package drcustomitems.items.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import drcustomitems.items.actions.Action;
import drcustomitems.items.actions.ActionsHolder;
import drcustomitems.items.actions.CustomItemsActionsManager;

public class CustomItemsActionsListener implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		System.out.println("Yay player interacted!");
		if (event.hasItem() && CustomItemsActionsManager.getInstance().doesItemStackHaveActionsHolder(event.getItem())) {
			System.out.println("Yay player interacted with a custom item!");
			if (event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR || event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
				onRightClickItem(event, CustomItemsActionsManager.getInstance().getActionsHolderOfItemStack(event.getItem()));
			} else {
				onLeftClickItem(event, CustomItemsActionsManager.getInstance().getActionsHolderOfItemStack(event.getItem()));
			}
			onClickItem(event, CustomItemsActionsManager.getInstance().getActionsHolderOfItemStack(event.getItem()));
		}
	}
	
	private void onRightClickItem(PlayerInteractEvent event, ActionsHolder actionsHolder) {
		Player player = event.getPlayer();
		for (Action action : actionsHolder.getRightClickActions()) {
			action.runAction(player);
		}
		if (actionsHolder.getShouldCancelRightClick()) {
			event.setCancelled(true);
		}
	}
	
	private void onLeftClickItem(PlayerInteractEvent event, ActionsHolder actionsHolder) {
		Player player = event.getPlayer();
		for (Action action : actionsHolder.getLeftClickActions()) {
			action.runAction(player);
		}
		if (actionsHolder.getShouldCancelLeftClick()) {
			event.setCancelled(true);
		}
	}
	
	private void onClickItem(PlayerInteractEvent event, ActionsHolder actionsHolder) {
		Player player = event.getPlayer();
		for (Action action : actionsHolder.getClickActions()) {
			action.runAction(player);
		}
		if (actionsHolder.getShouldCancelClick()) {
			event.setCancelled(true);
		}
	}
	
}
