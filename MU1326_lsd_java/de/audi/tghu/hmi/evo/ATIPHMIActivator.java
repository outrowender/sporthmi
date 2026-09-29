/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.activator.AbstractActivator;
import de.audi.kbd.hmi.evo.KeyEventDistributorEvo;
import de.audi.tghu.fwhmi.DisplayManagerMIB2High;
import de.audi.tghu.fwhmi.DisplayManagerMIB2Standard;
import de.audi.tghu.fwhmi.evo.RootWindowFactoryQNX;
import de.audi.tghu.hmi.evo.TerminalContextEvo;
import de.audi.tghu.hmi.evo.TopLevelScreenActionProxyImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class ATIPHMIActivator
extends AbstractActivator {
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        TopLevelScreenActionProxyImpl topLevelScreenActionProxyImpl = new TopLevelScreenActionProxyImpl(this.framework);
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(27));
        this.bundleContext.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = ATIPHMIActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)topLevelScreenActionProxyImpl, (Dictionary)hashtable);
        this.registerDisplayManager();
        this.registerKeyEventDistributor();
        this.registerTerminals();
        this.registerRootWindow();
    }

    private void registerRootWindow() {
        if (this.framework.isTarget()) {
            new RootWindowFactoryQNX(this.framework);
        }
    }

    private void registerKeyEventDistributor() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.getFramework().getHMITerminalRegistry().registerKeyEventDistributor(i2, new KeyEventDistributorEvo(i2, this.getFramework()));
        }
    }

    private void registerDisplayManager() {
        if (this.getFramework().isEvoStd()) {
            this.getFramework().getHMITerminalRegistry().registerDisplayManager(new DisplayManagerMIB2Standard(this.getFramework()));
        } else {
            this.getFramework().getHMITerminalRegistry().registerDisplayManager(new DisplayManagerMIB2High(this.getFramework()));
        }
    }

    private void registerTerminals() {
        this.registerTerminal(0);
        this.registerTerminal(6);
        if (this.getFramework().isFrontMU()) {
            if (this.getFramework().isDualView()) {
                this.registerTerminal(2);
            }
            this.registerTerminal(1);
        } else {
            this.registerTerminal(3);
            this.registerTerminal(4);
            this.registerTerminal(5);
        }
    }

    private void registerTerminal(int n) {
        this.getFramework().getHMITerminalRegistry().registerTerminalContext(n, new TerminalContextEvo(n));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

