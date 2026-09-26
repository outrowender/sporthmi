/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;

public class ApplicationUpdate {
    private final Application application;
    private final ApplicationOwner owner;

    public ApplicationUpdate(Application application, ApplicationOwner applicationOwner) {
        this.application = application;
        this.owner = applicationOwner;
    }

    public Application getApplication() {
        return this.application;
    }

    public ApplicationOwner getOwner() {
        return this.owner;
    }
}

