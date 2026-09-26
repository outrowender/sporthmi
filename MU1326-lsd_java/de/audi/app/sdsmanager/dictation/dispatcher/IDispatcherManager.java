/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dispatcher;

import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public interface IDispatcherManager {
    default public CommandListManager getCommandListManager() {
    }

    default public DispatcherBase getInternalTaskDispatcher() {
    }

    default public DispatcherBase getExternalTaskDispatcher() {
    }
}

