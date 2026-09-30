/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder;

import de.esolutions.fw.comm.core.IEnum;

public interface ResultCode
extends IEnum {
    public static final int RES_OK = 0;
    public static final int RES_CANCELLED_OK = 1;
    public static final int RES_ERROR_INVALID_ARGUMENT = 2;
    public static final int RES_ERROR_GENERAL = 3;
}

