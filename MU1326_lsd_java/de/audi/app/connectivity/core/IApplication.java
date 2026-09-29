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
    default public void init() {
    }

    default public void deinit() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public BundleContext getBundleContext() {
    }

    default public CommandListManager getCommandListManager() {
    }

    default public LogChannel getLogChannel() {
    }

    default public ConnectivityDiag getDiag() {
    }
}

