/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.Screen;

public interface IModelConnectService {
    public void modifiyModelReference(Screen var1, boolean var2, boolean var3);

    public void modifiyModelReference(HMIView[] var1, int[] var2, int[] var3, boolean var4, boolean var5);

    public void modifyModelReference(HMIView var1, boolean var2, boolean var3);

    public void checkForPostConnecting(HMIApplication var1);

    public void clearUnconnectedItems(boolean var1);
}

