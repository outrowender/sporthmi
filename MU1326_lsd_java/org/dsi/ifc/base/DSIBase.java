/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

import org.dsi.ifc.base.DSIListener;

public interface DSIBase {
    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";

    public void setNotification(int[] var1, DSIListener var2);

    public void setNotification(int var1, DSIListener var2);

    public void setNotification(DSIListener var1);

    public void clearNotification(int[] var1, DSIListener var2);

    public void clearNotification(int var1, DSIListener var2);

    public void clearNotification(DSIListener var1);
}

