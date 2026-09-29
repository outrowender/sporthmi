/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.JobSetVideoScale;

class FilePlayerContent$SessionPlayer$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$x;
    private final /* synthetic */ int val$y;
    private final /* synthetic */ int val$width;
    private final /* synthetic */ int val$height;
    private final /* synthetic */ FilePlayerContent$SessionPlayer this$1;

    FilePlayerContent$SessionPlayer$4(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, String string, int n, int n2, int n3, int n4) {
        this.this$1 = filePlayerContent$SessionPlayer;
        this.val$x = n;
        this.val$y = n2;
        this.val$width = n3;
        this.val$height = n4;
        super(string);
    }

    @Override
    public void run() {
        if (!FilePlayerContent$SessionPlayer.access$1000(this.this$1).equals(FilePlayerContent.access$100(FilePlayerContent$SessionPlayer.access$900(this.this$1)).getActiveSession())) {
            FilePlayerContent.access$2500(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main().log(1078071040, "[%1.setVideoScaling] [%2] Session not active any more.", (Object)"FilePlayerContent", (Object)FilePlayerContent$SessionPlayer.access$1000(this.this$1));
            return;
        }
        FilePlayerContent.access$1600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).enqueue(new JobSetVideoScale(FilePlayerContent.access$2600(FilePlayerContent$SessionPlayer.access$900(this.this$1)).main(), FilePlayerContent$SessionPlayer.access$1500(this.this$1), this.val$x, this.val$y, this.val$width, this.val$height));
    }
}

