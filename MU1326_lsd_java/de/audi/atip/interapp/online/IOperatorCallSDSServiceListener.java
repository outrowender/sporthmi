/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface IOperatorCallSDSServiceListener {
    public static final int RESULT_CALL_CONNECTED = 0;
    public static final int RESULT_CONNECTION_ERROR = 1;
    public static final int RESULT_LICENSE_ERROR = 2;
    public static final int RESULT_OLD_DATA_FOUND = 3;
    public static final int RESULT_PRIVATE_CALL_ACTIVE = 4;
    public static final int RESULT_CONNECTION_ABORTED = 5;
    public static final int RESULT_INTERNAL_ERROR = 6;
    public static final int RESULT_SERVER_ERROR = 7;
    public static final int RESULT_SERVICE_NOT_READY = 8;

    public void startCallcenterCallBySDSResult(int var1);
}

