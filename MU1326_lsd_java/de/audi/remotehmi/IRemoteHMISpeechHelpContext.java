/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechContext;

public interface IRemoteHMISpeechHelpContext
extends IRemoteHMISpeechContext {
    public String getHelpTitle();

    public String[] getIntroPrompts();

    public int getId();

    public String getContext();
}

