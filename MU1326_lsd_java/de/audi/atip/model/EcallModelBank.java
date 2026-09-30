/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.model.ICoreEcallModelBank;
import de.audi.atip.model.IEvoEcallModelBank;

public class EcallModelBank
extends AbstractModelBank
implements ICoreEcallModelBank,
IEvoEcallModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 14: {
                    this.models[14] = new LabelModel(3300014);
                    break;
                }
                case 16: {
                    this.models[16] = new LabelModel(3300016);
                    break;
                }
                case 2: {
                    this.models[2] = new ButtonModel(3300002);
                    break;
                }
                case 17: {
                    this.models[17] = new LabelModel(3300017);
                    break;
                }
                case 8: {
                    this.models[8] = new ButtonModel(3300008);
                    break;
                }
                case 18: {
                    this.models[18] = new ButtonModel(3300018);
                    break;
                }
                case 19: {
                    this.models[19] = new LabelModel(3300019);
                    break;
                }
                case 5: {
                    this.models[5] = new LabelModel(3300005);
                    break;
                }
                case 27: {
                    this.models[27] = new ChoiceModel(3300027);
                    break;
                }
                case 26: {
                    this.models[26] = new ChoiceModel(3300026);
                    break;
                }
                case 0: {
                    this.models[0] = new ButtonModel(3300000);
                    break;
                }
                case 6: {
                    this.models[6] = new ChoiceModel(3300006);
                    break;
                }
                case 7: {
                    this.models[7] = new ButtonModel(3300007);
                    break;
                }
                case 15: {
                    this.models[15] = new ChoiceModel(3300015);
                    break;
                }
                case 4: {
                    this.models[4] = new ButtonModel(3300004);
                    break;
                }
                case 10: {
                    this.models[10] = new ButtonModel(3300010);
                    break;
                }
                case 9: {
                    this.models[9] = new ButtonModel(3300009);
                    break;
                }
                case 13: {
                    this.models[13] = new LabelModel(3300013);
                    break;
                }
                case 11: {
                    this.models[11] = new ButtonModel(3300011);
                    break;
                }
                case 24: {
                    this.models[24] = new ButtonModel(3300024);
                    break;
                }
                case 23: {
                    this.models[23] = new ButtonModel(3300023);
                    break;
                }
                case 1: {
                    this.models[1] = new ButtonModel(3300001);
                    break;
                }
                case 25: {
                    this.models[25] = new ChoiceModel(3300025);
                    break;
                }
                case 20: {
                    this.models[20] = new ButtonModel(3300020);
                    break;
                }
                case 12: {
                    this.models[12] = new ButtonModel(3300012);
                    break;
                }
                case 3: {
                    this.models[3] = new ButtonModel(3300003);
                    break;
                }
                default: {
                    EcallModelBank.getModelLogChannel().log(10000, "[EcallModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public EcallModelBank() {
        super(33, 28, 26);
        this.modelIDs = new int[26];
        this.modelIDs[0] = 3300014;
        this.modelIDs[1] = 3300016;
        this.modelIDs[2] = 3300002;
        this.modelIDs[3] = 3300017;
        this.modelIDs[4] = 3300008;
        this.modelIDs[5] = 3300018;
        this.modelIDs[6] = 3300019;
        this.modelIDs[7] = 3300005;
        this.modelIDs[8] = 3300027;
        this.modelIDs[9] = 3300026;
        this.modelIDs[10] = 3300000;
        this.modelIDs[11] = 3300006;
        this.modelIDs[12] = 3300007;
        this.modelIDs[13] = 3300015;
        this.modelIDs[14] = 3300004;
        this.modelIDs[15] = 3300010;
        this.modelIDs[16] = 3300009;
        this.modelIDs[17] = 3300013;
        this.modelIDs[18] = 3300011;
        this.modelIDs[19] = 3300024;
        this.modelIDs[20] = 3300023;
        this.modelIDs[21] = 3300001;
        this.modelIDs[22] = 3300025;
        this.modelIDs[23] = 3300020;
        this.modelIDs[24] = 3300012;
        this.modelIDs[25] = 3300003;
    }
}

