/*
 * Copyright (c) Fisher and Paykel Appliances
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package chapter5;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTrasactionTest {

	public static void main(final String[] args) {
		final Trader raoul = new Trader("Raoul", "Cambridge");
		final Trader mario = new Trader("Mario", "Milan");
		final Trader alan = new Trader("Alan", "Cambridge");
		final Trader brian = new Trader("Brian", "Cambridge");
		final List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Find all transactions in 2011 and sort by value (small to high)
		final List<Transaction> tr2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(comparing(Transaction::getValue)).collect(toList());
		tr2011.stream().forEach(System.out::println);

		// What are all the unique cities where the traders work?
		transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
		transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(toSet()).stream().forEach(System.out::println);

		// Find all traders from Cambridge and sort them by name
		System.out.println("Find all traders from Cambridge and sort them by name");
		transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct()
				.sorted(comparing(Trader::getName)).forEach(System.out::println);

		// Return a string of all traders’ names sorted alphabetically
		System.out.println("Return a string of all traders’ names sorted alphabetically");
		final String traderStr = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",
				(n1, n2) -> String.join("-", n1, n2)).replaceFirst("-", "");
		System.out.println(traderStr);
		final String traderStr2 = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted()
				.collect(Collectors.joining("-"));
		System.out.println(traderStr2);

        System.out.println("Are any traders based in Milan?");
		final boolean milanBased = transactions.stream().anyMatch(t -> t.getTrader().from("Milan"));
		System.out.println(milanBased);

		// Print all transactions’ values from the traders living in Cambridge
		System.out.println("---->Print all transactions’ values from the traders living in Cambridge");
		transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
				.forEach(System.out::println);

		System.out.println("What’s the highest value of all the transactions?");
		transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
		transactions.stream().max(comparing(Transaction::getValue)).ifPresent(max -> System.out.println(max.getValue()));
		System.out.println("What’s the smallest value of all the transactions?");
		transactions.stream().min(comparing(Transaction::getValue)).ifPresent(min -> System.out.println(min.getValue()));

	}

}

