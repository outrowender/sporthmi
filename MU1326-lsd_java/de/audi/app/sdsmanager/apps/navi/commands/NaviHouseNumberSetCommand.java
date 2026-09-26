/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.log.LogChannel;

public class NaviHouseNumberSetCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;

    public NaviHouseNumberSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandlerImpl naviSDSHandlerImpl) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
    }

    @Override
    public void execute() {
        String string;
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        IPicklist iPicklist = naviOneshotHandler == null ? this.sdsHandler.getEntryPicklist() : naviOneshotHandler.getCurrentPicklist();
        IPicklistSlot iPicklistSlot = iPicklist.getSlot(0, 0);
        String string2 = iPicklistSlot != null ? iPicklistSlot.getText() : "";
        String string3 = string = iPicklistSlot != null ? iPicklistSlot.getObjectStringID() : "";
        if (naviOneshotHandler == null) {
            this.sdsHandler.setOneshotData(new NaviService$OneshotData(string2, string), (byte)2);
        } else {
            naviOneshotHandler.setOneshotData(iPicklistSlot, 2);
        }
        this.logger.log(-2137614336, "%1#execute: housenumber=%2, housenumberStringID=%3!", (Object)this.getName(), (Object)string2, (Object)string);
        this.sendResult(3000);
    }
}

