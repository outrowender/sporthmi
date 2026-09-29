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
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, 13905920, new int[]{617885696});
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, 97792000, new int[]{215232512});
        eventMediatorArray[3] = new ChangeMediator((long)0, (MediatorManager)this.smm, 13905920, new int[]{4384});
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 148123648, new int[]{4239});
        eventMediatorArray[6] = new ChangeMediator((long)0, (MediatorManager)this.smm, 114569216, new int[]{785657856});
        eventMediatorArray[7] = new ChangeMediator((long)0, (MediatorManager)this.smm, 164900864, new int[]{835989504});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

