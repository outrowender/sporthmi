/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties$1;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusListener;
import de.audi.app.bap.utils.CollectionUtils;
import de.audi.tghu.command.Command;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.List;

final class AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties
extends Command
implements IBAPFunctionStatusListener {
    private final List allProperties;
    private final List functionsToBeUpdated;
    private int updatedPropertiesCount;
    private int totalPropertiesToUpdateCount;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG this$0;

    public AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        this.this$0 = abstractBAPModuleInitializationManagerASG;
        super(abstractBAPModuleInitializationManagerASG.logChannel);
        this.functionsToBeUpdated = new ArrayList(10);
        this.allProperties = AbstractBAPModuleInitializationManagerASG.access$000(abstractBAPModuleInitializationManagerASG).getFunctionRegistration().getAllProperties();
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateProperties#execute] updating properties (lsgID=%1", (Object)AbstractBAPModuleInitializationManagerASG.access$000(this.this$0).getLSGDescription());
        this.this$0.setInitState(8);
        CollectionUtils.filterFromIteratorIntoCollection(this.allProperties.iterator(), this.functionsToBeUpdated, new AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties$1(this));
        this.updatedPropertiesCount = 0;
        this.totalPropertiesToUpdateCount = this.functionsToBeUpdated.size();
        this.updateNextProperty();
    }

    private void updateNextProperty() {
        if (this.functionsToBeUpdated.isEmpty()) {
            this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateProperties#updateNextProperty] all properties updated");
            this.commandList.commandFinished();
        } else {
            ++this.updatedPropertiesCount;
            this.this$0.logChannel.log(14808325, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateProperties#updateNextProperty] update property %1 of %2", (long)this.updatedPropertiesCount, (long)this.totalPropertiesToUpdateCount);
            BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)this.functionsToBeUpdated.get(0);
            bAPFunctionPropertyASG.addStatusListener(this);
            bAPFunctionPropertyASG.getREQ();
        }
    }

    @Override
    public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
        BAPFunctionPropertyASG bAPFunctionPropertyASG = AbstractBAPModuleInitializationManagerASG.access$000(this.this$0).getBAPFunctionPropertyASG(n);
        bAPFunctionPropertyASG.removeStatusListener(this);
        this.functionsToBeUpdated.remove(bAPFunctionPropertyASG);
        this.updateNextProperty();
    }

    static /* synthetic */ AbstractBAPModuleInitializationManagerASG access$100(AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties abstractBAPModuleInitializationManagerASG$CommandUpdateProperties) {
        return abstractBAPModuleInitializationManagerASG$CommandUpdateProperties.this$0;
    }
}

