/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public class DialNumberResult {
    public static final int SUCCESSFUL = 0;
    public static final int NOT_SUCCESSFUL = 1;
    public static final int ABORT_SUCCESSFUL = 2;
    public static final int ABORT_NOT_SUCCESSFUL = 3;
    public static final int NOT_SUCCESSFUL_NUMBER_INVALID = 4;
    public static final int NOT_SUCCESSFUL_NO_NETWORK = 5;

    private DialNumberResult() {
        throw new AssertionError((Object)"DialNumberResult is not intended to be instantiated.");
    }
}

