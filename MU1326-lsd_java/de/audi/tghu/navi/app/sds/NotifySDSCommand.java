/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;

public abstract class NotifySDSCommand
extends NavCommand {
    protected NaviServiceListener feedbackNaviServiceListener;

    public NotifySDSCommand(NaviServiceListener naviServiceListener) {
        this.feedbackNaviServiceListener = naviServiceListener;
    }

    public NotifySDSCommand(NaviServiceListener naviServiceListener, String string) {
        super(string);
        this.feedbackNaviServiceListener = naviServiceListener;
    }

    public abstract void call() {
    }

    @Override
    public void execute() {
        if (this.feedbackNaviServiceListener != null) {
            this.call();
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "NotifySDSCommand#execute() - navi service listener not available!");
            this.getCommandList().commandAborted("no SDS service listener");
        }
    }
}

