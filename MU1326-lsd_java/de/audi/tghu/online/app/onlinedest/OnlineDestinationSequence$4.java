/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;

class OnlineDestinationSequence$4
extends AbstractOnlineDestinationCommand {
    private final /* synthetic */ long[] val$imported;
    private final /* synthetic */ OnlineDestinationSequence this$0;

    OnlineDestinationSequence$4(OnlineDestinationSequence onlineDestinationSequence, long[] lArray) {
        this.this$0 = onlineDestinationSequence;
        this.val$imported = lArray;
    }

    @Override
    public void execute() {
        this.getDSI().setADBImportStatus(this.val$imported, 3002);
        this.getCommandList().commandFinished();
    }
}

