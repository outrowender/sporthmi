/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;

public interface IMenuItemMulti
extends IMenuItem {
    public static final int FIRST_INDEX = 0;

    public int getSubItemCount();

    public void setMenuSize(int var1, int var2, int var3);
}

