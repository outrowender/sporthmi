/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;

public abstract class AbstractENIActivator
extends AbstractActivator {
    private LogChannel logMain = null;

    protected final LogChannel getLogMain() {
        return this.logMain;
    }

    protected final void initCore() {
        this.logMain = this.getFramework().getLogChannel("App.ENI.Main");
        this.getLogMain().log(1000000, "initCore()");
    }

    protected final void cleanupCore() {
        this.getLogMain().log(1000000, "cleanupCore()");
        this.logMain = null;
    }
}

