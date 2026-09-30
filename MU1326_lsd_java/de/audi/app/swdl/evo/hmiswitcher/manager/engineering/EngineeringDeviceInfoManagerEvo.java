/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl.evo.hmiswitcher.manager.engineering;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringDeviceInfoManager;

public class EngineeringDeviceInfoManagerEvo
extends AbstractEngineeringDeviceInfoManager {
    public EngineeringDeviceInfoManagerEvo(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerSelection swdlDSIHandlerSelection) {
        super(swdlEnv, abstractPopupManager, swdlDSIHandlerDeviceInfo, swdlDSIHandlerSelection);
    }

    protected void showSummaryChanged(int n) {
        this.getHMIService().showPopup(1700017, n);
    }
}

