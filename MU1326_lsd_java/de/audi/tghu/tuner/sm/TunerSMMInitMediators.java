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
import java.util.NoSuchElementException;

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
        eventMediatorArray[0] = new DataUpdateMediator(100000L, this.smm, 100018, 100020, 100019, 100019, 100365, 3000L);
        eventMediatorArray[1] = new DataUpdateMediator(100001L, this.smm, 100018, 100020, 100019, 100019, 100390, 3000L);
        eventMediatorArray[9] = new HistoryRestoreMediator(100009L, this.smm, 100047);
        eventMediatorArray[10] = new DataUpdateMediator(100010L, this.smm, 100054, 100052, 100053, -1, 100553, 3000L);
        eventMediatorArray[15] = new ChangeMediator(100015L, (MediatorManager)this.smm, 100067, new int[]{100315});
        eventMediatorArray[18] = new ChangeMediator(100018L, (MediatorManager)this.smm, 100095, new int[]{100154});
        eventMediatorArray[19] = new DataUpdateMediator(100019L, this.smm, 100018, 100020, 100019, 100019, 100522, 3000L);
        eventMediatorArray[20] = new ChangeMediator(100020L, (MediatorManager)this.smm, 100112, new int[]{100327});
        eventMediatorArray[21] = new ChangeMediator(100021L, (MediatorManager)this.smm, 100026, new int[]{100489});
        eventMediatorArray[22] = new ChangeMediator(100022L, (MediatorManager)this.smm, 100026, new int[]{100490});
        eventMediatorArray[23] = new ChangeMediator(100023L, (MediatorManager)this.smm, 100205, new int[]{100549, 100655, 100708});
        eventMediatorArray[25] = new ChangeMediator(100025L, (MediatorManager)this.smm, 100113, new int[]{100327});
        eventMediatorArray[26] = new DataUpdateMediator(100026L, this.smm, 100054, 100052, 100053, -1, 100554, 3000L);
        eventMediatorArray[27] = new ChangeMediator(100027L, (MediatorManager)this.smm, 100114, new int[]{100561});
        eventMediatorArray[29] = new ChangeMediator(100029L, (MediatorManager)this.smm, 100117, new int[]{377});
        eventMediatorArray[30] = new ChangeMediator(100030L, (MediatorManager)this.smm, 100117, new int[]{377});
        eventMediatorArray[31] = new ChangeMediator(100031L, (MediatorManager)this.smm, 100004, new int[]{100316});
        eventMediatorArray[34] = new ChangeMediator(100034L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[35] = new ChangeTimerMediator(100035L, this.smm, 100186, new int[]{100432}, 3000L);
        eventMediatorArray[37] = new ChangeMediator(100037L, (MediatorManager)this.smm, 100021, new int[]{100618});
        eventMediatorArray[38] = new ChangeMediator(100038L, (MediatorManager)this.smm, 100188, new int[]{100327});
        eventMediatorArray[39] = new ChangeMediator(100039L, (MediatorManager)this.smm, 100188, new int[]{100327});
        eventMediatorArray[40] = new ChangeMediator(100040L, (MediatorManager)this.smm, 100021, new int[]{100618});
        eventMediatorArray[41] = new ChangeMediator(100041L, (MediatorManager)this.smm, 100189, new int[]{100446});
        eventMediatorArray[42] = new ChangeMediator(100042L, (MediatorManager)this.smm, 100191, new int[]{100509});
        eventMediatorArray[43] = new ChangeMediator(100043L, (MediatorManager)this.smm, 100192, new int[]{100375});
        eventMediatorArray[44] = new DataUpdateMediator(100044L, this.smm, 100018, 100020, 100019, 100019, 100158, 3000L);
        eventMediatorArray[45] = new ChangeMediator(100045L, (MediatorManager)this.smm, 100199, new int[]{100676});
        eventMediatorArray[46] = new ChangeMediator(100046L, (MediatorManager)this.smm, 100200, new int[]{100676});
        eventMediatorArray[47] = new ChangeMediator(100047L, (MediatorManager)this.smm, 100202, new int[]{100680});
        eventMediatorArray[48] = new ChangeMediator(100048L, (MediatorManager)this.smm, 100201, new int[]{100681});
        eventMediatorArray[50] = new ChangeMediator(100050L, (MediatorManager)this.smm, 100205, new int[]{100550, 100655, 100708});
        eventMediatorArray[51] = new ChangeMediator(100051L, (MediatorManager)this.smm, 100205, new int[]{100549, 100655, 100708});
        eventMediatorArray[52] = new ChangeMediator(100052L, (MediatorManager)this.smm, 100067, new int[]{100727});
        eventMediatorArray[53] = new ChangeMediator(100053L, (MediatorManager)this.smm, 100067, new int[]{100727});
        eventMediatorArray[54] = new ChangeMediator(100054L, (MediatorManager)this.smm, 100067, new int[]{100727});
        eventMediatorArray[55] = new ChangeMediator(100055L, (MediatorManager)this.smm, 100206, new int[]{100489, 100490});
        eventMediatorArray[56] = new ChangeMediator(100056L, (MediatorManager)this.smm, 100205, new int[]{100550, 100655, 100708});
        eventMediatorArray[57] = new ChangeMediator(100057L, (MediatorManager)this.smm, 100205, new int[]{100550, 100655, 100708});
        eventMediatorArray[58] = new ChangeMediator(100058L, (MediatorManager)this.smm, 100205, new int[]{100550, 100655, 100708});
        eventMediatorArray[59] = new ChangeTimerMediator(100059L, this.smm, 400004, new int[]{362}, 3000L);
        eventMediatorArray[60] = new DataUpdateMediator(100060L, this.smm, 100214, 100214, 100214, 100214, 167, 3000L);
        eventMediatorArray[61] = new ChangeMediator(100061L, (MediatorManager)this.smm, 100215, new int[]{4097});
        eventMediatorArray[62] = new ChangeMediator(100062L, (MediatorManager)this.smm, 100216, new int[]{509});
        eventMediatorArray[64] = new HistoryRestoreMediator(100064L, this.smm, 100217);
        eventMediatorArray[65] = new HistoryRestoreMediator(100065L, this.smm, 100219);
        eventMediatorArray[66] = new ChangeMediator(100066L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[67] = new ChangeMediator(100067L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

