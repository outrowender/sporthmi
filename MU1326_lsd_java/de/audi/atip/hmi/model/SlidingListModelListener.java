/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModelListener;
import de.audi.atip.hmi.model.ListRow;

public interface SlidingListModelListener
extends AbstractListModelListener {
    public void requestRowsAfter(int var1, ListRow var2, int var3, int var4);

    public void requestRowsBefore(int var1, ListRow var2, int var3, int var4);
}

