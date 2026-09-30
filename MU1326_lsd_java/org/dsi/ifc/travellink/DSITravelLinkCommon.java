/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travellink;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.travellink.GenericProperty;

public interface DSITravelLinkCommon
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int RT_REQUESTTOAPP = 1000;
    public static final int ATTR_FROMAPP = 1;

    public void requestToApp(int var1, int var2, GenericProperty[] var3, int var4, int var5, int var6, int var7);
}

