/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.TextfieldModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.model.ICoreConnectivityModelBank;
import de.audi.atip.model.IEvoConnectivityModelBank;

public class ConnectivityModelBank
extends AbstractModelBank
implements ICoreConnectivityModelBank,
IEvoConnectivityModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 15: {
                    this.models[15] = new TextfieldModel(2500015);
                    break;
                }
                case 13: {
                    this.models[13] = new ChoiceModel(2500013);
                    break;
                }
                case 115: {
                    this.models[115] = new ButtonModel(2500115);
                    break;
                }
                case 169: {
                    this.models[169] = new ButtonModel(2500169);
                    break;
                }
                case 300: {
                    this.models[300] = new BaseListModel(0x2626CC, null);
                    break;
                }
                case 210: {
                    this.models[210] = new ButtonModel(0x262672);
                    break;
                }
                case 369: {
                    this.models[369] = new TextfieldModel(2500369);
                    break;
                }
                case 119: {
                    this.models[119] = new SpellerModel(2500119);
                    break;
                }
                case 171: {
                    this.models[171] = new ButtonModel(2500171);
                    break;
                }
                case 104: {
                    this.models[104] = new ButtonModel(2500104);
                    break;
                }
                case 223: {
                    this.models[223] = new BaseListModel(2500223, null);
                    break;
                }
                case 212: {
                    this.models[212] = new LabelModel(2500212);
                    break;
                }
                case 224: {
                    this.models[224] = new ChoiceModel(2500224);
                    break;
                }
                case 217: {
                    this.models[217] = new ChoiceModel(2500217);
                    break;
                }
                case 148: {
                    this.models[148] = new ChoiceModel(2500148);
                    break;
                }
                case 143: {
                    this.models[143] = new ChoiceModel(0x26262F);
                    break;
                }
                case 283: {
                    this.models[283] = new BaseListModel(0x2626BB, null);
                    break;
                }
                case 381: {
                    this.models[381] = new ChoiceModel(2500381);
                    break;
                }
                case 18: {
                    this.models[18] = new TextfieldModel(2500018);
                    break;
                }
                case 45: {
                    this.models[45] = new SpellerModel(2500045);
                    break;
                }
                case 303: {
                    this.models[303] = new SpellerModel(2500303);
                    break;
                }
                case 382: {
                    this.models[382] = new ChoiceModel(2500382);
                    break;
                }
                case 354: {
                    this.models[354] = new TextfieldModel(2500354);
                    break;
                }
                case 222: {
                    this.models[222] = new BaseListModel(2500222, null);
                    break;
                }
                case 198: {
                    this.models[198] = new MetricsModel(0x262666);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(2500105);
                    break;
                }
                case 432: {
                    this.models[432] = new ButtonModel(2500432);
                    break;
                }
                case 139: {
                    this.models[139] = new ButtonModel(0x26262B);
                    break;
                }
                case 19: {
                    this.models[19] = new SpellerModel(2500019);
                    break;
                }
                case 323: {
                    this.models[323] = new OptionModel(2500323);
                    break;
                }
                case 200: {
                    this.models[200] = new MetricsModel(0x262668);
                    break;
                }
                case 355: {
                    this.models[355] = new SpellerModel(2500355);
                    break;
                }
                case 168: {
                    this.models[168] = new ButtonModel(2500168);
                    break;
                }
                case 353: {
                    this.models[353] = new ChoiceModel(2500353);
                    break;
                }
                case 201: {
                    this.models[201] = new BaseListModel(0x262669, null);
                    break;
                }
                case 184: {
                    this.models[184] = new ChoiceModel(2500184);
                    break;
                }
                case 325: {
                    this.models[325] = new ChoiceModel(2500325);
                    break;
                }
                case 368: {
                    this.models[368] = new ChoiceModel(2500368);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(2500044);
                    break;
                }
                case 314: {
                    this.models[314] = new SpellerModel(2500314);
                    break;
                }
                case 218: {
                    this.models[218] = new ChoiceModel(2500218);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(2500187);
                    break;
                }
                case 230: {
                    this.models[230] = new ChoiceModel(0x262686);
                    break;
                }
                case 114: {
                    this.models[114] = new ButtonModel(0x262612);
                    break;
                }
                case 133: {
                    this.models[133] = new TextfieldModel(0x262625);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(0x262696);
                    break;
                }
                case 356: {
                    this.models[356] = new TextfieldModel(2500356);
                    break;
                }
                case 357: {
                    this.models[357] = new ButtonModel(2500357);
                    break;
                }
                case 170: {
                    this.models[170] = new ButtonModel(2500170);
                    break;
                }
                case 160: {
                    this.models[160] = new ButtonModel(2500160);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(2500106);
                    break;
                }
                case 243: {
                    this.models[243] = new ButtonModel(2500243);
                    break;
                }
                case 46: {
                    this.models[46] = new ButtonModel(2500046);
                    break;
                }
                case 358: {
                    this.models[358] = new ButtonModel(2500358);
                    break;
                }
                case 359: {
                    this.models[359] = new SpellerModel(2500359);
                    break;
                }
                case 245: {
                    this.models[245] = new ButtonModel(2500245);
                    break;
                }
                case 192: {
                    this.models[192] = new ChoiceModel(0x262660);
                    break;
                }
                case 229: {
                    this.models[229] = new ChoiceModel(2500229);
                    break;
                }
                case 433: {
                    this.models[433] = new ChoiceModel(2500433);
                    break;
                }
                case 263: {
                    this.models[263] = new ButtonModel(2500263);
                    break;
                }
                case 360: {
                    this.models[360] = new ButtonModel(2500360);
                    break;
                }
                case 144: {
                    this.models[144] = new ButtonModel(2500144);
                    break;
                }
                case 189: {
                    this.models[189] = new ChoiceModel(2500189);
                    break;
                }
                case 219: {
                    this.models[219] = new ButtonModel(2500219);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(2500237);
                    break;
                }
                case 130: {
                    this.models[130] = new ChoiceModel(0x262622);
                    break;
                }
                case 338: {
                    this.models[338] = new ButtonModel(0x2626F2);
                    break;
                }
                case 131: {
                    this.models[131] = new ChoiceModel(0x262623);
                    break;
                }
                case 110: {
                    this.models[110] = new OptionModel(2500110);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(2500127);
                    break;
                }
                case 100: {
                    this.models[100] = new LabelModel(2500100);
                    break;
                }
                case 249: {
                    this.models[249] = new ButtonModel(0x262699);
                    break;
                }
                case 91: {
                    this.models[91] = new OptionModel(2500091);
                    break;
                }
                case 147: {
                    this.models[147] = new ButtonModel(0x262633);
                    break;
                }
                case 120: {
                    this.models[120] = new ButtonModel(2500120);
                    break;
                }
                case 339: {
                    this.models[339] = new ChoiceModel(2500339);
                    break;
                }
                case 370: {
                    this.models[370] = new ChoiceModel(2500370);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(2500183);
                    break;
                }
                case 280: {
                    this.models[280] = new ButtonModel(2500280);
                    break;
                }
                case 378: {
                    this.models[378] = new ChoiceModel(2500378);
                    break;
                }
                case 379: {
                    this.models[379] = new ButtonModel(2500379);
                    break;
                }
                case 220: {
                    this.models[220] = new ChoiceModel(2500220);
                    break;
                }
                case 41: {
                    this.models[41] = new ButtonModel(2500041);
                    break;
                }
                case 191: {
                    this.models[191] = new ChoiceModel(2500191);
                    break;
                }
                case 195: {
                    this.models[195] = new ChoiceModel(0x262663);
                    break;
                }
                case 321: {
                    this.models[321] = new ButtonModel(2500321);
                    break;
                }
                case 208: {
                    this.models[208] = new LabelModel(2500208);
                    break;
                }
                case 179: {
                    this.models[179] = new OptionModel(2500179);
                    break;
                }
                case 116: {
                    this.models[116] = new ButtonModel(2500116);
                    break;
                }
                case 146: {
                    this.models[146] = new SpellerModel(0x262632);
                    break;
                }
                case 20: {
                    this.models[20] = new ChoiceModel(2500020);
                    break;
                }
                case 161: {
                    this.models[161] = new ButtonModel(2500161);
                    break;
                }
                case 361: {
                    this.models[361] = new ButtonModel(2500361);
                    break;
                }
                case 215: {
                    this.models[215] = new ChoiceModel(0x262677);
                    break;
                }
                case 194: {
                    this.models[194] = new ButtonModel(0x262662);
                    break;
                }
                case 240: {
                    this.models[240] = new ButtonModel(2500240);
                    break;
                }
                case 203: {
                    this.models[203] = new ChoiceModel(0x26266B);
                    break;
                }
                case 362: {
                    this.models[362] = new SpellerModel(2500362);
                    break;
                }
                case 152: {
                    this.models[152] = new ButtonModel(2500152);
                    break;
                }
                case 140: {
                    this.models[140] = new ChoiceModel(0x26262C);
                    break;
                }
                case 363: {
                    this.models[363] = new SpellerModel(2500363);
                    break;
                }
                case 121: {
                    this.models[121] = new ButtonModel(2500121);
                    break;
                }
                case 225: {
                    this.models[225] = new ChoiceModel(2500225);
                    break;
                }
                case 250: {
                    this.models[250] = new ChoiceModel(2500250);
                    break;
                }
                case 190: {
                    this.models[190] = new ChoiceModel(2500190);
                    break;
                }
                case 320: {
                    this.models[320] = new MenuModel(2500320);
                    break;
                }
                case 239: {
                    this.models[239] = new TextfieldModel(2500239);
                    break;
                }
                case 207: {
                    this.models[207] = new ChoiceModel(0x26266F);
                    break;
                }
                case 377: {
                    this.models[377] = new ChoiceModel(2500377);
                    break;
                }
                case 340: {
                    this.models[340] = new OptionModel(2500340);
                    break;
                }
                case 319: {
                    this.models[319] = new ChoiceModel(2500319);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(2500145);
                    break;
                }
                case 216: {
                    this.models[216] = new LabelModel(2500216);
                    break;
                }
                case 244: {
                    this.models[244] = new ButtonModel(2500244);
                    break;
                }
                case 151: {
                    this.models[151] = new ChoiceModel(2500151);
                    break;
                }
                case 209: {
                    this.models[209] = new SpellerModel(2500209);
                    break;
                }
                case 364: {
                    this.models[364] = new SpellerModel(2500364);
                    break;
                }
                case 141: {
                    this.models[141] = new ChoiceModel(0x26262D);
                    break;
                }
                case 435: {
                    this.models[435] = new BaseListModel(2500435, (MenuModel)this.getModel(2500320));
                    break;
                }
                case 162: {
                    this.models[162] = new ButtonModel(0x262642);
                    break;
                }
                case 315: {
                    this.models[315] = new SpellerModel(2500315);
                    break;
                }
                case 98: {
                    this.models[98] = new ChoiceModel(0x262602);
                    break;
                }
                case 150: {
                    this.models[150] = new ChoiceModel(0x262636);
                    break;
                }
                case 299: {
                    this.models[299] = new SpellerModel(2500299);
                    break;
                }
                case 204: {
                    this.models[204] = new ButtonModel(0x26266C);
                    break;
                }
                case 156: {
                    this.models[156] = new TextfieldModel(2500156);
                    break;
                }
                case 158: {
                    this.models[158] = new ButtonModel(2500158);
                    break;
                }
                case 367: {
                    this.models[367] = new ChoiceModel(2500367);
                    break;
                }
                case 248: {
                    this.models[248] = new ChoiceModel(2500248);
                    break;
                }
                case 287: {
                    this.models[287] = new ChoiceModel(2500287);
                    break;
                }
                case 288: {
                    this.models[288] = new ChoiceModel(2500288);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(2500185);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(2500117);
                    break;
                }
                case 188: {
                    this.models[188] = new ChoiceModel(2500188);
                    break;
                }
                case 157: {
                    this.models[157] = new SpellerModel(2500157);
                    break;
                }
                case 66: {
                    this.models[66] = new ChoiceModel(2500066);
                    break;
                }
                case 205: {
                    this.models[205] = new ButtonModel(0x26266D);
                    break;
                }
                case 136: {
                    this.models[136] = new ButtonModel(0x262628);
                    break;
                }
                case 181: {
                    this.models[181] = new ChoiceModel(0x262655);
                    break;
                }
                case 253: {
                    this.models[253] = new ButtonModel(2500253);
                    break;
                }
                case 365: {
                    this.models[365] = new TextfieldModel(2500365);
                    break;
                }
                case 102: {
                    this.models[102] = new ButtonModel(0x262606);
                    break;
                }
                case 42: {
                    this.models[42] = new ChoiceModel(2500042);
                    break;
                }
                case 206: {
                    this.models[206] = new ButtonModel(0x26266E);
                    break;
                }
                case 142: {
                    this.models[142] = new ChoiceModel(0x26262E);
                    break;
                }
                case 311: {
                    this.models[311] = new ButtonModel(2500311);
                    break;
                }
                case 165: {
                    this.models[165] = new ButtonModel(2500165);
                    break;
                }
                case 138: {
                    this.models[138] = new ChoiceModel(0x26262A);
                    break;
                }
                case 221: {
                    this.models[221] = new BaseListModel(2500221, null);
                    break;
                }
                case 316: {
                    this.models[316] = new ChoiceModel(2500316);
                    break;
                }
                case 391: {
                    this.models[391] = new ChoiceModel(0x262727);
                    break;
                }
                case 255: {
                    this.models[255] = new ChoiceModel(2500255);
                    break;
                }
                case 380: {
                    this.models[380] = new ButtonModel(2500380);
                    break;
                }
                case 202: {
                    this.models[202] = new ChoiceModel(0x26266A);
                    break;
                }
                case 366: {
                    this.models[366] = new SpellerModel(2500366);
                    break;
                }
                case 431: {
                    this.models[431] = new ButtonModel(2500431);
                    break;
                }
                case 214: {
                    this.models[214] = new ChoiceModel(0x262676);
                    break;
                }
                case 132: {
                    this.models[132] = new SpellerModel(0x262624);
                    break;
                }
                case 124: {
                    this.models[124] = new LabelModel(2500124);
                    break;
                }
                case 211: {
                    this.models[211] = new SpellerModel(2500211);
                    break;
                }
                case 376: {
                    this.models[376] = new ChoiceModel(2500376);
                    break;
                }
                case 285: {
                    this.models[285] = new ChoiceModel(2500285);
                    break;
                }
                case 301: {
                    this.models[301] = new SpellerModel(2500301);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(2500312);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(2500149);
                    break;
                }
                case 101: {
                    this.models[101] = new ButtonModel(2500101);
                    break;
                }
                case 134: {
                    this.models[134] = new ButtonModel(0x262626);
                    break;
                }
                case 199: {
                    this.models[199] = new MetricsModel(0x262667);
                    break;
                }
                case 99: {
                    this.models[99] = new ButtonModel(2500099);
                    break;
                }
                case 103: {
                    this.models[103] = new LabelModel(2500103);
                    break;
                }
                case 302: {
                    this.models[302] = new SpellerModel(2500302);
                    break;
                }
                case 324: {
                    this.models[324] = new ChoiceModel(2500324);
                    break;
                }
                case 126: {
                    this.models[126] = new SpellerModel(2500126);
                    break;
                }
                case 16: {
                    this.models[16] = new SpellerModel(2500016);
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(0x262616);
                    break;
                }
                case 284: {
                    this.models[284] = new ChoiceModel(2500284);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(2500159);
                    break;
                }
                case 40: {
                    this.models[40] = new ButtonModel(2500040);
                    break;
                }
                case 231: {
                    this.models[231] = new ChoiceModel(2500231);
                    break;
                }
                case 125: {
                    this.models[125] = new TextfieldModel(2500125);
                    break;
                }
                default: {
                    ConnectivityModelBank.getModelLogChannel().log(10000, "[ConnectivityModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public ConnectivityModelBank() {
        super(25, 436, 180);
        this.modelIDs = new int[180];
        this.modelIDs[0] = 2500015;
        this.modelIDs[1] = 2500013;
        this.modelIDs[2] = 2500115;
        this.modelIDs[3] = 2500169;
        this.modelIDs[4] = 0x2626CC;
        this.modelIDs[5] = 0x262672;
        this.modelIDs[6] = 2500369;
        this.modelIDs[7] = 2500119;
        this.modelIDs[8] = 2500171;
        this.modelIDs[9] = 2500104;
        this.modelIDs[10] = 2500223;
        this.modelIDs[11] = 2500212;
        this.modelIDs[12] = 2500224;
        this.modelIDs[13] = 2500217;
        this.modelIDs[14] = 2500148;
        this.modelIDs[15] = 0x26262F;
        this.modelIDs[16] = 0x2626BB;
        this.modelIDs[17] = 2500381;
        this.modelIDs[18] = 2500018;
        this.modelIDs[19] = 2500045;
        this.modelIDs[20] = 2500303;
        this.modelIDs[21] = 2500382;
        this.modelIDs[22] = 2500354;
        this.modelIDs[23] = 2500222;
        this.modelIDs[24] = 0x262666;
        this.modelIDs[25] = 2500105;
        this.modelIDs[26] = 2500432;
        this.modelIDs[27] = 0x26262B;
        this.modelIDs[28] = 2500019;
        this.modelIDs[29] = 2500323;
        this.modelIDs[30] = 0x262668;
        this.modelIDs[31] = 2500355;
        this.modelIDs[32] = 2500168;
        this.modelIDs[33] = 2500353;
        this.modelIDs[34] = 0x262669;
        this.modelIDs[35] = 2500184;
        this.modelIDs[36] = 2500325;
        this.modelIDs[37] = 2500368;
        this.modelIDs[38] = 2500044;
        this.modelIDs[39] = 2500314;
        this.modelIDs[40] = 2500218;
        this.modelIDs[41] = 2500187;
        this.modelIDs[42] = 0x262686;
        this.modelIDs[43] = 0x262612;
        this.modelIDs[44] = 0x262625;
        this.modelIDs[45] = 0x262696;
        this.modelIDs[46] = 2500356;
        this.modelIDs[47] = 2500357;
        this.modelIDs[48] = 2500170;
        this.modelIDs[49] = 2500160;
        this.modelIDs[50] = 2500106;
        this.modelIDs[51] = 2500243;
        this.modelIDs[52] = 2500046;
        this.modelIDs[53] = 2500358;
        this.modelIDs[54] = 2500359;
        this.modelIDs[55] = 2500245;
        this.modelIDs[56] = 0x262660;
        this.modelIDs[57] = 2500229;
        this.modelIDs[58] = 2500433;
        this.modelIDs[59] = 2500263;
        this.modelIDs[60] = 2500360;
        this.modelIDs[61] = 2500144;
        this.modelIDs[62] = 2500189;
        this.modelIDs[63] = 2500219;
        this.modelIDs[64] = 2500237;
        this.modelIDs[65] = 0x262622;
        this.modelIDs[66] = 0x2626F2;
        this.modelIDs[67] = 0x262623;
        this.modelIDs[68] = 2500110;
        this.modelIDs[69] = 2500127;
        this.modelIDs[70] = 2500100;
        this.modelIDs[71] = 0x262699;
        this.modelIDs[72] = 2500091;
        this.modelIDs[73] = 0x262633;
        this.modelIDs[74] = 2500120;
        this.modelIDs[75] = 2500339;
        this.modelIDs[76] = 2500370;
        this.modelIDs[77] = 2500183;
        this.modelIDs[78] = 2500280;
        this.modelIDs[79] = 2500378;
        this.modelIDs[80] = 2500379;
        this.modelIDs[81] = 2500220;
        this.modelIDs[82] = 2500041;
        this.modelIDs[83] = 2500191;
        this.modelIDs[84] = 0x262663;
        this.modelIDs[85] = 2500321;
        this.modelIDs[86] = 2500208;
        this.modelIDs[87] = 2500179;
        this.modelIDs[88] = 2500116;
        this.modelIDs[89] = 0x262632;
        this.modelIDs[90] = 2500020;
        this.modelIDs[91] = 2500161;
        this.modelIDs[92] = 2500361;
        this.modelIDs[93] = 0x262677;
        this.modelIDs[94] = 0x262662;
        this.modelIDs[95] = 2500240;
        this.modelIDs[96] = 0x26266B;
        this.modelIDs[97] = 2500362;
        this.modelIDs[98] = 2500152;
        this.modelIDs[99] = 0x26262C;
        this.modelIDs[100] = 2500363;
        this.modelIDs[101] = 2500121;
        this.modelIDs[102] = 2500225;
        this.modelIDs[103] = 2500250;
        this.modelIDs[104] = 2500190;
        this.modelIDs[105] = 2500320;
        this.modelIDs[106] = 2500239;
        this.modelIDs[107] = 0x26266F;
        this.modelIDs[108] = 2500377;
        this.modelIDs[109] = 2500340;
        this.modelIDs[110] = 2500319;
        this.modelIDs[111] = 2500145;
        this.modelIDs[112] = 2500216;
        this.modelIDs[113] = 2500244;
        this.modelIDs[114] = 2500151;
        this.modelIDs[115] = 2500209;
        this.modelIDs[116] = 2500364;
        this.modelIDs[117] = 0x26262D;
        this.modelIDs[118] = 2500435;
        this.modelIDs[119] = 0x262642;
        this.modelIDs[120] = 2500315;
        this.modelIDs[121] = 0x262602;
        this.modelIDs[122] = 0x262636;
        this.modelIDs[123] = 2500299;
        this.modelIDs[124] = 0x26266C;
        this.modelIDs[125] = 2500156;
        this.modelIDs[126] = 2500158;
        this.modelIDs[127] = 2500367;
        this.modelIDs[128] = 2500248;
        this.modelIDs[129] = 2500287;
        this.modelIDs[130] = 2500288;
        this.modelIDs[131] = 2500185;
        this.modelIDs[132] = 2500117;
        this.modelIDs[133] = 2500188;
        this.modelIDs[134] = 2500157;
        this.modelIDs[135] = 2500066;
        this.modelIDs[136] = 0x26266D;
        this.modelIDs[137] = 0x262628;
        this.modelIDs[138] = 0x262655;
        this.modelIDs[139] = 2500253;
        this.modelIDs[140] = 2500365;
        this.modelIDs[141] = 0x262606;
        this.modelIDs[142] = 2500042;
        this.modelIDs[143] = 0x26266E;
        this.modelIDs[144] = 0x26262E;
        this.modelIDs[145] = 2500311;
        this.modelIDs[146] = 2500165;
        this.modelIDs[147] = 0x26262A;
        this.modelIDs[148] = 2500221;
        this.modelIDs[149] = 2500316;
        this.modelIDs[150] = 0x262727;
        this.modelIDs[151] = 2500255;
        this.modelIDs[152] = 2500380;
        this.modelIDs[153] = 0x26266A;
        this.modelIDs[154] = 2500366;
        this.modelIDs[155] = 2500431;
        this.modelIDs[156] = 0x262676;
        this.modelIDs[157] = 0x262624;
        this.modelIDs[158] = 2500124;
        this.modelIDs[159] = 2500211;
        this.modelIDs[160] = 2500376;
        this.modelIDs[161] = 2500285;
        this.modelIDs[162] = 2500301;
        this.modelIDs[163] = 2500312;
        this.modelIDs[164] = 2500149;
        this.modelIDs[165] = 2500101;
        this.modelIDs[166] = 0x262626;
        this.modelIDs[167] = 0x262667;
        this.modelIDs[168] = 2500099;
        this.modelIDs[169] = 2500103;
        this.modelIDs[170] = 2500302;
        this.modelIDs[171] = 2500324;
        this.modelIDs[172] = 2500126;
        this.modelIDs[173] = 2500016;
        this.modelIDs[174] = 0x262616;
        this.modelIDs[175] = 2500284;
        this.modelIDs[176] = 2500159;
        this.modelIDs[177] = 2500040;
        this.modelIDs[178] = 2500231;
        this.modelIDs[179] = 2500125;
    }
}

