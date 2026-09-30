/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

public class CombiSignConverter {
    private static int characterSetMajorVersion = 3;
    private static int characterSetMinorVersion = 0;
    private static final String COMBISIGN_NONE = "";
    private static final String[] SPECIAL_SIGN_SET_VERSION_1 = new String[147];
    private static final String[] SPECIAL_SIGN_SET_VERSION_2;
    private static final String[] SPECIAL_SIGN_SET_VERSION_3;
    private static final String[] SPECIAL_SIGN_SET_VERSION_3_1;

    public static String convertSign(int n) {
        if (0 < n && n < 147) {
            switch (characterSetMajorVersion) {
                case 1: {
                    return SPECIAL_SIGN_SET_VERSION_1[n];
                }
                case 2: {
                    return SPECIAL_SIGN_SET_VERSION_2[n];
                }
            }
            switch (characterSetMinorVersion) {
                case 0: {
                    return SPECIAL_SIGN_SET_VERSION_3[n];
                }
            }
            return SPECIAL_SIGN_SET_VERSION_3_1[n];
        }
        return COMBISIGN_NONE;
    }

    public static void setCharacterSetVersion(int n, int n2) {
        characterSetMajorVersion = n;
        characterSetMinorVersion = n2;
    }

    static {
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[0] = COMBISIGN_NONE;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[1] = "\ue000";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[2] = "\ue001";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[3] = "\ue002";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[4] = "\ue003";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[5] = "\ue004";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[6] = "\ue005";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[7] = "\ue006";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[8] = "\ue006";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[9] = "\ue008";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[10] = "\ue009";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[11] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[12] = "\ue01b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[13] = "\ue01c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[14] = "\ue01d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[15] = "\ue01e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[16] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[17] = ">";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[18] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[19] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[20] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[21] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[22] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[23] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[24] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[25] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[26] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[27] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[28] = null;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[29] = "-";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[30] = "+";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[31] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[32] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[33] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[34] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[35] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[36] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[37] = "#";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_1[38] = "#";
        SPECIAL_SIGN_SET_VERSION_2 = new String[147];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[0] = COMBISIGN_NONE;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[1] = "\ue000";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[2] = "\ue001";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[3] = "\ue002";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[4] = "\ue003";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[5] = "\ue004";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[6] = "\ue005";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[7] = "\ue006";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[8] = "\ue007";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[9] = "\ue008";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[10] = "\ue009";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[11] = "\ue01a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[12] = "\ue01b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[13] = "\ue01c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[14] = "\ue01d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[15] = "\ue01e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[16] = "\ue01f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[17] = "\ue020";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[18] = "\ue021";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[19] = "\ue022";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[20] = "\ue024";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[21] = "\ue025";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[22] = "\ue026";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[23] = "\ue027";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[24] = "\ue028";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[25] = "\ue029";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[26] = "\ue02a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[27] = "\ue02b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[28] = "\ue02c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[29] = "\ue02d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[30] = "\ue02e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[31] = "\ue02f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[32] = "\ue034";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[33] = "\ue039";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[34] = "\ue043";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[35] = "\ue044";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[36] = "\ue045";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[37] = "\ue046";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_2[38] = "\ue047";
        SPECIAL_SIGN_SET_VERSION_3 = new String[147];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[0] = COMBISIGN_NONE;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[1] = "\ue000";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[2] = "\ue001";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[3] = "\ue002";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[4] = "\ue003";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[5] = "\ue004";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[6] = "\ue005";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[39] = "\ue006";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[40] = "\ue007";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[9] = "\ue008";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[10] = "\ue009";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[11] = "\ue01b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[12] = "\uf7f2";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[13] = "\ue01c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[14] = "\ue01d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[15] = "\ue01e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[16] = "\ue01f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[17] = "\ue020";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[18] = "\ue021";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[19] = "\ue022";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[20] = "\ue024";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[21] = "\ue025";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[22] = "\ue026";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[23] = "\ue027";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[24] = "\ue028";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[25] = "\ue029";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[26] = "\ue02a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[27] = "\ue02b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[28] = "\ue02c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[29] = "\ue02d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[30] = "\ue02e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[31] = "\ue02f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[32] = "\ue034";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[33] = "\ue039";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[34] = "\ue043";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[35] = "\ue044";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[36] = "\ue045";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[37] = "\ue046";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[38] = "\ue047";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[41] = "\ue01b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[42] = "\ue023";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[43] = "\ue048";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[44] = "\ue049";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[45] = "\ue04a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[46] = "\ue04b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[47] = "\ue04c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[48] = "\ue04d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[49] = "\ue04e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[50] = "\ue04f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[51] = "\ue050";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[52] = "\ue051";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[53] = "\ue052";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[54] = "\ue053";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[55] = "\ue054";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[56] = "\ue055";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[57] = "\ue056";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[58] = "\ue057";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[59] = "\ue058";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[60] = "\ue059";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[61] = "\ue060";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[62] = "\ue061";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[63] = "\ue062";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[64] = "\ue063";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[65] = "\ue064";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[66] = "\ue065";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[67] = "\ue066";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[68] = "\ue067";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[69] = "\ue068";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[70] = "\ue069";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[71] = "\ue06a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[72] = "\ue06b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[73] = "\ue06c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[74] = "\ue06d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[75] = "\ue06e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[76] = "\ue06f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[77] = "\ue070";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[78] = "\ue071";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[79] = "\ue072";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[80] = "\ue073";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[81] = "\ue074";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[82] = "\ue075";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[83] = "\ue076";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[84] = "\ue077";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[85] = "\ue078";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[86] = "\ue079";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[87] = "\ue07a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[88] = "\ue07b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[89] = "\ue07c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[90] = "\ue07d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[91] = "\ue07e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[92] = "\ue07f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[93] = "\ue080";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[94] = "\ue081";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[95] = "\ue082";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[96] = "\ue083";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[97] = "\ue084";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[98] = "\ue085";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[99] = "\ue086";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[100] = "\ue087";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[101] = "\ue088";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[102] = "\ue089";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[103] = "\ue08a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[104] = "\ue08b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[105] = "\ue08c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[106] = "\ue08d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[107] = "\ue08e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[108] = "\ue08f";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[109] = "\ue090";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[110] = "\ue091";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[111] = "\ue092";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[112] = "\ue093";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[113] = "\ue094";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[114] = "\ue095";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[115] = "\ue096";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[116] = "\ue097";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[117] = "\ue098";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[118] = "\ue099";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[119] = "\ue09a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[120] = "\ue0b0";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[121] = "\ue0b1";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[122] = "\ue0fe";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[123] = "\ue0fd";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[124] = "\ue0ff";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[125] = "\ue0b2";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[126] = "\ue0b3";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[127] = "\ue0b4";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[128] = "\ue0b5";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[129] = "\ue0b6";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[130] = "\ue230";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[131] = "\ue231";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[132] = "\ue232";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[133] = "\ue233";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[134] = "\ue234";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[135] = "\ue235";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[136] = "\ue236";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[137] = "\ue237";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[138] = "\ue238";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[139] = "\ue239";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[140] = COMBISIGN_NONE;
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[141] = SPECIAL_SIGN_SET_VERSION_3[79];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[142] = SPECIAL_SIGN_SET_VERSION_3[72];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[143] = SPECIAL_SIGN_SET_VERSION_3[89];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[144] = SPECIAL_SIGN_SET_VERSION_3[89];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[145] = SPECIAL_SIGN_SET_VERSION_3[89];
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3[146] = SPECIAL_SIGN_SET_VERSION_3[89];
        SPECIAL_SIGN_SET_VERSION_3_1 = new String[147];
        System.arraycopy((Object)SPECIAL_SIGN_SET_VERSION_3, 0, (Object)SPECIAL_SIGN_SET_VERSION_3_1, 0, 147);
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[140] = "\ue061";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[141] = "\ue09a";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[142] = "\ue09b";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[143] = "\ue09c";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[144] = "\ue09d";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[145] = "\ue09e";
        CombiSignConverter.SPECIAL_SIGN_SET_VERSION_3_1[146] = "\ue09f";
    }
}

