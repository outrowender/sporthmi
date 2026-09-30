/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import de.esolutions.fw.comm.core.IEnum;

public interface ImportSource
extends IEnum {
    public static final int IMPORTSOURCE_UNDEFINED = 1;
    public static final int IMPORTSOURCE_USB = 2;
    public static final int IMPORTSOURCE_SDCARD = 4;
    public static final int IMPORTSOURCE_ONLINE = 8;
    public static final int IMPORTSOURCE_STREETVIEW = 16;
    public static final int IMPORTSOURCE_CD = 32;
    public static final int IMPORTSOURCE_DVD = 64;
}

