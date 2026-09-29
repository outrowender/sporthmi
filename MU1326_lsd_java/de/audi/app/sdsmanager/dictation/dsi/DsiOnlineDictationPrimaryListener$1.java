/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;

class DsiOnlineDictationPrimaryListener$1
implements ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final LogChannel logChannel;
    private final String handlerName;
    private final /* synthetic */ DsiOnlineDictationPrimaryListener this$0;

    DsiOnlineDictationPrimaryListener$1(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener) {
        this.this$0 = dsiOnlineDictationPrimaryListener;
        this.cmdListManager = DsiOnlineDictationPrimaryListener.access$000(this.this$0).getDispatcherManager().getCommandListManager();
        this.logChannel = this.cmdListManager.getLogChannel();
        this.handlerName = DictationUtil.getShortClassName(super.getClass());
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return DsiOnlineDictationPrimaryListener.access$100(this.this$0);
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

