/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.vw.mib.bap.datatypes.BAPEntity;

public final class DeserializationResult {
    private final int result;
    private final BAPEntity data;

    public DeserializationResult(int n, BAPEntity bAPEntity) {
        this.result = n;
        this.data = bAPEntity;
    }

    public int getResult() {
        return this.result;
    }

    public BAPEntity getData() {
        return this.data;
    }
}

