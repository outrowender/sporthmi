/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidgetStorageObject;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;

public class WidgetStorageObjectMenu
extends AbstractWidgetStorageObject
implements WidgetConstants {
    private MenuItemIndex focusedIndex;
    private Long focusedUniqueID = null;
    private WidgetFocusAdvice focusAdvice;

    public MenuItemIndex getFocusedIndex() {
        return this.focusedIndex;
    }

    public void setFocusedIndex(MenuItemIndex menuItemIndex) {
        this.focusedIndex = menuItemIndex;
    }

    public Long getFocusedUniqueID() {
        return this.focusedUniqueID;
    }

    public void setFocusedUniqueID(Long l) {
        this.focusedUniqueID = l;
    }

    public WidgetFocusAdvice getFocusAdvice() {
        return this.focusAdvice;
    }

    public void setFocusAdvice(WidgetFocusAdvice widgetFocusAdvice) {
        this.focusAdvice = widgetFocusAdvice;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("WidgetStorageObjectMenu[");
        buffer.append("focusedID=").append(this.focusedUniqueID).append(", index=").append(this.focusedIndex).append(", advice=").append(this.focusAdvice);
        buffer.append("]");
        return buffer.toString();
    }
}

