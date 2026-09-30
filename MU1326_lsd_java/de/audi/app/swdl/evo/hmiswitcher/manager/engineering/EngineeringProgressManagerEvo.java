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
    private static final int SWDL_STATE_META_INFO = 1;
    private static final int SWDL_STATE_PROGESS = 2;
    private static final int SWDL_STATE_SUMMARY = 3;

    public EngineeringProgressManagerEvo(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, AbstractEngineeringDeviceInfoManager abstractEngineeringDeviceInfoManager, AbstractEngineeringSelectionManager abstractEngineeringSelectionManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerSelection swdlDSIHandlerSelection) {
        super(swdlEnv, abstractSwdlJoinedDownloadState, abstractPopupManager, abstractEngineeringDeviceInfoManager, abstractEngineeringSelectionManager, swdlDSIHandlerProgress, swdlDSIHandlerDeviceInfo, swdlDSIHandlerSelection);
    }

    protected void showProgress(int n) {
        this.getLogHMI().log(1000000, "showProgress");
        this.getHMIService().getChoiceModel(1700123).setValue(2);
        this.getHMIService().fireSMEvent(n, 1700028);
    }

    protected void showTriggerReboot(int n) {
        this.getLogHMI().log(1000000, "showTriggerReboot");
        this.getHMIService().fireSMEvent(n, 1700017);
    }

    protected void showSummary(int n) {
        this.getLogHMI().log(1000000, "showSummary");
        this.getHMIService().getChoiceModel(1700123).setValue(3);
        this.getHMIService().fireSMEvent(n, 1700028);
    }

    protected void showReadMetaInfo(int n) {
        this.getLogHMI().log(1000000, "showReadMetaInfo");
        this.getHMIService().getChoiceModel(1700123).setValue(1);
        this.getHMIService().fireSMEvent(n, 1700028);
    }

    protected void fireSMEventHKReturn(int n) {
        this.getLogHMI().log(1000000, "fireSMEventHKReturn");
        this.getHMIService().fireSMEvent(n, 1741);
    }

    protected void showPopupSwdlReboot() {
        this.getLogHMI().log(1000000, "showPopupSwdlReboot");
        this.getHMIService().fireSMEvent(0, 1700017);
    }

    protected void showProgressScreen() {
        this.getLogHMI().log(1000000, "showProgressScreen");
        this.getHMIService().fireSMEvent(0, 1700018);
    }

    public void showSummaryUota(boolean bl) {
    }

    public void switchUotaProgressState(boolean bl) {
    }

    public void showPopupUpdateSuccessful() {
    }
}

