/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequenceSdsJpKr;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputSDSSequence$16
extends NavCommand {
    private final /* synthetic */ String val$houseNumber;
    private final /* synthetic */ IMatchspellerModelAccess val$houseNumberModelAccess;
    private final /* synthetic */ String val$houseNumberId;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$16(AddressInputSDSSequence addressInputSDSSequence, String string, String string2, IMatchspellerModelAccess iMatchspellerModelAccess, String string3) {
        this.this$0 = addressInputSDSSequence;
        this.val$houseNumber = string2;
        this.val$houseNumberModelAccess = iMatchspellerModelAccess;
        this.val$houseNumberId = string3;
        super(string);
    }

    @Override
    public void execute() {
        if (!Util.isEmpty(this.val$houseNumber)) {
            HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence = null;
            if (this.dsiResponseContainer.selectionCriterionAvailable(154)) {
                housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequenceSdsJpKr(this.val$houseNumberModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.previewMap, this.this$0.addressInputService);
            } else if (this.dsiResponseContainer.selectionCriterionAvailable(5)) {
                housenumberMatchspellerInputSimpleSequence = new HousenumberMatchspellerInputSimpleSequence(this.val$houseNumberModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.previewMap, this.this$0.addressInputService);
            }
            if (housenumberMatchspellerInputSimpleSequence != null) {
                this.getCommandList().commandFinishedWithPostSequence(this.this$0.getSetInputCommandList(housenumberMatchspellerInputSimpleSequence, this.val$houseNumber, this.val$houseNumberId, false));
            } else {
                this.getCommandList().commandFinished();
            }
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

