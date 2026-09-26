/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IErrorIndicationListener;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.tghu.command.Command;

final class AbstractBAPModuleInitializationManagerFSG$CommandUpdateFunctionList
extends Command
implements IAcknowledgeListener,
IErrorIndicationListener {
    private final BAPFunctionPropertyFSG functionListProperty;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerFSG this$0;

    public AbstractBAPModuleInitializationManagerFSG$CommandUpdateFunctionList(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG) {
        this.this$0 = abstractBAPModuleInitializationManagerFSG;
        super(abstractBAPModuleInitializationManagerFSG.logChannel);
        this.functionListProperty = AbstractBAPModuleInitializationManagerFSG.access$000(abstractBAPModuleInitializationManagerFSG).getBAPFunctionPropertyFSG(AbstractBAPModuleInitializationManagerFSG.access$000(abstractBAPModuleInitializationManagerFSG).getFunctionList().getFctListBAPFctID());
    }

    @Override
    public void execute() {
        this.this$0.setInitState(3);
        this.functionListProperty.addAcknowledgeListener(this);
        this.functionListProperty.addErrorIndicationListener(this);
        this.sendFunctionList();
    }

    private void sendFunctionList() {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateFunctionList#sendUpdate] updating function list for lsgID=%1", (Object)LSGIDs.getDescription(AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getLSGID()));
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getBAPFunctionPropertyFSG(AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getFunctionList().getFctListBAPFctID());
        bAPFunctionPropertyFSG.resendLastStatus();
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        if (n2 == 0) {
            this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateFunctionList#processAcknowledge] called (lsgID=%1)", (Object)this.this$0.lsgIDDescription);
            this.functionListProperty.removeAcknowledgeListener(this);
            this.commandList.commandFinished();
        }
    }

    @Override
    public void processIndicationError(int n, int n2) {
        if (n2 == 66) {
            this.functionListProperty.removeErrorIndicationListener(this);
            AbstractBAPModuleInitializationManagerFSG.access$100(this.this$0, this);
        }
    }
}

