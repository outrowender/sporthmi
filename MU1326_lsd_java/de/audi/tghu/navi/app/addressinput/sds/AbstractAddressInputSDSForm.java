/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.ReplySDSTriggerAddressInputReturnCommand;
import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm$1;
import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm$2;
import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm$3;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.addressinput.sds.IAddressInputSDSForm;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.sds.SDSNaviPicklistRowCreator;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAddressInputSDSForm
implements IAddressInputSDSForm {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final IAddressInputForm addressInputService;
    protected final LogChannel logChannel;
    protected final INavigationInputModeManager inputModeManager;
    protected final ICommandListFactory commandListFactory;
    protected final NavigationEnv env;
    protected final SpellerStack spellerStack;
    protected final IPreviewMap previewMap;
    protected final IAddressInputFormModelAccessHelper modelAccessHelper;
    protected final AddressInputSDSSequence addressInputSDSSequence;

    public AbstractAddressInputSDSForm(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, AddressInputSDSSequence addressInputSDSSequence) {
        this.addressInputService = iAddressInputForm;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
        this.addressInputSDSSequence = addressInputSDSSequence;
    }

    @Override
    public void triggerAddressInputReturn(int n, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#triggerAddressInputReturn() - returnCode = %2", (Object)this.CLASS_NAME, (long)n);
        if (null == naviServiceListener) {
            this.logChannel.log(10000, "%1#triggerAddressInputReturn() - naviServiceListener is null can't continue and cant reply to SDS", (Object)this.CLASS_NAME);
            return;
        }
        ReplySDSTriggerAddressInputReturnCommand replySDSTriggerAddressInputReturnCommand = new ReplySDSTriggerAddressInputReturnCommand(naviServiceListener, 1);
        ReplySDSTriggerAddressInputReturnCommand replySDSTriggerAddressInputReturnCommand2 = new ReplySDSTriggerAddressInputReturnCommand(naviServiceListener, 0);
        this.addressInputService.destAddressInputHKReturn(0, n, replySDSTriggerAddressInputReturnCommand2, replySDSTriggerAddressInputReturnCommand);
    }

    @Override
    public void triggerAddressInputReturn(int n, int n2, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "%1#triggerAddressInputReturn() - returnCode = %2", (Object)this.CLASS_NAME, (long)n);
        if (null == naviServiceListener) {
            this.logChannel.log(10000, "%1#triggerAddressInputReturn() - naviServiceListener is null can't continue and cant reply to SDS", (Object)this.CLASS_NAME);
            return;
        }
        ReplySDSTriggerAddressInputReturnCommand replySDSTriggerAddressInputReturnCommand = new ReplySDSTriggerAddressInputReturnCommand(naviServiceListener, 1);
        AbstractAddressInputSDSForm$1 abstractAddressInputSDSForm$1 = new AbstractAddressInputSDSForm$1(this, "Adjust Cursorp\u00fcosition and add replay for SDS", n2, naviServiceListener);
        this.addressInputService.destAddressInputHKReturn(0, n, abstractAddressInputSDSForm$1, replySDSTriggerAddressInputReturnCommand);
    }

    protected void updateMapCodeSDSDisambiguatedPickList(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(3869);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < disambiguatedNavLocationArray.length; ++i2) {
            DisambiguatedNavLocation disambiguatedNavLocation = disambiguatedNavLocationArray[i2];
            baseListModelApp2.append(SDSNaviPicklistRowCreator.createPickListRowByIndexAndNameForMapCode(i2, disambiguatedNavLocation.getLocation().street, disambiguatedNavLocation.getType()));
        }
        baseListModelApp.update(baseListModelApp2);
        this.logChannel.log(-2137614336, "%1#updateSDSPickList - Pick List Length is %2", (Object)this.CLASS_NAME, (long)baseListModelApp.getLength());
    }

    @Override
    public void synchronizeSpeechCountryWithCurrentLD(NaviServiceListener naviServiceListener) {
        boolean bl = this.speechCountryNeedsSync();
        if (bl) {
            this.logChannel.log(1078071040, "%1#synchronizeSpeechCountryWithCurrentLD() - a sync is necessary, set currentLD on Southside", (Object)this.CLASS_NAME);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), SpellerContextManager.getSpellerContext(116)));
            commandList.add(new LISetCurrentLDCommand(this.getSynchronisationLocation()));
            commandList.add(new AbstractAddressInputSDSForm$2(this, "AbstractAddressInputSDSForm#synchronizeSpeechCountryWithCurrentLD() Set correct Country for City History "));
            commandList.add(new AbstractAddressInputSDSForm$3(this, "AbstractAddressInputSDSForm#synchronizeSpeechCountryWithCurrentLD() - reply to SDS", naviServiceListener));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#synchronizeSpeechCountryWithCurrentLD").toString());
        } else {
            this.logChannel.log(1078071040, "%1#synchronizeSpeechCountryWithCurrentLD() - no sync is necessary", (Object)this.CLASS_NAME);
            naviServiceListener.responseSynchronizeSpeechCountryWithCurrentLDResult((byte)0, false);
        }
    }

    protected NavLocation getSynchronisationLocation() {
        return Vehicle.getInstance().getVehicleLocationDescription();
    }

    protected boolean speechCountryNeedsSync() {
        return this.env.getContainer().getLiCurrentLD() == null ? true : Util.isEmpty(this.env.getContainer().getLiCurrentLD().countryAbbreviation);
    }
}

