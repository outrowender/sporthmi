/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.VillageAndStreetInputSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputSDSSequence$15
extends NavCommand {
    private final /* synthetic */ String val$villageAndStreet;
    private final /* synthetic */ IMatchspellerModelAccess val$submunicipalTownModelAccess;
    private final /* synthetic */ String val$villageId;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$15(AddressInputSDSSequence addressInputSDSSequence, String string, String string2, IMatchspellerModelAccess iMatchspellerModelAccess, String string3) {
        this.this$0 = addressInputSDSSequence;
        this.val$villageAndStreet = string2;
        this.val$submunicipalTownModelAccess = iMatchspellerModelAccess;
        this.val$villageId = string3;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(151) && this.dsiResponseContainer.refinementCriterionAvailable(151) && !Util.isEmpty(this.val$villageAndStreet)) {
            VillageAndStreetInputSequence villageAndStreetInputSequence = new VillageAndStreetInputSequence(this.val$submunicipalTownModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.addressInputService, this.this$0.previewMap);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getSetInputCommandList(villageAndStreetInputSequence, this.val$villageAndStreet, this.val$villageId, false));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

