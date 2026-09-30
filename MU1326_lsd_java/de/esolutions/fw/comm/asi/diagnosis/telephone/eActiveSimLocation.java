/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

import de.esolutions.fw.comm.core.IEnum;

public interface eActiveSimLocation
extends IEnum {
    public static final int ACTIVE_SIM_MAIN_UNIT = 0;
    public static final int ACTIVE_SIM_BLUETOOTH_HANDSET_1 = 1;
    public static final int ACTIVE_SIM_BLUETOOTH_HANDSET_2 = 2;
    public static final int ACTIVE_SIM_MOBILE_PHONE = 3;
    public static final int ACTIVE_SIM_EMBEDDED_SIM = 4;
    public static final int ACTIVE_SIM_NOT_AVAILABLE = 255;
}

