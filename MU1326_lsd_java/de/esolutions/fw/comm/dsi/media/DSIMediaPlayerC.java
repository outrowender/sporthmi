/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMediaPlayerC {
    public void setPlaybackMode(int var1) throws MethodException;

    public void setVideoNorm(int var1) throws MethodException;

    public void setRating(long var1, int var3) throws MethodException;

    public void requestCoverArt(long var1) throws MethodException;

    public void requestFullyQualifiedName(long var1) throws MethodException;

    public void setEntry(long var1, int var3) throws MethodException;

    public void play() throws MethodException;

    public void resume() throws MethodException;

    public void pause() throws MethodException;

    public void stop() throws MethodException;

    public void seek(int var1, int var2) throws MethodException;

    public void skip(int var1, int var2) throws MethodException;

    public void setActiveMedia(long var1, long var3, int var5) throws MethodException;

    public void requestPlayView(long var1, int var3, int var4, int var5) throws MethodException;

    public void executeMenuCmd(int var1) throws MethodException;

    public void setVideoAngle(int var1) throws MethodException;

    public void setAudioStream(int var1) throws MethodException;

    public void setVideoFormat(int var1) throws MethodException;

    public void setSubtitleLanguage(int var1) throws MethodException;

    public void requestDetailInfo(long var1) throws MethodException;

    public void setPlaySelection(int var1, long var2, boolean var4) throws MethodException;

    public void setPlaySelectionAB(int var1) throws MethodException;

    public void setPlaybackURL(String var1) throws MethodException;

    public void setVideoRect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) throws MethodException;

    public void playSimilarEntry(long var1, int var3) throws MethodException;

    public void grantTempPMLRequest() throws MethodException;

    public void denyTempPMLRequest() throws MethodException;

    public void requestTouchEvent(int var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

