/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.model.ICoreAddressBookModelBank;
import de.audi.atip.model.IEvoAddressBookModelBank;

public class AddressBookModelBank
extends AbstractModelBank
implements ICoreAddressBookModelBank,
IEvoAddressBookModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 438: {
                    this.models[438] = new ButtonModel(380635648);
                    break;
                }
                case 469: {
                    this.models[469] = new ButtonModel(900729344);
                    break;
                }
                case 493: {
                    this.models[493] = new LabelModel(1303382528);
                    break;
                }
                case 526: {
                    this.models[526] = new BaseListModel(1857030656, (MenuModel)this.getModel(2108688896));
                    break;
                }
                case 458: {
                    this.models[458] = new ChoiceModel(716179968);
                    break;
                }
                case 543: {
                    this.models[543] = new RangeModel(2142243328);
                    break;
                }
                case 502: {
                    this.models[502] = new OptionModel(1454377472);
                    break;
                }
                case 584: {
                    this.models[584] = new LabelModel(-1464858112);
                    break;
                }
                case 482: {
                    this.models[482] = new ChoiceModel(1118833152);
                    break;
                }
                case 560: {
                    this.models[560] = new LabelModel(-1867511296);
                    break;
                }
                case 589: {
                    this.models[589] = new LabelModel(-1380972032);
                    break;
                }
                case 527: {
                    this.models[527] = new BaseListModel(1873807872, (MenuModel)this.getModel(2108688896));
                    break;
                }
                case 454: {
                    this.models[454] = new ButtonModel(649071104);
                    break;
                }
                case 541: {
                    this.models[541] = new MenuModel(2108688896);
                    break;
                }
                case 466: {
                    this.models[466] = new ChoiceModel(850397696);
                    break;
                }
                case 508: {
                    this.models[508] = new ResourceLocatorModel(1555040768);
                    break;
                }
                case 492: {
                    this.models[492] = new ButtonModel(1286605312);
                    break;
                }
                case 494: {
                    this.models[494] = new ChoiceModel(1320159744);
                    break;
                }
                case 545: {
                    this.models[545] = new ChoiceModel(-2119169536);
                    break;
                }
                case 473: {
                    this.models[473] = new ChoiceModel(967838208);
                    break;
                }
                case 440: {
                    this.models[440] = new ChoiceModel(414190080);
                    break;
                }
                case 562: {
                    this.models[562] = new OptionModel(-1833956864);
                    break;
                }
                case 503: {
                    this.models[503] = new OptionModel(1471154688);
                    break;
                }
                case 453: {
                    this.models[453] = new ButtonModel(632293888);
                    break;
                }
                case 488: {
                    this.models[488] = new ChoiceModel(1219496448);
                    break;
                }
                case 521: {
                    this.models[521] = new ButtonModel(1773144576);
                    break;
                }
                case 531: {
                    this.models[531] = new OptionModel(1940916736);
                    break;
                }
                case 497: {
                    this.models[497] = new ChoiceModel(1370491392);
                    break;
                }
                case 542: {
                    this.models[542] = new RangeModel(2125466112);
                    break;
                }
                case 464: {
                    this.models[464] = new ChoiceModel(816843264);
                    break;
                }
                case 489: {
                    this.models[489] = new ChoiceModel(1236273664);
                    break;
                }
                case 510: {
                    this.models[510] = new MatchspellerModel(1588595200);
                    break;
                }
                case 585: {
                    this.models[585] = new LabelModel(-1448080896);
                    break;
                }
                case 544: {
                    this.models[544] = new ButtonModel(-2135946752);
                    break;
                }
                case 496: {
                    this.models[496] = new LabelModel(1353714176);
                    break;
                }
                case 459: {
                    this.models[459] = new ChoiceModel(732957184);
                    break;
                }
                case 443: {
                    this.models[443] = new LabelModel(464521728);
                    break;
                }
                case 478: {
                    this.models[478] = new LabelModel(1051724288);
                    break;
                }
                case 534: {
                    this.models[534] = new ChoiceModel(1991248384);
                    break;
                }
                case 495: {
                    this.models[495] = new LabelModel(1336936960);
                    break;
                }
                case 435: {
                    this.models[435] = new LabelModel(330304000);
                    break;
                }
                case 501: {
                    this.models[501] = new ButtonModel(1437600256);
                    break;
                }
                case 446: {
                    this.models[446] = new LabelModel(514853376);
                    break;
                }
                case 441: {
                    this.models[441] = new LabelModel(430967296);
                    break;
                }
                case 477: {
                    this.models[477] = new ChoiceModel(1034947072);
                    break;
                }
                case 491: {
                    this.models[491] = new ButtonModel(1269828096);
                    break;
                }
                case 430: {
                    this.models[430] = new LabelModel(246417920);
                    break;
                }
                case 536: {
                    this.models[536] = new LabelModel(2024802816);
                    break;
                }
                case 498: {
                    this.models[498] = new ChoiceModel(1387268608);
                    break;
                }
                case 436: {
                    this.models[436] = new LabelModel(347081216);
                    break;
                }
                case 535: {
                    this.models[535] = new ChoiceModel(2008025600);
                    break;
                }
                case 461: {
                    this.models[461] = new ButtonModel(766511616);
                    break;
                }
                case 481: {
                    this.models[481] = new LabelModel(1102055936);
                    break;
                }
                case 428: {
                    this.models[428] = new LabelModel(212863488);
                    break;
                }
                case 582: {
                    this.models[582] = new ChoiceModel(-1498412544);
                    break;
                }
                case 468: {
                    this.models[468] = new ChoiceModel(883952128);
                    break;
                }
                case 525: {
                    this.models[525] = new BaseListModel(1840253440, (MenuModel)this.getModel(2108688896));
                    break;
                }
                case 456: {
                    this.models[456] = new LabelModel(682625536);
                    break;
                }
                case 429: {
                    this.models[429] = new LabelModel(229640704);
                    break;
                }
                case 592: {
                    this.models[592] = new SpellerModel(-1330640384);
                    break;
                }
                case 253: {
                    this.models[253] = new ChoiceModel(1571752448);
                    break;
                }
                case 475: {
                    this.models[475] = new ButtonModel(1001392640);
                    break;
                }
                case 593: {
                    this.models[593] = new RangeModel(-1313863168);
                    break;
                }
                case 539: {
                    this.models[539] = new ChoiceModel(2075134464);
                    break;
                }
                case 583: {
                    this.models[583] = new BaseListModel(-1481635328, null);
                    break;
                }
                case 470: {
                    this.models[470] = new ChoiceModel(917506560);
                    break;
                }
                case 509: {
                    this.models[509] = new MenuModel(1571817984);
                    break;
                }
                case 442: {
                    this.models[442] = new ResourceLocatorModel(447744512);
                    break;
                }
                case 515: {
                    this.models[515] = new ButtonModel(1672481280);
                    break;
                }
                case 533: {
                    this.models[533] = new OptionModel(1974471168);
                    break;
                }
                case 554: {
                    this.models[554] = new OptionModel(-1968174592);
                    break;
                }
                case 590: {
                    this.models[590] = new LabelModel(-1364194816);
                    break;
                }
                case 445: {
                    this.models[445] = new LabelModel(498076160);
                    break;
                }
                case 455: {
                    this.models[455] = new ButtonModel(665848320);
                    break;
                }
                case 519: {
                    this.models[519] = new ChoiceModel(1739590144);
                    break;
                }
                case 450: {
                    this.models[450] = new ChoiceModel(581962240);
                    break;
                }
                case 484: {
                    this.models[484] = new ButtonModel(1152387584);
                    break;
                }
                case 513: {
                    this.models[513] = new OptionModel(1638926848);
                    break;
                }
                case 532: {
                    this.models[532] = new OptionModel(1957693952);
                    break;
                }
                case 444: {
                    this.models[444] = new ChoiceModel(481298944);
                    break;
                }
                case 476: {
                    this.models[476] = new ButtonModel(1018169856);
                    break;
                }
                case 523: {
                    this.models[523] = new OptionModel(1806699008);
                    break;
                }
                case 597: {
                    this.models[597] = new ChoiceModel(-1246754304);
                    break;
                }
                case 514: {
                    this.models[514] = new OptionModel(1655704064);
                    break;
                }
                case 548: {
                    this.models[548] = new ButtonModel(-2068837888);
                    break;
                }
                case 451: {
                    this.models[451] = new TiledListModel(598739456, null);
                    break;
                }
                case 452: {
                    this.models[452] = new ChoiceModel(615516672);
                    break;
                }
                case 490: {
                    this.models[490] = new ChoiceModel(1253050880);
                    break;
                }
                case 485: {
                    this.models[485] = new ButtonModel(1169164800);
                    break;
                }
                case 594: {
                    this.models[594] = new TiledListModel(-1297085952, (MenuModel)this.getModel(1571817984));
                    break;
                }
                case 512: {
                    this.models[512] = new ButtonModel(1622149632);
                    break;
                }
                case 463: {
                    this.models[463] = new TiledListModel(800066048, null);
                    break;
                }
                case 480: {
                    this.models[480] = new LabelModel(1085278720);
                    break;
                }
                case 522: {
                    this.models[522] = new ButtonModel(1789921792);
                    break;
                }
                case 546: {
                    this.models[546] = new ButtonModel(-2102392320);
                    break;
                }
                case 586: {
                    this.models[586] = new LabelModel(-1431303680);
                    break;
                }
                case 500: {
                    this.models[500] = new ButtonModel(1420823040);
                    break;
                }
                case 559: {
                    this.models[559] = new RangeModel(-1884288512);
                    break;
                }
                case 457: {
                    this.models[457] = new LabelModel(699402752);
                    break;
                }
                case 439: {
                    this.models[439] = new ButtonModel(397412864);
                    break;
                }
                case 448: {
                    this.models[448] = new ChoiceModel(548407808);
                    break;
                }
                case 474: {
                    this.models[474] = new ButtonModel(984615424);
                    break;
                }
                case 427: {
                    this.models[427] = new ChoiceModel(0xBB00A00);
                    break;
                }
                case 479: {
                    this.models[479] = new LabelModel(1068501504);
                    break;
                }
                case 449: {
                    this.models[449] = new ChoiceModel(565185024);
                    break;
                }
                case 547: {
                    this.models[547] = new ButtonModel(-2085615104);
                    break;
                }
                case 507: {
                    this.models[507] = new ChoiceModel(1538263552);
                    break;
                }
                case 595: {
                    this.models[595] = new BaseListModel(-1280308736, (MenuModel)this.getModel(1571817984));
                    break;
                }
                case 538: {
                    this.models[538] = new ChoiceModel(2058357248);
                    break;
                }
                case 587: {
                    this.models[587] = new LabelModel(-1414526464);
                    break;
                }
                default: {
                    AddressBookModelBank.getModelLogChannel().log(10000, "[AddressBookModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public AddressBookModelBank() {
        super(7, 598, 110);
        this.modelIDs = new int[110];
        this.modelIDs[0] = 380635648;
        this.modelIDs[1] = 900729344;
        this.modelIDs[2] = 1303382528;
        this.modelIDs[3] = 1857030656;
        this.modelIDs[4] = 716179968;
        this.modelIDs[5] = 2142243328;
        this.modelIDs[6] = 1454377472;
        this.modelIDs[7] = -1464858112;
        this.modelIDs[8] = 1118833152;
        this.modelIDs[9] = -1867511296;
        this.modelIDs[10] = -1380972032;
        this.modelIDs[11] = 1873807872;
        this.modelIDs[12] = 649071104;
        this.modelIDs[13] = 2108688896;
        this.modelIDs[14] = 850397696;
        this.modelIDs[15] = 1555040768;
        this.modelIDs[16] = 1286605312;
        this.modelIDs[17] = 1320159744;
        this.modelIDs[18] = -2119169536;
        this.modelIDs[19] = 967838208;
        this.modelIDs[20] = 414190080;
        this.modelIDs[21] = -1833956864;
        this.modelIDs[22] = 1471154688;
        this.modelIDs[23] = 632293888;
        this.modelIDs[24] = 1219496448;
        this.modelIDs[25] = 1773144576;
        this.modelIDs[26] = 1940916736;
        this.modelIDs[27] = 1370491392;
        this.modelIDs[28] = 2125466112;
        this.modelIDs[29] = 816843264;
        this.modelIDs[30] = 1236273664;
        this.modelIDs[31] = 1588595200;
        this.modelIDs[32] = -1448080896;
        this.modelIDs[33] = -2135946752;
        this.modelIDs[34] = 1353714176;
        this.modelIDs[35] = 732957184;
        this.modelIDs[36] = 464521728;
        this.modelIDs[37] = 1051724288;
        this.modelIDs[38] = 1991248384;
        this.modelIDs[39] = 1336936960;
        this.modelIDs[40] = 330304000;
        this.modelIDs[41] = 1437600256;
        this.modelIDs[42] = 514853376;
        this.modelIDs[43] = 430967296;
        this.modelIDs[44] = 1034947072;
        this.modelIDs[45] = 1269828096;
        this.modelIDs[46] = 246417920;
        this.modelIDs[47] = 2024802816;
        this.modelIDs[48] = 1387268608;
        this.modelIDs[49] = 347081216;
        this.modelIDs[50] = 2008025600;
        this.modelIDs[51] = 766511616;
        this.modelIDs[52] = 1102055936;
        this.modelIDs[53] = 212863488;
        this.modelIDs[54] = -1498412544;
        this.modelIDs[55] = 883952128;
        this.modelIDs[56] = 1840253440;
        this.modelIDs[57] = 682625536;
        this.modelIDs[58] = 229640704;
        this.modelIDs[59] = -1330640384;
        this.modelIDs[60] = 1571752448;
        this.modelIDs[61] = 1001392640;
        this.modelIDs[62] = -1313863168;
        this.modelIDs[63] = 2075134464;
        this.modelIDs[64] = -1481635328;
        this.modelIDs[65] = 917506560;
        this.modelIDs[66] = 1571817984;
        this.modelIDs[67] = 447744512;
        this.modelIDs[68] = 1672481280;
        this.modelIDs[69] = 1974471168;
        this.modelIDs[70] = -1968174592;
        this.modelIDs[71] = -1364194816;
        this.modelIDs[72] = 498076160;
        this.modelIDs[73] = 665848320;
        this.modelIDs[74] = 1739590144;
        this.modelIDs[75] = 581962240;
        this.modelIDs[76] = 1152387584;
        this.modelIDs[77] = 1638926848;
        this.modelIDs[78] = 1957693952;
        this.modelIDs[79] = 481298944;
        this.modelIDs[80] = 1018169856;
        this.modelIDs[81] = 1806699008;
        this.modelIDs[82] = -1246754304;
        this.modelIDs[83] = 1655704064;
        this.modelIDs[84] = -2068837888;
        this.modelIDs[85] = 598739456;
        this.modelIDs[86] = 615516672;
        this.modelIDs[87] = 1253050880;
        this.modelIDs[88] = 1169164800;
        this.modelIDs[89] = -1297085952;
        this.modelIDs[90] = 1622149632;
        this.modelIDs[91] = 800066048;
        this.modelIDs[92] = 1085278720;
        this.modelIDs[93] = 1789921792;
        this.modelIDs[94] = -2102392320;
        this.modelIDs[95] = -1431303680;
        this.modelIDs[96] = 1420823040;
        this.modelIDs[97] = -1884288512;
        this.modelIDs[98] = 699402752;
        this.modelIDs[99] = 397412864;
        this.modelIDs[100] = 548407808;
        this.modelIDs[101] = 984615424;
        this.modelIDs[102] = 0xBB00A00;
        this.modelIDs[103] = 1068501504;
        this.modelIDs[104] = 565185024;
        this.modelIDs[105] = -2085615104;
        this.modelIDs[106] = 1538263552;
        this.modelIDs[107] = -1280308736;
        this.modelIDs[108] = 2058357248;
        this.modelIDs[109] = -1414526464;
    }
}

