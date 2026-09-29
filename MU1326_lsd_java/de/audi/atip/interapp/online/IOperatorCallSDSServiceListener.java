/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface IOperatorCallSDSServiceListener {
    public static final int RESULT_CALL_CONNECTED;
    public static final int RESULT_CONNECTION_ERROR;
    public static final int RESULT_LICENSE_ERROR;
    public static final int RESULT_OLD_DATA_FOUND;
    public static final int RESULT_PRIVATE_CALL_ACTIVE;
    public static final int RESULT_CONNECTION_ABORTED;
    public static final int RESULT_INTERNAL_ERROR;
    public static final int RESULT_SERVER_ERROR;
    public static final int RESULT_SERVICE_NOT_READY;

    default public void startCallcenterCallBySDSResult(int n) {
    }
}

