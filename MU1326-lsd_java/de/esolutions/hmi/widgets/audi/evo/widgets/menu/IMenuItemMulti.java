/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;

public interface IMenuItemMulti
extends IMenuItem {
    public static final int FIRST_INDEX;

    default public int getSubItemCount() {
    }

    default public void setMenuSize(int n, int n2, int n3) {
    }
}

