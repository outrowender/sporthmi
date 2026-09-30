/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.TerminalModeModelBank;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private TerminalModeScreenFactory instance = null;
    private TerminalModeConditionBank conditionBank;

    public Activator() {
        super(32, "TerminalMode", System.getProperty("variant.skin", "EvoHighScale"), new TerminalModeModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new TerminalModeScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new TerminalModeConditionBank((TerminalModeScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

