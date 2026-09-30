/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaycontroller;

import org.dsi.ifc.base.DSIBase;

public interface DSIDisplayController
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int RT_SETDISPLAYBRIGHTNESS = 1001;
    public static final int RT_SWITCHDISPLAYPOWER = 1002;
    public static final int RT_GETDISPLAYBRIGHTNESS = 1003;
    public static final int RP_GETDISPLAYBRIGHTNESS = 2000;

    public void switchDisplayPower(int var1, int var2, int var3);

    public void setDisplayBrightness(int var1, int var2);

    public void getDisplayBrightness(int var1);
}

