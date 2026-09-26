/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import org.dsi.ifc.global.ResourceLocator;

public interface ICombiBAPContentAccessor {
    public static final int LIST_STATE_COMPLETELY_LOADED;
    public static final int LIST_STATE_INCOMPLETE_LOADED;
    public static final int LIST_STATE_LOADING;
    public static final int LIST_STATE_UNKNOW;
    public static final int FILEPLAYER_RINGTONE;
    public static final int FILEPLAYER_BOARDBOOK;

    default public void updateCurrentPlayingTrack(int n, long l, int n2, int n3, I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n4, ResourceLocator resourceLocator) {
    }

    default public void updateActiveRepeatScope(int n, boolean bl) {
    }

    default public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray, int n) {
    }

    default public void updateListSize(int n) {
    }

    default public void updateListState(boolean bl, int n) {
    }

    default public void contentAdapterStartupFinished() {
    }

    default public void updateActiveFileplayerPlaybackType(int n) {
    }

    default public void gotoCurrentPlayingTrackResult(boolean bl) {
    }

    default public void gotoParentFolderResult(boolean bl) {
    }

    default public void gotoRootFolderResult(boolean bl) {
    }

    default public void gotoSubFolderResult(boolean bl) {
    }

    default public void updatePlaybackFolder(boolean bl) {
    }

    default public void responseList(int n, int n2, int n3, MediaListEntry[] mediaListEntryArray) {
    }

    default public void getNextListPosResult(boolean bl, CombiBAPMediaEntry combiBAPMediaEntry, CombiBAPMediaEntry combiBAPMediaEntry2, int n) {
    }

    default public void selectListEntryResult(boolean bl) {
    }

    default public void updateSeekState(boolean bl) {
    }

    default public void changeActiveSourceMediaType(int n) {
    }

    default public void updateOnlineMusicState(int n, int n2, int n3) {
    }

    default public void trackChangeIsComing() {
    }

    default public void updatePlayPosition(PlayTime playTime) {
    }
}

