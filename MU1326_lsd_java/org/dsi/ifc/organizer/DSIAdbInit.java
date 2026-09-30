/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbInit
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_SETDEFAULTPUBLICPROFILEVISIBILITY = 1000;
    public static final int RT_SETMAXLOCALENTRIES = 1001;
    public static final int RT_SETMAXPHONEENTRIES = 1002;
    public static final int RT_SETMAXTOPDESTENTRIES = 1003;
    public static final int RT_SETMAXSPEEDDIALENTRIES = 1004;
    public static final int RT_SETNUMERICALSPELLERENABLED = 1005;
    public static final int RT_SETAUTOPROFILEALLOCATION = 1006;
    public static final int RT_FINALIZECONFIGURATION = 1007;
    public static final int RT_SETSPEEDDIALTYPE = 1009;
    public static final int RT_SETPROFILEHANDLINGTYPE = 1010;
    public static final int RT_SETDEFAULTSORTORDER = 1011;
    public static final int RT_SETONLINEDESTINATIONENABLED = 1012;
    public static final int RT_SETDEFAULTSOSBUTTON = 1013;
    public static final int ATTR_DEFAULTPUBLICPROFILEVISIBILITY = 1;
    public static final int ATTR_MAXLOCALENTRIES = 2;
    public static final int ATTR_MAXPHONEENTRIES = 3;
    public static final int ATTR_MAXTOPDESTENTRIES = 4;
    public static final int ATTR_MAXSPEEDDIALENTRIES = 5;
    public static final int ATTR_AUTOPROFILEALLOCATION = 6;
    public static final int ATTR_DEFAULTSOSBUTTON = 7;
    public static final int RP_SETDEFAULTPUBLICPROFILEVISIBILITYRESULT = 2000;
    public static final int RP_SETMAXLOCALENTRIESRESULT = 2001;
    public static final int RP_SETMAXPHONEENTRIESRESULT = 2002;
    public static final int RP_SETMAXTOPDESTENTRIESRESULT = 2003;
    public static final int RP_SETMAXSPEEDDIALENTRIESRESULT = 2004;
    public static final int RP_SETAUTOPROFILEALLOCATIONRESULT = 2005;
    public static final int RP_SETNUMERICALSPELLERENABLEDRESULT = 2006;
    public static final int RP_SETSPEEDDIALTYPERESULT = 2009;
    public static final int RP_SETPROFILEHANDLINGTYPE = 2010;
    public static final int RP_SETDEFAULTSORTORDERRESULT = 2011;
    public static final int RP_SETONLINEDESTINATIONENABLEDRESULT = 2012;
    public static final int RP_SETDEFAULTSOSBUTTONRESULT = 2013;

    public void setDefaultPublicProfileVisibility(boolean var1);

    public void setMaxLocalEntries(int var1);

    public void setMaxPhoneEntries(int var1);

    public void setMaxTopDestEntries(int var1);

    public void setMaxSpeedDialEntries(int var1);

    public void setNumericalSpellerEnabled(boolean var1);

    public void setAutoProfileAllocation(boolean var1);

    public void finalizeConfiguration();

    public void setSpeedDialType(int var1);

    public void setProfileHandlingType(int var1);

    public void setDefaultSortOrder(int var1);

    public void setOnlineDestinationEnabled(boolean var1);

    public void setDefaultSOSButton(boolean var1);
}

