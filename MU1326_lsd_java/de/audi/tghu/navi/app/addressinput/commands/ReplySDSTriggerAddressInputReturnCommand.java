/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;

public class ReplySDSTriggerAddressInputReturnCommand
extends NavCommand {
    private final NaviServiceListener naviServiceListener;
    private final byte resultCode;

    public ReplySDSTriggerAddressInputReturnCommand(NaviServiceListener naviServiceListener, byte by) {
        this.naviServiceListener = naviServiceListener;
        this.resultCode = by;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute() - response with resultCode = %2", (Object)this.CLASS_NAME, (long)this.resultCode);
        this.naviServiceListener.responseTriggerAddressInputReturn(this.resultCode);
        this.getCommandList().commandFinished();
    }
}

