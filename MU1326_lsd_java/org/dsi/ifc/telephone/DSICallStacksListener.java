/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.MissedCallIndicator;

public interface DSICallStacksListener
extends DSIListener {
    public void updateIsReverted(boolean var1, int var2);

    public void updateLastAnsweredNumbers(CallStackEntry[] var1, int var2);

    public void updateLastDialedNumbers(CallStackEntry[] var1, int var2);

    public void updateMissedNumbers(CallStackEntry[] var1, int var2);

    public void updateMEDataValidity(int var1, int var2);

    public void updateMissedCallIndicator(MissedCallIndicator var1, int var2);
}

