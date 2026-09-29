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
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 14: {
                    this.models[14] = new LabelModel(-1369820672);
                    break;
                }
                case 16: {
                    this.models[16] = new LabelModel(-1336266240);
                    break;
                }
                case 2: {
                    this.models[2] = new ButtonModel(-1571147264);
                    break;
                }
                case 17: {
                    this.models[17] = new LabelModel(-1319489024);
                    break;
                }
                case 8: {
                    this.models[8] = new ButtonModel(-1470483968);
                    break;
                }
                case 18: {
                    this.models[18] = new ButtonModel(-1302711808);
                    break;
                }
                case 19: {
                    this.models[19] = new LabelModel(-1285934592);
                    break;
                }
                case 5: {
                    this.models[5] = new LabelModel(-1520815616);
                    break;
                }
                case 27: {
                    this.models[27] = new ChoiceModel(-1151716864);
                    break;
                }
                case 26: {
                    this.models[26] = new ChoiceModel(-1168494080);
                    break;
                }
                case 0: {
                    this.models[0] = new ButtonModel(-1604701696);
                    break;
                }
                case 6: {
                    this.models[6] = new ChoiceModel(-1504038400);
                    break;
                }
                case 7: {
                    this.models[7] = new ButtonModel(-1487261184);
                    break;
                }
                case 15: {
                    this.models[15] = new ChoiceModel(-1353043456);
                    break;
                }
                case 4: {
                    this.models[4] = new ButtonModel(-1537592832);
                    break;
                }
                case 10: {
                    this.models[10] = new ButtonModel(-1436929536);
                    break;
                }
                case 9: {
                    this.models[9] = new ButtonModel(-1453706752);
                    break;
                }
                case 13: {
                    this.models[13] = new LabelModel(-1386597888);
                    break;
                }
                case 11: {
                    this.models[11] = new ButtonModel(-1420152320);
                    break;
                }
                case 24: {
                    this.models[24] = new ButtonModel(-1202048512);
                    break;
                }
                case 23: {
                    this.models[23] = new ButtonModel(-1218825728);
                    break;
                }
                case 1: {
                    this.models[1] = new ButtonModel(-1587924480);
                    break;
                }
                case 25: {
                    this.models[25] = new ChoiceModel(-1185271296);
                    break;
                }
                case 20: {
                    this.models[20] = new ButtonModel(-1269157376);
                    break;
                }
                case 12: {
                    this.models[12] = new ButtonModel(-1403375104);
                    break;
                }
                case 3: {
                    this.models[3] = new ButtonModel(-1554370048);
                    break;
                }
                default: {
                    EcallModelBank.getModelLogChannel().log(10000, "[EcallModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public EcallModelBank() {
        super(33, 28, 26);
        this.modelIDs = new int[26];
        this.modelIDs[0] = -1369820672;
        this.modelIDs[1] = -1336266240;
        this.modelIDs[2] = -1571147264;
        this.modelIDs[3] = -1319489024;
        this.modelIDs[4] = -1470483968;
        this.modelIDs[5] = -1302711808;
        this.modelIDs[6] = -1285934592;
        this.modelIDs[7] = -1520815616;
        this.modelIDs[8] = -1151716864;
        this.modelIDs[9] = -1168494080;
        this.modelIDs[10] = -1604701696;
        this.modelIDs[11] = -1504038400;
        this.modelIDs[12] = -1487261184;
        this.modelIDs[13] = -1353043456;
        this.modelIDs[14] = -1537592832;
        this.modelIDs[15] = -1436929536;
        this.modelIDs[16] = -1453706752;
        this.modelIDs[17] = -1386597888;
        this.modelIDs[18] = -1420152320;
        this.modelIDs[19] = -1202048512;
        this.modelIDs[20] = -1218825728;
        this.modelIDs[21] = -1587924480;
        this.modelIDs[22] = -1185271296;
        this.modelIDs[23] = -1269157376;
        this.modelIDs[24] = -1403375104;
        this.modelIDs[25] = -1554370048;
    }
}

