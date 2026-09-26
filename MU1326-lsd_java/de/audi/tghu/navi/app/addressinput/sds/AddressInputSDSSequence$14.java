/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.SubmunicipalTownOrStreetInputSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputSDSSequence$14
extends NavCommand {
    private final /* synthetic */ String val$submunicipalTownOrStreet;
    private final /* synthetic */ IMatchspellerModelAccess val$submunicipalTownModelAccess;
    private final /* synthetic */ String val$submunicipalTownId;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$14(AddressInputSDSSequence addressInputSDSSequence, String string, String string2, IMatchspellerModelAccess iMatchspellerModelAccess, String string3) {
        this.this$0 = addressInputSDSSequence;
        this.val$submunicipalTownOrStreet = string2;
        this.val$submunicipalTownModelAccess = iMatchspellerModelAccess;
        this.val$submunicipalTownId = string3;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(150) && !Util.isEmpty(this.val$submunicipalTownOrStreet)) {
            SubmunicipalTownOrStreetInputSequence submunicipalTownOrStreetInputSequence = new SubmunicipalTownOrStreetInputSequence(this.val$submunicipalTownModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.addressInputService, this.this$0.previewMap);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getSetInputCommandList(submunicipalTownOrStreetInputSequence, this.val$submunicipalTownOrStreet, this.val$submunicipalTownId, false));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

