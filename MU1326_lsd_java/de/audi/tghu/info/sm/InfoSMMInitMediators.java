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
import java.util.NoSuchElementException;

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
        eventMediatorArray[0] = new ChangeMediator(500000L, (MediatorManager)this.smm, 500005, new int[]{500196});
        eventMediatorArray[1] = new ChangeTimerMediator(500001L, this.smm, 400117, new int[]{500183}, 3000L);
        eventMediatorArray[2] = new HistoryRestoreMediator(500002L, this.smm, 500007);
        eventMediatorArray[3] = new WaitSyncMediator(500003L, (MediatorManager)this.smm, 500003, 500166);
        eventMediatorArray[5] = new ChangeMediator(500005L, (MediatorManager)this.smm, 500009, new int[]{335});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

