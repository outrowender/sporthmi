/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.addressinput.RemoteHmiCityHistoryListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.nar.listeners.AbstractAddressInputListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputMainScreenListenerNAR$1;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputMainScreenListenerNAR$2;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequenceNAR;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenListenerNAR
extends AbstractAddressInputListenerNAR
implements IAddressInputMainScreenListener,
ButtonListener,
SpellerListener,
BaseListModelListener,
MenuModelListener {
    private final AddressInputMainScreenSequence inputSequence;
    private final ADBInterAppService adbInterAppService;
    private final INavigationInputModeManager inputModeManager;
    private final HomeAddressHandler homeAddressHandler;
    private NavLocation previousLocation = null;
    private static final int COUNTRY_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiNarMainScreenCountryTextFieldModel();
    private static final int CITY_ZIP_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiNarMainScreenCityZipTextFieldModel();
    private static final int STREET_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiNarMainScreenStreetTextFieldModel();
    private static final int HOUSENUMBER_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiNarMainScreenHousenumberTextFieldModel();
    private static final int START_GUIDANCE_BUTTON_MODEL_ID = DIScreensEvo.getDiNarMainScreenStartGuidanceButtonModel();
    private static final int COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiNarMainScreenCountryDirectWritingSpellerModel();
    private static final int CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiNarMainScreenCityZipDirectWritingSpellerModel();
    private static final int STREET_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiNarMainScreenStreetDirectWritingSpellerModel();
    private static final int HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiNarMainScreenHousenumberDirectWritingSpellerModel();
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiNarDestOptMethodsButtonModel();
    private static final int SUBMIT_ADDRESS_TO_ADB_BUTTON_ID = DIScreensEvo.getDiNarSubmitAddressToAddressBookButtonModel();
    private static final int SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiNarSubmitAddressAsHomeAddressButtonModel();
    private static final int CREATE_EDIT_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiNarCreateEditHomeAddressButtonModel();
    private static final int SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiNarSubmitLocationToRemoteHmiButtonModel();
    private static final int EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiNarExtendSearchAreaForRemoteHmiButtonModel();
    private static final int ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID = DIScreensEvo.getDiNarOnlineSearchAreaBaseListModel();
    private static final int ADD_STREET_BUTTON_MODEL_ID = DIScreensEvo.getDiNarAddStreetButtonModel();
    private static final int ADD_INTERSECTION_BUTTON_MODEL_ID = DIScreensEvo.getDiNarAddIntersectionButtonModel();
    private static final int ADD_HOUSENUMBER_BUTTON_MODEL_ID = DIScreensEvo.getDiNarAddHousenumberButtonModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiNarMainScreenMenuModel();

    public AddressInputMainScreenListenerNAR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputMainScreenSequenceNAR addressInputMainScreenSequenceNAR, IRouteManager iRouteManager, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputMainScreenSequenceNAR;
        this.adbInterAppService = aDBInterAppService;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.homeAddressHandler = homeAddressHandler;
        this.initListeners();
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return this.getStartCommandList();
    }

    @Override
    public CommandList getStartCommandList(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation);
    }

    @Override
    public CommandList getStartCommandListForOnline() {
        return this.inputSequence.getStartCommandList(null, true);
    }

    @Override
    public CommandList getStartCommandListForOnline(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation, true);
    }

    @Override
    protected void initListeners() {
        this.env.getTextfieldModel(COUNTRY_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(CITY_ZIP_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(STREET_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(HOUSENUMBER_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(START_GUIDANCE_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_TO_ADB_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(CREATE_EDIT_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(ADD_HOUSENUMBER_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(ADD_STREET_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(ADD_INTERSECTION_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getSpellerModel(COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(STREET_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getBaseListModel(ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID).setListener(this);
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused (menu model) menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        if (this.previousLocation == null || this.inputSequence.isNdfEnteredForTheFirstTime() || this.previousLocation.longitude != navLocation.longitude || this.previousLocation.latitude != navLocation.latitude) {
            CommandList commandList = this.commandListFactory.createCommandList();
            this.previousLocation = navLocation;
            if (navLocation != null && Util.isEmpty(navLocation.street) && !Util.isEmpty(navLocation.town)) {
                commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
            } else {
                commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, false, 1, null, null));
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemFocused update preview map").toString());
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected model=%2, row=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)evoListRow);
        if (n == ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID) {
            if (evoListRow instanceof RemoteHmiCityHistoryListRow) {
                RemoteHmiCityHistoryListRow remoteHmiCityHistoryListRow = (RemoteHmiCityHistoryListRow)evoListRow;
                CommandList commandList = this.commandListFactory.createCommandList();
                commandList.add(new GetLastCityHistoryEntryCommand(remoteHmiCityHistoryListRow.getHistoryElement()));
                commandList.add(new AddressInputMainScreenListenerNAR$1(this, new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString()));
                ReturnNavLocationToPOIOnlineSearchSequence returnNavLocationToPOIOnlineSearchSequence = new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory);
                commandList.add(returnNavLocationToPOIOnlineSearchSequence.getStartCommandList());
                commandList.add(new AddressInputMainScreenListenerNAR$2(this, "delay fire model event", n, n4));
                commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
            } else {
                this.logChannel.log(-1601830656, "%1#itemSelected - row is no instance of RemoteHmiCityHistoryListRow. This would cause a class cast exception.", (Object)this.CLASS_NAME);
            }
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "%1#textChanged - model=%2, text=%3, latestChar=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        if (n == COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting country speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCountryCommandList(c2), 30009);
        } else if (n == CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting city zip speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(c2), 30010);
        } else if (n == STREET_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting street speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(STREET_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(c2), 30011);
        } else if (n == HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting housenumber speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(c2), 30012);
        } else {
            this.logChannel.log(-2137614336, "%1#textChanged - unsupported model id (%2)", (Object)this.CLASS_NAME, (long)n);
        }
        this.env.fireModelEvent(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped modelID=%2, keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == DEST_OPT_METHODS_BUTTON_ID) {
            this.inputManager.start(this.adbInterAppService.getAddressbookDestination());
            if (this.inputModeManager.getInputMode() == 1) {
                this.env.getChoiceModel(170).setValue(2);
            }
        } else if (n == SUBMIT_ADDRESS_TO_ADB_BUTTON_ID) {
            this.startReturnNavLocationToAdressbookSequence();
        } else if (n == SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID) {
            this.startReturnNavLocationToAddressHandlerSequence(this.homeAddressHandler);
        } else if (n == SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID) {
            this.startReturnNavLocationToRemoteHmi();
        } else if (n == CREATE_EDIT_HOME_ADDRESS_BUTTON_ID) {
            this.inputModeManager.setInputMode(2, this.env);
            this.inputManager.start(this.homeAddressHandler.getCurrentHomeAddress());
        } else if (n == EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID) {
            this.inputModeManager.setInputMode(5, this.env);
        } else if (n == COUNTRY_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCountryCommandList(), 30002);
        } else if (n == CITY_ZIP_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(), 30003);
        } else if (n == ADD_STREET_BUTTON_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(), 30018);
        } else if (n == STREET_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(), 30004);
        } else if (n == HOUSENUMBER_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(), 30005);
        } else if (n == ADD_HOUSENUMBER_BUTTON_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(), 30019);
        } else if (n == START_GUIDANCE_BUTTON_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartRouteGuidanceCommandList(), 30008);
        } else if (n == ADD_INTERSECTION_BUTTON_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartJunctionCommandList(), 30006);
        } else {
            this.logChannel.log(-2137614336, "%1#keyTyped - no valid case for modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void resetPreviousLocation() {
        this.previousLocation = null;
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

