/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.sm;

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

public class PhoneSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected PhoneSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[187];
        eventMediatorArray[9] = new WaitTimerMediator(300009L, (MediatorManager)this.smm, 300056, 50L);
        eventMediatorArray[10] = new WaitSyncMediator(300010L, (MediatorManager)this.smm, 300008, 300371);
        eventMediatorArray[11] = new WaitSyncMediator(300011L, (MediatorManager)this.smm, 300012, 300371);
        eventMediatorArray[12] = new DataUpdateMediator(300012L, this.smm, 300062, 300064, 300063, -1, 300481, 3000L);
        eventMediatorArray[14] = new InfoTimerMediator(300014L, (MediatorManager)this.smm, 300065, 3000L);
        eventMediatorArray[15] = new DataUpdateMediator(300015L, this.smm, 300080, 300082, 300081, -1, 300578, 3000L);
        eventMediatorArray[16] = new InfoTimerMediator(300016L, (MediatorManager)this.smm, 300083, 3000L);
        eventMediatorArray[17] = new DataUpdateMediator(300017L, this.smm, 300084, 300087, 300086, 300085, 300592, 3000L);
        eventMediatorArray[18] = new InfoTimerMediator(300018L, (MediatorManager)this.smm, 300088, 3000L);
        eventMediatorArray[19] = new DataUpdateMediator(300019L, this.smm, 300097, 300099, 300098, -1, 300527, 3000L);
        eventMediatorArray[20] = new InfoTimerMediator(300020L, (MediatorManager)this.smm, 300100, 3000L);
        eventMediatorArray[21] = new DataUpdateMediator(300021L, this.smm, 300102, 300103, 300104, -1, 300527, 3000L);
        eventMediatorArray[22] = new InfoTimerMediator(300022L, (MediatorManager)this.smm, 300105, 3000L);
        eventMediatorArray[23] = new DataUpdateMediator(300023L, this.smm, 300106, 300109, 300108, 300107, 300527, 3000L);
        eventMediatorArray[24] = new InfoTimerMediator(300024L, (MediatorManager)this.smm, 300110, 3000L);
        eventMediatorArray[25] = new ChangeMediator(300025L, (MediatorManager)this.smm, 300115, new int[]{2200237});
        eventMediatorArray[26] = new HistoryRestoreMediator(300026L, this.smm, 300115);
        eventMediatorArray[27] = new DataUpdateMediator(300027L, this.smm, 300118, 300120, 300119, 300119, 300201, 3000L);
        eventMediatorArray[28] = new DataUpdateMediator(300028L, this.smm, 300121, 300123, 300122, 300124, 300199, 3000L);
        eventMediatorArray[31] = new ChangeMediator(300031L, (MediatorManager)this.smm, 300133, new int[]{300870});
        eventMediatorArray[32] = new WaitScreenMediator(300032L, this.smm, 300135, 300199, 3000L);
        eventMediatorArray[33] = new DataUpdateMediator(300033L, this.smm, 300143, 300145, -1, -1, 300635, 3000L);
        eventMediatorArray[34] = new InfoTimerMediator(300034L, (MediatorManager)this.smm, 300146, 3000L);
        eventMediatorArray[35] = new DataUpdateMediator(300035L, this.smm, 300148, 300150, 300149, -1, 300590, 3000L);
        eventMediatorArray[36] = new DataUpdateMediator(300036L, this.smm, 300155, 300157, 300156, -1, 300212, 3000L);
        eventMediatorArray[37] = new DataUpdateMediator(300037L, this.smm, 300160, 300162, 300161, -1, 300216, 3000L);
        eventMediatorArray[38] = new InfoTimerMediator(300038L, (MediatorManager)this.smm, 300158, 3000L);
        eventMediatorArray[39] = new InfoTimerMediator(300039L, (MediatorManager)this.smm, 300163, 3000L);
        eventMediatorArray[40] = new DataUpdateMediator(300040L, this.smm, 300167, 300168, -1, -1, 300214, 3000L);
        eventMediatorArray[41] = new DataUpdateMediator(300041L, this.smm, 300164, 300166, 300165, -1, 300218, 3000L);
        eventMediatorArray[42] = new InfoTimerMediator(300042L, (MediatorManager)this.smm, 300173, 3000L);
        eventMediatorArray[43] = new InfoTimerMediator(300043L, (MediatorManager)this.smm, 300174, 3000L);
        eventMediatorArray[44] = new InfoTimerMediator(300044L, (MediatorManager)this.smm, 300179, 3000L);
        eventMediatorArray[46] = new ChangeMediator(300046L, (MediatorManager)this.smm, 300456, new int[]{300747});
        eventMediatorArray[47] = new ChangeMediator(300047L, (MediatorManager)this.smm, 300189, new int[]{3848, 4196, 4475});
        eventMediatorArray[48] = new ChangeMediator(300048L, (MediatorManager)this.smm, 300197, new int[]{300687});
        eventMediatorArray[50] = new WaitSyncMediator(300050L, (MediatorManager)this.smm, 300216, 300701);
        eventMediatorArray[51] = new WaitTimerMediator(300051L, (MediatorManager)this.smm, 300221, 3000L);
        eventMediatorArray[52] = new ChangeMediator(300052L, (MediatorManager)this.smm, 300188, new int[]{300747});
        eventMediatorArray[53] = new ChangeMediator(300053L, (MediatorManager)this.smm, 300187, new int[]{17});
        eventMediatorArray[55] = new WaitSyncMediator(300055L, (MediatorManager)this.smm, 700015, 700497);
        eventMediatorArray[57] = new ChangeMediator(300057L, (MediatorManager)this.smm, 300227, new int[]{300664});
        eventMediatorArray[58] = new HistoryRestoreMediator(300058L, this.smm, 300228);
        eventMediatorArray[59] = new WaitTimerMediator(300059L, (MediatorManager)this.smm, 300231, 3000L);
        eventMediatorArray[60] = new ChangeMediator(300060L, this.smm, 300232, true, new int[]{300664});
        eventMediatorArray[61] = new ChangeMediator(300061L, this.smm, 300233, true, new int[]{300227});
        eventMediatorArray[63] = new WaitTimerMediator(300063L, (MediatorManager)this.smm, 300255, 3000L);
        eventMediatorArray[71] = new ChangeMediator(300071L, (MediatorManager)this.smm, 300260, new int[]{300729});
        eventMediatorArray[72] = new ChangeMediator(300072L, (MediatorManager)this.smm, 300281, new int[]{300612});
        eventMediatorArray[74] = new WaitSyncMediator(300074L, (MediatorManager)this.smm, 300039, 300373);
        eventMediatorArray[76] = new WaitSyncMediator(300076L, (MediatorManager)this.smm, 300039, 300373);
        eventMediatorArray[77] = new WaitSyncMediator(300077L, (MediatorManager)this.smm, 300265, 2200159);
        eventMediatorArray[78] = new WaitSyncMediator(300078L, (MediatorManager)this.smm, 300266, 2200159);
        eventMediatorArray[79] = new WaitTimerMediator(300079L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[80] = new WaitTimerMediator(300080L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[83] = new ChangeMediator(300083L, (MediatorManager)this.smm, 2500183, new int[]{300664});
        eventMediatorArray[84] = new ChangeMediator(300084L, (MediatorManager)this.smm, 2500184, new int[]{300227});
        eventMediatorArray[85] = new ChangeMediator(300085L, (MediatorManager)this.smm, 300014, new int[]{3848});
        eventMediatorArray[87] = new ChangeMediator(300087L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[88] = new ChangeMediator(300088L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[90] = new ChangeMediator(300090L, (MediatorManager)this.smm, 2500186, new int[]{300612, 300664});
        eventMediatorArray[91] = new WaitSyncMediator(300091L, (MediatorManager)this.smm, 300039, 300373);
        eventMediatorArray[93] = new WaitTimerMediator(300093L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[94] = new ChangeMediator(300094L, (MediatorManager)this.smm, 300283, new int[]{300614});
        eventMediatorArray[95] = new ChangeMediator(300095L, (MediatorManager)this.smm, 300187, new int[]{17});
        eventMediatorArray[97] = new ChangeMediator(300097L, (MediatorManager)this.smm, 1503, new int[]{350});
        eventMediatorArray[98] = new WaitSyncTimeoutMediator(300098L, this.smm, 300276, 300288, 700498, 1500L);
        eventMediatorArray[99] = new WaitSyncTimeoutMediator(300099L, this.smm, 300280, 300289, 2200351, 1500L);
        eventMediatorArray[102] = new HistoryRestoreMediator(300102L, this.smm, 300292);
        eventMediatorArray[103] = new WaitSyncTimeoutMediator(300103L, this.smm, 300411, 300410, 2200351, 1500L);
        eventMediatorArray[105] = new ChangeMediator(300105L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[106] = new ChangeMediator(300106L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[107] = new ChangeMediator(300107L, (MediatorManager)this.smm, 2500186, new int[]{300612, 300664});
        eventMediatorArray[108] = new WaitSyncMediator(300108L, (MediatorManager)this.smm, 300039, 300373);
        eventMediatorArray[110] = new WaitTimerMediator(300110L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[111] = new ChangeMediator(300111L, (MediatorManager)this.smm, 2200166, new int[]{2200143});
        eventMediatorArray[112] = new ChangeMediator(300112L, (MediatorManager)this.smm, 2200166, new int[]{2200143});
        eventMediatorArray[113] = new ChangeMediator(300113L, (MediatorManager)this.smm, 300418, new int[]{300953});
        eventMediatorArray[114] = new ChangeMediator(300114L, (MediatorManager)this.smm, 300419, new int[]{300952});
        eventMediatorArray[117] = new WaitTimerMediator(300117L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[118] = new WaitSyncMediator(300118L, (MediatorManager)this.smm, 300039, 300960);
        eventMediatorArray[119] = new ChangeMediator(300119L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[121] = new WaitTimerMediator(300121L, (MediatorManager)this.smm, 300424, 3000L);
        eventMediatorArray[122] = new ChangeMediator(300122L, (MediatorManager)this.smm, 300426, new int[]{300957});
        eventMediatorArray[125] = new WaitSyncMediator(300125L, (MediatorManager)this.smm, 300434, 300960);
        eventMediatorArray[126] = new WaitSyncMediator(300126L, (MediatorManager)this.smm, 300437, 301021);
        eventMediatorArray[127] = new HistoryRestoreMediator(300127L, this.smm, 300439);
        eventMediatorArray[128] = new ChangeMediator(300128L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[129] = new ChangeMediator(300129L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[130] = new ChangeMediator(300130L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[131] = new ChangeMediator(300131L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[132] = new ChangeMediator(300132L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[133] = new ChangeMediator(300133L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[134] = new ChangeMediator(300134L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[135] = new ChangeMediator(300135L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[136] = new WaitSyncMediator(300136L, (MediatorManager)this.smm, 2200094, 2200328);
        eventMediatorArray[137] = new WaitSyncMediator(300137L, (MediatorManager)this.smm, 2200106, 2200327);
        eventMediatorArray[138] = new ChangeMediator(300138L, (MediatorManager)this.smm, 300441, new int[]{301049});
        eventMediatorArray[139] = new ChangeMediator(300139L, (MediatorManager)this.smm, 300419, new int[]{300952});
        eventMediatorArray[140] = new ChangeMediator(300140L, (MediatorManager)this.smm, 300419, new int[]{300952});
        eventMediatorArray[141] = new WaitSyncMediator(300141L, (MediatorManager)this.smm, 300039, 300960);
        eventMediatorArray[142] = new WaitSyncMediator(300142L, (MediatorManager)this.smm, 300039, 300960);
        eventMediatorArray[143] = new WaitSyncMediator(300143L, (MediatorManager)this.smm, 300434, 300960);
        eventMediatorArray[144] = new WaitSyncMediator(300144L, (MediatorManager)this.smm, 300434, 300960);
        eventMediatorArray[145] = new WaitTimerMediator(300145L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[146] = new WaitTimerMediator(300146L, (MediatorManager)this.smm, 300027, 3000L);
        eventMediatorArray[147] = new ChangeMediator(300147L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[148] = new ChangeMediator(300148L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[149] = new ChangeMediator(300149L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[150] = new ChangeMediator(300150L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[151] = new ChangeMediator(300151L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[152] = new ChangeMediator(300152L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[153] = new ChangeMediator(300153L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[154] = new ChangeMediator(300154L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[155] = new ChangeMediator(300155L, (MediatorManager)this.smm, 300442, new int[]{301049, 300664, 300227, 300957});
        eventMediatorArray[156] = new HistoryRestoreMediator(300156L, this.smm, 300443);
        eventMediatorArray[157] = new ChangeMediator(300157L, (MediatorManager)this.smm, 300445, new int[]{301085});
        eventMediatorArray[158] = new ChangeMediator(300158L, (MediatorManager)this.smm, 300452, new int[]{300503});
        eventMediatorArray[159] = new ChangeMediator(300159L, (MediatorManager)this.smm, 300453, new int[]{4239, 4367, 4091, 4350});
        eventMediatorArray[161] = new WaitScreenMediator(300161L, this.smm, 300285, 300901, 5000L);
        eventMediatorArray[162] = new ChangeMediator(300162L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[163] = new ChangeMediator(300163L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[164] = new ChangeMediator(300164L, (MediatorManager)this.smm, 2500184, new int[]{300227, 300953});
        eventMediatorArray[165] = new ChangeMediator(300165L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[166] = new ChangeMediator(300166L, (MediatorManager)this.smm, 2500184, new int[]{300227, 300953});
        eventMediatorArray[167] = new ChangeMediator(300167L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[168] = new ChangeMediator(300168L, (MediatorManager)this.smm, 2500184, new int[]{300227, 300953});
        eventMediatorArray[170] = new WaitSyncMediator(300170L, (MediatorManager)this.smm, 300517, 2500431);
        eventMediatorArray[173] = new ChangeMediator(300173L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[174] = new ChangeMediator(300174L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[175] = new ChangeMediator(300175L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[176] = new HistoryRestoreMediator(300176L, this.smm, 300541);
        eventMediatorArray[177] = new HistoryRestoreMediator(300177L, this.smm, 300542);
        eventMediatorArray[178] = new ChangeMediator(300178L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[179] = new ChangeMediator(300179L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[180] = new ChangeMediator(300180L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[181] = new ChangeMediator(300181L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[182] = new ChangeMediator(300182L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[183] = new ChangeMediator(300183L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[184] = new ChangeMediator(300184L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[185] = new ChangeMediator(300185L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[186] = new ChangeMediator(300186L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

