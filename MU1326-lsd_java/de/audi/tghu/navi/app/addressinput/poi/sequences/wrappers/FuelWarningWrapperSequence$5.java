/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

class FuelWarningWrapperSequence$5
extends NavCommand {
    private final /* synthetic */ FuelWarningWrapperSequence this$0;

    FuelWarningWrapperSequence$5(FuelWarningWrapperSequence fuelWarningWrapperSequence, String string) {
        this.this$0 = fuelWarningWrapperSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.alongRouteModelAccess.onUpdateResultList(new LIValueList(), 0L, null, false);
        this.getCommandList().commandFinished();
    }
}

