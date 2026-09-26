/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BufferedDynamicListModel;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.FastScrollingModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SlidingListModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.model.ICoreMediaModelBank;
import de.audi.atip.model.IEvoMediaModelBank;

public class MediaModelBank
extends AbstractModelBank
implements ICoreMediaModelBank,
IEvoMediaModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 651: {
                    this.models[651] = new OptionModel(-888208640);
                    break;
                }
                case 290: {
                    this.models[290] = new ChoiceModel(1645085440);
                    break;
                }
                case 675: {
                    this.models[675] = new TerminalModelContainer(-485555456, 1, false);
                    break;
                }
                case 851: {
                    this.models[851] = new ButtonModel(-1827667200);
                    break;
                }
                case 640: {
                    this.models[640] = new TiledListModel(-1072758016, (MenuModel)this.getModel(-1055980800));
                    break;
                }
                case 251: {
                    this.models[251] = new TerminalModelContainer(990774016, 2, false);
                    break;
                }
                case 592: {
                    this.models[592] = new TerminalModelContainer(-1878064384, 3, false);
                    break;
                }
                case 826: {
                    this.models[826] = new ChoiceModel(2047869696);
                    break;
                }
                case 704: {
                    this.models[704] = new ButtonModel(0x100300);
                    break;
                }
                case 712: {
                    this.models[712] = new ChoiceModel(135267072);
                    break;
                }
                case 253: {
                    this.models[253] = new TerminalModelContainer(1024328448, 5, false);
                    break;
                }
                case 638: {
                    this.models[638] = new ChoiceModel(-1106312448);
                    break;
                }
                case 641: {
                    this.models[641] = new MenuModel(-1055980800);
                    break;
                }
                case 150: {
                    this.models[150] = new TerminalModelContainer(-703790336, 2, false);
                    break;
                }
                case 848: {
                    this.models[848] = new ChoiceModel(-1877998848);
                    break;
                }
                case 274: {
                    this.models[274] = new TerminalModelContainer(1376649984, 4, true);
                    break;
                }
                case 384: {
                    this.models[384] = new VirtualButtonModel(-1072823552);
                    break;
                }
                case 667: {
                    this.models[667] = new ChoiceModel(-619773184);
                    break;
                }
                case 179: {
                    this.models[179] = new TerminalModelContainer(-217251072, 1, false);
                    break;
                }
                case 543: {
                    this.models[543] = new TerminalModelContainer(1594819328, 3, false);
                    break;
                }
                case 313: {
                    this.models[313] = new TerminalModelContainer(2030961408, 2, false);
                    break;
                }
                case 688: {
                    this.models[688] = new TerminalModelContainer(-267451648, 2, false);
                    break;
                }
                case 265: {
                    this.models[265] = new ButtonModel(1225655040);
                    break;
                }
                case 568: {
                    this.models[568] = new TerminalModelContainer(2014249728, 5, false);
                    break;
                }
                case 243: {
                    this.models[243] = new TerminalModelContainer(0x330E0300, 2, false);
                    break;
                }
                case 596: {
                    this.models[596] = new ChoiceModel(-1810955520);
                    break;
                }
                case 666: {
                    this.models[666] = new ButtonModel(-636550400);
                    break;
                }
                case 258: {
                    this.models[258] = new ButtonModel(1108214528);
                    break;
                }
                case 561: {
                    this.models[561] = new TerminalModelContainer(1896809216, 5, false);
                    break;
                }
                case 285: {
                    this.models[285] = new TerminalModelContainer(1561199360, 4, true);
                    break;
                }
                case 847: {
                    this.models[847] = new ChoiceModel(-1894776064);
                    break;
                }
                case 546: {
                    this.models[546] = new BufferedDynamicListModel(1645150976);
                    break;
                }
                case 153: {
                    this.models[153] = new TerminalModelContainer(-653458688, 6, false);
                    break;
                }
                case 598: {
                    this.models[598] = new BaseListModel(-1777401088, (MenuModel)this.getModel(907019008));
                    break;
                }
                case 588: {
                    this.models[588] = new TerminalModelContainer(-1945173248, 22, false);
                    break;
                }
                case 700: {
                    this.models[700] = new OptionModel(-66125056);
                    break;
                }
                case 677: {
                    this.models[677] = new TerminalModelContainer(-452001024, 5, false);
                    break;
                }
                case 558: {
                    this.models[558] = new LabelModel(1846477568);
                    break;
                }
                case 451: {
                    this.models[451] = new ChoiceModel(0x30F0300);
                    break;
                }
                case 957: {
                    this.models[957] = new ChoiceModel(-49282304);
                    break;
                }
                case 845: {
                    this.models[845] = new ButtonModel(-1928330496);
                    break;
                }
                case 527: {
                    this.models[527] = new TerminalModelContainer(1326383872, 3, false);
                    break;
                }
                case 282: {
                    this.models[282] = new TerminalModelContainer(1510867712, 4, true);
                    break;
                }
                case 631: {
                    this.models[631] = new TerminalModelContainer(-1223752960, 12, true);
                    break;
                }
                case 241: {
                    this.models[241] = new TerminalModelContainer(823001856, 2, false);
                    break;
                }
                case 650: {
                    this.models[650] = new TerminalModelContainer(-904985856, 2, false);
                    break;
                }
                case 551: {
                    this.models[551] = new ButtonModel(1729037056);
                    break;
                }
                case 544: {
                    this.models[544] = new TerminalModelContainer(1611596544, 3, false);
                    break;
                }
                case 537: {
                    this.models[537] = new ChoiceModel(1494156032);
                    break;
                }
                case 214: {
                    this.models[214] = new SlidingListModel(370017024);
                    break;
                }
                case 360: {
                    this.models[360] = new LabelModel(-1475476736);
                    break;
                }
                case 581: {
                    this.models[581] = new TerminalModelContainer(-2062613760, 2, false);
                    break;
                }
                case 644: {
                    this.models[644] = new TerminalModelContainer(-1005649152, 2, false);
                    break;
                }
                case 624: {
                    this.models[624] = new SpellerModel(-1341193472);
                    break;
                }
                case 235: {
                    this.models[235] = new TerminalModelContainer(722338560, 2, false);
                    break;
                }
                case 585: {
                    this.models[585] = new MenuModel(-1995504896);
                    break;
                }
                case 462: {
                    this.models[462] = new ButtonModel(235864832);
                    break;
                }
                case 800: {
                    this.models[800] = new ChoiceModel(1611662080);
                    break;
                }
                case 590: {
                    this.models[590] = new ChoiceModel(-1911618816);
                    break;
                }
                case 612: {
                    this.models[612] = new TerminalModelContainer(-1542520064, 2, false);
                    break;
                }
                case 578: {
                    this.models[578] = new ButtonModel(-2112945408);
                    break;
                }
                case 623: {
                    this.models[623] = new ChoiceModel(-1357970688);
                    break;
                }
                case 956: {
                    this.models[956] = new ChoiceModel(-66059520);
                    break;
                }
                case 152: {
                    this.models[152] = new TerminalModelContainer(-670235904, 2, false);
                    break;
                }
                case 634: {
                    this.models[634] = new TerminalModelContainer(-1173421312, 2, false);
                    break;
                }
                case 547: {
                    this.models[547] = new FastScrollingModel(1661928192);
                    break;
                }
                case 643: {
                    this.models[643] = new TerminalModelContainer(-1022426368, 22, false);
                    break;
                }
                case 216: {
                    this.models[216] = new ResourceLocatorModel(403571456);
                    break;
                }
                case 530: {
                    this.models[530] = new ChoiceModel(1376715520);
                    break;
                }
                case 599: {
                    this.models[599] = new TerminalModelContainer(-1760623872, 2, false);
                    break;
                }
                case 589: {
                    this.models[589] = new TerminalModelContainer(-1928396032, 3, false);
                    break;
                }
                case 1037: {
                    this.models[1037] = new LabelModel(1292960512);
                    break;
                }
                case 661: {
                    this.models[661] = new LabelModel(-720436480);
                    break;
                }
                case 821: {
                    this.models[821] = new ChoiceModel(1963983616);
                    break;
                }
                case 778: {
                    this.models[778] = new ChoiceModel(1242563328);
                    break;
                }
                case 559: {
                    this.models[559] = new LabelModel(1863254784);
                    break;
                }
                case 268: {
                    this.models[268] = new BufferedListModel(1275986688);
                    break;
                }
                case 732: {
                    this.models[732] = new LabelModel(470811392);
                    break;
                }
                case 571: {
                    this.models[571] = new ChoiceModel(2064581376);
                    break;
                }
                case 220: {
                    this.models[220] = new ChoiceModel(470680320);
                    break;
                }
                case 271: {
                    this.models[271] = new TerminalModelContainer(1326318336, 4, true);
                    break;
                }
                case 314: {
                    this.models[314] = new TerminalModelContainer(2047738624, 2, false);
                    break;
                }
                case 681: {
                    this.models[681] = new MenuModel(-384892160);
                    break;
                }
                case 264: {
                    this.models[264] = new TerminalModelContainer(1208877824, 1, false);
                    break;
                }
                case 672: {
                    this.models[672] = new TerminalModelContainer(-535887104, 1, false);
                    break;
                }
                case 761: {
                    this.models[761] = new ChoiceModel(957350656);
                    break;
                }
                case 522: {
                    this.models[522] = new ChoiceModel(1242497792);
                    break;
                }
                case 1012: {
                    this.models[1012] = new ChoiceModel(873530112);
                    break;
                }
                case 747: {
                    this.models[747] = new ChoiceModel(722469632);
                    break;
                }
                case 569: {
                    this.models[569] = new TerminalModelContainer(2031026944, 5, false);
                    break;
                }
                case 560: {
                    this.models[560] = new ChoiceModel(1880032000);
                    break;
                }
                case 199: {
                    this.models[199] = new TerminalModelContainer(118358784, 3, false);
                    break;
                }
                case 540: {
                    this.models[540] = new ButtonModel(1544487680);
                    break;
                }
                case 662: {
                    this.models[662] = new TerminalModelContainer(-703659264, 2, false);
                    break;
                }
                case 246: {
                    this.models[246] = new TerminalModelContainer(906887936, 2, false);
                    break;
                }
                case 1038: {
                    this.models[1038] = new ChoiceModel(1309737728);
                    break;
                }
                case 232: {
                    this.models[232] = new TerminalModelContainer(672006912, 2, false);
                    break;
                }
                case 743: {
                    this.models[743] = new ChoiceModel(655360768);
                    break;
                }
                case 549: {
                    this.models[549] = new ChoiceModel(1695482624);
                    break;
                }
                case 154: {
                    this.models[154] = new TerminalModelContainer(-636681472, 2, false);
                    break;
                }
                case 786: {
                    this.models[786] = new ChoiceModel(1376781056);
                    break;
                }
                case 706: {
                    this.models[706] = new SpellerModel(34603776);
                    break;
                }
                case 244: {
                    this.models[244] = new TerminalModelContainer(873333504, 2, false);
                    break;
                }
                case 607: {
                    this.models[607] = new TerminalModelContainer(-1626406144, 3, true);
                    break;
                }
                case 575: {
                    this.models[575] = new ButtonModel(2131690240);
                    break;
                }
                case 853: {
                    this.models[853] = new ChoiceModel(-1794112768);
                    break;
                }
                case 863: {
                    this.models[863] = new ChoiceModel(-1626340608);
                    break;
                }
                case 721: {
                    this.models[721] = new BaseListModel(0x11100300, (MenuModel)this.getModel(-1055980800));
                    break;
                }
                case 767: {
                    this.models[767] = new ChoiceModel(1058013952);
                    break;
                }
                case 652: {
                    this.models[652] = new TerminalModelContainer(-871431424, 2, false);
                    break;
                }
                case 970: {
                    this.models[970] = new ChoiceModel(168887040);
                    break;
                }
                case 802: {
                    this.models[802] = new ChoiceModel(1645216512);
                    break;
                }
                case 685: {
                    this.models[685] = new ChoiceModel(-317783296);
                    break;
                }
                case 680: {
                    this.models[680] = new TiledListModel(-401669376, (MenuModel)this.getModel(-384892160));
                    break;
                }
                case 628: {
                    this.models[628] = new TerminalModelContainer(-1274084608, 2, false);
                    break;
                }
                case 213: {
                    this.models[213] = new ButtonModel(353239808);
                    break;
                }
                case 218: {
                    this.models[218] = new LabelModel(437125888);
                    break;
                }
                case 591: {
                    this.models[591] = new TerminalModelContainer(-1894841600, 13, false);
                    break;
                }
                case 254: {
                    this.models[254] = new TerminalModelContainer(0x3E0E0300, 3, false);
                    break;
                }
                case 333: {
                    this.models[333] = new LabelModel(-1928461568);
                    break;
                }
                case 595: {
                    this.models[595] = new TerminalModelContainer(-1827732736, 2, false);
                    break;
                }
                case 572: {
                    this.models[572] = new ButtonModel(2081358592);
                    break;
                }
                case 556: {
                    this.models[556] = new ButtonModel(1812923136);
                    break;
                }
                case 247: {
                    this.models[247] = new TerminalModelContainer(923665152, 1, false);
                    break;
                }
                case 673: {
                    this.models[673] = new TerminalModelContainer(-519109888, 1, false);
                    break;
                }
                case 659: {
                    this.models[659] = new BufferedListModel(-753990912);
                    break;
                }
                case 229: {
                    this.models[229] = new TerminalModelContainer(621675264, 2, false);
                    break;
                }
                case 202: {
                    this.models[202] = new TerminalModelContainer(168690432, 3, false);
                    break;
                }
                case 526: {
                    this.models[526] = new TerminalModelContainer(1309606656, 2, false);
                    break;
                }
                case 703: {
                    this.models[703] = new ChoiceModel(-15793408);
                    break;
                }
                case 548: {
                    this.models[548] = new LabelModel(1678705408);
                    break;
                }
                case 322: {
                    this.models[322] = new RangeModel(-2113010944);
                    break;
                }
                case 205: {
                    this.models[205] = new TerminalModelContainer(219022080, 3, false);
                    break;
                }
                case 605: {
                    this.models[605] = new TerminalModelContainer(-1659960576, 22, false);
                    break;
                }
                case 555: {
                    this.models[555] = new LabelModel(1796145920);
                    break;
                }
                case 449: {
                    this.models[449] = new ButtonModel(17761024);
                    break;
                }
                case 255: {
                    this.models[255] = new TerminalModelContainer(1057882880, 3, false);
                    break;
                }
                case 719: {
                    this.models[719] = new BaseListModel(252707584, (MenuModel)this.getModel(907019008));
                    break;
                }
                case 906: {
                    this.models[906] = new ChoiceModel(-904920320);
                    break;
                }
                case 626: {
                    this.models[626] = new ChoiceModel(-1307639040);
                    break;
                }
                case 339: {
                    this.models[339] = new LabelModel(-1827798272);
                    break;
                }
                case 1108: {
                    this.models[1108] = new ChoiceModel(-1810824448);
                    break;
                }
                case 586: {
                    this.models[586] = new TerminalModelContainer(-1978727680, 2, false);
                    break;
                }
                case 682: {
                    this.models[682] = new TerminalModelContainer(-368114944, 3, false);
                    break;
                }
                case 250: {
                    this.models[250] = new TerminalModelContainer(973996800, 2, false);
                    break;
                }
                case 583: {
                    this.models[583] = new TerminalModelContainer(-2029059328, 12, true);
                    break;
                }
                case 1039: {
                    this.models[1039] = new TerminalModelContainer(1326514944, 6, false);
                    break;
                }
                case 288: {
                    this.models[288] = new TerminalModelContainer(1611531008, 22, false);
                    break;
                }
                case 1020: {
                    this.models[1020] = new OptionModel(1007747840);
                    break;
                }
                case 240: {
                    this.models[240] = new TerminalModelContainer(0x300E0300, 2, false);
                    break;
                }
                case 456: {
                    this.models[456] = new RangeModel(135201536);
                    break;
                }
                case 353: {
                    this.models[353] = new TerminalModelContainer(-1592917248, 2, false);
                    break;
                }
                case 729: {
                    this.models[729] = new RangeModel(420479744);
                    break;
                }
                case 751: {
                    this.models[751] = new OptionModel(789578496);
                    break;
                }
                case 663: {
                    this.models[663] = new TerminalModelContainer(-686882048, 2, false);
                    break;
                }
                case 542: {
                    this.models[542] = new TerminalModelContainer(1578042112, 3, false);
                    break;
                }
                case 534: {
                    this.models[534] = new TerminalModelContainer(1443824384, 2, false);
                    break;
                }
                case 676: {
                    this.models[676] = new TerminalModelContainer(-468778240, 17, false);
                    break;
                }
                case 1040: {
                    this.models[1040] = new TerminalModelContainer(1343292160, 3, false);
                    break;
                }
                case 620: {
                    this.models[620] = new TerminalModelContainer(-1408302336, 1, false);
                    break;
                }
                case 660: {
                    this.models[660] = new ChoiceModel(-737213696);
                    break;
                }
                case 679: {
                    this.models[679] = new FastScrollingModel(-418446592);
                    break;
                }
                case 192: {
                    this.models[192] = new TerminalModelContainer(918272, 3, false);
                    break;
                }
                case 564: {
                    this.models[564] = new TerminalModelContainer(1947140864, 2, false);
                    break;
                }
                case 823: {
                    this.models[823] = new ChoiceModel(1997538048);
                    break;
                }
                case 223: {
                    this.models[223] = new BufferedListModel(521011968);
                    break;
                }
                case 742: {
                    this.models[742] = new ChoiceModel(638583552);
                    break;
                }
                case 252: {
                    this.models[252] = new TerminalModelContainer(1007551232, 1, false);
                    break;
                }
                case 619: {
                    this.models[619] = new TerminalModelContainer(-1425079552, 2, false);
                    break;
                }
                case 263: {
                    this.models[263] = new TerminalModelContainer(1192100608, 1, false);
                    break;
                }
                case 541: {
                    this.models[541] = new ButtonModel(1561264896);
                    break;
                }
                case 217: {
                    this.models[217] = new ButtonModel(420348672);
                    break;
                }
                case 701: {
                    this.models[701] = new ButtonModel(-49347840);
                    break;
                }
                case 657: {
                    this.models[657] = new ChoiceModel(-787545344);
                    break;
                }
                case 201: {
                    this.models[201] = new TerminalModelContainer(151913216, 3, false);
                    break;
                }
                case 183: {
                    this.models[183] = new TerminalModelContainer(-150142208, 1, false);
                    break;
                }
                case 1041: {
                    this.models[1041] = new BaseListModel(1360069376, null);
                    break;
                }
                case 603: {
                    this.models[603] = new TerminalModelContainer(-1693515008, 2, false);
                    break;
                }
                case 594: {
                    this.models[594] = new TerminalModelContainer(-1844509952, 5, false);
                    break;
                }
                case 694: {
                    this.models[694] = new TerminalModelContainer(-166788352, 2, false);
                    break;
                }
                case 668: {
                    this.models[668] = new LabelModel(-602995968);
                    break;
                }
                case 299: {
                    this.models[299] = new TerminalModelContainer(1796080384, 2, false);
                    break;
                }
                case 287: {
                    this.models[287] = new TerminalModelContainer(1594753792, 2, false);
                    break;
                }
                case 529: {
                    this.models[529] = new TerminalModelContainer(1359938304, 2, false);
                    break;
                }
                case 664: {
                    this.models[664] = new TerminalModelContainer(-670104832, 2, false);
                    break;
                }
                case 842: {
                    this.models[842] = new LabelModel(-1978662144);
                    break;
                }
                case 686: {
                    this.models[686] = new TerminalModelContainer(-301006080, 3, false);
                    break;
                }
                case 536: {
                    this.models[536] = new TerminalModelContainer(1477378816, 22, false);
                    break;
                }
                case 752: {
                    this.models[752] = new ChoiceModel(0x30100300);
                    break;
                }
                case 461: {
                    this.models[461] = new ButtonModel(219087616);
                    break;
                }
                case 727: {
                    this.models[727] = new LabelModel(386925312);
                    break;
                }
                case 1021: {
                    this.models[1021] = new OptionModel(1024525056);
                    break;
                }
                case 533: {
                    this.models[533] = new TerminalModelContainer(1427047168, 2, false);
                    break;
                }
                case 606: {
                    this.models[606] = new TerminalModelContainer(-1643183360, 2, false);
                    break;
                }
                case 633: {
                    this.models[633] = new TerminalModelContainer(-1190198528, 3, false);
                    break;
                }
                case 629: {
                    this.models[629] = new ChoiceModel(-1257307392);
                    break;
                }
                case 647: {
                    this.models[647] = new TerminalModelContainer(-955317504, 3, false);
                    break;
                }
                case 822: {
                    this.models[822] = new ChoiceModel(1980760832);
                    break;
                }
                case 550: {
                    this.models[550] = new ChoiceModel(1712259840);
                    break;
                }
                case 1117: {
                    this.models[1117] = new ChoiceModel(-1659829504);
                    break;
                }
                case 602: {
                    this.models[602] = new MenuModel(-1710292224);
                    break;
                }
                case 1105: {
                    this.models[1105] = new ChoiceModel(-1861156096);
                    break;
                }
                case 532: {
                    this.models[532] = new TerminalModelContainer(1410269952, 2, false);
                    break;
                }
                case 1042: {
                    this.models[1042] = new TerminalModelContainer(1376846592, 2, false);
                    break;
                }
                case 758: {
                    this.models[758] = new MenuModel(907019008);
                    break;
                }
                case 654: {
                    this.models[654] = new TerminalModelContainer(-837876992, 3, false);
                    break;
                }
                case 809: {
                    this.models[809] = new ChoiceModel(1762657024);
                    break;
                }
                case 468: {
                    this.models[468] = new TerminalModelContainer(336528128, 2, false);
                    break;
                }
                case 895: {
                    this.models[895] = new ChoiceModel(-1089469696);
                    break;
                }
                case 616: {
                    this.models[616] = new TerminalModelContainer(-1475411200, 2, false);
                    break;
                }
                case 618: {
                    this.models[618] = new TerminalModelContainer(-1441856768, 2, false);
                    break;
                }
                case 582: {
                    this.models[582] = new TerminalModelContainer(-2045836544, 14, false);
                    break;
                }
                case 538: {
                    this.models[538] = new TerminalModelContainer(1510933248, 2, false);
                    break;
                }
                case 275: {
                    this.models[275] = new TerminalModelContainer(1393427200, 4, true);
                    break;
                }
                case 625: {
                    this.models[625] = new BufferedListModel(-1324416256);
                    break;
                }
                case 784: {
                    this.models[784] = new OptionModel(1343226624);
                    break;
                }
                case 233: {
                    this.models[233] = new TerminalModelContainer(688784128, 2, false);
                    break;
                }
                case 267: {
                    this.models[267] = new TerminalModelContainer(1259209472, 2, false);
                    break;
                }
                case 1043: {
                    this.models[1043] = new BaseListModel(1393623808, null);
                    break;
                }
                case 584: {
                    this.models[584] = new TiledListModel(-2012282112, (MenuModel)this.getModel(-1995504896));
                    break;
                }
                case 846: {
                    this.models[846] = new ChoiceModel(-1911553280);
                    break;
                }
                case 553: {
                    this.models[553] = new LabelModel(1762591488);
                    break;
                }
                case 617: {
                    this.models[617] = new ChoiceModel(-1458633984);
                    break;
                }
                case 273: {
                    this.models[273] = new TerminalModelContainer(1359872768, 4, true);
                    break;
                }
                case 892: {
                    this.models[892] = new OptionModel(-1139801344);
                    break;
                }
                case 645: {
                    this.models[645] = new TerminalModelContainer(-988871936, 1, false);
                    break;
                }
                case 190: {
                    this.models[190] = new TerminalModelContainer(-32701696, 3, false);
                    break;
                }
                case 261: {
                    this.models[261] = new TerminalModelContainer(1158546176, 4, false);
                    break;
                }
                case 783: {
                    this.models[783] = new OptionModel(1326449408);
                    break;
                }
                case 1047: {
                    this.models[1047] = new RangeModel(1460732672);
                    break;
                }
                case 749: {
                    this.models[749] = new ChoiceModel(756024064);
                    break;
                }
                case 671: {
                    this.models[671] = new TerminalModelContainer(-552664320, 1, false);
                    break;
                }
                case 891: {
                    this.models[891] = new OptionModel(-1156578560);
                    break;
                }
                case 762: {
                    this.models[762] = new TerminalModelContainer(974127872, 2, false);
                    break;
                }
                case 731: {
                    this.models[731] = new LabelModel(454034176);
                    break;
                }
                case 155: {
                    this.models[155] = new TerminalModelContainer(-619904256, 2, false);
                    break;
                }
                case 841: {
                    this.models[841] = new LabelModel(-1995439360);
                    break;
                }
                case 266: {
                    this.models[266] = new ButtonModel(1242432256);
                    break;
                }
                case 852: {
                    this.models[852] = new ButtonModel(-1810889984);
                    break;
                }
                case 239: {
                    this.models[239] = new TerminalModelContainer(789447424, 2, false);
                    break;
                }
                case 1115: {
                    this.models[1115] = new ChoiceModel(-1693383936);
                    break;
                }
                case 830: {
                    this.models[830] = new ChoiceModel(2114978560);
                    break;
                }
                case 627: {
                    this.models[627] = new LabelModel(-1290861824);
                    break;
                }
                case 293: {
                    this.models[293] = new TerminalModelContainer(1695417088, 22, false);
                    break;
                }
                case 554: {
                    this.models[554] = new ButtonModel(1779368704);
                    break;
                }
                case 687: {
                    this.models[687] = new TerminalModelContainer(-284228864, 5, false);
                    break;
                }
                case 579: {
                    this.models[579] = new ButtonModel(-2096168192);
                    break;
                }
                case 653: {
                    this.models[653] = new TerminalModelContainer(-854654208, 2, false);
                    break;
                }
                case 722: {
                    this.models[722] = new BaseListModel(303039232, null);
                    break;
                }
                case 870: {
                    this.models[870] = new ChoiceModel(-1508900096);
                    break;
                }
                case 338: {
                    this.models[338] = new LabelModel(-1844575488);
                    break;
                }
                case 610: {
                    this.models[610] = new TerminalModelContainer(-1576074496, 2, false);
                    break;
                }
                case 869: {
                    this.models[869] = new ChoiceModel(-1525677312);
                    break;
                }
                case 352: {
                    this.models[352] = new ChoiceModel(-1609694464);
                    break;
                }
                case 785: {
                    this.models[785] = new OptionModel(1360003840);
                    break;
                }
                case 702: {
                    this.models[702] = new OptionModel(-32570624);
                    break;
                }
                case 1018: {
                    this.models[1018] = new ButtonModel(974193408);
                    break;
                }
                case 736: {
                    this.models[736] = new ButtonModel(537920256);
                    break;
                }
                case 580: {
                    this.models[580] = new ChoiceModel(-2079390976);
                    break;
                }
                case 570: {
                    this.models[570] = new TerminalModelContainer(2047804160, 3, false);
                    break;
                }
                case 577: {
                    this.models[577] = new ChoiceModel(-2129722624);
                    break;
                }
                case 1044: {
                    this.models[1044] = new LabelModel(1410401024);
                    break;
                }
                case 630: {
                    this.models[630] = new TerminalModelContainer(-1240530176, 3, false);
                    break;
                }
                case 228: {
                    this.models[228] = new TerminalModelContainer(604898048, 3, false);
                    break;
                }
                case 878: {
                    this.models[878] = new ChoiceModel(-1374682368);
                    break;
                }
                case 768: {
                    this.models[768] = new ResourceLocatorModel(1074791168);
                    break;
                }
                case 1022: {
                    this.models[1022] = new OptionModel(1041302272);
                    break;
                }
                case 260: {
                    this.models[260] = new TerminalModelContainer(1141768960, 2, false);
                    break;
                }
                case 748: {
                    this.models[748] = new ChoiceModel(739246848);
                    break;
                }
                case 639: {
                    this.models[639] = new TerminalModelContainer(-1089535232, 13, false);
                    break;
                }
                case 148: {
                    this.models[148] = new BaseListModel(-737344768, null);
                    break;
                }
                case 713: {
                    this.models[713] = new LabelModel(152044288);
                    break;
                }
                case 614: {
                    this.models[614] = new TerminalModelContainer(-1508965632, 2, false);
                    break;
                }
                case 467: {
                    this.models[467] = new RangeModel(319750912);
                    break;
                }
                case 707: {
                    this.models[707] = new ChoiceModel(0x3100300);
                    break;
                }
                case 646: {
                    this.models[646] = new TerminalModelContainer(-972094720, 2, false);
                    break;
                }
                case 528: {
                    this.models[528] = new TerminalModelContainer(1343161088, 3, false);
                    break;
                }
                case 225: {
                    this.models[225] = new BufferedListModel(554566400);
                    break;
                }
                case 678: {
                    this.models[678] = new TerminalModelContainer(-435223808, 12, true);
                    break;
                }
                case 593: {
                    this.models[593] = new TerminalModelContainer(-1861287168, 3, false);
                    break;
                }
                case 695: {
                    this.models[695] = new TerminalModelContainer(-150011136, 2, false);
                    break;
                }
                case 1017: {
                    this.models[1017] = new ButtonModel(957416192);
                    break;
                }
                case 875: {
                    this.models[875] = new ChoiceModel(-1425014016);
                    break;
                }
                case 315: {
                    this.models[315] = new TerminalModelContainer(2064515840, 2, false);
                    break;
                }
                case 884: {
                    this.models[884] = new ChoiceModel(-1274019072);
                    break;
                }
                case 621: {
                    this.models[621] = new TerminalModelContainer(-1391525120, 2, false);
                    break;
                }
                case 608: {
                    this.models[608] = new TerminalModelContainer(-1609628928, 2, false);
                    break;
                }
                case 272: {
                    this.models[272] = new TerminalModelContainer(1343095552, 4, true);
                    break;
                }
                case 294: {
                    this.models[294] = new TerminalModelContainer(1712194304, 2, false);
                    break;
                }
                case 604: {
                    this.models[604] = new TerminalModelContainer(-1676737792, 2, false);
                    break;
                }
                case 656: {
                    this.models[656] = new ResourceLocatorModel(-804322560);
                    break;
                }
                case 1118: {
                    this.models[1118] = new ChoiceModel(-1643052288);
                    break;
                }
                case 465: {
                    this.models[465] = new ButtonModel(286196480);
                    break;
                }
                case 334: {
                    this.models[334] = new LabelModel(-1911684352);
                    break;
                }
                case 637: {
                    this.models[637] = new TerminalModelContainer(-1123089664, 22, false);
                    break;
                }
                case 801: {
                    this.models[801] = new ChoiceModel(1628439296);
                    break;
                }
                case 552: {
                    this.models[552] = new ChoiceModel(1745814272);
                    break;
                }
                case 230: {
                    this.models[230] = new ChoiceModel(638452480);
                    break;
                }
                case 983: {
                    this.models[983] = new ChoiceModel(386990848);
                    break;
                }
                case 829: {
                    this.models[829] = new ChoiceModel(2098201344);
                    break;
                }
                case 573: {
                    this.models[573] = new TerminalModelContainer(2098135808, 2, false);
                    break;
                }
                case 622: {
                    this.models[622] = new TerminalModelContainer(-1374747904, 2, false);
                    break;
                }
                case 270: {
                    this.models[270] = new TerminalModelContainer(1309541120, 4, true);
                    break;
                }
                case 440: {
                    this.models[440] = new BufferedListModel(-133299456);
                    break;
                }
                case 655: {
                    this.models[655] = new TerminalModelContainer(-821099776, 2, false);
                    break;
                }
                case 226: {
                    this.models[226] = new BufferedListModel(571343616);
                    break;
                }
                case 609: {
                    this.models[609] = new TerminalModelContainer(-1592851712, 3, false);
                    break;
                }
                case 893: {
                    this.models[893] = new OptionModel(-1123024128);
                    break;
                }
                case 691: {
                    this.models[691] = new ChoiceModel(-217120000);
                    break;
                }
                case 452: {
                    this.models[452] = new ChoiceModel(68092672);
                    break;
                }
                case 292: {
                    this.models[292] = new TerminalModelContainer(1678639872, 12, true);
                    break;
                }
                case 259: {
                    this.models[259] = new ChoiceModel(1124991744);
                    break;
                }
                case 903: {
                    this.models[903] = new ChoiceModel(-955251968);
                    break;
                }
                case 222: {
                    this.models[222] = new BufferedListModel(504234752);
                    break;
                }
                case 684: {
                    this.models[684] = new LabelModel(-334560512);
                    break;
                }
                case 880: {
                    this.models[880] = new VirtualButtonModel(-1341127936);
                    break;
                }
                case 1019: {
                    this.models[1019] = new ButtonModel(990970624);
                    break;
                }
                case 208: {
                    this.models[208] = new ChoiceModel(269353728);
                    break;
                }
                case 670: {
                    this.models[670] = new TerminalModelContainer(-569441536, 1, false);
                    break;
                }
                case 563: {
                    this.models[563] = new TerminalModelContainer(1930363648, 2, false);
                    break;
                }
                case 1045: {
                    this.models[1045] = new LabelModel(1427178240);
                    break;
                }
                case 692: {
                    this.models[692] = new TerminalModelContainer(-200342784, 3, false);
                    break;
                }
                case 286: {
                    this.models[286] = new TerminalModelContainer(1577976576, 4, true);
                    break;
                }
                case 200: {
                    this.models[200] = new TerminalModelContainer(135136000, 3, false);
                    break;
                }
                case 448: {
                    this.models[448] = new BaseListModel(983808, null);
                    break;
                }
                case 611: {
                    this.models[611] = new ChoiceModel(-1559297280);
                    break;
                }
                case 665: {
                    this.models[665] = new TerminalModelContainer(-653327616, 3, false);
                    break;
                }
                case 1023: {
                    this.models[1023] = new ButtonModel(1058079488);
                    break;
                }
                case 349: {
                    this.models[349] = new LabelModel(-1660026112);
                    break;
                }
                case 242: {
                    this.models[242] = new TerminalModelContainer(839779072, 2, false);
                    break;
                }
                case 206: {
                    this.models[206] = new TerminalModelContainer(0xE0E0300, 3, false);
                    break;
                }
                case 194: {
                    this.models[194] = new TerminalModelContainer(34472704, 2, false);
                    break;
                }
                case 720: {
                    this.models[720] = new BaseListModel(0x10100300, (MenuModel)this.getModel(-1710292224));
                    break;
                }
                case 215: {
                    this.models[215] = new ButtonModel(386794240);
                    break;
                }
                case 574: {
                    this.models[574] = new BufferedDynamicListModel(2114913024);
                    break;
                }
                case 1046: {
                    this.models[1046] = new ChoiceModel(1443955456);
                    break;
                }
                case 464: {
                    this.models[464] = new ButtonModel(269419264);
                    break;
                }
                case 844: {
                    this.models[844] = new LabelModel(-1945107712);
                    break;
                }
                case 601: {
                    this.models[601] = new TiledListModel(-1727069440, (MenuModel)this.getModel(-1710292224));
                    break;
                }
                case 904: {
                    this.models[904] = new ChoiceModel(-938474752);
                    break;
                }
                case 843: {
                    this.models[843] = new ResourceLocatorModel(-1961884928);
                    break;
                }
                case 632: {
                    this.models[632] = new FastScrollingModel(-1206975744);
                    break;
                }
                case 831: {
                    this.models[831] = new ButtonModel(2131755776);
                    break;
                }
                case 203: {
                    this.models[203] = new TerminalModelContainer(185467648, 3, false);
                    break;
                }
                case 658: {
                    this.models[658] = new SpellerModel(-770768128);
                    break;
                }
                case 958: {
                    this.models[958] = new ChoiceModel(-32505088);
                    break;
                }
                case 950: {
                    this.models[950] = new ChoiceModel(-166722816);
                    break;
                }
                case 237: {
                    this.models[237] = new TerminalModelContainer(755892992, 2, false);
                    break;
                }
                case 615: {
                    this.models[615] = new TerminalModelContainer(-1492188416, 1, false);
                    break;
                }
                case 283: {
                    this.models[283] = new TerminalModelContainer(1527644928, 4, true);
                    break;
                }
                case 249: {
                    this.models[249] = new TerminalModelContainer(957219584, 2, false);
                    break;
                }
                case 256: {
                    this.models[256] = new TerminalModelContainer(1074660096, 2, false);
                    break;
                }
                case 191: {
                    this.models[191] = new TerminalModelContainer(-15924480, 12, true);
                    break;
                }
                case 1116: {
                    this.models[1116] = new ChoiceModel(-1676606720);
                    break;
                }
                case 276: {
                    this.models[276] = new TerminalModelContainer(1410204416, 4, true);
                    break;
                }
                case 295: {
                    this.models[295] = new TerminalModelContainer(1728971520, 1, false);
                    break;
                }
                case 221: {
                    this.models[221] = new BufferedListModel(487457536);
                    break;
                }
                case 674: {
                    this.models[674] = new TerminalModelContainer(-502332672, 1, false);
                    break;
                }
                case 269: {
                    this.models[269] = new TerminalModelContainer(1292763904, 2, false);
                    break;
                }
                case 642: {
                    this.models[642] = new TerminalModelContainer(-1039203584, 2, false);
                    break;
                }
                case 728: {
                    this.models[728] = new LabelModel(403702528);
                    break;
                }
                case 361: {
                    this.models[361] = new LabelModel(-1458699520);
                    break;
                }
                case 531: {
                    this.models[531] = new TerminalModelContainer(1393492736, 2, false);
                    break;
                }
                case 227: {
                    this.models[227] = new BufferedListModel(588120832);
                    break;
                }
                case 683: {
                    this.models[683] = new TerminalModelContainer(-351337728, 2, false);
                    break;
                }
                case 236: {
                    this.models[236] = new TerminalModelContainer(739115776, 2, false);
                    break;
                }
                case 849: {
                    this.models[849] = new ChoiceModel(-1861221632);
                    break;
                }
                case 207: {
                    this.models[207] = new TerminalModelContainer(252576512, 3, false);
                    break;
                }
                case 730: {
                    this.models[730] = new LabelModel(437256960);
                    break;
                }
                case 597: {
                    this.models[597] = new BaseListModel(-1794178304, null);
                    break;
                }
                case 224: {
                    this.models[224] = new BufferedListModel(537789184);
                    break;
                }
                case 699: {
                    this.models[699] = new TerminalModelContainer(-82902272, 2, false);
                    break;
                }
                case 714: {
                    this.models[714] = new LabelModel(168821504);
                    break;
                }
                case 649: {
                    this.models[649] = new TerminalModelContainer(-921763072, 5, false);
                    break;
                }
                case 1106: {
                    this.models[1106] = new ChoiceModel(-1844378880);
                    break;
                }
                case 248: {
                    this.models[248] = new TerminalModelContainer(940442368, 2, false);
                    break;
                }
                case 545: {
                    this.models[545] = new TerminalModelContainer(1628373760, 3, false);
                    break;
                }
                case 613: {
                    this.models[613] = new TerminalModelContainer(-1525742848, 2, false);
                    break;
                }
                case 635: {
                    this.models[635] = new TerminalModelContainer(-1156644096, 3, false);
                    break;
                }
                case 562: {
                    this.models[562] = new TerminalModelContainer(1913586432, 5, false);
                    break;
                }
                case 689: {
                    this.models[689] = new TerminalModelContainer(-250674432, 3, false);
                    break;
                }
                case 888: {
                    this.models[888] = new ChoiceModel(-1206910208);
                    break;
                }
                case 648: {
                    this.models[648] = new TerminalModelContainer(-938540288, 3, false);
                    break;
                }
                case 709: {
                    this.models[709] = new BufferedListModel(84935424);
                    break;
                }
                case 808: {
                    this.models[808] = new ChoiceModel(1745879808);
                    break;
                }
                case 669: {
                    this.models[669] = new TerminalModelContainer(-586218752, 2, false);
                    break;
                }
                case 636: {
                    this.models[636] = new TerminalModelContainer(-1139866880, 2, false);
                    break;
                }
                case 539: {
                    this.models[539] = new ButtonModel(1527710464);
                    break;
                }
                case 204: {
                    this.models[204] = new TerminalModelContainer(202244864, 3, false);
                    break;
                }
                case 576: {
                    this.models[576] = new ButtonModel(-2146499840);
                    break;
                }
                case 693: {
                    this.models[693] = new TerminalModelContainer(-183565568, 2, false);
                    break;
                }
                case 351: {
                    this.models[351] = new LabelModel(-1626471680);
                    break;
                }
                case 587: {
                    this.models[587] = new TerminalModelContainer(-1961950464, 2, false);
                    break;
                }
                case 219: {
                    this.models[219] = new ResourceLocatorModel(453903104);
                    break;
                }
                default: {
                    MediaModelBank.getModelLogChannel().log(10000, "[MediaModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public MediaModelBank() {
        super(2, 1119, 394);
        this.modelIDs = new int[394];
        this.modelIDs[0] = -888208640;
        this.modelIDs[1] = 1645085440;
        this.modelIDs[2] = -485555456;
        this.modelIDs[3] = -1827667200;
        this.modelIDs[4] = -1072758016;
        this.modelIDs[5] = 990774016;
        this.modelIDs[6] = -1878064384;
        this.modelIDs[7] = 2047869696;
        this.modelIDs[8] = 0x100300;
        this.modelIDs[9] = 135267072;
        this.modelIDs[10] = 1024328448;
        this.modelIDs[11] = -1106312448;
        this.modelIDs[12] = -1055980800;
        this.modelIDs[13] = -703790336;
        this.modelIDs[14] = -1877998848;
        this.modelIDs[15] = 1376649984;
        this.modelIDs[16] = -1072823552;
        this.modelIDs[17] = -619773184;
        this.modelIDs[18] = -217251072;
        this.modelIDs[19] = 1594819328;
        this.modelIDs[20] = 2030961408;
        this.modelIDs[21] = -267451648;
        this.modelIDs[22] = 1225655040;
        this.modelIDs[23] = 2014249728;
        this.modelIDs[24] = 0x330E0300;
        this.modelIDs[25] = -1810955520;
        this.modelIDs[26] = -636550400;
        this.modelIDs[27] = 1108214528;
        this.modelIDs[28] = 1896809216;
        this.modelIDs[29] = 1561199360;
        this.modelIDs[30] = -1894776064;
        this.modelIDs[31] = 1645150976;
        this.modelIDs[32] = -653458688;
        this.modelIDs[33] = -1777401088;
        this.modelIDs[34] = -1945173248;
        this.modelIDs[35] = -66125056;
        this.modelIDs[36] = -452001024;
        this.modelIDs[37] = 1846477568;
        this.modelIDs[38] = 0x30F0300;
        this.modelIDs[39] = -49282304;
        this.modelIDs[40] = -1928330496;
        this.modelIDs[41] = 1326383872;
        this.modelIDs[42] = 1510867712;
        this.modelIDs[43] = -1223752960;
        this.modelIDs[44] = 823001856;
        this.modelIDs[45] = -904985856;
        this.modelIDs[46] = 1729037056;
        this.modelIDs[47] = 1611596544;
        this.modelIDs[48] = 1494156032;
        this.modelIDs[49] = 370017024;
        this.modelIDs[50] = -1475476736;
        this.modelIDs[51] = -2062613760;
        this.modelIDs[52] = -1005649152;
        this.modelIDs[53] = -1341193472;
        this.modelIDs[54] = 722338560;
        this.modelIDs[55] = -1995504896;
        this.modelIDs[56] = 235864832;
        this.modelIDs[57] = 1611662080;
        this.modelIDs[58] = -1911618816;
        this.modelIDs[59] = -1542520064;
        this.modelIDs[60] = -2112945408;
        this.modelIDs[61] = -1357970688;
        this.modelIDs[62] = -66059520;
        this.modelIDs[63] = -670235904;
        this.modelIDs[64] = -1173421312;
        this.modelIDs[65] = 1661928192;
        this.modelIDs[66] = -1022426368;
        this.modelIDs[67] = 403571456;
        this.modelIDs[68] = 1376715520;
        this.modelIDs[69] = -1760623872;
        this.modelIDs[70] = -1928396032;
        this.modelIDs[71] = 1292960512;
        this.modelIDs[72] = -720436480;
        this.modelIDs[73] = 1963983616;
        this.modelIDs[74] = 1242563328;
        this.modelIDs[75] = 1863254784;
        this.modelIDs[76] = 1275986688;
        this.modelIDs[77] = 470811392;
        this.modelIDs[78] = 2064581376;
        this.modelIDs[79] = 470680320;
        this.modelIDs[80] = 1326318336;
        this.modelIDs[81] = 2047738624;
        this.modelIDs[82] = -384892160;
        this.modelIDs[83] = 1208877824;
        this.modelIDs[84] = -535887104;
        this.modelIDs[85] = 957350656;
        this.modelIDs[86] = 1242497792;
        this.modelIDs[87] = 873530112;
        this.modelIDs[88] = 722469632;
        this.modelIDs[89] = 2031026944;
        this.modelIDs[90] = 1880032000;
        this.modelIDs[91] = 118358784;
        this.modelIDs[92] = 1544487680;
        this.modelIDs[93] = -703659264;
        this.modelIDs[94] = 906887936;
        this.modelIDs[95] = 1309737728;
        this.modelIDs[96] = 672006912;
        this.modelIDs[97] = 655360768;
        this.modelIDs[98] = 1695482624;
        this.modelIDs[99] = -636681472;
        this.modelIDs[100] = 1376781056;
        this.modelIDs[101] = 34603776;
        this.modelIDs[102] = 873333504;
        this.modelIDs[103] = -1626406144;
        this.modelIDs[104] = 2131690240;
        this.modelIDs[105] = -1794112768;
        this.modelIDs[106] = -1626340608;
        this.modelIDs[107] = 0x11100300;
        this.modelIDs[108] = 1058013952;
        this.modelIDs[109] = -871431424;
        this.modelIDs[110] = 168887040;
        this.modelIDs[111] = 1645216512;
        this.modelIDs[112] = -317783296;
        this.modelIDs[113] = -401669376;
        this.modelIDs[114] = -1274084608;
        this.modelIDs[115] = 353239808;
        this.modelIDs[116] = 437125888;
        this.modelIDs[117] = -1894841600;
        this.modelIDs[118] = 0x3E0E0300;
        this.modelIDs[119] = -1928461568;
        this.modelIDs[120] = -1827732736;
        this.modelIDs[121] = 2081358592;
        this.modelIDs[122] = 1812923136;
        this.modelIDs[123] = 923665152;
        this.modelIDs[124] = -519109888;
        this.modelIDs[125] = -753990912;
        this.modelIDs[126] = 621675264;
        this.modelIDs[127] = 168690432;
        this.modelIDs[128] = 1309606656;
        this.modelIDs[129] = -15793408;
        this.modelIDs[130] = 1678705408;
        this.modelIDs[131] = -2113010944;
        this.modelIDs[132] = 219022080;
        this.modelIDs[133] = -1659960576;
        this.modelIDs[134] = 1796145920;
        this.modelIDs[135] = 17761024;
        this.modelIDs[136] = 1057882880;
        this.modelIDs[137] = 252707584;
        this.modelIDs[138] = -904920320;
        this.modelIDs[139] = -1307639040;
        this.modelIDs[140] = -1827798272;
        this.modelIDs[141] = -1810824448;
        this.modelIDs[142] = -1978727680;
        this.modelIDs[143] = -368114944;
        this.modelIDs[144] = 973996800;
        this.modelIDs[145] = -2029059328;
        this.modelIDs[146] = 1326514944;
        this.modelIDs[147] = 1611531008;
        this.modelIDs[148] = 1007747840;
        this.modelIDs[149] = 0x300E0300;
        this.modelIDs[150] = 135201536;
        this.modelIDs[151] = -1592917248;
        this.modelIDs[152] = 420479744;
        this.modelIDs[153] = 789578496;
        this.modelIDs[154] = -686882048;
        this.modelIDs[155] = 1578042112;
        this.modelIDs[156] = 1443824384;
        this.modelIDs[157] = -468778240;
        this.modelIDs[158] = 1343292160;
        this.modelIDs[159] = -1408302336;
        this.modelIDs[160] = -737213696;
        this.modelIDs[161] = -418446592;
        this.modelIDs[162] = 918272;
        this.modelIDs[163] = 1947140864;
        this.modelIDs[164] = 1997538048;
        this.modelIDs[165] = 521011968;
        this.modelIDs[166] = 638583552;
        this.modelIDs[167] = 1007551232;
        this.modelIDs[168] = -1425079552;
        this.modelIDs[169] = 1192100608;
        this.modelIDs[170] = 1561264896;
        this.modelIDs[171] = 420348672;
        this.modelIDs[172] = -49347840;
        this.modelIDs[173] = -787545344;
        this.modelIDs[174] = 151913216;
        this.modelIDs[175] = -150142208;
        this.modelIDs[176] = 1360069376;
        this.modelIDs[177] = -1693515008;
        this.modelIDs[178] = -1844509952;
        this.modelIDs[179] = -166788352;
        this.modelIDs[180] = -602995968;
        this.modelIDs[181] = 1796080384;
        this.modelIDs[182] = 1594753792;
        this.modelIDs[183] = 1359938304;
        this.modelIDs[184] = -670104832;
        this.modelIDs[185] = -1978662144;
        this.modelIDs[186] = -301006080;
        this.modelIDs[187] = 1477378816;
        this.modelIDs[188] = 0x30100300;
        this.modelIDs[189] = 219087616;
        this.modelIDs[190] = 386925312;
        this.modelIDs[191] = 1024525056;
        this.modelIDs[192] = 1427047168;
        this.modelIDs[193] = -1643183360;
        this.modelIDs[194] = -1190198528;
        this.modelIDs[195] = -1257307392;
        this.modelIDs[196] = -955317504;
        this.modelIDs[197] = 1980760832;
        this.modelIDs[198] = 1712259840;
        this.modelIDs[199] = -1659829504;
        this.modelIDs[200] = -1710292224;
        this.modelIDs[201] = -1861156096;
        this.modelIDs[202] = 1410269952;
        this.modelIDs[203] = 1376846592;
        this.modelIDs[204] = 907019008;
        this.modelIDs[205] = -837876992;
        this.modelIDs[206] = 1762657024;
        this.modelIDs[207] = 336528128;
        this.modelIDs[208] = -1089469696;
        this.modelIDs[209] = -1475411200;
        this.modelIDs[210] = -1441856768;
        this.modelIDs[211] = -2045836544;
        this.modelIDs[212] = 1510933248;
        this.modelIDs[213] = 1393427200;
        this.modelIDs[214] = -1324416256;
        this.modelIDs[215] = 1343226624;
        this.modelIDs[216] = 688784128;
        this.modelIDs[217] = 1259209472;
        this.modelIDs[218] = 1393623808;
        this.modelIDs[219] = -2012282112;
        this.modelIDs[220] = -1911553280;
        this.modelIDs[221] = 1762591488;
        this.modelIDs[222] = -1458633984;
        this.modelIDs[223] = 1359872768;
        this.modelIDs[224] = -1139801344;
        this.modelIDs[225] = -988871936;
        this.modelIDs[226] = -32701696;
        this.modelIDs[227] = 1158546176;
        this.modelIDs[228] = 1326449408;
        this.modelIDs[229] = 1460732672;
        this.modelIDs[230] = 756024064;
        this.modelIDs[231] = -552664320;
        this.modelIDs[232] = -1156578560;
        this.modelIDs[233] = 974127872;
        this.modelIDs[234] = 454034176;
        this.modelIDs[235] = -619904256;
        this.modelIDs[236] = -1995439360;
        this.modelIDs[237] = 1242432256;
        this.modelIDs[238] = -1810889984;
        this.modelIDs[239] = 789447424;
        this.modelIDs[240] = -1693383936;
        this.modelIDs[241] = 2114978560;
        this.modelIDs[242] = -1290861824;
        this.modelIDs[243] = 1695417088;
        this.modelIDs[244] = 1779368704;
        this.modelIDs[245] = -284228864;
        this.modelIDs[246] = -2096168192;
        this.modelIDs[247] = -854654208;
        this.modelIDs[248] = 303039232;
        this.modelIDs[249] = -1508900096;
        this.modelIDs[250] = -1844575488;
        this.modelIDs[251] = -1576074496;
        this.modelIDs[252] = -1525677312;
        this.modelIDs[253] = -1609694464;
        this.modelIDs[254] = 1360003840;
        this.modelIDs[255] = -32570624;
        this.modelIDs[256] = 974193408;
        this.modelIDs[257] = 537920256;
        this.modelIDs[258] = -2079390976;
        this.modelIDs[259] = 2047804160;
        this.modelIDs[260] = -2129722624;
        this.modelIDs[261] = 1410401024;
        this.modelIDs[262] = -1240530176;
        this.modelIDs[263] = 604898048;
        this.modelIDs[264] = -1374682368;
        this.modelIDs[265] = 1074791168;
        this.modelIDs[266] = 1041302272;
        this.modelIDs[267] = 1141768960;
        this.modelIDs[268] = 739246848;
        this.modelIDs[269] = -1089535232;
        this.modelIDs[270] = -737344768;
        this.modelIDs[271] = 152044288;
        this.modelIDs[272] = -1508965632;
        this.modelIDs[273] = 319750912;
        this.modelIDs[274] = 0x3100300;
        this.modelIDs[275] = -972094720;
        this.modelIDs[276] = 1343161088;
        this.modelIDs[277] = 554566400;
        this.modelIDs[278] = -435223808;
        this.modelIDs[279] = -1861287168;
        this.modelIDs[280] = -150011136;
        this.modelIDs[281] = 957416192;
        this.modelIDs[282] = -1425014016;
        this.modelIDs[283] = 2064515840;
        this.modelIDs[284] = -1274019072;
        this.modelIDs[285] = -1391525120;
        this.modelIDs[286] = -1609628928;
        this.modelIDs[287] = 1343095552;
        this.modelIDs[288] = 1712194304;
        this.modelIDs[289] = -1676737792;
        this.modelIDs[290] = -804322560;
        this.modelIDs[291] = -1643052288;
        this.modelIDs[292] = 286196480;
        this.modelIDs[293] = -1911684352;
        this.modelIDs[294] = -1123089664;
        this.modelIDs[295] = 1628439296;
        this.modelIDs[296] = 1745814272;
        this.modelIDs[297] = 638452480;
        this.modelIDs[298] = 386990848;
        this.modelIDs[299] = 2098201344;
        this.modelIDs[300] = 2098135808;
        this.modelIDs[301] = -1374747904;
        this.modelIDs[302] = 1309541120;
        this.modelIDs[303] = -133299456;
        this.modelIDs[304] = -821099776;
        this.modelIDs[305] = 571343616;
        this.modelIDs[306] = -1592851712;
        this.modelIDs[307] = -1123024128;
        this.modelIDs[308] = -217120000;
        this.modelIDs[309] = 68092672;
        this.modelIDs[310] = 1678639872;
        this.modelIDs[311] = 1124991744;
        this.modelIDs[312] = -955251968;
        this.modelIDs[313] = 504234752;
        this.modelIDs[314] = -334560512;
        this.modelIDs[315] = -1341127936;
        this.modelIDs[316] = 990970624;
        this.modelIDs[317] = 269353728;
        this.modelIDs[318] = -569441536;
        this.modelIDs[319] = 1930363648;
        this.modelIDs[320] = 1427178240;
        this.modelIDs[321] = -200342784;
        this.modelIDs[322] = 1577976576;
        this.modelIDs[323] = 135136000;
        this.modelIDs[324] = 983808;
        this.modelIDs[325] = -1559297280;
        this.modelIDs[326] = -653327616;
        this.modelIDs[327] = 1058079488;
        this.modelIDs[328] = -1660026112;
        this.modelIDs[329] = 839779072;
        this.modelIDs[330] = 0xE0E0300;
        this.modelIDs[331] = 34472704;
        this.modelIDs[332] = 0x10100300;
        this.modelIDs[333] = 386794240;
        this.modelIDs[334] = 2114913024;
        this.modelIDs[335] = 1443955456;
        this.modelIDs[336] = 269419264;
        this.modelIDs[337] = -1945107712;
        this.modelIDs[338] = -1727069440;
        this.modelIDs[339] = -938474752;
        this.modelIDs[340] = -1961884928;
        this.modelIDs[341] = -1206975744;
        this.modelIDs[342] = 2131755776;
        this.modelIDs[343] = 185467648;
        this.modelIDs[344] = -770768128;
        this.modelIDs[345] = -32505088;
        this.modelIDs[346] = -166722816;
        this.modelIDs[347] = 755892992;
        this.modelIDs[348] = -1492188416;
        this.modelIDs[349] = 1527644928;
        this.modelIDs[350] = 957219584;
        this.modelIDs[351] = 1074660096;
        this.modelIDs[352] = -15924480;
        this.modelIDs[353] = -1676606720;
        this.modelIDs[354] = 1410204416;
        this.modelIDs[355] = 1728971520;
        this.modelIDs[356] = 487457536;
        this.modelIDs[357] = -502332672;
        this.modelIDs[358] = 1292763904;
        this.modelIDs[359] = -1039203584;
        this.modelIDs[360] = 403702528;
        this.modelIDs[361] = -1458699520;
        this.modelIDs[362] = 1393492736;
        this.modelIDs[363] = 588120832;
        this.modelIDs[364] = -351337728;
        this.modelIDs[365] = 739115776;
        this.modelIDs[366] = -1861221632;
        this.modelIDs[367] = 252576512;
        this.modelIDs[368] = 437256960;
        this.modelIDs[369] = -1794178304;
        this.modelIDs[370] = 537789184;
        this.modelIDs[371] = -82902272;
        this.modelIDs[372] = 168821504;
        this.modelIDs[373] = -921763072;
        this.modelIDs[374] = -1844378880;
        this.modelIDs[375] = 940442368;
        this.modelIDs[376] = 1628373760;
        this.modelIDs[377] = -1525742848;
        this.modelIDs[378] = -1156644096;
        this.modelIDs[379] = 1913586432;
        this.modelIDs[380] = -250674432;
        this.modelIDs[381] = -1206910208;
        this.modelIDs[382] = -938540288;
        this.modelIDs[383] = 84935424;
        this.modelIDs[384] = 1745879808;
        this.modelIDs[385] = -586218752;
        this.modelIDs[386] = -1139866880;
        this.modelIDs[387] = 1527710464;
        this.modelIDs[388] = 202244864;
        this.modelIDs[389] = -2146499840;
        this.modelIDs[390] = -183565568;
        this.modelIDs[391] = -1626471680;
        this.modelIDs[392] = -1961950464;
        this.modelIDs[393] = 453903104;
    }
}

