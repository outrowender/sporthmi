/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.core.IEnum;

public interface Result
extends IEnum {
    public static final int RESULT_OK = 0;
    public static final int RESULT_UNSPECIFIED_ERROR = 1;
    public static final int RESULT_LOCATOR_NOT_FOUND = 2;
    public static final int RESULT_SYSTEM_NOT_READY = 3;
    public static final int RESULT_IMAGE_IO_ERROR = 4;
}

