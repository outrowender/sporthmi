/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;

class FilePlayerContent$SessionPlayer$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ FilePlayerContent$SessionPlayer this$1;

    FilePlayerContent$SessionPlayer$2(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, String string) {
        this.this$1 = filePlayerContent$SessionPlayer;
        super(string);
    }

    @Override
    public void run() {
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).equals(FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).getActiveSession())) {
            FilePlayerContent.access$1900(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onPause] [%2] Session not active any more.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            return;
        }
        FilePlayerContent.access$2000(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onPause] [%2] Mute audio.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
        FilePlayerContent$SessionPlayer.access$900(this.this$1).getTerminal().getAudioManager().mute();
    }
}

