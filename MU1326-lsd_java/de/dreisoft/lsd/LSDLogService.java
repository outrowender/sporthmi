/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.LSDLogService$LogServiceObserver;
import de.dreisoft.lsd.LSDLogService$SingletonHolder;
import de.dreisoft.lsd.ServiceObserver;
import de.dreisoft.lsd.ServiceRegistry;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

final class LSDLogService
implements LogService {
    private static final String[] LOG_SERVICE_CLASS = new String[]{(class$org$osgi$service$log$LogService == null ? (class$org$osgi$service$log$LogService = LSDLogService.class$("org.osgi.service.log.LogService")) : class$org$osgi$service$log$LogService).toString()};
    private LogService logService = null;
    private ServiceObserver logServiceObserver = new LSDLogService$LogServiceObserver(this, null);
    static /* synthetic */ Class class$org$osgi$service$log$LogService;

    private LSDLogService() {
        ServiceRegistry.getInstance().addObserver(this.logServiceObserver);
    }

    static LSDLogService getInstance() {
        return LSDLogService$SingletonHolder.INSTANCE;
    }

    @Override
    public void log(int n, String string) {
        if (this.logService != null) {
            this.logService.log(n, string);
        } else {
            this.logInternal(null, n, string, null);
        }
    }

    @Override
    public void log(int n, String string, Throwable throwable) {
        if (this.logService != null) {
            this.logService.log(n, string, throwable);
        } else {
            this.logInternal(null, n, string, throwable);
        }
    }

    @Override
    public void log(ServiceReference serviceReference, int n, String string) {
        if (this.logService != null) {
            this.logService.log(serviceReference, n, string);
        } else {
            this.logInternal(serviceReference, n, string, null);
        }
    }

    @Override
    public void log(ServiceReference serviceReference, int n, String string, Throwable throwable) {
        if (this.logService != null) {
            this.logService.log(serviceReference, n, string, throwable);
        } else {
            this.logInternal(serviceReference, n, string, throwable);
        }
    }

    private void logInternal(ServiceReference serviceReference, int n, String string, Throwable throwable) {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("<LSD> ");
        switch (n) {
            case 1: {
                stringBuffer.append("error: ");
                break;
            }
            case 2: {
                stringBuffer.append("warning: ");
                break;
            }
            case 3: {
                stringBuffer.append("info: ");
                break;
            }
            case 4: {
                stringBuffer.append("debug: ");
                break;
            }
            default: {
                stringBuffer.append("level ").append(n).append(": ");
            }
        }
        stringBuffer.append(string);
        System.err.println(stringBuffer.toString());
        if (serviceReference != null) {
            System.err.print("service:");
            System.err.println(serviceReference);
        }
        if (throwable != null) {
            System.err.print("exception: ");
            System.err.println(throwable.getMessage());
            throwable.printStackTrace(System.err);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ String[] access$200() {
        return LOG_SERVICE_CLASS;
    }

    static /* synthetic */ LogService access$302(LSDLogService lSDLogService, LogService logService) {
        lSDLogService.logService = logService;
        return lSDLogService.logService;
    }

    static /* synthetic */ LogService access$300(LSDLogService lSDLogService) {
        return lSDLogService.logService;
    }
}

