package drcustomitems.items.actions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Action {

	public void runAction(Player player, ItemStack itemStack);
	
}
