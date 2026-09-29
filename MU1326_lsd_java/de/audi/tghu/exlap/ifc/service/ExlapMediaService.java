/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.service;

import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.ListPageDataContainer;
import de.audi.tghu.exlap.impl.container.ListPageRequestContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserEntryContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.container.MediaSourceContainer;
import de.audi.tghu.exlap.impl.container.TrackPositionContainer;

public interface ExlapMediaService
extends ExlapService,
ExlapMediaListener {
    default public void setPlayMode(int n, MediaPlayModeContainer mediaPlayModeContainer) {
    }

    default public void nextTrack(int n) {
    }

    default public void previousTrack(int n) {
    }

    default public void playMedia(int n) {
    }

    default public void pauseMedia(int n) {
    }

    default public void setTrackPosition(int n, TrackPositionContainer trackPositionContainer) {
    }

    default public void activateMediaSource(int n, MediaSourceContainer mediaSourceContainer) {
    }

    default public void selectMediaBrowserSource(int n, MediaSourceContainer mediaSourceContainer) {
    }

    default public void mediaBrowserList(int n, ListPageRequestContainer listPageRequestContainer) {
    }

    default public void resultMediaBrowserList(int n, ListPageDataContainer listPageDataContainer) {
    }

    default public void enableMediaBrowserFollowMode(int n) {
    }

    default public void disableMediaBrowserFollowMode(int n) {
    }

    default public void changeMediaBrowserFolder(int n, MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    default public void mediaBrowserPlay(int n, MediaBrowserEntryContainer mediaBrowserEntryContainer) {
    }

    default public void activateAppConnectAudio(int n) {
    }
}

