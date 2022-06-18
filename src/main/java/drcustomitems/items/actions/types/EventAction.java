package drcustomitems.items.actions.types;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import drcustomitems.items.actions.Action;

public class EventAction<T extends Event> implements Action {

	private T event;
	
	public EventAction(T event) {
		this.event = event;
	}
	
	@Override
	public void runAction(Player player, ItemStack itemStack) {
		Bukkit.getServer().getPluginManager().callEvent(this.event);
	}

}
