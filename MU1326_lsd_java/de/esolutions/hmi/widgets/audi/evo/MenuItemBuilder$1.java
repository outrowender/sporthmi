/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.CloseDrawerKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.MenuItemBuilder;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

final class MenuItemBuilder$1
implements IWidgetKeyHandler {
    private final /* synthetic */ MenuItemController val$menuItem;
    private final /* synthetic */ CloseDrawerKeyHandler val$drawerClosingKeyHandler;

    MenuItemBuilder$1(MenuItemController menuItemController, CloseDrawerKeyHandler closeDrawerKeyHandler) {
        this.val$menuItem = menuItemController;
        this.val$drawerClosingKeyHandler = closeDrawerKeyHandler;
    }

    @Override
    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
        this.replaceKeyHandler().keyTurned(abstractWidgetController, wheelButtonEvent);
    }

    @Override
    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        this.replaceKeyHandler().keyReleased(abstractWidgetController, keyEvent);
    }

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        this.replaceKeyHandler().keyPressed(abstractWidgetController, keyEvent);
    }

    @Override
    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
        this.replaceKeyHandler().keyMoved(abstractWidgetController, joystickEvent);
    }

    private IWidgetKeyHandler replaceKeyHandler() {
        IWidgetKeyHandler iWidgetKeyHandler = this.val$menuItem.getKeyHandler();
        this.val$menuItem.setKeyHandler(null);
        MenuItemBuilder.configureKeyHandler(this.val$menuItem);
        IWidgetKeyHandler iWidgetKeyHandler2 = this.val$menuItem.getKeyHandler();
        if (iWidgetKeyHandler2 == null) {
            this.val$menuItem.setKeyHandler(iWidgetKeyHandler);
            return this.val$drawerClosingKeyHandler;
        }
        IWidgetLogChannel.logDrawerFocus.log(1078071040, "MenuItemBuilder#createAutomaticallyReplacingKeyHandlerWhenModelIsAvailable#replaceKeyHandler replacing keyhandler in %1", (Object)this.val$menuItem);
        CloseDrawerKeyHandler closeDrawerKeyHandler = MenuItemBuilder.access$000(iWidgetKeyHandler2, false);
        this.val$menuItem.setKeyHandler(closeDrawerKeyHandler);
        closeDrawerKeyHandler.setCloseOptionDrawerAfterScreenConnected(this.val$menuItem.getCloseOptionDrawerAfterScreenConnected());
        return closeDrawerKeyHandler;
    }
}

