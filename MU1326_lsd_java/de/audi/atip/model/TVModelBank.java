/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.DataModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.property.PropertyModel;
import de.audi.atip.model.ICoreTVModelBank;
import de.audi.atip.model.IEvoTVModelBank;

public class TVModelBank
extends AbstractModelBank
implements ICoreTVModelBank,
IEvoTVModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 77: {
                    this.models[77] = new ChoiceModel(2600077);
                    break;
                }
                case 109: {
                    this.models[109] = new MetricsModel(2600109);
                    break;
                }
                case 111: {
                    this.models[111] = new ButtonModel(2600111);
                    break;
                }
                case 32: {
                    this.models[32] = new ChoiceModel(2600032);
                    break;
                }
                case 152: {
                    this.models[152] = new MetricsModel(2600152);
                    break;
                }
                case 138: {
                    this.models[138] = new ButtonModel(2600138);
                    break;
                }
                case 59: {
                    this.models[59] = new ChoiceModel(2600059);
                    break;
                }
                case 12: {
                    this.models[12] = new ButtonModel(2600012);
                    break;
                }
                case 81: {
                    this.models[81] = new ChoiceModel(2600081);
                    break;
                }
                case 186: {
                    this.models[186] = new ButtonModel(2600186);
                    break;
                }
                case 51: {
                    this.models[51] = new ButtonModel(2600051);
                    break;
                }
                case 106: {
                    this.models[106] = new VirtualButtonModel(2600106);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(2600089);
                    break;
                }
                case 177: {
                    this.models[177] = new VirtualButtonModel(2600177);
                    break;
                }
                case 105: {
                    this.models[105] = new RangeModel(2600105);
                    break;
                }
                case 150: {
                    this.models[150] = new ChoiceModel(2600150);
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(2600155);
                    break;
                }
                case 92: {
                    this.models[92] = new MenuModel(2600092);
                    break;
                }
                case 48: {
                    this.models[48] = new OptionModel(2600048);
                    break;
                }
                case 159: {
                    this.models[159] = new ChoiceModel(2600159);
                    break;
                }
                case 49: {
                    this.models[49] = new ChoiceModel(2600049);
                    break;
                }
                case 162: {
                    this.models[162] = new MenuModel(2600162);
                    break;
                }
                case 123: {
                    this.models[123] = new ChoiceModel(2600123);
                    break;
                }
                case 142: {
                    this.models[142] = new ButtonModel(2600142);
                    break;
                }
                case 45: {
                    this.models[45] = new BaseListModel(2600045, (MenuModel)this.getModel(2600092));
                    break;
                }
                case 178: {
                    this.models[178] = new ButtonModel(2600178);
                    break;
                }
                case 86: {
                    this.models[86] = new ButtonModel(2600086);
                    break;
                }
                case 57: {
                    this.models[57] = new ChoiceModel(2600057);
                    break;
                }
                case 47: {
                    this.models[47] = new BaseListModel(2600047, null);
                    break;
                }
                case 160: {
                    this.models[160] = new ChoiceModel(2600160);
                    break;
                }
                case 100: {
                    this.models[100] = new ChoiceModel(2600100);
                    break;
                }
                case 68: {
                    this.models[68] = new ChoiceModel(2600068);
                    break;
                }
                case 95: {
                    this.models[95] = new RangeModel(2600095);
                    break;
                }
                case 91: {
                    this.models[91] = new OptionModel(2600091);
                    break;
                }
                case 29: {
                    this.models[29] = new ChoiceModel(2600029);
                    break;
                }
                case 31: {
                    this.models[31] = new BaseListModel(2600031, null);
                    break;
                }
                case 85: {
                    this.models[85] = new ChoiceModel(2600085);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(2600099);
                    break;
                }
                case 116: {
                    this.models[116] = new BaseListModel(2600116, null);
                    break;
                }
                case 157: {
                    this.models[157] = new DataModel(2600157);
                    break;
                }
                case 184: {
                    this.models[184] = new ChoiceModel(2600184);
                    break;
                }
                case 10: {
                    this.models[10] = new ChoiceModel(2600010);
                    break;
                }
                case 78: {
                    this.models[78] = new LabelModel(2600078);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(2600061);
                    break;
                }
                case 182: {
                    this.models[182] = new ChoiceModel(2600182);
                    break;
                }
                case 129: {
                    this.models[129] = new ButtonModel(2600129);
                    break;
                }
                case 200: {
                    this.models[200] = new ChoiceModel(2600200);
                    break;
                }
                case 84: {
                    this.models[84] = new ChoiceModel(2600084);
                    break;
                }
                case 151: {
                    this.models[151] = new MenuModel(2600151);
                    break;
                }
                case 137: {
                    this.models[137] = new ButtonModel(2600137);
                    break;
                }
                case 73: {
                    this.models[73] = new LabelModel(2600073);
                    break;
                }
                case 87: {
                    this.models[87] = new LabelModel(2600087);
                    break;
                }
                case 136: {
                    this.models[136] = new ButtonModel(2600136);
                    break;
                }
                case 70: {
                    this.models[70] = new ChoiceModel(2600070);
                    break;
                }
                case 143: {
                    this.models[143] = new ButtonModel(2600143);
                    break;
                }
                case 58: {
                    this.models[58] = new ChoiceModel(2600058);
                    break;
                }
                case 88: {
                    this.models[88] = new LabelModel(2600088);
                    break;
                }
                case 17: {
                    this.models[17] = new ChoiceModel(2600017);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(2600145);
                    break;
                }
                case 169: {
                    this.models[169] = new ChoiceModel(2600169);
                    break;
                }
                case 42: {
                    this.models[42] = new LabelModel(2600042);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(2600149);
                    break;
                }
                case 223: {
                    this.models[223] = new ChoiceModel(2600223);
                    break;
                }
                case 113: {
                    this.models[113] = new ChoiceModel(2600113);
                    break;
                }
                case 97: {
                    this.models[97] = new ButtonModel(2600097);
                    break;
                }
                case 39: {
                    this.models[39] = new OptionModel(2600039);
                    break;
                }
                case 118: {
                    this.models[118] = new ChoiceModel(2600118);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(2600115);
                    break;
                }
                case 67: {
                    this.models[67] = new ChoiceModel(2600067);
                    break;
                }
                case 41: {
                    this.models[41] = new ChoiceModel(2600041);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(2600171);
                    break;
                }
                case 53: {
                    this.models[53] = new ChoiceModel(2600053);
                    break;
                }
                case 60: {
                    this.models[60] = new ChoiceModel(2600060);
                    break;
                }
                case 14: {
                    this.models[14] = new ChoiceModel(2600014);
                    break;
                }
                case 141: {
                    this.models[141] = new ButtonModel(2600141);
                    break;
                }
                case 183: {
                    this.models[183] = new ChoiceModel(2600183);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(2600044);
                    break;
                }
                case 175: {
                    this.models[175] = new MetricsModel(2600175);
                    break;
                }
                case 127: {
                    this.models[127] = new ButtonModel(2600127);
                    break;
                }
                case 148: {
                    this.models[148] = new ChoiceModel(2600148);
                    break;
                }
                case 110: {
                    this.models[110] = new ButtonModel(2600110);
                    break;
                }
                case 128: {
                    this.models[128] = new ButtonModel(2600128);
                    break;
                }
                case 26: {
                    this.models[26] = new ChoiceModel(2600026);
                    break;
                }
                case 66: {
                    this.models[66] = new ChoiceModel(2600066);
                    break;
                }
                case 34: {
                    this.models[34] = new ChoiceModel(2600034);
                    break;
                }
                case 176: {
                    this.models[176] = new ChoiceModel(2600176);
                    break;
                }
                case 179: {
                    this.models[179] = new ButtonModel(2600179);
                    break;
                }
                case 140: {
                    this.models[140] = new ButtonModel(2600140);
                    break;
                }
                case 174: {
                    this.models[174] = new ChoiceModel(2600174);
                    break;
                }
                case 9: {
                    this.models[9] = new ChoiceModel(2600009);
                    break;
                }
                case 119: {
                    this.models[119] = new ChoiceModel(2600119);
                    break;
                }
                case 55: {
                    this.models[55] = new ChoiceModel(2600055);
                    break;
                }
                case 54: {
                    this.models[54] = new ChoiceModel(2600054);
                    break;
                }
                case 228: {
                    this.models[228] = new MetricsModel(2600228);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(2600161);
                    break;
                }
                case 28: {
                    this.models[28] = new ChoiceModel(2600028);
                    break;
                }
                case 135: {
                    this.models[135] = new ButtonModel(2600135);
                    break;
                }
                case 132: {
                    this.models[132] = new ButtonModel(2600132);
                    break;
                }
                case 130: {
                    this.models[130] = new ButtonModel(2600130);
                    break;
                }
                case 224: {
                    this.models[224] = new SpellerModel(2600224);
                    break;
                }
                case 13: {
                    this.models[13] = new ChoiceModel(2600013);
                    break;
                }
                case 187: {
                    this.models[187] = new ChoiceModel(2600187);
                    break;
                }
                case 93: {
                    this.models[93] = new ChoiceModel(2600093);
                    break;
                }
                case 158: {
                    this.models[158] = new DataModel(2600158);
                    break;
                }
                case 69: {
                    this.models[69] = new ChoiceModel(2600069);
                    break;
                }
                case 76: {
                    this.models[76] = new ChoiceModel(2600076);
                    break;
                }
                case 15: {
                    this.models[15] = new SpellerModel(2600015);
                    break;
                }
                case 213: {
                    this.models[213] = new ButtonModel(2600213);
                    break;
                }
                case 164: {
                    this.models[164] = new ButtonModel(2600164);
                    break;
                }
                case 35: {
                    this.models[35] = new ChoiceModel(2600035);
                    break;
                }
                case 22: {
                    this.models[22] = new BaseListModel(2600022, null);
                    break;
                }
                case 90: {
                    this.models[90] = new ButtonModel(2600090);
                    break;
                }
                case 0: {
                    this.models[0] = new BaseListModel(2600000, (MenuModel)this.getModel(2600162));
                    break;
                }
                case 154: {
                    this.models[154] = new ChoiceModel(2600154);
                    break;
                }
                case 126: {
                    this.models[126] = new ButtonModel(2600126);
                    break;
                }
                case 112: {
                    this.models[112] = new LabelModel(2600112);
                    break;
                }
                case 133: {
                    this.models[133] = new ButtonModel(2600133);
                    break;
                }
                case 121: {
                    this.models[121] = new ChoiceModel(2600121);
                    break;
                }
                case 71: {
                    this.models[71] = new ChoiceModel(2600071);
                    break;
                }
                case 38: {
                    this.models[38] = new ButtonModel(2600038);
                    break;
                }
                case 188: {
                    this.models[188] = new VirtualButtonModel(2600188);
                    break;
                }
                case 37: {
                    this.models[37] = new ChoiceModel(2600037);
                    break;
                }
                case 196: {
                    this.models[196] = new VirtualButtonModel(2600196);
                    break;
                }
                case 11: {
                    this.models[11] = new ChoiceModel(2600011);
                    break;
                }
                case 144: {
                    this.models[144] = new ButtonModel(2600144);
                    break;
                }
                case 120: {
                    this.models[120] = new ChoiceModel(2600120);
                    break;
                }
                case 139: {
                    this.models[139] = new ButtonModel(2600139);
                    break;
                }
                case 43: {
                    this.models[43] = new ButtonModel(2600043);
                    break;
                }
                case 165: {
                    this.models[165] = new ButtonModel(2600165);
                    break;
                }
                case 156: {
                    this.models[156] = new ChoiceModel(2600156);
                    break;
                }
                case 80: {
                    this.models[80] = new ChoiceModel(2600080);
                    break;
                }
                case 96: {
                    this.models[96] = new RangeModel(2600096);
                    break;
                }
                case 63: {
                    this.models[63] = new ChoiceModel(2600063);
                    break;
                }
                case 8: {
                    this.models[8] = new ChoiceModel(2600008);
                    break;
                }
                case 33: {
                    this.models[33] = new BaseListModel(2600033, null);
                    break;
                }
                case 125: {
                    this.models[125] = new ButtonModel(2600125);
                    break;
                }
                case 82: {
                    this.models[82] = new ChoiceModel(2600082);
                    break;
                }
                case 172: {
                    this.models[172] = new ButtonModel(2600172);
                    break;
                }
                case 190: {
                    this.models[190] = new ChoiceModel(2600190);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(2600166);
                    break;
                }
                case 173: {
                    this.models[173] = new ButtonModel(2600173);
                    break;
                }
                case 64: {
                    this.models[64] = new ChoiceModel(2600064);
                    break;
                }
                case 180: {
                    this.models[180] = new ResourceLocatorModel(2600180);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(2600101);
                    break;
                }
                case 19: {
                    this.models[19] = new BaseListModel(2600019, null);
                    break;
                }
                case 79: {
                    this.models[79] = new ChoiceModel(2600079);
                    break;
                }
                case 52: {
                    this.models[52] = new ButtonModel(2600052);
                    break;
                }
                case 62: {
                    this.models[62] = new ChoiceModel(2600062);
                    break;
                }
                case 124: {
                    this.models[124] = new ButtonModel(2600124);
                    break;
                }
                case 65: {
                    this.models[65] = new ChoiceModel(2600065);
                    break;
                }
                case 146: {
                    this.models[146] = new ChoiceModel(2600146);
                    break;
                }
                case 56: {
                    this.models[56] = new ChoiceModel(2600056);
                    break;
                }
                case 122: {
                    this.models[122] = new ButtonModel(2600122);
                    break;
                }
                case 147: {
                    this.models[147] = new ChoiceModel(2600147);
                    break;
                }
                case 131: {
                    this.models[131] = new ButtonModel(2600131);
                    break;
                }
                case 107: {
                    this.models[107] = new ChoiceModel(2600107);
                    break;
                }
                case 74: {
                    this.models[74] = new LabelModel(2600074);
                    break;
                }
                case 102: {
                    this.models[102] = new ChoiceModel(2600102);
                    break;
                }
                case 108: {
                    this.models[108] = new MetricsModel(2600108);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(2600104);
                    break;
                }
                case 117: {
                    this.models[117] = new PropertyModel(2600117);
                    break;
                }
                case 205: {
                    this.models[205] = new ButtonModel(2600205);
                    break;
                }
                case 20: {
                    this.models[20] = new ButtonModel(2600020);
                    break;
                }
                case 83: {
                    this.models[83] = new ChoiceModel(2600083);
                    break;
                }
                case 94: {
                    this.models[94] = new RangeModel(2600094);
                    break;
                }
                case 46: {
                    this.models[46] = new BaseListModel(2600046, null);
                    break;
                }
                case 153: {
                    this.models[153] = new ChoiceModel(2600153);
                    break;
                }
                case 114: {
                    this.models[114] = new SpellerModel(2600114);
                    break;
                }
                case 40: {
                    this.models[40] = new ChoiceModel(2600040);
                    break;
                }
                case 36: {
                    this.models[36] = new ChoiceModel(2600036);
                    break;
                }
                case 16: {
                    this.models[16] = new ChoiceModel(2600016);
                    break;
                }
                case 23: {
                    this.models[23] = new ChoiceModel(2600023);
                    break;
                }
                case 134: {
                    this.models[134] = new ButtonModel(2600134);
                    break;
                }
                case 103: {
                    this.models[103] = new ChoiceModel(2600103);
                    break;
                }
                default: {
                    TVModelBank.getModelLogChannel().log(10000, "[TVModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TVModelBank() {
        super(26, 229, 174);
        this.modelIDs = new int[174];
        this.modelIDs[0] = 2600077;
        this.modelIDs[1] = 2600109;
        this.modelIDs[2] = 2600111;
        this.modelIDs[3] = 2600032;
        this.modelIDs[4] = 2600152;
        this.modelIDs[5] = 2600138;
        this.modelIDs[6] = 2600059;
        this.modelIDs[7] = 2600012;
        this.modelIDs[8] = 2600081;
        this.modelIDs[9] = 2600186;
        this.modelIDs[10] = 2600051;
        this.modelIDs[11] = 2600106;
        this.modelIDs[12] = 2600089;
        this.modelIDs[13] = 2600177;
        this.modelIDs[14] = 2600105;
        this.modelIDs[15] = 2600150;
        this.modelIDs[16] = 2600155;
        this.modelIDs[17] = 2600092;
        this.modelIDs[18] = 2600048;
        this.modelIDs[19] = 2600159;
        this.modelIDs[20] = 2600049;
        this.modelIDs[21] = 2600162;
        this.modelIDs[22] = 2600123;
        this.modelIDs[23] = 2600142;
        this.modelIDs[24] = 2600045;
        this.modelIDs[25] = 2600178;
        this.modelIDs[26] = 2600086;
        this.modelIDs[27] = 2600057;
        this.modelIDs[28] = 2600047;
        this.modelIDs[29] = 2600160;
        this.modelIDs[30] = 2600100;
        this.modelIDs[31] = 2600068;
        this.modelIDs[32] = 2600095;
        this.modelIDs[33] = 2600091;
        this.modelIDs[34] = 2600029;
        this.modelIDs[35] = 2600031;
        this.modelIDs[36] = 2600085;
        this.modelIDs[37] = 2600099;
        this.modelIDs[38] = 2600116;
        this.modelIDs[39] = 2600157;
        this.modelIDs[40] = 2600184;
        this.modelIDs[41] = 2600010;
        this.modelIDs[42] = 2600078;
        this.modelIDs[43] = 2600061;
        this.modelIDs[44] = 2600182;
        this.modelIDs[45] = 2600129;
        this.modelIDs[46] = 2600200;
        this.modelIDs[47] = 2600084;
        this.modelIDs[48] = 2600151;
        this.modelIDs[49] = 2600137;
        this.modelIDs[50] = 2600073;
        this.modelIDs[51] = 2600087;
        this.modelIDs[52] = 2600136;
        this.modelIDs[53] = 2600070;
        this.modelIDs[54] = 2600143;
        this.modelIDs[55] = 2600058;
        this.modelIDs[56] = 2600088;
        this.modelIDs[57] = 2600017;
        this.modelIDs[58] = 2600145;
        this.modelIDs[59] = 2600169;
        this.modelIDs[60] = 2600042;
        this.modelIDs[61] = 2600149;
        this.modelIDs[62] = 2600223;
        this.modelIDs[63] = 2600113;
        this.modelIDs[64] = 2600097;
        this.modelIDs[65] = 2600039;
        this.modelIDs[66] = 2600118;
        this.modelIDs[67] = 2600115;
        this.modelIDs[68] = 2600067;
        this.modelIDs[69] = 2600041;
        this.modelIDs[70] = 2600171;
        this.modelIDs[71] = 2600053;
        this.modelIDs[72] = 2600060;
        this.modelIDs[73] = 2600014;
        this.modelIDs[74] = 2600141;
        this.modelIDs[75] = 2600183;
        this.modelIDs[76] = 2600044;
        this.modelIDs[77] = 2600175;
        this.modelIDs[78] = 2600127;
        this.modelIDs[79] = 2600148;
        this.modelIDs[80] = 2600110;
        this.modelIDs[81] = 2600128;
        this.modelIDs[82] = 2600026;
        this.modelIDs[83] = 2600066;
        this.modelIDs[84] = 2600034;
        this.modelIDs[85] = 2600176;
        this.modelIDs[86] = 2600179;
        this.modelIDs[87] = 2600140;
        this.modelIDs[88] = 2600174;
        this.modelIDs[89] = 2600009;
        this.modelIDs[90] = 2600119;
        this.modelIDs[91] = 2600055;
        this.modelIDs[92] = 2600054;
        this.modelIDs[93] = 2600228;
        this.modelIDs[94] = 2600161;
        this.modelIDs[95] = 2600028;
        this.modelIDs[96] = 2600135;
        this.modelIDs[97] = 2600132;
        this.modelIDs[98] = 2600130;
        this.modelIDs[99] = 2600224;
        this.modelIDs[100] = 2600013;
        this.modelIDs[101] = 2600187;
        this.modelIDs[102] = 2600093;
        this.modelIDs[103] = 2600158;
        this.modelIDs[104] = 2600069;
        this.modelIDs[105] = 2600076;
        this.modelIDs[106] = 2600015;
        this.modelIDs[107] = 2600213;
        this.modelIDs[108] = 2600164;
        this.modelIDs[109] = 2600035;
        this.modelIDs[110] = 2600022;
        this.modelIDs[111] = 2600090;
        this.modelIDs[112] = 2600000;
        this.modelIDs[113] = 2600154;
        this.modelIDs[114] = 2600126;
        this.modelIDs[115] = 2600112;
        this.modelIDs[116] = 2600133;
        this.modelIDs[117] = 2600121;
        this.modelIDs[118] = 2600071;
        this.modelIDs[119] = 2600038;
        this.modelIDs[120] = 2600188;
        this.modelIDs[121] = 2600037;
        this.modelIDs[122] = 2600196;
        this.modelIDs[123] = 2600011;
        this.modelIDs[124] = 2600144;
        this.modelIDs[125] = 2600120;
        this.modelIDs[126] = 2600139;
        this.modelIDs[127] = 2600043;
        this.modelIDs[128] = 2600165;
        this.modelIDs[129] = 2600156;
        this.modelIDs[130] = 2600080;
        this.modelIDs[131] = 2600096;
        this.modelIDs[132] = 2600063;
        this.modelIDs[133] = 2600008;
        this.modelIDs[134] = 2600033;
        this.modelIDs[135] = 2600125;
        this.modelIDs[136] = 2600082;
        this.modelIDs[137] = 2600172;
        this.modelIDs[138] = 2600190;
        this.modelIDs[139] = 2600166;
        this.modelIDs[140] = 2600173;
        this.modelIDs[141] = 2600064;
        this.modelIDs[142] = 2600180;
        this.modelIDs[143] = 2600101;
        this.modelIDs[144] = 2600019;
        this.modelIDs[145] = 2600079;
        this.modelIDs[146] = 2600052;
        this.modelIDs[147] = 2600062;
        this.modelIDs[148] = 2600124;
        this.modelIDs[149] = 2600065;
        this.modelIDs[150] = 2600146;
        this.modelIDs[151] = 2600056;
        this.modelIDs[152] = 2600122;
        this.modelIDs[153] = 2600147;
        this.modelIDs[154] = 2600131;
        this.modelIDs[155] = 2600107;
        this.modelIDs[156] = 2600074;
        this.modelIDs[157] = 2600102;
        this.modelIDs[158] = 2600108;
        this.modelIDs[159] = 2600104;
        this.modelIDs[160] = 2600117;
        this.modelIDs[161] = 2600205;
        this.modelIDs[162] = 2600020;
        this.modelIDs[163] = 2600083;
        this.modelIDs[164] = 2600094;
        this.modelIDs[165] = 2600046;
        this.modelIDs[166] = 2600153;
        this.modelIDs[167] = 2600114;
        this.modelIDs[168] = 2600040;
        this.modelIDs[169] = 2600036;
        this.modelIDs[170] = 2600016;
        this.modelIDs[171] = 2600023;
        this.modelIDs[172] = 2600134;
        this.modelIDs[173] = 2600103;
    }
}

