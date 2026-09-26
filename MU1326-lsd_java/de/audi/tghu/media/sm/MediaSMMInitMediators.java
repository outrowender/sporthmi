/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.ChangeTimerMediator;
import de.audi.atip.statemachine.mediator.DataUpdateMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;

public class MediaSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected MediaSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[128];
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1712128768, new int[]{-1106312448});
        eventMediatorArray[6] = new ChangeTimerMediator(0, this.smm, 1259143936, new int[]{1309737728}, 0);
        eventMediatorArray[8] = new DataUpdateMediator(0, this.smm, 1242366720, 1208812288, 1225589504, 1225589504, 1494156032, 0);
        eventMediatorArray[15] = new HistoryRestoreMediator(0, this.smm, 1980564224);
        eventMediatorArray[16] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1712128768, new int[]{-1106312448});
        eventMediatorArray[17] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2096299264, new int[]{-1257307392});
        eventMediatorArray[18] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -2079522048, -1072758016);
        eventMediatorArray[21] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1945304320, new int[]{2098135808, 5583});
        eventMediatorArray[25] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1878195456, 1745879808);
        eventMediatorArray[26] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1911749888, new int[]{-1693515008});
        eventMediatorArray[27] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894972672, new int[]{1510933248});
        eventMediatorArray[33] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1660091648, new int[]{-1005649152});
        eventMediatorArray[36] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1559428352, new int[]{990774016});
        eventMediatorArray[37] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1542651136, 1745879808);
        eventMediatorArray[38] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1525873920, new int[]{1494156032});
        eventMediatorArray[41] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1945304320, new int[]{2098135808, 5583});
        eventMediatorArray[42] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[43] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[45] = new HistoryRestoreMediator(0, this.smm, -1458765056);
        eventMediatorArray[46] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1441987840, new int[]{-1357970688});
        eventMediatorArray[48] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1425210624, new int[]{-787545344});
        eventMediatorArray[50] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[52] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1173552384, new int[]{672006912});
        eventMediatorArray[53] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[56] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894972672, new int[]{1510933248});
        eventMediatorArray[57] = new ChangeMediator((long)0, (MediatorManager)this.smm, -905116928, new int[]{1376715520});
        eventMediatorArray[58] = new ChangeTimerMediator(0, this.smm, 1259143936, new int[]{1309737728}, 0);
        eventMediatorArray[59] = new ChangeMediator((long)0, (MediatorManager)this.smm, -854785280, new int[]{957350656});
        eventMediatorArray[62] = new ChangeMediator((long)0, (MediatorManager)this.smm, -787676416, new int[]{-854654208});
        eventMediatorArray[72] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894972672, new int[]{1510933248});
        eventMediatorArray[73] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -703790336, 1745879808);
        eventMediatorArray[74] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -720567552, -1777401088);
        eventMediatorArray[75] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -603127040, 1745879808);
        eventMediatorArray[76] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -619904256, -1777401088);
        eventMediatorArray[77] = new DataUpdateMediator(0, this.smm, -687013120, -687013120, -687013120, -1, -1777401088);
        eventMediatorArray[78] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -569572608, 1745879808);
        eventMediatorArray[79] = new ChangeTimerMediator(0, this.smm, -1962081536, new int[]{68092672}, 0);
        eventMediatorArray[80] = new ChangeTimerMediator(0, this.smm, -1962081536, new int[]{68092672}, 0);
        eventMediatorArray[81] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -502463744, -368114944);
        eventMediatorArray[82] = new ChangeMediator((long)0, (MediatorManager)this.smm, -485686528, new int[]{1393623808, -166788352});
        eventMediatorArray[83] = new ChangeMediator((long)0, (MediatorManager)this.smm, -468909312, new int[]{-183565568, 1360069376});
        eventMediatorArray[84] = new DataUpdateMediator(0, this.smm, 1913455360, 1930232576, -1, -1, -586218752, 0);
        eventMediatorArray[85] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[87] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[88] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[89] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[90] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[92] = new ChangeMediator((long)0, (MediatorManager)this.smm, -435354880, new int[]{-1626340608});
        eventMediatorArray[93] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1525873920, new int[]{1494156032});
        eventMediatorArray[94] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1947009792, new int[]{1510933248});
        eventMediatorArray[95] = new ChangeMediator((long)0, (MediatorManager)this.smm, 621675264, new int[]{-300145920});
        eventMediatorArray[96] = new ChangeMediator((long)0, (MediatorManager)this.smm, -452132096, new int[]{1025254144, -1508367616});
        eventMediatorArray[97] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[98] = new ChangeMediator((long)0, (MediatorManager)this.smm, 655229696, new int[]{-972094720});
        eventMediatorArray[99] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1947009792, new int[]{1510933248});
        eventMediatorArray[100] = new ChangeMediator((long)0, (MediatorManager)this.smm, 688784128, new int[]{335});
        eventMediatorArray[101] = new ChangeMediator((long)0, (MediatorManager)this.smm, 705561344, new int[]{335});
        eventMediatorArray[102] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[103] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1190329600, new int[]{1242497792});
        eventMediatorArray[104] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 722338560, -938474752);
        eventMediatorArray[105] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1945304320, new int[]{2098135808, 5583});
        eventMediatorArray[106] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1947009792, new int[]{1494156032});
        eventMediatorArray[108] = new ChangeMediator((long)0, (MediatorManager)this.smm, 739115776, new int[]{4239});
        eventMediatorArray[109] = new WaitScreenMediator(0, this.smm, 772670208, 873530112, 0);
        eventMediatorArray[110] = new WaitScreenMediator(0, this.smm, 772670208, 873530112, 0);
        eventMediatorArray[114] = new ChangeTimerMediator(0, this.smm, -1962081536, new int[]{68092672}, 0);
        eventMediatorArray[116] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1190329600, new int[]{1242497792});
        eventMediatorArray[118] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894907136, new int[]{1124991744});
        eventMediatorArray[119] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894907136, new int[]{1124991744});
        eventMediatorArray[120] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[121] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[122] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[123] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[124] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[125] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[126] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[127] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

