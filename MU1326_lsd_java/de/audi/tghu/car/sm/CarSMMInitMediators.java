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
import java.util.NoSuchElementException;

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
        eventMediatorArray[0] = new DataUpdateMediator(600000L, this.smm, 600072, 600070, 600071, -1, 600359, 3000L);
        eventMediatorArray[2] = new ChangeMediator(600002L, (MediatorManager)this.smm, 600098, new int[]{52});
        eventMediatorArray[3] = new ChangeMediator(600003L, (MediatorManager)this.smm, 600098, new int[]{52});
        eventMediatorArray[4] = new ChangeMediator(600004L, (MediatorManager)this.smm, 600099, new int[]{600416});
        eventMediatorArray[5] = new ChangeMediator(600005L, (MediatorManager)this.smm, 600101, new int[]{600428});
        eventMediatorArray[9] = new ChangeMediator(600009L, (MediatorManager)this.smm, 600104, new int[]{600427});
        eventMediatorArray[13] = new ChangeMediator(600013L, (MediatorManager)this.smm, 600108, new int[]{600773});
        eventMediatorArray[14] = new WaitSyncMediator(600014L, (MediatorManager)this.smm, 600110, 601056);
        eventMediatorArray[15] = new ChangeMediator(600015L, (MediatorManager)this.smm, 600112, new int[]{601014});
        eventMediatorArray[16] = new ChangeMediator(600016L, (MediatorManager)this.smm, 600113, new int[]{601017});
        eventMediatorArray[17] = new ChangeMediator(600017L, (MediatorManager)this.smm, 600115, new int[]{601020});
        eventMediatorArray[18] = new HistoryRestoreMediator(600018L, this.smm, 200015);
        eventMediatorArray[23] = new ChangeMediator(600023L, (MediatorManager)this.smm, 600122, new int[]{601033});
        eventMediatorArray[24] = new ChangeMediator(600024L, (MediatorManager)this.smm, 600122, new int[]{601033});
        eventMediatorArray[25] = new WaitSyncMediator(600025L, (MediatorManager)this.smm, 600137, 600414);
        eventMediatorArray[26] = new WaitTimerMediator(600026L, (MediatorManager)this.smm, 600146, 3000L);
        eventMediatorArray[33] = new WaitTimerMediator(600033L, (MediatorManager)this.smm, 600171, 3000L);
        eventMediatorArray[34] = new WaitTimerMediator(600034L, (MediatorManager)this.smm, 600152, 3000L);
        eventMediatorArray[36] = new WaitTimerMediator(600036L, (MediatorManager)this.smm, 600158, 3000L);
        eventMediatorArray[37] = new ChangeMediator(600037L, (MediatorManager)this.smm, 600098, new int[]{52});
        eventMediatorArray[38] = new ChangeMediator(600038L, (MediatorManager)this.smm, 600098, new int[]{52});
        eventMediatorArray[39] = new InfoTimerMediator(600039L, (MediatorManager)this.smm, 600162, 3000L);
        eventMediatorArray[40] = new ChangeMediator(600040L, (MediatorManager)this.smm, 600165, new int[]{601254, 600709});
        eventMediatorArray[41] = new ChangeMediator(600041L, (MediatorManager)this.smm, 600166, new int[]{601254});
        eventMediatorArray[42] = new ChangeMediator(600042L, (MediatorManager)this.smm, 600168, new int[]{600815});
        eventMediatorArray[43] = new ChangeMediator(600043L, (MediatorManager)this.smm, 600170, new int[]{601257});
        eventMediatorArray[47] = new ChangeMediator(600047L, (MediatorManager)this.smm, 600183, new int[]{601438});
        eventMediatorArray[48] = new ChangeMediator(600048L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[49] = new ChangeMediator(600049L, (MediatorManager)this.smm, 600303, new int[]{2100465});
        eventMediatorArray[51] = new ChangeMediator(600051L, (MediatorManager)this.smm, 1493, new int[]{352});
        eventMediatorArray[52] = new HistoryRestoreMediator(600052L, this.smm, 600318);
        eventMediatorArray[53] = new InfoTimerMediator(600053L, (MediatorManager)this.smm, 600322, 3000L);
        eventMediatorArray[54] = new WaitSyncMediator(600054L, (MediatorManager)this.smm, 600321, 601813);
        eventMediatorArray[57] = new ChangeMediator(600057L, (MediatorManager)this.smm, 600327, new int[]{601843});
        eventMediatorArray[60] = new ChangeMediator(600060L, (MediatorManager)this.smm, 600335, new int[]{2100465});
        eventMediatorArray[61] = new ChangeMediator(600061L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[62] = new HistoryRestoreMediator(600062L, this.smm, 600339);
        eventMediatorArray[63] = new HistoryRestoreMediator(600063L, this.smm, 600342);
        eventMediatorArray[65] = new WaitSyncMediator(600065L, (MediatorManager)this.smm, 600347, 1700231);
        eventMediatorArray[66] = new HistoryRestoreMediator(600066L, this.smm, 600318);
        eventMediatorArray[67] = new HistoryRestoreMediator(600067L, this.smm, 600631);
        eventMediatorArray[68] = new ChangeMediator(600068L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[70] = new ChangeMediator(600070L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[71] = new HistoryRestoreMediator(600071L, this.smm, 600318);
        eventMediatorArray[72] = new ChangeMediator(600072L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[73] = new ChangeMediator(600073L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[74] = new ChangeMediator(600074L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

