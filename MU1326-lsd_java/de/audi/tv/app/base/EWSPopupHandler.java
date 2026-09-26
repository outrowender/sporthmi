/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.IEWSPopupHandler;
import de.audi.tv.app.base.TVEnv;

public class EWSPopupHandler
implements IEWSPopupHandler {
    private final TVEnv env;

    public EWSPopupHandler(TVEnv tVEnv) {
        this.env = tVEnv;
    }

    @Override
    public void showPopup() {
        this.env.framework.getHmiServiceApp().showPopup(1085024000);
    }

    @Override
    public void hidePopup() {
    }

    @Override
    public void showDetails() {
    }

    @Override
    public void showAreaList() {
    }
}

