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
    public void setPlayMode(int var1, MediaPlayModeContainer var2);

    public void nextTrack(int var1);

    public void previousTrack(int var1);

    public void playMedia(int var1);

    public void pauseMedia(int var1);

    public void setTrackPosition(int var1, TrackPositionContainer var2);

    public void activateMediaSource(int var1, MediaSourceContainer var2);

    public void selectMediaBrowserSource(int var1, MediaSourceContainer var2);

    public void mediaBrowserList(int var1, ListPageRequestContainer var2);

    public void resultMediaBrowserList(int var1, ListPageDataContainer var2);

    public void enableMediaBrowserFollowMode(int var1);

    public void disableMediaBrowserFollowMode(int var1);

    public void changeMediaBrowserFolder(int var1, MediaBrowserPathContainer var2);

    public void mediaBrowserPlay(int var1, MediaBrowserEntryContainer var2);

    public void activateAppConnectAudio(int var1);
}

