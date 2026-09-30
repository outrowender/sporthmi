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
import java.util.NoSuchElementException;

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
        eventMediatorArray[2] = new ChangeMediator(2L, (MediatorManager)this.smm, 1493, new int[]{352});
        eventMediatorArray[3] = new ChangeMediator(3L, (MediatorManager)this.smm, 1491, new int[]{358});
        eventMediatorArray[4] = new ChangeMediator(4L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[5] = new ChangeMediator(5L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[6] = new ChangeMediator(6L, (MediatorManager)this.smm, 1494, new int[]{367});
        eventMediatorArray[7] = new ChangeMediator(7L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[8] = new ChangeMediator(8L, (MediatorManager)this.smm, 1490, new int[]{378});
        eventMediatorArray[9] = new ChangeMediator(9L, (MediatorManager)this.smm, 1505, new int[]{355});
        eventMediatorArray[11] = new ChangeMediator(11L, (MediatorManager)this.smm, 1512, new int[]{354});
        eventMediatorArray[12] = new ChangeMediator(12L, (MediatorManager)this.smm, 1508, new int[]{359});
        eventMediatorArray[14] = new ChangeMediator(14L, (MediatorManager)this.smm, 1510, new int[]{357});
        eventMediatorArray[15] = new ChangeMediator(15L, (MediatorManager)this.smm, 1513, new int[]{372});
        eventMediatorArray[18] = new ChangeMediator(18L, (MediatorManager)this.smm, 1521, new int[]{450});
        eventMediatorArray[19] = new ChangeMediator(19L, (MediatorManager)this.smm, 1522, new int[]{452});
        eventMediatorArray[20] = new ChangeMediator(20L, (MediatorManager)this.smm, 1556, new int[]{456});
        eventMediatorArray[23] = new ChangeMediator(23L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[26] = new ChangeMediator(26L, this.smm, 1733, true, new int[]{545, 4117});
        eventMediatorArray[27] = new ChangeMediator(27L, (MediatorManager)this.smm, 1780, new int[]{11});
        eventMediatorArray[28] = new ChangeMediator(28L, (MediatorManager)this.smm, 1752, new int[]{3848});
        eventMediatorArray[32] = new ChangeMediator(32L, (MediatorManager)this.smm, 300044, new int[]{3895});
        eventMediatorArray[33] = new ChangeMediator(33L, (MediatorManager)this.smm, 1780, new int[]{11});
        eventMediatorArray[34] = new WaitSyncMediator(34L, (MediatorManager)this.smm, 400038, 400346);
        eventMediatorArray[35] = new ChangeMediator(35L, (MediatorManager)this.smm, 1871, new int[]{3930});
        eventMediatorArray[36] = new ChangeMediator(36L, (MediatorManager)this.smm, 1872, new int[]{3933});
        eventMediatorArray[37] = new ChangeMediator(37L, (MediatorManager)this.smm, 1878, new int[]{3944});
        eventMediatorArray[38] = new HistoryRestoreMediator(38L, this.smm, 1879);
        eventMediatorArray[39] = new HistoryRestoreMediator(39L, this.smm, 1879);
        eventMediatorArray[40] = new HistoryRestoreMediator(40L, this.smm, 1879);
        eventMediatorArray[41] = new HistoryRestoreMediator(41L, this.smm, 1879);
        eventMediatorArray[43] = new ChangeMediator(43L, (MediatorManager)this.smm, 1925, new int[]{52});
        eventMediatorArray[44] = new ChangeTimerMediator(44L, this.smm, 1926, new int[]{352}, 5000L);
        eventMediatorArray[47] = new ChangeMediator(47L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[48] = new ChangeMediator(48L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[49] = new ChangeMediator(49L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[50] = new ChangeMediator(50L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[51] = new ChangeMediator(51L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[52] = new ChangeTimerMediator(52L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[53] = new ChangeTimerMediator(53L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[54] = new ChangeTimerMediator(54L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[55] = new ChangeTimerMediator(55L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[56] = new DataUpdateMediator(56L, this.smm, 400324, 400324, 400324, 400324, 167, 3000L);
        eventMediatorArray[57] = new DataUpdateMediator(57L, this.smm, 400324, 400324, 400324, 400324, 167, 3000L);
        eventMediatorArray[58] = new DataUpdateMediator(58L, this.smm, 400324, 400324, 400324, 400324, 167, 3000L);
        eventMediatorArray[59] = new DataUpdateMediator(59L, this.smm, 400324, 400324, 400324, 400324, 167, 3000L);
        eventMediatorArray[60] = new ChangeMediator(60L, (MediatorManager)this.smm, 1491, new int[]{358});
        eventMediatorArray[61] = new ChangeMediator(61L, (MediatorManager)this.smm, 300044, new int[]{3996});
        eventMediatorArray[63] = new WaitSyncMediator(63L, (MediatorManager)this.smm, 400333, 400346);
        eventMediatorArray[64] = new ChangeMediator(64L, (MediatorManager)this.smm, 1943, new int[]{4005});
        eventMediatorArray[66] = new ChangeMediator(66L, (MediatorManager)this.smm, 1958, new int[]{4033});
        eventMediatorArray[67] = new ChangeMediator(67L, (MediatorManager)this.smm, 400355, new int[]{170});
        eventMediatorArray[68] = new HistoryRestoreMediator(68L, this.smm, 1879);
        eventMediatorArray[69] = new HistoryRestoreMediator(69L, this.smm, 1879);
        eventMediatorArray[71] = new ChangeMediator(71L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[72] = new ChangeMediator(72L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[73] = new ChangeMediator(73L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[75] = new ChangeMediator(75L, (MediatorManager)this.smm, 1987, new int[]{4045});
        eventMediatorArray[76] = new ChangeMediator(76L, (MediatorManager)this.smm, 2000, new int[]{4095});
        eventMediatorArray[77] = new WaitSyncMediator(77L, (MediatorManager)this.smm, 2007, 400346);
        eventMediatorArray[94] = new ChangeMediator(94L, (MediatorManager)this.smm, 300409, new int[]{4135});
        eventMediatorArray[95] = new WaitSyncMediator(95L, (MediatorManager)this.smm, 300204, 300691);
        eventMediatorArray[96] = new ChangeMediator(96L, (MediatorManager)this.smm, 2446, new int[]{4146});
        eventMediatorArray[97] = new ChangeMediator(97L, (MediatorManager)this.smm, 2236, new int[]{4179});
        eventMediatorArray[98] = new WaitSyncMediator(98L, (MediatorManager)this.smm, 2237, 400346);
        eventMediatorArray[99] = new HistoryRestoreMediator(99L, this.smm, 1879);
        eventMediatorArray[100] = new ChangeMediator(100L, (MediatorManager)this.smm, 2250, new int[]{4079});
        eventMediatorArray[102] = new ChangeMediator(102L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[103] = new WaitSyncMediator(103L, (MediatorManager)this.smm, 2410, 400346);
        eventMediatorArray[107] = new ChangeMediator(107L, (MediatorManager)this.smm, 2356, new int[]{4370});
        eventMediatorArray[110] = new ChangeMediator(110L, (MediatorManager)this.smm, 2426, new int[]{4384});
        eventMediatorArray[111] = new ChangeMediator(111L, (MediatorManager)this.smm, 2300035, new int[]{4415});
        eventMediatorArray[112] = new ChangeMediator(112L, (MediatorManager)this.smm, 2438, new int[]{4451});
        eventMediatorArray[113] = new ChangeMediator(113L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[114] = new ChangeMediator(114L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[115] = new ChangeMediator(115L, (MediatorManager)this.smm, 2440, new int[]{4498});
        eventMediatorArray[116] = new ChangeMediator(116L, (MediatorManager)this.smm, 2300124, new int[]{3947});
        eventMediatorArray[117] = new ChangeMediator(117L, (MediatorManager)this.smm, 2300123, new int[]{4386});
        eventMediatorArray[118] = new WaitSyncMediator(118L, (MediatorManager)this.smm, 2447, 400346);
        eventMediatorArray[120] = new ChangeMediator(120L, (MediatorManager)this.smm, 2456, new int[]{4587});
        eventMediatorArray[122] = new ChangeMediator(122L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[124] = new WaitSyncMediator(124L, (MediatorManager)this.smm, 2462, 500157);
        eventMediatorArray[125] = new ChangeMediator(125L, (MediatorManager)this.smm, 1649, new int[]{48});
        eventMediatorArray[127] = new ChangeMediator(127L, (MediatorManager)this.smm, 1494, new int[]{367});
        eventMediatorArray[128] = new ChangeMediator(128L, (MediatorManager)this.smm, 1498, new int[]{361});
        eventMediatorArray[155] = new WaitSyncMediator(155L, (MediatorManager)this.smm, 2797, 1700231);
        eventMediatorArray[156] = new ChangeMediator(156L, (MediatorManager)this.smm, 2454, new int[]{4586, 4622});
        eventMediatorArray[160] = new ChangeMediator(160L, (MediatorManager)this.smm, 2799, new int[]{5583, 335});
        eventMediatorArray[161] = new WaitSyncMediator(161L, (MediatorManager)this.smm, 2801, 1700231);
        eventMediatorArray[179] = new ChangeMediator(179L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[180] = new ChangeMediator(180L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[181] = new ChangeMediator(181L, (MediatorManager)this.smm, 2799, new int[]{5583});
        eventMediatorArray[182] = new ChangeMediator(182L, (MediatorManager)this.smm, 3077, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

