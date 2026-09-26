/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.sm;

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
import de.audi.atip.statemachine.mediator.WaitSyncMediator;

public class SystemSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SystemSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[183];
        eventMediatorArray[0] = new ChangeMediator(0L, (MediatorManager)this.smm, 1503, new int[]{350});
        eventMediatorArray[1] = new ChangeMediator(1L, (MediatorManager)this.smm, 1496, new int[]{375});
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1493, new int[]{352});
        eventMediatorArray[3] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1491, new int[]{358});
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[6] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1494, new int[]{367});
        eventMediatorArray[7] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[8] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1490, new int[]{378});
        eventMediatorArray[9] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1505, new int[]{355});
        eventMediatorArray[11] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1512, new int[]{354});
        eventMediatorArray[12] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1508, new int[]{359});
        eventMediatorArray[14] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1510, new int[]{357});
        eventMediatorArray[15] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1513, new int[]{372});
        eventMediatorArray[18] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1521, new int[]{450});
        eventMediatorArray[19] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1522, new int[]{452});
        eventMediatorArray[20] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1556, new int[]{456});
        eventMediatorArray[23] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[26] = new ChangeMediator(0, this.smm, 1733, true, new int[]{545, 4117});
        eventMediatorArray[27] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1780, new int[]{11});
        eventMediatorArray[28] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1752, new int[]{3848});
        eventMediatorArray[32] = new ChangeMediator((long)0, (MediatorManager)this.smm, 211026944, new int[]{3895});
        eventMediatorArray[33] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1780, new int[]{11});
        eventMediatorArray[34] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1508243968, -635763200);
        eventMediatorArray[35] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1871, new int[]{3930});
        eventMediatorArray[36] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1872, new int[]{3933});
        eventMediatorArray[37] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1878, new int[]{3944});
        eventMediatorArray[38] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[39] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[40] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[41] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[43] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1925, new int[]{52});
        eventMediatorArray[44] = new ChangeTimerMediator(0, this.smm, 1926, new int[]{352}, 0);
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[48] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[49] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[50] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[51] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[52] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[53] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[54] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[55] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[56] = new DataUpdateMediator(0, this.smm, -1004861952, -1004861952, -1004861952, -1004861952, 167, 0);
        eventMediatorArray[57] = new DataUpdateMediator(0, this.smm, -1004861952, -1004861952, -1004861952, -1004861952, 167, 0);
        eventMediatorArray[58] = new DataUpdateMediator(0, this.smm, -1004861952, -1004861952, -1004861952, -1004861952, 167, 0);
        eventMediatorArray[59] = new DataUpdateMediator(0, this.smm, -1004861952, -1004861952, -1004861952, -1004861952, 167, 0);
        eventMediatorArray[60] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1491, new int[]{358});
        eventMediatorArray[61] = new ChangeMediator((long)0, (MediatorManager)this.smm, 211026944, new int[]{3996});
        eventMediatorArray[63] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -853867008, -635763200);
        eventMediatorArray[64] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1943, new int[]{4005});
        eventMediatorArray[66] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1958, new int[]{4033});
        eventMediatorArray[67] = new ChangeMediator((long)0, (MediatorManager)this.smm, -484768256, new int[]{170});
        eventMediatorArray[68] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[69] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[71] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[72] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[73] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[75] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1987, new int[]{4045});
        eventMediatorArray[76] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2000, new int[]{4095});
        eventMediatorArray[77] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2007, -635763200);
        eventMediatorArray[94] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2039809024, new int[]{4135});
        eventMediatorArray[95] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1399585792, -1818885120);
        eventMediatorArray[96] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2446, new int[]{4146});
        eventMediatorArray[97] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2236, new int[]{4179});
        eventMediatorArray[98] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2237, -635763200);
        eventMediatorArray[99] = new HistoryRestoreMediator(0, this.smm, 1879);
        eventMediatorArray[100] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2250, new int[]{4079});
        eventMediatorArray[102] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[103] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2410, -635763200);
        eventMediatorArray[107] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2356, new int[]{4370});
        eventMediatorArray[110] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2426, new int[]{4384});
        eventMediatorArray[111] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2095570176, new int[]{4415});
        eventMediatorArray[112] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2438, new int[]{4451});
        eventMediatorArray[113] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[114] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[115] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2440, new int[]{4498});
        eventMediatorArray[116] = new ChangeMediator((long)0, (MediatorManager)this.smm, -602397952, new int[]{3947});
        eventMediatorArray[117] = new ChangeMediator((long)0, (MediatorManager)this.smm, -619175168, new int[]{4386});
        eventMediatorArray[118] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2447, -635763200);
        eventMediatorArray[120] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2456, new int[]{4587});
        eventMediatorArray[122] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[124] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2462, -1113520384);
        eventMediatorArray[125] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1649, new int[]{48});
        eventMediatorArray[127] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1494, new int[]{367});
        eventMediatorArray[128] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[155] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2797, -2014242560);
        eventMediatorArray[156] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2454, new int[]{4586, 4622});
        eventMediatorArray[160] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2799, new int[]{5583, 335});
        eventMediatorArray[161] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 2801, -2014242560);
        eventMediatorArray[179] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[180] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[181] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2799, new int[]{5583});
        eventMediatorArray[182] = new ChangeMediator((long)0, (MediatorManager)this.smm, 3077, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

