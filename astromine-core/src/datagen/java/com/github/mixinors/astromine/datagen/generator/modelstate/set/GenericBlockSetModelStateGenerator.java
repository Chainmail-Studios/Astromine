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

package com.github.mixinors.astromine.datagen.generator.modelstate.set;

import net.minecraft.block.Block;

import com.github.mixinors.astromine.datagen.material.MaterialItemType;
import com.github.mixinors.astromine.datagen.material.MaterialSet;
import me.shedaniel.cloth.api.datagen.v1.ModelStateData;

public class GenericBlockSetModelStateGenerator extends GenericItemSetModelGenerator {

	public GenericBlockSetModelStateGenerator(MaterialItemType type) {
		super(type);
		if (!type.isBlock()) throw new IllegalArgumentException("type " + type.getName() + " isn't a block");
	}

	@Override
	public void generate(ModelStateData data, MaterialSet set) {
		data.addSingletonCubeAll(getBlock(set));
		data.addSimpleBlockItemModel(getBlock(set));
	}

	public Block getBlock(MaterialSet set) {
		return set.getEntry(type).asBlock();
	}

	@Override
	public String getGeneratorName() {
		return type.getName() + "_block_set_modelstate";
	}
}
