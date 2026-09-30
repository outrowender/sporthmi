/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractOnlinePlayerControllerJob
extends AbstractQueueJob {
    protected final LogChannel logger;
    private final String name;

    public AbstractOnlinePlayerControllerJob(LogChannel logChannel, String string) {
        this.logger = logChannel;
        this.name = string;
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

    public void onOnlineContentActivated() {
    }

    public void onActiveSessionDetached() {
    }

    public void onOnlineSourceDeactivated() {
    }
}

