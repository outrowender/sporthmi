/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp;

import de.audi.app.navi.evo.di.AbstractAddressInputWorkFlowManagerEvo;
import de.audi.app.navi.evo.di.jp.AddressInputManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputChomeNumberWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputCityScreenWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputHouseNumberWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputMainScreenWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputPlacenameScreenWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputPrefectureScreenWorkFlowManagerJP;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputWardScreenWorkFlowManagerJP;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputWorkFlowManagerJP
extends AbstractAddressInputWorkFlowManagerEvo {
    protected AddressInputManagerJP addressInputManager;
    private final AddressInputMainScreenWorkFlowManagerJP mainScreenWorkFlowManager;
    private final AddressInputPrefectureScreenWorkFlowManagerJP perfectureScreenWorkFlowManager;
    private final AddressInputCityScreenWorkFlowManagerJP cityScreenWorkFlowManager;
    private final AddressInputWardScreenWorkFlowManagerJP wardScreenWorkFlowManager;
    private final AddressInputPlacenameScreenWorkFlowManagerJP placenameScreenWorkFlowManager;
    private final AddressInputChomeNumberWorkFlowManagerJP chomeScreenWorkFlowManager;
    private final AddressInputHouseNumberWorkFlowManagerJP houseNumberScreenWorkFlowManager;

    public AddressInputWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.mainScreenWorkFlowManager = new AddressInputMainScreenWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
        this.perfectureScreenWorkFlowManager = new AddressInputPrefectureScreenWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
        this.cityScreenWorkFlowManager = new AddressInputCityScreenWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
        this.wardScreenWorkFlowManager = new AddressInputWardScreenWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
        this.placenameScreenWorkFlowManager = new AddressInputPlacenameScreenWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
        this.chomeScreenWorkFlowManager = new AddressInputChomeNumberWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
        this.houseNumberScreenWorkFlowManager = new AddressInputHouseNumberWorkFlowManagerJP(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        commandList.setErrorCommand(null);
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - eventId=%2", (Object)this.CLASS_NAME, (long)n);
        if (this.isSystemJP(n)) {
            if (this.isJPMainScreen(n)) {
                return this.mainScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isJPPrefectureScreen(n)) {
                return this.perfectureScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isJPCityScreen(n)) {
                return this.cityScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isJPWardScreen(n)) {
                return this.wardScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isJPFacilityScreen(n)) {
                return commandList;
            }
            if (this.isJPPlaceScreen(n)) {
                return this.placenameScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isJPChomeScreen(n)) {
                return this.chomeScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isJPHouseNumberScreen(n)) {
                return this.houseNumberScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 is in range of JP system, but no match found.", (Object)this.CLASS_NAME, (long)n);
        } else {
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 isn't in value range of JP system.", (Object)this.CLASS_NAME, (long)n);
        }
        return commandList;
    }

    @Override
    public void setAddressInputManager(IAddressInputManager iAddressInputManager) {
        if (iAddressInputManager instanceof AddressInputManagerJP) {
            this.addressInputManager = (AddressInputManagerJP)iAddressInputManager;
            this.mainScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.perfectureScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.cityScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.wardScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.placenameScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.chomeScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.houseNumberScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
        } else {
            this.logChannel.log(10000, "%1#setAddressInputManager - received invalid instance.", (Object)this.CLASS_NAME);
        }
    }
}

