/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.core.IEnum;

public interface OAuthResultCode
extends IEnum {
    public static final int ERRORCODE_OK;
    public static final int ERRORCODE_AUTH_INTERNAL_ERROR;
    public static final int ERRORCODE_AUTH_BACKEND_ERROR;
    public static final int ERRORCODE_SERVICE_MISSING;
    public static final int ERRORCODE_SERVICE_FORBIDDEN;
}

