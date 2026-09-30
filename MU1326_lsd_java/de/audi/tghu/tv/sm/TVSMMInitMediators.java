/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import java.util.NoSuchElementException;

public class TVSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TVSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[42];
        eventMediatorArray[0] = new ChangeMediator(2600000L, (MediatorManager)this.smm, 2600011, new int[]{2600016, 5583});
        eventMediatorArray[1] = new HistoryRestoreMediator(2600001L, this.smm, 2600012);
        eventMediatorArray[2] = new ChangeMediator(2600002L, (MediatorManager)this.smm, 2600011, new int[]{2600023, 5583});
        eventMediatorArray[3] = new ChangeMediator(2600003L, (MediatorManager)this.smm, 2600011, new int[]{2600023, 5583});
        eventMediatorArray[4] = new ChangeMediator(2600004L, (MediatorManager)this.smm, 2600036, new int[]{2600026});
        eventMediatorArray[5] = new ChangeMediator(2600005L, (MediatorManager)this.smm, 2600038, new int[]{2600080});
        eventMediatorArray[8] = new ChangeMediator(2600008L, (MediatorManager)this.smm, 2600048, new int[]{2600081});
        eventMediatorArray[9] = new ChangeMediator(2600009L, (MediatorManager)this.smm, 2600049, new int[]{2600082});
        eventMediatorArray[10] = new ChangeMediator(2600010L, (MediatorManager)this.smm, 2600054, new int[]{2600040});
        eventMediatorArray[12] = new ChangeMediator(2600012L, (MediatorManager)this.smm, 2600038, new int[]{2600080});
        eventMediatorArray[14] = new ChangeMediator(2600014L, (MediatorManager)this.smm, 2600011, new int[]{2600016, 5583});
        eventMediatorArray[15] = new HistoryRestoreMediator(2600015L, this.smm, 2600068);
        eventMediatorArray[16] = new ChangeMediator(2600016L, (MediatorManager)this.smm, 2600069, new int[]{2600119});
        eventMediatorArray[17] = new ChangeMediator(2600017L, (MediatorManager)this.smm, 2600070, new int[]{377});
        eventMediatorArray[20] = new HistoryRestoreMediator(2600020L, this.smm, 2600091);
        eventMediatorArray[21] = new HistoryRestoreMediator(2600021L, this.smm, 2600091);
        eventMediatorArray[22] = new HistoryRestoreMediator(2600022L, this.smm, 2600091);
        eventMediatorArray[23] = new HistoryRestoreMediator(2600023L, this.smm, 2600091);
        eventMediatorArray[24] = new HistoryRestoreMediator(2600024L, this.smm, 2600091);
        eventMediatorArray[25] = new HistoryRestoreMediator(2600025L, this.smm, 2600091);
        eventMediatorArray[26] = new HistoryRestoreMediator(2600026L, this.smm, 2600012);
        eventMediatorArray[27] = new HistoryRestoreMediator(2600027L, this.smm, 2600012);
        eventMediatorArray[28] = new ChangeMediator(2600028L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[29] = new ChangeMediator(2600029L, (MediatorManager)this.smm, 2600094, new int[]{335});
        eventMediatorArray[30] = new ChangeMediator(2600030L, (MediatorManager)this.smm, 2600094, new int[]{335});
        eventMediatorArray[31] = new ChangeMediator(2600031L, (MediatorManager)this.smm, 2600095, new int[]{2600184});
        eventMediatorArray[32] = new ChangeMediator(2600032L, (MediatorManager)this.smm, 2600095, new int[]{2600184});
        eventMediatorArray[33] = new ChangeMediator(2600033L, (MediatorManager)this.smm, 2600072, new int[]{2600146});
        eventMediatorArray[34] = new ChangeMediator(2600034L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[35] = new ChangeMediator(2600035L, (MediatorManager)this.smm, 2600011, new int[]{2600023, 5583});
        eventMediatorArray[36] = new HistoryRestoreMediator(2600036L, this.smm, 2600091);
        eventMediatorArray[37] = new ChangeMediator(2600037L, (MediatorManager)this.smm, 2600011, new int[]{2600023, 5583});
        eventMediatorArray[38] = new HistoryRestoreMediator(2600038L, this.smm, 2600091);
        eventMediatorArray[39] = new ChangeMediator(2600039L, (MediatorManager)this.smm, 2600011, new int[]{2600023, 5583});
        eventMediatorArray[41] = new ChangeMediator(2600041L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

