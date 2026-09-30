/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import org.dsi.ifc.online.OperatorCallResult;

public interface IOperatorCallSDSService {
    public void startCallcenterCallBySDS(int var1, IOperatorCallSDSServiceListener var2, boolean var3);

    public int getNumberOfPoisOfHistoryCallForSDS(int var1, int var2);

    public OperatorCallResult getPoiOfIndexForSDS(int var1, int var2);
}

