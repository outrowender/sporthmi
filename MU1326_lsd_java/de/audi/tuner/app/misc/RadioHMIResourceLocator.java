/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.misc;

import de.audi.atip.hmi.model.HMIResourceLocator;

public class RadioHMIResourceLocator
extends HMIResourceLocator {
    public final int type;

    public RadioHMIResourceLocator(String string, int n) {
        super(string);
        this.type = n;
    }

    public RadioHMIResourceLocator(HMIResourceLocator hMIResourceLocator, int n) {
        super(hMIResourceLocator);
        this.type = n;
    }

    public RadioHMIResourceLocator(RadioHMIResourceLocator radioHMIResourceLocator) {
        super(radioHMIResourceLocator);
        this.type = radioHMIResourceLocator.type;
    }
}

