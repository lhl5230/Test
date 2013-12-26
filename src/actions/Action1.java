package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import widgets.FirstDialog;

public class Action1 extends Action implements IWorkbenchAction{
	private IWorkbenchWindow workbenchWindow;
	
	public Action1(IWorkbenchWindow window){
		if(window == null){
			throw new IllegalArgumentException();
		}
		this.workbenchWindow = window;
	}
	
	public void run(){
		if(workbenchWindow != null){
			// 在这里添加功能 
			FirstDialog dg  =   new  FirstDialog(workbenchWindow.getShell());
			dg.open();
		}
	}
	@Override
	public void dispose() {
		workbenchWindow = null;
	}
	
}
