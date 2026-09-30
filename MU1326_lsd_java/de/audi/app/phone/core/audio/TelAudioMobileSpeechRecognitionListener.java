/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.app.phone.core.audio.TelSDSHandler;
import de.audi.app.phone.core.audio.TelWidebandSpeechHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.terminalmode.CallStateChanged;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener;

class TelAudioMobileSpeechRecognitionListener
extends AbstractPhoneComponent
implements DSIMobileSpeechRecognitionListener,
IPhoneDiagComponent,
ITerminalModeUpdateListener {
    private final Timer deactivationTimer;
    private volatile DSIMobileSpeechRecognition dsiMobileSpeechRecognition;
    private DSIActivator dsiMobileSpeechRecognitionActivator;
    private final TelAudioCmdManager cmdManager;
    private final PhoneServiceProvider terminalModeUpdateListnerService;
    private volatile boolean terminalModeActive;
    private volatile boolean isExternSDSActive = false;
    private final TelWidebandSpeechHandler widebandSpeechHandler;
    private IGlobalTelephoneStateStruct struct;
    private volatile boolean externSpeechAudioActivated = false;
    private volatile TelSDSHandler telSDSHandler;
    private final int[] supportedExternSpeechApps;
    private volatile int currentSpeechRecognitionType = 0;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    private static boolean isTelSIMMode(int n) {
        return n == 0 || n == 2 || n == 1;
    }

    public TelAudioMobileSpeechRecognitionListener(ITelApplication iTelApplication, TelAudioCmdManager telAudioCmdManager, TelWidebandSpeechHandler telWidebandSpeechHandler, int[] nArray) {
        super(iTelApplication, "App.Phone.Audio");
        this.supportedExternSpeechApps = nArray;
        this.cmdManager = telAudioCmdManager;
        this.widebandSpeechHandler = telWidebandSpeechHandler;
        this.dsiMobileSpeechRecognitionActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition = TelAudioMobileSpeechRecognitionListener.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognition")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition).getName(), (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener = TelAudioMobileSpeechRecognitionListener.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener).getName(), new Integer(0), this, new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
                if (dSIBase instanceof DSIMobileSpeechRecognition) {
                    TelAudioMobileSpeechRecognitionListener.this.dsiMobileSpeechRecognition = (DSIMobileSpeechRecognition)dSIBase;
                } else {
                    TelAudioMobileSpeechRecognitionListener.this.dsiMobileSpeechRecognition = null;
                }
            }

            public int[] getAutoNotifications() {
                return new int[]{2, 1, 3};
            }
        });
        this.deactivationTimer = new Timer("MobileSpeechRecognitionAudioDeactivationTimer", 3000L, true, new TimerListener(){

            public void fireTimer(Timer timer) {
                TelAudioMobileSpeechRecognitionListener.this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener.TelAudioMobileSpeechRecognitionListener(...).new TimerListener() {...}#fireTimer(): mobileSpeechRecognition is not active - releasing audio connections.");
                TelAudioMobileSpeechRecognitionListener.this.setExternSDSActive(false);
            }

            public void cancelTimer(Timer timer) {
                TelAudioMobileSpeechRecognitionListener.this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener.TelAudioMobileSpeechRecognitionListener(...).new TimerListener() {...}#cancelTimer(): ");
            }
        });
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TelAudioMobileSpeechRecognitionListener.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this, null, iTelApplication.getBundleContext(), this.log);
        this.getApplication().addDiagnosisComponent(this);
        this.telSDSHandler = new TelSDSHandler(iTelApplication);
        this.addSubPhoneComponent(this.telSDSHandler);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.dsiMobileSpeechRecognitionActivator.start(this.getApplication().getBundleContext());
        this.terminalModeUpdateListnerService.startService();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.dsiMobileSpeechRecognitionActivator.stop(this.getApplication().getBundleContext());
        this.terminalModeUpdateListnerService.stopService();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.struct = iGlobalTelephoneStateStruct;
        if (n == 65550 || n == 131086) {
            this.checkExternalSpeechActivation(iGlobalTelephoneStateStruct);
        }
    }

    private void checkExternalSpeechActivation(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (!this.isCurrentAvailableExternSpeechTypeSupported()) {
            this.log.log(10000000, "[TelAudioMobileSpeechRecognitionListener#checkExternalSpeechActivation] current speech type not supported by the system --> NOP!");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000000, "[TelAudioMobileSpeechRecognitionListener#checkExternalSpeechActivation] stateStruct is null --> NOP!");
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getPrimaryDeviceState();
        if (iTelDSIMobileEquipmentDeviceState == null) {
            this.log.log(10000000, "[TelAudioMobileSpeechRecognitionListener#checkExternalSpeechActivation] primaryDevice is null --> NOP!");
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState2 == null) {
            this.log.log(10000000, "[TelAudioMobileSpeechRecognitionListener#checkExternalSpeechActivation] callLeadingDevice is null --> NOP!");
            return;
        }
        boolean bl = iTelDSIMobileEquipmentDeviceState2 != null && iTelDSIMobileEquipmentDeviceState2.getCallState() != null ? iTelDSIMobileEquipmentDeviceState2.getCallState().isIdle() : true;
        this.processWidebandSpeech(iGlobalTelephoneStateStruct, bl);
        int n = iTelDSIMobileEquipmentDeviceState.getHandsFreeMode();
        int n2 = iTelDSIMobileEquipmentDeviceState.getTelMode();
        this.determineExternMobileSpeechActive(n2, n, bl);
    }

    private void determineExternMobileSpeechActive(int n, int n2, boolean bl) {
        if (bl && this.isExternSDSActive() && !TelAudioMobileSpeechRecognitionListener.isTelSIMMode(n) && n2 == 0 && !this.externSpeechAudioActivated) {
            this.log.log(1000000, "[TelAudioMobileSpeechRecognitionListener#determineExternMobileSpeechActive] Extern SDS active -> request Audio channels");
            this.cmdManager.scheduleMobileSpeechRecognition(true);
            this.externSpeechAudioActivated = true;
            this.telSDSHandler.updateExternalSDSActive();
        } else if (bl && !this.isExternSDSActive() && !TelAudioMobileSpeechRecognitionListener.isTelSIMMode(n) && n2 == 4 && this.externSpeechAudioActivated) {
            this.log.log(1000000, "[TelAudioMobileSpeechRecognitionListener#determineExternMobileSpeechActive] Extern SDS NOT active -> release Audio channels");
            this.cmdManager.scheduleMobileSpeechRecognition(false);
            this.externSpeechAudioActivated = false;
        } else {
            this.log.log(1000000, "[TelAudioMobileSpeechRecognitionListener#determineExternMobileSpeechActive] Else use case.");
        }
    }

    private synchronized void processWidebandSpeech(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, boolean bl) {
        if (bl) {
            this.widebandSpeechHandler.setWidebandSpeech(iGlobalTelephoneStateStruct.getPrimaryDeviceState(), bl, false);
        } else {
            this.log.log(1000000, "[TelAudioMobileSpeechRecognitionListener#processWidebandSpeech] Call state is not Idle, do not change widebandspeech");
        }
    }

    private boolean isCurrentAvailableExternSpeechTypeSupported() {
        for (int i2 = 0; i2 < this.supportedExternSpeechApps.length; ++i2) {
            if (this.supportedExternSpeechApps[i2] != this.currentSpeechRecognitionType) continue;
            return true;
        }
        return false;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "TelAudioMobileSpeechRecognitionListener#asyncException(): errorMsg=%1", (Object)string);
    }

    public void updateSpeechRecognitionAvailable(int n, int n2) {
        if (n2 == 1) {
            this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener#updateSpeechRecognitionAvailable(): available=%1", (long)n);
            if (n == 0 || n == 2) {
                this.setExternSDSActive(false);
                this.externSpeechAudioActivated = false;
                this.cmdManager.scheduleMobileSpeechRecognition(false);
            }
        }
    }

    public void updateSpeechRecognitionActive(int n, int n2) {
        if (n2 == 1) {
            boolean bl;
            this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener#updateSpeechRecognitionActive(): active=%1", (long)n);
            boolean bl2 = bl = n == 1;
            if (this.terminalModeActive && bl) {
                this.log.log(1000000, "[TelAudioMobileSpeechRecognitionListener#updateSpeechRecognitionActive] terminal mode is active --> NOP!");
                return;
            }
            if (bl) {
                this.deactivationTimer.cancel();
                this.setExternSDSActive(true);
            } else if (!this.deactivationTimer.isRunning()) {
                this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener#updateSpeechRecognitionActive(): starting deactivation timer");
                this.deactivationTimer.start();
            }
        }
    }

    public void updateSpeechRecognitionType(int n, int n2) {
        if (n2 == 1) {
            this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener#updateSpeechRecognitionType(): type=%1", (long)n);
            this.currentSpeechRecognitionType = n;
        }
    }

    public void responseStartSpeechRecognition(int n) {
        this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener#responseStartSpeechRecognition(): result=%1", (long)n);
    }

    public void responseStopSpeechRecognition(int n) {
        this.log.log(1000000, "TelAudioMobileSpeechRecognitionListener#responseStopSpeechRecognition(): result=%1", (long)n);
    }

    public void cmdUpdateSpeechRecognitionActive(boolean bl) {
        this.updateSpeechRecognitionActive(bl ? 1 : 0, 1);
    }

    public void cmdRequestStartMobileSpeechRecognition() {
        DSIMobileSpeechRecognition dSIMobileSpeechRecognition = this.dsiMobileSpeechRecognition;
        if (dSIMobileSpeechRecognition != null) {
            dSIMobileSpeechRecognition.requestStartSpeechRecognition();
        }
    }

    public void cmdRequestStopMobileSpeechRecognition() {
        DSIMobileSpeechRecognition dSIMobileSpeechRecognition = this.dsiMobileSpeechRecognition;
        if (dSIMobileSpeechRecognition != null) {
            dSIMobileSpeechRecognition.requestStopSpeechRecognition();
        }
    }

    public void updateAppStates(TerminalModeAppState[] terminalModeAppStateArray) {
    }

    public void updateDeviceList(TerminalModeDevice[] terminalModeDeviceArray) {
    }

    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        this.log.log(1000000, "[TelAudioMobileSpeechRecognitionListener#updateActiveDeviceState] pActiveDevice=%1", (Object)terminalModeDevice);
        this.terminalModeActive = terminalModeDevice != null ? terminalModeDevice.isActive() : false;
    }

    public synchronized boolean isExternSDSActive() {
        return this.isExternSDSActive;
    }

    public synchronized void setExternSDSActive(boolean bl) {
        this.isExternSDSActive = bl;
        this.checkExternalSpeechActivation(this.struct);
    }

    public void updateAudioConnectionUsage(TerminalModeAudioUsage terminalModeAudioUsage) {
    }

    public void updateTMVideoFocus(boolean bl) {
    }

    public void updateCallState(CallStateChanged[] callStateChangedArray) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

