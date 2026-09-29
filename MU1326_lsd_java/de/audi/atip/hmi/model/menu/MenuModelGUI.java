/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.menu.MenuModel$FocusedMenuItem;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface MenuModelGUI
extends HMIModelGUI {
    default public void updateAdvice(WidgetFocusAdvice widgetFocusAdvice) {
    }

    default public void itemFocused(int n, WidgetFocusAdvice widgetFocusAdvice, long l, int n2) {
    }

    default public MenuModel$FocusedMenuItem getLastFocusedMenuItem() {
    }
}

