/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.tuner.app.memory.AbstractMemoryRow;

public abstract class AbstractTVMemoryRow
extends AbstractMemoryRow {
    protected AbstractTVMemoryRow(int n, int n2) {
        super(n, n2);
    }

    protected AbstractTVMemoryRow(AbstractTVMemoryRow abstractTVMemoryRow) {
        super(abstractTVMemoryRow);
    }
}

