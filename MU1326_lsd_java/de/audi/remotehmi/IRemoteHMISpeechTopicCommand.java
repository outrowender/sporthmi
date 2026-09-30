/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechCommand;

public interface IRemoteHMISpeechTopicCommand
extends IRemoteHMISpeechCommand {
    public String getLabel();

    public String getPrompt();

    public String[] getPrompts();

    public String getContext();
}

