/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.IdentifierGenerator;

public interface LongIdentifierGenerator
extends IdentifierGenerator {
    public Long nextLongIdentifier();

    public long maxValue();

    public long minValue();
}

