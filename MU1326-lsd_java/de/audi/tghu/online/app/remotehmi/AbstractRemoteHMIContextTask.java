/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

public abstract class AbstractRemoteHMIContextTask
extends AbstractRemoteHMITask {
    protected final String contextName;

    public AbstractRemoteHMIContextTask(String string, String string2) {
        this(string, string2, null);
    }

    public AbstractRemoteHMIContextTask(String string, String string2, LogAppender logAppender) {
        super(string2, logAppender);
        this.contextName = string;
    }

    public final String getContextName() {
        return this.contextName;
    }
}

