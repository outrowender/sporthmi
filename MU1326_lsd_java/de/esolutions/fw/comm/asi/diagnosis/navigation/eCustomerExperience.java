/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

import de.esolutions.fw.comm.core.IEnum;

public interface eCustomerExperience
extends IEnum {
    public static final int PSD_DRIVER_SHALL_BE_COMFORTABLE = 0;
    public static final int PSD_SYSTEM_WORKS_FINE_BUT_DRIVER_DISTURBS = 1;
    public static final int PSD_SYSTEM_WORKS_ON_WITH_SMALL_LIMITATIONS = 2;
    public static final int PSD_SYSTEM_WORKS_ONLY_WITH_MAJOR_LIMITATIONS = 3;
    public static final int PSD_DB_IN_DRIVEN_REGION_DID_NOT_FIT = 4;
    public static final int PSD_DRIVER_DID_ALMOST_NEVER_SEE_THE_FUNCTIONALITY = 5;
}

