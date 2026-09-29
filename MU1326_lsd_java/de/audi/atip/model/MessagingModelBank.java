/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BufferedChoiceModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.SlidingListModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.hmi.model.TextfieldModel;
import de.audi.atip.hmi.model.TooltipModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.property.PropertyModel;
import de.audi.atip.hmi.model.texteditor.TextEditorDDModel;
import de.audi.atip.model.ICoreMessagingModelBank;
import de.audi.atip.model.IEvoMessagingModelBank;

public class MessagingModelBank
extends AbstractModelBank
implements ICoreMessagingModelBank,
IEvoMessagingModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 280: {
                    this.models[280] = new ButtonModel(-661511936);
                    break;
                }
                case 201: {
                    this.models[201] = new BufferedChoiceModel(-1986912000);
                    break;
                }
                case 369: {
                    this.models[369] = new MenuModel(831725824);
                    break;
                }
                case 301: {
                    this.models[301] = new ButtonModel(-309190400);
                    break;
                }
                case 441: {
                    this.models[441] = new SpellerModel(2039685376);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(2073174272);
                    break;
                }
                case 403: {
                    this.models[403] = new ChoiceModel(1402151168);
                    break;
                }
                case 445: {
                    this.models[445] = new ChoiceModel(2106794240);
                    break;
                }
                case 328: {
                    this.models[328] = new BufferedChoiceModel(143859968);
                    break;
                }
                case 230: {
                    this.models[230] = new ButtonModel(-1500372736);
                    break;
                }
                case 425: {
                    this.models[425] = new ChoiceModel(1771249920);
                    break;
                }
                case 226: {
                    this.models[226] = new ButtonModel(-1567481600);
                    break;
                }
                case 491: {
                    this.models[491] = new ButtonModel(-1416421120);
                    break;
                }
                case 329: {
                    this.models[329] = new LabelModel(160637184);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(881991936);
                    break;
                }
                case 505: {
                    this.models[505] = new ChoiceModel(-1181540096);
                    break;
                }
                case 492: {
                    this.models[492] = new SpellerModel(-1399643904);
                    break;
                }
                case 438: {
                    this.models[438] = new ChoiceModel(1989353728);
                    break;
                }
                case 270: {
                    this.models[270] = new ChoiceModel(-829284096);
                    break;
                }
                case 426: {
                    this.models[426] = new ButtonModel(1788027136);
                    break;
                }
                case 312: {
                    this.models[312] = new BaseListModel(-124641024, null);
                    break;
                }
                case 474: {
                    this.models[474] = new ChoiceModel(-1701633792);
                    break;
                }
                case 364: {
                    this.models[364] = new MatchspellerModel(747839744);
                    break;
                }
                case 451: {
                    this.models[451] = new LabelModel(-2087509760);
                    break;
                }
                case 168: {
                    this.models[168] = new ListModel(1754407168);
                    break;
                }
                case 232: {
                    this.models[232] = new ChoiceModel(-1466818304);
                    break;
                }
                case 165: {
                    this.models[165] = new ButtonModel(1704075520);
                    break;
                }
                case 402: {
                    this.models[402] = new VirtualButtonModel(1385373952);
                    break;
                }
                case 382: {
                    this.models[382] = new ButtonModel(1049829632);
                    break;
                }
                case 137: {
                    this.models[137] = new ChoiceModel(1234313472);
                    break;
                }
                case 215: {
                    this.models[215] = new ChoiceModel(-1752030976);
                    break;
                }
                case 264: {
                    this.models[264] = new BaseListModel(-929947392, null);
                    break;
                }
                case 166: {
                    this.models[166] = new BufferedChoiceModel(1720852736);
                    break;
                }
                case 405: {
                    this.models[405] = new ButtonModel(1435705600);
                    break;
                }
                case 176: {
                    this.models[176] = new TerminalModelContainer(1888624896, 13, false);
                    break;
                }
                case 493: {
                    this.models[493] = new TiledListModel(-1382866688, (MenuModel)this.getModel(1217536256));
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(915546368);
                    break;
                }
                case 494: {
                    this.models[494] = new ButtonModel(-1366089472);
                    break;
                }
                case 316: {
                    this.models[316] = new BaseListModel(-57532160, null);
                    break;
                }
                case 211: {
                    this.models[211] = new ChoiceModel(-1819139840);
                    break;
                }
                case 495: {
                    this.models[495] = new TextEditorDDModel(-1349312256);
                    break;
                }
                case 167: {
                    this.models[167] = new ButtonModel(1737629952);
                    break;
                }
                case 236: {
                    this.models[236] = new ChoiceModel(-1399709440);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(1603412224);
                    break;
                }
                case 143: {
                    this.models[143] = new BufferedChoiceModel(1334976768);
                    break;
                }
                case 383: {
                    this.models[383] = new ButtonModel(1066606848);
                    break;
                }
                case 384: {
                    this.models[384] = new ButtonModel(1083384064);
                    break;
                }
                case 112: {
                    this.models[112] = new SpellerModel(814883072);
                    break;
                }
                case 496: {
                    this.models[496] = new ButtonModel(-1332535040);
                    break;
                }
                case 279: {
                    this.models[279] = new LabelModel(-678289152);
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(1519526144);
                    break;
                }
                case 194: {
                    this.models[194] = new LabelModel(-2104352512);
                    break;
                }
                case 497: {
                    this.models[497] = new ButtonModel(-1315757824);
                    break;
                }
                case 498: {
                    this.models[498] = new ButtonModel(-1298980608);
                    break;
                }
                case 475: {
                    this.models[475] = new ChoiceModel(-1684856576);
                    break;
                }
                case 404: {
                    this.models[404] = new ButtonModel(1418928384);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(-1231937280);
                    break;
                }
                case 256: {
                    this.models[256] = new ButtonModel(-1064165120);
                    break;
                }
                case 306: {
                    this.models[306] = new ChoiceModel(-225304320);
                    break;
                }
                case 529: {
                    this.models[529] = new ChoiceModel(-778886912);
                    break;
                }
                case 499: {
                    this.models[499] = new LabelModel(-1282203392);
                    break;
                }
                case 253: {
                    this.models[253] = new BaseListModel(-1114496768, null);
                    break;
                }
                case 500: {
                    this.models[500] = new TiledListModel(-1265426176, (MenuModel)this.getModel(-91086592));
                    break;
                }
                case 397: {
                    this.models[397] = new ChoiceModel(1301487872);
                    break;
                }
                case 353: {
                    this.models[353] = new ButtonModel(563290368);
                    break;
                }
                case 271: {
                    this.models[271] = new ButtonModel(-812506880);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(831660288);
                    break;
                }
                case 170: {
                    this.models[170] = new BufferedChoiceModel(1787961600);
                    break;
                }
                case 322: {
                    this.models[322] = new ButtonModel(43196672);
                    break;
                }
                case 195: {
                    this.models[195] = new ChoiceModel(-2087575296);
                    break;
                }
                case 252: {
                    this.models[252] = new BufferedChoiceModel(-1131273984);
                    break;
                }
                case 385: {
                    this.models[385] = new ButtonModel(1100161280);
                    break;
                }
                case 134: {
                    this.models[134] = new ChoiceModel(1183981824);
                    break;
                }
                case 339: {
                    this.models[339] = new LabelModel(328409344);
                    break;
                }
                case 131: {
                    this.models[131] = new ListModel(1133650176);
                    break;
                }
                case 351: {
                    this.models[351] = new BufferedChoiceModel(529735936);
                    break;
                }
                case 274: {
                    this.models[274] = new BaseListModel(-762175232, null);
                    break;
                }
                case 325: {
                    this.models[325] = new BaseListModel(93528320, null);
                    break;
                }
                case 304: {
                    this.models[304] = new ChoiceModel(-258858752);
                    break;
                }
                case 386: {
                    this.models[386] = new ButtonModel(1116938496);
                    break;
                }
                case 184: {
                    this.models[184] = new ButtonModel(2022842624);
                    break;
                }
                case 430: {
                    this.models[430] = new ChoiceModel(1855136000);
                    break;
                }
                case 275: {
                    this.models[275] = new ButtonModel(-745398016);
                    break;
                }
                case 153: {
                    this.models[153] = new ChoiceModel(1502748928);
                    break;
                }
                case 169: {
                    this.models[169] = new LabelModel(1771184384);
                    break;
                }
                case 129: {
                    this.models[129] = new ChoiceModel(1100095744);
                    break;
                }
                case 506: {
                    this.models[506] = new ButtonModel(-1164762880);
                    break;
                }
                case 269: {
                    this.models[269] = new LabelModel(-846061312);
                    break;
                }
                case 413: {
                    this.models[413] = new ChoiceModel(1569923328);
                    break;
                }
                case 186: {
                    this.models[186] = new ChoiceModel(2056397056);
                    break;
                }
                case 244: {
                    this.models[244] = new LabelModel(-1265491712);
                    break;
                }
                case 216: {
                    this.models[216] = new TextfieldModel(-1735253760);
                    break;
                }
                case 408: {
                    this.models[408] = new ButtonModel(1486037248);
                    break;
                }
                case 400: {
                    this.models[400] = new ChoiceModel(1351819520);
                    break;
                }
                case 387: {
                    this.models[387] = new ButtonModel(1133715712);
                    break;
                }
                case 307: {
                    this.models[307] = new BaseListModel(-208527104, (MenuModel)this.getModel(1217536256));
                    break;
                }
                case 171: {
                    this.models[171] = new ButtonModel(1804738816);
                    break;
                }
                case 345: {
                    this.models[345] = new ChoiceModel(429072640);
                    break;
                }
                case 452: {
                    this.models[452] = new ChoiceModel(-2070732544);
                    break;
                }
                case 206: {
                    this.models[206] = new ButtonModel(-1903025920);
                    break;
                }
                case 178: {
                    this.models[178] = new ButtonModel(1922179328);
                    break;
                }
                case 300: {
                    this.models[300] = new ChoiceModel(-325967616);
                    break;
                }
                case 141: {
                    this.models[141] = new ListModel(1301422336);
                    break;
                }
                case 501: {
                    this.models[501] = new ListModel(-1248648960);
                    break;
                }
                case 526: {
                    this.models[526] = new BaseListModel(-829218560, null);
                    break;
                }
                case 225: {
                    this.models[225] = new ButtonModel(-1584258816);
                    break;
                }
                case 318: {
                    this.models[318] = new ButtonModel(-23977728);
                    break;
                }
                case 213: {
                    this.models[213] = new ChoiceModel(-1785585408);
                    break;
                }
                case 412: {
                    this.models[412] = new ChoiceModel(1553146112);
                    break;
                }
                case 398: {
                    this.models[398] = new ChoiceModel(1318265088);
                    break;
                }
                case 502: {
                    this.models[502] = new ButtonModel(-1231871744);
                    break;
                }
                case 427: {
                    this.models[427] = new BaseListModel(1804804352, null);
                    break;
                }
                case 489: {
                    this.models[489] = new ChoiceModel(-1449975552);
                    break;
                }
                case 309: {
                    this.models[309] = new ChoiceModel(-174972672);
                    break;
                }
                case 321: {
                    this.models[321] = new ButtonModel(26419456);
                    break;
                }
                case 388: {
                    this.models[388] = new ButtonModel(1150492928);
                    break;
                }
                case 163: {
                    this.models[163] = new ButtonModel(1670521088);
                    break;
                }
                case 231: {
                    this.models[231] = new ButtonModel(-1483595520);
                    break;
                }
                case 223: {
                    this.models[223] = new ButtonModel(-1617813248);
                    break;
                }
                case 389: {
                    this.models[389] = new ButtonModel(1167270144);
                    break;
                }
                case 503: {
                    this.models[503] = new ListModel(-1215094528);
                    break;
                }
                case 342: {
                    this.models[342] = new LabelModel(378740992);
                    break;
                }
                case 442: {
                    this.models[442] = new SpellerModel(2056462592);
                    break;
                }
                case 414: {
                    this.models[414] = new LabelModel(1586700544);
                    break;
                }
                case 527: {
                    this.models[527] = new BaseListModel(-812441344, null);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(-1382932224);
                    break;
                }
                case 222: {
                    this.models[222] = new ButtonModel(-1634590464);
                    break;
                }
                case 390: {
                    this.models[390] = new ButtonModel(1184047360);
                    break;
                }
                case 308: {
                    this.models[308] = new ChoiceModel(-191749888);
                    break;
                }
                case 453: {
                    this.models[453] = new ChoiceModel(-2053955328);
                    break;
                }
                case 233: {
                    this.models[233] = new ChoiceModel(-1450041088);
                    break;
                }
                case 251: {
                    this.models[251] = new BufferedChoiceModel(-1148051200);
                    break;
                }
                case 415: {
                    this.models[415] = new VirtualButtonModel(1603477760);
                    break;
                }
                case 314: {
                    this.models[314] = new MenuModel(-91086592);
                    break;
                }
                case 224: {
                    this.models[224] = new ButtonModel(-1601036032);
                    break;
                }
                case 324: {
                    this.models[324] = new BaseListModel(76751104, null);
                    break;
                }
                case 142: {
                    this.models[142] = new TooltipModel(1318199552);
                    break;
                }
                case 434: {
                    this.models[434] = new ButtonModel(1922244864);
                    break;
                }
                case 319: {
                    this.models[319] = new ButtonModel(-7200512);
                    break;
                }
                case 478: {
                    this.models[478] = new MenuModel(-1634524928);
                    break;
                }
                case 207: {
                    this.models[207] = new ChoiceModel(-1886248704);
                    break;
                }
                case 111: {
                    this.models[111] = new TextfieldModel(798105856);
                    break;
                }
                case 243: {
                    this.models[243] = new ChoiceModel(-1282268928);
                    break;
                }
                case 229: {
                    this.models[229] = new ChoiceModel(-1517149952);
                    break;
                }
                case 266: {
                    this.models[266] = new SpellerModel(-896392960);
                    break;
                }
                case 130: {
                    this.models[130] = new ChoiceModel(1116872960);
                    break;
                }
                case 399: {
                    this.models[399] = new BufferedChoiceModel(1335042304);
                    break;
                }
                case 221: {
                    this.models[221] = new ButtonModel(-1651367680);
                    break;
                }
                case 228: {
                    this.models[228] = new ButtonModel(-1533927168);
                    break;
                }
                case 443: {
                    this.models[443] = new TextfieldModel(2073239808);
                    break;
                }
                case 267: {
                    this.models[267] = new BaseListModel(-879615744, (MenuModel)this.getModel(-91086592));
                    break;
                }
                case 435: {
                    this.models[435] = new ButtonModel(1939022080);
                    break;
                }
                case 303: {
                    this.models[303] = new PropertyModel(-275635968);
                    break;
                }
                case 287: {
                    this.models[287] = new ButtonModel(-544071424);
                    break;
                }
                case 391: {
                    this.models[391] = new ButtonModel(1200824576);
                    break;
                }
                case 531: {
                    this.models[531] = new ButtonModel(-745332480);
                    break;
                }
                case 317: {
                    this.models[317] = new ChoiceModel(-40754944);
                    break;
                }
                case 200: {
                    this.models[200] = new ChoiceModel(-2003689216);
                    break;
                }
                case 409: {
                    this.models[409] = new ButtonModel(1502814464);
                    break;
                }
                case 395: {
                    this.models[395] = new LabelModel(1267933440);
                    break;
                }
                case 208: {
                    this.models[208] = new ChoiceModel(-1869471488);
                    break;
                }
                case 341: {
                    this.models[341] = new ChoiceModel(361963776);
                    break;
                }
                case 212: {
                    this.models[212] = new MetricsModel(-1802362624);
                    break;
                }
                case 411: {
                    this.models[411] = new ChoiceModel(1536368896);
                    break;
                }
                case 136: {
                    this.models[136] = new MenuModel(1217536256);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(848437504);
                    break;
                }
                case 210: {
                    this.models[210] = new ChoiceModel(-1835917056);
                    break;
                }
                case 381: {
                    this.models[381] = new ButtonModel(1033052416);
                    break;
                }
                case 454: {
                    this.models[454] = new ChoiceModel(-2037178112);
                    break;
                }
                case 487: {
                    this.models[487] = new ChoiceModel(-1483529984);
                    break;
                }
                case 262: {
                    this.models[262] = new BaseListModel(-963501824, null);
                    break;
                }
                case 528: {
                    this.models[528] = new BaseListModel(-795664128, null);
                    break;
                }
                case 406: {
                    this.models[406] = new ButtonModel(1452482816);
                    break;
                }
                case 240: {
                    this.models[240] = new ChoiceModel(-1332600576);
                    break;
                }
                case 416: {
                    this.models[416] = new ButtonModel(1620254976);
                    break;
                }
                case 209: {
                    this.models[209] = new ChoiceModel(-1852694272);
                    break;
                }
                case 436: {
                    this.models[436] = new SpellerModel(1955799296);
                    break;
                }
                case 343: {
                    this.models[343] = new ChoiceModel(395518208);
                    break;
                }
                case 423: {
                    this.models[423] = new ChoiceModel(1737695488);
                    break;
                }
                case 320: {
                    this.models[320] = new ButtonModel(9642240);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(2039619840);
                    break;
                }
                case 299: {
                    this.models[299] = new ChoiceModel(-342744832);
                    break;
                }
                case 323: {
                    this.models[323] = new ButtonModel(59973888);
                    break;
                }
                case 265: {
                    this.models[265] = new BaseListModel(-913170176, (MenuModel)this.getModel(831725824));
                    break;
                }
                case 218: {
                    this.models[218] = new ButtonModel(-1701699328);
                    break;
                }
                case 164: {
                    this.models[164] = new ChoiceModel(1687298304);
                    break;
                }
                case 424: {
                    this.models[424] = new ChoiceModel(1754472704);
                    break;
                }
                case 410: {
                    this.models[410] = new ChoiceModel(1519591680);
                    break;
                }
                case 437: {
                    this.models[437] = new BaseListModel(1972576512, (MenuModel)this.getModel(-1634524928));
                    break;
                }
                case 263: {
                    this.models[263] = new ButtonModel(-946724608);
                    break;
                }
                case 418: {
                    this.models[418] = new ButtonModel(1653809408);
                    break;
                }
                case 392: {
                    this.models[392] = new ButtonModel(1217601792);
                    break;
                }
                case 277: {
                    this.models[277] = new ButtonModel(-711843584);
                    break;
                }
                case 407: {
                    this.models[407] = new ButtonModel(1469260032);
                    break;
                }
                case 272: {
                    this.models[272] = new BaseListModel(-795729664, null);
                    break;
                }
                case 302: {
                    this.models[302] = new PropertyModel(-292413184);
                    break;
                }
                case 297: {
                    this.models[297] = new ChoiceModel(-376299264);
                    break;
                }
                case 444: {
                    this.models[444] = new ButtonModel(2090017024);
                    break;
                }
                case 268: {
                    this.models[268] = new ChoiceModel(-862838528);
                    break;
                }
                case 132: {
                    this.models[132] = new ChoiceModel(1150427392);
                    break;
                }
                case 204: {
                    this.models[204] = new LabelModel(-1936580352);
                    break;
                }
                case 352: {
                    this.models[352] = new ChoiceModel(546513152);
                    break;
                }
                case 177: {
                    this.models[177] = new ButtonModel(1905402112);
                    break;
                }
                case 145: {
                    this.models[145] = new ListModel(1368531200);
                    break;
                }
                case 172: {
                    this.models[172] = new ChoiceModel(1821516032);
                    break;
                }
                case 504: {
                    this.models[504] = new TextEditorDDModel(-1198317312);
                    break;
                }
                case 175: {
                    this.models[175] = new SlidingListModel(1871847680);
                    break;
                }
                case 327: {
                    this.models[327] = new BufferedChoiceModel(127082752);
                    break;
                }
                case 401: {
                    this.models[401] = new ButtonModel(1368596736);
                    break;
                }
                default: {
                    MessagingModelBank.getModelLogChannel().log(10000, "[MessagingModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public MessagingModelBank() {
        super(22, 532, 209);
        this.modelIDs = new int[209];
        this.modelIDs[0] = -661511936;
        this.modelIDs[1] = -1986912000;
        this.modelIDs[2] = 831725824;
        this.modelIDs[3] = -309190400;
        this.modelIDs[4] = 2039685376;
        this.modelIDs[5] = 2073174272;
        this.modelIDs[6] = 1402151168;
        this.modelIDs[7] = 2106794240;
        this.modelIDs[8] = 143859968;
        this.modelIDs[9] = -1500372736;
        this.modelIDs[10] = 1771249920;
        this.modelIDs[11] = -1567481600;
        this.modelIDs[12] = -1416421120;
        this.modelIDs[13] = 160637184;
        this.modelIDs[14] = 881991936;
        this.modelIDs[15] = -1181540096;
        this.modelIDs[16] = -1399643904;
        this.modelIDs[17] = 1989353728;
        this.modelIDs[18] = -829284096;
        this.modelIDs[19] = 1788027136;
        this.modelIDs[20] = -124641024;
        this.modelIDs[21] = -1701633792;
        this.modelIDs[22] = 747839744;
        this.modelIDs[23] = -2087509760;
        this.modelIDs[24] = 1754407168;
        this.modelIDs[25] = -1466818304;
        this.modelIDs[26] = 1704075520;
        this.modelIDs[27] = 1385373952;
        this.modelIDs[28] = 1049829632;
        this.modelIDs[29] = 1234313472;
        this.modelIDs[30] = -1752030976;
        this.modelIDs[31] = -929947392;
        this.modelIDs[32] = 1720852736;
        this.modelIDs[33] = 1435705600;
        this.modelIDs[34] = 1888624896;
        this.modelIDs[35] = -1382866688;
        this.modelIDs[36] = 915546368;
        this.modelIDs[37] = -1366089472;
        this.modelIDs[38] = -57532160;
        this.modelIDs[39] = -1819139840;
        this.modelIDs[40] = -1349312256;
        this.modelIDs[41] = 1737629952;
        this.modelIDs[42] = -1399709440;
        this.modelIDs[43] = 1603412224;
        this.modelIDs[44] = 1334976768;
        this.modelIDs[45] = 1066606848;
        this.modelIDs[46] = 1083384064;
        this.modelIDs[47] = 814883072;
        this.modelIDs[48] = -1332535040;
        this.modelIDs[49] = -678289152;
        this.modelIDs[50] = 1519526144;
        this.modelIDs[51] = -2104352512;
        this.modelIDs[52] = -1315757824;
        this.modelIDs[53] = -1298980608;
        this.modelIDs[54] = -1684856576;
        this.modelIDs[55] = 1418928384;
        this.modelIDs[56] = -1231937280;
        this.modelIDs[57] = -1064165120;
        this.modelIDs[58] = -225304320;
        this.modelIDs[59] = -778886912;
        this.modelIDs[60] = -1282203392;
        this.modelIDs[61] = -1114496768;
        this.modelIDs[62] = -1265426176;
        this.modelIDs[63] = 1301487872;
        this.modelIDs[64] = 563290368;
        this.modelIDs[65] = -812506880;
        this.modelIDs[66] = 831660288;
        this.modelIDs[67] = 1787961600;
        this.modelIDs[68] = 43196672;
        this.modelIDs[69] = -2087575296;
        this.modelIDs[70] = -1131273984;
        this.modelIDs[71] = 1100161280;
        this.modelIDs[72] = 1183981824;
        this.modelIDs[73] = 328409344;
        this.modelIDs[74] = 1133650176;
        this.modelIDs[75] = 529735936;
        this.modelIDs[76] = -762175232;
        this.modelIDs[77] = 93528320;
        this.modelIDs[78] = -258858752;
        this.modelIDs[79] = 1116938496;
        this.modelIDs[80] = 2022842624;
        this.modelIDs[81] = 1855136000;
        this.modelIDs[82] = -745398016;
        this.modelIDs[83] = 1502748928;
        this.modelIDs[84] = 1771184384;
        this.modelIDs[85] = 1100095744;
        this.modelIDs[86] = -1164762880;
        this.modelIDs[87] = -846061312;
        this.modelIDs[88] = 1569923328;
        this.modelIDs[89] = 2056397056;
        this.modelIDs[90] = -1265491712;
        this.modelIDs[91] = -1735253760;
        this.modelIDs[92] = 1486037248;
        this.modelIDs[93] = 1351819520;
        this.modelIDs[94] = 1133715712;
        this.modelIDs[95] = -208527104;
        this.modelIDs[96] = 1804738816;
        this.modelIDs[97] = 429072640;
        this.modelIDs[98] = -2070732544;
        this.modelIDs[99] = -1903025920;
        this.modelIDs[100] = 1922179328;
        this.modelIDs[101] = -325967616;
        this.modelIDs[102] = 1301422336;
        this.modelIDs[103] = -1248648960;
        this.modelIDs[104] = -829218560;
        this.modelIDs[105] = -1584258816;
        this.modelIDs[106] = -23977728;
        this.modelIDs[107] = -1785585408;
        this.modelIDs[108] = 1553146112;
        this.modelIDs[109] = 1318265088;
        this.modelIDs[110] = -1231871744;
        this.modelIDs[111] = 1804804352;
        this.modelIDs[112] = -1449975552;
        this.modelIDs[113] = -174972672;
        this.modelIDs[114] = 26419456;
        this.modelIDs[115] = 1150492928;
        this.modelIDs[116] = 1670521088;
        this.modelIDs[117] = -1483595520;
        this.modelIDs[118] = -1617813248;
        this.modelIDs[119] = 1167270144;
        this.modelIDs[120] = -1215094528;
        this.modelIDs[121] = 378740992;
        this.modelIDs[122] = 2056462592;
        this.modelIDs[123] = 1586700544;
        this.modelIDs[124] = -812441344;
        this.modelIDs[125] = -1382932224;
        this.modelIDs[126] = -1634590464;
        this.modelIDs[127] = 1184047360;
        this.modelIDs[128] = -191749888;
        this.modelIDs[129] = -2053955328;
        this.modelIDs[130] = -1450041088;
        this.modelIDs[131] = -1148051200;
        this.modelIDs[132] = 1603477760;
        this.modelIDs[133] = -91086592;
        this.modelIDs[134] = -1601036032;
        this.modelIDs[135] = 76751104;
        this.modelIDs[136] = 1318199552;
        this.modelIDs[137] = 1922244864;
        this.modelIDs[138] = -7200512;
        this.modelIDs[139] = -1634524928;
        this.modelIDs[140] = -1886248704;
        this.modelIDs[141] = 798105856;
        this.modelIDs[142] = -1282268928;
        this.modelIDs[143] = -1517149952;
        this.modelIDs[144] = -896392960;
        this.modelIDs[145] = 1116872960;
        this.modelIDs[146] = 1335042304;
        this.modelIDs[147] = -1651367680;
        this.modelIDs[148] = -1533927168;
        this.modelIDs[149] = 2073239808;
        this.modelIDs[150] = -879615744;
        this.modelIDs[151] = 1939022080;
        this.modelIDs[152] = -275635968;
        this.modelIDs[153] = -544071424;
        this.modelIDs[154] = 1200824576;
        this.modelIDs[155] = -745332480;
        this.modelIDs[156] = -40754944;
        this.modelIDs[157] = -2003689216;
        this.modelIDs[158] = 1502814464;
        this.modelIDs[159] = 1267933440;
        this.modelIDs[160] = -1869471488;
        this.modelIDs[161] = 361963776;
        this.modelIDs[162] = -1802362624;
        this.modelIDs[163] = 1536368896;
        this.modelIDs[164] = 1217536256;
        this.modelIDs[165] = 848437504;
        this.modelIDs[166] = -1835917056;
        this.modelIDs[167] = 1033052416;
        this.modelIDs[168] = -2037178112;
        this.modelIDs[169] = -1483529984;
        this.modelIDs[170] = -963501824;
        this.modelIDs[171] = -795664128;
        this.modelIDs[172] = 1452482816;
        this.modelIDs[173] = -1332600576;
        this.modelIDs[174] = 1620254976;
        this.modelIDs[175] = -1852694272;
        this.modelIDs[176] = 1955799296;
        this.modelIDs[177] = 395518208;
        this.modelIDs[178] = 1737695488;
        this.modelIDs[179] = 9642240;
        this.modelIDs[180] = 2039619840;
        this.modelIDs[181] = -342744832;
        this.modelIDs[182] = 59973888;
        this.modelIDs[183] = -913170176;
        this.modelIDs[184] = -1701699328;
        this.modelIDs[185] = 1687298304;
        this.modelIDs[186] = 1754472704;
        this.modelIDs[187] = 1519591680;
        this.modelIDs[188] = 1972576512;
        this.modelIDs[189] = -946724608;
        this.modelIDs[190] = 1653809408;
        this.modelIDs[191] = 1217601792;
        this.modelIDs[192] = -711843584;
        this.modelIDs[193] = 1469260032;
        this.modelIDs[194] = -795729664;
        this.modelIDs[195] = -292413184;
        this.modelIDs[196] = -376299264;
        this.modelIDs[197] = 2090017024;
        this.modelIDs[198] = -862838528;
        this.modelIDs[199] = 1150427392;
        this.modelIDs[200] = -1936580352;
        this.modelIDs[201] = 546513152;
        this.modelIDs[202] = 1905402112;
        this.modelIDs[203] = 1368531200;
        this.modelIDs[204] = 1821516032;
        this.modelIDs[205] = -1198317312;
        this.modelIDs[206] = 1871847680;
        this.modelIDs[207] = 127082752;
        this.modelIDs[208] = 1368596736;
    }
}

