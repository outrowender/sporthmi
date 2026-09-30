/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.IConfiguration;

public final class EvoConfiguration
implements IConfiguration {
    public int getDisplaySettingMinValue() {
        return -126;
    }

    public int getDisplaySettingMaxValue() {
        return 126;
    }

    public int getDisplaySettingStepWidth() {
        return 14;
    }

    public boolean hasAV() {
        return true;
    }
}

