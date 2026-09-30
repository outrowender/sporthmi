/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.model.ICoreTerminalModeModelBank;
import de.audi.atip.model.IEvoTerminalModeModelBank;

public class TerminalModeModelBank
extends AbstractModelBank
implements ICoreTerminalModeModelBank,
IEvoTerminalModeModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 63: {
                    this.models[63] = new ButtonModel(3200063);
                    break;
                }
                case 70: {
                    this.models[70] = new ChoiceModel(3200070);
                    break;
                }
                case 25: {
                    this.models[25] = new LabelModel(3200025);
                    break;
                }
                case 31: {
                    this.models[31] = new ButtonModel(3200031);
                    break;
                }
                case 32: {
                    this.models[32] = new ButtonModel(3200032);
                    break;
                }
                case 33: {
                    this.models[33] = new ChoiceModel(3200033);
                    break;
                }
                case 12: {
                    this.models[12] = new ChoiceModel(3200012);
                    break;
                }
                case 34: {
                    this.models[34] = new ChoiceModel(3200034);
                    break;
                }
                case 35: {
                    this.models[35] = new ChoiceModel(3200035);
                    break;
                }
                case 65: {
                    this.models[65] = new ButtonModel(3200065);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(3200044);
                    break;
                }
                case 51: {
                    this.models[51] = new ButtonModel(3200051);
                    break;
                }
                case 69: {
                    this.models[69] = new ButtonModel(3200069);
                    break;
                }
                case 26: {
                    this.models[26] = new RangeModel(3200026);
                    break;
                }
                case 36: {
                    this.models[36] = new ChoiceModel(3200036);
                    break;
                }
                case 68: {
                    this.models[68] = new ChoiceModel(3200068);
                    break;
                }
                case 27: {
                    this.models[27] = new LabelModel(3200027);
                    break;
                }
                case 28: {
                    this.models[28] = new LabelModel(3200028);
                    break;
                }
                case 62: {
                    this.models[62] = new ChoiceModel(3200062);
                    break;
                }
                case 37: {
                    this.models[37] = new VirtualButtonModel(3200037);
                    break;
                }
                case 38: {
                    this.models[38] = new VirtualButtonModel(3200038);
                    break;
                }
                case 50: {
                    this.models[50] = new ChoiceModel(3200050);
                    break;
                }
                case 47: {
                    this.models[47] = new ButtonModel(3200047);
                    break;
                }
                case 39: {
                    this.models[39] = new ButtonModel(3200039);
                    break;
                }
                case 43: {
                    this.models[43] = new ChoiceModel(3200043);
                    break;
                }
                case 64: {
                    this.models[64] = new ButtonModel(3200064);
                    break;
                }
                case 52: {
                    this.models[52] = new ButtonModel(3200052);
                    break;
                }
                case 49: {
                    this.models[49] = new ChoiceModel(3200049);
                    break;
                }
                case 46: {
                    this.models[46] = new ChoiceModel(3200046);
                    break;
                }
                case 40: {
                    this.models[40] = new ButtonModel(3200040);
                    break;
                }
                case 45: {
                    this.models[45] = new ChoiceModel(3200045);
                    break;
                }
                case 29: {
                    this.models[29] = new LabelModel(3200029);
                    break;
                }
                case 30: {
                    this.models[30] = new LabelModel(3200030);
                    break;
                }
                case 48: {
                    this.models[48] = new ButtonModel(3200048);
                    break;
                }
                case 41: {
                    this.models[41] = new ButtonModel(3200041);
                    break;
                }
                case 42: {
                    this.models[42] = new ButtonModel(3200042);
                    break;
                }
                default: {
                    TerminalModeModelBank.getModelLogChannel().log(10000, "[TerminalModeModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TerminalModeModelBank() {
        super(32, 71, 36);
        this.modelIDs = new int[36];
        this.modelIDs[0] = 3200063;
        this.modelIDs[1] = 3200070;
        this.modelIDs[2] = 3200025;
        this.modelIDs[3] = 3200031;
        this.modelIDs[4] = 3200032;
        this.modelIDs[5] = 3200033;
        this.modelIDs[6] = 3200012;
        this.modelIDs[7] = 3200034;
        this.modelIDs[8] = 3200035;
        this.modelIDs[9] = 3200065;
        this.modelIDs[10] = 3200044;
        this.modelIDs[11] = 3200051;
        this.modelIDs[12] = 3200069;
        this.modelIDs[13] = 3200026;
        this.modelIDs[14] = 3200036;
        this.modelIDs[15] = 3200068;
        this.modelIDs[16] = 3200027;
        this.modelIDs[17] = 3200028;
        this.modelIDs[18] = 3200062;
        this.modelIDs[19] = 3200037;
        this.modelIDs[20] = 3200038;
        this.modelIDs[21] = 3200050;
        this.modelIDs[22] = 3200047;
        this.modelIDs[23] = 3200039;
        this.modelIDs[24] = 3200043;
        this.modelIDs[25] = 3200064;
        this.modelIDs[26] = 3200052;
        this.modelIDs[27] = 3200049;
        this.modelIDs[28] = 3200046;
        this.modelIDs[29] = 3200040;
        this.modelIDs[30] = 3200045;
        this.modelIDs[31] = 3200029;
        this.modelIDs[32] = 3200030;
        this.modelIDs[33] = 3200048;
        this.modelIDs[34] = 3200041;
        this.modelIDs[35] = 3200042;
    }
}

