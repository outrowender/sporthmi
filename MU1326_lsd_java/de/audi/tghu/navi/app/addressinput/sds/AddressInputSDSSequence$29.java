/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$SpellingResult;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputSDSSequence$29
extends NavCommand {
    private final /* synthetic */ AddressInputSDSSequence$SpellingResult val$result;
    private final /* synthetic */ IMatchspellerInputSequenceExt val$sequence;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$29(AddressInputSDSSequence addressInputSDSSequence, String string, AddressInputSDSSequence$SpellingResult addressInputSDSSequence$SpellingResult, IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt) {
        this.this$0 = addressInputSDSSequence;
        this.val$result = addressInputSDSSequence$SpellingResult;
        this.val$sequence = iMatchspellerInputSequenceExt;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "AddressInputSDSSequence#SelectEntryFromList#execute()");
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        LIValueListElement lIValueListElement = this.val$result.getElement();
        int n = Util.getLIValueListElement(this.logger, lIValueList, lIValueListElement.getListIndex());
        if (n >= 0) {
            LIValueListElement lIValueListElement2 = lIValueList.getList()[n];
            this.logger.log(-2137614336, "SelectEntryFromList#execute() - found element at index %2: %1", (Object)lIValueListElement2, (long)n);
            this.getCommandList().commandFinishedWithPostSequence(this.val$sequence.getSelectListElementCommandList(lIValueListElement2, true));
        } else {
            this.logger.log(10000, "SelectEntryFromList#execute() - could not find selected entry in list!");
            this.getCommandList().commandAborted("selected entry not found");
        }
    }
}

