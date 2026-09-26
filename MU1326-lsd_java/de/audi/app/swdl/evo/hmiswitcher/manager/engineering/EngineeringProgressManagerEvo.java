/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl.evo.hmiswitcher.manager.engineering;

import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringSelectionManager;

public class EngineeringProgressManagerEvo
extends AbstractEngineeringProgressManager {
    private static final int SWDL_STATE_META_INFO;
    private static final int SWDL_STATE_PROGESS;
    private static final int SWDL_STATE_SUMMARY;

    public EngineeringProgressManagerEvo(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, AbstractEngineeringDeviceInfoManager abstractEngineeringDeviceInfoManager, AbstractEngineeringSelectionManager abstractEngineeringSelectionManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerSelection swdlDSIHandlerSelection) {
        super(swdlEnv, abstractSwdlJoinedDownloadState, abstractPopupManager, abstractEngineeringDeviceInfoManager, abstractEngineeringSelectionManager, swdlDSIHandlerProgress, swdlDSIHandlerDeviceInfo, swdlDSIHandlerSelection);
    }

    @Override
    protected void showProgress(int n) {
        this.getLogHMI().log(1078071040, "showProgress");
        this.getHMIService().getChoiceModel(468785408).setValue(2);
        this.getHMIService().fireSMEvent(n, -1125115648);
    }

    @Override
    protected void showTriggerReboot(int n) {
        this.getLogHMI().log(1078071040, "showTriggerReboot");
        this.getHMIService().fireSMEvent(n, -1309665024);
    }

    @Override
    protected void showSummary(int n) {
        this.getLogHMI().log(1078071040, "showSummary");
        this.getHMIService().getChoiceModel(468785408).setValue(3);
        this.getHMIService().fireSMEvent(n, -1125115648);
    }

    @Override
    protected void showReadMetaInfo(int n) {
        this.getLogHMI().log(1078071040, "showReadMetaInfo");
        this.getHMIService().getChoiceModel(468785408).setValue(1);
        this.getHMIService().fireSMEvent(n, -1125115648);
    }

    @Override
    protected void fireSMEventHKReturn(int n) {
        this.getLogHMI().log(1078071040, "fireSMEventHKReturn");
        this.getHMIService().fireSMEvent(n, 1741);
    }

    @Override
    protected void showPopupSwdlReboot() {
        this.getLogHMI().log(1078071040, "showPopupSwdlReboot");
        this.getHMIService().fireSMEvent(0, -1309665024);
    }

    @Override
    protected void showProgressScreen() {
        this.getLogHMI().log(1078071040, "showProgressScreen");
        this.getHMIService().fireSMEvent(0, -1292887808);
    }

    @Override
    public void showSummaryUota(boolean bl) {
    }

    @Override
    public void switchUotaProgressState(boolean bl) {
    }

    @Override
    public void showPopupUpdateSuccessful() {
    }
}

