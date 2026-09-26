/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.IOnlinePlayerController;
import de.audi.app.media.content.media.online.JobSessionOpen;
import de.audi.app.media.content.media.online.OnlinePlayerController;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;

class OnlinePlayerController$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IOnlinePlayerController val$controller;
    private final /* synthetic */ IMediaOnlinePlayerSession val$pSession;
    private final /* synthetic */ OnlinePlayerController this$0;

    OnlinePlayerController$2(OnlinePlayerController onlinePlayerController, String string, IOnlinePlayerController iOnlinePlayerController, IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        this.this$0 = onlinePlayerController;
        this.val$controller = iOnlinePlayerController;
        this.val$pSession = iMediaOnlinePlayerSession;
        super(string);
    }

    @Override
    public void run() {
        OnlinePlayerController.access$300(this.this$0).enqueue(new JobSessionOpen(OnlinePlayerController.access$000(this.this$0), this.val$controller, OnlinePlayerController.access$100(this.this$0), OnlinePlayerController.access$200(this.this$0), new OnlinePlayerSession(OnlinePlayerController.access$000(this.this$0), this.val$pSession)));
    }
}

