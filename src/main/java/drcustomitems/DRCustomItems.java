package drcustomitems;

import org.bukkit.plugin.java.JavaPlugin;

import drcustomitems.items.listeners.CustomItemsActionsListener;

public class DRCustomItems extends JavaPlugin {

	@Override
	public void onEnable() {
		super.onEnable();
		getServer().getPluginManager().registerEvents(new CustomItemsActionsListener(), this);
		System.out.println("DRCustomItems has successfully loaded!");
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		System.out.println("DRCustomItems has successfully disabled!");
	}
	
}
