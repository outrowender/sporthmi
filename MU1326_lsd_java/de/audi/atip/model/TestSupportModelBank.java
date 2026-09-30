/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.model;

import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.model.ICoreTestSupportModelBank;
import de.audi.atip.model.IEvoTestSupportModelBank;

public class TestSupportModelBank
extends AbstractModelBank
implements ICoreTestSupportModelBank,
IEvoTestSupportModelBank {
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 4: {
                    this.models[4] = new ChoiceModel(2400004);
                    break;
                }
                case 2: {
                    this.models[2] = new ListModel(2400002);
                    break;
                }
                case 0: {
                    this.models[0] = new ListModel(2400000);
                    break;
                }
                case 9: {
                    this.models[9] = new LabelModel(2400009);
                    break;
                }
                case 3: {
                    this.models[3] = new ChoiceModel(2400003);
                    break;
                }
                case 6: {
                    this.models[6] = new BaseListModel(2400006, null);
                    break;
                }
                case 5: {
                    this.models[5] = new BaseListModel(2400005, null);
                    break;
                }
                case 8: {
                    this.models[8] = new BaseListModel(2400008, null);
                    break;
                }
                case 1: {
                    this.models[1] = new LabelModel(2400001);
                    break;
                }
                case 7: {
                    this.models[7] = new BaseListModel(2400007, null);
                    break;
                }
                default: {
                    TestSupportModelBank.getModelLogChannel().log(10000, "[TestSupportModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * 100000 + n));
                }
            }
        }
    }

    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TestSupportModelBank() {
        super(24, 10, 10);
        this.modelIDs = new int[10];
        this.modelIDs[0] = 2400004;
        this.modelIDs[1] = 2400002;
        this.modelIDs[2] = 2400000;
        this.modelIDs[3] = 2400009;
        this.modelIDs[4] = 2400003;
        this.modelIDs[5] = 2400006;
        this.modelIDs[6] = 2400005;
        this.modelIDs[7] = 2400008;
        this.modelIDs[8] = 2400001;
        this.modelIDs[9] = 2400007;
    }
}

