/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbUserProfile
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_DOWNLOADTOPROFILE = 1000;
    public static final int RT_RESTARTDOWNLOAD = 1001;
    public static final int RT_SETPROFILENAME = 1002;
    public static final int RT_DELETEPROFILES = 1003;
    public static final int RT_COMMONENTRYCOUNT = 1004;
    public static final int RT_ENTRYMETER = 1005;
    public static final int RT_SETPAIRINGCODE = 1006;
    public static final int RT_SETHOMEID = 1007;
    public static final int RT_SETSOSBUTTON = 1008;
    public static final int ATTR_PROFILEINFO = 2;
    public static final int ATTR_DEVICECONNECTED = 3;
    public static final int ATTR_DOWNLOADCOUNTSIM = 5;
    public static final int ATTR_DOWNLOADCOUNTME = 6;
    public static final int ATTR_DOWNLOADCOUNTOPP = 7;
    public static final int ATTR_DOWNLOADSTATE = 8;
    public static final int ATTR_DOWNLOADSTATE2NDPHONE = 9;
    public static final int ATTR_SOSBUTTON = 10;
    public static final int RP_DOWNLOADTOPROFILERESULT = 2001;
    public static final int RP_RESTARTDOWNLOADRESULT = 2002;
    public static final int RP_SETPROFILENAMERESULT = 2004;
    public static final int RP_DELETEPROFILESRESULT = 2005;
    public static final int RP_COMMONENTRYCOUNTRESULT = 2006;
    public static final int RP_ENTRYMETERRESULT = 2007;
    public static final int RP_SETPAIRINGCODERESULT = 2008;
    public static final int RP_SETHOMEIDRESULT = 2009;
    public static final int RP_SETSOSBUTTONRESULT = 2010;
    public static final int IN_NEWDEVICECONNECTED = 3000;
    public static final int IN_PROFILEDELETED = 3002;

    public void downloadToProfile(int var1);

    public void restartDownload();

    public void setProfileName(String var1);

    public void deleteProfiles(int[] var1);

    public void commonEntryCount();

    public void entryMeter();

    public void setPairingCode(String var1);

    public void setHomeId(long var1);

    public void setSOSButton(boolean var1);
}

