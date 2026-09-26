/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;

class AddressInputSDSFormKR$1
extends NavCommand {
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ AddressInputSDSFormKR this$0;

    AddressInputSDSFormKR$1(AddressInputSDSFormKR addressInputSDSFormKR, String string, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSFormKR;
        this.val$naviServiceListener = naviServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (Util.isListValid(lIValueList) && lIValueList.getList().length > 0) {
            this.val$naviServiceListener.responseStartDestinationInput((byte)0);
        } else {
            this.val$naviServiceListener.responseStartDestinationInput((byte)3);
        }
        this.getCommandList().commandFinished();
    }
}

