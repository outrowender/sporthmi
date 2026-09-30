/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

import de.esolutions.fw.comm.core.IEnum;

public interface eMediaTypeOpticalDrive
extends IEnum {
    public static final int MEDIA_TYPE_CD_DA = 0;
    public static final int MEDIA_TYPE_CD_ROM = 1;
    public static final int MEDIA_TYPE_DVD_VIDEO = 2;
    public static final int MEDIA_TYPE_DVD_AUDIO = 3;
    public static final int MEDIA_TYPE_DVD_ROM = 4;
    public static final int MEDIA_TYPE_BD = 5;
    public static final int MEDIA_TYPE_BD_ROM = 6;
    public static final int MEDIA_TYPE_NOT_AVAILABLE = 255;
}

