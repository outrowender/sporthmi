/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.audio.cmd.EcallAudioCmdDefaultListener;
import de.audi.app.ecall.core.audio.cmd.EcallAudioCmdManager;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdManager;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class EcallAudioScenarioHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    private static final int AUDIO_SCENARIO_NONE = 0;
    private volatile int currentAudioScenario = 0;
    private volatile IEcallAudioCmdManager ecallAudioCmdManager;
    private final AudioServiceListener audioServiceListener;
    private final MutePinListener mutePinListener;
    private volatile boolean hasActiveCustomerCall;

    public EcallAudioScenarioHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Audio");
        this.mutePinListener = new MutePinListener(iEcallApplication, 4628);
        this.audioServiceListener = new AudioServiceListener(iEcallApplication);
        this.ecallAudioCmdManager = new EcallAudioCmdManager(iEcallApplication, this.audioServiceListener, this.mutePinListener);
    }

    public void init() {
        super.init();
        this.getApplication().getEcallStateManager().registerListener(this);
        ((EcallAudioCmdManager)this.ecallAudioCmdManager).init();
    }

    public void deinit() {
        this.getApplication().getEcallStateManager().removeListener(this);
        if (this.ecallAudioCmdManager != null) {
            ((EcallAudioCmdManager)this.ecallAudioCmdManager).deinit();
        }
        super.deinit();
    }

    public IEcallAudioCmdManager getEcallAudioCmdManager() {
        return this.ecallAudioCmdManager;
    }

    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 2) {
            if (this.hasActiveCustomerCall != iEcallStateStruct.isActiveCustomerCallPresent()) {
                this.onCustomerCallStateChanged(iEcallStateStruct);
            }
            this.hasActiveCustomerCall = iEcallStateStruct.isActiveCustomerCallPresent();
        } else if (n == 5) {
            this.triggerAudioSource(iEcallStateStruct.getBapAudioSource(), false);
        }
    }

    protected IEcallComponent[] getSubComponents() {
        return new IEcallComponent[]{this.audioServiceListener, this.mutePinListener};
    }

    private void onCustomerCallStateChanged(IEcallStateStruct iEcallStateStruct) {
        if (iEcallStateStruct.isCallActive()) {
            this.log.log(1000000, "EcallAudioScenarioHandler#onCustomerCallStateChanged(): service is active. NOP.");
            return;
        }
        if (iEcallStateStruct.getBapAudioSource() == 3) {
            this.log.log(1000000, "EcallAudioScenarioHandler#onCustomerCallStateChanged(): bapAudioSource is ECALL 0x03. NOP");
            return;
        }
        if (iEcallStateStruct.getBapAudioSource() == 4) {
            this.log.log(1000000, "EcallAudioScenarioHandler#onCustomerCallStateChanged(): bapAudioSource is ECALL 0x04. NOP");
            return;
        }
        boolean bl = iEcallStateStruct.isActiveCustomerCallPresent();
        this.getApplication().getEcallBapServiceAdapter().sendMainUnitAudioSource(bl);
    }

    void forceTriggerAudioSource(int n) {
        this.triggerAudioSource(n, true);
    }

    private void triggerAudioSource(int n, boolean bl) {
        if (this.currentAudioScenario != n || bl) {
            this.currentAudioScenario = n;
            switch (n) {
                case 4: {
                    this.ecallAudioCmdManager.schedulePhoneEcallAudioScenario(n, this.hasActiveCustomerCall);
                    break;
                }
                case 3: {
                    this.ecallAudioCmdManager.schedulePhoneEcallHighAudioScenario(n);
                    break;
                }
                case 1: {
                    this.ecallAudioCmdManager.schedulePhoneVoiceHighAudioScenario(n);
                    break;
                }
                case 2: {
                    this.ecallAudioCmdManager.schedulePhoneVoiceLowAudioScenario(n);
                    break;
                }
                case 7: {
                    this.ecallAudioCmdManager.scheduleEcallMuteAudioScenario(n);
                    break;
                }
                case 0: {
                    this.ecallAudioCmdManager.scheduleReleaseAllConnections(this.hasActiveCustomerCall);
                    break;
                }
                default: {
                    this.log.log(10000000, "EcallAudioScenarioHandler#triggerAudioSource(): unsupported audioSource %1 ", (long)n);
                    break;
                }
            }
        } else {
            this.log.log(10000000, "EcallAudioScenarioHandler#triggerAudioSource(): audioSource has not changed --> NOP!");
        }
    }

    void setEcallAudioCmdManager(IEcallAudioCmdManager iEcallAudioCmdManager) {
        this.ecallAudioCmdManager = iEcallAudioCmdManager;
    }

    private class MutePinListener
    extends EcallAudioCmdDefaultListener {
        private final ChoiceModelApp mutePinActiveModel;
        private static final int MUTE_PIN_INACTIVE = 0;
        private static final int MUTE_PIN_ACTIVE = 1;

        public MutePinListener(IEcallApplication iEcallApplication, int n) {
            super(iEcallApplication);
            this.mutePinActiveModel = iEcallApplication.getFrameworkAccess().getHMIService().getChoiceModel(n);
        }

        public void updateMutePinState(boolean bl, int n) {
            this.log.log(1000000, "EcallAudioScenarioHandler.MutePinListener#updateMutePinState(): mutePinState=%1", bl);
            if (n != 1) {
                return;
            }
            if (this.isECallAudioActive()) {
                this.log.log(1000000, "EcallAudioScenarioHandler.MutePinListener#updateMutePinState(): ECALL active, do not release ECALL_MUTE!!!");
                return;
            }
            if (bl) {
                EcallAudioScenarioHandler.this.ecallAudioCmdManager.scheduleMutePinMuteRequest();
                this.mutePinActiveModel.setValue(1);
            } else {
                EcallAudioScenarioHandler.this.ecallAudioCmdManager.scheduleMutePinMuteRelease();
                this.mutePinActiveModel.setValue(0);
            }
        }

        private boolean isECallAudioActive() {
            return EcallAudioScenarioHandler.this.currentAudioScenario == 4 || EcallAudioScenarioHandler.this.currentAudioScenario == 3 || EcallAudioScenarioHandler.this.currentAudioScenario == 7;
        }
    }

    private class AudioServiceListener
    extends EcallAudioCmdDefaultListener {
        public AudioServiceListener(IEcallApplication iEcallApplication) {
            super(iEcallApplication);
        }

        public void updateAMAvailable(boolean bl) {
            this.log.log(1000000, "EcallAudioScenarioHandler.AudioServiceListener#updateAMAvailable(): available=%1", bl);
            if (bl && EcallAudioScenarioHandler.this.currentAudioScenario != 0) {
                EcallAudioScenarioHandler.this.forceTriggerAudioSource(EcallAudioScenarioHandler.this.currentAudioScenario);
            }
        }
    }
}

