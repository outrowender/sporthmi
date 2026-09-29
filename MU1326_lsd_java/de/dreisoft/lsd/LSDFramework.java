/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.BundleRegistry;
import de.dreisoft.lsd.LSDLogService;
import de.dreisoft.lsd.ServiceRegistry;
import org.osgi.service.log.LogService;

public abstract class LSDFramework {
    protected static BundleRegistry bundleRegistry = BundleRegistry.getInstance();
    protected static ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
    protected static LogService logService = LSDLogService.getInstance();
}

