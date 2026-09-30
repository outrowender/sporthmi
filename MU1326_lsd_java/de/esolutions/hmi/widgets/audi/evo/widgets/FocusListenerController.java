/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class FocusListenerController
extends AbstractWidgetController {
    private boolean notifyOnFocusLost = true;
    private boolean notifyOnFocusGained = true;
    int notificationState = 508;
    private boolean focused;

    public IRenderer getRenderer() {
        return null;
    }

    public void setNotificationOnFocusGained(boolean bl) {
        this.notifyOnFocusGained = bl;
    }

    public void setNotificationOnFocusLost(boolean bl) {
        this.notifyOnFocusLost = bl;
    }

    private void setState(boolean bl, int n) {
        this.notificationState = bl ? (this.notificationState |= n) : (this.notificationState &= ~n);
    }

    public void setNotificationOnStateSelectionMenu(boolean bl) {
        this.setState(bl, 4);
    }

    public void setNotificationOnStateOptionMenu(boolean bl) {
        this.setState(bl, 8);
    }

    public void setNotificationOnStateMainArea(boolean bl) {
        this.setState(bl, 16);
    }

    public void setNotificationOnStateEntertainmentMenu(boolean bl) {
        this.setState(bl, 32);
    }

    public void setNotificationOnStatePartialPopup(boolean bl) {
        this.setState(bl, 64);
        this.setState(bl, 128);
    }

    public void setNotificationOnStateConnect(boolean bl) {
        this.setState(bl, 256);
    }

    public void setNotificationOnEveryState(boolean bl) {
        this.setState(bl, 508);
    }

    public void handleFocusChanged(int n, int n2, int n3) {
        logDrawerFocusMain.log(10000000, "FocusListenerController#handleFocusChanged focusEvent=%1, drawerState=%2", (long)n, (long)n2);
        this.focused = n == 2;
        int n4 = DrawerFocusUtil.calculateChoiceValue(n, n2, n3);
        if (this.isFireConditionMet(n4)) {
            this.fireUpdateChoiceModel(n4);
        }
    }

    private void fireUpdateChoiceModel(int n) {
        if (logDrawerFocusMain.isDebug()) {
            logDrawerFocusMain.log(10000000, "FocusListenerController#fireUpdateChoiceModel choiceValue: %2 - Bin: %1", (Object)Integer.toBinaryString(n), (long)n);
        }
        if (this.model == null || !(this.model instanceof ChoiceModelGUI)) {
            logDrawerFocusMain.log(100000, "FocusListenerController#fireUpdateChoiceModel not a ChoiceModelGUI at %1: %2", this.model, (Object)this);
            return;
        }
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
        choiceModelGUI.itemSelected(n, this.terminal.getTerminalID());
    }

    private boolean isFireConditionMet(int n) {
        boolean bl = false;
        boolean bl2 = false;
        if (this.notifyOnFocusGained == DrawerFocusUtil.isFocusGained(n)) {
            bl = true;
        } else if (this.notifyOnFocusLost == DrawerFocusUtil.isFocusLost(n)) {
            bl = true;
        }
        if ((this.notificationState & DrawerFocusUtil.getRawState(n)) > 0) {
            bl2 = true;
        }
        return bl & bl2;
    }

    public void predisconnecting() {
        super.predisconnecting();
        if (this.focused) {
            int n = DrawerFocusUtil.calculateChoiceValue(1, 256, 8192);
            if (this.isFireConditionMet(n)) {
                this.fireUpdateChoiceModel(n);
            }
            this.focused = false;
        }
    }

    public void initializeWidget() {
        this.focused = false;
    }
}

