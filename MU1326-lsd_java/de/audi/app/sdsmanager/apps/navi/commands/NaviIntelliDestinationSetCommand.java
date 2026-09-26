/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviIntelliDestinationSetCommand
extends AbstractSystemCallCommand {
    private static final int LINE_SELECTION;
    private static final int FIRST_ENTRY;
    private final NaviSDSHandler sdsHandler;
    private final NaviService naviService;
    private final int selection;

    public NaviIntelliDestinationSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NaviService naviService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.naviService = naviService;
        this.selection = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: selection=%2!", (Object)this.getName(), (long)this.selection);
        this.sdsHandler.setSDSAddressInputMode((byte)8);
        int n = -1;
        switch (this.selection) {
            case 1: {
                n = 0;
                break;
            }
            default: {
                n = SDSModelAccess.getEnumerationNumberStatus();
            }
        }
        this.logger.log(-2137614336, "%1#execute: index of selected destination=%2", (Object)this.getName(), (long)n);
        this.naviService.setIntelliDestinationByIndex(n);
    }

    public void responseIntelliDestinationSet(byte by) {
        this.logger.log(-2137614336, "%1#responseIntelliDestinationSet: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.sendResult(n);
    }
}

