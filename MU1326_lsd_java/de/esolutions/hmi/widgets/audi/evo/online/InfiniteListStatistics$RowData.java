/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.evo.online.RowInfo;

class InfiniteListStatistics$RowData {
    public String name;
    public long uniqueId;
    public RowInfo info;
    public int checkFor;

    public InfiniteListStatistics$RowData(String string, int n) {
        this.name = string;
        this.checkFor = n;
        this.uniqueId = -1L;
        this.info = null;
    }
}

