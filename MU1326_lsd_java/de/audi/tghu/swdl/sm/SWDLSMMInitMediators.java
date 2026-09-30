/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.DataUpdateMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;
import java.util.NoSuchElementException;

public class SWDLSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SWDLSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[47];
        eventMediatorArray[1] = new DataUpdateMediator(1700001L, this.smm, 1700007, 1700005, 1700006, -1, 1700137);
        eventMediatorArray[2] = new DataUpdateMediator(1700002L, this.smm, 1700010, 1700008, 1700009, -1, 1700141);
        eventMediatorArray[3] = new WaitSyncMediator(1700003L, (MediatorManager)this.smm, 1700015, 1700133);
        eventMediatorArray[4] = new ChangeMediator(1700004L, (MediatorManager)this.smm, 1700038, new int[]{1700089});
        eventMediatorArray[5] = new WaitSyncMediator(1700005L, (MediatorManager)this.smm, 1700015, 1700133);
        eventMediatorArray[6] = new WaitSyncMediator(1700006L, (MediatorManager)this.smm, 1700015, 1700133);
        eventMediatorArray[8] = new DataUpdateMediator(1700008L, this.smm, 1700063, 1700060, 1700062, 1700061, 1700257, 3000L);
        eventMediatorArray[9] = new WaitSyncMediator(1700009L, (MediatorManager)this.smm, 1700015, 1700133);
        eventMediatorArray[10] = new ChangeMediator(1700010L, (MediatorManager)this.smm, 1700070, new int[]{391});
        eventMediatorArray[11] = new HistoryRestoreMediator(1700011L, this.smm, 1700072);
        eventMediatorArray[13] = new ChangeMediator(1700013L, (MediatorManager)this.smm, 1700077, new int[]{3849});
        eventMediatorArray[14] = new ChangeMediator(1700014L, (MediatorManager)this.smm, 1700088, new int[]{1700061});
        eventMediatorArray[16] = new WaitSyncMediator(1700016L, (MediatorManager)this.smm, 1700015, 1700133);
        eventMediatorArray[17] = new ChangeMediator(1700017L, (MediatorManager)this.smm, 1700094, new int[]{3849});
        eventMediatorArray[18] = new WaitSyncMediator(1700018L, (MediatorManager)this.smm, 1700136, 1700242);
        eventMediatorArray[19] = new WaitSyncMediator(1700019L, (MediatorManager)this.smm, 1700101, 1700132);
        eventMediatorArray[20] = new WaitSyncMediator(1700020L, (MediatorManager)this.smm, 1700101, 1700133);
        eventMediatorArray[21] = new WaitSyncMediator(1700021L, (MediatorManager)this.smm, 1700101, 1700138);
        eventMediatorArray[22] = new WaitSyncMediator(1700022L, (MediatorManager)this.smm, 1700103, 1700051);
        eventMediatorArray[23] = new WaitSyncMediator(1700023L, (MediatorManager)this.smm, 1700103, 1700051);
        eventMediatorArray[24] = new WaitSyncMediator(1700024L, (MediatorManager)this.smm, 1700105, 1700330);
        eventMediatorArray[25] = new WaitSyncMediator(1700025L, (MediatorManager)this.smm, 1700105, 1700330);
        eventMediatorArray[26] = new WaitSyncMediator(1700026L, (MediatorManager)this.smm, 1700107, 1700331);
        eventMediatorArray[27] = new WaitSyncMediator(1700027L, (MediatorManager)this.smm, 1700107, 1700331);
        eventMediatorArray[28] = new WaitSyncMediator(1700028L, (MediatorManager)this.smm, 1700105, 1700330);
        eventMediatorArray[29] = new WaitSyncMediator(1700029L, (MediatorManager)this.smm, 1700107, 1700331);
        eventMediatorArray[30] = new WaitSyncMediator(1700030L, (MediatorManager)this.smm, 1700101, 1700133);
        eventMediatorArray[35] = new WaitTimerMediator(1700035L, (MediatorManager)this.smm, 1700111, 5000L);
        eventMediatorArray[36] = new HistoryRestoreMediator(1700036L, this.smm, 1700112);
        eventMediatorArray[38] = new WaitSyncMediator(1700038L, (MediatorManager)this.smm, 1700110, 1700262);
        eventMediatorArray[39] = new ChangeMediator(1700039L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[42] = new ChangeMediator(1700042L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[43] = new ChangeMediator(1700043L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[44] = new WaitTimerMediator(1700044L, (MediatorManager)this.smm, 1700137, 2500L);
        eventMediatorArray[45] = new ChangeMediator(1700045L, (MediatorManager)this.smm, 1700138, new int[]{1700380});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

