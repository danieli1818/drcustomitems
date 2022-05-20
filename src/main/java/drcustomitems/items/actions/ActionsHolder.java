package drcustomitems.items.actions;

import java.util.List;

public interface ActionsHolder {

	List<Action> getRightClickActions();
	
	List<Action> getLeftClickActions();
	
	// Any click right or left.
	List<Action> getClickActions();
	
	public boolean getShouldCancelRightClick();
	
	public boolean getShouldCancelLeftClick();
	
	public boolean getShouldCancelClick();
	
}
