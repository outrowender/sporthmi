/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn;

import de.audi.app.navi.evo.di.AbstractAddressInputWorkFlowManagerEvo;
import de.audi.app.navi.evo.di.cn.AddressInputManagerCN;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputCityScreenWorkFlowManagerCN;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputHouseNumberWorkFlowManagerCN;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputIntersectionScreenWorkFlowManagerCN;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN;
import de.audi.app.navi.evo.di.cn.wfm.AddressInputStreetScreenWorkFlowManagerCN;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputWorkFlowManagerCN
extends AbstractAddressInputWorkFlowManagerEvo {
    protected AddressInputManagerCN addressInputManager;
    private final AddressInputMainScreenWorkFlowManagerCN mainScreenWorkFlowManager;
    private final AddressInputCityScreenWorkFlowManagerCN cityScreenWorkFlowManager;
    private final AddressInputStreetScreenWorkFlowManagerCN streetScreenWorkFlowManager;
    private final AddressInputHouseNumberWorkFlowManagerCN houseNumberScreenWorkFlowManager;
    private final AddressInputIntersectionScreenWorkFlowManagerCN intersectionScreenWorkFlowManager;

    public AddressInputWorkFlowManagerCN(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.mainScreenWorkFlowManager = new AddressInputMainScreenWorkFlowManagerCN(navigationEnv, iCommandListFactory, spellerStack);
        this.cityScreenWorkFlowManager = new AddressInputCityScreenWorkFlowManagerCN(navigationEnv, iCommandListFactory, spellerStack);
        this.streetScreenWorkFlowManager = new AddressInputStreetScreenWorkFlowManagerCN(navigationEnv, iCommandListFactory, spellerStack);
        this.houseNumberScreenWorkFlowManager = new AddressInputHouseNumberWorkFlowManagerCN(navigationEnv, iCommandListFactory, spellerStack);
        this.intersectionScreenWorkFlowManager = new AddressInputIntersectionScreenWorkFlowManagerCN(navigationEnv, iCommandListFactory, spellerStack);
    }

    public CommandList handleWorkFlow(CommandList commandList, int n) {
        commandList.setErrorCommand(null);
        this.logChannel.log(10000000, "%1#handleWorkFlow - eventId=%2", (Object)this.CLASS_NAME, (long)n);
        if (this.isSystemCN(n)) {
            if (this.isCNMainScreen(n)) {
                return this.mainScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isCNCityScreen(n)) {
                return this.cityScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isCNLocationScreen(n)) {
                return commandList;
            }
            if (this.isCNStreetScreen(n)) {
                return this.streetScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isCNHousenumberMatchSpellerScreen(n)) {
                return this.houseNumberScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isCNIntersectionScreen(n)) {
                return this.intersectionScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 is in range of CN system, but no match found.", (Object)this.CLASS_NAME, (long)n);
        } else {
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 isn't in value range of CN system.", (Object)this.CLASS_NAME, (long)n);
        }
        return commandList;
    }

    public void setAddressInputManager(IAddressInputManager iAddressInputManager) {
        if (iAddressInputManager instanceof AddressInputManagerCN) {
            this.addressInputManager = (AddressInputManagerCN)iAddressInputManager;
            this.mainScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.cityScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.streetScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.houseNumberScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.intersectionScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
        }
    }
}

