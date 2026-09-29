/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.jdsi.JDSIManager$DSIHistoryServiceRegistered;
import de.audi.tghu.jdsi.JDSIManager$DSIHistoryServiceRemoved;
import de.audi.tghu.jdsi.JDSIManager$DSIHistoryStartService;
import de.audi.tghu.jdsi.JDSIManager$DSIHistoryStopService;
import de.audi.tghu.jdsi.JDSIManager$DSIInstance;
import de.audi.tghu.jdsi.JDSIManager$PendingDSIStart;
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
    public static final int DOMAIN_FAILED;
    public static final int DOMAIN_NOT_STARTED;
    public static final int DOMAIN_STARTED;
    private static final boolean DEBUG;
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
        this.lc.log(-1601830656, "JDSIManager.setServiceAdmin(%1)", (Object)serviceAdmin);
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
            this.lc.log(1078071040, "Searching Listener for DSI Service %1, Instance %2", (Object)string, (long)n);
            if (this.fw.getBundleCxt().getServiceReferences((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = JDSIManager.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), string2) != null) {
                this.lc.log(1078071040, "Found DSI Listener for %1 Instance %2!", (Object)string, (long)n);
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
        this.lc.log(1078071040, "startServiceInternal(DSI Service %1, Instance %2)", (Object)string, (long)n);
        if (serviceAdmin != null && serviceAdmin.startService(string, n)) {
            this.historyStartStopService.put(new JDSIManager$DSIHistoryStartService(this, string, n));
        }
    }

    private void stopServiceInternal(ServiceAdmin serviceAdmin, String string, int n) {
        this.lc.log(1078071040, "stopServiceInternal(DSI Service %1, Instance %2)", (Object)string, (long)n);
        if (serviceAdmin.stopService(string, n)) {
            this.historyStartStopService.put(new JDSIManager$DSIHistoryStopService(this, string, n));
        }
    }

    public synchronized void stopDSIService(String string, int n) {
        this.lc.log(1078071040, "Stopping DSI Service: %1 Instance: %2!", (Object)string, (long)n);
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.getDSIInstance(string, n);
        if (jDSIManager$DSIInstance.decrementStartCounter()) {
            if (this.serviceAdmin != null) {
                this.stopServiceInternal(this.serviceAdmin, string, n);
            } else {
                this.lc.log(-1601830656, "Stopping DSI Service: %1 - ServiceAdmin not available!", (Object)string);
            }
        } else {
            this.lc.log(1078071040, "Skip stopping DSI Service %1 Instance %2!", (Object)string, (long)n);
        }
    }

    public synchronized boolean startDSIService(String string, int n) {
        this.lc.log(1078071040, "Starting DSI Service %1 Instance %2!", (Object)string, (long)n);
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.getDSIInstance(string, n);
        if (jDSIManager$DSIInstance.incrementStartCounter()) {
            if (this.serviceAdmin != null) {
                this.startServiceInternal(this.serviceAdmin, string, n);
            } else {
                this.lc.log(-1601830656, "Starting DSI Service: %1 delayed! ServiceAdmin not available!", (Object)string);
                this.enqueueDSIStart(string, n);
            }
            return true;
        }
        this.lc.log(1078071040, "DSI Service: %1 Instance: %2 has already started!", (Object)string, (long)n);
        return false;
    }

    JDSIManager$DSIInstance getDSIInstance(String string, int n) {
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.dsiServiceMap.getDSIInstance(string, n);
        if (jDSIManager$DSIInstance == null) {
            jDSIManager$DSIInstance = new JDSIManager$DSIInstance(null, string, n);
            this.dsiServiceMap.mapDSIInstance(jDSIManager$DSIInstance);
        }
        return jDSIManager$DSIInstance;
    }

    void removePendingDSIStart(String string, int n) {
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.getDSIInstance(string, n);
        this.lc.log(1078071040, "removePendingDSIStart(%1,%2)", (Object)string, (long)n);
        jDSIManager$DSIInstance.setPendingDSIHandler(null);
    }

    private void enqueueDSIStart(String string, int n) {
        this.lc.log(1078071040, "enqueueDSIStart(%1:%2)", (Object)string, (long)n);
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.getDSIInstance(string, n);
        jDSIManager$DSIInstance.setPendingDSIHandler(new JDSIManager$PendingDSIStart(this, 0, 0));
    }

    private synchronized void startQueuedDSIs() {
        this.lc.log(-1601830656, "startQueuedDSIs");
        while (this.serviceAdmin != null) {
            List list = this.dsiServiceMap.getPendingDSIInstances();
            if (list.isEmpty()) {
                return;
            }
            JDSIManager$DSIInstance jDSIManager$DSIInstance = (JDSIManager$DSIInstance)list.get(0);
            jDSIManager$DSIInstance.setPendingDSIHandler(null);
            this.startServiceInternal(this.serviceAdmin, jDSIManager$DSIInstance.getServiceName(), jDSIManager$DSIInstance.getInstanceID());
        }
        return;
    }

    @Override
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

    @Override
    public String getName() {
        return "JDSIManager";
    }

    void addDSIService(DSIBase dSIBase, String string, int n) {
        if (dSIBase != null) {
            this.serviceHistory.put(new JDSIManager$DSIHistoryServiceRegistered(this, string, n));
        }
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.getDSIInstance(string, n);
        jDSIManager$DSIInstance.setService(dSIBase);
    }

    void removedDSIService(DSIBase dSIBase, String string, int n) {
        this.serviceHistory.put(new JDSIManager$DSIHistoryServiceRemoved(this, string, n));
        JDSIManager$DSIInstance jDSIManager$DSIInstance = this.getDSIInstance(string, n);
        jDSIManager$DSIInstance.setService(null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IFrameworkAccess access$000(JDSIManager jDSIManager) {
        return jDSIManager.fw;
    }
}

