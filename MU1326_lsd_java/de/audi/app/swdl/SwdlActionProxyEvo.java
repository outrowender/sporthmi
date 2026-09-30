/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl;

import de.audi.atip.statemachine.ap.SWDLActionProxy;
import de.audi.tghu.swdl.app.AbstractSwdlActionProxy;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.HMISwitcher;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;

public class SwdlActionProxyEvo
extends AbstractSwdlActionProxy
implements SWDLActionProxy {
    public SwdlActionProxyEvo(SwdlEnv swdlEnv, HMISwitcher hMISwitcher, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerProgress swdlDSIHandlerProgress, AbstractSwdlTextFactory abstractSwdlTextFactory) {
        super(swdlEnv, hMISwitcher, abstractSwdlJoinedDownloadState, abstractPopupManager, swdlDSIHandlerDeviceInfo, swdlDSIHandlerProgress, abstractSwdlTextFactory);
    }

    public void interruptRSUDownload(int n) {
    }
}

