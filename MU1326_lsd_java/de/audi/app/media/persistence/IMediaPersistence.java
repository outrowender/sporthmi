/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.persistence.MediaStorage;
import de.audi.app.media.source.ISourceSlot;

public interface IMediaPersistence {
    public static final int SCOPE_GLOBAL;
    public static final int SCOPE_SOURCE;
    public static final int SCOPE_MEDIATYPE;
    public static final int SCOPE_SOURCESLOT;
    public static final String GLOBAL_KEY_DVDV_PM_LEVEL;
    public static final String GLOBAL_KEY_DVDV_PM_PASSWORD;
    public static final String GLOBAL_KEY_DVDV_REGIONCODE_CHANGES_LEFT;
    public static final String GLOBAL_KEY_LAST_ACTIVE_SOURCE;
    public static final String GLOBAL_KEY_LAST_ACTIVE_SLOT;
    public static final String GLOBAL_KEY_IOS_AUTOSTART;
    public static final String GLOBAL_KEY_RIPPING_ENCODING_QUALITY;
    public static final String GLOBAL_KEY_BROWSER_LAST_SELECTION;
    public static final String GLOBAL_KEY_DVDC_REPEAT_SCOPE;
    public static final String DEFAULT_PML_PASSWORD;
    public static final int DEFAULT_PML_LEVEL;
    public static final String DEFAULT_IOS_AUTOSTART;

    default public void setGlobalStringProperty(String string, String string2) {
    }

    default public void setGlobalIntProperty(String string, int n) {
    }

    default public String getGlobalStringProperty(String string) {
    }

    default public int getGlobalIntProperty(String string) {
    }

    default public void setLocalProperty(int n, ISourceSlot iSourceSlot, int n2, Object object) {
    }

    default public Object getLocalProperty(int n, ISourceSlot iSourceSlot, int n2, Object object) {
    }

    default public void registerIntProperty(String string, int n, int n2, int n3) {
    }

    default public void registerStringProperty(String string, String string2) {
    }

    default public MediaStorage getStorage() {
    }
}

