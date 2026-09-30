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
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 280: {
                    this.models[280] = new ButtonModel(2200280);
                    break;
                }
                case 201: {
                    this.models[201] = new BufferedChoiceModel(2200201);
                    break;
                }
                case 369: {
                    this.models[369] = new MenuModel(2200369);
                    break;
                }
                case 301: {
                    this.models[301] = new ButtonModel(2200301);
                    break;
                }
                case 441: {
                    this.models[441] = new SpellerModel(2200441);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(2200187);
                    break;
                }
                case 403: {
                    this.models[403] = new ChoiceModel(2200403);
                    break;
                }
                case 445: {
                    this.models[445] = new ChoiceModel(2200445);
                    break;
                }
                case 328: {
                    this.models[328] = new BufferedChoiceModel(2200328);
                    break;
                }
                case 230: {
                    this.models[230] = new ButtonModel(2200230);
                    break;
                }
                case 425: {
                    this.models[425] = new ChoiceModel(2200425);
                    break;
                }
                case 226: {
                    this.models[226] = new ButtonModel(2200226);
                    break;
                }
                case 491: {
                    this.models[491] = new ButtonModel(2200491);
                    break;
                }
                case 329: {
                    this.models[329] = new LabelModel(2200329);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(2200116);
                    break;
                }
                case 505: {
                    this.models[505] = new ChoiceModel(2200505);
                    break;
                }
                case 492: {
                    this.models[492] = new SpellerModel(2200492);
                    break;
                }
                case 438: {
                    this.models[438] = new ChoiceModel(2200438);
                    break;
                }
                case 270: {
                    this.models[270] = new ChoiceModel(2200270);
                    break;
                }
                case 426: {
                    this.models[426] = new ButtonModel(2200426);
                    break;
                }
                case 312: {
                    this.models[312] = new BaseListModel(2200312, null);
                    break;
                }
                case 474: {
                    this.models[474] = new ChoiceModel(2200474);
                    break;
                }
                case 364: {
                    this.models[364] = new MatchspellerModel(2200364);
                    break;
                }
                case 451: {
                    this.models[451] = new LabelModel(2200451);
                    break;
                }
                case 168: {
                    this.models[168] = new ListModel(2200168);
                    break;
                }
                case 232: {
                    this.models[232] = new ChoiceModel(2200232);
                    break;
                }
                case 165: {
                    this.models[165] = new ButtonModel(2200165);
                    break;
                }
                case 402: {
                    this.models[402] = new VirtualButtonModel(2200402);
                    break;
                }
                case 382: {
                    this.models[382] = new ButtonModel(2200382);
                    break;
                }
                case 137: {
                    this.models[137] = new ChoiceModel(2200137);
                    break;
                }
                case 215: {
                    this.models[215] = new ChoiceModel(2200215);
                    break;
                }
                case 264: {
                    this.models[264] = new BaseListModel(2200264, null);
                    break;
                }
                case 166: {
                    this.models[166] = new BufferedChoiceModel(2200166);
                    break;
                }
                case 405: {
                    this.models[405] = new ButtonModel(2200405);
                    break;
                }
                case 176: {
                    this.models[176] = new TerminalModelContainer(2200176, 13, false);
                    break;
                }
                case 493: {
                    this.models[493] = new TiledListModel(2200493, (MenuModel)this.getModel(2200136));
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(2200118);
                    break;
                }
                case 494: {
                    this.models[494] = new ButtonModel(2200494);
                    break;
                }
                case 316: {
                    this.models[316] = new BaseListModel(2200316, null);
                    break;
                }
                case 211: {
                    this.models[211] = new ChoiceModel(2200211);
                    break;
                }
                case 495: {
                    this.models[495] = new TextEditorDDModel(2200495);
                    break;
                }
                case 167: {
                    this.models[167] = new ButtonModel(2200167);
                    break;
                }
                case 236: {
                    this.models[236] = new ChoiceModel(2200236);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(2200159);
                    break;
                }
                case 143: {
                    this.models[143] = new BufferedChoiceModel(2200143);
                    break;
                }
                case 383: {
                    this.models[383] = new ButtonModel(2200383);
                    break;
                }
                case 384: {
                    this.models[384] = new ButtonModel(2200384);
                    break;
                }
                case 112: {
                    this.models[112] = new SpellerModel(2200112);
                    break;
                }
                case 496: {
                    this.models[496] = new ButtonModel(2200496);
                    break;
                }
                case 279: {
                    this.models[279] = new LabelModel(2200279);
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(2200154);
                    break;
                }
                case 194: {
                    this.models[194] = new LabelModel(2200194);
                    break;
                }
                case 497: {
                    this.models[497] = new ButtonModel(2200497);
                    break;
                }
                case 498: {
                    this.models[498] = new ButtonModel(2200498);
                    break;
                }
                case 475: {
                    this.models[475] = new ChoiceModel(2200475);
                    break;
                }
                case 404: {
                    this.models[404] = new ButtonModel(2200404);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(2200246);
                    break;
                }
                case 256: {
                    this.models[256] = new ButtonModel(2200256);
                    break;
                }
                case 306: {
                    this.models[306] = new ChoiceModel(2200306);
                    break;
                }
                case 529: {
                    this.models[529] = new ChoiceModel(2200529);
                    break;
                }
                case 499: {
                    this.models[499] = new LabelModel(2200499);
                    break;
                }
                case 253: {
                    this.models[253] = new BaseListModel(2200253, null);
                    break;
                }
                case 500: {
                    this.models[500] = new TiledListModel(2200500, (MenuModel)this.getModel(2200314));
                    break;
                }
                case 397: {
                    this.models[397] = new ChoiceModel(2200397);
                    break;
                }
                case 353: {
                    this.models[353] = new ButtonModel(2200353);
                    break;
                }
                case 271: {
                    this.models[271] = new ButtonModel(2200271);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(2200113);
                    break;
                }
                case 170: {
                    this.models[170] = new BufferedChoiceModel(2200170);
                    break;
                }
                case 322: {
                    this.models[322] = new ButtonModel(2200322);
                    break;
                }
                case 195: {
                    this.models[195] = new ChoiceModel(2200195);
                    break;
                }
                case 252: {
                    this.models[252] = new BufferedChoiceModel(2200252);
                    break;
                }
                case 385: {
                    this.models[385] = new ButtonModel(2200385);
                    break;
                }
                case 134: {
                    this.models[134] = new ChoiceModel(2200134);
                    break;
                }
                case 339: {
                    this.models[339] = new LabelModel(2200339);
                    break;
                }
                case 131: {
                    this.models[131] = new ListModel(2200131);
                    break;
                }
                case 351: {
                    this.models[351] = new BufferedChoiceModel(2200351);
                    break;
                }
                case 274: {
                    this.models[274] = new BaseListModel(2200274, null);
                    break;
                }
                case 325: {
                    this.models[325] = new BaseListModel(2200325, null);
                    break;
                }
                case 304: {
                    this.models[304] = new ChoiceModel(2200304);
                    break;
                }
                case 386: {
                    this.models[386] = new ButtonModel(2200386);
                    break;
                }
                case 184: {
                    this.models[184] = new ButtonModel(2200184);
                    break;
                }
                case 430: {
                    this.models[430] = new ChoiceModel(2200430);
                    break;
                }
                case 275: {
                    this.models[275] = new ButtonModel(2200275);
                    break;
                }
                case 153: {
                    this.models[153] = new ChoiceModel(2200153);
                    break;
                }
                case 169: {
                    this.models[169] = new LabelModel(2200169);
                    break;
                }
                case 129: {
                    this.models[129] = new ChoiceModel(2200129);
                    break;
                }
                case 506: {
                    this.models[506] = new ButtonModel(2200506);
                    break;
                }
                case 269: {
                    this.models[269] = new LabelModel(2200269);
                    break;
                }
                case 413: {
                    this.models[413] = new ChoiceModel(2200413);
                    break;
                }
                case 186: {
                    this.models[186] = new ChoiceModel(2200186);
                    break;
                }
                case 244: {
                    this.models[244] = new LabelModel(2200244);
                    break;
                }
                case 216: {
                    this.models[216] = new TextfieldModel(2200216);
                    break;
                }
                case 408: {
                    this.models[408] = new ButtonModel(2200408);
                    break;
                }
                case 400: {
                    this.models[400] = new ChoiceModel(2200400);
                    break;
                }
                case 387: {
                    this.models[387] = new ButtonModel(2200387);
                    break;
                }
                case 307: {
                    this.models[307] = new BaseListModel(2200307, (MenuModel)this.getModel(2200136));
                    break;
                }
                case 171: {
                    this.models[171] = new ButtonModel(2200171);
                    break;
                }
                case 345: {
                    this.models[345] = new ChoiceModel(2200345);
                    break;
                }
                case 452: {
                    this.models[452] = new ChoiceModel(2200452);
                    break;
                }
                case 206: {
                    this.models[206] = new ButtonModel(2200206);
                    break;
                }
                case 178: {
                    this.models[178] = new ButtonModel(2200178);
                    break;
                }
                case 300: {
                    this.models[300] = new ChoiceModel(2200300);
                    break;
                }
                case 141: {
                    this.models[141] = new ListModel(2200141);
                    break;
                }
                case 501: {
                    this.models[501] = new ListModel(2200501);
                    break;
                }
                case 526: {
                    this.models[526] = new BaseListModel(2200526, null);
                    break;
                }
                case 225: {
                    this.models[225] = new ButtonModel(2200225);
                    break;
                }
                case 318: {
                    this.models[318] = new ButtonModel(2200318);
                    break;
                }
                case 213: {
                    this.models[213] = new ChoiceModel(2200213);
                    break;
                }
                case 412: {
                    this.models[412] = new ChoiceModel(2200412);
                    break;
                }
                case 398: {
                    this.models[398] = new ChoiceModel(2200398);
                    break;
                }
                case 502: {
                    this.models[502] = new ButtonModel(2200502);
                    break;
                }
                case 427: {
                    this.models[427] = new BaseListModel(2200427, null);
                    break;
                }
                case 489: {
                    this.models[489] = new ChoiceModel(2200489);
                    break;
                }
                case 309: {
                    this.models[309] = new ChoiceModel(2200309);
                    break;
                }
                case 321: {
                    this.models[321] = new ButtonModel(2200321);
                    break;
                }
                case 388: {
                    this.models[388] = new ButtonModel(2200388);
                    break;
                }
                case 163: {
                    this.models[163] = new ButtonModel(2200163);
                    break;
                }
                case 231: {
                    this.models[231] = new ButtonModel(2200231);
                    break;
                }
                case 223: {
                    this.models[223] = new ButtonModel(2200223);
                    break;
                }
                case 389: {
                    this.models[389] = new ButtonModel(2200389);
                    break;
                }
                case 503: {
                    this.models[503] = new ListModel(2200503);
                    break;
                }
                case 342: {
                    this.models[342] = new LabelModel(2200342);
                    break;
                }
                case 442: {
                    this.models[442] = new SpellerModel(2200442);
                    break;
                }
                case 414: {
                    this.models[414] = new LabelModel(2200414);
                    break;
                }
                case 527: {
                    this.models[527] = new BaseListModel(2200527, null);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(2200237);
                    break;
                }
                case 222: {
                    this.models[222] = new ButtonModel(2200222);
                    break;
                }
                case 390: {
                    this.models[390] = new ButtonModel(2200390);
                    break;
                }
                case 308: {
                    this.models[308] = new ChoiceModel(2200308);
                    break;
                }
                case 453: {
                    this.models[453] = new ChoiceModel(2200453);
                    break;
                }
                case 233: {
                    this.models[233] = new ChoiceModel(2200233);
                    break;
                }
                case 251: {
                    this.models[251] = new BufferedChoiceModel(2200251);
                    break;
                }
                case 415: {
                    this.models[415] = new VirtualButtonModel(2200415);
                    break;
                }
                case 314: {
                    this.models[314] = new MenuModel(2200314);
                    break;
                }
                case 224: {
                    this.models[224] = new ButtonModel(2200224);
                    break;
                }
                case 324: {
                    this.models[324] = new BaseListModel(2200324, null);
                    break;
                }
                case 142: {
                    this.models[142] = new TooltipModel(2200142);
                    break;
                }
                case 434: {
                    this.models[434] = new ButtonModel(2200434);
                    break;
                }
                case 319: {
                    this.models[319] = new ButtonModel(2200319);
                    break;
                }
                case 478: {
                    this.models[478] = new MenuModel(2200478);
                    break;
                }
                case 207: {
                    this.models[207] = new ChoiceModel(2200207);
                    break;
                }
                case 111: {
                    this.models[111] = new TextfieldModel(2200111);
                    break;
                }
                case 243: {
                    this.models[243] = new ChoiceModel(2200243);
                    break;
                }
                case 229: {
                    this.models[229] = new ChoiceModel(2200229);
                    break;
                }
                case 266: {
                    this.models[266] = new SpellerModel(2200266);
                    break;
                }
                case 130: {
                    this.models[130] = new ChoiceModel(2200130);
                    break;
                }
                case 399: {
                    this.models[399] = new BufferedChoiceModel(2200399);
                    break;
                }
                case 221: {
                    this.models[221] = new ButtonModel(2200221);
                    break;
                }
                case 228: {
                    this.models[228] = new ButtonModel(2200228);
                    break;
                }
                case 443: {
                    this.models[443] = new TextfieldModel(2200443);
                    break;
                }
                case 267: {
                    this.models[267] = new BaseListModel(2200267, (MenuModel)this.getModel(2200314));
                    break;
                }
                case 435: {
                    this.models[435] = new ButtonModel(2200435);
                    break;
                }
                case 303: {
                    this.models[303] = new PropertyModel(2200303);
                    break;
                }
                case 287: {
                    this.models[287] = new ButtonModel(2200287);
                    break;
                }
                case 391: {
                    this.models[391] = new ButtonModel(2200391);
                    break;
                }
                case 531: {
                    this.models[531] = new ButtonModel(2200531);
                    break;
                }
                case 317: {
                    this.models[317] = new ChoiceModel(2200317);
                    break;
                }
                case 200: {
                    this.models[200] = new ChoiceModel(2200200);
                    break;
                }
                case 409: {
                    this.models[409] = new ButtonModel(2200409);
                    break;
                }
                case 395: {
                    this.models[395] = new LabelModel(2200395);
                    break;
                }
                case 208: {
                    this.models[208] = new ChoiceModel(2200208);
                    break;
                }
                case 341: {
                    this.models[341] = new ChoiceModel(2200341);
                    break;
                }
                case 212: {
                    this.models[212] = new MetricsModel(2200212);
                    break;
                }
                case 411: {
                    this.models[411] = new ChoiceModel(2200411);
                    break;
                }
                case 136: {
                    this.models[136] = new MenuModel(2200136);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(2200114);
                    break;
                }
                case 210: {
                    this.models[210] = new ChoiceModel(0x219292);
                    break;
                }
                case 381: {
                    this.models[381] = new ButtonModel(2200381);
                    break;
                }
                case 454: {
                    this.models[454] = new ChoiceModel(2200454);
                    break;
                }
                case 487: {
                    this.models[487] = new ChoiceModel(2200487);
                    break;
                }
                case 262: {
                    this.models[262] = new BaseListModel(2200262, null);
                    break;
                }
                case 528: {
                    this.models[528] = new BaseListModel(2200528, null);
                    break;
                }
                case 406: {
                    this.models[406] = new ButtonModel(2200406);
                    break;
                }
                case 240: {
                    this.models[240] = new ChoiceModel(2200240);
                    break;
                }
                case 416: {
                    this.models[416] = new ButtonModel(2200416);
                    break;
                }
                case 209: {
                    this.models[209] = new ChoiceModel(0x219291);
                    break;
                }
                case 436: {
                    this.models[436] = new SpellerModel(2200436);
                    break;
                }
                case 343: {
                    this.models[343] = new ChoiceModel(2200343);
                    break;
                }
                case 423: {
                    this.models[423] = new ChoiceModel(2200423);
                    break;
                }
                case 320: {
                    this.models[320] = new ButtonModel(2200320);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(2200185);
                    break;
                }
                case 299: {
                    this.models[299] = new ChoiceModel(2200299);
                    break;
                }
                case 323: {
                    this.models[323] = new ButtonModel(2200323);
                    break;
                }
                case 265: {
                    this.models[265] = new BaseListModel(2200265, (MenuModel)this.getModel(2200369));
                    break;
                }
                case 218: {
                    this.models[218] = new ButtonModel(2200218);
                    break;
                }
                case 164: {
                    this.models[164] = new ChoiceModel(2200164);
                    break;
                }
                case 424: {
                    this.models[424] = new ChoiceModel(2200424);
                    break;
                }
                case 410: {
                    this.models[410] = new ChoiceModel(2200410);
                    break;
                }
                case 437: {
                    this.models[437] = new BaseListModel(2200437, (MenuModel)this.getModel(2200478));
                    break;
                }
                case 263: {
                    this.models[263] = new ButtonModel(2200263);
                    break;
                }
                case 418: {
                    this.models[418] = new ButtonModel(2200418);
                    break;
                }
                case 392: {
                    this.models[392] = new ButtonModel(2200392);
                    break;
                }
                case 277: {
                    this.models[277] = new ButtonModel(2200277);
                    break;
                }
                case 407: {
                    this.models[407] = new ButtonModel(2200407);
                    break;
                }
                case 272: {
                    this.models[272] = new BaseListModel(2200272, null);
                    break;
                }
                case 302: {
                    this.models[302] = new PropertyModel(2200302);
                    break;
                }
                case 297: {
                    this.models[297] = new ChoiceModel(2200297);
                    break;
                }
                case 444: {
                    this.models[444] = new ButtonModel(2200444);
                    break;
                }
                case 268: {
                    this.models[268] = new ChoiceModel(2200268);
                    break;
                }
                case 132: {
                    this.models[132] = new ChoiceModel(2200132);
                    break;
                }
                case 204: {
                    this.models[204] = new LabelModel(2200204);
                    break;
                }
                case 352: {
                    this.models[352] = new ChoiceModel(2200352);
                    break;
                }
                case 177: {
                    this.models[177] = new ButtonModel(2200177);
                    break;
                }
                case 145: {
                    this.models[145] = new ListModel(2200145);
                    break;
                }
                case 172: {
                    this.models[172] = new ChoiceModel(2200172);
                    break;
                }
                case 504: {
                    this.models[504] = new TextEditorDDModel(2200504);
                    break;
                }
                case 175: {
                    this.models[175] = new SlidingListModel(2200175);
                    break;
                }
                case 327: {
                    this.models[327] = new BufferedChoiceModel(2200327);
                    break;
                }
                case 401: {
                    this.models[401] = new ButtonModel(2200401);
                    break;
                }
                default: {
                    MessagingModelBank.getModelLogChannel().log(10000, "[MessagingModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public MessagingModelBank() {
        super(22, 532, 209);
        this.modelIDs = new int[209];
        this.modelIDs[0] = 2200280;
        this.modelIDs[1] = 2200201;
        this.modelIDs[2] = 2200369;
        this.modelIDs[3] = 2200301;
        this.modelIDs[4] = 2200441;
        this.modelIDs[5] = 2200187;
        this.modelIDs[6] = 2200403;
        this.modelIDs[7] = 2200445;
        this.modelIDs[8] = 2200328;
        this.modelIDs[9] = 2200230;
        this.modelIDs[10] = 2200425;
        this.modelIDs[11] = 2200226;
        this.modelIDs[12] = 2200491;
        this.modelIDs[13] = 2200329;
        this.modelIDs[14] = 2200116;
        this.modelIDs[15] = 2200505;
        this.modelIDs[16] = 2200492;
        this.modelIDs[17] = 2200438;
        this.modelIDs[18] = 2200270;
        this.modelIDs[19] = 2200426;
        this.modelIDs[20] = 2200312;
        this.modelIDs[21] = 2200474;
        this.modelIDs[22] = 2200364;
        this.modelIDs[23] = 2200451;
        this.modelIDs[24] = 2200168;
        this.modelIDs[25] = 2200232;
        this.modelIDs[26] = 2200165;
        this.modelIDs[27] = 2200402;
        this.modelIDs[28] = 2200382;
        this.modelIDs[29] = 2200137;
        this.modelIDs[30] = 2200215;
        this.modelIDs[31] = 2200264;
        this.modelIDs[32] = 2200166;
        this.modelIDs[33] = 2200405;
        this.modelIDs[34] = 2200176;
        this.modelIDs[35] = 2200493;
        this.modelIDs[36] = 2200118;
        this.modelIDs[37] = 2200494;
        this.modelIDs[38] = 2200316;
        this.modelIDs[39] = 2200211;
        this.modelIDs[40] = 2200495;
        this.modelIDs[41] = 2200167;
        this.modelIDs[42] = 2200236;
        this.modelIDs[43] = 2200159;
        this.modelIDs[44] = 2200143;
        this.modelIDs[45] = 2200383;
        this.modelIDs[46] = 2200384;
        this.modelIDs[47] = 2200112;
        this.modelIDs[48] = 2200496;
        this.modelIDs[49] = 2200279;
        this.modelIDs[50] = 2200154;
        this.modelIDs[51] = 2200194;
        this.modelIDs[52] = 2200497;
        this.modelIDs[53] = 2200498;
        this.modelIDs[54] = 2200475;
        this.modelIDs[55] = 2200404;
        this.modelIDs[56] = 2200246;
        this.modelIDs[57] = 2200256;
        this.modelIDs[58] = 2200306;
        this.modelIDs[59] = 2200529;
        this.modelIDs[60] = 2200499;
        this.modelIDs[61] = 2200253;
        this.modelIDs[62] = 2200500;
        this.modelIDs[63] = 2200397;
        this.modelIDs[64] = 2200353;
        this.modelIDs[65] = 2200271;
        this.modelIDs[66] = 2200113;
        this.modelIDs[67] = 2200170;
        this.modelIDs[68] = 2200322;
        this.modelIDs[69] = 2200195;
        this.modelIDs[70] = 2200252;
        this.modelIDs[71] = 2200385;
        this.modelIDs[72] = 2200134;
        this.modelIDs[73] = 2200339;
        this.modelIDs[74] = 2200131;
        this.modelIDs[75] = 2200351;
        this.modelIDs[76] = 2200274;
        this.modelIDs[77] = 2200325;
        this.modelIDs[78] = 2200304;
        this.modelIDs[79] = 2200386;
        this.modelIDs[80] = 2200184;
        this.modelIDs[81] = 2200430;
        this.modelIDs[82] = 2200275;
        this.modelIDs[83] = 2200153;
        this.modelIDs[84] = 2200169;
        this.modelIDs[85] = 2200129;
        this.modelIDs[86] = 2200506;
        this.modelIDs[87] = 2200269;
        this.modelIDs[88] = 2200413;
        this.modelIDs[89] = 2200186;
        this.modelIDs[90] = 2200244;
        this.modelIDs[91] = 2200216;
        this.modelIDs[92] = 2200408;
        this.modelIDs[93] = 2200400;
        this.modelIDs[94] = 2200387;
        this.modelIDs[95] = 2200307;
        this.modelIDs[96] = 2200171;
        this.modelIDs[97] = 2200345;
        this.modelIDs[98] = 2200452;
        this.modelIDs[99] = 2200206;
        this.modelIDs[100] = 2200178;
        this.modelIDs[101] = 2200300;
        this.modelIDs[102] = 2200141;
        this.modelIDs[103] = 2200501;
        this.modelIDs[104] = 2200526;
        this.modelIDs[105] = 2200225;
        this.modelIDs[106] = 2200318;
        this.modelIDs[107] = 2200213;
        this.modelIDs[108] = 2200412;
        this.modelIDs[109] = 2200398;
        this.modelIDs[110] = 2200502;
        this.modelIDs[111] = 2200427;
        this.modelIDs[112] = 2200489;
        this.modelIDs[113] = 2200309;
        this.modelIDs[114] = 2200321;
        this.modelIDs[115] = 2200388;
        this.modelIDs[116] = 2200163;
        this.modelIDs[117] = 2200231;
        this.modelIDs[118] = 2200223;
        this.modelIDs[119] = 2200389;
        this.modelIDs[120] = 2200503;
        this.modelIDs[121] = 2200342;
        this.modelIDs[122] = 2200442;
        this.modelIDs[123] = 2200414;
        this.modelIDs[124] = 2200527;
        this.modelIDs[125] = 2200237;
        this.modelIDs[126] = 2200222;
        this.modelIDs[127] = 2200390;
        this.modelIDs[128] = 2200308;
        this.modelIDs[129] = 2200453;
        this.modelIDs[130] = 2200233;
        this.modelIDs[131] = 2200251;
        this.modelIDs[132] = 2200415;
        this.modelIDs[133] = 2200314;
        this.modelIDs[134] = 2200224;
        this.modelIDs[135] = 2200324;
        this.modelIDs[136] = 2200142;
        this.modelIDs[137] = 2200434;
        this.modelIDs[138] = 2200319;
        this.modelIDs[139] = 2200478;
        this.modelIDs[140] = 2200207;
        this.modelIDs[141] = 2200111;
        this.modelIDs[142] = 2200243;
        this.modelIDs[143] = 2200229;
        this.modelIDs[144] = 2200266;
        this.modelIDs[145] = 2200130;
        this.modelIDs[146] = 2200399;
        this.modelIDs[147] = 2200221;
        this.modelIDs[148] = 2200228;
        this.modelIDs[149] = 2200443;
        this.modelIDs[150] = 2200267;
        this.modelIDs[151] = 2200435;
        this.modelIDs[152] = 2200303;
        this.modelIDs[153] = 2200287;
        this.modelIDs[154] = 2200391;
        this.modelIDs[155] = 2200531;
        this.modelIDs[156] = 2200317;
        this.modelIDs[157] = 2200200;
        this.modelIDs[158] = 2200409;
        this.modelIDs[159] = 2200395;
        this.modelIDs[160] = 2200208;
        this.modelIDs[161] = 2200341;
        this.modelIDs[162] = 2200212;
        this.modelIDs[163] = 2200411;
        this.modelIDs[164] = 2200136;
        this.modelIDs[165] = 2200114;
        this.modelIDs[166] = 0x219292;
        this.modelIDs[167] = 2200381;
        this.modelIDs[168] = 2200454;
        this.modelIDs[169] = 2200487;
        this.modelIDs[170] = 2200262;
        this.modelIDs[171] = 2200528;
        this.modelIDs[172] = 2200406;
        this.modelIDs[173] = 2200240;
        this.modelIDs[174] = 2200416;
        this.modelIDs[175] = 0x219291;
        this.modelIDs[176] = 2200436;
        this.modelIDs[177] = 2200343;
        this.modelIDs[178] = 2200423;
        this.modelIDs[179] = 2200320;
        this.modelIDs[180] = 2200185;
        this.modelIDs[181] = 2200299;
        this.modelIDs[182] = 2200323;
        this.modelIDs[183] = 2200265;
        this.modelIDs[184] = 2200218;
        this.modelIDs[185] = 2200164;
        this.modelIDs[186] = 2200424;
        this.modelIDs[187] = 2200410;
        this.modelIDs[188] = 2200437;
        this.modelIDs[189] = 2200263;
        this.modelIDs[190] = 2200418;
        this.modelIDs[191] = 2200392;
        this.modelIDs[192] = 2200277;
        this.modelIDs[193] = 2200407;
        this.modelIDs[194] = 2200272;
        this.modelIDs[195] = 2200302;
        this.modelIDs[196] = 2200297;
        this.modelIDs[197] = 2200444;
        this.modelIDs[198] = 2200268;
        this.modelIDs[199] = 2200132;
        this.modelIDs[200] = 2200204;
        this.modelIDs[201] = 2200352;
        this.modelIDs[202] = 2200177;
        this.modelIDs[203] = 2200145;
        this.modelIDs[204] = 2200172;
        this.modelIDs[205] = 2200504;
        this.modelIDs[206] = 2200175;
        this.modelIDs[207] = 2200327;
        this.modelIDs[208] = 2200401;
    }
}

