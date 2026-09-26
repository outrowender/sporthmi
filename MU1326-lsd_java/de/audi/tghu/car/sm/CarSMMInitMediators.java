/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.sm;

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
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;

public class CarSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected CarSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[75];
        eventMediatorArray[0] = new DataUpdateMediator(0, this.smm, 136841472, 103287040, 120064256, -1, 657000704, 0);
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, 573049088, new int[]{52});
        eventMediatorArray[3] = new ChangeMediator((long)0, (MediatorManager)this.smm, 573049088, new int[]{52});
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, 589826304, new int[]{1613302016});
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 623380736, new int[]{1814628608});
        eventMediatorArray[9] = new ChangeMediator((long)0, (MediatorManager)this.smm, 673712384, new int[]{1797851392});
        eventMediatorArray[13] = new ChangeMediator((long)0, (MediatorManager)this.smm, 740821248, new int[]{-987100928});
        eventMediatorArray[14] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 774375680, -534050560);
        eventMediatorArray[15] = new ChangeMediator((long)0, (MediatorManager)this.smm, 807930112, new int[]{-1238693632});
        eventMediatorArray[16] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824707328, new int[]{-1188361984});
        eventMediatorArray[17] = new ChangeMediator((long)0, (MediatorManager)this.smm, 858261760, new int[]{-1138030336});
        eventMediatorArray[18] = new HistoryRestoreMediator(0, this.smm, 1326252800);
        eventMediatorArray[23] = new ChangeMediator((long)0, (MediatorManager)this.smm, 975702272, new int[]{-919926528});
        eventMediatorArray[24] = new ChangeMediator((long)0, (MediatorManager)this.smm, 975702272, new int[]{-919926528});
        eventMediatorArray[25] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 1227360512, 1579747584);
        eventMediatorArray[26] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1378355456, (long)0);
        eventMediatorArray[33] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1797785856, (long)0);
        eventMediatorArray[34] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1479018752, (long)0);
        eventMediatorArray[36] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 1579682048, (long)0);
        eventMediatorArray[37] = new ChangeMediator((long)0, (MediatorManager)this.smm, 573049088, new int[]{52});
        eventMediatorArray[38] = new ChangeMediator((long)0, (MediatorManager)this.smm, 573049088, new int[]{52});
        eventMediatorArray[39] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 1646790912, (long)0);
        eventMediatorArray[40] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1697122560, new int[]{-1507063552, -2060842752});
        eventMediatorArray[41] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1713899776, new int[]{-1507063552});
        eventMediatorArray[42] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1747454208, new int[]{-282457856});
        eventMediatorArray[43] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1781008640, new int[]{-1456731904});
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1999112448, new int[]{1580009728});
        eventMediatorArray[48] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[49] = new ChangeMediator((long)0, (MediatorManager)this.smm, -282588928, new int[]{-250863616});
        eventMediatorArray[51] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1493, new int[]{352});
        eventMediatorArray[52] = new HistoryRestoreMediator(0, this.smm, -30930688);
        eventMediatorArray[53] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 0x2290900, (long)0);
        eventMediatorArray[54] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 19466496, -718403328);
        eventMediatorArray[57] = new ChangeMediator((long)0, (MediatorManager)this.smm, 120129792, new int[]{-215086848});
        eventMediatorArray[60] = new ChangeMediator((long)0, (MediatorManager)this.smm, 254347520, new int[]{-250863616});
        eventMediatorArray[61] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[62] = new HistoryRestoreMediator(0, this.smm, 321456384);
        eventMediatorArray[63] = new HistoryRestoreMediator(0, this.smm, 371788032);
        eventMediatorArray[65] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 455674112, -2014242560);
        eventMediatorArray[66] = new HistoryRestoreMediator(0, this.smm, -30930688);
        eventMediatorArray[67] = new HistoryRestoreMediator(0, this.smm, 925501696);
        eventMediatorArray[68] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[70] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[71] = new HistoryRestoreMediator(0, this.smm, -30930688);
        eventMediatorArray[72] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[73] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[74] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

