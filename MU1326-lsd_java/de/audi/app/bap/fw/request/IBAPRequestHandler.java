/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.request;

import de.vw.mib.bap.stream.BitStreamSerializer;

public interface IBAPRequestHandler {
    public static final int ERROR_TYPE_FUNCTION_NOT_SUPPORTED;
    public static final int ERROR_TYPE_FUNCTION_NOT_AVAILABLE;
    public static final int ERROR_TYPE_FUNCTION_OUT_OF_RANGE;
    public static final int ERROR_TYPE_METHOD_ABORTED;
    public static final int ERROR_TYPE_INVALID_REQUEST;
    public static final int ERROR_TYPE_INVALID_ARGUMENT;
    public static final int ERROR_TYPE_NO_RESPONSE;
    public static final int ERROR_TYPE_UNSUPPORTED_OP_TYPE;
    public static final int ERROR_TYPE_RETRY_TIMEOUT;
    public static final int ERROR_TYPE_MAX_DATA_LENGTH_EXCEEDED;
    public static final int ERROR_TYPE_SIZE;

    default public boolean processRequest(int n, int n2, int n3, BitStreamSerializer bitStreamSerializer) {
    }

    default public void requestErrorCode(int n, int n2, int n3) {
    }

    default public void requestError(int n, int n2, int n3) {
    }

    default public void destroy() {
    }
}

