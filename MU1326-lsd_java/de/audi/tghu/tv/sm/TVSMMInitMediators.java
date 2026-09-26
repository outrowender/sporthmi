/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;

public class TVSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TVSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[42];
        eventMediatorArray[0] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1353459456, 5583});
        eventMediatorArray[1] = new HistoryRestoreMediator(0, this.smm, 1286350592);
        eventMediatorArray[2] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1470899968, 5583});
        eventMediatorArray[3] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1470899968, 5583});
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1689003776, new int[]{1521231616});
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1722558208, new int[]{-1867766016});
        eventMediatorArray[8] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1890330368, new int[]{-1850988800});
        eventMediatorArray[9] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1907107584, new int[]{-1834211584});
        eventMediatorArray[10] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1990993664, new int[]{1756112640});
        eventMediatorArray[12] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1722558208, new int[]{-1867766016});
        eventMediatorArray[14] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1353459456, 5583});
        eventMediatorArray[15] = new HistoryRestoreMediator(0, this.smm, -2069092608);
        eventMediatorArray[16] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2052315392, new int[]{-1213454592});
        eventMediatorArray[17] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2035538176, new int[]{377});
        eventMediatorArray[20] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[21] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[22] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[23] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[24] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[25] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[26] = new HistoryRestoreMediator(0, this.smm, 1286350592);
        eventMediatorArray[27] = new HistoryRestoreMediator(0, this.smm, 1286350592);
        eventMediatorArray[28] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[29] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1632884992, new int[]{335});
        eventMediatorArray[30] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1632884992, new int[]{335});
        eventMediatorArray[31] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1616107776, new int[]{-122935552});
        eventMediatorArray[32] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1616107776, new int[]{-122935552});
        eventMediatorArray[33] = new ChangeMediator((long)0, (MediatorManager)this.smm, -2001983744, new int[]{-760469760});
        eventMediatorArray[34] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[35] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1470899968, 5583});
        eventMediatorArray[36] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[37] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1470899968, 5583});
        eventMediatorArray[38] = new HistoryRestoreMediator(0, this.smm, -1683216640);
        eventMediatorArray[39] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1269573376, new int[]{1470899968, 5583});
        eventMediatorArray[41] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

