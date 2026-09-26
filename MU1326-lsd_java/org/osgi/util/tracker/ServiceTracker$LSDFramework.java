/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import de.dreisoft.lsd.LSDFramework;
import de.dreisoft.lsd.ServiceRegistry;
import org.osgi.service.log.LogService;

class ServiceTracker$LSDFramework
extends LSDFramework {
    private ServiceTracker$LSDFramework() {
    }

    public static ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    public static LogService getLogService() {
        return logService;
    }
}

