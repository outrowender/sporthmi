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
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 212: {
                    this.models[212] = new RangeModel(-1261891584);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(-1748430848);
                    break;
                }
                case 134: {
                    this.models[134] = new MetricsModel(1724452864);
                    break;
                }
                case 139: {
                    this.models[139] = new ChoiceModel(1808338944);
                    break;
                }
                case 191: {
                    this.models[191] = new ChoiceModel(-1614213120);
                    break;
                }
                case 313: {
                    this.models[313] = new LabelModel(432672768);
                    break;
                }
                case 147: {
                    this.models[147] = new ChoiceModel(1942556672);
                    break;
                }
                case 260: {
                    this.models[260] = new ChoiceModel(-456585216);
                    break;
                }
                case 287: {
                    this.models[287] = new ChoiceModel(-3600384);
                    break;
                }
                case 122: {
                    this.models[122] = new ChoiceModel(1523126272);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(-2033643520);
                    break;
                }
                case 272: {
                    this.models[272] = new LabelModel(-255258624);
                    break;
                }
                case 275: {
                    this.models[275] = new LabelModel(-204926976);
                    break;
                }
                case 142: {
                    this.models[142] = new ChoiceModel(1858670592);
                    break;
                }
                case 255: {
                    this.models[255] = new ButtonModel(-540471296);
                    break;
                }
                case 250: {
                    this.models[250] = new ChoiceModel(-624357376);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(1439240192);
                    break;
                }
                case 274: {
                    this.models[274] = new LabelModel(-221704192);
                    break;
                }
                case 182: {
                    this.models[182] = new ChoiceModel(-1765208064);
                    break;
                }
                case 91: {
                    this.models[91] = new ListModel(1003032576);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(415895552);
                    break;
                }
                case 143: {
                    this.models[143] = new ChoiceModel(1875447808);
                    break;
                }
                case 194: {
                    this.models[194] = new ChoiceModel(-1563881472);
                    break;
                }
                case 269: {
                    this.models[269] = new LabelModel(-305590272);
                    break;
                }
                case 266: {
                    this.models[266] = new LabelModel(-355921920);
                    break;
                }
                case 245: {
                    this.models[245] = new ButtonModel(-708243456);
                    break;
                }
                case 136: {
                    this.models[136] = new ChoiceModel(1758007296);
                    break;
                }
                case 247: {
                    this.models[247] = new ButtonModel(-674689024);
                    break;
                }
                case 227: {
                    this.models[227] = new ChoiceModel(-1010233344);
                    break;
                }
                case 119: {
                    this.models[119] = new LabelModel(1472794624);
                    break;
                }
                case 248: {
                    this.models[248] = new ButtonModel(-657911808);
                    break;
                }
                case 196: {
                    this.models[196] = new ChoiceModel(-1530327040);
                    break;
                }
                case 257: {
                    this.models[257] = new ChoiceModel(-506916864);
                    break;
                }
                case 268: {
                    this.models[268] = new LabelModel(-322367488);
                    break;
                }
                case 278: {
                    this.models[278] = new ChoiceModel(-154595328);
                    break;
                }
                case 288: {
                    this.models[288] = new ChoiceModel(13242368);
                    break;
                }
                case 281: {
                    this.models[281] = new ButtonModel(-104263680);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(-691466240);
                    break;
                }
                case 295: {
                    this.models[295] = new ChoiceModel(130682880);
                    break;
                }
                case 259: {
                    this.models[259] = new ChoiceModel(-473362432);
                    break;
                }
                case 271: {
                    this.models[271] = new LabelModel(-272035840);
                    break;
                }
                case 155: {
                    this.models[155] = new ChoiceModel(2076774400);
                    break;
                }
                case 145: {
                    this.models[145] = new ChoiceModel(1909002240);
                    break;
                }
                case 85: {
                    this.models[85] = new ChoiceModel(902369280);
                    break;
                }
                case 103: {
                    this.models[103] = new ChoiceModel(1204359168);
                    break;
                }
                case 184: {
                    this.models[184] = new ListModel(-1731653632);
                    break;
                }
                case 316: {
                    this.models[316] = new LabelModel(483004416);
                    break;
                }
                case 273: {
                    this.models[273] = new LabelModel(-238481408);
                    break;
                }
                case 168: {
                    this.models[168] = new LabelModel(-2000089088);
                    break;
                }
                case 95: {
                    this.models[95] = new ChoiceModel(1070141440);
                    break;
                }
                case 291: {
                    this.models[291] = new ChoiceModel(63574016);
                    break;
                }
                case 253: {
                    this.models[253] = new ChoiceModel(-574025728);
                    break;
                }
                case 284: {
                    this.models[284] = new LabelModel(-53932032);
                    break;
                }
                case 285: {
                    this.models[285] = new ChoiceModel(-37154816);
                    break;
                }
                case 267: {
                    this.models[267] = new LabelModel(-339144704);
                    break;
                }
                case 90: {
                    this.models[90] = new ButtonModel(986255360);
                    break;
                }
                case 261: {
                    this.models[261] = new ChoiceModel(-439808000);
                    break;
                }
                case 258: {
                    this.models[258] = new ChoiceModel(-490139648);
                    break;
                }
                case 294: {
                    this.models[294] = new ChoiceModel(113905664);
                    break;
                }
                case 339: {
                    this.models[339] = new BaseListModel(868880384, null);
                    break;
                }
                case 315: {
                    this.models[315] = new ListModel(466227200);
                    break;
                }
                case 180: {
                    this.models[180] = new ChoiceModel(-1798762496);
                    break;
                }
                case 305: {
                    this.models[305] = new ChoiceModel(298455040);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(1237913600);
                    break;
                }
                case 138: {
                    this.models[138] = new ChoiceModel(1791561728);
                    break;
                }
                case 282: {
                    this.models[282] = new ButtonModel(-87486464);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(1976111104);
                    break;
                }
                case 238: {
                    this.models[238] = new ChoiceModel(-825683968);
                    break;
                }
                case 230: {
                    this.models[230] = new ChoiceModel(-959901696);
                    break;
                }
                case 93: {
                    this.models[93] = new ButtonModel(1036587008);
                    break;
                }
                case 279: {
                    this.models[279] = new LabelModel(-137818112);
                    break;
                }
                case 262: {
                    this.models[262] = new LabelModel(-423030784);
                    break;
                }
                case 298: {
                    this.models[298] = new VirtualButtonModel(181014528);
                    break;
                }
                case 338: {
                    this.models[338] = new ChoiceModel(852103168);
                    break;
                }
                case 264: {
                    this.models[264] = new LabelModel(-389476352);
                    break;
                }
                case 100: {
                    this.models[100] = new ButtonModel(1154027520);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(1086918656);
                    break;
                }
                case 317: {
                    this.models[317] = new ChoiceModel(499781632);
                    break;
                }
                case 185: {
                    this.models[185] = new ButtonModel(-1714876416);
                    break;
                }
                case 186: {
                    this.models[186] = new ButtonModel(-1698099200);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(-842461184);
                    break;
                }
                case 86: {
                    this.models[86] = new ChoiceModel(919146496);
                    break;
                }
                case 222: {
                    this.models[222] = new ListModel(-1094119424);
                    break;
                }
                case 169: {
                    this.models[169] = new LabelModel(-1983311872);
                    break;
                }
                case 135: {
                    this.models[135] = new ChoiceModel(1741230080);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(969478144);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(1170804736);
                    break;
                }
                case 226: {
                    this.models[226] = new ChoiceModel(-1027010560);
                    break;
                }
                case 88: {
                    this.models[88] = new ChoiceModel(952700928);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(1539903488);
                    break;
                }
                case 308: {
                    this.models[308] = new LabelModel(348786688);
                    break;
                }
                case 176: {
                    this.models[176] = new ChoiceModel(-1865871360);
                    break;
                }
                case 337: {
                    this.models[337] = new ChoiceModel(835325952);
                    break;
                }
                case 125: {
                    this.models[125] = new MetricsModel(1573457920);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(1422462976);
                    break;
                }
                case 87: {
                    this.models[87] = new ChoiceModel(935923712);
                    break;
                }
                case 319: {
                    this.models[319] = new ChoiceModel(533336064);
                    break;
                }
                case 92: {
                    this.models[92] = new ChoiceModel(1019809792);
                    break;
                }
                case 296: {
                    this.models[296] = new ChoiceModel(147460096);
                    break;
                }
                case 311: {
                    this.models[311] = new RangeModel(399118336);
                    break;
                }
                case 256: {
                    this.models[256] = new ChoiceModel(-523694080);
                    break;
                }
                case 314: {
                    this.models[314] = new TiledListModel(449449984, null);
                    break;
                }
                case 283: {
                    this.models[283] = new ChoiceModel(-70709248);
                    break;
                }
                case 249: {
                    this.models[249] = new ButtonModel(-641134592);
                    break;
                }
                case 277: {
                    this.models[277] = new ChoiceModel(-171372544);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(1137250304);
                    break;
                }
                case 98: {
                    this.models[98] = new ChoiceModel(1120473088);
                    break;
                }
                case 223: {
                    this.models[223] = new BrowserModel(-1077342208);
                    break;
                }
                case 228: {
                    this.models[228] = new ChoiceModel(-993456128);
                    break;
                }
                case 244: {
                    this.models[244] = new ChoiceModel(-725020672);
                    break;
                }
                case 290: {
                    this.models[290] = new ChoiceModel(46796800);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(-1681321984);
                    break;
                }
                case 151: {
                    this.models[151] = new ChoiceModel(2009665536);
                    break;
                }
                case 132: {
                    this.models[132] = new RangeModel(1690898432);
                    break;
                }
                case 280: {
                    this.models[280] = new ButtonModel(-121040896);
                    break;
                }
                case 211: {
                    this.models[211] = new ChoiceModel(-1278668800);
                    break;
                }
                case 225: {
                    this.models[225] = new ChoiceModel(-1043787776);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(1388908544);
                    break;
                }
                case 293: {
                    this.models[293] = new ChoiceModel(97128448);
                    break;
                }
                case 94: {
                    this.models[94] = new ChoiceModel(1053364224);
                    break;
                }
                case 241: {
                    this.models[241] = new ChoiceModel(-775352320);
                    break;
                }
                case 189: {
                    this.models[189] = new ChoiceModel(-1647767552);
                    break;
                }
                case 224: {
                    this.models[224] = new ChoiceModel(-1060564992);
                    break;
                }
                case 240: {
                    this.models[240] = new ChoiceModel(-792129536);
                    break;
                }
                case 289: {
                    this.models[289] = new ChoiceModel(30019584);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(1221136384);
                    break;
                }
                case 153: {
                    this.models[153] = new ChoiceModel(2043219968);
                    break;
                }
                case 326: {
                    this.models[326] = new ButtonModel(650776576);
                    break;
                }
                case 179: {
                    this.models[179] = new ChoiceModel(-1815539712);
                    break;
                }
                case 297: {
                    this.models[297] = new ChoiceModel(164237312);
                    break;
                }
                case 286: {
                    this.models[286] = new ChoiceModel(-20377600);
                    break;
                }
                case 276: {
                    this.models[276] = new BaseListModel(-188149760, null);
                    break;
                }
                case 214: {
                    this.models[214] = new ButtonModel(-1228337152);
                    break;
                }
                case 102: {
                    this.models[102] = new ChoiceModel(1187581952);
                    break;
                }
                case 97: {
                    this.models[97] = new ChoiceModel(1103695872);
                    break;
                }
                case 239: {
                    this.models[239] = new ChoiceModel(-808906752);
                    break;
                }
                default: {
                    SettingsModelBank.getModelLogChannel().log(10000, "[SettingsModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public SettingsModelBank() {
        super(11, 340, 136);
        this.modelIDs = new int[136];
        this.modelIDs[0] = -1261891584;
        this.modelIDs[1] = -1748430848;
        this.modelIDs[2] = 1724452864;
        this.modelIDs[3] = 1808338944;
        this.modelIDs[4] = -1614213120;
        this.modelIDs[5] = 432672768;
        this.modelIDs[6] = 1942556672;
        this.modelIDs[7] = -456585216;
        this.modelIDs[8] = -3600384;
        this.modelIDs[9] = 1523126272;
        this.modelIDs[10] = -2033643520;
        this.modelIDs[11] = -255258624;
        this.modelIDs[12] = -204926976;
        this.modelIDs[13] = 1858670592;
        this.modelIDs[14] = -540471296;
        this.modelIDs[15] = -624357376;
        this.modelIDs[16] = 1439240192;
        this.modelIDs[17] = -221704192;
        this.modelIDs[18] = -1765208064;
        this.modelIDs[19] = 1003032576;
        this.modelIDs[20] = 415895552;
        this.modelIDs[21] = 1875447808;
        this.modelIDs[22] = -1563881472;
        this.modelIDs[23] = -305590272;
        this.modelIDs[24] = -355921920;
        this.modelIDs[25] = -708243456;
        this.modelIDs[26] = 1758007296;
        this.modelIDs[27] = -674689024;
        this.modelIDs[28] = -1010233344;
        this.modelIDs[29] = 1472794624;
        this.modelIDs[30] = -657911808;
        this.modelIDs[31] = -1530327040;
        this.modelIDs[32] = -506916864;
        this.modelIDs[33] = -322367488;
        this.modelIDs[34] = -154595328;
        this.modelIDs[35] = 13242368;
        this.modelIDs[36] = -104263680;
        this.modelIDs[37] = -691466240;
        this.modelIDs[38] = 130682880;
        this.modelIDs[39] = -473362432;
        this.modelIDs[40] = -272035840;
        this.modelIDs[41] = 2076774400;
        this.modelIDs[42] = 1909002240;
        this.modelIDs[43] = 902369280;
        this.modelIDs[44] = 1204359168;
        this.modelIDs[45] = -1731653632;
        this.modelIDs[46] = 483004416;
        this.modelIDs[47] = -238481408;
        this.modelIDs[48] = -2000089088;
        this.modelIDs[49] = 1070141440;
        this.modelIDs[50] = 63574016;
        this.modelIDs[51] = -574025728;
        this.modelIDs[52] = -53932032;
        this.modelIDs[53] = -37154816;
        this.modelIDs[54] = -339144704;
        this.modelIDs[55] = 986255360;
        this.modelIDs[56] = -439808000;
        this.modelIDs[57] = -490139648;
        this.modelIDs[58] = 113905664;
        this.modelIDs[59] = 868880384;
        this.modelIDs[60] = 466227200;
        this.modelIDs[61] = -1798762496;
        this.modelIDs[62] = 298455040;
        this.modelIDs[63] = 1237913600;
        this.modelIDs[64] = 1791561728;
        this.modelIDs[65] = -87486464;
        this.modelIDs[66] = 1976111104;
        this.modelIDs[67] = -825683968;
        this.modelIDs[68] = -959901696;
        this.modelIDs[69] = 1036587008;
        this.modelIDs[70] = -137818112;
        this.modelIDs[71] = -423030784;
        this.modelIDs[72] = 181014528;
        this.modelIDs[73] = 852103168;
        this.modelIDs[74] = -389476352;
        this.modelIDs[75] = 1154027520;
        this.modelIDs[76] = 1086918656;
        this.modelIDs[77] = 499781632;
        this.modelIDs[78] = -1714876416;
        this.modelIDs[79] = -1698099200;
        this.modelIDs[80] = -842461184;
        this.modelIDs[81] = 919146496;
        this.modelIDs[82] = -1094119424;
        this.modelIDs[83] = -1983311872;
        this.modelIDs[84] = 1741230080;
        this.modelIDs[85] = 969478144;
        this.modelIDs[86] = 1170804736;
        this.modelIDs[87] = -1027010560;
        this.modelIDs[88] = 952700928;
        this.modelIDs[89] = 1539903488;
        this.modelIDs[90] = 348786688;
        this.modelIDs[91] = -1865871360;
        this.modelIDs[92] = 835325952;
        this.modelIDs[93] = 1573457920;
        this.modelIDs[94] = 1422462976;
        this.modelIDs[95] = 935923712;
        this.modelIDs[96] = 533336064;
        this.modelIDs[97] = 1019809792;
        this.modelIDs[98] = 147460096;
        this.modelIDs[99] = 399118336;
        this.modelIDs[100] = -523694080;
        this.modelIDs[101] = 449449984;
        this.modelIDs[102] = -70709248;
        this.modelIDs[103] = -641134592;
        this.modelIDs[104] = -171372544;
        this.modelIDs[105] = 1137250304;
        this.modelIDs[106] = 1120473088;
        this.modelIDs[107] = -1077342208;
        this.modelIDs[108] = -993456128;
        this.modelIDs[109] = -725020672;
        this.modelIDs[110] = 46796800;
        this.modelIDs[111] = -1681321984;
        this.modelIDs[112] = 2009665536;
        this.modelIDs[113] = 1690898432;
        this.modelIDs[114] = -121040896;
        this.modelIDs[115] = -1278668800;
        this.modelIDs[116] = -1043787776;
        this.modelIDs[117] = 1388908544;
        this.modelIDs[118] = 97128448;
        this.modelIDs[119] = 1053364224;
        this.modelIDs[120] = -775352320;
        this.modelIDs[121] = -1647767552;
        this.modelIDs[122] = -1060564992;
        this.modelIDs[123] = -792129536;
        this.modelIDs[124] = 30019584;
        this.modelIDs[125] = 1221136384;
        this.modelIDs[126] = 2043219968;
        this.modelIDs[127] = 650776576;
        this.modelIDs[128] = -1815539712;
        this.modelIDs[129] = 164237312;
        this.modelIDs[130] = -20377600;
        this.modelIDs[131] = -188149760;
        this.modelIDs[132] = -1228337152;
        this.modelIDs[133] = 1187581952;
        this.modelIDs[134] = 1103695872;
        this.modelIDs[135] = -808906752;
    }
}

