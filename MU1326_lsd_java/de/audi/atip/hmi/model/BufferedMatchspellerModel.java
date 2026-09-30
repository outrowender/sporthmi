/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedSpellerModel;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;

public class BufferedMatchspellerModel
extends BufferedSpellerModel
implements MatchspellerModelApp,
MatchspellerModelGUI {
    private MatchspellerModel matchspellerModel = (MatchspellerModel)super.getMainModel();

    public BufferedMatchspellerModel(int n) {
        super(new MatchspellerModel(n), new MatchspellerModel(n));
    }

    public BufferedMatchspellerModel(int n, int n2) {
        super(new MatchspellerModel(n, n2), new MatchspellerModel(n, n2));
    }

    protected BufferedMatchspellerModel(MatchspellerModel matchspellerModel, MatchspellerModel matchspellerModel2) {
        super(matchspellerModel, matchspellerModel2);
    }

    public void setMaxLength(int n) {
        this.getCurrent().setMaxLength(n);
    }

    public int getMaxLength() {
        return this.matchspellerModel.getMaxLength();
    }

    public void setMinLength(int n) {
        this.getCurrent().setMinLength(n);
    }

    public int getMinLength() {
        return this.matchspellerModel.getMinLength();
    }

    public void setSpellerListener(MatchSpellerListener matchSpellerListener) {
        this.matchspellerModel.setSpellerListener(matchSpellerListener);
    }

    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    public String getText() {
        return this.matchspellerModel.getText();
    }

    public void setValidChars(String string) {
        ((MatchspellerModel)this.getCurrent()).setValidChars(string);
    }

    public void setValidChars(String string, int n) {
        ((MatchspellerModel)this.getCurrent()).setValidChars(string, n);
    }

    public void setValidChars(String string, int n, int n2) {
        ((MatchspellerModel)this.getCurrent()).setValidChars(string, n, n2);
    }

    public int getDeleteButtonState() {
        return this.matchspellerModel.getDeleteButtonState();
    }

    public int getExitButtonState() {
        return this.matchspellerModel.getExitButtonState();
    }

    public int getMatchCountVisibility() {
        return this.matchspellerModel.getMatchCountVisibility();
    }

    public String getValidChars() {
        return this.matchspellerModel.getValidChars();
    }

    public void setZIPFlag(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setZIPFlag(bl);
    }

    public boolean isZIP() {
        return this.matchspellerModel.isZIP();
    }

    public void clear() {
        ((MatchspellerModel)this.getCurrent()).clear();
    }

    public void keyPressed(int n, int n2) {
        this.matchspellerModel.keyPressed(n, n2);
    }

    public void keyReleased(int n, int n2) {
        this.matchspellerModel.keyReleased(n, n2);
    }

    public void keyTyped(int n, int n2) {
        this.matchspellerModel.keyTyped(n, n2);
    }

    public void textChanged(String string, char c2, int n) {
        ((MatchspellerModel)this.getCurrent()).textChanged(string, c2, n);
    }

    public void setMatchCount(int n) {
        ((MatchspellerModel)this.getCurrent()).setMatchCount(n);
    }

    public void setMatchCount(int n, int n2) {
        ((MatchspellerModel)this.getCurrent()).setMatchCount(n, n2);
    }

    public int getMatchCount() {
        return this.matchspellerModel.getMatchCount();
    }

    public void setUniqueMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setUniqueMatch(bl);
    }

    public boolean isUniqueMatch() {
        return this.matchspellerModel.isUniqueMatch();
    }

    public boolean isFullMatch() {
        return this.matchspellerModel.isFullMatch();
    }

    public void setFullMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setFullMatch(bl);
    }

    public void setCompletionText(String string) {
        ((MatchspellerModel)this.getCurrent()).setCompletionText(string);
    }

    public String getCompletionText() {
        return this.matchspellerModel.getCompletionText();
    }

    public void setCommandAvailable(int n, boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setCommandAvailable(n, bl);
    }

    public boolean getCommandAvailable(int n) {
        return this.matchspellerModel.getCommandAvailable(n);
    }

    public void commandPressed(int n, int n2) {
        this.matchspellerModel.commandPressed(n, n2);
    }

    public void setLanguage(int n) {
        ((MatchspellerModel)this.getCurrent()).setLanguage(n);
    }

    public int getLanguage() {
        return this.matchspellerModel.getLanguage();
    }

    public String getCountryAbbreviation() {
        return this.matchspellerModel.getCountryAbbreviation();
    }

    public void setCountryAbbreviation(String string) {
        ((MatchspellerModel)this.getCurrent()).setCountryAbbreviation(string);
    }

    public void setPhonemeText(String string, String string2) {
        ((MatchspellerModel)this.getCurrent()).setPhonemeText(string, string2);
    }

    public String getPhonemeText() {
        return ((MatchspellerModel)this.getCurrent()).getPhonemeText();
    }

    public String getPhonemeAlphabet() {
        return ((MatchspellerModel)this.getCurrent()).getPhonemeAlphabet();
    }

    public void setValidNonAlphaNumTPCharacters(String string) {
        ((MatchspellerModel)super.getCurrent()).setValidNonAlphaNumTPCharacters(string);
    }

    public String getValidNonAlphaNumTPCharacters(int n) {
        return ((MatchspellerModel)super.getMainModel()).getValidNonAlphaNumTPCharacters(n);
    }

    public void nonAlphaNumTPCharsChanged(String string, int n) {
        ((MatchspellerModel)super.getMainModel()).nonAlphaNumTPCharsChanged(string, n);
    }

    public void inputModeTPChanged(int n, int n2) {
        ((MatchspellerModel)super.getMainModel()).inputModeTPChanged(n, n2);
    }

    public void setInitialInputMode(int n) {
        ((MatchspellerModel)super.getMainModel()).setInitialInputMode(n);
    }

    public int getInitialInputMode(int n) {
        return ((MatchspellerModel)super.getMainModel()).getInitialInputMode(n);
    }

    public int getNonAlphaNumMode(int n) {
        return ((MatchspellerModel)super.getMainModel()).getNonAlphaNumMode(n);
    }

    public void setAllowNonAlphaNumInput(boolean bl) {
        ((MatchspellerModel)super.getMainModel()).setAllowNonAlphaNumInput(bl);
    }

    public boolean getAllowNonAlphaNumInput(int n) {
        return ((MatchspellerModel)super.getMainModel()).getAllowNonAlphaNumInput(n);
    }

    public void set(MatchSpellerListener matchSpellerListener) {
        this.matchspellerModel.setSpellerListener(matchSpellerListener);
    }

    public void setSpellerListenerAsia(MatchspellerListenerAsia matchspellerListenerAsia) {
        this.matchspellerModel.setSpellerListenerAsia(matchspellerListenerAsia);
    }

    public void strokesChanged(int n, String string, char c2) {
        ((MatchspellerModel)super.getMainModel()).strokesChanged(n, string, c2);
    }

    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        ((MatchspellerModel)super.getMainModel()).requestValidHanziCharsWindow(n, n2, n3);
    }

    public String getValidHanziCharsWindowResult() {
        return ((MatchspellerModel)super.getMainModel()).getValidHanziCharsWindowResult();
    }

    public int getTotalAmountOfHanziCharacters() {
        return ((MatchspellerModel)super.getMainModel()).getTotalAmountOfHanziCharacters();
    }

    public void setValidHanziChars(String string, int n) {
        ((MatchspellerModel)super.getMainModel()).setValidHanziChars(string, n);
    }
}

