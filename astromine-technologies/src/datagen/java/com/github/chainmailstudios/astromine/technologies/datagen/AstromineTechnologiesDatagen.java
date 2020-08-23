package com.github.chainmailstudios.astromine.technologies.datagen;

import com.github.chainmailstudios.astromine.datagen.entrypoint.DatagenInitializer;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineLootTableGenerators;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineRecipeGenerators;
import com.github.chainmailstudios.astromine.datagen.registry.AstromineTagGenerators;

public class AstromineTechnologiesDatagen implements DatagenInitializer {
	@Override
	public String getModuleId() {
		return "astromine-technologies";
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
}