/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviInputStartingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPOIShortCutSetCommand
extends AbstractSystemCallCommand
implements ISDSNaviInputStartingCommand {
    private static final byte GAS_STATION;
    private static final byte RESTAURANT;
    private static final byte REST_AREA;
    private static final byte REST_AREA_WC;
    private static final byte ATM;
    private static final byte REST_AREA_NAR;
    private final NaviService naviService;
    private NaviSDSHandler naviSDSHandler;
    private final byte searchArea;
    private byte naturalPOI;
    private static final byte[][] searchAreaToPOIID;

    public NaviPOIShortCutSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandler naviSDSHandler, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.naviSDSHandler = naviSDSHandler;
        this.searchArea = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: searchArea=%2", (Object)this.getName(), (long)this.searchArea);
        this.naturalPOI = SDSUtils.translate(this.searchArea, searchAreaToPOIID);
        if (this.naturalPOI == -128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled searchArea %2, sending INVALID!", (Object)this.getName(), (long)this.searchArea);
            this.sendResult(1184628736);
            return;
        }
        NaviSDSUtils.resetVDEData(11, this.naviSDSHandler);
        NaviSDSUtils.setInputStartedMode((byte)11, this.naviSDSHandler, this.logger);
        this.naviService.startDestinationInput(10);
    }

    @Override
    public void responseStartDestinationInput(byte by) {
        this.logger.log(-2137614336, "%1#responseStartDestinationInput: result=%2", (Object)this.getName(), (long)by);
        if (by != 0) {
            this.sendResult(NaviSDSUtils.getSDSResult(by));
            return;
        }
        switch (this.naturalPOI) {
            case 102: {
                this.naviService.selectPOI(this.naturalPOI);
                break;
            }
            default: {
                this.naviService.selectTopPOI(this.naturalPOI);
            }
        }
    }

    public void responsePOISelection(byte by) {
        this.logger.log(-2137614336, "%1#responsePOISelection: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(-2137614336, "%1#responsePOISelection: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    static {
        searchAreaToPOIID = new byte[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 102}};
    }
}

