/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechContext;

public interface IRemoteHMISpeechHelpContext
extends IRemoteHMISpeechContext {
    default public String getHelpTitle() {
    }

    default public String[] getIntroPrompts() {
    }

    default public int getId() {
    }

    default public String getContext() {
    }
}

