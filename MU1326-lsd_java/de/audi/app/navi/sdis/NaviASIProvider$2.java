/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviASIProvider;
import de.audi.tghu.navi.app.command.NavCommand;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.core.method.MethodException;

class NaviASIProvider$2
extends NavCommand {
    private final /* synthetic */ ASIHMISyncNavigationReply val$reply;
    private final /* synthetic */ NaviASIProvider this$0;

    NaviASIProvider$2(NaviASIProvider naviASIProvider, String string, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.this$0 = naviASIProvider;
        this.val$reply = aSIHMISyncNavigationReply;
        super(string);
    }

    @Override
    public void execute() {
        try {
            this.val$reply.startGuidanceToDestinationsResult(2);
            this.this$0.updateDestinationsForGuidance(null);
            this.getCommandList().commandFinished();
        }
        catch (MethodException methodException) {
            this.logger.log(-1601830656, "ReplyCommand failed", (Throwable)methodException);
            this.getCommandList().commandAborted(methodException);
        }
        NaviASIProvider.access$102(this.this$0, false);
    }
}

