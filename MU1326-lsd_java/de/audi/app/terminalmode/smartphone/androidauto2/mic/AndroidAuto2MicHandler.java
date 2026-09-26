/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2.mic;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.androidauto2.AbstractAndroidAuto2Handler;
import de.audi.app.terminalmode.smartphone.androidauto2.mic.IAndroidAuto2MicHandler;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;

public class AndroidAuto2MicHandler
extends AbstractAndroidAuto2Handler
implements IAndroidAuto2MicHandler {
    private static final String LOGCLASS;
    private volatile boolean micState = false;
    private volatile boolean unsolicited = true;

    public AndroidAuto2MicHandler(LogChannel logChannel, DSIAndroidAuto2 dSIAndroidAuto2, IStateHandler iStateHandler, IContext iContext) {
        super(logChannel, dSIAndroidAuto2, iStateHandler, iContext);
    }

    @Override
    public void microphoneUpdate(boolean bl) {
        if (this.micState == bl) {
            return;
        }
        this.logger.log(1078071040, "[%1.microphoneUpdate] %2", (Object)"AndroidAuto2MicHandler", (Object)(bl ? "OPEN" : "CLOSE"));
        if (bl) {
            this.dsi.microphoneNotification(1, this.unsolicited);
        } else {
            this.dsi.microphoneNotification(2, this.unsolicited);
        }
        this.unsolicited = true;
        this.micState = bl;
    }

    @Override
    public void microphoneRequestNotification(int n, int n2) {
        if (this.isValid(n2)) {
            this.logger.log(1078071040, "<- [%1.microphoneRequestNotification] %2", (Object)"AndroidAuto2MicHandler", (Object)this.getMicrophoneState(n));
            if (n == 1) {
                this.requestDSIUpdate(Resource.AUDIO_SPEECH, ResourceOwner.DEVICE);
            } else {
                this.requestDSIUpdate(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT);
            }
            this.unsolicited = false;
        }
    }

    private String getMicrophoneState(int n) {
        switch (n) {
            case 1: {
                return "MIC_OPEN";
            }
            case 2: {
                return "MIC_CLOSE";
            }
        }
        return new StringBuffer().append("MIC_UNKNOWN ").append(n).toString();
    }

    @Override
    protected String getLogClass() {
        return "AndroidAuto2MicHandler";
    }
}

