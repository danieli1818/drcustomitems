package drcustomitems.items.actions.types;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import drcustomitems.items.actions.Action;

public class ConsumeAction implements Action {
	
	private boolean shouldRunIfNonCreativeOnly;
	
	public ConsumeAction() {
		this.shouldRunIfNonCreativeOnly = true;
	}
	
	public ConsumeAction(boolean shouldRunIfNonCreativeOnly) {
		this.shouldRunIfNonCreativeOnly = shouldRunIfNonCreativeOnly;
	}

	@Override
	public void runAction(Player player, ItemStack itemStack) {
		if (shouldRunIfNonCreativeOnly && player.getGameMode() == GameMode.CREATIVE) {
			return;
		}
		int amount = itemStack.getAmount();
		itemStack.setAmount(amount - 1);
	}

	
	
}
