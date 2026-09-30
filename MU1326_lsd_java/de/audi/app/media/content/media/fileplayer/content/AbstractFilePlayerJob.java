/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractFilePlayerJob
extends AbstractQueueJob {
    protected final LogChannel logger;
    private final String name;
    private final IFilePlayer filePlayer;

    public AbstractFilePlayerJob(LogChannel logChannel, String string, IFilePlayer iFilePlayer) {
        this.logger = logChannel;
        this.name = string;
        this.filePlayer = iFilePlayer;
    }

    protected IFilePlayer getPlayer() {
        return this.filePlayer;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public void abort(boolean bl) {
    }

    protected void setSessionPlaybackState() {
        FilePlayerSession filePlayerSession = this.getPlayer().getState().getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 4: {
                filePlayerSession.updateState(5);
                this.getPlayer().getAudioManager().requestVolumelock("File player stopped");
                break;
            }
            case 11: {
                filePlayerSession.updateState(6);
                this.getPlayer().getAudioManager().requestVolumelock("File player stopped with error");
                break;
            }
            case 3: {
                filePlayerSession.updateState(2);
                this.getPlayer().getAudioManager().releaseVolumelock("File player playing");
                break;
            }
            case 5: {
                filePlayerSession.updateState(3);
                this.getPlayer().getAudioManager().releaseVolumelock("File player paused");
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                filePlayerSession.updateState(4);
                this.getPlayer().getAudioManager().releaseVolumelock("File player seeking");
                break;
            }
        }
    }

    public void onPlaybackStateChanged() {
    }

    public void onCapabilitiesChanged() {
    }

    public void onResponsePlaybackURL() {
    }

    public void onPlaybackModeChanged() {
    }

    public void onPlaybackModeListChanged() {
    }

    public void onAudioStateChanged() {
    }

    public void onPlayerError(int n) {
    }

    public void onUpdatePlayPosition(int n, int n2) {
    }
}

