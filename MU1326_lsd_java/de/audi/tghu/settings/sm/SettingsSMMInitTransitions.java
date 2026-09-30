/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.SMModuleConstants;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class SettingsSMMInitTransitions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;

    protected SettingsSMMInitTransitions(AbstractSMM abstractSMM, LogChannel logChannel) {
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
        int[] nArray = new int[363];
        this.initTransFlagListSub1(nArray);
        this.smm.setTransFlagList(nArray);
    }

    private void initTransFlagListSub1(int[] nArray) {
        nArray[81] = 8;
        nArray[93] = 1;
        nArray[121] = 8;
        nArray[125] = 8;
        nArray[127] = 8;
        nArray[128] = 1;
        nArray[131] = 8;
        nArray[142] = 8;
        nArray[143] = 1;
        nArray[159] = 8;
        nArray[161] = 1;
        nArray[165] = 8;
        nArray[185] = 1;
        nArray[241] = 8;
        nArray[242] = 8;
        nArray[245] = 8;
        nArray[246] = 8;
        nArray[248] = 4;
        nArray[260] = 4;
        nArray[276] = 4;
        nArray[277] = 8;
        nArray[281] = 8;
        nArray[299] = 8;
        nArray[303] = 4;
        nArray[306] = 8;
        nArray[307] = 8;
        nArray[308] = 8;
        nArray[309] = 8;
        nArray[313] = 4;
        nArray[315] = 4;
        nArray[318] = 4;
        nArray[322] = 8;
        nArray[327] = 8;
        nArray[333] = 4;
        nArray[337] = 4;
        nArray[339] = 8;
        nArray[349] = 4;
        nArray[351] = 4;
        nArray[352] = 4;
        nArray[357] = 4;
        nArray[359] = 4;
        nArray[360] = 8;
        nArray[361] = 4;
        nArray[362] = 4;
    }

    private void initTransTrgtFlagList() {
        int[][] nArrayArray = new int[363][];
        this.initTransTrgtFlagList0(nArrayArray);
        this.initTransTrgtFlagList1(nArrayArray);
        this.smm.setTransTrgtFlagList(nArrayArray);
    }

    private void initTransTrgtFlagList0(int[][] nArray) {
        nArray[2] = new int[]{64};
        nArray[4] = nArray[2];
        nArray[5] = nArray[2];
        nArray[13] = nArray[2];
        nArray[48] = new int[]{0};
        nArray[50] = new int[]{32};
        nArray[55] = nArray[2];
        nArray[56] = nArray[2];
        nArray[81] = new int[]{10};
        nArray[82] = nArray[2];
        nArray[90] = nArray[2];
        nArray[91] = nArray[2];
        nArray[93] = nArray[48];
        nArray[121] = new int[]{72};
        nArray[125] = nArray[121];
        nArray[127] = nArray[121];
        nArray[128] = nArray[48];
        nArray[131] = nArray[121];
        nArray[140] = nArray[48];
        nArray[142] = new int[]{8};
        nArray[143] = nArray[48];
        nArray[159] = nArray[121];
        nArray[161] = nArray[48];
        nArray[165] = nArray[142];
        nArray[175] = nArray[48];
        nArray[178] = nArray[2];
        nArray[185] = nArray[48];
        nArray[195] = nArray[50];
        nArray[196] = nArray[48];
        nArray[236] = nArray[2];
        nArray[237] = nArray[50];
        nArray[238] = nArray[2];
        nArray[239] = new int[]{2};
        nArray[240] = nArray[48];
        nArray[241] = nArray[121];
        nArray[242] = new int[]{24};
        nArray[243] = nArray[48];
        nArray[244] = nArray[48];
        nArray[245] = nArray[121];
        nArray[246] = nArray[121];
        nArray[247] = nArray[48];
        nArray[248] = nArray[50];
        nArray[249] = nArray[50];
    }

    private void initTransTrgtFlagList1(int[][] nArray) {
        nArray[250] = nArray[50];
        nArray[251] = nArray[48];
        nArray[252] = nArray[48];
        nArray[253] = nArray[50];
        nArray[254] = nArray[50];
        nArray[255] = nArray[50];
        nArray[256] = nArray[50];
        nArray[257] = nArray[50];
        nArray[258] = nArray[50];
        nArray[259] = nArray[50];
        nArray[260] = new int[]{64, 0};
        nArray[261] = nArray[50];
        nArray[262] = nArray[50];
        nArray[263] = nArray[50];
        nArray[264] = nArray[50];
        nArray[265] = nArray[2];
        nArray[266] = nArray[48];
        nArray[267] = nArray[50];
        nArray[268] = nArray[50];
        nArray[269] = nArray[48];
        nArray[270] = nArray[50];
        nArray[271] = nArray[48];
        nArray[272] = nArray[48];
        nArray[273] = nArray[2];
        nArray[274] = nArray[2];
        nArray[275] = nArray[50];
        nArray[276] = new int[]{0, 0};
        nArray[277] = nArray[81];
        nArray[278] = nArray[48];
        nArray[279] = nArray[48];
        nArray[280] = nArray[48];
        nArray[281] = nArray[142];
        nArray[282] = nArray[48];
        nArray[283] = nArray[48];
        nArray[284] = nArray[48];
        nArray[285] = nArray[48];
        nArray[286] = nArray[48];
        nArray[287] = nArray[48];
        nArray[288] = nArray[48];
        nArray[289] = nArray[48];
        nArray[290] = nArray[48];
        nArray[291] = nArray[48];
        nArray[292] = nArray[48];
        nArray[293] = nArray[48];
        nArray[294] = nArray[48];
        nArray[295] = nArray[48];
        nArray[296] = nArray[48];
        nArray[297] = nArray[48];
        nArray[298] = nArray[48];
        nArray[299] = nArray[142];
        nArray[300] = nArray[2];
        nArray[301] = nArray[50];
        nArray[302] = nArray[50];
        nArray[303] = new int[]{0, 32};
        nArray[304] = nArray[2];
        nArray[305] = nArray[50];
        nArray[306] = nArray[142];
        nArray[307] = nArray[142];
        nArray[308] = nArray[142];
        nArray[309] = nArray[142];
        nArray[310] = nArray[2];
        nArray[311] = nArray[2];
        nArray[312] = nArray[2];
        nArray[313] = nArray[303];
        nArray[314] = nArray[50];
        nArray[315] = nArray[303];
        nArray[316] = nArray[50];
        nArray[317] = nArray[2];
        nArray[318] = new int[]{64, 64};
        nArray[319] = nArray[2];
        nArray[320] = nArray[2];
        nArray[321] = nArray[2];
        nArray[322] = nArray[142];
        nArray[323] = nArray[2];
        nArray[324] = nArray[2];
        nArray[325] = nArray[50];
        nArray[326] = nArray[48];
        nArray[327] = nArray[142];
        nArray[328] = nArray[50];
        nArray[329] = nArray[2];
        nArray[330] = nArray[50];
        nArray[331] = nArray[50];
        nArray[332] = nArray[48];
        nArray[333] = nArray[2];
        nArray[334] = nArray[48];
        nArray[335] = nArray[48];
        nArray[336] = nArray[48];
        nArray[337] = new int[]{0, 8};
        nArray[338] = nArray[2];
        nArray[339] = nArray[142];
        nArray[340] = nArray[2];
        nArray[341] = nArray[2];
        nArray[342] = nArray[48];
        nArray[343] = nArray[48];
        nArray[344] = nArray[48];
        nArray[345] = nArray[2];
        nArray[346] = nArray[48];
        nArray[347] = nArray[48];
        nArray[348] = nArray[2];
        nArray[349] = nArray[318];
        nArray[350] = nArray[48];
        nArray[351] = nArray[318];
        nArray[352] = nArray[318];
        nArray[353] = nArray[2];
        nArray[354] = nArray[48];
        nArray[355] = nArray[50];
        nArray[356] = nArray[50];
        nArray[357] = nArray[303];
        nArray[358] = nArray[48];
        nArray[359] = nArray[303];
        nArray[360] = nArray[242];
        nArray[361] = nArray[50];
        nArray[362] = nArray[50];
    }

    private void initTransitionTargetStateList() {
        int[][] nArrayArray = new int[363][];
        this.initTransitionTargetStateList0(nArrayArray);
        this.initTransitionTargetStateList1(nArrayArray);
        this.smm.setTransTrgtStateList(nArrayArray);
    }

    private void initTransitionTargetStateList0(int[][] nArray) {
        nArray[2] = new int[]{1100148};
        nArray[4] = new int[]{1100133};
        nArray[5] = new int[]{1100140};
        nArray[13] = new int[]{1100165};
        nArray[48] = new int[]{1100132};
        nArray[50] = new int[]{-10};
        nArray[55] = new int[]{1100161};
        nArray[56] = new int[]{1100166};
        nArray[81] = new int[]{1100060};
        nArray[82] = new int[]{1100126};
        nArray[90] = new int[]{1100143};
        nArray[91] = new int[]{1100169};
        nArray[93] = new int[]{-6};
        nArray[121] = new int[]{1100147};
        nArray[125] = new int[]{1100142};
        nArray[127] = new int[]{1100121};
        nArray[128] = new int[]{-4};
        nArray[131] = new int[]{1100158};
        nArray[140] = nArray[131];
        nArray[142] = new int[]{1100164};
        nArray[143] = new int[]{-3};
        nArray[159] = new int[]{1100117};
        nArray[161] = new int[]{-5};
        nArray[165] = nArray[125];
        nArray[175] = nArray[131];
        nArray[178] = new int[]{1100178};
        nArray[185] = new int[]{-7};
        nArray[195] = new int[]{-10};
        nArray[196] = new int[]{1100160};
        nArray[236] = new int[]{1100112};
        nArray[237] = nArray[159];
        nArray[238] = new int[]{1100114};
        nArray[239] = new int[]{1100049};
        nArray[240] = nArray[236];
        nArray[241] = nArray[236];
        nArray[242] = new int[]{1100111};
        nArray[243] = nArray[242];
        nArray[244] = nArray[131];
        nArray[245] = new int[]{1100116};
        nArray[246] = new int[]{1100113};
        nArray[247] = nArray[125];
        nArray[248] = new int[]{1100118};
        nArray[249] = nArray[248];
    }

    private void initTransitionTargetStateList1(int[][] nArray) {
        nArray[250] = nArray[248];
        nArray[251] = new int[]{1100150};
        nArray[252] = new int[]{1100149};
        nArray[253] = new int[]{1100119};
        nArray[254] = nArray[253];
        nArray[255] = nArray[142];
        nArray[256] = nArray[248];
        nArray[257] = nArray[4];
        nArray[258] = nArray[251];
        nArray[259] = nArray[251];
        nArray[260] = new int[]{1100156, 1100152};
        nArray[261] = nArray[248];
        nArray[262] = nArray[248];
        nArray[263] = nArray[248];
        nArray[264] = nArray[248];
        nArray[265] = nArray[125];
        nArray[266] = new int[]{1100130};
        nArray[267] = nArray[266];
        nArray[268] = nArray[266];
        nArray[269] = new int[]{1100129};
        nArray[270] = new int[]{1100159};
        nArray[271] = nArray[131];
        nArray[272] = new int[]{1100144};
        nArray[273] = new int[]{1100134};
        nArray[274] = new int[]{1100122};
        nArray[275] = nArray[248];
        nArray[276] = new int[]{1100135, 1100137};
        nArray[277] = new int[]{1100058};
        nArray[278] = nArray[273];
        nArray[279] = nArray[273];
        nArray[280] = nArray[273];
        nArray[281] = new int[]{1100138};
        nArray[282] = nArray[281];
        nArray[283] = nArray[281];
        nArray[284] = nArray[281];
        nArray[285] = nArray[281];
        nArray[286] = nArray[281];
        nArray[287] = nArray[281];
        nArray[288] = nArray[281];
        nArray[289] = nArray[281];
        nArray[290] = nArray[281];
        nArray[291] = nArray[281];
        nArray[292] = nArray[281];
        nArray[293] = nArray[281];
        nArray[294] = nArray[281];
        nArray[295] = nArray[281];
        nArray[296] = nArray[281];
        nArray[297] = nArray[281];
        nArray[298] = new int[]{1100128};
        nArray[299] = nArray[5];
        nArray[300] = nArray[272];
        nArray[301] = nArray[270];
        nArray[302] = nArray[270];
        nArray[303] = new int[]{1100144, 1100143};
        nArray[304] = new int[]{1100146};
        nArray[305] = nArray[90];
        nArray[306] = new int[]{1100131};
        nArray[307] = nArray[121];
        nArray[308] = nArray[121];
        nArray[309] = nArray[121];
        nArray[310] = nArray[252];
        nArray[311] = new int[]{1100153};
        nArray[312] = nArray[253];
        nArray[313] = new int[]{1100123, 1100150};
        nArray[314] = nArray[253];
        nArray[315] = nArray[313];
        nArray[316] = nArray[253];
        nArray[317] = new int[]{1100155};
        nArray[318] = new int[]{1100156, 1100155};
        nArray[319] = new int[]{1100154};
        nArray[320] = nArray[311];
        nArray[321] = nArray[311];
        nArray[322] = nArray[311];
        nArray[323] = new int[]{1100152};
        nArray[324] = nArray[323];
        nArray[325] = nArray[253];
        nArray[326] = nArray[266];
        nArray[327] = nArray[131];
        nArray[328] = nArray[270];
        nArray[329] = new int[]{1100162};
        nArray[330] = nArray[248];
        nArray[331] = nArray[196];
        nArray[332] = nArray[329];
        nArray[333] = new int[]{1100163};
        nArray[334] = nArray[329];
        nArray[335] = nArray[196];
        nArray[336] = nArray[333];
        nArray[337] = new int[]{1100162, 1100163};
        nArray[338] = new int[]{1100120};
        nArray[339] = nArray[131];
        nArray[340] = new int[]{1100167};
        nArray[341] = new int[]{1100168};
        nArray[342] = nArray[340];
        nArray[343] = nArray[340];
        nArray[344] = nArray[340];
        nArray[345] = new int[]{1100171};
        nArray[346] = nArray[345];
        nArray[347] = new int[]{1100174};
        nArray[348] = new int[]{1100172};
        nArray[349] = new int[]{1100177, 1100175};
        nArray[350] = nArray[345];
        nArray[351] = new int[]{1100176, 1100173};
        nArray[352] = nArray[351];
        nArray[353] = new int[]{1100179};
        nArray[354] = new int[]{1100181};
        nArray[355] = nArray[354];
        nArray[356] = nArray[354];
        nArray[357] = new int[]{1100180, 1100181};
        nArray[358] = nArray[353];
        nArray[359] = nArray[357];
        nArray[360] = nArray[242];
        nArray[361] = new int[]{1100115};
        nArray[362] = nArray[196];
    }

    private void initTransIncludeJumpList() {
        HashMap hashMap = new HashMap();
        this.smm.setTransIncludeJumpTransition(hashMap);
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

