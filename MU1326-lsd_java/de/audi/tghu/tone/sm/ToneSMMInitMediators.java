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
        eventMediatorArray[3] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1782714112, new int[]{2101481216});
        eventMediatorArray[4] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1774055680, 4073});
        eventMediatorArray[5] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1673392384});
        eventMediatorArray[6] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1723724032});
        eventMediatorArray[7] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1690169600});
        eventMediatorArray[8] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1740501248});
        eventMediatorArray[9] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1706946816});
        eventMediatorArray[10] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1824387328});
        eventMediatorArray[11] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{4073});
        eventMediatorArray[13] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1790832896});
        eventMediatorArray[14] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1807610112});
        eventMediatorArray[15] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1639837952});
        eventMediatorArray[16] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1606283520});
        eventMediatorArray[17] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1589506304});
        eventMediatorArray[18] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1656615168});
        eventMediatorArray[19] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1522397440});
        eventMediatorArray[20] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1757278464});
        eventMediatorArray[21] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1833045760, new int[]{-410582784});
        eventMediatorArray[22] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1816268544, new int[]{-410582784});
        eventMediatorArray[24] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1866600192, new int[]{-1164573696});
        eventMediatorArray[25] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1824387328});
        eventMediatorArray[26] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1916931840, new int[]{-511180544});
        eventMediatorArray[27] = new HistoryRestoreMediator(0, this.smm, 1933709056);
        eventMediatorArray[28] = new HistoryRestoreMediator(0, this.smm, 1984040704);
        eventMediatorArray[29] = new HistoryRestoreMediator(0, this.smm, 1950486272);
        eventMediatorArray[30] = new HistoryRestoreMediator(0, this.smm, 1967263488);
        eventMediatorArray[31] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1539174656});
        eventMediatorArray[33] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2000817920, new int[]{2023097344, 3848, -1013709824, 4196});
        eventMediatorArray[35] = new HistoryRestoreMediator(0, this.smm, 2034372352);
        eventMediatorArray[36] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[37] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[38] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[39] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[40] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[41] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[42] = new HistoryRestoreMediator(0, this.smm, 2051149568);
        eventMediatorArray[43] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[47] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1824387328, new int[]{1494156032});
        eventMediatorArray[49] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[50] = new HistoryRestoreMediator(0, this.smm, -784199936);
        eventMediatorArray[51] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[52] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[53] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[62] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1623060736});
        eventMediatorArray[64] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1891496192, new int[]{1396838144});
        eventMediatorArray[65] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1472065792});
        eventMediatorArray[66] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[67] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[68] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[69] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[70] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[71] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[72] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[73] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[74] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[75] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[76] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1354625280});
        eventMediatorArray[77] = new HistoryRestoreMediator(0, this.smm, 2034372352);
        eventMediatorArray[78] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1774055680, new int[]{4303});
        eventMediatorArray[79] = new HistoryRestoreMediator(0, this.smm, -1757278464);
        eventMediatorArray[80] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1891496192, new int[]{1396838144});
        eventMediatorArray[81] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[82] = new ChangeMediator((long)0, (MediatorManager)this.smm, -1891496192, new int[]{1396838144});
        eventMediatorArray[83] = new ChangeMediator((long)0, (MediatorManager)this.smm, 2067926784, new int[]{30, -1438511360, 4228});
        eventMediatorArray[84] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1799491328, new int[]{-1807610112});
        eventMediatorArray[85] = new HistoryRestoreMediator(0, this.smm, 1799491328);
        eventMediatorArray[86] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[87] = new ChangeMediator((long)0, (MediatorManager)this.smm, 1462117888, new int[]{2023097344, -1734933504});
        eventMediatorArray[88] = new ChangeMediator((long)0, (MediatorManager)this.smm, -582873344, new int[]{5617});
        this.smm.setMediatorList(eventMediatorArray);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

