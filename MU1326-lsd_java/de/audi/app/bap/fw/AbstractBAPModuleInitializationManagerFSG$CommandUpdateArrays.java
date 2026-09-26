/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IAcknowledgeTimeoutListener;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.tghu.command.Command;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AbstractBAPModuleInitializationManagerFSG$CommandUpdateArrays
extends Command
implements IAcknowledgeListener,
IAcknowledgeTimeoutListener {
    private final List arraysToBeUpdated;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerFSG this$0;

    public AbstractBAPModuleInitializationManagerFSG$CommandUpdateArrays(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG) {
        this.this$0 = abstractBAPModuleInitializationManagerFSG;
        super(abstractBAPModuleInitializationManagerFSG.logChannel);
        this.arraysToBeUpdated = new ArrayList(10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] send changedArray request for all available arrays (lsgID=%1)", (Object)LSGIDs.getDescription(AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getLSGID()));
        List list = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getFunctionRegistration().getAllArrays();
        if (list.isEmpty()) {
            this.commandList.commandFinished();
            return;
        }
        List list2 = this.arraysToBeUpdated;
        synchronized (list2) {
            this.arraysToBeUpdated.addAll(list);
        }
        int n = 1;
        int n2 = list.size();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            BAPFunctionArrayFSG bAPFunctionArrayFSG = (BAPFunctionArrayFSG)iterator.next();
            if (AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getFunctionList().isFunctionSupported(bAPFunctionArrayFSG.getFctID()) && bAPFunctionArrayFSG.isDataValid()) {
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] update array %1 of %2", (long)n, (long)n2);
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] %1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
                bAPFunctionArrayFSG.addAcknowledgeListener(this);
                bAPFunctionArrayFSG.addAcknowledgeTimeoutListener(this);
                if (!bAPFunctionArrayFSG.sendFullRangeUpdate()) {
                    this.this$0.logChannel.log(-1601830656, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] array %1 not sent; move on", (Object)bAPFunctionArrayFSG.getFctIDDescription());
                    this.arrayUpdated(bAPFunctionArrayFSG);
                }
            } else {
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] ignore array %1 of %2", (long)n, (long)n2);
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] %1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
                this.removeFunction(bAPFunctionArrayFSG);
            }
            ++n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeFunction(BAPFunctionArrayFSG bAPFunctionArrayFSG) {
        boolean bl = false;
        List list = this.arraysToBeUpdated;
        synchronized (list) {
            this.arraysToBeUpdated.remove(bAPFunctionArrayFSG);
            if (this.arraysToBeUpdated.isEmpty()) {
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#removeFunction] all arrays acknowledged");
                bl = true;
            } else {
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#removeFunction] %1 arrays to be acknowledged", (long)this.arraysToBeUpdated.size());
            }
        }
        if (bl) {
            this.commandList.commandFinished();
        }
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        if (n2 == 4) {
            BAPFunctionArrayFSG bAPFunctionArrayFSG = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getBAPFunctionArrayFSG(n);
            this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#processAcknowledge] array update acknowledged (lsgID=%1, fctID=%2)", (Object)bAPFunctionArrayFSG.getLSGIDDescription(), (Object)bAPFunctionArrayFSG.getFctIDDescription());
            this.arrayUpdated(bAPFunctionArrayFSG);
        }
    }

    @Override
    public void processAcknowledgeTimeout(int n) {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#processAcknowledgeTimeout] ");
        BAPFunctionArrayFSG bAPFunctionArrayFSG = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getBAPFunctionArrayFSG(n);
        this.arrayUpdated(bAPFunctionArrayFSG);
    }

    private void arrayUpdated(BAPFunctionArrayFSG bAPFunctionArrayFSG) {
        bAPFunctionArrayFSG.removeAcknowledgeListener(this);
        bAPFunctionArrayFSG.removeAcknowledgeTimeoutListener(this);
        this.removeFunction(bAPFunctionArrayFSG);
    }
}

