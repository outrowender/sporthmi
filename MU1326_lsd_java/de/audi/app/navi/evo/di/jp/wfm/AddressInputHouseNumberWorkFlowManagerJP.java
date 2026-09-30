/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class AddressInputHouseNumberWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    private final ChoiceModelApp chomeAvailabelChoiceModel;

    public AddressInputHouseNumberWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.chomeAvailabelChoiceModel = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpNeedsChome());
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleWorkFlow - screenEventId=%2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 20802: {
                this.createJPHouseNumberSelectListElementWorkFlow(commandList);
                break;
            }
            case 20804: {
                this.createJPHouseNumberScreenEnteredWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of refinement screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJPHouseNumberScreenEnteredWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPHouseNumberScreenEnteredWorkFlow", (Object)this.CLASS_NAME);
        SpellerContext spellerContext = this.getSpellerContext(38);
        commandList.add(new LIGetStateCommand(this.spellerStack, spellerContext));
        commandList.add(this.inputManager.gethouseNumberScreenListenerJP().getStartCommandList());
    }

    private void createJPHouseNumberSelectListElementWorkFlow(CommandList commandList) {
        this.logChannel.log(10000000, "%1#createJPHouseNumberSelectListElementWorkFlow", (Object)this.CLASS_NAME);
        if (AddressInputUtilEvo.isOnlineOrNormalPOIContext(this.env)) {
            AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
        }
        if (this.chomeAvailabelChoiceModel.getValue() == 1) {
            this.spellerStack.pop();
            this.spellerStack.pop();
        } else {
            this.spellerStack.pop();
        }
    }
}

