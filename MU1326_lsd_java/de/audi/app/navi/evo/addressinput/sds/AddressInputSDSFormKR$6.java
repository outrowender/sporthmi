/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputSDSFormKR$6
extends NavCommand {
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ AddressInputSDSFormKR this$0;

    AddressInputSDSFormKR$6(AddressInputSDSFormKR addressInputSDSFormKR, String string, NaviServiceListener naviServiceListener) {
        this.this$0 = addressInputSDSFormKR;
        this.val$naviServiceListener = naviServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.val$naviServiceListener.responseSelectPOIbyListIndex((byte)0);
        } else {
            this.val$naviServiceListener.responseSelectPOIbyListIndex((byte)3);
        }
        this.getCommandList().commandFinished();
    }
}

