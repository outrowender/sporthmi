/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineSearchInitCommand
extends AbstractSystemCallCommand {
    private static final String PCM_PATH;
    private final boolean oneshotRecog;
    private final NaviSDSPOIOnlineService poiOnlineService;
    private int destinationType;

    public NaviPOIOnlineSearchInitCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
        super(logChannel, string, sDSHandlerService);
        this.poiOnlineService = naviSDSPOIOnlineService;
        this.destinationType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.oneshotRecog = this.destinationType == 24;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] oneshotRecog=%2", (Object)this.getName(), (Object)this.oneshotRecog);
        SDSModelAccess.setNaviPOIOnlineRecognitionStatus(-1, 0);
        SDSModelAccess.setNaviDestinationTypeModel(this.destinationType);
        SDSModelAccess.setEnumerationNumberStatus(-1);
        SDSModelAccess.setEnumerationNumberValue(-1);
        this.clearPOIOnlineResultList();
        int n = this.oneshotRecog ? (this.sdsHandlerService.getFramework().isCn() ? 1 : 2) : -1;
        this.logger.log(-2137614336, "[%1#execute] audioFormat=%2", (Object)this.getName(), (long)n);
        String string = this.oneshotRecog ? "/tmp/speech-online.pcm" : "";
        byte by = this.poiOnlineService.poiOnlineSearchInit(this.oneshotRecog, n, string);
        this.logger.log(-2137614336, "[%1#execute] result=%2!", (Object)this.getName(), (long)by);
        this.sendResult(NaviSDSUtils.handlePOIOnlineReplyCode(this.logger, by, this.getName()));
    }

    protected void clearPOIOnlineResultList() {
    }
}

