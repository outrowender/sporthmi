/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BrowserModel;
import de.audi.atip.hmi.model.BufferedChoiceModel;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.property.PropertyModel;
import de.audi.atip.model.ICoreEarlyAppsModelBank;
import de.audi.atip.model.IEvoEarlyAppsModelBank;

public class EarlyAppsModelBank
extends AbstractModelBank
implements ICoreEarlyAppsModelBank,
IEvoEarlyAppsModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 488: {
                    this.models[488] = new ChoiceModel(135077888);
                    break;
                }
                case 740: {
                    this.models[740] = new ChoiceModel(68034560);
                    break;
                }
                case 248: {
                    this.models[248] = new ChoiceModel(403447808);
                    break;
                }
                case 246: {
                    this.models[246] = new ChoiceModel(369893376);
                    break;
                }
                case 283: {
                    this.models[283] = new ChoiceModel(990650368);
                    break;
                }
                case 351: {
                    this.models[351] = new ChoiceModel(2131501056);
                    break;
                }
                case 211: {
                    this.models[211] = new ChoiceModel(-217374720);
                    break;
                }
                case 656: {
                    this.models[656] = new ButtonModel(-1341317120);
                    break;
                }
                case 466: {
                    this.models[466] = new ChoiceModel(-234086400);
                    break;
                }
                case 305: {
                    this.models[305] = new ChoiceModel(1359749120);
                    break;
                }
                case 657: {
                    this.models[657] = new ButtonModel(-1324539904);
                    break;
                }
                case 270: {
                    this.models[270] = new ChoiceModel(772546560);
                    break;
                }
                case 741: {
                    this.models[741] = new ChoiceModel(84811776);
                    break;
                }
                case 194: {
                    this.models[194] = new ChoiceModel(-502587392);
                    break;
                }
                case 157: {
                    this.models[157] = new ChoiceModel(-1123344384);
                    break;
                }
                case 517: {
                    this.models[517] = new ChoiceModel(621617152);
                    break;
                }
                case 173: {
                    this.models[173] = new ChoiceModel(-854908928);
                    break;
                }
                case 620: {
                    this.models[620] = new ChoiceModel(-1945296896);
                    break;
                }
                case 742: {
                    this.models[742] = new ChoiceModel(101588992);
                    break;
                }
                case 172: {
                    this.models[172] = new LabelModel(-871686144);
                    break;
                }
                case 349: {
                    this.models[349] = new ChoiceModel(2097946624);
                    break;
                }
                case 156: {
                    this.models[156] = new ChoiceModel(-1140121600);
                    break;
                }
                case 107: {
                    this.models[107] = new ChoiceModel(-1962205184);
                    break;
                }
                case 671: {
                    this.models[671] = new ChoiceModel(-1089658880);
                    break;
                }
                case 398: {
                    this.models[398] = new MenuModel(-1374937088);
                    break;
                }
                case 399: {
                    this.models[399] = new ChoiceModel(-1358159872);
                    break;
                }
                case 672: {
                    this.models[672] = new ChoiceModel(-1072881664);
                    break;
                }
                case 381: {
                    this.models[381] = new ChoiceModel(-1660149760);
                    break;
                }
                case 216: {
                    this.models[216] = new RangeModel(-133488640);
                    break;
                }
                case 385: {
                    this.models[385] = new ChoiceModel(-1593040896);
                    break;
                }
                case 615: {
                    this.models[615] = new ChoiceModel(-2029182976);
                    break;
                }
                case 571: {
                    this.models[571] = new ChoiceModel(1527586816);
                    break;
                }
                case 222: {
                    this.models[222] = new RangeModel(-32825344);
                    break;
                }
                case 277: {
                    this.models[277] = new ChoiceModel(889987072);
                    break;
                }
                case 408: {
                    this.models[408] = new ChoiceModel(-1207164928);
                    break;
                }
                case 673: {
                    this.models[673] = new ChoiceModel(-1056104448);
                    break;
                }
                case 552: {
                    this.models[552] = new ChoiceModel(1208819712);
                    break;
                }
                case 295: {
                    this.models[295] = new ChoiceModel(1191976960);
                    break;
                }
                case 360: {
                    this.models[360] = new ChoiceModel(-2012471296);
                    break;
                }
                case 176: {
                    this.models[176] = new ChoiceModel(-804577280);
                    break;
                }
                case 361: {
                    this.models[361] = new ChoiceModel(-1995694080);
                    break;
                }
                case 243: {
                    this.models[243] = new ChoiceModel(319561728);
                    break;
                }
                case 559: {
                    this.models[559] = new MetricsModel(1326260224);
                    break;
                }
                case 529: {
                    this.models[529] = new ChoiceModel(822943744);
                    break;
                }
                case 518: {
                    this.models[518] = new ChoiceModel(638394368);
                    break;
                }
                case 97: {
                    this.models[97] = new ChoiceModel(-2129977344);
                    break;
                }
                case 119: {
                    this.models[119] = new ChoiceModel(-1760878592);
                    break;
                }
                case 203: {
                    this.models[203] = new RangeModel(-351592448);
                    break;
                }
                case 535: {
                    this.models[535] = new ChoiceModel(923607040);
                    break;
                }
                case 513: {
                    this.models[513] = new RangeModel(554508288);
                    break;
                }
                case 409: {
                    this.models[409] = new MetricsModel(-1190387712);
                    break;
                }
                case 470: {
                    this.models[470] = new ChoiceModel(-166977536);
                    break;
                }
                case 514: {
                    this.models[514] = new RangeModel(0x220D2000);
                    break;
                }
                case 254: {
                    this.models[254] = new ChoiceModel(504111104);
                    break;
                }
                case 572: {
                    this.models[572] = new ChoiceModel(1544364032);
                    break;
                }
                case 532: {
                    this.models[532] = new ChoiceModel(873275392);
                    break;
                }
                case 282: {
                    this.models[282] = new RangeModel(973873152);
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(-1777655808);
                    break;
                }
                case 127: {
                    this.models[127] = new ChoiceModel(-1626660864);
                    break;
                }
                case 326: {
                    this.models[326] = new ChoiceModel(1712070656);
                    break;
                }
                case 337: {
                    this.models[337] = new ChoiceModel(1896620032);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(-1811210240);
                    break;
                }
                case 269: {
                    this.models[269] = new ChoiceModel(755769344);
                    break;
                }
                case 479: {
                    this.models[479] = new ChoiceModel(-15982592);
                    break;
                }
                case 503: {
                    this.models[503] = new ChoiceModel(386736128);
                    break;
                }
                case 238: {
                    this.models[238] = new ChoiceModel(235675648);
                    break;
                }
                case 485: {
                    this.models[485] = new ChoiceModel(84746240);
                    break;
                }
                case 134: {
                    this.models[134] = new ChoiceModel(-1509220352);
                    break;
                }
                case 624: {
                    this.models[624] = new ChoiceModel(-1878188032);
                    break;
                }
                case 200: {
                    this.models[200] = new ChoiceModel(-401924096);
                    break;
                }
                case 410: {
                    this.models[410] = new ChoiceModel(-1173610496);
                    break;
                }
                case 237: {
                    this.models[237] = new ChoiceModel(218898432);
                    break;
                }
                case 188: {
                    this.models[188] = new ButtonModel(-603250688);
                    break;
                }
                case 221: {
                    this.models[221] = new RangeModel(-49602560);
                    break;
                }
                case 195: {
                    this.models[195] = new ChoiceModel(-485810176);
                    break;
                }
                case 389: {
                    this.models[389] = new ChoiceModel(-1525932032);
                    break;
                }
                case 649: {
                    this.models[649] = new ButtonModel(-1458757632);
                    break;
                }
                case 382: {
                    this.models[382] = new ChoiceModel(-1643372544);
                    break;
                }
                case 653: {
                    this.models[653] = new ChoiceModel(-1391648768);
                    break;
                }
                case 411: {
                    this.models[411] = new MetricsModel(-1156833280);
                    break;
                }
                case 209: {
                    this.models[209] = new RangeModel(-250929152);
                    break;
                }
                case 302: {
                    this.models[302] = new BaseListModel(1309417472, null);
                    break;
                }
                case 435: {
                    this.models[435] = new ChoiceModel(-754180096);
                    break;
                }
                case 281: {
                    this.models[281] = new ChoiceModel(957095936);
                    break;
                }
                case 674: {
                    this.models[674] = new ChoiceModel(-1039327232);
                    break;
                }
                case 158: {
                    this.models[158] = new ButtonModel(-1106567168);
                    break;
                }
                case 573: {
                    this.models[573] = new ChoiceModel(1561141248);
                    break;
                }
                case 412: {
                    this.models[412] = new ChoiceModel(-1140056064);
                    break;
                }
                case 353: {
                    this.models[353] = new ChoiceModel(-2129911808);
                    break;
                }
                case 519: {
                    this.models[519] = new ChoiceModel(655171584);
                    break;
                }
                case 515: {
                    this.models[515] = new RangeModel(588062720);
                    break;
                }
                case 267: {
                    this.models[267] = new ChoiceModel(722214912);
                    break;
                }
                case 413: {
                    this.models[413] = new ChoiceModel(-1123278848);
                    break;
                }
                case 536: {
                    this.models[536] = new ChoiceModel(940384256);
                    break;
                }
                case 334: {
                    this.models[334] = new ChoiceModel(1846288384);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(-1861541888);
                    break;
                }
                case 348: {
                    this.models[348] = new ChoiceModel(2081169408);
                    break;
                }
                case 548: {
                    this.models[548] = new MetricsModel(1141710848);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(-2146754560);
                    break;
                }
                case 362: {
                    this.models[362] = new ChoiceModel(-1978916864);
                    break;
                }
                case 125: {
                    this.models[125] = new ChoiceModel(-1660215296);
                    break;
                }
                case 754: {
                    this.models[754] = new ButtonModel(302915584);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(-1056235520);
                    break;
                }
                case 448: {
                    this.models[448] = new ChoiceModel(-536076288);
                    break;
                }
                case 675: {
                    this.models[675] = new ChoiceModel(-1022550016);
                    break;
                }
                case 676: {
                    this.models[676] = new ButtonModel(-1005772800);
                    break;
                }
                case 291: {
                    this.models[291] = new ChoiceModel(1124868096);
                    break;
                }
                case 436: {
                    this.models[436] = new ChoiceModel(-737402880);
                    break;
                }
                case 677: {
                    this.models[677] = new ChoiceModel(-988995584);
                    break;
                }
                case 303: {
                    this.models[303] = new ChoiceModel(1326194688);
                    break;
                }
                case 285: {
                    this.models[285] = new RangeModel(1024204800);
                    break;
                }
                case 414: {
                    this.models[414] = new ChoiceModel(-1106501632);
                    break;
                }
                case 678: {
                    this.models[678] = new ChoiceModel(-972218368);
                    break;
                }
                case 274: {
                    this.models[274] = new RangeModel(839655424);
                    break;
                }
                case 491: {
                    this.models[491] = new ChoiceModel(185409536);
                    break;
                }
                case 354: {
                    this.models[354] = new ChoiceModel(-2113134592);
                    break;
                }
                case 554: {
                    this.models[554] = new ChoiceModel(1242374144);
                    break;
                }
                case 284: {
                    this.models[284] = new ChoiceModel(1007427584);
                    break;
                }
                case 120: {
                    this.models[120] = new ChoiceModel(-1744101376);
                    break;
                }
                case 679: {
                    this.models[679] = new ChoiceModel(-955441152);
                    break;
                }
                case 124: {
                    this.models[124] = new ChoiceModel(-1676992512);
                    break;
                }
                case 198: {
                    this.models[198] = new ChoiceModel(-435478528);
                    break;
                }
                case 213: {
                    this.models[213] = new ChoiceModel(-183820288);
                    break;
                }
                case 511: {
                    this.models[511] = new ChoiceModel(520953856);
                    break;
                }
                case 189: {
                    this.models[189] = new ButtonModel(-586473472);
                    break;
                }
                case 392: {
                    this.models[392] = new ButtonModel(-1475600384);
                    break;
                }
                case 363: {
                    this.models[363] = new MetricsModel(-1962139648);
                    break;
                }
                case 220: {
                    this.models[220] = new RangeModel(-66379776);
                    break;
                }
                case 437: {
                    this.models[437] = new ChoiceModel(-720625664);
                    break;
                }
                case 467: {
                    this.models[467] = new ChoiceModel(-217309184);
                    break;
                }
                case 343: {
                    this.models[343] = new ButtonModel(1997283328);
                    break;
                }
                case 271: {
                    this.models[271] = new ChoiceModel(789323776);
                    break;
                }
                case 167: {
                    this.models[167] = new RangeModel(-955572224);
                    break;
                }
                case 415: {
                    this.models[415] = new ChoiceModel(-1089724416);
                    break;
                }
                case 320: {
                    this.models[320] = new ButtonModel(1611407360);
                    break;
                }
                case 378: {
                    this.models[378] = new MetricsModel(-1710481408);
                    break;
                }
                case 228: {
                    this.models[228] = new ChoiceModel(67903488);
                    break;
                }
                case 390: {
                    this.models[390] = new MenuModel(-1509154816);
                    break;
                }
                case 680: {
                    this.models[680] = new ChoiceModel(-938663936);
                    break;
                }
                case 364: {
                    this.models[364] = new MetricsModel(-1945362432);
                    break;
                }
                case 323: {
                    this.models[323] = new ChoiceModel(1661739008);
                    break;
                }
                case 197: {
                    this.models[197] = new ButtonModel(-452255744);
                    break;
                }
                case 510: {
                    this.models[510] = new ChoiceModel(504176640);
                    break;
                }
                case 658: {
                    this.models[658] = new ButtonModel(-1307762688);
                    break;
                }
                case 312: {
                    this.models[312] = new ChoiceModel(1477189632);
                    break;
                }
                case 227: {
                    this.models[227] = new MetricsModel(51126272);
                    break;
                }
                case 397: {
                    this.models[397] = new ChoiceModel(-1391714304);
                    break;
                }
                case 616: {
                    this.models[616] = new ChoiceModel(-2012405760);
                    break;
                }
                case 416: {
                    this.models[416] = new ChoiceModel(-1072947200);
                    break;
                }
                case 391: {
                    this.models[391] = new ChoiceModel(-1492377600);
                    break;
                }
                case 449: {
                    this.models[449] = new ChoiceModel(-519299072);
                    break;
                }
                case 346: {
                    this.models[346] = new ChoiceModel(2047614976);
                    break;
                }
                case 555: {
                    this.models[555] = new ChoiceModel(1259151360);
                    break;
                }
                case 373: {
                    this.models[373] = new ChoiceModel(-1794367488);
                    break;
                }
                case 171: {
                    this.models[171] = new LabelModel(-888463360);
                    break;
                }
                case 193: {
                    this.models[193] = new ButtonModel(-519364608);
                    break;
                }
                case 93: {
                    this.models[93] = new RangeModel(2097881088);
                    break;
                }
                case 417: {
                    this.models[417] = new ChoiceModel(-1056169984);
                    break;
                }
                case 486: {
                    this.models[486] = new ChoiceModel(101523456);
                    break;
                }
                case 577: {
                    this.models[577] = new ChoiceModel(1628250112);
                    break;
                }
                case 527: {
                    this.models[527] = new ChoiceModel(789389312);
                    break;
                }
                case 383: {
                    this.models[383] = new ChoiceModel(-1626595328);
                    break;
                }
                case 126: {
                    this.models[126] = new ChoiceModel(-1643438080);
                    break;
                }
                case 681: {
                    this.models[681] = new ChoiceModel(-921886720);
                    break;
                }
                case 418: {
                    this.models[418] = new ChoiceModel(-1039392768);
                    break;
                }
                case 492: {
                    this.models[492] = new ChoiceModel(202186752);
                    break;
                }
                case 379: {
                    this.models[379] = new MetricsModel(-1693704192);
                    break;
                }
                case 627: {
                    this.models[627] = new ChoiceModel(-1827856384);
                    break;
                }
                case 152: {
                    this.models[152] = new ChoiceModel(-1207230464);
                    break;
                }
                case 102: {
                    this.models[102] = new ButtonModel(-2046091264);
                    break;
                }
                case 465: {
                    this.models[465] = new ChoiceModel(-250863616);
                    break;
                }
                case 537: {
                    this.models[537] = new ChoiceModel(957161472);
                    break;
                }
                case 682: {
                    this.models[682] = new ChoiceModel(-905109504);
                    break;
                }
                case 336: {
                    this.models[336] = new PropertyModel(1879842816);
                    break;
                }
                case 242: {
                    this.models[242] = new ChoiceModel(302784512);
                    break;
                }
                case 580: {
                    this.models[580] = new ChoiceModel(1678581760);
                    break;
                }
                case 419: {
                    this.models[419] = new ChoiceModel(-1022615552);
                    break;
                }
                case 683: {
                    this.models[683] = new ChoiceModel(-888332288);
                    break;
                }
                case 121: {
                    this.models[121] = new ChoiceModel(-1727324160);
                    break;
                }
                case 98: {
                    this.models[98] = new RangeModel(-2113200128);
                    break;
                }
                case 667: {
                    this.models[667] = new LabelModel(-1156767744);
                    break;
                }
                case 617: {
                    this.models[617] = new ChoiceModel(-1995628544);
                    break;
                }
                case 208: {
                    this.models[208] = new ChoiceModel(-267706368);
                    break;
                }
                case 136: {
                    this.models[136] = new ChoiceModel(-1475665920);
                    break;
                }
                case 560: {
                    this.models[560] = new ChoiceModel(1343037440);
                    break;
                }
                case 387: {
                    this.models[387] = new ChoiceModel(-1559486464);
                    break;
                }
                case 169: {
                    this.models[169] = new LabelModel(-922017792);
                    break;
                }
                case 247: {
                    this.models[247] = new ChoiceModel(386670592);
                    break;
                }
                case 684: {
                    this.models[684] = new ChoiceModel(-871555072);
                    break;
                }
                case 630: {
                    this.models[630] = new ChoiceModel(-1777524736);
                    break;
                }
                case 394: {
                    this.models[394] = new ButtonModel(-1442045952);
                    break;
                }
                case 139: {
                    this.models[139] = new BufferedChoiceModel(-1425334272);
                    break;
                }
                case 201: {
                    this.models[201] = new ChoiceModel(-385146880);
                    break;
                }
                case 226: {
                    this.models[226] = new RangeModel(0x20C2000);
                    break;
                }
                case 395: {
                    this.models[395] = new ButtonModel(-1425268736);
                    break;
                }
                case 232: {
                    this.models[232] = new RangeModel(135012352);
                    break;
                }
                case 365: {
                    this.models[365] = new ChoiceModel(-1928585216);
                    break;
                }
                case 292: {
                    this.models[292] = new BaseListModel(1141645312, null);
                    break;
                }
                case 191: {
                    this.models[191] = new ButtonModel(-552919040);
                    break;
                }
                case 648: {
                    this.models[648] = new MetricsModel(-1475534848);
                    break;
                }
                case 339: {
                    this.models[339] = new RangeModel(1930174464);
                    break;
                }
                case 255: {
                    this.models[255] = new ChoiceModel(520888320);
                    break;
                }
                case 181: {
                    this.models[181] = new ChoiceModel(-720691200);
                    break;
                }
                case 607: {
                    this.models[607] = new ChoiceModel(2131566592);
                    break;
                }
                case 230: {
                    this.models[230] = new MetricsModel(101457920);
                    break;
                }
                case 135: {
                    this.models[135] = new ChoiceModel(-1492443136);
                    break;
                }
                case 212: {
                    this.models[212] = new ChoiceModel(-200597504);
                    break;
                }
                case 229: {
                    this.models[229] = new RangeModel(84680704);
                    break;
                }
                case 743: {
                    this.models[743] = new ChoiceModel(118366208);
                    break;
                }
                case 293: {
                    this.models[293] = new BaseListModel(1158422528, null);
                    break;
                }
                case 170: {
                    this.models[170] = new LabelModel(-905240576);
                    break;
                }
                case 581: {
                    this.models[581] = new ChoiceModel(1695358976);
                    break;
                }
                case 335: {
                    this.models[335] = new ChoiceModel(1863065600);
                    break;
                }
                case 582: {
                    this.models[582] = new ChoiceModel(1712136192);
                    break;
                }
                case 344: {
                    this.models[344] = new ButtonModel(2014060544);
                    break;
                }
                case 352: {
                    this.models[352] = new ChoiceModel(-2146689024);
                    break;
                }
                case 420: {
                    this.models[420] = new MetricsModel(-1005838336);
                    break;
                }
                case 685: {
                    this.models[685] = new ChoiceModel(-854777856);
                    break;
                }
                case 313: {
                    this.models[313] = new ChoiceModel(1493966848);
                    break;
                }
                case 206: {
                    this.models[206] = new ChoiceModel(-301260800);
                    break;
                }
                case 421: {
                    this.models[421] = new ChoiceModel(-989061120);
                    break;
                }
                case 245: {
                    this.models[245] = new ChoiceModel(353116160);
                    break;
                }
                case 538: {
                    this.models[538] = new ChoiceModel(973938688);
                    break;
                }
                case 631: {
                    this.models[631] = new ChoiceModel(-1760747520);
                    break;
                }
                case 704: {
                    this.models[704] = new ChoiceModel(-536010752);
                    break;
                }
                case 289: {
                    this.models[289] = new ChoiceModel(1091313664);
                    break;
                }
                case 266: {
                    this.models[266] = new ChoiceModel(705437696);
                    break;
                }
                case 236: {
                    this.models[236] = new ChoiceModel(0xC0C2000);
                    break;
                }
                case 686: {
                    this.models[686] = new MetricsModel(-838000640);
                    break;
                }
                case 687: {
                    this.models[687] = new ChoiceModel(-821223424);
                    break;
                }
                case 516: {
                    this.models[516] = new RangeModel(604839936);
                    break;
                }
                case 299: {
                    this.models[299] = new ChoiceModel(1259085824);
                    break;
                }
                case 205: {
                    this.models[205] = new RangeModel(-318038016);
                    break;
                }
                case 286: {
                    this.models[286] = new ChoiceModel(1040982016);
                    break;
                }
                case 94: {
                    this.models[94] = new ChoiceModel(2114658304);
                    break;
                }
                case 732: {
                    this.models[732] = new ChoiceModel(-66248704);
                    break;
                }
                case 493: {
                    this.models[493] = new ChoiceModel(0xD0D2000);
                    break;
                }
                case 272: {
                    this.models[272] = new ChoiceModel(806100992);
                    break;
                }
                case 478: {
                    this.models[478] = new ChoiceModel(-32759808);
                    break;
                }
                case 112: {
                    this.models[112] = new ChoiceModel(-1878319104);
                    break;
                }
                case 556: {
                    this.models[556] = new ChoiceModel(1275928576);
                    break;
                }
                case 333: {
                    this.models[333] = new ChoiceModel(1829511168);
                    break;
                }
                case 366: {
                    this.models[366] = new ChoiceModel(-1911808000);
                    break;
                }
                case 422: {
                    this.models[422] = new ChoiceModel(-972283904);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(-2096422912);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(-1995759616);
                    break;
                }
                case 474: {
                    this.models[474] = new ChoiceModel(-99868672);
                    break;
                }
                case 249: {
                    this.models[249] = new ChoiceModel(420225024);
                    break;
                }
                case 359: {
                    this.models[359] = new ChoiceModel(-2029248512);
                    break;
                }
                case 744: {
                    this.models[744] = new ChoiceModel(135143424);
                    break;
                }
                case 745: {
                    this.models[745] = new ChoiceModel(151920640);
                    break;
                }
                case 146: {
                    this.models[146] = new ChoiceModel(-1307893760);
                    break;
                }
                case 177: {
                    this.models[177] = new ChoiceModel(-787800064);
                    break;
                }
                case 110: {
                    this.models[110] = new ChoiceModel(-1911873536);
                    break;
                }
                case 401: {
                    this.models[401] = new ChoiceModel(-1324605440);
                    break;
                }
                case 746: {
                    this.models[746] = new ChoiceModel(168697856);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(-687136768);
                    break;
                }
                case 393: {
                    this.models[393] = new ChoiceModel(-1458823168);
                    break;
                }
                case 174: {
                    this.models[174] = new ChoiceModel(-838131712);
                    break;
                }
                case 122: {
                    this.models[122] = new ChoiceModel(-1710546944);
                    break;
                }
                case 558: {
                    this.models[558] = new ButtonModel(1309483008);
                    break;
                }
                case 178: {
                    this.models[178] = new ChoiceModel(-771022848);
                    break;
                }
                case 520: {
                    this.models[520] = new ChoiceModel(671948800);
                    break;
                }
                case 160: {
                    this.models[160] = new ChoiceModel(-1073012736);
                    break;
                }
                case 533: {
                    this.models[533] = new ChoiceModel(890052608);
                    break;
                }
                case 747: {
                    this.models[747] = new ChoiceModel(185475072);
                    break;
                }
                case 187: {
                    this.models[187] = new ButtonModel(-620027904);
                    break;
                }
                case 253: {
                    this.models[253] = new ChoiceModel(487333888);
                    break;
                }
                case 438: {
                    this.models[438] = new ChoiceModel(-703848448);
                    break;
                }
                case 714: {
                    this.models[714] = new ChoiceModel(-368238592);
                    break;
                }
                case 507: {
                    this.models[507] = new ChoiceModel(453844992);
                    break;
                }
                case 483: {
                    this.models[483] = new ChoiceModel(51191808);
                    break;
                }
                case 505: {
                    this.models[505] = new ChoiceModel(420290560);
                    break;
                }
                case 634: {
                    this.models[634] = new ChoiceModel(-1710415872);
                    break;
                }
                case 367: {
                    this.models[367] = new ChoiceModel(-1895030784);
                    break;
                }
                case 311: {
                    this.models[311] = new ChoiceModel(1460412416);
                    break;
                }
                case 585: {
                    this.models[585] = new ChoiceModel(1762467840);
                    break;
                }
                case 199: {
                    this.models[199] = new ChoiceModel(-418701312);
                    break;
                }
                case 439: {
                    this.models[439] = new LabelModel(-687071232);
                    break;
                }
                case 688: {
                    this.models[688] = new MetricsModel(-804446208);
                    break;
                }
                case 388: {
                    this.models[388] = new ChoiceModel(-1542709248);
                    break;
                }
                case 241: {
                    this.models[241] = new ChoiceModel(286007296);
                    break;
                }
                case 231: {
                    this.models[231] = new ChoiceModel(118235136);
                    break;
                }
                case 423: {
                    this.models[423] = new ChoiceModel(-955506688);
                    break;
                }
                case 290: {
                    this.models[290] = new ChoiceModel(1108090880);
                    break;
                }
                case 424: {
                    this.models[424] = new ChoiceModel(-938729472);
                    break;
                }
                case 586: {
                    this.models[586] = new ChoiceModel(1779245056);
                    break;
                }
                case 475: {
                    this.models[475] = new LabelModel(-83091456);
                    break;
                }
                case 175: {
                    this.models[175] = new ChoiceModel(-821354496);
                    break;
                }
                case 425: {
                    this.models[425] = new MetricsModel(-921952256);
                    break;
                }
                case 217: {
                    this.models[217] = new RangeModel(-116711424);
                    break;
                }
                case 487: {
                    this.models[487] = new ChoiceModel(118300672);
                    break;
                }
                case 252: {
                    this.models[252] = new ChoiceModel(470556672);
                    break;
                }
                case 557: {
                    this.models[557] = new ChoiceModel(1292705792);
                    break;
                }
                case 689: {
                    this.models[689] = new ChoiceModel(-787668992);
                    break;
                }
                case 308: {
                    this.models[308] = new BaseListModel(1410080768, null);
                    break;
                }
                case 273: {
                    this.models[273] = new ChoiceModel(822878208);
                    break;
                }
                case 275: {
                    this.models[275] = new ChoiceModel(856432640);
                    break;
                }
                case 659: {
                    this.models[659] = new ButtonModel(-1290985472);
                    break;
                }
                case 117: {
                    this.models[117] = new ChoiceModel(-1794433024);
                    break;
                }
                case 330: {
                    this.models[330] = new ButtonModel(1779179520);
                    break;
                }
                case 233: {
                    this.models[233] = new MetricsModel(151789568);
                    break;
                }
                case 539: {
                    this.models[539] = new ChoiceModel(990715904);
                    break;
                }
                case 588: {
                    this.models[588] = new ChoiceModel(1812799488);
                    break;
                }
                case 184: {
                    this.models[184] = new ChoiceModel(-670359552);
                    break;
                }
                case 508: {
                    this.models[508] = new ChoiceModel(470622208);
                    break;
                }
                case 143: {
                    this.models[143] = new ChoiceModel(-1358225408);
                    break;
                }
                case 131: {
                    this.models[131] = new ChoiceModel(-1559552000);
                    break;
                }
                case 298: {
                    this.models[298] = new ChoiceModel(1242308608);
                    break;
                }
                case 748: {
                    this.models[748] = new ChoiceModel(202252288);
                    break;
                }
                case 356: {
                    this.models[356] = new ChoiceModel(-2079580160);
                    break;
                }
                case 471: {
                    this.models[471] = new ChoiceModel(-150200320);
                    break;
                }
                case 756: {
                    this.models[756] = new ChoiceModel(336470016);
                    break;
                }
                case 690: {
                    this.models[690] = new ChoiceModel(-770891776);
                    break;
                }
                case 749: {
                    this.models[749] = new ChoiceModel(219029504);
                    break;
                }
                case 426: {
                    this.models[426] = new ChoiceModel(-905175040);
                    break;
                }
                case 218: {
                    this.models[218] = new RangeModel(-99934208);
                    break;
                }
                case 651: {
                    this.models[651] = new ButtonModel(-1425203200);
                    break;
                }
                case 619: {
                    this.models[619] = new ChoiceModel(-1962074112);
                    break;
                }
                case 235: {
                    this.models[235] = new ChoiceModel(185344000);
                    break;
                }
                case 141: {
                    this.models[141] = new ChoiceModel(-1391779840);
                    break;
                }
                case 691: {
                    this.models[691] = new ChoiceModel(-754114560);
                    break;
                }
                case 480: {
                    this.models[480] = new ChoiceModel(860160);
                    break;
                }
                case 739: {
                    this.models[739] = new ChoiceModel(51257344);
                    break;
                }
                case 315: {
                    this.models[315] = new ChoiceModel(1527521280);
                    break;
                }
                case 692: {
                    this.models[692] = new ChoiceModel(-737337344);
                    break;
                }
                case 608: {
                    this.models[608] = new ChoiceModel(-2146623488);
                    break;
                }
                case 693: {
                    this.models[693] = new ChoiceModel(-720560128);
                    break;
                }
                case 592: {
                    this.models[592] = new ChoiceModel(1879908352);
                    break;
                }
                case 694: {
                    this.models[694] = new MetricsModel(-703782912);
                    break;
                }
                case 403: {
                    this.models[403] = new ChoiceModel(-1291051008);
                    break;
                }
                case 755: {
                    this.models[755] = new ButtonModel(319692800);
                    break;
                }
                case 310: {
                    this.models[310] = new ChoiceModel(1443635200);
                    break;
                }
                case 338: {
                    this.models[338] = new ChoiceModel(1913397248);
                    break;
                }
                case 427: {
                    this.models[427] = new MetricsModel(-888397824);
                    break;
                }
                case 695: {
                    this.models[695] = new ChoiceModel(-687005696);
                    break;
                }
                case 428: {
                    this.models[428] = new MetricsModel(-871620608);
                    break;
                }
                case 314: {
                    this.models[314] = new ChoiceModel(1510744064);
                    break;
                }
                case 562: {
                    this.models[562] = new ChoiceModel(1376591872);
                    break;
                }
                case 636: {
                    this.models[636] = new ChoiceModel(-1676861440);
                    break;
                }
                case 280: {
                    this.models[280] = new ChoiceModel(940318720);
                    break;
                }
                case 637: {
                    this.models[637] = new ChoiceModel(-1660084224);
                    break;
                }
                case 696: {
                    this.models[696] = new ChoiceModel(-670228480);
                    break;
                }
                case 130: {
                    this.models[130] = new ChoiceModel(-1576329216);
                    break;
                }
                case 750: {
                    this.models[750] = new ChoiceModel(0xE0E2000);
                    break;
                }
                case 402: {
                    this.models[402] = new ChoiceModel(-1307828224);
                    break;
                }
                case 476: {
                    this.models[476] = new ChoiceModel(-66314240);
                    break;
                }
                case 219: {
                    this.models[219] = new RangeModel(-83156992);
                    break;
                }
                case 215: {
                    this.models[215] = new RangeModel(-150265856);
                    break;
                }
                case 697: {
                    this.models[697] = new ChoiceModel(-653451264);
                    break;
                }
                case 265: {
                    this.models[265] = new ChoiceModel(688660480);
                    break;
                }
                case 472: {
                    this.models[472] = new ChoiceModel(-133423104);
                    break;
                }
                case 324: {
                    this.models[324] = new ChoiceModel(1678516224);
                    break;
                }
                case 140: {
                    this.models[140] = new BufferedListModel(-1408557056);
                    break;
                }
                case 468: {
                    this.models[468] = new ChoiceModel(-200531968);
                    break;
                }
                case 660: {
                    this.models[660] = new ButtonModel(-1274208256);
                    break;
                }
                case 224: {
                    this.models[224] = new MetricsModel(794624);
                    break;
                }
                case 368: {
                    this.models[368] = new ChoiceModel(-1878253568);
                    break;
                }
                case 155: {
                    this.models[155] = new ChoiceModel(-1156898816);
                    break;
                }
                case 661: {
                    this.models[661] = new ButtonModel(-1257431040);
                    break;
                }
                case 664: {
                    this.models[664] = new ChoiceModel(-1207099392);
                    break;
                }
                case 144: {
                    this.models[144] = new ChoiceModel(-1341448192);
                    break;
                }
                case 489: {
                    this.models[489] = new ChoiceModel(151855104);
                    break;
                }
                case 665: {
                    this.models[665] = new ChoiceModel(-1190322176);
                    break;
                }
                case 504: {
                    this.models[504] = new ChoiceModel(403513344);
                    break;
                }
                case 190: {
                    this.models[190] = new BrowserModel(-569696256);
                    break;
                }
                case 400: {
                    this.models[400] = new RangeModel(-1341382656);
                    break;
                }
                case 182: {
                    this.models[182] = new ChoiceModel(-703913984);
                    break;
                }
                case 137: {
                    this.models[137] = new ChoiceModel(-1458888704);
                    break;
                }
                case 214: {
                    this.models[214] = new ChoiceModel(-167043072);
                    break;
                }
                case 698: {
                    this.models[698] = new ChoiceModel(-636674048);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(-1827987456);
                    break;
                }
                case 369: {
                    this.models[369] = new ChoiceModel(-1861476352);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(-972349440);
                    break;
                }
                case 699: {
                    this.models[699] = new ChoiceModel(-619896832);
                    break;
                }
                case 751: {
                    this.models[751] = new ChoiceModel(252583936);
                    break;
                }
                case 594: {
                    this.models[594] = new ChoiceModel(1913462784);
                    break;
                }
                case 250: {
                    this.models[250] = new ChoiceModel(437002240);
                    break;
                }
                case 406: {
                    this.models[406] = new ChoiceModel(-1240719360);
                    break;
                }
                case 114: {
                    this.models[114] = new ChoiceModel(-1844764672);
                    break;
                }
                case 540: {
                    this.models[540] = new ChoiceModel(1007493120);
                    break;
                }
                case 639: {
                    this.models[639] = new ChoiceModel(-1626529792);
                    break;
                }
                case 700: {
                    this.models[700] = new ChoiceModel(-603119616);
                    break;
                }
                case 268: {
                    this.models[268] = new ChoiceModel(0x2C0C2000);
                    break;
                }
                case 481: {
                    this.models[481] = new ChoiceModel(17637376);
                    break;
                }
                case 640: {
                    this.models[640] = new ChoiceModel(-1609752576);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(-653582336);
                    break;
                }
                case 541: {
                    this.models[541] = new ChoiceModel(1024270336);
                    break;
                }
                case 662: {
                    this.models[662] = new ButtonModel(-1240653824);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(-2062868480);
                    break;
                }
                case 701: {
                    this.models[701] = new ChoiceModel(-586342400);
                    break;
                }
                case 258: {
                    this.models[258] = new ChoiceModel(0x220C2000);
                    break;
                }
                case 340: {
                    this.models[340] = new RangeModel(1946951680);
                    break;
                }
                case 133: {
                    this.models[133] = new ChoiceModel(-1525997568);
                    break;
                }
                case 523: {
                    this.models[523] = new ChoiceModel(722280448);
                    break;
                }
                case 477: {
                    this.models[477] = new ChoiceModel(-49537024);
                    break;
                }
                case 429: {
                    this.models[429] = new ChoiceModel(-854843392);
                    break;
                }
                case 375: {
                    this.models[375] = new ChoiceModel(-1760813056);
                    break;
                }
                case 370: {
                    this.models[370] = new MetricsModel(-1844699136);
                    break;
                }
                case 553: {
                    this.models[553] = new ChoiceModel(1225596928);
                    break;
                }
                case 613: {
                    this.models[613] = new ChoiceModel(-2062737408);
                    break;
                }
                case 542: {
                    this.models[542] = new ChoiceModel(1041047552);
                    break;
                }
                case 304: {
                    this.models[304] = new ChoiceModel(1342971904);
                    break;
                }
                case 264: {
                    this.models[264] = new ChoiceModel(671883264);
                    break;
                }
                case 192: {
                    this.models[192] = new ButtonModel(-536141824);
                    break;
                }
                case 204: {
                    this.models[204] = new ChoiceModel(-334815232);
                    break;
                }
                case 357: {
                    this.models[357] = new ChoiceModel(-2062802944);
                    break;
                }
                case 287: {
                    this.models[287] = new ChoiceModel(1057759232);
                    break;
                }
                case 702: {
                    this.models[702] = new ChoiceModel(-569565184);
                    break;
                }
                case 543: {
                    this.models[543] = new ChoiceModel(1057824768);
                    break;
                }
                case 490: {
                    this.models[490] = new ChoiceModel(168632320);
                    break;
                }
                case 108: {
                    this.models[108] = new ChoiceModel(-1945427968);
                    break;
                }
                case 614: {
                    this.models[614] = new ChoiceModel(-2045960192);
                    break;
                }
                case 168: {
                    this.models[168] = new LabelModel(-938795008);
                    break;
                }
                case 109: {
                    this.models[109] = new ChoiceModel(-1928650752);
                    break;
                }
                case 345: {
                    this.models[345] = new ChoiceModel(2030837760);
                    break;
                }
                case 132: {
                    this.models[132] = new ChoiceModel(-1542774784);
                    break;
                }
                case 239: {
                    this.models[239] = new ChoiceModel(252452864);
                    break;
                }
                case 703: {
                    this.models[703] = new MetricsModel(-552787968);
                    break;
                }
                case 341: {
                    this.models[341] = new RangeModel(1963728896);
                    break;
                }
                case 598: {
                    this.models[598] = new ChoiceModel(1980571648);
                    break;
                }
                case 652: {
                    this.models[652] = new ButtonModel(-1408425984);
                    break;
                }
                case 261: {
                    this.models[261] = new ChoiceModel(621551616);
                    break;
                }
                case 509: {
                    this.models[509] = new ChoiceModel(487399424);
                    break;
                }
                case 709: {
                    this.models[709] = new ChoiceModel(-452124672);
                    break;
                }
                case 297: {
                    this.models[297] = new ChoiceModel(1225531392);
                    break;
                }
                case 430: {
                    this.models[430] = new ChoiceModel(-838066176);
                    break;
                }
                case 234: {
                    this.models[234] = new ChoiceModel(168566784);
                    break;
                }
                case 95: {
                    this.models[95] = new RangeModel(2131435520);
                    break;
                }
                case 276: {
                    this.models[276] = new ChoiceModel(873209856);
                    break;
                }
                case 260: {
                    this.models[260] = new ChoiceModel(604774400);
                    break;
                }
                case 599: {
                    this.models[599] = new ChoiceModel(1997348864);
                    break;
                }
                case 251: {
                    this.models[251] = new ChoiceModel(453779456);
                    break;
                }
                case 288: {
                    this.models[288] = new RangeModel(1074536448);
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(-1173676032);
                    break;
                }
                case 263: {
                    this.models[263] = new ChoiceModel(655106048);
                    break;
                }
                case 643: {
                    this.models[643] = new ChoiceModel(-1559420928);
                    break;
                }
                case 300: {
                    this.models[300] = new ChoiceModel(1275863040);
                    break;
                }
                case 705: {
                    this.models[705] = new ChoiceModel(-519233536);
                    break;
                }
                case 484: {
                    this.models[484] = new ChoiceModel(67969024);
                    break;
                }
                case 431: {
                    this.models[431] = new ChoiceModel(-821288960);
                    break;
                }
                case 374: {
                    this.models[374] = new ChoiceModel(-1777590272);
                    break;
                }
                case 262: {
                    this.models[262] = new ButtonModel(638328832);
                    break;
                }
                case 223: {
                    this.models[223] = new RangeModel(-16048128);
                    break;
                }
                case 225: {
                    this.models[225] = new ChoiceModel(17571840);
                    break;
                }
                case 138: {
                    this.models[138] = new RangeModel(-1442111488);
                    break;
                }
                case 296: {
                    this.models[296] = new ChoiceModel(1208754176);
                    break;
                }
                case 196: {
                    this.models[196] = new ChoiceModel(-469032960);
                    break;
                }
                case 396: {
                    this.models[396] = new ButtonModel(-1408491520);
                    break;
                }
                case 129: {
                    this.models[129] = new ChoiceModel(-1593106432);
                    break;
                }
                case 454: {
                    this.models[454] = new ChoiceModel(-435412992);
                    break;
                }
                case 404: {
                    this.models[404] = new ButtonModel(-1274273792);
                    break;
                }
                case 153: {
                    this.models[153] = new ButtonModel(-1190453248);
                    break;
                }
                case 600: {
                    this.models[600] = new ChoiceModel(2014126080);
                    break;
                }
                case 440: {
                    this.models[440] = new ChoiceModel(-670294016);
                    break;
                }
                case 752: {
                    this.models[752] = new ChoiceModel(269361152);
                    break;
                }
                case 240: {
                    this.models[240] = new ChoiceModel(269230080);
                    break;
                }
                case 376: {
                    this.models[376] = new ChoiceModel(-1744035840);
                    break;
                }
                case 432: {
                    this.models[432] = new ChoiceModel(-804511744);
                    break;
                }
                case 706: {
                    this.models[706] = new ChoiceModel(-502456320);
                    break;
                }
                case 601: {
                    this.models[601] = new ChoiceModel(2030903296);
                    break;
                }
                case 103: {
                    this.models[103] = new ChoiceModel(-2029314048);
                    break;
                }
                case 259: {
                    this.models[259] = new ChoiceModel(587997184);
                    break;
                }
                case 279: {
                    this.models[279] = new RangeModel(923541504);
                    break;
                }
                case 278: {
                    this.models[278] = new ChoiceModel(906764288);
                    break;
                }
                case 544: {
                    this.models[544] = new MetricsModel(1074601984);
                    break;
                }
                case 494: {
                    this.models[494] = new ChoiceModel(235741184);
                    break;
                }
                case 100: {
                    this.models[100] = new RangeModel(-2079645696);
                    break;
                }
                case 561: {
                    this.models[561] = new ChoiceModel(1359814656);
                    break;
                }
                case 180: {
                    this.models[180] = new ChoiceModel(-737468416);
                    break;
                }
                case 301: {
                    this.models[301] = new ChoiceModel(1292640256);
                    break;
                }
                case 602: {
                    this.models[602] = new ChoiceModel(2047680512);
                    break;
                }
                case 179: {
                    this.models[179] = new ChoiceModel(-754245632);
                    break;
                }
                case 545: {
                    this.models[545] = new ChoiceModel(1091379200);
                    break;
                }
                case 207: {
                    this.models[207] = new RangeModel(-284483584);
                    break;
                }
                case 433: {
                    this.models[433] = new ChoiceModel(-787734528);
                    break;
                }
                case 244: {
                    this.models[244] = new ChoiceModel(336338944);
                    break;
                }
                case 707: {
                    this.models[707] = new ChoiceModel(-485679104);
                    break;
                }
                case 603: {
                    this.models[603] = new ChoiceModel(2064457728);
                    break;
                }
                case 434: {
                    this.models[434] = new ChoiceModel(-770957312);
                    break;
                }
                case 358: {
                    this.models[358] = new ChoiceModel(-2046025728);
                    break;
                }
                case 202: {
                    this.models[202] = new ChoiceModel(-368369664);
                    break;
                }
                case 708: {
                    this.models[708] = new ChoiceModel(-468901888);
                    break;
                }
                case 715: {
                    this.models[715] = new ChoiceModel(-351461376);
                    break;
                }
                case 306: {
                    this.models[306] = new ChoiceModel(1376526336);
                    break;
                }
                case 668: {
                    this.models[668] = new LabelModel(-1139990528);
                    break;
                }
                case 512: {
                    this.models[512] = new ChoiceModel(0x200D2000);
                    break;
                }
                case 342: {
                    this.models[342] = new RangeModel(1980506112);
                    break;
                }
                case 405: {
                    this.models[405] = new ChoiceModel(-1257496576);
                    break;
                }
                case 350: {
                    this.models[350] = new ChoiceModel(2114723840);
                    break;
                }
                case 546: {
                    this.models[546] = new ChoiceModel(1108156416);
                    break;
                }
                case 256: {
                    this.models[256] = new ChoiceModel(0x200C2000);
                    break;
                }
                case 386: {
                    this.models[386] = new ChoiceModel(-1576263680);
                    break;
                }
                case 455: {
                    this.models[455] = new ChoiceModel(-418635776);
                    break;
                }
                case 186: {
                    this.models[186] = new ChoiceModel(-636805120);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(-1978982400);
                    break;
                }
                case 307: {
                    this.models[307] = new ChoiceModel(1393303552);
                    break;
                }
                case 712: {
                    this.models[712] = new ChoiceModel(-401793024);
                    break;
                }
                case 371: {
                    this.models[371] = new MetricsModel(-1827921920);
                    break;
                }
                case 210: {
                    this.models[210] = new ChoiceModel(-234151936);
                    break;
                }
                case 528: {
                    this.models[528] = new ChoiceModel(806166528);
                    break;
                }
                case 257: {
                    this.models[257] = new ChoiceModel(554442752);
                    break;
                }
                case 663: {
                    this.models[663] = new ButtonModel(-1223876608);
                    break;
                }
                case 710: {
                    this.models[710] = new ChoiceModel(-435347456);
                    break;
                }
                case 128: {
                    this.models[128] = new ChoiceModel(-1609883648);
                    break;
                }
                case 711: {
                    this.models[711] = new ChoiceModel(-418570240);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(-2012536832);
                    break;
                }
                case 506: {
                    this.models[506] = new ChoiceModel(437067776);
                    break;
                }
                case 441: {
                    this.models[441] = new ChoiceModel(-653516800);
                    break;
                }
                case 380: {
                    this.models[380] = new MetricsModel(-1676926976);
                    break;
                }
                case 713: {
                    this.models[713] = new MetricsModel(-385015808);
                    break;
                }
                case 372: {
                    this.models[372] = new ChoiceModel(-1811144704);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(-1089789952);
                    break;
                }
                case 473: {
                    this.models[473] = new ChoiceModel(-116645888);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(-1693769728);
                    break;
                }
                case 377: {
                    this.models[377] = new ChoiceModel(-1727258624);
                    break;
                }
                case 384: {
                    this.models[384] = new ChoiceModel(-1609818112);
                    break;
                }
                case 111: {
                    this.models[111] = new ChoiceModel(-1895096320);
                    break;
                }
                case 753: {
                    this.models[753] = new ChoiceModel(286138368);
                    break;
                }
                case 294: {
                    this.models[294] = new ChoiceModel(1175199744);
                    break;
                }
                default: {
                    EarlyAppsModelBank.getModelLogChannel().log(10000, "[EarlyAppsModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public EarlyAppsModelBank() {
        super(21, 757, 520);
        this.modelIDs = new int[520];
        this.modelIDs[0] = 135077888;
        this.modelIDs[1] = 68034560;
        this.modelIDs[2] = 403447808;
        this.modelIDs[3] = 369893376;
        this.modelIDs[4] = 990650368;
        this.modelIDs[5] = 2131501056;
        this.modelIDs[6] = -217374720;
        this.modelIDs[7] = -1341317120;
        this.modelIDs[8] = -234086400;
        this.modelIDs[9] = 1359749120;
        this.modelIDs[10] = -1324539904;
        this.modelIDs[11] = 772546560;
        this.modelIDs[12] = 84811776;
        this.modelIDs[13] = -502587392;
        this.modelIDs[14] = -1123344384;
        this.modelIDs[15] = 621617152;
        this.modelIDs[16] = -854908928;
        this.modelIDs[17] = -1945296896;
        this.modelIDs[18] = 101588992;
        this.modelIDs[19] = -871686144;
        this.modelIDs[20] = 2097946624;
        this.modelIDs[21] = -1140121600;
        this.modelIDs[22] = -1962205184;
        this.modelIDs[23] = -1089658880;
        this.modelIDs[24] = -1374937088;
        this.modelIDs[25] = -1358159872;
        this.modelIDs[26] = -1072881664;
        this.modelIDs[27] = -1660149760;
        this.modelIDs[28] = -133488640;
        this.modelIDs[29] = -1593040896;
        this.modelIDs[30] = -2029182976;
        this.modelIDs[31] = 1527586816;
        this.modelIDs[32] = -32825344;
        this.modelIDs[33] = 889987072;
        this.modelIDs[34] = -1207164928;
        this.modelIDs[35] = -1056104448;
        this.modelIDs[36] = 1208819712;
        this.modelIDs[37] = 1191976960;
        this.modelIDs[38] = -2012471296;
        this.modelIDs[39] = -804577280;
        this.modelIDs[40] = -1995694080;
        this.modelIDs[41] = 319561728;
        this.modelIDs[42] = 1326260224;
        this.modelIDs[43] = 822943744;
        this.modelIDs[44] = 638394368;
        this.modelIDs[45] = -2129977344;
        this.modelIDs[46] = -1760878592;
        this.modelIDs[47] = -351592448;
        this.modelIDs[48] = 923607040;
        this.modelIDs[49] = 554508288;
        this.modelIDs[50] = -1190387712;
        this.modelIDs[51] = -166977536;
        this.modelIDs[52] = 0x220D2000;
        this.modelIDs[53] = 504111104;
        this.modelIDs[54] = 1544364032;
        this.modelIDs[55] = 873275392;
        this.modelIDs[56] = 973873152;
        this.modelIDs[57] = -1777655808;
        this.modelIDs[58] = -1626660864;
        this.modelIDs[59] = 1712070656;
        this.modelIDs[60] = 1896620032;
        this.modelIDs[61] = -1811210240;
        this.modelIDs[62] = 755769344;
        this.modelIDs[63] = -15982592;
        this.modelIDs[64] = 386736128;
        this.modelIDs[65] = 235675648;
        this.modelIDs[66] = 84746240;
        this.modelIDs[67] = -1509220352;
        this.modelIDs[68] = -1878188032;
        this.modelIDs[69] = -401924096;
        this.modelIDs[70] = -1173610496;
        this.modelIDs[71] = 218898432;
        this.modelIDs[72] = -603250688;
        this.modelIDs[73] = -49602560;
        this.modelIDs[74] = -485810176;
        this.modelIDs[75] = -1525932032;
        this.modelIDs[76] = -1458757632;
        this.modelIDs[77] = -1643372544;
        this.modelIDs[78] = -1391648768;
        this.modelIDs[79] = -1156833280;
        this.modelIDs[80] = -250929152;
        this.modelIDs[81] = 1309417472;
        this.modelIDs[82] = -754180096;
        this.modelIDs[83] = 957095936;
        this.modelIDs[84] = -1039327232;
        this.modelIDs[85] = -1106567168;
        this.modelIDs[86] = 1561141248;
        this.modelIDs[87] = -1140056064;
        this.modelIDs[88] = -2129911808;
        this.modelIDs[89] = 655171584;
        this.modelIDs[90] = 588062720;
        this.modelIDs[91] = 722214912;
        this.modelIDs[92] = -1123278848;
        this.modelIDs[93] = 940384256;
        this.modelIDs[94] = 1846288384;
        this.modelIDs[95] = -1861541888;
        this.modelIDs[96] = 2081169408;
        this.modelIDs[97] = 1141710848;
        this.modelIDs[98] = -2146754560;
        this.modelIDs[99] = -1978916864;
        this.modelIDs[100] = -1660215296;
        this.modelIDs[101] = 302915584;
        this.modelIDs[102] = -1056235520;
        this.modelIDs[103] = -536076288;
        this.modelIDs[104] = -1022550016;
        this.modelIDs[105] = -1005772800;
        this.modelIDs[106] = 1124868096;
        this.modelIDs[107] = -737402880;
        this.modelIDs[108] = -988995584;
        this.modelIDs[109] = 1326194688;
        this.modelIDs[110] = 1024204800;
        this.modelIDs[111] = -1106501632;
        this.modelIDs[112] = -972218368;
        this.modelIDs[113] = 839655424;
        this.modelIDs[114] = 185409536;
        this.modelIDs[115] = -2113134592;
        this.modelIDs[116] = 1242374144;
        this.modelIDs[117] = 1007427584;
        this.modelIDs[118] = -1744101376;
        this.modelIDs[119] = -955441152;
        this.modelIDs[120] = -1676992512;
        this.modelIDs[121] = -435478528;
        this.modelIDs[122] = -183820288;
        this.modelIDs[123] = 520953856;
        this.modelIDs[124] = -586473472;
        this.modelIDs[125] = -1475600384;
        this.modelIDs[126] = -1962139648;
        this.modelIDs[127] = -66379776;
        this.modelIDs[128] = -720625664;
        this.modelIDs[129] = -217309184;
        this.modelIDs[130] = 1997283328;
        this.modelIDs[131] = 789323776;
        this.modelIDs[132] = -955572224;
        this.modelIDs[133] = -1089724416;
        this.modelIDs[134] = 1611407360;
        this.modelIDs[135] = -1710481408;
        this.modelIDs[136] = 67903488;
        this.modelIDs[137] = -1509154816;
        this.modelIDs[138] = -938663936;
        this.modelIDs[139] = -1945362432;
        this.modelIDs[140] = 1661739008;
        this.modelIDs[141] = -452255744;
        this.modelIDs[142] = 504176640;
        this.modelIDs[143] = -1307762688;
        this.modelIDs[144] = 1477189632;
        this.modelIDs[145] = 51126272;
        this.modelIDs[146] = -1391714304;
        this.modelIDs[147] = -2012405760;
        this.modelIDs[148] = -1072947200;
        this.modelIDs[149] = -1492377600;
        this.modelIDs[150] = -519299072;
        this.modelIDs[151] = 2047614976;
        this.modelIDs[152] = 1259151360;
        this.modelIDs[153] = -1794367488;
        this.modelIDs[154] = -888463360;
        this.modelIDs[155] = -519364608;
        this.modelIDs[156] = 2097881088;
        this.modelIDs[157] = -1056169984;
        this.modelIDs[158] = 101523456;
        this.modelIDs[159] = 1628250112;
        this.modelIDs[160] = 789389312;
        this.modelIDs[161] = -1626595328;
        this.modelIDs[162] = -1643438080;
        this.modelIDs[163] = -921886720;
        this.modelIDs[164] = -1039392768;
        this.modelIDs[165] = 202186752;
        this.modelIDs[166] = -1693704192;
        this.modelIDs[167] = -1827856384;
        this.modelIDs[168] = -1207230464;
        this.modelIDs[169] = -2046091264;
        this.modelIDs[170] = -250863616;
        this.modelIDs[171] = 957161472;
        this.modelIDs[172] = -905109504;
        this.modelIDs[173] = 1879842816;
        this.modelIDs[174] = 302784512;
        this.modelIDs[175] = 1678581760;
        this.modelIDs[176] = -1022615552;
        this.modelIDs[177] = -888332288;
        this.modelIDs[178] = -1727324160;
        this.modelIDs[179] = -2113200128;
        this.modelIDs[180] = -1156767744;
        this.modelIDs[181] = -1995628544;
        this.modelIDs[182] = -267706368;
        this.modelIDs[183] = -1475665920;
        this.modelIDs[184] = 1343037440;
        this.modelIDs[185] = -1559486464;
        this.modelIDs[186] = -922017792;
        this.modelIDs[187] = 386670592;
        this.modelIDs[188] = -871555072;
        this.modelIDs[189] = -1777524736;
        this.modelIDs[190] = -1442045952;
        this.modelIDs[191] = -1425334272;
        this.modelIDs[192] = -385146880;
        this.modelIDs[193] = 0x20C2000;
        this.modelIDs[194] = -1425268736;
        this.modelIDs[195] = 135012352;
        this.modelIDs[196] = -1928585216;
        this.modelIDs[197] = 1141645312;
        this.modelIDs[198] = -552919040;
        this.modelIDs[199] = -1475534848;
        this.modelIDs[200] = 1930174464;
        this.modelIDs[201] = 520888320;
        this.modelIDs[202] = -720691200;
        this.modelIDs[203] = 2131566592;
        this.modelIDs[204] = 101457920;
        this.modelIDs[205] = -1492443136;
        this.modelIDs[206] = -200597504;
        this.modelIDs[207] = 84680704;
        this.modelIDs[208] = 118366208;
        this.modelIDs[209] = 1158422528;
        this.modelIDs[210] = -905240576;
        this.modelIDs[211] = 1695358976;
        this.modelIDs[212] = 1863065600;
        this.modelIDs[213] = 1712136192;
        this.modelIDs[214] = 2014060544;
        this.modelIDs[215] = -2146689024;
        this.modelIDs[216] = -1005838336;
        this.modelIDs[217] = -854777856;
        this.modelIDs[218] = 1493966848;
        this.modelIDs[219] = -301260800;
        this.modelIDs[220] = -989061120;
        this.modelIDs[221] = 353116160;
        this.modelIDs[222] = 973938688;
        this.modelIDs[223] = -1760747520;
        this.modelIDs[224] = -536010752;
        this.modelIDs[225] = 1091313664;
        this.modelIDs[226] = 705437696;
        this.modelIDs[227] = 0xC0C2000;
        this.modelIDs[228] = -838000640;
        this.modelIDs[229] = -821223424;
        this.modelIDs[230] = 604839936;
        this.modelIDs[231] = 1259085824;
        this.modelIDs[232] = -318038016;
        this.modelIDs[233] = 1040982016;
        this.modelIDs[234] = 2114658304;
        this.modelIDs[235] = -66248704;
        this.modelIDs[236] = 0xD0D2000;
        this.modelIDs[237] = 806100992;
        this.modelIDs[238] = -32759808;
        this.modelIDs[239] = -1878319104;
        this.modelIDs[240] = 1275928576;
        this.modelIDs[241] = 1829511168;
        this.modelIDs[242] = -1911808000;
        this.modelIDs[243] = -972283904;
        this.modelIDs[244] = -2096422912;
        this.modelIDs[245] = -1995759616;
        this.modelIDs[246] = -99868672;
        this.modelIDs[247] = 420225024;
        this.modelIDs[248] = -2029248512;
        this.modelIDs[249] = 135143424;
        this.modelIDs[250] = 151920640;
        this.modelIDs[251] = -1307893760;
        this.modelIDs[252] = -787800064;
        this.modelIDs[253] = -1911873536;
        this.modelIDs[254] = -1324605440;
        this.modelIDs[255] = 168697856;
        this.modelIDs[256] = -687136768;
        this.modelIDs[257] = -1458823168;
        this.modelIDs[258] = -838131712;
        this.modelIDs[259] = -1710546944;
        this.modelIDs[260] = 1309483008;
        this.modelIDs[261] = -771022848;
        this.modelIDs[262] = 671948800;
        this.modelIDs[263] = -1073012736;
        this.modelIDs[264] = 890052608;
        this.modelIDs[265] = 185475072;
        this.modelIDs[266] = -620027904;
        this.modelIDs[267] = 487333888;
        this.modelIDs[268] = -703848448;
        this.modelIDs[269] = -368238592;
        this.modelIDs[270] = 453844992;
        this.modelIDs[271] = 51191808;
        this.modelIDs[272] = 420290560;
        this.modelIDs[273] = -1710415872;
        this.modelIDs[274] = -1895030784;
        this.modelIDs[275] = 1460412416;
        this.modelIDs[276] = 1762467840;
        this.modelIDs[277] = -418701312;
        this.modelIDs[278] = -687071232;
        this.modelIDs[279] = -804446208;
        this.modelIDs[280] = -1542709248;
        this.modelIDs[281] = 286007296;
        this.modelIDs[282] = 118235136;
        this.modelIDs[283] = -955506688;
        this.modelIDs[284] = 1108090880;
        this.modelIDs[285] = -938729472;
        this.modelIDs[286] = 1779245056;
        this.modelIDs[287] = -83091456;
        this.modelIDs[288] = -821354496;
        this.modelIDs[289] = -921952256;
        this.modelIDs[290] = -116711424;
        this.modelIDs[291] = 118300672;
        this.modelIDs[292] = 470556672;
        this.modelIDs[293] = 1292705792;
        this.modelIDs[294] = -787668992;
        this.modelIDs[295] = 1410080768;
        this.modelIDs[296] = 822878208;
        this.modelIDs[297] = 856432640;
        this.modelIDs[298] = -1290985472;
        this.modelIDs[299] = -1794433024;
        this.modelIDs[300] = 1779179520;
        this.modelIDs[301] = 151789568;
        this.modelIDs[302] = 990715904;
        this.modelIDs[303] = 1812799488;
        this.modelIDs[304] = -670359552;
        this.modelIDs[305] = 470622208;
        this.modelIDs[306] = -1358225408;
        this.modelIDs[307] = -1559552000;
        this.modelIDs[308] = 1242308608;
        this.modelIDs[309] = 202252288;
        this.modelIDs[310] = -2079580160;
        this.modelIDs[311] = -150200320;
        this.modelIDs[312] = 336470016;
        this.modelIDs[313] = -770891776;
        this.modelIDs[314] = 219029504;
        this.modelIDs[315] = -905175040;
        this.modelIDs[316] = -99934208;
        this.modelIDs[317] = -1425203200;
        this.modelIDs[318] = -1962074112;
        this.modelIDs[319] = 185344000;
        this.modelIDs[320] = -1391779840;
        this.modelIDs[321] = -754114560;
        this.modelIDs[322] = 860160;
        this.modelIDs[323] = 51257344;
        this.modelIDs[324] = 1527521280;
        this.modelIDs[325] = -737337344;
        this.modelIDs[326] = -2146623488;
        this.modelIDs[327] = -720560128;
        this.modelIDs[328] = 1879908352;
        this.modelIDs[329] = -703782912;
        this.modelIDs[330] = -1291051008;
        this.modelIDs[331] = 319692800;
        this.modelIDs[332] = 1443635200;
        this.modelIDs[333] = 1913397248;
        this.modelIDs[334] = -888397824;
        this.modelIDs[335] = -687005696;
        this.modelIDs[336] = -871620608;
        this.modelIDs[337] = 1510744064;
        this.modelIDs[338] = 1376591872;
        this.modelIDs[339] = -1676861440;
        this.modelIDs[340] = 940318720;
        this.modelIDs[341] = -1660084224;
        this.modelIDs[342] = -670228480;
        this.modelIDs[343] = -1576329216;
        this.modelIDs[344] = 0xE0E2000;
        this.modelIDs[345] = -1307828224;
        this.modelIDs[346] = -66314240;
        this.modelIDs[347] = -83156992;
        this.modelIDs[348] = -150265856;
        this.modelIDs[349] = -653451264;
        this.modelIDs[350] = 688660480;
        this.modelIDs[351] = -133423104;
        this.modelIDs[352] = 1678516224;
        this.modelIDs[353] = -1408557056;
        this.modelIDs[354] = -200531968;
        this.modelIDs[355] = -1274208256;
        this.modelIDs[356] = 794624;
        this.modelIDs[357] = -1878253568;
        this.modelIDs[358] = -1156898816;
        this.modelIDs[359] = -1257431040;
        this.modelIDs[360] = -1207099392;
        this.modelIDs[361] = -1341448192;
        this.modelIDs[362] = 151855104;
        this.modelIDs[363] = -1190322176;
        this.modelIDs[364] = 403513344;
        this.modelIDs[365] = -569696256;
        this.modelIDs[366] = -1341382656;
        this.modelIDs[367] = -703913984;
        this.modelIDs[368] = -1458888704;
        this.modelIDs[369] = -167043072;
        this.modelIDs[370] = -636674048;
        this.modelIDs[371] = -1827987456;
        this.modelIDs[372] = -1861476352;
        this.modelIDs[373] = -972349440;
        this.modelIDs[374] = -619896832;
        this.modelIDs[375] = 252583936;
        this.modelIDs[376] = 1913462784;
        this.modelIDs[377] = 437002240;
        this.modelIDs[378] = -1240719360;
        this.modelIDs[379] = -1844764672;
        this.modelIDs[380] = 1007493120;
        this.modelIDs[381] = -1626529792;
        this.modelIDs[382] = -603119616;
        this.modelIDs[383] = 0x2C0C2000;
        this.modelIDs[384] = 17637376;
        this.modelIDs[385] = -1609752576;
        this.modelIDs[386] = -653582336;
        this.modelIDs[387] = 1024270336;
        this.modelIDs[388] = -1240653824;
        this.modelIDs[389] = -2062868480;
        this.modelIDs[390] = -586342400;
        this.modelIDs[391] = 0x220C2000;
        this.modelIDs[392] = 1946951680;
        this.modelIDs[393] = -1525997568;
        this.modelIDs[394] = 722280448;
        this.modelIDs[395] = -49537024;
        this.modelIDs[396] = -854843392;
        this.modelIDs[397] = -1760813056;
        this.modelIDs[398] = -1844699136;
        this.modelIDs[399] = 1225596928;
        this.modelIDs[400] = -2062737408;
        this.modelIDs[401] = 1041047552;
        this.modelIDs[402] = 1342971904;
        this.modelIDs[403] = 671883264;
        this.modelIDs[404] = -536141824;
        this.modelIDs[405] = -334815232;
        this.modelIDs[406] = -2062802944;
        this.modelIDs[407] = 1057759232;
        this.modelIDs[408] = -569565184;
        this.modelIDs[409] = 1057824768;
        this.modelIDs[410] = 168632320;
        this.modelIDs[411] = -1945427968;
        this.modelIDs[412] = -2045960192;
        this.modelIDs[413] = -938795008;
        this.modelIDs[414] = -1928650752;
        this.modelIDs[415] = 2030837760;
        this.modelIDs[416] = -1542774784;
        this.modelIDs[417] = 252452864;
        this.modelIDs[418] = -552787968;
        this.modelIDs[419] = 1963728896;
        this.modelIDs[420] = 1980571648;
        this.modelIDs[421] = -1408425984;
        this.modelIDs[422] = 621551616;
        this.modelIDs[423] = 487399424;
        this.modelIDs[424] = -452124672;
        this.modelIDs[425] = 1225531392;
        this.modelIDs[426] = -838066176;
        this.modelIDs[427] = 168566784;
        this.modelIDs[428] = 2131435520;
        this.modelIDs[429] = 873209856;
        this.modelIDs[430] = 604774400;
        this.modelIDs[431] = 1997348864;
        this.modelIDs[432] = 453779456;
        this.modelIDs[433] = 1074536448;
        this.modelIDs[434] = -1173676032;
        this.modelIDs[435] = 655106048;
        this.modelIDs[436] = -1559420928;
        this.modelIDs[437] = 1275863040;
        this.modelIDs[438] = -519233536;
        this.modelIDs[439] = 67969024;
        this.modelIDs[440] = -821288960;
        this.modelIDs[441] = -1777590272;
        this.modelIDs[442] = 638328832;
        this.modelIDs[443] = -16048128;
        this.modelIDs[444] = 17571840;
        this.modelIDs[445] = -1442111488;
        this.modelIDs[446] = 1208754176;
        this.modelIDs[447] = -469032960;
        this.modelIDs[448] = -1408491520;
        this.modelIDs[449] = -1593106432;
        this.modelIDs[450] = -435412992;
        this.modelIDs[451] = -1274273792;
        this.modelIDs[452] = -1190453248;
        this.modelIDs[453] = 2014126080;
        this.modelIDs[454] = -670294016;
        this.modelIDs[455] = 269361152;
        this.modelIDs[456] = 269230080;
        this.modelIDs[457] = -1744035840;
        this.modelIDs[458] = -804511744;
        this.modelIDs[459] = -502456320;
        this.modelIDs[460] = 2030903296;
        this.modelIDs[461] = -2029314048;
        this.modelIDs[462] = 587997184;
        this.modelIDs[463] = 923541504;
        this.modelIDs[464] = 906764288;
        this.modelIDs[465] = 1074601984;
        this.modelIDs[466] = 235741184;
        this.modelIDs[467] = -2079645696;
        this.modelIDs[468] = 1359814656;
        this.modelIDs[469] = -737468416;
        this.modelIDs[470] = 1292640256;
        this.modelIDs[471] = 2047680512;
        this.modelIDs[472] = -754245632;
        this.modelIDs[473] = 1091379200;
        this.modelIDs[474] = -284483584;
        this.modelIDs[475] = -787734528;
        this.modelIDs[476] = 336338944;
        this.modelIDs[477] = -485679104;
        this.modelIDs[478] = 2064457728;
        this.modelIDs[479] = -770957312;
        this.modelIDs[480] = -2046025728;
        this.modelIDs[481] = -368369664;
        this.modelIDs[482] = -468901888;
        this.modelIDs[483] = -351461376;
        this.modelIDs[484] = 1376526336;
        this.modelIDs[485] = -1139990528;
        this.modelIDs[486] = 0x200D2000;
        this.modelIDs[487] = 1980506112;
        this.modelIDs[488] = -1257496576;
        this.modelIDs[489] = 2114723840;
        this.modelIDs[490] = 1108156416;
        this.modelIDs[491] = 0x200C2000;
        this.modelIDs[492] = -1576263680;
        this.modelIDs[493] = -418635776;
        this.modelIDs[494] = -636805120;
        this.modelIDs[495] = -1978982400;
        this.modelIDs[496] = 1393303552;
        this.modelIDs[497] = -401793024;
        this.modelIDs[498] = -1827921920;
        this.modelIDs[499] = -234151936;
        this.modelIDs[500] = 806166528;
        this.modelIDs[501] = 554442752;
        this.modelIDs[502] = -1223876608;
        this.modelIDs[503] = -435347456;
        this.modelIDs[504] = -1609883648;
        this.modelIDs[505] = -418570240;
        this.modelIDs[506] = -2012536832;
        this.modelIDs[507] = 437067776;
        this.modelIDs[508] = -653516800;
        this.modelIDs[509] = -1676926976;
        this.modelIDs[510] = -385015808;
        this.modelIDs[511] = -1811144704;
        this.modelIDs[512] = -1089789952;
        this.modelIDs[513] = -116645888;
        this.modelIDs[514] = -1693769728;
        this.modelIDs[515] = -1727258624;
        this.modelIDs[516] = -1609818112;
        this.modelIDs[517] = -1895096320;
        this.modelIDs[518] = 286138368;
        this.modelIDs[519] = 1175199744;
    }
}

