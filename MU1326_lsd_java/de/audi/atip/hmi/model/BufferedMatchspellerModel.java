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

    @Override
    public void setMaxLength(int n) {
        this.getCurrent().setMaxLength(n);
    }

    @Override
    public int getMaxLength() {
        return this.matchspellerModel.getMaxLength();
    }

    @Override
    public void setMinLength(int n) {
        this.getCurrent().setMinLength(n);
    }

    @Override
    public int getMinLength() {
        return this.matchspellerModel.getMinLength();
    }

    public void setSpellerListener(MatchSpellerListener matchSpellerListener) {
        this.matchspellerModel.setSpellerListener(matchSpellerListener);
    }

    @Override
    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    @Override
    public String getText() {
        return this.matchspellerModel.getText();
    }

    @Override
    public void setValidChars(String string) {
        ((MatchspellerModel)this.getCurrent()).setValidChars(string);
    }

    @Override
    public void setValidChars(String string, int n) {
        ((MatchspellerModel)this.getCurrent()).setValidChars(string, n);
    }

    @Override
    public void setValidChars(String string, int n, int n2) {
        ((MatchspellerModel)this.getCurrent()).setValidChars(string, n, n2);
    }

    @Override
    public int getDeleteButtonState() {
        return this.matchspellerModel.getDeleteButtonState();
    }

    @Override
    public int getExitButtonState() {
        return this.matchspellerModel.getExitButtonState();
    }

    @Override
    public int getMatchCountVisibility() {
        return this.matchspellerModel.getMatchCountVisibility();
    }

    @Override
    public String getValidChars() {
        return this.matchspellerModel.getValidChars();
    }

    @Override
    public void setZIPFlag(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setZIPFlag(bl);
    }

    @Override
    public boolean isZIP() {
        return this.matchspellerModel.isZIP();
    }

    @Override
    public void clear() {
        ((MatchspellerModel)this.getCurrent()).clear();
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.matchspellerModel.keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2) {
        this.matchspellerModel.keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2) {
        this.matchspellerModel.keyTyped(n, n2);
    }

    @Override
    public void textChanged(String string, char c2, int n) {
        ((MatchspellerModel)this.getCurrent()).textChanged(string, c2, n);
    }

    @Override
    public void setMatchCount(int n) {
        ((MatchspellerModel)this.getCurrent()).setMatchCount(n);
    }

    @Override
    public void setMatchCount(int n, int n2) {
        ((MatchspellerModel)this.getCurrent()).setMatchCount(n, n2);
    }

    @Override
    public int getMatchCount() {
        return this.matchspellerModel.getMatchCount();
    }

    @Override
    public void setUniqueMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setUniqueMatch(bl);
    }

    @Override
    public boolean isUniqueMatch() {
        return this.matchspellerModel.isUniqueMatch();
    }

    @Override
    public boolean isFullMatch() {
        return this.matchspellerModel.isFullMatch();
    }

    @Override
    public void setFullMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setFullMatch(bl);
    }

    @Override
    public void setCompletionText(String string) {
        ((MatchspellerModel)this.getCurrent()).setCompletionText(string);
    }

    @Override
    public String getCompletionText() {
        return this.matchspellerModel.getCompletionText();
    }

    @Override
    public void setCommandAvailable(int n, boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setCommandAvailable(n, bl);
    }

    @Override
    public boolean getCommandAvailable(int n) {
        return this.matchspellerModel.getCommandAvailable(n);
    }

    @Override
    public void commandPressed(int n, int n2) {
        this.matchspellerModel.commandPressed(n, n2);
    }

    @Override
    public void setLanguage(int n) {
        ((MatchspellerModel)this.getCurrent()).setLanguage(n);
    }

    @Override
    public int getLanguage() {
        return this.matchspellerModel.getLanguage();
    }

    @Override
    public String getCountryAbbreviation() {
        return this.matchspellerModel.getCountryAbbreviation();
    }

    @Override
    public void setCountryAbbreviation(String string) {
        ((MatchspellerModel)this.getCurrent()).setCountryAbbreviation(string);
    }

    @Override
    public void setPhonemeText(String string, String string2) {
        ((MatchspellerModel)this.getCurrent()).setPhonemeText(string, string2);
    }

    @Override
    public String getPhonemeText() {
        return ((MatchspellerModel)this.getCurrent()).getPhonemeText();
    }

    @Override
    public String getPhonemeAlphabet() {
        return ((MatchspellerModel)this.getCurrent()).getPhonemeAlphabet();
    }

    @Override
    public void setValidNonAlphaNumTPCharacters(String string) {
        ((MatchspellerModel)super.getCurrent()).setValidNonAlphaNumTPCharacters(string);
    }

    @Override
    public String getValidNonAlphaNumTPCharacters(int n) {
        return ((MatchspellerModel)super.getMainModel()).getValidNonAlphaNumTPCharacters(n);
    }

    @Override
    public void nonAlphaNumTPCharsChanged(String string, int n) {
        ((MatchspellerModel)super.getMainModel()).nonAlphaNumTPCharsChanged(string, n);
    }

    @Override
    public void inputModeTPChanged(int n, int n2) {
        ((MatchspellerModel)super.getMainModel()).inputModeTPChanged(n, n2);
    }

    @Override
    public void setInitialInputMode(int n) {
        ((MatchspellerModel)super.getMainModel()).setInitialInputMode(n);
    }

    @Override
    public int getInitialInputMode(int n) {
        return ((MatchspellerModel)super.getMainModel()).getInitialInputMode(n);
    }

    public int getNonAlphaNumMode(int n) {
        return ((MatchspellerModel)super.getMainModel()).getNonAlphaNumMode(n);
    }

    @Override
    public void setAllowNonAlphaNumInput(boolean bl) {
        ((MatchspellerModel)super.getMainModel()).setAllowNonAlphaNumInput(bl);
    }

    @Override
    public boolean getAllowNonAlphaNumInput(int n) {
        return ((MatchspellerModel)super.getMainModel()).getAllowNonAlphaNumInput(n);
    }

    public void set(MatchSpellerListener matchSpellerListener) {
        this.matchspellerModel.setSpellerListener(matchSpellerListener);
    }

    @Override
    public void setSpellerListenerAsia(MatchspellerListenerAsia matchspellerListenerAsia) {
        this.matchspellerModel.setSpellerListenerAsia(matchspellerListenerAsia);
    }

    @Override
    public void strokesChanged(int n, String string, char c2) {
        ((MatchspellerModel)super.getMainModel()).strokesChanged(n, string, c2);
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        ((MatchspellerModel)super.getMainModel()).requestValidHanziCharsWindow(n, n2, n3);
    }

    @Override
    public String getValidHanziCharsWindowResult() {
        return ((MatchspellerModel)super.getMainModel()).getValidHanziCharsWindowResult();
    }

    @Override
    public int getTotalAmountOfHanziCharacters() {
        return ((MatchspellerModel)super.getMainModel()).getTotalAmountOfHanziCharacters();
    }

    @Override
    public void setValidHanziChars(String string, int n) {
        ((MatchspellerModel)super.getMainModel()).setValidHanziChars(string, n);
    }
}

