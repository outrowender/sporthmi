/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.SMModuleConstants;

public class TestSupportSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TestSupportSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[1];
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

