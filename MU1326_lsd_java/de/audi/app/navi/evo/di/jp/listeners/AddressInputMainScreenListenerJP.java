/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.AbstractAddressInputListenerEvo;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
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
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputMainScreenListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenListenerJP
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
    private static final int PREFECTURE_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiJpMainScreenPrefectureTextFieldModel();
    private static final int CITY_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiJpMainScreenCityTextFieldModel();
    private static final int FACILITY_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiJpMainScreenFacilityNameTextFieldModel();
    private static final int PLACENAME_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiJpMainScreenPlaceNameTextFieldModel();
    private static final int CHOME_TEXT_FIELD_MODEL_ID = DIScreensEvo.getDiJpMainScreenChomeTextFieldModel();
    private static final int START_GUIDANCE_BUTTON_MODEL_ID = DIScreensEvo.getDiJpMainScreenStartGuidanceButtonModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiJpMainScreenMenuModel();
    private static final int PREFECTURE_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiJpMainScreenPrefectureDirectWritingSpellerModel();
    private static final int CITY_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiJpMainScreenCityDirectWritingSpellerModel();
    private static final int PLACE_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiJpMainScreenPlaceNameDirectWritingSpellerModel();
    private static final int CHOME_DIRECT_WRITTING_SPELLER_MODEL_ID = DIScreensEvo.getDiJpMainScreenChomeDirectWritingSpellerModel();
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiJpDestOptMethodsButtonModel();
    private static final int SUBMIT_ADDRESS_TO_ADB_BUTTON_ID = DIScreensEvo.getDiJpSubmitAddressToAddressBookButtonModel();
    private static final int SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiJpSubmitAddressAsHomeAddressButtonModel();
    private static final int CREATE_EDIT_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiJpCreateEditHomeAddressButtonModel();
    private static final int SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiJpSubmitLocationToRemoteHmiButtonModel();
    private static final int EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID = DIScreensEvo.getDiJpExtendSearchAreaForRemoteHmiButtonModel();
    private static final int ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID = DIScreensEvo.getDiJpOnlineSearchAreaBaseListModel();
    private static final int SET_NEW_SEARCH_AREA_BUTTON_MODEL_ID = DIScreensEvo.getDiJpPOISearchInNewAreaButton();

    public AddressInputMainScreenListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputMainScreenSequence addressInputMainScreenSequence, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputMainScreenSequence;
        this.adbInterAppService = aDBInterAppService;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.homeAddressHandler = homeAddressHandler;
        this.initListeners();
    }

    protected void initListeners() {
        this.env.getTextfieldModel(PREFECTURE_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(CITY_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(FACILITY_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(PLACENAME_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getTextfieldModel(CHOME_TEXT_FIELD_MODEL_ID).setButtonListener(this);
        this.env.getSpellerModel(PREFECTURE_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(CITY_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(PLACE_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getSpellerModel(CHOME_DIRECT_WRITTING_SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getButtonModel(START_GUIDANCE_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_TO_ADB_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(CREATE_EDIT_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SET_NEW_SEARCH_AREA_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getBaseListModel(ONLINE_SEARCH_AREA_BASE_LIST_MODEL_ID).setListener(this);
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
    }

    public CommandList getStartCommandList(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation);
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.getStartCommandList();
    }

    public CommandList getStartCommandListForOnline() {
        return this.inputSequence.getStartCommandList(null, true);
    }

    public CommandList getStartCommandListForOnline(NavLocation navLocation) {
        return this.inputSequence.getStartCommandList(navLocation, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void keyPressed(int n, int n2, int n3) {
        block22: {
            block29: {
                block28: {
                    block27: {
                        block26: {
                            block25: {
                                block24: {
                                    block23: {
                                        this.logChannel.log(10000000, "%1#keyPressed - with modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
                                        if (n != DEST_OPT_METHODS_BUTTON_ID) break block23;
                                        this.inputManager.start(this.adbInterAppService.getAddressbookDestination());
                                        if (this.inputModeManager.getInputMode() == 1) {
                                            this.env.getChoiceModel(170).setValue(2);
                                        }
                                        break block22;
                                    }
                                    if (n != SUBMIT_ADDRESS_TO_ADB_BUTTON_ID) break block24;
                                    this.startReturnNavLocationToAdressbookSequence();
                                    break block22;
                                }
                                if (n != SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID) break block25;
                                this.startReturnNavLocationToAddressHandlerSequence(this.homeAddressHandler);
                                break block22;
                            }
                            if (n != SUBMIT_LOCATION_TO_REMOTE_HMI_BUTTON_ID) break block26;
                            this.startReturnNavLocationToRemoteHmi();
                            break block22;
                        }
                        if (n != CREATE_EDIT_HOME_ADDRESS_BUTTON_ID) break block27;
                        this.inputModeManager.setInputMode(2, this.env);
                        this.inputManager.start(this.homeAddressHandler.getCurrentHomeAddress());
                        break block22;
                    }
                    if (n != EXTEND_SEARCH_AREA_FOR_REMOTE_HMI_BUTTON_ID) break block28;
                    this.inputModeManager.setInputMode(5, this.env);
                    break block22;
                }
                if (n != SET_NEW_SEARCH_AREA_BUTTON_MODEL_ID) break block29;
                int n4 = this.inputModeManager.getInputMode();
                if (n4 == 5 || n4 == 4) {
                    this.startReturnNavLocationToRemoteHmi();
                    break block22;
                } else if (n4 == 6) {
                    this.startReturnNavLocationToPoiOnline();
                    break block22;
                } else {
                    this.inputManager.getPoiService().startPoiWithSearchContext(4, this.env.getContainer().getLiCurrentLD(), true);
                }
                break block22;
            }
            if (n == PREFECTURE_TEXT_FIELD_MODEL_ID) {
                if (AddressInputUtilEvo.isInPOIRelatedContext(this.env)) {
                    this.logChannel.log(10000000, "%1#keyPressed() set nation wide button to invisible.", (Object)this.CLASS_NAME);
                    this.env.getButtonModel(DIScreensEvo.getDiJpPrefectureScreenNationWideButtonModel()).setStatus(0);
                } else {
                    this.logChannel.log(10000000, "%1#keyPressed() set nation wide button to visible.", (Object)this.CLASS_NAME);
                    this.env.getButtonModel(DIScreensEvo.getDiJpPrefectureScreenNationWideButtonModel()).setStatus(1);
                }
                this.inputManager.executeAddressInputEvent(this.inputSequence.getStartPrefectureCommandList(), 20002);
            } else if (n == CITY_TEXT_FIELD_MODEL_ID) {
                this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(), 20003);
            } else if (n == FACILITY_TEXT_FIELD_MODEL_ID) {
                this.resetPreviousLocation();
                this.inputManager.executeAddressInputEvent(this.inputSequence.getStartFacilityCommandList(), 20004);
            } else if (n == PLACENAME_TEXT_FIELD_MODEL_ID) {
                this.inputManager.executeAddressInputEvent(this.inputSequence.getStartPlacenameCommandList(), 20005);
            } else if (n == CHOME_TEXT_FIELD_MODEL_ID) {
                if ((Util.isEmpty(this.env.getTextfieldModel(PLACENAME_TEXT_FIELD_MODEL_ID).getText1()) || this.env.getInputModeManager().isSdsActive()) && !this.isChomeNumberAvailable()) {
                    this.env.getChoiceModel(401712).setValue(0);
                    return;
                }
                if (this.env.getContainer().selectionCriterionAvailable(144)) {
                    this.logChannel.log(10000000, "%1#keyPressed - updateChoiceModel Chome select screen is needed!", (Object)this.CLASS_NAME);
                    this.env.getChoiceModel(DIScreensEvo.getDiJpNeedsChome()).setValue(1);
                    this.inputManager.executeAddressInputEvent(this.commandListFactory.createCommandList(), 20006);
                } else {
                    this.logChannel.log(10000000, "%1#keyPressed - updateChoiceModel Chome select screen is not needed!", (Object)this.CLASS_NAME);
                    this.env.getChoiceModel(DIScreensEvo.getDiJpNeedsChome()).setValue(0);
                    this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(), 20804);
                }
            } else if (n == START_GUIDANCE_BUTTON_MODEL_ID) {
                this.inputManager.executeAddressInputEvent(this.inputSequence.getStartRouteGuidanceCommandList(), 20011);
            } else {
                this.logChannel.log(10000000, "%1#keyPressed - no valid case for modelId=%2 keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    public boolean isChomeNumberAvailable() {
        DSIResponseContainer dSIResponseContainer = this.env.getContainer();
        return dSIResponseContainer.selectionCriterionAvailable(144) || dSIResponseContainer.selectionCriterionAvailable(5);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged - model=%2, text=%3, latestChar=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        if (n == PREFECTURE_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting prefecture speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(PREFECTURE_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartPrefectureCommandList(c2), 20007);
        } else if (n == CITY_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting city speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(CITY_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartCityZipCommandList(c2), 20008);
        } else if (n == PLACE_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting place name speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(PLACE_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartPlacenameCommandList(c2), 20009);
        } else if (n == CHOME_DIRECT_WRITTING_SPELLER_MODEL_ID) {
            this.logChannel.log(10000000, "%1#textChanged - starting chome/number speller", (Object)this.CLASS_NAME);
            this.clearSpellerModel(CHOME_DIRECT_WRITTING_SPELLER_MODEL_ID);
            this.inputManager.executeAddressInputEvent(this.inputSequence.getStartHouseNumberCommandList(c2), 20010);
        } else {
            this.logChannel.log(10000000, "%1#textChanged - unsupported model id (%2)", (Object)this.CLASS_NAME, (long)n);
        }
        this.env.fireModelEvent(n, n2);
    }

    public void resetPreviousLocation() {
        this.previousLocation = null;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused (menu model) menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        if (this.previousLocation == null || this.inputSequence.isNdfEnteredForTheFirstTime() || this.previousLocation.longitude != navLocation.longitude || this.previousLocation.latitude != navLocation.latitude) {
            this.logChannel.log(10000000, "%1#itemFocused -- liCurrentLD = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            String string = Util.getLocationAccessor(navLocation).getState();
            String string2 = Util.getLocationAccessor(navLocation).getTown();
            String string3 = Util.getLocationAccessor(navLocation).getPlaceName();
            CommandList commandList = this.commandListFactory.createCommandList();
            this.previousLocation = navLocation;
            if (Util.isEmpty(string)) {
                commandList.add(new NavCommand("Focus preview map on CCP"){

                    public void execute() {
                        AddressInputMainScreenListenerJP.this.previewMap.setPreviewAreaAroundCCP(1);
                        this.getCommandList().commandFinished();
                    }
                });
            } else if (Util.isEmpty(string2) && !Util.isEmpty(string) || Util.isEmpty(string3) && !Util.isEmpty(string2)) {
                commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
            } else {
                commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, false, 1, null, null));
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemFocused update preview map").toString());
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

