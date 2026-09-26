/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPhoneNumberAddCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final NBestStorageAccess nbest;

    public NaviPhoneNumberAddCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.nbest = nBestStorageAccess;
    }

    @Override
    public void execute() {
        String string;
        this.logger.log(-2137614336, "[%1#execute]", (Object)this.getName());
        IPicklistSlot iPicklistSlot = this.nbest.getMatchingPicklist((byte)0).getSlot(0, 0);
        String string2 = string = iPicklistSlot != null ? SDSUtils.remove(iPicklistSlot.getText(), ' ') : "";
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(-1601830656, "%1#execute: No number found in prompt label!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        this.logger.log(-2137614336, "[%1#execute] setting promptText = %2", (Object)this.getName(), (Object)string);
        this.naviService.inputTelephoneNumber(string);
    }

    public void naviPhoneNumberAddResult(byte by) {
        this.logger.log(-2137614336, "[%1#naviPhoneNumberAddResult] result=%2", (Object)this.getName(), (long)by);
        if (by == 0) {
            NaviSDSUtils.updateNaviPhoneNumberModels(this.naviService);
        }
        this.sendResult(NaviSDSUtils.getSDSResult(by));
    }
}

