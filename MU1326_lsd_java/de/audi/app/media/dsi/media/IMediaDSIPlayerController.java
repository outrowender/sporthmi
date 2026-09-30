/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.source.ISourceActivationCallbackHandler;

public interface IMediaDSIPlayerController
extends IDSIController {
    public static final int SETENTRY_PLAY_FROM_THE_BEGINNING = -1;

    public void setPlayerListener(IMediaPlayerListener var1);

    public void activate(long var1, long var3);

    public void setSourceActivationListener(ISourceActivationCallbackHandler var1);

    public void deactivate();

    public boolean setPlaybackMode(int var1);

    public boolean setVideoNorm(int var1);

    public boolean requestCoverArtURL(long var1);

    public boolean setEntry(long var1, int var3);

    public boolean resume();

    public boolean pause();

    public boolean stop();

    public boolean skip(int var1, int var2);

    public boolean touchEvent(int var1, int var2, int var3);

    public boolean requestPlayView(long var1, int var3, int var4, int var5);

    public void discardPlayViewRequest(int var1);

    public boolean executeMenuCmd(int var1);

    public boolean setVideoAngle(int var1);

    public boolean setAudioStream(int var1);

    public boolean setVideoFormat(int var1);

    public boolean setSubtitleLanguage(int var1);

    public boolean requestDetailInfo(long var1);

    public boolean setPlaySelection(int var1, long var2, boolean var4);

    public boolean setPlaySelectionCoverflow(int var1);

    public boolean grantTempPMLRequest();

    public boolean denyTempPMLRequest();

    public boolean dsiSeek(boolean var1, int var2);

    public boolean playSimilarEntries(long var1, int var3);

    public boolean setPlaybackURL(String var1);

    public boolean requestFullQualifiedName(long var1);

    public boolean setVideoRect(int var1, int var2, int var3, int var4);

    public void deactivateSource() throws InterruptedException;
}

