/*
 * MIT License
 *
 * Copyright (c) 2020, 2021 Mixinors
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

package com.github.mixinors.astromine.datagen.generator.recipe.set.base;

import com.github.mixinors.astromine.datagen.material.MaterialItemType;
import com.github.mixinors.astromine.datagen.material.MaterialSet;

public abstract class SimpleProcessingSetRecipeGenerator implements SetRecipeGenerator {
	public final MaterialItemType input;
	public final int inputCount;
	public final MaterialItemType output;
	public final int outputCount;
	public final int time;

	public SimpleProcessingSetRecipeGenerator(MaterialItemType input, int inputCount, MaterialItemType output, int outputCount, int time) {
		this.input = input;
		this.inputCount = inputCount;
		this.output = output;
		this.outputCount = outputCount;
		this.time = time;
	}

	@Override
	public boolean shouldGenerate(MaterialSet set) {
		return set.hasType(input) && set.hasType(output);
	}

	@Override
	public MaterialItemType getOutput() {
		return output;
	}
}
