/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.mmicombi.IMMICombiPopupEventListener;
import de.audi.atip.mmicombi.IMMICombiScreenChangeManager;

public interface IMMICombiPopupManager
extends IPopupManager {
    public void showPopupRequestFromCombi(int var1);

    public void removePopupRequestFromCombi();

    public void setMainUnitPopupManager(IPopupManager var1);

    public void setScreenChangeSync(IMMICombiScreenChangeManager var1);

    public IPopupManager getMainUnitPopupManager();

    public IMMICombiPopupEventListener getMMICombiPopupEventListener();

    public boolean isPopupRequested(int var1);

    public void deregisterPopupAtZPM(int var1);

    public int getLastVisibleZPMPopupID();
}

