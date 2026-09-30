/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.IdentifierGenerator;

public interface StringIdentifierGenerator
extends IdentifierGenerator {
    public static final int INFINITE_MAX_LENGTH = -1;

    public String nextStringIdentifier();

    public long maxLength();

    public long minLength();
}

