/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;

public class EcallSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EcallSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    protected void initTransitions() {
        this.initTransFlagList();
        this.initTransTrgtFlagList();
        this.initTransitionTargetStateList();
        this.initTransIncludeJumpList();
    }

    private void initTransFlagList() {
        int[] nArray = new int[61];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
        nArray[1] = 4;
        nArray[7] = 4;
        nArray[10] = 8;
        nArray[14] = 4;
        nArray[15] = 4;
        nArray[16] = 4;
        nArray[17] = 12;
        nArray[20] = 12;
        nArray[21] = 12;
        nArray[57] = 1;
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[61][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[1] = new int[]{8, 8};
        nArray[2] = new int[]{32};
        nArray[3] = nArray[2];
        nArray[4] = nArray[2];
        nArray[5] = new int[]{0};
        nArray[6] = nArray[2];
        nArray[7] = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32};
        nArray[10] = new int[]{40};
        nArray[13] = nArray[2];
        nArray[14] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32};
        nArray[15] = nArray[14];
        nArray[16] = nArray[14];
        nArray[17] = nArray[14];
        nArray[20] = nArray[7];
        nArray[21] = nArray[14];
        nArray[22] = nArray[2];
        nArray[23] = nArray[2];
        nArray[29] = nArray[5];
        nArray[37] = nArray[2];
        nArray[42] = nArray[2];
        nArray[44] = nArray[5];
        nArray[45] = nArray[2];
        nArray[46] = nArray[2];
        nArray[47] = nArray[2];
        nArray[48] = nArray[2];
        nArray[49] = nArray[5];
        nArray[50] = nArray[5];
        nArray[51] = nArray[2];
        nArray[52] = nArray[5];
        nArray[53] = nArray[2];
        nArray[54] = nArray[2];
        nArray[55] = nArray[5];
        nArray[56] = nArray[2];
        nArray[57] = nArray[5];
        nArray[58] = nArray[2];
        nArray[59] = nArray[2];
        nArray[60] = nArray[5];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[61][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[1] = new int[]{-1118162432, -1118162432};
        nArray[2] = new int[]{-564514304};
        nArray[3] = new int[]{-1504038400};
        nArray[4] = nArray[3];
        nArray[5] = new int[]{-1520815616};
        nArray[6] = nArray[3];
        nArray[7] = new int[]{-564514304, -1554370048, -1571147264, -1487261184, -1436929536, -1403375104, -1420152320, -1453706752, -1470483968, -1386597888, -279301632, -312856064, 39531008, -1369820672, -10866176, -44420608, -212192768, -1252380160, -1235602944, -1218825728, -245747200, -346410496, -111529472, -94752256, -145083904, -447073792, -161861120, -61197824, -178638336, -77975040, -128306688, 22753792, -564514304};
        nArray[10] = nArray[2];
        nArray[13] = new int[]{-10};
        nArray[14] = new int[]{-983944704, -900058624, -1101385216, 56308224, -1067830784, -296078848, -1034276352, 5976576, -1151716864, -228969984, -1000721920, -1084608000, -262524416, -1051053568, -950390272, -195415552, -916835840, -967167488, -27643392, -933613056, -1017499136, -329633280, -1151716864};
        nArray[15] = nArray[14];
        nArray[16] = nArray[14];
        nArray[17] = nArray[14];
        nArray[20] = nArray[7];
        nArray[21] = nArray[14];
        nArray[22] = nArray[2];
        nArray[23] = nArray[2];
        nArray[29] = new int[]{-363187712};
        nArray[37] = nArray[2];
        nArray[42] = nArray[2];
        nArray[44] = new int[]{-631623168};
        nArray[45] = new int[]{-614845952};
        nArray[46] = new int[]{-1151716864};
        nArray[47] = nArray[2];
        nArray[48] = nArray[45];
        nArray[49] = new int[]{-598068736};
        nArray[50] = nArray[2];
        nArray[51] = new int[]{-1537592832};
        nArray[52] = nArray[2];
        nArray[53] = new int[]{-547737088};
        nArray[54] = new int[]{-10};
        nArray[55] = new int[]{-581291520};
        nArray[56] = new int[]{-379964928};
        nArray[57] = new int[]{-3};
        nArray[58] = nArray[56];
        nArray[59] = nArray[56];
        nArray[60] = nArray[29];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

