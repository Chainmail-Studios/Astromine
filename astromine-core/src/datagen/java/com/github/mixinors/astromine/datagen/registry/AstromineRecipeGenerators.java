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

package com.github.mixinors.astromine.datagen.registry;

import com.github.mixinors.astromine.AMCommon;
import com.github.mixinors.astromine.datagen.generator.recipe.onetime.base.OneTimeRecipeGenerator;
import com.github.mixinors.astromine.datagen.generator.recipe.set.base.SetRecipeGenerator;
import com.github.mixinors.astromine.datagen.material.MaterialSet;
import me.shedaniel.cloth.api.datagen.v1.RecipeData;

import java.util.ArrayList;
import java.util.List;

public abstract class AstromineRecipeGenerators {
	private final List<SetRecipeGenerator> SET_GENERATORS = new ArrayList<>();
	private final List<OneTimeRecipeGenerator> ONE_TIME_GENERATORS = new ArrayList<>();

	public SetRecipeGenerator register(SetRecipeGenerator generator) {
		SET_GENERATORS.add(generator);
		return generator;
	}

	public OneTimeRecipeGenerator register(OneTimeRecipeGenerator generator) {
		ONE_TIME_GENERATORS.add(generator);
		return generator;
	}

	public void generateRecipes(RecipeData recipes) {
		AstromineMaterialSets.getMaterialSets().forEach((set) -> generateSetRecipes(recipes, set));
		generateOneTimeRecipes(recipes);
	}

	private void generateSetRecipes(RecipeData recipes, MaterialSet set) {
		SET_GENERATORS.forEach((generator) -> {
			try {
				if (set.shouldGenerate(generator)) {
					generator.generate(recipes, set);
					AMCommon.LOGGER.info("Recipe generation of " + set.getName() + " succeeded, with generator " + generator.getGeneratorName() + ".");
				}
			} catch (Exception exception) {
				AMCommon.LOGGER.error("Recipe generation of " + set.getName() + " failed, with generator " + generator.getGeneratorName() + ".");
				AMCommon.LOGGER.error(exception.getMessage());
			}
		});
	}

	private void generateOneTimeRecipes(RecipeData recipes) {
		ONE_TIME_GENERATORS.forEach((generator) -> {
			try {
				generator.generate(recipes);
			} catch (Exception exception) {
				AMCommon.LOGGER.error("Recipe generation failed, with generator " + generator.getGeneratorName() + ".");
				AMCommon.LOGGER.error(exception.getMessage());
			}
		});
	}
}
