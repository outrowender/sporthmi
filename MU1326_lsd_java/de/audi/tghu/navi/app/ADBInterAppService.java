/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService$1;
import de.audi.tghu.navi.app.ADBInterAppService$2;
import de.audi.tghu.navi.app.ADBInterAppService$3;
import de.audi.tghu.navi.app.ADBInterAppService$4;
import de.audi.tghu.navi.app.ADBInterAppService$5;
import de.audi.tghu.navi.app.ADBInterAppService$6;
import de.audi.tghu.navi.app.ADBInterAppService$7;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBOnlineUtils;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.command.CheckTryBestMatchResultCommand;
import de.audi.tghu.navi.app.command.LITryBestMatchCommand;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.li.aih.AddressbookDestinationAIH;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.io.Serializable;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

public class ADBInterAppService
implements NaviADBService {
    private static final int NO_DISAMBIG_CHOICE_DEST;
    private static final int DISAMBIG_CHOICE_DEST_TRY_BEST_MATCH;
    protected final NavigationEnv env;
    private DSINavigationManager dsiNavigationManager;
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final INavigationInputModeManager inputModeManager;
    private final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private IAddressInputForm addressInputForm;
    private final LocationSerializer locationSerializer;
    private INaviFavoriteHandler favoriteHandler;
    private NavLocation addressbookDestination = null;
    private NaviADBService$LocationInputHandler locationInputHandler = null;
    private NaviADBService$LocationInputHandler fallbackLocationInputHandler = null;
    private final CommandListCallManager commandListCallManager;
    private IPoiService poiService;
    private final MapInterface mapInterface;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected GuiModelAccessForPreviewMapDetailScreen guiModelAccessDetails;

    public ADBInterAppService(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, ICommandListFactory iCommandListFactory, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, LocationSerializer locationSerializer, CommandListCallManager commandListCallManager, MapInterface mapInterface) {
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.dsiNavigationManager = dSINavigationManager;
        this.locationSerializer = locationSerializer;
        this.logChannel = navigationEnv.getLogChannel();
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.commandListCallManager = commandListCallManager;
        this.mapInterface = mapInterface;
    }

    public void setGuiModelAccessDetailsFavoriteContacts(GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen) {
        this.guiModelAccessDetails = guiModelAccessForPreviewMapDetailScreen;
    }

    public void setFavoriteHandler(INaviFavoriteHandler iNaviFavoriteHandler) {
        this.favoriteHandler = iNaviFavoriteHandler;
    }

    @Override
    public void setDestination(byte[] byArray, String string) {
        this.logChannel.log(-2137614336, "%1#setDestination( %2 )", (Object)this.CLASS_NAME, (Object)string);
        this.env.getChoiceModel(1042286080).setValue(0);
        this.setInputMode(0);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StreamToLocationCommand(byArray));
        commandList.add(new ADBInterAppService$1(this, "Save contact name and enqueue strart guidance sequence", string));
        commandList.execute("ADBInterAppService#setDestination");
    }

    @Override
    public void setDestination(String string, String string2, String string3) {
        this.setInputMode(0);
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setDestination( %1, %2 )").toString(), (long)n, (long)n2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        this.showAdressbookDestination(navLocation, string3);
        this.startGuidanceToDestinationSequence.start(navLocation);
    }

    public CommandList getTryBestMatchAndOpenAddressInputFormCL(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, AdbEntry adbEntry, int n, IAddressInputForm iAddressInputForm, CommandList commandList) {
        IAddressInputForm iAddressInputForm2 = iAddressInputForm;
        commandList.add(new LITryBestMatchCommand(adbEntry, (short)n));
        commandList.add(new ADBInterAppService$2(this, "ADBInterAppService#getTryBestMatchAndOpenAddressInputFormCL get nav loc, (show error-popup,) open AIF", adbEntry, naviADBService$LocationInputHandler, iAddressInputForm2));
        return commandList;
    }

    @Override
    public void setDestination(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, AdbEntry adbEntry, int n, String string) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setDestination ADBEntry = %1, adrIndex = %2").toString(), (Object)adbEntry, (long)n);
        this.getTryBestMatchAndOpenAddressInputFormCL(naviADBService$LocationInputHandler, adbEntry, n, this.addressInputForm, this.commandListFactory.createCommandList()).execute(new StringBuffer().append(this.CLASS_NAME).append("#setDestination enter adb-entry").toString());
    }

    @Override
    public void setDestination(AdbEntry adbEntry, int n, String string) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setDestination ADBEntry = %1, adrIndex = %2").toString(), (Object)adbEntry, (long)n);
        this.getTryBestMatchAndOpenAddressInputFormCL(null, adbEntry, n, this.addressInputForm, this.commandListFactory.createCommandList()).execute(new StringBuffer().append(this.CLASS_NAME).append("#setDestination enter adb-entry").toString());
    }

    public void setDestination_old(AdbEntry adbEntry, int n, String string) {
        this.env.getChoiceModel(1042286080).setValue(0);
        this.env.getChoiceModel(-1407187456).setValue(0);
        this.setInputMode(0);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setDestination_old - entry <%1>; adrIndex <%2>").toString(), (Object)adbEntry, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LITryBestMatchCommand(adbEntry, (short)n));
        commandList.add(new CheckTryBestMatchResultCommand());
        commandList.add(new ADBInterAppService$3(this, string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setDestination_old").toString());
    }

    @Override
    public GeoMetric convertDecimalsToGeoMetric(String string, String string2) {
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#convertDecimalsToGeoMetric( %1, %2 )").toString(), (long)n, (long)n2);
        return new GeoMetric(n2, n);
    }

    @Override
    public void editLocation(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, AdbEntry adbEntry, int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#editLocation inputHandler = %1, ADBEntry = %2, adrIndex = %3").toString(), (Object)naviADBService$LocationInputHandler, (Object)adbEntry, (long)n);
        this.setInputMode(1);
        this.handlerRegistered(naviADBService$LocationInputHandler);
        CommandList commandList = this.getTryBestMatchAndOpenAddressInputFormCL(naviADBService$LocationInputHandler, adbEntry, n, this.addressInputForm, this.commandListFactory.createCommandList());
        commandList.add(new ADBInterAppService$4(this, new StringBuffer().append(this.CLASS_NAME).append("#editLocation Set tryBestMatch result as current location").toString()));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#editLocation adb-option addDest").toString());
    }

    @Override
    public void editLocation(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, byte[] byArray) {
        this.setInputMode(1);
        this.env.getChoiceModel(-1407187456).setValue(0);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#editLocation() #### ADBDest = %1").toString(), (Object)byArray);
        this.handlerRegistered(naviADBService$LocationInputHandler);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StreamToLocationCommand(byArray));
        commandList.add(new ADBInterAppService$5(this, "Save contact name and enqueue start NDF sequence"));
        commandList.execute("ADBInterAppService#editLocation");
    }

    @Override
    public String[] getLocationName(byte[] byArray) {
        String[] stringArray = null;
        try {
            this.logChannel.log(-2137614336, "%1#getLocationName", (Object)this.CLASS_NAME);
            NavLocation navLocation = this.streamToLocation(byArray);
            this.logChannel.log(-2137614336, "%1#getLocationName - retreived navLocation", (Object)this.CLASS_NAME);
            Util.setDescriptionOnLocation(navLocation, "");
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
            stringArray = new String[]{locationFormattingResponse.getFirstLineAsText(), locationFormattingResponse.getSecondLineAsText()};
        }
        catch (Exception exception) {
            exception.printStackTrace();
            stringArray = new String[]{"", ""};
        }
        return stringArray;
    }

    @Override
    public String getLocationNameSingleLine(byte[] byArray) {
        String string = null;
        try {
            this.logChannel.log(-2137614336, "%1#getLocationNameSingleLine", (Object)this.CLASS_NAME);
            NavLocation navLocation = this.streamToLocation(byArray);
            this.logChannel.log(-2137614336, "%1#getLocationNameSingleLine - retreived navLocation", (Object)this.CLASS_NAME);
            Util.setDescriptionOnLocation(navLocation, "");
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatOneLine(navLocation, this.env);
            string = locationFormattingResponse.getFirstLineAsText();
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#getLocationNameSingleLine %2", (Object)this.CLASS_NAME, (Throwable)exception);
            string = "";
        }
        return string;
    }

    public String[] getLocationNameForNavLocation(NavLocation navLocation) {
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
        return new String[]{locationFormattingResponse.getFirstLineAsText(), locationFormattingResponse.getSecondLineAsText()};
    }

    @Override
    public byte[] resolveGeoCoords(int n, int n2, String string) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#resolveGeoCoords - longitude: %1, latitude: %2").toString(), (long)n, (long)n2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        if (!Util.isEmpty(string)) {
            Util.setOnlinePOINameOnLocation(navLocation, string);
        }
        byte[] byArray = navLocation != null ? this.locationToStream(navLocation) : new byte[]{};
        return byArray;
    }

    @Override
    public void parkNearDestination(byte[] byArray, String string) {
        NavLocation navLocation = this.streamToLocation(byArray);
        this.poiService.startParkingNearDestination(navLocation);
    }

    @Override
    public void parkNearDestination(String string, String string2, String string3) {
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        this.poiService.startParkingNearDestination(navLocation);
    }

    @Override
    public void poiNearDestination(byte[] byArray, String string) {
        NavLocation navLocation = this.streamToLocation(byArray);
        this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
    }

    @Override
    public void poiNearDestination(String string, String string2, String string3) {
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
    }

    @Override
    public void showDestinationInMap(byte[] byArray, String string) {
        this.logChannel.log(-2137614336, "%1#showDestinationInMap( byte[], - )", (Object)this.CLASS_NAME);
        this.setInputMode(1);
        NavLocation navLocation = this.streamToLocation(byArray);
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "%1#showDestinationInMap(byte[] navLoc) location is NULL", (Object)this.CLASS_NAME);
            return;
        }
        this.mapInterface.destOptShowInMap(navLocation);
    }

    @Override
    public void showDestinationInMap(String string, String string2, String string3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#showDestinationInMap() - longitude: %1, latitude: %2").toString(), (Object)string, (Object)string2);
        this.setInputMode(1);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(Util.degreeStringToWgs84(string), Util.degreeStringToWgs84(string2));
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "%1#showDestinationInMap(long, lat, ...) location is NULL", (Object)this.CLASS_NAME);
            return;
        }
        this.mapInterface.destOptShowInMap(navLocation);
    }

    @Override
    public void focusPreviewMap(byte[] byArray) {
        this.env.getChoiceModel(4078).setValue(0);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#focusPreviewMap with byte[]", (Object)this.CLASS_NAME);
        }
        NavLocation navLocation = this.streamToLocation(byArray);
        try {
            GuiTooltipInformationContainer guiTooltipInformationContainer = null;
            if (this.guiModelAccessDetails != null) {
                guiTooltipInformationContainer = this.guiModelAccessDetails.createMapTooltipInformationContainer(navLocation, "");
            }
            this.mapInterface.getPreviewMap().setPreviewAddressBookEntry(navLocation, 10, this.guiModelAccessDetails, guiTooltipInformationContainer);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#focusPreviewMap() - ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
            exception.printStackTrace();
        }
        this.env.getChoiceModel(4078).setValue(1);
    }

    @Override
    public void focusPreviewMap(String string, String string2) {
        this.env.getChoiceModel(4078).setValue(0);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#focusPreviewMap with geo coordinates", (Object)this.CLASS_NAME);
        }
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        try {
            GuiTooltipInformationContainer guiTooltipInformationContainer = null;
            if (this.guiModelAccessDetails != null) {
                guiTooltipInformationContainer = this.guiModelAccessDetails.createMapTooltipInformationContainer(navLocation, "");
            }
            this.mapInterface.getPreviewMap().setPreviewAddressBookEntry(navLocation, 10, this.guiModelAccessDetails, guiTooltipInformationContainer);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#focusPreviewMap() - ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
            exception.printStackTrace();
        }
        this.env.getChoiceModel(4078).setValue(1);
    }

    @Override
    public void focusPreviewMap(AdbEntry adbEntry, int n) {
        this.env.getChoiceModel(4078).setValue(0);
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#focusPreviewMap on AdbEntry - entry <%1>; adrIndex <%2>").toString(), (Object)adbEntry, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LITryBestMatchCommand(adbEntry, (short)n));
        commandList.add(new CheckTryBestMatchResultCommand());
        commandList.add(new ADBInterAppService$6(this));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#focusPreviewMap").toString());
    }

    @Override
    public void enterPreviewMap(int n, int n2) {
        try {
            this.mapInterface.getPreviewMap().previewMapScreenEntering(0, 0, 0, 0);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#enterPreviewMap() - ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
            exception.printStackTrace();
        }
    }

    @Override
    public void exitPreviewMap() {
        try {
            this.mapInterface.getPreviewMap().previewMapScreenExited();
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#exitPreviewMap() - ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
            exception.printStackTrace();
        }
    }

    @Override
    public void addToFavorites(String string, String string2, String string3) {
        if (this.favoriteHandler == null) {
            this.logChannel.log(10000, "%1#addToFavorites - favoriteHandler is null!", (Object)this.CLASS_NAME);
            return;
        }
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        this.favoriteHandler.addToFavorites(navLocation, string3);
    }

    @Override
    public void addToFavorites(byte[] byArray, String string) {
        if (this.favoriteHandler == null) {
            this.logChannel.log(10000, "%1#addToFavorites - favoriteHandler is null!", (Object)this.CLASS_NAME);
            return;
        }
        NavLocation navLocation = this.streamToLocation(byArray);
        this.favoriteHandler.addToFavorites(navLocation, string);
    }

    @Override
    public void definePreset(DefinitionRequest definitionRequest, byte[] byArray, String string) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#definePreset() name=%1, request=%2").toString(), (Object)string, (Object)definitionRequest);
        PresetListRow presetListRow = new PresetListRow();
        presetListRow.setText(2, string);
        if (byArray == null) {
            this.logChannel.log(10000, "%1#definePreset() byte[] ist null", (Object)this.CLASS_NAME);
            definitionRequest.responseDefine(1, null, null, 4);
            return;
        }
        definitionRequest.responseDefine(0, (Serializable)byArray, presetListRow, 4);
    }

    @Override
    public void definePreset(DefinitionRequest definitionRequest, String string, String string2, String string3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#definePreset() name=%1, request=%2").toString(), (Object)string3, (Object)definitionRequest);
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        NavLocation navLocation = this.resolveGeoCoordsNavLocation(n, n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new ADBInterAppService$7(this, "Save contact name and enqueue strart guidance sequence", definitionRequest));
        commandList.execute("ADBInterAppService#definePreset");
    }

    public NavLocation resolveGeoCoordsNavLocation(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#resolveGeoCoordsNavLocation - longitude: %1, latitude: %2").toString(), (long)n, (long)n2);
        return NaviADBOnlineUtils.resolveGeoCoords(this.env, this.dsiNavigationManager, n, n2, this.commandListCallManager);
    }

    private void showAdressbookDestination(NavLocation navLocation, String string) {
        Util.setDescriptionOnLocation(navLocation, string);
        this.logChannel.log(-2137614336, "%1#showAdressbookDestination( %2 )", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.removeHandler();
    }

    public NavLocation getAddressbookDestination() {
        return this.addressbookDestination;
    }

    private void setAddressbookDestination(NavLocation navLocation) {
        this.addressbookDestination = navLocation;
    }

    public void removeHandler() {
        this.logChannel.log(-2137614336, "%1#removeHandler() - current handler: %2", (Object)this.CLASS_NAME, (Object)this.locationInputHandler);
        if (this.locationInputHandler != null) {
            this.locationInputHandler.sessionClosed();
            this.locationInputHandler = null;
        }
    }

    public boolean isHandlerRegistered() {
        return this.locationInputHandler != null;
    }

    public NaviADBService$LocationInputHandler getCurrentLocationInputHandler() {
        return this.locationInputHandler;
    }

    private void handlerRegistered(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler) {
        if (this.locationInputHandler != null) {
            this.logChannel.log(1078071040, "%1#handlerRegistered() - handler already registered! Old handler will be overridden!", (Object)this.CLASS_NAME);
        }
        this.locationInputHandler = naviADBService$LocationInputHandler;
        this.fallbackLocationInputHandler = naviADBService$LocationInputHandler;
    }

    public void updateGivenTryBestMatchLocation(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#updateGivenTryBestMatchLocation( %2 )", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.addressInputForm.acceptGivenInput(new AddressbookDestinationAIH(this.getCurrentLocationInputHandler(), this.commandListFactory), navLocation));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#updateGivenTryBestMatchLocation").toString());
    }

    public NavLocation streamToLocation(byte[] byArray) {
        this.logChannel.log(-2137614336, "%1#streamToLocation(): stream: %2", (Object)this.CLASS_NAME, (Object)byArray);
        return this.locationSerializer.streamToLocation(byArray);
    }

    public byte[] locationToStream(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#locationToStream(): location: %2", (Object)this.CLASS_NAME, (Object)navLocation);
        return this.locationSerializer.locationToStream(navLocation);
    }

    private void setInputMode(int n) {
        this.logChannel.log(-2137614336, "%1#setInputMode( %2 )", (Object)this.CLASS_NAME, (long)n);
        this.env.getChoiceModel(170).setValue(2);
        this.inputModeManager.setInputMode(n, this.env);
    }

    public void setAddressInputForm(IAddressInputForm iAddressInputForm) {
        this.addressInputForm = iAddressInputForm;
    }

    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }

    static /* synthetic */ void access$000(ADBInterAppService aDBInterAppService, NavLocation navLocation, String string) {
        aDBInterAppService.showAdressbookDestination(navLocation, string);
    }

    static /* synthetic */ IStartGuidanceToDestinationSequence access$100(ADBInterAppService aDBInterAppService) {
        return aDBInterAppService.startGuidanceToDestinationSequence;
    }

    static /* synthetic */ NaviADBService$LocationInputHandler access$200(ADBInterAppService aDBInterAppService) {
        return aDBInterAppService.fallbackLocationInputHandler;
    }

    static /* synthetic */ void access$300(ADBInterAppService aDBInterAppService, NaviADBService$LocationInputHandler naviADBService$LocationInputHandler) {
        aDBInterAppService.handlerRegistered(naviADBService$LocationInputHandler);
    }

    static /* synthetic */ LogChannel access$400(ADBInterAppService aDBInterAppService) {
        return aDBInterAppService.logChannel;
    }

    static /* synthetic */ void access$500(ADBInterAppService aDBInterAppService, NavLocation navLocation) {
        aDBInterAppService.setAddressbookDestination(navLocation);
    }

    static /* synthetic */ IAddressInputForm access$600(ADBInterAppService aDBInterAppService) {
        return aDBInterAppService.addressInputForm;
    }

    static /* synthetic */ MapInterface access$700(ADBInterAppService aDBInterAppService) {
        return aDBInterAppService.mapInterface;
    }
}

