/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.sm;

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

public class TunerSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TunerSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[68];
        eventMediatorArray[0] = new DataUpdateMediator(0, this.smm, -1299840768, -1266286336, -1283063552, -1283063552, 227016960, 0);
        eventMediatorArray[1] = new DataUpdateMediator(0, this.smm, -1299840768, -1266286336, -1283063552, -1283063552, 646447360, 0);
        eventMediatorArray[9] = new HistoryRestoreMediator(0, this.smm, -813301504);
        eventMediatorArray[10] = new DataUpdateMediator(0, this.smm, -695860992, -729415424, -712638208, -1, -913833728, 0);
        eventMediatorArray[15] = new ChangeMediator((long)0, (MediatorManager)this.smm, -477757184, new int[]{-611909376});
        eventMediatorArray[18] = new ChangeMediator((long)0, (MediatorManager)this.smm, -7995136, new int[]{981926144});
        eventMediatorArray[19] = new DataUpdateMediator(0, this.smm, -1299840768, -1266286336, -1283063552, -1283063552, -1433927424, 0);
        eventMediatorArray[20] = new ChangeMediator((long)0, (MediatorManager)this.smm, 277283072, new int[]{-410582784});
        eventMediatorArray[21] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1165623040, new int[]{-1987575552});
        eventMediatorArray[22] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1165623040, new int[]{-1970798336});
        eventMediatorArray[23] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1837564160, new int[]{-980942592, 797507840, 1686700288});
        eventMediatorArray[25] = new ChangeMediator((long)0, (MediatorManager)this.smm, 294060288, new int[]{-410582784});
        eventMediatorArray[26] = new DataUpdateMediator(0, this.smm, -695860992, -729415424, -712638208, -1, -897056512, 0);
        eventMediatorArray[27] = new ChangeMediator((long)0, (MediatorManager)this.smm, 310837504, new int[]{-779616000});
        eventMediatorArray[29] = new ChangeMediator((long)0, (MediatorManager)this.smm, 361169152, new int[]{377});
        eventMediatorArray[30] = new ChangeMediator((long)0, (MediatorManager)this.smm, 361169152, new int[]{377});
        eventMediatorArray[31] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1534721792, new int[]{-595132160});
        eventMediatorArray[34] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[35] = new ChangeTimerMediator(0, this.smm, 1518797056, new int[]{1351090432}, 0);
        eventMediatorArray[37] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1249509120, new int[]{176750848});
        eventMediatorArray[38] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1552351488, new int[]{-410582784});
        eventMediatorArray[39] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1552351488, new int[]{-410582784});
        eventMediatorArray[40] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1249509120, new int[]{176750848});
        eventMediatorArray[41] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1569128704, new int[]{1585971456});
        eventMediatorArray[42] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1602683136, new int[]{-1652031232});
        eventMediatorArray[43] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1619460352, new int[]{394789120});
        eventMediatorArray[44] = new DataUpdateMediator(0, this.smm, -1299840768, -1266286336, -1283063552, -1283063552, 1049035008, 0);
        eventMediatorArray[45] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1736900864, new int[]{1149829376});
        eventMediatorArray[46] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1753678080, new int[]{1149829376});
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1787232512, new int[]{1216938240});
        eventMediatorArray[48] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1770455296, new int[]{1233715456});
        eventMediatorArray[50] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1837564160, new int[]{-964165376, 797507840, 1686700288});
        eventMediatorArray[51] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1837564160, new int[]{-980942592, 797507840, 1686700288});
        eventMediatorArray[52] = new ChangeMediator((long)0, (MediatorManager)this.smm, -477757184, new int[]{2005467392});
        eventMediatorArray[53] = new ChangeMediator((long)0, (MediatorManager)this.smm, -477757184, new int[]{2005467392});
        eventMediatorArray[54] = new ChangeMediator((long)0, (MediatorManager)this.smm, -477757184, new int[]{2005467392});
        eventMediatorArray[55] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1854341376, new int[]{-1987575552, -1970798336});
        eventMediatorArray[56] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1837564160, new int[]{-964165376, 797507840, 1686700288});
        eventMediatorArray[57] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1837564160, new int[]{-964165376, 797507840, 1686700288});
        eventMediatorArray[58] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1837564160, new int[]{-964165376, 797507840, 1686700288});
        eventMediatorArray[59] = new ChangeTimerMediator(0, this.smm, -2078669312, new int[]{362}, 0);
        eventMediatorArray[60] = new DataUpdateMediator(0, this.smm, 1988559104, 1988559104, 1988559104, 1988559104, 167, 0);
        eventMediatorArray[61] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2005336320, new int[]{4097});
        eventMediatorArray[62] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2022113536, new int[]{509});
        eventMediatorArray[64] = new HistoryRestoreMediator(0, this.smm, 2038890752);
        eventMediatorArray[65] = new HistoryRestoreMediator(0, this.smm, 2072445184);
        eventMediatorArray[66] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[67] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

