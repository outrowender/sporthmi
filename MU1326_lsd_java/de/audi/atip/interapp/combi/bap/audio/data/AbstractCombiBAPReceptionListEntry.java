/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public abstract class AbstractCombiBAPReceptionListEntry
implements CombiBAPArrayElement {
    public static final int ATTRIBUTE_AVAILABLE = 1;
    public static final int ATTRIBUTE_DVB_SERVICE_CORRUPTED = 2;
    public static final int ATTRIBUTE_DAB_PRIMARY_SERVICE_CONTAINS_SECONDARY_SERVICES = 4;
    public static final int ATTRIBUTE_DAB_PRIMARY_SERVICE_CORRUPTED = 8;
    public static final int ATTRIBUTE_DAB_SERVICE_FM_LINKED = 16;
    public static final int ATTRIBUTE_TP_AVAILABLE = 32;
    public static final int ATTRIBUTE_TMC_AVAILABLE = 64;
    public static final int ATTRIBUTE_SDARS_STATION_SUBSCRIBED_OR_NOT_AN_SDARS_STATION = 128;
    public static final int ATTRIBUTE_DAB_SERVICE_LINKED_TO_ONLINE_RADIO = 256;
    public static final int ATTRIBUTE_FM_LINKED_TO_ONLINE_RADIO = 512;
    protected int posID;
    protected int attributes;
    protected int presetID;
    protected int category;
    protected String name;
    protected String frequency;
    protected String pictureURL;

    public AbstractCombiBAPReceptionListEntry(int n, String string, String string2, int n2, int n3, int n4, String string3) {
        this.posID = n;
        this.name = string;
        this.frequency = string2;
        this.attributes = n2;
        this.presetID = n3;
        this.category = n4;
        this.pictureURL = string3;
    }

    public int getPosID() {
        return this.posID;
    }

    public int getAttributes() {
        return this.attributes;
    }

    public boolean hasAttribute(int n) {
        return (this.attributes & n) == n;
    }

    public void setAttributes(int n) {
        this.attributes = n;
    }

    public void addAttribute(int n) {
        this.attributes |= n;
    }

    public int getPresetID() {
        return this.presetID;
    }

    public void setPresetID(int n) {
        this.presetID = n;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int n) {
        this.category = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String string) {
        this.frequency = string;
    }

    public String getPictureURL() {
        return this.pictureURL;
    }

    public void setPictureURL(String string) {
        this.pictureURL = string;
    }
}

