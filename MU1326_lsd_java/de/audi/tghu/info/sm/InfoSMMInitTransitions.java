/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;

public class InfoSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected InfoSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[37];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
        nArray[2] = 4;
        nArray[4] = 8;
        nArray[20] = 1;
        nArray[24] = 1;
        nArray[26] = 1;
        nArray[27] = 8;
        nArray[29] = 1;
        nArray[35] = 4;
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[37][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[0] = new int[]{0};
        nArray[1] = new int[]{32};
        nArray[2] = new int[]{72, 0, 0};
        nArray[3] = nArray[0];
        nArray[4] = new int[]{72};
        nArray[5] = nArray[0];
        nArray[6] = new int[]{64};
        nArray[7] = nArray[0];
        nArray[8] = nArray[0];
        nArray[9] = nArray[1];
        nArray[10] = nArray[6];
        nArray[11] = nArray[1];
        nArray[12] = nArray[1];
        nArray[13] = nArray[6];
        nArray[14] = nArray[1];
        nArray[15] = nArray[1];
        nArray[16] = nArray[0];
        nArray[17] = new int[]{2};
        nArray[18] = nArray[6];
        nArray[19] = nArray[0];
        nArray[20] = nArray[0];
        nArray[21] = nArray[0];
        nArray[22] = nArray[0];
        nArray[23] = nArray[0];
        nArray[24] = nArray[0];
        nArray[25] = nArray[0];
        nArray[26] = nArray[0];
        nArray[27] = new int[]{8};
        nArray[28] = nArray[0];
        nArray[29] = nArray[0];
        nArray[30] = nArray[1];
        nArray[31] = nArray[1];
        nArray[32] = new int[]{16};
        nArray[33] = nArray[0];
        nArray[35] = nArray[1];
        nArray[36] = nArray[1];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[37][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[0] = new int[]{715196160};
        nArray[1] = new int[]{-10};
        nArray[2] = new int[]{765527808, 731973376, 614532864};
        nArray[3] = nArray[0];
        nArray[4] = new int[]{748750592};
        nArray[5] = new int[]{597755648};
        nArray[6] = nArray[4];
        nArray[7] = new int[]{681641728};
        nArray[8] = nArray[4];
        nArray[9] = new int[]{-10};
        nArray[10] = new int[]{698418944};
        nArray[11] = new int[]{815859456};
        nArray[12] = nArray[11];
        nArray[13] = new int[]{799082240};
        nArray[14] = new int[]{782305024};
        nArray[15] = nArray[14];
        nArray[16] = new int[]{648087296};
        nArray[17] = nArray[5];
        nArray[18] = nArray[10];
        nArray[19] = new int[]{664864512};
        nArray[20] = new int[]{-4};
        nArray[21] = nArray[4];
        nArray[22] = nArray[4];
        nArray[23] = nArray[4];
        nArray[24] = new int[]{-3};
        nArray[25] = new int[]{614532864};
        nArray[26] = new int[]{-5};
        nArray[27] = new int[]{765527808};
        nArray[28] = new int[]{631310080};
        nArray[29] = nArray[20];
        nArray[30] = new int[]{849413888};
        nArray[31] = nArray[30];
        nArray[32] = new int[]{832636672};
        nArray[33] = nArray[16];
        nArray[35] = nArray[14];
        nArray[36] = nArray[14];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}

