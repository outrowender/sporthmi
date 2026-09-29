/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState;
import de.audi.app.terminalmode.events.TrackDataChangedEvent$Builder;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.atip.utils.statemachine.Message;

public class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active
extends TMDeviceControl$TMDeviceControlState {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive this$5;

    public TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive tMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive) {
        this.this$5 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive;
        super(null);
    }

    @Override
    public void enter(Message message) {
        TMDeviceControl.access$1600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).setServiceStatus(true);
        TMDeviceControl.access$1000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5))))), TMDevice$ConnectionState.ACTIVE, "ActivateDeviceSubsystem");
        TMDeviceControl.access$3900(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getPropertySPIServiceState().accept(SPIServiceState.STARTED);
        this.setHMIDeviceState(true);
        IAudioManager iAudioManager = TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getAudioManager();
        TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getCommandListHelper().create().addSingle(iAudioManager.createAudioConnectionRequest(TMAudioConnection.ANNOUNCEMENT, false)).execute(new StringBuffer().append(TMDeviceControl.access$000(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5))))))).append(".Active.enter()").toString());
        TMDeviceControl.access$2300(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).deviceActivated(TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))));
    }

    @Override
    protected void deactivate() {
        TMDeviceControl$SM.access$4100(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))), TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting == null ? (TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting")) : TMDeviceControl.class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting);
    }

    @Override
    public void exit(Message message) {
        this.setHMIDeviceState(false);
        this.resetModels();
    }

    private void setHMIDeviceState(boolean bl) {
        int n = TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).isCarplayDevice() ? 1 : (TMDeviceControl.access$600(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).isAndroidAutoDevice() ? 2 : 3);
        this.updateMainWizardModel(bl, n);
        this.updateTabbarModel(bl, n);
    }

    private void updateMainWizardModel(boolean bl, int n) {
        TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getFramework().getHmiServiceApp().getChoiceModel(4239).setValue(bl ? n : 0);
        int n2 = bl ? (1 == n ? 16 : (2 == n ? 17 : 19)) : 18;
        int n3 = TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getFramework().getHmiServiceApp().getChoiceModel(138).getValue();
        if (17 == n3 || 16 == n3 || 18 == n3 || 19 == n3) {
            TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getFramework().getHmiServiceApp().getChoiceModel(138).setValue(n2);
        }
    }

    private void updateTabbarModel(boolean bl, int n) {
        if (bl) {
            if (1 == n) {
                TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getChoiceModel(4552).setValue(1);
            } else {
                TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getChoiceModel(4552).setValue(2);
            }
        } else {
            TMDeviceControl.access$200(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).getChoiceModel(4552).setValue(0);
        }
    }

    private void resetModels() {
        TMDeviceControl.access$2300(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).updateNowPlayingData(new TrackDataChangedEvent$Builder().build());
        TMDeviceControl.access$2300(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive.access$3600(this.this$5)))))).updatePlayPosition(new TrackPlayPositionEvent(0, 0));
    }
}

