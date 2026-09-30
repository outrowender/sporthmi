/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.IEnum;

public interface EFecCheckResult
extends IEnum {
    public static final int eFecValid = 0;
    public static final int eFecSignatureFailed = 1;
    public static final int eFecVcrnTemporarilyFailed = 2;
    public static final int eFecDateFailed = 3;
    public static final int eFecValidityFailed = 4;
}

