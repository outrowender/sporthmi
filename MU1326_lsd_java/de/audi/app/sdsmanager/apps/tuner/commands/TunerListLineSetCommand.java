/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;

public class TunerListLineSetCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;
    private final TunerService tunerService;
    private final int[][] rowType2response = new int[][]{{0, 10008}, {1, 10011}, {2, 10010}};

    public TunerListLineSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, TunerService tunerService) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
        this.tunerService = tunerService;
    }

    @Override
    public void execute() {
        int n = SDSModelAccess.getEnumerationNumberStatus();
        this.logger.log(-2137614336, "%1#execute: lineNumber=%2", (Object)this.getName(), (long)n);
        byte by = this.tunerService.getTypeOfListRow(n);
        this.logger.log(-2137614336, "%1#execute: type of row=%2", (Object)this.getName(), (long)by);
        int n2 = SDSUtils.translate((int)by, this.rowType2response);
        if (n2 == 128) {
            this.logger.log(-1601830656, "%1#execute: no response event found for row type -> sending error", (Object)this.getName());
            this.sendResult(10005);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: send item selection for line %2 (0-based) with ok-event %3", (Object)this.getName(), (long)n, (long)n2);
        int[] nArray = new int[]{n2, 10006, 10005};
        this.hmiService.fireSDSEvent(2, 6, n, nArray);
    }
}

