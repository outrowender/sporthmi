/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputWardScreenWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    public AddressInputWardScreenWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 20702: {
                this.createJPWardScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            case 20703: {
                this.createJPWardScreenEnteredWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJPWardScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPWardScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        this.spellerStack.pop();
        this.spellerStack.pop();
        if (AddressInputUtilEvo.isRemoteHMIPOIContext(this.env)) {
            AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
        }
    }

    private void createJPWardScreenEnteredWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPWardScreenEnteredWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(this.inputManager.getWardScreenListener().getStartCommandList());
    }
}

