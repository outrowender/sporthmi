/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedSpellerModel;
import de.audi.atip.hmi.model.SpellerModelAsia;
import de.audi.atip.hmi.modelaccess.SpellerModelAsiaApp;
import de.audi.atip.hmi.modelaccess.SpellerModelAsiaGUI;

public class BufferedSpellerModelAsia
extends BufferedSpellerModel
implements SpellerModelAsiaApp,
SpellerModelAsiaGUI {
    public BufferedSpellerModelAsia(int n) {
        super(new SpellerModelAsia(n), new SpellerModelAsia(n));
    }

    public BufferedSpellerModelAsia(int n, int n2) {
        super(new SpellerModelAsia(n, n2), new SpellerModelAsia(n, n2));
    }

    @Override
    public String getPhonetic() {
        return ((SpellerModelAsia)super.getMainModel()).getPhonetic();
    }

    @Override
    public void setText(String string, String string2) {
        ((SpellerModelAsia)super.getCurrent()).setText(string, string2);
    }

    @Override
    public void textChanged(String string, String string2, int n) {
        ((SpellerModelAsia)super.getCurrent()).textChanged(string, string2, n);
    }

    @Override
    public void textChanged(String string, String string2, char c2, int n) {
        ((SpellerModelAsia)super.getCurrent()).textChanged(string, string2, c2, n);
    }
}

