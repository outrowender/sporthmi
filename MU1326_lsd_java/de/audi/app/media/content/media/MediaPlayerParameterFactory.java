/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractMediaPlayerHMIHandler;
import de.audi.app.media.content.media.HardKeyHandler;
import de.audi.app.media.content.media.ISeeker;
import de.audi.app.media.content.media.IncreaseSeekHandler;
import de.audi.app.media.content.media.MediaPlayerSeekerAdapter;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.app.media.util.CopyOnWriteMap;
import de.audi.atip.log.LogChannel;

public class MediaPlayerParameterFactory {
    public MediaPlayerSeekerAdapter createSeekAdapter(AbstractMediaPlayer abstractMediaPlayer) {
        return new MediaPlayerSeekerAdapter(abstractMediaPlayer);
    }

    public IncreaseSeekHandler createIncreaseSeekHandler(ISeeker iSeeker, LogChannel logChannel) {
        return new IncreaseSeekHandler(iSeeker, logChannel);
    }

    public AbstractMediaPlayerHMIHandler createAbstractMediaHMIHandler(IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer) {
        return new AbstractMediaPlayerHMIHandler(iMediaTerminal, abstractMediaPlayer);
    }

    public HardKeyHandler createHardKeyHandler(IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer) {
        return new HardKeyHandler(iMediaTerminal, abstractMediaPlayer);
    }

    public Queue createQueue(LogChannel logChannel, String string) {
        return new Queue(logChannel, string);
    }

    public CopyOnWriteArrayList createCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList();
    }

    public CopyOnWriteMap createCopyOnWriteMap(int n) {
        return new CopyOnWriteMap(n);
    }
}

