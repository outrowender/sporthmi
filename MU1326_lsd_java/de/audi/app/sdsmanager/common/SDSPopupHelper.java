/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.def.NullViewSizeManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;

public class SDSPopupHelper
implements ISDSPopupHelper {
    private LogChannel lc = Logger.getMainLog();
    private final HMIService hmiService;
    private AppSDSManager appSDSManager;
    private SDSAudioHandler sdsAudioHandler;
    private int currentBigCommandScreenPopupMappingID = -1;
    private int bigCommandDisplayToRemove = -1;
    private int currentHelpScreenPopupMappingID = -1;
    private int currentFurtherCommandDisplayPopupMappingID = -1;
    private IViewSizeManager viewSizeManager = new NullViewSizeManager(this.lc);
    private final Object furtherCommandDisplayMutex = new Object();
    private volatile boolean furtherCommandDisplayActive = false;
    private volatile boolean isLogicalPopupRemovedBySDS = false;
    private volatile boolean logicalPopupCalledToBeRemovedBySDS = false;

    public SDSPopupHelper(IFrameworkAccess iFrameworkAccess) {
        this.hmiService = iFrameworkAccess.getHMIService();
    }

    public void setAppSDSManager(AppSDSManager appSDSManager) {
        this.appSDSManager = appSDSManager;
    }

    public void setSDSAudioHandler(SDSAudioHandler sDSAudioHandler) {
        this.sdsAudioHandler = sDSAudioHandler;
    }

    public void stop() {
        this.removeAllSDSPopups();
    }

    public void removeAllSDSPopups() {
        this.lc.log(10000000, "SDSPopupHelper#removeSDSPopups: called");
        int[] nArray = SDSManagerBaseActivator.getMapping().getSDSPopups();
        if (SDSUtils.isEmpty(nArray)) {
            return;
        }
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            this.hmiService.removePopup(n2);
        }
    }

    public void removeSmallCommandDisplay() {
        this.lc.log(10000000, "SDSPopupHelper#removeSmallCommandDisplay: called");
        SDSModelAccess.setSmallCommandDisplayVisible(0);
        SDSModelAccess.setCommandType(-1);
    }

    public void removeAllBigCommandPopups() {
        int[] nArray = SDSManagerBaseActivator.getMapping().getBigCommandPopups();
        this.lc.log(10000000, "SDSPopupHelper#removeBigCommandPopups: Removing big command popups %1!", (Object)nArray);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            this.hmiService.removePopup(n2);
        }
    }

    public void removeBigCommandDisplay() {
        this.lc.log(10000000, "SDSPopupHelper#removeBigCommandDisplay: currentBigCommandScreenPopupMappingID=%1!", (long)this.currentBigCommandScreenPopupMappingID);
        if (this.currentBigCommandScreenPopupMappingID == -1) {
            return;
        }
        this.triggerHapticalPopup(this.currentBigCommandScreenPopupMappingID, false);
        this.setCurrentBigCommandScreenPopupMapping(-1);
    }

    public void removeAllFurtherCommandPopups() {
        int[] nArray = SDSManagerBaseActivator.getMapping().getFurtherCommandPopups();
        this.lc.log(10000000, "SDSPopupHelper#removeFurtherCommandPopups: Removing further command popups %1!", (Object)nArray);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            this.hmiService.removePopup(n2);
        }
        this.furtherCommandDisplayActive = false;
    }

    public boolean isFurtherCommandDisplayActive() {
        return this.furtherCommandDisplayActive;
    }

    public void showFurtherCommandDisplay() {
        this.setFurtherCommandDisplay(true);
    }

    public void removeFurtherCommandDisplay() {
        this.setFurtherCommandDisplay(false);
    }

    public void toggleFurtherCommandDisplay() {
        this.setFurtherCommandDisplay(!this.furtherCommandDisplayActive);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setFurtherCommandDisplay(boolean bl) {
        Object object = this.furtherCommandDisplayMutex;
        synchronized (object) {
            if (this.furtherCommandDisplayActive == bl) {
                this.lc.log(10000000, "SDSPopupHelper#setFurtherCommandDisplay: Further command display is already %1 => NOP!", (Object)(bl ? "on" : "off"));
                return;
            }
            if (bl) {
                int n = this.appSDSManager.getDialogContext();
                int n2 = SDSPopupHelper.getPopupMappingForDialogContext(n);
                this.lc.log(10000000, "SDSPopupHelper#setFurtherCommandDisplay: Show further command display from sdsDialogContext=%1 => popupMappingID=%2!", (long)n, (long)n2);
                this.triggerHapticalPopup(n2, true);
                this.currentFurtherCommandDisplayPopupMappingID = n2;
                this.sdsAudioHandler.switchToSDSAudioDrawerContext(n);
                SDSModelAccess.setCommandType(2);
                this.removeBigCommandDisplay();
                this.furtherCommandDisplayActive = true;
                SDSModelAccess.setSmallCommandDisplayVisible(1);
            } else {
                if (this.currentFurtherCommandDisplayPopupMappingID == -1) {
                    this.lc.log(100000, "SDSPopupHelper#setFurtherCommandDisplay: Cannot remove current further command display => is already NONE!");
                    return;
                }
                this.lc.log(10000000, "SDSPopupHelper#setFurtherCommandDisplay: Remove current further command display with popupMappingID=%1!", (long)this.currentFurtherCommandDisplayPopupMappingID);
                this.triggerHapticalPopup(this.currentFurtherCommandDisplayPopupMappingID, false);
                this.sdsAudioHandler.switchToSDSAudioDrawerContextMain();
                this.currentFurtherCommandDisplayPopupMappingID = -1;
                if (SDSModelAccess.getCommandScreen() == 1) {
                    SDSModelAccess.setCommandType(0);
                } else {
                    SDSModelAccess.setCommandType(4);
                    SDSModelAccess.setSmallCommandDisplayVisible(0);
                }
                this.furtherCommandDisplayActive = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateFurtherCommandsRemoved() {
        Object object = this.furtherCommandDisplayMutex;
        synchronized (object) {
            this.currentFurtherCommandDisplayPopupMappingID = -1;
            this.furtherCommandDisplayActive = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateFurtherCommandsShown() {
        Object object = this.furtherCommandDisplayMutex;
        synchronized (object) {
            if (this.furtherCommandDisplayActive) {
                return;
            }
            this.furtherCommandDisplayActive = true;
            int n = this.appSDSManager.getDialogContext();
            this.currentFurtherCommandDisplayPopupMappingID = SDSPopupHelper.getPopupMappingForDialogContext(n);
            this.lc.log(10000000, "SDSPopupHelper#updateFurtherCommandsShown: Current FC-Popup mapping-ID would be %1 for context %2!", (long)this.currentFurtherCommandDisplayPopupMappingID, (long)n);
        }
    }

    private static int getPopupMappingForDialogContext(int n) {
        SDSUtils.DialogContextToPopupToAudioDrawerTriplet dialogContextToPopupToAudioDrawerTriplet = null;
        for (int i2 = 0; i2 < SDSUtils.DialogContextToPopupToAudioDrawerTriplet.TRIPLET_DATA.length; ++i2) {
            dialogContextToPopupToAudioDrawerTriplet = SDSUtils.DialogContextToPopupToAudioDrawerTriplet.TRIPLET_DATA[i2];
            if (dialogContextToPopupToAudioDrawerTriplet.dialogContext != n) continue;
            return dialogContextToPopupToAudioDrawerTriplet.popupMapping;
        }
        return -1;
    }

    public void removeAllDisambiguationPopups() {
        int[] nArray = SDSManagerBaseActivator.getMapping().getDisambiguationPopups();
        this.lc.log(10000000, "SDSPopupHelper#removeDisambiguationPopups: Removing further command popups %1!", (Object)nArray);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            this.hmiService.removePopup(n2);
        }
    }

    public int getCommandScreenPopupMapping(int n) {
        this.lc.log(10000000, "SDSPopupHelper#getCommandScreenPopupMapping: commandMode=%1", (long)n);
        return SDSManagerBaseActivator.getMapping().getCommandScreenPopupMapping(n, this.lc);
    }

    public int getHelpScreenPopupMapping(int n) {
        this.lc.log(10000000, "SDSPopupHelper#getHelpScreenPopup: listMode=%1", (long)n);
        return SDSManagerBaseActivator.getMapping().getHelpScreenPopupMapping(n, this.lc);
    }

    public void triggerHapticalPopup(int n, boolean bl) {
        this.lc.log(10000000, "SDSPopupHelper#triggerHapticalPopup: popupMappingID=%2, show=%1", (Object)bl, (long)n);
        SDSModelAccess.setSDSLogicalPopup(0);
        if (n == 4 && bl && SDSModelAccess.getCommandScreen() == 0) {
            SDSModelAccess.setSDSLogicalPopup(1);
        }
        this.triggerPopup(n, bl, 0);
    }

    public void triggerHapticalPartialPopup(int n, boolean bl) {
        this.lc.log(10000000, "SDSPopupHelper#triggerHapticalPartialPopup: popupMappingID=%2, show=%1", (Object)bl, (long)n);
        int n2 = SDSManagerBaseActivator.getMapping().getPopupID(n);
        if (n2 == -1) {
            this.lc.log(100000, "SDSPopupHelper#triggerHapticalPartialPopup: No mappedPopupID found for popupMappingID %1!", (long)n);
            return;
        }
        this.lc.log(10000000, "SDSPopupHelper#triggerHapticalPartialPopup: %1 popup with id %2 and terminalID %3!", (Object)(bl ? "Showing" : "Removing"), (long)n2, 0L);
        if (bl) {
            this.hmiService.showPartialPopup(0, n2);
        } else {
            this.hmiService.removePartialPopup(0, n2);
        }
    }

    public void triggerSpeechPopup(int n, boolean bl) {
        this.lc.log(10000000, "SDSPopupHelper#triggerSpeechPopup: popupMappingID=%2, show=%1", (Object)bl, (long)n);
        this.triggerPopup(n, bl, 6);
    }

    private void triggerPopup(int n, boolean bl, int n2) {
        this.lc.log(10000000, "SDSPopupHelper#triggerPopup: popupMappingID=%2, show=%1, terminalID=%3", (Object)bl, (long)n, (long)n2);
        int n3 = SDSManagerBaseActivator.getMapping().getPopupID(n);
        if (n3 == -1) {
            this.lc.log(100000, "SDSPopupHelper#triggerPopup: No mappedPopupID found for popupID %1!", (long)n);
            return;
        }
        this.lc.log(10000000, "SDSPopupHelper#triggerPopup: %1 popup with id %2 and terminalID %3!", (Object)(bl ? "Showing" : "Removing"), (long)n3, (long)n2);
        if (bl) {
            this.hmiService.showPopup(n3, n2);
        } else {
            this.hmiService.removePopup(n3, n2);
        }
    }

    public boolean isSmallStageActive() {
        return this.viewSizeManager.getCurrentViewSize() == 1;
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        if (iViewSizeManager != null) {
            this.lc.log(10000000, "SDSPopupHelper#setViewSizeManager: called");
            this.viewSizeManager = iViewSizeManager;
        }
    }

    public void unsetViewSizeManager() {
        this.lc.log(10000000, "SDSPopupHelper#unsetViewSizeManager: called");
        this.viewSizeManager = new NullViewSizeManager(this.lc);
    }

    public int getCurrentBigCommandScreenPopupMapping() {
        return this.currentBigCommandScreenPopupMappingID;
    }

    public void setCurrentBigCommandScreenPopupMapping(int n) {
        this.lc.log(10000000, "SDSPopupHelper#setCurrentBigCommandScreenPopupMapping: popupMappingID=%1", (long)n);
        this.currentBigCommandScreenPopupMappingID = n;
    }

    public int getCurrentHelpScreenPopupMappingID() {
        return this.currentHelpScreenPopupMappingID;
    }

    public void setCurrentHelpScreenPopupMappingID(int n) {
        this.currentHelpScreenPopupMappingID = n;
    }

    public int getCurrentHMIPopup() {
        return this.hmiService.getCurrentPopup();
    }

    public boolean isSDSPopup(int n) {
        return SDSManagerBaseActivator.getMapping().isSDSPopup(n);
    }

    public void showDebugPopup(String string, String string2, String string3) {
        if (!Boolean.getBoolean("ActivateNaviDebugPopup")) {
            return;
        }
        SDSModelAccess.setDebugActionProxyLabel(string);
        SDSModelAccess.setDebugTimeoutLabel(string2);
        SDSModelAccess.setDetailedMessageLabel(string3);
        this.triggerHapticalPopup(1000, true);
    }

    public boolean isBigCommandDisplay(int n) {
        return SDSManagerBaseActivator.getMapping().isBigCommandDisplay(n);
    }

    public void setBigCommandDisplayToRemove(int n) {
        this.lc.log(10000000, "SDSPopupHelper#setBigCommandDisplayToRemove: popupMappingId=%1!", (long)n);
        this.bigCommandDisplayToRemove = n;
    }

    public void updateBigCommandDisplayConnected() {
        this.lc.log(10000000, "SDSPopupHelper#updateBigCommandDisplayConnected: bigCommandDisplayToRemove=%1!", (long)this.bigCommandDisplayToRemove);
        SDSModelAccess.setSmallCommandDisplayVisible(1);
        if (this.bigCommandDisplayToRemove != -1) {
            this.triggerPopup(this.bigCommandDisplayToRemove, false, 0);
            this.bigCommandDisplayToRemove = -1;
        }
    }

    public boolean isLogicalPopupRemovedBySDS() {
        return this.isLogicalPopupRemovedBySDS;
    }

    public void setLogicalPopupRemovedBySDS(boolean bl) {
        this.lc.log(10000000, "SDSPopupHelper#setLogicalPopupRemovedBySDS: status=%1!", bl);
        this.isLogicalPopupRemovedBySDS = bl;
        if (bl) {
            this.setLogicalPopupCalledToBeRemovedBySDS(true);
        }
    }

    public void setLastPartialPopupHiddenBySDSDialog() {
    }

    public void setLogicalPopupCalledToBeRemovedBySDS(boolean bl) {
        this.logicalPopupCalledToBeRemovedBySDS = bl;
    }

    public boolean isLogicalPopupCalledToBeRemovedBySDS() {
        return this.logicalPopupCalledToBeRemovedBySDS;
    }
}

