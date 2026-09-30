/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelComponent;
import de.audi.app.phone.core.audio.ITelAudio;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.app.phone.core.audio.TelAudioMobileSpeechRecognitionListener;
import de.audi.app.phone.core.audio.TelAutomaticAudioTransferHandler;
import de.audi.app.phone.core.audio.TelDefaultHMIAudioServiceListener;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler;
import de.audi.app.phone.core.audio.TelRingtoneManager;
import de.audi.app.phone.core.audio.TelSDSHandler;
import de.audi.app.phone.core.audio.TelWidebandSpeechHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.interapp.TelMuteMicServiceImpl;
import de.audi.app.phone.core.interapp.TelServiceAudioImpl;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.model.TelDefaultChoiceListener;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

public class TelAudioScenarioHandler
extends AbstractPhoneComponent
implements ITelAudio {
    private final TelAudioCmdManager cmdManager;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private volatile int previousAudioScenario = 0;
    private volatile int currentAudioScenario = 0;
    private final TelRingtoneManager ringtoneManager;
    protected volatile boolean ringtoneMuteSettingOn;
    private volatile TelSDSHandler telSDSHandler;
    private ToggleMicMuteButtonListner toggleMicMuteButtonListener;
    private MicMuteChoiceListener micMuteChoiceListener;
    private RingtoneMuteChoiceListener ringtoneMuteChoiceListener;
    private final TelWidebandSpeechHandler widebandSpeechHandler;
    private volatile boolean amAvailable;
    private boolean initialCallLeadingWBSUpdateReceived = false;

    private static boolean isTelSIMMode(int n) {
        return n == 0 || n == 2 || n == 1;
    }

    public TelAudioScenarioHandler(ITelApplication iTelApplication, TelRingtoneManager telRingtoneManager, int[] nArray) {
        super(iTelApplication, "App.Phone.Audio");
        this.addSubPhoneComponent(new TelServiceAudioImpl(iTelApplication));
        this.addSubPhoneComponent(this.createTelMicrophoneGainLevelHandler(iTelApplication));
        this.addSubPhoneComponent(new AudioServiceListener(iTelApplication));
        this.addSubPhoneComponent(new FactoryResetHandler(iTelApplication));
        this.toggleMicMuteButtonListener = new ToggleMicMuteButtonListner(iTelApplication);
        this.addSubPhoneComponent(this.toggleMicMuteButtonListener);
        this.micMuteChoiceListener = new MicMuteChoiceListener(iTelApplication);
        this.addSubPhoneComponent(this.micMuteChoiceListener);
        this.ringtoneMuteChoiceListener = new RingtoneMuteChoiceListener(iTelApplication);
        this.addSubPhoneComponent(this.ringtoneMuteChoiceListener);
        this.addSubPhoneComponent(new TelAutomaticAudioTransferHandler(iTelApplication));
        this.telSDSHandler = new TelSDSHandler(iTelApplication);
        this.addSubPhoneComponent(this.telSDSHandler);
        this.cmdManager = new TelAudioCmdManager(iTelApplication);
        this.ringtoneManager = telRingtoneManager;
        this.ringtoneManager.setCommandManager(this.cmdManager);
        this.widebandSpeechHandler = new TelWidebandSpeechHandler(iTelApplication, this.cmdManager);
        this.addSubPhoneComponent(this.widebandSpeechHandler);
        this.addSubPhoneComponent(new TelMuteMicServiceImpl(iTelApplication));
        if (Boolean.getBoolean("externalSDS")) {
            this.addSubPhoneComponent(new TelAudioMobileSpeechRecognitionListener(iTelApplication, this.cmdManager, this.widebandSpeechHandler, nArray));
        }
    }

    protected ITelComponent createTelMicrophoneGainLevelHandler(ITelApplication iTelApplication) {
        return new TelMicrophoneGainLevelHandler(iTelApplication);
    }

    public void init() {
        long l = this.getApplication().getFrameworkAccess().getMonotonicTime();
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.cmdManager.init();
        this.ringtoneManager.init();
        this.getApplication().getStartupLogChannel().log(1000000, "[TelAudioScenarioHandler#init] done in %1 ms", this.getApplication().getFrameworkAccess().getMonotonicTime() - l);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.cmdManager.deinit();
        this.ringtoneManager.deinit();
        this.initialCallLeadingWBSUpdateReceived = false;
    }

    ToggleMicMuteButtonListner getToggleMicMuteButtonListener() {
        return this.toggleMicMuteButtonListener;
    }

    RingtoneMuteChoiceListener getRingtoneMuteChoiceListener() {
        return this.ringtoneMuteChoiceListener;
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (n == 65544 || n == 65550 || n == 65553 || n == 131080 || n == 131086 || n == 131089 || n == 196616 || n == 196622 || n == 196625 || n == 65568 || n == 131104 || n == 196640) {
            this.updateAudioScenario(iGlobalTelephoneStateStruct);
        }
    }

    private boolean initialCallLeadingWBSUpdateReceived(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, int n) {
        boolean bl = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice().isRolePrimary() && n == 65568;
        boolean bl2 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice().isRoleAssociated() && n == 131104;
        boolean bl3 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice().isRoleData() && n == 196640;
        this.initialCallLeadingWBSUpdateReceived = bl || bl2 || bl3;
        return this.initialCallLeadingWBSUpdateReceived;
    }

    private synchronized boolean processWidebandSpeech(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, boolean bl) {
        if (iTelDSIMobileEquipmentDeviceState == null) {
            this.log.log(10000000, "[TelAudioScenarioHandler#processWidebandSpeech] callLeadingDeviceState is null --> NOP!");
            return false;
        }
        boolean bl2 = iTelDSIMobileEquipmentDeviceState.getCallState() != null ? iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() : true;
        return this.widebandSpeechHandler.setWidebandSpeech(iTelDSIMobileEquipmentDeviceState, bl2, bl);
    }

    private void updateAudioScenario(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "TelAudioScenarioHandler#updateAudioScenario stateStruct is null");
            return;
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        if (iTelDSIMobileEquipmentDeviceState == null) {
            this.log.log(10000000, "[TelAudioScenarioHandler#updateAudioScenario] callLeadingDevice is null --> NOP!");
            return;
        }
        CallStateStruct callStateStruct = iTelDSIMobileEquipmentDeviceState.getCallState();
        if (callStateStruct == null) {
            this.log.log(100000, "[TelAudioScenarioHandler#updateAudioScenario] call state is null --> NOP!");
            return;
        }
        int n = iTelDSIMobileEquipmentDeviceState.getHandsFreeMode();
        int n2 = iTelDSIMobileEquipmentDeviceState.getTelMode();
        int n3 = iTelDSIMobileEquipmentDeviceState.getmICMuteState();
        boolean bl = iTelDSIMobileEquipmentDeviceState.inbandRingingSupported();
        this.previousAudioScenario = this.currentAudioScenario;
        this.setCurrentAudioScenario(this.determineNewAudioScenario(this.getCurrentAudioScenario(), callStateStruct, n, n2, n3, bl));
        this.triggerAudioScenario(false);
        this.telSDSHandler.checkPauseResumeSDS(callStateStruct);
    }

    private int determineNewAudioScenario(int n, CallStateStruct callStateStruct, int n2, int n3, int n4, boolean bl) {
        if (callStateStruct == null) {
            this.log.log(1000000, "[TelAudioScenarioHandler#determineNewAudioScenario] call state is null --> returning currentAudioScenario %1", (long)n);
            return n;
        }
        int n5 = n;
        int n6 = callStateStruct.getMpCallState();
        if (n6 == 0) {
            n5 = 0;
        } else if (n6 == 15) {
            n5 = this.computeNewAudioScenarioForCallStateRinging(n, n2, bl, n5);
        } else if (n6 == 3 && this.getCurrentAudioScenario() == 5) {
            this.log.log(10000000, "TelAudioScenarioHandler#determineNewAudioScenario(): Disconnecting and RINGING_MUTE");
            n5 = n;
        } else {
            n5 = this.computeNewAudioScenarioForCallStaleActive(n, callStateStruct, n2, n3, n4);
        }
        this.log.log(1000000, "[TelAudioScenarioHandler#determineNewAudioScenario] returning current audio scenario %1", (long)n);
        return n5;
    }

    private int computeNewAudioScenarioForCallStaleActive(int n, CallStateStruct callStateStruct, int n2, int n3, int n4) {
        int n5;
        boolean bl;
        boolean bl2 = TelAudioScenarioHandler.isTelSIMMode(n3);
        boolean bl3 = bl = n4 == 0;
        if (this.isOperatorOrEmergencyCallPerNadModule(callStateStruct) && n3 != 3) {
            n5 = bl ? 7 : 6;
        } else if (bl2) {
            switch (n2) {
                case 0: {
                    n5 = bl ? 7 : 6;
                    break;
                }
                case 1: {
                    n5 = bl ? 9 : 8;
                    break;
                }
                case 2: {
                    n5 = bl ? 11 : 10;
                    break;
                }
                default: {
                    this.log.log(1000000, "[TelAudioScenarioHandler#computeNewAudioScenarioForCallStaleActive] invalid hansfreemode for sim usage %1", (long)n2);
                    n5 = n;
                    break;
                }
            }
        } else {
            switch (n2) {
                case 0: {
                    n5 = bl ? 13 : 12;
                    break;
                }
                case 4: {
                    n5 = bl ? 15 : 14;
                    break;
                }
                default: {
                    this.log.log(1000000, "[TelAudioScenarioHandler#computeNewAudioScenarioForCallStaleActive] invalid hansfreemode for HFP usage %1", (long)n2);
                    n5 = n;
                }
            }
        }
        return n5;
    }

    private int computeNewAudioScenarioForCallStateRinging(int n, int n2, boolean bl, int n3) {
        if (this.ringtoneMuteSettingOn) {
            this.log.log(10000000, "[TelAudioScenarioHandler#computeNewAudioScenarioForCallStateRinging] ringtone mute setting is on");
            n3 = 5;
        } else if (n == 5) {
            this.log.log(10000000, "[TelAudioScenarioHandler#computeNewAudioScenarioForCallStateRinging] ringtone mute was activated by user.");
            n3 = 5;
        } else if (bl) {
            switch (n2) {
                case 0: {
                    n3 = 1;
                    break;
                }
                case 4: {
                    n3 = 2;
                    break;
                }
                default: {
                    this.log.log(100000, "[TelAudioScenarioHandler#computeNewAudioScenarioForCallStateRinging] unsupported handsfree mode %1 with inband ringing", (long)n2);
                    break;
                }
            }
        } else {
            n3 = this.ringtoneManager.isIndividualRingtoneSelected() ? 4 : 3;
        }
        return n3;
    }

    boolean isOperatorOrEmergencyCallPerNadModule(CallStateStruct callStateStruct) {
        if (callStateStruct == null) {
            this.log.log(100000, "TelAudioScenarioHandler#isOperatorCallPerNadModule(): callState is NULL");
            return false;
        }
        return (callStateStruct.isHasOperatorCall() || callStateStruct.isHasEmergencyCall()) && this.isCurrentCountryUseNADForOperatorOrEmergencyCall();
    }

    private boolean isCurrentCountryUseNADForOperatorOrEmergencyCall() {
        return this.getApplication().getFrameworkAccess().getSysConst(442) == 2;
    }

    private void triggerAudioScenario(boolean bl) {
        int n;
        int n2;
        if (!this.isAmAvailable()) {
            this.log.log(100000, "[TelAudioScenarioHandler#triggerAudioScenario] AudioManagement not available --> NOP!");
            return;
        }
        boolean bl2 = false;
        if (this.telephoneState != null && this.telephoneState.getCallLeadingDevice() != null) {
            bl2 = this.processWidebandSpeech(this.telephoneState.getCallLeadingDevice(), bl);
            this.log.log(1000000, "[TelAudioScenarioHandler#triggerAudioScenario] widebandSpeechActivated=%1", bl2);
        }
        if ((n2 = this.currentAudioScenario) != (n = this.previousAudioScenario) || bl || bl2) {
            if (n == 5 && n2 != 5) {
                this.cmdManager.scheduleRingtoneMute(false);
            } else if (n == 3 && n2 != 3) {
                this.ringtoneManager.abortOutbandRinging();
            } else if (n == 4 && n2 != 4) {
                this.ringtoneManager.abortMediaRinging();
            }
            this.log.log(10000000, "[TelAudioScenarioHandler#triggerAudioScenario] audioScenario=%1", (long)n2);
            this.ringtoneManager.checkAbortRingtoneListPlayback();
            if (n2 == 3) {
                this.ringtoneManager.startOutbandRinging(this.getCallLeadingDeviceRole());
            } else if (n2 == 4) {
                this.ringtoneManager.startMediaRinging();
            } else if (n2 == 5) {
                this.cmdManager.scheduleRingtoneMute(true);
            } else if (n2 == 1) {
                this.cmdManager.scheduleInbandRingingHandsfree();
            } else if (n2 == 2) {
                this.cmdManager.scheduleInbandRingingPrivateHFP();
            } else {
                this.cmdManager.scheduleAudioScenario(n2);
            }
        } else {
            this.log.log(10000000, "[TelAudioScenarioHandler#triggerAudioScenario] audioScenario has not changed --> NOP! audioScenario: %1", (long)n2);
        }
    }

    private int getCallLeadingDeviceRole() {
        if (this.telephoneState != null && this.telephoneState.getCallLeadingDevice() != null) {
            return this.telephoneState.getCallLeadingDevice().getDeviceRole();
        }
        return 65536;
    }

    public void muteRingtone(boolean bl) {
        if (bl) {
            if (this.getCurrentAudioScenario() == 3) {
                this.ringtoneManager.abortOutbandRinging();
            } else if (this.getCurrentAudioScenario() == 4) {
                this.ringtoneManager.abortMediaRinging();
            }
            this.setCurrentAudioScenario(5);
            if (this.isAmAvailable()) {
                this.cmdManager.scheduleRingtoneMute(true);
            } else {
                this.log.log(100000, "[TelAudioScenarioHandler#muteRingtone] ringToneMuted=%1, AudioManagement not available", bl);
            }
        } else {
            if (this.isAmAvailable()) {
                this.cmdManager.scheduleRingtoneMute(false);
            } else {
                this.log.log(100000, "[TelAudioScenarioHandler#muteRingtone] ringToneMuted=%1, AudioManagement not available", bl);
            }
            this.updateAudioScenario(this.telephoneState);
        }
    }

    protected void ringtoneMuteSettingDisabled() {
        this.ringtoneMuteSettingOn = false;
        this.getChoiceModel(300455).setValue(0);
        this.getApplication().getGlobalTelephoneStateManager().updateRingtoneMuteSetting(false);
    }

    protected void ringtoneMuteSettingEnabled() {
        this.ringtoneMuteSettingOn = true;
        this.getChoiceModel(300455).setValue(1);
        this.getApplication().getGlobalTelephoneStateManager().updateRingtoneMuteSetting(true);
    }

    TelAudioCmdManager getCmdManager() {
        return this.cmdManager;
    }

    int getCurrentAudioScenario() {
        return this.currentAudioScenario;
    }

    protected void setCurrentAudioScenario(int n) {
        this.currentAudioScenario = n;
    }

    TelRingtoneManager getRingtoneManager() {
        return this.ringtoneManager;
    }

    public void switchMicMuteOff(int n) {
        this.getApplication().getTelephoneDSIAccess().requestSetMICMuteState(1, n);
    }

    public void switchMicMuteOn(int n) {
        this.getApplication().getTelephoneDSIAccess().requestSetMICMuteState(0, n);
    }

    public void toggelMicMuteState(int n) {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        if (iGlobalTelephoneStateStruct != null) {
            int n2 = iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getmICMuteState() : 1;
            this.getApplication().getTelephoneDSIAccess().requestSetMICMuteState(n2 == 1 ? 0 : 1, n);
        }
    }

    public boolean isAmAvailable() {
        return this.amAvailable;
    }

    public void setAmAvailable(boolean bl) {
        this.amAvailable = bl;
        this.widebandSpeechHandler.setAMAvailable(bl);
    }

    private class FactoryResetHandler
    extends AbstractTelMessageListener {
        public FactoryResetHandler(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 28);
        }

        protected void messageReceived() {
            this.log.log(1000000, "TelAudioScenarioHandler.FactoryResetHandler#messageRecieved(): called");
            TelAudioScenarioHandler.this.ringtoneMuteSettingDisabled();
        }
    }

    private class AudioServiceListener
    extends TelDefaultHMIAudioServiceListener {
        public AudioServiceListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Audio");
        }

        public void updateAMAvailable(boolean bl) {
            this.log.log(1000000, "[TelAudioScenarioHandler.AudioServiceListener#updateAMAvailable] currentAudioScenario=%2, available=%1", bl, (long)TelAudioScenarioHandler.this.currentAudioScenario);
            boolean bl2 = !TelAudioScenarioHandler.this.isAmAvailable() && bl && TelAudioScenarioHandler.this.currentAudioScenario != 0;
            TelAudioScenarioHandler.this.setAmAvailable(bl);
            if (bl2) {
                TelAudioScenarioHandler.this.triggerAudioScenario(true);
            }
        }
    }

    class MicMuteChoiceListener
    extends TelDefaultChoiceListener {
        public MicMuteChoiceListener(ITelApplication iTelApplication) {
            super(iTelApplication, 4346);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            this.log.log(10000000, "[MicMuteChoiceListener#itemSelected] modelID=%1, itemID=%2, column=%3", (long)n, (long)n2, (long)n3);
            if (n == 4346) {
                TelAudioScenarioHandler.this.toggelMicMuteState(n4);
            }
        }
    }

    class RingtoneMuteChoiceListener
    extends TelDefaultChoiceListener {
        public RingtoneMuteChoiceListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300455);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            this.log.log(10000000, "[RingtoneMuteChoiceListener#itemSelected] modelID=%1, itemID=%2, column=%3", (long)n, (long)n2, (long)n3);
            if (n == 300455) {
                if (n2 == 1) {
                    TelAudioScenarioHandler.this.ringtoneMuteSettingEnabled();
                } else {
                    TelAudioScenarioHandler.this.ringtoneMuteSettingDisabled();
                }
            }
        }
    }

    class ToggleMicMuteButtonListner
    extends TelDefaultButtonListener {
        public ToggleMicMuteButtonListner(ITelApplication iTelApplication) {
            super(iTelApplication, 301228);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[ToggleMicMuteButtonListner#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
            if (n == 301228) {
                TelAudioScenarioHandler.this.toggelMicMuteState(n3);
            }
        }
    }
}

