/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class ServiceRequestResult {
    public static final int SUCCEEDED = 0;
    public static final int FAILED = 1;
    public static final int ABORTED = 2;
    public static final int ABORTION_FAILED = 3;
    public static final int FAILED_NO_REQUEST_WAS_PENDING = 4;

    private ServiceRequestResult() {
        throw new AssertionError((Object)"ServiceRequestResult is not intended to be instantiated.");
    }
}

