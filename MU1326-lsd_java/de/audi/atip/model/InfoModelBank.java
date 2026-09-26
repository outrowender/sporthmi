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
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 167: {
                    this.models[167] = new ButtonModel(-945748224);
                    break;
                }
                case 139: {
                    this.models[139] = new LabelModel(-1415510272);
                    break;
                }
                case 153: {
                    this.models[153] = new LabelModel(-1180629248);
                    break;
                }
                case 143: {
                    this.models[143] = new TerminalModelContainer(-1348401408, 12, true);
                    break;
                }
                case 174: {
                    this.models[174] = new LabelModel(-828307712);
                    break;
                }
                case 146: {
                    this.models[146] = new LabelModel(-1298069760);
                    break;
                }
                case 180: {
                    this.models[180] = new ChoiceModel(-727644416);
                    break;
                }
                case 160: {
                    this.models[160] = new ChoiceModel(-1063188736);
                    break;
                }
                case 150: {
                    this.models[150] = new LabelModel(-1230960896);
                    break;
                }
                case 144: {
                    this.models[144] = new ChoiceModel(-1331624192);
                    break;
                }
                case 172: {
                    this.models[172] = new MetricsModel(-861862144);
                    break;
                }
                case 179: {
                    this.models[179] = new ListModel(-744421632);
                    break;
                }
                case 142: {
                    this.models[142] = new BufferedListModel(-1365178624);
                    break;
                }
                case 55: {
                    this.models[55] = new LabelModel(1470170880);
                    break;
                }
                case 133: {
                    this.models[133] = new ChoiceModel(-1516173568);
                    break;
                }
                case 135: {
                    this.models[135] = new RangeModel(-1482619136);
                    break;
                }
                case 148: {
                    this.models[148] = new TerminalModelContainer(-1264515328, 1, false);
                    break;
                }
                case 165: {
                    this.models[165] = new TooltipModel(-979302656);
                    break;
                }
                case 56: {
                    this.models[56] = new LabelModel(1486948096);
                    break;
                }
                case 110: {
                    this.models[110] = new LabelModel(-1902049536);
                    break;
                }
                case 129: {
                    this.models[129] = new TiledListModel(-1583282432, (MenuModel)this.getModel(-1381955840));
                    break;
                }
                case 155: {
                    this.models[155] = new ButtonModel(-1147074816);
                    break;
                }
                case 151: {
                    this.models[151] = new ListModel(-1214183680);
                    break;
                }
                case 130: {
                    this.models[130] = new TerminalModelContainer(-1566505216, 3, false);
                    break;
                }
                case 166: {
                    this.models[166] = new ChoiceModel(-962525440);
                    break;
                }
                case 168: {
                    this.models[168] = new ChoiceModel(-928971008);
                    break;
                }
                case 158: {
                    this.models[158] = new LabelModel(-1096743168);
                    break;
                }
                case 182: {
                    this.models[182] = new VirtualButtonModel(-694089984);
                    break;
                }
                case 115: {
                    this.models[115] = new ChoiceModel(-1818163456);
                    break;
                }
                case 131: {
                    this.models[131] = new VirtualButtonModel(-1549728000);
                    break;
                }
                case 157: {
                    this.models[157] = new ChoiceModel(-1113520384);
                    break;
                }
                case 184: {
                    this.models[184] = new TerminalModelContainer(-660535552, 4, false);
                    break;
                }
                case 54: {
                    this.models[54] = new LabelModel(1453393664);
                    break;
                }
                case 141: {
                    this.models[141] = new MenuModel(-1381955840);
                    break;
                }
                case 199: {
                    this.models[199] = new MetricsModel(-408877312);
                    break;
                }
                case 226: {
                    this.models[226] = new BaseListModel(44173056, null);
                    break;
                }
                case 200: {
                    this.models[200] = new LabelModel(-392100096);
                    break;
                }
                case 137: {
                    this.models[137] = new LabelModel(-1449064704);
                    break;
                }
                case 53: {
                    this.models[53] = new RangeModel(1436616448);
                    break;
                }
                case 233: {
                    this.models[233] = new ButtonModel(161613568);
                    break;
                }
                case 134: {
                    this.models[134] = new ChoiceModel(-1499396352);
                    break;
                }
                case 162: {
                    this.models[162] = new ButtonModel(-1029634304);
                    break;
                }
                case 136: {
                    this.models[136] = new LabelModel(-1465841920);
                    break;
                }
                case 108: {
                    this.models[108] = new LabelModel(-1935603968);
                    break;
                }
                case 191: {
                    this.models[191] = new ChoiceModel(-543095040);
                    break;
                }
                case 181: {
                    this.models[181] = new ListModel(-710867200);
                    break;
                }
                case 171: {
                    this.models[171] = new ChoiceModel(-878639360);
                    break;
                }
                case 195: {
                    this.models[195] = new ListModel(-475986176);
                    break;
                }
                case 177: {
                    this.models[177] = new ButtonModel(-777976064);
                    break;
                }
                case 149: {
                    this.models[149] = new ChoiceModel(-1247738112);
                    break;
                }
                case 109: {
                    this.models[109] = new LabelModel(-1918826752);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(-1046411520);
                    break;
                }
                case 170: {
                    this.models[170] = new ChoiceModel(-895416576);
                    break;
                }
                case 106: {
                    this.models[106] = new MetricsModel(-1969158400);
                    break;
                }
                case 163: {
                    this.models[163] = new ChoiceModel(-1012857088);
                    break;
                }
                case 186: {
                    this.models[186] = new TerminalModelContainer(-626981120, 1, false);
                    break;
                }
                case 196: {
                    this.models[196] = new ChoiceModel(-459208960);
                    break;
                }
                case 225: {
                    this.models[225] = new BaseListModel(27395840, null);
                    break;
                }
                case 183: {
                    this.models[183] = new TerminalModelContainer(-677312768, 2, false);
                    break;
                }
                case 156: {
                    this.models[156] = new ChoiceModel(-1130297600);
                    break;
                }
                case 152: {
                    this.models[152] = new ChoiceModel(-1197406464);
                    break;
                }
                case 154: {
                    this.models[154] = new ListModel(-1163852032);
                    break;
                }
                case 193: {
                    this.models[193] = new ChoiceModel(-509540608);
                    break;
                }
                case 202: {
                    this.models[202] = new ChoiceModel(-358545664);
                    break;
                }
                case 147: {
                    this.models[147] = new TerminalModelContainer(-1281292544, 1, false);
                    break;
                }
                case 188: {
                    this.models[188] = new LabelModel(-593426688);
                    break;
                }
                case 176: {
                    this.models[176] = new ButtonModel(-794753280);
                    break;
                }
                case 206: {
                    this.models[206] = new ChoiceModel(-291436800);
                    break;
                }
                case 190: {
                    this.models[190] = new LabelModel(-559872256);
                    break;
                }
                case 159: {
                    this.models[159] = new ButtonModel(-1079965952);
                    break;
                }
                case 192: {
                    this.models[192] = new ChoiceModel(-526317824);
                    break;
                }
                case 94: {
                    this.models[94] = new ButtonModel(2124482304);
                    break;
                }
                case 175: {
                    this.models[175] = new BaseListModel(-811530496, null);
                    break;
                }
                case 173: {
                    this.models[173] = new MetricsModel(-845084928);
                    break;
                }
                case 169: {
                    this.models[169] = new ButtonModel(-912193792);
                    break;
                }
                case 189: {
                    this.models[189] = new LabelModel(-576649472);
                    break;
                }
                case 185: {
                    this.models[185] = new ChoiceModel(-643758336);
                    break;
                }
                case 203: {
                    this.models[203] = new OptionModel(-341768448);
                    break;
                }
                case 132: {
                    this.models[132] = new LabelModel(-1532950784);
                    break;
                }
                case 164: {
                    this.models[164] = new ButtonModel(-996079872);
                    break;
                }
                case 145: {
                    this.models[145] = new ButtonModel(-1314846976);
                    break;
                }
                case 194: {
                    this.models[194] = new TerminalModelContainer(-492763392, 12, true);
                    break;
                }
                case 138: {
                    this.models[138] = new ChoiceModel(-1432287488);
                    break;
                }
                case 187: {
                    this.models[187] = new ButtonModel(-610203904);
                    break;
                }
                default: {
                    InfoModelBank.getModelLogChannel().log(10000, "[InfoModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public InfoModelBank() {
        super(5, 234, 84);
        this.modelIDs = new int[84];
        this.modelIDs[0] = -945748224;
        this.modelIDs[1] = -1415510272;
        this.modelIDs[2] = -1180629248;
        this.modelIDs[3] = -1348401408;
        this.modelIDs[4] = -828307712;
        this.modelIDs[5] = -1298069760;
        this.modelIDs[6] = -727644416;
        this.modelIDs[7] = -1063188736;
        this.modelIDs[8] = -1230960896;
        this.modelIDs[9] = -1331624192;
        this.modelIDs[10] = -861862144;
        this.modelIDs[11] = -744421632;
        this.modelIDs[12] = -1365178624;
        this.modelIDs[13] = 1470170880;
        this.modelIDs[14] = -1516173568;
        this.modelIDs[15] = -1482619136;
        this.modelIDs[16] = -1264515328;
        this.modelIDs[17] = -979302656;
        this.modelIDs[18] = 1486948096;
        this.modelIDs[19] = -1902049536;
        this.modelIDs[20] = -1583282432;
        this.modelIDs[21] = -1147074816;
        this.modelIDs[22] = -1214183680;
        this.modelIDs[23] = -1566505216;
        this.modelIDs[24] = -962525440;
        this.modelIDs[25] = -928971008;
        this.modelIDs[26] = -1096743168;
        this.modelIDs[27] = -694089984;
        this.modelIDs[28] = -1818163456;
        this.modelIDs[29] = -1549728000;
        this.modelIDs[30] = -1113520384;
        this.modelIDs[31] = -660535552;
        this.modelIDs[32] = 1453393664;
        this.modelIDs[33] = -1381955840;
        this.modelIDs[34] = -408877312;
        this.modelIDs[35] = 44173056;
        this.modelIDs[36] = -392100096;
        this.modelIDs[37] = -1449064704;
        this.modelIDs[38] = 1436616448;
        this.modelIDs[39] = 161613568;
        this.modelIDs[40] = -1499396352;
        this.modelIDs[41] = -1029634304;
        this.modelIDs[42] = -1465841920;
        this.modelIDs[43] = -1935603968;
        this.modelIDs[44] = -543095040;
        this.modelIDs[45] = -710867200;
        this.modelIDs[46] = -878639360;
        this.modelIDs[47] = -475986176;
        this.modelIDs[48] = -777976064;
        this.modelIDs[49] = -1247738112;
        this.modelIDs[50] = -1918826752;
        this.modelIDs[51] = -1046411520;
        this.modelIDs[52] = -895416576;
        this.modelIDs[53] = -1969158400;
        this.modelIDs[54] = -1012857088;
        this.modelIDs[55] = -626981120;
        this.modelIDs[56] = -459208960;
        this.modelIDs[57] = 27395840;
        this.modelIDs[58] = -677312768;
        this.modelIDs[59] = -1130297600;
        this.modelIDs[60] = -1197406464;
        this.modelIDs[61] = -1163852032;
        this.modelIDs[62] = -509540608;
        this.modelIDs[63] = -358545664;
        this.modelIDs[64] = -1281292544;
        this.modelIDs[65] = -593426688;
        this.modelIDs[66] = -794753280;
        this.modelIDs[67] = -291436800;
        this.modelIDs[68] = -559872256;
        this.modelIDs[69] = -1079965952;
        this.modelIDs[70] = -526317824;
        this.modelIDs[71] = 2124482304;
        this.modelIDs[72] = -811530496;
        this.modelIDs[73] = -845084928;
        this.modelIDs[74] = -912193792;
        this.modelIDs[75] = -576649472;
        this.modelIDs[76] = -643758336;
        this.modelIDs[77] = -341768448;
        this.modelIDs[78] = -1532950784;
        this.modelIDs[79] = -996079872;
        this.modelIDs[80] = -1314846976;
        this.modelIDs[81] = -492763392;
        this.modelIDs[82] = -1432287488;
        this.modelIDs[83] = -610203904;
    }
}

