/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NaviPresetHandler$1;
import de.audi.tghu.navi.app.NaviPresetHandler$2;
import de.audi.tghu.navi.app.NaviPresetHandler$3;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.rows.AdbEntryListRow;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public abstract class NaviPresetHandler
implements IAppPresetDefinitionHandler,
IAppPresetExecutionHandler {
    protected NavigationEnv env;
    protected IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    protected final ICommandListFactory commandListFactory;
    private final HomeAddressHandler homeAddressHandler;
    protected Map listToNavExtractor = new HashMap();
    private static final long TIMEOUT;
    private static final String LOGCLASS;

    public NaviPresetHandler(NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.commandListFactory = iCommandListFactory;
        this.homeAddressHandler = homeAddressHandler;
    }

    @Override
    public abstract int getType() {
    }

    @Override
    public abstract int[] getModelIds() {
    }

    @Override
    public int getExecutionType() {
        return 4;
    }

    @Override
    public void requestDefinition(DefinitionRequest definitionRequest) {
        this.env.getLogChannel().log(-2137614336, "%1#requestDefinition() request is %2", (Object)"NaviPresetHandler", (Object)definitionRequest);
        EvoListRow evoListRow = this.env.getBaseListModel(definitionRequest.getModelId()).getRow(definitionRequest.getRowId());
        if (this.isPostalAddress(evoListRow) || this.isAmbiguous(evoListRow)) {
            definitionRequest.responseDefine(1, null, null, 4);
            return;
        }
        SyncNavLocationExtractorAdapter syncNavLocationExtractorAdapter = (SyncNavLocationExtractorAdapter)this.listToNavExtractor.get(new Integer(definitionRequest.getModelId()));
        NavLocation navLocation = syncNavLocationExtractorAdapter.extractNavLocationFromRow(evoListRow);
        if (this.env.getLogChannel().isDebug()) {
            this.env.getLogChannel().log(-2137614336, "%1#requestDefinition() NavLocation is %2", (Object)"NaviPresetHandler", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.savePreset(definitionRequest, navLocation);
    }

    private void savePreset(DefinitionRequest definitionRequest, NavLocation navLocation) {
        if (navLocation == null || !navLocation.isPositionValid()) {
            definitionRequest.responseDefine(1, null, null, 4);
            return;
        }
        PresetListRow presetListRow = new PresetListRow();
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
        presetListRow.setText(2, locationFormattingResponse.getFirstLineAsText());
        presetListRow.setText(4, locationFormattingResponse.getSecondLineAsText());
        byte[] byArray = this.getSerializedNavLocation(navLocation);
        if (byArray == null) {
            definitionRequest.responseDefine(1, null, null, 4);
            return;
        }
        definitionRequest.responseDefine(0, (Serializable)byArray, presetListRow, 4);
    }

    private boolean isAmbiguous(EvoListRow evoListRow) {
        if (evoListRow instanceof SearchResultListRow && 16 == ((SearchResultListRow)evoListRow).getSearchResult().getSource() && AddressDisambiguator.isHNrUnclear(this.env.getContainer().getTryMatchLocationResultData(), this.env.getLogChannel())) {
            this.env.getLogChannel().log(-2137614336, "%1#isAmbiguous() return true", (Object)"NaviPresetHandler");
            return true;
        }
        this.env.getLogChannel().log(-2137614336, "%1#isAmbiguous() return false", (Object)"NaviPresetHandler");
        return false;
    }

    private boolean isPostalAddress(EvoListRow evoListRow) {
        AdbEntryListRow adbEntryListRow;
        int n;
        if (evoListRow instanceof AdbEntryListRow && ((n = (adbEntryListRow = (AdbEntryListRow)evoListRow).getAdbType()) == 0 || n == 1)) {
            this.env.getLogChannel().log(-2137614336, "%1#isPostalAddress() return true", (Object)"NaviPresetHandler");
            return true;
        }
        this.env.getLogChannel().log(-2137614336, "%1#isPostalAddress() return false", (Object)"NaviPresetHandler");
        return false;
    }

    @Override
    public void requestExecute(ExecuteRequest executeRequest) {
        this.env.getLogChannel().log(-2137614336, "%1#requestExecute() preset=%2", (Object)"NaviPresetHandler", (Object)executeRequest.getPreset());
        Serializable serializable = executeRequest.getPreset().getData();
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new StreamToLocationCommand((byte[])serializable));
        commandList.add(new NaviPresetHandler$1(this, executeRequest));
        commandList.setErrorCommand(new NaviPresetHandler$2(this, executeRequest));
        commandList.execute("NaviPresetHandler#requestExecute() startRG for a navi preset");
    }

    private void fireSMTransition() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(4146);
        choiceModelApp.setValue(choiceModelApp.getValue() + 1);
    }

    protected void registerRowExtractor(int n, SyncNavLocationExtractorAdapter syncNavLocationExtractorAdapter) {
        this.listToNavExtractor.put(new Integer(n), syncNavLocationExtractorAdapter);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private byte[] getSerializedNavLocation(NavLocation navLocation) {
        if (navLocation == null) {
            this.env.getLogChannel().log(-1601830656, "%1#getSerializedNavLocation location is null", (Object)"NaviPresetHandler");
            return null;
        }
        Object object = new Object();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NaviPresetHandler$3(this, navLocation, object));
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("NaviPresetHandler#LocationToStreamCommandList");
            try {
                object.wait(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return (byte[])commandList.get("LOCATION_STREAM");
    }

    static /* synthetic */ void access$000(NaviPresetHandler naviPresetHandler) {
        naviPresetHandler.fireSMTransition();
    }
}

