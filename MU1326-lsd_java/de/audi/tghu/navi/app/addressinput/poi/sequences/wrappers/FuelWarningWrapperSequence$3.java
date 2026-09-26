/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class FuelWarningWrapperSequence$3
extends NavCommand {
    private final /* synthetic */ FuelWarningWrapperSequence this$0;

    FuelWarningWrapperSequence$3(FuelWarningWrapperSequence fuelWarningWrapperSequence, String string) {
        this.this$0 = fuelWarningWrapperSequence;
        super(string);
    }

    @Override
    public void execute() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(4498);
        if (choiceModelApp.getValue() == 0) {
            choiceModelApp.setValue(1);
        } else {
            choiceModelApp.setValue(0);
        }
        this.getCommandList().commandFinished();
    }
}

