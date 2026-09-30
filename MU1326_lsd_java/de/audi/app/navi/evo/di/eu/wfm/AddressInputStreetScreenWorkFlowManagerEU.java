/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.wfm;

import de.audi.app.navi.evo.di.eu.wfm.AbstractAddressInputScreenWorkFlowManagerEU;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputStreetScreenWorkFlowManagerEU
extends AbstractAddressInputScreenWorkFlowManagerEU {
    public AddressInputStreetScreenWorkFlowManagerEU(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 302: {
                this.createEuStreetScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 304: {
                this.createEuStreetScreenAmbiguousListElementSelectedWorkFlow(commandList);
                break;
            }
            case 303: {
                this.createDiEuStreetScreenNonambiguousListElementSelectedWorkFlow();
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of street screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createDiEuStreetScreenNonambiguousListElementSelectedWorkFlow() {
        this.logChannel.log(10000000, "%1#createDiEuStreetScreenNonambiguousListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
        this.spellerStack.pop();
    }

    private void createEuStreetScreenListElementSelectedWorkFlow(CommandList commandList) {
        commandList.add(0, new LIGetStateCommand(this.spellerStack, new SpellerContext(56)));
        this.logChannel.log(10000000, "%1#createEuStreetScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
    }

    private void createEuStreetScreenAmbiguousListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createEuStreetScreenAmbiguousListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(this.inputManager.getRefinementScreenListener().getStartCommandList());
    }
}

