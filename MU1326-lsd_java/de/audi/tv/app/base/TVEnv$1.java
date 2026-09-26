/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.IConfiguration;
import de.audi.tv.app.base.TVEnv;

class TVEnv$1
implements IConfiguration {
    private final /* synthetic */ TVEnv this$0;

    TVEnv$1(TVEnv tVEnv) {
        this.this$0 = tVEnv;
    }

    @Override
    public int getDisplaySettingMinValue() {
        throw new UnsupportedOperationException("[TVEnv.configuration] No configuration registered!");
    }

    @Override
    public int getDisplaySettingMaxValue() {
        throw new UnsupportedOperationException("[TVEnv.configuration] No configuration registered!");
    }

    @Override
    public int getDisplaySettingStepWidth() {
        throw new UnsupportedOperationException("[TVEnv.configuration] No configuration registered!");
    }

    @Override
    public boolean hasAV() {
        throw new UnsupportedOperationException("[TVEnv.configuration] No configuration registered!");
    }
}

