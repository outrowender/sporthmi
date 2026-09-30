/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2.voice;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.androidauto2.AbstractAndroidAuto2Handler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;

public class AndroidAuto2VoiceSessionHandler
extends AbstractAndroidAuto2Handler {
    private static final String LOGCLASS = "AndroidAuto2VoiceSessionHandler";

    public AndroidAuto2VoiceSessionHandler(LogChannel logChannel, DSIAndroidAuto2 dSIAndroidAuto2, IStateHandler iStateHandler, IContext iContext) {
        super(logChannel, dSIAndroidAuto2, iStateHandler, iContext);
    }

    protected String getLogClass() {
        return LOGCLASS;
    }

    public void voiceSessionNotification(int n, int n2) {
        if (this.isValid(n2)) {
            this.logger.log(1000000, "<- [%1.voiceSessionNotification] %2", (Object)LOGCLASS, (Object)this.getVoiceSessionStatus(n));
            if (1 == n) {
                this.requestDSIUpdate(Application.SPEECH, ApplicationOwner.DEVICE);
            } else if (2 == n) {
                this.requestDSIUpdate(Application.SPEECH, ApplicationOwner.NOBODY);
            }
        }
    }

    private String getVoiceSessionStatus(int n) {
        switch (n) {
            case 1: {
                return "VS_START";
            }
            case 2: {
                return "VS_END";
            }
        }
        return "VS_UNKNOWN " + n;
    }
}

