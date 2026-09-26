/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.AddressInputFormModelAccessHelperEU;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorEvo;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$1;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$2;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambMatchSpellerListener;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambMatchSpellerListenerAsia;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambPopUpButtonListener;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberMatchspellerInputModelAccess;
import de.audi.app.navi.evo.search.DemoModeSearchGuiHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHousenumberMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressDisambiguatorHMIListener {
    protected static final int NO_DISAMBIG_CHOICE_DEST;
    private static final String LOGCLASS;
    private AddressDisambiguatorEvo addressDisambiguator;
    private final NavigationEnv env;
    private final HomeAddressHandler homeAddressHandler;
    private final ADBInterAppService adbInterAppService;
    private final LogChannel lc;
    private boolean spellerStateRestored = false;

    public AddressDisambiguatorHMIListener(AddressDisambiguatorEvo addressDisambiguatorEvo, NavigationEnv navigationEnv, HomeAddressHandler homeAddressHandler, ADBInterAppService aDBInterAppService, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap) {
        Object object;
        this.addressDisambiguator = addressDisambiguatorEvo;
        this.env = navigationEnv;
        this.homeAddressHandler = homeAddressHandler;
        this.adbInterAppService = aDBInterAppService;
        this.lc = navigationEnv.getSearchLogChannel();
        this.addressDisambiguator.matchSpeller.clear();
        AddressInputFormModelAccessHelperEU addressInputFormModelAccessHelperEU = new AddressInputFormModelAccessHelperEU(navigationEnv);
        HousenumberMatchspellerInputModelAccess housenumberMatchspellerInputModelAccess = new HousenumberMatchspellerInputModelAccess(navigationEnv, addressDisambiguatorEvo.matchSpeller.getID(), addressDisambiguatorEvo.tiledList.getID(), addressInputFormModelAccessHelperEU);
        if (Util.isHURegionAsia()) {
            object = new AddressDisambiguatorHMIListener$DisambMatchSpellerListenerAsia(this, new HousenumberMatchspellerInputSequence(housenumberMatchspellerInputModelAccess, SpellerStack.getInstance(), addressDisambiguatorEvo.commandListFactory, iPreviewMap, iAddressInputForm), new AddressInputHousenumberMatchSpellerSequence(addressDisambiguatorEvo.commandListFactory, navigationEnv, housenumberMatchspellerInputModelAccess, iPreviewMap, SpellerStack.getInstance(), null), navigationEnv, addressDisambiguatorEvo.matchSpeller.getID(), addressDisambiguatorEvo.tiledList.getID(), addressDisambiguatorEvo.menuModel.getID(), iPreviewMap);
            addressDisambiguatorEvo.matchSpeller.setSpellerListenerAsia((MatchspellerListenerAsia)object);
        } else {
            object = new AddressDisambiguatorHMIListener$DisambMatchSpellerListener(this, new HousenumberMatchspellerInputSequence(housenumberMatchspellerInputModelAccess, SpellerStack.getInstance(), addressDisambiguatorEvo.commandListFactory, iPreviewMap, iAddressInputForm), navigationEnv, addressDisambiguatorEvo.matchSpeller.getID(), addressDisambiguatorEvo.tiledList.getID(), addressDisambiguatorEvo.menuModel.getID(), iPreviewMap);
            addressDisambiguatorEvo.matchSpeller.setSpellerListener((SpellerListener)object);
        }
        object = new AddressDisambiguatorHMIListener$DisambPopUpButtonListener(this, null);
        navigationEnv.getButtonModel(-937425408).setButtonListener((ButtonListener)object);
        navigationEnv.getButtonModel(-920648192).setButtonListener((ButtonListener)object);
        navigationEnv.getButtonModel(-1239415296).setButtonListener((ButtonListener)object);
        navigationEnv.getButtonModel(-1222638080).setButtonListener((ButtonListener)object);
    }

    private void restoreSpellerState() {
        if (!this.spellerStateRestored) {
            CommandList commandList = this.addressDisambiguator.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(this.addressDisambiguator.getSpellerState()));
            commandList.execute("AddressDisambiguatorHMIListener#restoreSpellerStateCommandList");
            this.spellerStateRestored = true;
        }
    }

    private void executeUserAction(NavLocation navLocation, ICommandList iCommandList) {
        int n = this.env.getChoiceModel(1579091456).getValue();
        if (n == 1) {
            iCommandList.commandFinishedWithPostSequence(this.saveDestinationInContact(navLocation));
        } else if (n == 2) {
            this.saveHomeAddress(navLocation);
        } else if (n == 9) {
            iCommandList.commandFinishedWithPostCommand(DemoModeSearchGuiHandler.getSetPositionCommand(navLocation, this.addressDisambiguator.logger));
        } else {
            iCommandList.commandFinishedWithPostSequence(this.getStartRouteGudianceCL(navLocation));
        }
    }

    private CommandList saveDestinationInContact(NavLocation navLocation) {
        if (this.addressDisambiguator.logger.isDebug2()) {
            this.addressDisambiguator.logger.log(14808325, "%1#saveDestinationInContact - Store Address to ADB", (Object)"AddressDisambiguatorHMIListener");
        }
        CommandList commandList = this.addressDisambiguator.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new AddressDisambiguatorHMIListener$1(this, "SaveLocationInAdbCommand"));
        return commandList;
    }

    private void saveHomeAddress(NavLocation navLocation) {
        this.addressDisambiguator.logger.log(-2137614336, "AddressDisambiguatorHMIListener#saveHomeAddress: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
    }

    private CommandList getStartRouteGudianceCL(NavLocation navLocation) {
        CommandList commandList = this.addressDisambiguator.commandListFactory.createCommandList();
        commandList.add(new AddressDisambiguatorHMIListener$2(this, "AddressDisambiguatorHMIListener#DisambBaseListListener#itemSelected start RG", navLocation));
        return commandList;
    }

    static /* synthetic */ void access$100(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener) {
        addressDisambiguatorHMIListener.restoreSpellerState();
    }

    static /* synthetic */ AddressDisambiguatorEvo access$200(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener) {
        return addressDisambiguatorHMIListener.addressDisambiguator;
    }

    static /* synthetic */ void access$400(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener, NavLocation navLocation, ICommandList iCommandList) {
        addressDisambiguatorHMIListener.executeUserAction(navLocation, iCommandList);
    }

    static /* synthetic */ LogChannel access$500(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener) {
        return addressDisambiguatorHMIListener.lc;
    }

    static /* synthetic */ NavigationEnv access$700(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener) {
        return addressDisambiguatorHMIListener.env;
    }

    static /* synthetic */ ADBInterAppService access$800(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener) {
        return addressDisambiguatorHMIListener.adbInterAppService;
    }
}

