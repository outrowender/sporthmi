/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AbstractAddressInputScreenWorkFlowManagerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputTownStreetScreenWorkFlowManagerKR
extends AbstractAddressInputScreenWorkFlowManagerKR {
    public AddressInputTownStreetScreenWorkFlowManagerKR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 40502: {
                this.createKRTownStreetScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of street screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createKRTownStreetScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createKRTownStreetScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        int n = this.inputManager.getActiveSpellerContextId();
        if (n == 97) {
            commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
        } else if (n == 98) {
            commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(this.commandListFactory).getStartCommandList());
        }
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
    }
}

