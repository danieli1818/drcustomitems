package drcustomitems.items;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import drcustomitems.items.actions.CustomItemsActionsManager;

public class CustomItemStacksManager {

	private Map<String, ItemStack> customItemStacks;
	private Map<String, Map<String, ItemStack>> customPluginItemStacks;
	private static CustomItemStacksManager instance;
	
	private CustomItemStacksManager() {
		this.customItemStacks = new HashMap<>();
		this.customPluginItemStacks = new HashMap<>();
	}
	
	public static CustomItemStacksManager getInstance() {
		if (instance == null) {
			instance = new CustomItemStacksManager();
		}
		return instance;
	}
	
	public boolean addCustomItemStack(String id, ItemStack itemStack) {
		if (this.customItemStacks.containsKey(id)) {
			return false;
		}
		this.customItemStacks.put(id, itemStack);
		return true;
	}
	
	public boolean addCustomItemStack(String plugin, String id, ItemStack itemStack) {
		if (!this.customPluginItemStacks.containsKey(plugin)) {
			this.customPluginItemStacks.put(plugin, new HashMap<>());
		}
		if (this.customPluginItemStacks.get(plugin).containsKey(id)) {
			return false;
		}
		this.customPluginItemStacks.get(plugin).put(id, itemStack);
		return true;
	}
	
	public boolean removeCustomItemStack(String id) {
		ItemStack itemStack = this.customItemStacks.remove(id);
		if (itemStack != null) {
			CustomItemsActionsManager.getInstance().removeActionsHolderOfItemStack(itemStack);
			return true;
		}
		return false;
	}
	
	public boolean giveCustomItemStack(String id, Player player) {
		ItemStack itemStack = this.customItemStacks.get(id);
		if (itemStack == null) {
			return false;
		}
		player.getInventory().addItem(itemStack);
		return true;
	}
	
	public boolean giveCustomItemStack(String plugin, String id, Player player) {
		ItemStack itemStack = this.customPluginItemStacks.get(plugin).get(id);
		if (itemStack == null) {
			return false;
		}
		player.getInventory().addItem(itemStack);
		return true;
	}
	
	public boolean giveCustomItemStack(String id, Player player, int slot) {
		ItemStack itemStack = this.customItemStacks.get(id);
		if (itemStack == null) {
			return false;
		}
		player.getInventory().setItem(slot, itemStack);
		return true;
	}
	
	public boolean giveCustomItemStack(String plugin, String id, Player player, int slot) {
		ItemStack itemStack = this.customPluginItemStacks.get(plugin).get(id);
		if (itemStack == null) {
			return false;
		}
		player.getInventory().setItem(slot, itemStack);
		return true;
	}
	
	public boolean isCustomItemStack(ItemStack itemStack) {
		if (this.customItemStacks.containsValue(itemStack)) {
			return true;
		}
		for (Map<String, ItemStack> customPluginItemStacks : this.customPluginItemStacks.values()) {
			if (customPluginItemStacks.containsValue(itemStack)) {
				return true;
			}
		}
		return false;
	}
	
}
