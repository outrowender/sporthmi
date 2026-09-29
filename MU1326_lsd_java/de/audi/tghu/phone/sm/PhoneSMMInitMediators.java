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
        eventMediatorArray[9] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 412353536, (long)0);
        eventMediatorArray[10] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -393018368, 1402274816);
        eventMediatorArray[11] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -325909504, 1402274816);
        eventMediatorArray[12] = new DataUpdateMediator(0, this.smm, 513016832, 546571264, 529794048, -1, -1047198720, 0);
        eventMediatorArray[14] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 563348480, (long)0);
        eventMediatorArray[15] = new DataUpdateMediator(0, this.smm, 815006720, 848561152, 831783936, -1, 580256768, 0);
        eventMediatorArray[16] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 865338368, (long)0);
        eventMediatorArray[17] = new DataUpdateMediator(0, this.smm, 882115584, 932447232, 915670016, 898892800, 815137792, 0);
        eventMediatorArray[18] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 949224448, (long)0);
        eventMediatorArray[19] = new DataUpdateMediator(0, this.smm, 1100219392, 1133773824, 1116996608, -1, -275446784, 0);
        eventMediatorArray[20] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 0x44940400, (long)0);
        eventMediatorArray[21] = new DataUpdateMediator(0, this.smm, 1184105472, 1200882688, 1217659904, -1, -275446784, 0);
        eventMediatorArray[22] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 0x49940400, (long)0);
        eventMediatorArray[23] = new DataUpdateMediator(0, this.smm, 1251214336, 1301545984, 1284768768, 1267991552, -275446784, 0);
        eventMediatorArray[24] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 1318323200, (long)0);
        eventMediatorArray[25] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1402209280, new int[]{-1382932224});
        eventMediatorArray[26] = new HistoryRestoreMediator(0, this.smm, 1402209280);
        eventMediatorArray[27] = new DataUpdateMediator(0, this.smm, 1452540928, 1486095360, 1469318144, 1469318144, -1449917440, 0);
        eventMediatorArray[28] = new DataUpdateMediator(0, this.smm, 1502872576, 1536427008, 1519649792, 1553204224, -1483471872, 0);
        eventMediatorArray[31] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1704199168, new int[]{1184302080});
        eventMediatorArray[32] = new WaitScreenMediator(0, this.smm, 1737753600, -1483471872, 0);
        eventMediatorArray[33] = new DataUpdateMediator(0, this.smm, 1871971328, 1905525760, -1, -1, 1536558080, 0);
        eventMediatorArray[34] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 1922302976, (long)0);
        eventMediatorArray[35] = new DataUpdateMediator(0, this.smm, 1955857408, 1989411840, 1972634624, -1, 781583360, 0);
        eventMediatorArray[36] = new DataUpdateMediator(0, this.smm, 2073297920, 2106852352, 2090075136, -1, -1265368064, 0);
        eventMediatorArray[37] = new DataUpdateMediator(0, this.smm, -2137783296, -2104228864, -2121006080, -1, -1198259200, 0);
        eventMediatorArray[38] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 2123629568, (long)0);
        eventMediatorArray[39] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, -2087451648, (long)0);
        eventMediatorArray[40] = new DataUpdateMediator(0, this.smm, -2020342784, -2003565568, -1, -1, -1231813632, 0);
        eventMediatorArray[41] = new DataUpdateMediator(0, this.smm, -2070674432, -2037120000, -2053897216, -1, -1164704768, 0);
        eventMediatorArray[42] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, -1919679488, (long)0);
        eventMediatorArray[43] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, -1902902272, (long)0);
        eventMediatorArray[44] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, -1819016192, (long)0);
        eventMediatorArray[46] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1466629120, new int[]{-879361024});
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1651244032, new int[]{3848, 4196, 4475});
        eventMediatorArray[48] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1517026304, new int[]{-1885993984});
        eventMediatorArray[50] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1198259200, -1651112960);
        eventMediatorArray[51] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -1114373120, (long)0);
        eventMediatorArray[52] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1668021248, new int[]{-879361024});
        eventMediatorArray[53] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1684798464, new int[]{17});
        eventMediatorArray[55] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1873676800, 1370491392);
        eventMediatorArray[57] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1013709824, new int[]{2023097344});
        eventMediatorArray[58] = new HistoryRestoreMediator(0, this.smm, -996932608);
        eventMediatorArray[59] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -946600960, (long)0);
        eventMediatorArray[60] = new ChangeMediator(0, this.smm, -929823744, true, new int[]{2023097344});
        eventMediatorArray[61] = new ChangeMediator(0, this.smm, -913046528, true, new int[]{-1013709824});
        eventMediatorArray[63] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -543947776, (long)0);
        eventMediatorArray[71] = new ChangeMediator((long)0, (MediatorManager)this.smm, -460061696, new int[]{-1181350912});
        eventMediatorArray[72] = new ChangeMediator((long)0, (MediatorManager)this.smm, -107740160, new int[]{1150682112});
        eventMediatorArray[74] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, 1435829248);
        eventMediatorArray[76] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, 1435829248);
        eventMediatorArray[77] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -376175616, 1603412224);
        eventMediatorArray[78] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -359398400, 1603412224);
        eventMediatorArray[79] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[80] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[83] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344});
        eventMediatorArray[84] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824});
        eventMediatorArray[85] = new ChangeMediator((long)0, (MediatorManager)this.smm, -292355072, new int[]{3848});
        eventMediatorArray[87] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[88] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[90] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1512449536, new int[]{1150682112, 2023097344});
        eventMediatorArray[91] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, 1435829248);
        eventMediatorArray[93] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[94] = new ChangeMediator((long)0, (MediatorManager)this.smm, -74185728, new int[]{1184236544});
        eventMediatorArray[95] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1684798464, new int[]{17});
        eventMediatorArray[97] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1503, new int[]{350});
        eventMediatorArray[98] = new WaitSyncTimeoutMediator(0, this.smm, -191626240, 9765888, 1387268608, 0);
        eventMediatorArray[99] = new WaitSyncTimeoutMediator(0, this.smm, -124517376, 26543104, 529735936, 0);
        eventMediatorArray[102] = new HistoryRestoreMediator(0, this.smm, 76874752);
        eventMediatorArray[103] = new WaitSyncTimeoutMediator(0, this.smm, 2073363456, 2056586240, 529735936, 0);
        eventMediatorArray[105] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[106] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[107] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1512449536, new int[]{1150682112, 2023097344});
        eventMediatorArray[108] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, 1435829248);
        eventMediatorArray[110] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[111] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1720852736, new int[]{1334976768});
        eventMediatorArray[112] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1720852736, new int[]{1334976768});
        eventMediatorArray[113] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2104163328, new int[]{-1718156288});
        eventMediatorArray[114] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2087386112, new int[]{-1734933504});
        eventMediatorArray[117] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[118] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, -1600715776);
        eventMediatorArray[119] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[121] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -2003500032, (long)0);
        eventMediatorArray[122] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1969945600, new int[]{-1651047424});
        eventMediatorArray[125] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1835727872, -1600715776);
        eventMediatorArray[126] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1785396224, -577305600);
        eventMediatorArray[127] = new HistoryRestoreMediator(0, this.smm, -1751841792);
        eventMediatorArray[128] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[129] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[130] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[131] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[132] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[133] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[134] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[135] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[136] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 512893184, 143859968);
        eventMediatorArray[137] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 714219776, 127082752);
        eventMediatorArray[138] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1718287360, new int[]{-107543552});
        eventMediatorArray[139] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2087386112, new int[]{-1734933504});
        eventMediatorArray[140] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2087386112, new int[]{-1734933504});
        eventMediatorArray[141] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, -1600715776);
        eventMediatorArray[142] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 127140864, -1600715776);
        eventMediatorArray[143] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1835727872, -1600715776);
        eventMediatorArray[144] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1835727872, -1600715776);
        eventMediatorArray[145] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[146] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, -74251264, (long)0);
        eventMediatorArray[147] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[148] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[149] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[150] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[151] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[152] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[153] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[154] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[155] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1701510144, new int[]{-107543552, 2023097344, -1013709824, -1651047424});
        eventMediatorArray[156] = new HistoryRestoreMediator(0, this.smm, -1684732928);
        eventMediatorArray[157] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1651178496, new int[]{496501760});
        eventMediatorArray[158] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1533737984, new int[]{-678099968});
        eventMediatorArray[159] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1516960768, new int[]{4239, 4367, 4091, 4350});
        eventMediatorArray[161] = new WaitScreenMediator(0, this.smm, -40631296, 1704395776, 0);
        eventMediatorArray[162] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[163] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[164] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824, -1718156288});
        eventMediatorArray[165] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[166] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824, -1718156288});
        eventMediatorArray[167] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[168] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1478895104, new int[]{-1013709824, -1718156288});
        eventMediatorArray[170] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -443218944, 1327965696);
        eventMediatorArray[173] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[174] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[175] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[176] = new HistoryRestoreMediator(0, this.smm, -40565760);
        eventMediatorArray[177] = new HistoryRestoreMediator(0, this.smm, -23788544);
        eventMediatorArray[178] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[179] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[180] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[181] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[182] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[183] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[184] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[185] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[186] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

