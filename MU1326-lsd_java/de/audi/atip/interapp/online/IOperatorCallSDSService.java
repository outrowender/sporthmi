/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import org.dsi.ifc.online.OperatorCallResult;

public interface IOperatorCallSDSService {
    default public void startCallcenterCallBySDS(int n, IOperatorCallSDSServiceListener iOperatorCallSDSServiceListener, boolean bl) {
    }

    default public int getNumberOfPoisOfHistoryCallForSDS(int n, int n2) {
    }

    default public OperatorCallResult getPoiOfIndexForSDS(int n, int n2) {
    }
}

