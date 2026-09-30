/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;

public interface DSINavAsiaSDIS
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int ATTR_ROUTEGUIDANCEACTIVE = 1;
    public static final int ATTR_CARPOSITION = 2;
    public static final int ATTR_DESTINATIONINFO = 3;
    public static final int ATTR_NEXTDESTINATIONINFO = 4;
    public static final int RT_STARTGUIDANCETODESTINATIONS = 1000;
    public static final int RP_STARTGUIDANCETODESTINATIONSRESULT = 2000;
    public static final int STARTGUIDANCERESULT_OK = 0;
    public static final int STARTGUIDANCERESULT_NOT_OPERABLE = 1;
    public static final int STARTGUIDANCERESULT_ERROR = 2;
    public static final int STARTGUIDANCERESULT_UNSUPPORTED = 3;

    public void startGuidanceToDestinations(AddressDataSDIS[] var1);
}

