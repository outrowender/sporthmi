/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface SpellerModelGUI
extends HMIModelGUI {
    public static final int BUTTON_DEFAULT;
    public static final int BUTTON_OFF;
    public static final int BUTTON_ON;
    public static final int EXIT_DEFAULT;
    public static final int EXIT_OK;
    public static final int EXIT_LIST;
    public static final int EXIT_IMPORT;
    public static final int EXIT_OPTIONS;
    public static final int EXIT_SEARCH;
    public static final int EXIT_MAX;
    public static final int EXIT_DTMF;
    public static final int COMMAND_SPELLER_OPENED;
    public static final int COMMAND_SPELLER_CLOSED;
    public static final int BUTTON_OK_AVAILABLE;
    public static final int BUTTON_CLOSE_AVAILABLE;
    public static final int COMMAND_INDEX_OK;
    public static final int COMMAND_INDEX_DIAL;
    public static final int COMMAND_INDEX_HANGUP;
    public static final int COMMAND_INDEX_MUTE;
    public static final int COMMAND_INDEX_ADD_CALL;
    public static final int COMMAND_INDEX_MERGE_CALLS;
    public static final int COMMAND_INDEX_SPLIT_CONFERENCE;
    public static final int COMMAND_INDEX_MAIL_BOX;
    public static final int COMMAND_COUNT;

    default public void textChanged(String string, char c2, int n) {
    }

    default public boolean isEmpty() {
    }

    default public int getMaxLength() {
    }

    default public int getMinLength() {
    }

    default public String getText() {
    }

    default public int getDeleteButtonState() {
    }

    default public int getExitButtonState() {
    }

    default public int getExitButtonText() {
    }

    default public String getCountryAbbreviation() {
    }

    default public void keyPressed(int n, int n2) {
    }

    default public void keyReleased(int n, int n2) {
    }

    default public void keyTyped(int n, int n2) {
    }

    default public boolean getCommandAvailable(int n) {
    }

    default public void commandPressed(int n, int n2) {
    }

    default public void focusedCharacter(char c2, int n) {
    }

    default public String getCompletionText() {
    }

    default public String getTruffleSuggestion() {
    }

    default public String getSuggestedNewSearchString() {
    }

    default public boolean shallSpellerBeInitiallyOpen() {
    }

    default public void setSpellerInitiallyOpen(boolean bl) {
    }

    default public TouchEvent getTouchEventForFollowUpScreen() {
    }

    default public void setTouchEventForFollowUpScreen(TouchEvent touchEvent) {
    }
}

