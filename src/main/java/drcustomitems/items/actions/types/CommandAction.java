package drcustomitems.items.actions.types;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import drcustomitems.items.actions.Action;

public class CommandAction implements Action {

	private List<String> commands;
	
	public CommandAction() {
		this.commands = new ArrayList<>();
	}
	
	public CommandAction(List<String> commands) {
		this();
		this.commands.addAll(commands);
	}
	
	public void addCommand(String command) {
		this.commands.add(command);
	}
	
	public void addCommands(List<String> commands) {
		this.commands.addAll(commands);
	}
	
	public boolean removeCommand(String command) {
		return this.commands.remove(command);
	}
	
	public boolean removeCommands(List<String> commands) {
		return this.commands.removeAll(commands);
	}
	
	public List<String> getCommands() {
		return this.commands;
	}
	
	@Override
	public void runAction(Player player) {
		for (String command : this.commands) {
			String finishedCommand = command.replace("<player>", player.getName());
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), finishedCommand);
		}
	}

}
