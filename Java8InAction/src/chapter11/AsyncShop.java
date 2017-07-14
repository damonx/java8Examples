package chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop {
	private final String name;
	private final Random random;

	public AsyncShop(final String name) {
		this.name = name;
		this.random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
	}

	public String getName() {
		return this.name;
	}

	public Future<Double> getPrice(final String product) {
		/*
		 * CompletableFuture<Double> futurePrice = new CompletableFuture<>(); new Thread( () -> { try { double price =
		 * calculatePrice(product); futurePrice.complete(price); } catch (Exception ex) { futurePrice.completeExceptionally(ex); }
		 * }).start(); return futurePrice;
		 */
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}

	private double calculatePrice(final String product) {
		Util.delay();
		// if (true) {
		// throw new RuntimeException("product not available");
		// }
		return Util.format(this.random.nextDouble() * product.charAt(0) + product.charAt(1));
	}
}

