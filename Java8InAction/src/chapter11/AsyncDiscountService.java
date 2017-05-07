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

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class AsyncDiscountService {
	private List<Shop> shops;
	private Executor executor;

	public AsyncDiscountService() {
	}

	public AsyncDiscountService with(final List<Shop> _shops) {
		this.shops = _shops;
		this.executor = Executors.newFixedThreadPool(Math.min(this.shops.size(), 100), new ThreadFactory() {

			@Override
			public Thread newThread(final Runnable r) {
				final Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		return this;
	}

	public List<String> findPrices(final String product) {
		final List<CompletableFuture<String>> priceFutures = this.shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), this.executor))
				.map(future -> future.thenApply(Quote::parse))
				.map(future -> future
						.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), this.executor)))
				.collect(Collectors.toList());

		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

	}

}

