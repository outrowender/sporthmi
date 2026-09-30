/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractPlayerJob
extends AbstractQueueJob {
    protected final LogChannel logger;
    private final String name;
    protected final IPlayer player;

    public AbstractPlayerJob(LogChannel logChannel, String string, IPlayer iPlayer) {
        this.logger = logChannel;
        this.name = string;
        this.player = iPlayer;
    }

    public int getType() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public void abort(boolean bl) {
    }
}

