/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMSyncTarget;
import java.util.NoSuchElementException;

public class SettingsSMMInitStates
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SettingsSMMInitStates(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, 6, 0, 0, 15, 0, 3, 3, 1, 593, 593, 593, 593, 1, 8, 6, 11, 15, 593, 15, 8, 261, 7, 0, 0, 9, 0, 8, 1, 0, 7, 2, 15, 0, 0, 0, 2, 7, 0, 9, 0, 0, 0, 0, 0, 0, 6, 2, 3, 265, 593, 0, 0, 1, 6, 7, 0, 0, 1, 1, 0, 0, 0, 3, 9, 0, 0, 1, 0, 593, 9};
        this.smm.setStateFlagList(nArray);
    }

    private void initStateSuperstateList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1100117, 1100111, 1100115, 1100111, 1100117, 1100115, 1100139, 1100139, 1100148, 1100164, 1100127, 1100133, 1100150, 1100119, 1100118, 1100118, 1100118, -10, 1100130, 1100159, 1100143, -10, 1100118, 1100132, 1100136, 1100132, 1100136, 1100136, 1100128, 1100141, 1100118, 1100128, 1100159, 1100143, 1100143, 1100143, 1100139, 1100118, 1100148, 1100119, 1100119, 1100124, 1100119, 1100119, 1100119, 1100119, 1100119, 1100139, 1100139, -10, 1100118, 1100160, 1100160, 1100118, 1100118, 1100118, 1100166, 1100166, 1100159, 1100169, 1100169, 1100170, 1100175, 1100169, 1100174, 1100175, 1100174, 1100118, 1100178, 1100181, 1100178};
        this.smm.setStateSuperstateList(nArray);
    }

    private void initStateDHSList() {
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1100082, 1100047, 1100046, -1, 1100044, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1100019, -1, -1, -1, -1, 1100026, -1, -1, 1100007, 1100008, -1, 1100079, 1100079, -1, 1100004, -1, 1100040, -1, 1100025, 1100026, 1100026, 1100039, -1, 1100006, -1, 1100013, 1100012, 1100010, 1100011, 1100059, 1100035, 1100020, 1100041, -1, -1, -1, 1100009, 1100028, -1, 1100005, -1, 1100023, 1100024, -1, -1, 1100016, 1100017, 1100034, -1, -1, 189, 1100057, -1, 1100076, -1, -1};
        this.smm.setStateDHSList(nArray);
    }

    private void initStateTrigger() {
        int[][] nArrayArray = new int[182][];
        int[][] nArrayArray2 = new int[182][];
        this.initStateTrigger1(nArrayArray, nArrayArray2);
        this.smm.setStateTriggerEventList(nArrayArray);
        this.smm.setStateOutTransList(nArrayArray2);
    }

    private void initStateTrigger1(int[][] nArray, int[][] nArray2) {
        nArray[111] = new int[]{1, 2, 1100081};
        nArray2[111] = new int[]{1100236, 1100237, 1100238};
        nArray[112] = new int[]{1100078};
        nArray2[112] = new int[]{1100239};
        nArray[114] = new int[]{1741, 1742};
        nArray2[114] = new int[]{1100240, 1100240};
        nArray[115] = new int[]{2, 1750, 1741, 1742, 2800};
        nArray2[115] = new int[]{1100360, 1100241, 1100242, 1100242, 1100361};
        nArray[117] = new int[]{1, 2, 1100076, 1100077};
        nArray2[117] = new int[]{1100243, 1100244, 1100245, 1100246};
        nArray[118] = new int[]{2, 1100068, 1100083, 1741, 1742};
        nArray2[118] = new int[]{1100247, 1100248, 1100249, 1100250, 1100250};
        nArray[119] = new int[]{1, 2, 1741, 1742, 1100033};
        nArray2[119] = new int[]{1100251, 1100252, 1100253, 1100253, 1100254};
        nArray[120] = new int[]{1, 2};
        nArray2[120] = new int[]{1100143, 1100255};
        nArray[121] = nArray[120];
        nArray2[121] = new int[]{1100128, 1100256};
        nArray[122] = nArray[120];
        nArray2[122] = new int[]{1100048, 1100257};
        nArray[123] = new int[]{1, 2, 1507};
        nArray2[123] = new int[]{1100161, 1100258, 1100259};
        nArray[124] = new int[]{1};
        nArray2[124] = new int[]{1100260};
        nArray[126] = new int[]{1100032};
        nArray2[126] = new int[]{1100261};
        nArray[127] = new int[]{1507, 1741, 1742, 1644};
        nArray2[127] = new int[]{1100262, 1100263, 1100263, 1100264};
        nArray[128] = new int[]{1, 1100034, 1100036, 1100079, 1700068, 1100010, 1100063, 1100027, 1100097, 1100047, 1100001, 1100064, 1100082, 1100050, 1100070, 1100028, 1100035, 1100065, 1700059, 1100011, 1100009, 1700132};
        nArray2[128] = new int[]{1100265, 1100055, 1100056, 1100159, 1100175, 1100002, 1100121, 1100081, 1100178, 1100090, 1100013, 1100127, 1100165, 1100082, 1100142, 1100091, 1100131, 1100125, 1100140, 1100004, 1100005, 1100266};
        nArray[129] = nArray[123];
        nArray2[129] = new int[]{1100093, 1100267, 1100268};
        nArray[130] = new int[]{1, 2, 1100101};
        nArray2[130] = new int[]{1100269, 1100270, 1100271};
        nArray[131] = new int[]{1100074};
        nArray2[131] = new int[]{1100272};
        nArray[132] = new int[]{2, 1};
        nArray2[132] = new int[]{1100050, 1100273};
        nArray[133] = nArray[120];
        nArray2[133] = new int[]{1100274, 1100275};
        nArray[134] = new int[]{1100006};
        nArray2[134] = new int[]{1100276};
        nArray[135] = new int[]{1100007};
        nArray2[135] = new int[]{1100277};
        nArray[136] = new int[]{1741, 1742, 1100008, 1100102};
        nArray2[136] = new int[]{1100278, 1100278, 1100279, 1100280};
        nArray[137] = nArray[135];
        nArray2[137] = new int[]{1100281};
        nArray[138] = new int[]{1484, 1558, 1485, 1557, 1482, 1741, 1742, 1525, -13, 1483, 106, 105, 1750, 101, 1741, 102, 151};
        nArray2[138] = new int[]{1100282, 1100283, 1100284, 1100285, 1100286, 1100287, 1100287, 1100288, 1100289, 1100290, 1100291, 1100292, 1100293, 1100294, 1100295, 1100296, 1100297};
        nArray[139] = nArray[114];
        nArray2[139] = new int[]{1100298, 1100298};
        nArray[140] = new int[]{1100042};
        nArray2[140] = new int[]{1100299};
        nArray[143] = new int[]{1, 2, 1100049, 1100058};
        nArray2[143] = new int[]{1100300, 1100301, 1100302, 1100303};
        nArray[144] = new int[]{1100044};
        nArray2[144] = new int[]{1100304};
        nArray[146] = new int[]{1100048, 1100046};
        nArray2[146] = new int[]{1100305, 1100306};
        nArray[147] = new int[]{1100061, 1100098, 1100062};
        nArray2[147] = new int[]{1100307, 1100308, 1100309};
        nArray[148] = nArray[124];
        nArray2[148] = new int[]{1100310};
        nArray[149] = new int[]{1100005, 1100004};
        nArray2[149] = new int[]{1100311, 1100312};
        nArray[150] = new int[]{1, 2, 1492};
        nArray2[150] = new int[]{1100313, 1100314, 1100315};
        nArray[152] = new int[]{1100023, 1100022};
        nArray2[152] = new int[]{1100316, 1100317};
        nArray[153] = new int[]{1100018, 1100019};
        nArray2[153] = new int[]{1100318, 1100319};
        nArray[154] = new int[]{1100021, 1741, 1742, 1100020};
        nArray2[154] = new int[]{1100320, 1100321, 1100321, 1100322};
        nArray[155] = new int[]{1741, 1742, 1100024};
        nArray2[155] = new int[]{1100323, 1100323, 1100324};
        nArray[157] = new int[]{1100031};
        nArray2[157] = new int[]{1100325};
        nArray[159] = new int[]{1, 2, 1741, 1742};
        nArray2[159] = new int[]{1100326, 1100327, 1100328, 1100328};
        nArray[160] = new int[]{2, 1, 2800};
        nArray2[160] = new int[]{1100195, 1100329, 1100362};
        nArray[161] = nArray[120];
        nArray2[161] = new int[]{1100196, 1100330};
        nArray[162] = new int[]{1741, 1742, 1100054, 1100051};
        nArray2[162] = new int[]{1100331, 1100331, 1100332, 1100333};
        nArray[163] = new int[]{1741, 1742, 1100056, 1100057, 1100052};
        nArray2[163] = new int[]{1100334, 1100334, 1100335, 1100336, 1100337};
        nArray[164] = nArray[120];
        nArray2[164] = new int[]{1100338, 1100339};
        nArray[166] = nArray[124];
        nArray2[166] = new int[]{1100340};
        nArray[167] = new int[]{1100037};
        nArray2[167] = new int[]{1100341};
        nArray[168] = new int[]{1100039, 1741, 1742, 1100038};
        nArray2[168] = new int[]{1100342, 1100343, 1100343, 1100344};
        nArray[169] = nArray[124];
        nArray2[169] = new int[]{1100345};
        nArray[170] = nArray[114];
        nArray2[170] = new int[]{1100346, 1100346};
        nArray[171] = new int[]{1100030, 1100029};
        nArray2[171] = new int[]{1100347, 1100348};
        nArray[174] = new int[]{1, 1741, 1742};
        nArray2[174] = new int[]{1100349, 1100350, 1100350};
        nArray[175] = new int[]{1, 1100099};
        nArray2[175] = new int[]{1100351, 1100352};
        nArray[178] = nArray[124];
        nArray2[178] = new int[]{1100353};
        nArray[179] = new int[]{1000082};
        nArray2[179] = new int[]{1100354};
        nArray[180] = nArray[123];
        nArray2[180] = new int[]{1100185, 1100355, 1100356};
        nArray[181] = nArray[150];
        nArray2[181] = new int[]{1100357, 1100358, 1100359};
    }

    private void initStateMediatorList() {
        int[][] nArrayArray = new int[182][];
        nArrayArray[111] = new int[]{1100049};
        nArrayArray[115] = new int[]{1100062};
        nArrayArray[125] = new int[]{1100051, 1100050};
        nArrayArray[127] = new int[]{1100052};
        nArrayArray[128] = new int[]{1100060};
        nArrayArray[130] = new int[]{1100056};
        nArrayArray[131] = new int[]{1100061};
        nArrayArray[136] = new int[]{1100058};
        nArrayArray[138] = new int[]{1100059};
        nArrayArray[143] = new int[]{1100057};
        nArrayArray[150] = new int[]{1100053};
        nArrayArray[160] = new int[]{1100063};
        nArrayArray[175] = new int[]{1100054};
        nArrayArray[181] = new int[]{1100055};
        this.smm.setStateMediatorList(nArrayArray);
    }

    private void initStateSyncTriggerList() {
        int[][] nArrayArray = new int[182][];
        this.smm.setStateSyncTriggerList(nArrayArray);
    }

    private void initStateSyncExitTriggerList() {
        int[][] nArrayArray = new int[182][];
        this.smm.setStateSyncExitTriggerList(nArrayArray);
    }

    private void initStateSyncTargetList() {
        int[][] nArrayArray = new int[182][];
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

