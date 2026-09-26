/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.AddressInputWizard;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class AddressInputWizard$1
extends NavCommand {
    private final /* synthetic */ int val$modelID;
    private final /* synthetic */ AddressInputWizard this$0;

    AddressInputWizard$1(AddressInputWizard addressInputWizard, String string, int n) {
        this.this$0 = addressInputWizard;
        this.val$modelID = n;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        Util.setGeoPosFlagOnLocation(navLocation, true);
        if (this.env.getChoiceModel(1579091456).getValue() == 1) {
            this.navigation.getAdbInterAppService().updateGivenTryBestMatchLocation(navLocation);
        } else if (this.env.getChoiceModel(1579091456).getValue() == 2) {
            AddressInputWizard.access$000(this.this$0).onCreateEditHomeAddress(navLocation);
        } else {
            AddressInputWizard.access$100(this.this$0).log(-1601830656, "AddressInputWizard#keyPressed( %1 ) - unknown context: %2", (long)this.val$modelID, (long)this.env.getChoiceModel(1579091456).getValue());
        }
        this.getCommandList().commandFinished();
    }
}

