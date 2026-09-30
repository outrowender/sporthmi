/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dispatcher;

import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dispatcher.IDispatcherManager;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public final class DispatcherManager
extends AbstractDictationComponent
implements IDispatcherManager {
    private final CommandListManager commandListManager;
    private final DispatcherBase internalDispatcher;
    private final DispatcherBase externalDispatcher;

    public DispatcherManager(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
        this.commandListManager = new CommandListManager("(SdsDictationCommandListManager)", this.framework, this.framework.getLogChannel("App.SDS.Dictation.CmdListManager"), null, null);
        this.commandListManager.start();
        LogChannel logChannel = this.framework.getLogChannel("App.SDS.Dictation.InternalDispatcher");
        this.internalDispatcher = this.framework.getDispatcherManager().createDispatcher("(SdsDictationInternalDispatcher)", new JobLogger(logChannel));
        this.internalDispatcher.start();
        LogChannel logChannel2 = this.framework.getLogChannel("App.SDS.Dictation.ExternalDispatcher");
        this.externalDispatcher = this.framework.getDispatcherManager().createDispatcher("(SdsDictationExternalDispatcher)", new JobLogger(logChannel2));
        this.externalDispatcher.start();
    }

    public void dispose() {
        super.dispose();
        this.commandListManager.destroy();
        this.internalDispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.internalDispatcher.getDispatcherName());
        this.externalDispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.externalDispatcher.getDispatcherName());
    }

    public CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    public DispatcherBase getInternalTaskDispatcher() {
        return this.internalDispatcher;
    }

    public DispatcherBase getExternalTaskDispatcher() {
        return this.externalDispatcher;
    }
}

