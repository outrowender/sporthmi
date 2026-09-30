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
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.hmi.model.TooltipModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.model.ICoreInfoModelBank;
import de.audi.atip.model.IEvoInfoModelBank;

public class InfoModelBank
extends AbstractModelBank
implements ICoreInfoModelBank,
IEvoInfoModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 167: {
                    this.models[167] = new ButtonModel(500167);
                    break;
                }
                case 139: {
                    this.models[139] = new LabelModel(500139);
                    break;
                }
                case 153: {
                    this.models[153] = new LabelModel(500153);
                    break;
                }
                case 143: {
                    this.models[143] = new TerminalModelContainer(500143, 12, true);
                    break;
                }
                case 174: {
                    this.models[174] = new LabelModel(500174);
                    break;
                }
                case 146: {
                    this.models[146] = new LabelModel(500146);
                    break;
                }
                case 180: {
                    this.models[180] = new ChoiceModel(500180);
                    break;
                }
                case 160: {
                    this.models[160] = new ChoiceModel(500160);
                    break;
                }
                case 150: {
                    this.models[150] = new LabelModel(500150);
                    break;
                }
                case 144: {
                    this.models[144] = new ChoiceModel(500144);
                    break;
                }
                case 172: {
                    this.models[172] = new MetricsModel(500172);
                    break;
                }
                case 179: {
                    this.models[179] = new ListModel(500179);
                    break;
                }
                case 142: {
                    this.models[142] = new BufferedListModel(500142);
                    break;
                }
                case 55: {
                    this.models[55] = new LabelModel(500055);
                    break;
                }
                case 133: {
                    this.models[133] = new ChoiceModel(500133);
                    break;
                }
                case 135: {
                    this.models[135] = new RangeModel(500135);
                    break;
                }
                case 148: {
                    this.models[148] = new TerminalModelContainer(500148, 1, false);
                    break;
                }
                case 165: {
                    this.models[165] = new TooltipModel(500165);
                    break;
                }
                case 56: {
                    this.models[56] = new LabelModel(500056);
                    break;
                }
                case 110: {
                    this.models[110] = new LabelModel(500110);
                    break;
                }
                case 129: {
                    this.models[129] = new TiledListModel(500129, (MenuModel)this.getModel(500141));
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(500155);
                    break;
                }
                case 151: {
                    this.models[151] = new ListModel(500151);
                    break;
                }
                case 130: {
                    this.models[130] = new TerminalModelContainer(500130, 3, false);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(500166);
                    break;
                }
                case 168: {
                    this.models[168] = new ChoiceModel(500168);
                    break;
                }
                case 158: {
                    this.models[158] = new LabelModel(500158);
                    break;
                }
                case 182: {
                    this.models[182] = new VirtualButtonModel(500182);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(500115);
                    break;
                }
                case 131: {
                    this.models[131] = new VirtualButtonModel(500131);
                    break;
                }
                case 157: {
                    this.models[157] = new ChoiceModel(500157);
                    break;
                }
                case 184: {
                    this.models[184] = new TerminalModelContainer(500184, 4, false);
                    break;
                }
                case 54: {
                    this.models[54] = new LabelModel(500054);
                    break;
                }
                case 141: {
                    this.models[141] = new MenuModel(500141);
                    break;
                }
                case 199: {
                    this.models[199] = new MetricsModel(500199);
                    break;
                }
                case 226: {
                    this.models[226] = new BaseListModel(500226, null);
                    break;
                }
                case 200: {
                    this.models[200] = new LabelModel(500200);
                    break;
                }
                case 137: {
                    this.models[137] = new LabelModel(500137);
                    break;
                }
                case 53: {
                    this.models[53] = new RangeModel(500053);
                    break;
                }
                case 233: {
                    this.models[233] = new ButtonModel(500233);
                    break;
                }
                case 134: {
                    this.models[134] = new ChoiceModel(500134);
                    break;
                }
                case 162: {
                    this.models[162] = new ButtonModel(500162);
                    break;
                }
                case 136: {
                    this.models[136] = new LabelModel(500136);
                    break;
                }
                case 108: {
                    this.models[108] = new LabelModel(500108);
                    break;
                }
                case 191: {
                    this.models[191] = new ChoiceModel(500191);
                    break;
                }
                case 181: {
                    this.models[181] = new ListModel(500181);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(500171);
                    break;
                }
                case 195: {
                    this.models[195] = new ListModel(500195);
                    break;
                }
                case 177: {
                    this.models[177] = new ButtonModel(500177);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(500149);
                    break;
                }
                case 109: {
                    this.models[109] = new LabelModel(500109);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(500161);
                    break;
                }
                case 170: {
                    this.models[170] = new ChoiceModel(500170);
                    break;
                }
                case 106: {
                    this.models[106] = new MetricsModel(500106);
                    break;
                }
                case 163: {
                    this.models[163] = new ChoiceModel(500163);
                    break;
                }
                case 186: {
                    this.models[186] = new TerminalModelContainer(500186, 1, false);
                    break;
                }
                case 196: {
                    this.models[196] = new ChoiceModel(500196);
                    break;
                }
                case 225: {
                    this.models[225] = new BaseListModel(500225, null);
                    break;
                }
                case 183: {
                    this.models[183] = new TerminalModelContainer(500183, 2, false);
                    break;
                }
                case 156: {
                    this.models[156] = new ChoiceModel(500156);
                    break;
                }
                case 152: {
                    this.models[152] = new ChoiceModel(500152);
                    break;
                }
                case 154: {
                    this.models[154] = new ListModel(500154);
                    break;
                }
                case 193: {
                    this.models[193] = new ChoiceModel(500193);
                    break;
                }
                case 202: {
                    this.models[202] = new ChoiceModel(500202);
                    break;
                }
                case 147: {
                    this.models[147] = new TerminalModelContainer(500147, 1, false);
                    break;
                }
                case 188: {
                    this.models[188] = new LabelModel(500188);
                    break;
                }
                case 176: {
                    this.models[176] = new ButtonModel(500176);
                    break;
                }
                case 206: {
                    this.models[206] = new ChoiceModel(500206);
                    break;
                }
                case 190: {
                    this.models[190] = new LabelModel(500190);
                    break;
                }
                case 159: {
                    this.models[159] = new ButtonModel(500159);
                    break;
                }
                case 192: {
                    this.models[192] = new ChoiceModel(500192);
                    break;
                }
                case 94: {
                    this.models[94] = new ButtonModel(500094);
                    break;
                }
                case 175: {
                    this.models[175] = new BaseListModel(500175, null);
                    break;
                }
                case 173: {
                    this.models[173] = new MetricsModel(500173);
                    break;
                }
                case 169: {
                    this.models[169] = new ButtonModel(500169);
                    break;
                }
                case 189: {
                    this.models[189] = new LabelModel(500189);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(500185);
                    break;
                }
                case 203: {
                    this.models[203] = new OptionModel(500203);
                    break;
                }
                case 132: {
                    this.models[132] = new LabelModel(500132);
                    break;
                }
                case 164: {
                    this.models[164] = new ButtonModel(500164);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(500145);
                    break;
                }
                case 194: {
                    this.models[194] = new TerminalModelContainer(500194, 12, true);
                    break;
                }
                case 138: {
                    this.models[138] = new ChoiceModel(500138);
                    break;
                }
                case 187: {
                    this.models[187] = new ButtonModel(500187);
                    break;
                }
                default: {
                    InfoModelBank.getModelLogChannel().log(10000, "[InfoModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public InfoModelBank() {
        super(5, 234, 84);
        this.modelIDs = new int[84];
        this.modelIDs[0] = 500167;
        this.modelIDs[1] = 500139;
        this.modelIDs[2] = 500153;
        this.modelIDs[3] = 500143;
        this.modelIDs[4] = 500174;
        this.modelIDs[5] = 500146;
        this.modelIDs[6] = 500180;
        this.modelIDs[7] = 500160;
        this.modelIDs[8] = 500150;
        this.modelIDs[9] = 500144;
        this.modelIDs[10] = 500172;
        this.modelIDs[11] = 500179;
        this.modelIDs[12] = 500142;
        this.modelIDs[13] = 500055;
        this.modelIDs[14] = 500133;
        this.modelIDs[15] = 500135;
        this.modelIDs[16] = 500148;
        this.modelIDs[17] = 500165;
        this.modelIDs[18] = 500056;
        this.modelIDs[19] = 500110;
        this.modelIDs[20] = 500129;
        this.modelIDs[21] = 500155;
        this.modelIDs[22] = 500151;
        this.modelIDs[23] = 500130;
        this.modelIDs[24] = 500166;
        this.modelIDs[25] = 500168;
        this.modelIDs[26] = 500158;
        this.modelIDs[27] = 500182;
        this.modelIDs[28] = 500115;
        this.modelIDs[29] = 500131;
        this.modelIDs[30] = 500157;
        this.modelIDs[31] = 500184;
        this.modelIDs[32] = 500054;
        this.modelIDs[33] = 500141;
        this.modelIDs[34] = 500199;
        this.modelIDs[35] = 500226;
        this.modelIDs[36] = 500200;
        this.modelIDs[37] = 500137;
        this.modelIDs[38] = 500053;
        this.modelIDs[39] = 500233;
        this.modelIDs[40] = 500134;
        this.modelIDs[41] = 500162;
        this.modelIDs[42] = 500136;
        this.modelIDs[43] = 500108;
        this.modelIDs[44] = 500191;
        this.modelIDs[45] = 500181;
        this.modelIDs[46] = 500171;
        this.modelIDs[47] = 500195;
        this.modelIDs[48] = 500177;
        this.modelIDs[49] = 500149;
        this.modelIDs[50] = 500109;
        this.modelIDs[51] = 500161;
        this.modelIDs[52] = 500170;
        this.modelIDs[53] = 500106;
        this.modelIDs[54] = 500163;
        this.modelIDs[55] = 500186;
        this.modelIDs[56] = 500196;
        this.modelIDs[57] = 500225;
        this.modelIDs[58] = 500183;
        this.modelIDs[59] = 500156;
        this.modelIDs[60] = 500152;
        this.modelIDs[61] = 500154;
        this.modelIDs[62] = 500193;
        this.modelIDs[63] = 500202;
        this.modelIDs[64] = 500147;
        this.modelIDs[65] = 500188;
        this.modelIDs[66] = 500176;
        this.modelIDs[67] = 500206;
        this.modelIDs[68] = 500190;
        this.modelIDs[69] = 500159;
        this.modelIDs[70] = 500192;
        this.modelIDs[71] = 500094;
        this.modelIDs[72] = 500175;
        this.modelIDs[73] = 500173;
        this.modelIDs[74] = 500169;
        this.modelIDs[75] = 500189;
        this.modelIDs[76] = 500185;
        this.modelIDs[77] = 500203;
        this.modelIDs[78] = 500132;
        this.modelIDs[79] = 500164;
        this.modelIDs[80] = 500145;
        this.modelIDs[81] = 500194;
        this.modelIDs[82] = 500138;
        this.modelIDs[83] = 500187;
    }
}

