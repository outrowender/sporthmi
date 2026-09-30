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
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 51: {
                    this.models[51] = new ButtonModel(1300051);
                    break;
                }
                case 25: {
                    this.models[25] = new BufferedListModel(1300025);
                    break;
                }
                case 77: {
                    this.models[77] = new LabelModel(1300077);
                    break;
                }
                case 35: {
                    this.models[35] = new LabelModel(1300035);
                    break;
                }
                case 64: {
                    this.models[64] = new ChoiceModel(1300064);
                    break;
                }
                case 79: {
                    this.models[79] = new ButtonModel(1300079);
                    break;
                }
                case 71: {
                    this.models[71] = new ButtonModel(1300071);
                    break;
                }
                case 13: {
                    this.models[13] = new LabelModel(1300013);
                    break;
                }
                case 58: {
                    this.models[58] = new LabelModel(1300058);
                    break;
                }
                case 30: {
                    this.models[30] = new BufferedListModel(1300030);
                    break;
                }
                case 47: {
                    this.models[47] = new LabelModel(1300047);
                    break;
                }
                case 10: {
                    this.models[10] = new ChoiceModel(1300010);
                    break;
                }
                case 3: {
                    this.models[3] = new ListModel(1300003);
                    break;
                }
                case 76: {
                    this.models[76] = new LabelModel(1300076);
                    break;
                }
                case 50: {
                    this.models[50] = new LabelModel(1300050);
                    break;
                }
                case 37: {
                    this.models[37] = new ButtonModel(1300037);
                    break;
                }
                case 27: {
                    this.models[27] = new ButtonModel(1300027);
                    break;
                }
                case 70: {
                    this.models[70] = new ButtonModel(1300070);
                    break;
                }
                case 39: {
                    this.models[39] = new ButtonModel(1300039);
                    break;
                }
                case 29: {
                    this.models[29] = new BufferedListModel(1300029);
                    break;
                }
                case 32: {
                    this.models[32] = new ButtonModel(1300032);
                    break;
                }
                case 15: {
                    this.models[15] = new ButtonModel(1300015);
                    break;
                }
                case 46: {
                    this.models[46] = new LabelModel(1300046);
                    break;
                }
                case 42: {
                    this.models[42] = new ButtonModel(1300042);
                    break;
                }
                case 34: {
                    this.models[34] = new ChoiceModel(1300034);
                    break;
                }
                case 52: {
                    this.models[52] = new ButtonModel(1300052);
                    break;
                }
                case 8: {
                    this.models[8] = new ButtonModel(1300008);
                    break;
                }
                case 53: {
                    this.models[53] = new LabelModel(1300053);
                    break;
                }
                case 48: {
                    this.models[48] = new LabelModel(1300048);
                    break;
                }
                case 72: {
                    this.models[72] = new ChoiceModel(1300072);
                    break;
                }
                case 41: {
                    this.models[41] = new ListModel(1300041);
                    break;
                }
                case 9: {
                    this.models[9] = new ChoiceModel(1300009);
                    break;
                }
                case 28: {
                    this.models[28] = new BufferedListModel(1300028);
                    break;
                }
                case 21: {
                    this.models[21] = new BufferedListModel(1300021);
                    break;
                }
                case 31: {
                    this.models[31] = new ButtonModel(1300031);
                    break;
                }
                case 54: {
                    this.models[54] = new LabelModel(1300054);
                    break;
                }
                case 6: {
                    this.models[6] = new ButtonModel(1300006);
                    break;
                }
                case 73: {
                    this.models[73] = new ChoiceModel(1300073);
                    break;
                }
                case 2: {
                    this.models[2] = new ListModel(1300002);
                    break;
                }
                case 45: {
                    this.models[45] = new LabelModel(1300045);
                    break;
                }
                case 43: {
                    this.models[43] = new ListModel(1300043);
                    break;
                }
                case 33: {
                    this.models[33] = new ChoiceModel(1300033);
                    break;
                }
                case 4: {
                    this.models[4] = new ChoiceModel(1300004);
                    break;
                }
                case 38: {
                    this.models[38] = new ButtonModel(1300038);
                    break;
                }
                case 65: {
                    this.models[65] = new ChoiceModel(1300065);
                    break;
                }
                case 69: {
                    this.models[69] = new LabelModel(1300069);
                    break;
                }
                case 68: {
                    this.models[68] = new LabelModel(1300068);
                    break;
                }
                case 56: {
                    this.models[56] = new LabelModel(1300056);
                    break;
                }
                case 19: {
                    this.models[19] = new LabelModel(1300019);
                    break;
                }
                case 1: {
                    this.models[1] = new ListModel(1300001);
                    break;
                }
                case 49: {
                    this.models[49] = new LabelModel(1300049);
                    break;
                }
                case 24: {
                    this.models[24] = new ChoiceModel(1300024);
                    break;
                }
                case 5: {
                    this.models[5] = new SpellerModel(1300005);
                    break;
                }
                case 57: {
                    this.models[57] = new LabelModel(1300057);
                    break;
                }
                case 26: {
                    this.models[26] = new ButtonModel(1300026);
                    break;
                }
                case 44: {
                    this.models[44] = new LabelModel(1300044);
                    break;
                }
                case 14: {
                    this.models[14] = new ButtonModel(1300014);
                    break;
                }
                case 18: {
                    this.models[18] = new ButtonModel(1300018);
                    break;
                }
                case 66: {
                    this.models[66] = new ButtonModel(1300066);
                    break;
                }
                case 36: {
                    this.models[36] = new ButtonModel(1300036);
                    break;
                }
                case 78: {
                    this.models[78] = new LabelModel(1300078);
                    break;
                }
                case 20: {
                    this.models[20] = new LabelModel(1300020);
                    break;
                }
                case 12: {
                    this.models[12] = new LabelModel(1300012);
                    break;
                }
                case 0: {
                    this.models[0] = new ButtonModel(1300000);
                    break;
                }
                case 60: {
                    this.models[60] = new ButtonModel(1300060);
                    break;
                }
                case 74: {
                    this.models[74] = new LabelModel(1300074);
                    break;
                }
                case 22: {
                    this.models[22] = new LabelModel(1300022);
                    break;
                }
                case 62: {
                    this.models[62] = new ChoiceModel(1300062);
                    break;
                }
                case 23: {
                    this.models[23] = new ChoiceModel(1300023);
                    break;
                }
                case 55: {
                    this.models[55] = new LabelModel(1300055);
                    break;
                }
                case 17: {
                    this.models[17] = new ButtonModel(1300017);
                    break;
                }
                case 16: {
                    this.models[16] = new BufferedListModel(1300016);
                    break;
                }
                case 11: {
                    this.models[11] = new ButtonModel(1300011);
                    break;
                }
                case 67: {
                    this.models[67] = new BufferedListModel(1300067);
                    break;
                }
                case 59: {
                    this.models[59] = new ButtonModel(1300059);
                    break;
                }
                case 7: {
                    this.models[7] = new ButtonModel(1300007);
                    break;
                }
                case 75: {
                    this.models[75] = new BufferedListModel(1300075);
                    break;
                }
                case 40: {
                    this.models[40] = new ListModel(1300040);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(1300061);
                    break;
                }
                case 63: {
                    this.models[63] = new ChoiceModel(1300063);
                    break;
                }
                default: {
                    EngineeringModelBank.getModelLogChannel().log(10000, "[EngineeringModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public EngineeringModelBank() {
        super(13, 80, 80);
        this.modelIDs = new int[80];
        this.modelIDs[0] = 1300051;
        this.modelIDs[1] = 1300025;
        this.modelIDs[2] = 1300077;
        this.modelIDs[3] = 1300035;
        this.modelIDs[4] = 1300064;
        this.modelIDs[5] = 1300079;
        this.modelIDs[6] = 1300071;
        this.modelIDs[7] = 1300013;
        this.modelIDs[8] = 1300058;
        this.modelIDs[9] = 1300030;
        this.modelIDs[10] = 1300047;
        this.modelIDs[11] = 1300010;
        this.modelIDs[12] = 1300003;
        this.modelIDs[13] = 1300076;
        this.modelIDs[14] = 1300050;
        this.modelIDs[15] = 1300037;
        this.modelIDs[16] = 1300027;
        this.modelIDs[17] = 1300070;
        this.modelIDs[18] = 1300039;
        this.modelIDs[19] = 1300029;
        this.modelIDs[20] = 1300032;
        this.modelIDs[21] = 1300015;
        this.modelIDs[22] = 1300046;
        this.modelIDs[23] = 1300042;
        this.modelIDs[24] = 1300034;
        this.modelIDs[25] = 1300052;
        this.modelIDs[26] = 1300008;
        this.modelIDs[27] = 1300053;
        this.modelIDs[28] = 1300048;
        this.modelIDs[29] = 1300072;
        this.modelIDs[30] = 1300041;
        this.modelIDs[31] = 1300009;
        this.modelIDs[32] = 1300028;
        this.modelIDs[33] = 1300021;
        this.modelIDs[34] = 1300031;
        this.modelIDs[35] = 1300054;
        this.modelIDs[36] = 1300006;
        this.modelIDs[37] = 1300073;
        this.modelIDs[38] = 1300002;
        this.modelIDs[39] = 1300045;
        this.modelIDs[40] = 1300043;
        this.modelIDs[41] = 1300033;
        this.modelIDs[42] = 1300004;
        this.modelIDs[43] = 1300038;
        this.modelIDs[44] = 1300065;
        this.modelIDs[45] = 1300069;
        this.modelIDs[46] = 1300068;
        this.modelIDs[47] = 1300056;
        this.modelIDs[48] = 1300019;
        this.modelIDs[49] = 1300001;
        this.modelIDs[50] = 1300049;
        this.modelIDs[51] = 1300024;
        this.modelIDs[52] = 1300005;
        this.modelIDs[53] = 1300057;
        this.modelIDs[54] = 1300026;
        this.modelIDs[55] = 1300044;
        this.modelIDs[56] = 1300014;
        this.modelIDs[57] = 1300018;
        this.modelIDs[58] = 1300066;
        this.modelIDs[59] = 1300036;
        this.modelIDs[60] = 1300078;
        this.modelIDs[61] = 1300020;
        this.modelIDs[62] = 1300012;
        this.modelIDs[63] = 1300000;
        this.modelIDs[64] = 1300060;
        this.modelIDs[65] = 1300074;
        this.modelIDs[66] = 1300022;
        this.modelIDs[67] = 1300062;
        this.modelIDs[68] = 1300023;
        this.modelIDs[69] = 1300055;
        this.modelIDs[70] = 1300017;
        this.modelIDs[71] = 1300016;
        this.modelIDs[72] = 1300011;
        this.modelIDs[73] = 1300067;
        this.modelIDs[74] = 1300059;
        this.modelIDs[75] = 1300007;
        this.modelIDs[76] = 1300075;
        this.modelIDs[77] = 1300040;
        this.modelIDs[78] = 1300061;
        this.modelIDs[79] = 1300063;
    }
}

