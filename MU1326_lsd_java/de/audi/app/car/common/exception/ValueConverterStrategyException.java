/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.exception;

public class ValueConverterStrategyException
extends Exception {
    public static final int EXCEPTION_REASON_UNKNOWN;
    public static final int EXCEPTION_REASON_INVALID_PARAMETER;
    public static final int EXCEPTION_REASON_NOT_IMPLEMENTED;
    private final int reason;
    private static final long serialVersionUID;

    public ValueConverterStrategyException(int n) {
        this.reason = n;
    }

    public ValueConverterStrategyException(int n, String string) {
        super(string);
        this.reason = n;
    }

    public int getReason() {
        return this.reason;
    }
}

