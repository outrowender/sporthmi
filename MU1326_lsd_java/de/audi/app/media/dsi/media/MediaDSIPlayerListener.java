/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.dsi.media.MediaDSIPlayerControllerImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.PlayViewExceptionController;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.logger.LogUtil;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.DSIMediaPlayerListener;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public class MediaDSIPlayerListener
extends AbstractDSIListener
implements DSIMediaPlayerListener {
    private static final String LOGCLASS = "MediaDSIPlayerListener";
    private final MediaDSIPlayerControllerImpl controller;
    private final LogChannel dsiPeriodic;
    private final String logPrefixResponsePlayView;
    private final String logPrefixDispatcher;
    private final DispatcherBase dispatcher;
    private int currentTimePos;
    private int currentTotalTime;
    private long currentEntryID;
    protected PlayViewExceptionController exceptionController;

    public MediaDSIPlayerListener(MediaDSIPlayerControllerImpl mediaDSIPlayerControllerImpl, LogChannel logChannel, LogChannel logChannel2, DispatcherBase dispatcherBase, PlayViewExceptionController playViewExceptionController) {
        super(logChannel);
        this.dsiPeriodic = logChannel2;
        this.dispatcher = dispatcherBase;
        this.controller = mediaDSIPlayerControllerImpl;
        this.logPrefixResponsePlayView = new Buffer(20).append("[").append(LOGCLASS).append(".responsePlayView]").toString();
        this.logPrefixDispatcher = new Buffer(20).append("DSIMediaPlayer[").append(mediaDSIPlayerControllerImpl.getInstanceID()).append("].").toString();
        this.exceptionController = playViewExceptionController;
    }

    protected String getLogClass() {
        return LOGCLASS;
    }

    public void indicationDvdEvent(final int n) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("indicationDvdEvent").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.indicationDvdEvent] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID(), (long)n);
                MediaDSIPlayerListener.this.controller.getPlayerListener().indicationDvdEvent(n);
            }
        });
    }

    public void responseCmdBlocked(final int n) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseCmdBlocked").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseCmdBlocked] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID(), (long)n);
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseCmdBlocked(n);
            }
        });
    }

    public void responseCoverArt(final long l, final ResourceLocator resourceLocator) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseCoverArt").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseCoverArtURL] [%2] entryID='%3',rl='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Long(l), (Object)resourceLocator);
                }
                RequestParameterEntryID requestParameterEntryID = (RequestParameterEntryID)MediaDSIPlayerListener.this.controller.getRequestCoverartURLHandler().dataResponded();
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseCoverArtURL(requestParameterEntryID, l, resourceLocator);
            }
        });
    }

    public void responseDetailInfo(final EntryInfo entryInfo) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseDetailInfo").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] [%2]", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID());
                RequestParameterEntryID requestParameterEntryID = (RequestParameterEntryID)MediaDSIPlayerListener.this.controller.getRequestDetailInfoHandler().dataResponded();
                if (entryInfo == null) {
                    MediaDSIPlayerListener.this.logger.log(100000, "[%1.responseDetailInfo] [%2] Detail info null. Ignore.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID());
                    return;
                }
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] entryID='%2',fileName='%3',title='%4'", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)String.valueOf(entryInfo.getEntryID()), (Object)entryInfo.getFilename(), (Object)entryInfo.getTitle());
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] albumID ='%2',album ='%3'", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)String.valueOf(entryInfo.getAlbumID()), (Object)entryInfo.getAlbum());
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] artistID='%2',artist='%3'", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)String.valueOf(entryInfo.getArtistID()), (Object)entryInfo.getArtist());
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] genreID ='%2',genre ='%3'", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)String.valueOf(entryInfo.getGenreID()), (Object)entryInfo.getGenre());
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] contentType='%2'", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)LogUtil.getListEntryContentTypeStr(entryInfo.getContentType()));
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] flags='%2'", (Object)MediaDSIPlayerListener.LOGCLASS, (long)entryInfo.flags);
                    if (null != entryInfo.getChapterInfo()) {
                        MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseDetailInfo] activeChapter='%2' totalChapter='%3'", (Object)MediaDSIPlayerListener.LOGCLASS, (long)entryInfo.getChapterInfo().getActiveChapter(), (long)entryInfo.getChapterInfo().getNumChapters());
                    }
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseDetailInfo(requestParameterEntryID, entryInfo);
            }
        });
    }

    public void responseFullyQualifiedName(final long l, final String string) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseFullyQualifiedName").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseFullyQualifiedName] [%2] entryID='%3',path='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Long(l), (Object)string);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseFullyQualifiedName(l, string);
            }
        });
    }

    public void responsePlaySimilarEntry(final long l, final boolean bl) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responsePlaySimilarEntry").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responsePlaySimilarEntry] [%2] entryID='%3',result='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Long(l), (Object)String.valueOf(bl));
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responsePlaySimilarEntry(l, bl);
            }
        });
    }

    public void responsePlayView(final ListEntry[] listEntryArray, final int n, final int n2, final int n3) {
        if (listEntryArray == null) {
            this.logger.log(100000, "[%1.responsePlayView] Response play view is null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append(this.logPrefixDispatcher).append("responsePlayView (size='").append(listEntryArray.length).append("', client='").append(n3).append("')").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responsePlayView] [%2] index='%3', order='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Integer(n2), (Object)new Integer(n));
                }
                RequestParameterList requestParameterList = (RequestParameterList)MediaDSIPlayerListener.this.controller.getRequestListHandler().dataResponded();
                LogUtil.logEntryList(MediaDSIPlayerListener.this.logPrefixResponsePlayView, MediaDSIPlayerListener.this.logger, listEntryArray);
                MediaListEntry[] mediaListEntryArray = MediaListEntry.convert(listEntryArray);
                MediaDSIPlayerListener.this.exceptionController.responseReceived(n3);
                MediaDSIPlayerListener.this.controller.getPlayerListener().responsePlayView(requestParameterList, mediaListEntryArray, n, n2);
            }
        });
    }

    public void responseRating(long l, int n) {
    }

    public void responseSetPlaySelection(final int n, final int n2) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseSetPlaySelection").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseSetPlaySelection] [%2] browserInstanceID='%3',result='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Integer(n), (long)n2);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseSetPlaySelection(n, 0 == n2);
            }
        });
    }

    public void responseSetPlaySelectionAB(final int n, final boolean bl) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseSetPlaySelectionAB").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseSetPlaySelectionAB] [%2] coverflowInstanceID='%3',result='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Integer(n), (Object)String.valueOf(bl));
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseSetPlaySelectionCoverflow(n, bl);
            }
        });
    }

    public void responseSetPlaybackURL(final String string) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("responseSetPlaybackURL").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseSetPlaybackURL] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)string);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseSetPlaybackURL(string);
            }
        });
    }

    public void responseSetVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    public void tempPMLRequest(final int n) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("tempPMLRequest").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.tempPMLRequest] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (long)n);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseTempPMLRequest(n);
            }
        });
    }

    public void updateActiveAudioStream(final int n, int n2) {
        if (!this.isUpdateRelevant("updateActiveAudioStream", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateActiveAudioStream").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateActiveAudioStream] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID(), (long)n);
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateActiveAudioStream(n);
            }
        });
    }

    public void updateActiveMedia(final long l, final long l2, final int n, final int n2, int n3) {
        if (l == 0L && l2 == 0L) {
            this.controller.receivedDeviceDeactivation();
        }
        if (!this.isUpdateRelevant("updateActiveMedia", this.controller.getInstanceID(), n3)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append(this.logPrefixDispatcher).append("updateActiveMedia (deviceID='").append(l).append("',mediaID='").append(l2).append("')").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    Buffer buffer = new Buffer(20);
                    buffer.append("deviceID='").append(l).append("',mediaID='").append(l2).append("',groupID='").append(n).append("',playerID='").append(n2).append("'");
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateActiveMedia] [%2] %3", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)buffer);
                }
                MediaDSIPlayerListener.this.resetTimePosValues();
                if (l == 0L && l2 == 0L) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateActiveMedia] [%2] Player deactivated.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID());
                    MediaDSIPlayerListener.this.controller.sourceDeviceDeactivated();
                    return;
                }
                MediaDSIPlayerListener.this.controller.sourceDeviceActivated(l, l2, n2, true);
            }
        });
    }

    public void updateActiveSubtitle(final int n, int n2) {
        if (!this.isUpdateRelevant("updateActiveSubtitle", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateActiveSubtitle").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateActiveSubtitle] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (long)n);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateActiveSubtitle(n);
            }
        });
    }

    public void updateActiveVideoAngle(final int n, int n2) {
        if (!this.isUpdateRelevant("updateActiveVideoAngle", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateActiveVideoAngle").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateActiveVideoAngle] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (long)n);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateActiveVideoAngle(n);
            }
        });
    }

    public void updateAudioStreamList(final AudioStream[] audioStreamArray, int n) {
        if (!this.isUpdateRelevant("updateAudioStreamList", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateAudioStreamList").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateAudioStreamList] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)audioStreamArray);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateAudioStreamList(audioStreamArray);
            }
        });
    }

    public void updateCapabilities(final Capabilities capabilities, int n) {
        if (!this.isUpdateRelevant("updateCapabilities", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateCapabilities").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateCapabilities] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)capabilities);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateCapabilities(capabilities);
            }
        });
    }

    public void updateCmdBlockingMask(final int n, int n2) {
        if (!this.isUpdateRelevant("updateCmdBlockingMask", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateCmdBlockingMask").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateCmdBlockingMask] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (long)n);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateCmdBlockingMask(n);
            }
        });
    }

    public void updateNumVideoAngles(final int n, int n2) {
        if (!this.isUpdateRelevant("updateNumVideoAngles", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateNumVideoAngles").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateNumVideoAngles] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (long)n);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateNumVideoAngles(n);
            }
        });
    }

    public void updatePlayPosition(final long l, int n, int n2, int n3) {
        if (n3 == 2) {
            this.resetTimePosValues();
            this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updatePlayPosition (INVALID)").toString()){

                public void run() {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updatePlayPosition] [%2] Invalidation.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()));
                    MediaDSIPlayerListener.this.controller.getPlayerListener().playPositionInvalidated();
                }
            });
            return;
        }
        if (!this.isUpdateRelevant("updatePlayPosition", this.controller.getInstanceID(), n3)) {
            return;
        }
        final int n4 = n / 1000;
        final int n5 = n2 > 0 ? n2 / 1000 : n2;
        boolean bl = n4 == this.currentTimePos && n5 == this.currentTotalTime && this.currentEntryID == l;
        this.currentTimePos = n4;
        this.currentTotalTime = n5;
        this.currentEntryID = l;
        if (this.dsiPeriodic.isInfo()) {
            String string = new Buffer().append("entryID='").append(l).append("',timePos='").append(n).append("',totalTime='").append(n2).append("',").append("changed='").append(!bl).append("'").toString();
            this.dsiPeriodic.log(1000000, "[%1.updatePlayPosition] [%2] %3", (Object)LOGCLASS, (Object)new Integer(this.controller.getInstanceID()), (Object)string);
        }
        if (bl) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append(this.logPrefixDispatcher).append("updatePlayPosition (entryID='").append(l).append("',pos='").append(this.currentTimePos).append("',total='").append(this.currentTotalTime).append("')").toString()){

            public void run() {
                MediaDSIPlayerListener.this.controller.getPlayerListener().updatePlayPosition(l, n4, n5);
            }
        });
    }

    public void updatePlayViewSize(final int n, final int n2, int n3) {
        if (n3 == 2) {
            this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updatePlayViewSize (INVALID)").toString()){

                public void run() {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updatePlayViewSize] [%2] Invalidation.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()));
                    MediaDSIPlayerListener.this.exceptionController.invalidate();
                    MediaDSIPlayerListener.this.controller.getRequestListHandler().reset();
                    MediaDSIPlayerListener.this.controller.getPlayerListener().playViewSizeInvalidated();
                }
            });
            return;
        }
        if (!this.isUpdateRelevant("updatePlayViewSize", this.controller.getInstanceID(), n3)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append(this.logPrefixDispatcher).append("updatePlayViewSize ('").append(n).append("')").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updatePlayViewSize] [%2] count='%3', flags='%4'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)new Integer(n), (Object)new Integer(n2));
                }
                if (n < 0) {
                    MediaDSIPlayerListener.this.logger.log(100000, "[%1.updatePlayViewSize] Receive invalid count '%2'. Ignore.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)n);
                    return;
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updatePlayViewSize(n, n2);
            }
        });
    }

    public void updatePlaybackFolder(final ListEntry[] listEntryArray, int n) {
        if (!this.isUpdateRelevant("updatePlaybackFolder", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackFolder").toString()){

            public void run() {
                if (listEntryArray == null) {
                    MediaDSIPlayerListener.this.logger.log(100000, "[%1.updatePlaybackFolder] [%2] Playback folder is null. Ignore.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID());
                    return;
                }
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updatePlaybackFolder] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)LogUtil.listEntryToStr(listEntryArray));
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updatePlaybackFolder(MediaListEntry.convert(listEntryArray));
            }
        });
    }

    public void updatePlaybackMode(final int n, int n2) {
        if (!this.isUpdateRelevant("updatePlaybackMode", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackMode").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updatePlaybackMode] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID(), (long)n);
                MediaDSIPlayerListener.this.controller.getPlayerListener().updatePlaybackMode(n);
            }
        });
    }

    public void updatePlaybackModeList(final PlaybackMode[] playbackModeArray, int n) {
        if (!this.isUpdateRelevant("updatePlaybackModeList", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackModeList").toString()){

            public void run() {
                if (playbackModeArray == null) {
                    MediaDSIPlayerListener.this.logger.log(100000, "[%1.updatePlaybackModeList] [%2] Playback mode list is null. Ignore.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID());
                    return;
                }
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    LogUtil.logPlaybackModeList(MediaDSIPlayerListener.this.logger, new StringBuffer().append("[MediaDSIPlayerListener.updatePlaybackModeList] [").append(MediaDSIPlayerListener.this.controller.getInstanceID()).append("]").toString(), playbackModeArray);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updatePlaybackModeList(playbackModeArray);
            }
        });
    }

    public void updatePlaybackState(final int n, int n2) {
        if (!this.isUpdateRelevant("updatePlaybackState", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackState").toString()){

            public void run() {
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updatePlaybackState] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)LogUtil.getPlaybackStateStr(n));
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updatePlaybackState(n);
            }
        });
    }

    public void updateSubtitleList(final int[] nArray, int n) {
        if (!this.isUpdateRelevant("updateSubtitleList", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateSubtitleList").toString()){

            public void run() {
                if (nArray == null) {
                    MediaDSIPlayerListener.this.logger.log(100000, "[%1.updateSubtitleList] [%2] Subtitle list is null. Ignore.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID());
                    return;
                }
                if (MediaDSIPlayerListener.this.logger.isInfo()) {
                    Buffer buffer = new Buffer(20);
                    for (int i2 = 0; i2 < nArray.length; ++i2) {
                        buffer.append(i2).append(",");
                    }
                    MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateSubtitleList] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)buffer);
                }
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateSubtitleList(nArray);
            }
        });
    }

    public void updateVideoFormat(final int n, int n2) {
        if (!this.isUpdateRelevant("updateVideoFormat", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateVideoFormat").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateVideoFormat] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID(), (long)n);
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateVideoFormat(n);
            }
        });
    }

    public void updateVideoNorm(final int n, int n2) {
        if (!this.isUpdateRelevant("updateVideoNorm", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("updateVideoNorm").toString()){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.updateVideoNorm] [%2] '%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, (long)MediaDSIPlayerListener.this.controller.getInstanceID(), (long)n);
                MediaDSIPlayerListener.this.controller.getPlayerListener().updateVideoNorm(n);
            }
        });
    }

    public void asyncException(final int n, final String string, final int n2) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(new StringBuffer().append(this.logPrefixDispatcher).append("asyncException").toString()){

            public void run() {
                Buffer buffer = new Buffer(20);
                buffer.append("errorCode='").append(n).append("',requestType='").append(n2).append("',msg='").append(string).append("'");
                MediaDSIPlayerListener.this.logger.log(100000, "[%1.asyncException] [%2] %3", (Object)MediaDSIPlayerListener.LOGCLASS, (Object)new Integer(MediaDSIPlayerListener.this.controller.getInstanceID()), (Object)buffer);
                switch (n2) {
                    case 1019: {
                        MediaDSIPlayerListener.this.logger.log(100000, "[%1.asyncException] RT_REQUESTDETAILINFO.", (Object)MediaDSIPlayerListener.LOGCLASS);
                        MediaDSIPlayerListener.this.controller.getRequestDetailInfoHandler().dataResponded();
                        break;
                    }
                    case 1003: {
                        MediaDSIPlayerListener.this.logger.log(100000, "[%1.asyncException] RT_REQUESTCOVERART.", (Object)MediaDSIPlayerListener.LOGCLASS);
                        MediaDSIPlayerListener.this.controller.getRequestCoverartURLHandler().dataResponded();
                        break;
                    }
                    case 1012: {
                        MediaDSIPlayerListener.this.logger.log(100000, "[%1.asyncException] RT_SETACTIVEMEDIA.", (Object)MediaDSIPlayerListener.LOGCLASS);
                        if (n == 8300) {
                            MediaDSIPlayerListener.this.logger.log(1000000, "[%1.asyncException] Pruning detected.", (Object)MediaDSIPlayerListener.LOGCLASS);
                            MediaDSIPlayerListener.this.controller.sourceDeviceActivated(0L, 0L, 0, false);
                            break;
                        }
                        MediaDSIPlayerListener.this.controller.sourceActivationFailed();
                        break;
                    }
                    case 1013: {
                        MediaDSIPlayerListener.this.logger.log(100000, "[%1.asyncException] RT_REQUESTPLAYVIEW.", (Object)MediaDSIPlayerListener.LOGCLASS);
                        if (MediaDSIPlayerListener.this.exceptionController.asyncException(n, string, n2)) break;
                        RequestParameterList requestParameterList = (RequestParameterList)MediaDSIPlayerListener.this.controller.getRequestListHandler().dataResponded();
                        if (requestParameterList == null) {
                            return;
                        }
                        MediaDSIPlayerListener.this.logger.log(100000, "[%1.asyncException] Running request was aborted.", (Object)MediaDSIPlayerListener.LOGCLASS);
                        MediaDSIPlayerListener.this.controller.getPlayerListener().errorPlayViewListRequestAborted(requestParameterList.getClientID());
                        break;
                    }
                    default: {
                        MediaDSIPlayerListener.this.controller.getPlayerListener().error(n2);
                    }
                }
            }
        });
    }

    private void resetTimePosValues() {
        this.currentTimePos = -1;
        this.currentTotalTime = -1;
        this.currentEntryID = -1L;
    }

    public void responseFidForPlaylistEntryID(final long l, final long l2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIPlayerListener.this.logger.log(1000000, "[%1.responseFidForPlaylistEntryID] playlistEntryID='%2', entryID='%3'.", (Object)MediaDSIPlayerListener.LOGCLASS, l, l2);
                MediaDSIPlayerListener.this.controller.getPlayerListener().responseFidForPlaylistEntryID(l, l2);
            }
        });
    }

    public void updatePlaybackContentFolder(ListEntry[] listEntryArray, int n) {
    }
}

