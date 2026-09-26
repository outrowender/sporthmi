/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIContextTask;

public abstract class AbstractRemoteHMIViewTask
extends AbstractRemoteHMIContextTask {
    protected final Integer viewType;

    public AbstractRemoteHMIViewTask(String string, Integer n, String string2) {
        this(string, n, string2, null);
    }

    public AbstractRemoteHMIViewTask(String string, Integer n, String string2, LogAppender logAppender) {
        super(string, string2, logAppender);
        this.viewType = n;
    }

    public final Integer getViewType() {
        return this.viewType;
    }
}

