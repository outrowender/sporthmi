/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl;

import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;

public class SwdlJoinedDownloadStateEvo
extends AbstractSwdlJoinedDownloadState {
    public SwdlJoinedDownloadStateEvo(SwdlEnv swdlEnv) {
        super(swdlEnv);
    }

    @Override
    protected void fireSMEventEnter(int n) {
        this.getHMIService().fireSMEvent(n, -12);
    }

    @Override
    protected void fireSMEventExit(int n) {
        this.getHMIService().fireSMEvent(n, -14);
    }
}

