/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.addressinput.RemoteHmiCityHistoryListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
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
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenListenerEU
extends AbstractAddressInputListenerEU
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
    private static final int COUNTRY_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiEuMainScreenCountryTextFieldModel();
    private static final int CITY_ZIP_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiEuMainScreenCityZipTextFieldModel();
    private static final int STREET_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiEuMainScreenStreetTextFieldModel();
    private static final int HOUSENUMBER_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiEuMainScreenHousenumberTextFieldModel();
    private static final int JUNCTION_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiEuMainScreenJunctionTextFieldModel();
    private static final int START_GUIDANCE_BUTTON_MODEL_ID = DIScreensEvo.getDiEuMainScreenStartGuidanceButtonModel();
    private static final int COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiEuMainScreenCountryDirectWritingSpellerModel();
    private static final int CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiEuMainScreenCityZipDirectWritingSpellerModel();
    private static final int STREET_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiEuMainScreenStreetDirectWritingSpellerModel();
    private static final int HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiEuMainScreenHousenumberDirectWritingSpellerModel();
    private static final int JUNCTION_DIRECT_WRITING_SPELLER_MODEL_ID = DIScreensEvo.getDiEuMainScreenJunctionDirectWritingSpellerModel();
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiEuDestOptMethodsButtonModel();
    private static final int SUBMIT_ADDRESS_TO_ADB_BUTTON_ID = DIScreensEvo.getDiEuSubmitAddressToAddressBookButtonModel();
    private static final int SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiEuSubmitAddressAsHomeAddressButtonModel();
    private static final int CREATE_EDIT_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiEuCreateEditHomeAddressButtonModel();
    private static final int SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiEuSubmitLocationToRemoteHmiButtonModel();
    private static final int EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiEuExtendSearchAreaForRemoteHmiButtonModel();
    private static final int ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID = DIScreensEvo.getDiEuOnlineSearchAreaBaseListModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiEuMainScreenMenuModel();

    public AddressInputMainScreenListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputMainScreenSequence addressInputMainScreenSequence, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputMainScreenSequence;
        this.adbInterAppService = aDBInterAppService;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.homeAddressHandler = homeAddressHandler;
        this.initListeners();
    }

    protected void initListeners() {
        this.env.getTextfieldModel(COUNTRY_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(CITY_ZIP_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(STREET_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(HOUSENUMBER_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(JUNCTION_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(START_GUIDANCE_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_TO_ADB_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(CREATE_EDIT_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getSpellerModel(COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(STREET_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(JUNCTION_DIRECT_WRITING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getBaseListModel(ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID).setListener(this);
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.getStartCommandList();
    }

    public CommandList getStartCommandList(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation);
    }

    public CommandList getStartCommandListForOnline() {
        return this.inputSequence.getStartCommandList(null, true);
    }

    public CommandList getStartCommandListForOnline(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation, true);
    }

    public void resetPreviousLocation() {
        this.previousLocation = null;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused (menu model) menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
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

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped modelID=%2, keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
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
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCountryCommandList(), 2);
        } else if (n == CITY_ZIP_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(), 3);
        } else if (n == STREET_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(), 4);
        } else if (n == HOUSENUMBER_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(), 5);
        } else if (n == JUNCTION_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartJunctionCommandList(), 6);
        } else if (n == START_GUIDANCE_BUTTON_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartRouteGuidanceCommandList(), 8);
        } else {
            this.logChannel.log(10000000, "%1#keyTyped - no valid case for modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        }
        this.env.fireModelEvent(n, n3);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged - model=%2, text=%3, latestChar=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        if (n == COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting country speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(COUNTRY_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCountryCommandList(c2), 9);
        } else if (n == CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting city zip speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(CITY_ZIP_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(c2), 10);
        } else if (n == STREET_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting street speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(STREET_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(c2), 11);
        } else if (n == HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting housenumber speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(HOUSENUMBER_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(c2), 12);
        } else if (n == JUNCTION_DIRECT_WRITING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting junction speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(JUNCTION_DIRECT_WRITING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartJunctionCommandList(c2), 13);
        } else {
            this.logChannel.log(10000000, "%1#textChanged - unsupported model id (%2)", (Object)this.CLASS_NAME, (long)n);
        }
        this.env.fireModelEvent(n, n2);
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        this.logChannel.log(10000000, "%1#itemSelected model=%2, row=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)evoListRow);
        if (n == ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID) {
            RemoteHmiCityHistoryListRow remoteHmiCityHistoryListRow = (RemoteHmiCityHistoryListRow)evoListRow;
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new GetLastCityHistoryEntryCommand(remoteHmiCityHistoryListRow.getHistoryElement()));
            commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString()){

                public void execute() {
                    Object object = this.getCommandList().get("NavLocation from History");
                    if (object instanceof NavLocation) {
                        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
                    } else {
                        this.getCommandList().commandAborted("unexpected Object");
                    }
                }
            });
            ReturnNavLocationToPOIOnlineSearchSequence returnNavLocationToPOIOnlineSearchSequence = new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory);
            commandList.add(returnNavLocationToPOIOnlineSearchSequence.getStartCommandList());
            commandList.add(new NavCommand("delay fire model event"){

                public void execute() {
                    this.env.fireModelEvent(n, n4);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused model=%2, row=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)evoListRow);
        if (n == ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID) {
            RemoteHmiCityHistoryListRow remoteHmiCityHistoryListRow = (RemoteHmiCityHistoryListRow)evoListRow;
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new GetLastCityHistoryEntryCommand(remoteHmiCityHistoryListRow.getHistoryElement()));
            commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected Set Preview Map").toString()){

                public void execute() {
                    Object object = this.getCommandList().get("NavLocation from History");
                    if (object != null && object instanceof NavLocation) {
                        AddressInputMainScreenListenerEU.this.previewMap.setPreviewLocationCity((NavLocation)object, 1, null, null);
                    }
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemFocused").toString());
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

