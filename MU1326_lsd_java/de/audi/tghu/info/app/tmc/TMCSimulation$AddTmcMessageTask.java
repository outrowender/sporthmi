/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.info.app.tmc.TMCSimulation;
import java.util.TimerTask;

class TMCSimulation$AddTmcMessageTask
extends TimerTask {
    private final /* synthetic */ TMCSimulation this$0;

    public TMCSimulation$AddTmcMessageTask(TMCSimulation tMCSimulation) {
        this.this$0 = tMCSimulation;
    }

    @Override
    public void run() {
        if (TMCSimulation.access$800(this.this$0) >= TMCSimulation.access$900().length) {
            TMCSimulation.access$000(this.this$0).log(-2137614336, "[TMCSimulation#AddTmcMessageTask] Do nothing, no more messages available. ");
        } else {
            TMCSimulation.access$000(this.this$0).log(-2137614336, "[TMCSimulation#AddTmcMessageTask] Add next message. ");
            this.this$0.addTmcMessage(TMCSimulation.access$800(this.this$0), -1L);
            TMCSimulation.access$808(this.this$0);
            TMCSimulation.access$700(this.this$0).windowChange(TMCSimulation.access$600(this.this$0));
        }
    }
}

