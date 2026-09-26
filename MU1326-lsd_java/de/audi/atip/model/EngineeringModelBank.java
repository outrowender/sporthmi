/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.model.ICoreEngineeringModelBank;
import de.audi.atip.model.IEvoEngineeringModelBank;

public class EngineeringModelBank
extends AbstractModelBank
implements ICoreEngineeringModelBank,
IEvoEngineeringModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 51: {
                    this.models[51] = new ButtonModel(1406538496);
                    break;
                }
                case 25: {
                    this.models[25] = new BufferedListModel(970330880);
                    break;
                }
                case 77: {
                    this.models[77] = new LabelModel(1842746112);
                    break;
                }
                case 35: {
                    this.models[35] = new LabelModel(1138103040);
                    break;
                }
                case 64: {
                    this.models[64] = new ChoiceModel(1624642304);
                    break;
                }
                case 79: {
                    this.models[79] = new ButtonModel(1876300544);
                    break;
                }
                case 71: {
                    this.models[71] = new ButtonModel(1742082816);
                    break;
                }
                case 13: {
                    this.models[13] = new LabelModel(769004288);
                    break;
                }
                case 58: {
                    this.models[58] = new LabelModel(1523979008);
                    break;
                }
                case 30: {
                    this.models[30] = new BufferedListModel(1054216960);
                    break;
                }
                case 47: {
                    this.models[47] = new LabelModel(1339429632);
                    break;
                }
                case 10: {
                    this.models[10] = new ChoiceModel(718672640);
                    break;
                }
                case 3: {
                    this.models[3] = new ListModel(601232128);
                    break;
                }
                case 76: {
                    this.models[76] = new LabelModel(1825968896);
                    break;
                }
                case 50: {
                    this.models[50] = new LabelModel(1389761280);
                    break;
                }
                case 37: {
                    this.models[37] = new ButtonModel(1171657472);
                    break;
                }
                case 27: {
                    this.models[27] = new ButtonModel(1003885312);
                    break;
                }
                case 70: {
                    this.models[70] = new ButtonModel(1725305600);
                    break;
                }
                case 39: {
                    this.models[39] = new ButtonModel(1205211904);
                    break;
                }
                case 29: {
                    this.models[29] = new BufferedListModel(1037439744);
                    break;
                }
                case 32: {
                    this.models[32] = new ButtonModel(1087771392);
                    break;
                }
                case 15: {
                    this.models[15] = new ButtonModel(802558720);
                    break;
                }
                case 46: {
                    this.models[46] = new LabelModel(1322652416);
                    break;
                }
                case 42: {
                    this.models[42] = new ButtonModel(1255543552);
                    break;
                }
                case 34: {
                    this.models[34] = new ChoiceModel(1121325824);
                    break;
                }
                case 52: {
                    this.models[52] = new ButtonModel(1423315712);
                    break;
                }
                case 8: {
                    this.models[8] = new ButtonModel(685118208);
                    break;
                }
                case 53: {
                    this.models[53] = new LabelModel(1440092928);
                    break;
                }
                case 48: {
                    this.models[48] = new LabelModel(1356206848);
                    break;
                }
                case 72: {
                    this.models[72] = new ChoiceModel(1758860032);
                    break;
                }
                case 41: {
                    this.models[41] = new ListModel(1238766336);
                    break;
                }
                case 9: {
                    this.models[9] = new ChoiceModel(701895424);
                    break;
                }
                case 28: {
                    this.models[28] = new BufferedListModel(1020662528);
                    break;
                }
                case 21: {
                    this.models[21] = new BufferedListModel(903222016);
                    break;
                }
                case 31: {
                    this.models[31] = new ButtonModel(1070994176);
                    break;
                }
                case 54: {
                    this.models[54] = new LabelModel(1456870144);
                    break;
                }
                case 6: {
                    this.models[6] = new ButtonModel(651563776);
                    break;
                }
                case 73: {
                    this.models[73] = new ChoiceModel(1775637248);
                    break;
                }
                case 2: {
                    this.models[2] = new ListModel(584454912);
                    break;
                }
                case 45: {
                    this.models[45] = new LabelModel(1305875200);
                    break;
                }
                case 43: {
                    this.models[43] = new ListModel(1272320768);
                    break;
                }
                case 33: {
                    this.models[33] = new ChoiceModel(1104548608);
                    break;
                }
                case 4: {
                    this.models[4] = new ChoiceModel(618009344);
                    break;
                }
                case 38: {
                    this.models[38] = new ButtonModel(1188434688);
                    break;
                }
                case 65: {
                    this.models[65] = new ChoiceModel(1641419520);
                    break;
                }
                case 69: {
                    this.models[69] = new LabelModel(1708528384);
                    break;
                }
                case 68: {
                    this.models[68] = new LabelModel(1691751168);
                    break;
                }
                case 56: {
                    this.models[56] = new LabelModel(1490424576);
                    break;
                }
                case 19: {
                    this.models[19] = new LabelModel(869667584);
                    break;
                }
                case 1: {
                    this.models[1] = new ListModel(567677696);
                    break;
                }
                case 49: {
                    this.models[49] = new LabelModel(1372984064);
                    break;
                }
                case 24: {
                    this.models[24] = new ChoiceModel(953553664);
                    break;
                }
                case 5: {
                    this.models[5] = new SpellerModel(634786560);
                    break;
                }
                case 57: {
                    this.models[57] = new LabelModel(1507201792);
                    break;
                }
                case 26: {
                    this.models[26] = new ButtonModel(987108096);
                    break;
                }
                case 44: {
                    this.models[44] = new LabelModel(1289097984);
                    break;
                }
                case 14: {
                    this.models[14] = new ButtonModel(785781504);
                    break;
                }
                case 18: {
                    this.models[18] = new ButtonModel(852890368);
                    break;
                }
                case 66: {
                    this.models[66] = new ButtonModel(1658196736);
                    break;
                }
                case 36: {
                    this.models[36] = new ButtonModel(1154880256);
                    break;
                }
                case 78: {
                    this.models[78] = new LabelModel(1859523328);
                    break;
                }
                case 20: {
                    this.models[20] = new LabelModel(886444800);
                    break;
                }
                case 12: {
                    this.models[12] = new LabelModel(752227072);
                    break;
                }
                case 0: {
                    this.models[0] = new ButtonModel(550900480);
                    break;
                }
                case 60: {
                    this.models[60] = new ButtonModel(1557533440);
                    break;
                }
                case 74: {
                    this.models[74] = new LabelModel(1792414464);
                    break;
                }
                case 22: {
                    this.models[22] = new LabelModel(919999232);
                    break;
                }
                case 62: {
                    this.models[62] = new ChoiceModel(1591087872);
                    break;
                }
                case 23: {
                    this.models[23] = new ChoiceModel(936776448);
                    break;
                }
                case 55: {
                    this.models[55] = new LabelModel(1473647360);
                    break;
                }
                case 17: {
                    this.models[17] = new ButtonModel(836113152);
                    break;
                }
                case 16: {
                    this.models[16] = new BufferedListModel(819335936);
                    break;
                }
                case 11: {
                    this.models[11] = new ButtonModel(735449856);
                    break;
                }
                case 67: {
                    this.models[67] = new BufferedListModel(1674973952);
                    break;
                }
                case 59: {
                    this.models[59] = new ButtonModel(1540756224);
                    break;
                }
                case 7: {
                    this.models[7] = new ButtonModel(668340992);
                    break;
                }
                case 75: {
                    this.models[75] = new BufferedListModel(1809191680);
                    break;
                }
                case 40: {
                    this.models[40] = new ListModel(1221989120);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(1574310656);
                    break;
                }
                case 63: {
                    this.models[63] = new ChoiceModel(1607865088);
                    break;
                }
                default: {
                    EngineeringModelBank.getModelLogChannel().log(10000, "[EngineeringModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public EngineeringModelBank() {
        super(13, 80, 80);
        this.modelIDs = new int[80];
        this.modelIDs[0] = 1406538496;
        this.modelIDs[1] = 970330880;
        this.modelIDs[2] = 1842746112;
        this.modelIDs[3] = 1138103040;
        this.modelIDs[4] = 1624642304;
        this.modelIDs[5] = 1876300544;
        this.modelIDs[6] = 1742082816;
        this.modelIDs[7] = 769004288;
        this.modelIDs[8] = 1523979008;
        this.modelIDs[9] = 1054216960;
        this.modelIDs[10] = 1339429632;
        this.modelIDs[11] = 718672640;
        this.modelIDs[12] = 601232128;
        this.modelIDs[13] = 1825968896;
        this.modelIDs[14] = 1389761280;
        this.modelIDs[15] = 1171657472;
        this.modelIDs[16] = 1003885312;
        this.modelIDs[17] = 1725305600;
        this.modelIDs[18] = 1205211904;
        this.modelIDs[19] = 1037439744;
        this.modelIDs[20] = 1087771392;
        this.modelIDs[21] = 802558720;
        this.modelIDs[22] = 1322652416;
        this.modelIDs[23] = 1255543552;
        this.modelIDs[24] = 1121325824;
        this.modelIDs[25] = 1423315712;
        this.modelIDs[26] = 685118208;
        this.modelIDs[27] = 1440092928;
        this.modelIDs[28] = 1356206848;
        this.modelIDs[29] = 1758860032;
        this.modelIDs[30] = 1238766336;
        this.modelIDs[31] = 701895424;
        this.modelIDs[32] = 1020662528;
        this.modelIDs[33] = 903222016;
        this.modelIDs[34] = 1070994176;
        this.modelIDs[35] = 1456870144;
        this.modelIDs[36] = 651563776;
        this.modelIDs[37] = 1775637248;
        this.modelIDs[38] = 584454912;
        this.modelIDs[39] = 1305875200;
        this.modelIDs[40] = 1272320768;
        this.modelIDs[41] = 1104548608;
        this.modelIDs[42] = 618009344;
        this.modelIDs[43] = 1188434688;
        this.modelIDs[44] = 1641419520;
        this.modelIDs[45] = 1708528384;
        this.modelIDs[46] = 1691751168;
        this.modelIDs[47] = 1490424576;
        this.modelIDs[48] = 869667584;
        this.modelIDs[49] = 567677696;
        this.modelIDs[50] = 1372984064;
        this.modelIDs[51] = 953553664;
        this.modelIDs[52] = 634786560;
        this.modelIDs[53] = 1507201792;
        this.modelIDs[54] = 987108096;
        this.modelIDs[55] = 1289097984;
        this.modelIDs[56] = 785781504;
        this.modelIDs[57] = 852890368;
        this.modelIDs[58] = 1658196736;
        this.modelIDs[59] = 1154880256;
        this.modelIDs[60] = 1859523328;
        this.modelIDs[61] = 886444800;
        this.modelIDs[62] = 752227072;
        this.modelIDs[63] = 550900480;
        this.modelIDs[64] = 1557533440;
        this.modelIDs[65] = 1792414464;
        this.modelIDs[66] = 919999232;
        this.modelIDs[67] = 1591087872;
        this.modelIDs[68] = 936776448;
        this.modelIDs[69] = 1473647360;
        this.modelIDs[70] = 836113152;
        this.modelIDs[71] = 819335936;
        this.modelIDs[72] = 735449856;
        this.modelIDs[73] = 1674973952;
        this.modelIDs[74] = 1540756224;
        this.modelIDs[75] = 668340992;
        this.modelIDs[76] = 1809191680;
        this.modelIDs[77] = 1221989120;
        this.modelIDs[78] = 1574310656;
        this.modelIDs[79] = 1607865088;
    }
}

