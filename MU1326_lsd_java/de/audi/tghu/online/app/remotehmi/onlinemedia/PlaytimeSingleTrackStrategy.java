/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.media.IMediaValues;
import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;
import de.audi.tghu.online.app.remotehmi.util.UtilOnline;

public class PlaytimeSingleTrackStrategy
implements IPlaytimeStrategy {
    private static final int TIMEOUT_TIME_ID_MATCHING = 3;
    final LogChannel logChannel;
    final RemoteHMIService remoteHmiService;
    private long lastMatchTime;

    public PlaytimeSingleTrackStrategy(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        if (logChannel == null || remoteHMIService == null) {
            UtilOnline.validateArgumentNotNull(logChannel, "log");
            UtilOnline.validateArgumentNotNull(remoteHMIService, "remoteHmiService");
        }
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    public void updatePlayPosition(int n, int n2) {
        this.remoteHmiService.execute(new UpdatePlayTimeTask("update-play-position", n, n2));
    }

    private void updatePlayTime(int n, int n2) {
        this.logChannel.log(10000000, "PlaytimeSingleTrackStrategy#updatePlayTime timePlaying = %1, timeTotal = %2, new trackId=%3", (long)n, (long)n2);
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        if (iViewNpsListenerInterface == null) {
            this.logChannel.log(100000, "PlaytimeSingleTrackStrategy#updatePlayTime: no HMIViewGridListener/NPS listener available");
            return;
        }
        IMediaValues iMediaValues = iViewNpsListenerInterface.getMediaValues();
        iMediaValues.setTimeTotal(n2);
        iMediaValues.setTimePlaying(n);
        iViewNpsListenerInterface.setRadioMode(n2 == 0);
        iViewNpsListenerInterface.updateTimeValues();
        AbstractHMIViewListener abstractHMIViewListener = this.remoteHmiService.getViewListener(13000);
        if (abstractHMIViewListener == null) {
            this.logChannel.log(1000000, "PlaytimeSingleTrackStrategy#updatePlayTime: no HMIViewGridListener available.");
            return;
        }
        IGridList iGridList = abstractHMIViewListener.getCurrentGridList();
        if (iGridList == null) {
            this.logChannel.log(1000000, "PlaytimeSingleTrackStrategy#updatePlayTime: no grid list available. ");
            return;
        }
        if (iGridList.getViewType() != 1) {
            this.logChannel.log(1000000, "PlaytimeSingleTrackStrategy#updatePlayTime: grid list is not of type media. ");
            return;
        }
        iGridList.setMediaGridValues(iMediaValues);
        abstractHMIViewListener.renderGridList(3, 4);
    }

    public void updateBufferPosition(IOnlineMediaSession iOnlineMediaSession) {
        this.remoteHmiService.execute(new UpdateBufferPositionTask("update-buffer-position", iOnlineMediaSession));
    }

    private void updateBufferState(IOnlineMediaSession iOnlineMediaSession) {
        this.logChannel.log(1000000, "PlaytimeSingleTrackStrategy#updateBufferState fillstate");
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        if (iViewNpsListenerInterface == null) {
            this.logChannel.log(10000, "PlaytimeSingleTrackStrategy#updateBufferState: no NPS listener available");
            return;
        }
        iViewNpsListenerInterface.setRadioMode(false);
        int n = iOnlineMediaSession.getBufferLevel();
        iViewNpsListenerInterface.updateBufferState(n);
        iViewNpsListenerInterface.setBufferState(iOnlineMediaSession.getBufferStatus());
        this.logChannel.log(1000000, "PlaytimeSingleTrackStrategy#updateBufferState: new buffer state: %1", (long)n);
    }

    public class UpdatePlayTimeTask
    extends AbstractRemoteHMITask {
        int timePlaying;
        int timeTotal;

        public UpdatePlayTimeTask(String string, int n, int n2) {
            super(string);
            this.timePlaying = n;
            this.timeTotal = n2;
        }

        public void run() {
            PlaytimeSingleTrackStrategy.this.updatePlayTime(this.timePlaying, this.timeTotal);
        }

        public boolean isCoalescable() {
            return true;
        }

        public Long getDelayMillis() {
            return new Long(0L);
        }

        public boolean coalesceWith(RemoteHMITask remoteHMITask) {
            if (!(remoteHMITask instanceof UpdatePlayTimeTask)) {
                return false;
            }
            PlaytimeSingleTrackStrategy.this.logChannel.log(1000000, "UpdatePlayTimeTask#coalesceWith: avoided update of playtime: %1", (long)((UpdatePlayTimeTask)remoteHMITask).timePlaying);
            return true;
        }
    }

    public class UpdateBufferPositionTask
    extends AbstractRemoteHMITask {
        IOnlineMediaSession session;

        public UpdateBufferPositionTask(String string, IOnlineMediaSession iOnlineMediaSession) {
            super(string);
            this.session = iOnlineMediaSession;
        }

        public boolean isCoalescable() {
            return true;
        }

        public Long getDelayMillis() {
            return new Long(500L);
        }

        public void run() {
            PlaytimeSingleTrackStrategy.this.updateBufferState(this.session);
        }
    }
}

