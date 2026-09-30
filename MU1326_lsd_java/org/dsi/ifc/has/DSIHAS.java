/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.has;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.has.HASDataContainer;

public interface DSIHAS
extends DSIBase {
    public static final String VERSION = "2.11.6";
    public static final int RT_HMIREADY = 1000;
    public static final int RT_ACTIONRESULT = 1001;
    public static final int RT_PROPERTYUPDATE = 1002;
    public static final int RT_SUBSCRIBERESULT = 1003;
    public static final int IN_ACTIONREQUEST = 3000;
    public static final int IN_SUBSCRIBEREQUEST = 3001;
    public static final int IN_UNSUBSCRIBEREQUEST = 3002;
    public static final int IN_UNSUBSCRIBEALLREQUEST = 3003;
    public static final int IN_GETPROPERTYREQUEST = 3004;

    public void hmiReady();

    public void actionResult(int var1, int var2, HASDataContainer[] var3, int var4);

    public void propertyUpdate(int var1, HASDataContainer[] var2, int var3);

    public void subscribeResult(int var1, int var2);
}

