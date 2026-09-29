/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver$EmptyImplementation;
import de.audi.app.messaging.core.readout.MessageReader;
import de.audi.app.messaging.core.readout.MessageReader$1;

final class MessageReader$FolderNavigatorObserver
extends IFolderNavigatorObserver$EmptyImplementation {
    private final /* synthetic */ MessageReader this$0;

    private MessageReader$FolderNavigatorObserver(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void indicateFolderChange(boolean bl) {
        MessageReader.access$4100(this.this$0).log(-2137614336, "[MessageReader#indicateFolderChange] inProgress = %1", bl);
        if (!bl) {
            int n = MessageReader.access$4200(this.this$0).getFolderNavigator().getCurrentFolder().getHmiFolderType();
            MessageReader.access$4300(this.this$0, n == 4);
        }
    }

    /* synthetic */ MessageReader$FolderNavigatorObserver(MessageReader messageReader, MessageReader$1 messageReader$1) {
        this(messageReader);
    }
}

