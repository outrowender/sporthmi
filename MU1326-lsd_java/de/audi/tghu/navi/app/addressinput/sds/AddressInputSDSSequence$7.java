/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.WardInputSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class AddressInputSDSSequence$7
extends NavCommand {
    private final /* synthetic */ String val$ward;
    private final /* synthetic */ IMatchspellerModelAccess val$wardModelAccess;
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ String val$wardId;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$7(AddressInputSDSSequence addressInputSDSSequence, String string, String string2, IMatchspellerModelAccess iMatchspellerModelAccess, NaviServiceListener naviServiceListener, String string3) {
        this.this$0 = addressInputSDSSequence;
        this.val$ward = string2;
        this.val$wardModelAccess = iMatchspellerModelAccess;
        this.val$naviServiceListener = naviServiceListener;
        this.val$wardId = string3;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(152) && this.dsiResponseContainer.refinementCriterionAvailable(152) && !Util.isEmpty(this.val$ward)) {
            WardInputSequence wardInputSequence = new WardInputSequence(this.val$wardModelAccess, this.this$0.spellerStack, this.this$0.commandListFactory, this.this$0.addressInputService, this.this$0.previewMap, this.val$naviServiceListener);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getSetInputCommandList(wardInputSequence, this.val$ward, this.val$wardId, false));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

