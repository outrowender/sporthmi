/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.IConfiguration;

public final class EvoConfiguration
implements IConfiguration {
    @Override
    public int getDisplaySettingMinValue() {
        return -126;
    }

    @Override
    public int getDisplaySettingMaxValue() {
        return 126;
    }

    @Override
    public int getDisplaySettingStepWidth() {
        return 14;
    }

    @Override
    public boolean hasAV() {
        return true;
    }
}

