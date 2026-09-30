/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eRoutineResults
extends IEnum {
    public static final int ROUTINE_INCORRECT_RESULT = 0;
    public static final int ROUTINE_NO_RESULTS_AVAILABLE = 1;
    public static final int ROUTINE_CORRECT_RESULTS = 65535;
    public static final int ROUTINE_RESULTS_DUMMY = 43981;
}

