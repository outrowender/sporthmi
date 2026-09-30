/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.DataUpdateMediator;
import java.util.NoSuchElementException;

public class EngineeringSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EngineeringSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[]{new DataUpdateMediator(1300000L, this.smm, 1300012, 1300010, 1300011, -1, 1300023, 3000L), new DataUpdateMediator(1300001L, this.smm, 1300023, 1300022, -1, -1, 1300061, 3000L)};
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

