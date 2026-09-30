/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.interapp.displaymanager.Cropping;

public interface ICroppingAdjuster {
    public static final ICroppingAdjuster DEFAULT = new ICroppingAdjuster(){

        public Cropping adjustIfNecessary(Cropping cropping) {
            return cropping;
        }
    };

    public Cropping adjustIfNecessary(Cropping var1);
}

