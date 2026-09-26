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
        eventMediatorArray[1] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1390074368, new int[]{505816576});
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[7] = new ChangeMediator((long)0, (MediatorManager)this.smm, -802871808, new int[]{371598848});
        eventMediatorArray[10] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1020975616, new int[]{371598848});
        eventMediatorArray[12] = new WaitScreenMediator(0, this.smm, -786094592, -869980672, 0);
        eventMediatorArray[19] = new DataUpdateMediator(0, this.smm, 203826688, 153495040, 187049472, 170272256, 1495672320, 0);
        eventMediatorArray[20] = new DataUpdateMediator(0, this.smm, 203826688, 153495040, 187049472, 170272256, 1495672320, 0);
        eventMediatorArray[21] = new DataUpdateMediator(0, this.smm, 338044416, 287712768, 321267200, 304489984, 1428563456, 0);
        eventMediatorArray[22] = new DataUpdateMediator(0, this.smm, 405153280, 354821632, 388376064, 371598848, 0x60262600, 0);
        eventMediatorArray[24] = new DataUpdateMediator(0, this.smm, 472262144, 421930496, 455484928, 438707712, 1462117888, 0);
        eventMediatorArray[25] = new ChangeMediator((long)0, (MediatorManager)this.smm, 522593792, new int[]{740697600});
        eventMediatorArray[26] = new ChangeMediator((long)0, (MediatorManager)this.smm, 505816576, new int[]{874915328});
        eventMediatorArray[27] = new ChangeMediator((long)0, (MediatorManager)this.smm, 0x20262600, new int[]{757474816});
        eventMediatorArray[28] = new ChangeMediator((long)0, (MediatorManager)this.smm, 556148224, new int[]{908469760});
        eventMediatorArray[29] = new ChangeMediator((long)0, (MediatorManager)this.smm, 489039360, new int[]{925246976});
        eventMediatorArray[30] = new ChangeTimerMediator(0, this.smm, 723920384, new int[]{1184236544}, 0);
        eventMediatorArray[32] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[33] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256});
        eventMediatorArray[34] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 942024192, (long)0);
        eventMediatorArray[35] = new DataUpdateMediator(0, this.smm, 1042687488, 1009133056, 1025910272, 1025910272, 1864771072, 0);
        eventMediatorArray[36] = new ChangeMediator((long)0, (MediatorManager)this.smm, 0x20262600, new int[]{791029248});
        eventMediatorArray[37] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[38] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[39] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[40] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256});
        eventMediatorArray[41] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256});
        eventMediatorArray[42] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, -165337600, (long)0);
        eventMediatorArray[43] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1176905216, (long)0);
        eventMediatorArray[46] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1210459648, (long)0);
        eventMediatorArray[47] = new DataUpdateMediator(0, this.smm, 1344677376, 1311122944, 1327900160, -1, -1775884800, 0);
        eventMediatorArray[48] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1361454592, (long)0);
        eventMediatorArray[49] = new ChangeMediator((long)0, (MediatorManager)this.smm, 489039360, new int[]{925246976});
        eventMediatorArray[50] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 824583680, 3841);
        eventMediatorArray[51] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 824583680, 3841);
        eventMediatorArray[52] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[53] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824, -1718156288});
        eventMediatorArray[54] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344});
        eventMediatorArray[55] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824});
        eventMediatorArray[56] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344});
        eventMediatorArray[57] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824});
        eventMediatorArray[58] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[59] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[60] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[61] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[62] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[63] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[65] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1546003968, new int[]{-2144983552});
        eventMediatorArray[66] = new HistoryRestoreMediator(0, this.smm, 1797662208);
        eventMediatorArray[68] = new HistoryRestoreMediator(0, this.smm, 2116429312);
        eventMediatorArray[69] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1020975616, new int[]{371598848});
        eventMediatorArray[70] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1020975616, new int[]{371598848});
        eventMediatorArray[71] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[72] = new HistoryRestoreMediator(0, this.smm, 1797662208);
        eventMediatorArray[73] = new HistoryRestoreMediator(0, this.smm, 1898325504);
        eventMediatorArray[74] = new HistoryRestoreMediator(0, this.smm, 1915102720);
        eventMediatorArray[76] = new HistoryRestoreMediator(0, this.smm, 1931879936);
        eventMediatorArray[77] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[78] = new ChangeMediator((long)0, (MediatorManager)this.smm, 489039360, new int[]{925246976});
        eventMediatorArray[79] = new ChangeMediator((long)0, (MediatorManager)this.smm, 522593792, new int[]{740697600});
        eventMediatorArray[80] = new ChangeMediator((long)0, (MediatorManager)this.smm, 0x20262600, new int[]{757474816});
        eventMediatorArray[81] = new ChangeMediator((long)0, (MediatorManager)this.smm, 0x20262600, new int[]{791029248});
        eventMediatorArray[82] = new ChangeMediator((long)0, (MediatorManager)this.smm, 505816576, new int[]{874915328});
        eventMediatorArray[83] = new ChangeMediator((long)0, (MediatorManager)this.smm, 556148224, new int[]{908469760});
        eventMediatorArray[84] = new ChangeMediator((long)0, (MediatorManager)this.smm, 489039360, new int[]{925246976});
        eventMediatorArray[85] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1546003968, new int[]{-2144983552});
        eventMediatorArray[86] = new DataUpdateMediator(0, this.smm, 1344677376, 1311122944, 1327900160, -1, -1775884800, 0);
        eventMediatorArray[87] = new HistoryRestoreMediator(0, this.smm, 1797662208);
        eventMediatorArray[88] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1361454592, (long)0);
        eventMediatorArray[89] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1210459648, (long)0);
        eventMediatorArray[90] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[91] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[92] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344});
        eventMediatorArray[93] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824});
        eventMediatorArray[94] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256});
        eventMediatorArray[95] = new ChangeMediator((long)0, (MediatorManager)this.smm, -802871808, new int[]{371598848});
        eventMediatorArray[96] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256});
        eventMediatorArray[97] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[98] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858138112, new int[]{-2044320256, 1982211584});
        eventMediatorArray[99] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1020975616, new int[]{371598848});
        eventMediatorArray[100] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[101] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1239079424, new int[]{170272256});
        eventMediatorArray[102] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1020975616, new int[]{371598848});
        eventMediatorArray[103] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1020975616, new int[]{371598848});
        eventMediatorArray[104] = new HistoryRestoreMediator(0, this.smm, 1931879936);
        eventMediatorArray[105] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, -165337600, (long)0);
        eventMediatorArray[106] = new WaitScreenMediator(0, this.smm, -786094592, -869980672, 0);
        eventMediatorArray[107] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[108] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[109] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[110] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[111] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[113] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[115] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504, 1150682112});
        eventMediatorArray[116] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824, -1718156288, 1184236544});
        eventMediatorArray[119] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1948657152, new int[]{925246976});
        eventMediatorArray[120] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1948657152, new int[]{925246976});
        eventMediatorArray[121] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1529226752, 874915328);
        eventMediatorArray[122] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1529226752, 874915328);
        eventMediatorArray[125] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[126] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 52831744, (long)0);
        eventMediatorArray[127] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2099652096, new int[]{4277});
        eventMediatorArray[128] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[129] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[130] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[131] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[132] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[133] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[134] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[135] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[136] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -2128206336, (long)0);
        eventMediatorArray[137] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1993988608, new int[]{421996032});
        eventMediatorArray[138] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1993988608, new int[]{421996032});
        eventMediatorArray[142] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1171905024, (long)0);
        eventMediatorArray[143] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1155127808, new int[]{4239});
        eventMediatorArray[144] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[145] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[146] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[149] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[150] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[151] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[152] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[153] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[154] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[155] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[156] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[157] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[158] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

