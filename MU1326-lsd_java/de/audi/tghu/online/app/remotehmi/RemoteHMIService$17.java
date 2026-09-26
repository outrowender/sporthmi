/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.i18n.Language;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$17
extends AbstractRemoteHMITask {
    private final /* synthetic */ Language val$language;
    private final /* synthetic */ String val$hmiCode;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$17(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, Language language, String string2) {
        this.this$0 = remoteHMIService;
        this.val$language = language;
        this.val$hmiCode = string2;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#setLanguage: %1", (Object)this.val$language);
        if (this.this$0.dsiAccess.hasDSI()) {
            this.this$0.dsiAccess.setHMILanguage(this.val$hmiCode);
            RemoteHMIAction remoteHMIAction = this.this$0.getAction(950);
            remoteHMIAction.getParameters().put("value", this.val$hmiCode);
            this.this$0.invokeActionImmediately(remoteHMIAction);
        } else {
            this.this$0.logChannel.log(-1601830656, "RemoteHMIService#setLanguage: no IRemoteHMI present.");
            RemoteHMIService.access$302(this.this$0, this.val$hmiCode);
        }
    }
}

