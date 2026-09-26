/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeRadioStrategy$UpdateBufferPositionTask;

public class PlaytimeRadioStrategy
implements IPlaytimeStrategy {
    LogChannel logChannel;
    final RemoteHMIService remoteHmiService;

    public PlaytimeRadioStrategy(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(-2137614336, "PlaytimeRadioStrategy#updatePlayPosition update ignored");
    }

    @Override
    public void updateBufferPosition(IOnlineMediaSession iOnlineMediaSession) {
        this.remoteHmiService.execute(new PlaytimeRadioStrategy$UpdateBufferPositionTask(this, "update-buffer-position", iOnlineMediaSession));
    }

    private void updateBufferState(IOnlineMediaSession iOnlineMediaSession) {
        this.logChannel.log(1078071040, "PlaytimeSingleTrackStrategy#updateBufferState fillstate");
        IViewNpsListenerInterface iViewNpsListenerInterface = (IViewNpsListenerInterface)((Object)this.remoteHmiService.getViewListener(15000));
        if (iViewNpsListenerInterface == null) {
            this.logChannel.log(10000, "PlaytimeSingleTrackStrategy#updateBufferState: no NPS listener available");
            return;
        }
        iViewNpsListenerInterface.setRadioMode(true);
        int n = iOnlineMediaSession.getBufferLevel();
        iViewNpsListenerInterface.updateBufferState(n);
        iViewNpsListenerInterface.setBufferState(iOnlineMediaSession.getBufferStatus());
        this.logChannel.log(1078071040, "PlaytimeSingleTrackStrategy#updateBufferState: new buffer state: %1", (long)n);
    }

    static /* synthetic */ void access$000(PlaytimeRadioStrategy playtimeRadioStrategy, IOnlineMediaSession iOnlineMediaSession) {
        playtimeRadioStrategy.updateBufferState(iOnlineMediaSession);
    }
}

