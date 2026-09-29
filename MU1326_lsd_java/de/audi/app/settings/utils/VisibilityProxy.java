/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.utils;

import de.audi.atip.hmi.model.ChoiceModel;

public class VisibilityProxy {
    private static final int VISIBLE;
    private static final int INVISIBLE;
    private static final int DISABLED;
    private ChoiceModel model;

    public VisibilityProxy(ChoiceModel choiceModel) {
        this.model = choiceModel;
    }

    public void setVisible() {
        this.model.setValue(0);
    }

    public void setInvisible() {
        this.model.setValue(1);
    }

    public void enableIfVisible() {
    }

    public void disableIfVisible() {
    }
}

