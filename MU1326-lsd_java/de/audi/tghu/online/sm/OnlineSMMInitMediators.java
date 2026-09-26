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
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1729635072, new int[]{1696277248});
        eventMediatorArray[1] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1679303424, new int[]{204});
        eventMediatorArray[4] = new HistoryRestoreMediator(0, this.smm, 1746412288);
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1763189504, new int[]{-1256512768});
        eventMediatorArray[8] = new WaitScreenMediator(0, this.smm, 588973568, -501538048, 0);
        eventMediatorArray[12] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1863852800, new int[]{538714880});
        eventMediatorArray[14] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1947738880, new int[]{-853859584});
        eventMediatorArray[15] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2014847744, new int[]{555492096});
        eventMediatorArray[20] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 605750784, 3841);
        eventMediatorArray[24] = new HistoryRestoreMediator(0, this.smm, 1746412288);
        eventMediatorArray[26] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2129124608, new int[]{4097});
        eventMediatorArray[31] = new ChangeMediator(0, this.smm, -2062015744, true, new int[]{1495016192});
        eventMediatorArray[33] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2045238528, new int[]{-1608768768});
        eventMediatorArray[35] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[36] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[37] = new DataUpdateMediator(0, this.smm, -1004861952, -1004861952, -1004861952, -1004861952, 167, 0);
        eventMediatorArray[38] = new WaitScreenMediator(0, this.smm, 505087488, 152838912, 0);
        eventMediatorArray[39] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[40] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[41] = new DataUpdateMediator(0, this.smm, -1004861952, -1004861952, -1004861952, -1004861952, 167, 0);
        eventMediatorArray[43] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1978129664, new int[]{-451140864});
        eventMediatorArray[44] = new ChangeMediator((long)0, (MediatorManager)this.smm, 217127168, new int[]{4097});
        eventMediatorArray[46] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894243584, new int[]{-367254784});
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1676139776, new int[]{-1709432064});
        eventMediatorArray[49] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1793580288, new int[]{-518249728});
        eventMediatorArray[50] = new ChangeMediator((long)0, (MediatorManager)this.smm, -937942272, new int[]{3848});
        eventMediatorArray[51] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1760025856, new int[]{-1357110528});
        eventMediatorArray[54] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[55] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[57] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[59] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1659362560, new int[]{-585358592});
        eventMediatorArray[61] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1625808128, new int[]{1025254144, -1508367616});
        eventMediatorArray[62] = new DataUpdateMediator(0, this.smm, -1911020800, -1911020800, -1, -1, -350477568);
        eventMediatorArray[63] = new HistoryRestoreMediator(0, this.smm, 1746412288);
        eventMediatorArray[65] = new HistoryRestoreMediator(0, this.smm, 1746412288);
        eventMediatorArray[66] = new HistoryRestoreMediator(0, this.smm, 1746412288);
        eventMediatorArray[68] = new ChangeMediator((long)0, (MediatorManager)this.smm, 217127168, new int[]{4097});
        eventMediatorArray[69] = new HistoryRestoreMediator(0, this.smm, -1642585344);
        eventMediatorArray[70] = new HistoryRestoreMediator(0, this.smm, -1642585344);
        eventMediatorArray[72] = new ChangeMediator((long)0, (MediatorManager)this.smm, 217127168, new int[]{4097});
        eventMediatorArray[73] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[74] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1491590400, new int[]{-1373887744});
        eventMediatorArray[75] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1894243584, new int[]{-1759763712});
        eventMediatorArray[76] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1978129664, new int[]{-1961090304});
        eventMediatorArray[77] = new ChangeMediator((long)0, (MediatorManager)this.smm, -937942272, new int[]{4367});
        eventMediatorArray[79] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2095570176, new int[]{589046528});
        eventMediatorArray[80] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1770, new int[]{941368064});
        eventMediatorArray[81] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[82] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[83] = new ChangeMediator((long)0, (MediatorManager)this.smm, 217127168, new int[]{4097});
        eventMediatorArray[84] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1712857856, new int[]{286991104});
        eventMediatorArray[85] = new HistoryRestoreMediator(0, this.smm, 1746412288);
        eventMediatorArray[87] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1424481536, new int[]{-367254784});
        eventMediatorArray[90] = new DataUpdateMediator(0, this.smm, -1441258752, -1441258752, -1, -1, 286991104);
        eventMediatorArray[91] = new ChangeTimerMediator(0, this.smm, 1813521152, new int[]{1427907328}, 0);
        eventMediatorArray[92] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1273486592, new int[]{-1759763712});
        eventMediatorArray[93] = new HistoryRestoreMediator(0, this.smm, -1256709376);
        eventMediatorArray[94] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1625808128, new int[]{270344960});
        eventMediatorArray[97] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1072160000, new int[]{672998144});
        eventMediatorArray[98] = new HistoryRestoreMediator(0, this.smm, -1642585344);
        eventMediatorArray[99] = new WaitScreenMediator(0, this.smm, -1021828352, 840770304, 0);
        eventMediatorArray[100] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1055382784, 823993088);
        eventMediatorArray[101] = new HistoryRestoreMediator(0, this.smm, -1642585344);
        eventMediatorArray[102] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1763189504, new int[]{857547520});
        eventMediatorArray[103] = new HistoryRestoreMediator(0, this.smm, -1256709376);
        eventMediatorArray[104] = new HistoryRestoreMediator(0, this.smm, -1256709376);
        eventMediatorArray[106] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1741, (long)0);
        eventMediatorArray[107] = new HistoryRestoreMediator(0, this.smm, -870833408);
        eventMediatorArray[108] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[110] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -719838464, -635763200);
        eventMediatorArray[111] = new HistoryRestoreMediator(0, this.smm, -1642585344);
        eventMediatorArray[112] = new HistoryRestoreMediator(0, this.smm, -1256709376);
        eventMediatorArray[113] = new HistoryRestoreMediator(0, this.smm, -1256709376);
        eventMediatorArray[114] = new WaitSyncTimeoutMediator(0, this.smm, -686284032, -669506816, 488448768, 0);
        eventMediatorArray[115] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1625808128, new int[]{-1508367616});
        eventMediatorArray[116] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[117] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2095570176, new int[]{589046528});
        eventMediatorArray[118] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[119] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1679303424, new int[]{204});
        eventMediatorArray[120] = new HistoryRestoreMediator(0, this.smm, -1256709376);
        eventMediatorArray[121] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1741, (long)0);
        eventMediatorArray[125] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1910897152, new int[]{-1004723456});
        eventMediatorArray[126] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1911020800, new int[]{-1910758656});
        eventMediatorArray[127] = new ChangeMediator((long)0, (MediatorManager)this.smm, 85533440, new int[]{-635624704});
        eventMediatorArray[128] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1877466368, new int[]{-618847488});
        eventMediatorArray[129] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[130] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[132] = new ChangeMediator((long)0, (MediatorManager)this.smm, -535289088, new int[]{52});
        eventMediatorArray[133] = new WaitOnChangeMediator(0, this.smm, -501734656, new int[]{1025254144, -1508367616}, 0);
        eventMediatorArray[135] = new HistoryRestoreMediator(0, this.smm, -1642585344);
        eventMediatorArray[136] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[137] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1625808128, new int[]{1025254144, -1508367616});
        eventMediatorArray[141] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1642585344, new int[]{1025450752});
        eventMediatorArray[144] = new ChangeMediator((long)0, (MediatorManager)this.smm, 68756224, new int[]{1059005184});
        eventMediatorArray[145] = new ChangeMediator((long)0, (MediatorManager)this.smm, 169419520, new int[]{1243554560});
        eventMediatorArray[151] = new ChangeMediator((long)0, (MediatorManager)this.smm, 202973952, new int[]{-1114373120});
        eventMediatorArray[152] = new WaitOnChangeMediator(0, this.smm, 202973952, new int[]{-1114373120}, 0);
        eventMediatorArray[153] = new ChangeMediator((long)0, (MediatorManager)this.smm, 68756224, new int[]{1059005184});
        eventMediatorArray[154] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[155] = new ChangeMediator((long)0, (MediatorManager)this.smm, 121, new int[]{5583, 335});
        eventMediatorArray[156] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[157] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[159] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[164] = new ChangeMediator((long)0, (MediatorManager)this.smm, -535289088, new int[]{52});
        eventMediatorArray[165] = new HistoryRestoreMediator(0, this.smm, 1075389184);
        eventMediatorArray[166] = new DataUpdateMediator(0, this.smm, 1142498048, 1192829696, 1176052480, 1159275264, 1881088768, 0);
        eventMediatorArray[167] = new HistoryRestoreMediator(0, this.smm, 1209606912);
        eventMediatorArray[168] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1226384128, new int[]{1981752064});
        eventMediatorArray[169] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[170] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[171] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[172] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1243161344, new int[]{2015306496});
        eventMediatorArray[173] = new ChangeMediator((long)0, (MediatorManager)this.smm, -535289088, new int[]{52});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

