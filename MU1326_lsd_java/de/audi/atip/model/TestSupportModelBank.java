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
    @Override
    protected synchronized void createModel(int n) {
        if (this.models[n] == null) {
            switch (n) {
                case 4: {
                    this.models[4] = new ChoiceModel(77538304);
                    break;
                }
                case 2: {
                    this.models[2] = new ListModel(43983872);
                    break;
                }
                case 0: {
                    this.models[0] = new ListModel(10429440);
                    break;
                }
                case 9: {
                    this.models[9] = new LabelModel(161424384);
                    break;
                }
                case 3: {
                    this.models[3] = new ChoiceModel(60761088);
                    break;
                }
                case 6: {
                    this.models[6] = new BaseListModel(111092736, null);
                    break;
                }
                case 5: {
                    this.models[5] = new BaseListModel(94315520, null);
                    break;
                }
                case 8: {
                    this.models[8] = new BaseListModel(144647168, null);
                    break;
                }
                case 1: {
                    this.models[1] = new LabelModel(27206656);
                    break;
                }
                case 7: {
                    this.models[7] = new BaseListModel(127869952, null);
                    break;
                }
                default: {
                    TestSupportModelBank.getModelLogChannel().log(10000, "[TestSupportModelBank#createModel()] model with ID %1 not found", (long)(this.moduleID * -1601830656 + n));
                }
            }
        }
    }

    @Override
    public int[] getAllModelIds() {
        return this.modelIDs;
    }

    public TestSupportModelBank() {
        super(24, 10, 10);
        this.modelIDs = new int[10];
        this.modelIDs[0] = 77538304;
        this.modelIDs[1] = 43983872;
        this.modelIDs[2] = 10429440;
        this.modelIDs[3] = 161424384;
        this.modelIDs[4] = 60761088;
        this.modelIDs[5] = 111092736;
        this.modelIDs[6] = 94315520;
        this.modelIDs[7] = 144647168;
        this.modelIDs[8] = 27206656;
        this.modelIDs[9] = 127869952;
    }
}

