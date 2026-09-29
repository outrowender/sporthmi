/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;

class OnlineDestinationSequence$5
extends AbstractOnlineDestinationCommand {
    private final /* synthetic */ long[] val$imported;
    private final /* synthetic */ OnlineDestinationSequence this$0;

    OnlineDestinationSequence$5(OnlineDestinationSequence onlineDestinationSequence, long[] lArray) {
        this.this$0 = onlineDestinationSequence;
        this.val$imported = lArray;
    }

    @Override
    public void execute() {
        this.getDSI().setADBImportStatus(this.val$imported, 3004);
        this.getCommandList().commandFinished();
    }
}

