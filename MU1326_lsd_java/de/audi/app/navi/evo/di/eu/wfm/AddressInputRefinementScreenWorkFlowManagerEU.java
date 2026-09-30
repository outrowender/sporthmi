/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.wfm;

import de.audi.app.navi.evo.di.eu.wfm.AbstractAddressInputScreenWorkFlowManagerEU;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputRefinementScreenWorkFlowManagerEU
extends AbstractAddressInputScreenWorkFlowManagerEU {
    public AddressInputRefinementScreenWorkFlowManagerEU(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 702: {
                this.createEuRefinementScreenSelectListElementWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId %2 is in range of refinement screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createEuRefinementScreenSelectListElementWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createEuRefinementScreenSelectListElementWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
        this.spellerStack.pop();
    }
}

