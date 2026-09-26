/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MainWizardController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

class AbstractPlaceholderMenuController$1
implements PlaceholderMenuItem {
    private final /* synthetic */ MenuItemController val$menuItem;
    private final /* synthetic */ AbstractWidget val$widget;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    AbstractPlaceholderMenuController$1(AbstractPlaceholderMenuController abstractPlaceholderMenuController, MenuItemController menuItemController, AbstractWidget abstractWidget) {
        this.this$0 = abstractPlaceholderMenuController;
        this.val$menuItem = menuItemController;
        this.val$widget = abstractWidget;
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        this.val$menuItem.keyTurned(wheelButtonEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.val$menuItem.keyReleased(keyEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.val$menuItem.keyPressed(keyEvent);
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        this.val$menuItem.keyMoved(joystickEvent);
    }

    @Override
    public void itemFocused() {
    }

    @Override
    public boolean isVisible() {
        return this.val$menuItem.isVisible();
    }

    @Override
    public boolean isSubSelection() {
        return false;
    }

    @Override
    public boolean isSubItem() {
        return false;
    }

    @Override
    public boolean isSelected() {
        return this.val$menuItem.isSelected();
    }

    @Override
    public boolean isMultiItem() {
        return false;
    }

    @Override
    public int getSubItemCount() {
        return 0;
    }

    @Override
    public String getLabelText() {
        InitializationContext initializationContext = this.this$0.getInitContext();
        if (initializationContext == null) {
            return null;
        }
        AbstractScreenFactory abstractScreenFactory = initializationContext.getScreenFactory();
        if (abstractScreenFactory == null) {
            return null;
        }
        return abstractScreenFactory.getText(this.val$menuItem.getLabelId(), AbstractPlaceholderMenuController.access$100(this.this$0).getViewSizeManager().getCurrentViewSize());
    }

    @Override
    public Object getIconData(int n) {
        int n2;
        if (this.this$0 instanceof MainWizardController && (n2 = this.val$menuItem.getWidgetID()) != -1) {
            return Util.createInteger(n2);
        }
        int[] nArray = this.val$menuItem.getBitmapIndices();
        if (nArray == null || nArray.length <= n) {
            return null;
        }
        return Util.createInteger(nArray[n]);
    }

    @Override
    public int[] getColorIndices() {
        return this.val$widget.getColorIndices();
    }

    @Override
    public boolean isEnabled() {
        return this.val$widget.isEnabled();
    }

    @Override
    public AbstractWidgetController getWidget() {
        return this.val$menuItem;
    }

    @Override
    public int getSdsItemSelectedAction() {
        return this.val$menuItem.getSdsItemSelectedAction();
    }

    @Override
    public int getSdsCommand() {
        return this.val$menuItem.getSdsCommand();
    }

    @Override
    public int getInternalID() {
        return this.val$menuItem.getInternalID();
    }

    @Override
    public int getWidgetID() {
        return this.val$menuItem.getWidgetID();
    }

    @Override
    public boolean isLockable() {
        return this.val$menuItem.isLockable();
    }
}

