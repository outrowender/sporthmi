/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2.audio;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.androidauto2.audio.IAndroidAuto2AudioHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;

public class AudioDuckResponse
extends AbstractCommand {
    private static final String LOGCLASS = "AudioDuckResponse";
    private final IAndroidAuto2AudioHandler callbackHandler;

    public AudioDuckResponse(LogChannel logChannel, IContext iContext, IAndroidAuto2AudioHandler iAndroidAuto2AudioHandler) {
        super(logChannel, LOGCLASS, iContext);
        this.callbackHandler = iAndroidAuto2AudioHandler;
    }

    public void execute() {
        this.logger.log(10000000, "[%1.execute]", (Object)LOGCLASS);
        this.callbackHandler.responseUpdateMode();
        this.getCommandList().commandFinished();
    }
}

