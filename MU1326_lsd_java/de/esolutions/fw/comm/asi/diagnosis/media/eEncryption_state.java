/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

import de.esolutions.fw.comm.core.IEnum;

public interface eEncryption_state
extends IEnum {
    public static final int ENCRYPTION_STATE_NOT_INITIALIZED = 0;
    public static final int ENCRYPTION_STATE_OK = 1;
    public static final int ENCRYPTION_STATE_NOK = 2;
    public static final int ENCRYPTION_STATE_NO_ENCRYPTION = 3;
}

