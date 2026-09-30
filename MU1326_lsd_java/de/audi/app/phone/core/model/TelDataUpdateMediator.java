/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class TelDataUpdateMediator {
    private static final int NOT_AVAILABLE_VALUE = -1;
    private static final int AVAILABLE_VALUE = 0;
    private static final int UPDATE_VALUE = 0;
    private static final int ERROR_DEFAULT_VALUE = 0;
    private final ChoiceModelApp choiceModel;
    private final LogChannel log;

    public TelDataUpdateMediator(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.choiceModel = choiceModelApp;
        this.log = logChannel;
    }

    public void setNotAvailable() {
        this.setChoiceModel(1, -1);
    }

    public void setUpdate() {
        this.setChoiceModel(0, 0);
    }

    public void setAvaible() {
        this.setChoiceModel(1, 0);
    }

    public void setError(int n) {
        this.setChoiceModel(2, n);
    }

    public void setError() {
        this.setError(0);
    }

    private void setChoiceModel(int n, int n2) {
        TelModelGroup telModelGroup = new TelModelGroup("TelDataUpdateMediator#setChoiceModel", this.log);
        telModelGroup.add(this.choiceModel);
        this.choiceModel.setStatus(n);
        this.choiceModel.setValue(n2);
        telModelGroup.flush();
        telModelGroup.removeAll();
    }
}

