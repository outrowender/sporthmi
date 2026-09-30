/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.dsi.media.NullMediaPlayerListener;
import de.audi.app.media.dsi.media.PlayViewExceptionController;
import de.audi.app.media.dsi.media.requests.MediaDSIPlayerRequestCoverArtUrlHandler;
import de.audi.app.media.dsi.media.requests.MediaDSIPlayerRequestDetailInfoHandler;
import de.audi.app.media.dsi.media.requests.MediaDSIPlayerRequestListHandler;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceActivationCallbackHandler;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.NullSourceActivationCallbackHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaPlayer;

public class MediaDSIPlayerControllerImpl
extends AbstractDSIController
implements IMediaDSIPlayerController {
    private static final String LOGCLASS = "MediaDSIPlayerControllerImpl";
    private final MediaDSIPlayerListener dsiListener;
    private final MediaDSIPlayerRequestDetailInfoHandler requestDetailInfoHandler;
    private final MediaDSIPlayerRequestCoverArtUrlHandler requestCoverURLHandler;
    private final MediaDSIPlayerRequestListHandler requestPlayViewListHandler;
    private final ISourceResolver sourceResolver;
    private final Object addingServiceMutex = new Object();
    private volatile DSIMediaPlayer dsiMediaPlayer = null;
    private volatile IMediaPlayerListener mediaPlayerListener;
    private volatile ISourceActivationCallbackHandler sourceActivationListener;
    private long lastDeviceIdForActivation = 0L;
    private long pendingDeviceId = 0L;
    private long pendingMediaId = 0L;
    private boolean isPlayerDeactivated = true;
    private final Object deviceLock = new Object();
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayerListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayer;

    public MediaDSIPlayerControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, ISourceResolver iSourceResolver, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, true, logChannel);
        if (iSourceResolver == null) {
            throw new IllegalArgumentException();
        }
        this.mediaPlayerListener = new NullMediaPlayerListener(logChannel);
        this.sourceActivationListener = new NullSourceActivationCallbackHandler(logChannel);
        PlayViewExceptionController playViewExceptionController = new PlayViewExceptionController(logChannel);
        this.dsiListener = new MediaDSIPlayerListener(this, logChannel, iFrameworkAccess.getLogChannel(new StringBuffer().append(logChannel.name).append(".periodic").toString()), dispatcherBase, playViewExceptionController);
        this.sourceResolver = iSourceResolver;
        this.requestDetailInfoHandler = new MediaDSIPlayerRequestDetailInfoHandler(logChannel, n);
        this.requestCoverURLHandler = new MediaDSIPlayerRequestCoverArtUrlHandler(logChannel, n);
        this.requestPlayViewListHandler = new MediaDSIPlayerRequestListHandler(logChannel, n, playViewExceptionController);
        playViewExceptionController.setRequestHandler(this.requestPlayViewListHandler);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        super.deinit();
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.clearAttributeNotification(this.dsiMediaPlayer);
        this.setPlayerListener(null);
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.pendingDeviceId = 0L;
            this.pendingMediaId = 0L;
            this.isPlayerDeactivated = true;
        }
        this.lastDeviceIdForActivation = 0L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1000000, "[%1.addDSIService] [%2] '%3'.", (Object)LOGCLASS, (Object)new Integer(this.getInstanceID()), (Object)dSIBase);
        this.requestDetailInfoHandler.setDSI(dSIBase);
        this.requestCoverURLHandler.setDSI(dSIBase);
        this.requestPlayViewListHandler.setDSI(dSIBase);
        this.registerAttributeNotifications(dSIBase);
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.dsiMediaPlayer = (DSIMediaPlayer)dSIBase;
            if (this.pendingDeviceId > 0L) {
                this.logger.log(1000000, "[%1.addDSIService] [%2] Pending activation mediaID='%3', deviceID='%4'", (Object)LOGCLASS, (Object)new Integer(this.getInstanceID()), (Object)new Long(this.pendingDeviceId), (Object)new Long(this.pendingMediaId));
                this.activateSource(this.pendingDeviceId, this.pendingMediaId);
                this.pendingDeviceId = 0L;
                this.isPlayerDeactivated = false;
            }
        }
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService]", (Object)LOGCLASS);
        this.dsiMediaPlayer = null;
        this.requestDetailInfoHandler.setDSI(null);
        this.requestCoverURLHandler.setDSI(null);
        this.requestPlayViewListHandler.setDSI(null);
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(10000000, "[%1.registerAttributeNotifications]", (Object)LOGCLASS);
        dSIBase.setNotification(new int[]{15, 8, 17, 13, 14, 10, 3, 4, 9, 6, 5, 7, 11, 12, 16, 1, 2}, this.getDSIListener());
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = MediaDSIPlayerControllerImpl.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = MediaDSIPlayerControllerImpl.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer;
    }

    protected final MediaDSIPlayerRequestDetailInfoHandler getRequestDetailInfoHandler() {
        return this.requestDetailInfoHandler;
    }

    protected final MediaDSIPlayerRequestCoverArtUrlHandler getRequestCoverartURLHandler() {
        return this.requestCoverURLHandler;
    }

    protected final MediaDSIPlayerRequestListHandler getRequestListHandler() {
        return this.requestPlayViewListHandler;
    }

    public void setPlayerListener(IMediaPlayerListener iMediaPlayerListener) {
        this.logger.log(1000000, "[%1.setPlayerListener] '%2'.", (Object)LOGCLASS, (Object)iMediaPlayerListener);
        if (iMediaPlayerListener == null) {
            this.mediaPlayerListener = new NullMediaPlayerListener(this.logger);
            return;
        }
        this.mediaPlayerListener = iMediaPlayerListener;
    }

    protected IMediaPlayerListener getPlayerListener() {
        return this.mediaPlayerListener;
    }

    public void setSourceActivationListener(ISourceActivationCallbackHandler iSourceActivationCallbackHandler) {
        this.logger.log(1000000, "[%1.setSourceActivationListener] '%2'.", (Object)LOGCLASS, (Object)iSourceActivationCallbackHandler);
        this.sourceActivationListener = iSourceActivationCallbackHandler;
    }

    protected ISourceActivationCallbackHandler getSourceActivationListener() {
        return this.sourceActivationListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(long l, long l2) {
        if (l <= 0L) {
            throw new IllegalArgumentException();
        }
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.activate] deviceId='%2', mediaId=%3", (Object)LOGCLASS, l, l2);
            DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
            if (dSIMediaPlayer == null) {
                this.logger.log(100000, "[%1.activate] No DSIMediaPlayer service. Pending activation.", (Object)LOGCLASS);
                this.pendingDeviceId = l;
                this.pendingMediaId = l2;
                return;
            }
            this.pendingDeviceId = l;
            this.pendingMediaId = l2;
            this.isPlayerDeactivated = false;
        }
        this.lastDeviceIdForActivation = l;
        this.activateSource(l, l2);
    }

    private void activateSource(long l, long l2) {
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.activateSource] [%4] dsiMediaPlayer.setActiveMedia(deviceId='%2',mediaId='%3')", (Object)LOGCLASS, (Object)new Long(l), (Object)new Long(l2), (long)this.getInstanceID());
        }
        this.dsiMediaPlayer.setActiveMedia(l, l2, 0);
    }

    protected void sourceDeviceActivated(long l, long l2, int n, boolean bl) {
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.sourceDeviceActivated] %2", (Object)LOGCLASS, (Object)new Buffer().append("[").append(n).append("] deviceID='").append(l).append("', mediaID='").append(l2).append("', '").append(bl ? "SUCCESS" : "FAILED").append("'").toString());
        }
        this.requestDetailInfoHandler.reset();
        this.requestCoverURLHandler.reset();
        this.requestPlayViewListHandler.reset();
        if (!bl && this.lastDeviceIdForActivation > 0L) {
            MediaSourceSlot mediaSourceSlot = this.sourceResolver.getSourceSlot(l, l2);
            this.sourceActivationListener.sourceDeviceActivated(mediaSourceSlot, n, bl);
            return;
        }
        if (l != 0L && l2 == -1L) {
            this.logger.log(1000000, "[%1.sourceDeviceActivated] active device is pending.", (Object)LOGCLASS);
            this.sourceActivationListener.sourceDevicePending(l);
            return;
        }
        MediaSourceSlot mediaSourceSlot = this.sourceResolver.getSourceSlot(l, l2);
        if (mediaSourceSlot == null) {
            this.logger.log(100000, "[%1.sourceDeviceActivated] Slot is null.", (Object)LOGCLASS);
            return;
        }
        this.sourceActivationListener.sourceDeviceActivated(mediaSourceSlot, n, bl);
    }

    protected void sourceDeviceDeactivated() {
        this.sourceActivationListener.sourceDeviceDeactivated();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deactivate() {
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
            this.pendingDeviceId = 0L;
            this.pendingMediaId = 0L;
            DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
            if (dSIMediaPlayer == null) {
                this.logger.log(100000, "[%1.deactivate] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
                return;
            }
            if (this.isPlayerDeactivated) {
                this.logger.log(1000000, "[%1.deactivate] Already deactivated.", (Object)LOGCLASS);
                return;
            }
            this.isPlayerDeactivated = true;
        }
        this.lastDeviceIdForActivation = 0L;
        this.activateSource(0L, 0L);
    }

    public boolean denyTempPMLRequest() {
        this.logger.log(1000000, "[%1.denyTempPLMRequest]", (Object)LOGCLASS);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.denyTempPMLRequest] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.denyTempPMLRequest();
        return true;
    }

    public boolean executeMenuCmd(int n) {
        this.logger.log(1000000, "[%1.executeMenuCmd] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.executeMenuCmd] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.executeMenuCmd(n);
        return true;
    }

    public boolean grantTempPMLRequest() {
        this.logger.log(1000000, "[%1.grantTempPMLRequest]", (Object)LOGCLASS);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.grantTempPMLRequest] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.grantTempPMLRequest();
        return true;
    }

    public boolean pause() {
        this.logger.log(1000000, "[%1.pause]", (Object)LOGCLASS);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.pause] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.pause();
        return true;
    }

    public boolean stop() {
        this.logger.log(1000000, "[%1.stop]", (Object)LOGCLASS);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.stop] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.stop();
        return true;
    }

    public boolean requestCoverArtURL(long l) {
        this.logger.log(1000000, "[%1.requestCoverArtURL] '%2'", (Object)LOGCLASS, l);
        return this.requestCoverURLHandler.request(new RequestParameterEntryID(l, 0));
    }

    public boolean requestDetailInfo(long l) {
        return this.requestDetailInfoHandler.request(new RequestParameterEntryID(l, 0));
    }

    public boolean requestPlayView(long l, int n, int n2, int n3) {
        return this.requestPlayViewListHandler.request(new RequestParameterList(l, 0, n, n2, n3));
    }

    public void discardPlayViewRequest(int n) {
        this.requestPlayViewListHandler.discard(n);
    }

    public boolean resume() {
        this.logger.log(1000000, "[%1.resume]", (Object)LOGCLASS);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.resume] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.resume();
        return true;
    }

    public boolean dsiSeek(boolean bl, int n) {
        int n2;
        this.logger.log(1000000, "[%1.seek] '%2','%3x'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"), (long)n);
        int n3 = bl ? 0 : 1;
        switch (n) {
            case 2: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 2;
                break;
            }
            case 8: {
                n2 = 4;
                break;
            }
            case 16: {
                n2 = 6;
                break;
            }
            case 32: {
                n2 = 7;
                break;
            }
            case 64: {
                n2 = 15;
                break;
            }
            default: {
                this.logger.log(100000, "[%1.seek] Invalid seek speed '%2'. Ignore seeking.", (Object)LOGCLASS, (long)n);
                return false;
            }
        }
        this.logger.log(1000000, "[%1.seek] '%2','%3'", (Object)LOGCLASS, (long)n3, (long)n2);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.seek] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.seek(n3, n2);
        return true;
    }

    public boolean setAudioStream(int n) {
        this.logger.log(1000000, "[%1.setAudioStream] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setAudioStream] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setAudioStream(n);
        return true;
    }

    public boolean setEntry(long l, int n) {
        this.logger.log(1000000, "[%1.setEntry] entryID='%2', pos='%3'", (Object)LOGCLASS, l, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setEntry] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setEntry(l, n == -1 ? n : n * 1000);
        return true;
    }

    public boolean setPlaySelection(int n, long l, boolean bl) {
        DSIMediaPlayer dSIMediaPlayer;
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.setPlaySelection] instanceID='%2' entryId='%3' seamless='%4'", (Object)LOGCLASS, (Object)new Integer(n), (Object)new Long(l), (Object)bl);
        }
        if ((dSIMediaPlayer = this.dsiMediaPlayer) == null) {
            this.logger.log(100000, "[%1.setPlaySelection] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setPlaySelection(n, l, bl);
        return true;
    }

    public boolean setPlaySelectionCoverflow(int n) {
        this.logger.log(1000000, "[%1.setPlaySelectionCoverflow] instanceID='%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setPlaySelectionCoverflow] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setPlaySelectionAB(n);
        return true;
    }

    public boolean setPlaybackMode(int n) {
        this.logger.log(1000000, "[%1.setPlaybackMode] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setPlaybackMode] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setPlaybackMode(n);
        return true;
    }

    public boolean setSubtitleLanguage(int n) {
        this.logger.log(1000000, "[%1.setSubtitleLanguage] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setSubtitleLanguage] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setSubtitleLanguage(n);
        return true;
    }

    public boolean setVideoAngle(int n) {
        this.logger.log(1000000, "[%1.setVideoAngle] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setVideoAngle] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setVideoAngle(n);
        return true;
    }

    public boolean setVideoFormat(int n) {
        this.logger.log(1000000, "[%1.setVideoFormat] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setVideoFormat] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setVideoFormat(n);
        return true;
    }

    public boolean setVideoNorm(int n) {
        this.logger.log(1000000, "[%1.setVideoNorm] '%2'", (Object)LOGCLASS, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setVideoNorm] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setVideoNorm(n);
        return true;
    }

    public boolean skip(int n, int n2) {
        this.logger.log(1000000, "[%1.skip] skipMode='%2', count='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.skip] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.skip(n, n2);
        return true;
    }

    public boolean playSimilarEntries(long l, int n) {
        this.logger.log(1000000, "[%1.playSimilarEntries] entryID='%2', count='%3'", (Object)LOGCLASS, l, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.playSimilarEntries] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.playSimilarEntry(l, n);
        return true;
    }

    public boolean setPlaybackURL(String string) {
        this.logger.log(1000000, "[%1.setPlaybackURL] '%2'", (Object)LOGCLASS, (Object)string);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setPlaybackURL] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setPlaybackURL(string);
        return true;
    }

    public boolean requestFullQualifiedName(long l) {
        this.logger.log(1000000, "[%1.requestFullQualifiedName] '%2'", (Object)LOGCLASS, l);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.requestFullQualifiedName] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.requestFullyQualifiedName(l);
        return true;
    }

    public boolean setVideoRect(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer(20);
        buffer.append("x='").append(n).append("',y='").append(n2).append("',width='").append(n3).append("',heigth='").append(n4).append("'");
        this.logger.log(1000000, "[%1.setVideoRect] %2", (Object)LOGCLASS, (Object)buffer);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(100000, "[%1.setVideoRect] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        dSIMediaPlayer.setVideoRect(0, 0, -1, -1, n, n2, n3, n4);
        return true;
    }

    public boolean touchEvent(int n, int n2, int n3) {
        Object object;
        if (this.logger.isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("'").append(n).append("','").append(n2).append(",").append(n3).append("'");
            this.logger.log(1000000, "[%1.touchEvent] '%2'", (Object)LOGCLASS, object);
        }
        if ((object = this.dsiMediaPlayer) == null) {
            this.logger.log(100000, "[%1.touchEvent] No DSIMediaPlayer service registered. Ignore.", (Object)LOGCLASS);
            return false;
        }
        object.requestTouchEvent(n, n2, n3);
        return true;
    }

    public void sourceActivationFailed() {
        this.logger.log(1000000, "[%1.sourceActivationFailed]", (Object)LOGCLASS);
        this.sourceActivationListener.sourceActivationFailed();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void receivedDeviceDeactivation() {
        Object object = this.deviceLock;
        synchronized (object) {
            this.deviceLock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deactivateSource() throws InterruptedException {
        Object object = this.deviceLock;
        synchronized (object) {
            this.deviceLock.wait(3000L);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

