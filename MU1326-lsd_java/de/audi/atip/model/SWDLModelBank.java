/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.IPSpellerModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.model.ICoreSWDLModelBank;
import de.audi.atip.model.IEvoSWDLModelBank;

public class SWDLModelBank
extends AbstractModelBank
implements ICoreSWDLModelBank,
IEvoSWDLModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 366: {
                    this.models[366] = new ButtonModel(250747136);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(351344896);
                    break;
                }
                case 292: {
                    this.models[292] = new ButtonModel(-990832384);
                    break;
                }
                case 134: {
                    this.models[134] = new LabelModel(653334784);
                    break;
                }
                case 62: {
                    this.models[62] = new ListModel(-554690304);
                    break;
                }
                case 255: {
                    this.models[255] = new ButtonModel(-1611589376);
                    break;
                }
                case 105: {
                    this.models[105] = new LabelModel(166795520);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(535894272);
                    break;
                }
                case 226: {
                    this.models[226] = new LabelModel(-2098128640);
                    break;
                }
                case 140: {
                    this.models[140] = new BufferedListModel(753998080);
                    break;
                }
                case 345: {
                    this.models[345] = new ButtonModel(-101639936);
                    break;
                }
                case 133: {
                    this.models[133] = new BufferedListModel(636557568);
                    break;
                }
                case 305: {
                    this.models[305] = new ButtonModel(-772728576);
                    break;
                }
                case 172: {
                    this.models[172] = new ButtonModel(1290868992);
                    break;
                }
                case 131: {
                    this.models[131] = new ButtonModel(603003136);
                    break;
                }
                case 112: {
                    this.models[112] = new ChoiceModel(284236032);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(317790464);
                    break;
                }
                case 95: {
                    this.models[95] = new LabelModel(-1042176);
                    break;
                }
                case 279: {
                    this.models[279] = new ChoiceModel(-1208936192);
                    break;
                }
                case 330: {
                    this.models[330] = new ChoiceModel(-353298176);
                    break;
                }
                case 245: {
                    this.models[245] = new ListModel(-1779361536);
                    break;
                }
                case 241: {
                    this.models[241] = new ButtonModel(-1846470400);
                    break;
                }
                case 138: {
                    this.models[138] = new BufferedListModel(720443648);
                    break;
                }
                case 87: {
                    this.models[87] = new LabelModel(-135259904);
                    break;
                }
                case 239: {
                    this.models[239] = new LabelModel(-1880024832);
                    break;
                }
                case 290: {
                    this.models[290] = new ButtonModel(-1024386816);
                    break;
                }
                case 334: {
                    this.models[334] = new ResourceLocatorModel(-286189312);
                    break;
                }
                case 60: {
                    this.models[60] = new ChoiceModel(-588244736);
                    break;
                }
                case 252: {
                    this.models[252] = new LabelModel(-1661921024);
                    break;
                }
                case 237: {
                    this.models[237] = new ButtonModel(-1913579264);
                    break;
                }
                case 243: {
                    this.models[243] = new RangeModel(-1812915968);
                    break;
                }
                case 173: {
                    this.models[173] = new LabelModel(1307646208);
                    break;
                }
                case 94: {
                    this.models[94] = new LabelModel(-17819392);
                    break;
                }
                case 126: {
                    this.models[126] = new LabelModel(519117056);
                    break;
                }
                case 270: {
                    this.models[270] = new ChoiceModel(-1359931136);
                    break;
                }
                case 321: {
                    this.models[321] = new SpellerModel(-504293120);
                    break;
                }
                case 386: {
                    this.models[386] = new ChoiceModel(586291456);
                    break;
                }
                case 256: {
                    this.models[256] = new ChoiceModel(-1594812160);
                    break;
                }
                case 249: {
                    this.models[249] = new ButtonModel(-1712252672);
                    break;
                }
                case 367: {
                    this.models[367] = new ChoiceModel(267524352);
                    break;
                }
                case 100: {
                    this.models[100] = new LabelModel(82909440);
                    break;
                }
                case 301: {
                    this.models[301] = new BaseListModel(-839837440, (MenuModel)this.getModel(-252634880));
                    break;
                }
                case 387: {
                    this.models[387] = new ChoiceModel(603068672);
                    break;
                }
                case 251: {
                    this.models[251] = new LabelModel(-1678698240);
                    break;
                }
                case 168: {
                    this.models[168] = new LabelModel(1223760128);
                    break;
                }
                case 111: {
                    this.models[111] = new ChoiceModel(267458816);
                    break;
                }
                case 282: {
                    this.models[282] = new ButtonModel(-1158604544);
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(1005656320);
                    break;
                }
                case 388: {
                    this.models[388] = new BaseListModel(619845888, null);
                    break;
                }
                case 300: {
                    this.models[300] = new ButtonModel(-856614656);
                    break;
                }
                case 283: {
                    this.models[283] = new ButtonModel(-1141827328);
                    break;
                }
                case 136: {
                    this.models[136] = new BufferedListModel(686889216);
                    break;
                }
                case 132: {
                    this.models[132] = new BufferedListModel(619780352);
                    break;
                }
                case 278: {
                    this.models[278] = new ChoiceModel(-1225713408);
                    break;
                }
                case 80: {
                    this.models[80] = new LabelModel(-252700416);
                    break;
                }
                case 307: {
                    this.models[307] = new ButtonModel(-739174144);
                    break;
                }
                case 338: {
                    this.models[338] = new ButtonModel(-219080448);
                    break;
                }
                case 247: {
                    this.models[247] = new ButtonModel(-1745807104);
                    break;
                }
                case 222: {
                    this.models[222] = new ButtonModel(2129729792);
                    break;
                }
                case 364: {
                    this.models[364] = new ChoiceModel(217192704);
                    break;
                }
                case 236: {
                    this.models[236] = new ButtonModel(-1930356480);
                    break;
                }
                case 57: {
                    this.models[57] = new ButtonModel(-638576384);
                    break;
                }
                case 272: {
                    this.models[272] = new ButtonModel(-1326376704);
                    break;
                }
                case 101: {
                    this.models[101] = new LabelModel(99686656);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(-655288064);
                    break;
                }
                case 135: {
                    this.models[135] = new ButtonModel(670112000);
                    break;
                }
                case 129: {
                    this.models[129] = new ButtonModel(569448704);
                    break;
                }
                case 303: {
                    this.models[303] = new LabelModel(-806283008);
                    break;
                }
                case 370: {
                    this.models[370] = new ButtonModel(317856000);
                    break;
                }
                case 233: {
                    this.models[233] = new ButtonModel(-1980688128);
                    break;
                }
                case 228: {
                    this.models[228] = new ChoiceModel(-2064574208);
                    break;
                }
                case 51: {
                    this.models[51] = new ButtonModel(-739239680);
                    break;
                }
                case 368: {
                    this.models[368] = new ChoiceModel(284301568);
                    break;
                }
                case 308: {
                    this.models[308] = new ChoiceModel(-722396928);
                    break;
                }
                case 148: {
                    this.models[148] = new ChoiceModel(888215808);
                    break;
                }
                case 281: {
                    this.models[281] = new BaseListModel(-1175381760, null);
                    break;
                }
                case 75: {
                    this.models[75] = new LabelModel(-336586496);
                    break;
                }
                case 298: {
                    this.models[298] = new ChoiceModel(-890169088);
                    break;
                }
                case 77: {
                    this.models[77] = new LabelModel(-303032064);
                    break;
                }
                case 324: {
                    this.models[324] = new ButtonModel(-453961472);
                    break;
                }
                case 347: {
                    this.models[347] = new MetricsModel(-68085504);
                    break;
                }
                case 296: {
                    this.models[296] = new LabelModel(-923723520);
                    break;
                }
                case 339: {
                    this.models[339] = new ButtonModel(-202303232);
                    break;
                }
                case 259: {
                    this.models[259] = new ChoiceModel(-1544480512);
                    break;
                }
                case 43: {
                    this.models[43] = new ButtonModel(-873457408);
                    break;
                }
                case 280: {
                    this.models[280] = new LabelModel(-1192158976);
                    break;
                }
                case 258: {
                    this.models[258] = new ListModel(-1561257728);
                    break;
                }
                case 240: {
                    this.models[240] = new ButtonModel(-1863247616);
                    break;
                }
                case 304: {
                    this.models[304] = new ButtonModel(-789505792);
                    break;
                }
                case 103: {
                    this.models[103] = new LabelModel(133241088);
                    break;
                }
                case 122: {
                    this.models[122] = new LabelModel(452008192);
                    break;
                }
                case 261: {
                    this.models[261] = new ChoiceModel(-1510926080);
                    break;
                }
                case 335: {
                    this.models[335] = new MenuModel(-269412096);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(334567680);
                    break;
                }
                case 329: {
                    this.models[329] = new LabelModel(-370075392);
                    break;
                }
                case 355: {
                    this.models[355] = new LabelModel(66197760);
                    break;
                }
                case 250: {
                    this.models[250] = new LabelModel(-1695475456);
                    break;
                }
                case 156: {
                    this.models[156] = new ButtonModel(1022433536);
                    break;
                }
                case 153: {
                    this.models[153] = new ButtonModel(972101888);
                    break;
                }
                case 52: {
                    this.models[52] = new LabelModel(-722462464);
                    break;
                }
                case 110: {
                    this.models[110] = new ChoiceModel(250681600);
                    break;
                }
                case 320: {
                    this.models[320] = new ChoiceModel(-521070336);
                    break;
                }
                case 91: {
                    this.models[91] = new LabelModel(-68151040);
                    break;
                }
                case 230: {
                    this.models[230] = new LabelModel(-2031019776);
                    break;
                }
                case 99: {
                    this.models[99] = new LabelModel(66132224);
                    break;
                }
                case 381: {
                    this.models[381] = new MetricsModel(502405376);
                    break;
                }
                case 369: {
                    this.models[369] = new LabelModel(301078784);
                    break;
                }
                case 83: {
                    this.models[83] = new ButtonModel(-202368768);
                    break;
                }
                case 81: {
                    this.models[81] = new IPSpellerModel(-235923200);
                    break;
                }
                case 225: {
                    this.models[225] = new ButtonModel(-2114905856);
                    break;
                }
                case 318: {
                    this.models[318] = new ButtonModel(-554624768);
                    break;
                }
                case 130: {
                    this.models[130] = new ButtonModel(586225920);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(1274091776);
                    break;
                }
                case 54: {
                    this.models[54] = new LabelModel(-688908032);
                    break;
                }
                case 221: {
                    this.models[221] = new ButtonModel(2112952576);
                    break;
                }
                case 260: {
                    this.models[260] = new ListModel(-1527703296);
                    break;
                }
                case 390: {
                    this.models[390] = new VirtualButtonModel(653400320);
                    break;
                }
                case 344: {
                    this.models[344] = new ButtonModel(-118417152);
                    break;
                }
                case 391: {
                    this.models[391] = new VirtualButtonModel(670177536);
                    break;
                }
                case 365: {
                    this.models[365] = new LabelModel(233969920);
                    break;
                }
                case 253: {
                    this.models[253] = new LabelModel(-1645143808);
                    break;
                }
                case 294: {
                    this.models[294] = new LabelModel(-957277952);
                    break;
                }
                case 374: {
                    this.models[374] = new ChoiceModel(384964864);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(183572736);
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(988879104);
                    break;
                }
                case 311: {
                    this.models[311] = new ChoiceModel(-672065280);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(-571467520);
                    break;
                }
                case 109: {
                    this.models[109] = new ChoiceModel(233904384);
                    break;
                }
                case 98: {
                    this.models[98] = new ListModel(49355008);
                    break;
                }
                case 232: {
                    this.models[232] = new ButtonModel(-1997465344);
                    break;
                }
                case 229: {
                    this.models[229] = new ChoiceModel(-2047796992);
                    break;
                }
                case 263: {
                    this.models[263] = new ButtonModel(-1477371648);
                    break;
                }
                case 167: {
                    this.models[167] = new BufferedListModel(1206982912);
                    break;
                }
                case 356: {
                    this.models[356] = new LabelModel(82974976);
                    break;
                }
                case 360: {
                    this.models[360] = new LabelModel(150083840);
                    break;
                }
                case 276: {
                    this.models[276] = new ButtonModel(-1259267840);
                    break;
                }
                case 277: {
                    this.models[277] = new ButtonModel(-1242490624);
                    break;
                }
                case 306: {
                    this.models[306] = new BaseListModel(-755951360, null);
                    break;
                }
                case 120: {
                    this.models[120] = new LabelModel(418453760);
                    break;
                }
                case 118: {
                    this.models[118] = new LabelModel(384899328);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(15800576);
                    break;
                }
                case 124: {
                    this.models[124] = new LabelModel(485562624);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(-101705472);
                    break;
                }
                case 45: {
                    this.models[45] = new ButtonModel(-839902976);
                    break;
                }
                case 284: {
                    this.models[284] = new ChoiceModel(-1125050112);
                    break;
                }
                case 378: {
                    this.models[378] = new ChoiceModel(452073728);
                    break;
                }
                case 271: {
                    this.models[271] = new LabelModel(-1343153920);
                    break;
                }
                case 373: {
                    this.models[373] = new ButtonModel(368187648);
                    break;
                }
                case 302: {
                    this.models[302] = new ButtonModel(-823060224);
                    break;
                }
                case 144: {
                    this.models[144] = new LabelModel(821106944);
                    break;
                }
                case 142: {
                    this.models[142] = new ButtonModel(787552512);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(368122112);
                    break;
                }
                case 325: {
                    this.models[325] = new ButtonModel(-437184256);
                    break;
                }
                case 244: {
                    this.models[244] = new LabelModel(-1796138752);
                    break;
                }
                case 384: {
                    this.models[384] = new ChoiceModel(552737024);
                    break;
                }
                case 313: {
                    this.models[313] = new ChoiceModel(-638510848);
                    break;
                }
                case 158: {
                    this.models[158] = new ButtonModel(1055987968);
                    break;
                }
                case 392: {
                    this.models[392] = new LabelModel(686954752);
                    break;
                }
                case 291: {
                    this.models[291] = new ChoiceModel(-1007609600);
                    break;
                }
                case 160: {
                    this.models[160] = new LabelModel(1089542400);
                    break;
                }
                case 275: {
                    this.models[275] = new MetricsModel(-1276045056);
                    break;
                }
                case 137: {
                    this.models[137] = new ChoiceModel(703666432);
                    break;
                }
                case 254: {
                    this.models[254] = new ButtonModel(-1628366592);
                    break;
                }
                case 67: {
                    this.models[67] = new ButtonModel(-470804224);
                    break;
                }
                case 84: {
                    this.models[84] = new ButtonModel(-185591552);
                    break;
                }
                case 235: {
                    this.models[235] = new LabelModel(-1947133696);
                    break;
                }
                case 128: {
                    this.models[128] = new LabelModel(552671488);
                    break;
                }
                case 376: {
                    this.models[376] = new MenuModel(418519296);
                    break;
                }
                case 104: {
                    this.models[104] = new LabelModel(150018304);
                    break;
                }
                case 107: {
                    this.models[107] = new SpellerModel(200349952);
                    break;
                }
                case 59: {
                    this.models[59] = new ChoiceModel(-605021952);
                    break;
                }
                case 82: {
                    this.models[82] = new LabelModel(-219145984);
                    break;
                }
                case 287: {
                    this.models[287] = new ButtonModel(-1074718464);
                    break;
                }
                case 223: {
                    this.models[223] = new OptionModel(2146507008);
                    break;
                }
                case 322: {
                    this.models[322] = new BaseListModel(-487515904, null);
                    break;
                }
                case 327: {
                    this.models[327] = new ChoiceModel(-403629824);
                    break;
                }
                case 350: {
                    this.models[350] = new ButtonModel(-17753856);
                    break;
                }
                case 349: {
                    this.models[349] = new ButtonModel(-34531072);
                    break;
                }
                case 55: {
                    this.models[55] = new LabelModel(-672130816);
                    break;
                }
                case 143: {
                    this.models[143] = new ButtonModel(804329728);
                    break;
                }
                case 224: {
                    this.models[224] = new ButtonModel(-2131683072);
                    break;
                }
                case 319: {
                    this.models[319] = new SpellerModel(-537847552);
                    break;
                }
                case 346: {
                    this.models[346] = new BaseListModel(-84862720, (MenuModel)this.getModel(-252634880));
                    break;
                }
                case 372: {
                    this.models[372] = new ButtonModel(351410432);
                    break;
                }
                case 108: {
                    this.models[108] = new ChoiceModel(217127168);
                    break;
                }
                case 293: {
                    this.models[293] = new ChoiceModel(-974055168);
                    break;
                }
                case 85: {
                    this.models[85] = new ButtonModel(-168814336);
                    break;
                }
                case 358: {
                    this.models[358] = new ButtonModel(116529408);
                    break;
                }
                case 141: {
                    this.models[141] = new ChoiceModel(770775296);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(301013248);
                    break;
                }
                case 88: {
                    this.models[88] = new ListModel(-118482688);
                    break;
                }
                case 336: {
                    this.models[336] = new MenuModel(-252634880);
                    break;
                }
                case 139: {
                    this.models[139] = new LabelModel(737220864);
                    break;
                }
                case 169: {
                    this.models[169] = new BufferedListModel(1240537344);
                    break;
                }
                case 297: {
                    this.models[297] = new ButtonModel(-906946304);
                    break;
                }
                case 76: {
                    this.models[76] = new ChoiceModel(-319809280);
                    break;
                }
                case 269: {
                    this.models[269] = new ChoiceModel(-1376708352);
                    break;
                }
                case 341: {
                    this.models[341] = new ButtonModel(-168748800);
                    break;
                }
                case 295: {
                    this.models[295] = new ButtonModel(-940500736);
                    break;
                }
                case 383: {
                    this.models[383] = new ButtonModel(535959808);
                    break;
                }
                case 102: {
                    this.models[102] = new LabelModel(116463872);
                    break;
                }
                case 42: {
                    this.models[42] = new ChoiceModel(-890234624);
                    break;
                }
                case 257: {
                    this.models[257] = new ChoiceModel(-1578034944);
                    break;
                }
                case 314: {
                    this.models[314] = new ButtonModel(-621733632);
                    break;
                }
                case 262: {
                    this.models[262] = new ButtonModel(-1494148864);
                    break;
                }
                case 363: {
                    this.models[363] = new ButtonModel(200415488);
                    break;
                }
                case 47: {
                    this.models[47] = new ButtonModel(-806348544);
                    break;
                }
                case 234: {
                    this.models[234] = new LabelModel(-1963910912);
                    break;
                }
                case 310: {
                    this.models[310] = new ChoiceModel(-688842496);
                    break;
                }
                case 90: {
                    this.models[90] = new ButtonModel(-84928256);
                    break;
                }
                case 44: {
                    this.models[44] = new ButtonModel(-856680192);
                    break;
                }
                case 159: {
                    this.models[159] = new ButtonModel(1072765184);
                    break;
                }
                case 268: {
                    this.models[268] = new LabelModel(-1393485568);
                    break;
                }
                case 170: {
                    this.models[170] = new LabelModel(1257314560);
                    break;
                }
                case 380: {
                    this.models[380] = new ChoiceModel(485628160);
                    break;
                }
                case 285: {
                    this.models[285] = new ButtonModel(-1108272896);
                    break;
                }
                case 46: {
                    this.models[46] = new ChoiceModel(-823125760);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(-1762584320);
                    break;
                }
                case 362: {
                    this.models[362] = new ButtonModel(183638272);
                    break;
                }
                case 121: {
                    this.models[121] = new BufferedListModel(435230976);
                    break;
                }
                case 238: {
                    this.models[238] = new ChoiceModel(-1896802048);
                    break;
                }
                case 385: {
                    this.models[385] = new LabelModel(569514240);
                    break;
                }
                case 359: {
                    this.models[359] = new LabelModel(133306624);
                    break;
                }
                case 340: {
                    this.models[340] = new ButtonModel(-185526016);
                    break;
                }
                case 299: {
                    this.models[299] = new LabelModel(-873391872);
                    break;
                }
                case 352: {
                    this.models[352] = new MenuModel(15866112);
                    break;
                }
                case 288: {
                    this.models[288] = new ButtonModel(-1057941248);
                    break;
                }
                case 119: {
                    this.models[119] = new LabelModel(401676544);
                    break;
                }
                case 361: {
                    this.models[361] = new ButtonModel(166861056);
                    break;
                }
                case 273: {
                    this.models[273] = new BaseListModel(-1309599488, null);
                    break;
                }
                case 157: {
                    this.models[157] = new ButtonModel(1039210752);
                    break;
                }
                case 267: {
                    this.models[267] = new ChoiceModel(-1410262784);
                    break;
                }
                case 337: {
                    this.models[337] = new MetricsModel(-235857664);
                    break;
                }
                case 264: {
                    this.models[264] = new LabelModel(-1460594432);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(1106319616);
                    break;
                }
                case 326: {
                    this.models[326] = new ChoiceModel(-420407040);
                    break;
                }
                case 382: {
                    this.models[382] = new ChoiceModel(519182592);
                    break;
                }
                case 242: {
                    this.models[242] = new BaseListModel(-1829693184, null);
                    break;
                }
                case 309: {
                    this.models[309] = new ChoiceModel(-705619712);
                    break;
                }
                case 371: {
                    this.models[371] = new ChoiceModel(334633216);
                    break;
                }
                case 58: {
                    this.models[58] = new ChoiceModel(-621799168);
                    break;
                }
                case 162: {
                    this.models[162] = new ButtonModel(1123096832);
                    break;
                }
                case 331: {
                    this.models[331] = new ChoiceModel(-336520960);
                    break;
                }
                case 97: {
                    this.models[97] = new ButtonModel(32577792);
                    break;
                }
                case 231: {
                    this.models[231] = new ButtonModel(-2014242560);
                    break;
                }
                case 145: {
                    this.models[145] = new BufferedListModel(837884160);
                    break;
                }
                case 125: {
                    this.models[125] = new LabelModel(502339840);
                    break;
                }
                case 266: {
                    this.models[266] = new LabelModel(-1427040000);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(468785408);
                    break;
                }
                case 265: {
                    this.models[265] = new LabelModel(-1443817216);
                    break;
                }
                case 86: {
                    this.models[86] = new LabelModel(-152037120);
                    break;
                }
                case 357: {
                    this.models[357] = new LabelModel(99752192);
                    break;
                }
                case 174: {
                    this.models[174] = new LabelModel(1324423424);
                    break;
                }
                case 56: {
                    this.models[56] = new ChoiceModel(-655353600);
                    break;
                }
                case 227: {
                    this.models[227] = new ListModel(-2081351424);
                    break;
                }
                case 274: {
                    this.models[274] = new ButtonModel(-1292822272);
                    break;
                }
                case 74: {
                    this.models[74] = new BufferedListModel(-353363712);
                    break;
                }
                default: {
                    SWDLModelBank.getModelLogChannel().log(10000, "[SWDLModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public SWDLModelBank() {
        super(17, 393, 257);
        this.modelIDs = new int[257];
        this.modelIDs[0] = 250747136;
        this.modelIDs[1] = 351344896;
        this.modelIDs[2] = -990832384;
        this.modelIDs[3] = 653334784;
        this.modelIDs[4] = -554690304;
        this.modelIDs[5] = -1611589376;
        this.modelIDs[6] = 166795520;
        this.modelIDs[7] = 535894272;
        this.modelIDs[8] = -2098128640;
        this.modelIDs[9] = 753998080;
        this.modelIDs[10] = -101639936;
        this.modelIDs[11] = 636557568;
        this.modelIDs[12] = -772728576;
        this.modelIDs[13] = 1290868992;
        this.modelIDs[14] = 603003136;
        this.modelIDs[15] = 284236032;
        this.modelIDs[16] = 317790464;
        this.modelIDs[17] = -1042176;
        this.modelIDs[18] = -1208936192;
        this.modelIDs[19] = -353298176;
        this.modelIDs[20] = -1779361536;
        this.modelIDs[21] = -1846470400;
        this.modelIDs[22] = 720443648;
        this.modelIDs[23] = -135259904;
        this.modelIDs[24] = -1880024832;
        this.modelIDs[25] = -1024386816;
        this.modelIDs[26] = -286189312;
        this.modelIDs[27] = -588244736;
        this.modelIDs[28] = -1661921024;
        this.modelIDs[29] = -1913579264;
        this.modelIDs[30] = -1812915968;
        this.modelIDs[31] = 1307646208;
        this.modelIDs[32] = -17819392;
        this.modelIDs[33] = 519117056;
        this.modelIDs[34] = -1359931136;
        this.modelIDs[35] = -504293120;
        this.modelIDs[36] = 586291456;
        this.modelIDs[37] = -1594812160;
        this.modelIDs[38] = -1712252672;
        this.modelIDs[39] = 267524352;
        this.modelIDs[40] = 82909440;
        this.modelIDs[41] = -839837440;
        this.modelIDs[42] = 603068672;
        this.modelIDs[43] = -1678698240;
        this.modelIDs[44] = 1223760128;
        this.modelIDs[45] = 267458816;
        this.modelIDs[46] = -1158604544;
        this.modelIDs[47] = 1005656320;
        this.modelIDs[48] = 619845888;
        this.modelIDs[49] = -856614656;
        this.modelIDs[50] = -1141827328;
        this.modelIDs[51] = 686889216;
        this.modelIDs[52] = 619780352;
        this.modelIDs[53] = -1225713408;
        this.modelIDs[54] = -252700416;
        this.modelIDs[55] = -739174144;
        this.modelIDs[56] = -219080448;
        this.modelIDs[57] = -1745807104;
        this.modelIDs[58] = 2129729792;
        this.modelIDs[59] = 217192704;
        this.modelIDs[60] = -1930356480;
        this.modelIDs[61] = -638576384;
        this.modelIDs[62] = -1326376704;
        this.modelIDs[63] = 99686656;
        this.modelIDs[64] = -655288064;
        this.modelIDs[65] = 670112000;
        this.modelIDs[66] = 569448704;
        this.modelIDs[67] = -806283008;
        this.modelIDs[68] = 317856000;
        this.modelIDs[69] = -1980688128;
        this.modelIDs[70] = -2064574208;
        this.modelIDs[71] = -739239680;
        this.modelIDs[72] = 284301568;
        this.modelIDs[73] = -722396928;
        this.modelIDs[74] = 888215808;
        this.modelIDs[75] = -1175381760;
        this.modelIDs[76] = -336586496;
        this.modelIDs[77] = -890169088;
        this.modelIDs[78] = -303032064;
        this.modelIDs[79] = -453961472;
        this.modelIDs[80] = -68085504;
        this.modelIDs[81] = -923723520;
        this.modelIDs[82] = -202303232;
        this.modelIDs[83] = -1544480512;
        this.modelIDs[84] = -873457408;
        this.modelIDs[85] = -1192158976;
        this.modelIDs[86] = -1561257728;
        this.modelIDs[87] = -1863247616;
        this.modelIDs[88] = -789505792;
        this.modelIDs[89] = 133241088;
        this.modelIDs[90] = 452008192;
        this.modelIDs[91] = -1510926080;
        this.modelIDs[92] = -269412096;
        this.modelIDs[93] = 334567680;
        this.modelIDs[94] = -370075392;
        this.modelIDs[95] = 66197760;
        this.modelIDs[96] = -1695475456;
        this.modelIDs[97] = 1022433536;
        this.modelIDs[98] = 972101888;
        this.modelIDs[99] = -722462464;
        this.modelIDs[100] = 250681600;
        this.modelIDs[101] = -521070336;
        this.modelIDs[102] = -68151040;
        this.modelIDs[103] = -2031019776;
        this.modelIDs[104] = 66132224;
        this.modelIDs[105] = 502405376;
        this.modelIDs[106] = 301078784;
        this.modelIDs[107] = -202368768;
        this.modelIDs[108] = -235923200;
        this.modelIDs[109] = -2114905856;
        this.modelIDs[110] = -554624768;
        this.modelIDs[111] = 586225920;
        this.modelIDs[112] = 1274091776;
        this.modelIDs[113] = -688908032;
        this.modelIDs[114] = 2112952576;
        this.modelIDs[115] = -1527703296;
        this.modelIDs[116] = 653400320;
        this.modelIDs[117] = -118417152;
        this.modelIDs[118] = 670177536;
        this.modelIDs[119] = 233969920;
        this.modelIDs[120] = -1645143808;
        this.modelIDs[121] = -957277952;
        this.modelIDs[122] = 384964864;
        this.modelIDs[123] = 183572736;
        this.modelIDs[124] = 988879104;
        this.modelIDs[125] = -672065280;
        this.modelIDs[126] = -571467520;
        this.modelIDs[127] = 233904384;
        this.modelIDs[128] = 49355008;
        this.modelIDs[129] = -1997465344;
        this.modelIDs[130] = -2047796992;
        this.modelIDs[131] = -1477371648;
        this.modelIDs[132] = 1206982912;
        this.modelIDs[133] = 82974976;
        this.modelIDs[134] = 150083840;
        this.modelIDs[135] = -1259267840;
        this.modelIDs[136] = -1242490624;
        this.modelIDs[137] = -755951360;
        this.modelIDs[138] = 418453760;
        this.modelIDs[139] = 384899328;
        this.modelIDs[140] = 15800576;
        this.modelIDs[141] = 485562624;
        this.modelIDs[142] = -101705472;
        this.modelIDs[143] = -839902976;
        this.modelIDs[144] = -1125050112;
        this.modelIDs[145] = 452073728;
        this.modelIDs[146] = -1343153920;
        this.modelIDs[147] = 368187648;
        this.modelIDs[148] = -823060224;
        this.modelIDs[149] = 821106944;
        this.modelIDs[150] = 787552512;
        this.modelIDs[151] = 368122112;
        this.modelIDs[152] = -437184256;
        this.modelIDs[153] = -1796138752;
        this.modelIDs[154] = 552737024;
        this.modelIDs[155] = -638510848;
        this.modelIDs[156] = 1055987968;
        this.modelIDs[157] = 686954752;
        this.modelIDs[158] = -1007609600;
        this.modelIDs[159] = 1089542400;
        this.modelIDs[160] = -1276045056;
        this.modelIDs[161] = 703666432;
        this.modelIDs[162] = -1628366592;
        this.modelIDs[163] = -470804224;
        this.modelIDs[164] = -185591552;
        this.modelIDs[165] = -1947133696;
        this.modelIDs[166] = 552671488;
        this.modelIDs[167] = 418519296;
        this.modelIDs[168] = 150018304;
        this.modelIDs[169] = 200349952;
        this.modelIDs[170] = -605021952;
        this.modelIDs[171] = -219145984;
        this.modelIDs[172] = -1074718464;
        this.modelIDs[173] = 2146507008;
        this.modelIDs[174] = -487515904;
        this.modelIDs[175] = -403629824;
        this.modelIDs[176] = -17753856;
        this.modelIDs[177] = -34531072;
        this.modelIDs[178] = -672130816;
        this.modelIDs[179] = 804329728;
        this.modelIDs[180] = -2131683072;
        this.modelIDs[181] = -537847552;
        this.modelIDs[182] = -84862720;
        this.modelIDs[183] = 351410432;
        this.modelIDs[184] = 217127168;
        this.modelIDs[185] = -974055168;
        this.modelIDs[186] = -168814336;
        this.modelIDs[187] = 116529408;
        this.modelIDs[188] = 770775296;
        this.modelIDs[189] = 301013248;
        this.modelIDs[190] = -118482688;
        this.modelIDs[191] = -252634880;
        this.modelIDs[192] = 737220864;
        this.modelIDs[193] = 1240537344;
        this.modelIDs[194] = -906946304;
        this.modelIDs[195] = -319809280;
        this.modelIDs[196] = -1376708352;
        this.modelIDs[197] = -168748800;
        this.modelIDs[198] = -940500736;
        this.modelIDs[199] = 535959808;
        this.modelIDs[200] = 116463872;
        this.modelIDs[201] = -890234624;
        this.modelIDs[202] = -1578034944;
        this.modelIDs[203] = -621733632;
        this.modelIDs[204] = -1494148864;
        this.modelIDs[205] = 200415488;
        this.modelIDs[206] = -806348544;
        this.modelIDs[207] = -1963910912;
        this.modelIDs[208] = -688842496;
        this.modelIDs[209] = -84928256;
        this.modelIDs[210] = -856680192;
        this.modelIDs[211] = 1072765184;
        this.modelIDs[212] = -1393485568;
        this.modelIDs[213] = 1257314560;
        this.modelIDs[214] = 485628160;
        this.modelIDs[215] = -1108272896;
        this.modelIDs[216] = -823125760;
        this.modelIDs[217] = -1762584320;
        this.modelIDs[218] = 183638272;
        this.modelIDs[219] = 435230976;
        this.modelIDs[220] = -1896802048;
        this.modelIDs[221] = 569514240;
        this.modelIDs[222] = 133306624;
        this.modelIDs[223] = -185526016;
        this.modelIDs[224] = -873391872;
        this.modelIDs[225] = 15866112;
        this.modelIDs[226] = -1057941248;
        this.modelIDs[227] = 401676544;
        this.modelIDs[228] = 166861056;
        this.modelIDs[229] = -1309599488;
        this.modelIDs[230] = 1039210752;
        this.modelIDs[231] = -1410262784;
        this.modelIDs[232] = -235857664;
        this.modelIDs[233] = -1460594432;
        this.modelIDs[234] = 1106319616;
        this.modelIDs[235] = -420407040;
        this.modelIDs[236] = 519182592;
        this.modelIDs[237] = -1829693184;
        this.modelIDs[238] = -705619712;
        this.modelIDs[239] = 334633216;
        this.modelIDs[240] = -621799168;
        this.modelIDs[241] = 1123096832;
        this.modelIDs[242] = -336520960;
        this.modelIDs[243] = 32577792;
        this.modelIDs[244] = -2014242560;
        this.modelIDs[245] = 837884160;
        this.modelIDs[246] = 502339840;
        this.modelIDs[247] = -1427040000;
        this.modelIDs[248] = 468785408;
        this.modelIDs[249] = -1443817216;
        this.modelIDs[250] = -152037120;
        this.modelIDs[251] = 99752192;
        this.modelIDs[252] = 1324423424;
        this.modelIDs[253] = -655353600;
        this.modelIDs[254] = -2081351424;
        this.modelIDs[255] = -1292822272;
        this.modelIDs[256] = -353363712;
    }
}

