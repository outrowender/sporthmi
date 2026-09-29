/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractFilePlayerControllerJob
extends AbstractQueueJob {
    protected final LogChannel logger;
    private final String name;

    public AbstractFilePlayerControllerJob(LogChannel logChannel, String string) {
        this.logger = logChannel;
        this.name = string;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String toString() {
        return "";
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void abort(boolean bl) {
    }

    public void onFilePlayerActive() {
    }

    public void onActiveSessionDetached() {
    }
}

