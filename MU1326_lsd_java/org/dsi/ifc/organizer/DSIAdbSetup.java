/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbSetup
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_SETLANGUAGE = 1000;
    public static final int RT_SETSORTORDER = 1001;
    public static final int RT_SETPICTUREVISIBILITY = 1003;
    public static final int RT_SETPUBLICPROFILEVISIBILITY = 1004;
    public static final int RT_RESETTOFACTORYSETTINGS = 1005;
    public static final int RT_RESETTOPDESTINATION = 1006;
    public static final int RT_CREATEBACKUPFILE = 1007;
    public static final int RT_IMPORTBACKUPFILE = 1008;
    public static final int RT_SETCONTEXTSPECIFICVISIBILITY = 1009;
    public static final int ATTR_ADBSTATE = 1;
    public static final int ATTR_SORTORDER = 2;
    public static final int ATTR_PICTUREVISIBILITY = 3;
    public static final int ATTR_CONTEXTSPECIFICVISIBILITY = 4;
    public static final int RP_SETLANGUAGERESULT = 2000;
    public static final int RP_SETSORTORDERRESULT = 2001;
    public static final int RP_SETPUBLICPROFILEVISIBILITYRESULT = 2005;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT = 2006;
    public static final int RP_RESETTOPDESTINATIONRESULT = 2010;
    public static final int RP_CREATEBACKUPFILERESULT = 2012;
    public static final int RP_IMPORTBACKUPFILERESULT = 2013;
    public static final int RP_SETPICTUREVISIBILITYRESULT = 2014;
    public static final int RP_SETCONTEXTSPECIFICVISIBILITYRESULT = 2015;

    public void setLanguage(String var1);

    public void setSortOrder(int var1);

    public void setPublicProfileVisibility(boolean var1);

    public void resetToFactorySettings();

    public void resetTopDestination();

    public void createBackupFile(String var1);

    public void importBackupFile(String var1);

    public void setPictureVisibility(boolean var1);

    public void setContextSpecificVisibility(boolean var1);
}

