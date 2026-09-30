/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.AbstractAddressInputListenerEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputMainScreenListenerJP;
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

public class AddressInputRightDrawerListenerJP
extends AbstractAddressInputListenerEvo
implements OptionModelListener {
    private static final int WIDGET_ID = 1;
    private final MapInterface mapInterface;
    private final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    private final AsyncNavLocationExtractor asyncLiCityHistoryListNavLocationExtractor;
    private final AddressInputMainScreenListenerJP mainScreenListener;
    private static final int PREFECTURE_SCREEN_TILED_LIST = DIScreensEvo.getDiJpPrefectureScreenTiledListModel();
    private static final int CITY_SCREEN_TILED_LIST = DIScreensEvo.getDiJpCityScreenTiledListModel();
    private static final int PLACENAME_SCREEN_TILED_LIST = DIScreensEvo.getDiJpPlacenameScreenTiledListModel();
    private static final int CHOME_SCREEN_TILED_LIST = DIScreensEvo.getDiJpChomeScreenTiledListModel();
    private static final int HOUSENUMBER_SCREEN_TILED_LIST = DIScreensEvo.getDiJpHouseNumberScreenTiledListModel();
    private static final int WARD_SCREEN_TILED_LIST = DIScreensEvo.getDiJpWardScreenTiledListModel();
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiJpStoreDestinationAsFavoriteOptionModel();
    private static final int POI_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiJpPoiNearDestinationOptionModel();
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiJpShowInMapOptionModel();
    private static final int ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID = DIScreensEvo.getDiJpAddDestinationToContactOptionModel();
    private static final int[] optionListenerTargets = new int[]{PREFECTURE_SCREEN_TILED_LIST, CITY_SCREEN_TILED_LIST, PLACENAME_SCREEN_TILED_LIST, CHOME_SCREEN_TILED_LIST, HOUSENUMBER_SCREEN_TILED_LIST, WARD_SCREEN_TILED_LIST};

    public AddressInputRightDrawerListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor, AsyncNavLocationExtractor asyncNavLocationExtractor2, AddressInputMainScreenListenerJP addressInputMainScreenListenerJP) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.asyncLiCityHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.mapInterface = mapInterface;
        this.mainScreenListener = addressInputMainScreenListenerJP;
        this.initListeners();
    }

    protected void initListeners() {
        this.registerOptionListenersForOption(STORE_AS_FAVORITE_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(POI_NEAR_DESTINATION_OPTION_MODEL_ID);
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
        } else if (n == POI_NEAR_DESTINATION_OPTION_MODEL_ID) {
            this.inputManager.startPoiNearDestination(this.inputManager.getBackupLocation());
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
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.inputManager.addAddressToFavorites(navLocation);
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.inputManager.addAddressToFavorites(navLocation);
                    }
                });
            }
        } else if (n == POI_NEAR_DESTINATION_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.inputManager.startPoiNearDestination(navLocation);
                        iCommandList.commandFinished();
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.inputManager.startPoiNearDestination(navLocation);
                        iCommandList.commandFinished();
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
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.mapInterface.destOptShowInMap(navLocation);
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.mapInterface.onShowInMapClicked(null);
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.mapInterface.destOptShowInMap(navLocation);
                    }
                });
            }
        } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
            if (evoListRow instanceof LiValueListRow) {
                this.asyncLiValueListNavLocationExctractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.inputManager.startStoringNavLocationOnAdbEntry(navLocation);
                    }
                });
            } else if (evoListRow instanceof AbstractAddressInputHistoryElementListRow) {
                this.asyncLiCityHistoryListNavLocationExtractor.executeCallbackWithNavLocation(evoListRow, 0, new NavLocationCallback(){

                    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                        AddressInputRightDrawerListenerJP.this.logChannel.log(10000000, "%1#handleKeyPressedForList navlocation is %2", (Object)AddressInputRightDrawerListenerJP.this.CLASS_NAME, (Object)navLocation);
                        AddressInputRightDrawerListenerJP.this.inputManager.startStoringNavLocationOnAdbEntry(navLocation);
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

    public CommandList getStartCommandList() {
        return null;
    }

    public CommandList getStartCommandList(String string) {
        return null;
    }
}

