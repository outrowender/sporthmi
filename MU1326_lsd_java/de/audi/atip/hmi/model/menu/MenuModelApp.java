/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface MenuModelApp
extends HMIModelApp {
    public void trigger(ModelTrigger var1);

    public WidgetFocusAdvice getAdvice();

    public void setFocusedItem(int var1, FocusAdvice var2, long var3);

    public void resetFocusedItem();

    public void setListener(MenuModelListener var1);
}

