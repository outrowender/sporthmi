/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.suppservices.AbstractTelDialSuppServiceHandler;
import de.audi.app.phone.evo.suppservices.TelEvoSuppServiceDialHandler$ClampListener;
import de.audi.app.phone.evo.suppservices.TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TelEvoSuppServiceDialHandler
extends AbstractTelDialSuppServiceHandler {
    private final DispatcherBase dispatcher;
    private volatile TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable pendingRequestPopup;
    private final TelEvoSuppServiceDialHandler$ClampListener clampListener;
    private volatile boolean isPhoneReady;

    public TelEvoSuppServiceDialHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.dispatcher = iTelApplication.getFrameworkAccess().getDispatcherManager().createDispatcher("TelEvoSuppServiceDialHandler#dispatcher", new JobLogger(this.log));
        this.clampListener = new TelEvoSuppServiceDialHandler$ClampListener(this, iTelApplication);
        this.addSubPhoneComponent(this.clampListener);
    }

    @Override
    public void init() {
        super.init();
        this.dispatcher.start();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.dispatcher.stop();
    }

    @Override
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
        this.removePopup(-2070674432);
        this.removePopup(-1970011136);
        this.removePopup(-1953233920);
        this.removePopup(-1936456704);
        this.removePopup(-1919679488);
        this.removePopup(-1902902272);
        this.removePopup(-1886125056);
        this.removePopup(-1986788352);
        this.removePopup(-2003565568);
        this.removePopup(-2020342784);
        this.removePopup(-1869347840);
        this.removePopup(-2037120000);
        this.removePopup(-1718352896);
        this.removePopup(-1701575680);
        this.removePopup(-1751907328);
        this.removePopup(-1735130112);
        this.removePopup(-1785461760);
        this.removePopup(-1768684544);
    }

    @Override
    protected void updateSuppServiceHFP() {
        this.showPopup(-2070674432);
    }

    private void hideSuppServiceHFPPartialPopup() {
        this.removePopup(-2070674432);
    }

    @Override
    protected void updateSuppServiceRequested() {
        this.pendingRequestPopup = this.showPartialPopup(-1970011136, true);
    }

    @Override
    protected void updateSuppServiceResponse(boolean bl) {
        if (!bl) {
            this.showRequestNotSuccessful();
        }
    }

    @Override
    protected void responseCWQuery(int n) {
        switch (n) {
            case 1: {
                this.showResponsePopup(-1902902272);
                break;
            }
            case 0: {
                this.showResponsePopup(-1886125056);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelEvoSuppServiceDialHandler#responseCWQuery] unhandled CWSTATE %1", (long)n);
            }
        }
    }

    @Override
    protected void responseCWActivate(int n) {
        switch (n) {
            case 1: {
                this.showResponsePopup(-1785461760);
                break;
            }
            case 0: {
                this.showRequestNotSuccessful();
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelEvoSuppServiceDialHandler#responseCWQuery] unhandled CWSTATE %1", (long)n);
            }
        }
    }

    private void showResponsePopup(int n) {
        if (this.pendingRequestPopup != null) {
            TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable.access$000(this.pendingRequestPopup, n);
            this.pendingRequestPopup = null;
        }
    }

    @Override
    protected void responseCWDeactivate(int n) {
        switch (n) {
            case 1: {
                this.showRequestNotSuccessful();
                break;
            }
            case 0: {
                this.showResponsePopup(-1768684544);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelEvoSuppServiceDialHandler#responseCWQuery] unhandled CWSTATE %1", (long)n);
            }
        }
    }

    @Override
    protected void responseCLIRQuery(int n) {
        switch (n) {
            case 0: {
                this.showResponsePopup(-2037120000);
                break;
            }
            case 2: {
                this.showResponsePopup(-2020342784);
                break;
            }
            case 1: {
                this.showResponsePopup(-1869347840);
                break;
            }
            default: {
                this.log.log(1078071040, "[TelEvoSuppServiceDialHandler#responseCLIRQuery] unhandled telCLIRState=%1", (long)n);
            }
        }
    }

    @Override
    protected void responseCLIRDoNotSendOwnNumber(int n) {
        if (n == 1) {
            this.showResponsePopup(-1751907328);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    @Override
    protected void responseCLIRSendOwnNumber(int n) {
        if (n == 2) {
            this.showResponsePopup(-1735130112);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    @Override
    protected void responseCFQuery(boolean bl) {
        if (bl) {
            this.showResponsePopup(-1986788352);
        } else {
            this.showResponsePopup(-2003565568);
        }
    }

    @Override
    protected void responseCFActivate(boolean bl) {
        if (bl) {
            this.showResponsePopup(-1718352896);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    @Override
    protected void responseCFDeactivate(boolean bl) {
        if (bl) {
            this.showRequestNotSuccessful();
        } else {
            this.showResponsePopup(-1701575680);
        }
    }

    @Override
    protected void responseCFDelete(boolean bl) {
        if (bl) {
            this.showRequestNotSuccessful();
        } else {
            this.showResponsePopup(-1701575680);
        }
    }

    @Override
    protected void responseCFRegistration(boolean bl) {
        if (bl) {
            this.showResponsePopup(-1718352896);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    @Override
    protected void responseSimPinChanged(boolean bl) {
        if (bl) {
            this.showResponsePopup(-1953233920);
        }
    }

    @Override
    protected void responseUSSD(boolean bl) {
        if (bl) {
            this.showResponsePopup(-1919679488);
        } else {
            this.showRequestNotSuccessful();
        }
    }

    protected void showRequestNotSuccessful() {
        this.showResponsePopup(-1936456704);
    }

    private TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable showPartialPopup(int n, boolean bl) {
        TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable telEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable = new TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable(this, n, bl, null);
        this.dispatcher.execute(telEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable);
        return telEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable;
    }

    static /* synthetic */ LogChannel access$200(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ void access$300(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler, int n) {
        telEvoSuppServiceDialHandler.showPopup(n);
    }

    static /* synthetic */ LogChannel access$400(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ LogChannel access$500(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ LogChannel access$600(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ LogChannel access$700(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ void access$800(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler, int n) {
        telEvoSuppServiceDialHandler.removePopup(n);
    }

    static /* synthetic */ LogChannel access$900(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ LogChannel access$1000(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        return telEvoSuppServiceDialHandler.log;
    }

    static /* synthetic */ void access$1100(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler) {
        telEvoSuppServiceDialHandler.hideSuppServiceHFPPartialPopup();
    }
}

