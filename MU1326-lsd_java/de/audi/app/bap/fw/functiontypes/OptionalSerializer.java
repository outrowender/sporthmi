/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.vw.mib.bap.datatypes.BAPDataType;

public final class OptionalSerializer {
    private final BAPDataType value;

    public static OptionalSerializer withoutValue() {
        return new OptionalSerializer();
    }

    public static OptionalSerializer withValue(BAPDataType bAPDataType) {
        if (bAPDataType == null) {
            throw new IllegalArgumentException("OptionalSerializer#withValue called with null !");
        }
        return new OptionalSerializer(bAPDataType);
    }

    private OptionalSerializer() {
        this.value = null;
    }

    private OptionalSerializer(BAPDataType bAPDataType) {
        this.value = bAPDataType;
    }

    public boolean hasValue() {
        return this.value != null;
    }

    public BAPDataType getValue() {
        return this.value;
    }
}

