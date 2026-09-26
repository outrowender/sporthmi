/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPAudioListStates {
    private boolean mediaBrowserListAvailable;
    private boolean presetListAvailable;
    private boolean receptionListAvailable;
    private int listState;

    public boolean isMediaBrowserListAvailable() {
        return this.mediaBrowserListAvailable;
    }

    public void setMediaBrowserListAvailable(boolean bl) {
        this.mediaBrowserListAvailable = bl;
    }

    public boolean isPresetListAvailable() {
        return this.presetListAvailable;
    }

    public void setPresetListAvailable(boolean bl) {
        this.presetListAvailable = bl;
    }

    public boolean isReceptionListAvailable() {
        return this.receptionListAvailable;
    }

    public void setReceptionListAvailable(boolean bl) {
        this.receptionListAvailable = bl;
    }

    public int getListState() {
        return this.listState;
    }

    public void setListState(int n) {
        this.listState = n;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.listState;
        n = 31 * n + (this.mediaBrowserListAvailable ? 1231 : 1237);
        n = 31 * n + (this.presetListAvailable ? 1231 : 1237);
        n = 31 * n + (this.receptionListAvailable ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CombiBAPAudioListStates combiBAPAudioListStates = (CombiBAPAudioListStates)object;
        if (this.listState != combiBAPAudioListStates.listState) {
            return false;
        }
        if (this.mediaBrowserListAvailable != combiBAPAudioListStates.mediaBrowserListAvailable) {
            return false;
        }
        if (this.presetListAvailable != combiBAPAudioListStates.presetListAvailable) {
            return false;
        }
        return this.receptionListAvailable == combiBAPAudioListStates.receptionListAvailable;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPAudioListStates {mediaBrowserListAvailable=");
        buffer.append(this.mediaBrowserListAvailable);
        buffer.append(", presetListAvailable=");
        buffer.append(this.presetListAvailable);
        buffer.append(", receptionListAvailable=");
        buffer.append(this.receptionListAvailable);
        buffer.append(", listState=");
        buffer.append(this.listState);
        buffer.append("}");
        return buffer.toString();
    }
}

