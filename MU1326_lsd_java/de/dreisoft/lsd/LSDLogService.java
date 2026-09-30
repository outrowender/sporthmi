/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import de.dreisoft.lsd.ServiceRegistry;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

final class LSDLogService
implements LogService {
    private static final String[] LOG_SERVICE_CLASS = new String[]{(class$org$osgi$service$log$LogService == null ? (class$org$osgi$service$log$LogService = LSDLogService.class$("org.osgi.service.log.LogService")) : class$org$osgi$service$log$LogService).toString()};
    private LogService logService = null;
    private ServiceObserver logServiceObserver = new LogServiceObserver();
    static /* synthetic */ Class class$org$osgi$service$log$LogService;

    private LSDLogService() {
        ServiceRegistry.getInstance().addObserver(this.logServiceObserver);
    }

    static LSDLogService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void log(int n, String string) {
        if (this.logService != null) {
            this.logService.log(n, string);
        } else {
            this.logInternal(null, n, string, null);
        }
    }

    public void log(int n, String string, Throwable throwable) {
        if (this.logService != null) {
            this.logService.log(n, string, throwable);
        } else {
            this.logInternal(null, n, string, throwable);
        }
    }

    public void log(ServiceReference serviceReference, int n, String string) {
        if (this.logService != null) {
            this.logService.log(serviceReference, n, string);
        } else {
            this.logInternal(serviceReference, n, string, null);
        }
    }

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

    private static class SingletonHolder {
        static final LSDLogService INSTANCE = new LSDLogService();

        private SingletonHolder() {
        }
    }

    private class LogServiceObserver
    implements ServiceObserver {
        private LogServiceObserver() {
        }

        public String[] getObservedClasses() {
            return LOG_SERVICE_CLASS;
        }

        public boolean addingService(ServiceInfo serviceInfo) {
            LSDLogService.this.logService = (LogService)serviceInfo.getService();
            return true;
        }

        public void removedService(ServiceInfo serviceInfo) {
            if (LSDLogService.this.logService == (LogService)serviceInfo.getService()) {
                LSDLogService.this.logService = null;
            }
        }
    }
}

