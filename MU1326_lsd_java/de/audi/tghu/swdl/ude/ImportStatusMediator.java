/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class ImportStatusMediator {
    private final LogChannel lc;
    private final ChoiceModelApp choiceModel;

    ImportStatusMediator(LogChannel logChannel, ChoiceModelApp choiceModelApp) {
        this.lc = logChannel;
        this.choiceModel = choiceModelApp;
    }

    void switchToErrorScreen() {
        this.lc.log(-2137614336, "[ImportStatusMediator.switchToErrorScreen]");
        this.choiceModel.setStatus(1);
        this.choiceModel.setValue(-1);
    }

    void showPPImporting() {
        this.lc.log(-2137614336, "[ImportStatusMediator.showPPImporting]");
        this.choiceModel.setStatus(0);
    }

    void showPPImportSucccess() {
        this.lc.log(-2137614336, "[ImportStatusMediator.showPPImportSuccess]");
        this.choiceModel.setStatus(1);
        this.choiceModel.setValue(0);
    }

    void hidePP() {
        this.lc.log(-2137614336, "[ImportStatusMediator.hidePP]");
        this.choiceModel.setStatus(2);
    }
}

