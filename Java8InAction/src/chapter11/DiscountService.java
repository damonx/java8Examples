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
import java.util.stream.Collectors;

public class DiscountService {
	private List<Shop> shops;

	public DiscountService() {
	}

	public DiscountService with(final List<Shop> _shops) {
		this.shops = _shops;
		return this;
	}

	public List<String> findPrices(final String product){
		return this.shops.parallelStream()
				.map(shop -> shop.getPrice(product))
				.map(Quote::parse)
				.map(Discount::applyDiscount)
				.collect(Collectors.toList());
	}

}

