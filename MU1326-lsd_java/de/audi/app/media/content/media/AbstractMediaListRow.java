/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.atip.hmi.model.list.EvoListRow;

public abstract class AbstractMediaListRow
extends EvoListRow {
    private final long entryID;

    public AbstractMediaListRow(long l, long l2, int n) {
        super(l, n);
        this.entryID = l2;
    }

    public AbstractMediaListRow(AbstractMediaListRow abstractMediaListRow) {
        super(abstractMediaListRow);
        this.entryID = abstractMediaListRow.getEntryID();
    }

    public abstract boolean isEnabled() {
    }

    public final long getEntryID() {
        return this.entryID;
    }
}

