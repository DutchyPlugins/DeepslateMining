package dev.array21.deepslatemining;

import dev.array21.deepslatemining.listeners.BlockDamageEventListener;
import dev.array21.dutchycore.DutchyCore;
import dev.array21.dutchycore.annotations.RegisterModule;
import dev.array21.dutchycore.module.PluginModule;

@RegisterModule(name = "DeepslateMining", version = "@VERSION@", author = "Dutchy76", infoUrl = "https://github.com/DutchyPlugins/DeepslateMining")
public class DeepslateMining extends PluginModule {

	@Override
	public void enable(DutchyCore plugin) {
		super.logInfo("Initializing...");
		super.registerEventListener(new BlockDamageEventListener());
		super.logInfo("Loaded.");
	}
}
