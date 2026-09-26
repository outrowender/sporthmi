/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

public interface ErrorReporter {
    public static final String NO_INITIAL;
    public static final String ILLEGAL_INITIAL;
    public static final String UNKNOWN_ACTION;
    public static final String ILLEGAL_CONFIG;
    public static final String NON_DETERMINISTIC;
    public static final String UNDEFINED_VARIABLE;
    public static final String EXPRESSION_ERROR;

    default public void onError(String string, String string2, Object object) {
    }
}

