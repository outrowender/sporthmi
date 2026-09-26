/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputSDSSequence$32
extends NavCommand {
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$32(AddressInputSDSSequence addressInputSDSSequence, String string) {
        this.this$0 = addressInputSDSSequence;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        long l = this.dsiResponseContainer.getLispValueListCount();
        String[] stringArray = null;
        if (Util.isListValid(lIValueList)) {
            LIValueListElement[] lIValueListElementArray = lIValueList.getList();
            stringArray = new String[lIValueListElementArray.length];
            for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                stringArray[i2] = lIValueListElementArray[i2].getData();
            }
        }
        this.getCommandList().put("VDE_LIST_GET", stringArray);
        this.getCommandList().put("VDE_LIST_LENGTH_GET", new Long(l));
        this.getCommandList().commandFinished();
    }
}

