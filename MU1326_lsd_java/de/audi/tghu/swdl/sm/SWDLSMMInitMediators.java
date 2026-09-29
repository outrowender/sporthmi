/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.DataUpdateMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import de.audi.atip.statemachine.mediator.WaitTimerMediator;

public class SWDLSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SWDLSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[47];
        eventMediatorArray[1] = new DataUpdateMediator(0, this.smm, -1477437184, -1510991616, -1494214400, -1, 703666432);
        eventMediatorArray[2] = new DataUpdateMediator(0, this.smm, -1427105536, -1460659968, -1443882752, -1, 770775296);
        eventMediatorArray[3] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1343219456, 636557568);
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, -957343488, new int[]{-101705472});
        eventMediatorArray[5] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1343219456, 636557568);
        eventMediatorArray[6] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1343219456, 636557568);
        eventMediatorArray[8] = new DataUpdateMediator(0, this.smm, -537913088, -588244736, -554690304, -571467520, -1578034944, 0);
        eventMediatorArray[9] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1343219456, 636557568);
        eventMediatorArray[10] = new ChangeMediator((long)0, (MediatorManager)this.smm, -420472576, new int[]{391});
        eventMediatorArray[11] = new HistoryRestoreMediator(0, this.smm, -386918144);
        eventMediatorArray[13] = new ChangeMediator((long)0, (MediatorManager)this.smm, -303032064, new int[]{3849});
        eventMediatorArray[14] = new ChangeMediator((long)0, (MediatorManager)this.smm, -118482688, new int[]{-571467520});
        eventMediatorArray[16] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, -1343219456, 636557568);
        eventMediatorArray[17] = new ChangeMediator((long)0, (MediatorManager)this.smm, -17819392, new int[]{3849});
        eventMediatorArray[18] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 686889216, -1829693184);
        eventMediatorArray[19] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 99686656, 619780352);
        eventMediatorArray[20] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 99686656, 636557568);
        eventMediatorArray[21] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 99686656, 720443648);
        eventMediatorArray[22] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 133241088, -739239680);
        eventMediatorArray[23] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 133241088, -739239680);
        eventMediatorArray[24] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 166795520, -353298176);
        eventMediatorArray[25] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 166795520, -353298176);
        eventMediatorArray[26] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 200349952, -336520960);
        eventMediatorArray[27] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 200349952, -336520960);
        eventMediatorArray[28] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 166795520, -353298176);
        eventMediatorArray[29] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 200349952, -336520960);
        eventMediatorArray[30] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 99686656, 636557568);
        eventMediatorArray[35] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 267458816, (long)0);
        eventMediatorArray[36] = new HistoryRestoreMediator(0, this.smm, 284236032);
        eventMediatorArray[38] = new WaitSyncMediator((long)0, (MediatorManager)this.smm, 250681600, -1494148864);
        eventMediatorArray[39] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[42] = new ChangeMediator((long)0, (MediatorManager)this.smm, 824583680, new int[]{509});
        eventMediatorArray[43] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[44] = new WaitTimerMediator((long)0, (MediatorManager)this.smm, 703666432, (long)0);
        eventMediatorArray[45] = new ChangeMediator((long)0, (MediatorManager)this.smm, 720443648, new int[]{485628160});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

