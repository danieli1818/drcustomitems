package drcustomitems.items.listeners;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import drcustomitems.items.CustomItemStacksManager;
import drcustomitems.items.actions.Action;
import drcustomitems.items.actions.ActionsHolder;
import drcustomitems.items.actions.CustomItemsActionsManager;

public class CustomItemsActionsListener implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		if (event.hasItem() && CustomItemsActionsManager.getInstance().doesItemStackHaveActionsHolder(event.getItem())) {
			if (CustomItemStacksManager.getInstance().shouldDisableDefaultUsage(event.getItem())) {
				event.setCancelled(true);
			}
			ActionsHolder actionsHolder = CustomItemsActionsManager.getInstance().getActionsHolderOfItemStack(event.getItem());
			if (actionsHolder == null) {
				return;
			}
			if (event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR || event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
				onRightClickItem(event, actionsHolder);
			} else {
				onLeftClickItem(event, actionsHolder);
			}
			onClickItem(event, actionsHolder);
		}
	}
	
	private void onRightClickItem(PlayerInteractEvent event, ActionsHolder actionsHolder) {
		Player player = event.getPlayer();
		ItemStack itemStack = event.getItem();
		List<Action> actions = actionsHolder.getRightClickActions();
		if (actions == null) {
			return;
		}
		for (Action action : actions) {
			action.runAction(player, itemStack);
		}
		if (actionsHolder.getShouldCancelRightClick()) {
			event.setCancelled(true);
		}
	}
	
	private void onLeftClickItem(PlayerInteractEvent event, ActionsHolder actionsHolder) {
		Player player = event.getPlayer();
		ItemStack itemStack = event.getItem();
		List<Action> actions = actionsHolder.getLeftClickActions();
		if (actions == null) {
			return;
		}
		for (Action action : actions) {
			action.runAction(player, itemStack);
		}
		if (actionsHolder.getShouldCancelLeftClick()) {
			event.setCancelled(true);
		}
	}
	
	private void onClickItem(PlayerInteractEvent event, ActionsHolder actionsHolder) {
		Player player = event.getPlayer();
		ItemStack itemStack = event.getItem();
		List<Action> actions = actionsHolder.getClickActions();
		if (actions == null) {
			return;
		}
		for (Action action : actions) {
			action.runAction(player, itemStack);
		}
		if (actionsHolder.getShouldCancelClick()) {
			event.setCancelled(true);
		}
	}
	
}
