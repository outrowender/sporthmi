/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.audio.EcallAudioScenarioHandler$AudioServiceListener;
import de.audi.app.ecall.core.audio.EcallAudioScenarioHandler$MutePinListener;
import de.audi.app.ecall.core.audio.cmd.EcallAudioCmdManager;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdManager;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;

public class EcallAudioScenarioHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    private static final int AUDIO_SCENARIO_NONE;
    private volatile int currentAudioScenario = 0;
    private volatile IEcallAudioCmdManager ecallAudioCmdManager;
    private final EcallAudioScenarioHandler$AudioServiceListener audioServiceListener;
    private final EcallAudioScenarioHandler$MutePinListener mutePinListener;
    private volatile boolean hasActiveCustomerCall;

    public EcallAudioScenarioHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Audio");
        this.mutePinListener = new EcallAudioScenarioHandler$MutePinListener(this, iEcallApplication, 4628);
        this.audioServiceListener = new EcallAudioScenarioHandler$AudioServiceListener(this, iEcallApplication);
        this.ecallAudioCmdManager = new EcallAudioCmdManager(iEcallApplication, this.audioServiceListener, this.mutePinListener);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getEcallStateManager().registerListener(this);
        ((EcallAudioCmdManager)this.ecallAudioCmdManager).init();
    }

    @Override
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

    @Override
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

    @Override
    protected IEcallComponent[] getSubComponents() {
        return new IEcallComponent[]{this.audioServiceListener, this.mutePinListener};
    }

    private void onCustomerCallStateChanged(IEcallStateStruct iEcallStateStruct) {
        if (iEcallStateStruct.isCallActive()) {
            this.log.log(1078071040, "EcallAudioScenarioHandler#onCustomerCallStateChanged(): service is active. NOP.");
            return;
        }
        if (iEcallStateStruct.getBapAudioSource() == 3) {
            this.log.log(1078071040, "EcallAudioScenarioHandler#onCustomerCallStateChanged(): bapAudioSource is ECALL 0x03. NOP");
            return;
        }
        if (iEcallStateStruct.getBapAudioSource() == 4) {
            this.log.log(1078071040, "EcallAudioScenarioHandler#onCustomerCallStateChanged(): bapAudioSource is ECALL 0x04. NOP");
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
                    this.log.log(-2137614336, "EcallAudioScenarioHandler#triggerAudioSource(): unsupported audioSource %1 ", (long)n);
                    break;
                }
            }
        } else {
            this.log.log(-2137614336, "EcallAudioScenarioHandler#triggerAudioSource(): audioSource has not changed --> NOP!");
        }
    }

    void setEcallAudioCmdManager(IEcallAudioCmdManager iEcallAudioCmdManager) {
        this.ecallAudioCmdManager = iEcallAudioCmdManager;
    }

    static /* synthetic */ int access$000(EcallAudioScenarioHandler ecallAudioScenarioHandler) {
        return ecallAudioScenarioHandler.currentAudioScenario;
    }

    static /* synthetic */ IEcallAudioCmdManager access$100(EcallAudioScenarioHandler ecallAudioScenarioHandler) {
        return ecallAudioScenarioHandler.ecallAudioCmdManager;
    }
}

