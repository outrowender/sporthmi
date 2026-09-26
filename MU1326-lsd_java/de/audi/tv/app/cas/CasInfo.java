/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DefaultTVListener;

public class CasInfo
extends DefaultTVListener {
    private final LabelModelApp labelModel;

    public CasInfo(TVEnv tVEnv) {
        this.labelModel = tVEnv.getLabelModel(1789667072);
    }

    @Override
    public void updateCASInfo(boolean bl, String string) {
        this.labelModel.setText(string);
    }
}

