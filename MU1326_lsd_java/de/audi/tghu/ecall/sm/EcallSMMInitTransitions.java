/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;
import java.util.NoSuchElementException;

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
        nArray[1] = new int[]{3300029, 3300029};
        nArray[2] = new int[]{3300062};
        nArray[3] = new int[]{3300006};
        nArray[4] = nArray[3];
        nArray[5] = new int[]{3300005};
        nArray[6] = nArray[3];
        nArray[7] = new int[]{3300062, 3300003, 3300002, 3300007, 3300010, 3300012, 3300011, 3300009, 3300008, 3300013, 3300079, 3300077, 3300098, 3300014, 3300095, 3300093, 3300083, 3300021, 3300022, 3300023, 3300081, 3300075, 3300089, 3300090, 3300087, 3300069, 3300086, 3300092, 3300085, 3300091, 3300088, 3300097, 3300062};
        nArray[10] = nArray[2];
        nArray[13] = new int[]{-10};
        nArray[14] = new int[]{3300037, 3300042, 3300030, 3300099, 3300032, 3300078, 3300034, 3300096, 3300027, 3300082, 3300036, 3300031, 3300080, 3300033, 3300039, 3300084, 3300041, 3300038, 3300094, 3300040, 3300035, 3300076, 3300027};
        nArray[15] = nArray[14];
        nArray[16] = nArray[14];
        nArray[17] = nArray[14];
        nArray[20] = nArray[7];
        nArray[21] = nArray[14];
        nArray[22] = nArray[2];
        nArray[23] = nArray[2];
        nArray[29] = new int[]{3300074};
        nArray[37] = nArray[2];
        nArray[42] = nArray[2];
        nArray[44] = new int[]{3300058};
        nArray[45] = new int[]{3300059};
        nArray[46] = new int[]{3300027};
        nArray[47] = nArray[2];
        nArray[48] = nArray[45];
        nArray[49] = new int[]{3300060};
        nArray[50] = nArray[2];
        nArray[51] = new int[]{3300004};
        nArray[52] = nArray[2];
        nArray[53] = new int[]{3300063};
        nArray[54] = new int[]{-10};
        nArray[55] = new int[]{3300061};
        nArray[56] = new int[]{3300073};
        nArray[57] = new int[]{-3};
        nArray[58] = nArray[56];
        nArray[59] = nArray[56];
        nArray[60] = nArray[29];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

