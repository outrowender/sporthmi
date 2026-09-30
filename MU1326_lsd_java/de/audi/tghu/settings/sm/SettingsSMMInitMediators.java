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
import java.util.NoSuchElementException;

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
        eventMediatorArray[49] = new WaitSyncMediator(1100049L, (MediatorManager)this.smm, 1100081, 1100276);
        eventMediatorArray[50] = new ChangeMediator(1100050L, (MediatorManager)this.smm, 1100068, new int[]{1100143});
        eventMediatorArray[51] = new ChangeMediator(1100051L, (MediatorManager)this.smm, 1100083, new int[]{1100291});
        eventMediatorArray[52] = new ChangeMediator(1100052L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[53] = new ChangeMediator(1100053L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[54] = new ChangeMediator(1100054L, (MediatorManager)this.smm, 1100099, new int[]{1100228});
        eventMediatorArray[55] = new ChangeMediator(1100055L, (MediatorManager)this.smm, 1492, new int[]{377, 1000019});
        eventMediatorArray[56] = new HistoryRestoreMediator(1100056L, this.smm, 1100101);
        eventMediatorArray[57] = new HistoryRestoreMediator(1100057L, this.smm, 1100058);
        eventMediatorArray[58] = new InfoTimerMediator(1100058L, (MediatorManager)this.smm, 1100102, 3000L);
        eventMediatorArray[59] = new WaitScreenMediator(1100059L, (MediatorManager)this.smm, 1486, 4528);
        eventMediatorArray[60] = new WaitSyncMediator(1100060L, (MediatorManager)this.smm, 1700132, 1700231);
        eventMediatorArray[61] = new WaitTimerMediator(1100061L, (MediatorManager)this.smm, 1100074, 3000L);
        eventMediatorArray[62] = new ChangeMediator(1100062L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[63] = new ChangeMediator(1100063L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

