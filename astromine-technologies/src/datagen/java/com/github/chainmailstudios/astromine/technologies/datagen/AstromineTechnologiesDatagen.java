package com.github.chainmailstudios.astromine.technologies.datagen;

import com.github.chainmailstudios.astromine.datagen.entrypoint.DatagenInitializer;
import com.github.chainmailstudios.astromine.datagen.generator.Generator;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineLootTableGenerators;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineMaterialSets;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineModelStateGenerators;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineRecipeGenerators;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineTagGenerators;
import me.shedaniel.cloth.api.datagen.v1.ModelStateData;

public class AstromineTechnologiesDatagen implements DatagenInitializer {
	@Override
	public String getModuleId() {
		return "astromine-technologies";
	}

	@Override
	public AstromineMaterialSets getMaterialSets() {
		return null;
	}

	@Override
	public AstromineLootTableGenerators getLootTableGenerators() {
		return null;
	}

	@Override
	public AstromineRecipeGenerators getRecipeGenerators() {
		return new AstromineTechnologiesRecipeGenerators();
	}

	@Override
	public AstromineTagGenerators getTagGenerators() {
		return null;
	}

	@Override
	public AstromineModelStateGenerators getModelStateGenerators() {
		return null;
	}
}
