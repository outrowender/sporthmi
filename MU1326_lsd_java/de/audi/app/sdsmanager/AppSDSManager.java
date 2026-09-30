/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.ISDSDispatcher;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.VolumeSettingSessionCallback;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.Stoppable;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.atip.interapp.ISDSKeyInterceptor;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppSDSManager
implements Stoppable {
    private final LogChannel lc = Logger.getMainLog();
    private final List statusListeners = new ArrayList();
    private final Object statusListenersMutex = new Object();
    private final Object sdsKeyListenersMutex = new Object();
    private final List sdsKeyListeners = new ArrayList();
    private final Object dialogFlagsResetterMutex = new Object();
    private volatile boolean isSecondCallToResetDialogFlags = false;
    private final ISDSDispatcher sdsDispatcher;
    private final ISDSPopupHelper sdsPopupHelper;
    private final MobileSpeechRecognitionHandler mobileSRHandler;
    private SDSAdapter sdsAdapter;
    private SDSHMIListener hmiListener;
    private SDSTimeoutHandler sdsTimeoutHandler;
    private SDSAppFactory sdsAppFactory;
    private VolumeSettingSessionCallback volumeSettingSessionCallback;
    private final SpeechTTSHandler ttsHandler;
    private boolean sdsSpeechPopupActive = false;
    private boolean sdsActive = false;
    private boolean sdsPauseStateActive = false;
    private boolean sdsAborting = false;
    private volatile boolean abortEventTriggered = false;
    private byte waitStateStatus = 0;
    private boolean externalSDSRequested = false;
    private byte pttBlocked = 0;
    private volatile int dialogContext = 0;
    private ConnectedScreenIDIsScrollablePair connectedScreenIDIsScrollablePair = new ConnectedScreenIDIsScrollablePair();
    private ConnectedScreenIDWithSDSDataPair connectedSDSScreenIDWithSDSDataPair = new ConnectedScreenIDWithSDSDataPair();

    AppSDSManager(ISDSDispatcher iSDSDispatcher, ISDSPopupHelper iSDSPopupHelper, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, SpeechTTSHandler speechTTSHandler) {
        this.sdsDispatcher = iSDSDispatcher;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.mobileSRHandler = mobileSpeechRecognitionHandler;
        this.mobileSRHandler.setAppSDSManager(this);
        this.ttsHandler = speechTTSHandler;
        this.lc.log(10000000, "AppSDSManager#ctor: construction finished!");
    }

    public void stop() {
        this.lc.log(10000000, "AppSDSManager#stop: Removing all SDS popups!");
        this.sdsPopupHelper.stop();
    }

    public boolean abortSDSSession(boolean bl) {
        boolean bl2;
        this.sdsTimeoutHandler.cancelProgressIconTimer();
        this.sdsTimeoutHandler.cancelPTTRunningTimer();
        this.sdsTimeoutHandler.cancelRecognitionProlongLoopTimer();
        boolean bl3 = this.sdsAdapter.isSDSVolumeSettingActive();
        boolean bl4 = this.isSDSActive();
        this.lc.log(10000000, "AppSDSManager#abortSDSSession: sdsActive=%1, sdsVolumeSettingActive=%2!", bl4, bl3);
        if (!bl4 && (bl2 = this.mobileSRHandler.requestStopSpeechRecognition())) {
            this.lc.log(10000000, "AppSDSManager#abortSDSSession: Mobile speech recognition was stopped => NOP!");
            return false;
        }
        if (bl4 || bl3 || this.sdsAdapter.isPttRunning()) {
            this.lc.log(10000000, "AppSDSManager#abortSDSSession: dialog is active -> abort! silent=%1", bl);
            this.sdsAdapter.handleLeavingWaitingState();
            this.forceAbortSDSSession(bl);
            return true;
        }
        return false;
    }

    void forceAbortSDSSession(boolean bl) {
        this.sdsAdapter.removeSDSProgressIcon();
        if (this.isSDSPauseStateActive()) {
            this.notifySessionEnded();
        }
        if (!this.isSDSAborting()) {
            this.notifyExternalListenersSessionAborting();
        }
        this.setSDSAborting(true);
        this.sdsAdapter.abortSession(bl);
    }

    boolean abortSDSSession() {
        this.lc.log(10000000, "AppSDSManager#abortSDSSession: called");
        return this.abortSDSSession(false);
    }

    public void startSession() {
        this.lc.log(10000000, "AppSDSManager#startSession: called");
        this.notifySessionStarted();
        this.notifyFreeze(true);
    }

    public void updateStatusActive() {
        this.lc.log(10000000, "AppSDSManager#updateStatusActive: called");
        this.hmiListener.updateSDSStatusActive();
    }

    private void notifySessionStarted() {
        ISDSApplication[] iSDSApplicationArray = this.sdsDispatcher.getRegisteredApplications();
        if (iSDSApplicationArray == null) {
            this.lc.log(10000, "AppSDSManager#notifySessionStarted: No applications found!");
            return;
        }
        int n = iSDSApplicationArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            iSDSApplicationArray[i2].sessionStarted();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyExternalListenersSessionStarted() {
        Object object = this.statusListenersMutex;
        synchronized (object) {
            Iterator iterator = this.statusListeners.iterator();
            while (iterator.hasNext()) {
                ((ISDSServiceStatusListener)iterator.next()).notifySDSDialogStarted();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyExternalListenersSessionEnded() {
        Object object = this.statusListenersMutex;
        synchronized (object) {
            Iterator iterator = this.statusListeners.iterator();
            while (iterator.hasNext()) {
                ((ISDSServiceStatusListener)iterator.next()).notifySDSDialogEnded();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyExternalListenersSessionAborting() {
        Object object = this.statusListenersMutex;
        synchronized (object) {
            Iterator iterator = this.statusListeners.iterator();
            while (iterator.hasNext()) {
                ((ISDSServiceStatusListener)iterator.next()).notifySDSDialogAborting();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyExternalSDSKeyListeners(int n) {
        Object object = this.sdsKeyListenersMutex;
        synchronized (object) {
            Iterator iterator = this.sdsKeyListeners.iterator();
            block9: while (iterator.hasNext()) {
                ISDSKeyInterceptor iSDSKeyInterceptor = (ISDSKeyInterceptor)iterator.next();
                switch (n) {
                    case 0: {
                        iSDSKeyInterceptor.pttPressed();
                        continue block9;
                    }
                    case 1: {
                        iSDSKeyInterceptor.pttReleasedAfterShortPress();
                        continue block9;
                    }
                    case 2: {
                        iSDSKeyInterceptor.pttLongDetected();
                        continue block9;
                    }
                    case 3: {
                        iSDSKeyInterceptor.pttReleasedAfterLongPress();
                        continue block9;
                    }
                }
                this.lc.log(100000, "AppSDSManager#notifySDSKeyListeners: Unknown methodId=%1 -> NOP!", (long)n);
            }
        }
    }

    private void notifyFreeze(boolean bl) {
        this.lc.log(10000000, "AppSDSManager#notifyFreeze: status=%1!", bl);
        ISDSApplication[] iSDSApplicationArray = this.sdsDispatcher.getRegisteredApplications();
        if (iSDSApplicationArray == null) {
            this.lc.log(10000, "AppSDSManager#notifyFreeze: No applications found!");
            return;
        }
        boolean bl2 = true;
        int n = iSDSApplicationArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl3 = bl2 = bl ? iSDSApplicationArray[i2].freezeLists() : iSDSApplicationArray[i2].unfreezeLists();
            if (bl2) continue;
            this.lc.log(100000, "AppSDSManager#notifyFreeze: %1reeze failed, %1 aborting session!", (Object)(bl ? "F" : "Unf"), (Object)(bl ? "" : "but NOT "));
            if (!bl) break;
            this.abortSDSSession();
            break;
        }
    }

    public void endSession() {
        this.lc.log(10000000, "AppSDSManager#endSession: called");
        if (!this.isSDSPauseStateActive()) {
            this.notifySessionEnded();
        }
        this.notifyFreeze(false);
    }

    public void updateStatusInactive() {
        this.lc.log(10000000, "AppSDSManager#updateStatusInactive: called");
        this.hmiListener.updateSDSStatusInactive(this.isSDSPauseStateActive(), true);
    }

    private void notifySessionEnded() {
        ISDSApplication[] iSDSApplicationArray = this.sdsDispatcher.getRegisteredApplications();
        if (iSDSApplicationArray == null) {
            this.lc.log(10000, "AppSDSManager#notifySessionEnded: No applications found!");
            return;
        }
        int n = iSDSApplicationArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            try {
                iSDSApplicationArray[i2].sessionEnded();
                continue;
            }
            catch (Exception exception) {
                this.lc.log(10000000, "AppSDSManager#notifySessionEnded: Exception in %1!", (Object)iSDSApplicationArray[i2], (Throwable)exception);
            }
        }
    }

    private void notifyVolumeSettingSessionCallback() {
        if (this.volumeSettingSessionCallback != null) {
            this.volumeSettingSessionCallback.callback();
            this.volumeSettingSessionCallback = null;
        }
    }

    public byte getPTTBlocked() {
        this.lc.log(10000000, "getPTTBlocked: pttBlocked=%1", (long)this.pttBlocked);
        return this.pttBlocked;
    }

    public boolean isPTTBlocked() {
        this.lc.log(10000000, "AppSDSManager#isPTTBlocked: pttBlocked=%1", (long)this.pttBlocked);
        return this.pttBlocked != 0;
    }

    public boolean isExternalSDSRequested() {
        return this.externalSDSRequested;
    }

    public void setExternalSDSRequested(boolean bl) {
        this.lc.log(10000000, "AppSDSManager#setExternalSDSRequested: value=%1", bl);
        this.externalSDSRequested = bl;
    }

    public byte getWaitStateStatus() {
        return this.waitStateStatus;
    }

    public void setWaitStateStatus(byte by) {
        this.lc.log(10000000, "AppSDSManager#setWaitStateStatus: status=%1", (long)by);
        this.waitStateStatus = by;
    }

    public void triggerSDSPauseState(boolean bl, boolean bl2) {
        this.lc.log(10000000, "AppSDSManager#triggerSDSPauseState: value=%1", bl);
        this.sdsPauseStateActive = bl;
        if (bl) {
            this.sdsAdapter.removeSDSProgressIcon();
            this.hmiListener.updateSDSStatusPause(true);
        } else if (!this.isSDSWaitStateActive()) {
            this.hmiListener.updateSDSStatusPause(false);
        }
        if (bl2) {
            this.sdsPopupHelper.triggerSpeechPopup(1, bl);
        }
    }

    public void checkAbortingAndTriggerWaitState() {
        SystemSDSHandler systemSDSHandler = this.sdsAppFactory.getSDSHandlerSystem();
        boolean bl = systemSDSHandler.abortCurrentRecognition((byte)4, true, -1);
        boolean bl2 = systemSDSHandler.abortCurrentPrompt((byte)4, false, -1);
        this.lc.log(10000000, "AppSDSManager#checkAbortingAndTriggerWaitState: Current recognition is %1being aborted, current prompt is %2being aborted!", (Object)(bl ? "" : "NOT "), (Object)(bl2 ? "" : "NOT "));
        if (bl || bl2) {
            this.setWaitStateStatus((byte)1);
        } else {
            this.triggerSDSWaitState(true, true);
        }
    }

    public void triggerSDSWaitState(boolean bl, boolean bl2) {
        this.lc.log(10000000, "AppSDSManager#triggerSDSWaitState: value=%1, handlePopup=%2", bl, bl2);
        this.setWaitStateStatus(bl ? (byte)2 : 0);
        this.sdsAdapter.triggerWaitStateAbortTimer(bl);
        this.hmiListener.updateSDSStatusPause(bl);
        if (bl2) {
            this.sdsPopupHelper.triggerSpeechPopup(3, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetDialogFlags() {
        Object object = this.dialogFlagsResetterMutex;
        synchronized (object) {
            if (!this.isSecondCallToResetDialogFlags) {
                this.isSecondCallToResetDialogFlags = true;
                return;
            }
            this.isSecondCallToResetDialogFlags = false;
        }
        this.lc.log(10000000, "AppSDSManager#resetDialogFlags: called");
        this.sdsAppFactory.getSDSHandlerNavi().setAIFCountry(false);
        this.ttsHandler.resetPromptType();
        this.setSDSAborting(false);
        this.setSDSActive(false);
        this.setAbortEventTriggered(false);
        this.setWaitStateStatus((byte)0);
        this.sdsPopupHelper.setLogicalPopupRemovedBySDS(false);
        this.setExternalSDSRequested(false);
        this.sdsTimeoutHandler.cancelSDSSessionAbortingTTSTimer();
        this.sdsAdapter.setSDSVolumeSettingActive(false);
        this.sdsAdapter.setSDSNumberDialingActive(false);
        this.sdsAdapter.removeSDSProgressIcon();
        this.sdsAdapter.setPttRunning(false);
        SDSModelAccess.setDialogJumpingModel(0);
        SDSModelAccess.setSDSAborterType(-1);
        SDSModelAccess.setSmallCommandDisplayVisible(0);
        SDSModelAccess.setSDSLogicalPopup(0);
        this.notifyExternalListenersSessionEnded();
        this.notifyVolumeSettingSessionCallback();
        this.changeTracingStatus(false);
    }

    public boolean isSDSSpeechPopupActive() {
        return this.sdsSpeechPopupActive;
    }

    public void setSDSSpeechPopupActive(boolean bl) {
        this.lc.log(10000000, "AppSDSManager#setSDSSpeechPopupActive: value=%1", bl);
        this.sdsSpeechPopupActive = bl;
    }

    public boolean isSDSActive() {
        return this.sdsActive;
    }

    public void setSDSActive(boolean bl) {
        boolean bl2 = this.sdsActive;
        this.sdsActive = bl;
        this.lc.log(10000000, "AppSDSManager#setSDSActive: old value=%1, new value=%2", bl2, bl);
        if (!bl2 && bl) {
            this.hmiListener.updateSDSRecogStatus(false, false);
        }
    }

    public boolean isExternalSDSActive() {
        return this.mobileSRHandler.isMobileSpeechRecognitionActive();
    }

    public void setRecognition(boolean bl) {
        this.lc.log(10000000, "AppSDSManager#setRecognition: active=%1, sdsWaitStateActive=%2", bl, this.isSDSWaitStateActive());
        this.hmiListener.updateSDSRecogStatus(bl, this.isSDSWaitStateActive());
        ISDSApplication iSDSApplication = this.sdsDispatcher.getActiveApplication();
        if (iSDSApplication != null) {
            iSDSApplication.recognizerOpen(bl);
        }
    }

    public boolean isSDSPauseStateActive() {
        return this.sdsPauseStateActive;
    }

    public boolean isSDSWaitStateActive() {
        return this.waitStateStatus == 2;
    }

    public boolean isSDSAborting() {
        return this.sdsAborting;
    }

    public void setSDSAborting(boolean bl) {
        this.lc.log(10000000, "AppSDSManager#setSDSAborting: value=%1", bl);
        this.sdsAborting = bl;
    }

    public void setPttBlocked(byte by) {
        this.pttBlocked = by;
    }

    public void setSDSHMIListener(SDSHMIListener sDSHMIListener) {
        this.hmiListener = sDSHMIListener;
    }

    void setSDSAdapter(SDSAdapter sDSAdapter) {
        this.sdsAdapter = sDSAdapter;
    }

    public int getDialogContext() {
        return this.dialogContext;
    }

    public void setDialogContext(int n) {
        this.lc.log(10000000, "AppSDSManager#setDialogContext: value=%1", (long)n);
        this.dialogContext = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        Object object = this.statusListenersMutex;
        synchronized (object) {
            this.statusListeners.add(iSDSServiceStatusListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        Object object = this.statusListenersMutex;
        synchronized (object) {
            this.statusListeners.remove(iSDSServiceStatusListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerSDSKeyInterceptor(ISDSServiceStatusListener iSDSServiceStatusListener) {
        Object object = this.sdsKeyListenersMutex;
        synchronized (object) {
            this.sdsKeyListeners.add(iSDSServiceStatusListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterSDSKeyInterceptor(ISDSServiceStatusListener iSDSServiceStatusListener) {
        Object object = this.sdsKeyListenersMutex;
        synchronized (object) {
            this.sdsKeyListeners.remove(iSDSServiceStatusListener);
        }
    }

    public boolean isConnectedScreenScollable(int n) {
        return this.connectedScreenIDIsScrollablePair.isScreenScrollable(n);
    }

    public void updateConnectedScreenScrollable(int n, int n2, boolean bl) {
        this.connectedScreenIDIsScrollablePair.setPairValues(n, bl);
    }

    public SDSService.ScreenConnectedSDSData getScreenConnectedSDSData(int n) {
        return this.connectedSDSScreenIDWithSDSDataPair.getSDSData(n);
    }

    public void updateConnectedScreenWithSDSData(int n, int n2, SDSService.ScreenConnectedSDSData screenConnectedSDSData) {
        this.connectedSDSScreenIDWithSDSDataPair.setPairValues(n, screenConnectedSDSData);
    }

    public void setSDSTimeoutHandler(SDSTimeoutHandler sDSTimeoutHandler) {
        this.sdsTimeoutHandler = sDSTimeoutHandler;
    }

    public boolean isAbortEventTriggered() {
        return this.abortEventTriggered;
    }

    public void setAbortEventTriggered(boolean bl) {
        this.abortEventTriggered = bl;
    }

    public void setFactory(SDSAppFactory sDSAppFactory) {
        this.sdsAppFactory = sDSAppFactory;
    }

    public void setCallback(VolumeSettingSessionCallback volumeSettingSessionCallback) {
        this.volumeSettingSessionCallback = volumeSettingSessionCallback;
    }

    public synchronized void changeTracingStatus(boolean bl) {
        if (bl) {
            this.sdsAdapter.getFramework().activateTracingPreset("speech_system::speech-dialog");
            this.lc.log(1000000, "AppSDSManager#changeTracingStatus: started logging presets");
        } else {
            this.lc.log(1000000, "AppSDSManager#changeTracingStatus: stopping logging presets");
            this.sdsAdapter.getFramework().activateTracingPreset("speech_system::speech-nodialog");
        }
    }

    private class ConnectedScreenIDWithSDSDataPair {
        private int screenID = -1;
        private SDSService.ScreenConnectedSDSData data = null;

        private ConnectedScreenIDWithSDSDataPair() {
        }

        private void setPairValues(int n, SDSService.ScreenConnectedSDSData screenConnectedSDSData) {
            this.screenID = n;
            this.data = screenConnectedSDSData;
        }

        private SDSService.ScreenConnectedSDSData getSDSData(int n) {
            if (n == -1 || this.screenID != n) {
                AppSDSManager.this.lc.log(100000, "AppSDSManager.ConnectedScreenIDWithSDSDataPair#getSDSData: given screenID %1 != %2 saved screenID => return null!", (long)n, (long)this.screenID);
                return null;
            }
            return this.data;
        }
    }

    private class ConnectedScreenIDIsScrollablePair {
        private int screenID = -1;
        private boolean isScrollable = false;

        private ConnectedScreenIDIsScrollablePair() {
        }

        private void setPairValues(int n, boolean bl) {
            this.screenID = n;
            this.isScrollable = bl;
        }

        private boolean isScreenScrollable(int n) {
            if (n == -1 || this.screenID != n) {
                AppSDSManager.this.lc.log(100000, "AppSDSManager.ConnectedScreenIDIsScrollablePair#isScreenScrollable: given screenID != saved screenID => return false!");
                return false;
            }
            return this.isScrollable;
        }
    }
}

