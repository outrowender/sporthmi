/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

public final class CombiBAPAudioSourceAttributes {
    public static final int ATTRIBUTE_BUILT_IN_BUT_NOT_READY;
    public static final int ATTRIBUTE_MEDIA_AUDIO_SOURCE_ERROR;
    public static final int ATTRIBUTE_MEDIA_IS_NOT_PLAYABLE;
    public static final int ATTRIBUTE_MEDIA_IS_NOT_READABLE;
    public static final int ATTRIBUTE_MEDIA_IS_BEING_LOADED;
    public static final int ATTRIBUTE_IMPORT_RUNNING;
    public static final int ATTRIBUTE_MEDIUM_DOES_NOT_SUPPORTS_BROWSER_LIST_DF_42;
    private boolean builtInButNotReady = false;
    private boolean mediaAudioSourceError = false;
    private boolean mediaIsNotPlayable = false;
    private boolean mediaIsNotReadable = false;
    private boolean mediaIsBeingLoaded = false;
    private boolean importRunning = false;
    private boolean mediumDoesNotSupportBrowserList = false;

    public CombiBAPAudioSourceAttributes() {
    }

    public CombiBAPAudioSourceAttributes(CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        this.set(combiBAPAudioSourceAttributes);
    }

    public CombiBAPAudioSourceAttributes(int n) {
        this.set(n);
    }

    public void reset() {
        this.builtInButNotReady = false;
        this.mediaAudioSourceError = false;
        this.mediaIsNotPlayable = false;
        this.mediaIsNotReadable = false;
        this.mediaIsBeingLoaded = false;
        this.importRunning = false;
        this.mediumDoesNotSupportBrowserList = false;
    }

    public boolean isBuiltInButNotReady() {
        return this.builtInButNotReady;
    }

    public void setBuiltInButNotReady(boolean bl) {
        this.builtInButNotReady = bl;
    }

    public boolean isMediaAudioSourceError() {
        return this.mediaAudioSourceError;
    }

    public void setMediaAudioSourceError(boolean bl) {
        this.mediaAudioSourceError = bl;
    }

    public boolean isMediaIsNotPlayable() {
        return this.mediaIsNotPlayable;
    }

    public void setMediaIsNotPlayable(boolean bl) {
        this.mediaIsNotPlayable = bl;
    }

    public boolean isMediaIsNotReadable() {
        return this.mediaIsNotReadable;
    }

    public void setMediaIsNotReadable(boolean bl) {
        this.mediaIsNotReadable = bl;
    }

    public boolean isMediaIsBeingLoaded() {
        return this.mediaIsBeingLoaded;
    }

    public void setMediaIsBeingLoaded(boolean bl) {
        this.mediaIsBeingLoaded = bl;
    }

    public boolean isImportRunning() {
        return this.importRunning;
    }

    public void setImportRunning(boolean bl) {
        this.importRunning = bl;
    }

    public boolean isMediumDoesNotSupportBrowserList() {
        return this.mediumDoesNotSupportBrowserList;
    }

    public void setMediumDoesNotSupportBrowserList(boolean bl) {
        this.mediumDoesNotSupportBrowserList = bl;
    }

    public void set(CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        this.builtInButNotReady = combiBAPAudioSourceAttributes.builtInButNotReady;
        this.mediaAudioSourceError = combiBAPAudioSourceAttributes.mediaAudioSourceError;
        this.mediaIsNotPlayable = combiBAPAudioSourceAttributes.mediaIsNotPlayable;
        this.mediaIsNotReadable = combiBAPAudioSourceAttributes.mediaIsNotReadable;
        this.mediaIsBeingLoaded = combiBAPAudioSourceAttributes.mediaIsBeingLoaded;
        this.importRunning = combiBAPAudioSourceAttributes.importRunning;
        this.mediumDoesNotSupportBrowserList = combiBAPAudioSourceAttributes.mediumDoesNotSupportBrowserList;
    }

    public void set(int n) {
        this.builtInButNotReady = CombiBAPAudioSourceAttributes.hasAttribute(n, 1);
        this.mediaAudioSourceError = CombiBAPAudioSourceAttributes.hasAttribute(n, 2);
        this.mediaIsNotPlayable = CombiBAPAudioSourceAttributes.hasAttribute(n, 4);
        this.mediaIsNotReadable = CombiBAPAudioSourceAttributes.hasAttribute(n, 8);
        this.mediaIsBeingLoaded = CombiBAPAudioSourceAttributes.hasAttribute(n, 16);
        this.importRunning = CombiBAPAudioSourceAttributes.hasAttribute(n, 32);
        this.mediumDoesNotSupportBrowserList = CombiBAPAudioSourceAttributes.hasAttribute(n, 64);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.builtInButNotReady ? 1231 : 1237);
        n = 31 * n + (this.importRunning ? 1231 : 1237);
        n = 31 * n + (this.mediaAudioSourceError ? 1231 : 1237);
        n = 31 * n + (this.mediaIsBeingLoaded ? 1231 : 1237);
        n = 31 * n + (this.mediaIsNotPlayable ? 1231 : 1237);
        n = 31 * n + (this.mediaIsNotReadable ? 1231 : 1237);
        n = 31 * n + (this.mediumDoesNotSupportBrowserList ? 1231 : 1237);
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
        CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes = (CombiBAPAudioSourceAttributes)object;
        if (this.builtInButNotReady != combiBAPAudioSourceAttributes.builtInButNotReady) {
            return false;
        }
        if (this.importRunning != combiBAPAudioSourceAttributes.importRunning) {
            return false;
        }
        if (this.mediaAudioSourceError != combiBAPAudioSourceAttributes.mediaAudioSourceError) {
            return false;
        }
        if (this.mediaIsBeingLoaded != combiBAPAudioSourceAttributes.mediaIsBeingLoaded) {
            return false;
        }
        if (this.mediaIsNotPlayable != combiBAPAudioSourceAttributes.mediaIsNotPlayable) {
            return false;
        }
        if (this.mediaIsNotReadable != combiBAPAudioSourceAttributes.mediaIsNotReadable) {
            return false;
        }
        return this.mediumDoesNotSupportBrowserList == combiBAPAudioSourceAttributes.mediumDoesNotSupportBrowserList;
    }

    public String toString() {
        return new StringBuffer().append("CombiBAPAudioSourceAttributes [builtInButNotReady=").append(this.builtInButNotReady).append(", mediaAudioSourceError=").append(this.mediaAudioSourceError).append(", mediaIsNotPlayable=").append(this.mediaIsNotPlayable).append(", mediaIsNotReadable=").append(this.mediaIsNotReadable).append(", mediaIsBeingLoaded=").append(this.mediaIsBeingLoaded).append(", importRunning=").append(this.importRunning).append(", mediumDoesNotSupportBrowserList=").append(this.mediumDoesNotSupportBrowserList).append("]").toString();
    }

    private static boolean hasAttribute(int n, int n2) {
        return (n & n2) == n2;
    }
}

