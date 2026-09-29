/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudio;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;

public interface CombiBAPServiceMedia
extends CombiBAPServiceAudio {
    default public void updateSourceListMedia(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
    }

    default public void updateCurrentBrowseFolder(int n, String string, int n2, int n3, int n4) {
    }

    default public void trackChangeIsComing() {
    }

    default public void updateBrowserListSize(int n) {
    }

    default public void responseMediaBrowserList(int n, CombiBAPMediaBrowserListEntry[] combiBAPMediaBrowserListEntryArray) {
    }

    default public void updatePlaybackFolder(boolean bl) {
    }

    default public void goToResult(int n, int n2) {
    }

    default public void updateMediaImportState(int n, int n2, boolean bl, int n3) {
    }

    default public void responseCoverArt(long l, int n, String string, int n2) {
    }

    default public void updatePlayPosition(PlayPosition playPosition) {
    }
}

