/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelSearchCmd;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.search.DSISearch;

public class TelSearchPrepareSourcesCmd
extends AbstractTelSearchCmd {
    private final int[] sources;

    public TelSearchPrepareSourcesCmd(LogChannel logChannel, DSISearch dSISearch, int[] nArray) {
        super(logChannel, "TelSearchPrepareSourcesCmd", dSISearch);
        this.sources = nArray;
    }

    @Override
    public void execute() {
        if (this.dsiSearch != null) {
            this.logger.log(1078071040, "[TelSearchPrepareSourcesCmd#execute] sources=%1", (Object)Converter.array2String(this.sources));
            this.dsiSearch.prepareSources(this.sources);
        } else {
            this.logger.log(-1601830656, "[TelSearchPrepareSourcesCmd#execute] DSISearch is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void prepareSourcesResult(int n) {
        this.logger.log(1078071040, "[TelSearchPrepareSourcesCmd#prepareSourcesResult] success=%1", (long)n);
        this.getCommandList().commandFinished();
    }
}

