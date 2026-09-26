/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;

public class DisplayManagerHandler$Properties {
    public final ReadOnlyProperty currentDisplayableId;
    public final ReadOnlyProperty showVideoPossible;

    public DisplayManagerHandler$Properties(PropertyFactory propertyFactory) {
        this.currentDisplayableId = propertyFactory.createProperty("DisplayManagerHandler.currentDisplayableId");
        this.showVideoPossible = propertyFactory.createProperty("DisplayManagerHandler.showVideoPossible", new Boolean(false));
    }

    private Property writeableCurrentDisplayableId() {
        return (Property)this.currentDisplayableId;
    }

    private Property writeableShowVideoPossible() {
        return (Property)this.showVideoPossible;
    }

    static /* synthetic */ Property access$000(DisplayManagerHandler$Properties displayManagerHandler$Properties) {
        return displayManagerHandler$Properties.writeableCurrentDisplayableId();
    }

    static /* synthetic */ Property access$100(DisplayManagerHandler$Properties displayManagerHandler$Properties) {
        return displayManagerHandler$Properties.writeableShowVideoPossible();
    }
}

