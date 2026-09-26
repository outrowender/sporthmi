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
    private static final String LOGCLASS;
    private final IAndroidAuto2AudioHandler callbackHandler;

    public AudioDuckResponse(LogChannel logChannel, IContext iContext, IAndroidAuto2AudioHandler iAndroidAuto2AudioHandler) {
        super(logChannel, "AudioDuckResponse", iContext);
        this.callbackHandler = iAndroidAuto2AudioHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1.execute]", (Object)"AudioDuckResponse");
        this.callbackHandler.responseUpdateMode();
        this.getCommandList().commandFinished();
    }
}

