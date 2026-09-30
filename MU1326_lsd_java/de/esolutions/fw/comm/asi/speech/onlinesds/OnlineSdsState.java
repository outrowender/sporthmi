/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.core.IEnum;

public interface OnlineSdsState
extends IEnum {
    public static final int OS_STATE_OK = 0;
    public static final int OS_STATE_SKIPPED_OK = 1;
    public static final int OS_STATE_ERROR_NO_ONLINE_RESULT = 2;
    public static final int OS_STATE_ERROR_NO_CONNECTION = 3;
    public static final int OS_STATE_ERROR_GENERAL = 4;
    public static final int OS_STATE_QUERY_REQUIRED = 5;
}

