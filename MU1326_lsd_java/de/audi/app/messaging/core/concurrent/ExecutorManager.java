/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.concurrent;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.job.JobLogger;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public final class ExecutorManager
extends AbstractMessagingComponent {
    private final CommandListManager commandListManager;
    private final DispatcherBase internalTaskDispatcher;
    private final DispatcherBase externalTaskDispatcher;

    public ExecutorManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.commandListManager = new CommandListManager("(CommandListManager)", this.framework, this.framework.getLogChannel("App.Messaging.CmdList"), null, null);
        this.commandListManager.start();
        this.internalTaskDispatcher = this.framework.getDispatcherManager().createDispatcher("(InternalDispatcher)", new JobLogger(this.framework.getLogChannel("App.Messaging.InternalDispatcher")));
        this.internalTaskDispatcher.start();
        this.externalTaskDispatcher = this.framework.getDispatcherManager().createDispatcher("(ExternalDispatcher)", new JobLogger(this.framework.getLogChannel("App.Messaging.InterAppDispatcher")));
        this.externalTaskDispatcher.start();
    }

    public void dispose() {
        super.dispose();
        this.commandListManager.destroy();
        this.internalTaskDispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.internalTaskDispatcher.getDispatcherName());
        this.externalTaskDispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.externalTaskDispatcher.getDispatcherName());
    }

    public CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    public DispatcherBase getInternalTaskDispatcher() {
        return this.internalTaskDispatcher;
    }

    public DispatcherBase getExternalTaskDispatcher() {
        return this.externalTaskDispatcher;
    }
}

