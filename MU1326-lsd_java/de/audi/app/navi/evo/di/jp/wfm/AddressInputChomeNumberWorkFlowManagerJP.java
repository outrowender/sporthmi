/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.wfm.AbstractAddressInputScreenWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputChomeNumberWorkFlowManagerJP$1;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputChomeNumberWorkFlowManagerJP
extends AbstractAddressInputScreenWorkFlowManagerJP {
    private final ChoiceModelApp housenumberAvailable;

    public AddressInputChomeNumberWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.housenumberAvailable = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpChomeNeedsNumberChoice());
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow with screenEventId = %2", (Object)this.CLASS_NAME, (long)n);
        switch (n) {
            case 20502: {
                this.createJPChomeScreenListElementSelectedWorkFlow(commandList);
                break;
            }
            default: {
                this.logChannel.log(10000, "%1#handleWorkFlow - screenEventId %2 is in range of main screen but not known as valid id.", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createJPChomeScreenListElementSelectedWorkFlow(CommandList commandList) {
        this.logChannel.log(-2137614336, "%1#createJPChomeScreenListElementSelectedWorkFlow", (Object)this.CLASS_NAME);
        commandList.add(new AddressInputChomeNumberWorkFlowManagerJP$1(this));
    }

    static /* synthetic */ ChoiceModelApp access$000(AddressInputChomeNumberWorkFlowManagerJP addressInputChomeNumberWorkFlowManagerJP) {
        return addressInputChomeNumberWorkFlowManagerJP.housenumberAvailable;
    }
}

