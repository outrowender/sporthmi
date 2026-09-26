/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class RightDrawerHandler$4
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$4(RightDrawerHandler rightDrawerHandler, String string, LogChannel logChannel) {
        this.this$0 = rightDrawerHandler;
        this.val$log = logChannel;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString((String)object);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$log.log(1078071040, "RightDrawerHandler#indicateCommand: Commands.STATE_CLOSE_RIGHT_DRAWER called");
        String string = (String)object;
        this.this$0.closeRightDrawer(string);
    }
}

