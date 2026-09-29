/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher;

import de.audi.atip.engineering.fsc.IFSCService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.versioninfo.BaseVersionInfoController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;
import de.audi.tghu.swdl.app.hmiswitcher.HMIContainer;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;

public final class HMISwitcher {
    public static final int TYPE_ENGINEERING;
    public static final int TYPE_CUSTOMER;
    public static final int TYPE_VERSION_INFO;
    private final SwdlEnv swdlEnv;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;
    private final SwdlDSIManager dsiManager;
    private final HMIContainer engineeringHmiContainer;
    private final HMIContainer customerHmiContainer;
    private BaseVersionInfoController versionInfoController;
    private CustomerDLState customerDLState;
    private HMIContainer activeHmiContainer;

    public HMISwitcher(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, SwdlDSIManager swdlDSIManager, HMIContainer hMIContainer, HMIContainer hMIContainer2) {
        this.swdlEnv = swdlEnv;
        this.swdlJoinedDownloadState = abstractSwdlJoinedDownloadState;
        this.dsiManager = swdlDSIManager;
        this.engineeringHmiContainer = hMIContainer;
        this.customerHmiContainer = hMIContainer2;
        this.versionInfoController = new BaseVersionInfoController(swdlEnv);
        if (!swdlEnv.isEngineeringDownloadActive() && !swdlEnv.isRebootToDownload()) {
            this.versionInfoController.readVersionInfo(swdlEnv.getCurrentHmiLanguage());
        }
        this.setActiveHmiContainer(hMIContainer);
    }

    private SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private IFSCService getFscService() {
        return this.getSwdlEnv().getFscService();
    }

    private LogChannel getLogMain() {
        return this.getSwdlEnv().getLogMain();
    }

    public void releaseSwdlFocus() {
        this.getSelectionDSIHandler().releaseFocus();
    }

    public BaseVersionInfoController getVersionInfoController() {
        return this.versionInfoController;
    }

    private SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.dsiManager.getSelectionDSIHandler();
    }

    private SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    private HMIContainer getActiveHmiContainer() {
        return this.activeHmiContainer;
    }

    private void setActiveHmiContainer(HMIContainer hMIContainer) {
        if (null != hMIContainer && !hMIContainer.equals(this.activeHmiContainer)) {
            this.dsiManager.setActiveHmiContainer(hMIContainer);
            this.activeHmiContainer = hMIContainer;
        }
        this.dsiManager.setAvailableMedia();
    }

    public synchronized void switchToEngineeringHmi() {
        if (0 != this.getActiveHmiContainer().getTypeId()) {
            this.setActiveHmiContainer(this.engineeringHmiContainer);
            this.removeFSCServiceListner();
        }
    }

    public void initEngineeringHMI() {
        this.getLogMain().log(1078071040, "[HMISwitcher] initEngineeringHMI(): request focus");
        this.dsiManager.getSelectionDSIHandler().doSetUserSwdl(false);
        this.dsiManager.getSelectionDSIHandler().requestFocus();
        if (this.getSwdlEnv().isRebootToDownload()) {
            this.getLogMain().log(-2137614336, "[HMISwitcher] initEngineeringHMI(): trigger latest panel");
            this.getProgressManager().triggerLatestPanel();
        } else {
            this.getLogMain().log(-2137614336, "[HMISwitcher] initEngineeringHMI(): get available media");
            this.getSelectionManager().doGetSourceMedia();
        }
    }

    public void deinitEngineeringHMI() {
        this.getLogMain().log(-2137614336, "[HMISwitcher] deinitEngineeringHMI(): release focus");
        this.dsiManager.getSelectionDSIHandler().releaseFocus();
    }

    public synchronized void switchToCustomerHmi(int n) {
        this.swdlJoinedDownloadState.setJoinedDownload(false);
        this.setActiveHmiContainer(this.customerHmiContainer);
        this.removeFSCServiceListner();
    }

    private void removeFSCServiceListner() {
        if (null != this.getFscService()) {
            this.getFscService().removeListener();
        }
    }

    public synchronized boolean isModeCustomer() {
        return 1 == this.getActiveHmiContainer().getTypeId();
    }

    public synchronized boolean isModeVersionInformations() {
        return 2 == this.getActiveHmiContainer().getTypeId();
    }

    public ISelectionManager getSelectionManager() {
        return this.getActiveHmiContainer().getSelectionManager();
    }

    public IDeviceInfoManager getDeviceInfoManager() {
        return this.getActiveHmiContainer().getDeviceInfoManager();
    }

    public ILoggingManager getLoggingManager() {
        return this.getActiveHmiContainer().getLoggingManager();
    }

    public IProgressManager getProgressManager() {
        return this.getActiveHmiContainer().getProgressManager();
    }

    public void initCustomerUpdate(int n, boolean bl, int n2) {
        this.getSwdlEnv().getLogCustomer().log(-2137614336, "[HMISwitcher] initCustomerUpdate(sourceMediumID=%1,reboot=%2,terminalID=%3)", (Object)Integer.toString(n), (Object)Boolean.toString(bl), (Object)Integer.toString(n2));
        this.getSwdlModels().getStartDownloadDisabled().setValue(1);
        this.getSelectionDSIHandler().clearNotification(new int[]{3});
        this.getSwdlEnv().setCustomerDownloadActive(true);
        this.getSwdlEnv().sendMessage(8);
        if (!this.getSwdlEnv().getBulkCopyAccess().bulkCopyLock()) {
            this.getSwdlEnv().getLogMain().log(-1601830656, "[HMISwitcher] initCustomerUpdate: The bulk-copy lock was not available!");
        }
        this.switchToCustomerHmi(n2);
        this.getSelectionDSIHandler().doSetUserSwdl(true);
        this.getSelectionDSIHandler().requestFocus();
        if (this.getSwdlEnv().isUpdateOverTheAirFeatureEnabled() && 8 == n) {
            this.getSelectionDSIHandler().doStoreFsPath("/net/mmx/mnt/ota/swdl");
        }
        if (bl) {
            this.getProgressManager().swdlProgressEntered();
            this.getProgressManager().triggerLatestPanel();
            this.getProgressManager().showPopupMainSKSetupUpdateSummaryInterruptRestart();
        } else {
            this.getSelectionManager().preSelectSourceMedium(n);
        }
    }

    public CustomerDLState getCustomerDLState() {
        if (this.customerDLState == null) {
            this.customerDLState = new CustomerDLState(this.getSwdlEnv(), this, this.dsiManager.getSelectionDSIHandler());
        }
        return this.customerDLState;
    }

    public void reEnterUota(int n, boolean bl) {
        this.dsiManager.getUotaDSIHandler().resumeUota(n, bl);
    }

    public BaseUpdateOverTheAirController getUOTAController() {
        return this.dsiManager.getUotaDSIHandler();
    }

    public void removeCustomerDLState() {
        this.customerDLState = null;
    }
}

