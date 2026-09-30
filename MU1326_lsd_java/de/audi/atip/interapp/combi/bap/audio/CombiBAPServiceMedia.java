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
    public void updateSourceListMedia(int[] var1, CombiBAPAudioSource[][] var2);

    public void updateCurrentBrowseFolder(int var1, String var2, int var3, int var4, int var5);

    public void trackChangeIsComing();

    public void updateBrowserListSize(int var1);

    public void responseMediaBrowserList(int var1, CombiBAPMediaBrowserListEntry[] var2);

    public void updatePlaybackFolder(boolean var1);

    public void goToResult(int var1, int var2);

    public void updateMediaImportState(int var1, int var2, boolean var3, int var4);

    public void responseCoverArt(long var1, int var3, String var4, int var5);

    public void updatePlayPosition(PlayPosition var1);
}

