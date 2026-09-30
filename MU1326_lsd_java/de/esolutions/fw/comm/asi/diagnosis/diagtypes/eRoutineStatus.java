/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eRoutineStatus
extends IEnum {
    public static final int ROUTINE_ACTIVE = 1;
    public static final int ROUTINE_NOT_ACTIVE = 2;
    public static final int ROUTINE_ABORTED = 3;
    public static final int ROUTINE_STATUS_DUMMY = 171;
}

