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
package factoryMethod.creator;

import factoryMethod.product.Human;

public class HumanFactory extends AbstractHumanFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Human> T createHuman(final Class<T> c) {
	    Human human = null;
        try{
             human = (T)Class.forName(c.getName()).newInstance();
		} catch (final Exception e) {
			System.out.println("Creation Error");
        }
		return (T) human;
	}

}

