/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMulti;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;

public interface IMenuItemMultiLine
extends IMenuItemSingle,
IMenuItemMulti {
    public int getPreferredLineHeight(int var1);

    public int getFilledInsets(boolean var1);

    public void setVisibleAreaBounds(int var1, int var2, int var3);

    public boolean isScrollLineByLine();

    public int getSdsItemSelectedAction(int var1);
}

