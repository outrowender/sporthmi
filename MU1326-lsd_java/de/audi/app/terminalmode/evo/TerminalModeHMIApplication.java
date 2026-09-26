/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.AbstractTerminalModeHMIApplication;
import de.audi.app.terminalmode.IContext;

public class TerminalModeHMIApplication
extends AbstractTerminalModeHMIApplication {
    static final String LOGCLASS;
    final int APPLICATION_ID;

    public TerminalModeHMIApplication(IContext iContext) {
        super(iContext);
        this.APPLICATION_ID = 43;
    }

    @Override
    public int getId() {
        return 32;
    }

    @Override
    protected String getLogClass() {
        return "TerminalModeHMIApplication";
    }

    @Override
    protected int getTerminalModeScreenId() {
        return 13905920;
    }
}

