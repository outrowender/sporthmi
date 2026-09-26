/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.presets;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.evo.presets.MediaPresetData;
import de.audi.app.media.evo.presets.MediaPresetHandler;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.log.LogChannel;
import java.io.Serializable;

public class MediaPreset
extends MediaFavorite {
    private final ISourceSlot presetSlot;
    private final MediaPresetHandler presetHandler;

    public MediaPreset(LogChannel logChannel, ISourceSlot iSourceSlot, MediaListEntry mediaListEntry, MediaListEntry[] mediaListEntryArray, int n, MediaPresetHandler mediaPresetHandler) {
        super(logChannel, mediaListEntry, mediaListEntryArray, n);
        this.presetSlot = iSourceSlot;
        this.presetHandler = mediaPresetHandler;
    }

    public MediaPreset(LogChannel logChannel, ISourceSlot iSourceSlot, MediaFavorite mediaFavorite, MediaPresetHandler mediaPresetHandler) {
        super(logChannel, mediaFavorite);
        this.presetSlot = iSourceSlot;
        this.presetHandler = mediaPresetHandler;
    }

    public String getSourcename() {
        return this.presetSlot.getSource().getName();
    }

    public Serializable getSerializablePreset() {
        return new MediaPresetData(this.getInternalBrowseType(), this.getPath(), this.getSerializedFavorite(), this.presetSlot.getSource().getType(), ((MediaSourceSlot)this.presetSlot).getUniqueMediaId());
    }

    public static MediaPreset getMediaPresetFromSerializable(LogChannel logChannel, MediaPresetData mediaPresetData, ISourceResolver iSourceResolver, MediaPresetHandler mediaPresetHandler) {
        return new MediaPreset(logChannel, iSourceResolver.getSourceSlot((long)mediaPresetData.getSourceType(), mediaPresetData.getMediaUniqueId()), MediaFavorite.getFavoriteFromPersistence(logChannel, mediaPresetData.getPreset()), MediaFavorite.getPathFromPersistence(mediaPresetData.getPath()), mediaPresetData.getBroweMode(), mediaPresetHandler);
    }

    public ISourceSlot getPresetSlot() {
        return this.presetSlot;
    }

    public boolean isPresetSourceActivatable() {
        return this.presetSlot != null && this.presetSlot.isLoaded();
    }

    public String getName() {
        if (this.isFolderstackEmpty()) {
            return this.getSourcename();
        }
        return this.getLabelText(this.getFavoriteEntry());
    }

    private String getLabelText(I18NString i18NString) {
        switch (i18NString.getI18NKey()) {
            case 3: {
                return this.presetHandler.getText(2099184384);
            }
            case 4: {
                return this.presetHandler.getText(2115961600);
            }
            case 6: {
                return this.presetHandler.getText(2132738816);
            }
            case 7: {
                return this.presetHandler.getText(-2145451264);
            }
            case 9: {
                return this.presetHandler.getText(-2128674048);
            }
            case 10: {
                return this.presetHandler.getText(-2111896832);
            }
            case 50: {
                return this.presetHandler.getText(1159725824);
            }
            case 51: {
                return this.presetHandler.getText(1142948608);
            }
            case 30: {
                return this.presetHandler.getText(-2095119616);
            }
            case 13: {
                return this.presetHandler.getText(-769719552);
            }
        }
        return i18NString.getOriginalString();
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this.presetSlot == null ? 0 : this.presetSlot.hashCode());
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MediaPreset mediaPreset = (MediaPreset)object;
        if (this.presetSlot == null) {
            return mediaPreset.presetSlot == null;
        }
        return ((Object)this.presetSlot).equals(mediaPreset.presetSlot);
    }
}

