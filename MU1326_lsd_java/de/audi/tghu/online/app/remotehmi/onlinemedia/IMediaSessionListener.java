/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaSession;

public interface IMediaSessionListener {
    public void updatePlayPosition(int var1, int var2);

    public void processState(IOnlineMediaSession var1);

    public void close(OnlineMediaSession var1);

    public void processGenericEvent(String var1, IOnlineMediaSession var2, Object var3);

    public void processShuffleChanged(IOnlineMediaSession var1, boolean var2);

    public void processRepeatChanged(IOnlineMediaSession var1, boolean var2);

    public void setPlaytimeStrategy(IPlaytimeStrategy var1);

    public void processBufferChangedEvent(IOnlineMediaSession var1);

    public void processSkipEvent(IOnlineMediaSession var1);

    public void updateMetadata(String var1, String var2, String var3, String var4);
}

