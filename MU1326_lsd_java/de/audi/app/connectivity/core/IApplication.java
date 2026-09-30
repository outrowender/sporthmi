/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.connectivity.core;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import org.osgi.framework.BundleContext;

public interface IApplication {
    public void init();

    public void deinit();

    public IFrameworkAccess getFramework();

    public BundleContext getBundleContext();

    public CommandListManager getCommandListManager();

    public LogChannel getLogChannel();

    public ConnectivityDiag getDiag();
}

