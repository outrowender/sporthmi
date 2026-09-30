/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.IEnum;

public interface EFecState
extends IEnum {
    public static final int eStateNotAvailable = -1;
    public static final int eNoPermission = 0;
    public static final int ePermissionGranted = 1;
    public static final int ePermissionTemporarilyWithdrawn = 2;
    public static final int ePermissionWithdrawn = 3;
    public static final int ePermissionIllegal = 4;
}

