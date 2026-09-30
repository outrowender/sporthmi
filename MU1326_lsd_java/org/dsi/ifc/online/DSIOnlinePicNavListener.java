/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.PicNavSyncInfo;

public interface DSIOnlinePicNavListener
extends DSIListener {
    public void updateSyncStatus(int var1, int var2);

    public void synchronizeResult(int var1, PicNavSyncInfo var2);

    public void getPendingTransactionsResult(int var1, PicNavSyncInfo var2);

    public void setActiveProfileResult(int var1);
}

