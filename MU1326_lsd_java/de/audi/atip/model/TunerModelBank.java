/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BrowserModel;
import de.audi.atip.hmi.model.BufferedButtonModel;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.hmi.model.TextfieldModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.model.ICoreTunerModelBank;
import de.audi.atip.model.IEvoTunerModelBank;

public class TunerModelBank
extends AbstractModelBank
implements ICoreTunerModelBank,
IEvoTunerModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 156: {
                    this.models[156] = new LabelModel(1015480576);
                    break;
                }
                case 868: {
                    this.models[868] = new LabelModel(76153088);
                    break;
                }
                case 704: {
                    this.models[704] = new LabelModel(1619591424);
                    break;
                }
                case 763: {
                    this.models[763] = new ButtonModel(-1685520128);
                    break;
                }
                case 522: {
                    this.models[522] = new ChoiceModel(-1433927424);
                    break;
                }
                case 583: {
                    this.models[583] = new ChoiceModel(-410517248);
                    break;
                }
                case 152: {
                    this.models[152] = new LabelModel(948371712);
                    break;
                }
                case 654: {
                    this.models[654] = new LabelModel(780730624);
                    break;
                }
                case 869: {
                    this.models[869] = new LabelModel(92930304);
                    break;
                }
                case 598: {
                    this.models[598] = new LabelModel(-158859008);
                    break;
                }
                case 285: {
                    this.models[285] = new ButtonModel(-1115225856);
                    break;
                }
                case 434: {
                    this.models[434] = new ChoiceModel(1384644864);
                    break;
                }
                case 396: {
                    this.models[396] = new ChoiceModel(747110656);
                    break;
                }
                case 227: {
                    this.models[227] = new ChoiceModel(-2088304384);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(528941312);
                    break;
                }
                case 717: {
                    this.models[717] = new BaseListModel(1837695232, (MenuModel)this.getModel(-829947648));
                    break;
                }
                case 627: {
                    this.models[627] = new LabelModel(327745792);
                    break;
                }
                case 659: {
                    this.models[659] = new ButtonModel(864616704);
                    break;
                }
                case 753: {
                    this.models[753] = new VirtualButtonModel(-1853292288);
                    break;
                }
                case 809: {
                    this.models[809] = new ButtonModel(-913768192);
                    break;
                }
                case 430: {
                    this.models[430] = new TerminalModelContainer(1317536000, 2, false);
                    break;
                }
                case 540: {
                    this.models[540] = new ChoiceModel(-1131937536);
                    break;
                }
                case 736: {
                    this.models[736] = new ChoiceModel(-2138504960);
                    break;
                }
                case 378: {
                    this.models[378] = new ButtonModel(445120768);
                    break;
                }
                case 321: {
                    this.models[321] = new ButtonModel(-511246080);
                    break;
                }
                case 466: {
                    this.models[466] = new BaseListModel(1921515776, (MenuModel)this.getModel(-678952704));
                    break;
                }
                case 421: {
                    this.models[421] = new TerminalModelContainer(1166541056, 3, false);
                    break;
                }
                case 375: {
                    this.models[375] = new ChoiceModel(394789120);
                    break;
                }
                case 711: {
                    this.models[711] = new ChoiceModel(1737031936);
                    break;
                }
                case 195: {
                    this.models[195] = new TerminalModelContainer(1669792000, 2, false);
                    break;
                }
                case 299: {
                    this.models[299] = new ChoiceModel(-880344832);
                    break;
                }
                case 674: {
                    this.models[674] = new ButtonModel(1116274944);
                    break;
                }
                case 470: {
                    this.models[470] = new OptionModel(1988624640);
                    break;
                }
                case 697: {
                    this.models[697] = new ButtonModel(1502150912);
                    break;
                }
                case 593: {
                    this.models[593] = new ButtonModel(-242745088);
                    break;
                }
                case 927: {
                    this.models[927] = new LabelModel(1066008832);
                    break;
                }
                case 579: {
                    this.models[579] = new ButtonModel(-477626112);
                    break;
                }
                case 170: {
                    this.models[170] = new TerminalModelContainer(1250361600, 1, false);
                    break;
                }
                case 250: {
                    this.models[250] = new ButtonModel(-1702428416);
                    break;
                }
                case 159: {
                    this.models[159] = new ResourceLocatorModel(1065812224);
                    break;
                }
                case 487: {
                    this.models[487] = new ChoiceModel(-2021129984);
                    break;
                }
                case 620: {
                    this.models[620] = new MatchspellerModel(210305280);
                    break;
                }
                case 509: {
                    this.models[509] = new ChoiceModel(-1652031232);
                    break;
                }
                case 918: {
                    this.models[918] = new LabelModel(915013888);
                    break;
                }
                case 783: {
                    this.models[783] = new LabelModel(-1349975808);
                    break;
                }
                case 642: {
                    this.models[642] = new LabelModel(579404032);
                    break;
                }
                case 558: {
                    this.models[558] = new MenuModel(-829947648);
                    break;
                }
                case 160: {
                    this.models[160] = new ChoiceModel(1082589440);
                    break;
                }
                case 731: {
                    this.models[731] = new LabelModel(2072576256);
                    break;
                }
                case 510: {
                    this.models[510] = new ChoiceModel(-1635254016);
                    break;
                }
                case 428: {
                    this.models[428] = new ButtonModel(1283981568);
                    break;
                }
                case 134: {
                    this.models[134] = new TerminalModelContainer(646381824, 3, false);
                    break;
                }
                case 467: {
                    this.models[467] = new BaseListModel(1938292992, (MenuModel)this.getModel(-1299709696));
                    break;
                }
                case 795: {
                    this.models[795] = new ButtonModel(-1148649216);
                    break;
                }
                case 530: {
                    this.models[530] = new MenuModel(-1299709696);
                    break;
                }
                case 750: {
                    this.models[750] = new BaseListModel(-1903623936, null);
                    break;
                }
                case 390: {
                    this.models[390] = new ChoiceModel(646447360);
                    break;
                }
                case 707: {
                    this.models[707] = new MenuModel(1669923072);
                    break;
                }
                case 920: {
                    this.models[920] = new BaseListModel(948568320, null);
                    break;
                }
                case 568: {
                    this.models[568] = new MenuModel(-662175488);
                    break;
                }
                case 605: {
                    this.models[605] = new ChoiceModel(-41418496);
                    break;
                }
                case 719: {
                    this.models[719] = new ChoiceModel(1871249664);
                    break;
                }
                case 356: {
                    this.models[356] = new ChoiceModel(76022016);
                    break;
                }
                case 737: {
                    this.models[737] = new ResourceLocatorModel(-2121727744);
                    break;
                }
                case 544: {
                    this.models[544] = new BaseListModel(-1064828672, null);
                    break;
                }
                case 547: {
                    this.models[547] = new ButtonModel(-1014497024);
                    break;
                }
                case 609: {
                    this.models[609] = new ChoiceModel(25755904);
                    break;
                }
                case 143: {
                    this.models[143] = new TerminalModelContainer(797376768, 3, false);
                    break;
                }
                case 513: {
                    this.models[513] = new ButtonModel(-1584922368);
                    break;
                }
                case 350: {
                    this.models[350] = new TerminalModelContainer(-24706816, 3, false);
                    break;
                }
                case 308: {
                    this.models[308] = new ButtonModel(-729349888);
                    break;
                }
                case 760: {
                    this.models[760] = new ResourceLocatorModel(-1735851776);
                    break;
                }
                case 640: {
                    this.models[640] = new LabelModel(545849600);
                    break;
                }
                case 870: {
                    this.models[870] = new LabelModel(109707520);
                    break;
                }
                case 198: {
                    this.models[198] = new TerminalModelContainer(1720123648, 2, false);
                    break;
                }
                case 352: {
                    this.models[352] = new ChoiceModel(0x880100);
                    break;
                }
                case 696: {
                    this.models[696] = new ChoiceModel(1485373696);
                    break;
                }
                case 796: {
                    this.models[796] = new ButtonModel(-1131872000);
                    break;
                }
                case 387: {
                    this.models[387] = new ChoiceModel(596115712);
                    break;
                }
                case 723: {
                    this.models[723] = new ChoiceModel(1938358528);
                    break;
                }
                case 238: {
                    this.models[238] = new ButtonModel(-1903755008);
                    break;
                }
                case 916: {
                    this.models[916] = new ChoiceModel(881459456);
                    break;
                }
                case 365: {
                    this.models[365] = new ChoiceModel(227016960);
                    break;
                }
                case 427: {
                    this.models[427] = new TerminalModelContainer(1267204352, 2, false);
                    break;
                }
                case 575: {
                    this.models[575] = new ChoiceModel(-544734976);
                    break;
                }
                case 189: {
                    this.models[189] = new TerminalModelContainer(1569128704, 1, false);
                    break;
                }
                case 477: {
                    this.models[477] = new BaseListModel(2106065152, null);
                    break;
                }
                case 491: {
                    this.models[491] = new BaseListModel(-1954021120, (MenuModel)this.getModel(310903040));
                    break;
                }
                case 580: {
                    this.models[580] = new ChoiceModel(-460848896);
                    break;
                }
                case 398: {
                    this.models[398] = new ChoiceModel(780665088);
                    break;
                }
                case 140: {
                    this.models[140] = new TerminalModelContainer(747045120, 3, false);
                    break;
                }
                case 871: {
                    this.models[871] = new LabelModel(126484736);
                    break;
                }
                case 656: {
                    this.models[656] = new ButtonModel(814285056);
                    break;
                }
                case 232: {
                    this.models[232] = new ChoiceModel(-2004418304);
                    break;
                }
                case 436: {
                    this.models[436] = new ButtonModel(1418199296);
                    break;
                }
                case 129: {
                    this.models[129] = new TerminalModelContainer(562495744, 3, false);
                    break;
                }
                case 320: {
                    this.models[320] = new ChoiceModel(-528023296);
                    break;
                }
                case 608: {
                    this.models[608] = new OptionModel(8978688);
                    break;
                }
                case 374: {
                    this.models[374] = new ChoiceModel(378011904);
                    break;
                }
                case 423: {
                    this.models[423] = new ChoiceModel(1200095488);
                    break;
                }
                case 144: {
                    this.models[144] = new ChoiceModel(814153984);
                    break;
                }
                case 516: {
                    this.models[516] = new BaseListModel(-1534590720, (MenuModel)this.getModel(-796393216));
                    break;
                }
                case 720: {
                    this.models[720] = new ChoiceModel(1888026880);
                    break;
                }
                case 315: {
                    this.models[315] = new ChoiceModel(-611909376);
                    break;
                }
                case 610: {
                    this.models[610] = new ChoiceModel(42533120);
                    break;
                }
                case 482: {
                    this.models[482] = new BaseListModel(-2105016064, null);
                    break;
                }
                case 541: {
                    this.models[541] = new LabelModel(-1115160320);
                    break;
                }
                case 442: {
                    this.models[442] = new SpellerModel(1518862592);
                    break;
                }
                case 136: {
                    this.models[136] = new TerminalModelContainer(679936256, 3, false);
                    break;
                }
                case 457: {
                    this.models[457] = new BaseListModel(1770520832, (MenuModel)this.getModel(495517952));
                    break;
                }
                case 872: {
                    this.models[872] = new BaseListModel(143261952, null);
                    break;
                }
                case 460: {
                    this.models[460] = new BaseListModel(1820852480, (MenuModel)this.getModel(495517952));
                    break;
                }
                case 833: {
                    this.models[833] = new ChoiceModel(-511115008);
                    break;
                }
                case 728: {
                    this.models[728] = new ChoiceModel(2022244608);
                    break;
                }
                case 928: {
                    this.models[928] = new ChoiceModel(1082786048);
                    break;
                }
                case 768: {
                    this.models[768] = new ChoiceModel(-1601634048);
                    break;
                }
                case 873: {
                    this.models[873] = new BaseListModel(160039168, null);
                    break;
                }
                case 383: {
                    this.models[383] = new LabelModel(529006848);
                    break;
                }
                case 252: {
                    this.models[252] = new ButtonModel(-1668873984);
                    break;
                }
                case 629: {
                    this.models[629] = new VirtualButtonModel(361300224);
                    break;
                }
                case 874: {
                    this.models[874] = new ButtonModel(176816384);
                    break;
                }
                case 490: {
                    this.models[490] = new ChoiceModel(-1970798336);
                    break;
                }
                case 929: {
                    this.models[929] = new ChoiceModel(1099563264);
                    break;
                }
                case 529: {
                    this.models[529] = new ChoiceModel(-1316486912);
                    break;
                }
                case 774: {
                    this.models[774] = new ChoiceModel(-1500970752);
                    break;
                }
                case 380: {
                    this.models[380] = new TerminalModelContainer(478675200, 1, false);
                    break;
                }
                case 186: {
                    this.models[186] = new TerminalModelContainer(1518797056, 1, false);
                    break;
                }
                case 130: {
                    this.models[130] = new TerminalModelContainer(579272960, 3, false);
                    break;
                }
                case 438: {
                    this.models[438] = new VirtualButtonModel(1451753728);
                    break;
                }
                case 603: {
                    this.models[603] = new ButtonModel(-74972928);
                    break;
                }
                case 797: {
                    this.models[797] = new ButtonModel(-1115094784);
                    break;
                }
                case 446: {
                    this.models[446] = new TerminalModelContainer(1585971456, 2, false);
                    break;
                }
                case 746: {
                    this.models[746] = new BaseListModel(-1970732800, (MenuModel)this.getModel(-1299709696));
                    break;
                }
                case 132: {
                    this.models[132] = new TerminalModelContainer(612827392, 3, false);
                    break;
                }
                case 183: {
                    this.models[183] = new ButtonModel(1468465408);
                    break;
                }
                case 402: {
                    this.models[402] = new LabelModel(847773952);
                    break;
                }
                case 225: {
                    this.models[225] = new TerminalModelContainer(-2121858816, 5, false);
                    break;
                }
                case 133: {
                    this.models[133] = new TerminalModelContainer(629604608, 3, false);
                    break;
                }
                case 618: {
                    this.models[618] = new ChoiceModel(176750848);
                    break;
                }
                case 623: {
                    this.models[623] = new LabelModel(260636928);
                    break;
                }
                case 545: {
                    this.models[545] = new ButtonModel(-1048051456);
                    break;
                }
                case 588: {
                    this.models[588] = new ButtonModel(-326631168);
                    break;
                }
                case 162: {
                    this.models[162] = new ChoiceModel(1116143872);
                    break;
                }
                case 724: {
                    this.models[724] = new ChoiceModel(1955135744);
                    break;
                }
                case 416: {
                    this.models[416] = new ButtonModel(1082654976);
                    break;
                }
                case 128: {
                    this.models[128] = new TerminalModelContainer(545718528, 3, false);
                    break;
                }
                case 370: {
                    this.models[370] = new MenuModel(310903040);
                    break;
                }
                case 559: {
                    this.models[559] = new MenuModel(-813170432);
                    break;
                }
                case 643: {
                    this.models[643] = new LabelModel(596181248);
                    break;
                }
                case 613: {
                    this.models[613] = new ChoiceModel(92864768);
                    break;
                }
                case 930: {
                    this.models[930] = new LabelModel(1116340480);
                    break;
                }
                case 751: {
                    this.models[751] = new ButtonModel(-1886846720);
                    break;
                }
                case 182: {
                    this.models[182] = new LabelModel(1451688192);
                    break;
                }
                case 479: {
                    this.models[479] = new BaseListModel(2139619584, null);
                    break;
                }
                case 472: {
                    this.models[472] = new ChoiceModel(2022179072);
                    break;
                }
                case 599: {
                    this.models[599] = new ButtonModel(-142081792);
                    break;
                }
                case 201: {
                    this.models[201] = new ButtonModel(1770455296);
                    break;
                }
                case 687: {
                    this.models[687] = new ButtonModel(1334378752);
                    break;
                }
                case 808: {
                    this.models[808] = new ChoiceModel(-930545408);
                    break;
                }
                case 887: {
                    this.models[887] = new ChoiceModel(394920192);
                    break;
                }
                case 397: {
                    this.models[397] = new ChoiceModel(763887872);
                    break;
                }
                case 875: {
                    this.models[875] = new ResourceLocatorModel(193593600);
                    break;
                }
                case 422: {
                    this.models[422] = new TerminalModelContainer(1183318272, 3, false);
                    break;
                }
                case 514: {
                    this.models[514] = new BaseListModel(-1568145152, (MenuModel)this.getModel(-829947648));
                    break;
                }
                case 810: {
                    this.models[810] = new ButtonModel(-896990976);
                    break;
                }
                case 612: {
                    this.models[612] = new LabelModel(76087552);
                    break;
                }
                case 433: {
                    this.models[433] = new TerminalModelContainer(1367867648, 3, false);
                    break;
                }
                case 468: {
                    this.models[468] = new ButtonModel(1955070208);
                    break;
                }
                case 481: {
                    this.models[481] = new BaseListModel(-2121793280, null);
                    break;
                }
                case 196: {
                    this.models[196] = new ChoiceModel(1686569216);
                    break;
                }
                case 718: {
                    this.models[718] = new MenuModel(1854472448);
                    break;
                }
                case 316: {
                    this.models[316] = new ChoiceModel(-595132160);
                    break;
                }
                case 770: {
                    this.models[770] = new LabelModel(-1568079616);
                    break;
                }
                case 705: {
                    this.models[705] = new ChoiceModel(1636368640);
                    break;
                }
                case 399: {
                    this.models[399] = new ChoiceModel(797442304);
                    break;
                }
                case 424: {
                    this.models[424] = new LabelModel(1216872704);
                    break;
                }
                case 619: {
                    this.models[619] = new VirtualButtonModel(193528064);
                    break;
                }
                case 168: {
                    this.models[168] = new LabelModel(1216807168);
                    break;
                }
                case 483: {
                    this.models[483] = new BaseListModel(-2088238848, null);
                    break;
                }
                case 158: {
                    this.models[158] = new ChoiceModel(1049035008);
                    break;
                }
                case 360: {
                    this.models[360] = new TerminalModelContainer(0x8880100, 3, false);
                    break;
                }
                case 635: {
                    this.models[635] = new MatchspellerModel(461963520);
                    break;
                }
                case 266: {
                    this.models[266] = new ChoiceModel(-1433992960);
                    break;
                }
                case 203: {
                    this.models[203] = new ChoiceModel(1804009728);
                    break;
                }
                case 486: {
                    this.models[486] = new ChoiceModel(-2037907200);
                    break;
                }
                case 876: {
                    this.models[876] = new ChoiceModel(210370816);
                    break;
                }
                case 665: {
                    this.models[665] = new ChoiceModel(965280000);
                    break;
                }
                case 480: {
                    this.models[480] = new BaseListModel(-2138570496, null);
                    break;
                }
                case 686: {
                    this.models[686] = new OptionModel(1317601536);
                    break;
                }
                case 832: {
                    this.models[832] = new ChoiceModel(-527892224);
                    break;
                }
                case 877: {
                    this.models[877] = new LabelModel(227148032);
                    break;
                }
                case 657: {
                    this.models[657] = new OptionModel(831062272);
                    break;
                }
                case 489: {
                    this.models[489] = new ChoiceModel(-1987575552);
                    break;
                }
                case 645: {
                    this.models[645] = new ButtonModel(629735680);
                    break;
                }
                case 319: {
                    this.models[319] = new ChoiceModel(-544800512);
                    break;
                }
                case 592: {
                    this.models[592] = new ButtonModel(-259522304);
                    break;
                }
                case 616: {
                    this.models[616] = new ChoiceModel(143196416);
                    break;
                }
                case 362: {
                    this.models[362] = new LabelModel(176685312);
                    break;
                }
                case 354: {
                    this.models[354] = new ChoiceModel(42467584);
                    break;
                }
                case 811: {
                    this.models[811] = new ButtonModel(-880213760);
                    break;
                }
                case 931: {
                    this.models[931] = new TerminalModelContainer(1133117696, 3, false);
                    break;
                }
                case 606: {
                    this.models[606] = new LabelModel(-24641280);
                    break;
                }
                case 235: {
                    this.models[235] = new RangeModel(-1954086656);
                    break;
                }
                case 798: {
                    this.models[798] = new ChoiceModel(-1098317568);
                    break;
                }
                case 138: {
                    this.models[138] = new TerminalModelContainer(713490688, 3, false);
                    break;
                }
                case 664: {
                    this.models[664] = new MenuModel(948502784);
                    break;
                }
                case 431: {
                    this.models[431] = new TerminalModelContainer(1334313216, 3, false);
                    break;
                }
                case 921: {
                    this.models[921] = new BaseListModel(965345536, null);
                    break;
                }
                case 303: {
                    this.models[303] = new BaseListModel(-813235968, (MenuModel)this.getModel(-695795456));
                    break;
                }
                case 624: {
                    this.models[624] = new LabelModel(277414144);
                    break;
                }
                case 709: {
                    this.models[709] = new ButtonModel(1703477504);
                    break;
                }
                case 710: {
                    this.models[710] = new ButtonModel(1720254720);
                    break;
                }
                case 381: {
                    this.models[381] = new LabelModel(495452416);
                    break;
                }
                case 567: {
                    this.models[567] = new MenuModel(-678952704);
                    break;
                }
                case 202: {
                    this.models[202] = new BrowserModel(1787232512);
                    break;
                }
                case 401: {
                    this.models[401] = new SpellerModel(830996736);
                    break;
                }
                case 505: {
                    this.models[505] = new ButtonModel(-1719140096);
                    break;
                }
                case 395: {
                    this.models[395] = new ChoiceModel(730333440);
                    break;
                }
                case 471: {
                    this.models[471] = new BaseListModel(2005401856, (MenuModel)this.getModel(-662175488));
                    break;
                }
                case 888: {
                    this.models[888] = new ButtonModel(411697408);
                    break;
                }
                case 764: {
                    this.models[764] = new ButtonModel(-1668742912);
                    break;
                }
                case 571: {
                    this.models[571] = new ChoiceModel(-611843840);
                    break;
                }
                case 614: {
                    this.models[614] = new LabelModel(109641984);
                    break;
                }
                case 157: {
                    this.models[157] = new ButtonModel(1032257792);
                    break;
                }
                case 218: {
                    this.models[218] = new ChoiceModel(2055667968);
                    break;
                }
                case 662: {
                    this.models[662] = new ChoiceModel(914948352);
                    break;
                }
                case 596: {
                    this.models[596] = new ResourceLocatorModel(-192413440);
                    break;
                }
                case 527: {
                    this.models[527] = new ChoiceModel(-1350041344);
                    break;
                }
                case 680: {
                    this.models[680] = new ChoiceModel(1216938240);
                    break;
                }
                case 267: {
                    this.models[267] = new ChoiceModel(-1417215744);
                    break;
                }
                case 236: {
                    this.models[236] = new LabelModel(-1937309440);
                    break;
                }
                case 615: {
                    this.models[615] = new LabelModel(126419200);
                    break;
                }
                case 317: {
                    this.models[317] = new BufferedButtonModel(-578354944);
                    break;
                }
                case 698: {
                    this.models[698] = new ButtonModel(1518928128);
                    break;
                }
                case 484: {
                    this.models[484] = new BaseListModel(-2071461632, null);
                    break;
                }
                case 233: {
                    this.models[233] = new ChoiceModel(-1987641088);
                    break;
                }
                case 351: {
                    this.models[351] = new TerminalModelContainer(-7929600, 3, false);
                    break;
                }
                case 932: {
                    this.models[932] = new LabelModel(1149894912);
                    break;
                }
                case 585: {
                    this.models[585] = new TextfieldModel(-376962816);
                    break;
                }
                case 604: {
                    this.models[604] = new ChoiceModel(-58195712);
                    break;
                }
                case 667: {
                    this.models[667] = new BaseListModel(998834432, null);
                    break;
                }
                case 234: {
                    this.models[234] = new ChoiceModel(-1970863872);
                    break;
                }
                case 432: {
                    this.models[432] = new TerminalModelContainer(1351090432, 2, false);
                    break;
                }
                case 521: {
                    this.models[521] = new MenuModel(-1450704640);
                    break;
                }
                case 636: {
                    this.models[636] = new MenuModel(478740736);
                    break;
                }
                case 878: {
                    this.models[878] = new BaseListModel(243925248, null);
                    break;
                }
                case 879: {
                    this.models[879] = new ResourceLocatorModel(260702464);
                    break;
                }
                case 167: {
                    this.models[167] = new LabelModel(1200029952);
                    break;
                }
                case 305: {
                    this.models[305] = new ChoiceModel(-779681536);
                    break;
                }
                case 622: {
                    this.models[622] = new ChoiceModel(243859712);
                    break;
                }
                case 372: {
                    this.models[372] = new TerminalModelContainer(344457472, 20, false);
                    break;
                }
                case 414: {
                    this.models[414] = new RangeModel(1049100544);
                    break;
                }
                case 546: {
                    this.models[546] = new ButtonModel(-1031274240);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(1535574272);
                    break;
                }
                case 600: {
                    this.models[600] = new LabelModel(-125304576);
                    break;
                }
                case 269: {
                    this.models[269] = new OptionModel(-1383661312);
                    break;
                }
                case 172: {
                    this.models[172] = new TerminalModelContainer(1283916032, 2, false);
                    break;
                }
                case 219: {
                    this.models[219] = new ChoiceModel(2072445184);
                    break;
                }
                case 355: {
                    this.models[355] = new ResourceLocatorModel(59244800);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(1183252736);
                    break;
                }
                case 204: {
                    this.models[204] = new ChoiceModel(1820786944);
                    break;
                }
                case 933: {
                    this.models[933] = new LabelModel(1166672128);
                    break;
                }
                case 880: {
                    this.models[880] = new ChoiceModel(277479680);
                    break;
                }
                case 251: {
                    this.models[251] = new ButtonModel(-1685651200);
                    break;
                }
                case 782: {
                    this.models[782] = new LabelModel(-1366753024);
                    break;
                }
                case 641: {
                    this.models[641] = new ChoiceModel(562626816);
                    break;
                }
                case 793: {
                    this.models[793] = new ChoiceModel(-1182203648);
                    break;
                }
                case 670: {
                    this.models[670] = new LabelModel(1049166080);
                    break;
                }
                case 708: {
                    this.models[708] = new ChoiceModel(1686700288);
                    break;
                }
                case 617: {
                    this.models[617] = new ButtonModel(159973632);
                    break;
                }
                case 327: {
                    this.models[327] = new ChoiceModel(-410582784);
                    break;
                }
                case 548: {
                    this.models[548] = new ChoiceModel(-997719808);
                    break;
                }
                case 668: {
                    this.models[668] = new BaseListModel(1015611648, null);
                    break;
                }
                case 611: {
                    this.models[611] = new ChoiceModel(59310336);
                    break;
                }
                case 135: {
                    this.models[135] = new TerminalModelContainer(663159040, 3, false);
                    break;
                }
                case 369: {
                    this.models[369] = new BaseListModel(0x11880100, (MenuModel)this.getModel(310903040));
                    break;
                }
                case 260: {
                    this.models[260] = new ChoiceModel(-1534656256);
                    break;
                }
                case 922: {
                    this.models[922] = new BaseListModel(982122752, null);
                    break;
                }
                case 669: {
                    this.models[669] = new ButtonModel(1032388864);
                    break;
                }
                case 550: {
                    this.models[550] = new ChoiceModel(-964165376);
                    break;
                }
                case 631: {
                    this.models[631] = new ButtonModel(394854656);
                    break;
                }
                case 576: {
                    this.models[576] = new LabelModel(-527957760);
                    break;
                }
                case 440: {
                    this.models[440] = new TerminalModelContainer(1485308160, 3, false);
                    break;
                }
                case 139: {
                    this.models[139] = new TerminalModelContainer(730267904, 3, false);
                    break;
                }
                case 923: {
                    this.models[923] = new BaseListModel(998899968, null);
                    break;
                }
                case 703: {
                    this.models[703] = new LabelModel(1602814208);
                    break;
                }
                case 331: {
                    this.models[331] = new ButtonModel(-343473920);
                    break;
                }
                case 742: {
                    this.models[742] = new ChoiceModel(-2037841664);
                    break;
                }
                case 325: {
                    this.models[325] = new TerminalModelContainer(-444137216, 2, false);
                    break;
                }
                case 625: {
                    this.models[625] = new LabelModel(294191360);
                    break;
                }
                case 684: {
                    this.models[684] = new ChoiceModel(1284047104);
                    break;
                }
                case 450: {
                    this.models[450] = new TerminalModelContainer(1653080320, 2, false);
                    break;
                }
                case 648: {
                    this.models[648] = new ButtonModel(680067328);
                    break;
                }
                case 765: {
                    this.models[765] = new LabelModel(-1651965696);
                    break;
                }
                case 646: {
                    this.models[646] = new ButtonModel(646512896);
                    break;
                }
                case 804: {
                    this.models[804] = new ResourceLocatorModel(-997654272);
                    break;
                }
                case 163: {
                    this.models[163] = new ChoiceModel(1132921088);
                    break;
                }
                case 561: {
                    this.models[561] = new ChoiceModel(-779616000);
                    break;
                }
                case 590: {
                    this.models[590] = new ButtonModel(-293076736);
                    break;
                }
                case 601: {
                    this.models[601] = new ButtonModel(-108527360);
                    break;
                }
                case 377: {
                    this.models[377] = new TerminalModelContainer(428343552, 1, false);
                    break;
                }
                case 142: {
                    this.models[142] = new TerminalModelContainer(780599552, 3, false);
                    break;
                }
                case 660: {
                    this.models[660] = new OptionModel(881393920);
                    break;
                }
                case 794: {
                    this.models[794] = new ChoiceModel(-1165426432);
                    break;
                }
                case 637: {
                    this.models[637] = new MenuModel(495517952);
                    break;
                }
                case 137: {
                    this.models[137] = new TerminalModelContainer(696713472, 3, false);
                    break;
                }
                case 799: {
                    this.models[799] = new LabelModel(-1081540352);
                    break;
                }
                case 675: {
                    this.models[675] = new SpellerModel(1133052160);
                    break;
                }
                case 517: {
                    this.models[517] = new ButtonModel(-1517813504);
                    break;
                }
                case 194: {
                    this.models[194] = new TerminalModelContainer(1653014784, 3, false);
                    break;
                }
                case 264: {
                    this.models[264] = new ChoiceModel(-1467547392);
                    break;
                }
                case 595: {
                    this.models[595] = new ChoiceModel(-209190656);
                    break;
                }
                case 602: {
                    this.models[602] = new ChoiceModel(-91750144);
                    break;
                }
                case 570: {
                    this.models[570] = new BaseListModel(-628621056, null);
                    break;
                }
                case 511: {
                    this.models[511] = new RangeModel(-1618476800);
                    break;
                }
                case 417: {
                    this.models[417] = new ButtonModel(1099432192);
                    break;
                }
                case 584: {
                    this.models[584] = new ChoiceModel(-393740032);
                    break;
                }
                case 231: {
                    this.models[231] = new ChoiceModel(-2021195520);
                    break;
                }
                case 560: {
                    this.models[560] = new MenuModel(-796393216);
                    break;
                }
                case 934: {
                    this.models[934] = new TerminalModelContainer(1183449344, 22, false);
                    break;
                }
                case 671: {
                    this.models[671] = new ChoiceModel(1065943296);
                    break;
                }
                case 348: {
                    this.models[348] = new TerminalModelContainer(-58261248, 3, false);
                    break;
                }
                case 681: {
                    this.models[681] = new ChoiceModel(1233715456);
                    break;
                }
                case 586: {
                    this.models[586] = new MatchspellerModel(-360185600);
                    break;
                }
                case 752: {
                    this.models[752] = new ButtonModel(-1870069504);
                    break;
                }
                case 772: {
                    this.models[772] = new ChoiceModel(-1534525184);
                    break;
                }
                case 889: {
                    this.models[889] = new LabelModel(428474624);
                    break;
                }
                case 577: {
                    this.models[577] = new ChoiceModel(-511180544);
                    break;
                }
                case 549: {
                    this.models[549] = new ChoiceModel(-980942592);
                    break;
                }
                case 781: {
                    this.models[781] = new LabelModel(-1383530240);
                    break;
                }
                case 515: {
                    this.models[515] = new BaseListModel(-1551367936, (MenuModel)this.getModel(-813170432));
                    break;
                }
                case 528: {
                    this.models[528] = new ChoiceModel(-1333264128);
                    break;
                }
                case 658: {
                    this.models[658] = new OptionModel(847839488);
                    break;
                }
                case 881: {
                    this.models[881] = new ChoiceModel(294256896);
                    break;
                }
                case 469: {
                    this.models[469] = new ButtonModel(1971847424);
                    break;
                }
                case 935: {
                    this.models[935] = new LabelModel(1200226560);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(1099366656);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(1267138816);
                    break;
                }
                case 357: {
                    this.models[357] = new ChoiceModel(92799232);
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(998703360);
                    break;
                }
                case 413: {
                    this.models[413] = new TerminalModelContainer(1032323328, 5, false);
                    break;
                }
                case 532: {
                    this.models[532] = new BaseListModel(-1266155264, null);
                    break;
                }
                case 437: {
                    this.models[437] = new VirtualButtonModel(1434976512);
                    break;
                }
                case 691: {
                    this.models[691] = new LabelModel(1401487616);
                    break;
                }
                case 666: {
                    this.models[666] = new ChoiceModel(982057216);
                    break;
                }
                case 727: {
                    this.models[727] = new ChoiceModel(2005467392);
                    break;
                }
                case 418: {
                    this.models[418] = new ButtonModel(1116209408);
                    break;
                }
                case 630: {
                    this.models[630] = new ChoiceModel(378077440);
                    break;
                }
                case 230: {
                    this.models[230] = new ChoiceModel(-2037972736);
                    break;
                }
                case 174: {
                    this.models[174] = new ResourceLocatorModel(1317470464);
                    break;
                }
                case 552: {
                    this.models[552] = new ResourceLocatorModel(-930610944);
                    break;
                }
                case 652: {
                    this.models[652] = new BaseListModel(747176192, (MenuModel)this.getModel(1669923072));
                    break;
                }
                case 591: {
                    this.models[591] = new ButtonModel(-276299520);
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(981926144);
                    break;
                }
                case 712: {
                    this.models[712] = new ResourceLocatorModel(1753809152);
                    break;
                }
                case 441: {
                    this.models[441] = new TerminalModelContainer(1502085376, 1, false);
                    break;
                }
                case 175: {
                    this.models[175] = new ResourceLocatorModel(1334247680);
                    break;
                }
                case 384: {
                    this.models[384] = new LabelModel(545784064);
                    break;
                }
                case 478: {
                    this.models[478] = new BaseListModel(2122842368, null);
                    break;
                }
                case 435: {
                    this.models[435] = new TerminalModelContainer(1401422080, 3, false);
                    break;
                }
                case 919: {
                    this.models[919] = new LabelModel(931791104);
                    break;
                }
                case 565: {
                    this.models[565] = new MenuModel(-712507136);
                    break;
                }
                case 192: {
                    this.models[192] = new TerminalModelContainer(1619460352, 3, false);
                    break;
                }
                case 882: {
                    this.models[882] = new ChoiceModel(311034112);
                    break;
                }
                case 553: {
                    this.models[553] = new ChoiceModel(-913833728);
                    break;
                }
                case 676: {
                    this.models[676] = new ChoiceModel(1149829376);
                    break;
                }
                case 578: {
                    this.models[578] = new ChoiceModel(-494403328);
                    break;
                }
                case 448: {
                    this.models[448] = new TerminalModelContainer(1619525888, 2, false);
                    break;
                }
                case 193: {
                    this.models[193] = new TerminalModelContainer(1636237568, 2, false);
                    break;
                }
                case 682: {
                    this.models[682] = new ChoiceModel(1250492672);
                    break;
                }
                case 725: {
                    this.models[725] = new ChoiceModel(1971912960);
                    break;
                }
                case 650: {
                    this.models[650] = new ButtonModel(713621760);
                    break;
                }
                case 807: {
                    this.models[807] = new LabelModel(-947322624);
                    break;
                }
                case 141: {
                    this.models[141] = new TerminalModelContainer(763822336, 3, false);
                    break;
                }
                case 574: {
                    this.models[574] = new ChoiceModel(-561512192);
                    break;
                }
                case 330: {
                    this.models[330] = new ChoiceModel(-360251136);
                    break;
                }
                case 699: {
                    this.models[699] = new ButtonModel(1535705344);
                    break;
                }
                case 197: {
                    this.models[197] = new ChoiceModel(1703346432);
                    break;
                }
                case 524: {
                    this.models[524] = new ChoiceModel(-1400372992);
                    break;
                }
                case 915: {
                    this.models[915] = new BaseListModel(864682240, null);
                    break;
                }
                case 683: {
                    this.models[683] = new ChoiceModel(1267269888);
                    break;
                }
                case 347: {
                    this.models[347] = new TerminalModelContainer(-75038464, 2, false);
                    break;
                }
                case 626: {
                    this.models[626] = new ButtonModel(310968576);
                    break;
                }
                case 447: {
                    this.models[447] = new ButtonModel(1602748672);
                    break;
                }
                case 268: {
                    this.models[268] = new OptionModel(-1400438528);
                    break;
                }
                case 407: {
                    this.models[407] = new RangeModel(931660032);
                    break;
                }
                case 936: {
                    this.models[936] = new ResourceLocatorModel(1217003776);
                    break;
                }
                case 404: {
                    this.models[404] = new TerminalModelContainer(881328384, 5, false);
                    break;
                }
                case 661: {
                    this.models[661] = new OptionModel(898171136);
                    break;
                }
                case 587: {
                    this.models[587] = new ChoiceModel(-343408384);
                    break;
                }
                case 349: {
                    this.models[349] = new TerminalModelContainer(-41484032, 3, false);
                    break;
                }
                case 917: {
                    this.models[917] = new ChoiceModel(898236672);
                    break;
                }
                case 265: {
                    this.models[265] = new BufferedListModel(-1450770176);
                    break;
                }
                case 716: {
                    this.models[716] = new ChoiceModel(1820918016);
                    break;
                }
                case 146: {
                    this.models[146] = new ButtonModel(847708416);
                    break;
                }
                case 914: {
                    this.models[914] = new LabelModel(847905024);
                    break;
                }
                case 506: {
                    this.models[506] = new ButtonModel(-1702362880);
                    break;
                }
                case 492: {
                    this.models[492] = new TerminalModelContainer(-1937243904, 25, false);
                    break;
                }
                case 766: {
                    this.models[766] = new ChoiceModel(-1635188480);
                    break;
                }
                case 429: {
                    this.models[429] = new ButtonModel(1300758784);
                    break;
                }
                case 883: {
                    this.models[883] = new ResourceLocatorModel(327811328);
                    break;
                }
                case 153: {
                    this.models[153] = new LabelModel(965148928);
                    break;
                }
                case 488: {
                    this.models[488] = new BaseListModel(-2004352768, null);
                    break;
                }
                case 554: {
                    this.models[554] = new ChoiceModel(-897056512);
                    break;
                }
                case 726: {
                    this.models[726] = new ChoiceModel(1988690176);
                    break;
                }
                case 179: {
                    this.models[179] = new TerminalModelContainer(1401356544, 2, false);
                    break;
                }
                case 131: {
                    this.models[131] = new TerminalModelContainer(596050176, 3, false);
                    break;
                }
                case 890: {
                    this.models[890] = new LabelModel(445251840);
                    break;
                }
                case 800: {
                    this.models[800] = new ButtonModel(-1064763136);
                    break;
                }
                case 217: {
                    this.models[217] = new TerminalModelContainer(2038890752, 2, false);
                    break;
                }
                case 449: {
                    this.models[449] = new ChoiceModel(1636303104);
                    break;
                }
                case 382: {
                    this.models[382] = new LabelModel(512229632);
                    break;
                }
                case 884: {
                    this.models[884] = new ChoiceModel(344588544);
                    break;
                }
                case 185: {
                    this.models[185] = new TerminalModelContainer(1502019840, 2, false);
                    break;
                }
                case 628: {
                    this.models[628] = new ChoiceModel(344523008);
                    break;
                }
                case 310: {
                    this.models[310] = new MenuModel(-695795456);
                    break;
                }
                case 420: {
                    this.models[420] = new TerminalModelContainer(1149763840, 2, false);
                    break;
                }
                case 459: {
                    this.models[459] = new BaseListModel(1804075264, null);
                    break;
                }
                case 653: {
                    this.models[653] = new ChoiceModel(763953408);
                    break;
                }
                case 655: {
                    this.models[655] = new ChoiceModel(797507840);
                    break;
                }
                case 885: {
                    this.models[885] = new LabelModel(361365760);
                    break;
                }
                case 738: {
                    this.models[738] = new ChoiceModel(-2104950528);
                    break;
                }
                case 394: {
                    this.models[394] = new ChoiceModel(713556224);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(830931200);
                    break;
                }
                case 190: {
                    this.models[190] = new TerminalModelContainer(1585905920, 1, false);
                    break;
                }
                case 651: {
                    this.models[651] = new OptionModel(730398976);
                    break;
                }
                case 367: {
                    this.models[367] = new ChoiceModel(260571392);
                    break;
                }
                case 184: {
                    this.models[184] = new ChoiceModel(1485242624);
                    break;
                }
                case 749: {
                    this.models[749] = new ChoiceModel(-1920401152);
                    break;
                }
                case 425: {
                    this.models[425] = new ChoiceModel(1233649920);
                    break;
                }
                case 647: {
                    this.models[647] = new ButtonModel(663290112);
                    break;
                }
                case 150: {
                    this.models[150] = new ChoiceModel(914817280);
                    break;
                }
                case 632: {
                    this.models[632] = new LabelModel(411631872);
                    break;
                }
                case 458: {
                    this.models[458] = new ButtonModel(1787298048);
                    break;
                }
                case 621: {
                    this.models[621] = new ChoiceModel(227082496);
                    break;
                }
                case 258: {
                    this.models[258] = new ButtonModel(-1568210688);
                    break;
                }
                case 597: {
                    this.models[597] = new BaseListModel(-175636224, null);
                    break;
                }
                case 891: {
                    this.models[891] = new BaseListModel(462029056, null);
                    break;
                }
                case 739: {
                    this.models[739] = new ChoiceModel(-2088173312);
                    break;
                }
                case 200: {
                    this.models[200] = new ChoiceModel(1753678080);
                    break;
                }
                case 886: {
                    this.models[886] = new LabelModel(378142976);
                    break;
                }
                case 673: {
                    this.models[673] = new ChoiceModel(1099497728);
                    break;
                }
                case 456: {
                    this.models[456] = new BaseListModel(1753743616, (MenuModel)this.getModel(478740736));
                    break;
                }
                case 180: {
                    this.models[180] = new ButtonModel(1418133760);
                    break;
                }
                case 531: {
                    this.models[531] = new OptionModel(-1282932480);
                    break;
                }
                default: {
                    TunerModelBank.getModelLogChannel().log(10000, "[TunerModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TunerModelBank() {
        super(1, 937, 445);
        this.modelIDs = new int[445];
        this.modelIDs[0] = 1015480576;
        this.modelIDs[1] = 76153088;
        this.modelIDs[2] = 1619591424;
        this.modelIDs[3] = -1685520128;
        this.modelIDs[4] = -1433927424;
        this.modelIDs[5] = -410517248;
        this.modelIDs[6] = 948371712;
        this.modelIDs[7] = 780730624;
        this.modelIDs[8] = 92930304;
        this.modelIDs[9] = -158859008;
        this.modelIDs[10] = -1115225856;
        this.modelIDs[11] = 1384644864;
        this.modelIDs[12] = 747110656;
        this.modelIDs[13] = -2088304384;
        this.modelIDs[14] = 528941312;
        this.modelIDs[15] = 1837695232;
        this.modelIDs[16] = 327745792;
        this.modelIDs[17] = 864616704;
        this.modelIDs[18] = -1853292288;
        this.modelIDs[19] = -913768192;
        this.modelIDs[20] = 1317536000;
        this.modelIDs[21] = -1131937536;
        this.modelIDs[22] = -2138504960;
        this.modelIDs[23] = 445120768;
        this.modelIDs[24] = -511246080;
        this.modelIDs[25] = 1921515776;
        this.modelIDs[26] = 1166541056;
        this.modelIDs[27] = 394789120;
        this.modelIDs[28] = 1737031936;
        this.modelIDs[29] = 1669792000;
        this.modelIDs[30] = -880344832;
        this.modelIDs[31] = 1116274944;
        this.modelIDs[32] = 1988624640;
        this.modelIDs[33] = 1502150912;
        this.modelIDs[34] = -242745088;
        this.modelIDs[35] = 1066008832;
        this.modelIDs[36] = -477626112;
        this.modelIDs[37] = 1250361600;
        this.modelIDs[38] = -1702428416;
        this.modelIDs[39] = 1065812224;
        this.modelIDs[40] = -2021129984;
        this.modelIDs[41] = 210305280;
        this.modelIDs[42] = -1652031232;
        this.modelIDs[43] = 915013888;
        this.modelIDs[44] = -1349975808;
        this.modelIDs[45] = 579404032;
        this.modelIDs[46] = -829947648;
        this.modelIDs[47] = 1082589440;
        this.modelIDs[48] = 2072576256;
        this.modelIDs[49] = -1635254016;
        this.modelIDs[50] = 1283981568;
        this.modelIDs[51] = 646381824;
        this.modelIDs[52] = 1938292992;
        this.modelIDs[53] = -1148649216;
        this.modelIDs[54] = -1299709696;
        this.modelIDs[55] = -1903623936;
        this.modelIDs[56] = 646447360;
        this.modelIDs[57] = 1669923072;
        this.modelIDs[58] = 948568320;
        this.modelIDs[59] = -662175488;
        this.modelIDs[60] = -41418496;
        this.modelIDs[61] = 1871249664;
        this.modelIDs[62] = 76022016;
        this.modelIDs[63] = -2121727744;
        this.modelIDs[64] = -1064828672;
        this.modelIDs[65] = -1014497024;
        this.modelIDs[66] = 25755904;
        this.modelIDs[67] = 797376768;
        this.modelIDs[68] = -1584922368;
        this.modelIDs[69] = -24706816;
        this.modelIDs[70] = -729349888;
        this.modelIDs[71] = -1735851776;
        this.modelIDs[72] = 545849600;
        this.modelIDs[73] = 109707520;
        this.modelIDs[74] = 1720123648;
        this.modelIDs[75] = 0x880100;
        this.modelIDs[76] = 1485373696;
        this.modelIDs[77] = -1131872000;
        this.modelIDs[78] = 596115712;
        this.modelIDs[79] = 1938358528;
        this.modelIDs[80] = -1903755008;
        this.modelIDs[81] = 881459456;
        this.modelIDs[82] = 227016960;
        this.modelIDs[83] = 1267204352;
        this.modelIDs[84] = -544734976;
        this.modelIDs[85] = 1569128704;
        this.modelIDs[86] = 2106065152;
        this.modelIDs[87] = -1954021120;
        this.modelIDs[88] = -460848896;
        this.modelIDs[89] = 780665088;
        this.modelIDs[90] = 747045120;
        this.modelIDs[91] = 126484736;
        this.modelIDs[92] = 814285056;
        this.modelIDs[93] = -2004418304;
        this.modelIDs[94] = 1418199296;
        this.modelIDs[95] = 562495744;
        this.modelIDs[96] = -528023296;
        this.modelIDs[97] = 8978688;
        this.modelIDs[98] = 378011904;
        this.modelIDs[99] = 1200095488;
        this.modelIDs[100] = 814153984;
        this.modelIDs[101] = -1534590720;
        this.modelIDs[102] = 1888026880;
        this.modelIDs[103] = -611909376;
        this.modelIDs[104] = 42533120;
        this.modelIDs[105] = -2105016064;
        this.modelIDs[106] = -1115160320;
        this.modelIDs[107] = 1518862592;
        this.modelIDs[108] = 679936256;
        this.modelIDs[109] = 1770520832;
        this.modelIDs[110] = 143261952;
        this.modelIDs[111] = 1820852480;
        this.modelIDs[112] = -511115008;
        this.modelIDs[113] = 2022244608;
        this.modelIDs[114] = 1082786048;
        this.modelIDs[115] = -1601634048;
        this.modelIDs[116] = 160039168;
        this.modelIDs[117] = 529006848;
        this.modelIDs[118] = -1668873984;
        this.modelIDs[119] = 361300224;
        this.modelIDs[120] = 176816384;
        this.modelIDs[121] = -1970798336;
        this.modelIDs[122] = 1099563264;
        this.modelIDs[123] = -1316486912;
        this.modelIDs[124] = -1500970752;
        this.modelIDs[125] = 478675200;
        this.modelIDs[126] = 1518797056;
        this.modelIDs[127] = 579272960;
        this.modelIDs[128] = 1451753728;
        this.modelIDs[129] = -74972928;
        this.modelIDs[130] = -1115094784;
        this.modelIDs[131] = 1585971456;
        this.modelIDs[132] = -1970732800;
        this.modelIDs[133] = 612827392;
        this.modelIDs[134] = 1468465408;
        this.modelIDs[135] = 847773952;
        this.modelIDs[136] = -2121858816;
        this.modelIDs[137] = 629604608;
        this.modelIDs[138] = 176750848;
        this.modelIDs[139] = 260636928;
        this.modelIDs[140] = -1048051456;
        this.modelIDs[141] = -326631168;
        this.modelIDs[142] = 1116143872;
        this.modelIDs[143] = 1955135744;
        this.modelIDs[144] = 1082654976;
        this.modelIDs[145] = 545718528;
        this.modelIDs[146] = 310903040;
        this.modelIDs[147] = -813170432;
        this.modelIDs[148] = 596181248;
        this.modelIDs[149] = 92864768;
        this.modelIDs[150] = 1116340480;
        this.modelIDs[151] = -1886846720;
        this.modelIDs[152] = 1451688192;
        this.modelIDs[153] = 2139619584;
        this.modelIDs[154] = 2022179072;
        this.modelIDs[155] = -142081792;
        this.modelIDs[156] = 1770455296;
        this.modelIDs[157] = 1334378752;
        this.modelIDs[158] = -930545408;
        this.modelIDs[159] = 394920192;
        this.modelIDs[160] = 763887872;
        this.modelIDs[161] = 193593600;
        this.modelIDs[162] = 1183318272;
        this.modelIDs[163] = -1568145152;
        this.modelIDs[164] = -896990976;
        this.modelIDs[165] = 76087552;
        this.modelIDs[166] = 1367867648;
        this.modelIDs[167] = 1955070208;
        this.modelIDs[168] = -2121793280;
        this.modelIDs[169] = 1686569216;
        this.modelIDs[170] = 1854472448;
        this.modelIDs[171] = -595132160;
        this.modelIDs[172] = -1568079616;
        this.modelIDs[173] = 1636368640;
        this.modelIDs[174] = 797442304;
        this.modelIDs[175] = 1216872704;
        this.modelIDs[176] = 193528064;
        this.modelIDs[177] = 1216807168;
        this.modelIDs[178] = -2088238848;
        this.modelIDs[179] = 1049035008;
        this.modelIDs[180] = 0x8880100;
        this.modelIDs[181] = 461963520;
        this.modelIDs[182] = -1433992960;
        this.modelIDs[183] = 1804009728;
        this.modelIDs[184] = -2037907200;
        this.modelIDs[185] = 210370816;
        this.modelIDs[186] = 965280000;
        this.modelIDs[187] = -2138570496;
        this.modelIDs[188] = 1317601536;
        this.modelIDs[189] = -527892224;
        this.modelIDs[190] = 227148032;
        this.modelIDs[191] = 831062272;
        this.modelIDs[192] = -1987575552;
        this.modelIDs[193] = 629735680;
        this.modelIDs[194] = -544800512;
        this.modelIDs[195] = -259522304;
        this.modelIDs[196] = 143196416;
        this.modelIDs[197] = 176685312;
        this.modelIDs[198] = 42467584;
        this.modelIDs[199] = -880213760;
        this.modelIDs[200] = 1133117696;
        this.modelIDs[201] = -24641280;
        this.modelIDs[202] = -1954086656;
        this.modelIDs[203] = -1098317568;
        this.modelIDs[204] = 713490688;
        this.modelIDs[205] = 948502784;
        this.modelIDs[206] = 1334313216;
        this.modelIDs[207] = 965345536;
        this.modelIDs[208] = -813235968;
        this.modelIDs[209] = 277414144;
        this.modelIDs[210] = 1703477504;
        this.modelIDs[211] = 1720254720;
        this.modelIDs[212] = 495452416;
        this.modelIDs[213] = -678952704;
        this.modelIDs[214] = 1787232512;
        this.modelIDs[215] = 830996736;
        this.modelIDs[216] = -1719140096;
        this.modelIDs[217] = 730333440;
        this.modelIDs[218] = 2005401856;
        this.modelIDs[219] = 411697408;
        this.modelIDs[220] = -1668742912;
        this.modelIDs[221] = -611843840;
        this.modelIDs[222] = 109641984;
        this.modelIDs[223] = 1032257792;
        this.modelIDs[224] = 2055667968;
        this.modelIDs[225] = 914948352;
        this.modelIDs[226] = -192413440;
        this.modelIDs[227] = -1350041344;
        this.modelIDs[228] = 1216938240;
        this.modelIDs[229] = -1417215744;
        this.modelIDs[230] = -1937309440;
        this.modelIDs[231] = 126419200;
        this.modelIDs[232] = -578354944;
        this.modelIDs[233] = 1518928128;
        this.modelIDs[234] = -2071461632;
        this.modelIDs[235] = -1987641088;
        this.modelIDs[236] = -7929600;
        this.modelIDs[237] = 1149894912;
        this.modelIDs[238] = -376962816;
        this.modelIDs[239] = -58195712;
        this.modelIDs[240] = 998834432;
        this.modelIDs[241] = -1970863872;
        this.modelIDs[242] = 1351090432;
        this.modelIDs[243] = -1450704640;
        this.modelIDs[244] = 478740736;
        this.modelIDs[245] = 243925248;
        this.modelIDs[246] = 260702464;
        this.modelIDs[247] = 1200029952;
        this.modelIDs[248] = -779681536;
        this.modelIDs[249] = 243859712;
        this.modelIDs[250] = 344457472;
        this.modelIDs[251] = 1049100544;
        this.modelIDs[252] = -1031274240;
        this.modelIDs[253] = 1535574272;
        this.modelIDs[254] = -125304576;
        this.modelIDs[255] = -1383661312;
        this.modelIDs[256] = 1283916032;
        this.modelIDs[257] = 2072445184;
        this.modelIDs[258] = 59244800;
        this.modelIDs[259] = 1183252736;
        this.modelIDs[260] = 1820786944;
        this.modelIDs[261] = 1166672128;
        this.modelIDs[262] = 277479680;
        this.modelIDs[263] = -1685651200;
        this.modelIDs[264] = -1366753024;
        this.modelIDs[265] = 562626816;
        this.modelIDs[266] = -1182203648;
        this.modelIDs[267] = 1049166080;
        this.modelIDs[268] = 1686700288;
        this.modelIDs[269] = 159973632;
        this.modelIDs[270] = -410582784;
        this.modelIDs[271] = -997719808;
        this.modelIDs[272] = 1015611648;
        this.modelIDs[273] = 59310336;
        this.modelIDs[274] = 663159040;
        this.modelIDs[275] = 0x11880100;
        this.modelIDs[276] = -1534656256;
        this.modelIDs[277] = 982122752;
        this.modelIDs[278] = 1032388864;
        this.modelIDs[279] = -964165376;
        this.modelIDs[280] = 394854656;
        this.modelIDs[281] = -527957760;
        this.modelIDs[282] = 1485308160;
        this.modelIDs[283] = 730267904;
        this.modelIDs[284] = 998899968;
        this.modelIDs[285] = 1602814208;
        this.modelIDs[286] = -343473920;
        this.modelIDs[287] = -2037841664;
        this.modelIDs[288] = -444137216;
        this.modelIDs[289] = 294191360;
        this.modelIDs[290] = 1284047104;
        this.modelIDs[291] = 1653080320;
        this.modelIDs[292] = 680067328;
        this.modelIDs[293] = -1651965696;
        this.modelIDs[294] = 646512896;
        this.modelIDs[295] = -997654272;
        this.modelIDs[296] = 1132921088;
        this.modelIDs[297] = -779616000;
        this.modelIDs[298] = -293076736;
        this.modelIDs[299] = -108527360;
        this.modelIDs[300] = 428343552;
        this.modelIDs[301] = 780599552;
        this.modelIDs[302] = 881393920;
        this.modelIDs[303] = -1165426432;
        this.modelIDs[304] = 495517952;
        this.modelIDs[305] = 696713472;
        this.modelIDs[306] = -1081540352;
        this.modelIDs[307] = 1133052160;
        this.modelIDs[308] = -1517813504;
        this.modelIDs[309] = 1653014784;
        this.modelIDs[310] = -1467547392;
        this.modelIDs[311] = -209190656;
        this.modelIDs[312] = -91750144;
        this.modelIDs[313] = -628621056;
        this.modelIDs[314] = -1618476800;
        this.modelIDs[315] = 1099432192;
        this.modelIDs[316] = -393740032;
        this.modelIDs[317] = -2021195520;
        this.modelIDs[318] = -796393216;
        this.modelIDs[319] = 1183449344;
        this.modelIDs[320] = 1065943296;
        this.modelIDs[321] = -58261248;
        this.modelIDs[322] = 1233715456;
        this.modelIDs[323] = -360185600;
        this.modelIDs[324] = -1870069504;
        this.modelIDs[325] = -1534525184;
        this.modelIDs[326] = 428474624;
        this.modelIDs[327] = -511180544;
        this.modelIDs[328] = -980942592;
        this.modelIDs[329] = -1383530240;
        this.modelIDs[330] = -1551367936;
        this.modelIDs[331] = -1333264128;
        this.modelIDs[332] = 847839488;
        this.modelIDs[333] = 294256896;
        this.modelIDs[334] = 1971847424;
        this.modelIDs[335] = 1200226560;
        this.modelIDs[336] = 1099366656;
        this.modelIDs[337] = 1267138816;
        this.modelIDs[338] = 92799232;
        this.modelIDs[339] = 998703360;
        this.modelIDs[340] = 1032323328;
        this.modelIDs[341] = -1266155264;
        this.modelIDs[342] = 1434976512;
        this.modelIDs[343] = 1401487616;
        this.modelIDs[344] = 982057216;
        this.modelIDs[345] = 2005467392;
        this.modelIDs[346] = 1116209408;
        this.modelIDs[347] = 378077440;
        this.modelIDs[348] = -2037972736;
        this.modelIDs[349] = 1317470464;
        this.modelIDs[350] = -930610944;
        this.modelIDs[351] = 747176192;
        this.modelIDs[352] = -276299520;
        this.modelIDs[353] = 981926144;
        this.modelIDs[354] = 1753809152;
        this.modelIDs[355] = 1502085376;
        this.modelIDs[356] = 1334247680;
        this.modelIDs[357] = 545784064;
        this.modelIDs[358] = 2122842368;
        this.modelIDs[359] = 1401422080;
        this.modelIDs[360] = 931791104;
        this.modelIDs[361] = -712507136;
        this.modelIDs[362] = 1619460352;
        this.modelIDs[363] = 311034112;
        this.modelIDs[364] = -913833728;
        this.modelIDs[365] = 1149829376;
        this.modelIDs[366] = -494403328;
        this.modelIDs[367] = 1619525888;
        this.modelIDs[368] = 1636237568;
        this.modelIDs[369] = 1250492672;
        this.modelIDs[370] = 1971912960;
        this.modelIDs[371] = 713621760;
        this.modelIDs[372] = -947322624;
        this.modelIDs[373] = 763822336;
        this.modelIDs[374] = -561512192;
        this.modelIDs[375] = -360251136;
        this.modelIDs[376] = 1535705344;
        this.modelIDs[377] = 1703346432;
        this.modelIDs[378] = -1400372992;
        this.modelIDs[379] = 864682240;
        this.modelIDs[380] = 1267269888;
        this.modelIDs[381] = -75038464;
        this.modelIDs[382] = 310968576;
        this.modelIDs[383] = 1602748672;
        this.modelIDs[384] = -1400438528;
        this.modelIDs[385] = 931660032;
        this.modelIDs[386] = 1217003776;
        this.modelIDs[387] = 881328384;
        this.modelIDs[388] = 898171136;
        this.modelIDs[389] = -343408384;
        this.modelIDs[390] = -41484032;
        this.modelIDs[391] = 898236672;
        this.modelIDs[392] = -1450770176;
        this.modelIDs[393] = 1820918016;
        this.modelIDs[394] = 847708416;
        this.modelIDs[395] = 847905024;
        this.modelIDs[396] = -1702362880;
        this.modelIDs[397] = -1937243904;
        this.modelIDs[398] = -1635188480;
        this.modelIDs[399] = 1300758784;
        this.modelIDs[400] = 327811328;
        this.modelIDs[401] = 965148928;
        this.modelIDs[402] = -2004352768;
        this.modelIDs[403] = -897056512;
        this.modelIDs[404] = 1988690176;
        this.modelIDs[405] = 1401356544;
        this.modelIDs[406] = 596050176;
        this.modelIDs[407] = 445251840;
        this.modelIDs[408] = -1064763136;
        this.modelIDs[409] = 2038890752;
        this.modelIDs[410] = 1636303104;
        this.modelIDs[411] = 512229632;
        this.modelIDs[412] = 344588544;
        this.modelIDs[413] = 1502019840;
        this.modelIDs[414] = 344523008;
        this.modelIDs[415] = -695795456;
        this.modelIDs[416] = 1149763840;
        this.modelIDs[417] = 1804075264;
        this.modelIDs[418] = 763953408;
        this.modelIDs[419] = 797507840;
        this.modelIDs[420] = 361365760;
        this.modelIDs[421] = -2104950528;
        this.modelIDs[422] = 713556224;
        this.modelIDs[423] = 830931200;
        this.modelIDs[424] = 1585905920;
        this.modelIDs[425] = 730398976;
        this.modelIDs[426] = 260571392;
        this.modelIDs[427] = 1485242624;
        this.modelIDs[428] = -1920401152;
        this.modelIDs[429] = 1233649920;
        this.modelIDs[430] = 663290112;
        this.modelIDs[431] = 914817280;
        this.modelIDs[432] = 411631872;
        this.modelIDs[433] = 1787298048;
        this.modelIDs[434] = 227082496;
        this.modelIDs[435] = -1568210688;
        this.modelIDs[436] = -175636224;
        this.modelIDs[437] = 462029056;
        this.modelIDs[438] = -2088173312;
        this.modelIDs[439] = 1753678080;
        this.modelIDs[440] = 378142976;
        this.modelIDs[441] = 1099497728;
        this.modelIDs[442] = 1753743616;
        this.modelIDs[443] = 1418133760;
        this.modelIDs[444] = -1282932480;
    }
}

