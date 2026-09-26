/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.atip.log.LogChannel;

public abstract class AbstractSDSCommand
implements ISDSCommandListener {
    protected final LogChannel logger;

    public AbstractSDSCommand(LogChannel logChannel) {
        this.logger = logChannel;
    }
}

