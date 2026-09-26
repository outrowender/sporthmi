/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechEntity;

public interface IRemoteHMISpeechCommand
extends IRemoteHMISpeechEntity {
    public static final int ID_PREFIX_GLOBAL;
    public static final int ID_PREFIX_HELP_TOPIC;
    public static final String DEFAULT_CONFIRMATION_PROMPT;

    default public String getConfirmationPrompt() {
    }

    default public String[] getConfirmationPrompts() {
    }

    default public String[] getShortConfirmationPrompts() {
    }

    default public boolean isStopDialog() {
    }

    default public String getIdName() {
    }
}

