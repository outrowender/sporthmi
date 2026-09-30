/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputPlacenameScreenWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    public AddressInputPlacenameScreenWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 20402: {
                this.createJPPlaceScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJPPlaceScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPPlaceScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
    }
}

