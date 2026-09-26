/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.metrics.AbstractMetrics;

public interface GuiListRow {
    default public long getUniqueID() {
    }

    default public int getColumnCount() {
    }

    default public int getInteger(int n) {
    }

    default public long getLong(int n) {
    }

    default public String getText(int n) {
    }

    default public AbstractMetrics getMetrics(int n) {
    }

    default public Object getCell(int n) {
    }
}

