/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviFurtherInputPossibleCommand
extends AbstractSystemCallCommand {
    private static final int INPUT_TYPE_MAPCODE = 0;
    private static final int INPUT_TYPE_PHONENUMBER = 1;
    private final NaviService naviService;
    private final byte inputType;

    public NaviFurtherInputPossibleCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.inputType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] inputType=%2", (Object)this.getName(), (long)this.inputType);
        switch (this.inputType) {
            case 0: {
                this.sendResult(this.naviService.isFurtherMapCodeInputPossible() ? 40000 : 40006);
                break;
            }
            case 1: {
                this.sendResult(this.naviService.isFurtherTelephonenumberInputPossible() ? 40000 : 40006);
                break;
            }
            default: {
                this.sendResult(40001);
            }
        }
    }
}

