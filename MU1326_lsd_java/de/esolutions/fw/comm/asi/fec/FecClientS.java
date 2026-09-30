/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.core.method.MethodException;

public interface FecClientS {
    public void updateFECs(SFecState[] var1) throws MethodException;
}

