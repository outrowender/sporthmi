/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.RangeModel2D;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.model.ICoreToneModelBank;
import de.audi.atip.model.IEvoToneModelBank;

public class ToneModelBank
extends AbstractModelBank
implements ICoreToneModelBank,
IEvoToneModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 88: {
                    this.models[88] = new ChoiceModel(1000088);
                    break;
                }
                case 16: {
                    this.models[16] = new ChoiceModel(1000016);
                    break;
                }
                case 109: {
                    this.models[109] = new ChoiceModel(1000109);
                    break;
                }
                case 94: {
                    this.models[94] = new ChoiceModel(1000094);
                    break;
                }
                case 83: {
                    this.models[83] = new ChoiceModel(1000083);
                    break;
                }
                case 100: {
                    this.models[100] = new ChoiceModel(1000100);
                    break;
                }
                case 74: {
                    this.models[74] = new ChoiceModel(1000074);
                    break;
                }
                case 112: {
                    this.models[112] = new ButtonModel(1000112);
                    break;
                }
                case 72: {
                    this.models[72] = new ChoiceModel(1000072);
                    break;
                }
                case 92: {
                    this.models[92] = new ChoiceModel(1000092);
                    break;
                }
                case 68: {
                    this.models[68] = new ChoiceModel(1000068);
                    break;
                }
                case 102: {
                    this.models[102] = new ChoiceModel(1000102);
                    break;
                }
                case 77: {
                    this.models[77] = new ChoiceModel(1000077);
                    break;
                }
                case 111: {
                    this.models[111] = new ChoiceModel(1000111);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(1000099);
                    break;
                }
                case 23: {
                    this.models[23] = new RangeModel(1000023);
                    break;
                }
                case 37: {
                    this.models[37] = new RangeModel2D(1000037);
                    break;
                }
                case 71: {
                    this.models[71] = new ChoiceModel(1000071);
                    break;
                }
                case 39: {
                    this.models[39] = new TerminalModelContainer(1000039, 5, false);
                    break;
                }
                case 75: {
                    this.models[75] = new ChoiceModel(1000075);
                    break;
                }
                case 57: {
                    this.models[57] = new ChoiceModel(1000057);
                    break;
                }
                case 28: {
                    this.models[28] = new ChoiceModel(1000028);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(1000096);
                    break;
                }
                case 76: {
                    this.models[76] = new ChoiceModel(1000076);
                    break;
                }
                case 19: {
                    this.models[19] = new ChoiceModel(1000019);
                    break;
                }
                case 84: {
                    this.models[84] = new ChoiceModel(1000084);
                    break;
                }
                case 56: {
                    this.models[56] = new ChoiceModel(1000056);
                    break;
                }
                case 64: {
                    this.models[64] = new ChoiceModel(1000064);
                    break;
                }
                case 45: {
                    this.models[45] = new RangeModel(1000045);
                    break;
                }
                case 42: {
                    this.models[42] = new ChoiceModel(1000042);
                    break;
                }
                case 27: {
                    this.models[27] = new RangeModel(1000027);
                    break;
                }
                case 51: {
                    this.models[51] = new ChoiceModel(1000051);
                    break;
                }
                case 26: {
                    this.models[26] = new RangeModel(1000026);
                    break;
                }
                case 33: {
                    this.models[33] = new ButtonModel(1000033);
                    break;
                }
                case 12: {
                    this.models[12] = new TerminalModelContainer(1000012, 2, false);
                    break;
                }
                case 67: {
                    this.models[67] = new ChoiceModel(1000067);
                    break;
                }
                case 90: {
                    this.models[90] = new ChoiceModel(1000090);
                    break;
                }
                case 38: {
                    this.models[38] = new TerminalModelContainer(1000038, 5, false);
                    break;
                }
                case 43: {
                    this.models[43] = new TerminalModelContainer(1000043, 5, false);
                    break;
                }
                case 86: {
                    this.models[86] = new ChoiceModel(1000086);
                    break;
                }
                case 22: {
                    this.models[22] = new RangeModel(1000022);
                    break;
                }
                case 87: {
                    this.models[87] = new ChoiceModel(1000087);
                    break;
                }
                case 80: {
                    this.models[80] = new ChoiceModel(1000080);
                    break;
                }
                case 14: {
                    this.models[14] = new ChoiceModel(1000014);
                    break;
                }
                case 35: {
                    this.models[35] = new ChoiceModel(1000035);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(1000044);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(1000101);
                    break;
                }
                case 97: {
                    this.models[97] = new ChoiceModel(1000097);
                    break;
                }
                case 17: {
                    this.models[17] = new ChoiceModel(1000017);
                    break;
                }
                case 103: {
                    this.models[103] = new RangeModel(1000103);
                    break;
                }
                case 82: {
                    this.models[82] = new ChoiceModel(1000082);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(1000104);
                    break;
                }
                case 151: {
                    this.models[151] = new ButtonModel(1000151);
                    break;
                }
                case 41: {
                    this.models[41] = new ChoiceModel(1000041);
                    break;
                }
                case 144: {
                    this.models[144] = new ChoiceModel(1000144);
                    break;
                }
                case 91: {
                    this.models[91] = new ChoiceModel(1000091);
                    break;
                }
                case 55: {
                    this.models[55] = new ChoiceModel(1000055);
                    break;
                }
                case 11: {
                    this.models[11] = new RangeModel(1000011);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(1000089);
                    break;
                }
                case 85: {
                    this.models[85] = new ChoiceModel(1000085);
                    break;
                }
                case 49: {
                    this.models[49] = new ChoiceModel(1000049);
                    break;
                }
                case 60: {
                    this.models[60] = new LabelModel(1000060);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(1000116);
                    break;
                }
                case 65: {
                    this.models[65] = new ChoiceModel(1000065);
                    break;
                }
                case 32: {
                    this.models[32] = new ChoiceModel(1000032);
                    break;
                }
                case 25: {
                    this.models[25] = new RangeModel(1000025);
                    break;
                }
                case 24: {
                    this.models[24] = new RangeModel(1000024);
                    break;
                }
                case 15: {
                    this.models[15] = new TerminalModelContainer(1000015, 5, false);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(1000161);
                    break;
                }
                case 142: {
                    this.models[142] = new ButtonModel(1000142);
                    break;
                }
                case 69: {
                    this.models[69] = new ChoiceModel(1000069);
                    break;
                }
                case 73: {
                    this.models[73] = new ChoiceModel(1000073);
                    break;
                }
                case 93: {
                    this.models[93] = new ChoiceModel(1000093);
                    break;
                }
                case 110: {
                    this.models[110] = new RangeModel(1000110);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(1000061);
                    break;
                }
                case 47: {
                    this.models[47] = new ChoiceModel(1000047);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(1000105);
                    break;
                }
                case 152: {
                    this.models[152] = new ChoiceModel(1000152);
                    break;
                }
                case 128: {
                    this.models[128] = new RangeModel(1000128);
                    break;
                }
                case 98: {
                    this.models[98] = new ChoiceModel(1000098);
                    break;
                }
                case 95: {
                    this.models[95] = new ChoiceModel(1000095);
                    break;
                }
                case 66: {
                    this.models[66] = new ChoiceModel(1000066);
                    break;
                }
                case 40: {
                    this.models[40] = new TerminalModelContainer(1000040, 5, false);
                    break;
                }
                case 36: {
                    this.models[36] = new TerminalModelContainer(1000036, 5, false);
                    break;
                }
                case 18: {
                    this.models[18] = new TerminalModelContainer(1000018, 5, false);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(1000106);
                    break;
                }
                case 21: {
                    this.models[21] = new RangeModel(1000021);
                    break;
                }
                case 63: {
                    this.models[63] = new ChoiceModel(1000063);
                    break;
                }
                case 13: {
                    this.models[13] = new ChoiceModel(1000013);
                    break;
                }
                case 59: {
                    this.models[59] = new LabelModel(1000059);
                    break;
                }
                case 79: {
                    this.models[79] = new ChoiceModel(1000079);
                    break;
                }
                case 48: {
                    this.models[48] = new ChoiceModel(1000048);
                    break;
                }
                case 46: {
                    this.models[46] = new ChoiceModel(1000046);
                    break;
                }
                default: {
                    ToneModelBank.getModelLogChannel().log(10000, "[ToneModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public ToneModelBank() {
        super(10, 162, 93);
        this.modelIDs = new int[93];
        this.modelIDs[0] = 1000088;
        this.modelIDs[1] = 1000016;
        this.modelIDs[2] = 1000109;
        this.modelIDs[3] = 1000094;
        this.modelIDs[4] = 1000083;
        this.modelIDs[5] = 1000100;
        this.modelIDs[6] = 1000074;
        this.modelIDs[7] = 1000112;
        this.modelIDs[8] = 1000072;
        this.modelIDs[9] = 1000092;
        this.modelIDs[10] = 1000068;
        this.modelIDs[11] = 1000102;
        this.modelIDs[12] = 1000077;
        this.modelIDs[13] = 1000111;
        this.modelIDs[14] = 1000099;
        this.modelIDs[15] = 1000023;
        this.modelIDs[16] = 1000037;
        this.modelIDs[17] = 1000071;
        this.modelIDs[18] = 1000039;
        this.modelIDs[19] = 1000075;
        this.modelIDs[20] = 1000057;
        this.modelIDs[21] = 1000028;
        this.modelIDs[22] = 1000096;
        this.modelIDs[23] = 1000076;
        this.modelIDs[24] = 1000019;
        this.modelIDs[25] = 1000084;
        this.modelIDs[26] = 1000056;
        this.modelIDs[27] = 1000064;
        this.modelIDs[28] = 1000045;
        this.modelIDs[29] = 1000042;
        this.modelIDs[30] = 1000027;
        this.modelIDs[31] = 1000051;
        this.modelIDs[32] = 1000026;
        this.modelIDs[33] = 1000033;
        this.modelIDs[34] = 1000012;
        this.modelIDs[35] = 1000067;
        this.modelIDs[36] = 1000090;
        this.modelIDs[37] = 1000038;
        this.modelIDs[38] = 1000043;
        this.modelIDs[39] = 1000086;
        this.modelIDs[40] = 1000022;
        this.modelIDs[41] = 1000087;
        this.modelIDs[42] = 1000080;
        this.modelIDs[43] = 1000014;
        this.modelIDs[44] = 1000035;
        this.modelIDs[45] = 1000044;
        this.modelIDs[46] = 1000101;
        this.modelIDs[47] = 1000097;
        this.modelIDs[48] = 1000017;
        this.modelIDs[49] = 1000103;
        this.modelIDs[50] = 1000082;
        this.modelIDs[51] = 1000104;
        this.modelIDs[52] = 1000151;
        this.modelIDs[53] = 1000041;
        this.modelIDs[54] = 1000144;
        this.modelIDs[55] = 1000091;
        this.modelIDs[56] = 1000055;
        this.modelIDs[57] = 1000011;
        this.modelIDs[58] = 1000089;
        this.modelIDs[59] = 1000085;
        this.modelIDs[60] = 1000049;
        this.modelIDs[61] = 1000060;
        this.modelIDs[62] = 1000116;
        this.modelIDs[63] = 1000065;
        this.modelIDs[64] = 1000032;
        this.modelIDs[65] = 1000025;
        this.modelIDs[66] = 1000024;
        this.modelIDs[67] = 1000015;
        this.modelIDs[68] = 1000161;
        this.modelIDs[69] = 1000142;
        this.modelIDs[70] = 1000069;
        this.modelIDs[71] = 1000073;
        this.modelIDs[72] = 1000093;
        this.modelIDs[73] = 1000110;
        this.modelIDs[74] = 1000061;
        this.modelIDs[75] = 1000047;
        this.modelIDs[76] = 1000105;
        this.modelIDs[77] = 1000152;
        this.modelIDs[78] = 1000128;
        this.modelIDs[79] = 1000098;
        this.modelIDs[80] = 1000095;
        this.modelIDs[81] = 1000066;
        this.modelIDs[82] = 1000040;
        this.modelIDs[83] = 1000036;
        this.modelIDs[84] = 1000018;
        this.modelIDs[85] = 1000106;
        this.modelIDs[86] = 1000021;
        this.modelIDs[87] = 1000063;
        this.modelIDs[88] = 1000013;
        this.modelIDs[89] = 1000059;
        this.modelIDs[90] = 1000079;
        this.modelIDs[91] = 1000048;
        this.modelIDs[92] = 1000046;
    }
}

