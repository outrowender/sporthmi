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
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 63: {
                    this.models[63] = new ButtonModel(1070870528);
                    break;
                }
                case 70: {
                    this.models[70] = new ChoiceModel(1188311040);
                    break;
                }
                case 25: {
                    this.models[25] = new LabelModel(433336320);
                    break;
                }
                case 31: {
                    this.models[31] = new ButtonModel(533999616);
                    break;
                }
                case 32: {
                    this.models[32] = new ButtonModel(550776832);
                    break;
                }
                case 33: {
                    this.models[33] = new ChoiceModel(567554048);
                    break;
                }
                case 12: {
                    this.models[12] = new ChoiceModel(215232512);
                    break;
                }
                case 34: {
                    this.models[34] = new ChoiceModel(584331264);
                    break;
                }
                case 35: {
                    this.models[35] = new ChoiceModel(601108480);
                    break;
                }
                case 65: {
                    this.models[65] = new ButtonModel(1104424960);
                    break;
                }
                case 44: {
                    this.models[44] = new ChoiceModel(752103424);
                    break;
                }
                case 51: {
                    this.models[51] = new ButtonModel(869543936);
                    break;
                }
                case 69: {
                    this.models[69] = new ButtonModel(1171533824);
                    break;
                }
                case 26: {
                    this.models[26] = new RangeModel(450113536);
                    break;
                }
                case 36: {
                    this.models[36] = new ChoiceModel(617885696);
                    break;
                }
                case 68: {
                    this.models[68] = new ChoiceModel(1154756608);
                    break;
                }
                case 27: {
                    this.models[27] = new LabelModel(466890752);
                    break;
                }
                case 28: {
                    this.models[28] = new LabelModel(483667968);
                    break;
                }
                case 62: {
                    this.models[62] = new ChoiceModel(1054093312);
                    break;
                }
                case 37: {
                    this.models[37] = new VirtualButtonModel(634662912);
                    break;
                }
                case 38: {
                    this.models[38] = new VirtualButtonModel(651440128);
                    break;
                }
                case 50: {
                    this.models[50] = new ChoiceModel(852766720);
                    break;
                }
                case 47: {
                    this.models[47] = new ButtonModel(802435072);
                    break;
                }
                case 39: {
                    this.models[39] = new ButtonModel(668217344);
                    break;
                }
                case 43: {
                    this.models[43] = new ChoiceModel(735326208);
                    break;
                }
                case 64: {
                    this.models[64] = new ButtonModel(1087647744);
                    break;
                }
                case 52: {
                    this.models[52] = new ButtonModel(886321152);
                    break;
                }
                case 49: {
                    this.models[49] = new ChoiceModel(835989504);
                    break;
                }
                case 46: {
                    this.models[46] = new ChoiceModel(785657856);
                    break;
                }
                case 40: {
                    this.models[40] = new ButtonModel(684994560);
                    break;
                }
                case 45: {
                    this.models[45] = new ChoiceModel(768880640);
                    break;
                }
                case 29: {
                    this.models[29] = new LabelModel(500445184);
                    break;
                }
                case 30: {
                    this.models[30] = new LabelModel(517222400);
                    break;
                }
                case 48: {
                    this.models[48] = new ButtonModel(819212288);
                    break;
                }
                case 41: {
                    this.models[41] = new ButtonModel(701771776);
                    break;
                }
                case 42: {
                    this.models[42] = new ButtonModel(718548992);
                    break;
                }
                default: {
                    TerminalModeModelBank.getModelLogChannel().log(10000, "[TerminalModeModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TerminalModeModelBank() {
        super(32, 71, 36);
        this.modelIDs = new int[36];
        this.modelIDs[0] = 1070870528;
        this.modelIDs[1] = 1188311040;
        this.modelIDs[2] = 433336320;
        this.modelIDs[3] = 533999616;
        this.modelIDs[4] = 550776832;
        this.modelIDs[5] = 567554048;
        this.modelIDs[6] = 215232512;
        this.modelIDs[7] = 584331264;
        this.modelIDs[8] = 601108480;
        this.modelIDs[9] = 1104424960;
        this.modelIDs[10] = 752103424;
        this.modelIDs[11] = 869543936;
        this.modelIDs[12] = 1171533824;
        this.modelIDs[13] = 450113536;
        this.modelIDs[14] = 617885696;
        this.modelIDs[15] = 1154756608;
        this.modelIDs[16] = 466890752;
        this.modelIDs[17] = 483667968;
        this.modelIDs[18] = 1054093312;
        this.modelIDs[19] = 634662912;
        this.modelIDs[20] = 651440128;
        this.modelIDs[21] = 852766720;
        this.modelIDs[22] = 802435072;
        this.modelIDs[23] = 668217344;
        this.modelIDs[24] = 735326208;
        this.modelIDs[25] = 1087647744;
        this.modelIDs[26] = 886321152;
        this.modelIDs[27] = 835989504;
        this.modelIDs[28] = 785657856;
        this.modelIDs[29] = 684994560;
        this.modelIDs[30] = 768880640;
        this.modelIDs[31] = 500445184;
        this.modelIDs[32] = 517222400;
        this.modelIDs[33] = 819212288;
        this.modelIDs[34] = 701771776;
        this.modelIDs[35] = 718548992;
    }
}

