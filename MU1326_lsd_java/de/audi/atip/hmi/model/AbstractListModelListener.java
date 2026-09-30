/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListRow;

public interface AbstractListModelListener {
    public void itemFocused(int var1, ListRow var2, int var3, int var4);

    public void itemSelected(int var1, ListRow var2, int var3);

    public void rebuildListFromStart(int var1, int var2);

    public void rebuildListFromEnd(int var1, int var2);

    public void scrollingActive(int var1, boolean var2, int var3);
}

