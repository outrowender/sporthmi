/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$1;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$10;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$2;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$3;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$4;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$5;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$6;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$7;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$8;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl$9;
import de.audi.atip.interapp.media.IMediaOnlineSessionPlayer;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class MediaOnlineSessionPlayerImpl
implements IMediaOnlineSessionPlayer {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final OnlinePlayerSession session;
    private final IOnlinePlayer player;

    public MediaOnlineSessionPlayerImpl(LogChannel logChannel, OnlinePlayerSession onlinePlayerSession, IOnlinePlayer iOnlinePlayer) {
        this.logger = logChannel;
        this.session = onlinePlayerSession;
        this.player = iOnlinePlayer;
    }

    @Override
    public void resume() {
        this.logger.log(1078071040, "[%1.resume] [%2]", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$1(this, "OnlinePlayer.resume"));
    }

    @Override
    public void pause() {
        this.logger.log(1078071040, "[%1.pause] [%2]", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$2(this, "OnlinePlayer.pause"));
    }

    @Override
    public void stop() {
        this.logger.log(1078071040, "[%1.stop] '%2'", (Object)"MediaOnlineSessionPlayerImpl");
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$3(this, "OnlinePlayer.stop"));
    }

    @Override
    public void seek(boolean bl) {
        this.logger.log(1078071040, "[%1.seek] [%2] '%3'", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session, (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$4(this, "OnlinePlayer.seek", bl));
    }

    @Override
    public void updatePlayingTrack(long l, String string, String string2, String string3, ResourceLocator resourceLocator) {
        if (this.logger.isDebug2()) {
            Buffer buffer = new Buffer();
            buffer.append("'").append(l).append("','").append(string).append("','").append(string2).append("','").append(string3).append("'");
            this.logger.log(14808325, "[%1.updatePlayingTrack] [%2] %3", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session, (Object)buffer);
        }
        if (string == null || string2 == null || string3 == null) {
            throw new IllegalArgumentException();
        }
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$5(this, "OnlinePlayer.updatePlayingTrack", l, string, string2, string3, resourceLocator));
    }

    @Override
    public void skip(int n) {
        this.logger.log(1078071040, "[%1.skip] [%2] '%3'", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session, (long)n);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$6(this, "OnlinePlayer.skip", n));
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("MediaOnlineSessionPlayerImpl").append("[").append(this.session).append("]@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void seekToTime(int n) {
        this.logger.log(1078071040, "[%1.seekToTime] [%2]", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$7(this, "OnlinePlayer.seekToTime", n));
    }

    @Override
    public void setRepeatTitle(boolean bl) {
        this.logger.log(1078071040, "[%1.setRepeatTitle] [%2]", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$8(this, "OnlinePlayer.setRepeatTitle", bl));
    }

    @Override
    public void setShuffle(boolean bl) {
        this.logger.log(1078071040, "[%1.setShuffle] [%2]", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$9(this, "OnlinePlayer.setShuffle", bl));
    }

    @Override
    public void updateOnlineCoverart(ResourceLocator resourceLocator) {
        this.logger.log(1078071040, "[%1.updateOnlineCoverart] [%2]", (Object)"MediaOnlineSessionPlayerImpl", (Object)this.session);
        this.player.getDispatcher().execute(new MediaOnlineSessionPlayerImpl$10(this, "OnlinePlayer.updateOnlineCoverart", resourceLocator));
    }

    static /* synthetic */ IOnlinePlayer access$000(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl) {
        return mediaOnlineSessionPlayerImpl.player;
    }

    static /* synthetic */ OnlinePlayerSession access$100(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl) {
        return mediaOnlineSessionPlayerImpl.session;
    }

    static /* synthetic */ LogChannel access$200(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl) {
        return mediaOnlineSessionPlayerImpl.logger;
    }
}

