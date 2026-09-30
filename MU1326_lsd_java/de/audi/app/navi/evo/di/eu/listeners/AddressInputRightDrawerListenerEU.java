/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputMainScreenListenerEU;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.AbstractAddressInputHistoryElementListRow;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputRightDrawerListenerEU
extends AbstractAddressInputListenerEU
implements OptionModelListener {
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiEuStoreDestinationAsFavoriteOptionModel();
    private static final int PARKING_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiEuParkingNearDestinationOptionModel();
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiEuShowInMapOptionModel();
    private static final int ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID = DIScreensEvo.getDiEuAddDestinationToContactOptionModel();
    private static final int CITY_ZIP_SCREEN_TILED_LIST = DIScreensEvo.getDiEuCityZipScreenTiledListModel();
    private static final int STREET_SCREEN_TILED_LIST = DIScreensEvo.getDiEuStreetScreenTiledListModel();
    private static final int HOUSENUMBER_FREETEXT_SCREEN_TILED_LIST = DIScreensEvo.getDiEuHousenumberFreetextScreenTiledListModel();
    private static final int HOUSENUMBER_MATCHSPELLER_SCREEN_TILED_LIST = DIScreensEvo.getDiEuHousenumberMatchSpellerScreenTiledListModel();
    private static final int JUNCTION_SCREEN_TILED_LIST = DIScreensEvo.getDiEuJunctionScreenTiledListModel();
    private static final int REFINEMENT_SCREEN_TILED_LIST = DIScreensEvo.getDiEuRefinementScreenTiledListModel();
    private static final int[] optionListenerTargets = new int[]{CITY_ZIP_SCREEN_TILED_LIST, STREET_SCREEN_TILED_LIST, HOUSENUMBER_FREETEXT_SCREEN_TILED_LIST, HOUSENUMBER_MATCHSPELLER_SCREEN_TILED_LIST, JUNCTION_SCREEN_TILED_LIST, REFINEMENT_SCREEN_TILED_LIST};
    private static final int WIDGET_ID = 1;
    private final MapInterface mapInterface;
    private final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    private final AsyncNavLocationExtractor asyncLiCityHistoryListNavLocationExtractor;
    private final AddressInputMainScreenListenerEU mainScreenListener;

    public AddressInputRightDrawerListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor, AsyncNavLocationExtractor asyncNavLocationExtractor2, AddressInputMainScreenListenerEU addressInputMainScreenListenerEU) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.mapInterface = mapInterface;
        this.asyncLiCityHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.mainScreenListener = addressInputMainScreenListenerEU;
        this.initListeners();
    }

    public CommandList getStartCommandList() {
        return this.commandListFactory.createCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.getStartCommandList();
    }

    protected void initListeners() {
        this.registerOptionListenersForOption(STORE_AS_FAVORITE_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(PARKING_NEAR_DESTINATION_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(SHOW_IN_MAP_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID);
    }

    private void registerOptionListenersForOption(int n) {
        OptionModelApp optionModelApp = this.env.getHMIService().getOptionModel(n);
        optionModelApp.setCustomIDListener(this, 1);
        for (int i2 = 0; i2 < optionListenerTargets.length; ++i2) {
            optionModelApp.setListener(this, optionListenerTargets[i2]);
        }
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "%1#keyPressed - modelId=%2, targetModelId=%3, targetWidgetId=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (long)n4);
        if (n4 == 1) {
            this.handleKeyPressedForInputForm(n);
        } else {
            this.handleKeyPressedForList(n, n2, n3);
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }

    private void handleKeyPressedForInputForm(int n) {
        this.logChannel.log(10000000, "%1#handleKeyPressedForInputForm()", (Object)this.CLASS_NAME);
        this.mainScreenListener.resetPreviousLocation();
        if (n == STORE_AS_FAVORITE_OPTION_MODEL_ID) {
            this.inputManager.addAddressToFavorites(this.inputManager.getBackupLocation());
        } else if (n == PARKING_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (this.inputManager.getStartParkingNearDestination(this.inputManager.getBackupLocation()) != null) {
                this.inputManager.getStartParkingNearDestination(this.inputManager.getBackupLocation()).execute(new StringBuffer().append(this.CLASS_NAME).append("#Parking near destination").toString());
            }
        } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
            this.mapInterface.destOptShowInMap(this.inputManager.getBackupLocation());
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            this.inputManager.startStoringNavLocationOnAdbEntry(this.inputManager.getBackupLocation());
        }
    }

    private void handleKeyPressedForList(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#handleKeyPressedForList()", (Object)this.CLASS_NAME);
        EvoListRow evoListRow = this.env.getTiledListModel(n2).getRow(n3);
        if (n == STORE_AS_FAVORITE_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerEU.this.inputManager.addAddressToFavorites(navLocation);
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerEU.this.inputManager.addAddressToFavorites(navLocation);
                    }
                });
            }
        } else if (n == PARKING_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        iCommandList.commandFinishedWithPostSequence(AddressInputRightDrawerListenerEU.this.inputManager.getStartParkingNearDestination(navLocation));
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        iCommandList.commandFinishedWithPostSequence(AddressInputRightDrawerListenerEU.this.inputManager.getStartParkingNearDestination(navLocation));
                    }
                });
            }
        } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
                NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(lIValueListElement.longitude, lIValueListElement.latitude);
                this.mapInterface.onShowInMapClicked(navLocationWgs84);
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerEU.this.mapInterface.destOptShowInMap(navLocation);
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.mapInterface.onShowInMapClicked(null);
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerEU.this.mapInterface.destOptShowInMap(navLocation);
                    }
                });
            }
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerEU.this.inputManager.startStoringNavLocationOnAdbEntry(navLocation);
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerEU.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerEU.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerEU.this.inputManager.startStoringNavLocationOnAdbEntry(navLocation);
                    }
                });
            }
        }
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

