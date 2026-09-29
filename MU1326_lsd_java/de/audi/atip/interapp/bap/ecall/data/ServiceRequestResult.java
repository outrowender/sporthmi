/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class ServiceRequestResult {
    public static final int SUCCEEDED;
    public static final int FAILED;
    public static final int ABORTED;
    public static final int ABORTION_FAILED;
    public static final int FAILED_NO_REQUEST_WAS_PENDING;

    private ServiceRequestResult() {
        throw new AssertionError((Object)"ServiceRequestResult is not intended to be instantiated.");
    }
}

