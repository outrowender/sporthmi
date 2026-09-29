/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.TunerModels;

public class RadioBaseListModelListener
extends DefaultBaseListModelListener {
    private final TunerModels models;
    private final MenuModelApp menu;
    private final ChoiceModelApp onOff;

    public RadioBaseListModelListener(TunerModels tunerModels, int n) {
        this.models = tunerModels;
        this.menu = tunerModels.getMenuModel(n);
        this.onOff = tunerModels.getChoiceModel(180);
    }

    protected boolean isNewSelection(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        SelectedItem selectedItem = this.models.getBaseListModel(n).getSelected();
        if (selectedItem != null && selectedItem.getUniqueID() == evoListRow.getUniqueID()) {
            if (this.onOff.getValue() == 1) {
                this.menu.trigger(ModelTrigger.TOGGLE_NOW_PLAYING);
            }
            return false;
        }
        return true;
    }
}

