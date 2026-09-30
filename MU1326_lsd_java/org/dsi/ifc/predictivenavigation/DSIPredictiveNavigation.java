/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.predictivenavigation;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;

public interface DSIPredictiveNavigation
extends DSIBase {
    public static final String VERSION = "2.11.3";
    public static final int OPERATIONMODE_INACTIVE = 0;
    public static final int OPERATIONMODE_PASSIVE = 1;
    public static final int OPERATIONMODE_ACTIVE = 2;
    public static final int ROUTECALCULATIONSTATE_NOT_CALCULATED = 0;
    public static final int ROUTECALCULATIONSTATE_CALCULATING = 1;
    public static final int ROUTECALCULATIONSTATE_CALCULATED = 2;
    public static final int ROUTECALCULATIONSTATE_RECALCULATING = 3;
    public static final int ROUTECOLOR_0 = 0;
    public static final int ROUTECOLOR_1 = 1;
    public static final int ROUTECOLOR_2 = 2;
    public static final int ROUTECOLOR_3 = 3;
    public static final int ROUTECOLOR_4 = 4;
    public static final int ROUTECOLOR_5 = 5;
    public static final int RT_SETOPERATIONMODE = 1000;
    public static final int RT_SETMAXPREDICTIONS = 1001;
    public static final int RT_CLEARCACHE = 1002;
    public static final int RT_CLEARCACHEBYDESTINATION = 1003;
    public static final int RT_CLEARCACHEBYAGE = 1004;
    public static final int RP_CLEARCACHERESULT = 2000;
    public static final int ATTR_OPERATIONMODE = 1;
    public static final int ATTR_LIKELYDESTINATIONS = 2;
    public static final int ATTR_MAXPREDICTIONS = 3;

    public void setOperationMode(int var1);

    public void setMaxPredictions(int var1);

    public void clearCache();

    public void clearCacheByDestination(NavLocation var1, int var2);

    public void clearCacheByAge(long var1);
}

