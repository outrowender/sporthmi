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

    @Override
    public void setMaxLength(int n) {
        this.getCurrent().setMaxLength(n);
    }

    @Override
    public int getMaxLength() {
        return this.spellerModel.getMaxLength();
    }

    @Override
    public void setMinLength(int n) {
        this.getCurrent().setMinLength(n);
    }

    @Override
    public int getMinLength() {
        return this.spellerModel.getMinLength();
    }

    @Override
    public void setSpellerListener(SpellerListener spellerListener) {
        this.spellerModel.setSpellerListener(spellerListener);
    }

    @Override
    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    @Override
    public String getText() {
        return this.spellerModel.getText();
    }

    @Override
    public void setControlButtonStates(int n, int n2) {
        this.getCurrent().setControlButtonStates(n, n2);
    }

    @Override
    public int getExitButtonState() {
        return this.spellerModel.getExitButtonState();
    }

    @Override
    public int getDeleteButtonState() {
        return this.spellerModel.getDeleteButtonState();
    }

    @Override
    public void clear() {
        this.getCurrent().clear();
    }

    @Override
    public void endTransaction() {
        super.endTransaction();
        this.spellerModel.fireModelUpdateEvent(1);
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.spellerModel.keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2) {
        this.spellerModel.keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2) {
        this.spellerModel.keyTyped(n, n2);
    }

    @Override
    public void textChanged(String string, char c2, int n) {
        this.getCurrent().setText(string);
    }

    @Override
    public void setCommandAvailable(int n, boolean bl) {
        this.getCurrent().setCommandAvailable(n, bl);
    }

    @Override
    public boolean getCommandAvailable(int n) {
        return this.spellerModel.getCommandAvailable(n);
    }

    @Override
    public void setExitButtonText(int n) {
        this.getCurrent().setExitButtonText(n);
    }

    @Override
    public int getExitButtonText() {
        return this.spellerModel.getExitButtonText();
    }

    @Override
    public void commandPressed(int n, int n2) {
        this.spellerModel.commandPressed(n, n2);
    }

    protected SpellerModel getCurrent() {
        return (SpellerModel)super.getActiveModel();
    }

    @Override
    public String getCountryAbbreviation() {
        return this.spellerModel.getCountryAbbreviation();
    }

    @Override
    public void setCountryAbbreviation(String string) {
        this.getCurrent().setCountryAbbreviation(string);
    }

    @Override
    public void setCompletionText(String string) {
        this.getCurrent().setCompletionText(string);
    }

    @Override
    public String getCompletionText() {
        return this.spellerModel.getCompletionText();
    }

    @Override
    public void focusedCharacter(char c2, int n) {
        this.spellerModel.focusedCharacter(c2, n);
    }

    @Override
    public void setSuggestions(String string, String string2) {
        this.getCurrent().setSuggestions(string, string2);
    }

    @Override
    public String getTruffleSuggestion() {
        return this.spellerModel.getTruffleSuggestion();
    }

    @Override
    public String getSuggestedNewSearchString() {
        return this.spellerModel.getSuggestedNewSearchString();
    }

    @Override
    public void setSpellerInitiallyOpen(boolean bl) {
        this.getCurrent().setSpellerInitiallyOpen(bl);
    }

    @Override
    public boolean shallSpellerBeInitiallyOpen() {
        return this.spellerModel.shallSpellerBeInitiallyOpen();
    }

    @Override
    public TouchEvent getTouchEventForFollowUpScreen() {
        return this.spellerModel.getTouchEventForFollowUpScreen();
    }

    @Override
    public void setTouchEventForFollowUpScreen(TouchEvent touchEvent) {
        this.getCurrent().setTouchEventForFollowUpScreen(touchEvent);
    }
}

