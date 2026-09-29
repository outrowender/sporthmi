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
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, 705372160, new int[]{2047614976});
        eventMediatorArray[1] = new ChangeMediator((long)0, (MediatorManager)this.smm, 554377216, new int[]{-754245632});
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, 0x200B2000, new int[]{-972349440});
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1460346880, new int[]{-1324605440});
        eventMediatorArray[6] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1510678528, new int[]{-250863616});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

