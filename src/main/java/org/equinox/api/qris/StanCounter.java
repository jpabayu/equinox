package org.equinox.api.qris;

import com.hazelcast.core.IFunction;

public class StanCounter implements IFunction<Integer, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Integer input) {
		if (input == null)
			return new Integer(1);

		if (input < 999999) {
			return ++input;
		} else {
			return new Integer(1);
		}
	}

}
