/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.LSDLogService;
import de.dreisoft.lsd.LSDLogService$1;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import org.osgi.service.log.LogService;

class LSDLogService$LogServiceObserver
implements ServiceObserver {
    private final /* synthetic */ LSDLogService this$0;

    private LSDLogService$LogServiceObserver(LSDLogService lSDLogService) {
        this.this$0 = lSDLogService;
    }

    @Override
    public String[] getObservedClasses() {
        return LSDLogService.access$200();
    }

    @Override
    public boolean addingService(ServiceInfo serviceInfo) {
        LSDLogService.access$302(this.this$0, (LogService)serviceInfo.getService());
        return true;
    }

    @Override
    public void removedService(ServiceInfo serviceInfo) {
        if (LSDLogService.access$300(this.this$0) == (LogService)serviceInfo.getService()) {
            LSDLogService.access$302(this.this$0, null);
        }
    }

    /* synthetic */ LSDLogService$LogServiceObserver(LSDLogService lSDLogService, LSDLogService$1 lSDLogService$1) {
        this(lSDLogService);
    }
}

