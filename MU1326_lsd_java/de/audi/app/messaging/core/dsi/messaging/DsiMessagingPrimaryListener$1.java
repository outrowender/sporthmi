/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Classes;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;

class DsiMessagingPrimaryListener$1
implements ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final LogChannel logChannel;
    private final String handlerName;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$1(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.cmdListManager = DsiMessagingPrimaryListener.access$000(this.this$0).getExecutorManager().getCommandListManager();
        this.logChannel = this.cmdListManager.getLogChannel();
        this.handlerName = Classes.getShortClassName(super.getClass());
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return DsiMessagingPrimaryListener.access$100(this.this$0);
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

