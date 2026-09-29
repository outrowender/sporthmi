/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.info.app.tmc.TMCSimulation;
import java.util.TimerTask;
import org.dsi.ifc.tmc.TmcListElement;

class TMCSimulation$UpdateTimerTask
extends TimerTask {
    private long windowSize;
    private int offset;
    private int[] msgIds;
    private int openedListAnchorId;
    private final /* synthetic */ TMCSimulation this$0;

    public TMCSimulation$UpdateTimerTask(TMCSimulation tMCSimulation, long l, int n, int[] nArray, int n2) {
        this.this$0 = tMCSimulation;
        this.windowSize = l;
        this.offset = n;
        this.msgIds = nArray;
        this.openedListAnchorId = n2;
    }

    @Override
    public synchronized void run() {
        int n;
        int n2;
        int n3 = -1;
        if (this.msgIds == null || this.msgIds.length == 0 || this.msgIds.length == 1 && this.msgIds[0] == -1) {
            TMCSimulation.access$000(this.this$0).log(-2137614336, "[TMCSimulation#setWindow] Initial window requested. ");
            n3 = TMCSimulation.access$100(this.this$0, this.windowSize, 0, 0L, this.openedListAnchorId, false, 0);
        } else {
            boolean bl = false;
        }
        TmcListElement[] tmcListElementArray = (TmcListElement[])TMCSimulation.access$200(this.this$0).toArray(new TmcListElement[TMCSimulation.access$200(this.this$0).size()]);
        if (TMCSimulation.access$300(this.this$0).isEvoHigh() || TMCSimulation.access$300(this.this$0).isPorscheHigh() || TMCSimulation.access$300(this.this$0).isBentley() || TMCSimulation.access$300(this.this$0).isPGen2()) {
            n2 = TMCSimulation.access$400(this.this$0).size() + TMCSimulation.access$500(this.this$0).size();
            n = TMCSimulation.access$400(this.this$0).size() + 1 + (this.openedListAnchorId == 0 ? TMCSimulation.access$500(this.this$0).size() : 0);
        } else {
            n2 = TMCSimulation.access$400(this.this$0).size();
            n = TMCSimulation.access$400(this.this$0).size();
        }
        TMCSimulation.access$000(this.this$0).log(-2137614336, "Updating window... ");
        switch (TMCSimulation.access$600(this.this$0)) {
            case 0: 
            case 1: 
            case 2: {
                TMCSimulation.access$700(this.this$0).updateEventsTotal(TMCSimulation.access$600(this.this$0), n2, n, 1);
                TMCSimulation.access$700(this.this$0).tmcWindowResult(TMCSimulation.access$600(this.this$0), n3, tmcListElementArray);
                break;
            }
        }
    }
}

