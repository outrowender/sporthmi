/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import java.util.NoSuchElementException;

public class EarlyAppsSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EarlyAppsSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[7];
        eventMediatorArray[0] = new ChangeMediator(0x200B20L, (MediatorManager)this.smm, 2100010, new int[]{2100346});
        eventMediatorArray[1] = new ChangeMediator(2100001L, (MediatorManager)this.smm, 2100001, new int[]{2100179});
        eventMediatorArray[2] = new ChangeMediator(0x200B22L, (MediatorManager)this.smm, 0x200B20, new int[]{2100166});
        eventMediatorArray[4] = new ChangeMediator(2100004L, (MediatorManager)this.smm, 2100055, new int[]{2100401});
        eventMediatorArray[6] = new ChangeMediator(2100006L, (MediatorManager)this.smm, 2100058, new int[]{2100465});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

