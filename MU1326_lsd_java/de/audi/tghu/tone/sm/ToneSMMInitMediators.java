/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.mediator.ChangeMediator;
import de.audi.atip.statemachine.mediator.HistoryRestoreMediator;
import java.util.NoSuchElementException;

public class ToneSMMInitMediators
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected ToneSMMInitMediators(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initMediators() {
        EventMediator[] eventMediatorArray = new EventMediator[89];
        eventMediatorArray[3] = new ChangeMediator(1000003L, (MediatorManager)this.smm, 1000042, new int[]{1000061});
        eventMediatorArray[4] = new ChangeMediator(1000004L, (MediatorManager)this.smm, 1000043, new int[]{1000086, 4073});
        eventMediatorArray[5] = new ChangeMediator(1000005L, (MediatorManager)this.smm, 1000043, new int[]{1000092});
        eventMediatorArray[6] = new ChangeMediator(1000006L, (MediatorManager)this.smm, 1000043, new int[]{1000089});
        eventMediatorArray[7] = new ChangeMediator(1000007L, (MediatorManager)this.smm, 1000043, new int[]{1000091});
        eventMediatorArray[8] = new ChangeMediator(1000008L, (MediatorManager)this.smm, 1000043, new int[]{1000088});
        eventMediatorArray[9] = new ChangeMediator(1000009L, (MediatorManager)this.smm, 1000043, new int[]{1000090});
        eventMediatorArray[10] = new ChangeMediator(1000010L, (MediatorManager)this.smm, 1000043, new int[]{1000083});
        eventMediatorArray[11] = new ChangeMediator(1000011L, (MediatorManager)this.smm, 1000043, new int[]{4073});
        eventMediatorArray[13] = new ChangeMediator(1000013L, (MediatorManager)this.smm, 1000043, new int[]{1000085});
        eventMediatorArray[14] = new ChangeMediator(1000014L, (MediatorManager)this.smm, 1000043, new int[]{1000084});
        eventMediatorArray[15] = new ChangeMediator(1000015L, (MediatorManager)this.smm, 1000043, new int[]{1000094});
        eventMediatorArray[16] = new ChangeMediator(1000016L, (MediatorManager)this.smm, 1000043, new int[]{1000096});
        eventMediatorArray[17] = new ChangeMediator(1000017L, (MediatorManager)this.smm, 1000043, new int[]{1000097});
        eventMediatorArray[18] = new ChangeMediator(1000018L, (MediatorManager)this.smm, 1000043, new int[]{1000093});
        eventMediatorArray[19] = new ChangeMediator(1000019L, (MediatorManager)this.smm, 1000043, new int[]{1000101});
        eventMediatorArray[20] = new ChangeMediator(1000020L, (MediatorManager)this.smm, 1000043, new int[]{1000087});
        eventMediatorArray[21] = new ChangeMediator(1000021L, (MediatorManager)this.smm, 1000045, new int[]{100327});
        eventMediatorArray[22] = new ChangeMediator(1000022L, (MediatorManager)this.smm, 1000044, new int[]{100327});
        eventMediatorArray[24] = new ChangeMediator(1000024L, (MediatorManager)this.smm, 1000047, new int[]{300730});
        eventMediatorArray[25] = new ChangeMediator(1000025L, (MediatorManager)this.smm, 1000043, new int[]{1000083});
        eventMediatorArray[26] = new ChangeMediator(1000026L, (MediatorManager)this.smm, 1000050, new int[]{100577});
        eventMediatorArray[27] = new HistoryRestoreMediator(1000027L, this.smm, 1000051);
        eventMediatorArray[28] = new HistoryRestoreMediator(1000028L, this.smm, 1000054);
        eventMediatorArray[29] = new HistoryRestoreMediator(1000029L, this.smm, 1000052);
        eventMediatorArray[30] = new HistoryRestoreMediator(1000030L, this.smm, 1000053);
        eventMediatorArray[31] = new ChangeMediator(1000031L, (MediatorManager)this.smm, 1000043, new int[]{1000100});
        eventMediatorArray[33] = new ChangeMediator(1000033L, (MediatorManager)this.smm, 1000055, new int[]{300664, 3848, 300227, 4196});
        eventMediatorArray[35] = new HistoryRestoreMediator(1000035L, this.smm, 1000057);
        eventMediatorArray[36] = new HistoryRestoreMediator(1000036L, this.smm, 1000043);
        eventMediatorArray[37] = new HistoryRestoreMediator(1000037L, this.smm, 1000043);
        eventMediatorArray[38] = new HistoryRestoreMediator(1000038L, this.smm, 1000043);
        eventMediatorArray[39] = new HistoryRestoreMediator(1000039L, this.smm, 1000043);
        eventMediatorArray[40] = new HistoryRestoreMediator(1000040L, this.smm, 1000043);
        eventMediatorArray[41] = new HistoryRestoreMediator(1000041L, this.smm, 1000043);
        eventMediatorArray[42] = new HistoryRestoreMediator(1000042L, this.smm, 1000058);
        eventMediatorArray[43] = new HistoryRestoreMediator(1000043L, this.smm, 1000043);
        eventMediatorArray[47] = new ChangeMediator(1000047L, (MediatorManager)this.smm, 1000083, new int[]{200537});
        eventMediatorArray[49] = new HistoryRestoreMediator(1000049L, this.smm, 1000043);
        eventMediatorArray[50] = new HistoryRestoreMediator(1000050L, this.smm, 1000145);
        eventMediatorArray[51] = new HistoryRestoreMediator(1000051L, this.smm, 1000043);
        eventMediatorArray[52] = new HistoryRestoreMediator(1000052L, this.smm, 1000043);
        eventMediatorArray[53] = new HistoryRestoreMediator(1000053L, this.smm, 1000043);
        eventMediatorArray[62] = new ChangeMediator(1000062L, (MediatorManager)this.smm, 1000043, new int[]{1000095});
        eventMediatorArray[64] = new ChangeMediator(1000064L, (MediatorManager)this.smm, 1000079, new int[]{1000019});
        eventMediatorArray[65] = new ChangeMediator(1000065L, (MediatorManager)this.smm, 1000043, new int[]{1000104});
        eventMediatorArray[66] = new HistoryRestoreMediator(1000066L, this.smm, 1000043);
        eventMediatorArray[67] = new ChangeMediator(1000067L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[68] = new ChangeMediator(1000068L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[69] = new ChangeMediator(1000069L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[70] = new ChangeMediator(1000070L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[71] = new ChangeMediator(1000071L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[72] = new ChangeMediator(1000072L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[73] = new ChangeMediator(1000073L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[74] = new ChangeMediator(1000074L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[75] = new ChangeMediator(1000075L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[76] = new ChangeMediator(1000076L, (MediatorManager)this.smm, 1000043, new int[]{1000111});
        eventMediatorArray[77] = new HistoryRestoreMediator(1000077L, this.smm, 1000057);
        eventMediatorArray[78] = new ChangeMediator(1000078L, (MediatorManager)this.smm, 1000086, new int[]{4303});
        eventMediatorArray[79] = new HistoryRestoreMediator(1000079L, this.smm, 1000087);
        eventMediatorArray[80] = new ChangeMediator(1000080L, (MediatorManager)this.smm, 1000079, new int[]{1000019});
        eventMediatorArray[81] = new ChangeMediator(1000081L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[82] = new ChangeMediator(1000082L, (MediatorManager)this.smm, 1000079, new int[]{1000019});
        eventMediatorArray[83] = new ChangeMediator(1000083L, (MediatorManager)this.smm, 1000059, new int[]{30, 1000106, 4228});
        eventMediatorArray[84] = new ChangeMediator(1000084L, (MediatorManager)this.smm, 1000043, new int[]{1000084});
        eventMediatorArray[85] = new HistoryRestoreMediator(1000085L, this.smm, 1000043);
        eventMediatorArray[86] = new ChangeMediator(1000086L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[87] = new ChangeMediator(1000087L, (MediatorManager)this.smm, 2500183, new int[]{300664, 300952});
        eventMediatorArray[88] = new ChangeMediator(1000088L, (MediatorManager)this.smm, 1000157, new int[]{5617});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

