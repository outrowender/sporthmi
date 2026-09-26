/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import de.audi.remotehmi.ui.mib2.grid.GeoPosition;

public interface IPreviewContainer$INavInfo {
    default public void setPosition(GeoPosition geoPosition) {
    }

    default public void setStreet(String string) {
    }

    default public void setZip(String string) {
    }

    default public void setCountry(String string) {
    }

    default public void setNumber(String string) {
    }

    default public void setName(String string) {
    }

    default public void setCity(String string) {
    }

    default public void setCalculateRRD(boolean bl) {
    }

    default public void setStartRg(boolean bl) {
    }

    default public GeoPosition getPosition() {
    }

    default public String getStreet() {
    }

    default public String getZip() {
    }

    default public String getCountry() {
    }

    default public String getNumber() {
    }

    default public String getName() {
    }

    default public String getCity() {
    }

    default public boolean isCalculateRRD() {
    }

    default public boolean isStartRg() {
    }

    default public String getState() {
    }

    default public void setState(String string) {
    }
}

