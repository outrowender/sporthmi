/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface BaseListModelListener {
    public void itemReleased(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void itemSelected(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void itemLongSelected(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void itemFocused(EvoListRow var1, int var2, int var3, int var4, int var5);
}

