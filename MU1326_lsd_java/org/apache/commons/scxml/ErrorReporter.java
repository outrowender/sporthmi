/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

public interface ErrorReporter {
    public static final String NO_INITIAL = "NO_INITIAL";
    public static final String ILLEGAL_INITIAL = "ILLEGAL_INITIAL";
    public static final String UNKNOWN_ACTION = "UNKNOWN_ACTION";
    public static final String ILLEGAL_CONFIG = "ILLEGAL_CONFIG";
    public static final String NON_DETERMINISTIC = "NON_DETERMINISTIC";
    public static final String UNDEFINED_VARIABLE = "UNDEFINED_VARIABLE";
    public static final String EXPRESSION_ERROR = "EXPRESSION_ERROR";

    public void onError(String var1, String var2, Object var3);
}

