/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListSupplier;
import de.audi.tghu.navi.app.call.CommandListCallManager$1;
import de.audi.tghu.navi.app.call.CommandListCallManager$QueueData;
import de.audi.tghu.navi.app.call.INavCall;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CommandListCallManager
extends CommandListManager {
    private static final int EXECUTION_TIMEOUT;
    private INavCall call = null;
    private final List callQueue;
    private final Timer executionTimer;
    private final TimerListener executionTimerListener = new CommandListCallManager$1(this);

    public CommandListCallManager(String string, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, ICommandListSupplier iCommandListSupplier, HMIModelApp hMIModelApp) {
        super(string, iFrameworkAccess, logChannel, iCommandListSupplier, hMIModelApp);
        this.callQueue = new LinkedList();
        this.executionTimer = new Timer("executionTimer", 0, true, this.executionTimerListener);
    }

    synchronized INavCall getCall() {
        return this.call;
    }

    public synchronized boolean executeCall(INavCall iNavCall, String string, boolean bl) {
        this.getLogChannel().log(-2137614336, "CommandListCallManager#executeCall()");
        if (this.call == null) {
            this.call = iNavCall;
            iNavCall.setManager(this);
            iNavCall.execute(string);
            this.executionTimer.start();
            return true;
        }
        if (bl) {
            this.getLogChannel().log(-2137614336, "CommandListCallManager#executeCall() - add call to internal queue ( %1 )", (Object)iNavCall);
            this.callQueue.add(new CommandListCallManager$QueueData(this, iNavCall, string));
            return true;
        }
        this.getLogChannel().log(10000, "CommandListCallManager#executeCall() - another call is already registered ( %1 )!", (Object)this.call);
        return false;
    }

    synchronized void removeCall(INavCall iNavCall) {
        this.getLogChannel().log(-2137614336, "CommandListCallManager#removeCall( %1 )", (Object)iNavCall);
        if (this.call != null && this.call.equals(iNavCall)) {
            this.call = null;
            if (this.callQueue.size() > 0) {
                this.getLogChannel().log(-2137614336, "CommandListCallManager#removeCall() - process call from queue");
                CommandListCallManager$QueueData commandListCallManager$QueueData = (CommandListCallManager$QueueData)this.callQueue.remove(0);
                this.executeCall(commandListCallManager$QueueData.call, commandListCallManager$QueueData.invocationSource, false);
            }
        } else {
            this.getLogChannel().log(1078071040, "CommandListCallManager#removeCall() - given call not registered!");
        }
    }

    public synchronized void executeCallDiscardOld(INavCall iNavCall, String string) {
        this.getLogChannel().log(-2137614336, "CommandListCallManager#executeCallDiscardOld() - queue size: %1", (long)this.callQueue.size());
        if (this.callQueue.size() > 0) {
            Iterator iterator = this.callQueue.iterator();
            while (iterator.hasNext()) {
                CommandListCallManager$QueueData commandListCallManager$QueueData = (CommandListCallManager$QueueData)iterator.next();
                if (!super.getClass().equals(super.getClass())) continue;
                this.getLogChannel().log(-2137614336, "CommandListCallManager#executeCallDiscardOld() - remove call from queue ( %1 )", (Object)commandListCallManager$QueueData.call);
                iterator.remove();
            }
        }
        this.executeCall(iNavCall, string, true);
    }

    public final void cleanUp() {
        this.executionTimer.cancel();
    }

    static /* synthetic */ INavCall access$000(CommandListCallManager commandListCallManager) {
        return commandListCallManager.call;
    }
}

