package drcustomitems.items.actions;

import java.util.ArrayList;
import java.util.List;

public class BaseActionsHolder implements ActionsHolder {
	
	private List<Action> rightClickActions;
	private List<Action> leftClickActions;
	private List<Action> clickActions;
	
	private boolean shouldRightClickCancel;
	private boolean shouldLeftClickCancel;
	private boolean shouldClickCancel;

	public BaseActionsHolder() {
		this.rightClickActions = new ArrayList<>();
		this.leftClickActions = new ArrayList<>();
		this.clickActions = new ArrayList<>();
	}
	
	@Override
	public List<Action> getRightClickActions() {
		return this.rightClickActions;
	}

	@Override
	public List<Action> getLeftClickActions() {
		return this.leftClickActions;
	}

	@Override
	public List<Action> getClickActions() {
		return this.clickActions;
	}
	
	public BaseActionsHolder addRightClickAction(Action action) {
		if (action != null) {
			this.rightClickActions.add(action);
		}
		return this;
	}
	
	public BaseActionsHolder addLeftClickAction(Action action) {
		if (action != null) {
			this.leftClickActions.add(action);
		}
		return this;
	}
	
	public BaseActionsHolder addClickAction(Action action) {
		if (action != null) {
			this.clickActions.add(action);
		}
		return this;
	}
	
	public boolean removeRightClickAction(Action action) {
		if (action != null) {
			return this.rightClickActions.remove(action);
		}
		return false;
	}
	
	public boolean removeLeftClickAction(Action action) {
		if (action != null) {
			return this.leftClickActions.remove(action);
		}
		return false;
	}
	
	public boolean removeClickAction(Action action) {
		if (action != null) {
			return this.clickActions.remove(action);
		}
		return false;
	}
	
	public BaseActionsHolder setShouldCancelRightClick(boolean shouldCancel) {
		this.shouldRightClickCancel = shouldCancel;
		return this;
	}
	
	public BaseActionsHolder setShouldCancelLeftClick(boolean shouldCancel) {
		this.shouldLeftClickCancel = shouldCancel;
		return this;
	}
	
	public BaseActionsHolder setShouldCancelClick(boolean shouldCancel) {
		this.shouldClickCancel = shouldCancel;
		return this;
	}
	
	public boolean getShouldCancelRightClick() {
		return this.shouldRightClickCancel;
	}
	
	public boolean getShouldCancelLeftClick() {
		return this.shouldLeftClickCancel;
	}
	
	public boolean getShouldCancelClick() {
		return this.shouldClickCancel;
	}

}
