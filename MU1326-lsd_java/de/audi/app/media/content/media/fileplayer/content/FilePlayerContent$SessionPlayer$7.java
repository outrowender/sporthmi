/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.JobSkip;

class FilePlayerContent$SessionPlayer$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pCount;
    private final /* synthetic */ FilePlayerContent$SessionPlayer this$1;

    FilePlayerContent$SessionPlayer$7(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, String string, int n) {
        this.this$1 = filePlayerContent$SessionPlayer;
        this.val$pCount = n;
        super(string);
    }

    @Override
    public void run() {
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).equals(FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).getActiveSession())) {
            FilePlayerContent.access$3600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSkip] [%2] Session not active any more.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            return;
        }
        if (FilePlayerContent$SessionPlayer.access$1000(this.this$1).getType() != 0) {
            FilePlayerContent.access$3700(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSkip] Only supported for boardbook.", (Object)"FilePlayerContent");
            return;
        }
        if (this.val$pCount >= 0) {
            FilePlayerContent.access$3800(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSkip] No forward skip allowed.", (Object)"FilePlayerContent");
            return;
        }
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).isOnPlayback()) {
            FilePlayerContent.access$3900(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onSkip] Not on playback.", (Object)"FilePlayerContent");
            return;
        }
        FilePlayerContent.access$1600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).enqueue(new JobSkip(FilePlayerContent.access$4000(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main(), FilePlayerContent$SessionPlayer.access$1500(this.this$1), FilePlayerContent$SessionPlayer.access$900(this.this$1).getTerminal().getAudioManager(), this.val$pCount));
    }
}

