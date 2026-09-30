/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.core.IEnum;

public interface AudioDataFormat
extends IEnum {
    public static final int ADF_PCM = 0;
    public static final int ADF_WAVE = 1;
    public static final int ADF_OGG = 2;
    public static final int ADF_OPUS = 3;
    public static final int ADF_SPEEX = 4;
    public static final int ADF_FLAC = 5;
    public static final int ADF_CELT = 6;
}

