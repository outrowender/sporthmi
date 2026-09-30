/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.IEnum;

public interface EComponentEncryptionDomain
extends IEnum {
    public static final int eFecEnryptComponentBased = 0;
    public static final int eFecEnryptComponentAndCarBased = 1;
    public static final int eFecEnryptGFAKeyBased = 2;
}

