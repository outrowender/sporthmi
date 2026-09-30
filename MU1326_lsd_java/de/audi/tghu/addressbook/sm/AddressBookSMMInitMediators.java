/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.ChangeTimerMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;
import java.util.NoSuchElementException;

public class AddressBookSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected AddressBookSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[82];
        eventMediatorArray[0] = new WaitSyncMediator(700000L, (MediatorManager)this.smm, 700005, 700498);
        eventMediatorArray[2] = new WaitSyncMediator(700002L, (MediatorManager)this.smm, 700010, 700459);
        eventMediatorArray[4] = new WaitSyncMediator(700004L, (MediatorManager)this.smm, 700015, 700497);
        eventMediatorArray[6] = new WaitSyncMediator(700006L, (MediatorManager)this.smm, 400332, 700497);
        eventMediatorArray[7] = new WaitSyncMediator(700007L, (MediatorManager)this.smm, 700026, 700497);
        eventMediatorArray[10] = new ChangeTimerMediator(700010L, this.smm, 700035, new int[]{700453}, 3000L);
        eventMediatorArray[11] = new ChangeTimerMediator(700011L, this.smm, 700036, new int[]{700454}, 3000L);
        eventMediatorArray[12] = new ChangeTimerMediator(700012L, this.smm, 700037, new int[]{700455}, 3000L);
        eventMediatorArray[13] = new WaitScreenMediator(700013L, this.smm, 700034, 700495, 3000L);
        eventMediatorArray[14] = new WaitScreenMediator(700014L, this.smm, 700041, 700496, 3000L);
        eventMediatorArray[17] = new WaitSyncMediator(700017L, (MediatorManager)this.smm, 700048, 700497);
        eventMediatorArray[18] = new ChangeMediator(700018L, (MediatorManager)this.smm, 700049, new int[]{3853});
        eventMediatorArray[19] = new WaitSyncMediator(700019L, (MediatorManager)this.smm, 1917, 700497);
        eventMediatorArray[21] = new ChangeMediator(700021L, (MediatorManager)this.smm, 700057, new int[]{700538});
        eventMediatorArray[22] = new ChangeMediator(700022L, (MediatorManager)this.smm, 700056, new int[]{700464});
        eventMediatorArray[23] = new WaitSyncMediator(700023L, (MediatorManager)this.smm, 2200119, 2200159);
        eventMediatorArray[24] = new WaitSyncMediator(700024L, (MediatorManager)this.smm, 2200115, 2200159);
        eventMediatorArray[25] = new WaitSyncMediator(700025L, (MediatorManager)this.smm, 2200119, 2200159);
        eventMediatorArray[26] = new WaitSyncMediator(700026L, (MediatorManager)this.smm, 700060, 2200159);
        eventMediatorArray[27] = new WaitSyncMediator(700027L, (MediatorManager)this.smm, 700059, 2200159);
        eventMediatorArray[29] = new WaitSyncMediator(700029L, (MediatorManager)this.smm, 700066, 700497);
        eventMediatorArray[31] = new WaitSyncMediator(700031L, (MediatorManager)this.smm, 700063, 700497);
        eventMediatorArray[32] = new WaitSyncMediator(700032L, (MediatorManager)this.smm, 300258, 700497);
        eventMediatorArray[33] = new WaitSyncMediator(700033L, (MediatorManager)this.smm, 1917, 700497);
        eventMediatorArray[34] = new WaitSyncMediator(700034L, (MediatorManager)this.smm, 2200119, 2200159);
        eventMediatorArray[35] = new WaitSyncMediator(700035L, (MediatorManager)this.smm, 700060, 2200159);
        eventMediatorArray[36] = new WaitSyncMediator(700036L, (MediatorManager)this.smm, 2200115, 2200159);
        eventMediatorArray[37] = new WaitSyncMediator(700037L, (MediatorManager)this.smm, 700059, 2200159);
        eventMediatorArray[38] = new WaitSyncMediator(700038L, (MediatorManager)this.smm, 700063, 700497);
        eventMediatorArray[39] = new WaitSyncMediator(700039L, (MediatorManager)this.smm, 700068, 400346);
        eventMediatorArray[40] = new WaitSyncMediator(700040L, (MediatorManager)this.smm, 700068, 400346);
        eventMediatorArray[42] = new WaitSyncMediator(700042L, (MediatorManager)this.smm, 700071, 400346);
        eventMediatorArray[45] = new WaitSyncMediator(700045L, (MediatorManager)this.smm, 700070, 700497);
        eventMediatorArray[46] = new WaitSyncMediator(700046L, (MediatorManager)this.smm, 400325, 400346);
        eventMediatorArray[47] = new WaitSyncMediator(700047L, (MediatorManager)this.smm, 700071, 400346);
        eventMediatorArray[48] = new WaitSyncMediator(700048L, (MediatorManager)this.smm, 700070, 700497);
        eventMediatorArray[50] = new ChangeMediator(700050L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[53] = new WaitSyncMediator(700053L, (MediatorManager)this.smm, 700073, 700438);
        eventMediatorArray[54] = new WaitSyncMediator(700054L, (MediatorManager)this.smm, 2200106, 2200327);
        eventMediatorArray[55] = new WaitSyncMediator(700055L, (MediatorManager)this.smm, 2200094, 2200328);
        eventMediatorArray[56] = new ChangeMediator(700056L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[57] = new WaitScreenMediator(700057L, this.smm, 700074, 700498, 3000L);
        eventMediatorArray[58] = new WaitSyncMediator(700058L, (MediatorManager)this.smm, 2200078, 2200328);
        eventMediatorArray[59] = new WaitSyncMediator(700059L, (MediatorManager)this.smm, 2200112, 2200327);
        eventMediatorArray[60] = new ChangeMediator(700060L, (MediatorManager)this.smm, 2300004, new int[]{204});
        eventMediatorArray[61] = new HistoryRestoreMediator(700061L, this.smm, 700052);
        eventMediatorArray[62] = new HistoryRestoreMediator(700062L, this.smm, 700091);
        eventMediatorArray[63] = new ChangeMediator(700063L, (MediatorManager)this.smm, 700072, new int[]{2300070});
        eventMediatorArray[64] = new ChangeMediator(700064L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[65] = new WaitSyncMediator(700065L, (MediatorManager)this.smm, 700093, 700473);
        eventMediatorArray[66] = new WaitTimerMediator(700066L, (MediatorManager)this.smm, 700094, 3000L);
        eventMediatorArray[67] = new WaitSyncMediator(700067L, (MediatorManager)this.smm, 700096, 2200159);
        eventMediatorArray[68] = new WaitSyncMediator(700068L, (MediatorManager)this.smm, 700096, 2200159);
        eventMediatorArray[69] = new WaitSyncMediator(700069L, (MediatorManager)this.smm, 400325, 400346);
        eventMediatorArray[73] = new ChangeMediator(700073L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[75] = new ChangeTimerMediator(700075L, this.smm, 700019, new int[]{700449}, 800L);
        eventMediatorArray[78] = new ChangeMediator(700078L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[79] = new ChangeMediator(700079L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[80] = new ChangeMediator(700080L, (MediatorManager)this.smm, 700111, new int[]{5583});
        eventMediatorArray[81] = new ChangeMediator(700081L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

