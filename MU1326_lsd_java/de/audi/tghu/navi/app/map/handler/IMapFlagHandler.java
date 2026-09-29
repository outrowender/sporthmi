/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.utils.MapPin;

public interface IMapFlagHandler {
    public static final int PERSONAL_DEST_INDEX_UNDEFINED;
    public static final int PERSONAL_DEST_INDEX_FOR_REMOVE;
    public static final int PERSONAL_DEST_INDEX_FOR_REPLACE;
    public static final int PERSONAL_DEST_INDEX_FOR_ADD;
    public static final int PERSONAL_DEST_INDEX_MAX;

    default public void refresh(boolean bl) {
    }

    default public void refresh(boolean bl, boolean bl2) {
    }

    default public void setTemporaryPins(MapPin[] mapPinArray) {
    }

    default public void addTemporaryPins(MapPin[] mapPinArray) {
    }

    default public void removeTemporaryPins(MapPin[] mapPinArray) {
    }

    default public void cleanPins(MapPin[] mapPinArray) {
    }

    default public void setPins(MapPin[] mapPinArray) {
    }

    default public void cleanAllPins() {
    }

    default public MapPin[] getPins() {
    }

    default public MapPin getPin(long l) {
    }

    default public boolean configureFlags(long[] lArray) {
    }

    default public void onChangedRenderer(int n) {
    }
}

