/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.IOnlinePlayerController;
import de.audi.app.media.content.media.online.JobSessionClose;
import de.audi.app.media.content.media.online.OnlinePlayerController;
import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;

class OnlinePlayerController$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IOnlinePlayerController val$controller;
    private final /* synthetic */ IMediaOnlinePlayerSession val$pSession;
    private final /* synthetic */ OnlinePlayerController this$0;

    OnlinePlayerController$3(OnlinePlayerController onlinePlayerController, String string, IOnlinePlayerController iOnlinePlayerController, IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        this.this$0 = onlinePlayerController;
        this.val$controller = iOnlinePlayerController;
        this.val$pSession = iMediaOnlinePlayerSession;
        super(string);
    }

    @Override
    public void run() {
        OnlinePlayerController.access$300(this.this$0).enqueue(new JobSessionClose(OnlinePlayerController.access$000(this.this$0), this.val$controller, this.val$pSession));
    }
}

