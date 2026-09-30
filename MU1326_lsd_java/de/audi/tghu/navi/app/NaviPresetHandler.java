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
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
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
    private static final long TIMEOUT = 30000L;
    private static final String LOGCLASS = "NaviPresetHandler";

    public NaviPresetHandler(NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.commandListFactory = iCommandListFactory;
        this.homeAddressHandler = homeAddressHandler;
    }

    public abstract int getType();

    public abstract int[] getModelIds();

    public int getExecutionType() {
        return 4;
    }

    public void requestDefinition(DefinitionRequest definitionRequest) {
        this.env.getLogChannel().log(10000000, "%1#requestDefinition() request is %2", (Object)LOGCLASS, (Object)definitionRequest);
        EvoListRow evoListRow = this.env.getBaseListModel(definitionRequest.getModelId()).getRow(definitionRequest.getRowId());
        if (this.isPostalAddress(evoListRow) || this.isAmbiguous(evoListRow)) {
            definitionRequest.responseDefine(1, null, null, 4);
            return;
        }
        SyncNavLocationExtractorAdapter syncNavLocationExtractorAdapter = (SyncNavLocationExtractorAdapter)this.listToNavExtractor.get(new Integer(definitionRequest.getModelId()));
        NavLocation navLocation = syncNavLocationExtractorAdapter.extractNavLocationFromRow(evoListRow);
        if (this.env.getLogChannel().isDebug()) {
            this.env.getLogChannel().log(10000000, "%1#requestDefinition() NavLocation is %2", (Object)LOGCLASS, (Object)LocationFormatter.formatLocationShort(navLocation));
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
            this.env.getLogChannel().log(10000000, "%1#isAmbiguous() return true", (Object)LOGCLASS);
            return true;
        }
        this.env.getLogChannel().log(10000000, "%1#isAmbiguous() return false", (Object)LOGCLASS);
        return false;
    }

    private boolean isPostalAddress(EvoListRow evoListRow) {
        AdbEntryListRow adbEntryListRow;
        int n;
        if (evoListRow instanceof AdbEntryListRow && ((n = (adbEntryListRow = (AdbEntryListRow)evoListRow).getAdbType()) == 0 || n == 1)) {
            this.env.getLogChannel().log(10000000, "%1#isPostalAddress() return true", (Object)LOGCLASS);
            return true;
        }
        this.env.getLogChannel().log(10000000, "%1#isPostalAddress() return false", (Object)LOGCLASS);
        return false;
    }

    public void requestExecute(final ExecuteRequest executeRequest) {
        this.env.getLogChannel().log(10000000, "%1#requestExecute() preset=%2", (Object)LOGCLASS, (Object)executeRequest.getPreset());
        Serializable serializable = executeRequest.getPreset().getData();
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new StreamToLocationCommand((byte[])serializable));
        commandList.add(new NavCommand(){

            public void execute() {
                NaviPresetHandler.this.startGuidanceToDestinationSequence.start((NavLocation)this.getCommandList().get("STREAMED_LOCATION"));
                executeRequest.responseExecute(0);
                NaviPresetHandler.this.fireSMTransition();
                this.getCommandList().commandFinished();
            }
        });
        commandList.setErrorCommand(new NavCommand(){

            public void execute() {
                this.env.getLogChannel().log(10000, "%1#requestExecute() request=%2", (Object)NaviPresetHandler.LOGCLASS, (Object)executeRequest);
                executeRequest.responseExecute(1);
                this.getCommandList().commandFinished();
            }
        });
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
            this.env.getLogChannel().log(100000, "%1#getSerializedNavLocation location is null", (Object)LOGCLASS);
            return null;
        }
        final Object object = new Object();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void locationToStreamResult(boolean bl, byte[] byArray) {
                this.logger.log(10000000, "LocationToStreamCommand#locationToStreamResult( %1 )", bl);
                if (bl) {
                    this.getCommandList().put("LOCATION_STREAM", byArray);
                }
                Object object2 = object;
                synchronized (object2) {
                    object.notify();
                }
                this.getCommandList().commandFinished();
            }
        });
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("NaviPresetHandler#LocationToStreamCommandList");
            try {
                object.wait(30000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return (byte[])commandList.get("LOCATION_STREAM");
    }
}

