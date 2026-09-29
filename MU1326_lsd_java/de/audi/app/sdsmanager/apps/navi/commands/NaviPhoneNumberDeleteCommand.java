/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPhoneNumberDeleteCommand
extends AbstractSystemCallCommand {
    private static final int DELETE_ALL;
    private static final int DELETE_SEQUENCE;
    private final byte deleteType;
    private final NaviService naviService;

    public NaviPhoneNumberDeleteCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.deleteType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] deleteType=%2", (Object)this.getName(), (long)this.deleteType);
        switch (this.deleteType) {
            case 0: {
                this.naviService.clearTelephoneNumber();
                break;
            }
            case 1: {
                this.naviService.deleteLastTelephoneNumberInput();
                break;
            }
            default: {
                this.sendResult(1100742656);
            }
        }
    }

    public void naviPhoneNumberDeleteResult(byte by) {
        this.logger.log(-2137614336, "[%1#naviPhoneNumberDeleteResult] result=%2", (Object)this.getName(), (long)by);
        if (by == 0) {
            NaviSDSUtils.updateNaviPhoneNumberModels(this.naviService);
        }
        this.sendResult(NaviSDSUtils.getSDSResult(by));
    }
}

