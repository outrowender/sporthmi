/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;

public class EcallSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EcallSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[19];
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1571147264, new int[]{-1504038400});
        eventMediatorArray[1] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1571147264, new int[]{-1504038400});
        eventMediatorArray[11] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[12] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1537592832, (long)0);
        eventMediatorArray[13] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1537592832, (long)0);
        eventMediatorArray[14] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1537592832, (long)0);
        eventMediatorArray[15] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1537592832, (long)0);
        eventMediatorArray[16] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1537592832, (long)0);
        eventMediatorArray[17] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1537592832, (long)0);
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

