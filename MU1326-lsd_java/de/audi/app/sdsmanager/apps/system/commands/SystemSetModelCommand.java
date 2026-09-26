/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class SystemSetModelCommand
extends AbstractSystemCallCommand {
    private final int model;
    private final int value;
    private HMIService hmi;
    private static final int MODEL_READOUT;
    private static final int MODEL_ADDRESS_CORRECTION;
    private static final int MODEL_HOME_ADDRESS;
    private static final int MODEL_MSG_DIALOG_STATE;
    private static final int MODEL_SCREEN_SYNCED;
    private static final int MODEL_NAV_POI_CORRECTION;
    private static final int MODEL_LIST_NOT_SPEAKABLE;
    private static final int MODEL_NAVI_VDE_NO_I_MEANT;
    private static final int MODEL_CMD_MODE_HELP;
    private static final int MODEL_ADB_SPOKEN_CATEGORY_LOCATION;
    private static final int MODEL_PICKLIST_CONTEXT_CHOICE;
    private static final int MODEL_DIALOG_CONTEXT_CHOICE;
    private static final int MODEL_MSG_READOUT_ACTIVE_CHOICE;
    private static final int MODEL_SDS_HELP_CORRECTION_CHOICE;
    private static final int MODEL_ASIA_SEARCH_AREA_CHOICE;
    private static final int MODEL_SDS_STORE_NBEST_RESULT_CHOICE;
    private static final int MODEL_REMOTE_HMI_ONLINE_PROMPT_AVAILABLE_CHOICE;
    private static final int MODEL_VDE_ONESHOT_ACTIVE_CHOICE;
    private static final int MODEL_NAVI_TRUFFLES_CONTEXT;
    private static final int MODEL_NAVI_FAVORITES_PICKLIST;
    private static final int MODEL_LAST_DESTINATION_PICKLIST;
    private static final int MODEL_COMMAND_DISPLAY_SOURCE;
    private static final int MODEL_LAST_DESTINATION_NAVIGATE_HOME;
    private static final int MODEL_VOICE_BARGE_IN_PROMPT_SELECT;
    private static final int MODEL_PTT_IN_HELP_TOPIC;
    private static final int MODEL_SDS_RECOGNIZER_CHOICE;
    private static final int MODEL_SDS_COMMAND_SCREEN_CHOICE;
    private static final int MODEL_SDS_PROGRESS_ICON_VISIBLE_CHOICE;
    private static final int MODEL_SDS_INTERSECTION_SET_CHOICE;
    private static final int MODEL_SDS_PROMPT_TYPE_UNCHANGING_CHOICE;
    private static final int MODEL_SDS_ONLINE_POI_SYNC_NEEDED_CHOICE;
    private static final int MODEL_SDS_AUDI_CONNECT_SCREEN_SYNC_CHOICE;
    private static final int[][] modelTranslationTable;

    public SystemSetModelCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.model = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.value = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
        this.hmi = hMIService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] called; model=%2, value=%3", (Object)this.getName(), (long)this.model, (long)this.value);
        int n = SDSUtils.translate(this.model, modelTranslationTable);
        if (n == 128) {
            this.logger.log(10000, "[%1#execute] unsupported model=%2", (Object)this.getName(), (long)this.model);
            return;
        }
        try {
            this.hmi.getChoiceModel(n).setValue(this.value);
        }
        catch (ClassCastException classCastException) {
            this.logger.log(10000, "[%1#execute] model is no choice model!", (Object)this.getName());
        }
        catch (NullPointerException nullPointerException) {
            this.logger.log(10000, "[%1#execute] model does not exist!", (Object)this.getName());
        }
    }

    static {
        modelTranslationTable = new int[][]{{0, 275}, {1, 3854}, {2, 3855}, {3, 3905}, {4, 3912}, {5, 3942}, {6, 3943}, {7, 3954}, {8, 3956}, {9, 3970}, {10, 4008}, {11, 4090}, {12, 276}, {13, 4164}, {14, 4337}, {15, 4305}, {16, SDSManagerBaseActivator.getMapping().getModelID(25)}, {17, 4397}, {18, 4409}, {19, 4459}, {20, 4460}, {21, 4482}, {22, 4534}, {23, SDSManagerBaseActivator.getMapping().getModelID(29)}, {24, 4644}, {25, 324}, {26, 3981}, {27, 4007}, {28, SDSManagerBaseActivator.getMapping().getModelID(31)}, {29, SDSManagerBaseActivator.getMapping().getModelID(32)}, {30, SDSManagerBaseActivator.getMapping().getModelID(33)}, {31, SDSManagerBaseActivator.getMapping().getModelID(34)}};
    }
}

