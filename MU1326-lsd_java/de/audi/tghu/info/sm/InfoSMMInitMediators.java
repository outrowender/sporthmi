/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.ChangeTimerMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;

public class InfoSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected InfoSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[6];
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, 631310080, new int[]{-459208960});
        eventMediatorArray[1] = new ChangeTimerMediator(0, this.smm, -182843904, new int[]{-677312768}, 0);
        eventMediatorArray[2] = new HistoryRestoreMediator(0, this.smm, 664864512);
        eventMediatorArray[3] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 597755648, -962525440);
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 698418944, new int[]{335});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

