/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.CoverartInfo;

public interface DSIMetadataService
extends DSIBase {
    public static final String VERSION = "2.11.52";
    public static final int ATTR_ONLINELOOKUPSTATUS = 1;
    public static final int RT_REQUESTCOVERART = 1000;
    public static final int RT_DISABLEONLINELOOKUP = 1001;
    public static final int RT_ENABLEONLINELOOKUP = 1002;
    public static final int RP_RESPONSECOVERART = 2000;
    public static final int ONLINELOOKUP_UNKNOWN = 0;
    public static final int ONLINELOOKUP_ENABLED = 1;
    public static final int ONLINELOOKUP_DISABLED = 2;

    public void requestCoverArt(int var1, CoverartInfo var2);

    public void disableOnlineLookup();

    public void enableOnlineLookup();
}

