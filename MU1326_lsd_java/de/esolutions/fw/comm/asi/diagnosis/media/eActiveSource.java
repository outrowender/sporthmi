/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

import de.esolutions.fw.comm.core.IEnum;

public interface eActiveSource
extends IEnum {
    public static final int ACTIVE_SOURCE_OPTICAL_DRIVE_INTERNAL = 0;
    public static final int ACTIVE_SOURCE_OPTICAL_DRIVE_EXTERNAL = 1;
    public static final int ACTIVE_SOURCE_INTERNAL_DEVICE = 2;
    public static final int ACTIVE_SOURCE_SD_CARD_READER_1 = 3;
    public static final int ACTIVE_SOURCE_SD_CARD_READER_2 = 4;
    public static final int ACTIVE_SOURCE_MEDIA_IN = 5;
    public static final int ACTIVE_SOURCE_AUX_IN = 6;
    public static final int ACTIVE_SOURCE_WLAN = 8;
    public static final int ACTIVE_SOURCE_BLUETOOTH = 9;
    public static final int ACTIVE_SOURCE_NOT_AVAILABLE = 255;
}

