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
package java8.thread;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Shop {
	private final String name;

	public Shop(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public double getPrice(final String product) {
		return calculatePrice(product);
	}

	public Future<Double> getPriceAsync(final String product) {
		final CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(()->{
			try {
				futurePrice.complete(calculatePrice(product));
			} catch (final Exception ex) {
				futurePrice.completeExceptionally(ex);
			}
		}).start();
		return futurePrice;
	}

	private double calculatePrice(final String product) {
		delay();
		if ("wrong".equals(product)) {
			throw new RuntimeException("Wrong product!");
		}
		return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void doSomethingElse() {
		System.out.println("I am doing something else.");
	}


	public static void main(final String[] args) {
		final Shop shop = new Shop("Mac");
		long start = System.nanoTime();
		final Future<Double> futurePrice = shop.getPriceAsync("iPhone7");
		final long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime + " msecs");
        doSomethingElse();
        try{
        	final double price = futurePrice.get();
        	System.out.printf("Price is %.2f%n", price);
		} catch (final Exception e) {
			throw new RuntimeException();
        }
		final long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after: " + retrievalTime + " msecs");

		final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
				new Shop("LetsSaveBig"),
				new Shop("MyFavoriteShop"), new Shop("BuyItAll"));
		System.out.println("-------------------------Blocking call -------------------");
		start = System.nanoTime();
		final List<String> prices = shops.parallelStream()
				.map(s -> String.format("%s price is %.2f",
						s.getName(), s.getPrice("iPhone8")))
				.collect(Collectors.toList());
		System.out.println(prices);
		final long duration = (System.nanoTime() - start) / 1_000_000;

		System.out.println("Done in " + duration + " msecs");

	}
}

