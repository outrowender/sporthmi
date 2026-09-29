/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.di.AbstractAddressInputListenerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
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
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenListenerCN
extends AbstractAddressInputListenerEvo
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
    private static final int CITY_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiCnMainScreenCityZipTextFieldModel();
    private static final int LOCATION_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiCnMainScreenLocationTextFieldModel();
    private static final int STREET_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiCnMainScreenStreetTextFieldModel();
    private static final int HOUSENUMBER_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiCnMainScreenHousenumberTextFieldModel();
    private static final int INTERSECTION_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiCnMainScreenIntersectionTextFieldModel();
    private static final int START_GUIDANCE_BUTTON_MODEL_ID = DIScreensEvo.getDiCnMainScreenStartGuidanceButtonModel();
    private static final int SET_NEW_SEARCH_AREA_BUTTON_MODEL_ID = DIScreensEvo.getDiCnSearchInNewAreaButton();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiCnMainScreenMenuModel();
    private static final int CITY_ZIP_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiCnMainScreenCityZipDirectWritingSpellerModel();
    private static final int STREET_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiCnMainScreenStreetDirectWritingSpellerModel();
    private static final int HOUSENUMBER_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiCnMainScreenHouseNumberDirectWritingSpellerModel();
    private static final int INTERSECTION_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiCnMainScreenIntersectionDirectWritingSpellerModel();
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiCnDestOptMethodsButtonModel();
    private static final int SUBMIT_ADDRESS_TO_ADB_BUTTON_ID = DIScreensEvo.getDiCnSubmitAddressToAddressBookButtonModel();
    private static final int SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiCnSubmitAddressAsHomeAddressButtonModel();
    private static final int CREATE_EDIT_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiCnCreateEditHomeAddressButtonModel();
    private static final int SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiCnSubmitLocationToRemoteHmiButtonModel();
    private static final int EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiCnExtendSearchAreaForRemoteHmiButtonModel();
    private static final int SET_SEARCH_AREA_FOR_ONLINE_SEARCH_AREA_BUTTON_ID = DIScreensEvo.getDiCnPoiOnlineSetSearchAreaButtonModel();
    private static final int ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID = DIScreensEvo.getDiCnOnlineSearchAreaBaseListModel();

    public AddressInputMainScreenListenerCN(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputMainScreenSequence addressInputMainScreenSequence, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputMainScreenSequence;
        this.adbInterAppService = aDBInterAppService;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.homeAddressHandler = homeAddressHandler;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.env.getTextfieldModel(CITY_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(LOCATION_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(STREET_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(HOUSENUMBER_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(INTERSECTION_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(START_GUIDANCE_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_TO_ADB_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(CREATE_EDIT_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SET_NEW_SEARCH_AREA_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(SET_SEARCH_AREA_FOR_ONLINE_SEARCH_AREA_BUTTON_ID).setButtonListener(this);
        this.env.getSpellerModel(CITY_ZIP_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(STREET_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(HOUSENUMBER_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(INTERSECTION_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getBaseListModel(ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID).setListener(this);
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
    }

    @Override
    public CommandList getStartCommandList(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation);
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
    public CommandList getStartCommandListForOnline() {
        return this.inputSequence.getStartCommandList(null, true);
    }

    @Override
    public CommandList getStartCommandListForOnline(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation, true);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyPressed - with modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
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
        } else if (n == SET_NEW_SEARCH_AREA_BUTTON_MODEL_ID) {
            int n4 = this.inputModeManager.getInputMode();
            if (n4 == 5 || n4 == 4) {
                this.startReturnNavLocationToRemoteHmi();
            } else if (n4 == 6) {
                this.startReturnNavLocationToPoiOnline();
            } else {
                this.inputManager.getPoiService().startPoiWithSearchContext(4, this.env.getContainer().getLiCurrentLD(), true);
            }
        } else if (n == SET_SEARCH_AREA_FOR_ONLINE_SEARCH_AREA_BUTTON_ID) {
            int n5 = this.inputModeManager.getInputMode();
            if (n5 == 6) {
                this.startReturnNavLocationToPoiOnline();
            } else if (n5 == 5 || n5 == 4) {
                this.startReturnNavLocationToRemoteHmi();
            }
        } else if (n == CITY_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(), 10002);
        } else if (n == LOCATION_TEXT_FIELD_MODEL_ID) {
            this.resetPreviousLocation();
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartLocationNameCommandList(), 10003);
        } else if (n == STREET_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(), 10004);
        } else if (n == HOUSENUMBER_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(), 10005);
        } else if (n == INTERSECTION_TEXT_FIELD_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartJunctionCommandList(), 10006);
        } else if (n == START_GUIDANCE_BUTTON_MODEL_ID) {
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartRouteGuidanceCommandList(), 10007);
        } else {
            this.logChannel.log(-2137614336, "%1#keyPressed - no valid case for modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "%1#textChanged - model=%2, text=%3, latestChar=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        if (n == CITY_ZIP_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting city zip speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(CITY_ZIP_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(c2), 10009);
        } else if (n == STREET_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting street speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(STREET_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartStreetCommandList(c2), 10010);
        } else if (n == HOUSENUMBER_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting housenumber speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(HOUSENUMBER_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(c2), 10011);
        } else if (n == INTERSECTION_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(-2137614336, "%1#textChanged - starting intersection speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(INTERSECTION_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartJunctionCommandList(c2), 10012);
        } else {
            this.logChannel.log(-2137614336, "%1#textChanged - unsupported model id (%2)", (Object)this.CLASS_NAME, (long)n);
        }
        this.env.fireModelEvent(n, n2);
    }

    @Override
    public void resetPreviousLocation() {
        this.previousLocation = null;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused (menu model) menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        if (this.previousLocation == null || this.inputSequence.isNdfEnteredForTheFirstTime() || this.previousLocation.longitude != navLocation.longitude || this.previousLocation.latitude != navLocation.latitude) {
            CommandList commandList = this.commandListFactory.createCommandList();
            this.previousLocation = navLocation;
            if (navLocation != null && navLocation.latitude > 0 && navLocation.longitude > 0) {
                if (Util.isEmpty(navLocation.getStreet()) && !Util.isEmpty(navLocation.getTown())) {
                    commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
                } else {
                    commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, false, 1, null, null));
                }
            } else {
                commandList.add(new HidePreviewMapCommand(this.previewMap));
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemFocused update preview map").toString());
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

