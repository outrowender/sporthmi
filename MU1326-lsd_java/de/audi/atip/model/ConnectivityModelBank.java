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
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 15: {
                    this.models[15] = new TextfieldModel(-1356519936);
                    break;
                }
                case 13: {
                    this.models[13] = new ChoiceModel(-1390074368);
                    break;
                }
                case 115: {
                    this.models[115] = new ButtonModel(321267200);
                    break;
                }
                case 169: {
                    this.models[169] = new ButtonModel(1227236864);
                    break;
                }
                case 300: {
                    this.models[300] = new BaseListModel(-869915136, null);
                    break;
                }
                case 210: {
                    this.models[210] = new ButtonModel(1915102720);
                    break;
                }
                case 369: {
                    this.models[369] = new TextfieldModel(287778304);
                    break;
                }
                case 119: {
                    this.models[119] = new SpellerModel(388376064);
                    break;
                }
                case 171: {
                    this.models[171] = new ButtonModel(1260791296);
                    break;
                }
                case 104: {
                    this.models[104] = new ButtonModel(136717824);
                    break;
                }
                case 223: {
                    this.models[223] = new BaseListModel(2133206528, null);
                    break;
                }
                case 212: {
                    this.models[212] = new LabelModel(1948657152);
                    break;
                }
                case 224: {
                    this.models[224] = new ChoiceModel(-2144983552);
                    break;
                }
                case 217: {
                    this.models[217] = new ChoiceModel(2032543232);
                    break;
                }
                case 148: {
                    this.models[148] = new ChoiceModel(874915328);
                    break;
                }
                case 143: {
                    this.models[143] = new ChoiceModel(791029248);
                    break;
                }
                case 283: {
                    this.models[283] = new BaseListModel(-1155127808, null);
                    break;
                }
                case 381: {
                    this.models[381] = new ChoiceModel(489104896);
                    break;
                }
                case 18: {
                    this.models[18] = new TextfieldModel(-1306188288);
                    break;
                }
                case 45: {
                    this.models[45] = new SpellerModel(-853203456);
                    break;
                }
                case 303: {
                    this.models[303] = new SpellerModel(-819583488);
                    break;
                }
                case 382: {
                    this.models[382] = new ChoiceModel(505882112);
                    break;
                }
                case 354: {
                    this.models[354] = new TextfieldModel(36120064);
                    break;
                }
                case 222: {
                    this.models[222] = new BaseListModel(2116429312, null);
                    break;
                }
                case 198: {
                    this.models[198] = new MetricsModel(0x66262600);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(153495040);
                    break;
                }
                case 432: {
                    this.models[432] = new ButtonModel(1344742912);
                    break;
                }
                case 139: {
                    this.models[139] = new ButtonModel(723920384);
                    break;
                }
                case 19: {
                    this.models[19] = new SpellerModel(-1289411072);
                    break;
                }
                case 323: {
                    this.models[323] = new OptionModel(-484039168);
                    break;
                }
                case 200: {
                    this.models[200] = new MetricsModel(1747330560);
                    break;
                }
                case 355: {
                    this.models[355] = new SpellerModel(52897280);
                    break;
                }
                case 168: {
                    this.models[168] = new ButtonModel(1210459648);
                    break;
                }
                case 353: {
                    this.models[353] = new ChoiceModel(19342848);
                    break;
                }
                case 201: {
                    this.models[201] = new BaseListModel(1764107776, null);
                    break;
                }
                case 184: {
                    this.models[184] = new ChoiceModel(1478895104);
                    break;
                }
                case 325: {
                    this.models[325] = new ChoiceModel(-450484736);
                    break;
                }
                case 368: {
                    this.models[368] = new ChoiceModel(271001088);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(-869980672);
                    break;
                }
                case 314: {
                    this.models[314] = new SpellerModel(-635034112);
                    break;
                }
                case 218: {
                    this.models[218] = new ChoiceModel(2049320448);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(1529226752);
                    break;
                }
                case 230: {
                    this.models[230] = new ChoiceModel(-2044320256);
                    break;
                }
                case 114: {
                    this.models[114] = new ButtonModel(304489984);
                    break;
                }
                case 133: {
                    this.models[133] = new TextfieldModel(623257088);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(-1775884800);
                    break;
                }
                case 356: {
                    this.models[356] = new TextfieldModel(69674496);
                    break;
                }
                case 357: {
                    this.models[357] = new ButtonModel(86451712);
                    break;
                }
                case 170: {
                    this.models[170] = new ButtonModel(1244014080);
                    break;
                }
                case 160: {
                    this.models[160] = new ButtonModel(1076241920);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(170272256);
                    break;
                }
                case 243: {
                    this.models[243] = new ButtonModel(-1826216448);
                    break;
                }
                case 46: {
                    this.models[46] = new ButtonModel(-836426240);
                    break;
                }
                case 358: {
                    this.models[358] = new ButtonModel(103228928);
                    break;
                }
                case 359: {
                    this.models[359] = new SpellerModel(120006144);
                    break;
                }
                case 245: {
                    this.models[245] = new ButtonModel(-1792662016);
                    break;
                }
                case 192: {
                    this.models[192] = new ChoiceModel(0x60262600);
                    break;
                }
                case 229: {
                    this.models[229] = new ChoiceModel(-2061097472);
                    break;
                }
                case 433: {
                    this.models[433] = new ChoiceModel(1361520128);
                    break;
                }
                case 263: {
                    this.models[263] = new ButtonModel(-1490672128);
                    break;
                }
                case 360: {
                    this.models[360] = new ButtonModel(136783360);
                    break;
                }
                case 144: {
                    this.models[144] = new ButtonModel(807806464);
                    break;
                }
                case 189: {
                    this.models[189] = new ChoiceModel(1562781184);
                    break;
                }
                case 219: {
                    this.models[219] = new ButtonModel(2066097664);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(-1926879744);
                    break;
                }
                case 130: {
                    this.models[130] = new ChoiceModel(0x22262600);
                    break;
                }
                case 338: {
                    this.models[338] = new ButtonModel(-232380928);
                    break;
                }
                case 131: {
                    this.models[131] = new ChoiceModel(589702656);
                    break;
                }
                case 110: {
                    this.models[110] = new OptionModel(237381120);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(522593792);
                    break;
                }
                case 100: {
                    this.models[100] = new LabelModel(69608960);
                    break;
                }
                case 249: {
                    this.models[249] = new ButtonModel(-1725553152);
                    break;
                }
                case 91: {
                    this.models[91] = new OptionModel(-81451520);
                    break;
                }
                case 147: {
                    this.models[147] = new ButtonModel(858138112);
                    break;
                }
                case 120: {
                    this.models[120] = new ButtonModel(405153280);
                    break;
                }
                case 339: {
                    this.models[339] = new ChoiceModel(-215603712);
                    break;
                }
                case 370: {
                    this.models[370] = new ChoiceModel(304555520);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(1462117888);
                    break;
                }
                case 280: {
                    this.models[280] = new ButtonModel(-1205459456);
                    break;
                }
                case 378: {
                    this.models[378] = new ChoiceModel(438773248);
                    break;
                }
                case 379: {
                    this.models[379] = new ButtonModel(455550464);
                    break;
                }
                case 220: {
                    this.models[220] = new ChoiceModel(2082874880);
                    break;
                }
                case 41: {
                    this.models[41] = new ButtonModel(-920312320);
                    break;
                }
                case 191: {
                    this.models[191] = new ChoiceModel(1596335616);
                    break;
                }
                case 195: {
                    this.models[195] = new ChoiceModel(1663444480);
                    break;
                }
                case 321: {
                    this.models[321] = new ButtonModel(-517593600);
                    break;
                }
                case 208: {
                    this.models[208] = new LabelModel(1881548288);
                    break;
                }
                case 179: {
                    this.models[179] = new OptionModel(1395009024);
                    break;
                }
                case 116: {
                    this.models[116] = new ButtonModel(338044416);
                    break;
                }
                case 146: {
                    this.models[146] = new SpellerModel(841360896);
                    break;
                }
                case 20: {
                    this.models[20] = new ChoiceModel(-1272633856);
                    break;
                }
                case 161: {
                    this.models[161] = new ButtonModel(1093019136);
                    break;
                }
                case 361: {
                    this.models[361] = new ButtonModel(153560576);
                    break;
                }
                case 215: {
                    this.models[215] = new ChoiceModel(1998988800);
                    break;
                }
                case 194: {
                    this.models[194] = new ButtonModel(0x62262600);
                    break;
                }
                case 240: {
                    this.models[240] = new ButtonModel(-1876548096);
                    break;
                }
                case 203: {
                    this.models[203] = new ChoiceModel(1797662208);
                    break;
                }
                case 362: {
                    this.models[362] = new SpellerModel(170337792);
                    break;
                }
                case 152: {
                    this.models[152] = new ButtonModel(942024192);
                    break;
                }
                case 140: {
                    this.models[140] = new ChoiceModel(740697600);
                    break;
                }
                case 363: {
                    this.models[363] = new SpellerModel(187115008);
                    break;
                }
                case 121: {
                    this.models[121] = new ButtonModel(421930496);
                    break;
                }
                case 225: {
                    this.models[225] = new ChoiceModel(-2128206336);
                    break;
                }
                case 250: {
                    this.models[250] = new ChoiceModel(-1708775936);
                    break;
                }
                case 190: {
                    this.models[190] = new ChoiceModel(1579558400);
                    break;
                }
                case 320: {
                    this.models[320] = new MenuModel(-534370816);
                    break;
                }
                case 239: {
                    this.models[239] = new TextfieldModel(-1893325312);
                    break;
                }
                case 207: {
                    this.models[207] = new ChoiceModel(1864771072);
                    break;
                }
                case 377: {
                    this.models[377] = new ChoiceModel(421996032);
                    break;
                }
                case 340: {
                    this.models[340] = new OptionModel(-198826496);
                    break;
                }
                case 319: {
                    this.models[319] = new ChoiceModel(-551148032);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(824583680);
                    break;
                }
                case 216: {
                    this.models[216] = new LabelModel(2015766016);
                    break;
                }
                case 244: {
                    this.models[244] = new ButtonModel(-1809439232);
                    break;
                }
                case 151: {
                    this.models[151] = new ChoiceModel(925246976);
                    break;
                }
                case 209: {
                    this.models[209] = new SpellerModel(1898325504);
                    break;
                }
                case 364: {
                    this.models[364] = new SpellerModel(203892224);
                    break;
                }
                case 141: {
                    this.models[141] = new ChoiceModel(757474816);
                    break;
                }
                case 435: {
                    this.models[435] = new BaseListModel(1395074560, (MenuModel)this.getModel(-534370816));
                    break;
                }
                case 162: {
                    this.models[162] = new ButtonModel(1109796352);
                    break;
                }
                case 315: {
                    this.models[315] = new SpellerModel(-618256896);
                    break;
                }
                case 98: {
                    this.models[98] = new ChoiceModel(0x2262600);
                    break;
                }
                case 150: {
                    this.models[150] = new ChoiceModel(908469760);
                    break;
                }
                case 299: {
                    this.models[299] = new SpellerModel(-886692352);
                    break;
                }
                case 204: {
                    this.models[204] = new ButtonModel(1814439424);
                    break;
                }
                case 156: {
                    this.models[156] = new TextfieldModel(1009133056);
                    break;
                }
                case 158: {
                    this.models[158] = new ButtonModel(1042687488);
                    break;
                }
                case 367: {
                    this.models[367] = new ChoiceModel(254223872);
                    break;
                }
                case 248: {
                    this.models[248] = new ChoiceModel(-1742330368);
                    break;
                }
                case 287: {
                    this.models[287] = new ChoiceModel(-1088018944);
                    break;
                }
                case 288: {
                    this.models[288] = new ChoiceModel(-1071241728);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(1495672320);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(354821632);
                    break;
                }
                case 188: {
                    this.models[188] = new ChoiceModel(1546003968);
                    break;
                }
                case 157: {
                    this.models[157] = new SpellerModel(1025910272);
                    break;
                }
                case 66: {
                    this.models[66] = new ChoiceModel(-500881920);
                    break;
                }
                case 205: {
                    this.models[205] = new ButtonModel(1831216640);
                    break;
                }
                case 136: {
                    this.models[136] = new ButtonModel(673588736);
                    break;
                }
                case 181: {
                    this.models[181] = new ChoiceModel(1428563456);
                    break;
                }
                case 253: {
                    this.models[253] = new ButtonModel(-1658444288);
                    break;
                }
                case 365: {
                    this.models[365] = new TextfieldModel(220669440);
                    break;
                }
                case 102: {
                    this.models[102] = new ButtonModel(0x6262600);
                    break;
                }
                case 42: {
                    this.models[42] = new ChoiceModel(-903535104);
                    break;
                }
                case 206: {
                    this.models[206] = new ButtonModel(1847993856);
                    break;
                }
                case 142: {
                    this.models[142] = new ChoiceModel(774252032);
                    break;
                }
                case 311: {
                    this.models[311] = new ButtonModel(-685365760);
                    break;
                }
                case 165: {
                    this.models[165] = new ButtonModel(1160128000);
                    break;
                }
                case 138: {
                    this.models[138] = new ChoiceModel(707143168);
                    break;
                }
                case 221: {
                    this.models[221] = new BaseListModel(2099652096, null);
                    break;
                }
                case 316: {
                    this.models[316] = new ChoiceModel(-601479680);
                    break;
                }
                case 391: {
                    this.models[391] = new ChoiceModel(656877056);
                    break;
                }
                case 255: {
                    this.models[255] = new ChoiceModel(-1624889856);
                    break;
                }
                case 380: {
                    this.models[380] = new ButtonModel(472327680);
                    break;
                }
                case 202: {
                    this.models[202] = new ChoiceModel(1780884992);
                    break;
                }
                case 366: {
                    this.models[366] = new SpellerModel(237446656);
                    break;
                }
                case 431: {
                    this.models[431] = new ButtonModel(1327965696);
                    break;
                }
                case 214: {
                    this.models[214] = new ChoiceModel(1982211584);
                    break;
                }
                case 132: {
                    this.models[132] = new SpellerModel(606479872);
                    break;
                }
                case 124: {
                    this.models[124] = new LabelModel(472262144);
                    break;
                }
                case 211: {
                    this.models[211] = new SpellerModel(1931879936);
                    break;
                }
                case 376: {
                    this.models[376] = new ChoiceModel(405218816);
                    break;
                }
                case 285: {
                    this.models[285] = new ChoiceModel(-1121573376);
                    break;
                }
                case 301: {
                    this.models[301] = new SpellerModel(-853137920);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(-668588544);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(891692544);
                    break;
                }
                case 101: {
                    this.models[101] = new ButtonModel(86386176);
                    break;
                }
                case 134: {
                    this.models[134] = new ButtonModel(0x26262600);
                    break;
                }
                case 199: {
                    this.models[199] = new MetricsModel(1730553344);
                    break;
                }
                case 99: {
                    this.models[99] = new ButtonModel(52831744);
                    break;
                }
                case 103: {
                    this.models[103] = new LabelModel(119940608);
                    break;
                }
                case 302: {
                    this.models[302] = new SpellerModel(-836360704);
                    break;
                }
                case 324: {
                    this.models[324] = new ChoiceModel(-467261952);
                    break;
                }
                case 126: {
                    this.models[126] = new SpellerModel(505816576);
                    break;
                }
                case 16: {
                    this.models[16] = new SpellerModel(-1339742720);
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(371598848);
                    break;
                }
                case 284: {
                    this.models[284] = new ChoiceModel(-1138350592);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(1059464704);
                    break;
                }
                case 40: {
                    this.models[40] = new ButtonModel(-937089536);
                    break;
                }
                case 231: {
                    this.models[231] = new ChoiceModel(-2027543040);
                    break;
                }
                case 125: {
                    this.models[125] = new TextfieldModel(489039360);
                    break;
                }
                default: {
                    ConnectivityModelBank.getModelLogChannel().log(10000, "[ConnectivityModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public ConnectivityModelBank() {
        super(25, 436, 180);
        this.modelIDs = new int[180];
        this.modelIDs[0] = -1356519936;
        this.modelIDs[1] = -1390074368;
        this.modelIDs[2] = 321267200;
        this.modelIDs[3] = 1227236864;
        this.modelIDs[4] = -869915136;
        this.modelIDs[5] = 1915102720;
        this.modelIDs[6] = 287778304;
        this.modelIDs[7] = 388376064;
        this.modelIDs[8] = 1260791296;
        this.modelIDs[9] = 136717824;
        this.modelIDs[10] = 2133206528;
        this.modelIDs[11] = 1948657152;
        this.modelIDs[12] = -2144983552;
        this.modelIDs[13] = 2032543232;
        this.modelIDs[14] = 874915328;
        this.modelIDs[15] = 791029248;
        this.modelIDs[16] = -1155127808;
        this.modelIDs[17] = 489104896;
        this.modelIDs[18] = -1306188288;
        this.modelIDs[19] = -853203456;
        this.modelIDs[20] = -819583488;
        this.modelIDs[21] = 505882112;
        this.modelIDs[22] = 36120064;
        this.modelIDs[23] = 2116429312;
        this.modelIDs[24] = 0x66262600;
        this.modelIDs[25] = 153495040;
        this.modelIDs[26] = 1344742912;
        this.modelIDs[27] = 723920384;
        this.modelIDs[28] = -1289411072;
        this.modelIDs[29] = -484039168;
        this.modelIDs[30] = 1747330560;
        this.modelIDs[31] = 52897280;
        this.modelIDs[32] = 1210459648;
        this.modelIDs[33] = 19342848;
        this.modelIDs[34] = 1764107776;
        this.modelIDs[35] = 1478895104;
        this.modelIDs[36] = -450484736;
        this.modelIDs[37] = 271001088;
        this.modelIDs[38] = -869980672;
        this.modelIDs[39] = -635034112;
        this.modelIDs[40] = 2049320448;
        this.modelIDs[41] = 1529226752;
        this.modelIDs[42] = -2044320256;
        this.modelIDs[43] = 304489984;
        this.modelIDs[44] = 623257088;
        this.modelIDs[45] = -1775884800;
        this.modelIDs[46] = 69674496;
        this.modelIDs[47] = 86451712;
        this.modelIDs[48] = 1244014080;
        this.modelIDs[49] = 1076241920;
        this.modelIDs[50] = 170272256;
        this.modelIDs[51] = -1826216448;
        this.modelIDs[52] = -836426240;
        this.modelIDs[53] = 103228928;
        this.modelIDs[54] = 120006144;
        this.modelIDs[55] = -1792662016;
        this.modelIDs[56] = 0x60262600;
        this.modelIDs[57] = -2061097472;
        this.modelIDs[58] = 1361520128;
        this.modelIDs[59] = -1490672128;
        this.modelIDs[60] = 136783360;
        this.modelIDs[61] = 807806464;
        this.modelIDs[62] = 1562781184;
        this.modelIDs[63] = 2066097664;
        this.modelIDs[64] = -1926879744;
        this.modelIDs[65] = 0x22262600;
        this.modelIDs[66] = -232380928;
        this.modelIDs[67] = 589702656;
        this.modelIDs[68] = 237381120;
        this.modelIDs[69] = 522593792;
        this.modelIDs[70] = 69608960;
        this.modelIDs[71] = -1725553152;
        this.modelIDs[72] = -81451520;
        this.modelIDs[73] = 858138112;
        this.modelIDs[74] = 405153280;
        this.modelIDs[75] = -215603712;
        this.modelIDs[76] = 304555520;
        this.modelIDs[77] = 1462117888;
        this.modelIDs[78] = -1205459456;
        this.modelIDs[79] = 438773248;
        this.modelIDs[80] = 455550464;
        this.modelIDs[81] = 2082874880;
        this.modelIDs[82] = -920312320;
        this.modelIDs[83] = 1596335616;
        this.modelIDs[84] = 1663444480;
        this.modelIDs[85] = -517593600;
        this.modelIDs[86] = 1881548288;
        this.modelIDs[87] = 1395009024;
        this.modelIDs[88] = 338044416;
        this.modelIDs[89] = 841360896;
        this.modelIDs[90] = -1272633856;
        this.modelIDs[91] = 1093019136;
        this.modelIDs[92] = 153560576;
        this.modelIDs[93] = 1998988800;
        this.modelIDs[94] = 0x62262600;
        this.modelIDs[95] = -1876548096;
        this.modelIDs[96] = 1797662208;
        this.modelIDs[97] = 170337792;
        this.modelIDs[98] = 942024192;
        this.modelIDs[99] = 740697600;
        this.modelIDs[100] = 187115008;
        this.modelIDs[101] = 421930496;
        this.modelIDs[102] = -2128206336;
        this.modelIDs[103] = -1708775936;
        this.modelIDs[104] = 1579558400;
        this.modelIDs[105] = -534370816;
        this.modelIDs[106] = -1893325312;
        this.modelIDs[107] = 1864771072;
        this.modelIDs[108] = 421996032;
        this.modelIDs[109] = -198826496;
        this.modelIDs[110] = -551148032;
        this.modelIDs[111] = 824583680;
        this.modelIDs[112] = 2015766016;
        this.modelIDs[113] = -1809439232;
        this.modelIDs[114] = 925246976;
        this.modelIDs[115] = 1898325504;
        this.modelIDs[116] = 203892224;
        this.modelIDs[117] = 757474816;
        this.modelIDs[118] = 1395074560;
        this.modelIDs[119] = 1109796352;
        this.modelIDs[120] = -618256896;
        this.modelIDs[121] = 0x2262600;
        this.modelIDs[122] = 908469760;
        this.modelIDs[123] = -886692352;
        this.modelIDs[124] = 1814439424;
        this.modelIDs[125] = 1009133056;
        this.modelIDs[126] = 1042687488;
        this.modelIDs[127] = 254223872;
        this.modelIDs[128] = -1742330368;
        this.modelIDs[129] = -1088018944;
        this.modelIDs[130] = -1071241728;
        this.modelIDs[131] = 1495672320;
        this.modelIDs[132] = 354821632;
        this.modelIDs[133] = 1546003968;
        this.modelIDs[134] = 1025910272;
        this.modelIDs[135] = -500881920;
        this.modelIDs[136] = 1831216640;
        this.modelIDs[137] = 673588736;
        this.modelIDs[138] = 1428563456;
        this.modelIDs[139] = -1658444288;
        this.modelIDs[140] = 220669440;
        this.modelIDs[141] = 0x6262600;
        this.modelIDs[142] = -903535104;
        this.modelIDs[143] = 1847993856;
        this.modelIDs[144] = 774252032;
        this.modelIDs[145] = -685365760;
        this.modelIDs[146] = 1160128000;
        this.modelIDs[147] = 707143168;
        this.modelIDs[148] = 2099652096;
        this.modelIDs[149] = -601479680;
        this.modelIDs[150] = 656877056;
        this.modelIDs[151] = -1624889856;
        this.modelIDs[152] = 472327680;
        this.modelIDs[153] = 1780884992;
        this.modelIDs[154] = 237446656;
        this.modelIDs[155] = 1327965696;
        this.modelIDs[156] = 1982211584;
        this.modelIDs[157] = 606479872;
        this.modelIDs[158] = 472262144;
        this.modelIDs[159] = 1931879936;
        this.modelIDs[160] = 405218816;
        this.modelIDs[161] = -1121573376;
        this.modelIDs[162] = -853137920;
        this.modelIDs[163] = -668588544;
        this.modelIDs[164] = 891692544;
        this.modelIDs[165] = 86386176;
        this.modelIDs[166] = 0x26262600;
        this.modelIDs[167] = 1730553344;
        this.modelIDs[168] = 52831744;
        this.modelIDs[169] = 119940608;
        this.modelIDs[170] = -836360704;
        this.modelIDs[171] = -467261952;
        this.modelIDs[172] = 505816576;
        this.modelIDs[173] = -1339742720;
        this.modelIDs[174] = 371598848;
        this.modelIDs[175] = -1138350592;
        this.modelIDs[176] = 1059464704;
        this.modelIDs[177] = -937089536;
        this.modelIDs[178] = -2027543040;
        this.modelIDs[179] = 489039360;
    }
}

