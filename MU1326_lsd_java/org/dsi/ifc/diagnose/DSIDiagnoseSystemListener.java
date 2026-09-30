/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.diagnose;

import org.dsi.ifc.base.DSIListener;

public interface DSIDiagnoseSystemListener
extends DSIListener {
    public void updateDiagnosticValueChanged(int var1, long var2, int var4);

    public void requestRoutine(int var1, int var2, int var3, int[] var4);

    public void requestActuatorTest(int var1, int var2, int var3, int var4, int[] var5);
}

