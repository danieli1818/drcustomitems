package drcustomitems.items.actions;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class CustomItemsActionsManager {

	private Map<ItemStack, Map<NBTTagCompound, ActionsHolder>> actionsHoldersPerItem;
	private static CustomItemsActionsManager instance;
	
	private CustomItemsActionsManager() {
		this.actionsHoldersPerItem = new HashMap<>();
	}
	
	public static CustomItemsActionsManager getInstance() {
		if (instance == null) {
			instance = new CustomItemsActionsManager();
		}
		return instance;
	}
	
	public ActionsHolder addActionsHolderToItemStack(ItemStack itemStack, ActionsHolder actionsHolder) {
		Map<NBTTagCompound, ActionsHolder> actionsHolders = this.actionsHoldersPerItem.get(itemStack);
		if (actionsHolders == null) {
			actionsHolders = new HashMap<>();
			this.actionsHoldersPerItem.put(itemStack, actionsHolders);
		}
		net.minecraft.server.v1_12_R1.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
		NBTTagCompound tagCompound = nmsItemStack.getTag();
		ActionsHolder prevActionsHolder = actionsHolders.get(tagCompound);
		actionsHolders.put(tagCompound, actionsHolder);
		return prevActionsHolder;
	}
	
	public ActionsHolder removeActionsHolderOfItemStack(ItemStack itemStack) {
		Map<NBTTagCompound, ActionsHolder> actionsHolders = this.actionsHoldersPerItem.get(itemStack);
		if (actionsHolders == null) {
			return null;
		}
		net.minecraft.server.v1_12_R1.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
		NBTTagCompound tagCompound = nmsItemStack.getTag();
		return actionsHolders.remove(tagCompound);
	}
	
	public ActionsHolder getActionsHolderOfItemStack(ItemStack itemStack) {
		Map<NBTTagCompound, ActionsHolder> actionsHolders = this.actionsHoldersPerItem.get(itemStack);
		if (actionsHolders == null) {
			return null;
		}
		net.minecraft.server.v1_12_R1.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
		NBTTagCompound tagCompound = nmsItemStack.getTag();
		return actionsHolders.get(tagCompound);
	}
	
	public boolean doesItemStackHaveActionsHolder(ItemStack itemStack) {
		return getActionsHolderOfItemStack(itemStack) != null;
	}
	
}
