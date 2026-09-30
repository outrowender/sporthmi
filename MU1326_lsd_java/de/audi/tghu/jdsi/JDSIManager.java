/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.jdsi.JDSIServiceMap;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.RingBuffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.List;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.InvalidSyntaxException;

public final class JDSIManager
implements DumpInfoProvider {
    public static final int DOMAIN_FAILED = -1;
    public static final int DOMAIN_NOT_STARTED = 0;
    public static final int DOMAIN_STARTED = 1;
    private static final boolean DEBUG = false;
    private final IFrameworkAccess fw;
    private LogChannel lc;
    private ServiceAdmin serviceAdmin = null;
    private final RingBuffer historyStartStopService = new RingBuffer(200);
    private final RingBuffer serviceHistory = new RingBuffer(200);
    private final JDSIServiceMap dsiServiceMap;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    JDSIManager(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = iFrameworkAccess.getLogChannel("Fw.JDSI.Admin");
        this.dsiServiceMap = new JDSIServiceMap(120);
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setServiceAdmin(ServiceAdmin serviceAdmin) {
        this.lc.log(100000, "JDSIManager.setServiceAdmin(%1)", (Object)serviceAdmin);
        JDSIManager jDSIManager = this;
        synchronized (jDSIManager) {
            this.serviceAdmin = serviceAdmin;
        }
        if (serviceAdmin != null) {
            this.startQueuedDSIs();
        }
    }

    public JDSIServiceMap getJDSIServiceMap() {
        return this.dsiServiceMap;
    }

    private boolean isListenerRegistered(String string, int n) {
        String string2 = new Buffer().append("(&(DEVICE_NAME=").append(string).append("Listener)(DEVICE_INSTANCE=").append(n).append("))").toString();
        try {
            this.lc.log(1000000, "Searching Listener for DSI Service %1, Instance %2", (Object)string, (long)n);
            if (this.fw.getBundleCxt().getServiceReferences((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = JDSIManager.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), string2) != null) {
                this.lc.log(1000000, "Found DSI Listener for %1 Instance %2!", (Object)string, (long)n);
                return true;
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.lc.log(10000, "This should never happen! filter is : %1", (Object)invalidSyntaxException, (Object)string2);
            return false;
        }
        return false;
    }

    private void startServiceInternal(ServiceAdmin serviceAdmin, String string, int n) {
        this.lc.log(1000000, "startServiceInternal(DSI Service %1, Instance %2)", (Object)string, (long)n);
        if (serviceAdmin != null && serviceAdmin.startService(string, n)) {
            this.historyStartStopService.put(new DSIHistoryStartService(string, n));
        }
    }

    private void stopServiceInternal(ServiceAdmin serviceAdmin, String string, int n) {
        this.lc.log(1000000, "stopServiceInternal(DSI Service %1, Instance %2)", (Object)string, (long)n);
        if (serviceAdmin.stopService(string, n)) {
            this.historyStartStopService.put(new DSIHistoryStopService(string, n));
        }
    }

    public synchronized void stopDSIService(String string, int n) {
        this.lc.log(1000000, "Stopping DSI Service: %1 Instance: %2!", (Object)string, (long)n);
        DSIInstance dSIInstance = this.getDSIInstance(string, n);
        if (dSIInstance.decrementStartCounter()) {
            if (this.serviceAdmin != null) {
                this.stopServiceInternal(this.serviceAdmin, string, n);
            } else {
                this.lc.log(100000, "Stopping DSI Service: %1 - ServiceAdmin not available!", (Object)string);
            }
        } else {
            this.lc.log(1000000, "Skip stopping DSI Service %1 Instance %2!", (Object)string, (long)n);
        }
    }

    public synchronized boolean startDSIService(String string, int n) {
        this.lc.log(1000000, "Starting DSI Service %1 Instance %2!", (Object)string, (long)n);
        DSIInstance dSIInstance = this.getDSIInstance(string, n);
        if (dSIInstance.incrementStartCounter()) {
            if (this.serviceAdmin != null) {
                this.startServiceInternal(this.serviceAdmin, string, n);
            } else {
                this.lc.log(100000, "Starting DSI Service: %1 delayed! ServiceAdmin not available!", (Object)string);
                this.enqueueDSIStart(string, n);
            }
            return true;
        }
        this.lc.log(1000000, "DSI Service: %1 Instance: %2 has already started!", (Object)string, (long)n);
        return false;
    }

    DSIInstance getDSIInstance(String string, int n) {
        DSIInstance dSIInstance = this.dsiServiceMap.getDSIInstance(string, n);
        if (dSIInstance == null) {
            dSIInstance = new DSIInstance(null, string, n);
            this.dsiServiceMap.mapDSIInstance(dSIInstance);
        }
        return dSIInstance;
    }

    void removePendingDSIStart(String string, int n) {
        DSIInstance dSIInstance = this.getDSIInstance(string, n);
        this.lc.log(1000000, "removePendingDSIStart(%1,%2)", (Object)string, (long)n);
        dSIInstance.setPendingDSIHandler(null);
    }

    private void enqueueDSIStart(String string, int n) {
        this.lc.log(1000000, "enqueueDSIStart(%1:%2)", (Object)string, (long)n);
        DSIInstance dSIInstance = this.getDSIInstance(string, n);
        dSIInstance.setPendingDSIHandler(new PendingDSIStart(0, 0));
    }

    private synchronized void startQueuedDSIs() {
        this.lc.log(100000, "startQueuedDSIs");
        while (this.serviceAdmin != null) {
            List list = this.dsiServiceMap.getPendingDSIInstances();
            if (list.isEmpty()) {
                return;
            }
            DSIInstance dSIInstance = (DSIInstance)list.get(0);
            dSIInstance.setPendingDSIHandler(null);
            this.startServiceInternal(this.serviceAdmin, dSIInstance.getServiceName(), dSIInstance.getInstanceID());
        }
        return;
    }

    public void dump(PrintStream printStream, String string) {
        int n;
        printStream.println("Pending:");
        List list = this.dsiServiceMap.getPendingDSIInstances();
        for (n = 0; n < list.size(); ++n) {
            printStream.println(list.get(n));
        }
        printStream.println();
        printStream.println("History:");
        printStream.println();
        printStream.println("Start-Service:");
        for (n = 0; n < this.historyStartStopService.size(); ++n) {
            printStream.println(this.historyStartStopService.get(n));
        }
        printStream.println("Service-Registered/Removed:");
        for (n = 0; n < this.serviceHistory.size(); ++n) {
            printStream.println(this.serviceHistory.get(n));
        }
    }

    public String getName() {
        return "JDSIManager";
    }

    void addDSIService(DSIBase dSIBase, String string, int n) {
        if (dSIBase != null) {
            this.serviceHistory.put(new DSIHistoryServiceRegistered(string, n));
        }
        DSIInstance dSIInstance = this.getDSIInstance(string, n);
        dSIInstance.setService(dSIBase);
    }

    void removedDSIService(DSIBase dSIBase, String string, int n) {
        this.serviceHistory.put(new DSIHistoryServiceRemoved(string, n));
        DSIInstance dSIInstance = this.getDSIInstance(string, n);
        dSIInstance.setService(null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static class DSIInstance {
        private final String serviceName;
        private final int instanceID;
        private Object service;
        private int state;
        private PendingDSIStart pendingDSIHandler;
        private int startCounter;

        public DSIInstance(Object object, String string, int n) {
            this.serviceName = string;
            this.service = object;
            this.instanceID = n;
        }

        public Object getService() {
            return this.service;
        }

        public void setService(Object object) {
            this.service = object;
        }

        public int getInstanceID() {
            return this.instanceID;
        }

        public String getServiceName() {
            return this.serviceName;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int n) {
            this.state = n;
        }

        public PendingDSIStart getPendingDSIHandler() {
            return this.pendingDSIHandler;
        }

        public void setPendingDSIHandler(PendingDSIStart pendingDSIStart) {
            this.pendingDSIHandler = pendingDSIStart;
            if (pendingDSIStart != null) {
                this.state = pendingDSIStart.state;
            }
        }

        public int getStartCounter() {
            return this.startCounter;
        }

        public boolean incrementStartCounter() {
            ++this.startCounter;
            return this.startCounter == 1;
        }

        public boolean decrementStartCounter() {
            if (this.startCounter > 0) {
                --this.startCounter;
                return this.startCounter == 0;
            }
            return false;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("DSIInstance(").append(this.serviceName);
            buffer.append(", ").append(this.instanceID);
            if (this.pendingDSIHandler != null) {
                buffer.append(", ").append(this.pendingDSIHandler);
            }
            buffer.append(")");
            return buffer.toString();
        }
    }

    private class PendingDSIStart {
        private final long timestamp;
        private final int domain;
        private final int state;

        PendingDSIStart(int n, int n2) {
            this.timestamp = JDSIManager.this.fw.getMonotonicTime();
            this.domain = n;
            this.state = n2;
        }

        public String toString() {
            return new StringBuffer().append("[").append(this.timestamp).append("]PendingDSIStart(").append(this.domain).append(",0x").append(Integer.toHexString(this.state)).append(")").toString();
        }
    }

    private class DSIHistoryStopService {
        private final long timestamp;
        private final String service;
        private final int instance;

        DSIHistoryStopService(String string, int n) {
            this.timestamp = JDSIManager.this.fw.getMonotonicTime();
            this.service = string;
            this.instance = n;
        }

        public String toString() {
            return new Buffer().append('[').append(this.timestamp).append("] stopped DSI: ").append(this.service).append(':').append(this.instance).toString();
        }
    }

    private class DSIHistoryStartService {
        private final long timestamp;
        private final String service;
        private final int instance;

        DSIHistoryStartService(String string, int n) {
            this.timestamp = JDSIManager.this.fw.getMonotonicTime();
            this.service = string;
            this.instance = n;
        }

        public String toString() {
            return new Buffer().append('[').append(this.timestamp).append("] started DSI: ").append(this.service).append(':').append(this.instance).toString();
        }
    }

    private class DSIHistoryServiceRemoved {
        private final long timestamp;
        private final String serviceName;
        private final long instanceID;

        DSIHistoryServiceRemoved(String string, int n) {
            this.timestamp = JDSIManager.this.fw.getMonotonicTime();
            this.serviceName = string;
            this.instanceID = n;
        }

        public String toString() {
            return new Buffer().append('[').append(this.timestamp).append("] removed DSI: ").append(this.serviceName).append(" instance ").append(this.instanceID).toString();
        }
    }

    private class DSIHistoryServiceRegistered {
        private final long timestamp;
        private final String serviceName;
        private final int instanceID;

        DSIHistoryServiceRegistered(String string, int n) {
            this.timestamp = JDSIManager.this.fw.getMonotonicTime();
            this.serviceName = string;
            this.instanceID = n;
        }

        public String toString() {
            return new Buffer().append('[').append(this.timestamp).append("] registered DSI: ").append(this.serviceName).append(" instance ").append(this.instanceID).toString();
        }
    }
}

