/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler$1;
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

    public abstract void indicateCommand(int n, Object object) {
    }

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

    public RemoteHMITask createTask(int n, Object object) {
        return new AbstractCommandHandler$1(this, this.getFullName(), this.getParamsForDebugging(object), n, object);
    }
}

