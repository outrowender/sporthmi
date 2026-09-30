/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public final class OnlineFunctionsServiceManager
extends AbstractBAPModuleServiceManager {
    public OnlineFunctionsServiceManager(AbstractBAPModule abstractBAPModule, BundleContext bundleContext) {
        super(abstractBAPModule, bundleContext);
    }

    public void registerServices(AbstractActivator abstractActivator) {
    }

    public void trackServices() {
    }
}

