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
    private static final String LOGCLASS;
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
    @Override
    public void deinit() {
        super.deinit();
        this.logger.log(1078071040, "[%1.deinit] Deinit.", (Object)"MediaDSIPlayerControllerImpl");
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
    @Override
    public void addDSIService(DSIBase dSIBase) {
        this.logger.log(1078071040, "[%1.addDSIService] [%2] '%3'.", (Object)"MediaDSIPlayerControllerImpl", (Object)new Integer(this.getInstanceID()), (Object)dSIBase);
        this.requestDetailInfoHandler.setDSI(dSIBase);
        this.requestCoverURLHandler.setDSI(dSIBase);
        this.requestPlayViewListHandler.setDSI(dSIBase);
        this.registerAttributeNotifications(dSIBase);
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.dsiMediaPlayer = (DSIMediaPlayer)dSIBase;
            if (this.pendingDeviceId > 0L) {
                this.logger.log(1078071040, "[%1.addDSIService] [%2] Pending activation mediaID='%3', deviceID='%4'", (Object)"MediaDSIPlayerControllerImpl", (Object)new Integer(this.getInstanceID()), (Object)new Long(this.pendingDeviceId), (Object)new Long(this.pendingMediaId));
                this.activateSource(this.pendingDeviceId, this.pendingMediaId);
                this.pendingDeviceId = 0L;
                this.isPlayerDeactivated = false;
            }
        }
    }

    @Override
    protected void removeDSIService() {
        this.logger.log(1078071040, "[%1.removeDSIService]", (Object)"MediaDSIPlayerControllerImpl");
        this.dsiMediaPlayer = null;
        this.requestDetailInfoHandler.setDSI(null);
        this.requestCoverURLHandler.setDSI(null);
        this.requestPlayViewListHandler.setDSI(null);
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
        this.logger.log(-2137614336, "[%1.registerAttributeNotifications]", (Object)"MediaDSIPlayerControllerImpl");
        dSIBase.setNotification(new int[]{15, 8, 17, 13, 14, 10, 3, 4, 9, 6, 5, 7, 11, 12, 16, 1, 2}, this.getDSIListener());
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = MediaDSIPlayerControllerImpl.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener;
    }

    @Override
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

    @Override
    public void setPlayerListener(IMediaPlayerListener iMediaPlayerListener) {
        this.logger.log(1078071040, "[%1.setPlayerListener] '%2'.", (Object)"MediaDSIPlayerControllerImpl", (Object)iMediaPlayerListener);
        if (iMediaPlayerListener == null) {
            this.mediaPlayerListener = new NullMediaPlayerListener(this.logger);
            return;
        }
        this.mediaPlayerListener = iMediaPlayerListener;
    }

    protected IMediaPlayerListener getPlayerListener() {
        return this.mediaPlayerListener;
    }

    @Override
    public void setSourceActivationListener(ISourceActivationCallbackHandler iSourceActivationCallbackHandler) {
        this.logger.log(1078071040, "[%1.setSourceActivationListener] '%2'.", (Object)"MediaDSIPlayerControllerImpl", (Object)iSourceActivationCallbackHandler);
        this.sourceActivationListener = iSourceActivationCallbackHandler;
    }

    protected ISourceActivationCallbackHandler getSourceActivationListener() {
        return this.sourceActivationListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void activate(long l, long l2) {
        if (l <= 0L) {
            throw new IllegalArgumentException();
        }
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.activate] deviceId='%2', mediaId=%3", (Object)"MediaDSIPlayerControllerImpl", l, l2);
            DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
            if (dSIMediaPlayer == null) {
                this.logger.log(-1601830656, "[%1.activate] No DSIMediaPlayer service. Pending activation.", (Object)"MediaDSIPlayerControllerImpl");
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
            this.logger.log(1078071040, "[%1.activateSource] [%4] dsiMediaPlayer.setActiveMedia(deviceId='%2',mediaId='%3')", (Object)"MediaDSIPlayerControllerImpl", (Object)new Long(l), (Object)new Long(l2), (long)this.getInstanceID());
        }
        this.dsiMediaPlayer.setActiveMedia(l, l2, 0);
    }

    protected void sourceDeviceActivated(long l, long l2, int n, boolean bl) {
        if (this.logger.isInfo()) {
            this.logger.log(1078071040, "[%1.sourceDeviceActivated] %2", (Object)"MediaDSIPlayerControllerImpl", (Object)new Buffer().append("[").append(n).append("] deviceID='").append(l).append("', mediaID='").append(l2).append("', '").append(bl ? "SUCCESS" : "FAILED").append("'").toString());
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
            this.logger.log(1078071040, "[%1.sourceDeviceActivated] active device is pending.", (Object)"MediaDSIPlayerControllerImpl");
            this.sourceActivationListener.sourceDevicePending(l);
            return;
        }
        MediaSourceSlot mediaSourceSlot = this.sourceResolver.getSourceSlot(l, l2);
        if (mediaSourceSlot == null) {
            this.logger.log(-1601830656, "[%1.sourceDeviceActivated] Slot is null.", (Object)"MediaDSIPlayerControllerImpl");
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
    @Override
    public void deactivate() {
        Object object = this.addingServiceMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.deactivate]", (Object)"MediaDSIPlayerControllerImpl");
            this.pendingDeviceId = 0L;
            this.pendingMediaId = 0L;
            DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
            if (dSIMediaPlayer == null) {
                this.logger.log(-1601830656, "[%1.deactivate] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
                return;
            }
            if (this.isPlayerDeactivated) {
                this.logger.log(1078071040, "[%1.deactivate] Already deactivated.", (Object)"MediaDSIPlayerControllerImpl");
                return;
            }
            this.isPlayerDeactivated = true;
        }
        this.lastDeviceIdForActivation = 0L;
        this.activateSource(0L, 0L);
    }

    @Override
    public boolean denyTempPMLRequest() {
        this.logger.log(1078071040, "[%1.denyTempPLMRequest]", (Object)"MediaDSIPlayerControllerImpl");
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.denyTempPMLRequest] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.denyTempPMLRequest();
        return true;
    }

    @Override
    public boolean executeMenuCmd(int n) {
        this.logger.log(1078071040, "[%1.executeMenuCmd] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.executeMenuCmd] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.executeMenuCmd(n);
        return true;
    }

    @Override
    public boolean grantTempPMLRequest() {
        this.logger.log(1078071040, "[%1.grantTempPMLRequest]", (Object)"MediaDSIPlayerControllerImpl");
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.grantTempPMLRequest] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.grantTempPMLRequest();
        return true;
    }

    @Override
    public boolean pause() {
        this.logger.log(1078071040, "[%1.pause]", (Object)"MediaDSIPlayerControllerImpl");
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.pause] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.pause();
        return true;
    }

    @Override
    public boolean stop() {
        this.logger.log(1078071040, "[%1.stop]", (Object)"MediaDSIPlayerControllerImpl");
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.stop] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.stop();
        return true;
    }

    @Override
    public boolean requestCoverArtURL(long l) {
        this.logger.log(1078071040, "[%1.requestCoverArtURL] '%2'", (Object)"MediaDSIPlayerControllerImpl", l);
        return this.requestCoverURLHandler.request(new RequestParameterEntryID(l, 0));
    }

    @Override
    public boolean requestDetailInfo(long l) {
        return this.requestDetailInfoHandler.request(new RequestParameterEntryID(l, 0));
    }

    @Override
    public boolean requestPlayView(long l, int n, int n2, int n3) {
        return this.requestPlayViewListHandler.request(new RequestParameterList(l, 0, n, n2, n3));
    }

    @Override
    public void discardPlayViewRequest(int n) {
        this.requestPlayViewListHandler.discard(n);
    }

    @Override
    public boolean resume() {
        this.logger.log(1078071040, "[%1.resume]", (Object)"MediaDSIPlayerControllerImpl");
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.resume] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.resume();
        return true;
    }

    @Override
    public boolean dsiSeek(boolean bl, int n) {
        int n2;
        this.logger.log(1078071040, "[%1.seek] '%2','%3x'", (Object)"MediaDSIPlayerControllerImpl", (Object)(bl ? "FORWARD" : "BACKWARD"), (long)n);
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
                this.logger.log(-1601830656, "[%1.seek] Invalid seek speed '%2'. Ignore seeking.", (Object)"MediaDSIPlayerControllerImpl", (long)n);
                return false;
            }
        }
        this.logger.log(1078071040, "[%1.seek] '%2','%3'", (Object)"MediaDSIPlayerControllerImpl", (long)n3, (long)n2);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.seek] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.seek(n3, n2);
        return true;
    }

    @Override
    public boolean setAudioStream(int n) {
        this.logger.log(1078071040, "[%1.setAudioStream] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setAudioStream] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setAudioStream(n);
        return true;
    }

    @Override
    public boolean setEntry(long l, int n) {
        this.logger.log(1078071040, "[%1.setEntry] entryID='%2', pos='%3'", (Object)"MediaDSIPlayerControllerImpl", l, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setEntry] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setEntry(l, n == -1 ? n : n * 1000);
        return true;
    }

    @Override
    public boolean setPlaySelection(int n, long l, boolean bl) {
        DSIMediaPlayer dSIMediaPlayer;
        if (this.logger.isInfo()) {
            this.logger.log(1078071040, "[%1.setPlaySelection] instanceID='%2' entryId='%3' seamless='%4'", (Object)"MediaDSIPlayerControllerImpl", (Object)new Integer(n), (Object)new Long(l), (Object)bl);
        }
        if ((dSIMediaPlayer = this.dsiMediaPlayer) == null) {
            this.logger.log(-1601830656, "[%1.setPlaySelection] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setPlaySelection(n, l, bl);
        return true;
    }

    @Override
    public boolean setPlaySelectionCoverflow(int n) {
        this.logger.log(1078071040, "[%1.setPlaySelectionCoverflow] instanceID='%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setPlaySelectionCoverflow] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setPlaySelectionAB(n);
        return true;
    }

    @Override
    public boolean setPlaybackMode(int n) {
        this.logger.log(1078071040, "[%1.setPlaybackMode] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setPlaybackMode] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setPlaybackMode(n);
        return true;
    }

    @Override
    public boolean setSubtitleLanguage(int n) {
        this.logger.log(1078071040, "[%1.setSubtitleLanguage] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setSubtitleLanguage] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setSubtitleLanguage(n);
        return true;
    }

    @Override
    public boolean setVideoAngle(int n) {
        this.logger.log(1078071040, "[%1.setVideoAngle] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setVideoAngle] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setVideoAngle(n);
        return true;
    }

    @Override
    public boolean setVideoFormat(int n) {
        this.logger.log(1078071040, "[%1.setVideoFormat] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setVideoFormat] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setVideoFormat(n);
        return true;
    }

    @Override
    public boolean setVideoNorm(int n) {
        this.logger.log(1078071040, "[%1.setVideoNorm] '%2'", (Object)"MediaDSIPlayerControllerImpl", (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setVideoNorm] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setVideoNorm(n);
        return true;
    }

    @Override
    public boolean skip(int n, int n2) {
        this.logger.log(1078071040, "[%1.skip] skipMode='%2', count='%3'", (Object)"MediaDSIPlayerControllerImpl", (long)n, (long)n2);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.skip] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.skip(n, n2);
        return true;
    }

    @Override
    public boolean playSimilarEntries(long l, int n) {
        this.logger.log(1078071040, "[%1.playSimilarEntries] entryID='%2', count='%3'", (Object)"MediaDSIPlayerControllerImpl", l, (long)n);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.playSimilarEntries] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.playSimilarEntry(l, n);
        return true;
    }

    @Override
    public boolean setPlaybackURL(String string) {
        this.logger.log(1078071040, "[%1.setPlaybackURL] '%2'", (Object)"MediaDSIPlayerControllerImpl", (Object)string);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setPlaybackURL] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setPlaybackURL(string);
        return true;
    }

    @Override
    public boolean requestFullQualifiedName(long l) {
        this.logger.log(1078071040, "[%1.requestFullQualifiedName] '%2'", (Object)"MediaDSIPlayerControllerImpl", l);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.requestFullQualifiedName] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.requestFullyQualifiedName(l);
        return true;
    }

    @Override
    public boolean setVideoRect(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer(20);
        buffer.append("x='").append(n).append("',y='").append(n2).append("',width='").append(n3).append("',heigth='").append(n4).append("'");
        this.logger.log(1078071040, "[%1.setVideoRect] %2", (Object)"MediaDSIPlayerControllerImpl", (Object)buffer);
        DSIMediaPlayer dSIMediaPlayer = this.dsiMediaPlayer;
        if (dSIMediaPlayer == null) {
            this.logger.log(-1601830656, "[%1.setVideoRect] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        dSIMediaPlayer.setVideoRect(0, 0, -1, -1, n, n2, n3, n4);
        return true;
    }

    @Override
    public boolean touchEvent(int n, int n2, int n3) {
        Object object;
        if (this.logger.isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("'").append(n).append("','").append(n2).append(",").append(n3).append("'");
            this.logger.log(1078071040, "[%1.touchEvent] '%2'", (Object)"MediaDSIPlayerControllerImpl", object);
        }
        if ((object = this.dsiMediaPlayer) == null) {
            this.logger.log(-1601830656, "[%1.touchEvent] No DSIMediaPlayer service registered. Ignore.", (Object)"MediaDSIPlayerControllerImpl");
            return false;
        }
        object.requestTouchEvent(n, n2, n3);
        return true;
    }

    public void sourceActivationFailed() {
        this.logger.log(1078071040, "[%1.sourceActivationFailed]", (Object)"MediaDSIPlayerControllerImpl");
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
    @Override
    public void deactivateSource() {
        Object object = this.deviceLock;
        synchronized (object) {
            this.deviceLock.wait(0);
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

