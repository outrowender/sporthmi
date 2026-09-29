/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.messaging.core.messagingservice.MessagingService;
import de.audi.app.messaging.core.util.Classes;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;

class MessagingService$5
implements ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final LogChannel logChannel;
    private final String handlerName;
    private final /* synthetic */ MessagingService this$0;

    MessagingService$5(MessagingService messagingService) {
        this.this$0 = messagingService;
        this.cmdListManager = MessagingService.access$000(this.this$0).getExecutorManager().getCommandListManager();
        this.logChannel = this.cmdListManager.getLogChannel();
        this.handlerName = Classes.getShortClassName(super.getClass());
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return MessagingService.access$100(this.this$0);
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public String getHandlerName() {
        return this.handlerName;
    }
}

