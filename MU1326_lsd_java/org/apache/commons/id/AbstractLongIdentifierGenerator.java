/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.LongIdentifierGenerator;

public abstract class AbstractLongIdentifierGenerator
implements LongIdentifierGenerator {
    protected AbstractLongIdentifierGenerator() {
    }

    public long maxValue() {
        return Long.MAX_VALUE;
    }

    public long minValue() {
        return Long.MIN_VALUE;
    }

    public Object nextIdentifier() {
        return this.nextLongIdentifier();
    }

    public abstract Long nextLongIdentifier();
}

