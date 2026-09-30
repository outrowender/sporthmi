/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface SpellerModelGUI
extends HMIModelGUI {
    public static final int BUTTON_DEFAULT = -1;
    public static final int BUTTON_OFF = 0;
    public static final int BUTTON_ON = 1;
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
    public static final int BUTTON_OK_AVAILABLE = 7;
    public static final int BUTTON_CLOSE_AVAILABLE = -1;
    public static final int COMMAND_INDEX_OK = 7;
    public static final int COMMAND_INDEX_DIAL = 10;
    public static final int COMMAND_INDEX_HANGUP = 11;
    public static final int COMMAND_INDEX_MUTE = 12;
    public static final int COMMAND_INDEX_ADD_CALL = 13;
    public static final int COMMAND_INDEX_MERGE_CALLS = 14;
    public static final int COMMAND_INDEX_SPLIT_CONFERENCE = 15;
    public static final int COMMAND_INDEX_MAIL_BOX = 16;
    public static final int COMMAND_COUNT = 17;

    public void textChanged(String var1, char var2, int var3);

    public boolean isEmpty();

    public int getMaxLength();

    public int getMinLength();

    public String getText();

    public int getDeleteButtonState();

    public int getExitButtonState();

    public int getExitButtonText();

    public String getCountryAbbreviation();

    public void keyPressed(int var1, int var2);

    public void keyReleased(int var1, int var2);

    public void keyTyped(int var1, int var2);

    public boolean getCommandAvailable(int var1);

    public void commandPressed(int var1, int var2);

    public void focusedCharacter(char var1, int var2);

    public String getCompletionText();

    public String getTruffleSuggestion();

    public String getSuggestedNewSearchString();

    public boolean shallSpellerBeInitiallyOpen();

    public void setSpellerInitiallyOpen(boolean var1);

    public TouchEvent getTouchEventForFollowUpScreen();

    public void setTouchEventForFollowUpScreen(TouchEvent var1);
}

