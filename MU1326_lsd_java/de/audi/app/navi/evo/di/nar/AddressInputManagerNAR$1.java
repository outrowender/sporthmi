/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar;

import de.audi.app.navi.evo.di.nar.AddressInputManagerNAR;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class AddressInputManagerNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputManagerNAR this$0;

    AddressInputManagerNAR$1(AddressInputManagerNAR addressInputManagerNAR, String string) {
        this.this$0 = addressInputManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (!Util.isEmpty(navLocation.town)) {
            boolean bl = true;
            if (!Util.isEmpty(navLocation.street)) {
                bl = false;
            }
            this.getCommandList().commandFinishedWithPostCommand(new CmdNaviPreviewMapUpdate(AddressInputManagerNAR.access$000(this.this$0), bl, 1, null, null));
        } else {
            AddressInputManagerNAR.access$100(this.this$0).hidePreviewMap();
            this.getCommandList().commandFinished();
        }
    }
}

