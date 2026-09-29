/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.source.ISourceActivationCallbackHandler;

public interface IMediaDSIPlayerController
extends IDSIController {
    public static final int SETENTRY_PLAY_FROM_THE_BEGINNING;

    default public void setPlayerListener(IMediaPlayerListener iMediaPlayerListener) {
    }

    default public void activate(long l, long l2) {
    }

    default public void setSourceActivationListener(ISourceActivationCallbackHandler iSourceActivationCallbackHandler) {
    }

    default public void deactivate() {
    }

    default public boolean setPlaybackMode(int n) {
    }

    default public boolean setVideoNorm(int n) {
    }

    default public boolean requestCoverArtURL(long l) {
    }

    default public boolean setEntry(long l, int n) {
    }

    default public boolean resume() {
    }

    default public boolean pause() {
    }

    default public boolean stop() {
    }

    default public boolean skip(int n, int n2) {
    }

    default public boolean touchEvent(int n, int n2, int n3) {
    }

    default public boolean requestPlayView(long l, int n, int n2, int n3) {
    }

    default public void discardPlayViewRequest(int n) {
    }

    default public boolean executeMenuCmd(int n) {
    }

    default public boolean setVideoAngle(int n) {
    }

    default public boolean setAudioStream(int n) {
    }

    default public boolean setVideoFormat(int n) {
    }

    default public boolean setSubtitleLanguage(int n) {
    }

    default public boolean requestDetailInfo(long l) {
    }

    default public boolean setPlaySelection(int n, long l, boolean bl) {
    }

    default public boolean setPlaySelectionCoverflow(int n) {
    }

    default public boolean grantTempPMLRequest() {
    }

    default public boolean denyTempPMLRequest() {
    }

    default public boolean dsiSeek(boolean bl, int n) {
    }

    default public boolean playSimilarEntries(long l, int n) {
    }

    default public boolean setPlaybackURL(String string) {
    }

    default public boolean requestFullQualifiedName(long l) {
    }

    default public boolean setVideoRect(int n, int n2, int n3, int n4) {
    }

    default public void deactivateSource() {
    }
}

