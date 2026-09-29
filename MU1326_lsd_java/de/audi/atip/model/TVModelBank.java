/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.DataModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.property.PropertyModel;
import de.audi.atip.model.ICoreTVModelBank;
import de.audi.atip.model.IEvoTVModelBank;

public class TVModelBank
extends AbstractModelBank
implements ICoreTVModelBank,
IEvoTVModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 77: {
                    this.models[77] = new ChoiceModel(-1918097664);
                    break;
                }
                case 109: {
                    this.models[109] = new MetricsModel(-1381226752);
                    break;
                }
                case 111: {
                    this.models[111] = new ButtonModel(-1347672320);
                    break;
                }
                case 32: {
                    this.models[32] = new ChoiceModel(1621894912);
                    break;
                }
                case 152: {
                    this.models[152] = new MetricsModel(-659806464);
                    break;
                }
                case 138: {
                    this.models[138] = new ButtonModel(-894687488);
                    break;
                }
                case 59: {
                    this.models[59] = new ChoiceModel(2074879744);
                    break;
                }
                case 12: {
                    this.models[12] = new ButtonModel(1286350592);
                    break;
                }
                case 81: {
                    this.models[81] = new ChoiceModel(-1850988800);
                    break;
                }
                case 186: {
                    this.models[186] = new ButtonModel(-89381120);
                    break;
                }
                case 51: {
                    this.models[51] = new ButtonModel(1940662016);
                    break;
                }
                case 106: {
                    this.models[106] = new VirtualButtonModel(-1431558400);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(-1716771072);
                    break;
                }
                case 177: {
                    this.models[177] = new VirtualButtonModel(-240376064);
                    break;
                }
                case 105: {
                    this.models[105] = new RangeModel(-1448335616);
                    break;
                }
                case 150: {
                    this.models[150] = new ChoiceModel(-693360896);
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(-609474816);
                    break;
                }
                case 92: {
                    this.models[92] = new MenuModel(-1666439424);
                    break;
                }
                case 48: {
                    this.models[48] = new OptionModel(1890330368);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(-542365952);
                    break;
                }
                case 49: {
                    this.models[49] = new ChoiceModel(1907107584);
                    break;
                }
                case 162: {
                    this.models[162] = new MenuModel(-492034304);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(-1146345728);
                    break;
                }
                case 142: {
                    this.models[142] = new ButtonModel(-827578624);
                    break;
                }
                case 45: {
                    this.models[45] = new BaseListModel(1839998720, (MenuModel)this.getModel(-1666439424));
                    break;
                }
                case 178: {
                    this.models[178] = new ButtonModel(-223598848);
                    break;
                }
                case 86: {
                    this.models[86] = new ButtonModel(-1767102720);
                    break;
                }
                case 57: {
                    this.models[57] = new ChoiceModel(2041325312);
                    break;
                }
                case 47: {
                    this.models[47] = new BaseListModel(1873553152, null);
                    break;
                }
                case 160: {
                    this.models[160] = new ChoiceModel(-525588736);
                    break;
                }
                case 100: {
                    this.models[100] = new ChoiceModel(-1532221696);
                    break;
                }
                case 68: {
                    this.models[68] = new ChoiceModel(-2069092608);
                    break;
                }
                case 95: {
                    this.models[95] = new RangeModel(-1616107776);
                    break;
                }
                case 91: {
                    this.models[91] = new OptionModel(-1683216640);
                    break;
                }
                case 29: {
                    this.models[29] = new ChoiceModel(1571563264);
                    break;
                }
                case 31: {
                    this.models[31] = new BaseListModel(1605117696, null);
                    break;
                }
                case 85: {
                    this.models[85] = new ChoiceModel(-1783879936);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(-1548998912);
                    break;
                }
                case 116: {
                    this.models[116] = new BaseListModel(-1263786240, null);
                    break;
                }
                case 157: {
                    this.models[157] = new DataModel(-575920384);
                    break;
                }
                case 184: {
                    this.models[184] = new ChoiceModel(-122935552);
                    break;
                }
                case 10: {
                    this.models[10] = new ChoiceModel(1252796160);
                    break;
                }
                case 78: {
                    this.models[78] = new LabelModel(-1901320448);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(2108434176);
                    break;
                }
                case 182: {
                    this.models[182] = new ChoiceModel(-156489984);
                    break;
                }
                case 129: {
                    this.models[129] = new ButtonModel(-1045682432);
                    break;
                }
                case 200: {
                    this.models[200] = new ChoiceModel(145565440);
                    break;
                }
                case 84: {
                    this.models[84] = new ChoiceModel(-1800657152);
                    break;
                }
                case 151: {
                    this.models[151] = new MenuModel(-676583680);
                    break;
                }
                case 137: {
                    this.models[137] = new ButtonModel(-911464704);
                    break;
                }
                case 73: {
                    this.models[73] = new LabelModel(-1985206528);
                    break;
                }
                case 87: {
                    this.models[87] = new LabelModel(-1750325504);
                    break;
                }
                case 136: {
                    this.models[136] = new ButtonModel(-928241920);
                    break;
                }
                case 70: {
                    this.models[70] = new ChoiceModel(-2035538176);
                    break;
                }
                case 143: {
                    this.models[143] = new ButtonModel(-810801408);
                    break;
                }
                case 58: {
                    this.models[58] = new ChoiceModel(2058102528);
                    break;
                }
                case 88: {
                    this.models[88] = new LabelModel(-1733548288);
                    break;
                }
                case 17: {
                    this.models[17] = new ChoiceModel(1370236672);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(-777246976);
                    break;
                }
                case 169: {
                    this.models[169] = new ChoiceModel(-374593792);
                    break;
                }
                case 42: {
                    this.models[42] = new LabelModel(1789667072);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(-710138112);
                    break;
                }
                case 223: {
                    this.models[223] = new ChoiceModel(531441408);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(-1314117888);
                    break;
                }
                case 97: {
                    this.models[97] = new ButtonModel(-1582553344);
                    break;
                }
                case 39: {
                    this.models[39] = new OptionModel(1739335424);
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(-1230231808);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(-1280563456);
                    break;
                }
                case 67: {
                    this.models[67] = new ChoiceModel(-2085869824);
                    break;
                }
                case 41: {
                    this.models[41] = new ChoiceModel(1772889856);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(-341039360);
                    break;
                }
                case 53: {
                    this.models[53] = new ChoiceModel(1974216448);
                    break;
                }
                case 60: {
                    this.models[60] = new ChoiceModel(2091656960);
                    break;
                }
                case 14: {
                    this.models[14] = new ChoiceModel(1319905024);
                    break;
                }
                case 141: {
                    this.models[141] = new ButtonModel(-844355840);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(-139712768);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(1823221504);
                    break;
                }
                case 175: {
                    this.models[175] = new MetricsModel(-273930496);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(-1079236864);
                    break;
                }
                case 148: {
                    this.models[148] = new ChoiceModel(-726915328);
                    break;
                }
                case 110: {
                    this.models[110] = new ButtonModel(-1364449536);
                    break;
                }
                case 128: {
                    this.models[128] = new ButtonModel(-1062459648);
                    break;
                }
                case 26: {
                    this.models[26] = new ChoiceModel(1521231616);
                    break;
                }
                case 66: {
                    this.models[66] = new ChoiceModel(-2102647040);
                    break;
                }
                case 34: {
                    this.models[34] = new ChoiceModel(1655449344);
                    break;
                }
                case 176: {
                    this.models[176] = new ChoiceModel(-257153280);
                    break;
                }
                case 179: {
                    this.models[179] = new ButtonModel(-206821632);
                    break;
                }
                case 140: {
                    this.models[140] = new ButtonModel(-861133056);
                    break;
                }
                case 174: {
                    this.models[174] = new ChoiceModel(-290707712);
                    break;
                }
                case 9: {
                    this.models[9] = new ChoiceModel(1236018944);
                    break;
                }
                case 119: {
                    this.models[119] = new ChoiceModel(-1213454592);
                    break;
                }
                case 55: {
                    this.models[55] = new ChoiceModel(2007770880);
                    break;
                }
                case 54: {
                    this.models[54] = new ChoiceModel(1990993664);
                    break;
                }
                case 228: {
                    this.models[228] = new MetricsModel(615327488);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(-508811520);
                    break;
                }
                case 28: {
                    this.models[28] = new ChoiceModel(1554786048);
                    break;
                }
                case 135: {
                    this.models[135] = new ButtonModel(-945019136);
                    break;
                }
                case 132: {
                    this.models[132] = new ButtonModel(-995350784);
                    break;
                }
                case 130: {
                    this.models[130] = new ButtonModel(-1028905216);
                    break;
                }
                case 224: {
                    this.models[224] = new SpellerModel(548218624);
                    break;
                }
                case 13: {
                    this.models[13] = new ChoiceModel(1303127808);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(-72603904);
                    break;
                }
                case 93: {
                    this.models[93] = new ChoiceModel(-1649662208);
                    break;
                }
                case 158: {
                    this.models[158] = new DataModel(-559143168);
                    break;
                }
                case 69: {
                    this.models[69] = new ChoiceModel(-2052315392);
                    break;
                }
                case 76: {
                    this.models[76] = new ChoiceModel(-1934874880);
                    break;
                }
                case 15: {
                    this.models[15] = new SpellerModel(1336682240);
                    break;
                }
                case 213: {
                    this.models[213] = new ButtonModel(363669248);
                    break;
                }
                case 164: {
                    this.models[164] = new ButtonModel(-458479872);
                    break;
                }
                case 35: {
                    this.models[35] = new ChoiceModel(1672226560);
                    break;
                }
                case 22: {
                    this.models[22] = new BaseListModel(1454122752, null);
                    break;
                }
                case 90: {
                    this.models[90] = new ButtonModel(-1699993856);
                    break;
                }
                case 0: {
                    this.models[0] = new BaseListModel(1085024000, (MenuModel)this.getModel(-492034304));
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(-626252032);
                    break;
                }
                case 126: {
                    this.models[126] = new ButtonModel(-1096014080);
                    break;
                }
                case 112: {
                    this.models[112] = new LabelModel(-1330895104);
                    break;
                }
                case 133: {
                    this.models[133] = new ButtonModel(-978573568);
                    break;
                }
                case 121: {
                    this.models[121] = new ChoiceModel(-1179900160);
                    break;
                }
                case 71: {
                    this.models[71] = new ChoiceModel(-2018760960);
                    break;
                }
                case 38: {
                    this.models[38] = new ButtonModel(1722558208);
                    break;
                }
                case 188: {
                    this.models[188] = new VirtualButtonModel(-55826688);
                    break;
                }
                case 37: {
                    this.models[37] = new ChoiceModel(1705780992);
                    break;
                }
                case 196: {
                    this.models[196] = new VirtualButtonModel(78456576);
                    break;
                }
                case 11: {
                    this.models[11] = new ChoiceModel(1269573376);
                    break;
                }
                case 144: {
                    this.models[144] = new ButtonModel(-794024192);
                    break;
                }
                case 120: {
                    this.models[120] = new ChoiceModel(-1196677376);
                    break;
                }
                case 139: {
                    this.models[139] = new ButtonModel(-877910272);
                    break;
                }
                case 43: {
                    this.models[43] = new ButtonModel(1806444288);
                    break;
                }
                case 165: {
                    this.models[165] = new ButtonModel(-441702656);
                    break;
                }
                case 156: {
                    this.models[156] = new ChoiceModel(-592697600);
                    break;
                }
                case 80: {
                    this.models[80] = new ChoiceModel(-1867766016);
                    break;
                }
                case 96: {
                    this.models[96] = new RangeModel(-1599330560);
                    break;
                }
                case 63: {
                    this.models[63] = new ChoiceModel(2141988608);
                    break;
                }
                case 8: {
                    this.models[8] = new ChoiceModel(1219241728);
                    break;
                }
                case 33: {
                    this.models[33] = new BaseListModel(1638672128, null);
                    break;
                }
                case 125: {
                    this.models[125] = new ButtonModel(-1112791296);
                    break;
                }
                case 82: {
                    this.models[82] = new ChoiceModel(-1834211584);
                    break;
                }
                case 172: {
                    this.models[172] = new ButtonModel(-324262144);
                    break;
                }
                case 190: {
                    this.models[190] = new ChoiceModel(-22272256);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(-424925440);
                    break;
                }
                case 173: {
                    this.models[173] = new ButtonModel(-307484928);
                    break;
                }
                case 64: {
                    this.models[64] = new ChoiceModel(-2136201472);
                    break;
                }
                case 180: {
                    this.models[180] = new ResourceLocatorModel(-190044416);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(-1515444480);
                    break;
                }
                case 19: {
                    this.models[19] = new BaseListModel(1403791104, null);
                    break;
                }
                case 79: {
                    this.models[79] = new ChoiceModel(-1884543232);
                    break;
                }
                case 52: {
                    this.models[52] = new ButtonModel(1957439232);
                    break;
                }
                case 62: {
                    this.models[62] = new ChoiceModel(2125211392);
                    break;
                }
                case 124: {
                    this.models[124] = new ButtonModel(-1129568512);
                    break;
                }
                case 65: {
                    this.models[65] = new ChoiceModel(-2119424256);
                    break;
                }
                case 146: {
                    this.models[146] = new ChoiceModel(-760469760);
                    break;
                }
                case 56: {
                    this.models[56] = new ChoiceModel(2024548096);
                    break;
                }
                case 122: {
                    this.models[122] = new ButtonModel(-1163122944);
                    break;
                }
                case 147: {
                    this.models[147] = new ChoiceModel(-743692544);
                    break;
                }
                case 131: {
                    this.models[131] = new ButtonModel(-1012128000);
                    break;
                }
                case 107: {
                    this.models[107] = new ChoiceModel(-1414781184);
                    break;
                }
                case 74: {
                    this.models[74] = new LabelModel(-1968429312);
                    break;
                }
                case 102: {
                    this.models[102] = new ChoiceModel(-1498667264);
                    break;
                }
                case 108: {
                    this.models[108] = new MetricsModel(-1398003968);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(-1465112832);
                    break;
                }
                case 117: {
                    this.models[117] = new PropertyModel(-1247009024);
                    break;
                }
                case 205: {
                    this.models[205] = new ButtonModel(229451520);
                    break;
                }
                case 20: {
                    this.models[20] = new ButtonModel(1420568320);
                    break;
                }
                case 83: {
                    this.models[83] = new ChoiceModel(-1817434368);
                    break;
                }
                case 94: {
                    this.models[94] = new RangeModel(-1632884992);
                    break;
                }
                case 46: {
                    this.models[46] = new BaseListModel(1856775936, null);
                    break;
                }
                case 153: {
                    this.models[153] = new ChoiceModel(-643029248);
                    break;
                }
                case 114: {
                    this.models[114] = new SpellerModel(-1297340672);
                    break;
                }
                case 40: {
                    this.models[40] = new ChoiceModel(1756112640);
                    break;
                }
                case 36: {
                    this.models[36] = new ChoiceModel(1689003776);
                    break;
                }
                case 16: {
                    this.models[16] = new ChoiceModel(1353459456);
                    break;
                }
                case 23: {
                    this.models[23] = new ChoiceModel(1470899968);
                    break;
                }
                case 134: {
                    this.models[134] = new ButtonModel(-961796352);
                    break;
                }
                case 103: {
                    this.models[103] = new ChoiceModel(-1481890048);
                    break;
                }
                default: {
                    TVModelBank.getModelLogChannel().log(10000, "[TVModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TVModelBank() {
        super(26, 229, 174);
        this.modelIDs = new int[174];
        this.modelIDs[0] = -1918097664;
        this.modelIDs[1] = -1381226752;
        this.modelIDs[2] = -1347672320;
        this.modelIDs[3] = 1621894912;
        this.modelIDs[4] = -659806464;
        this.modelIDs[5] = -894687488;
        this.modelIDs[6] = 2074879744;
        this.modelIDs[7] = 1286350592;
        this.modelIDs[8] = -1850988800;
        this.modelIDs[9] = -89381120;
        this.modelIDs[10] = 1940662016;
        this.modelIDs[11] = -1431558400;
        this.modelIDs[12] = -1716771072;
        this.modelIDs[13] = -240376064;
        this.modelIDs[14] = -1448335616;
        this.modelIDs[15] = -693360896;
        this.modelIDs[16] = -609474816;
        this.modelIDs[17] = -1666439424;
        this.modelIDs[18] = 1890330368;
        this.modelIDs[19] = -542365952;
        this.modelIDs[20] = 1907107584;
        this.modelIDs[21] = -492034304;
        this.modelIDs[22] = -1146345728;
        this.modelIDs[23] = -827578624;
        this.modelIDs[24] = 1839998720;
        this.modelIDs[25] = -223598848;
        this.modelIDs[26] = -1767102720;
        this.modelIDs[27] = 2041325312;
        this.modelIDs[28] = 1873553152;
        this.modelIDs[29] = -525588736;
        this.modelIDs[30] = -1532221696;
        this.modelIDs[31] = -2069092608;
        this.modelIDs[32] = -1616107776;
        this.modelIDs[33] = -1683216640;
        this.modelIDs[34] = 1571563264;
        this.modelIDs[35] = 1605117696;
        this.modelIDs[36] = -1783879936;
        this.modelIDs[37] = -1548998912;
        this.modelIDs[38] = -1263786240;
        this.modelIDs[39] = -575920384;
        this.modelIDs[40] = -122935552;
        this.modelIDs[41] = 1252796160;
        this.modelIDs[42] = -1901320448;
        this.modelIDs[43] = 2108434176;
        this.modelIDs[44] = -156489984;
        this.modelIDs[45] = -1045682432;
        this.modelIDs[46] = 145565440;
        this.modelIDs[47] = -1800657152;
        this.modelIDs[48] = -676583680;
        this.modelIDs[49] = -911464704;
        this.modelIDs[50] = -1985206528;
        this.modelIDs[51] = -1750325504;
        this.modelIDs[52] = -928241920;
        this.modelIDs[53] = -2035538176;
        this.modelIDs[54] = -810801408;
        this.modelIDs[55] = 2058102528;
        this.modelIDs[56] = -1733548288;
        this.modelIDs[57] = 1370236672;
        this.modelIDs[58] = -777246976;
        this.modelIDs[59] = -374593792;
        this.modelIDs[60] = 1789667072;
        this.modelIDs[61] = -710138112;
        this.modelIDs[62] = 531441408;
        this.modelIDs[63] = -1314117888;
        this.modelIDs[64] = -1582553344;
        this.modelIDs[65] = 1739335424;
        this.modelIDs[66] = -1230231808;
        this.modelIDs[67] = -1280563456;
        this.modelIDs[68] = -2085869824;
        this.modelIDs[69] = 1772889856;
        this.modelIDs[70] = -341039360;
        this.modelIDs[71] = 1974216448;
        this.modelIDs[72] = 2091656960;
        this.modelIDs[73] = 1319905024;
        this.modelIDs[74] = -844355840;
        this.modelIDs[75] = -139712768;
        this.modelIDs[76] = 1823221504;
        this.modelIDs[77] = -273930496;
        this.modelIDs[78] = -1079236864;
        this.modelIDs[79] = -726915328;
        this.modelIDs[80] = -1364449536;
        this.modelIDs[81] = -1062459648;
        this.modelIDs[82] = 1521231616;
        this.modelIDs[83] = -2102647040;
        this.modelIDs[84] = 1655449344;
        this.modelIDs[85] = -257153280;
        this.modelIDs[86] = -206821632;
        this.modelIDs[87] = -861133056;
        this.modelIDs[88] = -290707712;
        this.modelIDs[89] = 1236018944;
        this.modelIDs[90] = -1213454592;
        this.modelIDs[91] = 2007770880;
        this.modelIDs[92] = 1990993664;
        this.modelIDs[93] = 615327488;
        this.modelIDs[94] = -508811520;
        this.modelIDs[95] = 1554786048;
        this.modelIDs[96] = -945019136;
        this.modelIDs[97] = -995350784;
        this.modelIDs[98] = -1028905216;
        this.modelIDs[99] = 548218624;
        this.modelIDs[100] = 1303127808;
        this.modelIDs[101] = -72603904;
        this.modelIDs[102] = -1649662208;
        this.modelIDs[103] = -559143168;
        this.modelIDs[104] = -2052315392;
        this.modelIDs[105] = -1934874880;
        this.modelIDs[106] = 1336682240;
        this.modelIDs[107] = 363669248;
        this.modelIDs[108] = -458479872;
        this.modelIDs[109] = 1672226560;
        this.modelIDs[110] = 1454122752;
        this.modelIDs[111] = -1699993856;
        this.modelIDs[112] = 1085024000;
        this.modelIDs[113] = -626252032;
        this.modelIDs[114] = -1096014080;
        this.modelIDs[115] = -1330895104;
        this.modelIDs[116] = -978573568;
        this.modelIDs[117] = -1179900160;
        this.modelIDs[118] = -2018760960;
        this.modelIDs[119] = 1722558208;
        this.modelIDs[120] = -55826688;
        this.modelIDs[121] = 1705780992;
        this.modelIDs[122] = 78456576;
        this.modelIDs[123] = 1269573376;
        this.modelIDs[124] = -794024192;
        this.modelIDs[125] = -1196677376;
        this.modelIDs[126] = -877910272;
        this.modelIDs[127] = 1806444288;
        this.modelIDs[128] = -441702656;
        this.modelIDs[129] = -592697600;
        this.modelIDs[130] = -1867766016;
        this.modelIDs[131] = -1599330560;
        this.modelIDs[132] = 2141988608;
        this.modelIDs[133] = 1219241728;
        this.modelIDs[134] = 1638672128;
        this.modelIDs[135] = -1112791296;
        this.modelIDs[136] = -1834211584;
        this.modelIDs[137] = -324262144;
        this.modelIDs[138] = -22272256;
        this.modelIDs[139] = -424925440;
        this.modelIDs[140] = -307484928;
        this.modelIDs[141] = -2136201472;
        this.modelIDs[142] = -190044416;
        this.modelIDs[143] = -1515444480;
        this.modelIDs[144] = 1403791104;
        this.modelIDs[145] = -1884543232;
        this.modelIDs[146] = 1957439232;
        this.modelIDs[147] = 2125211392;
        this.modelIDs[148] = -1129568512;
        this.modelIDs[149] = -2119424256;
        this.modelIDs[150] = -760469760;
        this.modelIDs[151] = 2024548096;
        this.modelIDs[152] = -1163122944;
        this.modelIDs[153] = -743692544;
        this.modelIDs[154] = -1012128000;
        this.modelIDs[155] = -1414781184;
        this.modelIDs[156] = -1968429312;
        this.modelIDs[157] = -1498667264;
        this.modelIDs[158] = -1398003968;
        this.modelIDs[159] = -1465112832;
        this.modelIDs[160] = -1247009024;
        this.modelIDs[161] = 229451520;
        this.modelIDs[162] = 1420568320;
        this.modelIDs[163] = -1817434368;
        this.modelIDs[164] = -1632884992;
        this.modelIDs[165] = 1856775936;
        this.modelIDs[166] = -643029248;
        this.modelIDs[167] = -1297340672;
        this.modelIDs[168] = 1756112640;
        this.modelIDs[169] = 1689003776;
        this.modelIDs[170] = 1353459456;
        this.modelIDs[171] = 1470899968;
        this.modelIDs[172] = -961796352;
        this.modelIDs[173] = -1481890048;
    }
}

