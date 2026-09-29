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
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1030676224, new int[]{17});
        eventMediatorArray[1] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -963567360, 1787961600);
        eventMediatorArray[2] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -963567360, 1787961600);
        eventMediatorArray[3] = new DataUpdateMediator(0, this.smm, -913235712, -946790144, -930012928, -1, 1720852736, 0);
        eventMediatorArray[4] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -879681280, (long)0);
        eventMediatorArray[5] = new DataUpdateMediator(0, this.smm, -812572416, -829349632, -795795200, -1, 1720852736, 0);
        eventMediatorArray[6] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -896392960, (long)0);
        eventMediatorArray[9] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -560914176, (long)0);
        eventMediatorArray[10] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -661577472, (long)0);
        eventMediatorArray[11] = new DataUpdateMediator(0, this.smm, -695131904, -711909120, -678354688, -1, -1148051200, 0);
        eventMediatorArray[12] = new DataUpdateMediator(0, this.smm, -527359744, -477028096, -493805312, -1, -1148051200, 0);
        eventMediatorArray[13] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -510582528, (long)0);
        eventMediatorArray[14] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -409919232, (long)0);
        eventMediatorArray[15] = new DataUpdateMediator(0, this.smm, -225369856, -258924288, -242147072, -1, -1131273984, 0);
        eventMediatorArray[16] = new DataUpdateMediator(0, this.smm, -107929344, -74374912, -91152128, -1, -1986912000, 0);
        eventMediatorArray[17] = new DataUpdateMediator(0, this.smm, -7266048, 9576704, 26353920, -1, -1986912000, 0);
        eventMediatorArray[18] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 59908352, (long)0);
        eventMediatorArray[19] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1315823360, (long)0);
        eventMediatorArray[21] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 127017216, (long)0);
        eventMediatorArray[22] = new DataUpdateMediator(0, this.smm, -611245824, -577691392, -594468608, -1, -1148051200, 0);
        eventMediatorArray[23] = new DataUpdateMediator(0, this.smm, -460250880, -376364800, -393142016, -1, -1148051200, 0);
        eventMediatorArray[25] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 345121024, (long)0);
        eventMediatorArray[27] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 412229888, 143859968);
        eventMediatorArray[28] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 244457728, 143859968);
        eventMediatorArray[29] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 462561536, 143859968);
        eventMediatorArray[30] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 512893184, 143859968);
        eventMediatorArray[31] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 479338752, (long)0);
        eventMediatorArray[34] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 546447616, 143859968);
        eventMediatorArray[35] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 563224832, 143859968);
        eventMediatorArray[36] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 580002048, (long)0);
        eventMediatorArray[37] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 596779264, (long)0);
        eventMediatorArray[38] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 647110912, 127082752);
        eventMediatorArray[39] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 714219776, 127082752);
        eventMediatorArray[40] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 680665344, (long)0);
        eventMediatorArray[41] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 814883072, 127082752);
        eventMediatorArray[42] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 781328640, 127082752);
        eventMediatorArray[43] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 798105856, (long)0);
        eventMediatorArray[44] = new ChangeMediator((long)0, (MediatorManager)this.smm, 831660288, new int[]{-1382932224, 268, 1351819520, 5583});
        eventMediatorArray[45] = new ChangeMediator((long)0, (MediatorManager)this.smm, 831660288, new int[]{-1382932224, 268, 1351819520, 5583});
        eventMediatorArray[49] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1351753984, (long)0);
        eventMediatorArray[50] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1368531200, (long)0);
        eventMediatorArray[51] = new ChangeMediator((long)0, (MediatorManager)this.smm, 217127168, new int[]{4097});
        eventMediatorArray[55] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1553080576, 1787961600);
        eventMediatorArray[57] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1620189440, 1787961600);
        eventMediatorArray[58] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1636966656, 1787961600);
        eventMediatorArray[59] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1215160064, (long)0);
        eventMediatorArray[63] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[71] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1503, new int[]{350});
        eventMediatorArray[72] = new WaitSyncTimeoutMediator(0, this.smm, 1670521088, 9765888, 1387268608, 0);
        eventMediatorArray[73] = new WaitScreenMediator(0, this.smm, 43320320, 529735936, 0);
        eventMediatorArray[74] = new WaitSyncTimeoutMediator(0, this.smm, 1838293248, 1855070464, 529735936, 0);
        eventMediatorArray[75] = new WaitSyncTimeoutMediator(0, this.smm, 1754407168, 1871847680, 529735936, 0);
        eventMediatorArray[76] = new WaitScreenMediator(0, this.smm, -1265491712, 529735936, 0);
        eventMediatorArray[77] = new WaitSyncTimeoutMediator(0, this.smm, 1754407168, -1282268928, 529735936, 0);
        eventMediatorArray[78] = new WaitSyncTimeoutMediator(0, this.smm, 1838293248, -1248714496, 529735936, 0);
        eventMediatorArray[81] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1720852736, new int[]{1334976768});
        eventMediatorArray[82] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[83] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[84] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1131273984, 1787961600);
        eventMediatorArray[85] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1080942336, 1335042304);
        eventMediatorArray[86] = new WaitScreenMediator(0, this.smm, -980279040, 1787961600, 0);
        eventMediatorArray[88] = new WaitScreenMediator(0, this.smm, -980279040, 1787961600, 0);
        eventMediatorArray[89] = new HistoryRestoreMediator(0, this.smm, -929947392);
        eventMediatorArray[90] = new HistoryRestoreMediator(0, this.smm, -946724608);
        eventMediatorArray[93] = new ChangeMediator((long)0, (MediatorManager)this.smm, -862838528, new int[]{1553146112});
        eventMediatorArray[94] = new ChangeMediator((long)0, (MediatorManager)this.smm, -879615744, new int[]{1553146112});
        eventMediatorArray[95] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[96] = new ChangeMediator((long)0, (MediatorManager)this.smm, 217127168, new int[]{4097});
        eventMediatorArray[97] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -829284096, 1335042304);
        eventMediatorArray[98] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -846061312, 1335042304);
        eventMediatorArray[101] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[102] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[106] = new WaitSyncTimeoutMediator(0, this.smm, -695066368, -678289152, 1787961600, 0);
        eventMediatorArray[107] = new WaitSyncTimeoutMediator(0, this.smm, -695066368, -678289152, 1787961600, 0);
        eventMediatorArray[108] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -611180288, 143859968);
        eventMediatorArray[112] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[113] = new HistoryRestoreMediator(0, this.smm, 1284710656);
        eventMediatorArray[114] = new HistoryRestoreMediator(0, this.smm, 1267933440);
        eventMediatorArray[115] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[116] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[117] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[118] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[119] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[120] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

