/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.PropertiesAccessor;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerLogging;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.HMIContainer;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdllogging.DSISwdlLogging;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.dsi.ifc.swdlselection.LameClient;
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
            this.getLogMain().log(1000000, "[SwdlDSIManager] All DSIs available, leave init screen.");
            this.getSwdlModels().getDSIisAvailableChoice().setValue(1);
        } else {
            this.getLogMain().log(1000000, "[SwdlDSIManager] Waiting for at least one DSI.");
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
                new Timer("SwdlDSIAvailableTimer", 5, this.getLogMain(), new TimerListener(){

                    public void fireTimer(Timer timer) {
                        SwdlDSIManager.this.updateDSIAvailableModel(SwdlDSIManager.this.areAllDSIsAvailable());
                    }

                    public void cancelTimer(Timer timer) {
                    }
                }, 2000L, true).restart();
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
            this.getSwdlEnv().executeInUtilThread(new Runnable(){

                public void run() {
                    SwdlDSIManager.this.getSelectionDSIHandler().waitForLameClients();
                    SwdlDSIManager.this.getSwdlEnv().sleep(1000L);
                    SwdlDSIManager.this.getSelectionDSIHandler().updateLameClients(new LameClient[]{new LameClient("RU", 259), new LameClient("CDC", 261)}, 1);
                    SwdlDSIManager.this.getSwdlEnv().sleep(20000L);
                    SwdlDSIManager.this.getSelectionDSIHandler().updateLameClients(new LameClient[]{new LameClient("CDC", 261)}, 1);
                    SwdlDSIManager.this.getSwdlEnv().sleep(10000L);
                    SwdlDSIManager.this.getSelectionDSIHandler().updateLameClients(new LameClient[0], 1);
                }
            });
        }
    }
}

