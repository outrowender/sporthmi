/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListInterceptor;
import de.audi.tghu.command.CommandListJobQueue;
import de.audi.tghu.command.CommandListNull;
import de.audi.tghu.command.ICommandListSupplier;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;

public class CommandListManager {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final ICommandListSupplier supplier;
    private final DispatcherBase dispatcher;
    private final CommandListJobQueue queue;
    private HMIModelApp mediatorModel;
    private volatile CommandList active = null;
    private int nrSyncCLEnqueued = 0;
    private IJobFilter dsiAvailableFilter = null;
    private volatile boolean destroyed = false;
    private final Object incrementSyncCoutnerMutex = new Object();

    public CommandListManager(String string, IFrameworkAccess iFrameworkAccess, final LogChannel logChannel, final ICommandListSupplier iCommandListSupplier, HMIModelApp hMIModelApp) {
        this.framework = iFrameworkAccess;
        this.log = logChannel;
        this.supplier = iCommandListSupplier;
        this.mediatorModel = hMIModelApp;
        this.queue = new CommandListJobQueue(logChannel, this);
        this.queue.addFilter(new BaseJobFilter(){

            public void enqueue(Job job, int n) {
                CommandList commandList = (CommandList)job.getPayload();
                logChannel.log(10000000, "CommandListQueue#enqueue( %1 ) ", (Object)commandList.getName());
                commandList.prologue();
                CommandListManager.this.countSyncCLenqueued(commandList, 1);
                super.enqueue(job, n);
            }
        });
        if (iCommandListSupplier != null) {
            this.dsiAvailableFilter = new BaseJobFilter(){

                public void enqueue(Job job, int n) {
                    CommandList commandList = (CommandList)job.getPayload();
                    if (!iCommandListSupplier.isDSIsAvailable(commandList)) {
                        logChannel.log(100000, "CommandListQueue#enqueue() - commandlist dropped. DSI for %1 not ready!", (Object)iCommandListSupplier.getApplicationName(commandList));
                    } else {
                        super.enqueue(job, n);
                    }
                }
            };
            this.queue.addFilter(this.dsiAvailableFilter);
        }
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher(string, new JobLogger(logChannel), this.queue, new CommandListInterceptor(logChannel, iCommandListSupplier), new Job(new CommandListNull(this)));
        this.dispatcher.addInterceptor(new BaseInterceptor(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void execute(Job job) {
                CommandList commandList = (CommandList)job.getPayload();
                CommandListManager.this.countSyncCLenqueued(commandList, -1);
                CommandListManager.this.setActiveCommandList(commandList);
                try {
                    super.execute(job);
                }
                finally {
                    commandList.epilogue();
                    CommandListManager.this.setActiveCommandList(null);
                }
            }
        });
    }

    public final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public final LogChannel getLogChannel() {
        return this.log;
    }

    public final ICommandListSupplier getCommandListSupplier() {
        return this.supplier;
    }

    public final void setMediatorModel(HMIModelApp hMIModelApp) {
        this.mediatorModel = hMIModelApp;
    }

    public final HMIModelApp getMediatorModel() {
        return this.mediatorModel;
    }

    public final CommandListJobQueue getQueue() {
        return this.queue;
    }

    public CommandList getActiveCommandList() {
        return this.destroyed ? null : this.active;
    }

    private final void setActiveCommandList(CommandList commandList) {
        this.active = commandList;
    }

    public final void start() {
        this.dispatcher.start();
    }

    public final void setPriority(int n) {
        this.dispatcher.setPriority(n);
    }

    public final void destroy() {
        this.getLogChannel().log(10000000, "CommandListManager#destroy()");
        this.destroyed = true;
        this.queue.abortQueuedExecution("CommandListManager#destroy() called", "", null, false);
        if (this.active != null) {
            this.active.stop("CommandListManager#destroy() called");
        }
        if (this.dsiAvailableFilter != null) {
            this.queue.removeFilter(this.dsiAvailableFilter);
        }
        this.dispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.dispatcher.getDispatcherName());
    }

    public final void execute(CommandList commandList) {
        if (this.destroyed) {
            this.getLogChannel().log(10000000, "CommandListManager#execute(%1): discard it, CmdListManager is already destroyed!", (Object)commandList);
            commandList.stop("CmdListManager is destroyed!");
        } else {
            this.dispatcher.execute(commandList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void countSyncCLenqueued(CommandList commandList, int n) {
        Object object = this.incrementSyncCoutnerMutex;
        synchronized (object) {
            if (commandList.isSync()) {
                this.nrSyncCLEnqueued += n;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isSyncCLenqueued() {
        Object object = this.incrementSyncCoutnerMutex;
        synchronized (object) {
            return this.nrSyncCLEnqueued > 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abortExecution(String string, Object object, boolean bl) {
        String string2 = this.supplier != null ? this.supplier.getApplicationName(null) : "UNKNOWN";
        this.getLogChannel().log(10000000, "CommandListManager#abortExecution( %1, %2 )", (Object)string, (Object)string2);
        this.getQueue().abortQueuedExecution(string, string2, object, bl);
        CommandList commandList = this.getActiveCommandList();
        if (commandList != null) {
            CommandList commandList2 = commandList;
            synchronized (commandList2) {
                this.stopCommandList(commandList, string, object, bl);
            }
        }
    }

    void stopCommandList(CommandList commandList, String string, Object object, boolean bl) {
        boolean bl2 = true;
        if (object != null) {
            Object object2 = commandList.get(object);
            boolean bl3 = bl2 = !bl && object2 != null || bl && object2 == null;
        }
        if (bl2) {
            this.getLogChannel().log(10000000, "CommandListManager#stopCommandList() - aborting list: %1", (Object)commandList);
            commandList.stop(string);
        }
    }
}

