/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.app.sdsmanager.commands.CommandRecognition;
import de.audi.app.sdsmanager.commands.CommandSetGrammarContext;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SDSCommandListFilter
extends BaseJobFilter {
    private static final String LOGCLASS = "SDSCommandListFilter";
    private final List commandListQueue;
    private LogChannel lc = Logger.getCommandLog();

    public SDSCommandListFilter(List list) {
        this.commandListQueue = list;
    }

    public void enqueue(Object object, int n) {
        this.lc.log(1000000, "[%1.enqueue] %2", (Object)LOGCLASS, (Object)((CommandList)object).getName());
        boolean bl = false;
        boolean bl2 = false;
        CommandList commandList = (CommandList)object;
        Collection collection = commandList.getCommands();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext() && !bl && !bl2) {
            Object object2 = iterator.next();
            if (object2 instanceof CommandSetGrammarContext) {
                bl = true;
                continue;
            }
            if (!(object2 instanceof CommandRecognition)) continue;
            bl2 = true;
        }
        if (bl || bl2) {
            int n2 = this.commandListQueue.size();
            this.lc.log(1000000, "[%1.enqueue] commandListQueueLength=%2, checking if queued job is available!", (Object)LOGCLASS, (long)n2);
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                CommandList commandList2 = (CommandList)this.commandListQueue.get(i2);
                String string = commandList2.getName();
                this.lc.log(1000000, "[%1.enqueue] Checking command list %2 (#%3)!", (Object)LOGCLASS, (Object)string, (long)i2);
                iterator = commandList2.getCommands().iterator();
                if (iterator.hasNext()) {
                    boolean bl3;
                    boolean bl4;
                    this.lc.log(1000000, "[%1.enqueue] Checking first command of command list %2 (#%3)!", (Object)LOGCLASS, (Object)string, (long)i2);
                    Command command = (Command)iterator.next();
                    boolean bl5 = bl4 = command instanceof CommandRecognition && bl;
                    if (bl4) {
                        this.lc.log(1000000, "[%1.enqueue] Stopping filter because of recognition job at queue position %2!", (Object)LOGCLASS, (long)i2);
                        break;
                    }
                    boolean bl6 = bl3 = command instanceof CommandSetGrammarContext && bl || command instanceof CommandRecognition && bl2;
                    if (bl3) {
                        this.lc.log(1000000, "[%1.enqueue] Removing command list %2 (#%3)!", (Object)LOGCLASS, (Object)string, (long)i2);
                        this.commandListQueue.remove(i2);
                        continue;
                    }
                    this.lc.log(100000, "[%1.enqueue] Keeping command list %2 (#%3)!", (Object)LOGCLASS, (Object)string, (long)i2);
                    continue;
                }
                this.lc.log(100000, "[%1.enqueue] command list %2 (#%3) is empty!", (Object)LOGCLASS, (Object)string, (long)i2);
            }
        }
        super.enqueue((Job)object, n);
    }
}

