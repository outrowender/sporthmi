/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPOIPromptLabelSetCommand
extends AbstractSystemCallCommand {
    private static final byte LABEL_SOURCE_LISTLINEDATAGET = 0;
    private static final byte LABEL_SOURCE_ONESHOTDATA = 1;
    private static final byte LABEL_SOURCE_CURRENT_CITY = 2;
    private final NaviSDSHandler naviHandler;
    private final NaviService naviService;
    private final byte source;

    public NaviPOIPromptLabelSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, NaviSDSHandler naviSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.source = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.naviHandler = naviSDSHandler;
        this.naviService = naviService;
    }

    public void execute() {
        String string;
        this.logger.log(10000000, "[%1#execute] source=%2", (Object)this.getName(), (long)this.source);
        switch (this.source) {
            case 0: {
                string = SDSModelAccess.getListLineDataGetModel();
                break;
            }
            case 1: {
                string = this.naviHandler.getOneshotData((byte)0).getText();
                break;
            }
            case 2: {
                NaviService.NaviInfoDetails naviInfoDetails = this.naviService.getFormattedPoiSearchAreaLocation();
                if (naviInfoDetails == null) {
                    this.logger.log(10000, "[%1#execute] naviDetails is null, sending ERROR!", (Object)this.getName());
                    this.sendResult(40001);
                    return;
                }
                SDSModelAccess.setOneshotCityLabel(naviInfoDetails.city);
                this.sendResult(40000);
                return;
            }
            default: {
                this.logger.log(100000, "[%1#execute] Unhandled source %2, sending ERROR!", (Object)this.getName(), (long)this.source);
                this.sendResult(40001);
                return;
            }
        }
        SDSModelAccess.setOneshotPoiLabel(string);
        this.sendResult(40000);
    }
}

