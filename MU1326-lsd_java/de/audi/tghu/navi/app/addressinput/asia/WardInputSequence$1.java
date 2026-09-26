/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.asia;

import de.audi.tghu.navi.app.addressinput.asia.WardInputSequence;
import de.audi.tghu.navi.app.addressinput.asia.WardInputSequence$1$1;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class WardInputSequence$1
extends NavCommand {
    private final /* synthetic */ WardInputSequence this$0;

    WardInputSequence$1(WardInputSequence wardInputSequence, String string) {
        this.this$0 = wardInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (Util.isEmpty(Util.getLocationAccessor(navLocation).getWard())) {
            this.getCommandList().commandFinishedWithPostCommand(new WardInputSequence$1$1(this, WardInputSequence.access$000(this.this$0)));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

