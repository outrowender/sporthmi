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
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 366: {
                    this.models[366] = new ButtonModel(1700366);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(1700116);
                    break;
                }
                case 292: {
                    this.models[292] = new ButtonModel(1700292);
                    break;
                }
                case 134: {
                    this.models[134] = new LabelModel(1700134);
                    break;
                }
                case 62: {
                    this.models[62] = new ListModel(1700062);
                    break;
                }
                case 255: {
                    this.models[255] = new ButtonModel(0x19F19F);
                    break;
                }
                case 105: {
                    this.models[105] = new LabelModel(1700105);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(0x19F11F);
                    break;
                }
                case 226: {
                    this.models[226] = new LabelModel(1700226);
                    break;
                }
                case 140: {
                    this.models[140] = new BufferedListModel(1700140);
                    break;
                }
                case 345: {
                    this.models[345] = new ButtonModel(0x19F1F9);
                    break;
                }
                case 133: {
                    this.models[133] = new BufferedListModel(1700133);
                    break;
                }
                case 305: {
                    this.models[305] = new ButtonModel(1700305);
                    break;
                }
                case 172: {
                    this.models[172] = new ButtonModel(1700172);
                    break;
                }
                case 131: {
                    this.models[131] = new ButtonModel(1700131);
                    break;
                }
                case 112: {
                    this.models[112] = new ChoiceModel(1700112);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(1700114);
                    break;
                }
                case 95: {
                    this.models[95] = new LabelModel(1700095);
                    break;
                }
                case 279: {
                    this.models[279] = new ChoiceModel(1700279);
                    break;
                }
                case 330: {
                    this.models[330] = new ChoiceModel(1700330);
                    break;
                }
                case 245: {
                    this.models[245] = new ListModel(1700245);
                    break;
                }
                case 241: {
                    this.models[241] = new ButtonModel(0x19F191);
                    break;
                }
                case 138: {
                    this.models[138] = new BufferedListModel(1700138);
                    break;
                }
                case 87: {
                    this.models[87] = new LabelModel(1700087);
                    break;
                }
                case 239: {
                    this.models[239] = new LabelModel(1700239);
                    break;
                }
                case 290: {
                    this.models[290] = new ButtonModel(1700290);
                    break;
                }
                case 334: {
                    this.models[334] = new ResourceLocatorModel(1700334);
                    break;
                }
                case 60: {
                    this.models[60] = new ChoiceModel(1700060);
                    break;
                }
                case 252: {
                    this.models[252] = new LabelModel(1700252);
                    break;
                }
                case 237: {
                    this.models[237] = new ButtonModel(1700237);
                    break;
                }
                case 243: {
                    this.models[243] = new RangeModel(1700243);
                    break;
                }
                case 173: {
                    this.models[173] = new LabelModel(1700173);
                    break;
                }
                case 94: {
                    this.models[94] = new LabelModel(1700094);
                    break;
                }
                case 126: {
                    this.models[126] = new LabelModel(1700126);
                    break;
                }
                case 270: {
                    this.models[270] = new ChoiceModel(1700270);
                    break;
                }
                case 321: {
                    this.models[321] = new SpellerModel(1700321);
                    break;
                }
                case 386: {
                    this.models[386] = new ChoiceModel(1700386);
                    break;
                }
                case 256: {
                    this.models[256] = new ChoiceModel(1700256);
                    break;
                }
                case 249: {
                    this.models[249] = new ButtonModel(0x19F199);
                    break;
                }
                case 367: {
                    this.models[367] = new ChoiceModel(1700367);
                    break;
                }
                case 100: {
                    this.models[100] = new LabelModel(1700100);
                    break;
                }
                case 301: {
                    this.models[301] = new BaseListModel(1700301, (MenuModel)this.getModel(1700336));
                    break;
                }
                case 387: {
                    this.models[387] = new ChoiceModel(1700387);
                    break;
                }
                case 251: {
                    this.models[251] = new LabelModel(1700251);
                    break;
                }
                case 168: {
                    this.models[168] = new LabelModel(1700168);
                    break;
                }
                case 111: {
                    this.models[111] = new ChoiceModel(1700111);
                    break;
                }
                case 282: {
                    this.models[282] = new ButtonModel(1700282);
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(1700155);
                    break;
                }
                case 388: {
                    this.models[388] = new BaseListModel(1700388, null);
                    break;
                }
                case 300: {
                    this.models[300] = new ButtonModel(1700300);
                    break;
                }
                case 283: {
                    this.models[283] = new ButtonModel(1700283);
                    break;
                }
                case 136: {
                    this.models[136] = new BufferedListModel(1700136);
                    break;
                }
                case 132: {
                    this.models[132] = new BufferedListModel(1700132);
                    break;
                }
                case 278: {
                    this.models[278] = new ChoiceModel(1700278);
                    break;
                }
                case 80: {
                    this.models[80] = new LabelModel(1700080);
                    break;
                }
                case 307: {
                    this.models[307] = new ButtonModel(1700307);
                    break;
                }
                case 338: {
                    this.models[338] = new ButtonModel(1700338);
                    break;
                }
                case 247: {
                    this.models[247] = new ButtonModel(1700247);
                    break;
                }
                case 222: {
                    this.models[222] = new ButtonModel(1700222);
                    break;
                }
                case 364: {
                    this.models[364] = new ChoiceModel(1700364);
                    break;
                }
                case 236: {
                    this.models[236] = new ButtonModel(1700236);
                    break;
                }
                case 57: {
                    this.models[57] = new ButtonModel(1700057);
                    break;
                }
                case 272: {
                    this.models[272] = new ButtonModel(1700272);
                    break;
                }
                case 101: {
                    this.models[101] = new LabelModel(1700101);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(1700312);
                    break;
                }
                case 135: {
                    this.models[135] = new ButtonModel(1700135);
                    break;
                }
                case 129: {
                    this.models[129] = new ButtonModel(1700129);
                    break;
                }
                case 303: {
                    this.models[303] = new LabelModel(1700303);
                    break;
                }
                case 370: {
                    this.models[370] = new ButtonModel(1700370);
                    break;
                }
                case 233: {
                    this.models[233] = new ButtonModel(1700233);
                    break;
                }
                case 228: {
                    this.models[228] = new ChoiceModel(1700228);
                    break;
                }
                case 51: {
                    this.models[51] = new ButtonModel(1700051);
                    break;
                }
                case 368: {
                    this.models[368] = new ChoiceModel(1700368);
                    break;
                }
                case 308: {
                    this.models[308] = new ChoiceModel(1700308);
                    break;
                }
                case 148: {
                    this.models[148] = new ChoiceModel(1700148);
                    break;
                }
                case 281: {
                    this.models[281] = new BaseListModel(1700281, null);
                    break;
                }
                case 75: {
                    this.models[75] = new LabelModel(1700075);
                    break;
                }
                case 298: {
                    this.models[298] = new ChoiceModel(1700298);
                    break;
                }
                case 77: {
                    this.models[77] = new LabelModel(1700077);
                    break;
                }
                case 324: {
                    this.models[324] = new ButtonModel(1700324);
                    break;
                }
                case 347: {
                    this.models[347] = new MetricsModel(1700347);
                    break;
                }
                case 296: {
                    this.models[296] = new LabelModel(1700296);
                    break;
                }
                case 339: {
                    this.models[339] = new ButtonModel(1700339);
                    break;
                }
                case 259: {
                    this.models[259] = new ChoiceModel(1700259);
                    break;
                }
                case 43: {
                    this.models[43] = new ButtonModel(1700043);
                    break;
                }
                case 280: {
                    this.models[280] = new LabelModel(1700280);
                    break;
                }
                case 258: {
                    this.models[258] = new ListModel(1700258);
                    break;
                }
                case 240: {
                    this.models[240] = new ButtonModel(1700240);
                    break;
                }
                case 304: {
                    this.models[304] = new ButtonModel(1700304);
                    break;
                }
                case 103: {
                    this.models[103] = new LabelModel(1700103);
                    break;
                }
                case 122: {
                    this.models[122] = new LabelModel(1700122);
                    break;
                }
                case 261: {
                    this.models[261] = new ChoiceModel(1700261);
                    break;
                }
                case 335: {
                    this.models[335] = new MenuModel(1700335);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(1700115);
                    break;
                }
                case 329: {
                    this.models[329] = new LabelModel(1700329);
                    break;
                }
                case 355: {
                    this.models[355] = new LabelModel(1700355);
                    break;
                }
                case 250: {
                    this.models[250] = new LabelModel(1700250);
                    break;
                }
                case 156: {
                    this.models[156] = new ButtonModel(1700156);
                    break;
                }
                case 153: {
                    this.models[153] = new ButtonModel(1700153);
                    break;
                }
                case 52: {
                    this.models[52] = new LabelModel(1700052);
                    break;
                }
                case 110: {
                    this.models[110] = new ChoiceModel(1700110);
                    break;
                }
                case 320: {
                    this.models[320] = new ChoiceModel(1700320);
                    break;
                }
                case 91: {
                    this.models[91] = new LabelModel(1700091);
                    break;
                }
                case 230: {
                    this.models[230] = new LabelModel(1700230);
                    break;
                }
                case 99: {
                    this.models[99] = new LabelModel(1700099);
                    break;
                }
                case 381: {
                    this.models[381] = new MetricsModel(1700381);
                    break;
                }
                case 369: {
                    this.models[369] = new LabelModel(1700369);
                    break;
                }
                case 83: {
                    this.models[83] = new ButtonModel(1700083);
                    break;
                }
                case 81: {
                    this.models[81] = new IPSpellerModel(1700081);
                    break;
                }
                case 225: {
                    this.models[225] = new ButtonModel(1700225);
                    break;
                }
                case 318: {
                    this.models[318] = new ButtonModel(1700318);
                    break;
                }
                case 130: {
                    this.models[130] = new ButtonModel(1700130);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(1700171);
                    break;
                }
                case 54: {
                    this.models[54] = new LabelModel(1700054);
                    break;
                }
                case 221: {
                    this.models[221] = new ButtonModel(1700221);
                    break;
                }
                case 260: {
                    this.models[260] = new ListModel(1700260);
                    break;
                }
                case 390: {
                    this.models[390] = new VirtualButtonModel(1700390);
                    break;
                }
                case 344: {
                    this.models[344] = new ButtonModel(1700344);
                    break;
                }
                case 391: {
                    this.models[391] = new VirtualButtonModel(1700391);
                    break;
                }
                case 365: {
                    this.models[365] = new LabelModel(1700365);
                    break;
                }
                case 253: {
                    this.models[253] = new LabelModel(1700253);
                    break;
                }
                case 294: {
                    this.models[294] = new LabelModel(1700294);
                    break;
                }
                case 374: {
                    this.models[374] = new ChoiceModel(1700374);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(1700106);
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(1700154);
                    break;
                }
                case 311: {
                    this.models[311] = new ChoiceModel(1700311);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(1700061);
                    break;
                }
                case 109: {
                    this.models[109] = new ChoiceModel(1700109);
                    break;
                }
                case 98: {
                    this.models[98] = new ListModel(1700098);
                    break;
                }
                case 232: {
                    this.models[232] = new ButtonModel(1700232);
                    break;
                }
                case 229: {
                    this.models[229] = new ChoiceModel(1700229);
                    break;
                }
                case 263: {
                    this.models[263] = new ButtonModel(1700263);
                    break;
                }
                case 167: {
                    this.models[167] = new BufferedListModel(1700167);
                    break;
                }
                case 356: {
                    this.models[356] = new LabelModel(1700356);
                    break;
                }
                case 360: {
                    this.models[360] = new LabelModel(1700360);
                    break;
                }
                case 276: {
                    this.models[276] = new ButtonModel(1700276);
                    break;
                }
                case 277: {
                    this.models[277] = new ButtonModel(1700277);
                    break;
                }
                case 306: {
                    this.models[306] = new BaseListModel(1700306, null);
                    break;
                }
                case 120: {
                    this.models[120] = new LabelModel(1700120);
                    break;
                }
                case 118: {
                    this.models[118] = new LabelModel(1700118);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(1700096);
                    break;
                }
                case 124: {
                    this.models[124] = new LabelModel(1700124);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(1700089);
                    break;
                }
                case 45: {
                    this.models[45] = new ButtonModel(1700045);
                    break;
                }
                case 284: {
                    this.models[284] = new ChoiceModel(1700284);
                    break;
                }
                case 378: {
                    this.models[378] = new ChoiceModel(1700378);
                    break;
                }
                case 271: {
                    this.models[271] = new LabelModel(1700271);
                    break;
                }
                case 373: {
                    this.models[373] = new ButtonModel(1700373);
                    break;
                }
                case 302: {
                    this.models[302] = new ButtonModel(1700302);
                    break;
                }
                case 144: {
                    this.models[144] = new LabelModel(1700144);
                    break;
                }
                case 142: {
                    this.models[142] = new ButtonModel(1700142);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(1700117);
                    break;
                }
                case 325: {
                    this.models[325] = new ButtonModel(1700325);
                    break;
                }
                case 244: {
                    this.models[244] = new LabelModel(1700244);
                    break;
                }
                case 384: {
                    this.models[384] = new ChoiceModel(1700384);
                    break;
                }
                case 313: {
                    this.models[313] = new ChoiceModel(1700313);
                    break;
                }
                case 158: {
                    this.models[158] = new ButtonModel(1700158);
                    break;
                }
                case 392: {
                    this.models[392] = new LabelModel(1700392);
                    break;
                }
                case 291: {
                    this.models[291] = new ChoiceModel(1700291);
                    break;
                }
                case 160: {
                    this.models[160] = new LabelModel(1700160);
                    break;
                }
                case 275: {
                    this.models[275] = new MetricsModel(1700275);
                    break;
                }
                case 137: {
                    this.models[137] = new ChoiceModel(1700137);
                    break;
                }
                case 254: {
                    this.models[254] = new ButtonModel(1700254);
                    break;
                }
                case 67: {
                    this.models[67] = new ButtonModel(1700067);
                    break;
                }
                case 84: {
                    this.models[84] = new ButtonModel(1700084);
                    break;
                }
                case 235: {
                    this.models[235] = new LabelModel(1700235);
                    break;
                }
                case 128: {
                    this.models[128] = new LabelModel(1700128);
                    break;
                }
                case 376: {
                    this.models[376] = new MenuModel(1700376);
                    break;
                }
                case 104: {
                    this.models[104] = new LabelModel(1700104);
                    break;
                }
                case 107: {
                    this.models[107] = new SpellerModel(1700107);
                    break;
                }
                case 59: {
                    this.models[59] = new ChoiceModel(1700059);
                    break;
                }
                case 82: {
                    this.models[82] = new LabelModel(1700082);
                    break;
                }
                case 287: {
                    this.models[287] = new ButtonModel(1700287);
                    break;
                }
                case 223: {
                    this.models[223] = new OptionModel(1700223);
                    break;
                }
                case 322: {
                    this.models[322] = new BaseListModel(1700322, null);
                    break;
                }
                case 327: {
                    this.models[327] = new ChoiceModel(1700327);
                    break;
                }
                case 350: {
                    this.models[350] = new ButtonModel(1700350);
                    break;
                }
                case 349: {
                    this.models[349] = new ButtonModel(1700349);
                    break;
                }
                case 55: {
                    this.models[55] = new LabelModel(1700055);
                    break;
                }
                case 143: {
                    this.models[143] = new ButtonModel(1700143);
                    break;
                }
                case 224: {
                    this.models[224] = new ButtonModel(1700224);
                    break;
                }
                case 319: {
                    this.models[319] = new SpellerModel(1700319);
                    break;
                }
                case 346: {
                    this.models[346] = new BaseListModel(1700346, (MenuModel)this.getModel(1700336));
                    break;
                }
                case 372: {
                    this.models[372] = new ButtonModel(1700372);
                    break;
                }
                case 108: {
                    this.models[108] = new ChoiceModel(1700108);
                    break;
                }
                case 293: {
                    this.models[293] = new ChoiceModel(1700293);
                    break;
                }
                case 85: {
                    this.models[85] = new ButtonModel(1700085);
                    break;
                }
                case 358: {
                    this.models[358] = new ButtonModel(1700358);
                    break;
                }
                case 141: {
                    this.models[141] = new ChoiceModel(1700141);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(0x19F111);
                    break;
                }
                case 88: {
                    this.models[88] = new ListModel(1700088);
                    break;
                }
                case 336: {
                    this.models[336] = new MenuModel(1700336);
                    break;
                }
                case 139: {
                    this.models[139] = new LabelModel(1700139);
                    break;
                }
                case 169: {
                    this.models[169] = new BufferedListModel(1700169);
                    break;
                }
                case 297: {
                    this.models[297] = new ButtonModel(1700297);
                    break;
                }
                case 76: {
                    this.models[76] = new ChoiceModel(1700076);
                    break;
                }
                case 269: {
                    this.models[269] = new ChoiceModel(1700269);
                    break;
                }
                case 341: {
                    this.models[341] = new ButtonModel(1700341);
                    break;
                }
                case 295: {
                    this.models[295] = new ButtonModel(1700295);
                    break;
                }
                case 383: {
                    this.models[383] = new ButtonModel(1700383);
                    break;
                }
                case 102: {
                    this.models[102] = new LabelModel(1700102);
                    break;
                }
                case 42: {
                    this.models[42] = new ChoiceModel(1700042);
                    break;
                }
                case 257: {
                    this.models[257] = new ChoiceModel(1700257);
                    break;
                }
                case 314: {
                    this.models[314] = new ButtonModel(1700314);
                    break;
                }
                case 262: {
                    this.models[262] = new ButtonModel(1700262);
                    break;
                }
                case 363: {
                    this.models[363] = new ButtonModel(1700363);
                    break;
                }
                case 47: {
                    this.models[47] = new ButtonModel(1700047);
                    break;
                }
                case 234: {
                    this.models[234] = new LabelModel(1700234);
                    break;
                }
                case 310: {
                    this.models[310] = new ChoiceModel(1700310);
                    break;
                }
                case 90: {
                    this.models[90] = new ButtonModel(1700090);
                    break;
                }
                case 44: {
                    this.models[44] = new ButtonModel(1700044);
                    break;
                }
                case 159: {
                    this.models[159] = new ButtonModel(1700159);
                    break;
                }
                case 268: {
                    this.models[268] = new LabelModel(1700268);
                    break;
                }
                case 170: {
                    this.models[170] = new LabelModel(1700170);
                    break;
                }
                case 380: {
                    this.models[380] = new ChoiceModel(1700380);
                    break;
                }
                case 285: {
                    this.models[285] = new ButtonModel(1700285);
                    break;
                }
                case 46: {
                    this.models[46] = new ChoiceModel(1700046);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(1700246);
                    break;
                }
                case 362: {
                    this.models[362] = new ButtonModel(1700362);
                    break;
                }
                case 121: {
                    this.models[121] = new BufferedListModel(0x19F119);
                    break;
                }
                case 238: {
                    this.models[238] = new ChoiceModel(1700238);
                    break;
                }
                case 385: {
                    this.models[385] = new LabelModel(1700385);
                    break;
                }
                case 359: {
                    this.models[359] = new LabelModel(1700359);
                    break;
                }
                case 340: {
                    this.models[340] = new ButtonModel(1700340);
                    break;
                }
                case 299: {
                    this.models[299] = new LabelModel(1700299);
                    break;
                }
                case 352: {
                    this.models[352] = new MenuModel(1700352);
                    break;
                }
                case 288: {
                    this.models[288] = new ButtonModel(1700288);
                    break;
                }
                case 119: {
                    this.models[119] = new LabelModel(1700119);
                    break;
                }
                case 361: {
                    this.models[361] = new ButtonModel(1700361);
                    break;
                }
                case 273: {
                    this.models[273] = new BaseListModel(1700273, null);
                    break;
                }
                case 157: {
                    this.models[157] = new ButtonModel(1700157);
                    break;
                }
                case 267: {
                    this.models[267] = new ChoiceModel(1700267);
                    break;
                }
                case 337: {
                    this.models[337] = new MetricsModel(0x19F1F1);
                    break;
                }
                case 264: {
                    this.models[264] = new LabelModel(1700264);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(1700161);
                    break;
                }
                case 326: {
                    this.models[326] = new ChoiceModel(1700326);
                    break;
                }
                case 382: {
                    this.models[382] = new ChoiceModel(1700382);
                    break;
                }
                case 242: {
                    this.models[242] = new BaseListModel(1700242, null);
                    break;
                }
                case 309: {
                    this.models[309] = new ChoiceModel(1700309);
                    break;
                }
                case 371: {
                    this.models[371] = new ChoiceModel(1700371);
                    break;
                }
                case 58: {
                    this.models[58] = new ChoiceModel(1700058);
                    break;
                }
                case 162: {
                    this.models[162] = new ButtonModel(1700162);
                    break;
                }
                case 331: {
                    this.models[331] = new ChoiceModel(1700331);
                    break;
                }
                case 97: {
                    this.models[97] = new ButtonModel(1700097);
                    break;
                }
                case 231: {
                    this.models[231] = new ButtonModel(1700231);
                    break;
                }
                case 145: {
                    this.models[145] = new BufferedListModel(1700145);
                    break;
                }
                case 125: {
                    this.models[125] = new LabelModel(1700125);
                    break;
                }
                case 266: {
                    this.models[266] = new LabelModel(1700266);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(1700123);
                    break;
                }
                case 265: {
                    this.models[265] = new LabelModel(1700265);
                    break;
                }
                case 86: {
                    this.models[86] = new LabelModel(1700086);
                    break;
                }
                case 357: {
                    this.models[357] = new LabelModel(1700357);
                    break;
                }
                case 174: {
                    this.models[174] = new LabelModel(1700174);
                    break;
                }
                case 56: {
                    this.models[56] = new ChoiceModel(1700056);
                    break;
                }
                case 227: {
                    this.models[227] = new ListModel(1700227);
                    break;
                }
                case 274: {
                    this.models[274] = new ButtonModel(1700274);
                    break;
                }
                case 74: {
                    this.models[74] = new BufferedListModel(1700074);
                    break;
                }
                default: {
                    SWDLModelBank.getModelLogChannel().log(10000, "[SWDLModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public SWDLModelBank() {
        super(17, 393, 257);
        this.modelIDs = new int[257];
        this.modelIDs[0] = 1700366;
        this.modelIDs[1] = 1700116;
        this.modelIDs[2] = 1700292;
        this.modelIDs[3] = 1700134;
        this.modelIDs[4] = 1700062;
        this.modelIDs[5] = 0x19F19F;
        this.modelIDs[6] = 1700105;
        this.modelIDs[7] = 0x19F11F;
        this.modelIDs[8] = 1700226;
        this.modelIDs[9] = 1700140;
        this.modelIDs[10] = 0x19F1F9;
        this.modelIDs[11] = 1700133;
        this.modelIDs[12] = 1700305;
        this.modelIDs[13] = 1700172;
        this.modelIDs[14] = 1700131;
        this.modelIDs[15] = 1700112;
        this.modelIDs[16] = 1700114;
        this.modelIDs[17] = 1700095;
        this.modelIDs[18] = 1700279;
        this.modelIDs[19] = 1700330;
        this.modelIDs[20] = 1700245;
        this.modelIDs[21] = 0x19F191;
        this.modelIDs[22] = 1700138;
        this.modelIDs[23] = 1700087;
        this.modelIDs[24] = 1700239;
        this.modelIDs[25] = 1700290;
        this.modelIDs[26] = 1700334;
        this.modelIDs[27] = 1700060;
        this.modelIDs[28] = 1700252;
        this.modelIDs[29] = 1700237;
        this.modelIDs[30] = 1700243;
        this.modelIDs[31] = 1700173;
        this.modelIDs[32] = 1700094;
        this.modelIDs[33] = 1700126;
        this.modelIDs[34] = 1700270;
        this.modelIDs[35] = 1700321;
        this.modelIDs[36] = 1700386;
        this.modelIDs[37] = 1700256;
        this.modelIDs[38] = 0x19F199;
        this.modelIDs[39] = 1700367;
        this.modelIDs[40] = 1700100;
        this.modelIDs[41] = 1700301;
        this.modelIDs[42] = 1700387;
        this.modelIDs[43] = 1700251;
        this.modelIDs[44] = 1700168;
        this.modelIDs[45] = 1700111;
        this.modelIDs[46] = 1700282;
        this.modelIDs[47] = 1700155;
        this.modelIDs[48] = 1700388;
        this.modelIDs[49] = 1700300;
        this.modelIDs[50] = 1700283;
        this.modelIDs[51] = 1700136;
        this.modelIDs[52] = 1700132;
        this.modelIDs[53] = 1700278;
        this.modelIDs[54] = 1700080;
        this.modelIDs[55] = 1700307;
        this.modelIDs[56] = 1700338;
        this.modelIDs[57] = 1700247;
        this.modelIDs[58] = 1700222;
        this.modelIDs[59] = 1700364;
        this.modelIDs[60] = 1700236;
        this.modelIDs[61] = 1700057;
        this.modelIDs[62] = 1700272;
        this.modelIDs[63] = 1700101;
        this.modelIDs[64] = 1700312;
        this.modelIDs[65] = 1700135;
        this.modelIDs[66] = 1700129;
        this.modelIDs[67] = 1700303;
        this.modelIDs[68] = 1700370;
        this.modelIDs[69] = 1700233;
        this.modelIDs[70] = 1700228;
        this.modelIDs[71] = 1700051;
        this.modelIDs[72] = 1700368;
        this.modelIDs[73] = 1700308;
        this.modelIDs[74] = 1700148;
        this.modelIDs[75] = 1700281;
        this.modelIDs[76] = 1700075;
        this.modelIDs[77] = 1700298;
        this.modelIDs[78] = 1700077;
        this.modelIDs[79] = 1700324;
        this.modelIDs[80] = 1700347;
        this.modelIDs[81] = 1700296;
        this.modelIDs[82] = 1700339;
        this.modelIDs[83] = 1700259;
        this.modelIDs[84] = 1700043;
        this.modelIDs[85] = 1700280;
        this.modelIDs[86] = 1700258;
        this.modelIDs[87] = 1700240;
        this.modelIDs[88] = 1700304;
        this.modelIDs[89] = 1700103;
        this.modelIDs[90] = 1700122;
        this.modelIDs[91] = 1700261;
        this.modelIDs[92] = 1700335;
        this.modelIDs[93] = 1700115;
        this.modelIDs[94] = 1700329;
        this.modelIDs[95] = 1700355;
        this.modelIDs[96] = 1700250;
        this.modelIDs[97] = 1700156;
        this.modelIDs[98] = 1700153;
        this.modelIDs[99] = 1700052;
        this.modelIDs[100] = 1700110;
        this.modelIDs[101] = 1700320;
        this.modelIDs[102] = 1700091;
        this.modelIDs[103] = 1700230;
        this.modelIDs[104] = 1700099;
        this.modelIDs[105] = 1700381;
        this.modelIDs[106] = 1700369;
        this.modelIDs[107] = 1700083;
        this.modelIDs[108] = 1700081;
        this.modelIDs[109] = 1700225;
        this.modelIDs[110] = 1700318;
        this.modelIDs[111] = 1700130;
        this.modelIDs[112] = 1700171;
        this.modelIDs[113] = 1700054;
        this.modelIDs[114] = 1700221;
        this.modelIDs[115] = 1700260;
        this.modelIDs[116] = 1700390;
        this.modelIDs[117] = 1700344;
        this.modelIDs[118] = 1700391;
        this.modelIDs[119] = 1700365;
        this.modelIDs[120] = 1700253;
        this.modelIDs[121] = 1700294;
        this.modelIDs[122] = 1700374;
        this.modelIDs[123] = 1700106;
        this.modelIDs[124] = 1700154;
        this.modelIDs[125] = 1700311;
        this.modelIDs[126] = 1700061;
        this.modelIDs[127] = 1700109;
        this.modelIDs[128] = 1700098;
        this.modelIDs[129] = 1700232;
        this.modelIDs[130] = 1700229;
        this.modelIDs[131] = 1700263;
        this.modelIDs[132] = 1700167;
        this.modelIDs[133] = 1700356;
        this.modelIDs[134] = 1700360;
        this.modelIDs[135] = 1700276;
        this.modelIDs[136] = 1700277;
        this.modelIDs[137] = 1700306;
        this.modelIDs[138] = 1700120;
        this.modelIDs[139] = 1700118;
        this.modelIDs[140] = 1700096;
        this.modelIDs[141] = 1700124;
        this.modelIDs[142] = 1700089;
        this.modelIDs[143] = 1700045;
        this.modelIDs[144] = 1700284;
        this.modelIDs[145] = 1700378;
        this.modelIDs[146] = 1700271;
        this.modelIDs[147] = 1700373;
        this.modelIDs[148] = 1700302;
        this.modelIDs[149] = 1700144;
        this.modelIDs[150] = 1700142;
        this.modelIDs[151] = 1700117;
        this.modelIDs[152] = 1700325;
        this.modelIDs[153] = 1700244;
        this.modelIDs[154] = 1700384;
        this.modelIDs[155] = 1700313;
        this.modelIDs[156] = 1700158;
        this.modelIDs[157] = 1700392;
        this.modelIDs[158] = 1700291;
        this.modelIDs[159] = 1700160;
        this.modelIDs[160] = 1700275;
        this.modelIDs[161] = 1700137;
        this.modelIDs[162] = 1700254;
        this.modelIDs[163] = 1700067;
        this.modelIDs[164] = 1700084;
        this.modelIDs[165] = 1700235;
        this.modelIDs[166] = 1700128;
        this.modelIDs[167] = 1700376;
        this.modelIDs[168] = 1700104;
        this.modelIDs[169] = 1700107;
        this.modelIDs[170] = 1700059;
        this.modelIDs[171] = 1700082;
        this.modelIDs[172] = 1700287;
        this.modelIDs[173] = 1700223;
        this.modelIDs[174] = 1700322;
        this.modelIDs[175] = 1700327;
        this.modelIDs[176] = 1700350;
        this.modelIDs[177] = 1700349;
        this.modelIDs[178] = 1700055;
        this.modelIDs[179] = 1700143;
        this.modelIDs[180] = 1700224;
        this.modelIDs[181] = 1700319;
        this.modelIDs[182] = 1700346;
        this.modelIDs[183] = 1700372;
        this.modelIDs[184] = 1700108;
        this.modelIDs[185] = 1700293;
        this.modelIDs[186] = 1700085;
        this.modelIDs[187] = 1700358;
        this.modelIDs[188] = 1700141;
        this.modelIDs[189] = 0x19F111;
        this.modelIDs[190] = 1700088;
        this.modelIDs[191] = 1700336;
        this.modelIDs[192] = 1700139;
        this.modelIDs[193] = 1700169;
        this.modelIDs[194] = 1700297;
        this.modelIDs[195] = 1700076;
        this.modelIDs[196] = 1700269;
        this.modelIDs[197] = 1700341;
        this.modelIDs[198] = 1700295;
        this.modelIDs[199] = 1700383;
        this.modelIDs[200] = 1700102;
        this.modelIDs[201] = 1700042;
        this.modelIDs[202] = 1700257;
        this.modelIDs[203] = 1700314;
        this.modelIDs[204] = 1700262;
        this.modelIDs[205] = 1700363;
        this.modelIDs[206] = 1700047;
        this.modelIDs[207] = 1700234;
        this.modelIDs[208] = 1700310;
        this.modelIDs[209] = 1700090;
        this.modelIDs[210] = 1700044;
        this.modelIDs[211] = 1700159;
        this.modelIDs[212] = 1700268;
        this.modelIDs[213] = 1700170;
        this.modelIDs[214] = 1700380;
        this.modelIDs[215] = 1700285;
        this.modelIDs[216] = 1700046;
        this.modelIDs[217] = 1700246;
        this.modelIDs[218] = 1700362;
        this.modelIDs[219] = 0x19F119;
        this.modelIDs[220] = 1700238;
        this.modelIDs[221] = 1700385;
        this.modelIDs[222] = 1700359;
        this.modelIDs[223] = 1700340;
        this.modelIDs[224] = 1700299;
        this.modelIDs[225] = 1700352;
        this.modelIDs[226] = 1700288;
        this.modelIDs[227] = 1700119;
        this.modelIDs[228] = 1700361;
        this.modelIDs[229] = 1700273;
        this.modelIDs[230] = 1700157;
        this.modelIDs[231] = 1700267;
        this.modelIDs[232] = 0x19F1F1;
        this.modelIDs[233] = 1700264;
        this.modelIDs[234] = 1700161;
        this.modelIDs[235] = 1700326;
        this.modelIDs[236] = 1700382;
        this.modelIDs[237] = 1700242;
        this.modelIDs[238] = 1700309;
        this.modelIDs[239] = 1700371;
        this.modelIDs[240] = 1700058;
        this.modelIDs[241] = 1700162;
        this.modelIDs[242] = 1700331;
        this.modelIDs[243] = 1700097;
        this.modelIDs[244] = 1700231;
        this.modelIDs[245] = 1700145;
        this.modelIDs[246] = 1700125;
        this.modelIDs[247] = 1700266;
        this.modelIDs[248] = 1700123;
        this.modelIDs[249] = 1700265;
        this.modelIDs[250] = 1700086;
        this.modelIDs[251] = 1700357;
        this.modelIDs[252] = 1700174;
        this.modelIDs[253] = 1700056;
        this.modelIDs[254] = 1700227;
        this.modelIDs[255] = 1700274;
        this.modelIDs[256] = 1700074;
    }
}

