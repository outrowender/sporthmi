/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;

public class TVSettings$Properties {
    public final Property visualAudioActive;

    public TVSettings$Properties(PropertyFactory propertyFactory) {
        this.visualAudioActive = propertyFactory.createProperty("TVSettings.visualAudioActive", new Boolean(true));
    }
}

