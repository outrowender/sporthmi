/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechEntity;

public interface IRemoteHMISpeechCommand
extends IRemoteHMISpeechEntity {
    public static final int ID_PREFIX_GLOBAL = 10000000;
    public static final int ID_PREFIX_HELP_TOPIC = 20000000;
    public static final String DEFAULT_CONFIRMATION_PROMPT = "$";

    public String getConfirmationPrompt();

    public String[] getConfirmationPrompts();

    public String[] getShortConfirmationPrompts();

    public boolean isStopDialog();

    public String getIdName();
}

