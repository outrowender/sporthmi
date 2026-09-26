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
    default public void trigger(ModelTrigger modelTrigger) {
    }

    default public WidgetFocusAdvice getAdvice() {
    }

    default public void setFocusedItem(int n, FocusAdvice focusAdvice, long l) {
    }

    default public void resetFocusedItem() {
    }

    default public void setListener(MenuModelListener menuModelListener) {
    }
}

