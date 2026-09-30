/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.DomainHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.mib.jdsi.IDSIClient;
import java.io.PrintStream;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.startup.DSIStartupListener;

public final class DomainHandlerMU
implements DSIStartupListener,
IDSIClient {
    private final Object domainSyncer = new Object();
    private LogChannel log;
    private MUDomain[] domainState;
    private DomainHandler domainHandler;
    private DSIStartup dsi = null;

    public DomainHandlerMU(LogChannel logChannel) {
        this.log = logChannel;
        logChannel.log(1000000, "MUDomainHandler( %1 )", (Object)logChannel);
        this.domainState = new MUDomain[DomainHandler.NR_DOMAINS];
        for (int i2 = 0; i2 < this.domainState.length; ++i2) {
            this.domainState[i2] = new MUDomain(i2);
        }
    }

    private void setNotification(DSIStartup dSIStartup, int[] nArray) {
        if (dSIStartup != null) {
            if (this.log.isInfo()) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    this.log.log(10000000, "MUDomainHandler.setNotification for attribute %1", (long)nArray[i2]);
                }
            }
            dSIStartup.setNotification(nArray, (DSIListener)this);
        }
    }

    public void setDSI(DSIBase dSIBase) {
        this.log.log(100000, "MUDomainHandler.setDSI( %1 )", (Object)dSIBase);
        if (dSIBase == null || dSIBase instanceof DSIStartup) {
            this.initDSI((DSIStartup)dSIBase);
        } else {
            this.log.log(100000, "MUDomainHandler.setDSI( %1 ) failed! wrong class!", (Object)dSIBase);
        }
    }

    public int[] getAutoNotifications() {
        return new int[0];
    }

    public void initDSI(DSIStartup dSIStartup) {
        this.log.log(100000, "MUDomainHandler.initDSI( %1 )", (Object)dSIStartup);
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
        new Timer("Media Delay Timer", Long.getLong("startup.rse.media.delay", 90000L), true, new TimerListener(){

            public void cancelTimer(Timer timer) {
            }

            public void fireTimer(Timer timer) {
                DomainHandlerMU.this.updateDomainStatusMedia(8, 1);
            }
        }).restart();
        new Timer("Nav Delay Timer", Long.getLong("startup.rse.navi.delay", 80000L), true, new TimerListener(){

            public void cancelTimer(Timer timer) {
            }

            public void fireTimer(Timer timer) {
                DomainHandlerMU.this.updateDomainStatusNav(8, 1);
            }
        }).restart();
        new Timer("Post Delay Timer", Long.getLong("startup.rse.post.delay", 100000L), true, new TimerListener(){

            public void cancelTimer(Timer timer) {
            }

            public void fireTimer(Timer timer) {
                DomainHandlerMU.this.updateDomainStatusPostStartup(8, 1);
            }
        }).restart();
    }

    DomainHandler getDomainHandler() {
        return this.domainHandler;
    }

    protected boolean isDomainStartedOnMU(int n) {
        MUDomain mUDomain = this.domainState[n];
        return mUDomain.isDomainStarted(8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startDomain(int n, int n2) {
        this.log.log(1000000, "MUDomainHandler.startDomain( %1, %2 )", (long)n, (long)n2);
        MUDomain mUDomain = this.domainState[n];
        Object object = this.domainSyncer;
        synchronized (object) {
            mUDomain.finishedPrepare(n2);
            this.domainSyncer.notifyAll();
        }
    }

    private void updateDomainState(int n, int n2, int n3) {
        if (n3 == 1) {
            this.getDomainHandler();
            this.log.log(1000000, "<- MUDomainHandler.updateDomainStatus%1( %2, %3 )", (Object)DomainHandler.getDomainName(n2), (long)n, (long)n3);
            this.domainState[n2].updateState(n);
        } else {
            this.getDomainHandler();
            this.log.log(1000000, "invalid MUDomainHandler.updateDomainStatus%1( %2, %3 )", (Object)DomainHandler.getDomainName(n2), (long)n, (long)n3);
        }
    }

    public void updateDomainStatusAddressbook(int n, int n2) {
        this.updateDomainState(n, 4, n2);
    }

    public void updateDomainStatusAudio(int n, int n2) {
        this.updateDomainState(n, 9, n2);
    }

    public void updateDomainStatusCar(int n, int n2) {
        this.updateDomainState(n, 8, n2);
    }

    public void updateDomainStatusCommunication(int n, int n2) {
        this.updateDomainState(n, 14, n2);
    }

    public void updateDomainStatusEarlyApps(int n, int n2) {
        this.updateDomainState(n, 12, n2);
    }

    public void updateDomainStatusInfo(int n, int n2) {
        this.updateDomainState(n, 7, n2);
    }

    public void updateDomainStatusMedia(int n, int n2) {
        this.updateDomainState(n, 3, n2);
    }

    public void updateDomainStatusNav(int n, int n2) {
        this.updateDomainState(n, 6, n2);
    }

    public void updateDomainStatusPhone(int n, int n2) {
        this.updateDomainState(n, 5, n2);
    }

    public void updateDomainStatusPostStartup(int n, int n2) {
    }

    public void updateDomainStatusRoot(int n, int n2) {
        this.updateDomainState(n, 1, n2);
    }

    public void updateDomainStatusSDS(int n, int n2) {
        this.updateDomainState(n, 10, n2);
    }

    public void updateDomainStatusSWDL(int n, int n2) {
        this.updateDomainState(n, 11, n2);
    }

    public void updateDomainStatusTuner(int n, int n2) {
        this.updateDomainState(n, 2, n2);
    }

    public void updateDomainStatusGEMMI(int n, int n2) {
        this.updateDomainState(n, 17, n2);
    }

    public void updateDomainStatusBapkombi(int n, int n2) {
        this.updateDomainState(n, 18, n2);
    }

    public void updateDomainStatusBluetooth(int n, int n2) {
        this.updateDomainState(n, 19, n2);
    }

    public void updateDomainStatusBrowser(int n, int n2) {
        this.updateDomainState(n, 20, n2);
    }

    public void updateDomainStatusIpServices(int n, int n2) {
        this.updateDomainState(n, 16, n2);
    }

    public void updateDomainStatusExplorer(int n, int n2) {
        this.updateDomainState(n, 21, n2);
    }

    public void updateDomainStatusCalendar(int n, int n2) {
        this.updateDomainState(n, 22, n2);
    }

    public void updateDomainStatusPictureStore(int n, int n2) {
        this.updateDomainState(n, 23, n2);
    }

    public void updateDomainStatusStreetView(int n, int n2) {
        this.updateDomainState(n, 24, n2);
    }

    public void updateDomainStatusMobilityHorizon(int n, int n2) {
        this.updateDomainState(n, 25, n2);
    }

    public void updateDomainStatusExBoxM(int n, int n2) {
        this.updateDomainState(n, 26, n2);
    }

    public void updateDomainStatusMirrorLink(int n, int n2) {
        this.updateDomainState(n, 27, n2);
    }

    public void updateDomainStatusSFA(int n, int n2) {
        this.updateDomainState(n, 28, n2);
    }

    public void updateDomainStatusSearch(int n, int n2) {
        this.updateDomainState(n, 29, n2);
    }

    public void updateDomainStatusDiagnosis(int n, int n2) {
        this.updateDomainState(n, 30, n2);
    }

    public void updateDomainStatusAsiaLanguageSupport(int n, int n2) {
        this.updateDomainState(n, 31, n2);
    }

    public void updateDomainStatusExLAP(int n, int n2) {
        this.updateDomainState(n, 32, n2);
    }

    public void updateDomainStatusTVTuner(int n, int n2) {
        this.updateDomainState(n, 33, n2);
    }

    public void updateDomainStatusMediaOnline(int n, int n2) {
        this.updateDomainState(n, 34, n2);
    }

    public void updateDomainStatusMediaRouter(int n, int n2) {
        this.updateDomainState(n, 35, n2);
    }

    public void updateDomainStatusRadioDataServer(int n, int n2) {
        this.updateDomainState(n, 36, n2);
    }

    public void updateDomainStatusSmartphoneIntegration(int n, int n2) {
        this.updateDomainState(n, 37, n2);
    }

    public void updateDomainStatusWirelessCharger(int n, int n2) {
        this.updateDomainState(n, 38, n2);
    }

    public void asyncException(int n, String string, int n2) {
    }

    private class MUDomain {
        int id;
        int requested;
        int responded;
        int updated;
        int propagated;
        long[] timeRequested = new long[17];
        long[] timeResponded = new long[17];
        long[] timeUpdated = new long[17];

        MUDomain(int n) {
            this.id = n;
            this.requested = 0;
            this.responded = 0;
            this.updated = 0;
            this.propagated = 0;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean isDomainStarted(int n) {
            Object object = DomainHandlerMU.this.domainSyncer;
            synchronized (object) {
                return this.responded >= n || this.updated >= n;
            }
        }

        void propagateState(int n) {
            if (n > this.propagated) {
                this.propagated = n;
                DomainHandlerMU.this.getDomainHandler().updateMUDomain(this.id, n);
            }
        }

        boolean startPrepare(int n) {
            if (n > this.requested) {
                this.requested = n;
                if (this.timeRequested[n] == 0L) {
                    this.timeRequested[n] = System.currentTimeMillis();
                }
                return true;
            }
            return false;
        }

        void finishedPrepare(int n) {
            if (n > this.responded) {
                this.responded = n;
                if (this.timeResponded[n] == 0L) {
                    this.timeResponded[n] = System.currentTimeMillis();
                }
                this.propagateState(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void updateState(int n) {
            Object object = DomainHandlerMU.this.domainSyncer;
            synchronized (object) {
                if (n > this.updated) {
                    this.updated = n;
                    if (this.timeUpdated[n] == 0L) {
                        this.timeUpdated[n] = System.currentTimeMillis();
                    }
                    this.propagateState(n);
                }
            }
        }

        void dumpState(PrintStream printStream, String string) {
            printStream.print(string);
            printStream.print("Domain: ");
            printStream.print(this.id);
            printStream.print(" ( state, requested, responded, updated )");
            for (int i2 = 2; i2 <= 16; ++i2) {
                printStream.print(string);
                printStream.print("(");
                printStream.print(i2);
                printStream.print(",");
                printStream.print(this.timeRequested[i2]);
                printStream.print(",");
                printStream.print(this.timeResponded[i2]);
                printStream.print(",");
                printStream.print(this.timeUpdated[i2]);
                printStream.print(")");
            }
        }
    }
}

