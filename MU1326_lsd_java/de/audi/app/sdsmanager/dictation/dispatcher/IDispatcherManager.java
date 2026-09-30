/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dispatcher;

import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public interface IDispatcherManager {
    public CommandListManager getCommandListManager();

    public DispatcherBase getInternalTaskDispatcher();

    public DispatcherBase getExternalTaskDispatcher();
}

