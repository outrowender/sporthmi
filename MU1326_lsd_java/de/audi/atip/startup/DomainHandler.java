/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.IDomainListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.DomainHandlerMU;
import de.audi.mib.jdsi.IDSIClient;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.startup.DSIStartupListener;

public class DomainHandler
implements DSIStartupListener,
IDSIClient {
    private static final String[] DOMAIN_NAMES = new String[]{"Unknown", "Root", "Tuner", "Media", "Addressbook", "Phone", "Nav", "Info", "Car", "Audio", "SDS", "SWDL", "EarlyApps", "PostStartup", "Communication", "Unused", "IpServices", "GEMMI", "Bapkombi", "Bluetooth", "Browser", "Explorer", "Calendar", "PictureStore", "StreetView", "MobilityHorizon", "ExBoxM", "MirrorLink", "SFA", "Search", "Diagnosis", "AsiaLanguageSupport", "ExLAP", "TVTuner", "MediaOnline", "MediaRouter", "RadioDataServer", "SmartphoneIntegration"};
    static final int NR_DOMAINS = DOMAIN_NAMES.length;
    private static final String[] ACTION_NAMES = new String[]{" request", " response", " update"};
    public static final long DSI_STARTUP_TIMEOUT = 5000L;
    private static final long DEFAULT_DOMAIN_START_TIMEOUT = 20000L;
    private static final long MAX_DOMAIN_START_WAIT = Long.getLong("startup.max.domain.wait", 20000L);
    private final IFrameworkAccess framework;
    private final Object DOMAIN_SYNCER = new Object();
    private final Object syncDSIStartup = new Object();
    private volatile boolean dsiAvailable = false;
    private final List listeners = new ArrayList(2);
    private DSIStartup dsiProvider = null;
    private final LogChannel log;
    private final LogChannel logExtStartup;
    private Domain[] domains;
    private DomainHandlerMU domainHandlerMU;

    private final IFrameworkAccess getFramework() {
        return this.framework;
    }

    static final String getDomainName(int n) {
        String string;
        try {
            string = DOMAIN_NAMES[n];
        }
        catch (Exception exception) {
            string = Integer.toString(n);
        }
        return string;
    }

    static boolean isIncluded(int n, int n2) {
        return (n & ~n2) == 0;
    }

    public static boolean isFailed(int n) {
        return DomainHandler.isIncluded(16, n);
    }

    public DomainHandler(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Domain");
        this.logExtStartup = iFrameworkAccess.getLogChannel("Ext.Startup");
        this.log.log(1000000, "DomainHandler()");
        this.domains = new Domain[NR_DOMAINS];
        for (int i2 = 0; i2 < this.domains.length; ++i2) {
            this.domains[i2] = new Domain(i2);
        }
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(new DumpInfoProvider(){

            public void dump(PrintStream printStream, String string) {
                DomainHandler.this.dumpDomainStartupTimes(printStream, "\n");
            }

            public String getName() {
                return "DomainStates";
            }
        });
    }

    Object getDomainSyncer() {
        return this.DOMAIN_SYNCER;
    }

    public void addDomainListener(IDomainListener iDomainListener) {
        if (iDomainListener != null) {
            this.listeners.add(iDomainListener);
            for (int i2 = 0; i2 < this.domains.length; ++i2) {
                Domain domain = this.getDomainByDomainId(i2);
                if (domain == null) continue;
                iDomainListener.updateDomainState(i2, domain.updated);
            }
        }
    }

    public void removeDomainListener(IDomainListener iDomainListener) {
        this.listeners.remove(iDomainListener);
    }

    private void setNotification(DSIStartup dSIStartup, int[] nArray) {
        if (dSIStartup != null) {
            if (this.log.isInfo()) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    this.log.log(10000000, "DSIStartup.setNotification for attribute %1", (long)nArray[i2]);
                }
            }
            dSIStartup.setNotification(nArray, (DSIListener)this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void markDSIStartupAsAvailable() {
        Object object = this.syncDSIStartup;
        synchronized (object) {
            this.dsiAvailable = true;
            this.syncDSIStartup.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean waitForDSIStartup() {
        this.log.log(1000000, "DomainHandler.waitForDSIStartup()");
        Object object = this.syncDSIStartup;
        synchronized (object) {
            if (!this.dsiAvailable) {
                this.log.log(1000000, "DomainHandler.waitForDSIStartup() wait %1 seconds for DSIStartup", 5L);
                try {
                    this.syncDSIStartup.wait(5000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            if (!this.dsiAvailable) {
                this.log.log(1000, "DomainHandler.waitForDSIStartup() failed! DSIStartup still not available!");
                return false;
            }
            return true;
        }
    }

    public void setDSI(DSIBase dSIBase) {
        this.log.log(100000, "setDSI( %1 )", (Object)dSIBase);
        if (dSIBase instanceof DSIStartup) {
            this.initDSI((DSIStartup)dSIBase);
        } else if (dSIBase == null) {
            this.dsiProvider = null;
            this.log.log(10000, "DomainHandler: DSIStartup provider is NULL!");
        } else {
            this.log.log(100000, "setDSI( %1 ) failed! wrong class!", (Object)dSIBase);
        }
    }

    public int[] getAutoNotifications() {
        return new int[0];
    }

    public void initDSI(DSIStartup dSIStartup) {
        this.log.log(100000, "initDSI( %1 )", (Object)dSIStartup);
        this.dsiProvider = dSIStartup;
        this.setNotification(dSIStartup, new int[]{2, 3, 4, 5, 6, 10, 11, 16, 19, 20, 21, 22, 23, 24, 28, 30, 31, 32, 33, 34, 35, 36});
        this.markDSIStartupAsAvailable();
    }

    public DSIStartup getDSI() {
        return this.dsiProvider;
    }

    private Domain getDomainByDomainId(int n) {
        try {
            if (n != 0) {
                return this.domains[n];
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.log.log(10000, "getDomainByDomainId( %1 ): domain with this id is not found!", (long)n);
        }
        return null;
    }

    public void setDomainHandlerMU(DomainHandlerMU domainHandlerMU) {
        this.log.log(100000, "setDomainHandlerMU( %1 )", (Object)domainHandlerMU);
        this.domainHandlerMU = domainHandlerMU;
        domainHandlerMU.initDomainHandler(this);
    }

    public DomainHandlerMU getDomainHandlerMU() {
        return this.domainHandlerMU;
    }

    public boolean isDomainStartedOnMU(int n) {
        Domain domain;
        DomainHandlerMU domainHandlerMU = this.getDomainHandlerMU();
        if (domainHandlerMU != null && (domain = this.getDomainByDomainId(n)) != null && domain.mustWaitForFrontMU()) {
            return domainHandlerMU.isDomainStartedOnMU(n);
        }
        return true;
    }

    public void updateMUDomain(int n, int n2) {
        this.log.log(10000000, "updateMUDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null && domain.mustWaitForFrontMU()) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((IDomainListener)this.listeners.get(i2)).muDomainIsAvailable(n, n2);
            }
        }
    }

    void informHMICompletelyStarted() {
        if (this.dsiProvider != null) {
            this.log.log(10000000, "DomainHandler::informDSICompletelyStarted");
            this.dsiProvider.hmiCompletelyStarted();
        } else {
            this.log.log(10000, "DomainHandler::informDSICompletelyStarted: DSIStartup isn't initialized");
        }
    }

    public void disableDomain(int n) {
        this.log.log(10000000, "DomainHandler.disableDomain( %1 )!", (Object)DomainHandler.getDomainName(n));
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            domain.disable();
        }
    }

    public boolean isDomainEnabled(int n) {
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            return domain.isEnabled();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int doStartDomain(int n, int n2) {
        this.log.log(10000000, "DomainHandler.doStartDomain( %1, 0x%2 )!", (Object)DomainHandler.getDomainName(n), (long)n2);
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            Object object = this.getDomainSyncer();
            synchronized (object) {
                if (!domain.isEnabled()) {
                    this.log.log(1000000, "-> DomainHandler.doStartDomain( %1, 0x%2 ): Domain is disabled!", (Object)DomainHandler.getDomainName(n), (long)n2);
                    return domain.updated;
                }
                if (domain.startPrepare(n2)) {
                    this.log.log(1000000, "-> DSIStartup.startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    this.logExtStartup.log(1000000, "startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    if (this.dsiProvider != null) {
                        this.dsiProvider.startDomain(n, n2);
                    } else {
                        this.log.log(1000, "DSIStartup not available -> simulate responses");
                    }
                } else {
                    this.log.log(10000000, "DomainHandler.doStartDomain( %1, 0x%2 ) do nothing, domain has already reached state 0x%3", (Object)DomainHandler.getDomainName(n), (long)n2, (long)domain.updated);
                    return domain.updated;
                }
                if (domain.waitForStartFinished(n2)) {
                    this.log.log(10000000, "DSIStartup.startDomain( %1, 0x%2 ) succeeded! current state is: 0x%3", (Object)DomainHandler.getDomainName(n), (long)n2, (long)domain.updated);
                } else {
                    String string = DomainHandler.getDomainName(n);
                    this.log.log(100000, "DSIStartup.startDomain( %1, 0x%2 ) timed out! current state is: 0x%3", (Object)string, (long)n2, (long)domain.updated);
                    this.logExtStartup.log(100000, "startDomain( %1, 0x%2 ) timed out!", (Object)string, (long)n2);
                    this.logExtStartup.log(100000, "%1 requested: [ 0x%2 ] current state is: [ 0x%3 ]", (Object)string, (long)n2, (long)domain.updated);
                }
                return domain.updated;
            }
        }
        this.log.log(100000, "DomainHandler.doStartDomain: Preparing to start undefined domain!");
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void doStartDomainAsync(int n, int n2) {
        this.log.log(10000000, "DomainHandler.prepareDomainAsync( %1, 0x%2 )!", (Object)DomainHandler.getDomainName(n), (long)n2);
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            Object object = this.getDomainSyncer();
            synchronized (object) {
                if (!domain.isEnabled()) {
                    this.log.log(1000000, "-> DomainHandler.doStartDomainAsync( %1, 0x%2 ): Domain is disabled!", (Object)DomainHandler.getDomainName(n), (long)n2);
                    return;
                }
                if (domain.startPrepare(n2)) {
                    this.log.log(1000000, "-> DSIStartup.startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    this.logExtStartup.log(1000000, "startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    if (this.dsiProvider != null) {
                        this.dsiProvider.startDomain(n, n2);
                    } else {
                        this.log.log(1000, "DSIStartup not available -> simulate responses");
                    }
                } else {
                    this.log.log(10000000, "DomainHandler.doStartDomainAsync( %1, 0x%2 ) do nothing, domain has already reached state 0x%3", (Object)DomainHandler.getDomainName(n), (long)n2, (long)domain.updated);
                    return;
                }
            }
        } else {
            this.log.log(100000, "DomainHandler.doStartDomainAsync: Preparing to start undefined domain!");
            return;
        }
    }

    boolean isWaitingForResponse(int n, int n2) {
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            return !DomainHandler.isIncluded(n2, domain.updated);
        }
        return false;
    }

    public boolean isDomainStartedToState(int n, int n2) {
        if (n == 0 || n2 == 0) {
            return true;
        }
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            return DomainHandler.isIncluded(n2, domain.updated);
        }
        this.log.log(1000, "Undefined Domain %1! Assume it is started for now. Fix this in config ( dsi.properties / lastmode.properties )!");
        return true;
    }

    public void dumpDomainStartupTimes(PrintStream printStream, String string) {
        printStream.print("Domain Startup Times:");
        for (int i2 = 0; i2 < this.domains.length; ++i2) {
            this.domains[i2].dumpState(printStream, string);
            printStream.println();
        }
        printStream.flush();
    }

    private void doUpdateDomainStatus(int n, int n2) {
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            domain.updateState(n2);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((IDomainListener)this.listeners.get(i2)).updateDomainState(n, n2);
            }
        }
    }

    private void updateDomainStatus(int n, int n2, int n3) {
        if (n3 == 1) {
            if (n == 0) {
                this.log.log(1000000, "<- updateDomainStatus( %1, 0x%2 ), status is 0 ( = DOMAIN_STATE_NOT_INIT ), use 1 (= DOMAIN_STATE_NOT_STARTED) instead", (Object)DomainHandler.getDomainName(n2), (long)n);
                n = 1;
            }
            this.log.log(1000000, "<- updateDomainStatus( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n2), (long)n);
            int n4 = n == 8 ? 14 : (n == 4 ? 6 : n);
            this.doUpdateDomainStatus(n2, n4);
        } else {
            this.log.log(10000000, "updateDomainStatus( %1, 0x%2 ), ignore: domain attribute is invalid", (Object)DomainHandler.getDomainName(n2), (long)n);
        }
    }

    public void startDomain(int n, int n2) {
        this.log.log(1000000, "<- startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
        int n3 = n2 == 8 ? 14 : (n2 == 4 ? 6 : n2);
        Domain domain = this.getDomainByDomainId(n);
        if (domain != null) {
            domain.finishedPrepare(n3);
            if (DomainHandler.isFailed(n3)) {
                this.doUpdateDomainStatus(n, n3);
            }
        }
    }

    public void updateDomainStatusRoot(int n, int n2) {
        this.updateDomainStatus(n, 1, n2);
    }

    public void updateDomainStatusTuner(int n, int n2) {
        this.updateDomainStatus(n, 2, n2);
    }

    public void updateDomainStatusMedia(int n, int n2) {
        this.updateDomainStatus(n, 3, n2);
    }

    public void updateDomainStatusAddressbook(int n, int n2) {
        this.updateDomainStatus(n, 4, n2);
    }

    public void updateDomainStatusPhone(int n, int n2) {
        this.updateDomainStatus(n, 5, n2);
    }

    public void updateDomainStatusNav(int n, int n2) {
        this.updateDomainStatus(n, 6, n2);
    }

    public void updateDomainStatusInfo(int n, int n2) {
        this.updateDomainStatus(n, 7, n2);
    }

    public void updateDomainStatusCar(int n, int n2) {
        this.updateDomainStatus(n, 8, n2);
    }

    public void updateDomainStatusAudio(int n, int n2) {
        this.updateDomainStatus(n, 9, n2);
    }

    public void updateDomainStatusSDS(int n, int n2) {
        this.updateDomainStatus(n, 10, n2);
    }

    public void updateDomainStatusSWDL(int n, int n2) {
        this.updateDomainStatus(n, 11, n2);
    }

    public void updateDomainStatusEarlyApps(int n, int n2) {
        this.updateDomainStatus(n, 12, n2);
    }

    public void updateDomainStatusPostStartup(int n, int n2) {
    }

    public void updateDomainStatusCommunication(int n, int n2) {
        this.updateDomainStatus(n, 14, n2);
    }

    public void updateDomainStatusIpServices(int n, int n2) {
        this.updateDomainStatus(n, 16, n2);
    }

    public void updateDomainStatusGEMMI(int n, int n2) {
        this.updateDomainStatus(n, 17, n2);
    }

    public void updateDomainStatusBapkombi(int n, int n2) {
        this.updateDomainStatus(n, 18, n2);
    }

    public void updateDomainStatusBluetooth(int n, int n2) {
        this.updateDomainStatus(n, 19, n2);
    }

    public void updateDomainStatusBrowser(int n, int n2) {
        this.updateDomainStatus(n, 20, n2);
    }

    public void updateDomainStatusExplorer(int n, int n2) {
        this.updateDomainStatus(n, 21, n2);
    }

    public void updateDomainStatusCalendar(int n, int n2) {
        this.updateDomainStatus(n, 22, n2);
    }

    public void updateDomainStatusPictureStore(int n, int n2) {
        this.updateDomainStatus(n, 23, n2);
    }

    public void updateDomainStatusStreetView(int n, int n2) {
        this.updateDomainStatus(n, 24, n2);
    }

    public void updateDomainStatusMobilityHorizon(int n, int n2) {
        this.updateDomainStatus(n, 25, n2);
    }

    public void updateDomainStatusExBoxM(int n, int n2) {
        this.updateDomainStatus(n, 26, n2);
    }

    public void updateDomainStatusMirrorLink(int n, int n2) {
        this.updateDomainStatus(n, 27, n2);
    }

    public void updateDomainStatusSFA(int n, int n2) {
        this.updateDomainStatus(n, 28, n2);
    }

    public void updateDomainStatusSearch(int n, int n2) {
        this.updateDomainStatus(n, 29, n2);
    }

    public void updateDomainStatusDiagnosis(int n, int n2) {
        this.updateDomainStatus(n, 30, n2);
    }

    public void updateDomainStatusAsiaLanguageSupport(int n, int n2) {
        this.updateDomainStatus(n, 31, n2);
    }

    public void updateDomainStatusExLAP(int n, int n2) {
        this.updateDomainStatus(n, 32, n2);
    }

    public void updateDomainStatusTVTuner(int n, int n2) {
        this.updateDomainStatus(n, 33, n2);
    }

    public void updateDomainStatusMediaOnline(int n, int n2) {
        this.updateDomainStatus(n, 34, n2);
    }

    public void updateDomainStatusMediaRouter(int n, int n2) {
        this.updateDomainStatus(n, 35, n2);
    }

    public void updateDomainStatusRadioDataServer(int n, int n2) {
        this.updateDomainStatus(n, 36, n2);
    }

    public void updateDomainStatusSmartphoneIntegration(int n, int n2) {
        this.updateDomainStatus(n, 37, n2);
    }

    public void updateDomainStatusWirelessCharger(int n, int n2) {
        this.updateDomainStatus(n, 38, n2);
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "asyncException( %2, %1, %3 )", (Object)string, (long)n, (long)n2);
    }

    private class Domain {
        int id;
        int updated;
        boolean enabled = true;
        private boolean waitForFrontMU;
        List actionHistory = new LinkedList();

        Domain(int n) {
            this.id = n;
            this.updated = 0;
            this.waitForFrontMU = n == 3 || n == 6;
        }

        boolean isUpdated(int n) {
            return DomainHandler.isIncluded(n, this.updated);
        }

        boolean mustWaitForFrontMU() {
            return this.waitForFrontMU;
        }

        void disable() {
            this.enabled = false;
        }

        boolean isEnabled() {
            return this.enabled;
        }

        boolean startPrepare(int n) {
            if (this.isUpdated(n) || DomainHandler.isFailed(this.updated)) {
                return false;
            }
            this.actionHistory.add(new DomainHistoryElement(0, n));
            return true;
        }

        void finishedPrepare(int n) {
            this.actionHistory.add(new DomainHistoryElement(1, n));
        }

        boolean waitForStartFinished(int n) {
            long l = DomainHandler.this.getFramework().getMonotonicTime() + MAX_DOMAIN_START_WAIT;
            long l2 = MAX_DOMAIN_START_WAIT + 1L;
            while (!this.isUpdated(n) && !DomainHandler.isFailed(this.updated) && l2 > 0L) {
                try {
                    DomainHandler.this.getDomainSyncer().wait(l2);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                l2 = l - DomainHandler.this.getFramework().getMonotonicTime() + 1L;
            }
            return this.isUpdated(n) && !DomainHandler.isFailed(this.updated);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void updateState(int n) {
            Object object = DomainHandler.this.getDomainSyncer();
            synchronized (object) {
                this.actionHistory.add(new DomainHistoryElement(2, n));
                this.updated = n;
                DomainHandler.this.getDomainSyncer().notifyAll();
            }
        }

        void dumpState(PrintStream printStream, String string) {
            printStream.print(string);
            printStream.print("Domain: ");
            printStream.print(this.id);
            printStream.print(" = ");
            printStream.print(DomainHandler.getDomainName(this.id));
            String string2 = new StringBuffer().append(string).append("\t").toString();
            Iterator iterator = this.actionHistory.iterator();
            while (iterator.hasNext()) {
                printStream.print(string2);
                printStream.print(iterator.next());
            }
        }
    }

    private class DomainHistoryElement {
        static final int ACTION_REQUESTED = 0;
        static final int ACTION_RESPONDED = 1;
        static final int ACTION_UPDATED = 2;
        private long timestamp;
        private int action;
        private int status;

        DomainHistoryElement(int n, int n2) {
            this.timestamp = DomainHandler.this.getFramework().getMonotonicTime();
            this.action = n;
            this.status = n2;
        }

        public String toString() {
            return new Buffer(50).append(this.timestamp).append(ACTION_NAMES[this.action]).append("(0x").append(Integer.toHexString(this.status)).append(')').toString();
        }
    }
}

