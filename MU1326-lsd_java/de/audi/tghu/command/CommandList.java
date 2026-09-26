/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListSupplier;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class CommandList
implements ICommandList {
    public static final int MODE_SYNC;
    public static final int MODE_ASYNC;
    public static final int STATUS_OK;
    public static final int STATUS_STOPPED;
    public static final int STATUS_ABORTED;
    private LogChannel logChannel;
    private List commands;
    private int pos = -1;
    private final int mode;
    private String invocationSource;
    private int status = 0;
    private Command activeCommand = null;
    private Command errorCommand = null;
    private long queuingTime = 0L;
    private Monitor[] monitors = null;
    private Map databag;
    private final CommandListManager manager;

    public CommandList(CommandListManager commandListManager) {
        this(commandListManager, 0);
    }

    public CommandList(CommandListManager commandListManager, int n) {
        this.manager = commandListManager;
        this.logChannel = commandListManager.getLogChannel();
        this.mode = n;
        this.commands = new ArrayList(5);
    }

    @Override
    public final CommandListManager getManager() {
        return this.manager;
    }

    @Override
    public Collection getCommands() {
        return this.commands;
    }

    boolean isSync() {
        return this.mode == 0;
    }

    @Override
    public String getName() {
        return this.invocationSource == null ? "UNKNOWN" : this.invocationSource;
    }

    @Override
    public String getInvocationSource() {
        return this.invocationSource;
    }

    long getQueuingTime() {
        return this.queuingTime;
    }

    void setQueuingTime(long l) {
        this.queuingTime = l;
    }

    @Override
    public ICommandList add(Command command) {
        this.add(this.commands.size(), command);
        return this;
    }

    @Override
    public ICommandList add(int n, Command command) {
        if (command != null) {
            command.setCommandList(this);
            this.commands.add(n, command);
        }
        return this;
    }

    @Override
    public ICommandList add(CommandList commandList) {
        this.add(this.commands.size(), commandList);
        return this;
    }

    @Override
    public ICommandList add(int n, CommandList commandList) {
        if (commandList != null) {
            Iterator iterator = commandList.commands.iterator();
            while (iterator.hasNext()) {
                Command command = (Command)iterator.next();
                command.setCommandList(this);
            }
            int n2 = n;
            Iterator iterator2 = commandList.commands.iterator();
            while (iterator2.hasNext()) {
                this.commands.add(n2++, iterator2.next());
            }
            if (this.databag != null && commandList.databag != null) {
                this.databag.putAll(commandList.databag);
            } else if (commandList.databag != null) {
                this.databag = new Hashtable();
                this.databag.putAll(commandList.databag);
            }
            Monitor[] monitorArray = commandList.getMonitors();
            if (monitorArray != null && monitorArray.length > 0) {
                for (int i2 = 0; i2 < monitorArray.length; ++i2) {
                    this.addMonitor(monitorArray[i2]);
                }
            }
            if (this.errorCommand != null && commandList.getErrorCommand() != null) {
                this.logChannel.log(10000, "CommandList#add() - only one error-handler allowed, skipping new!");
            } else if (commandList.getErrorCommand() != null) {
                this.setErrorCommand(commandList.getErrorCommand());
            }
        }
        return this;
    }

    @Override
    public ICommandList add(Collection collection) {
        this.add(this.getCommands().size(), collection);
        return this;
    }

    @Override
    public ICommandList add(int n, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Command command = (Command)iterator.next();
            command.setCommandList(this);
            this.add(n++, command);
        }
        return this;
    }

    @Override
    public void execute(String string) {
        this.invocationSource = string;
        this.manager.execute(this);
    }

    @Override
    public void commandFinishedWithPostCommand(Command command) {
        if (command != null) {
            this.add(this.pos + 1, command);
            this.logChannel.log(-2137614336, "CommandList#commandFinishedWithPostCommand() - new list: %1 ", (Object)this);
        }
        this.commandFinished();
    }

    @Override
    public void commandFinishedWithPostSequence(CommandList commandList) {
        if (commandList != null && commandList.size() > 0) {
            this.add(this.pos + 1, commandList);
            this.prologueMonitors(commandList.getMonitors());
            this.logChannel.log(-2137614336, "CommandList#commandFinishedWithPostSequence() - new list: %1 ", (Object)this);
        }
        this.commandFinished();
    }

    boolean hasNext() {
        boolean bl = false;
        if (this.status == 0) {
            boolean bl2 = bl = this.pos + 1 < this.commands.size();
            if (bl && this.monitors != null) {
                for (int i2 = 0; i2 < this.monitors.length; ++i2) {
                    bl &= this.monitors[i2].processCommand((Command)this.commands.get(this.pos + 1));
                }
                if (!bl) {
                    this.status = 1;
                }
            }
        }
        return bl;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    @Override
    public int size() {
        return this.commands.size();
    }

    Command next() {
        try {
            this.activeCommand = (Command)this.commands.get(this.pos + 1);
            ++this.pos;
            return this.activeCommand;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasActiveCommand() {
        return this.activeCommand != null;
    }

    @Override
    public Command getActiveCommand() {
        return this.activeCommand;
    }

    @Override
    public Command getErrorCommand() {
        return this.errorCommand;
    }

    @Override
    public void setErrorCommand(Command command) {
        this.errorCommand = command;
        if (command != null) {
            command.setCommandList(this);
        }
    }

    public int getStatus() {
        return this.status;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void commandFinished() {
        CommandList commandList = this;
        synchronized (commandList) {
            this.activeCommand = null;
            super.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stop(String string) {
        this.logChannel.log(-2137614336, "CommandList#stop( %1 ) - active command: %2, commandlist: %3", (Object)string, (Object)this.activeCommand, (Object)this);
        CommandList commandList = this;
        synchronized (commandList) {
            if (this.activeCommand != null) {
                this.activeCommand.abort();
                Command command = this.activeCommand.canceled();
                if (command != null) {
                    this.status = 0;
                    this.commandFinishedWithPostCommand(command);
                    return;
                }
            }
            this.status = 1;
            this.commandFinished();
        }
    }

    @Override
    public void commandAborted(long l) {
        String string = new Buffer().append("ResultCode: ").append(l).toString();
        this.commandAborted(string, "invalid result");
    }

    @Override
    public void commandAborted(Exception exception) {
        ICommandListSupplier iCommandListSupplier = this.manager.getCommandListSupplier();
        if (iCommandListSupplier != null) {
            iCommandListSupplier.handleException(exception);
        } else {
            this.logChannel.log(10000, "%1", (Throwable)exception);
        }
        this.commandAborted(exception.getMessage(), "exception");
    }

    @Override
    public void commandAborted(String string, String string2) {
        Object object;
        this.logChannel.log(10000, "CommandList#commandAborted( %1 ) - active command: %2, commandlist: %3", (Object)string, (Object)this.activeCommand, (Object)this);
        this.logChannel.log(10000, "CommandList#commandAborted() - reason: %1", (Object)string2);
        if (this.activeCommand != null) {
            this.activeCommand.abort();
            object = this.activeCommand.canceled();
            if (object != null) {
                this.status = 0;
                this.commandFinishedWithPostCommand((Command)object);
                return;
            }
        }
        this.status = 2;
        this.commandFinished();
        object = this.manager.getCommandListSupplier();
        if (object != null) {
            String string3 = string2 == null || string2.length() == 0 ? new Buffer().append("Command ").append(this.pos + 1).append('/').append(this.size()).append(" aborted: ").toString() : new Buffer().append("Command ").append(this.pos + 1).append('/').append(this.size()).append(" aborted (").append(string2).append("): ").toString();
            String string4 = string != null ? string : "";
            object.showDebugPopup(this, string3, string4);
        }
    }

    @Override
    public void commandAborted(String string) {
        this.logChannel.log(10000, "CommandList#commandAborted( %1 ) - active command: %2, commandlist: %3", (Object)string, (Object)this.activeCommand, (Object)this);
        this.commandAborted(string, null);
    }

    Monitor[] getMonitors() {
        return this.monitors;
    }

    @Override
    public void addMonitor(Monitor monitor) {
        if (!this.isMonitorRegistered(monitor)) {
            Monitor[] monitorArray = this.monitors;
            int n = monitorArray == null ? 0 : monitorArray.length;
            this.monitors = new Monitor[n + 1];
            for (int i2 = 0; i2 < n; ++i2) {
                this.monitors[i2] = monitorArray[i2];
            }
            this.monitors[n] = monitor;
        }
    }

    private boolean isMonitorRegistered(Monitor monitor) {
        if (this.monitors == null) {
            return false;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < this.monitors.length; ++i2) {
            if (this.monitors[i2] != monitor) continue;
            bl = true;
            break;
        }
        return bl;
    }

    @Override
    public void put(Object object, Object object2) {
        if (this.databag == null) {
            this.databag = new Hashtable();
        }
        this.databag.put(object, object2);
    }

    @Override
    public Object get(Object object) {
        if (this.databag == null) {
            return null;
        }
        return this.databag.get(object);
    }

    @Override
    public Object remove(Object object) {
        if (this.databag == null) {
            return null;
        }
        return this.databag.remove(object);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        if (this.invocationSource != null) {
            buffer.append(this.invocationSource).append(" ");
        }
        if (this.status == 1) {
            buffer.append("STOPPED ");
        } else if (this.status == 2) {
            buffer.append("ABORTED ");
        }
        if (this.mode == 1) {
            buffer.append("MODE_ASYNC ");
        } else {
            buffer.append("MODE_SYNC ");
        }
        ICommandListSupplier iCommandListSupplier = this.manager.getCommandListSupplier();
        buffer.append(iCommandListSupplier != null ? iCommandListSupplier.getApplicationName(this) : "").append(' ');
        buffer.append("@ ").append(this.pos).append('\n');
        int n = this.commands.size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 == this.pos) {
                buffer.append('*');
            }
            buffer.append('\t').append(i2).append(": ").append(((Command)this.commands.get(i2)).getName()).append('\n');
        }
        return buffer.toString();
    }

    private void setMediatorModelStatus(int n) {
        int n2 = this.manager.getMediatorModel().getStatus();
        if (n2 != n) {
            this.manager.getMediatorModel().setStatus(n);
        }
    }

    void prologue() {
        this.logChannel.log(14808325, "CommandList#prologue() - mode: %1 ", (long)this.mode);
        this.setQueuingTime(this.manager.getFramework().getMonotonicTime());
        if (this.manager.getMediatorModel() != null && this.isSync()) {
            this.setMediatorModelStatus(0);
        }
        Monitor[] monitorArray = this.getMonitors();
        this.prologueMonitors(monitorArray);
    }

    void epilogue() {
        Monitor[] monitorArray;
        this.logChannel.log(14808325, "CommandList#epilogue() - mode: %1 ", (long)this.mode);
        if (this.manager.getMediatorModel() != null && this.isSync()) {
            if (!this.manager.isSyncCLenqueued()) {
                this.logChannel.log(14808325, "CommandList#epilogue() - release waitSyncMonitor");
                this.setMediatorModelStatus(1);
            } else {
                this.logChannel.log(14808325, "CommandList#epilogue() - waitSyncMonitor kept close ");
            }
        }
        if ((monitorArray = this.getMonitors()) != null) {
            for (int i2 = 0; i2 < monitorArray.length; ++i2) {
                monitorArray[i2].epilogue(this);
            }
        }
    }

    void prologueMonitors(Monitor[] monitorArray) {
        if (monitorArray != null) {
            for (int i2 = 0; i2 < monitorArray.length; ++i2) {
                monitorArray[i2].prologue(this);
            }
        }
    }
}

