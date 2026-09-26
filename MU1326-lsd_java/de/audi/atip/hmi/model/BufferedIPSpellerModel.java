/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedMatchspellerModel;
import de.audi.atip.hmi.model.IPSpellerModel;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.modelaccess.IPSpellerModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;

public class BufferedIPSpellerModel
extends BufferedMatchspellerModel
implements IPSpellerModelApp,
MatchspellerModelGUI {
    private IPSpellerModel ipSpellerModel = (IPSpellerModel)super.getMainModel();

    public BufferedIPSpellerModel(int n) {
        super(new IPSpellerModel(n), new IPSpellerModel(n));
    }

    public BufferedIPSpellerModel(int n, int n2) {
        super(new IPSpellerModel(n, n2), new IPSpellerModel(n, n2));
    }

    @Override
    public void setMaxLength(int n) {
        this.getCurrent().setMaxLength(n);
    }

    @Override
    public int getMaxLength() {
        return this.ipSpellerModel.getMaxLength();
    }

    @Override
    public void setMinLength(int n) {
        this.getCurrent().setMinLength(n);
    }

    @Override
    public int getMinLength() {
        return this.ipSpellerModel.getMinLength();
    }

    @Override
    public void setSpellerListener(MatchSpellerListener matchSpellerListener) {
        this.ipSpellerModel.setSpellerListener(matchSpellerListener);
    }

    @Override
    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    @Override
    public String getText() {
        return this.ipSpellerModel.getText();
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
        return this.ipSpellerModel.getDeleteButtonState();
    }

    @Override
    public int getExitButtonState() {
        return this.ipSpellerModel.getExitButtonState();
    }

    @Override
    public int getMatchCountVisibility() {
        return this.ipSpellerModel.getMatchCountVisibility();
    }

    @Override
    public String getValidChars() {
        return this.ipSpellerModel.getValidChars();
    }

    @Override
    public void setZIPFlag(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setZIPFlag(bl);
    }

    @Override
    public boolean isZIP() {
        return this.ipSpellerModel.isZIP();
    }

    @Override
    public void clear() {
        this.getCurrent().clear();
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.ipSpellerModel.keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2) {
        this.ipSpellerModel.keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2) {
        this.ipSpellerModel.keyTyped(n, n2);
    }

    @Override
    public void textChanged(String string, char c2, int n) {
        this.getCurrent().textChanged(string, c2, n);
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
        return this.ipSpellerModel.getMatchCount();
    }

    @Override
    public void setUniqueMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setUniqueMatch(bl);
    }

    @Override
    public boolean isUniqueMatch() {
        return this.ipSpellerModel.isUniqueMatch();
    }

    @Override
    public boolean isFullMatch() {
        return this.ipSpellerModel.isFullMatch();
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
        return this.ipSpellerModel.getCompletionText();
    }

    @Override
    public void setCommandAvailable(int n, boolean bl) {
        this.getCurrent().setCommandAvailable(n, bl);
    }

    @Override
    public boolean getCommandAvailable(int n) {
        return this.ipSpellerModel.getCommandAvailable(n);
    }

    @Override
    public void commandPressed(int n, int n2) {
        this.ipSpellerModel.commandPressed(n, n2);
    }

    @Override
    public void setLanguage(int n) {
        ((MatchspellerModel)this.getCurrent()).setLanguage(n);
    }

    @Override
    public int getLanguage() {
        return this.ipSpellerModel.getLanguage();
    }

    @Override
    public String getCountryAbbreviation() {
        return this.ipSpellerModel.getCountryAbbreviation();
    }

    @Override
    public void setCountryAbbreviation(String string) {
        this.getCurrent().setCountryAbbreviation(string);
    }
}

