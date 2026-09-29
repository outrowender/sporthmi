/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.interapp.displaymanager.Cropping;
import de.audi.tv.app.settings.ICroppingAdjuster$1;

public interface ICroppingAdjuster {
    public static final ICroppingAdjuster DEFAULT = new ICroppingAdjuster$1();

    default public Cropping adjustIfNecessary(Cropping cropping) {
    }
}

