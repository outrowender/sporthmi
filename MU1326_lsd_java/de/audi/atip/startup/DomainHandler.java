/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.IDomainListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.DomainHandler$1;
import de.audi.atip.startup.DomainHandler$Domain;
import de.audi.atip.startup.DomainHandlerMU;
import de.audi.mib.jdsi.IDSIClient;
import java.io.PrintStream;
import java.util.ArrayList;
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
    public static final long DSI_STARTUP_TIMEOUT;
    private static final long DEFAULT_DOMAIN_START_TIMEOUT;
    private static final long MAX_DOMAIN_START_WAIT;
    private final IFrameworkAccess framework;
    private final Object DOMAIN_SYNCER = new Object();
    private final Object syncDSIStartup = new Object();
    private volatile boolean dsiAvailable = false;
    private final List listeners = new ArrayList(2);
    private DSIStartup dsiProvider = null;
    private final LogChannel log;
    private final LogChannel logExtStartup;
    private DomainHandler$Domain[] domains;
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
        this.log.log(1078071040, "DomainHandler()");
        this.domains = new DomainHandler$Domain[NR_DOMAINS];
        for (int i2 = 0; i2 < this.domains.length; ++i2) {
            this.domains[i2] = new DomainHandler$Domain(this, i2);
        }
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(new DomainHandler$1(this));
    }

    Object getDomainSyncer() {
        return this.DOMAIN_SYNCER;
    }

    public void addDomainListener(IDomainListener iDomainListener) {
        if (iDomainListener != null) {
            this.listeners.add(iDomainListener);
            for (int i2 = 0; i2 < this.domains.length; ++i2) {
                DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(i2);
                if (domainHandler$Domain == null) continue;
                iDomainListener.updateDomainState(i2, domainHandler$Domain.updated);
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
                    this.log.log(-2137614336, "DSIStartup.setNotification for attribute %1", (long)nArray[i2]);
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
        this.log.log(1078071040, "DomainHandler.waitForDSIStartup()");
        Object object = this.syncDSIStartup;
        synchronized (object) {
            if (!this.dsiAvailable) {
                this.log.log(1078071040, "DomainHandler.waitForDSIStartup() wait %1 seconds for DSIStartup", (long)0);
                try {
                    this.syncDSIStartup.wait(0);
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

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.log.log(-1601830656, "setDSI( %1 )", (Object)dSIBase);
        if (dSIBase instanceof DSIStartup) {
            this.initDSI((DSIStartup)dSIBase);
        } else if (dSIBase == null) {
            this.dsiProvider = null;
            this.log.log(10000, "DomainHandler: DSIStartup provider is NULL!");
        } else {
            this.log.log(-1601830656, "setDSI( %1 ) failed! wrong class!", (Object)dSIBase);
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    public void initDSI(DSIStartup dSIStartup) {
        this.log.log(-1601830656, "initDSI( %1 )", (Object)dSIStartup);
        this.dsiProvider = dSIStartup;
        this.setNotification(dSIStartup, new int[]{2, 3, 4, 5, 6, 10, 11, 16, 19, 20, 21, 22, 23, 24, 28, 30, 31, 32, 33, 34, 35, 36});
        this.markDSIStartupAsAvailable();
    }

    public DSIStartup getDSI() {
        return this.dsiProvider;
    }

    private DomainHandler$Domain getDomainByDomainId(int n) {
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
        this.log.log(-1601830656, "setDomainHandlerMU( %1 )", (Object)domainHandlerMU);
        this.domainHandlerMU = domainHandlerMU;
        domainHandlerMU.initDomainHandler(this);
    }

    public DomainHandlerMU getDomainHandlerMU() {
        return this.domainHandlerMU;
    }

    public boolean isDomainStartedOnMU(int n) {
        DomainHandler$Domain domainHandler$Domain;
        DomainHandlerMU domainHandlerMU = this.getDomainHandlerMU();
        if (domainHandlerMU != null && (domainHandler$Domain = this.getDomainByDomainId(n)) != null && domainHandler$Domain.mustWaitForFrontMU()) {
            return domainHandlerMU.isDomainStartedOnMU(n);
        }
        return true;
    }

    public void updateMUDomain(int n, int n2) {
        this.log.log(-2137614336, "updateMUDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null && domainHandler$Domain.mustWaitForFrontMU()) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((IDomainListener)this.listeners.get(i2)).muDomainIsAvailable(n, n2);
            }
        }
    }

    void informHMICompletelyStarted() {
        if (this.dsiProvider != null) {
            this.log.log(-2137614336, "DomainHandler::informDSICompletelyStarted");
            this.dsiProvider.hmiCompletelyStarted();
        } else {
            this.log.log(10000, "DomainHandler::informDSICompletelyStarted: DSIStartup isn't initialized");
        }
    }

    public void disableDomain(int n) {
        this.log.log(-2137614336, "DomainHandler.disableDomain( %1 )!", (Object)DomainHandler.getDomainName(n));
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            domainHandler$Domain.disable();
        }
    }

    public boolean isDomainEnabled(int n) {
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            return domainHandler$Domain.isEnabled();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int doStartDomain(int n, int n2) {
        this.log.log(-2137614336, "DomainHandler.doStartDomain( %1, 0x%2 )!", (Object)DomainHandler.getDomainName(n), (long)n2);
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            Object object = this.getDomainSyncer();
            synchronized (object) {
                if (!domainHandler$Domain.isEnabled()) {
                    this.log.log(1078071040, "-> DomainHandler.doStartDomain( %1, 0x%2 ): Domain is disabled!", (Object)DomainHandler.getDomainName(n), (long)n2);
                    return domainHandler$Domain.updated;
                }
                if (domainHandler$Domain.startPrepare(n2)) {
                    this.log.log(1078071040, "-> DSIStartup.startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    this.logExtStartup.log(1078071040, "startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    if (this.dsiProvider != null) {
                        this.dsiProvider.startDomain(n, n2);
                    } else {
                        this.log.log(1000, "DSIStartup not available -> simulate responses");
                    }
                } else {
                    this.log.log(-2137614336, "DomainHandler.doStartDomain( %1, 0x%2 ) do nothing, domain has already reached state 0x%3", (Object)DomainHandler.getDomainName(n), (long)n2, (long)domainHandler$Domain.updated);
                    return domainHandler$Domain.updated;
                }
                if (domainHandler$Domain.waitForStartFinished(n2)) {
                    this.log.log(-2137614336, "DSIStartup.startDomain( %1, 0x%2 ) succeeded! current state is: 0x%3", (Object)DomainHandler.getDomainName(n), (long)n2, (long)domainHandler$Domain.updated);
                } else {
                    String string = DomainHandler.getDomainName(n);
                    this.log.log(-1601830656, "DSIStartup.startDomain( %1, 0x%2 ) timed out! current state is: 0x%3", (Object)string, (long)n2, (long)domainHandler$Domain.updated);
                    this.logExtStartup.log(-1601830656, "startDomain( %1, 0x%2 ) timed out!", (Object)string, (long)n2);
                    this.logExtStartup.log(-1601830656, "%1 requested: [ 0x%2 ] current state is: [ 0x%3 ]", (Object)string, (long)n2, (long)domainHandler$Domain.updated);
                }
                return domainHandler$Domain.updated;
            }
        }
        this.log.log(-1601830656, "DomainHandler.doStartDomain: Preparing to start undefined domain!");
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void doStartDomainAsync(int n, int n2) {
        this.log.log(-2137614336, "DomainHandler.prepareDomainAsync( %1, 0x%2 )!", (Object)DomainHandler.getDomainName(n), (long)n2);
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            Object object = this.getDomainSyncer();
            synchronized (object) {
                if (!domainHandler$Domain.isEnabled()) {
                    this.log.log(1078071040, "-> DomainHandler.doStartDomainAsync( %1, 0x%2 ): Domain is disabled!", (Object)DomainHandler.getDomainName(n), (long)n2);
                    return;
                }
                if (domainHandler$Domain.startPrepare(n2)) {
                    this.log.log(1078071040, "-> DSIStartup.startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    this.logExtStartup.log(1078071040, "startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
                    if (this.dsiProvider != null) {
                        this.dsiProvider.startDomain(n, n2);
                    } else {
                        this.log.log(1000, "DSIStartup not available -> simulate responses");
                    }
                } else {
                    this.log.log(-2137614336, "DomainHandler.doStartDomainAsync( %1, 0x%2 ) do nothing, domain has already reached state 0x%3", (Object)DomainHandler.getDomainName(n), (long)n2, (long)domainHandler$Domain.updated);
                    return;
                }
            }
        } else {
            this.log.log(-1601830656, "DomainHandler.doStartDomainAsync: Preparing to start undefined domain!");
            return;
        }
    }

    boolean isWaitingForResponse(int n, int n2) {
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            return !DomainHandler.isIncluded(n2, domainHandler$Domain.updated);
        }
        return false;
    }

    public boolean isDomainStartedToState(int n, int n2) {
        if (n == 0 || n2 == 0) {
            return true;
        }
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            return DomainHandler.isIncluded(n2, domainHandler$Domain.updated);
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
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            domainHandler$Domain.updateState(n2);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((IDomainListener)this.listeners.get(i2)).updateDomainState(n, n2);
            }
        }
    }

    private void updateDomainStatus(int n, int n2, int n3) {
        if (n3 == 1) {
            if (n == 0) {
                this.log.log(1078071040, "<- updateDomainStatus( %1, 0x%2 ), status is 0 ( = DOMAIN_STATE_NOT_INIT ), use 1 (= DOMAIN_STATE_NOT_STARTED) instead", (Object)DomainHandler.getDomainName(n2), (long)n);
                n = 1;
            }
            this.log.log(1078071040, "<- updateDomainStatus( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n2), (long)n);
            int n4 = n == 8 ? 14 : (n == 4 ? 6 : n);
            this.doUpdateDomainStatus(n2, n4);
        } else {
            this.log.log(-2137614336, "updateDomainStatus( %1, 0x%2 ), ignore: domain attribute is invalid", (Object)DomainHandler.getDomainName(n2), (long)n);
        }
    }

    @Override
    public void startDomain(int n, int n2) {
        this.log.log(1078071040, "<- startDomain( %1, 0x%2 )", (Object)DomainHandler.getDomainName(n), (long)n2);
        int n3 = n2 == 8 ? 14 : (n2 == 4 ? 6 : n2);
        DomainHandler$Domain domainHandler$Domain = this.getDomainByDomainId(n);
        if (domainHandler$Domain != null) {
            domainHandler$Domain.finishedPrepare(n3);
            if (DomainHandler.isFailed(n3)) {
                this.doUpdateDomainStatus(n, n3);
            }
        }
    }

    @Override
    public void updateDomainStatusRoot(int n, int n2) {
        this.updateDomainStatus(n, 1, n2);
    }

    @Override
    public void updateDomainStatusTuner(int n, int n2) {
        this.updateDomainStatus(n, 2, n2);
    }

    @Override
    public void updateDomainStatusMedia(int n, int n2) {
        this.updateDomainStatus(n, 3, n2);
    }

    @Override
    public void updateDomainStatusAddressbook(int n, int n2) {
        this.updateDomainStatus(n, 4, n2);
    }

    @Override
    public void updateDomainStatusPhone(int n, int n2) {
        this.updateDomainStatus(n, 5, n2);
    }

    @Override
    public void updateDomainStatusNav(int n, int n2) {
        this.updateDomainStatus(n, 6, n2);
    }

    @Override
    public void updateDomainStatusInfo(int n, int n2) {
        this.updateDomainStatus(n, 7, n2);
    }

    @Override
    public void updateDomainStatusCar(int n, int n2) {
        this.updateDomainStatus(n, 8, n2);
    }

    @Override
    public void updateDomainStatusAudio(int n, int n2) {
        this.updateDomainStatus(n, 9, n2);
    }

    @Override
    public void updateDomainStatusSDS(int n, int n2) {
        this.updateDomainStatus(n, 10, n2);
    }

    @Override
    public void updateDomainStatusSWDL(int n, int n2) {
        this.updateDomainStatus(n, 11, n2);
    }

    @Override
    public void updateDomainStatusEarlyApps(int n, int n2) {
        this.updateDomainStatus(n, 12, n2);
    }

    @Override
    public void updateDomainStatusPostStartup(int n, int n2) {
    }

    @Override
    public void updateDomainStatusCommunication(int n, int n2) {
        this.updateDomainStatus(n, 14, n2);
    }

    @Override
    public void updateDomainStatusIpServices(int n, int n2) {
        this.updateDomainStatus(n, 16, n2);
    }

    @Override
    public void updateDomainStatusGEMMI(int n, int n2) {
        this.updateDomainStatus(n, 17, n2);
    }

    @Override
    public void updateDomainStatusBapkombi(int n, int n2) {
        this.updateDomainStatus(n, 18, n2);
    }

    @Override
    public void updateDomainStatusBluetooth(int n, int n2) {
        this.updateDomainStatus(n, 19, n2);
    }

    @Override
    public void updateDomainStatusBrowser(int n, int n2) {
        this.updateDomainStatus(n, 20, n2);
    }

    @Override
    public void updateDomainStatusExplorer(int n, int n2) {
        this.updateDomainStatus(n, 21, n2);
    }

    @Override
    public void updateDomainStatusCalendar(int n, int n2) {
        this.updateDomainStatus(n, 22, n2);
    }

    @Override
    public void updateDomainStatusPictureStore(int n, int n2) {
        this.updateDomainStatus(n, 23, n2);
    }

    @Override
    public void updateDomainStatusStreetView(int n, int n2) {
        this.updateDomainStatus(n, 24, n2);
    }

    @Override
    public void updateDomainStatusMobilityHorizon(int n, int n2) {
        this.updateDomainStatus(n, 25, n2);
    }

    @Override
    public void updateDomainStatusExBoxM(int n, int n2) {
        this.updateDomainStatus(n, 26, n2);
    }

    @Override
    public void updateDomainStatusMirrorLink(int n, int n2) {
        this.updateDomainStatus(n, 27, n2);
    }

    @Override
    public void updateDomainStatusSFA(int n, int n2) {
        this.updateDomainStatus(n, 28, n2);
    }

    @Override
    public void updateDomainStatusSearch(int n, int n2) {
        this.updateDomainStatus(n, 29, n2);
    }

    @Override
    public void updateDomainStatusDiagnosis(int n, int n2) {
        this.updateDomainStatus(n, 30, n2);
    }

    @Override
    public void updateDomainStatusAsiaLanguageSupport(int n, int n2) {
        this.updateDomainStatus(n, 31, n2);
    }

    @Override
    public void updateDomainStatusExLAP(int n, int n2) {
        this.updateDomainStatus(n, 32, n2);
    }

    @Override
    public void updateDomainStatusTVTuner(int n, int n2) {
        this.updateDomainStatus(n, 33, n2);
    }

    @Override
    public void updateDomainStatusMediaOnline(int n, int n2) {
        this.updateDomainStatus(n, 34, n2);
    }

    @Override
    public void updateDomainStatusMediaRouter(int n, int n2) {
        this.updateDomainStatus(n, 35, n2);
    }

    @Override
    public void updateDomainStatusRadioDataServer(int n, int n2) {
        this.updateDomainStatus(n, 36, n2);
    }

    @Override
    public void updateDomainStatusSmartphoneIntegration(int n, int n2) {
        this.updateDomainStatus(n, 37, n2);
    }

    @Override
    public void updateDomainStatusWirelessCharger(int n, int n2) {
        this.updateDomainStatus(n, 38, n2);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "asyncException( %2, %1, %3 )", (Object)string, (long)n, (long)n2);
    }

    static /* synthetic */ IFrameworkAccess access$000(DomainHandler domainHandler) {
        return domainHandler.getFramework();
    }

    static /* synthetic */ String[] access$100() {
        return ACTION_NAMES;
    }

    static /* synthetic */ long access$200() {
        return MAX_DOMAIN_START_WAIT;
    }

    static {
        MAX_DOMAIN_START_WAIT = Long.getLong("startup.max.domain.wait", 0);
    }
}

