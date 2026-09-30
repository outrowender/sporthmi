/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractCommandHandler {
    private final String name;

    public AbstractCommandHandler(String string) {
        this.name = string;
    }

    public String getName() {
        return this.name;
    }

    public abstract void indicateCommand(int var1, Object var2);

    protected LogAppender getParamsForDebugging(Object object) {
        return null;
    }

    protected final String getFullName() {
        String string = this.getName();
        Buffer buffer = new Buffer("command-handler-".length() + string.length());
        buffer.append("command-handler-");
        buffer.append(string);
        return buffer.toString();
    }

    public RemoteHMITask createTask(final int n, final Object object) {
        return new AbstractRemoteHMITask(this.getFullName(), this.getParamsForDebugging(object)){

            public void run() {
                AbstractCommandHandler.this.indicateCommand(n, object);
            }
        };
    }
}

