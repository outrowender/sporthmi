/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModelListener;
import de.audi.atip.hmi.model.ListRow;

public interface DynamicListModelListener
extends AbstractListModelListener {
    public static final int LIST_START = 0;
    public static final int LIST_END = 1;

    public void runningOutOfData(int var1, ListRow var2, int var3, int var4);

    public void itemReleased(int var1, ListRow var2, int var3);
}

