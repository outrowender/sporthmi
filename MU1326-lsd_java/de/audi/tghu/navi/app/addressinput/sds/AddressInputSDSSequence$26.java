/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence$SpellingResult;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputSDSSequence$26
extends NavCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$26(AddressInputSDSSequence addressInputSDSSequence, String string) {
        this.this$0 = addressInputSDSSequence;
        super(string);
    }

    @Override
    public void execute() {
        String[] stringArray = null;
        AddressInputSDSSequence$SpellingResult[] addressInputSDSSequence$SpellingResultArray = null;
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (Util.isListValid(lIValueList) && lIValueList.getList().length > 0) {
            LIValueListElement[] lIValueListElementArray = lIValueList.getList();
            this.logger.log(-2137614336, "AddressInputSDSSequence#PrepareSDSResult#execute - try to convert %1 entries", (long)lIValueListElementArray.length);
            LISpellerData lISpellerData = this.dsiResponseContainer.getSpellerState();
            stringArray = new String[lIValueListElementArray.length];
            addressInputSDSSequence$SpellingResultArray = new AddressInputSDSSequence$SpellingResult[lIValueListElementArray.length];
            for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                stringArray[i2] = lIValueListElementArray[i2].getData();
                addressInputSDSSequence$SpellingResultArray[i2] = new AddressInputSDSSequence$SpellingResult(this.this$0, lIValueListElementArray[i2], lISpellerData);
            }
        }
        this.getCommandList().put("SPELLING_ENTRIES", stringArray);
        this.getCommandList().put("SPELLING_INDICES", addressInputSDSSequence$SpellingResultArray);
        this.getCommandList().commandFinished();
    }
}

