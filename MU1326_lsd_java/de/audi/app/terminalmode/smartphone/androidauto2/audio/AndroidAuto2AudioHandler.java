/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2.audio;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.smartphone.androidauto2.AbstractAndroidAuto2Handler;
import de.audi.app.terminalmode.smartphone.androidauto2.audio.AudioDuckResponse;
import de.audi.app.terminalmode.smartphone.androidauto2.audio.IAndroidAuto2AudioHandler;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AudioLowering;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;

public class AndroidAuto2AudioHandler
extends AbstractAndroidAuto2Handler
implements IAndroidAuto2AudioHandler {
    private static final String LOGCLASS;
    private volatile int audioRequest;
    private volatile int currentAudioState;
    private volatile boolean currentEntertainmentFocus;
    private final IAudioConnectionHandle duckAudioCompletelyAudioConnectionHandle;
    private final IEventBus eventBus;

    public AndroidAuto2AudioHandler(LogChannel logChannel, DSIAndroidAuto2 dSIAndroidAuto2, IStateHandler iStateHandler, IContext iContext, IEventBus iEventBus) {
        super(logChannel, dSIAndroidAuto2, iStateHandler, iContext);
        this.duckAudioCompletelyAudioConnectionHandle = iContext.getAudioManager().createAudioConnectionHandle(TMAudioConnection.SPEECH_GUIDANCE);
        this.eventBus = iEventBus;
        this.currentAudioState = 3;
        this.currentEntertainmentFocus = false;
    }

    @Override
    protected String getLogClass() {
        return "AndroidAuto2AudioHandler";
    }

    @Override
    public void audioAvailable(int n, boolean bl, int n2) {
        if (this.isValid(n2)) {
            this.logger.log(1078071040, "[%1.audioAvailable] %2 %3", (Object)"AndroidAuto2AudioHandler", (Object)new Integer(n), (Object)new Boolean(bl));
            if (7 == this.currentAudioState) {
                return;
            }
            if (n == 1) {
                if (bl) {
                    this.duckAudio(500, 0.2);
                } else {
                    this.unduckAudio(500);
                }
            }
            if (0 == n && 1 == this.currentAudioState) {
                this.eventBus.mediaAudioAvailable(bl);
            }
        }
    }

    @Override
    public void updateEntertainmentAudioState(boolean bl) {
        if (this.currentEntertainmentFocus == bl) {
            this.logger.log(1078071040, "[%1.updateEntertainmentAudioState] entertainment focus not changed.", (Object)"AndroidAuto2AudioHandler");
            return;
        }
        if (bl) {
            this.currentAudioState = 1;
            this.dsi.audioFocusNotification(1, true);
        } else if (this.currentAudioState == 1) {
            this.currentAudioState = 3;
            this.dsi.audioFocusNotification(3, true);
        }
        this.logger.log(1078071040, "[%1.updateEntertainmentAudioState] audioFocusState=%2", (Object)"AndroidAuto2AudioHandler", (Object)this.getAudioStateString(this.currentAudioState));
        this.currentEntertainmentFocus = bl;
    }

    @Override
    public void responseUpdateMode(TMState tMState) {
        this.responseUpdateMode();
    }

    @Override
    public void responseUpdateMode() {
        int n = this.currentAudioState;
        if (1 == this.audioRequest) {
            n = 1;
            this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PLAYING));
        } else if (2 == this.audioRequest) {
            n = 7;
        } else if (3 == this.audioRequest) {
            n = 7;
        } else if (4 == this.audioRequest) {
            n = 3;
            this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PAUSED));
        }
        if (this.currentAudioState == n && 0 == this.audioRequest) {
            this.logger.log(1078071040, "[%1.responseUpdateMode] No audio update", (Object)"AndroidAuto2AudioHandler");
            return;
        }
        this.currentEntertainmentFocus = 1 == n;
        this.currentAudioState = n;
        this.audioRequest = 0;
        this.logger.log(1078071040, "[%1.responseUpdateMode] audioFocusState=%2", (Object)"AndroidAuto2AudioHandler", (Object)this.getAudioStateString(n));
        this.dsi.audioFocusNotification(n, false);
    }

    @Override
    public void audioFocusRequestNotification(int n, int n2) {
        if (this.isValid(n2)) {
            this.logger.log(1078071040, "<- [%1.audioFocusRequestNotification] %2", (Object)"AndroidAuto2AudioHandler", (Object)this.getAudioFocusString(n));
            this.audioRequest = n;
            switch (n) {
                case 1: {
                    this.requestDSIUpdate(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
                    this.releaseDuckAudioCompletely();
                    break;
                }
                case 2: {
                    this.duckAudioCompletely();
                    break;
                }
                case 3: {
                    this.duckAudio(500, 0.2);
                    break;
                }
                case 4: {
                    this.requestDSIUpdate(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT);
                    this.releaseDuckAudioCompletely();
                    this.unduckAudio(500);
                    break;
                }
            }
        }
    }

    private void duckAudio(int n, double d2) {
        this.logger.log(1078071040, "[%1.duckAudio]", (Object)"AndroidAuto2AudioHandler");
        this.context.getCommandListHelper().create().addSingle(new AudioLowering(this.context, true, n)).addSingle(new AudioDuckResponse(this.logger, this.context, this)).execute("AndroidAuto2AudioHandler.duckAudio");
    }

    private void unduckAudio(int n) {
        this.logger.log(1078071040, "[%1.unduckAudio]", (Object)"AndroidAuto2AudioHandler");
        this.context.getCommandListHelper().create().addSingle(new AudioLowering(this.context, false, n)).addSingle(new AudioDuckResponse(this.logger, this.context, this)).execute("AndroidAuto2AudioHandler.unduckAudio");
    }

    private void duckAudioCompletely() {
        this.logger.log(1078071040, "[%1.duckAudioCompletely]", (Object)"AndroidAuto2AudioHandler");
        this.context.getCommandListHelper().create().addSingle(this.duckAudioCompletelyAudioConnectionHandle.createRequestCommand(false)).addSingle(new AudioDuckResponse(this.logger, this.context, this)).execute("AndroidAuto2AudioHandler.duckAudioCompletely");
    }

    private void releaseDuckAudioCompletely() {
        this.logger.log(1078071040, "[%1.releaseDuckAudioCompletely]", (Object)"AndroidAuto2AudioHandler");
        this.context.getCommandListHelper().create().addSingle(this.duckAudioCompletelyAudioConnectionHandle.createReleaseCommand()).addSingle(new AudioDuckResponse(this.logger, this.context, this)).execute("AndroidAuto2AudioHandler.releaseDuckAudioCompletely");
    }

    private String getAudioFocusString(int n) {
        switch (n) {
            case 1: {
                return "GAIN";
            }
            case 2: {
                return "GAIN_TRANSIENT";
            }
            case 3: {
                return "GAIN_TRANSIENT_MAY_DUCK";
            }
            case 4: {
                return "RELEASE";
            }
        }
        return "UNKNOWN";
    }

    private String getAudioStateString(int n) {
        switch (n) {
            case 1: {
                return "GAIN";
            }
            case 6: {
                return "GAIN_MEDIA_ONLY";
            }
            case 2: {
                return "GAIN_TRANSIENT";
            }
            case 7: {
                return "GAIN_TRANSIENT_GUIDANCE_ONLY";
            }
            case 3: {
                return "LOSS";
            }
            case 5: {
                return "LOSS_TRANSIENT";
            }
            case 4: {
                return "LOSS_TRANSIENT_CAN_DUCK";
            }
        }
        return "UNKNOWN";
    }
}

