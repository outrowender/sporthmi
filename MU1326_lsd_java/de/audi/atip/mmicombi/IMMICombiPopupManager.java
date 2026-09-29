/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.mmicombi.IMMICombiPopupEventListener;
import de.audi.atip.mmicombi.IMMICombiScreenChangeManager;

public interface IMMICombiPopupManager
extends IPopupManager {
    default public void showPopupRequestFromCombi(int n) {
    }

    default public void removePopupRequestFromCombi() {
    }

    default public void setMainUnitPopupManager(IPopupManager iPopupManager) {
    }

    default public void setScreenChangeSync(IMMICombiScreenChangeManager iMMICombiScreenChangeManager) {
    }

    default public IPopupManager getMainUnitPopupManager() {
    }

    default public IMMICombiPopupEventListener getMMICombiPopupEventListener() {
    }

    default public boolean isPopupRequested(int n) {
    }

    default public void deregisterPopupAtZPM(int n) {
    }

    default public int getLastVisibleZPMPopupID() {
    }
}

