package rcp;

import javax.tools.Tool;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import actions.Action1;
import actions.HelloAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction action1;
	private HelloAction helloAction;
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	action1 = new Action1(window);
    	action1.setText("第一个菜单项");
    	action1.setId("com.lhl.actions.action1");
    	register(action1);
    	helloAction = new HelloAction(window);
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager helpMenu = new MenuManager("第一个菜单","com.lhl.firstmenu");
    	helpMenu.add(action1);
    	menuBar.add(helpMenu);
    	
    	MenuManager demoMenu = new MenuManager("&Demo","");
    	demoMenu.add(helloAction);
    	menuBar.add(demoMenu);
    }
    
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
    	super.fillCoolBar(coolBar);
    	IToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
    	coolBar.add(new ToolBarContributionItem(toolBarManager,"main"));
    	toolBarManager.add(helloAction);
    }
}
