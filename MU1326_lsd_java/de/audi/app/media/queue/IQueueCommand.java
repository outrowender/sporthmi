/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.queue;

import de.audi.app.media.queue.IQueueJob;
import java.util.List;

public interface IQueueCommand {
    public void execute(IQueueJob var1, List var2);
}

