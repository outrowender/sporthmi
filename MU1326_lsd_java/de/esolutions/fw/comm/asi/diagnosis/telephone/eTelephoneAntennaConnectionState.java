/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

import de.esolutions.fw.comm.core.IEnum;

public interface eTelephoneAntennaConnectionState
extends IEnum {
    public static final int TELEPHONE_ANTENNA_CONN_STATE_OK = 0;
    public static final int TELEPHONE_ANTENNA_CONN_STATE_OPEN_LOAD = 1;
    public static final int TELEPHONE_ANTENNA_CONN_STATE_SHORT_CIRCUIT_TO_GROUND = 2;
    public static final int TELEPHONE_ANTENNA_CONN_STATE_SHORT_CIRCUIT_TO_BATTERY = 3;
    public static final int TELEPHONE_ANTENNA_CONN_STATE_NOT_AVAILABLE = 255;
}

