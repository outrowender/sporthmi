/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.PowerFSM;
import java.util.ListIterator;

abstract class PowerFSM$State {
    private final int stateID;
    private final String name;
    private final /* synthetic */ PowerFSM this$0;

    public PowerFSM$State(PowerFSM powerFSM, int n, String string) {
        this.this$0 = powerFSM;
        this.stateID = n;
        this.name = string;
    }

    private final String getName() {
        return this.name;
    }

    protected void onEnter() {
        PowerFSM.access$300(this.this$0).log(-2137614336, "call onEnter PowerEventListeners (State=%1, terminalID=%2)", (Object)this.name, (long)PowerFSM.access$200(this.this$0));
        ListIterator listIterator = PowerFSM.access$400(this.this$0).listIterator();
        while (listIterator.hasNext()) {
            try {
                ((PowerEventListener)listIterator.next()).notifyPowerListenerOnEnterState(this.stateID, PowerFSM.access$200(this.this$0));
            }
            catch (Exception exception) {
                PowerFSM.access$300(this.this$0).log(10000, "Exception on call onEnter PowerEventListeners!", (Throwable)exception);
            }
        }
    }

    protected void onExit() {
        PowerFSM.access$300(this.this$0).log(-2137614336, "call onExit PowerEventListeners (State=%1, terminalID=%2)", (Object)this.name, (long)PowerFSM.access$200(this.this$0));
        ListIterator listIterator = PowerFSM.access$400(this.this$0).listIterator();
        while (listIterator.hasNext()) {
            try {
                ((PowerEventListener)listIterator.next()).notifyPowerListenerOnExitState(this.stateID, PowerFSM.access$200(this.this$0));
            }
            catch (Exception exception) {
                PowerFSM.access$300(this.this$0).log(10000, "Exception on call onExit PowerEventListeners!", (Throwable)exception);
            }
        }
    }

    protected void triggerOff() {
    }

    protected void triggerOn() {
    }

    abstract void triggerStandby(int n) {
    }

    protected void triggerCritTempr() {
    }

    protected void triggerStandbyRestricted() {
    }

    protected void triggerOnDiag() {
    }

    protected void triggerCustomerSWDL() {
    }

    protected void triggerOnTel() {
    }

    protected void triggerOnSWDL() {
    }

    protected void triggerStandbyPwrSave() {
    }

    protected void setAudioDeviceService() {
        PowerFSM.access$500(this.this$0).getPwrAudioHandler().mute(PowerFSM.access$200(this.this$0));
    }

    protected void setHMIReady() {
        if (PowerFSM.access$600(this.this$0).isQ21MessageActive()) {
            PowerFSM.access$500(this.this$0).showQ21Warning(PowerFSM.access$600(this.this$0).isHMIReady(), PowerFSM.access$200(this.this$0));
            this.triggerQ21();
        }
    }

    protected void releaseStanbyMute() {
    }

    protected void triggerQ21() {
    }

    protected void triggerQ0() {
    }

    protected void triggerCarStateChange(boolean bl) {
    }

    protected void triggerClimateChange(boolean bl) {
    }

    protected void setDSIDisplayManagement() {
    }

    protected void displayButtonTyped() {
    }

    protected void hardKeyTyped() {
    }

    protected void keyPTTPressed() {
    }

    protected void setAMAvailable() {
    }

    protected void triggerWirelessCharging() {
    }

    protected void triggerOnlineHint() {
    }

    protected void triggerUrgentTmc(boolean bl) {
    }

    protected void triggerCarClampState() {
    }

    protected void sendWLCMessage() {
        PowerFSM.access$300(this.this$0).log(-2137614336, "PowerFSM.sendWLCMessage()");
        MsgDistributor msgDistributor = PowerFSM.access$500(this.this$0).getFramework().getMsgDistrib();
        if (msgDistributor != null) {
            msgDistributor.sendMessage(102);
        }
    }

    static /* synthetic */ String access$000(PowerFSM$State powerFSM$State) {
        return powerFSM$State.getName();
    }

    static /* synthetic */ int access$100(PowerFSM$State powerFSM$State) {
        return powerFSM$State.stateID;
    }
}

