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
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 438: {
                    this.models[438] = new ButtonModel(700438);
                    break;
                }
                case 469: {
                    this.models[469] = new ButtonModel(700469);
                    break;
                }
                case 493: {
                    this.models[493] = new LabelModel(700493);
                    break;
                }
                case 526: {
                    this.models[526] = new BaseListModel(700526, (MenuModel)this.getModel(700541));
                    break;
                }
                case 458: {
                    this.models[458] = new ChoiceModel(700458);
                    break;
                }
                case 543: {
                    this.models[543] = new RangeModel(700543);
                    break;
                }
                case 502: {
                    this.models[502] = new OptionModel(700502);
                    break;
                }
                case 584: {
                    this.models[584] = new LabelModel(700584);
                    break;
                }
                case 482: {
                    this.models[482] = new ChoiceModel(700482);
                    break;
                }
                case 560: {
                    this.models[560] = new LabelModel(700560);
                    break;
                }
                case 589: {
                    this.models[589] = new LabelModel(700589);
                    break;
                }
                case 527: {
                    this.models[527] = new BaseListModel(700527, (MenuModel)this.getModel(700541));
                    break;
                }
                case 454: {
                    this.models[454] = new ButtonModel(700454);
                    break;
                }
                case 541: {
                    this.models[541] = new MenuModel(700541);
                    break;
                }
                case 466: {
                    this.models[466] = new ChoiceModel(700466);
                    break;
                }
                case 508: {
                    this.models[508] = new ResourceLocatorModel(700508);
                    break;
                }
                case 492: {
                    this.models[492] = new ButtonModel(700492);
                    break;
                }
                case 494: {
                    this.models[494] = new ChoiceModel(700494);
                    break;
                }
                case 545: {
                    this.models[545] = new ChoiceModel(700545);
                    break;
                }
                case 473: {
                    this.models[473] = new ChoiceModel(700473);
                    break;
                }
                case 440: {
                    this.models[440] = new ChoiceModel(700440);
                    break;
                }
                case 562: {
                    this.models[562] = new OptionModel(700562);
                    break;
                }
                case 503: {
                    this.models[503] = new OptionModel(700503);
                    break;
                }
                case 453: {
                    this.models[453] = new ButtonModel(700453);
                    break;
                }
                case 488: {
                    this.models[488] = new ChoiceModel(700488);
                    break;
                }
                case 521: {
                    this.models[521] = new ButtonModel(700521);
                    break;
                }
                case 531: {
                    this.models[531] = new OptionModel(700531);
                    break;
                }
                case 497: {
                    this.models[497] = new ChoiceModel(700497);
                    break;
                }
                case 542: {
                    this.models[542] = new RangeModel(700542);
                    break;
                }
                case 464: {
                    this.models[464] = new ChoiceModel(700464);
                    break;
                }
                case 489: {
                    this.models[489] = new ChoiceModel(700489);
                    break;
                }
                case 510: {
                    this.models[510] = new MatchspellerModel(700510);
                    break;
                }
                case 585: {
                    this.models[585] = new LabelModel(700585);
                    break;
                }
                case 544: {
                    this.models[544] = new ButtonModel(700544);
                    break;
                }
                case 496: {
                    this.models[496] = new LabelModel(700496);
                    break;
                }
                case 459: {
                    this.models[459] = new ChoiceModel(700459);
                    break;
                }
                case 443: {
                    this.models[443] = new LabelModel(700443);
                    break;
                }
                case 478: {
                    this.models[478] = new LabelModel(700478);
                    break;
                }
                case 534: {
                    this.models[534] = new ChoiceModel(700534);
                    break;
                }
                case 495: {
                    this.models[495] = new LabelModel(700495);
                    break;
                }
                case 435: {
                    this.models[435] = new LabelModel(700435);
                    break;
                }
                case 501: {
                    this.models[501] = new ButtonModel(700501);
                    break;
                }
                case 446: {
                    this.models[446] = new LabelModel(700446);
                    break;
                }
                case 441: {
                    this.models[441] = new LabelModel(700441);
                    break;
                }
                case 477: {
                    this.models[477] = new ChoiceModel(700477);
                    break;
                }
                case 491: {
                    this.models[491] = new ButtonModel(700491);
                    break;
                }
                case 430: {
                    this.models[430] = new LabelModel(700430);
                    break;
                }
                case 536: {
                    this.models[536] = new LabelModel(700536);
                    break;
                }
                case 498: {
                    this.models[498] = new ChoiceModel(700498);
                    break;
                }
                case 436: {
                    this.models[436] = new LabelModel(700436);
                    break;
                }
                case 535: {
                    this.models[535] = new ChoiceModel(700535);
                    break;
                }
                case 461: {
                    this.models[461] = new ButtonModel(700461);
                    break;
                }
                case 481: {
                    this.models[481] = new LabelModel(700481);
                    break;
                }
                case 428: {
                    this.models[428] = new LabelModel(700428);
                    break;
                }
                case 582: {
                    this.models[582] = new ChoiceModel(700582);
                    break;
                }
                case 468: {
                    this.models[468] = new ChoiceModel(700468);
                    break;
                }
                case 525: {
                    this.models[525] = new BaseListModel(700525, (MenuModel)this.getModel(700541));
                    break;
                }
                case 456: {
                    this.models[456] = new LabelModel(700456);
                    break;
                }
                case 429: {
                    this.models[429] = new LabelModel(700429);
                    break;
                }
                case 592: {
                    this.models[592] = new SpellerModel(700592);
                    break;
                }
                case 253: {
                    this.models[253] = new ChoiceModel(700253);
                    break;
                }
                case 475: {
                    this.models[475] = new ButtonModel(700475);
                    break;
                }
                case 593: {
                    this.models[593] = new RangeModel(700593);
                    break;
                }
                case 539: {
                    this.models[539] = new ChoiceModel(700539);
                    break;
                }
                case 583: {
                    this.models[583] = new BaseListModel(700583, null);
                    break;
                }
                case 470: {
                    this.models[470] = new ChoiceModel(700470);
                    break;
                }
                case 509: {
                    this.models[509] = new MenuModel(700509);
                    break;
                }
                case 442: {
                    this.models[442] = new ResourceLocatorModel(700442);
                    break;
                }
                case 515: {
                    this.models[515] = new ButtonModel(700515);
                    break;
                }
                case 533: {
                    this.models[533] = new OptionModel(700533);
                    break;
                }
                case 554: {
                    this.models[554] = new OptionModel(700554);
                    break;
                }
                case 590: {
                    this.models[590] = new LabelModel(700590);
                    break;
                }
                case 445: {
                    this.models[445] = new LabelModel(700445);
                    break;
                }
                case 455: {
                    this.models[455] = new ButtonModel(700455);
                    break;
                }
                case 519: {
                    this.models[519] = new ChoiceModel(700519);
                    break;
                }
                case 450: {
                    this.models[450] = new ChoiceModel(700450);
                    break;
                }
                case 484: {
                    this.models[484] = new ButtonModel(700484);
                    break;
                }
                case 513: {
                    this.models[513] = new OptionModel(700513);
                    break;
                }
                case 532: {
                    this.models[532] = new OptionModel(700532);
                    break;
                }
                case 444: {
                    this.models[444] = new ChoiceModel(700444);
                    break;
                }
                case 476: {
                    this.models[476] = new ButtonModel(700476);
                    break;
                }
                case 523: {
                    this.models[523] = new OptionModel(700523);
                    break;
                }
                case 597: {
                    this.models[597] = new ChoiceModel(700597);
                    break;
                }
                case 514: {
                    this.models[514] = new OptionModel(700514);
                    break;
                }
                case 548: {
                    this.models[548] = new ButtonModel(700548);
                    break;
                }
                case 451: {
                    this.models[451] = new TiledListModel(700451, null);
                    break;
                }
                case 452: {
                    this.models[452] = new ChoiceModel(700452);
                    break;
                }
                case 490: {
                    this.models[490] = new ChoiceModel(700490);
                    break;
                }
                case 485: {
                    this.models[485] = new ButtonModel(700485);
                    break;
                }
                case 594: {
                    this.models[594] = new TiledListModel(700594, (MenuModel)this.getModel(700509));
                    break;
                }
                case 512: {
                    this.models[512] = new ButtonModel(700512);
                    break;
                }
                case 463: {
                    this.models[463] = new TiledListModel(700463, null);
                    break;
                }
                case 480: {
                    this.models[480] = new LabelModel(700480);
                    break;
                }
                case 522: {
                    this.models[522] = new ButtonModel(700522);
                    break;
                }
                case 546: {
                    this.models[546] = new ButtonModel(700546);
                    break;
                }
                case 586: {
                    this.models[586] = new LabelModel(700586);
                    break;
                }
                case 500: {
                    this.models[500] = new ButtonModel(700500);
                    break;
                }
                case 559: {
                    this.models[559] = new RangeModel(700559);
                    break;
                }
                case 457: {
                    this.models[457] = new LabelModel(700457);
                    break;
                }
                case 439: {
                    this.models[439] = new ButtonModel(700439);
                    break;
                }
                case 448: {
                    this.models[448] = new ChoiceModel(700448);
                    break;
                }
                case 474: {
                    this.models[474] = new ButtonModel(700474);
                    break;
                }
                case 427: {
                    this.models[427] = new ChoiceModel(700427);
                    break;
                }
                case 479: {
                    this.models[479] = new LabelModel(700479);
                    break;
                }
                case 449: {
                    this.models[449] = new ChoiceModel(700449);
                    break;
                }
                case 547: {
                    this.models[547] = new ButtonModel(700547);
                    break;
                }
                case 507: {
                    this.models[507] = new ChoiceModel(700507);
                    break;
                }
                case 595: {
                    this.models[595] = new BaseListModel(700595, (MenuModel)this.getModel(700509));
                    break;
                }
                case 538: {
                    this.models[538] = new ChoiceModel(700538);
                    break;
                }
                case 587: {
                    this.models[587] = new LabelModel(700587);
                    break;
                }
                default: {
                    AddressBookModelBank.getModelLogChannel().log(10000, "[AddressBookModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public AddressBookModelBank() {
        super(7, 598, 110);
        this.modelIDs = new int[110];
        this.modelIDs[0] = 700438;
        this.modelIDs[1] = 700469;
        this.modelIDs[2] = 700493;
        this.modelIDs[3] = 700526;
        this.modelIDs[4] = 700458;
        this.modelIDs[5] = 700543;
        this.modelIDs[6] = 700502;
        this.modelIDs[7] = 700584;
        this.modelIDs[8] = 700482;
        this.modelIDs[9] = 700560;
        this.modelIDs[10] = 700589;
        this.modelIDs[11] = 700527;
        this.modelIDs[12] = 700454;
        this.modelIDs[13] = 700541;
        this.modelIDs[14] = 700466;
        this.modelIDs[15] = 700508;
        this.modelIDs[16] = 700492;
        this.modelIDs[17] = 700494;
        this.modelIDs[18] = 700545;
        this.modelIDs[19] = 700473;
        this.modelIDs[20] = 700440;
        this.modelIDs[21] = 700562;
        this.modelIDs[22] = 700503;
        this.modelIDs[23] = 700453;
        this.modelIDs[24] = 700488;
        this.modelIDs[25] = 700521;
        this.modelIDs[26] = 700531;
        this.modelIDs[27] = 700497;
        this.modelIDs[28] = 700542;
        this.modelIDs[29] = 700464;
        this.modelIDs[30] = 700489;
        this.modelIDs[31] = 700510;
        this.modelIDs[32] = 700585;
        this.modelIDs[33] = 700544;
        this.modelIDs[34] = 700496;
        this.modelIDs[35] = 700459;
        this.modelIDs[36] = 700443;
        this.modelIDs[37] = 700478;
        this.modelIDs[38] = 700534;
        this.modelIDs[39] = 700495;
        this.modelIDs[40] = 700435;
        this.modelIDs[41] = 700501;
        this.modelIDs[42] = 700446;
        this.modelIDs[43] = 700441;
        this.modelIDs[44] = 700477;
        this.modelIDs[45] = 700491;
        this.modelIDs[46] = 700430;
        this.modelIDs[47] = 700536;
        this.modelIDs[48] = 700498;
        this.modelIDs[49] = 700436;
        this.modelIDs[50] = 700535;
        this.modelIDs[51] = 700461;
        this.modelIDs[52] = 700481;
        this.modelIDs[53] = 700428;
        this.modelIDs[54] = 700582;
        this.modelIDs[55] = 700468;
        this.modelIDs[56] = 700525;
        this.modelIDs[57] = 700456;
        this.modelIDs[58] = 700429;
        this.modelIDs[59] = 700592;
        this.modelIDs[60] = 700253;
        this.modelIDs[61] = 700475;
        this.modelIDs[62] = 700593;
        this.modelIDs[63] = 700539;
        this.modelIDs[64] = 700583;
        this.modelIDs[65] = 700470;
        this.modelIDs[66] = 700509;
        this.modelIDs[67] = 700442;
        this.modelIDs[68] = 700515;
        this.modelIDs[69] = 700533;
        this.modelIDs[70] = 700554;
        this.modelIDs[71] = 700590;
        this.modelIDs[72] = 700445;
        this.modelIDs[73] = 700455;
        this.modelIDs[74] = 700519;
        this.modelIDs[75] = 700450;
        this.modelIDs[76] = 700484;
        this.modelIDs[77] = 700513;
        this.modelIDs[78] = 700532;
        this.modelIDs[79] = 700444;
        this.modelIDs[80] = 700476;
        this.modelIDs[81] = 700523;
        this.modelIDs[82] = 700597;
        this.modelIDs[83] = 700514;
        this.modelIDs[84] = 700548;
        this.modelIDs[85] = 700451;
        this.modelIDs[86] = 700452;
        this.modelIDs[87] = 700490;
        this.modelIDs[88] = 700485;
        this.modelIDs[89] = 700594;
        this.modelIDs[90] = 700512;
        this.modelIDs[91] = 700463;
        this.modelIDs[92] = 700480;
        this.modelIDs[93] = 700522;
        this.modelIDs[94] = 700546;
        this.modelIDs[95] = 700586;
        this.modelIDs[96] = 700500;
        this.modelIDs[97] = 700559;
        this.modelIDs[98] = 700457;
        this.modelIDs[99] = 700439;
        this.modelIDs[100] = 700448;
        this.modelIDs[101] = 700474;
        this.modelIDs[102] = 700427;
        this.modelIDs[103] = 700479;
        this.modelIDs[104] = 700449;
        this.modelIDs[105] = 700547;
        this.modelIDs[106] = 700507;
        this.modelIDs[107] = 700595;
        this.modelIDs[108] = 700538;
        this.modelIDs[109] = 700587;
    }
}

