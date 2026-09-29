/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.PropertiesAccessor;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerLogging;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager$1;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager$2;
import de.audi.tghu.swdl.app.hmiswitcher.HMIContainer;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdllogging.DSISwdlLogging;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.dsi.ifc.uota.DSIUotA;

public class SwdlDSIManager {
    private final SwdlEnv swdlEnv;
    private final SwdlDSIHandlerDeviceInfo deviceInfoDSIHandler;
    private final SwdlDSIHandlerProgress progressDSIHandler;
    private final SwdlDSIHandlerSelection selectionDSIHandler;
    private final SwdlDSIHandlerLogging loggingDSIHandler;
    private final BaseUpdateOverTheAirController uotaDSIHandler;
    private boolean allDSIsAvailable;

    public SwdlDSIManager(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.swdlEnv = swdlEnv;
        this.deviceInfoDSIHandler = new SwdlDSIHandlerDeviceInfo(swdlEnv);
        this.progressDSIHandler = new SwdlDSIHandlerProgress(swdlEnv, abstractSwdlJoinedDownloadState);
        this.selectionDSIHandler = new SwdlDSIHandlerSelection(swdlEnv, this.getProgressDSIHandler());
        this.loggingDSIHandler = new SwdlDSIHandlerLogging(swdlEnv);
        this.uotaDSIHandler = baseUpdateOverTheAirController;
        this.allDSIsAvailable = false;
        this.getSwdlModels().getDSIisAvailableChoice().forceUpdate(true);
        this.getSwdlModels().getDSIisAvailableChoice().setValue(0);
        this.checkDSIAvailability();
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private final SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    private final LogChannel getLogMain() {
        return this.getSwdlEnv().getLogMain();
    }

    public final SwdlDSIHandlerDeviceInfo getDeviceInfoDSIHandler() {
        return this.deviceInfoDSIHandler;
    }

    public final SwdlDSIHandlerProgress getProgressDSIHandler() {
        return this.progressDSIHandler;
    }

    public final SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.selectionDSIHandler;
    }

    public final SwdlDSIHandlerLogging getLoggingDSIHandler() {
        return this.loggingDSIHandler;
    }

    public final BaseUpdateOverTheAirController getUotaDSIHandler() {
        return this.uotaDSIHandler;
    }

    private final boolean areAllDSIsAvailable() {
        return this.getDeviceInfoDSIHandler().isDSIAvailable() && this.getSelectionDSIHandler().isDSIAvailable() && this.getProgressDSIHandler().isDSIAvailable() && this.getLoggingDSIHandler().isDSIAvailable();
    }

    private final void updateDSIAvailableModel(boolean bl) {
        if (bl) {
            this.getLogMain().log(1078071040, "[SwdlDSIManager] All DSIs available, leave init screen.");
            this.getSwdlModels().getDSIisAvailableChoice().setValue(1);
        } else {
            this.getLogMain().log(1078071040, "[SwdlDSIManager] Waiting for at least one DSI.");
            this.getSwdlModels().getDSIisAvailableChoice().setValue(0);
        }
    }

    public final void checkDSIAvailability() {
        boolean bl = this.areAllDSIsAvailable();
        if (this.allDSIsAvailable != bl) {
            this.allDSIsAvailable = bl;
            this.updateDSIAvailableModel(bl);
            if (bl) {
                this.getProgressDSIHandler().startPanelNotification();
                new Timer("SwdlDSIAvailableTimer", 5, this.getLogMain(), new SwdlDSIManager$1(this), 0, true).restart();
            }
        }
    }

    public void setActiveHmiContainer(HMIContainer hMIContainer) {
        this.getDeviceInfoDSIHandler().getSelectionManager(hMIContainer.getDeviceInfoManager());
        this.getSelectionDSIHandler().setSelectionManager(hMIContainer.getSelectionManager());
        this.getProgressDSIHandler().setProgressManager(hMIContainer.getProgressManager());
        this.getLoggingDSIHandler().setLoggingManager(hMIContainer.getLoggingManager());
    }

    public void setAvailableMedia() {
        this.getSelectionDSIHandler().setAvailableMedia();
    }

    public void setSwdlDeviceInfoDSI(DSISwdlDeviceInfo dSISwdlDeviceInfo) {
        this.getDeviceInfoDSIHandler().setDSI(dSISwdlDeviceInfo);
        this.checkDSIAvailability();
    }

    public void setSwdlSelectionDSI(DSISwdlSelection dSISwdlSelection) {
        this.getSelectionDSIHandler().setDSI(dSISwdlSelection);
        this.checkDSIAvailability();
    }

    public void setSwdlProgressDSI(DSISwdlProgress dSISwdlProgress) {
        this.getProgressDSIHandler().setDSI(dSISwdlProgress);
        this.checkDSIAvailability();
    }

    public void setSwdlLoggingDSI(DSISwdlLogging dSISwdlLogging) {
        this.getLoggingDSIHandler().setDSI(dSISwdlLogging);
        this.checkDSIAvailability();
    }

    public void setSwdlUotaDSI(DSIUotA dSIUotA) {
        this.getUotaDSIHandler().setDSI(dSIUotA);
        this.checkDSIAvailability();
    }

    public void initDSIHandlers() {
        this.getSelectionDSIHandler().initWaitForLameClients();
        if (PropertiesAccessor.isSimulateSWDL()) {
            this.getSwdlEnv().executeInUtilThread(new SwdlDSIManager$2(this));
        }
    }

    static /* synthetic */ boolean access$000(SwdlDSIManager swdlDSIManager) {
        return swdlDSIManager.areAllDSIsAvailable();
    }

    static /* synthetic */ void access$100(SwdlDSIManager swdlDSIManager, boolean bl) {
        swdlDSIManager.updateDSIAvailableModel(bl);
    }

    static /* synthetic */ SwdlEnv access$200(SwdlDSIManager swdlDSIManager) {
        return swdlDSIManager.getSwdlEnv();
    }
}

