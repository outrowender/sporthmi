/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public interface IRemoteHMISpeechCommandSDS {
    public static final int ID_PREFIX_GLOBAL;
    public static final int ID_PREFIX_HELP_TOPIC;
    public static final String DEFAULT_CONFIRMATION_PROMPT;

    default public String[] getConfirmationPrompts() {
    }

    default public String[] getShortConfirmationPrompts() {
    }

    default public String getText() {
    }

    default public String getIDName() {
    }

    default public boolean isStopDialog() {
    }

    default public int getID() {
    }
}

