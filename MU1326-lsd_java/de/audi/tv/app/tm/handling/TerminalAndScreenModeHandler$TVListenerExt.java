/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$1;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$Properties;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;
import org.dsi.ifc.tvtuner.StartUpConfig;

class TerminalAndScreenModeHandler$TVListenerExt
extends DefaultTVListener {
    private final /* synthetic */ TerminalAndScreenModeHandler this$0;

    private TerminalAndScreenModeHandler$TVListenerExt(TerminalAndScreenModeHandler terminalAndScreenModeHandler) {
        this.this$0 = terminalAndScreenModeHandler;
    }

    @Override
    public void updateTerminalMode(int n, int n2) {
        TerminalAndScreenModeHandler$Properties.access$500(TerminalAndScreenModeHandler.access$400(this.this$0)).accept(new TerminalAndScreenModeTuple(n, n2));
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        int n = -1;
        if (startUpConfig.tmDatabroadDVBAvail) {
            n = 2;
        } else if (startUpConfig.tmDatabroadATSCAvail) {
            n = 6;
        } else if (startUpConfig.tmDatabroadISDBAvail) {
            n = 3;
        } else if (startUpConfig.tmDatabroadDMBAvail) {
            n = 5;
        } else if (startUpConfig.tmDatabroadDTMBAvail) {
            n = 4;
        } else if (startUpConfig.tmDatabroad1Avail) {
            n = 7;
        } else if (startUpConfig.tmDatabroad2Avail) {
            n = 8;
        }
        TerminalAndScreenModeHandler$Properties.access$600(TerminalAndScreenModeHandler.access$400(this.this$0)).accept(new Integer(n));
    }

    /* synthetic */ TerminalAndScreenModeHandler$TVListenerExt(TerminalAndScreenModeHandler terminalAndScreenModeHandler, TerminalAndScreenModeHandler$1 terminalAndScreenModeHandler$1) {
        this(terminalAndScreenModeHandler);
    }
}

