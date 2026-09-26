/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.DefaultSettingListener;

public class ParentalActionConfirmations
extends DefaultSettingListener {
    private final TVEnv env;

    public ParentalActionConfirmations(TVEnv tVEnv) {
        this.env = tVEnv;
    }

    @Override
    public void passwordChanged() {
        this.env.framework.getHmiServiceApp().showPartialPopup(0, 1806444288);
    }
}

