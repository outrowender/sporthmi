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

    public void setMaxLength(int n) {
        this.getCurrent().setMaxLength(n);
    }

    public int getMaxLength() {
        return this.ipSpellerModel.getMaxLength();
    }

    public void setMinLength(int n) {
        this.getCurrent().setMinLength(n);
    }

    public int getMinLength() {
        return this.ipSpellerModel.getMinLength();
    }

    public void setSpellerListener(MatchSpellerListener matchSpellerListener) {
        this.ipSpellerModel.setSpellerListener(matchSpellerListener);
    }

    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    public String getText() {
        return this.ipSpellerModel.getText();
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
        return this.ipSpellerModel.getDeleteButtonState();
    }

    public int getExitButtonState() {
        return this.ipSpellerModel.getExitButtonState();
    }

    public int getMatchCountVisibility() {
        return this.ipSpellerModel.getMatchCountVisibility();
    }

    public String getValidChars() {
        return this.ipSpellerModel.getValidChars();
    }

    public void setZIPFlag(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setZIPFlag(bl);
    }

    public boolean isZIP() {
        return this.ipSpellerModel.isZIP();
    }

    public void clear() {
        this.getCurrent().clear();
    }

    public void keyPressed(int n, int n2) {
        this.ipSpellerModel.keyPressed(n, n2);
    }

    public void keyReleased(int n, int n2) {
        this.ipSpellerModel.keyReleased(n, n2);
    }

    public void keyTyped(int n, int n2) {
        this.ipSpellerModel.keyTyped(n, n2);
    }

    public void textChanged(String string, char c2, int n) {
        this.getCurrent().textChanged(string, c2, n);
    }

    public void setMatchCount(int n) {
        ((MatchspellerModel)this.getCurrent()).setMatchCount(n);
    }

    public void setMatchCount(int n, int n2) {
        ((MatchspellerModel)this.getCurrent()).setMatchCount(n, n2);
    }

    public int getMatchCount() {
        return this.ipSpellerModel.getMatchCount();
    }

    public void setUniqueMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setUniqueMatch(bl);
    }

    public boolean isUniqueMatch() {
        return this.ipSpellerModel.isUniqueMatch();
    }

    public boolean isFullMatch() {
        return this.ipSpellerModel.isFullMatch();
    }

    public void setFullMatch(boolean bl) {
        ((MatchspellerModel)this.getCurrent()).setFullMatch(bl);
    }

    public void setCompletionText(String string) {
        ((MatchspellerModel)this.getCurrent()).setCompletionText(string);
    }

    public String getCompletionText() {
        return this.ipSpellerModel.getCompletionText();
    }

    public void setCommandAvailable(int n, boolean bl) {
        this.getCurrent().setCommandAvailable(n, bl);
    }

    public boolean getCommandAvailable(int n) {
        return this.ipSpellerModel.getCommandAvailable(n);
    }

    public void commandPressed(int n, int n2) {
        this.ipSpellerModel.commandPressed(n, n2);
    }

    public void setLanguage(int n) {
        ((MatchspellerModel)this.getCurrent()).setLanguage(n);
    }

    public int getLanguage() {
        return this.ipSpellerModel.getLanguage();
    }

    public String getCountryAbbreviation() {
        return this.ipSpellerModel.getCountryAbbreviation();
    }

    public void setCountryAbbreviation(String string) {
        this.getCurrent().setCountryAbbreviation(string);
    }
}

