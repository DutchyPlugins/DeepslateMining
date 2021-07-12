package dev.array21.deepslatemining.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockDamageEventListener implements Listener {

	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {
		if(event.getBlock().getType().equals(Material.DEEPSLATE)) {
			ItemStack mainHand = event.getItemInHand();
			if(mainHand.getType().equals(Material.DIAMOND_PICKAXE) || mainHand.getType().equals(Material.NETHERITE_PICKAXE)) {
				ItemMeta mainMeta = mainHand.getItemMeta();
				int efficiencyLevel = mainMeta.getEnchantLevel(Enchantment.DIG_SPEED);
				if(efficiencyLevel == 5) {
					PotionEffect pot = event.getPlayer().getPotionEffect(PotionEffectType.FAST_DIGGING);
					if(pot != null && pot.getAmplifier() > 1) {
						event.setInstaBreak(true);
					}
				}
			}
		}
	}
}
