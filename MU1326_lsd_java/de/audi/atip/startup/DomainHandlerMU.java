/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.DomainHandler;
import de.audi.atip.startup.DomainHandlerMU$1;
import de.audi.atip.startup.DomainHandlerMU$2;
import de.audi.atip.startup.DomainHandlerMU$3;
import de.audi.atip.startup.DomainHandlerMU$MUDomain;
import de.audi.atip.timer.Timer;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.startup.DSIStartupListener;

public final class DomainHandlerMU
implements DSIStartupListener,
IDSIClient {
    private final Object domainSyncer = new Object();
    private LogChannel log;
    private DomainHandlerMU$MUDomain[] domainState;
    private DomainHandler domainHandler;
    private DSIStartup dsi = null;

    public DomainHandlerMU(LogChannel logChannel) {
        this.log = logChannel;
        logChannel.log(1078071040, "MUDomainHandler( %1 )", (Object)logChannel);
        this.domainState = new DomainHandlerMU$MUDomain[DomainHandler.NR_DOMAINS];
        for (int i2 = 0; i2 < this.domainState.length; ++i2) {
            this.domainState[i2] = new DomainHandlerMU$MUDomain(this, i2);
        }
    }

    private void setNotification(DSIStartup dSIStartup, int[] nArray) {
        if (dSIStartup != null) {
            if (this.log.isInfo()) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    this.log.log(-2137614336, "MUDomainHandler.setNotification for attribute %1", (long)nArray[i2]);
                }
            }
            dSIStartup.setNotification(nArray, (DSIListener)this);
        }
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.log.log(-1601830656, "MUDomainHandler.setDSI( %1 )", (Object)dSIBase);
        if (dSIBase == null || dSIBase instanceof DSIStartup) {
            this.initDSI((DSIStartup)dSIBase);
        } else {
            this.log.log(-1601830656, "MUDomainHandler.setDSI( %1 ) failed! wrong class!", (Object)dSIBase);
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    public void initDSI(DSIStartup dSIStartup) {
        this.log.log(-1601830656, "MUDomainHandler.initDSI( %1 )", (Object)dSIStartup);
        this.dsi = dSIStartup;
        if (dSIStartup != null) {
            this.setNotification(dSIStartup, new int[]{2, 3, 4, 5, 6, 7, 11});
        }
    }

    public DSIStartup getDSI() {
        return this.dsi;
    }

    void initDomainHandler(DomainHandler domainHandler) {
        this.domainHandler = domainHandler;
        new Timer("Media Delay Timer", Long.getLong("startup.rse.media.delay", 0), true, new DomainHandlerMU$1(this)).restart();
        new Timer("Nav Delay Timer", Long.getLong("startup.rse.navi.delay", 0), true, new DomainHandlerMU$2(this)).restart();
        new Timer("Post Delay Timer", Long.getLong("startup.rse.post.delay", 0), true, new DomainHandlerMU$3(this)).restart();
    }

    DomainHandler getDomainHandler() {
        return this.domainHandler;
    }

    protected boolean isDomainStartedOnMU(int n) {
        DomainHandlerMU$MUDomain domainHandlerMU$MUDomain = this.domainState[n];
        return domainHandlerMU$MUDomain.isDomainStarted(8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startDomain(int n, int n2) {
        this.log.log(1078071040, "MUDomainHandler.startDomain( %1, %2 )", (long)n, (long)n2);
        DomainHandlerMU$MUDomain domainHandlerMU$MUDomain = this.domainState[n];
        Object object = this.domainSyncer;
        synchronized (object) {
            domainHandlerMU$MUDomain.finishedPrepare(n2);
            this.domainSyncer.notifyAll();
        }
    }

    private void updateDomainState(int n, int n2, int n3) {
        if (n3 == 1) {
            this.getDomainHandler();
            this.log.log(1078071040, "<- MUDomainHandler.updateDomainStatus%1( %2, %3 )", (Object)DomainHandler.getDomainName(n2), (long)n, (long)n3);
            this.domainState[n2].updateState(n);
        } else {
            this.getDomainHandler();
            this.log.log(1078071040, "invalid MUDomainHandler.updateDomainStatus%1( %2, %3 )", (Object)DomainHandler.getDomainName(n2), (long)n, (long)n3);
        }
    }

    @Override
    public void updateDomainStatusAddressbook(int n, int n2) {
        this.updateDomainState(n, 4, n2);
    }

    @Override
    public void updateDomainStatusAudio(int n, int n2) {
        this.updateDomainState(n, 9, n2);
    }

    @Override
    public void updateDomainStatusCar(int n, int n2) {
        this.updateDomainState(n, 8, n2);
    }

    @Override
    public void updateDomainStatusCommunication(int n, int n2) {
        this.updateDomainState(n, 14, n2);
    }

    @Override
    public void updateDomainStatusEarlyApps(int n, int n2) {
        this.updateDomainState(n, 12, n2);
    }

    @Override
    public void updateDomainStatusInfo(int n, int n2) {
        this.updateDomainState(n, 7, n2);
    }

    @Override
    public void updateDomainStatusMedia(int n, int n2) {
        this.updateDomainState(n, 3, n2);
    }

    @Override
    public void updateDomainStatusNav(int n, int n2) {
        this.updateDomainState(n, 6, n2);
    }

    @Override
    public void updateDomainStatusPhone(int n, int n2) {
        this.updateDomainState(n, 5, n2);
    }

    @Override
    public void updateDomainStatusPostStartup(int n, int n2) {
    }

    @Override
    public void updateDomainStatusRoot(int n, int n2) {
        this.updateDomainState(n, 1, n2);
    }

    @Override
    public void updateDomainStatusSDS(int n, int n2) {
        this.updateDomainState(n, 10, n2);
    }

    @Override
    public void updateDomainStatusSWDL(int n, int n2) {
        this.updateDomainState(n, 11, n2);
    }

    @Override
    public void updateDomainStatusTuner(int n, int n2) {
        this.updateDomainState(n, 2, n2);
    }

    @Override
    public void updateDomainStatusGEMMI(int n, int n2) {
        this.updateDomainState(n, 17, n2);
    }

    @Override
    public void updateDomainStatusBapkombi(int n, int n2) {
        this.updateDomainState(n, 18, n2);
    }

    @Override
    public void updateDomainStatusBluetooth(int n, int n2) {
        this.updateDomainState(n, 19, n2);
    }

    @Override
    public void updateDomainStatusBrowser(int n, int n2) {
        this.updateDomainState(n, 20, n2);
    }

    @Override
    public void updateDomainStatusIpServices(int n, int n2) {
        this.updateDomainState(n, 16, n2);
    }

    @Override
    public void updateDomainStatusExplorer(int n, int n2) {
        this.updateDomainState(n, 21, n2);
    }

    @Override
    public void updateDomainStatusCalendar(int n, int n2) {
        this.updateDomainState(n, 22, n2);
    }

    @Override
    public void updateDomainStatusPictureStore(int n, int n2) {
        this.updateDomainState(n, 23, n2);
    }

    @Override
    public void updateDomainStatusStreetView(int n, int n2) {
        this.updateDomainState(n, 24, n2);
    }

    @Override
    public void updateDomainStatusMobilityHorizon(int n, int n2) {
        this.updateDomainState(n, 25, n2);
    }

    @Override
    public void updateDomainStatusExBoxM(int n, int n2) {
        this.updateDomainState(n, 26, n2);
    }

    @Override
    public void updateDomainStatusMirrorLink(int n, int n2) {
        this.updateDomainState(n, 27, n2);
    }

    @Override
    public void updateDomainStatusSFA(int n, int n2) {
        this.updateDomainState(n, 28, n2);
    }

    @Override
    public void updateDomainStatusSearch(int n, int n2) {
        this.updateDomainState(n, 29, n2);
    }

    @Override
    public void updateDomainStatusDiagnosis(int n, int n2) {
        this.updateDomainState(n, 30, n2);
    }

    @Override
    public void updateDomainStatusAsiaLanguageSupport(int n, int n2) {
        this.updateDomainState(n, 31, n2);
    }

    @Override
    public void updateDomainStatusExLAP(int n, int n2) {
        this.updateDomainState(n, 32, n2);
    }

    @Override
    public void updateDomainStatusTVTuner(int n, int n2) {
        this.updateDomainState(n, 33, n2);
    }

    @Override
    public void updateDomainStatusMediaOnline(int n, int n2) {
        this.updateDomainState(n, 34, n2);
    }

    @Override
    public void updateDomainStatusMediaRouter(int n, int n2) {
        this.updateDomainState(n, 35, n2);
    }

    @Override
    public void updateDomainStatusRadioDataServer(int n, int n2) {
        this.updateDomainState(n, 36, n2);
    }

    @Override
    public void updateDomainStatusSmartphoneIntegration(int n, int n2) {
        this.updateDomainState(n, 37, n2);
    }

    @Override
    public void updateDomainStatusWirelessCharger(int n, int n2) {
        this.updateDomainState(n, 38, n2);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    static /* synthetic */ Object access$000(DomainHandlerMU domainHandlerMU) {
        return domainHandlerMU.domainSyncer;
    }
}

