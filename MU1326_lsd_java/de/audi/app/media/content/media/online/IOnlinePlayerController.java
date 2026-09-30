/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.content.media.online.OnlinePlayerSession;

public interface IOnlinePlayerController {
    public OnlinePlayerSession getActiveSession();

    public boolean isActiveSession(OnlinePlayerSession var1);

    public void addSessionToPendingList(OnlinePlayerSession var1);

    public void attachSession(OnlinePlayerSession var1);

    public void detachActiveSession();
}

