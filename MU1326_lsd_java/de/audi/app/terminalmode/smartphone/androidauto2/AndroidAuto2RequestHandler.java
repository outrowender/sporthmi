/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.dsi.androidauto2.DSIAndroidAuto2DefaultListener;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.androidauto2.IAndroidAuto2RequestHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.audio.IAndroidAuto2AudioHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.mic.IAndroidAuto2MicHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.nav.IAndroidAuto2NavHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.video.IAndroidAuto2VideoHandler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.IDispatcher;

public final class AndroidAuto2RequestHandler
extends DSIAndroidAuto2DefaultListener
implements IAndroidAuto2RequestHandler {
    private static final String LOGCLASS;
    private final LogChannel lc;
    private final IAndroidAuto2MicHandler micHandler;
    private final IAndroidAuto2NavHandler navHandler;
    private final IAndroidAuto2VideoHandler videoHandler;
    private final IAndroidAuto2AudioHandler audioHandler;
    private final AbstractCommand[][] audioFocusCommands = new AbstractCommand[0][];

    public AndroidAuto2RequestHandler(IStateHandler iStateHandler, LogChannel logChannel, IDispatcher iDispatcher, CommandListHelper commandListHelper, IAndroidAuto2MicHandler iAndroidAuto2MicHandler, IAndroidAuto2NavHandler iAndroidAuto2NavHandler, IAndroidAuto2VideoHandler iAndroidAuto2VideoHandler, IAndroidAuto2AudioHandler iAndroidAuto2AudioHandler) {
        this.lc = logChannel;
        this.micHandler = iAndroidAuto2MicHandler;
        this.navHandler = iAndroidAuto2NavHandler;
        this.videoHandler = iAndroidAuto2VideoHandler;
        this.audioHandler = iAndroidAuto2AudioHandler;
    }

    @Override
    public void responseUpdateMode(TMState tMState, long l) {
        this.audioHandler.responseUpdateMode(tMState);
        if (tMState.getOwnerForResource(Resource.SCREEN).is(ResourceOwner.DEVICE)) {
            this.videoHandler.updateVideoState(true);
        } else if (tMState.getOwnerForResource(Resource.SCREEN).is(ResourceOwner.MAINUNIT)) {
            this.videoHandler.updateVideoState(false);
        }
        if (tMState.getOwnerForResource(Resource.AUDIO_SPEECH).is(ResourceOwner.DEVICE)) {
            this.micHandler.microphoneUpdate(true);
        } else if (tMState.getOwnerForResource(Resource.AUDIO_SPEECH).is(ResourceOwner.MAINUNIT)) {
            this.micHandler.microphoneUpdate(false);
        }
        this.navHandler.updateNavFocus(tMState.getOwnerForApplication(Application.NAVI));
    }

    @Override
    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
        if (tMState.getOwnerForResource(Resource.AUDIO_MEDIA).is(ResourceOwner.DEVICE)) {
            this.audioHandler.updateEntertainmentAudioState(true);
        } else if (tMState.getOwnerForResource(Resource.AUDIO_MEDIA).is(ResourceOwner.MAINUNIT)) {
            this.audioHandler.updateEntertainmentAudioState(false);
        }
        if (tMState.getOwnerForResource(Resource.SCREEN).is(ResourceOwner.DEVICE)) {
            this.videoHandler.updateVideoState(true);
        } else if (tMState.getOwnerForResource(Resource.SCREEN).is(ResourceOwner.MAINUNIT)) {
            this.videoHandler.updateVideoState(false);
        }
        if (tMState.getOwnerForResource(Resource.AUDIO_SPEECH).is(ResourceOwner.DEVICE)) {
            this.micHandler.microphoneUpdate(true);
        } else if (tMState.getOwnerForResource(Resource.AUDIO_SPEECH).is(ResourceOwner.MAINUNIT)) {
            this.micHandler.microphoneUpdate(false);
        }
        this.navHandler.updateNavFocus(tMState.getOwnerForApplication(Application.NAVI));
        if (null != iDSISmartphoneManager$RequestModeChangeCallback) {
            iDSISmartphoneManager$RequestModeChangeCallback.modeChanged();
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "<- [%1.asyncException] errCode='%2' msg='%3' requestType='%4'", (Object)"AndroidAuto2RequestHandler", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }
}

