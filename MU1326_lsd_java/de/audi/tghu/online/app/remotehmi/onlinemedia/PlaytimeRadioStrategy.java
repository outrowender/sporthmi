/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;

public class PlaytimeRadioStrategy
implements IPlaytimeStrategy {
    LogChannel logChannel;
    final RemoteHMIService remoteHmiService;

    public PlaytimeRadioStrategy(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(10000000, "PlaytimeRadioStrategy#updatePlayPosition update ignored");
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
        iViewNpsListenerInterface.setRadioMode(true);
        int n = iOnlineMediaSession.getBufferLevel();
        iViewNpsListenerInterface.updateBufferState(n);
        iViewNpsListenerInterface.setBufferState(iOnlineMediaSession.getBufferStatus());
        this.logChannel.log(1000000, "PlaytimeSingleTrackStrategy#updateBufferState: new buffer state: %1", (long)n);
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
            PlaytimeRadioStrategy.this.updateBufferState(this.session);
        }
    }
}

