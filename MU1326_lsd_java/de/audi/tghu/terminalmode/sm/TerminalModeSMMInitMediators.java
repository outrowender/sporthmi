/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import java.util.NoSuchElementException;

public class TerminalModeSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TerminalModeSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[10];
        eventMediatorArray[0] = new ChangeMediator(3200000L, (MediatorManager)this.smm, 3200000, new int[]{3200036});
        eventMediatorArray[2] = new ChangeMediator(3200002L, (MediatorManager)this.smm, 3200005, new int[]{3200012});
        eventMediatorArray[3] = new ChangeMediator(3200003L, (MediatorManager)this.smm, 3200000, new int[]{4384});
        eventMediatorArray[4] = new ChangeMediator(3200004L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[5] = new ChangeMediator(3200005L, (MediatorManager)this.smm, 3200008, new int[]{4239});
        eventMediatorArray[6] = new ChangeMediator(3200006L, (MediatorManager)this.smm, 3200006, new int[]{3200046});
        eventMediatorArray[7] = new ChangeMediator(3200007L, (MediatorManager)this.smm, 3200009, new int[]{3200049});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

