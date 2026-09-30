/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2.video;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.androidauto2.AbstractAndroidAuto2Handler;
import de.audi.app.terminalmode.smartphone.androidauto2.video.IAndroidAuto2VideoHandler;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;

public class AndroidAuto2VideoHandler
extends AbstractAndroidAuto2Handler
implements IAndroidAuto2VideoHandler,
TimerListener {
    private static final String LOGCLASS = "AndroidAuto2VideoHandler";
    private final Timer videoAvailableTimer = new Timer("VideoAvailableTimer", 3000L, true, this);
    private volatile boolean videoAvailable;
    private volatile boolean videoState;

    public AndroidAuto2VideoHandler(LogChannel logChannel, DSIAndroidAuto2 dSIAndroidAuto2, IStateHandler iStateHandler, IContext iContext) {
        super(logChannel, dSIAndroidAuto2, iStateHandler, iContext);
    }

    public void updateVideoState(boolean bl) {
        this.logger.log(1000000, "[%1.updateVideoState] %2", (Object)LOGCLASS, (Object)new Boolean(bl));
        if (this.videoState == bl) {
            return;
        }
        if (bl) {
            this.dsi.videoFocusNotification(1, true);
            this.videoAvailableTimer.start();
        } else {
            this.dsi.videoFocusNotification(2, true);
            this.videoAvailableTimer.cancel();
        }
        this.videoState = bl;
    }

    public void videoFocusRequestNotification(int n, int n2) {
        if (this.isValid(n2)) {
            if (1 == n) {
                this.logger.log(1000000, "<- [%1.videoFocusRequestNotification]", (Object)LOGCLASS);
                if (!this.videoAvailable) {
                    this.videoAvailableTimer.start();
                }
            }
            this.requestDSIUpdate(Resource.SCREEN, 1 == n ? ResourceOwner.DEVICE : ResourceOwner.MAINUNIT);
        }
    }

    public void fireTimer(Timer timer) {
        this.logger.log(1000000, "[%1.fireTimer] Change notification resource.", (Object)LOGCLASS);
        this.requestDSIUpdate(Resource.NOTIFICATION, ResourceOwner.MAINUNIT);
    }

    public void cancelTimer(Timer timer) {
    }

    public void videoAvailable(boolean bl, int n) {
        if (!this.isValid(n)) {
            this.logger.log(1000000, "<- [%1.videoAvailable] Invalid.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "<- [%1.videoAvailable] %2", (Object)LOGCLASS, (Object)Boolean.toString(bl));
        this.videoAvailable = bl;
        if (bl) {
            this.videoAvailableTimer.cancel();
            this.requestDSIUpdate(Resource.NOTIFICATION, ResourceOwner.DEVICE);
        } else if (this.videoState) {
            this.requestDSIUpdate(Resource.NOTIFICATION, ResourceOwner.MAINUNIT);
        }
    }

    protected String getLogClass() {
        return LOGCLASS;
    }
}

