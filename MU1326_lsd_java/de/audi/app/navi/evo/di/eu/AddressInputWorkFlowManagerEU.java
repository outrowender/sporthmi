/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu;

import de.audi.app.navi.evo.di.AbstractAddressInputWorkFlowManagerEvo;
import de.audi.app.navi.evo.di.eu.AddressInputManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputCityZipScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputCountryScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputHousenumberFreetextScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputHousenumberMatchSpellerScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputJunctionScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputMainScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputRefinementScreenWorkFlowManagerEU;
import de.audi.app.navi.evo.di.eu.wfm.AddressInputStreetScreenWorkFlowManagerEU;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputWorkFlowManagerEU
extends AbstractAddressInputWorkFlowManagerEvo {
    protected AddressInputManagerEU addressInputManager;
    private final AddressInputMainScreenWorkFlowManagerEU mainScreenWorkFlowManager;
    private final AddressInputCountryScreenWorkFlowManagerEU countryScreenWorkFlowManager;
    private final AddressInputCityZipScreenWorkFlowManagerEU cityZipScreenWorkFlowManager;
    private final AddressInputStreetScreenWorkFlowManagerEU streetScreenWorkFlowManager;
    private final AddressInputHousenumberFreetextScreenWorkFlowManagerEU housenumberFreetextScreenWorkFlowManager;
    private final AddressInputHousenumberMatchSpellerScreenWorkFlowManagerEU housenumberMatchSpellerScreenWorkFlowManager;
    private final AddressInputJunctionScreenWorkFlowManagerEU junctionScreenWorkFlowManager;
    private final AddressInputRefinementScreenWorkFlowManagerEU refinementScreenWorkFlowManager;

    public AddressInputWorkFlowManagerEU(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.mainScreenWorkFlowManager = new AddressInputMainScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.countryScreenWorkFlowManager = new AddressInputCountryScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.cityZipScreenWorkFlowManager = new AddressInputCityZipScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.streetScreenWorkFlowManager = new AddressInputStreetScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.housenumberFreetextScreenWorkFlowManager = new AddressInputHousenumberFreetextScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.housenumberMatchSpellerScreenWorkFlowManager = new AddressInputHousenumberMatchSpellerScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.junctionScreenWorkFlowManager = new AddressInputJunctionScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
        this.refinementScreenWorkFlowManager = new AddressInputRefinementScreenWorkFlowManagerEU(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        commandList.setErrorCommand(null);
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - eventId=%2", (Object)this.CLASS_NAME, (long)n);
        if (this.isSystemEU(n)) {
            if (this.isEuMainScreen(n)) {
                return this.mainScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuCountryScreen(n)) {
                return this.countryScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuCityZipScreen(n)) {
                return this.cityZipScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuStreetScreen(n)) {
                return this.streetScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuHousenumberFreetextScreen(n)) {
                return this.housenumberFreetextScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuHousenumberMatchSpellerScreen(n)) {
                return this.housenumberMatchSpellerScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuJunctionScreen(n)) {
                return this.junctionScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isEuRefinementScreen(n)) {
                return this.refinementScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 is in range of EU system, but no match found.", (Object)this.CLASS_NAME, (long)n);
        } else {
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 isn't in value range of EU system.", (Object)this.CLASS_NAME, (long)n);
        }
        return commandList;
    }

    @Override
    public void setAddressInputManager(IAddressInputManager iAddressInputManager) {
        if (iAddressInputManager instanceof AddressInputManagerEU) {
            this.addressInputManager = (AddressInputManagerEU)iAddressInputManager;
            this.mainScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.countryScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.cityZipScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.streetScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.housenumberFreetextScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.junctionScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.refinementScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
        }
    }
}

