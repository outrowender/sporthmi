/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.sm;

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
import de.audi.atip.statemachine.mediator.InfoTimerMediator;
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;
import java.util.NoSuchElementException;

public class ConnectivitySMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected ConnectivitySMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[159];
        eventMediatorArray[1] = new ChangeMediator(2500001L, (MediatorManager)this.smm, 2500013, new int[]{2500126});
        eventMediatorArray[2] = new ChangeMediator(2500002L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[7] = new ChangeMediator(2500007L, (MediatorManager)this.smm, 2500048, new int[]{0x262616});
        eventMediatorArray[10] = new ChangeMediator(2500010L, (MediatorManager)this.smm, 2500035, new int[]{0x262616});
        eventMediatorArray[12] = new WaitScreenMediator(2500012L, this.smm, 2500049, 2500044, 3000L);
        eventMediatorArray[19] = new DataUpdateMediator(2500019L, this.smm, 2500108, 2500105, 2500107, 2500106, 2500185, 3000L);
        eventMediatorArray[20] = new DataUpdateMediator(2500020L, this.smm, 2500108, 2500105, 2500107, 2500106, 2500185, 3000L);
        eventMediatorArray[21] = new DataUpdateMediator(2500021L, this.smm, 2500116, 0x262611, 2500115, 0x262612, 0x262655, 3000L);
        eventMediatorArray[22] = new DataUpdateMediator(2500022L, this.smm, 2500120, 2500117, 2500119, 0x262616, 0x262660, 3000L);
        eventMediatorArray[24] = new DataUpdateMediator(2500024L, this.smm, 2500124, 2500121, 2500123, 2500122, 2500183, 3000L);
        eventMediatorArray[25] = new ChangeMediator(2500025L, (MediatorManager)this.smm, 2500127, new int[]{0x26262C});
        eventMediatorArray[26] = new ChangeMediator(2500026L, (MediatorManager)this.smm, 2500126, new int[]{2500148});
        eventMediatorArray[27] = new ChangeMediator(2500027L, (MediatorManager)this.smm, 0x262620, new int[]{0x26262D});
        eventMediatorArray[28] = new ChangeMediator(2500028L, (MediatorManager)this.smm, 0x262621, new int[]{0x262636});
        eventMediatorArray[29] = new ChangeMediator(2500029L, (MediatorManager)this.smm, 2500125, new int[]{2500151});
        eventMediatorArray[30] = new ChangeTimerMediator(2500030L, this.smm, 0x26262B, new int[]{300614}, 3000L);
        eventMediatorArray[32] = new ChangeMediator(2500032L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[33] = new ChangeMediator(2500033L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686});
        eventMediatorArray[34] = new WaitTimerMediator(2500034L, (MediatorManager)this.smm, 2500152, 3000L);
        eventMediatorArray[35] = new DataUpdateMediator(2500035L, this.smm, 2500158, 2500156, 2500157, 2500157, 0x26266F, 3000L);
        eventMediatorArray[36] = new ChangeMediator(2500036L, (MediatorManager)this.smm, 0x262620, new int[]{0x26262F});
        eventMediatorArray[37] = new ChangeMediator(2500037L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[38] = new ChangeMediator(2500038L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[39] = new ChangeMediator(2500039L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[40] = new ChangeMediator(2500040L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686});
        eventMediatorArray[41] = new ChangeMediator(2500041L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686});
        eventMediatorArray[42] = new InfoTimerMediator(2500042L, (MediatorManager)this.smm, 2500086, 3000L);
        eventMediatorArray[43] = new WaitTimerMediator(2500043L, (MediatorManager)this.smm, 0x262646, 3000L);
        eventMediatorArray[46] = new WaitTimerMediator(2500046L, (MediatorManager)this.smm, 2500168, 3000L);
        eventMediatorArray[47] = new DataUpdateMediator(2500047L, this.smm, 2500176, 2500174, 2500175, -1, 0x262696, 3000L);
        eventMediatorArray[48] = new WaitTimerMediator(2500048L, (MediatorManager)this.smm, 2500177, 3000L);
        eventMediatorArray[49] = new ChangeMediator(2500049L, (MediatorManager)this.smm, 2500125, new int[]{2500151});
        eventMediatorArray[50] = new WaitSyncMediator(2500050L, (MediatorManager)this.smm, 2500145, 3841);
        eventMediatorArray[51] = new WaitSyncMediator(2500051L, (MediatorManager)this.smm, 2500145, 3841);
        eventMediatorArray[52] = new ChangeMediator(2500052L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[53] = new ChangeMediator(2500053L, (MediatorManager)this.smm, 2500184, new int[]{300227, 300953});
        eventMediatorArray[54] = new ChangeMediator(2500054L, (MediatorManager)this.smm, 2500183, new int[]{300664});
        eventMediatorArray[55] = new ChangeMediator(2500055L, (MediatorManager)this.smm, 2500184, new int[]{300227});
        eventMediatorArray[56] = new ChangeMediator(2500056L, (MediatorManager)this.smm, 2500183, new int[]{300664});
        eventMediatorArray[57] = new ChangeMediator(2500057L, (MediatorManager)this.smm, 2500184, new int[]{300227});
        eventMediatorArray[58] = new ChangeMediator(2500058L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[59] = new ChangeMediator(2500059L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[60] = new WaitTimerMediator(2500060L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[61] = new WaitTimerMediator(2500061L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[62] = new ChangeMediator(2500062L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[63] = new WaitTimerMediator(2500063L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[65] = new ChangeMediator(2500065L, (MediatorManager)this.smm, 2500188, new int[]{2500224});
        eventMediatorArray[66] = new HistoryRestoreMediator(2500066L, this.smm, 0x26266B);
        eventMediatorArray[68] = new HistoryRestoreMediator(2500068L, this.smm, 2500222);
        eventMediatorArray[69] = new ChangeMediator(2500069L, (MediatorManager)this.smm, 2500035, new int[]{0x262616});
        eventMediatorArray[70] = new ChangeMediator(2500070L, (MediatorManager)this.smm, 2500035, new int[]{0x262616});
        eventMediatorArray[71] = new ChangeMediator(2500071L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[72] = new HistoryRestoreMediator(2500072L, this.smm, 0x26266B);
        eventMediatorArray[73] = new HistoryRestoreMediator(2500073L, this.smm, 2500209);
        eventMediatorArray[74] = new HistoryRestoreMediator(2500074L, this.smm, 0x262672);
        eventMediatorArray[76] = new HistoryRestoreMediator(2500076L, this.smm, 2500211);
        eventMediatorArray[77] = new ChangeMediator(2500077L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[78] = new ChangeMediator(2500078L, (MediatorManager)this.smm, 2500125, new int[]{2500151});
        eventMediatorArray[79] = new ChangeMediator(2500079L, (MediatorManager)this.smm, 2500127, new int[]{0x26262C});
        eventMediatorArray[80] = new ChangeMediator(2500080L, (MediatorManager)this.smm, 0x262620, new int[]{0x26262D});
        eventMediatorArray[81] = new ChangeMediator(2500081L, (MediatorManager)this.smm, 0x262620, new int[]{0x26262F});
        eventMediatorArray[82] = new ChangeMediator(2500082L, (MediatorManager)this.smm, 2500126, new int[]{2500148});
        eventMediatorArray[83] = new ChangeMediator(2500083L, (MediatorManager)this.smm, 0x262621, new int[]{0x262636});
        eventMediatorArray[84] = new ChangeMediator(2500084L, (MediatorManager)this.smm, 2500125, new int[]{2500151});
        eventMediatorArray[85] = new ChangeMediator(2500085L, (MediatorManager)this.smm, 2500188, new int[]{2500224});
        eventMediatorArray[86] = new DataUpdateMediator(2500086L, this.smm, 2500176, 2500174, 2500175, -1, 0x262696, 3000L);
        eventMediatorArray[87] = new HistoryRestoreMediator(2500087L, this.smm, 0x26266B);
        eventMediatorArray[88] = new WaitTimerMediator(2500088L, (MediatorManager)this.smm, 2500177, 3000L);
        eventMediatorArray[89] = new WaitTimerMediator(2500089L, (MediatorManager)this.smm, 2500168, 3000L);
        eventMediatorArray[90] = new ChangeMediator(2500090L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[91] = new ChangeMediator(2500091L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[92] = new ChangeMediator(2500092L, (MediatorManager)this.smm, 2500183, new int[]{300664});
        eventMediatorArray[93] = new ChangeMediator(2500093L, (MediatorManager)this.smm, 2500184, new int[]{300227});
        eventMediatorArray[94] = new ChangeMediator(2500094L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686});
        eventMediatorArray[95] = new ChangeMediator(2500095L, (MediatorManager)this.smm, 2500048, new int[]{0x262616});
        eventMediatorArray[96] = new ChangeMediator(0x262600L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686});
        eventMediatorArray[97] = new ChangeMediator(2500097L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[98] = new ChangeMediator(0x262602L, (MediatorManager)this.smm, 0x262633, new int[]{0x262686, 0x262676});
        eventMediatorArray[99] = new ChangeMediator(2500099L, (MediatorManager)this.smm, 2500035, new int[]{0x262616});
        eventMediatorArray[100] = new ChangeMediator(2500100L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[101] = new ChangeMediator(2500101L, (MediatorManager)this.smm, 2500022, new int[]{2500106});
        eventMediatorArray[102] = new ChangeMediator(0x262606L, (MediatorManager)this.smm, 2500035, new int[]{0x262616});
        eventMediatorArray[103] = new ChangeMediator(2500103L, (MediatorManager)this.smm, 2500035, new int[]{0x262616});
        eventMediatorArray[104] = new HistoryRestoreMediator(2500104L, this.smm, 2500211);
        eventMediatorArray[105] = new InfoTimerMediator(2500105L, (MediatorManager)this.smm, 2500086, 3000L);
        eventMediatorArray[106] = new WaitScreenMediator(2500106L, this.smm, 2500049, 2500044, 3000L);
        eventMediatorArray[107] = new WaitTimerMediator(2500107L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[108] = new WaitTimerMediator(2500108L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[109] = new WaitTimerMediator(2500109L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[110] = new ChangeMediator(2500110L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[111] = new WaitTimerMediator(2500111L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[113] = new WaitTimerMediator(0x262611L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[115] = new ChangeMediator(2500115L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952, 300612});
        eventMediatorArray[116] = new ChangeMediator(2500116L, (MediatorManager)this.smm, 2500184, new int[]{300227, 300953, 300614});
        eventMediatorArray[119] = new ChangeMediator(2500119L, (MediatorManager)this.smm, 2500212, new int[]{2500151});
        eventMediatorArray[120] = new ChangeMediator(2500120L, (MediatorManager)this.smm, 2500212, new int[]{2500151});
        eventMediatorArray[121] = new WaitSyncMediator(2500121L, (MediatorManager)this.smm, 2500187, 2500148);
        eventMediatorArray[122] = new WaitSyncMediator(2500122L, (MediatorManager)this.smm, 2500187, 2500148);
        eventMediatorArray[125] = new WaitTimerMediator(2500125L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[126] = new WaitTimerMediator(2500126L, (MediatorManager)this.smm, 2500099, 2500L);
        eventMediatorArray[127] = new ChangeMediator(2500127L, (MediatorManager)this.smm, 2500221, new int[]{4277});
        eventMediatorArray[128] = new ChangeMediator(0x262620L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[129] = new ChangeMediator(0x262621L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[130] = new ChangeMediator(0x262622L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[131] = new ChangeMediator(0x262623L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[132] = new ChangeMediator(0x262624L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[133] = new ChangeMediator(0x262625L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[134] = new ChangeMediator(0x262626L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[135] = new ChangeMediator(0x262627L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[136] = new WaitTimerMediator(0x262628L, (MediatorManager)this.smm, 2500225, 3000L);
        eventMediatorArray[137] = new ChangeMediator(0x262629L, (MediatorManager)this.smm, 2500233, new int[]{2500377});
        eventMediatorArray[138] = new ChangeMediator(0x26262AL, (MediatorManager)this.smm, 2500233, new int[]{2500377});
        eventMediatorArray[142] = new WaitTimerMediator(0x26262EL, (MediatorManager)this.smm, 2500282, 15000L);
        eventMediatorArray[143] = new ChangeMediator(0x26262FL, (MediatorManager)this.smm, 0x2626BB, new int[]{4239});
        eventMediatorArray[144] = new ChangeMediator(2500144L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[145] = new ChangeMediator(2500145L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[146] = new ChangeMediator(0x262632L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[149] = new ChangeMediator(2500149L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[150] = new ChangeMediator(0x262636L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[151] = new ChangeMediator(2500151L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[152] = new ChangeMediator(2500152L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[153] = new ChangeMediator(2500153L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[154] = new ChangeMediator(2500154L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[155] = new ChangeMediator(2500155L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[156] = new ChangeMediator(2500156L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[157] = new ChangeMediator(2500157L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[158] = new ChangeMediator(2500158L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

