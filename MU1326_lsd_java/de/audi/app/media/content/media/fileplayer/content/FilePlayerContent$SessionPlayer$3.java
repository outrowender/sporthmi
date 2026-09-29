/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.JobPlayURL;

class FilePlayerContent$SessionPlayer$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ String val$pUri;
    private final /* synthetic */ boolean val$pRepeat;
    private final /* synthetic */ FilePlayerContent$SessionPlayer this$1;

    FilePlayerContent$SessionPlayer$3(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, String string, String string2, boolean bl) {
        this.this$1 = filePlayerContent$SessionPlayer;
        this.val$pUri = string2;
        this.val$pRepeat = bl;
        super(string);
    }

    @Override
    public void run() {
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).equals(FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).getActiveSession())) {
            FilePlayerContent.access$2200(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.onPlay] [%2] Session not active any more.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            return;
        }
        FilePlayerContent.access$1600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).enqueue(new JobPlayURL(FilePlayerContent.access$2300(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main(), FilePlayerContent$SessionPlayer.access$1500(this.this$1), this.val$pUri, this.val$pRepeat));
    }
}

