/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandlerImpl;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;

public abstract class AbstractPhoneCallCommand
extends AbstractSystemCallCommand {
    private static final int[][] TEL_SERVICE_TO_MAPPING_RESULT = new int[][]{{0, 30000}, {2, 30005}, {3, 30006}, {12, 30006}, {13, 30006}};
    protected final ITelServiceSDS phoneService;
    protected final PhoneSDSHandlerImpl phoneSDSHandler;
    protected final HMIService hmiService;

    public AbstractPhoneCallCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ITelServiceSDS iTelServiceSDS, HMIService hMIService, PhoneSDSHandlerImpl phoneSDSHandlerImpl) {
        super(logChannel, string, sDSHandlerService);
        this.phoneService = iTelServiceSDS;
        this.phoneSDSHandler = phoneSDSHandlerImpl;
        this.hmiService = hMIService;
    }

    protected void dial(String string) {
        this.logger.log(-2137614336, "%1#dial number=%2!", (Object)this.getName(), (Object)string);
        this.phoneService.dialNumber(string, this.phoneSDSHandler, true);
        this.sdsHandlerService.setSDSNumberDialingActive(true);
        this.sdsHandlerService.switchEntertainment(false);
    }

    public void dialNumberResponse(int n) {
        this.logger.log(-2137614336, "%1#dialNumberResponse: result=%2!", (Object)this.getName(), (long)n);
        int n2 = SDSUtils.translate(n, TEL_SERVICE_TO_MAPPING_RESULT);
        if (n2 == 128) {
            n2 = 30001;
        } else if (n2 == 30000) {
            this.switchToPhoneContext();
        }
        this.sendResult(n2);
    }

    protected void switchToPhoneContext() {
        int n = SDSManagerBaseActivator.getMapping().getEventID(1016);
        if (n != -1) {
            this.hmiService.fireSMEvent(0, n);
        }
    }
}

