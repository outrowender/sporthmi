/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public interface DSIOnlineTrafficListener
extends DSIListener {
    public void updateConsumerReady(int var1, int var2);

    public void updateWantOnlineTrafficData(int var1, int var2);

    public void getNewDataResult(int var1, LocatablePosition[] var2);

    public void setNewDataResult(String var1, int var2);

    public void getNewSession();

    public void setTimeoutForFallbackResult(int var1);

    public void getNewFCDInformationResult(FCDPosition var1);

    public void getInventoryResult(String var1);

    public void getDownloadFileResult(String var1);
}

