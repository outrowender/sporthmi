/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class EngineeringSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected EngineeringSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[65];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
        nArray[4] = 1;
        nArray[64] = 4;
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[65][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[0] = new int[]{64};
        nArray[1] = new int[]{0};
        nArray[2] = nArray[0];
        nArray[3] = nArray[1];
        nArray[4] = nArray[1];
        nArray[5] = nArray[1];
        nArray[6] = nArray[1];
        nArray[7] = nArray[1];
        nArray[8] = nArray[1];
        nArray[9] = nArray[0];
        nArray[10] = nArray[1];
        nArray[11] = nArray[1];
        nArray[12] = nArray[0];
        nArray[13] = nArray[0];
        nArray[14] = nArray[0];
        nArray[15] = nArray[1];
        nArray[16] = nArray[1];
        nArray[18] = nArray[1];
        nArray[19] = new int[]{32};
        nArray[20] = nArray[0];
        nArray[21] = nArray[0];
        nArray[22] = nArray[0];
        nArray[23] = nArray[1];
        nArray[24] = nArray[0];
        nArray[27] = nArray[1];
        nArray[28] = nArray[1];
        nArray[29] = nArray[0];
        nArray[30] = nArray[1];
        nArray[31] = nArray[1];
        nArray[32] = nArray[0];
        nArray[33] = nArray[0];
        nArray[34] = nArray[0];
        nArray[36] = nArray[0];
        nArray[37] = nArray[1];
        nArray[38] = nArray[1];
        nArray[39] = nArray[1];
        nArray[40] = nArray[19];
        nArray[41] = nArray[0];
        nArray[42] = nArray[0];
        nArray[43] = nArray[1];
        nArray[44] = nArray[0];
        nArray[45] = nArray[0];
        nArray[46] = nArray[19];
        nArray[47] = nArray[19];
        nArray[48] = nArray[1];
        nArray[49] = nArray[0];
        nArray[50] = nArray[1];
        nArray[51] = nArray[0];
        nArray[52] = nArray[0];
        nArray[53] = nArray[1];
        nArray[54] = nArray[1];
        nArray[55] = nArray[1];
        nArray[56] = nArray[0];
        nArray[57] = nArray[0];
        nArray[58] = nArray[1];
        nArray[59] = nArray[19];
        nArray[60] = nArray[1];
        nArray[61] = nArray[0];
        nArray[62] = nArray[0];
        nArray[63] = nArray[1];
        nArray[64] = new int[]{64, 64};
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[65][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[0] = new int[]{1300006};
        nArray[1] = new int[]{1300004};
        nArray[2] = new int[]{1300003};
        nArray[3] = nArray[0];
        nArray[4] = new int[]{-3};
        nArray[5] = nArray[0];
        nArray[6] = nArray[0];
        nArray[7] = new int[]{1300005};
        nArray[8] = nArray[0];
        nArray[9] = nArray[1];
        nArray[10] = new int[]{1300009};
        nArray[11] = nArray[2];
        nArray[12] = new int[]{1300034};
        nArray[13] = new int[]{1300002};
        nArray[14] = nArray[13];
        nArray[15] = new int[]{1300013};
        nArray[16] = new int[]{1300011};
        nArray[18] = nArray[2];
        nArray[19] = new int[]{1300031};
        nArray[20] = nArray[16];
        nArray[21] = new int[]{1300010};
        nArray[22] = new int[]{1300008};
        nArray[23] = nArray[13];
        nArray[24] = new int[]{1300007};
        nArray[27] = nArray[0];
        nArray[28] = new int[]{1300014};
        nArray[29] = new int[]{1300016};
        nArray[30] = nArray[1];
        nArray[31] = nArray[29];
        nArray[32] = new int[]{1300018};
        nArray[33] = new int[]{1300017};
        nArray[34] = new int[]{1300019};
        nArray[36] = new int[]{1300021};
        nArray[37] = new int[]{1300022};
        nArray[38] = nArray[37];
        nArray[39] = nArray[36];
        nArray[40] = nArray[15];
        nArray[41] = new int[]{1300020};
        nArray[42] = nArray[41];
        nArray[43] = nArray[36];
        nArray[44] = new int[]{1300023};
        nArray[45] = new int[]{1300024};
        nArray[46] = nArray[15];
        nArray[47] = nArray[37];
        nArray[48] = new int[]{1300025};
        nArray[49] = new int[]{1300029};
        nArray[50] = nArray[29];
        nArray[51] = new int[]{1300028};
        nArray[52] = new int[]{1300027};
        nArray[53] = nArray[49];
        nArray[54] = new int[]{1300026};
        nArray[55] = nArray[54];
        nArray[56] = new int[]{1300030};
        nArray[57] = nArray[54];
        nArray[58] = nArray[49];
        nArray[59] = nArray[19];
        nArray[60] = new int[]{1300032};
        nArray[61] = new int[]{1300012};
        nArray[62] = new int[]{1300033};
        nArray[63] = nArray[0];
        nArray[64] = new int[]{1300035, 1300032};
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

