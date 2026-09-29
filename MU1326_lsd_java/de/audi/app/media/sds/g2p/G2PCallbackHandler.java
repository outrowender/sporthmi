/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds.g2p;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.sds.g2p.G2PCallbackHandler$1;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.interapp.media.MediaSDSEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

class G2PCallbackHandler {
    private static final String LOGCLASS;
    private final IServiceTracker sdsListenerTracker;
    private final Object mutex = new Object();
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private volatile IMediaSDSServiceListener sdsListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaSDSServiceListener;

    public G2PCallbackHandler(IMediaTerminal iMediaTerminal, LogChannel logChannel) {
        this.logger = logChannel;
        this.serviceManager = iMediaTerminal.getServiceManager();
        this.sdsListenerTracker = iMediaTerminal.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$media$IMediaSDSServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaSDSServiceListener = G2PCallbackHandler.class$("de.audi.atip.interapp.media.IMediaSDSServiceListener")) : class$de$audi$atip$interapp$media$IMediaSDSServiceListener, new G2PCallbackHandler$1(this));
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"G2PCallbackHandler");
        this.sdsListenerTracker.open();
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"G2PCallbackHandler");
        this.sdsListenerTracker.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void g2pStateChanged(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        Buffer buffer = new Buffer();
        buffer.append("state='").append(n).append("',titles='").append(bl3).append("',artists='").append(bl2).append("',albums='").append(bl).append("',videos='").append(bl5).append("',genres='").append(bl4).append("',playlist='").append(bl6).append("'");
        this.logger.log(1078071040, "[%1.g2pStateChanged] %2", (Object)"G2PCallbackHandler", (Object)buffer);
        Object object = this.mutex;
        synchronized (object) {
            IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
            if (iMediaSDSServiceListener == null) {
                this.logger.log(1078071040, "[%1.g2pStateChanged] No listener.", (Object)"G2PCallbackHandler");
                return;
            }
            iMediaSDSServiceListener.g2pStateChanged(n, bl, bl2, bl3, bl4, bl5, bl6);
        }
    }

    public void responseG2PArtistsOfGenre(byte by, long l, MediaSDSEntry[] mediaSDSEntryArray) {
        this.logger.log(1078071040, "[%1.g2pResponseArtistsOfGenre] '%2',genreID='%3'", (Object)"G2PCallbackHandler", (Object)new Byte(by), (Object)new Long(l));
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pResponseArtistsOfGenre] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.responseG2PArtistsOfGenre(by, l, mediaSDSEntryArray);
    }

    public void responseG2pAlbumsOfArtist(byte by, long l, long l2, MediaSDSEntry[] mediaSDSEntryArray) {
        this.logger.log(1078071040, "[%1.g2pResponseAlbumsOfArtist] '%2',genreID='%3', artistID='%4'", (Object)"G2PCallbackHandler", (Object)new Byte(by), (Object)new Long(l), (Object)new Long(l2));
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pResponseAlbumsOfArtist] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.responseG2pAlbumsOfArtist(by, l, l2, mediaSDSEntryArray);
    }

    public void responseG2PAlbumsOfArtist(byte by, long l, MediaSDSEntry[] mediaSDSEntryArray) {
        this.logger.log(1078071040, "[%1.g2pResponseAlbumsOfArtist] '%2', artistID='%3'", (Object)"G2PCallbackHandler", (long)by, l);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pResponseAlbumsOfArtist] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.responseG2PAlbumsOfArtist(by, l, mediaSDSEntryArray);
    }

    public void responseG2PRequestCoverarts(byte by, MediaCoverartEntry[] mediaCoverartEntryArray) {
        this.logger.log(1078071040, "[%1.responseG2PRequestCoverarts] success='%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.responseG2PRequestCoverarts] No listener.", (Object)"G2PCallbackHandler");
        } else {
            iMediaSDSServiceListener.g2pRequestCoverartsResult(by, mediaCoverartEntryArray);
        }
    }

    public void g2pPlayTitleResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayTitleResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayTitleResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayTitleResult(by);
    }

    public void g2pPlayAlbumResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayAlbumResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayAlbumResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayAlbumResult(by);
    }

    public void g2pPlayTitleOfAlbumResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayTitleOfAlbumResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayTitleOfAlbumResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayTitleOfAlbumResult(by);
    }

    public void g2pPlayTitleOfArtistResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayTitleOfArtistResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayTitleOfArtistResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayTitleOfArtistResult(by);
    }

    public void g2pPlayAlbumOfArtistResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayAlbumOfArtistResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayAlbumOfArtistResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayAlbumOfArtistResult(by);
    }

    public void playAllTracksResult(byte by) {
        this.logger.log(1078071040, "[%1.playAllTracksResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.playAllTracksResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.playAllTracksResult(by);
    }

    public void g2pPlayArtistResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayArtistResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayArtistResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayArtistResult(by);
    }

    public void g2pPlayGenreResult(byte by) {
        this.logger.log(1078071040, "[%1.g2pPlayGenreResult] '%2'", (Object)"G2PCallbackHandler", (long)by);
        IMediaSDSServiceListener iMediaSDSServiceListener = this.sdsListener;
        if (iMediaSDSServiceListener == null) {
            this.logger.log(1078071040, "[%1.g2pPlayGenreResult] No listener.", (Object)"G2PCallbackHandler");
            return;
        }
        iMediaSDSServiceListener.g2pPlayGenreResult(by);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(G2PCallbackHandler g2PCallbackHandler) {
        return g2PCallbackHandler.logger;
    }

    static /* synthetic */ IServiceManager access$100(G2PCallbackHandler g2PCallbackHandler) {
        return g2PCallbackHandler.serviceManager;
    }

    static /* synthetic */ IMediaSDSServiceListener access$202(G2PCallbackHandler g2PCallbackHandler, IMediaSDSServiceListener iMediaSDSServiceListener) {
        g2PCallbackHandler.sdsListener = iMediaSDSServiceListener;
        return g2PCallbackHandler.sdsListener;
    }

    static /* synthetic */ IMediaSDSServiceListener access$200(G2PCallbackHandler g2PCallbackHandler) {
        return g2PCallbackHandler.sdsListener;
    }
}

