/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;

public class ResourceLocatorListCell
implements ListCell,
ResourceLocatorModelGUI {
    private final HMIResourceLocator resource;

    public ResourceLocatorListCell(int n, String string) {
        this.resource = new HMIResourceLocator(n, string);
    }

    @Override
    public HMIResourceLocator getResourceLocator() {
        return this.resource;
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof ResourceLocatorListCell)) {
            return false;
        }
        ResourceLocatorListCell resourceLocatorListCell = (ResourceLocatorListCell)object;
        return this.resource.equals(resourceLocatorListCell.getResourceLocator());
    }

    public int hashCode() {
        return this.resource == null ? 0 : this.resource.hashCode();
    }

    public String toString() {
        return this.resource == null ? "resourceLocator:null" : this.resource.toString();
    }
}

