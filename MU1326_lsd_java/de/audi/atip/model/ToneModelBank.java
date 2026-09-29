/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.RangeModel2D;
import de.audi.atip.hmi.model.TerminalModelContainer;
import de.audi.atip.model.ICoreToneModelBank;
import de.audi.atip.model.IEvoToneModelBank;

public class ToneModelBank
extends AbstractModelBank
implements ICoreToneModelBank,
IEvoToneModelBank {
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 88: {
                    this.models[88] = new ChoiceModel(-1740501248);
                    break;
                }
                case 16: {
                    this.models[16] = new ChoiceModel(1346506496);
                    break;
                }
                case 109: {
                    this.models[109] = new ChoiceModel(-1388179712);
                    break;
                }
                case 94: {
                    this.models[94] = new ChoiceModel(-1639837952);
                    break;
                }
                case 83: {
                    this.models[83] = new ChoiceModel(-1824387328);
                    break;
                }
                case 100: {
                    this.models[100] = new ChoiceModel(-1539174656);
                    break;
                }
                case 74: {
                    this.models[74] = new ChoiceModel(-1975382272);
                    break;
                }
                case 112: {
                    this.models[112] = new ButtonModel(-1337848064);
                    break;
                }
                case 72: {
                    this.models[72] = new ChoiceModel(-2008936704);
                    break;
                }
                case 92: {
                    this.models[92] = new ChoiceModel(-1673392384);
                    break;
                }
                case 68: {
                    this.models[68] = new ChoiceModel(-2076045568);
                    break;
                }
                case 102: {
                    this.models[102] = new ChoiceModel(-1505620224);
                    break;
                }
                case 77: {
                    this.models[77] = new ChoiceModel(-1925050624);
                    break;
                }
                case 111: {
                    this.models[111] = new ChoiceModel(-1354625280);
                    break;
                }
                case 99: {
                    this.models[99] = new ChoiceModel(-1555951872);
                    break;
                }
                case 23: {
                    this.models[23] = new RangeModel(1463947008);
                    break;
                }
                case 37: {
                    this.models[37] = new RangeModel2D(1698828032);
                    break;
                }
                case 71: {
                    this.models[71] = new ChoiceModel(-2025713920);
                    break;
                }
                case 39: {
                    this.models[39] = new TerminalModelContainer(1732382464, 5, false);
                    break;
                }
                case 75: {
                    this.models[75] = new ChoiceModel(-1958605056);
                    break;
                }
                case 57: {
                    this.models[57] = new ChoiceModel(2034372352);
                    break;
                }
                case 28: {
                    this.models[28] = new ChoiceModel(1547833088);
                    break;
                }
                case 96: {
                    this.models[96] = new ChoiceModel(-1606283520);
                    break;
                }
                case 76: {
                    this.models[76] = new ChoiceModel(-1941827840);
                    break;
                }
                case 19: {
                    this.models[19] = new ChoiceModel(1396838144);
                    break;
                }
                case 84: {
                    this.models[84] = new ChoiceModel(-1807610112);
                    break;
                }
                case 56: {
                    this.models[56] = new ChoiceModel(2017595136);
                    break;
                }
                case 64: {
                    this.models[64] = new ChoiceModel(-2143154432);
                    break;
                }
                case 45: {
                    this.models[45] = new RangeModel(1833045760);
                    break;
                }
                case 42: {
                    this.models[42] = new ChoiceModel(1782714112);
                    break;
                }
                case 27: {
                    this.models[27] = new RangeModel(1531055872);
                    break;
                }
                case 51: {
                    this.models[51] = new ChoiceModel(1933709056);
                    break;
                }
                case 26: {
                    this.models[26] = new RangeModel(1514278656);
                    break;
                }
                case 33: {
                    this.models[33] = new ButtonModel(1631719168);
                    break;
                }
                case 12: {
                    this.models[12] = new TerminalModelContainer(1279397632, 2, false);
                    break;
                }
                case 67: {
                    this.models[67] = new ChoiceModel(-2092822784);
                    break;
                }
                case 90: {
                    this.models[90] = new ChoiceModel(-1706946816);
                    break;
                }
                case 38: {
                    this.models[38] = new TerminalModelContainer(1715605248, 5, false);
                    break;
                }
                case 43: {
                    this.models[43] = new TerminalModelContainer(1799491328, 5, false);
                    break;
                }
                case 86: {
                    this.models[86] = new ChoiceModel(-1774055680);
                    break;
                }
                case 22: {
                    this.models[22] = new RangeModel(1447169792);
                    break;
                }
                case 87: {
                    this.models[87] = new ChoiceModel(-1757278464);
                    break;
                }
                case 80: {
                    this.models[80] = new ChoiceModel(-1874718976);
                    break;
                }
                case 14: {
                    this.models[14] = new ChoiceModel(1312952064);
                    break;
                }
                case 35: {
                    this.models[35] = new ChoiceModel(1665273600);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(1816268544);
                    break;
                }
                case 101: {
                    this.models[101] = new ChoiceModel(-1522397440);
                    break;
                }
                case 97: {
                    this.models[97] = new ChoiceModel(-1589506304);
                    break;
                }
                case 17: {
                    this.models[17] = new ChoiceModel(1363283712);
                    break;
                }
                case 103: {
                    this.models[103] = new RangeModel(-1488843008);
                    break;
                }
                case 82: {
                    this.models[82] = new ChoiceModel(-1841164544);
                    break;
                }
                case 104: {
                    this.models[104] = new ChoiceModel(-1472065792);
                    break;
                }
                case 151: {
                    this.models[151] = new ButtonModel(-683536640);
                    break;
                }
                case 41: {
                    this.models[41] = new ChoiceModel(1765936896);
                    break;
                }
                case 144: {
                    this.models[144] = new ChoiceModel(-800977152);
                    break;
                }
                case 91: {
                    this.models[91] = new ChoiceModel(-1690169600);
                    break;
                }
                case 55: {
                    this.models[55] = new ChoiceModel(2000817920);
                    break;
                }
                case 11: {
                    this.models[11] = new RangeModel(1262620416);
                    break;
                }
                case 89: {
                    this.models[89] = new ChoiceModel(-1723724032);
                    break;
                }
                case 85: {
                    this.models[85] = new ChoiceModel(-1790832896);
                    break;
                }
                case 49: {
                    this.models[49] = new ChoiceModel(1900154624);
                    break;
                }
                case 60: {
                    this.models[60] = new LabelModel(2084704000);
                    break;
                }
                case 116: {
                    this.models[116] = new ChoiceModel(-1270739200);
                    break;
                }
                case 65: {
                    this.models[65] = new ChoiceModel(-2126377216);
                    break;
                }
                case 32: {
                    this.models[32] = new ChoiceModel(1614941952);
                    break;
                }
                case 25: {
                    this.models[25] = new RangeModel(1497501440);
                    break;
                }
                case 24: {
                    this.models[24] = new RangeModel(1480724224);
                    break;
                }
                case 15: {
                    this.models[15] = new TerminalModelContainer(1329729280, 5, false);
                    break;
                }
                case 161: {
                    this.models[161] = new ChoiceModel(-515764480);
                    break;
                }
                case 142: {
                    this.models[142] = new ButtonModel(-834531584);
                    break;
                }
                case 69: {
                    this.models[69] = new ChoiceModel(-2059268352);
                    break;
                }
                case 73: {
                    this.models[73] = new ChoiceModel(-1992159488);
                    break;
                }
                case 93: {
                    this.models[93] = new ChoiceModel(-1656615168);
                    break;
                }
                case 110: {
                    this.models[110] = new RangeModel(-1371402496);
                    break;
                }
                case 61: {
                    this.models[61] = new ChoiceModel(2101481216);
                    break;
                }
                case 47: {
                    this.models[47] = new ChoiceModel(1866600192);
                    break;
                }
                case 105: {
                    this.models[105] = new ChoiceModel(-1455288576);
                    break;
                }
                case 152: {
                    this.models[152] = new ChoiceModel(-666759424);
                    break;
                }
                case 128: {
                    this.models[128] = new RangeModel(-1069412608);
                    break;
                }
                case 98: {
                    this.models[98] = new ChoiceModel(-1572729088);
                    break;
                }
                case 95: {
                    this.models[95] = new ChoiceModel(-1623060736);
                    break;
                }
                case 66: {
                    this.models[66] = new ChoiceModel(-2109600000);
                    break;
                }
                case 40: {
                    this.models[40] = new TerminalModelContainer(1749159680, 5, false);
                    break;
                }
                case 36: {
                    this.models[36] = new TerminalModelContainer(1682050816, 5, false);
                    break;
                }
                case 18: {
                    this.models[18] = new TerminalModelContainer(1380060928, 5, false);
                    break;
                }
                case 106: {
                    this.models[106] = new ChoiceModel(-1438511360);
                    break;
                }
                case 21: {
                    this.models[21] = new RangeModel(1430392576);
                    break;
                }
                case 63: {
                    this.models[63] = new ChoiceModel(2135035648);
                    break;
                }
                case 13: {
                    this.models[13] = new ChoiceModel(1296174848);
                    break;
                }
                case 59: {
                    this.models[59] = new LabelModel(2067926784);
                    break;
                }
                case 79: {
                    this.models[79] = new ChoiceModel(-1891496192);
                    break;
                }
                case 48: {
                    this.models[48] = new ChoiceModel(1883377408);
                    break;
                }
                case 46: {
                    this.models[46] = new ChoiceModel(1849822976);
                    break;
                }
                default: {
                    ToneModelBank.getModelLogChannel().log(10000, "[ToneModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public ToneModelBank() {
        super(10, 162, 93);
        this.modelIDs = new int[93];
        this.modelIDs[0] = -1740501248;
        this.modelIDs[1] = 1346506496;
        this.modelIDs[2] = -1388179712;
        this.modelIDs[3] = -1639837952;
        this.modelIDs[4] = -1824387328;
        this.modelIDs[5] = -1539174656;
        this.modelIDs[6] = -1975382272;
        this.modelIDs[7] = -1337848064;
        this.modelIDs[8] = -2008936704;
        this.modelIDs[9] = -1673392384;
        this.modelIDs[10] = -2076045568;
        this.modelIDs[11] = -1505620224;
        this.modelIDs[12] = -1925050624;
        this.modelIDs[13] = -1354625280;
        this.modelIDs[14] = -1555951872;
        this.modelIDs[15] = 1463947008;
        this.modelIDs[16] = 1698828032;
        this.modelIDs[17] = -2025713920;
        this.modelIDs[18] = 1732382464;
        this.modelIDs[19] = -1958605056;
        this.modelIDs[20] = 2034372352;
        this.modelIDs[21] = 1547833088;
        this.modelIDs[22] = -1606283520;
        this.modelIDs[23] = -1941827840;
        this.modelIDs[24] = 1396838144;
        this.modelIDs[25] = -1807610112;
        this.modelIDs[26] = 2017595136;
        this.modelIDs[27] = -2143154432;
        this.modelIDs[28] = 1833045760;
        this.modelIDs[29] = 1782714112;
        this.modelIDs[30] = 1531055872;
        this.modelIDs[31] = 1933709056;
        this.modelIDs[32] = 1514278656;
        this.modelIDs[33] = 1631719168;
        this.modelIDs[34] = 1279397632;
        this.modelIDs[35] = -2092822784;
        this.modelIDs[36] = -1706946816;
        this.modelIDs[37] = 1715605248;
        this.modelIDs[38] = 1799491328;
        this.modelIDs[39] = -1774055680;
        this.modelIDs[40] = 1447169792;
        this.modelIDs[41] = -1757278464;
        this.modelIDs[42] = -1874718976;
        this.modelIDs[43] = 1312952064;
        this.modelIDs[44] = 1665273600;
        this.modelIDs[45] = 1816268544;
        this.modelIDs[46] = -1522397440;
        this.modelIDs[47] = -1589506304;
        this.modelIDs[48] = 1363283712;
        this.modelIDs[49] = -1488843008;
        this.modelIDs[50] = -1841164544;
        this.modelIDs[51] = -1472065792;
        this.modelIDs[52] = -683536640;
        this.modelIDs[53] = 1765936896;
        this.modelIDs[54] = -800977152;
        this.modelIDs[55] = -1690169600;
        this.modelIDs[56] = 2000817920;
        this.modelIDs[57] = 1262620416;
        this.modelIDs[58] = -1723724032;
        this.modelIDs[59] = -1790832896;
        this.modelIDs[60] = 1900154624;
        this.modelIDs[61] = 2084704000;
        this.modelIDs[62] = -1270739200;
        this.modelIDs[63] = -2126377216;
        this.modelIDs[64] = 1614941952;
        this.modelIDs[65] = 1497501440;
        this.modelIDs[66] = 1480724224;
        this.modelIDs[67] = 1329729280;
        this.modelIDs[68] = -515764480;
        this.modelIDs[69] = -834531584;
        this.modelIDs[70] = -2059268352;
        this.modelIDs[71] = -1992159488;
        this.modelIDs[72] = -1656615168;
        this.modelIDs[73] = -1371402496;
        this.modelIDs[74] = 2101481216;
        this.modelIDs[75] = 1866600192;
        this.modelIDs[76] = -1455288576;
        this.modelIDs[77] = -666759424;
        this.modelIDs[78] = -1069412608;
        this.modelIDs[79] = -1572729088;
        this.modelIDs[80] = -1623060736;
        this.modelIDs[81] = -2109600000;
        this.modelIDs[82] = 1749159680;
        this.modelIDs[83] = 1682050816;
        this.modelIDs[84] = 1380060928;
        this.modelIDs[85] = -1438511360;
        this.modelIDs[86] = 1430392576;
        this.modelIDs[87] = 2135035648;
        this.modelIDs[88] = 1296174848;
        this.modelIDs[89] = 2067926784;
        this.modelIDs[90] = -1891496192;
        this.modelIDs[91] = 1883377408;
        this.modelIDs[92] = 1849822976;
    }
}

