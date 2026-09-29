/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.content.media.fileplayer.AbstractPlayerSession;
import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;
import de.audi.atip.log.LogChannel;

public class OnlinePlayerSession
extends AbstractPlayerSession
implements IMediaOnlinePlayerSession {
    public OnlinePlayerSession(LogChannel logChannel, IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        super(logChannel, iMediaOnlinePlayerSession);
    }

    private IMediaOnlinePlayerSession getSession() {
        return (IMediaOnlinePlayerSession)this.clientSession;
    }

    @Override
    public String getServiceID() {
        return this.getSession().getServiceID();
    }

    @Override
    public void onClose() {
        super.onClose();
        this.updateBufferState(0, 0);
        this.responseDetailInfo("", "", "", "");
    }

    @Override
    public void updateBufferState(int n, int n2) {
        this.getSession().updateBufferState(n, n2);
    }

    @Override
    public void trackChanged(long l) {
        this.getSession().trackChanged(l);
    }

    @Override
    public void updateCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.getSession().updateCapabilities(bl, bl2, bl3, bl4, bl5, bl6);
    }

    @Override
    public void responseDetailInfo(String string, String string2, String string3, String string4) {
        this.getSession().responseDetailInfo(string, string2, string3, string4);
    }

    @Override
    public String getUrl() {
        return this.getSession().getUrl();
    }

    @Override
    public void updatePlaybackMode(boolean bl, boolean bl2) {
        this.getSession().updatePlaybackMode(bl, bl2);
    }

    @Override
    public void updateSkipCount(boolean bl, int n) {
        this.getSession().updateSkipCount(bl, n);
    }
}

