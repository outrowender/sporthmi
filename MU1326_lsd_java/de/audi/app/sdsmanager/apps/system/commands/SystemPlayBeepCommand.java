/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemPlayBeepCommand
extends AbstractSystemCallCommand {
    private final SpeechTTSHandler ttsHandler;
    private final int beepValue;
    private static final int[][] PARAMETER_TO_DSIBEEPVALUES = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}};

    public SystemPlayBeepCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SpeechTTSHandler speechTTSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.ttsHandler = speechTTSHandler;
        this.beepValue = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        int n = SDSUtils.translate(this.beepValue, PARAMETER_TO_DSIBEEPVALUES);
        if (n == Integer.MIN_VALUE) {
            this.sendResult(3001);
            return;
        }
        this.ttsHandler.playTone(n);
    }

    public void toneFinished() {
        this.sendResult(3000);
    }
}

