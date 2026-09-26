/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.dsi.media.MediaDSIPlayerControllerImpl;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$1;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$10;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$11;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$12;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$13;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$14;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$15;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$16;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$17;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$18;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$19;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$2;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$20;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$21;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$22;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$23;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$24;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$25;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$26;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$27;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$28;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$29;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$3;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$30;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$31;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$32;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$4;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$5;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$6;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$7;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$8;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener$9;
import de.audi.app.media.dsi.media.PlayViewExceptionController;
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
    private static final String LOGCLASS;
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
        this.logPrefixResponsePlayView = new Buffer(20).append("[").append("MediaDSIPlayerListener").append(".responsePlayView]").toString();
        this.logPrefixDispatcher = new Buffer(20).append("DSIMediaPlayer[").append(mediaDSIPlayerControllerImpl.getInstanceID()).append("].").toString();
        this.exceptionController = playViewExceptionController;
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIPlayerListener";
    }

    @Override
    public void indicationDvdEvent(int n) {
        this.dispatcher.execute(new MediaDSIPlayerListener$1(this, new StringBuffer().append(this.logPrefixDispatcher).append("indicationDvdEvent").toString(), n));
    }

    @Override
    public void responseCmdBlocked(int n) {
        this.dispatcher.execute(new MediaDSIPlayerListener$2(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseCmdBlocked").toString(), n));
    }

    @Override
    public void responseCoverArt(long l, ResourceLocator resourceLocator) {
        this.dispatcher.execute(new MediaDSIPlayerListener$3(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseCoverArt").toString(), l, resourceLocator));
    }

    @Override
    public void responseDetailInfo(EntryInfo entryInfo) {
        this.dispatcher.execute(new MediaDSIPlayerListener$4(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseDetailInfo").toString(), entryInfo));
    }

    @Override
    public void responseFullyQualifiedName(long l, String string) {
        this.dispatcher.execute(new MediaDSIPlayerListener$5(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseFullyQualifiedName").toString(), l, string));
    }

    @Override
    public void responsePlaySimilarEntry(long l, boolean bl) {
        this.dispatcher.execute(new MediaDSIPlayerListener$6(this, new StringBuffer().append(this.logPrefixDispatcher).append("responsePlaySimilarEntry").toString(), l, bl));
    }

    @Override
    public void responsePlayView(ListEntry[] listEntryArray, int n, int n2, int n3) {
        if (listEntryArray == null) {
            this.logger.log(-1601830656, "[%1.responsePlayView] Response play view is null. Ignore.", (Object)"MediaDSIPlayerListener");
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$7(this, new Buffer().append(this.logPrefixDispatcher).append("responsePlayView (size='").append(listEntryArray.length).append("', client='").append(n3).append("')").toString(), n2, n, listEntryArray, n3));
    }

    @Override
    public void responseRating(long l, int n) {
    }

    @Override
    public void responseSetPlaySelection(int n, int n2) {
        this.dispatcher.execute(new MediaDSIPlayerListener$8(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseSetPlaySelection").toString(), n, n2));
    }

    @Override
    public void responseSetPlaySelectionAB(int n, boolean bl) {
        this.dispatcher.execute(new MediaDSIPlayerListener$9(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseSetPlaySelectionAB").toString(), n, bl));
    }

    @Override
    public void responseSetPlaybackURL(String string) {
        this.dispatcher.execute(new MediaDSIPlayerListener$10(this, new StringBuffer().append(this.logPrefixDispatcher).append("responseSetPlaybackURL").toString(), string));
    }

    @Override
    public void responseSetVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    @Override
    public void tempPMLRequest(int n) {
        this.dispatcher.execute(new MediaDSIPlayerListener$11(this, new StringBuffer().append(this.logPrefixDispatcher).append("tempPMLRequest").toString(), n));
    }

    @Override
    public void updateActiveAudioStream(int n, int n2) {
        if (!this.isUpdateRelevant("updateActiveAudioStream", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$12(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateActiveAudioStream").toString(), n));
    }

    @Override
    public void updateActiveMedia(long l, long l2, int n, int n2, int n3) {
        if (l == 0L && l2 == 0L) {
            this.controller.receivedDeviceDeactivation();
        }
        if (!this.isUpdateRelevant("updateActiveMedia", this.controller.getInstanceID(), n3)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$13(this, new Buffer().append(this.logPrefixDispatcher).append("updateActiveMedia (deviceID='").append(l).append("',mediaID='").append(l2).append("')").toString(), l, l2, n, n2));
    }

    @Override
    public void updateActiveSubtitle(int n, int n2) {
        if (!this.isUpdateRelevant("updateActiveSubtitle", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$14(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateActiveSubtitle").toString(), n));
    }

    @Override
    public void updateActiveVideoAngle(int n, int n2) {
        if (!this.isUpdateRelevant("updateActiveVideoAngle", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$15(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateActiveVideoAngle").toString(), n));
    }

    @Override
    public void updateAudioStreamList(AudioStream[] audioStreamArray, int n) {
        if (!this.isUpdateRelevant("updateAudioStreamList", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$16(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateAudioStreamList").toString(), audioStreamArray));
    }

    @Override
    public void updateCapabilities(Capabilities capabilities, int n) {
        if (!this.isUpdateRelevant("updateCapabilities", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$17(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateCapabilities").toString(), capabilities));
    }

    @Override
    public void updateCmdBlockingMask(int n, int n2) {
        if (!this.isUpdateRelevant("updateCmdBlockingMask", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$18(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateCmdBlockingMask").toString(), n));
    }

    @Override
    public void updateNumVideoAngles(int n, int n2) {
        if (!this.isUpdateRelevant("updateNumVideoAngles", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$19(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateNumVideoAngles").toString(), n));
    }

    @Override
    public void updatePlayPosition(long l, int n, int n2, int n3) {
        if (n3 == 2) {
            this.resetTimePosValues();
            this.dispatcher.execute(new MediaDSIPlayerListener$20(this, new StringBuffer().append(this.logPrefixDispatcher).append("updatePlayPosition (INVALID)").toString()));
            return;
        }
        if (!this.isUpdateRelevant("updatePlayPosition", this.controller.getInstanceID(), n3)) {
            return;
        }
        int n4 = n / 1000;
        int n5 = n2 > 0 ? n2 / 1000 : n2;
        boolean bl = n4 == this.currentTimePos && n5 == this.currentTotalTime && this.currentEntryID == l;
        this.currentTimePos = n4;
        this.currentTotalTime = n5;
        this.currentEntryID = l;
        if (this.dsiPeriodic.isInfo()) {
            String string = new Buffer().append("entryID='").append(l).append("',timePos='").append(n).append("',totalTime='").append(n2).append("',").append("changed='").append(!bl).append("'").toString();
            this.dsiPeriodic.log(1078071040, "[%1.updatePlayPosition] [%2] %3", (Object)"MediaDSIPlayerListener", (Object)new Integer(this.controller.getInstanceID()), (Object)string);
        }
        if (bl) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$21(this, new Buffer().append(this.logPrefixDispatcher).append("updatePlayPosition (entryID='").append(l).append("',pos='").append(this.currentTimePos).append("',total='").append(this.currentTotalTime).append("')").toString(), l, n4, n5));
    }

    @Override
    public void updatePlayViewSize(int n, int n2, int n3) {
        if (n3 == 2) {
            this.dispatcher.execute(new MediaDSIPlayerListener$22(this, new StringBuffer().append(this.logPrefixDispatcher).append("updatePlayViewSize (INVALID)").toString()));
            return;
        }
        if (!this.isUpdateRelevant("updatePlayViewSize", this.controller.getInstanceID(), n3)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$23(this, new Buffer().append(this.logPrefixDispatcher).append("updatePlayViewSize ('").append(n).append("')").toString(), n, n2));
    }

    @Override
    public void updatePlaybackFolder(ListEntry[] listEntryArray, int n) {
        if (!this.isUpdateRelevant("updatePlaybackFolder", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$24(this, new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackFolder").toString(), listEntryArray));
    }

    @Override
    public void updatePlaybackMode(int n, int n2) {
        if (!this.isUpdateRelevant("updatePlaybackMode", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$25(this, new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackMode").toString(), n));
    }

    @Override
    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray, int n) {
        if (!this.isUpdateRelevant("updatePlaybackModeList", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$26(this, new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackModeList").toString(), playbackModeArray));
    }

    @Override
    public void updatePlaybackState(int n, int n2) {
        if (!this.isUpdateRelevant("updatePlaybackState", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$27(this, new StringBuffer().append(this.logPrefixDispatcher).append("updatePlaybackState").toString(), n));
    }

    @Override
    public void updateSubtitleList(int[] nArray, int n) {
        if (!this.isUpdateRelevant("updateSubtitleList", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$28(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateSubtitleList").toString(), nArray));
    }

    @Override
    public void updateVideoFormat(int n, int n2) {
        if (!this.isUpdateRelevant("updateVideoFormat", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$29(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateVideoFormat").toString(), n));
    }

    @Override
    public void updateVideoNorm(int n, int n2) {
        if (!this.isUpdateRelevant("updateVideoNorm", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIPlayerListener$30(this, new StringBuffer().append(this.logPrefixDispatcher).append("updateVideoNorm").toString(), n));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.dispatcher.execute(new MediaDSIPlayerListener$31(this, new StringBuffer().append(this.logPrefixDispatcher).append("asyncException").toString(), n, n2, string));
    }

    private void resetTimePosValues() {
        this.currentTimePos = -1;
        this.currentTotalTime = -1;
        this.currentEntryID = -1L;
    }

    public void responseFidForPlaylistEntryID(long l, long l2) {
        this.dispatcher.execute(new MediaDSIPlayerListener$32(this, l, l2));
    }

    @Override
    public void updatePlaybackContentFolder(ListEntry[] listEntryArray, int n) {
    }

    static /* synthetic */ MediaDSIPlayerControllerImpl access$000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.controller;
    }

    static /* synthetic */ LogChannel access$100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$1900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ String access$2100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logPrefixResponsePlayView;
    }

    static /* synthetic */ LogChannel access$2200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$2900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ void access$3400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        mediaDSIPlayerListener.resetTimePosValues();
    }

    static /* synthetic */ LogChannel access$3500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$3900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$4900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$5900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6500(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6600(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6700(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6800(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$6900(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$7000(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$7100(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$7200(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$7300(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }

    static /* synthetic */ LogChannel access$7400(MediaDSIPlayerListener mediaDSIPlayerListener) {
        return mediaDSIPlayerListener.logger;
    }
}

