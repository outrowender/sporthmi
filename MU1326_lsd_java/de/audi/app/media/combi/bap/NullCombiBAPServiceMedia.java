/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPMediaBrowserListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullCombiBAPServiceMedia
extends NullService
implements CombiBAPServiceMedia {
    protected NullCombiBAPServiceMedia(LogChannel logChannel) {
        super(logChannel, 1078071040, "CombiBAPServiceMedia");
    }

    @Override
    public void updateActiveSource(int n, int n2, int n3, boolean bl, boolean bl2, int n4) {
        this.log();
    }

    @Override
    public void updateActiveSourceState(int n, int n2) {
        this.log();
    }

    @Override
    public void updateCurrentStation(CombiBAPCurrentStationInfo combiBAPCurrentStationInfo) {
        this.log();
    }

    @Override
    public void updateActiveInfoState(int n) {
        this.log();
    }

    @Override
    public void updateSourceListMedia(int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.log();
    }

    @Override
    public void switchSourceResult(int n) {
        this.log();
    }

    @Override
    public void selectListEntryResult(int n) {
        this.log();
    }

    @Override
    public void skipResult(boolean bl) {
        this.log();
    }

    @Override
    public void updateSeekStatus(boolean bl) {
        this.log();
    }

    @Override
    public void updatePreferredList(int n) {
        this.log();
    }

    @Override
    public void getNextListPosResult(int n, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void updateCurrentBrowseFolder(int n, String string, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void updateBrowserListSize(int n) {
        this.log();
    }

    @Override
    public void responseMediaBrowserList(int n, CombiBAPMediaBrowserListEntry[] combiBAPMediaBrowserListEntryArray) {
        this.log();
    }

    @Override
    public void goToResult(int n, int n2) {
        this.log();
    }

    @Override
    public void updatePlaybackFolder(boolean bl) {
        this.log();
    }

    @Override
    public void restoreInfoState(int n) {
        this.log();
    }

    @Override
    public void activateSourceResult(int n) {
        this.log();
    }

    @Override
    public void updateMediaImportState(int n, int n2, boolean bl, int n3) {
        this.log();
    }

    @Override
    public void updateOnlineMusicState(int n, int n2) {
        this.log();
    }

    @Override
    public void responseCoverArt(long l, int n, String string, int n2) {
        this.log();
    }

    @Override
    public void trackChangeIsComing() {
        this.log();
    }

    @Override
    public void updatePlayPosition(PlayPosition playPosition) {
        this.log();
    }
}

