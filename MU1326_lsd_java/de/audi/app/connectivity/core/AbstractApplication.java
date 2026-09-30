/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.core;

import de.audi.app.connectivity.core.IApplication;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.BundleContext;

public abstract class AbstractApplication
implements IApplication {
    private final List components = new ArrayList();
    protected final IFrameworkAccess framework;
    protected final LogChannel log;
    protected final CommandListManager commandListManager;
    private BundleContext bundleContext;

    protected AbstractApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, String string, String string2, String string3) {
        this.framework = iFrameworkAccess;
        this.bundleContext = bundleContext;
        this.log = iFrameworkAccess.getLogChannel(string);
        LogChannel logChannel = iFrameworkAccess.getLogChannel(string2);
        this.commandListManager = new CommandListManager(string3, iFrameworkAccess, logChannel, null, null);
    }

    public final void addComponent(IApplicationComponent iApplicationComponent) {
        this.components.add(iApplicationComponent);
    }

    private void initComponents() {
        if (this.components.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            ((IApplicationComponent)this.components.get(i2)).init();
        }
    }

    private void deinitComponents() {
        if (this.components.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            ((IApplicationComponent)this.components.get(i2)).deinit();
        }
    }

    public void init() {
        this.initComponents();
        this.registerDSIListener();
        this.startDSI();
        this.startCommandListManager();
        this.log.log(10000000, "AbstractApplication#init(): %1 initialized", (Object)this.getClass().getName());
    }

    protected abstract void registerDSIListener();

    protected abstract void startDSI();

    private void startCommandListManager() {
        this.commandListManager.start();
    }

    public void deinit() {
        this.deinitComponents();
        this.commandListManager.destroy();
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public LogChannel getLogChannel() {
        return this.log;
    }
}

