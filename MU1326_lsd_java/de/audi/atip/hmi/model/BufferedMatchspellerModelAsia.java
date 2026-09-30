/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedMatchspellerModel;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.MatchspellerModelAsia;
import de.audi.atip.hmi.modelaccess.MatchspellerModelAsiaApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelAsiaGUI;

public class BufferedMatchspellerModelAsia
extends BufferedMatchspellerModel
implements MatchspellerModelAsiaApp,
MatchspellerModelAsiaGUI {
    public BufferedMatchspellerModelAsia(int n) {
        super(new MatchspellerModelAsia(n), new MatchspellerModelAsia(n));
    }

    public BufferedMatchspellerModelAsia(int n, int n2) {
        super(new MatchspellerModelAsia(n, n2), new MatchspellerModelAsia(n, n2));
    }

    public void setValidNonAlphaNumTPCharacters(String string) {
        ((MatchspellerModelAsia)super.getCurrent()).setValidNonAlphaNumTPCharacters(string);
    }

    public String getValidNonAlphaNumTPCharacters(int n) {
        return ((MatchspellerModelAsia)super.getMainModel()).getValidNonAlphaNumTPCharacters(n);
    }

    public void nonAlphaNumTPCharsChanged(String string, int n) {
        ((MatchspellerModelAsia)super.getMainModel()).nonAlphaNumTPCharsChanged(string, n);
    }

    public void inputModeTPChanged(int n, int n2) {
        ((MatchspellerModelAsia)super.getMainModel()).inputModeTPChanged(n, n2);
    }

    public void setInitialInputMode(int n) {
        ((MatchspellerModelAsia)super.getMainModel()).setInitialInputMode(n);
    }

    public int getInitialInputMode(int n) {
        return ((MatchspellerModelAsia)super.getMainModel()).getInitialInputMode(n);
    }

    public int getNonAlphaNumMode(int n) {
        return ((MatchspellerModelAsia)super.getMainModel()).getNonAlphaNumMode(n);
    }

    public void setAllowNonAlphaNumInput(boolean bl) {
        ((MatchspellerModelAsia)super.getMainModel()).setAllowNonAlphaNumInput(bl);
    }

    public boolean getAllowNonAlphaNumInput(int n) {
        return ((MatchspellerModelAsia)super.getMainModel()).getAllowNonAlphaNumInput(n);
    }

    public void setSpellerListenerAsia(MatchspellerListenerAsia matchspellerListenerAsia) {
        ((MatchspellerModelAsia)super.getMainModel()).setSpellerListenerAsia(matchspellerListenerAsia);
    }
}

