/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import java.util.HashMap;
import java.util.Map;

public final class LockingBitWrapper {
    private static boolean dataReady = false;
    public static final int FUNCTIONAL_BIT_NPS_AVAILABILITY;
    public static final int FUNCTIONAL_BIT_LOCKING_MODE_1;
    public static final int FUNCTIONAL_BIT_LOCKING_MODE_2;
    public static final int[] FUNCTIONAL_BIT_LIST;
    private static final Integer[] EMPTY_INTEGER_ARRAY;
    private static Object[] bitModelMapping;
    private static Map functionalBitStates;

    public static int[] getModelsForBitId(int n) {
        if (n <= bitModelMapping.length - 1) {
            Integer[] integerArray = (Integer[])bitModelMapping[n];
            int[] nArray = new int[integerArray.length];
            for (int i2 = 0; i2 < integerArray.length; ++i2) {
                nArray[i2] = integerArray[i2];
            }
            return nArray;
        }
        return new int[0];
    }

    public static void setFunctionBitState(int n, int n2) {
        functionalBitStates.put(new Integer(n), new Integer(n2));
    }

    public static int getFunctionalBitState(int n) {
        Integer n2 = new Integer(n);
        if (functionalBitStates.containsKey(n2)) {
            return (Integer)functionalBitStates.get(n2);
        }
        return -1;
    }

    public static boolean ready() {
        return dataReady;
    }

    static void setReady(boolean bl) {
        dataReady = bl;
    }

    static {
        FUNCTIONAL_BIT_LIST = new int[]{127, 166, 167};
        EMPTY_INTEGER_ARRAY = new Integer[0];
        bitModelMapping = new Object[191];
        functionalBitStates = new HashMap(2);
        LockingBitWrapper.bitModelMapping[0] = new Integer[]{new Integer(5584)};
        LockingBitWrapper.bitModelMapping[1] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[2] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[3] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[4] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[5] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[6] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[7] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[8] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[9] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[10] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[11] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[12] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[13] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[14] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[15] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[16] = new Integer[]{new Integer(5587)};
        LockingBitWrapper.bitModelMapping[17] = new Integer[]{new Integer(5597)};
        LockingBitWrapper.bitModelMapping[18] = new Integer[]{new Integer(5592)};
        LockingBitWrapper.bitModelMapping[19] = new Integer[]{new Integer(5618)};
        LockingBitWrapper.bitModelMapping[20] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[21] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[22] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[23] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[24] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[25] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[26] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[27] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[28] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[29] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[30] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[31] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[32] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[33] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[34] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[35] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[36] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[37] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[38] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[39] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[40] = new Integer[]{new Integer(5588)};
        LockingBitWrapper.bitModelMapping[41] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[42] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[43] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[44] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[45] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[46] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[47] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[48] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[49] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[50] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[51] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[52] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[53] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[54] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[55] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[56] = new Integer[]{new Integer(5593)};
        LockingBitWrapper.bitModelMapping[57] = new Integer[]{new Integer(5590)};
        LockingBitWrapper.bitModelMapping[58] = new Integer[]{new Integer(5598)};
        LockingBitWrapper.bitModelMapping[59] = new Integer[]{new Integer(5613)};
        LockingBitWrapper.bitModelMapping[60] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[61] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[62] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[63] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[64] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[65] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[66] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[67] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[68] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[69] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[70] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[71] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[72] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[73] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[74] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[75] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[76] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[77] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[78] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[79] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[80] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[81] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[82] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[83] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[84] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[85] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[86] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[87] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[88] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[89] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[90] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[91] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[92] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[93] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[94] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[95] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[96] = new Integer[]{new Integer(5608)};
        LockingBitWrapper.bitModelMapping[97] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[98] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[99] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[100] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[101] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[102] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[103] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[104] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[105] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[106] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[107] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[108] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[109] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[110] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[111] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[112] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[113] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[114] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[115] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[116] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[117] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[118] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[119] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[120] = new Integer[]{new Integer(5600)};
        LockingBitWrapper.bitModelMapping[121] = new Integer[]{new Integer(5601)};
        LockingBitWrapper.bitModelMapping[122] = new Integer[]{new Integer(5604)};
        LockingBitWrapper.bitModelMapping[123] = new Integer[]{new Integer(5605)};
        LockingBitWrapper.bitModelMapping[124] = new Integer[]{new Integer(5603)};
        LockingBitWrapper.bitModelMapping[125] = new Integer[]{new Integer(5602)};
        LockingBitWrapper.bitModelMapping[126] = new Integer[]{new Integer(5606)};
        LockingBitWrapper.bitModelMapping[127] = new Integer[]{new Integer(5607)};
        LockingBitWrapper.bitModelMapping[128] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[129] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[130] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[131] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[132] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[133] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[134] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[135] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[136] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[137] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[138] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[139] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[140] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[141] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[142] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[143] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[144] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[145] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[146] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[147] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[148] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[149] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[150] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[151] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[152] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[153] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[154] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[155] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[156] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[157] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[158] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[159] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[160] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[161] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[162] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[163] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[164] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[165] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[166] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[167] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[168] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[169] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[170] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[171] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[172] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[173] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[174] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[175] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[176] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[177] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[178] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[179] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[180] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[181] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[182] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[183] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[184] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[185] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[186] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[187] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[188] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[189] = EMPTY_INTEGER_ARRAY;
        LockingBitWrapper.bitModelMapping[190] = EMPTY_INTEGER_ARRAY;
    }
}

