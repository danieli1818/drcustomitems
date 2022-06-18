package drcustomitems.items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class CustomItemsBuilder {

	private ItemStack itemStack;
	private boolean shouldDisableDefaultUsage;
	
	public CustomItemsBuilder(Material material) {
		this.itemStack = new ItemStack(material);
		this.shouldDisableDefaultUsage = true;
	}
	
	public CustomItemsBuilder(ItemStack itemStack) {
		this.itemStack = new ItemStack(itemStack);
		this.shouldDisableDefaultUsage = true;
	}
	
	public CustomItemsBuilder setDisplayName(String name) {
		this.itemStack.getItemMeta().setDisplayName(name);
		return this;
	}
	
	public CustomItemsBuilder setLore(String[] lore) {
		this.itemStack.getItemMeta().setLore(Arrays.asList(lore));
		return this;
	}
	
	public CustomItemsBuilder disableDefaultUsage(boolean disableDefaultUsage) {
		this.shouldDisableDefaultUsage = disableDefaultUsage;
		return this;
	}
	
	public ItemStack create(String id) {
		net.minecraft.server.v1_12_R1.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(this.itemStack);
		NBTTagCompound tag = getCommonNBTTagCompound(nmsItemStack);
		nmsItemStack.setTag(tag);
		ItemStack bukkitItemStack = CraftItemStack.asBukkitCopy(nmsItemStack);
		CustomItemStacksManager.getInstance().addCustomItemStack(id, bukkitItemStack);
		return bukkitItemStack;
	}
	
	public ItemStack create(String id, String pluginID) {
		net.minecraft.server.v1_12_R1.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(this.itemStack);
		NBTTagCompound tag = getCommonNBTTagCompound(nmsItemStack);
		tag.setString("DRCustomItemPlugin", pluginID);
		nmsItemStack.setTag(tag);
		ItemStack bukkitItemStack = CraftItemStack.asBukkitCopy(nmsItemStack);
		CustomItemStacksManager.getInstance().addCustomItemStack(pluginID, id, bukkitItemStack);
		return bukkitItemStack;
	}
	
	private NBTTagCompound getCommonNBTTagCompound(net.minecraft.server.v1_12_R1.ItemStack nmsItemStack) {
		NBTTagCompound tag = nmsItemStack.getTag();
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		tag.setBoolean("DRCustomItem", true);
		tag.setBoolean("ShouldDisableDefaultUsage", shouldDisableDefaultUsage);
		return tag;
	}
	
}
