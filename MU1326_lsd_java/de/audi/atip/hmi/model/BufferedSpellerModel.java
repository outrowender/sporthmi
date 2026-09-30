/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;

public class BufferedSpellerModel
extends BufferedAbstractModel
implements SpellerModelGUI,
SpellerModelApp {
    private SpellerModel spellerModel = (SpellerModel)super.getMainModel();

    public BufferedSpellerModel(int n) {
        super(new SpellerModel(n), new SpellerModel(n));
    }

    public BufferedSpellerModel(int n, int n2) {
        super(new SpellerModel(n, n2), new SpellerModel(n, n2));
    }

    protected BufferedSpellerModel(SpellerModel spellerModel, SpellerModel spellerModel2) {
        super(spellerModel, spellerModel2);
    }

    public void setMaxLength(int n) {
        this.getCurrent().setMaxLength(n);
    }

    public int getMaxLength() {
        return this.spellerModel.getMaxLength();
    }

    public void setMinLength(int n) {
        this.getCurrent().setMinLength(n);
    }

    public int getMinLength() {
        return this.spellerModel.getMinLength();
    }

    public void setSpellerListener(SpellerListener spellerListener) {
        this.spellerModel.setSpellerListener(spellerListener);
    }

    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    public String getText() {
        return this.spellerModel.getText();
    }

    public void setControlButtonStates(int n, int n2) {
        this.getCurrent().setControlButtonStates(n, n2);
    }

    public int getExitButtonState() {
        return this.spellerModel.getExitButtonState();
    }

    public int getDeleteButtonState() {
        return this.spellerModel.getDeleteButtonState();
    }

    public void clear() {
        this.getCurrent().clear();
    }

    public void endTransaction() throws IllegalStateException {
        super.endTransaction();
        this.spellerModel.fireModelUpdateEvent(1);
    }

    public void keyPressed(int n, int n2) {
        this.spellerModel.keyPressed(n, n2);
    }

    public void keyReleased(int n, int n2) {
        this.spellerModel.keyReleased(n, n2);
    }

    public void keyTyped(int n, int n2) {
        this.spellerModel.keyTyped(n, n2);
    }

    public void textChanged(String string, char c2, int n) {
        this.getCurrent().setText(string);
    }

    public void setCommandAvailable(int n, boolean bl) {
        this.getCurrent().setCommandAvailable(n, bl);
    }

    public boolean getCommandAvailable(int n) {
        return this.spellerModel.getCommandAvailable(n);
    }

    public void setExitButtonText(int n) {
        this.getCurrent().setExitButtonText(n);
    }

    public int getExitButtonText() {
        return this.spellerModel.getExitButtonText();
    }

    public void commandPressed(int n, int n2) {
        this.spellerModel.commandPressed(n, n2);
    }

    protected SpellerModel getCurrent() {
        return (SpellerModel)super.getActiveModel();
    }

    public String getCountryAbbreviation() {
        return this.spellerModel.getCountryAbbreviation();
    }

    public void setCountryAbbreviation(String string) {
        this.getCurrent().setCountryAbbreviation(string);
    }

    public void setCompletionText(String string) {
        this.getCurrent().setCompletionText(string);
    }

    public String getCompletionText() {
        return this.spellerModel.getCompletionText();
    }

    public void focusedCharacter(char c2, int n) {
        this.spellerModel.focusedCharacter(c2, n);
    }

    public void setSuggestions(String string, String string2) {
        this.getCurrent().setSuggestions(string, string2);
    }

    public String getTruffleSuggestion() {
        return this.spellerModel.getTruffleSuggestion();
    }

    public String getSuggestedNewSearchString() {
        return this.spellerModel.getSuggestedNewSearchString();
    }

    public void setSpellerInitiallyOpen(boolean bl) {
        this.getCurrent().setSpellerInitiallyOpen(bl);
    }

    public boolean shallSpellerBeInitiallyOpen() {
        return this.spellerModel.shallSpellerBeInitiallyOpen();
    }

    public TouchEvent getTouchEventForFollowUpScreen() {
        return this.spellerModel.getTouchEventForFollowUpScreen();
    }

    public void setTouchEventForFollowUpScreen(TouchEvent touchEvent) {
        this.getCurrent().setTouchEventForFollowUpScreen(touchEvent);
    }
}

