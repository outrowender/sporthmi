/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.SlidingListModelListener;
import de.audi.atip.hmi.modelaccess.AbstractListModelApp;

public interface SlidingListModelApp
extends AbstractListModelApp {
    public static final byte VISIBLE_CONTEXT_START_OF_BUFFER = 0;
    public static final byte VISIBLE_CONTEXT_END_OF_BUFFER = 1;

    public void setListListener(SlidingListModelListener var1);

    public void setBufferSize(int var1);

    public void appendAtEnd(ListRow[] var1, boolean var2);

    public void appendAtStart(ListRow[] var1, boolean var2);

    public void set(ListRow[] var1, boolean var2, boolean var3, int var4, int var5);

    public void set(ListRow[] var1, boolean var2, boolean var3, int var4, byte var5, int var6);

    public void set(ListRow[] var1, boolean var2, boolean var3, int var4, byte var5, int var6, ListRow var7, int var8);

    public void setListEnd(boolean var1, boolean var2);

    public void setListEnd2(boolean var1, boolean var2);

    public void remove(ListRow var1);

    public void updateRows(ListRow[] var1);

    public void resetCursorPosition(boolean var1);
}

