/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu;

import de.audi.atip.hmi.model.menu.MenuModel$1;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.esolutions.fw.util.commons.Buffer;

public class MenuModel$FocusedMenuItem {
    private final int menuItemID;
    private final FocusAdvice advice;
    private final long uniqueListRowID;

    private MenuModel$FocusedMenuItem(int n, FocusAdvice focusAdvice, long l) {
        this.menuItemID = n;
        this.advice = focusAdvice;
        this.uniqueListRowID = l;
    }

    public int getMenuItemID() {
        return this.menuItemID;
    }

    public FocusAdvice getAdvice() {
        return this.advice;
    }

    public long getUniqueListRowID() {
        return this.uniqueListRowID;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("menuItemID:").append(this.menuItemID);
        buffer.append(", uniqueListRowID:").append(this.uniqueListRowID);
        buffer.append(", ").append(this.advice);
        return buffer.toString();
    }

    /* synthetic */ MenuModel$FocusedMenuItem(int n, FocusAdvice focusAdvice, long l, MenuModel$1 menuModel$1) {
        this(n, focusAdvice, l);
    }
}

