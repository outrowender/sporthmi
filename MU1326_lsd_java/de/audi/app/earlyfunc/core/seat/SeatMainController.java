/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopinComponent;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopupFactory;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.app.earlyfunc.core.seat.PopinAction;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.VisualizationConfig;

public class SeatMainController
implements ISeatMainController,
TimerListener {
    private final ICarApplication application;
    private final LogChannel logChannel;
    private final AbstractSeatPopinComponent component;
    private final SeatPopinConfigurationHandler configurationHandler;
    private SeatPopinContent deferredSeatRequest;
    private boolean popinListenerServiceTracked = false;
    private boolean isStandbyPopupVisible = false;
    private final Timer deferredRequestTimer;
    private static final long DEFERRED_REQUEST_TIMER_TIME;
    private ISeatPopupHandlerController popupHandlerController;
    private ISeatPopupController popupController;
    private final AbstractSeatPopupFactory factory;

    public SeatMainController(AbstractSeatPopupFactory abstractSeatPopupFactory) {
        this.application = abstractSeatPopupFactory.getApplication();
        this.logChannel = abstractSeatPopupFactory.getLogChannel();
        this.component = abstractSeatPopupFactory.getComponent();
        this.factory = abstractSeatPopupFactory;
        this.configurationHandler = this.component.getConfigurationHandler();
        this.deferredRequestTimer = new Timer("SeatPopinControllerProcesDeferredRequestTimer", 0, true, this);
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public SeatPopinConfigurationHandler getConfigurationHandler() {
        return this.configurationHandler;
    }

    @Override
    public void init() {
        this.popupHandlerController = this.factory.createInstancePopupHandlerController();
        this.popupController = this.factory.createInstancePopupController();
        this.popupHandlerController.init(this.factory.getPopupIDs());
    }

    @Override
    public void deinit() {
        this.popupHandlerController.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateConfigurationHandler(SeatViewOptions seatViewOptions) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.getLogChannel().log(1078071040, "[SeatMainController#updateConfigurationHandler] isSeatViewOptionsEmpty: %1", this.isSeatVisualizationConfigEmpty(seatViewOptions));
            this.configurationHandler.updateConfiguration(seatViewOptions);
            if (!this.isSeatVisualizationConfigEmpty(seatViewOptions)) {
                this.popupController.createPopups();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateConfigurationHandler(SeatPneumaticViewOptions seatPneumaticViewOptions) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.getLogChannel().log(1078071040, "[SeatMainController#updateConfigurationHandler] isSeatPneumaticViewOptionsEmpty: %1", this.isSeatPneumaticVisualizationConfigEmpty(seatPneumaticViewOptions));
            this.configurationHandler.updateConfiguration(seatPneumaticViewOptions);
            if (!this.isSeatPneumaticVisualizationConfigEmpty(seatPneumaticViewOptions)) {
                this.popupController.createPneumaticPopups();
            }
        }
    }

    private boolean isSeatVisualizationConfigEmpty(SeatViewOptions seatViewOptions) {
        if (seatViewOptions.getVisualizationConfig1RL() == null || seatViewOptions.getVisualizationConfig1RR() == null || seatViewOptions.getVisualizationConfig2RL() == null || seatViewOptions.getVisualizationConfig2RR() == null) {
            return true;
        }
        VisualizationConfig visualizationConfig = seatViewOptions.getVisualizationConfig1RL();
        VisualizationConfig visualizationConfig2 = seatViewOptions.getVisualizationConfig1RR();
        VisualizationConfig visualizationConfig3 = seatViewOptions.getVisualizationConfig2RL();
        VisualizationConfig visualizationConfig4 = seatViewOptions.getVisualizationConfig2RR();
        return !seatViewOptions.getVisualizationConfig1RL().sitzlaengsverstellung && !visualizationConfig.sitzhoehenverstellung && !visualizationConfig.sitzneigungsverstellung && !visualizationConfig.lehnenneigungsverstellung && !visualizationConfig.kopfstuetzenhoehenverstellung && !visualizationConfig.lordosenweitenverstellung && !visualizationConfig.lordosenhoehenverstellung && !visualizationConfig.sitztiefenverstellung && !visualizationConfig.lehnenkopfverstellung && !visualizationConfig.gurthoehenverstellung && !visualizationConfig.lehnenwangenverstellung && !visualizationConfig.sitzflaechenwangenverstellung && !visualizationConfig.kopfstuetzenlaengsverstellung && !visualizationConfig.fussstuetzenhoehe && !visualizationConfig.rseAufnahmehoehe && !visualizationConfig.rseAufnahmetiefe && !visualizationConfig.fussmattenhoehe && !visualizationConfig.rseDisplay && !visualizationConfig2.sitzlaengsverstellung && !visualizationConfig2.sitzhoehenverstellung && !visualizationConfig2.sitzneigungsverstellung && !visualizationConfig2.lehnenneigungsverstellung && !visualizationConfig2.kopfstuetzenhoehenverstellung && !visualizationConfig2.lordosenweitenverstellung && !visualizationConfig2.lordosenhoehenverstellung && !visualizationConfig2.sitztiefenverstellung && !visualizationConfig2.lehnenkopfverstellung && !visualizationConfig2.gurthoehenverstellung && !visualizationConfig2.lehnenwangenverstellung && !visualizationConfig2.sitzflaechenwangenverstellung && !visualizationConfig2.kopfstuetzenlaengsverstellung && !visualizationConfig2.fussstuetzenhoehe && !visualizationConfig2.rseAufnahmehoehe && !visualizationConfig2.rseAufnahmetiefe && !visualizationConfig2.fussmattenhoehe && !visualizationConfig2.rseDisplay && !visualizationConfig3.sitzlaengsverstellung && !visualizationConfig3.sitzhoehenverstellung && !visualizationConfig3.sitzneigungsverstellung && !visualizationConfig3.lehnenneigungsverstellung && !visualizationConfig3.kopfstuetzenhoehenverstellung && !visualizationConfig3.lordosenweitenverstellung && !visualizationConfig3.lordosenhoehenverstellung && !visualizationConfig3.sitztiefenverstellung && !visualizationConfig3.lehnenkopfverstellung && !visualizationConfig3.gurthoehenverstellung && !visualizationConfig3.lehnenwangenverstellung && !visualizationConfig3.sitzflaechenwangenverstellung && !visualizationConfig3.kopfstuetzenlaengsverstellung && !visualizationConfig3.fussstuetzenhoehe && !visualizationConfig3.rseAufnahmehoehe && !visualizationConfig3.rseAufnahmetiefe && !visualizationConfig3.fussmattenhoehe && !visualizationConfig3.rseDisplay && !visualizationConfig4.sitzlaengsverstellung && !visualizationConfig4.sitzhoehenverstellung && !visualizationConfig4.sitzneigungsverstellung && !visualizationConfig4.lehnenneigungsverstellung && !visualizationConfig4.kopfstuetzenhoehenverstellung && !visualizationConfig4.lordosenweitenverstellung && !visualizationConfig4.lordosenhoehenverstellung && !visualizationConfig4.sitztiefenverstellung && !visualizationConfig4.lehnenkopfverstellung && !visualizationConfig4.gurthoehenverstellung && !visualizationConfig4.lehnenwangenverstellung && !visualizationConfig4.sitzflaechenwangenverstellung && !visualizationConfig4.kopfstuetzenlaengsverstellung && !visualizationConfig4.fussstuetzenhoehe && !visualizationConfig4.rseAufnahmehoehe && !visualizationConfig4.rseAufnahmetiefe && !visualizationConfig4.fussmattenhoehe && !visualizationConfig4.rseDisplay && !seatViewOptions.seatmemoryConfig.seatmemory1RL && !seatViewOptions.seatmemoryConfig.seatmemory1RR && !seatViewOptions.seatmemoryConfig.seatmemory2RL && !seatViewOptions.seatmemoryConfig.seatmemory2RR;
    }

    private boolean isSeatPneumaticVisualizationConfigEmpty(SeatPneumaticViewOptions seatPneumaticViewOptions) {
        if (seatPneumaticViewOptions.getSeatPneumaticConfig().getVisualizationConfig1RL() == null || seatPneumaticViewOptions.getSeatPneumaticConfig().getVisualizationConfig1RR() == null) {
            return true;
        }
        VisualizationConfig visualizationConfig = seatPneumaticViewOptions.getSeatPneumaticConfig().getVisualizationConfig1RL();
        VisualizationConfig visualizationConfig2 = seatPneumaticViewOptions.getSeatPneumaticConfig().getVisualizationConfig1RR();
        return !seatPneumaticViewOptions.getSeatPneumaticConfig().getVisualizationConfig1RL().sitzlaengsverstellung && !visualizationConfig.sitzhoehenverstellung && !visualizationConfig.sitzneigungsverstellung && !visualizationConfig.lehnenneigungsverstellung && !visualizationConfig.kopfstuetzenhoehenverstellung && !visualizationConfig.lordosenweitenverstellung && !visualizationConfig.lordosenhoehenverstellung && !visualizationConfig.sitztiefenverstellung && !visualizationConfig.lehnenkopfverstellung && !visualizationConfig.gurthoehenverstellung && !visualizationConfig.lehnenwangenverstellung && !visualizationConfig.sitzflaechenwangenverstellung && !visualizationConfig.kopfstuetzenlaengsverstellung && !visualizationConfig.fussstuetzenhoehe && !visualizationConfig.rseAufnahmehoehe && !visualizationConfig.rseAufnahmetiefe && !visualizationConfig.fussmattenhoehe && !visualizationConfig.rseDisplay && !visualizationConfig2.sitzlaengsverstellung && !visualizationConfig2.sitzhoehenverstellung && !visualizationConfig2.sitzneigungsverstellung && !visualizationConfig2.lehnenneigungsverstellung && !visualizationConfig2.kopfstuetzenhoehenverstellung && !visualizationConfig2.lordosenweitenverstellung && !visualizationConfig2.lordosenhoehenverstellung && !visualizationConfig2.sitztiefenverstellung && !visualizationConfig2.lehnenkopfverstellung && !visualizationConfig2.gurthoehenverstellung && !visualizationConfig2.lehnenwangenverstellung && !visualizationConfig2.sitzflaechenwangenverstellung && !visualizationConfig2.kopfstuetzenlaengsverstellung && !visualizationConfig2.fussstuetzenhoehe && !visualizationConfig2.rseAufnahmehoehe && !visualizationConfig2.rseAufnahmetiefe && !visualizationConfig2.fussmattenhoehe && !visualizationConfig2.rseDisplay;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSeatPopinListenerServiceTracked(boolean bl) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            if (!this.isSeatPopinListenerServiceTracked() && bl && this.deferredSeatRequest != null) {
                this.deferredRequestTimer.start();
            }
            this.popinListenerServiceTracked = bl;
        }
    }

    private boolean isSeatPopinListenerServiceTracked() {
        return this.popinListenerServiceTracked;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processDeferredRequest() {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            if (this.deferredSeatRequest != null && this.isSeatPopinListenerServiceTracked() && (this.deferredSeatRequest.isPneumaticSeatContent() && this.popupController.arePneumaticSeatPopinsCreated() || !this.deferredSeatRequest.isPneumaticSeatContent() && this.popupController.areSeatPopinsCreated())) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[SeatMainController#processDeferredRequest] process deferred request: content='%1'", (Object)this.deferredSeatRequest);
                }
                this.popupController.performActionOnPopins(this.deferredSeatRequest, PopinAction.POPIN_ACTION_REQUEST, -1);
                this.deferredSeatRequest = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSeatContent(SeatContent seatContent) {
        SeatPopinContent seatPopinContent = new SeatPopinContent(seatContent);
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.popupController.performActionOnPopins(seatPopinContent, PopinAction.POPIN_ACTION_UPDATE, -1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSeatContent(SeatPneumaticContent seatPneumaticContent) {
        SeatPopinContent seatPopinContent = new SeatPopinContent(seatPneumaticContent);
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            this.popupController.performActionOnPopins(seatPopinContent, PopinAction.POPIN_ACTION_UPDATE, -1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestSeatPopin(SeatContent seatContent) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            SeatPopinContent seatPopinContent = new SeatPopinContent(seatContent);
            if (this.popupController.areSeatPopinsCreated() && this.isSeatPopinListenerServiceTracked()) {
                this.deferredSeatRequest = null;
                this.popupController.performActionOnPopins(seatPopinContent, PopinAction.POPIN_ACTION_REQUEST, -1);
            } else {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[SeatMainController#requestSeatPopin] SeatPopup-Request is deferred until %1: content='%2'", (Object)(this.popupController.areSeatPopinsCreated() ? "PartialPopupListener Service is tracked" : "SeatViewOptions are received"), (Object)seatPopinContent);
                }
                this.deferredSeatRequest = seatPopinContent;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestSeatPopin(SeatPneumaticContent seatPneumaticContent) {
        ISeatPopupController iSeatPopupController = this.popupController;
        synchronized (iSeatPopupController) {
            SeatPopinContent seatPopinContent = new SeatPopinContent(seatPneumaticContent);
            if (this.popupController.arePneumaticSeatPopinsCreated() && this.isSeatPopinListenerServiceTracked()) {
                this.deferredSeatRequest = null;
                this.popupController.performActionOnPopins(seatPopinContent, PopinAction.POPIN_ACTION_REQUEST, -1);
            } else {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[SeatMainController#requestSeatPopin] SeatPopup-Request is deferred until %1: content='%2'", (Object)(this.popupController.arePneumaticSeatPopinsCreated() ? "PartialPopupListener Service is tracked" : "SeatPneumaticViewOptions are received"), (Object)seatPopinContent);
                }
                this.deferredSeatRequest = seatPopinContent;
            }
        }
    }

    @Override
    public void acknowledgeSeatPopup(SeatContent seatContent) {
        if (seatContent.getContent1RL() == 0 && seatContent.getContent1RR() == 0) {
            this.getLogChannel().log(1078071040, "[SeatMainController#acknowledgeSeatPopup] acknowledge SeatPopup with NONE content: seatContent='%1'", (Object)seatContent);
            this.setSeatControlPowerManagementActive(false);
        }
    }

    @Override
    public void acknowledgeSeatPopup(SeatPneumaticContent seatPneumaticContent) {
        if (seatPneumaticContent.getContent1RL() == 0 && seatPneumaticContent.getContent1RR() == 0) {
            this.getLogChannel().log(1078071040, "[SeatMainController#acknowledgeSeatPopup] acknowledge SeatPneumaticPopup with NONE content: seatContent='%1'", (Object)seatPneumaticContent);
            this.setSeatControlPowerManagementActive(false);
        }
    }

    @Override
    public void callDSIcancelPopup(SeatContent seatContent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatMainConroller#callDSIcancelPopup] dsi.cancelSeatPopup: cancelContent='%1', cancelReason='%2'", (Object)seatContent, (long)n);
        }
        this.component.getDSI().cancelSeatPopup(seatContent, n);
    }

    @Override
    public void callDSIcancelPopup(SeatPneumaticContent seatPneumaticContent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatMainConroller#callDSIcancelPopup] dsi.cancelSeatPneumaticPopup: cancelContent='%1', cancelReason='%1'", (Object)seatPneumaticContent, (long)n);
        }
        this.component.getDSI().cancelSeatPneumaticPopup(seatPneumaticContent, n);
    }

    @Override
    public void callDSIshowPopup(SeatContent seatContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatMainController#callDSIshowPopup] dsi.showSeatPopup: shownContent='%1'", (Object)seatContent);
        }
        this.component.getDSI().showSeatPopup(seatContent);
    }

    @Override
    public void callDSIshowPopup(SeatPneumaticContent seatPneumaticContent) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatMainController#callDSIshowPopup] dsi.showSeatPneumaticPopup: shownContent='%1'", (Object)seatPneumaticContent);
        }
        this.component.getDSI().showSeatPneumaticPopup(seatPneumaticContent);
    }

    @Override
    public void setSeatControlPowerManagementActive(boolean bl) {
        this.getLogChannel().log(1078071040, "[SeatMainController#setSeatControlPowerManagementActive] powerManager.setExtendedPowerState: active='%1'", bl);
        try {
            if (bl) {
                this.setStandbyPopupVisibilityState();
            }
            this.application.getFrameworkAccess().getPowerMgr().setExtendedPowerState(bl ? 114 : 115, 0);
        }
        catch (Exception exception) {
            this.getLogChannel().log(1000, "[SeatMainController#setSeatControlPowerManagementActive] exception occured during setting extended power state", (Throwable)exception);
        }
    }

    @Override
    public boolean isStandbyPopupVisible() {
        return this.isStandbyPopupVisible;
    }

    private void setStandbyPopupVisibilityState() {
        this.isStandbyPopupVisible = this.getStandbyPopupID() != -1 && this.getCurrentlyVisiblePopupID() == this.getStandbyPopupID();
    }

    private int getStandbyPopupID() {
        return this.component.getStandbyPopupID();
    }

    private int getCurrentlyVisiblePopupID() {
        return this.application.getFrameworkAccess().getHmiServiceApp().getCurrentPopup();
    }

    public Timer getDeferredRequestTimer() {
        return this.deferredRequestTimer;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.processDeferredRequest();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

