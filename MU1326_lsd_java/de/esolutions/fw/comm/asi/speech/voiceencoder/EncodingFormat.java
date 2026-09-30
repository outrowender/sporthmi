/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder;

import de.esolutions.fw.comm.core.IEnum;

public interface EncodingFormat
extends IEnum {
    public static final int ENC_SPEEX_WB_NO_HEADER = 0;
    public static final int ENC_SPEEX_WB_OGG_HEADER = 1;
    public static final int ENC_SPEEX_WB_BYTE_HEADER = 2;
    public static final int ENC_SPEEX_WB_NUANCE_HEADER = 3;
}

