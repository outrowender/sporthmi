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
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.log.LogChannel;

public class NaviPOIPromptLabelSetCommand
extends AbstractSystemCallCommand {
    private static final byte LABEL_SOURCE_LISTLINEDATAGET;
    private static final byte LABEL_SOURCE_ONESHOTDATA;
    private static final byte LABEL_SOURCE_CURRENT_CITY;
    private final NaviSDSHandler naviHandler;
    private final NaviService naviService;
    private final byte source;

    public NaviPOIPromptLabelSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, NaviSDSHandler naviSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.source = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.naviHandler = naviSDSHandler;
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        String string;
        this.logger.log(-2137614336, "[%1#execute] source=%2", (Object)this.getName(), (long)this.source);
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
                NaviService$NaviInfoDetails naviService$NaviInfoDetails = this.naviService.getFormattedPoiSearchAreaLocation();
                if (naviService$NaviInfoDetails == null) {
                    this.logger.log(10000, "[%1#execute] naviDetails is null, sending ERROR!", (Object)this.getName());
                    this.sendResult(1100742656);
                    return;
                }
                SDSModelAccess.setOneshotCityLabel(naviService$NaviInfoDetails.city);
                this.sendResult(1083965440);
                return;
            }
            default: {
                this.logger.log(-1601830656, "[%1#execute] Unhandled source %2, sending ERROR!", (Object)this.getName(), (long)this.source);
                this.sendResult(1100742656);
                return;
            }
        }
        SDSModelAccess.setOneshotPoiLabel(string);
        this.sendResult(1083965440);
    }
}

