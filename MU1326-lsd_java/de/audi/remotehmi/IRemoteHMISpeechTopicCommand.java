/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechCommand;

public interface IRemoteHMISpeechTopicCommand
extends IRemoteHMISpeechCommand {
    default public String getLabel() {
    }

    default public String getPrompt() {
    }

    default public String[] getPrompts() {
    }

    default public String getContext() {
    }
}

