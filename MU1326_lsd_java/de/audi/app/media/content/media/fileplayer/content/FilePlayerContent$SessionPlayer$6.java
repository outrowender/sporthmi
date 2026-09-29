/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.JobSeek;

class FilePlayerContent$SessionPlayer$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$forward;
    private final /* synthetic */ FilePlayerContent$SessionPlayer this$1;

    FilePlayerContent$SessionPlayer$6(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, String string, boolean bl) {
        this.this$1 = filePlayerContent$SessionPlayer;
        this.val$forward = bl;
        super(string);
    }

    @Override
    public void run() {
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).equals(FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).getActiveSession())) {
            FilePlayerContent.access$3100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSeek] [%2] Session not active any more.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            return;
        }
        if (FilePlayerContent$SessionPlayer.access$1000(this.this$1).getType() != 0) {
            FilePlayerContent.access$3200(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSeek] Only supported for boardbook.", (Object)"FilePlayerContent");
            return;
        }
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).isOnPlayback()) {
            FilePlayerContent.access$3300(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSeek] Not on playback.", (Object)"FilePlayerContent");
            return;
        }
        FilePlayerContent.access$1600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).enqueue(new JobSeek(FilePlayerContent.access$3400(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main(), FilePlayerContent$SessionPlayer.access$1500(this.this$1), FilePlayerContent$SessionPlayer.access$900(this.this$1).getTerminal().getAudioManager(), this.val$forward));
    }
}

