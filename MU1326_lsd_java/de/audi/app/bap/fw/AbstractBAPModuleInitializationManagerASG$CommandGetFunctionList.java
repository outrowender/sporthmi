/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.AbstractFunctionListASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusListener;
import de.audi.tghu.command.Command;
import de.vw.mib.bap.requests.StatusProperty;

final class AbstractBAPModuleInitializationManagerASG$CommandGetFunctionList
extends Command
implements IBAPFunctionStatusListener {
    private final BAPFunctionPropertyASG functionListProperty;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG this$0;

    public AbstractBAPModuleInitializationManagerASG$CommandGetFunctionList(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        this.this$0 = abstractBAPModuleInitializationManagerASG;
        super(abstractBAPModuleInitializationManagerASG.logChannel);
        this.functionListProperty = AbstractBAPModuleInitializationManagerASG.access$000(abstractBAPModuleInitializationManagerASG).getBAPFunctionPropertyASG(AbstractBAPModuleInitializationManagerASG.access$000(abstractBAPModuleInitializationManagerASG).getFunctionList().getFctListBAPFctID());
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandGetFunctionList#execute] send FunctionList.Get request");
        this.this$0.setInitState(7);
        if (this.functionListProperty != null) {
            this.functionListProperty.addStatusListener(this);
            this.functionListProperty.getREQ();
        } else {
            this.this$0.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG.CommandGetFunctionList#execute] FunctionList function not found");
        }
    }

    @Override
    public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandGetFunctionList#notifyStatusIndicationReceived] received function list for lsgID=%1", (Object)AbstractBAPModuleInitializationManagerASG.access$000(this.this$0).getLSGDescription());
        this.functionListProperty.removeStatusListener(this);
        ((AbstractFunctionListASG)AbstractBAPModuleInitializationManagerASG.access$000(this.this$0).getFunctionList()).setFunctionListConfiguration(statusProperty);
        this.commandList.commandFinished();
    }
}

