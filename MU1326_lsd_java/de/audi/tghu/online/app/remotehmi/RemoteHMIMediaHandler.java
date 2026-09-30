/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIMediaHandler
extends AbstractRemoteHMIComponent {
    public static final String MEDIA_TYPE_AUDIO = "audio";
    public static final String MEDIA_TYPE_VIDEO = "video";
    private IMediaService mediaService;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
    }

    public IMediaService getMediaService() {
        return this.mediaService;
    }

    public void play(String string, String string2, AbstractHMIViewListener abstractHMIViewListener) {
    }

    private void processPlayPositionOM(int n, int n2) {
        AbstractHMIViewListener abstractHMIViewListener = this.remoteHmiService.getCurrentView();
    }

    protected void processPlayPosition(int n, int n2) {
        AbstractHMIViewListener abstractHMIViewListener = this.remoteHmiService.getCurrentView();
        if (abstractHMIViewListener.getReceiveMediaUpdates()) {
            RemoteHMIAction remoteHMIAction = abstractHMIViewListener.getAction(550);
            HMIProperties hMIProperties = remoteHMIAction.getParameters();
            hMIProperties.putInt("mediaPositionCurrent", n);
            hMIProperties.putInt("mediaPositionTotal", n2);
            abstractHMIViewListener.invokeAction(remoteHMIAction);
        }
    }

    public void abort() {
        this.logChannel.log(10000000, "RemoteHMIMediaHandler#abort");
    }

    public void pause() {
        this.logChannel.log(10000000, "RemoteHMIMediaHandler#pause");
    }

    public void resume() {
        this.logChannel.log(10000000, "RemoteHMIMediaHandler#resume");
    }

    public void activateBluetooth() {
        this.logChannel.log(100000, "RemoteHMIMediaHandler#activateBluetooth: called");
        IMediaService iMediaService = this.getMediaService();
        if (iMediaService != null) {
            iMediaService.activateSource(11, 0);
        }
    }

    public void setMediaService(IMediaService iMediaService) {
        this.mediaService = iMediaService;
    }

    public void onExit() {
        this.abort();
    }
}

