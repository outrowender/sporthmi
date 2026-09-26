/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IDecoratorProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public class MenuDecoratorProxyController
extends AbstractWidgetController
implements IMenuCallback {
    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.forwardProperty();
    }

    private void forwardProperty() {
        IMenuCallback iMenuCallback = this.getDecorator();
        MenuController menuController = this.getMenu();
        if (iMenuCallback != null && menuController != null && !menuController.isHideOverlayDecoratorDuringScrolling()) {
            iMenuCallback.setHideOverlayDecoratorDuringScrolling(menuController.isHideOverlayDecoratorDuringScrolling());
        }
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    private MenuController getMenu() {
        if (this.parent instanceof MenuController) {
            return (MenuController)this.parent;
        }
        menuLogCh.log(10000, "MenuDecoratorProxyController#getMenu: parent is not a Menu: %1", (Object)this.parent);
        return null;
    }

    private IMenuCallback getDecorator() {
        if (!this.isConnected()) {
            return null;
        }
        ScreenWidgetEVO screenWidgetEVO = (ScreenWidgetEVO)this.initContext.getScreen();
        if (screenWidgetEVO == null) {
            menuLogCh.log(10000, "MenuDecoratorProxyController#getDecorator: screen is null");
            return null;
        }
        ScreenMainArea screenMainArea = screenWidgetEVO.getSpecialArea();
        if (screenMainArea == null) {
            menuLogCh.log(-1601830656, "MenuDecoratorProxyController#getDecorator: special area is null. Screen: %1", (long)this.getScreenId());
            return null;
        }
        if (!(screenMainArea instanceof ContainerController)) {
            menuLogCh.log(10000, "MenuDecoratorProxyController#getDecorator: special area is not a container: %1. Screen: %2", (Object)screenMainArea, (long)this.getScreenId());
            return null;
        }
        ContainerController containerController = (ContainerController)screenMainArea;
        AbstractWidget abstractWidget = containerController.getMenuDecorator();
        if (abstractWidget == null) {
            menuLogCh.log(-1601830656, "MenuDecoratorProxyController#getDecorator: special area has no menu decorator. Screen: %1", (long)this.getScreenId());
            return null;
        }
        int n = 0;
        while (abstractWidget instanceof IDecoratorProvider) {
            abstractWidget = ((IDecoratorProvider)((Object)abstractWidget)).getMenuDecorator();
            if (++n <= 10) continue;
            menuLogCh.log(-1601830656, "MenuDecoratorProxyController#getDecorator: The extraction of embedded decorators encounterd the maximum hiearchy depth of 10. Please clean up your widget hierarchy.", (long)this.getScreenId());
            break;
        }
        if (!(abstractWidget instanceof IMenuCallback)) {
            menuLogCh.log(10000, "MenuDecoratorProxyController#getDecorator: special area's decorator is not a IMenuCallback: %1. Screen: %2", (Object)abstractWidget, (long)this.getScreenId());
            return null;
        }
        return (IMenuCallback)((Object)abstractWidget);
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
        IMenuCallback iMenuCallback = this.getDecorator();
        MenuController menuController = this.getMenu();
        if (menuController != null && iMenuCallback != null) {
            iMenuCallback.setActiveMenuController(menuController);
            iMenuCallback.menuFocusChanged(menuItemIndex);
        }
    }

    @Override
    public void menuFocusChangeFinished() {
        IMenuCallback iMenuCallback = this.getDecorator();
        MenuController menuController = this.getMenu();
        if (menuController != null && iMenuCallback != null) {
            iMenuCallback.setActiveMenuController(menuController);
            iMenuCallback.menuFocusChangeFinished();
        }
    }

    @Override
    public void menuLayouted() {
    }

    @Override
    public void viewportUpdated(boolean bl) {
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

