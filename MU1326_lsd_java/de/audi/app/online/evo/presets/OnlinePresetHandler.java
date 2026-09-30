/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.presets;

import de.audi.app.online.evo.presets.OnlinePresetData;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.atip.preset.IOnlinePresetHandler;
import de.audi.atip.preset.Preset;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.remoteinterface.IRemoteHMIPresetEntryConfiguration;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.io.Serializable;
import java.util.List;

public class OnlinePresetHandler
implements IAppPresetDefinitionHandler,
IAppPresetExecutionHandler,
IOnlinePresetHandler {
    private LogChannel logger = Online.getInstance().getPresetsLogChannel();
    private RemoteHMIService remoteHMIService;
    private static final String LOGCLASS = "OnlinePresetHandler";
    private List configurations;
    static /* synthetic */ Class class$de$audi$app$online$evo$presets$OnlinePresetData;

    public OnlinePresetHandler(RemoteHMIService remoteHMIService) {
        this.remoteHMIService = remoteHMIService;
    }

    public final int getExecutionType() {
        return 6;
    }

    public void requestExecute(ExecuteRequest executeRequest) {
        Serializable serializable = executeRequest.getPreset().getData();
        if (serializable instanceof OnlinePresetData) {
            OnlinePresetData onlinePresetData = (OnlinePresetData)serializable;
            int n = onlinePresetData.getType();
            String string = onlinePresetData.getContextName();
            RemoteHMIAction remoteHMIAction = this.remoteHMIService.getAction(100089417);
            remoteHMIAction.getParameters().putInt("type", n);
            remoteHMIAction.getParameters().put("contextName", string);
            this.remoteHMIService.invokeAction(remoteHMIAction);
            executeRequest.responseExecute(0);
            this.logger.log(1000000, "%1#requestExecute() called for type %2 and context %3", (Object)LOGCLASS, (Object)(n == 5 ? "DISTRIBUTED" : "SERVER"), (Object)string);
            return;
        }
        this.logger.log(100000, "%1#requestExecute(): got Serializable which was not of Class %2 but %3.", (Object)LOGCLASS, (Object)(class$de$audi$app$online$evo$presets$OnlinePresetData == null ? (class$de$audi$app$online$evo$presets$OnlinePresetData = OnlinePresetHandler.class$("de.audi.app.online.evo.presets.OnlinePresetData")) : class$de$audi$app$online$evo$presets$OnlinePresetData).getName(), (Object)serializable.getClass().getName());
        executeRequest.responseExecute(1);
    }

    public int getType() {
        return 1;
    }

    public int[] getModelIds() {
        return new int[]{2300157};
    }

    public void requestDefinition(DefinitionRequest definitionRequest) {
        this.logger.log(10000000, "%1#requestDefinition() called", (Object)LOGCLASS);
        RemoteHMIContext remoteHMIContext = this.remoteHMIService.getContext();
        if (remoteHMIContext != null && remoteHMIContext.getContextName().equals("top_wizard")) {
            this.handlePresetStorageFromTopWizard(definitionRequest);
        } else if (remoteHMIContext != null && !remoteHMIContext.getContextName().equals("top_wizard")) {
            this.handlePresetStorageInsideService(definitionRequest);
        } else {
            this.logger.log(10000000, "%1#requestDefinition(): context not accessible.", (Object)LOGCLASS);
            this.createEmptyResponse(definitionRequest);
        }
    }

    private void handlePresetStorageInsideService(DefinitionRequest definitionRequest) {
        String string = this.remoteHMIService.getContext().getContextName();
        String string2 = this.getAppNameByContextName(string);
        this.createPresetData(definitionRequest, string2, string);
    }

    private void handlePresetStorageFromTopWizard(DefinitionRequest definitionRequest) {
        if (this.remoteHMIService.getCurrentView().getCurrentGridList() != null) {
            IGridList iGridList = this.remoteHMIService.getCurrentView().getCurrentGridList();
            Object object = iGridList.get(iGridList.getCurrentCursor().getFocus().getIndex());
            if (object instanceof IGrid) {
                IGrid iGrid = (IGrid)object;
                List list = iGrid.getDrawerTypes();
                if (list == null || !list.contains("Audi_Connect_Preview")) {
                    IGridCell iGridCell = iGrid.getFirstCell(0);
                    if (iGridCell != null) {
                        String string = iGrid.getId();
                        String string2 = this.getAppNameByAppId(string);
                        String string3 = this.getContextNameByAppId(string);
                        this.createPresetData(definitionRequest, string2, string3);
                        return;
                    }
                    this.logger.log(100000, "%1#handlePresetStorageFromTopWizard(): grid does not have any text field.", (Object)LOGCLASS);
                } else {
                    this.logger.log(100000, "%1#handlePresetStorageFromTopWizard(): service is a preview and should not be stored.", (Object)LOGCLASS);
                }
            } else {
                this.logger.log(100000, "%1#handlePresetStorageFromTopWizard(): could not retrieve focussed item.", (Object)LOGCLASS);
            }
        } else {
            this.logger.log(100000, "%1#handlePresetStorageFromTopWizard(): could not retrieve current grid list.", (Object)LOGCLASS);
        }
        this.createEmptyResponse(definitionRequest);
    }

    private void createEmptyResponse(DefinitionRequest definitionRequest) {
        definitionRequest.responseDefine(1, null, null, 6);
    }

    private void createPresetData(DefinitionRequest definitionRequest, String string, String string2) {
        if (string != null && string2 != null) {
            int n = this.getTypeByContextName(string2);
            if (n == 1) {
                PresetListRow presetListRow = new PresetListRow();
                presetListRow.setRecordSet(0);
                presetListRow.setMainLabel(string);
                OnlinePresetData onlinePresetData = new OnlinePresetData(string, string2, n);
                definitionRequest.responseDefine(0, onlinePresetData, presetListRow, 6);
                this.logger.log(1000000, "%1#createPresetData(): created presetData for appname: %2, context: %3", (Object)LOGCLASS, (Object)string, (Object)string2);
                return;
            }
            this.logger.log(10000000, "%1#createPresetData(): trying to store preset of mobile app, which is not possible. Appname: '%2'", (Object)LOGCLASS, (Object)string);
        } else {
            this.logger.log(100000, "%1#createPresetData(): either appName (%2) or context (%3) is null.", (Object)LOGCLASS, (Object)string, (Object)string2);
        }
        this.createEmptyResponse(definitionRequest);
    }

    public void setPresetEntryConfigurations(List list) {
        this.configurations = list;
    }

    private String getAppNameByAppId(String string) {
        if (this.configurations != null) {
            for (int i2 = 0; i2 < this.configurations.size(); ++i2) {
                IRemoteHMIPresetEntryConfiguration iRemoteHMIPresetEntryConfiguration = (IRemoteHMIPresetEntryConfiguration)this.configurations.get(i2);
                if (!iRemoteHMIPresetEntryConfiguration.getAppId().equals(string)) continue;
                if (iRemoteHMIPresetEntryConfiguration.getType() != 2) {
                    return iRemoteHMIPresetEntryConfiguration.getName();
                }
                this.logger.log(10000000, "%1#getAppNameByAppId(): presets for mobile apps are not allowed. Cannot store %2.", (Object)LOGCLASS, (Object)iRemoteHMIPresetEntryConfiguration.getName());
            }
            this.logger.log(10000000, "%1#getAppNameByAppId(): could not retrieve app name for appId %2.", (Object)LOGCLASS, (Object)string);
        } else {
            this.logger.log(10000000, "%1#getAppNameByAppId(): presetEntryConfigurations is null.", (Object)LOGCLASS);
        }
        return null;
    }

    private String getAppNameByContextName(String string) {
        if (this.configurations != null) {
            for (int i2 = 0; i2 < this.configurations.size(); ++i2) {
                IRemoteHMIPresetEntryConfiguration iRemoteHMIPresetEntryConfiguration = (IRemoteHMIPresetEntryConfiguration)this.configurations.get(i2);
                if (!iRemoteHMIPresetEntryConfiguration.getContextName().equals(string)) continue;
                return iRemoteHMIPresetEntryConfiguration.getName();
            }
            this.logger.log(10000000, "%1#getAppNameByContextName(): could not retrieve app name for context name %2.", (Object)LOGCLASS, (Object)string);
        } else {
            this.logger.log(10000000, "%1#getAppNameByContextName(): presetEntryConfigurations is null.", (Object)LOGCLASS);
        }
        return null;
    }

    private String getContextNameByAppId(String string) {
        if (this.configurations != null) {
            for (int i2 = 0; i2 < this.configurations.size(); ++i2) {
                IRemoteHMIPresetEntryConfiguration iRemoteHMIPresetEntryConfiguration = (IRemoteHMIPresetEntryConfiguration)this.configurations.get(i2);
                if (!iRemoteHMIPresetEntryConfiguration.getAppId().equals(string)) continue;
                return iRemoteHMIPresetEntryConfiguration.getContextName();
            }
            this.logger.log(10000000, "%1#getContextNameByAppId(): could not retrieve context name for app id %2.", (Object)LOGCLASS, (Object)string);
        } else {
            this.logger.log(10000000, "%1#getContextNameByAppId(): presetEntryConfigurations is null.", (Object)LOGCLASS);
        }
        return null;
    }

    private int getTypeByContextName(String string) {
        if (this.configurations != null) {
            for (int i2 = 0; i2 < this.configurations.size(); ++i2) {
                IRemoteHMIPresetEntryConfiguration iRemoteHMIPresetEntryConfiguration = (IRemoteHMIPresetEntryConfiguration)this.configurations.get(i2);
                if (!iRemoteHMIPresetEntryConfiguration.getContextName().equals(string)) continue;
                return iRemoteHMIPresetEntryConfiguration.getType();
            }
            this.logger.log(10000000, "%1#getTypeByContextName(): could not retrieve type for context name %2.", (Object)LOGCLASS, (Object)string);
        } else {
            this.logger.log(10000000, "%1#getTypeByContextName(): presetEntryConfigurations is null.", (Object)LOGCLASS);
        }
        return 0;
    }

    public Preset updatePresetPreview(Preset preset) {
        String string = ((OnlinePresetData)preset.getData()).getContextName();
        if (string != null) {
            this.logger.log(10000000, "%1#updatePresetPreview() called for preset with context name '%1'", (Object)LOGCLASS, (Object)string);
            String string2 = this.getAppNameByContextName(string);
            if (string2 != null && !string2.startsWith("Text constant TEXT_CONST")) {
                preset.getPreview().setMainLabel(string2);
            }
        } else {
            this.logger.log(10000000, "%1#updatePresetPreview() called for preset without context name. Ignoring.", (Object)LOGCLASS);
        }
        return preset;
    }

    public final boolean isDynmaicOnlineModel(int n) {
        return n >= 2350000 && n <= 2400000;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

