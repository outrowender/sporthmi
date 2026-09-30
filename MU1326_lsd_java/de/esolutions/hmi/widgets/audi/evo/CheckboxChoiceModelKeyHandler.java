/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ChoiceModelKeyHandler;

public class CheckboxChoiceModelKeyHandler
extends ChoiceModelKeyHandler {
    private int[] modelValues;

    protected int getNewModelValue(AbstractWidgetController abstractWidgetController) {
        if (this.modelValues == null || this.modelValues.length < 2) {
            menuItemLogCh.log(10000, "CheckboxChoiceModelKeyHandler#getNewModelValue: no modelValues configured in handler. widget: %1", (Object)abstractWidgetController);
            return -1;
        }
        ChoiceModelGUI choiceModelGUI = this.getModel(abstractWidgetController);
        if (choiceModelGUI == null) {
            return -1;
        }
        int n = choiceModelGUI.getValue();
        if (n == this.modelValues[0]) {
            return this.modelValues[1];
        }
        return this.modelValues[0];
    }

    public int[] getModelValues() {
        return this.modelValues;
    }

    public void setModelValues(int[] nArray) {
        this.modelValues = nArray;
    }
}

