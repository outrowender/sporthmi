/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.AbstractTerminalModeHMIApplication;
import de.audi.app.terminalmode.IContext;

public class TerminalModeHMIApplication
extends AbstractTerminalModeHMIApplication {
    static final String LOGCLASS = "TerminalModeHMIApplication";
    final int APPLICATION_ID;

    public TerminalModeHMIApplication(IContext iContext) {
        super(iContext);
        this.APPLICATION_ID = 43;
    }

    public int getId() {
        return 32;
    }

    protected String getLogClass() {
        return LOGCLASS;
    }

    protected int getTerminalModeScreenId() {
        return 3200000;
    }
}

