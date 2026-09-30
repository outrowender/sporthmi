/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

public interface DSIError {
    public static final int ERROR_LISTENER_UPDATE_UNKNOWNFUNCTION = 8000;
    public static final int ERROR_LISTENER_RESPONSE_UNKNOWNFUNCTION = 8010;
    public static final int ERROR_LISTENER_RESPONSE_NONFATALEXCEPTION = 8011;
    public static final int ERROR_LISTENER_RESPONSE_FATALEXCEPTION = 8012;
    public static final int ERROR_LISTENER_RESPONSE_IOEXCEPTION = 8013;
    public static final int ERROR_LISTENER_UPDATE_CLASSCASTEXCEPTION = 8100;
    public static final int ERROR_LISTENER_RESPONSE_CLASSCASTEXCEPTION = 8101;
    public static final int ERROR_LISTENER_ADDLISTENER_CLASSCASTEXCEPTION = 8102;
    public static final int ERROR_DECODER_COMPILE = 8200;
    public static final int ERROR_REQUEST_BUSY = 8300;
    public static final int ERROR_INVALID_ATTRIBUTE = 8301;
    public static final int ERROR_INVALID_ARGUMENT = 8302;
    public static final int ERROR_INVALID_STATE = 8303;
    public static final int ERROR_REQUEST_TIMEOUT = 8304;
    public static final int ERROR_FUNCTION_NOTSUPPORTED = 8305;
    public static final int ERROR_ENTRYID_NOT_FOUND = 10001;
}

