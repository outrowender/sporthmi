/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.power.TelDefaultPowerEventListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.AbstractTelDialSuppServiceHandler;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TelEvoSuppServiceDialHandler
extends AbstractTelDialSuppServiceHandler {
    private final DispatcherBase dispatcher;
    private volatile SuppServiceShowPopupRunnable pendingRequestPopup;
    private final ClampListener clampListener;
    private volatile boolean isPhoneReady;

    public TelEvoSuppServiceDialHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.dispatcher = iTelApplication.getFrameworkAccess().getDispatcherManager().createDispatcher("TelEvoSuppServiceDialHandler#dispatcher", new JobLogger(this.log));
        this.clampListener = new ClampListener(iTelApplication);
        this.addSubPhoneComponent(this.clampListener);
    }

    public void init() {
        super.init();
        this.dispatcher.start();
    }

    public void deinit() {
        super.deinit();
        this.dispatcher.stop();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        boolean bl;
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        boolean bl2 = bl = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isPhoneReady();
        if (this.isPhoneReady && !bl) {
            this.removeAllPopups();
        }
        this.isPhoneReady = bl;
    }

    private void showPopup(int n) {
        if (this.isPhoneReady) {
            this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(0, n);
        }
    }

    private void removePopup(int n) {
        this.getApplication().getFrameworkAccess().getHMIService().removePartialPopup(0, n);
    }

    private void removeAllPopups() {
        this.removePopup(300164);
        this.removePopup(300170);
        this.removePopup(300171);
        this.removePopup(300172);
        this.removePopup(300173);
        this.removePopup(300174);
        this.removePopup(300175);
        this.removePopup(300169);
        this.removePopup(300168);
        this.removePopup(300167);
        this.removePopup(300176);
        this.removePopup(300166);
        this.removePopup(300185);
        this.removePopup(300186);
        this.removePopup(300183);
        this.removePopup(300184);
        this.removePopup(300181);
        this.removePopup(300182);
    }

    protected void updateSuppServiceHFP() {
        this.showPopup(300164);
    }

    private void hideSuppServiceHFPPartialPopup() {
        this.removePopup(300164);
    }

    protected void updateSuppServiceRequested() {
        this.pendingRequestPopup = this.showPartialPopup(300170, true);
    }

    protected void updateSuppServiceResponse(boolean bl) {
        if (!bl) {
            this.showRequestNotSuccessful();
        }
    }

    protected void responseCWQuery(int n) {
        switch (n) {
            case 1: {
                this.showResponsePopup(300174);
                break;
            }
            case 0: {
                this.showResponsePopup(300175);
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoSuppServiceDialHandler#responseCWQuery] unhandled CWSTATE %1", (long)n);
            }
        }
    }

    protected void responseCWActivate(int n) {
        switch (n) {
            case 1: {
                this.showResponsePopup(300181);
                break;
            }
            case 0: {
                this.showRequestNotSuccessful();
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoSuppServiceDialHandler#responseCWQuery] unhandled CWSTATE %1", (long)n);
            }
        }
    }

    private void showResponsePopup(int n) {
        if (this.pendingRequestPopup != null) {
            this.pendingRequestPopup.responseReceived(n);
            this.pendingRequestPopup = null;
        }
    }

    protected void responseCWDeactivate(int n) {
        switch (n) {
            case 1: {
                this.showRequestNotSuccessful();
                break;
            }
            case 0: {
                this.showResponsePopup(300182);
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoSuppServiceDialHandler#responseCWQuery] unhandled CWSTATE %1", (long)n);
            }
        }
    }

    protected void responseCLIRQuery(int n) {
        switch (n) {
            case 0: {
                this.showResponsePopup(300166);
                break;
            }
            case 2: {
                this.showResponsePopup(300167);
                break;
            }
            case 1: {
                this.showResponsePopup(300176);
                break;
            }
            default: {
                this.log.log(1000000, "[TelEvoSuppServiceDialHandler#responseCLIRQuery] unhandled telCLIRState=%1", (long)n);
            }
        }
    }

    protected void responseCLIRDoNotSendOwnNumber(int n) {
        if (n == 1) {
            this.showResponsePopup(300183);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    protected void responseCLIRSendOwnNumber(int n) {
        if (n == 2) {
            this.showResponsePopup(300184);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    protected void responseCFQuery(boolean bl) {
        if (bl) {
            this.showResponsePopup(300169);
        } else {
            this.showResponsePopup(300168);
        }
    }

    protected void responseCFActivate(boolean bl) {
        if (bl) {
            this.showResponsePopup(300185);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    protected void responseCFDeactivate(boolean bl) {
        if (bl) {
            this.showRequestNotSuccessful();
        } else {
            this.showResponsePopup(300186);
        }
    }

    protected void responseCFDelete(boolean bl) {
        if (bl) {
            this.showRequestNotSuccessful();
        } else {
            this.showResponsePopup(300186);
        }
    }

    protected void responseCFRegistration(boolean bl) {
        if (bl) {
            this.showResponsePopup(300185);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    protected void responseSimPinChanged(boolean bl) {
        if (bl) {
            this.showResponsePopup(300171);
        }
    }

    protected void responseUSSD(boolean bl) {
        if (bl) {
            this.showResponsePopup(300173);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    protected void showRequestNotSuccessful() {
        this.showResponsePopup(300172);
    }

    private SuppServiceShowPopupRunnable showPartialPopup(int n, boolean bl) {
        SuppServiceShowPopupRunnable suppServiceShowPopupRunnable = new SuppServiceShowPopupRunnable(n, bl);
        this.dispatcher.execute(suppServiceShowPopupRunnable);
        return suppServiceShowPopupRunnable;
    }

    private class ClampListener
    extends TelDefaultPowerEventListener {
        public ClampListener(ITelApplication iTelApplication) {
            super(iTelApplication);
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            if (!bl && !bl2) {
                TelEvoSuppServiceDialHandler.this.hideSuppServiceHFPPartialPopup();
            }
        }
    }

    private class SuppServiceShowPopupRunnable
    implements Runnable {
        private static final long MIN_SHOW_TIME = 3000L;
        private static final int POPUP_NONE = 0;
        private final int requestPopupId;
        private final Object minShowTimeMutext = new Object();
        private final Object responseMutex = new Object();
        private final boolean waitForResponse;
        private volatile boolean responseReceived;
        private volatile int responsePopupId;

        private SuppServiceShowPopupRunnable(int n, boolean bl) {
            this.requestPopupId = n;
            this.waitForResponse = bl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            TelEvoSuppServiceDialHandler.this.log.log(10000000, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] showing request popup %1", (long)this.requestPopupId);
            TelEvoSuppServiceDialHandler.this.showPopup(this.requestPopupId);
            Object object = this.minShowTimeMutext;
            synchronized (object) {
                try {
                    this.minShowTimeMutext.wait(3000L);
                }
                catch (InterruptedException interruptedException) {
                    TelEvoSuppServiceDialHandler.this.log.log(100000, "[TelEvoSuppServiceDialHandler.SuppServicePopupRunnable#run]", (Throwable)interruptedException);
                    Thread.interrupted();
                }
            }
            if (this.waitForResponse) {
                object = this.responseMutex;
                synchronized (object) {
                    if (!this.responseReceived) {
                        try {
                            this.responseMutex.wait();
                        }
                        catch (InterruptedException interruptedException) {
                            TelEvoSuppServiceDialHandler.this.log.log(100000, "[TelEvoSuppServiceDialHandler.SuppServicePopupRunnable#run]", (Throwable)interruptedException);
                            Thread.interrupted();
                        }
                    }
                }
                if (this.responseReceived && this.responsePopupId != 0) {
                    TelEvoSuppServiceDialHandler.this.log.log(10000000, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] showing response popup %1", (long)this.responsePopupId);
                    TelEvoSuppServiceDialHandler.this.showPopup(this.responsePopupId);
                    TelEvoSuppServiceDialHandler.this.log.log(10000000, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] removing request popup %1", (long)this.requestPopupId);
                    TelEvoSuppServiceDialHandler.this.removePopup(this.requestPopupId);
                }
            } else {
                TelEvoSuppServiceDialHandler.this.log.log(10000000, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] removing request popup %1", (long)this.requestPopupId);
                TelEvoSuppServiceDialHandler.this.removePopup(this.requestPopupId);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void responseReceived(int n) {
            TelEvoSuppServiceDialHandler.this.log.log(10000000, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#responseReceived] responsePopupId=%1", (long)n);
            Object object = this.responseMutex;
            synchronized (object) {
                this.responsePopupId = n;
                this.responseReceived = true;
                this.responseMutex.notifyAll();
            }
        }
    }
}

