/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface MenuModelGUI
extends HMIModelGUI {
    public void updateAdvice(WidgetFocusAdvice var1);

    public void itemFocused(int var1, WidgetFocusAdvice var2, long var3, int var5);

    public MenuModel.FocusedMenuItem getLastFocusedMenuItem();
}

