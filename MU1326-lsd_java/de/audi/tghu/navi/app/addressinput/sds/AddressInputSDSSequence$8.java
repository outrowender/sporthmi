/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.PlacenameInputSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputSDSSequence$8
extends NavCommand {
    private final /* synthetic */ String val$placeName;
    private final /* synthetic */ IMatchspellerModelAccess val$placeNameModelAccess;
    private final /* synthetic */ String val$placeNameId;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$8(AddressInputSDSSequence addressInputSDSSequence, String string, String string2, IMatchspellerModelAccess iMatchspellerModelAccess, String string3) {
        this.this$0 = addressInputSDSSequence;
        this.val$placeName = string2;
        this.val$placeNameModelAccess = iMatchspellerModelAccess;
        this.val$placeNameId = string3;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(147) && !Util.isEmpty(this.val$placeName)) {
            PlacenameInputSequence placenameInputSequence = new PlacenameInputSequence(this.val$placeNameModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.addressInputService, this.this$0.previewMap);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getSetInputCommandList(placenameInputSequence, this.val$placeName, this.val$placeNameId, false));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

