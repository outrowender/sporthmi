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
import java.util.NoSuchElementException;

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
        eventMediatorArray[0] = new ChangeMediator(3300000L, (MediatorManager)this.smm, 3300002, new int[]{3300006});
        eventMediatorArray[1] = new ChangeMediator(3300001L, (MediatorManager)this.smm, 3300002, new int[]{3300006});
        eventMediatorArray[11] = new ChangeMediator(3300011L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[12] = new WaitTimerMediator(3300012L, (MediatorManager)this.smm, 3300004, 3000L);
        eventMediatorArray[13] = new WaitTimerMediator(3300013L, (MediatorManager)this.smm, 3300004, 3000L);
        eventMediatorArray[14] = new WaitTimerMediator(3300014L, (MediatorManager)this.smm, 3300004, 3000L);
        eventMediatorArray[15] = new WaitTimerMediator(3300015L, (MediatorManager)this.smm, 3300004, 3000L);
        eventMediatorArray[16] = new WaitTimerMediator(3300016L, (MediatorManager)this.smm, 3300004, 3000L);
        eventMediatorArray[17] = new WaitTimerMediator(3300017L, (MediatorManager)this.smm, 3300004, 3000L);
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

