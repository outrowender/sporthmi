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
        eventMediatorArray[0] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1705904640, 1387268608);
        eventMediatorArray[2] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1789790720, 732957184);
        eventMediatorArray[4] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1873676800, 1370491392);
        eventMediatorArray[6] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -870644224, 1370491392);
        eventMediatorArray[7] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2058226176, 1370491392);
        eventMediatorArray[10] = new ChangeTimerMediator(0, this.smm, -2085746176, new int[]{632293888}, 0);
        eventMediatorArray[11] = new ChangeTimerMediator(0, this.smm, -2068968960, new int[]{649071104}, 0);
        eventMediatorArray[12] = new ChangeTimerMediator(0, this.smm, -2052191744, new int[]{665848320}, 0);
        eventMediatorArray[13] = new WaitScreenMediator(0, this.smm, -2102523392, 1336936960, 0);
        eventMediatorArray[14] = new WaitScreenMediator(0, this.smm, -1985082880, 1353714176, 0);
        eventMediatorArray[17] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1867642368, 1370491392);
        eventMediatorArray[18] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1850865152, new int[]{3853});
        eventMediatorArray[19] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1917, 1370491392);
        eventMediatorArray[21] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1716647424, new int[]{2058357248});
        eventMediatorArray[22] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1733424640, new int[]{816843264});
        eventMediatorArray[23] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 932323584, 1603412224);
        eventMediatorArray[24] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 865214720, 1603412224);
        eventMediatorArray[25] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 932323584, 1603412224);
        eventMediatorArray[26] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1666315776, 1603412224);
        eventMediatorArray[27] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1683092992, 1603412224);
        eventMediatorArray[29] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1565652480, 1370491392);
        eventMediatorArray[31] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1615984128, 1370491392);
        eventMediatorArray[32] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -493616128, 1370491392);
        eventMediatorArray[33] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1917, 1370491392);
        eventMediatorArray[34] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 932323584, 1603412224);
        eventMediatorArray[35] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1666315776, 1603412224);
        eventMediatorArray[36] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 865214720, 1603412224);
        eventMediatorArray[37] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1683092992, 1603412224);
        eventMediatorArray[38] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1615984128, 1370491392);
        eventMediatorArray[39] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1532098048, -635763200);
        eventMediatorArray[40] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1532098048, -635763200);
        eventMediatorArray[42] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1481766400, -635763200);
        eventMediatorArray[45] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1498543616, 1370491392);
        eventMediatorArray[46] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -988084736, -635763200);
        eventMediatorArray[47] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1481766400, -635763200);
        eventMediatorArray[48] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1498543616, 1370491392);
        eventMediatorArray[50] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[53] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1448211968, 380635648);
        eventMediatorArray[54] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 714219776, 127082752);
        eventMediatorArray[55] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 512893184, 143859968);
        eventMediatorArray[56] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[57] = new WaitScreenMediator(0, this.smm, -1431434752, 1387268608, 0);
        eventMediatorArray[58] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 244457728, 143859968);
        eventMediatorArray[59] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 814883072, 127082752);
        eventMediatorArray[60] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1679303424, new int[]{204});
        eventMediatorArray[61] = new HistoryRestoreMediator(0, this.smm, -1800533504);
        eventMediatorArray[62] = new HistoryRestoreMediator(0, this.smm, -1146222080);
        eventMediatorArray[63] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1464989184, new int[]{-1508367616});
        eventMediatorArray[64] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[65] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1112667648, 967838208);
        eventMediatorArray[66] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1095890432, (long)0);
        eventMediatorArray[67] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1062336000, 1603412224);
        eventMediatorArray[68] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1062336000, 1603412224);
        eventMediatorArray[69] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -988084736, -635763200);
        eventMediatorArray[73] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[75] = new ChangeTimerMediator(0, this.smm, 1940785664, new int[]{565185024}, 0);
        eventMediatorArray[78] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[79] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[80] = new ChangeMediator((long)0, (MediatorManager)this.smm, -810677760, new int[]{5583});
        eventMediatorArray[81] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

