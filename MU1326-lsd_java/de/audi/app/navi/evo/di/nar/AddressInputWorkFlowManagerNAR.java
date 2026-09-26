/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar;

import de.audi.app.navi.evo.di.AbstractAddressInputWorkFlowManagerEvo;
import de.audi.app.navi.evo.di.nar.AddressInputManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputCountryScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputHousenumberScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputIntersectionScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetRefinementScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetScreenWorkFlowManagerNAR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputWorkFlowManagerNAR
extends AbstractAddressInputWorkFlowManagerEvo {
    protected AddressInputManagerNAR addressInputManager;
    private final AddressInputMainScreenWorkFlowManagerNAR mainScreenWorkFlowManager;
    private final AddressInputCountryScreenWorkFlowManagerNAR countryScreenWorkFlowManager;
    private final AddressInputCityZipScreenWorkFlowManagerNAR cityZipScreenWorkFlowManager;
    private final AddressInputStreetScreenWorkFlowManagerNAR streetScreenWorkFlowManager;
    private final AddressInputHousenumberScreenWorkFlowManagerNAR housenumberScreenWorkFlowManager;
    private final AddressInputStreetRefinementScreenWorkFlowManagerNAR streetRefinementScreenWorkFlowManager;
    private final AddressInputIntersectionScreenWorkFlowManagerNAR intersectionScreenWorkFlowManager;

    public AddressInputWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.mainScreenWorkFlowManager = new AddressInputMainScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack);
        this.countryScreenWorkFlowManager = new AddressInputCountryScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack);
        this.cityZipScreenWorkFlowManager = new AddressInputCityZipScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack, cityHistory);
        this.streetScreenWorkFlowManager = new AddressInputStreetScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack);
        this.housenumberScreenWorkFlowManager = new AddressInputHousenumberScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack);
        this.streetRefinementScreenWorkFlowManager = new AddressInputStreetRefinementScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack, cityHistory);
        this.intersectionScreenWorkFlowManager = new AddressInputIntersectionScreenWorkFlowManagerNAR(navigationEnv, iCommandListFactory, spellerStack);
    }

    @Override
    public CommandList handleWorkFlow(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleWorkFlow - eventId=%2", (Object)this.CLASS_NAME, (long)n);
        if (this.isSystemNAR(n)) {
            if (this.isNARMainScreen(n)) {
                return this.mainScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isNARCountryScreen(n)) {
                return this.countryScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isNARCityScreen(n)) {
                return this.cityZipScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isNARStreetScreen(n)) {
                return this.streetScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isNARHousenumberScreen(n)) {
                return this.housenumberScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isNARStreetRefinementScreen(n)) {
                return this.streetRefinementScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            if (this.isNARIntersectionScreen(n)) {
                return this.intersectionScreenWorkFlowManager.handleWorkFlow(commandList, n);
            }
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 is in range of NAR system, but no match found.", (Object)this.CLASS_NAME, (long)n);
        } else {
            this.logChannel.log(10000, "%1#handleWorkFlow - received invalid screenEventId. ID=%2 isn't in value range of NAR system.", (Object)this.CLASS_NAME, (long)n);
        }
        return commandList;
    }

    @Override
    public void setAddressInputManager(IAddressInputManager iAddressInputManager) {
        if (iAddressInputManager instanceof AddressInputManagerNAR) {
            this.addressInputManager = (AddressInputManagerNAR)iAddressInputManager;
            this.mainScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.countryScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.cityZipScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.streetScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.housenumberScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.streetRefinementScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
            this.intersectionScreenWorkFlowManager.setAddressInputManager(this.addressInputManager);
        }
    }
}

