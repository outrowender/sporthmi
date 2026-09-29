/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.ChomeInputSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputSDSSequence$9
extends NavCommand {
    private final /* synthetic */ String val$chome;
    private final /* synthetic */ IMatchspellerModelAccess val$placeNameModelAccess;
    private final /* synthetic */ String val$chomeId;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$9(AddressInputSDSSequence addressInputSDSSequence, String string, String string2, IMatchspellerModelAccess iMatchspellerModelAccess, String string3) {
        this.this$0 = addressInputSDSSequence;
        this.val$chome = string2;
        this.val$placeNameModelAccess = iMatchspellerModelAccess;
        this.val$chomeId = string3;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(144) && !Util.isEmpty(this.val$chome)) {
            ChomeInputSequence chomeInputSequence = new ChomeInputSequence(this.val$placeNameModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.addressInputService, this.this$0.previewMap);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getSetInputCommandList(chomeInputSequence, this.val$chome, this.val$chomeId, false));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

