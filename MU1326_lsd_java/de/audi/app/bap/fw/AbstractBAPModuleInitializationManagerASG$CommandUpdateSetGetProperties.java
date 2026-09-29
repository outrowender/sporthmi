/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties$1;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusListener;
import de.audi.app.bap.utils.CollectionUtils;
import de.audi.tghu.command.Command;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.List;

final class AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties
extends Command
implements IBAPFunctionStatusListener {
    private final List allProperties;
    private final List propertiesToSend;
    private int updatedPropertiesCount;
    private int totalPropertiesToUpdateCount;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG this$0;

    public AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        this.this$0 = abstractBAPModuleInitializationManagerASG;
        super(abstractBAPModuleInitializationManagerASG.logChannel);
        this.propertiesToSend = new ArrayList(5);
        this.allProperties = AbstractBAPModuleInitializationManagerASG.access$000(abstractBAPModuleInitializationManagerASG).getFunctionRegistration().getAllProperties();
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateSetGetProperties#execute] updating properties (lsgID=%1", (Object)AbstractBAPModuleInitializationManagerASG.access$000(this.this$0).getLSGDescription());
        CollectionUtils.filterFromIteratorIntoCollection(this.allProperties.iterator(), this.propertiesToSend, new AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties$1(this));
        this.updatedPropertiesCount = 0;
        this.totalPropertiesToUpdateCount = this.propertiesToSend.size();
        this.updateNextProperty();
    }

    private void updateNextProperty() {
        if (this.propertiesToSend.isEmpty()) {
            this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateSetGetProperties#updateNextProperty] all properties updated");
            this.commandList.commandFinished();
        } else {
            ++this.updatedPropertiesCount;
            this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateSetGetProperties#updateNextProperty] update property %1 of %2", (long)this.updatedPropertiesCount, (long)this.totalPropertiesToUpdateCount);
            BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)this.propertiesToSend.get(0);
            bAPFunctionPropertyASG.addStatusListener(this);
            bAPFunctionPropertyASG.setGetREQ();
        }
    }

    private boolean hasSetGet(BAPFunctionPropertyASG bAPFunctionPropertyASG) {
        return bAPFunctionPropertyASG.getSetGetSerializer() != null;
    }

    @Override
    public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
        BAPFunctionPropertyASG bAPFunctionPropertyASG = AbstractBAPModuleInitializationManagerASG.access$000(this.this$0).getBAPFunctionPropertyASG(n);
        bAPFunctionPropertyASG.removeStatusListener(this);
        this.propertiesToSend.remove(bAPFunctionPropertyASG);
        this.updateNextProperty();
    }

    static /* synthetic */ AbstractBAPModuleInitializationManagerASG access$200(AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties abstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties) {
        return abstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties.this$0;
    }

    static /* synthetic */ boolean access$300(AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties abstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties, BAPFunctionPropertyASG bAPFunctionPropertyASG) {
        return abstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties.hasSetGet(bAPFunctionPropertyASG);
    }
}

