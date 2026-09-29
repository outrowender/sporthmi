/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.InfoTimerMediator;
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;

public class SettingsSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SettingsSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[64];
        eventMediatorArray[49] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 835260416, -188149760);
        eventMediatorArray[50] = new ChangeMediator((long)0, (MediatorManager)this.smm, 617156608, new int[]{1875447808});
        eventMediatorArray[51] = new ChangeMediator((long)0, (MediatorManager)this.smm, 868814848, new int[]{63574016});
        eventMediatorArray[52] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[53] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[54] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1137250304, new int[]{-993456128});
        eventMediatorArray[55] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377, 1396838144});
        eventMediatorArray[56] = new HistoryRestoreMediator(0, this.smm, 1170804736);
        eventMediatorArray[57] = new HistoryRestoreMediator(0, this.smm, 449384448);
        eventMediatorArray[58] = new InfoTimerMediator((long)0, (MediatorManager)this.smm, 1187581952, (long)0);
        eventMediatorArray[59] = new WaitScreenMediator((long)0, (MediatorManager)this.smm, 1486, 4528);
        eventMediatorArray[60] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 619780352, -2014242560);
        eventMediatorArray[61] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 717819904, (long)0);
        eventMediatorArray[62] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[63] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

