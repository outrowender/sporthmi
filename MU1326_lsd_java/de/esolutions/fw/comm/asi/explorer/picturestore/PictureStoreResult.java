/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import de.esolutions.fw.comm.core.IEnum;

public interface PictureStoreResult
extends IEnum {
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_NOSLOTAVAILABLE = 1;
    public static final int RESULT_IOERROR = 2;
    public static final int RESULT_PICTURENOTFOUND = 3;
    public static final int RESULT_INTERNALERROR = 4;
    public static final int RESULT_WRONG_PARAMETER = 5;
}

