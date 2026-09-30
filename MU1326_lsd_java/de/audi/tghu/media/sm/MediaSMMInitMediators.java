/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.sm;

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
import de.audi.atip.statemachine.mediator.WaitScreenMediator;
import de.audi.atip.statemachine.mediator.WaitSyncMediator;
import java.util.NoSuchElementException;

public class MediaSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected MediaSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[128];
        eventMediatorArray[2] = new ChangeMediator(200002L, (MediatorManager)this.smm, 200038, new int[]{200638});
        eventMediatorArray[6] = new ChangeTimerMediator(200006L, this.smm, 200011, new int[]{201038}, 3000L);
        eventMediatorArray[8] = new DataUpdateMediator(200008L, this.smm, 200010, 200008, 200009, 200009, 200537, 3000L);
        eventMediatorArray[15] = new HistoryRestoreMediator(200015L, this.smm, 200054);
        eventMediatorArray[16] = new ChangeMediator(200016L, (MediatorManager)this.smm, 200038, new int[]{200638});
        eventMediatorArray[17] = new ChangeMediator(200017L, (MediatorManager)this.smm, 200067, new int[]{200629});
        eventMediatorArray[18] = new WaitSyncMediator(200018L, (MediatorManager)this.smm, 200068, 200640);
        eventMediatorArray[21] = new ChangeMediator(200021L, (MediatorManager)this.smm, 200076, new int[]{200573, 5583});
        eventMediatorArray[25] = new WaitSyncMediator(200025L, (MediatorManager)this.smm, 200080, 200808);
        eventMediatorArray[26] = new ChangeMediator(200026L, (MediatorManager)this.smm, 200078, new int[]{200603});
        eventMediatorArray[27] = new ChangeMediator(200027L, (MediatorManager)this.smm, 200079, new int[]{200538});
        eventMediatorArray[33] = new ChangeMediator(200033L, (MediatorManager)this.smm, 200093, new int[]{200644});
        eventMediatorArray[36] = new ChangeMediator(200036L, (MediatorManager)this.smm, 200099, new int[]{200251});
        eventMediatorArray[37] = new WaitSyncMediator(200037L, (MediatorManager)this.smm, 200100, 200808);
        eventMediatorArray[38] = new ChangeMediator(200038L, (MediatorManager)this.smm, 200101, new int[]{200537});
        eventMediatorArray[41] = new ChangeMediator(200041L, (MediatorManager)this.smm, 200076, new int[]{200573, 5583});
        eventMediatorArray[42] = new HistoryRestoreMediator(200042L, this.smm, 200015);
        eventMediatorArray[43] = new HistoryRestoreMediator(200043L, this.smm, 200015);
        eventMediatorArray[45] = new HistoryRestoreMediator(200045L, this.smm, 200105);
        eventMediatorArray[46] = new HistoryRestoreMediator(200046L, this.smm, 200015);
        eventMediatorArray[47] = new ChangeMediator(200047L, (MediatorManager)this.smm, 200106, new int[]{200623});
        eventMediatorArray[48] = new ChangeMediator(200048L, (MediatorManager)this.smm, 200107, new int[]{200657});
        eventMediatorArray[50] = new HistoryRestoreMediator(200050L, this.smm, 200015);
        eventMediatorArray[52] = new ChangeMediator(200052L, (MediatorManager)this.smm, 200122, new int[]{200232});
        eventMediatorArray[53] = new HistoryRestoreMediator(200053L, this.smm, 200015);
        eventMediatorArray[56] = new ChangeMediator(200056L, (MediatorManager)this.smm, 200079, new int[]{200538});
        eventMediatorArray[57] = new ChangeMediator(200057L, (MediatorManager)this.smm, 200138, new int[]{200530});
        eventMediatorArray[58] = new ChangeTimerMediator(200058L, this.smm, 200011, new int[]{201038}, 3000L);
        eventMediatorArray[59] = new ChangeMediator(200059L, (MediatorManager)this.smm, 200141, new int[]{200761});
        eventMediatorArray[62] = new ChangeMediator(200062L, (MediatorManager)this.smm, 200145, new int[]{200653});
        eventMediatorArray[72] = new ChangeMediator(200072L, (MediatorManager)this.smm, 200079, new int[]{200538});
        eventMediatorArray[73] = new WaitSyncMediator(200073L, (MediatorManager)this.smm, 200150, 200808);
        eventMediatorArray[74] = new WaitSyncMediator(200074L, (MediatorManager)this.smm, 200149, 200598);
        eventMediatorArray[75] = new WaitSyncMediator(200075L, (MediatorManager)this.smm, 200156, 200808);
        eventMediatorArray[76] = new WaitSyncMediator(200076L, (MediatorManager)this.smm, 200155, 200598);
        eventMediatorArray[77] = new DataUpdateMediator(200077L, this.smm, 200151, 200151, 200151, -1, 200598);
        eventMediatorArray[78] = new WaitSyncMediator(200078L, (MediatorManager)this.smm, 200158, 200808);
        eventMediatorArray[79] = new ChangeTimerMediator(200079L, this.smm, 200075, new int[]{200452}, 2500L);
        eventMediatorArray[80] = new ChangeTimerMediator(200080L, this.smm, 200075, new int[]{200452}, 2500L);
        eventMediatorArray[81] = new WaitSyncMediator(200081L, (MediatorManager)this.smm, 200162, 200682);
        eventMediatorArray[82] = new ChangeMediator(200082L, (MediatorManager)this.smm, 200163, new int[]{201043, 200694});
        eventMediatorArray[83] = new ChangeMediator(200083L, (MediatorManager)this.smm, 200164, new int[]{200693, 201041});
        eventMediatorArray[84] = new DataUpdateMediator(200084L, this.smm, 200050, 200051, -1, -1, 200669, 3000L);
        eventMediatorArray[85] = new ChangeMediator(200085L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[87] = new ChangeMediator(200087L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[88] = new ChangeMediator(200088L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[89] = new ChangeMediator(200089L, (MediatorManager)this.smm, 1644, new int[]{509});
        eventMediatorArray[90] = new ChangeMediator(200090L, (MediatorManager)this.smm, 1495, new int[]{363});
        eventMediatorArray[92] = new ChangeMediator(200092L, (MediatorManager)this.smm, 200166, new int[]{200863});
        eventMediatorArray[93] = new ChangeMediator(200093L, (MediatorManager)this.smm, 200101, new int[]{200537});
        eventMediatorArray[94] = new ChangeMediator(200094L, (MediatorManager)this.smm, 200052, new int[]{200538});
        eventMediatorArray[95] = new ChangeMediator(200095L, (MediatorManager)this.smm, 200229, new int[]{2301166});
        eventMediatorArray[96] = new ChangeMediator(200096L, (MediatorManager)this.smm, 200165, new int[]{2300989, 2300070});
        eventMediatorArray[97] = new ChangeMediator(200097L, (MediatorManager)this.smm, 1492, new int[]{377});
        eventMediatorArray[98] = new ChangeMediator(200098L, (MediatorManager)this.smm, 200231, new int[]{200646});
        eventMediatorArray[99] = new ChangeMediator(200099L, (MediatorManager)this.smm, 200052, new int[]{200538});
        eventMediatorArray[100] = new ChangeMediator(200100L, (MediatorManager)this.smm, 200233, new int[]{335});
        eventMediatorArray[101] = new ChangeMediator(200101L, (MediatorManager)this.smm, 200234, new int[]{335});
        eventMediatorArray[102] = new HistoryRestoreMediator(200102L, this.smm, 200015);
        eventMediatorArray[103] = new ChangeMediator(200103L, (MediatorManager)this.smm, 200121, new int[]{200522});
        eventMediatorArray[104] = new WaitSyncMediator(200104L, (MediatorManager)this.smm, 200235, 200904);
        eventMediatorArray[105] = new ChangeMediator(200105L, (MediatorManager)this.smm, 200076, new int[]{200573, 5583});
        eventMediatorArray[106] = new ChangeMediator(200106L, (MediatorManager)this.smm, 200052, new int[]{200537});
        eventMediatorArray[108] = new ChangeMediator(200108L, (MediatorManager)this.smm, 200236, new int[]{4239});
        eventMediatorArray[109] = new WaitScreenMediator(200109L, this.smm, 200238, 201012, 3000L);
        eventMediatorArray[110] = new WaitScreenMediator(200110L, this.smm, 200238, 201012, 3000L);
        eventMediatorArray[114] = new ChangeTimerMediator(200114L, this.smm, 200075, new int[]{200452}, 5000L);
        eventMediatorArray[116] = new ChangeMediator(200116L, (MediatorManager)this.smm, 200121, new int[]{200522});
        eventMediatorArray[118] = new ChangeMediator(200118L, (MediatorManager)this.smm, 200335, new int[]{200259});
        eventMediatorArray[119] = new ChangeMediator(200119L, (MediatorManager)this.smm, 200335, new int[]{200259});
        eventMediatorArray[120] = new ChangeMediator(200120L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[121] = new ChangeMediator(200121L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[122] = new ChangeMediator(200122L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[123] = new ChangeMediator(200123L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[124] = new ChangeMediator(200124L, (MediatorManager)this.smm, 2800, new int[]{5583, 335});
        eventMediatorArray[125] = new ChangeMediator(200125L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[126] = new ChangeMediator(200126L, (MediatorManager)this.smm, 2800, new int[]{5583});
        eventMediatorArray[127] = new ChangeMediator(200127L, (MediatorManager)this.smm, 2800, new int[]{5583});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

