/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.JobResume;

class FilePlayerContent$SessionPlayer$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ FilePlayerContent$SessionPlayer this$1;

    FilePlayerContent$SessionPlayer$1(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, String string) {
        this.this$1 = filePlayerContent$SessionPlayer;
        super(string);
    }

    @Override
    public void run() {
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).equals(FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).getActiveSession())) {
            FilePlayerContent.access$1100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onResume] [%2] Session not active any more.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            return;
        }
        if (FilePlayerContent$SessionPlayer.access$900(this.this$1).getState().getAudioState().isAudible()) {
            FilePlayerContent.access$1200(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onResume] [%2] Already hearable.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            if (FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).isOnSeeking()) {
                FilePlayerContent.access$1300(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onResume] [%2] On seeking. Resume playback.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
                FilePlayerContent.access$1600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).enqueue(new JobResume(FilePlayerContent.access$1400(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main(), FilePlayerContent$SessionPlayer.access$1500(this.this$1)));
            }
        }
        FilePlayerContent.access$1700(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onResume] [%2] Try to resume audio.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
        FilePlayerContent$SessionPlayer.access$900(this.this$1).getTerminal().getAudioManager().resumeAudio(false);
    }
}

