/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.auth.AbstractModelManager;

public abstract class AbstractHMIListener
implements BaseListModelListener,
ButtonListener,
ChoiceListener,
SpellerListener,
MenuModelListener {
    protected AbstractModelManager modelManager;
    protected LogChannel logChannel;

    public abstract int[] getSpellerModels() {
    }

    public abstract int[] getChoiceModels() {
    }

    public abstract int[] getButtonModels() {
    }

    public abstract int[] getListModels() {
    }

    public abstract int[] getTextFieldModel() {
    }

    public abstract void setModelManager(AbstractModelManager abstractModelManager) {
    }

    public AbstractHMIListener(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void init() {
        this.modelManager.initSpellerModels(this.getSpellerModels(), this);
        this.modelManager.initChoiceModels(this.getChoiceModels(), this);
        this.modelManager.initButtonModels(this.getButtonModels(), this);
        this.modelManager.initListModels(this.getListModels(), this);
        this.modelManager.initTextFieldModels(this.getTextFieldModel(), this);
    }

    public void deinit() {
        this.modelManager.initSpellerModels(this.getSpellerModels(), null);
        this.modelManager.initChoiceModels(this.getChoiceModels(), null);
        this.modelManager.initButtonModels(this.getButtonModels(), null);
        this.modelManager.initListModels(this.getListModels(), null);
        this.modelManager.initTextFieldModels(this.getTextFieldModel(), null);
    }

    protected void handlePasswordSpellerInput(String string, int n) {
        int n2 = string.length();
        String string2 = this.fillPasswordCharacters(n2);
        this.modelManager.setTextFieldText(n, string2);
    }

    private String fillPasswordCharacters(int n) {
        String string = "";
        for (int i2 = 0; i2 < n; ++i2) {
            string = new StringBuffer().append(string).append("*").toString();
        }
        return string;
    }

    protected void updateSpellerText(int n, String string, int n2) {
        this.modelManager.updateSpellerText(n, string);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
    }
}

