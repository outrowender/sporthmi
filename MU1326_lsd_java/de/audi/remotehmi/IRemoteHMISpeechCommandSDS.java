/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public interface IRemoteHMISpeechCommandSDS {
    public static final int ID_PREFIX_GLOBAL = 10000000;
    public static final int ID_PREFIX_HELP_TOPIC = 20000000;
    public static final String DEFAULT_CONFIRMATION_PROMPT = "$";

    public String[] getConfirmationPrompts();

    public String[] getShortConfirmationPrompts();

    public String getText();

    public String getIDName();

    public boolean isStopDialog();

    public int getID();
}

