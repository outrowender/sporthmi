/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.StringIdentifierGenerator;

public abstract class AbstractStringIdentifierGenerator
implements StringIdentifierGenerator {
    protected static final int MAX_LONG_NUMERIC_VALUE_LENGTH = Long.toString(Long.MIN_VALUE).length();
    protected static final int ALPHA_NUMERIC_CHARSET_SIZE = 36;
    protected static final int MAX_LONG_ALPHANUMERIC_VALUE_LENGTH = Long.toString(Long.MAX_VALUE, 36).length();
    protected static final int MAX_INT_NUMERIC_VALUE_LENGTH = Integer.toString(Integer.MIN_VALUE).length();
    protected static final int MAX_INT_ALPHANUMERIC_VALUE_LENGTH = Integer.toString(Integer.MAX_VALUE, 36).length();
    protected static final int DEFAULT_ALPHANUMERIC_IDENTIFIER_SIZE = 15;

    protected AbstractStringIdentifierGenerator() {
    }

    public abstract String nextStringIdentifier();

    public long maxLength() {
        return -1L;
    }

    public long minLength() {
        return 0L;
    }

    public Object nextIdentifier() {
        return this.nextStringIdentifier();
    }
}

