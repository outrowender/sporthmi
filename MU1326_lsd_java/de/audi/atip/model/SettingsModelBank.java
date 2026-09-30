/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BrowserModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.model.ICoreSettingsModelBank;
import de.audi.atip.model.IEvoSettingsModelBank;

public class SettingsModelBank
extends AbstractModelBank
implements ICoreSettingsModelBank,
IEvoSettingsModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 212: {
                    this.models[212] = new RangeModel(1100212);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(1100183);
                    break;
                }
                case 134: {
                    this.models[134] = new MetricsModel(1100134);
                    break;
                }
                case 139: {
                    this.models[139] = new ChoiceModel(1100139);
                    break;
                }
                case 191: {
                    this.models[191] = new ChoiceModel(1100191);
                    break;
                }
                case 313: {
                    this.models[313] = new LabelModel(1100313);
                    break;
                }
                case 147: {
                    this.models[147] = new ChoiceModel(1100147);
                    break;
                }
                case 260: {
                    this.models[260] = new ChoiceModel(1100260);
                    break;
                }
                case 287: {
                    this.models[287] = new ChoiceModel(1100287);
                    break;
                }
                case 122: {
                    this.models[122] = new ChoiceModel(1100122);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(1100166);
                    break;
                }
                case 272: {
                    this.models[272] = new LabelModel(1100272);
                    break;
                }
                case 275: {
                    this.models[275] = new LabelModel(1100275);
                    break;
                }
                case 142: {
                    this.models[142] = new ChoiceModel(1100142);
                    break;
                }
                case 255: {
                    this.models[255] = new ButtonModel(1100255);
                    break;
                }
                case 250: {
                    this.models[250] = new ChoiceModel(1100250);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(1100117);
                    break;
                }
                case 274: {
                    this.models[274] = new LabelModel(1100274);
                    break;
                }
                case 182: {
                    this.models[182] = new ChoiceModel(1100182);
                    break;
                }
                case 91: {
                    this.models[91] = new ListModel(1100091);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(1100312);
                    break;
                }
                case 143: {
                    this.models[143] = new ChoiceModel(1100143);
                    break;
                }
                case 194: {
                    this.models[194] = new ChoiceModel(1100194);
                    break;
                }
                case 269: {
                    this.models[269] = new LabelModel(1100269);
                    break;
                }
                case 266: {
                    this.models[266] = new LabelModel(1100266);
                    break;
                }
                case 245: {
                    this.models[245] = new ButtonModel(1100245);
                    break;
                }
                case 136: {
                    this.models[136] = new ChoiceModel(1100136);
                    break;
                }
                case 247: {
                    this.models[247] = new ButtonModel(1100247);
                    break;
                }
                case 227: {
                    this.models[227] = new ChoiceModel(1100227);
                    break;
                }
                case 119: {
                    this.models[119] = new LabelModel(1100119);
                    break;
                }
                case 248: {
                    this.models[248] = new ButtonModel(1100248);
                    break;
                }
                case 196: {
                    this.models[196] = new ChoiceModel(1100196);
                    break;
                }
                case 257: {
                    this.models[257] = new ChoiceModel(1100257);
                    break;
                }
                case 268: {
                    this.models[268] = new LabelModel(1100268);
                    break;
                }
                case 278: {
                    this.models[278] = new ChoiceModel(1100278);
                    break;
                }
                case 288: {
                    this.models[288] = new ChoiceModel(1100288);
                    break;
                }
                case 281: {
                    this.models[281] = new ButtonModel(1100281);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(1100246);
                    break;
                }
                case 295: {
                    this.models[295] = new ChoiceModel(1100295);
                    break;
                }
                case 259: {
                    this.models[259] = new ChoiceModel(1100259);
                    break;
                }
                case 271: {
                    this.models[271] = new LabelModel(1100271);
                    break;
                }
                case 155: {
                    this.models[155] = new ChoiceModel(1100155);
                    break;
                }
                case 145: {
                    this.models[145] = new ChoiceModel(1100145);
                    break;
                }
                case 85: {
                    this.models[85] = new ChoiceModel(1100085);
                    break;
                }
                case 103: {
                    this.models[103] = new ChoiceModel(1100103);
                    break;
                }
                case 184: {
                    this.models[184] = new ListModel(1100184);
                    break;
                }
                case 316: {
                    this.models[316] = new LabelModel(1100316);
                    break;
                }
                case 273: {
                    this.models[273] = new LabelModel(1100273);
                    break;
                }
                case 168: {
                    this.models[168] = new LabelModel(1100168);
                    break;
                }
                case 95: {
                    this.models[95] = new ChoiceModel(1100095);
                    break;
                }
                case 291: {
                    this.models[291] = new ChoiceModel(1100291);
                    break;
                }
                case 253: {
                    this.models[253] = new ChoiceModel(1100253);
                    break;
                }
                case 284: {
                    this.models[284] = new LabelModel(1100284);
                    break;
                }
                case 285: {
                    this.models[285] = new ChoiceModel(1100285);
                    break;
                }
                case 267: {
                    this.models[267] = new LabelModel(1100267);
                    break;
                }
                case 90: {
                    this.models[90] = new ButtonModel(1100090);
                    break;
                }
                case 261: {
                    this.models[261] = new ChoiceModel(1100261);
                    break;
                }
                case 258: {
                    this.models[258] = new ChoiceModel(1100258);
                    break;
                }
                case 294: {
                    this.models[294] = new ChoiceModel(1100294);
                    break;
                }
                case 339: {
                    this.models[339] = new BaseListModel(1100339, null);
                    break;
                }
                case 315: {
                    this.models[315] = new ListModel(1100315);
                    break;
                }
                case 180: {
                    this.models[180] = new ChoiceModel(1100180);
                    break;
                }
                case 305: {
                    this.models[305] = new ChoiceModel(1100305);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(1100105);
                    break;
                }
                case 138: {
                    this.models[138] = new ChoiceModel(1100138);
                    break;
                }
                case 282: {
                    this.models[282] = new ButtonModel(1100282);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(1100149);
                    break;
                }
                case 238: {
                    this.models[238] = new ChoiceModel(1100238);
                    break;
                }
                case 230: {
                    this.models[230] = new ChoiceModel(1100230);
                    break;
                }
                case 93: {
                    this.models[93] = new ButtonModel(1100093);
                    break;
                }
                case 279: {
                    this.models[279] = new LabelModel(1100279);
                    break;
                }
                case 262: {
                    this.models[262] = new LabelModel(1100262);
                    break;
                }
                case 298: {
                    this.models[298] = new VirtualButtonModel(1100298);
                    break;
                }
                case 338: {
                    this.models[338] = new ChoiceModel(1100338);
                    break;
                }
                case 264: {
                    this.models[264] = new LabelModel(1100264);
                    break;
                }
                case 100: {
                    this.models[100] = new ButtonModel(1100100);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(1100096);
                    break;
                }
                case 317: {
                    this.models[317] = new ChoiceModel(1100317);
                    break;
                }
                case 185: {
                    this.models[185] = new ButtonModel(1100185);
                    break;
                }
                case 186: {
                    this.models[186] = new ButtonModel(1100186);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(1100237);
                    break;
                }
                case 86: {
                    this.models[86] = new ChoiceModel(1100086);
                    break;
                }
                case 222: {
                    this.models[222] = new ListModel(1100222);
                    break;
                }
                case 169: {
                    this.models[169] = new LabelModel(1100169);
                    break;
                }
                case 135: {
                    this.models[135] = new ChoiceModel(1100135);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(1100089);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(1100101);
                    break;
                }
                case 226: {
                    this.models[226] = new ChoiceModel(1100226);
                    break;
                }
                case 88: {
                    this.models[88] = new ChoiceModel(1100088);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(1100123);
                    break;
                }
                case 308: {
                    this.models[308] = new LabelModel(1100308);
                    break;
                }
                case 176: {
                    this.models[176] = new ChoiceModel(1100176);
                    break;
                }
                case 337: {
                    this.models[337] = new ChoiceModel(1100337);
                    break;
                }
                case 125: {
                    this.models[125] = new MetricsModel(1100125);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(1100116);
                    break;
                }
                case 87: {
                    this.models[87] = new ChoiceModel(1100087);
                    break;
                }
                case 319: {
                    this.models[319] = new ChoiceModel(1100319);
                    break;
                }
                case 92: {
                    this.models[92] = new ChoiceModel(1100092);
                    break;
                }
                case 296: {
                    this.models[296] = new ChoiceModel(1100296);
                    break;
                }
                case 311: {
                    this.models[311] = new RangeModel(1100311);
                    break;
                }
                case 256: {
                    this.models[256] = new ChoiceModel(1100256);
                    break;
                }
                case 314: {
                    this.models[314] = new TiledListModel(1100314, null);
                    break;
                }
                case 283: {
                    this.models[283] = new ChoiceModel(1100283);
                    break;
                }
                case 249: {
                    this.models[249] = new ButtonModel(1100249);
                    break;
                }
                case 277: {
                    this.models[277] = new ChoiceModel(1100277);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(1100099);
                    break;
                }
                case 98: {
                    this.models[98] = new ChoiceModel(1100098);
                    break;
                }
                case 223: {
                    this.models[223] = new BrowserModel(1100223);
                    break;
                }
                case 228: {
                    this.models[228] = new ChoiceModel(1100228);
                    break;
                }
                case 244: {
                    this.models[244] = new ChoiceModel(1100244);
                    break;
                }
                case 290: {
                    this.models[290] = new ChoiceModel(1100290);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(1100187);
                    break;
                }
                case 151: {
                    this.models[151] = new ChoiceModel(1100151);
                    break;
                }
                case 132: {
                    this.models[132] = new RangeModel(1100132);
                    break;
                }
                case 280: {
                    this.models[280] = new ButtonModel(1100280);
                    break;
                }
                case 211: {
                    this.models[211] = new ChoiceModel(1100211);
                    break;
                }
                case 225: {
                    this.models[225] = new ChoiceModel(1100225);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(1100114);
                    break;
                }
                case 293: {
                    this.models[293] = new ChoiceModel(1100293);
                    break;
                }
                case 94: {
                    this.models[94] = new ChoiceModel(1100094);
                    break;
                }
                case 241: {
                    this.models[241] = new ChoiceModel(1100241);
                    break;
                }
                case 189: {
                    this.models[189] = new ChoiceModel(1100189);
                    break;
                }
                case 224: {
                    this.models[224] = new ChoiceModel(1100224);
                    break;
                }
                case 240: {
                    this.models[240] = new ChoiceModel(1100240);
                    break;
                }
                case 289: {
                    this.models[289] = new ChoiceModel(1100289);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(1100104);
                    break;
                }
                case 153: {
                    this.models[153] = new ChoiceModel(1100153);
                    break;
                }
                case 326: {
                    this.models[326] = new ButtonModel(1100326);
                    break;
                }
                case 179: {
                    this.models[179] = new ChoiceModel(1100179);
                    break;
                }
                case 297: {
                    this.models[297] = new ChoiceModel(1100297);
                    break;
                }
                case 286: {
                    this.models[286] = new ChoiceModel(1100286);
                    break;
                }
                case 276: {
                    this.models[276] = new BaseListModel(1100276, null);
                    break;
                }
                case 214: {
                    this.models[214] = new ButtonModel(1100214);
                    break;
                }
                case 102: {
                    this.models[102] = new ChoiceModel(1100102);
                    break;
                }
                case 97: {
                    this.models[97] = new ChoiceModel(1100097);
                    break;
                }
                case 239: {
                    this.models[239] = new ChoiceModel(1100239);
                    break;
                }
                default: {
                    SettingsModelBank.getModelLogChannel().log(10000, "[SettingsModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public SettingsModelBank() {
        super(11, 340, 136);
        this.modelIDs = new int[136];
        this.modelIDs[0] = 1100212;
        this.modelIDs[1] = 1100183;
        this.modelIDs[2] = 1100134;
        this.modelIDs[3] = 1100139;
        this.modelIDs[4] = 1100191;
        this.modelIDs[5] = 1100313;
        this.modelIDs[6] = 1100147;
        this.modelIDs[7] = 1100260;
        this.modelIDs[8] = 1100287;
        this.modelIDs[9] = 1100122;
        this.modelIDs[10] = 1100166;
        this.modelIDs[11] = 1100272;
        this.modelIDs[12] = 1100275;
        this.modelIDs[13] = 1100142;
        this.modelIDs[14] = 1100255;
        this.modelIDs[15] = 1100250;
        this.modelIDs[16] = 1100117;
        this.modelIDs[17] = 1100274;
        this.modelIDs[18] = 1100182;
        this.modelIDs[19] = 1100091;
        this.modelIDs[20] = 1100312;
        this.modelIDs[21] = 1100143;
        this.modelIDs[22] = 1100194;
        this.modelIDs[23] = 1100269;
        this.modelIDs[24] = 1100266;
        this.modelIDs[25] = 1100245;
        this.modelIDs[26] = 1100136;
        this.modelIDs[27] = 1100247;
        this.modelIDs[28] = 1100227;
        this.modelIDs[29] = 1100119;
        this.modelIDs[30] = 1100248;
        this.modelIDs[31] = 1100196;
        this.modelIDs[32] = 1100257;
        this.modelIDs[33] = 1100268;
        this.modelIDs[34] = 1100278;
        this.modelIDs[35] = 1100288;
        this.modelIDs[36] = 1100281;
        this.modelIDs[37] = 1100246;
        this.modelIDs[38] = 1100295;
        this.modelIDs[39] = 1100259;
        this.modelIDs[40] = 1100271;
        this.modelIDs[41] = 1100155;
        this.modelIDs[42] = 1100145;
        this.modelIDs[43] = 1100085;
        this.modelIDs[44] = 1100103;
        this.modelIDs[45] = 1100184;
        this.modelIDs[46] = 1100316;
        this.modelIDs[47] = 1100273;
        this.modelIDs[48] = 1100168;
        this.modelIDs[49] = 1100095;
        this.modelIDs[50] = 1100291;
        this.modelIDs[51] = 1100253;
        this.modelIDs[52] = 1100284;
        this.modelIDs[53] = 1100285;
        this.modelIDs[54] = 1100267;
        this.modelIDs[55] = 1100090;
        this.modelIDs[56] = 1100261;
        this.modelIDs[57] = 1100258;
        this.modelIDs[58] = 1100294;
        this.modelIDs[59] = 1100339;
        this.modelIDs[60] = 1100315;
        this.modelIDs[61] = 1100180;
        this.modelIDs[62] = 1100305;
        this.modelIDs[63] = 1100105;
        this.modelIDs[64] = 1100138;
        this.modelIDs[65] = 1100282;
        this.modelIDs[66] = 1100149;
        this.modelIDs[67] = 1100238;
        this.modelIDs[68] = 1100230;
        this.modelIDs[69] = 1100093;
        this.modelIDs[70] = 1100279;
        this.modelIDs[71] = 1100262;
        this.modelIDs[72] = 1100298;
        this.modelIDs[73] = 1100338;
        this.modelIDs[74] = 1100264;
        this.modelIDs[75] = 1100100;
        this.modelIDs[76] = 1100096;
        this.modelIDs[77] = 1100317;
        this.modelIDs[78] = 1100185;
        this.modelIDs[79] = 1100186;
        this.modelIDs[80] = 1100237;
        this.modelIDs[81] = 1100086;
        this.modelIDs[82] = 1100222;
        this.modelIDs[83] = 1100169;
        this.modelIDs[84] = 1100135;
        this.modelIDs[85] = 1100089;
        this.modelIDs[86] = 1100101;
        this.modelIDs[87] = 1100226;
        this.modelIDs[88] = 1100088;
        this.modelIDs[89] = 1100123;
        this.modelIDs[90] = 1100308;
        this.modelIDs[91] = 1100176;
        this.modelIDs[92] = 1100337;
        this.modelIDs[93] = 1100125;
        this.modelIDs[94] = 1100116;
        this.modelIDs[95] = 1100087;
        this.modelIDs[96] = 1100319;
        this.modelIDs[97] = 1100092;
        this.modelIDs[98] = 1100296;
        this.modelIDs[99] = 1100311;
        this.modelIDs[100] = 1100256;
        this.modelIDs[101] = 1100314;
        this.modelIDs[102] = 1100283;
        this.modelIDs[103] = 1100249;
        this.modelIDs[104] = 1100277;
        this.modelIDs[105] = 1100099;
        this.modelIDs[106] = 1100098;
        this.modelIDs[107] = 1100223;
        this.modelIDs[108] = 1100228;
        this.modelIDs[109] = 1100244;
        this.modelIDs[110] = 1100290;
        this.modelIDs[111] = 1100187;
        this.modelIDs[112] = 1100151;
        this.modelIDs[113] = 1100132;
        this.modelIDs[114] = 1100280;
        this.modelIDs[115] = 1100211;
        this.modelIDs[116] = 1100225;
        this.modelIDs[117] = 1100114;
        this.modelIDs[118] = 1100293;
        this.modelIDs[119] = 1100094;
        this.modelIDs[120] = 1100241;
        this.modelIDs[121] = 1100189;
        this.modelIDs[122] = 1100224;
        this.modelIDs[123] = 1100240;
        this.modelIDs[124] = 1100289;
        this.modelIDs[125] = 1100104;
        this.modelIDs[126] = 1100153;
        this.modelIDs[127] = 1100326;
        this.modelIDs[128] = 1100179;
        this.modelIDs[129] = 1100297;
        this.modelIDs[130] = 1100286;
        this.modelIDs[131] = 1100276;
        this.modelIDs[132] = 1100214;
        this.modelIDs[133] = 1100102;
        this.modelIDs[134] = 1100097;
        this.modelIDs[135] = 1100239;
    }
}

