/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.metrics.AbstractMetrics;

public interface GuiListRow {
    public long getUniqueID();

    public int getColumnCount();

    public int getInteger(int var1);

    public long getLong(int var1);

    public String getText(int var1);

    public AbstractMetrics getMetrics(int var1);

    public Object getCell(int var1);
}

