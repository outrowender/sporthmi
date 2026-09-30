/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.request;

import de.vw.mib.bap.stream.BitStreamSerializer;

public interface IBAPRequestHandler {
    public static final int ERROR_TYPE_FUNCTION_NOT_SUPPORTED = 0;
    public static final int ERROR_TYPE_FUNCTION_NOT_AVAILABLE = 1;
    public static final int ERROR_TYPE_FUNCTION_OUT_OF_RANGE = 2;
    public static final int ERROR_TYPE_METHOD_ABORTED = 3;
    public static final int ERROR_TYPE_INVALID_REQUEST = 4;
    public static final int ERROR_TYPE_INVALID_ARGUMENT = 5;
    public static final int ERROR_TYPE_NO_RESPONSE = 6;
    public static final int ERROR_TYPE_UNSUPPORTED_OP_TYPE = 7;
    public static final int ERROR_TYPE_RETRY_TIMEOUT = 8;
    public static final int ERROR_TYPE_MAX_DATA_LENGTH_EXCEEDED = 9;
    public static final int ERROR_TYPE_SIZE = 10;

    public boolean processRequest(int var1, int var2, int var3, BitStreamSerializer var4);

    public void requestErrorCode(int var1, int var2, int var3);

    public void requestError(int var1, int var2, int var3);

    public void destroy();
}

