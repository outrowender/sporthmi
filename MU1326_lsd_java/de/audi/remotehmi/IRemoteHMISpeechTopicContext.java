/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.IRemoteHMISpeechNoHelpPrompt;

public interface IRemoteHMISpeechTopicContext
extends IRemoteHMISpeechContext {
    public String getLabel();

    public IRemoteHMISpeechNoHelpPrompt getNoHelpPrompt();

    public IRemoteHMISpeechCommandSDS[] getCommands();
}

