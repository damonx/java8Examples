/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {

	private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
			new Shop("LetsSaveBig"),
			new Shop("MyFavoriteShop"),
			new Shop("BuyItAll"),
			new Shop("ShopEasy"));

	private final Executor executor = Executors.newFixedThreadPool(this.shops.size(), new ThreadFactory() {
		@Override
		public Thread newThread(final Runnable r) {
			final Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});

	public List<String> findPricesSequential(final String product) {
		return this.shops.stream()
				.map(shop -> shop.getPrice(product))
				.map(Quote::parse)
				.map(Discount::applyDiscount)
				.collect(Collectors.toList());
	}



	public List<String> findPricesParallel(final String product) {
		return this.shops.parallelStream()
				.map(shop -> shop.getPrice(product))
				.map(Quote::parse)
				.map(Discount::applyDiscount)
				.collect(Collectors.toList());
	}

	public List<String> findPricesFuture(final String product) {
		final List<CompletableFuture<String>> priceFutures = findPricesStream(product)
				.collect(Collectors.<CompletableFuture<String>>toList());

		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}

	public Stream<CompletableFuture<String>> findPricesStream(final String product) {
		return this.shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), this.executor))
				.map(future -> future.thenApply(Quote::parse))
				.map(future -> future
						.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), this.executor)));
	}

	public void printPricesStream(final String product) {
		final long start = System.nanoTime();
		final CompletableFuture[] futures = findPricesStream(product)
				.map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
				.toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futures).join();
		System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
	}

}

