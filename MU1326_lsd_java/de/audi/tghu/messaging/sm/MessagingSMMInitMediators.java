/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.DataUpdateMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.InfoTimerMediator;
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitSyncTimeoutMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;
import java.util.NoSuchElementException;

public class MessagingSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected MessagingSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[121];
        eventMediatorArray[0] = new ChangeMediator(2200000L, (MediatorManager)this.smm, 2200002, new int[]{17});
        eventMediatorArray[1] = new WaitSyncMediator(2200001L, (MediatorManager)this.smm, 2200006, 2200170);
        eventMediatorArray[2] = new WaitSyncMediator(2200002L, (MediatorManager)this.smm, 2200006, 2200170);
        eventMediatorArray[3] = new DataUpdateMediator(2200003L, this.smm, 2200009, 2200007, 2200008, -1, 2200166, 3000L);
        eventMediatorArray[4] = new WaitTimerMediator(2200004L, (MediatorManager)this.smm, 2200011, 3000L);
        eventMediatorArray[5] = new DataUpdateMediator(2200005L, this.smm, 2200015, 2200014, 2200016, -1, 2200166, 3000L);
        eventMediatorArray[6] = new WaitTimerMediator(2200006L, (MediatorManager)this.smm, 2200266, 3000L);
        eventMediatorArray[9] = new WaitTimerMediator(2200009L, (MediatorManager)this.smm, 2200030, 3000L);
        eventMediatorArray[10] = new WaitTimerMediator(2200010L, (MediatorManager)this.smm, 2200024, 3000L);
        eventMediatorArray[11] = new DataUpdateMediator(2200011L, this.smm, 2200022, 2200021, 2200023, -1, 2200251, 3000L);
        eventMediatorArray[12] = new DataUpdateMediator(2200012L, this.smm, 2200032, 2200035, 2200034, -1, 2200251, 3000L);
        eventMediatorArray[13] = new WaitTimerMediator(2200013L, (MediatorManager)this.smm, 2200033, 3000L);
        eventMediatorArray[14] = new WaitTimerMediator(2200014L, (MediatorManager)this.smm, 2200039, 3000L);
        eventMediatorArray[15] = new DataUpdateMediator(2200015L, this.smm, 2200050, 2200048, 2200049, -1, 2200252, 3000L);
        eventMediatorArray[16] = new DataUpdateMediator(2200016L, this.smm, 2200057, 2200059, 2200058, -1, 2200201, 3000L);
        eventMediatorArray[17] = new DataUpdateMediator(2200017L, this.smm, 2200063, 2200064, 2200065, -1, 2200201, 3000L);
        eventMediatorArray[18] = new WaitTimerMediator(2200018L, (MediatorManager)this.smm, 2200067, 3000L);
        eventMediatorArray[19] = new WaitTimerMediator(2200019L, (MediatorManager)this.smm, 2200241, 3000L);
        eventMediatorArray[21] = new WaitTimerMediator(2200021L, (MediatorManager)this.smm, 2200071, 3000L);
        eventMediatorArray[22] = new DataUpdateMediator(2200022L, this.smm, 2200027, 2200029, 2200028, -1, 2200251, 3000L);
        eventMediatorArray[23] = new DataUpdateMediator(2200023L, this.smm, 2200036, 2200041, 2200040, -1, 2200251, 3000L);
        eventMediatorArray[25] = new WaitTimerMediator(2200025L, (MediatorManager)this.smm, 2200084, 3000L);
        eventMediatorArray[27] = new WaitSyncMediator(2200027L, (MediatorManager)this.smm, 2200088, 2200328);
        eventMediatorArray[28] = new WaitSyncMediator(2200028L, (MediatorManager)this.smm, 2200078, 2200328);
        eventMediatorArray[29] = new WaitSyncMediator(2200029L, (MediatorManager)this.smm, 2200091, 2200328);
        eventMediatorArray[30] = new WaitSyncMediator(2200030L, (MediatorManager)this.smm, 2200094, 2200328);
        eventMediatorArray[31] = new WaitTimerMediator(2200031L, (MediatorManager)this.smm, 2200092, 3000L);
        eventMediatorArray[34] = new WaitSyncMediator(2200034L, (MediatorManager)this.smm, 2200096, 2200328);
        eventMediatorArray[35] = new WaitSyncMediator(2200035L, (MediatorManager)this.smm, 0x219221, 2200328);
        eventMediatorArray[36] = new InfoTimerMediator(2200036L, (MediatorManager)this.smm, 0x219222, 3000L);
        eventMediatorArray[37] = new InfoTimerMediator(2200037L, (MediatorManager)this.smm, 2200099, 3000L);
        eventMediatorArray[38] = new WaitSyncMediator(2200038L, (MediatorManager)this.smm, 2200102, 2200327);
        eventMediatorArray[39] = new WaitSyncMediator(2200039L, (MediatorManager)this.smm, 2200106, 2200327);
        eventMediatorArray[40] = new WaitTimerMediator(2200040L, (MediatorManager)this.smm, 2200104, 3000L);
        eventMediatorArray[41] = new WaitSyncMediator(2200041L, (MediatorManager)this.smm, 2200112, 2200327);
        eventMediatorArray[42] = new WaitSyncMediator(2200042L, (MediatorManager)this.smm, 2200110, 2200327);
        eventMediatorArray[43] = new WaitTimerMediator(2200043L, (MediatorManager)this.smm, 2200111, 3000L);
        eventMediatorArray[44] = new ChangeMediator(2200044L, (MediatorManager)this.smm, 2200113, new int[]{2200237, 268, 2200400, 5583});
        eventMediatorArray[45] = new ChangeMediator(2200045L, (MediatorManager)this.smm, 2200113, new int[]{2200237, 268, 2200400, 5583});
        eventMediatorArray[49] = new WaitTimerMediator(2200049L, (MediatorManager)this.smm, 2200144, 3000L);
        eventMediatorArray[50] = new WaitTimerMediator(2200050L, (MediatorManager)this.smm, 2200145, 3000L);
        eventMediatorArray[51] = new ChangeMediator(2200051L, (MediatorManager)this.smm, 1700108, new int[]{4097});
        eventMediatorArray[55] = new WaitSyncMediator(2200055L, (MediatorManager)this.smm, 2200156, 2200170);
        eventMediatorArray[57] = new WaitSyncMediator(2200057L, (MediatorManager)this.smm, 2200160, 2200170);
        eventMediatorArray[58] = new WaitSyncMediator(2200058L, (MediatorManager)this.smm, 2200161, 2200170);
        eventMediatorArray[59] = new WaitTimerMediator(2200059L, (MediatorManager)this.smm, 2200247, 3000L);
        eventMediatorArray[63] = new ChangeMediator(2200063L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[71] = new ChangeMediator(2200071L, (MediatorManager)this.smm, 1503, new int[]{350});
        eventMediatorArray[72] = new WaitSyncTimeoutMediator(2200072L, this.smm, 2200163, 300288, 700498, 1500L);
        eventMediatorArray[73] = new WaitScreenMediator(2200073L, this.smm, 300290, 2200351, 3000L);
        eventMediatorArray[74] = new WaitSyncTimeoutMediator(2200074L, this.smm, 2200173, 2200174, 2200351, 1500L);
        eventMediatorArray[75] = new WaitSyncTimeoutMediator(2200075L, this.smm, 2200168, 2200175, 2200351, 1500L);
        eventMediatorArray[76] = new WaitScreenMediator(2200076L, this.smm, 2200244, 2200351, 3000L);
        eventMediatorArray[77] = new WaitSyncTimeoutMediator(2200077L, this.smm, 2200168, 2200243, 2200351, 1500L);
        eventMediatorArray[78] = new WaitSyncTimeoutMediator(2200078L, this.smm, 2200173, 2200245, 2200351, 1500L);
        eventMediatorArray[81] = new ChangeMediator(0x219211L, (MediatorManager)this.smm, 2200166, new int[]{2200143});
        eventMediatorArray[82] = new ChangeMediator(0x219212L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[83] = new ChangeMediator(2200083L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[84] = new WaitSyncMediator(2200084L, (MediatorManager)this.smm, 2200252, 2200170);
        eventMediatorArray[85] = new WaitSyncMediator(2200085L, (MediatorManager)this.smm, 2200255, 2200399);
        eventMediatorArray[86] = new WaitScreenMediator(2200086L, this.smm, 2200261, 2200170, 3000L);
        eventMediatorArray[88] = new WaitScreenMediator(2200088L, this.smm, 2200261, 2200170, 3000L);
        eventMediatorArray[89] = new HistoryRestoreMediator(0x219219L, this.smm, 2200264);
        eventMediatorArray[90] = new HistoryRestoreMediator(2200090L, this.smm, 2200263);
        eventMediatorArray[93] = new ChangeMediator(2200093L, (MediatorManager)this.smm, 2200268, new int[]{2200412});
        eventMediatorArray[94] = new ChangeMediator(2200094L, (MediatorManager)this.smm, 2200267, new int[]{2200412});
        eventMediatorArray[95] = new ChangeMediator(2200095L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[96] = new ChangeMediator(2200096L, (MediatorManager)this.smm, 1700108, new int[]{4097});
        eventMediatorArray[97] = new WaitSyncMediator(0x219221L, (MediatorManager)this.smm, 2200270, 2200399);
        eventMediatorArray[98] = new WaitSyncMediator(0x219222L, (MediatorManager)this.smm, 2200269, 2200399);
        eventMediatorArray[101] = new ChangeMediator(2200101L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[102] = new ChangeMediator(2200102L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[106] = new WaitSyncTimeoutMediator(2200106L, this.smm, 2200278, 2200279, 2200170, 2000L);
        eventMediatorArray[107] = new WaitSyncTimeoutMediator(2200107L, this.smm, 2200278, 2200279, 2200170, 2000L);
        eventMediatorArray[108] = new WaitSyncMediator(2200108L, (MediatorManager)this.smm, 2200283, 2200328);
        eventMediatorArray[112] = new ChangeMediator(2200112L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[113] = new HistoryRestoreMediator(2200113L, this.smm, 2200396);
        eventMediatorArray[114] = new HistoryRestoreMediator(2200114L, this.smm, 2200395);
        eventMediatorArray[115] = new ChangeMediator(2200115L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[116] = new ChangeMediator(2200116L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[117] = new ChangeMediator(2200117L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[118] = new ChangeMediator(2200118L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[119] = new ChangeMediator(2200119L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[120] = new ChangeMediator(2200120L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

