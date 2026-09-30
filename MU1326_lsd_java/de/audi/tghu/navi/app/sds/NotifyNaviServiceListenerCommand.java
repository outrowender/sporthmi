/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;

public abstract class NotifyNaviServiceListenerCommand
extends NavCommand {
    private final NaviServiceListener naviServiceListener;

    public NotifyNaviServiceListenerCommand(NaviServiceListener naviServiceListener) {
        this.naviServiceListener = naviServiceListener;
    }

    protected abstract void call(NaviServiceListener var1);

    public void execute() {
        this.logger.log(10000000, "NotifyNaviServiceListenerCommand#execute()");
        if (this.naviServiceListener != null) {
            this.call(this.naviServiceListener);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "NotifyNaviServiceListenerCommand#execute() - navi service listener not available!");
            this.getCommandList().commandAborted("no SDS service listener");
        }
    }
}

