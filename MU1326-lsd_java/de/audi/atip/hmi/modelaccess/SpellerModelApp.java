/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface SpellerModelApp
extends HMIModelApp {
    public static final int BUTTON_DEFAULT;
    public static final int BUTTON_OFF;
    public static final int BUTTON_ON;
    public static final int BUTTON_OK_SPELLER;
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
    public static final int COMMAND_INDEX_OK;
    public static final int COMMAND_INDEX_DIAL;
    public static final int COMMAND_INDEX_HANGUP;
    public static final int COMMAND_INDEX_MUTE;
    public static final int COMMAND_INDEX_ADD_CALL;
    public static final int COMMAND_INDEX_MERGE_CALLS;
    public static final int COMMAND_INDEX_SPLIT_CONFERENCE;
    public static final int COMMAND_INDEX_MAIL_BOX;
    public static final int COMMAND_COUNT;

    default public void setMaxLength(int n) {
    }

    default public int getMaxLength() {
    }

    default public void setMinLength(int n) {
    }

    default public int getMinLength() {
    }

    default public void setSpellerListener(SpellerListener spellerListener) {
    }

    default public void setText(String string) {
    }

    default public String getText() {
    }

    default public void setCountryAbbreviation(String string) {
    }

    default public String getCountryAbbreviation() {
    }

    default public void clear() {
    }

    default public void setControlButtonStates(int n, int n2) {
    }

    default public void setExitButtonText(int n) {
    }

    default public void setCommandAvailable(int n, boolean bl) {
    }

    default public void setCompletionText(String string) {
    }

    default public String getCompletionText() {
    }

    default public void setSuggestions(String string, String string2) {
    }

    default public void setSpellerInitiallyOpen(boolean bl) {
    }

    default public TouchEvent getTouchEventForFollowUpScreen() {
    }

    default public void setTouchEventForFollowUpScreen(TouchEvent touchEvent) {
    }
}

