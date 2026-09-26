/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechHelpContext;
import de.audi.remotehmi.IRemoteHMISpeechHelpIntroPrompt;
import de.audi.remotehmi.IRemoteHMISpeechTopicContext;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$14
extends AbstractRemoteHMITask {
    private final /* synthetic */ IRemoteHMISpeechHelpContext[] val$speechContext;
    private final /* synthetic */ IRemoteHMISpeechTopicContext[] val$topicCommands;
    private final /* synthetic */ IRemoteHMISpeechHelpIntroPrompt val$introPrompt;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$14(RemoteHMIService remoteHMIService, String string, IRemoteHMISpeechHelpContext[] iRemoteHMISpeechHelpContextArray, IRemoteHMISpeechTopicContext[] iRemoteHMISpeechTopicContextArray, IRemoteHMISpeechHelpIntroPrompt iRemoteHMISpeechHelpIntroPrompt) {
        this.this$0 = remoteHMIService;
        this.val$speechContext = iRemoteHMISpeechHelpContextArray;
        this.val$topicCommands = iRemoteHMISpeechTopicContextArray;
        this.val$introPrompt = iRemoteHMISpeechHelpIntroPrompt;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateSpeechHelpContexts: updating SDS service.");
        RemoteHMIService.access$200(this.this$0).indicateSpeechHelpContexts(this.val$speechContext, this.val$topicCommands, this.val$introPrompt);
    }
}

