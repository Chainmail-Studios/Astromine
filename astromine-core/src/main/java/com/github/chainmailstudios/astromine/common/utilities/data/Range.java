/*
 * MIT License
 *
 * Copyright (c) 2020 Chainmail Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.chainmailstudios.astromine.common.utilities.data;

/**
 * A range between
 * {@link #minimum} and {@link #maximum}.
 */
public final class Range<T extends Number> {
	private final T minimum;
	private final T maximum;

	/** Instantiates a {@link Range}. */
	private Range(T minimum, T maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/** Instantiates a {@link Range}. */
	public static <T extends Number> Range<T> of(T minimum, T maximum) {
		return new Range<>(minimum, maximum);
	}

	/** Returns this range's {@link #minimum}. */
	public T getMinimum() {
		return this.minimum;
	}

	/** Returns this range's {@link #maximum}. */
	public T getMaximum() {
		return this.maximum;
	}
}
