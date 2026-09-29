/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark.mmi3g;

import de.dreisoft.lsd.LSDFramework;
import de.dreisoft.lsd.ServiceRegistry;
import org.osgi.service.log.LogService;

public class MMI3gBenchmarkSuite$LSDFramework
extends LSDFramework {
    protected MMI3gBenchmarkSuite$LSDFramework() {
    }

    public static ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    public static LogService getLogService() {
        return logService;
    }
}

