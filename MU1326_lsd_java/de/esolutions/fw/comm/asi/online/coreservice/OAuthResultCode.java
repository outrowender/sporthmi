/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.core.IEnum;

public interface OAuthResultCode
extends IEnum {
    public static final int ERRORCODE_OK = 0;
    public static final int ERRORCODE_AUTH_INTERNAL_ERROR = 1;
    public static final int ERRORCODE_AUTH_BACKEND_ERROR = 2;
    public static final int ERRORCODE_SERVICE_MISSING = 3;
    public static final int ERRORCODE_SERVICE_FORBIDDEN = 4;
}

