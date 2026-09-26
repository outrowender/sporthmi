/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class CityZipInputSimpleSequence$3
extends NavCommand {
    private final /* synthetic */ LIValueListElement val$element;
    private final /* synthetic */ CityZipInputSimpleSequence this$0;

    CityZipInputSimpleSequence$3(CityZipInputSimpleSequence cityZipInputSimpleSequence, LIValueListElement lIValueListElement) {
        this.this$0 = cityZipInputSimpleSequence;
        this.val$element = lIValueListElement;
    }

    @Override
    public void execute() {
        if (!this.val$element.isToRefine()) {
            this.getCommandList().commandFinishedWithPostCommand(new AddCityToHistoryCommand(this.this$0.cityHistory));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

