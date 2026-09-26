/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IAcknowledgeTimeoutListener;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.tghu.command.Command;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AbstractBAPModuleInitializationManagerFSG$CommandUpdateProperties
extends Command
implements IAcknowledgeListener,
IAcknowledgeTimeoutListener,
BAPFunctionDataListener {
    private final List propertiesToBeUpdated;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerFSG this$0;

    public AbstractBAPModuleInitializationManagerFSG$CommandUpdateProperties(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG) {
        this.this$0 = abstractBAPModuleInitializationManagerFSG;
        super(abstractBAPModuleInitializationManagerFSG.logChannel);
        this.propertiesToBeUpdated = new ArrayList(10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        this.this$0.setInitState(4);
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#execute] updating all available properties (lsgID=%1)", (Object)LSGIDs.getDescription(AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getLSGID()));
        List list = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getFunctionRegistration().getAllProperties();
        if (list.isEmpty()) {
            this.commandList.commandFinished();
            return;
        }
        List list2 = this.propertiesToBeUpdated;
        synchronized (list2) {
            this.propertiesToBeUpdated.addAll(list);
        }
        int n = 1;
        int n2 = list.size();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = (BAPFunctionPropertyFSG)iterator.next();
            if (AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getFunctionList().isFunctionSupported(bAPFunctionPropertyFSG.getFctID()) && this.isRelevantForUpdateProperties(bAPFunctionPropertyFSG.getFctID()) && !bAPFunctionPropertyFSG.isControlledByFunctionSync()) {
                this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#execute] update property %1 of %2", (long)n, (long)n2);
                bAPFunctionPropertyFSG.addDataListener(this);
                bAPFunctionPropertyFSG.addAcknowledgeListener(this);
                bAPFunctionPropertyFSG.addAcknowledgeTimeoutListener(this);
                if (bAPFunctionPropertyFSG.isLastStatusAckAvailable()) {
                    bAPFunctionPropertyFSG.resendLastStatusAck();
                } else {
                    bAPFunctionPropertyFSG.resendLastStatus();
                }
            } else {
                this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#execute] ignore property %1 of %2", (long)n, (long)n2);
                this.removeProperty(bAPFunctionPropertyFSG);
            }
            ++n;
        }
    }

    private boolean isRelevantForUpdateProperties(int n) {
        if (this.this$0.getHMIState() == 1 && n == AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getFunctionList().getOperationStateBAPFctID()) {
            return false;
        }
        return AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).isRelevantForUpdateProperties(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeProperty(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
        boolean bl = false;
        List list = this.propertiesToBeUpdated;
        synchronized (list) {
            this.propertiesToBeUpdated.remove(bAPFunctionPropertyFSG);
            if (this.propertiesToBeUpdated.isEmpty()) {
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#removeProperty] all properties acknowledged");
                bl = true;
            } else {
                this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#removeProperty] %1 properties to be acknowledged", (long)this.propertiesToBeUpdated.size());
            }
        }
        if (bl) {
            this.commandList.commandFinished();
        }
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        if (n2 == 0 || n2 == 1) {
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getBAPFunctionPropertyFSG(n);
            this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#processAcknowledge] property update acknowledged (lsgID=%1, fctID=%2)", (Object)bAPFunctionPropertyFSG.getFctIDDescription(), (Object)bAPFunctionPropertyFSG.getFctIDDescription());
            this.propertyUpdated(bAPFunctionPropertyFSG);
        }
    }

    private void propertyUpdated(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
        bAPFunctionPropertyFSG.removeDataListener(this);
        bAPFunctionPropertyFSG.removeAcknowledgeListener(this);
        bAPFunctionPropertyFSG.removeAcknowledgeTimeoutListener(this);
        this.removeProperty(bAPFunctionPropertyFSG);
    }

    @Override
    public void processAcknowledgeTimeout(int n) {
        this.this$0.logChannel.log(-1601830656, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#processAcknowledgeTimeout]");
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getBAPFunctionPropertyFSG(n);
        this.propertyUpdated(bAPFunctionPropertyFSG);
    }

    @Override
    public void notifyDataValidChanged(int n, boolean bl) {
    }

    @Override
    public void notifyDataChanged(int n) {
    }

    @Override
    public void notifyDataUpdatedNoChange(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.access$000(this.this$0).getBAPFunctionPropertyFSG(n);
        this.propertyUpdated(bAPFunctionPropertyFSG);
    }
}

