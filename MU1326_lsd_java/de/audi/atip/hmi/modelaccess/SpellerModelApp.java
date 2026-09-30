/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface SpellerModelApp
extends HMIModelApp {
    public static final int BUTTON_DEFAULT = -1;
    public static final int BUTTON_OFF = 0;
    public static final int BUTTON_ON = 1;
    public static final int BUTTON_OK_SPELLER = 7;
    public static final int EXIT_DEFAULT = -1;
    public static final int EXIT_OK = 0;
    public static final int EXIT_LIST = 1;
    public static final int EXIT_IMPORT = 2;
    public static final int EXIT_OPTIONS = 3;
    public static final int EXIT_SEARCH = 4;
    public static final int EXIT_MAX = 5;
    public static final int EXIT_DTMF = 6;
    public static final int COMMAND_SPELLER_OPENED = 4711;
    public static final int COMMAND_SPELLER_CLOSED = 4712;
    public static final int COMMAND_INDEX_OK = 7;
    public static final int COMMAND_INDEX_DIAL = 10;
    public static final int COMMAND_INDEX_HANGUP = 11;
    public static final int COMMAND_INDEX_MUTE = 12;
    public static final int COMMAND_INDEX_ADD_CALL = 13;
    public static final int COMMAND_INDEX_MERGE_CALLS = 14;
    public static final int COMMAND_INDEX_SPLIT_CONFERENCE = 15;
    public static final int COMMAND_INDEX_MAIL_BOX = 16;
    public static final int COMMAND_COUNT = 17;

    public void setMaxLength(int var1);

    public int getMaxLength();

    public void setMinLength(int var1);

    public int getMinLength();

    public void setSpellerListener(SpellerListener var1);

    public void setText(String var1);

    public String getText();

    public void setCountryAbbreviation(String var1);

    public String getCountryAbbreviation();

    public void clear();

    public void setControlButtonStates(int var1, int var2);

    public void setExitButtonText(int var1);

    public void setCommandAvailable(int var1, boolean var2);

    public void setCompletionText(String var1);

    public String getCompletionText();

    public void setSuggestions(String var1, String var2);

    public void setSpellerInitiallyOpen(boolean var1);

    public TouchEvent getTouchEventForFollowUpScreen();

    public void setTouchEventForFollowUpScreen(TouchEvent var1);
}

