/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.sm;

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
import de.audi.atip.statemachine.mediator.WaitOnChangeMediator;
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitSyncTimeoutMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;
import java.util.NoSuchElementException;

public class OnlineSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected OnlineSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[174];
        eventMediatorArray[0] = new ChangeMediator(2300000L, (MediatorManager)this.smm, 2300007, new int[]{2300773});
        eventMediatorArray[1] = new ChangeMediator(2300001L, (MediatorManager)this.smm, 2300004, new int[]{204});
        eventMediatorArray[4] = new HistoryRestoreMediator(2300004L, this.smm, 2300008);
        eventMediatorArray[5] = new ChangeMediator(2300005L, (MediatorManager)this.smm, 2300009, new int[]{2300853});
        eventMediatorArray[8] = new WaitScreenMediator(2300008L, this.smm, 400163, 2300898, 3000L);
        eventMediatorArray[12] = new ChangeMediator(2300012L, (MediatorManager)this.smm, 2300015, new int[]{2300960});
        eventMediatorArray[14] = new ChangeMediator(2300014L, (MediatorManager)this.smm, 2300020, new int[]{2300877});
        eventMediatorArray[15] = new ChangeMediator(2300015L, (MediatorManager)this.smm, 2300024, new int[]{2300961});
        eventMediatorArray[20] = new WaitSyncMediator(2300020L, (MediatorManager)this.smm, 400164, 3841);
        eventMediatorArray[24] = new HistoryRestoreMediator(2300024L, this.smm, 2300008);
        eventMediatorArray[26] = new ChangeMediator(2300026L, (MediatorManager)this.smm, 2300033, new int[]{4097});
        eventMediatorArray[31] = new ChangeMediator(2300031L, this.smm, 2300037, true, new int[]{2301017});
        eventMediatorArray[33] = new ChangeMediator(2300033L, (MediatorManager)this.smm, 2300038, new int[]{2301088});
        eventMediatorArray[35] = new ChangeMediator(2300035L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[36] = new ChangeTimerMediator(2300036L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[37] = new DataUpdateMediator(2300037L, this.smm, 400324, 400324, 400324, 400324, 167, 3000L);
        eventMediatorArray[38] = new WaitScreenMediator(2300038L, this.smm, 400158, 2300937, 3000L);
        eventMediatorArray[39] = new ChangeMediator(2300039L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[40] = new ChangeTimerMediator(2300040L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[41] = new DataUpdateMediator(2300041L, this.smm, 400324, 400324, 400324, 400324, 167, 3000L);
        eventMediatorArray[43] = new ChangeMediator(2300043L, (MediatorManager)this.smm, 2300042, new int[]{2301157});
        eventMediatorArray[44] = new ChangeMediator(2300044L, (MediatorManager)this.smm, 1700108, new int[]{4097});
        eventMediatorArray[46] = new ChangeMediator(2300046L, (MediatorManager)this.smm, 2300047, new int[]{2301162});
        eventMediatorArray[47] = new ChangeMediator(2300047L, (MediatorManager)this.smm, 2300060, new int[]{2301082});
        eventMediatorArray[49] = new ChangeMediator(2300049L, (MediatorManager)this.smm, 2300053, new int[]{2301153});
        eventMediatorArray[50] = new ChangeMediator(2300050L, (MediatorManager)this.smm, 2300104, new int[]{3848});
        eventMediatorArray[51] = new ChangeMediator(2300051L, (MediatorManager)this.smm, 2300055, new int[]{2301103});
        eventMediatorArray[54] = new ChangeMediator(2300054L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[55] = new ChangeMediator(2300055L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[57] = new ChangeMediator(2300057L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[59] = new ChangeMediator(2300059L, (MediatorManager)this.smm, 2300061, new int[]{2301149});
        eventMediatorArray[61] = new ChangeMediator(2300061L, (MediatorManager)this.smm, 2300063, new int[]{2300989, 2300070});
        eventMediatorArray[62] = new DataUpdateMediator(2300062L, this.smm, 2300046, 2300046, -1, -1, 2301163);
        eventMediatorArray[63] = new HistoryRestoreMediator(2300063L, this.smm, 2300008);
        eventMediatorArray[65] = new HistoryRestoreMediator(2300065L, this.smm, 2300008);
        eventMediatorArray[66] = new HistoryRestoreMediator(2300066L, this.smm, 2300008);
        eventMediatorArray[68] = new ChangeMediator(2300068L, (MediatorManager)this.smm, 1700108, new int[]{4097});
        eventMediatorArray[69] = new HistoryRestoreMediator(2300069L, this.smm, 2300062);
        eventMediatorArray[70] = new HistoryRestoreMediator(2300070L, this.smm, 2300062);
        eventMediatorArray[72] = new ChangeMediator(2300072L, (MediatorManager)this.smm, 1700108, new int[]{4097});
        eventMediatorArray[73] = new ChangeMediator(2300073L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[74] = new ChangeMediator(2300074L, (MediatorManager)this.smm, 2300071, new int[]{2301102});
        eventMediatorArray[75] = new ChangeMediator(2300075L, (MediatorManager)this.smm, 2300047, new int[]{2301079});
        eventMediatorArray[76] = new ChangeMediator(2300076L, (MediatorManager)this.smm, 2300042, new int[]{2301067});
        eventMediatorArray[77] = new ChangeMediator(2300077L, (MediatorManager)this.smm, 2300104, new int[]{4367});
        eventMediatorArray[79] = new ChangeMediator(2300079L, (MediatorManager)this.smm, 2300035, new int[]{2300963});
        eventMediatorArray[80] = new ChangeMediator(2300080L, (MediatorManager)this.smm, 1770, new int[]{2300984});
        eventMediatorArray[81] = new ChangeMediator(2300081L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[82] = new ChangeMediator(2300082L, (MediatorManager)this.smm, 2500145, new int[]{509});
        eventMediatorArray[83] = new ChangeMediator(2300083L, (MediatorManager)this.smm, 1700108, new int[]{4097});
        eventMediatorArray[84] = new ChangeMediator(2300084L, (MediatorManager)this.smm, 2300006, new int[]{2300689});
        eventMediatorArray[85] = new HistoryRestoreMediator(2300085L, this.smm, 2300008);
        eventMediatorArray[87] = new ChangeMediator(2300087L, (MediatorManager)this.smm, 2300075, new int[]{2301162});
        eventMediatorArray[90] = new DataUpdateMediator(2300090L, this.smm, 2300074, 2300074, -1, -1, 2300689);
        eventMediatorArray[91] = new ChangeTimerMediator(2300091L, this.smm, 2300012, new int[]{2301013}, 3000L);
        eventMediatorArray[92] = new ChangeMediator(2300092L, (MediatorManager)this.smm, 2300084, new int[]{2301079});
        eventMediatorArray[93] = new HistoryRestoreMediator(2300093L, this.smm, 2300085);
        eventMediatorArray[94] = new ChangeMediator(2300094L, (MediatorManager)this.smm, 2300063, new int[]{2301200});
        eventMediatorArray[97] = new ChangeMediator(2300097L, (MediatorManager)this.smm, 2300096, new int[]{2301224});
        eventMediatorArray[98] = new HistoryRestoreMediator(2300098L, this.smm, 2300062);
        eventMediatorArray[99] = new WaitScreenMediator(2300099L, this.smm, 2300099, 2301234, 3000L);
        eventMediatorArray[100] = new WaitSyncMediator(2300100L, (MediatorManager)this.smm, 2300097, 2301233);
        eventMediatorArray[101] = new HistoryRestoreMediator(2300101L, this.smm, 2300062);
        eventMediatorArray[102] = new ChangeMediator(2300102L, (MediatorManager)this.smm, 2300009, new int[]{2301235});
        eventMediatorArray[103] = new HistoryRestoreMediator(2300103L, this.smm, 2300085);
        eventMediatorArray[104] = new HistoryRestoreMediator(2300104L, this.smm, 2300085);
        eventMediatorArray[106] = new WaitTimerMediator(2300106L, (MediatorManager)this.smm, 1741, 2500L);
        eventMediatorArray[107] = new HistoryRestoreMediator(2300107L, this.smm, 2300108);
        eventMediatorArray[108] = new ChangeMediator(2300108L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[110] = new WaitSyncMediator(2300110L, (MediatorManager)this.smm, 2300117, 400346);
        eventMediatorArray[111] = new HistoryRestoreMediator(2300111L, this.smm, 2300062);
        eventMediatorArray[112] = new HistoryRestoreMediator(2300112L, this.smm, 2300085);
        eventMediatorArray[113] = new HistoryRestoreMediator(2300113L, this.smm, 2300085);
        eventMediatorArray[114] = new WaitSyncTimeoutMediator(2300114L, this.smm, 2300119, 2300120, 2301213, 10000L);
        eventMediatorArray[115] = new ChangeMediator(2300115L, (MediatorManager)this.smm, 2300063, new int[]{2300070});
        eventMediatorArray[116] = new ChangeMediator(2300116L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[117] = new ChangeMediator(2300117L, (MediatorManager)this.smm, 2300035, new int[]{2300963});
        eventMediatorArray[118] = new ChangeMediator(2300118L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[119] = new ChangeMediator(2300119L, (MediatorManager)this.smm, 2300004, new int[]{204});
        eventMediatorArray[120] = new HistoryRestoreMediator(2300120L, this.smm, 2300085);
        eventMediatorArray[121] = new WaitTimerMediator(2300121L, (MediatorManager)this.smm, 1741, 2500L);
        eventMediatorArray[125] = new ChangeMediator(2300125L, (MediatorManager)this.smm, 400014, new int[]{2301380});
        eventMediatorArray[126] = new ChangeMediator(2300126L, (MediatorManager)this.smm, 2300046, new int[]{2301070});
        eventMediatorArray[127] = new ChangeMediator(2300127L, (MediatorManager)this.smm, 2300165, new int[]{2301402});
        eventMediatorArray[128] = new ChangeMediator(2300128L, (MediatorManager)this.smm, 2300048, new int[]{2301403});
        eventMediatorArray[129] = new ChangeMediator(2300129L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[130] = new ChangeMediator(2300130L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[132] = new ChangeMediator(2300132L, (MediatorManager)this.smm, 2300128, new int[]{52});
        eventMediatorArray[133] = new WaitOnChangeMediator(2300133L, this.smm, 2300130, new int[]{2300989, 2300070}, 400L);
        eventMediatorArray[135] = new HistoryRestoreMediator(2300135L, this.smm, 2300062);
        eventMediatorArray[136] = new ChangeMediator(2300136L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[137] = new ChangeMediator(2300137L, (MediatorManager)this.smm, 2300063, new int[]{2300989, 2300070});
        eventMediatorArray[141] = new ChangeMediator(2300141L, (MediatorManager)this.smm, 2300062, new int[]{2301757});
        eventMediatorArray[144] = new ChangeMediator(2300144L, (MediatorManager)this.smm, 2300164, new int[]{2301759});
        eventMediatorArray[145] = new ChangeMediator(2300145L, (MediatorManager)this.smm, 2300170, new int[]{2301770});
        eventMediatorArray[151] = new ChangeMediator(2300151L, (MediatorManager)this.smm, 2300172, new int[]{300221});
        eventMediatorArray[152] = new WaitOnChangeMediator(2300152L, this.smm, 2300172, new int[]{300221}, 3000L);
        eventMediatorArray[153] = new ChangeMediator(2300153L, (MediatorManager)this.smm, 2300164, new int[]{2301759});
        eventMediatorArray[154] = new ChangeMediator(2300154L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[155] = new ChangeMediator(2300155L, (MediatorManager)this.smm, 121, new int[]{5583, 335});
        eventMediatorArray[156] = new ChangeMediator(2300156L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[157] = new ChangeMediator(2300157L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[159] = new ChangeMediator(2300159L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[164] = new ChangeMediator(2300164L, (MediatorManager)this.smm, 2300128, new int[]{52});
        eventMediatorArray[165] = new HistoryRestoreMediator(2300165L, this.smm, 2300224);
        eventMediatorArray[166] = new DataUpdateMediator(2300166L, this.smm, 2300228, 2300231, 2300230, 2300229, 2301808, 3000L);
        eventMediatorArray[167] = new HistoryRestoreMediator(2300167L, this.smm, 2300232);
        eventMediatorArray[168] = new ChangeMediator(2300168L, (MediatorManager)this.smm, 2300233, new int[]{2301814});
        eventMediatorArray[169] = new ChangeMediator(2300169L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[170] = new ChangeMediator(2300170L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[171] = new ChangeMediator(2300171L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[172] = new ChangeMediator(2300172L, (MediatorManager)this.smm, 2300234, new int[]{2301816});
        eventMediatorArray[173] = new ChangeMediator(2300173L, (MediatorManager)this.smm, 2300128, new int[]{52});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

