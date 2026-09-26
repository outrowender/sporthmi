/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer;

import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.AbstractDriverResetHandler;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;

public abstract class AbstractCustDownloadActionProxy
implements I18NTarget {
    private final SwdlEnv swdlEnv;
    private final SwdlDSIManager swdlDSIManager;
    protected AbstractDriverResetHandler driverResetHandler;

    public AbstractCustDownloadActionProxy(SwdlEnv swdlEnv, SwdlDSIManager swdlDSIManager) {
        this.swdlEnv = swdlEnv;
        this.swdlDSIManager = swdlDSIManager;
    }

    private final CustomerDLState getCustomerDLState() {
        return this.getSwdlEnv().getCustomerDLState();
    }

    @Override
    public void setLanguage(Language language) {
        this.getLogMain().log(1078071040, "AbstractCustDownloadActionProxy.setLanguage(language=%1)", (Object)language);
        this.getCustomerDLState().setLanguage(language);
        this.getUotaController().setLanguage(language);
    }

    public void readyForCustomerUpdate(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.readyForCustomerUpdate(terminalID=%1)", (long)n);
    }

    public void resetSummaryUpdateCompleteStatus(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.resetSummaryUpdateCompleteStatus(terminalID=%1)", (long)n);
        if (this.getSelectionDSIHandler().isUserDownloadInterrupted()) {
            this.getSwdlModels().getCustomerUpdateAgainRequestChoice().setValue(1);
        } else {
            this.getSwdlModels().getCustomerUpdateAgainRequestChoice().setValue(0);
        }
    }

    public void abortProgress(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.abortProgress(terminalID=%1)", (long)n);
        this.getProgressManager().abortProgress(n);
    }

    public void abortProgressError(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.abortProgressError(terminalID=%1)", (long)n);
        this.getProgressManager().abortProgressError(n);
    }

    public void abortProgressInterrupt(int n) {
        this.getLogMain().log(1078071040, "AbstractCustDownloadActionProxy.abortProgressInterrupt(terminalID=%1)", (long)n);
        this.getProgressManager().abortProgressInterrupt(n);
    }

    public void abortSelection(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.abortSelection(terminalID=%1)", (long)n);
        this.getCustomerDLState().abortSelection(n);
    }

    public void swdlCustomerUpdateEntered(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.enterCustomerUpdate(terminal=%1)", (long)n);
        if (!this.getSwdlEnv().isCustomerDownloadActive()) {
            this.getCustomerDLState().startCustomerUpdate(false, n);
        }
    }

    public void swdlCustomerUpdateEnteredFromNavi(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.enterCustomerUpdateFromNavi(terminal=%1)", (long)n);
        this.getSwdlModels().getUotaExcludeNavdataChoiceModel().setValue(1);
        this.swdlCustomerUpdateEntered(n);
    }

    public void swdlCustomerUpdateLeft(int n) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.leaveCustomerUpdate(terminalID=%1)", (long)n);
        this.getCustomerDLState().leaveCustomerUpdate(n);
    }

    public void leaveCustomerUpdatePopups(int n, int n2) {
        this.getLogHMI().log(1078071040, "AbstractCustDownloadActionProxy.leaveCustomerUpdatePopups(terminalID=%1, popupID=%2)", (long)n, (long)n2);
        this.getCustomerDLState().leaveCustomerUpdatePopups(n, n2);
    }

    protected SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private LogChannel getLogMain() {
        return this.getSwdlEnv().getLogMain();
    }

    protected LogChannel getLogHMI() {
        return this.getSwdlEnv().getLogHMI();
    }

    private SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.swdlDSIManager.getUotaDSIHandler();
    }

    private SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.swdlDSIManager.getSelectionDSIHandler();
    }

    private IProgressManager getProgressManager() {
        return this.getSwdlEnv().getHMISwitcher().getProgressManager();
    }

    public AbstractDriverResetHandler getDriverResetHandler() {
        return this.driverResetHandler;
    }

    public void leaveCustomerUpdate(int n) {
    }

    public void swdlEnterUota(int n) {
        this.getLogHMI().log(-2137614336, "[AbstractCustDownloadActionProxy].swdlEnterUota(%1)", (long)n);
        this.getUotaController().startUota();
    }
}

