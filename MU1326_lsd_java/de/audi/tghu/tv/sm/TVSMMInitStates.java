/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class TVSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected TVSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initStates() {
        this.initStateFlagList();
        this.initStateSuperstateList();
        this.initStateDHSList();
        this.initStateTrigger();
        this.initStateMediatorList();
        this.initStateSyncTriggerList();
        this.initStateSyncExitTriggerList();
        this.initStateSyncTargetList();
        this.initSyncTargets();
    }

    protected void initStateFlagList() {
        int[] nArray = new int[]{1, 15, 0, 9, 6, 1, 7, 9, 0, 6, 1, 0, 9, 0, 6, 593, 9, 9, 9, 0, 0, 1, 1, 1, 1, 9, 1, 0, 6, 6, 6, 0, 0, 6, 6, 0, 49, 15, 0, 6, 7, 7, 15, 593, 593, 5, 10, 0, 1, 0, 257, 0, 0, 0, 0, 0, 7, 0, 8, 0, 0, 0, 0, 8, 7, 7, 271, 0, 9, 0, 6, 0, 257, 593, 0, 0, 0, 0, 593, 257, 0, 0, 0, 9, 1, 0, 15, 9, 7, 1, 593, 0, 9, 593, 89, 15, 0, 0, 1, 53, 0, 9, 0, 0, 9, 0, 9, 0, 9};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{2600036, 2600041, -1, 2600036, 2600065, 2600065, 2600094, 2600006, 2600007, 2600007, 2600006, 2600023, 2600006, 2600012, 2600012, 2600087, 2600024, 2600024, 2600006, -1, -1, 2600024, 2600006, 2600010, 2600010, 2600006, 2600024, 2600016, 2600017, 2600018, 2600050, 2600079, 2600021, 2600022, 2600025, 2600026, 2600094, 2600084, 2600064, 2600040, 2600000, 2600000, 2600041, 2600045, 2600072, 2600005, 2600045, -1, 2600072, 2600050, -10, 2600050, 2600056, 2600056, 2600056, 2600048, 2600048, 2600048, 2600086, -1, -1, -1, 2600001, 2600042, 2600003, 2600003, -10, -1, 2600041, 2600068, 2600106, -1, -10, 2600089, -1, 2600099, 2600099, 2600099, 2600108, -10, 2600083, 2600083, 2600083, 2600079, 2600064, 2600037, 2600005, 2600006, -1, 2600006, 2600108, -1, 2600006, 2600092, 2600066, 2600066, 2600095, -1, 2600094, 2600088, 2600101, 2600024, 2600104, 2600104, 2600016, 2600101, 2600068, 2600106, 2600006};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, 2600083, -1, -1, -1, 2600083, 2600012, -1, 2600021, -1, 2600083, 2600034, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2600032, 2600033, 2600011, 2600022, 2600047, 2600031, 2600038, 2600020, 2600030, 2600000, -1, 2600083, 2600017, -1, -1, -1, -1, -1, -1, 2600010, -1, -1, 2600023, -1, 2600024, 2600027, 2600028, 2600029, 2600025, -1, 2600026, 2600005, -1, -1, -1, 2600006, 2600042, -1, -1, -1, -1, -1, 2600008, 2600009, -1, -1, -1, -1, 2600015, 2600016, 2600045, -1, -1, 2600048, 2600050, 2600049, -1, -1, 2600018, -1, -1, -1, -1, -1, -1, -1, -1, 2600036, -1, 2600082, -1, -1, 2600075, 2600084, -1, 2600009, 2600083, -1, 2600083, -1, 2600083, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[109][];
        int[][] nArrayArray2 = new int[109][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[0] = new int[]{1, 2600064, 2600000};
        nArray2[0] = new int[]{2600025, 2600158, 2600000};
        nArray[1] = new int[]{1, 2600012};
        nArray2[1] = new int[]{2600111, 2600202};
        nArray[3] = new int[]{1, 2, 2600093, 2600094, 1741, 1742, 2600002, 2600045, 2600035, 2600012, 2600011, 2600049};
        nArray2[3] = new int[]{2600002, 2600003, 2600234, 2600218, 2600004, 2600004, 2600007, 2600116, 2600073, 2600008, 2600009, 2600128};
        nArray[5] = new int[]{1, 2};
        nArray2[5] = new int[]{2600117, 2600118};
        nArray[6] = new int[]{2, 2600091, 1750};
        nArray2[6] = new int[]{2600006, 2600225, 2600091};
        nArray[7] = new int[]{1, 2, 1741, 1742, 2600093, 2600011};
        nArray2[7] = new int[]{2600014, 2600015, 2600016, 2600016, 2600212, 2600017};
        nArray[10] = new int[]{1, 2, 2600119, 2600010, 2600005, 2600009, 1741, 1742, 2600007};
        nArray2[10] = new int[]{2600018, 2600019, 2600235, 2600036, 2600031, 2600035, 2600020, 2600020, 2600032};
        nArray[12] = nArray[7];
        nArray2[12] = new int[]{2600021, 2600022, 2600023, 2600023, 2600213, 2600024};
        nArray[15] = new int[]{1, 2, 1507};
        nArray2[15] = new int[]{2600037, 2600170, 2600174};
        nArray[16] = new int[]{1, 2, 1741, 1742, 2600091};
        nArray2[16] = new int[]{2600039, 2600040, 2600041, 2600041, 2600242};
        nArray[17] = new int[]{1, 2, 2600091, 1741, 1742, 2600093};
        nArray2[17] = new int[]{2600042, 2600043, 2600231, 2600104, 2600104, 2600044};
        nArray[18] = new int[]{1, 2, 2600093, 1741, 1742};
        nArray2[18] = new int[]{2600045, 2600046, 2600214, 2600047, 2600047};
        nArray[21] = new int[]{1, 2, 1741, 1742};
        nArray2[21] = new int[]{2600054, 2600055, 2600056, 2600056};
        nArray[22] = nArray[21];
        nArray2[22] = new int[]{2600057, 2600058, 2600059, 2600059};
        nArray[23] = new int[]{1};
        nArray2[23] = new int[]{2600060};
        nArray[24] = new int[]{2};
        nArray2[24] = new int[]{2600061};
        nArray[25] = new int[]{1, 2, 1741, 1742, 2600093};
        nArray2[25] = new int[]{2600062, 2600063, 2600064, 2600064, 2600215};
        nArray[26] = nArray[21];
        nArray2[26] = new int[]{2600065, 2600066, 2600067, 2600067};
        nArray[27] = new int[]{2600120};
        nArray2[27] = new int[]{2600241};
        nArray[30] = new int[]{2600015};
        nArray2[30] = new int[]{2600074};
        nArray[31] = new int[]{2600062, 2600060, 2600061, 1741, 1742};
        nArray2[31] = new int[]{2600149, 2600150, 2600151, 2600053, 2600053};
        nArray[36] = new int[]{1, 2600031};
        nArray2[36] = new int[]{2600072, 2600071};
        nArray[40] = nArray[23];
        nArray2[40] = new int[]{2600077};
        nArray[41] = new int[]{1, 2600089};
        nArray2[41] = new int[]{2600078, 2600191};
        nArray[42] = new int[]{1, 2600012, 2600069};
        nArray2[42] = new int[]{2600112, 2600203, 2600169};
        nArray[43] = nArray[5];
        nArray2[43] = new int[]{2600079, 2600080};
        nArray[44] = nArray[5];
        nArray2[44] = new int[]{2600081, 2600082};
        nArray[45] = nArray[5];
        nArray2[45] = new int[]{2600083, 2600119};
        nArray[46] = new int[]{2600003, 2600038};
        nArray2[46] = new int[]{2600086, 2600164};
        nArray[48] = nArray[21];
        nArray2[48] = new int[]{2600092, 2600093, 2600098, 2600098};
        nArray[49] = new int[]{2600039};
        nArray2[49] = new int[]{2600088};
        nArray[50] = new int[]{2, 1, 1741, 1742};
        nArray2[50] = new int[]{2600089, 2600048, 2600050, 2600050};
        nArray[51] = new int[]{2600040};
        nArray2[51] = new int[]{2600090};
        nArray[52] = nArray[30];
        nArray2[52] = new int[]{2600095};
        nArray[53] = nArray[30];
        nArray2[53] = new int[]{2600096};
        nArray[54] = nArray[51];
        nArray2[54] = new int[]{2600097};
        nArray[55] = new int[]{2600014, 2600013};
        nArray2[55] = new int[]{2600099, 2600100};
        nArray[56] = nArray[21];
        nArray2[56] = new int[]{2600101, 2600102, 2600103, 2600103};
        nArray[57] = new int[]{2600065, 1741, 1742};
        nArray2[57] = new int[]{2600159, 2600094, 2600094};
        nArray[58] = new int[]{2600066, 2600068};
        nArray2[58] = new int[]{2600160, 2600168};
        nArray[63] = new int[]{2800};
        nArray2[63] = new int[]{2600251};
        nArray[66] = new int[]{2, 1, 1000080, 2600090, 2600022, 2600016, 2600027, 2600055, 2600024, 200065, 2600021, 2600028, 2600023, 2600025, 2600026, 2600095};
        nArray2[66] = new int[]{2600113, 2600001, 2600204, 2600192, 2600012, 2600030, 2600156, 2600138, 2600010, 2600226, 2600029, 2600011, 2600028, 2600027, 2600171, 2600219};
        nArray[68] = new int[]{1, 2, 2600091};
        nArray2[68] = new int[]{2600120, 2600121, 2600200};
        nArray[69] = new int[]{1741, 1742, 2600001};
        nArray2[69] = new int[]{2600122, 2600122, 2600123};
        nArray[70] = new int[]{2600047};
        nArray2[70] = new int[]{2600125};
        nArray[72] = new int[]{2, 1};
        nArray2[72] = new int[]{2600137, 2600087};
        nArray[73] = nArray[5];
        nArray2[73] = new int[]{2600139, 2600189};
        nArray[75] = new int[]{2600057, 2600004};
        nArray2[75] = new int[]{2600147, 2600146};
        nArray[76] = new int[]{1741, 1742};
        nArray2[76] = new int[]{2600232, 2600232};
        nArray[77] = nArray[76];
        nArray2[77] = new int[]{2600233, 2600233};
        nArray[78] = nArray[5];
        nArray2[78] = new int[]{2600152, 2600157};
        nArray[79] = nArray[72];
        nArray2[79] = new int[]{2600153, 2600051};
        nArray[83] = new int[]{2600063, 2600066, 1741, 1742, 2600011};
        nArray2[83] = new int[]{2600154, 2600166, 2600155, 2600155, 2600167};
        nArray[84] = nArray[5];
        nArray2[84] = new int[]{2600161, 2600162};
        nArray[85] = new int[]{2600066};
        nArray2[85] = new int[]{2600163};
        nArray[87] = new int[]{1, 2, 2600070};
        nArray2[87] = new int[]{2600172, 2600038, 2600173};
        nArray[88] = new int[]{1, 1741, 1742, 2600058};
        nArray2[88] = new int[]{2600177, 2600144, 2600144, 2600145};
        nArray[89] = nArray[5];
        nArray2[89] = new int[]{2600190, 2600140};
        nArray[90] = nArray[5];
        nArray2[90] = new int[]{2600193, 2600194};
        nArray[92] = new int[]{1, 2, 1492};
        nArray2[92] = new int[]{2600205, 2600206, 2600207};
        nArray[93] = new int[]{1, 2, 1507, 1741, 1742};
        nArray2[93] = new int[]{2600208, 2600209, 2600210, 2600211, 2600211};
        nArray[94] = new int[]{1, 2600038, 2600072, 2600054, 2600048, 2600036};
        nArray2[94] = new int[]{2600228, 2600076, 2600223, 2600135, 2600127, 2600075};
        nArray[95] = new int[]{1, 2, 2600095};
        nArray2[95] = new int[]{2600220, 2600221, 2600222};
        nArray[98] = nArray[5];
        nArray2[98] = new int[]{2600229, 2600230};
        nArray[100] = new int[]{2600093};
        nArray2[100] = new int[]{2600239};
        nArray[101] = new int[]{1, 2, 1741, 1742, 2600091, 2600011};
        nArray2[101] = new int[]{2600236, 2600237, 2600238, 2600238, 2600245, 2600246};
        nArray[104] = new int[]{1, 2600011};
        nArray2[104] = new int[]{2600243, 2600244};
        nArray[106] = new int[]{1, 2, 2600093, 1741, 1742, 2600011};
        nArray2[106] = new int[]{2600247, 2600248, 2600216, 2600124, 2600124, 2600249};
        nArray[108] = nArray[63];
        nArray2[108] = new int[]{2600240};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[109][];
        nArrayArray[1] = new int[]{2600026};
        nArrayArray[3] = new int[]{2600001, 2600000, 2600009};
        nArrayArray[7] = new int[]{2600020, 2600002};
        nArrayArray[12] = new int[]{2600023, 2600003};
        nArrayArray[16] = new int[]{2600036};
        nArrayArray[17] = new int[]{2600021};
        nArrayArray[18] = new int[]{2600022};
        nArrayArray[25] = new int[]{2600024};
        nArrayArray[37] = new int[]{2600030};
        nArrayArray[42] = new int[]{2600027, 2600016};
        nArrayArray[46] = new int[]{2600012};
        nArrayArray[58] = new int[]{2600015};
        nArrayArray[63] = new int[]{2600041};
        nArrayArray[66] = new int[]{2600031};
        nArrayArray[68] = new int[]{2600025};
        nArrayArray[83] = new int[]{2600014};
        nArrayArray[86] = new int[]{2600029};
        nArrayArray[87] = new int[]{2600017};
        nArrayArray[92] = new int[]{2600028};
        nArrayArray[94] = new int[]{2600005, 2600033, 2600010, 2600008, 2600004};
        nArrayArray[95] = new int[]{2600032};
        nArrayArray[101] = new int[]{2600038, 2600037};
        nArrayArray[104] = new int[]{2600035};
        nArrayArray[106] = new int[]{2600039};
        nArrayArray[108] = new int[]{2600034};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[109][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[109][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[109][];
        this.smm.setStateSyncTargetList(nArrayArray);
    }

    private void initSyncTargets() {
        SMSyncTarget[] sMSyncTargetArray = new SMSyncTarget[1];
        this.smm.setSyncTargetList(sMSyncTargetArray);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

