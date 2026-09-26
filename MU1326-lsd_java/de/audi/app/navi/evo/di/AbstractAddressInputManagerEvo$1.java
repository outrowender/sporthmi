/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputManagerEvo$1
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManagerEvo this$0;

    AbstractAddressInputManagerEvo$1(AbstractAddressInputManagerEvo abstractAddressInputManagerEvo, String string) {
        this.this$0 = abstractAddressInputManagerEvo;
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
            this.getCommandList().commandFinishedWithPostCommand(new CmdNaviPreviewMapUpdate(AbstractAddressInputManagerEvo.access$000(this.this$0), bl, 1, null, null));
        } else {
            AbstractAddressInputManagerEvo.access$100(this.this$0).hidePreviewMap();
            this.getCommandList().commandFinished();
        }
    }
}

