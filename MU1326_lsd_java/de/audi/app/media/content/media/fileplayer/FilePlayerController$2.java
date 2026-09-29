/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.fileplayer.FilePlayerController;
import de.audi.app.media.content.media.fileplayer.IFilePlayerController;
import de.audi.app.media.content.media.fileplayer.JobSessionOpen;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;

class FilePlayerController$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IFilePlayerController val$controller;
    private final /* synthetic */ IMediaFilePlayerSession val$pSession;
    private final /* synthetic */ FilePlayerController this$0;

    FilePlayerController$2(FilePlayerController filePlayerController, String string, IFilePlayerController iFilePlayerController, IMediaFilePlayerSession iMediaFilePlayerSession) {
        this.this$0 = filePlayerController;
        this.val$controller = iFilePlayerController;
        this.val$pSession = iMediaFilePlayerSession;
        super(string);
    }

    @Override
    public void run() {
        FilePlayerController.access$100(this.this$0).enqueue(new JobSessionOpen(FilePlayerController.access$000(this.this$0), this.val$controller, this.val$pSession));
    }
}

