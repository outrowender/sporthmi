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
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringSelectionManager;

public class EngineeringSelectionManagerEvo
extends AbstractEngineeringSelectionManager {
    public EngineeringSelectionManagerEvo(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, AbstractEngineeringDeviceInfoManager abstractEngineeringDeviceInfoManager, SwdlDSIHandlerSelection swdlDSIHandlerSelection, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(swdlEnv, abstractSwdlJoinedDownloadState, abstractPopupManager, abstractEngineeringDeviceInfoManager, swdlDSIHandlerSelection, swdlDSIHandlerDeviceInfo, swdlDSIHandlerProgress);
    }

    protected void fireSMEventTriggerDownloadAborting(int n) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }
}

