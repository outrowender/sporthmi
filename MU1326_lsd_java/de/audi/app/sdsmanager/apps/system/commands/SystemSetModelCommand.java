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
    private static final int MODEL_READOUT = 0;
    private static final int MODEL_ADDRESS_CORRECTION = 1;
    private static final int MODEL_HOME_ADDRESS = 2;
    private static final int MODEL_MSG_DIALOG_STATE = 3;
    private static final int MODEL_SCREEN_SYNCED = 4;
    private static final int MODEL_NAV_POI_CORRECTION = 5;
    private static final int MODEL_LIST_NOT_SPEAKABLE = 6;
    private static final int MODEL_NAVI_VDE_NO_I_MEANT = 7;
    private static final int MODEL_CMD_MODE_HELP = 8;
    private static final int MODEL_ADB_SPOKEN_CATEGORY_LOCATION = 9;
    private static final int MODEL_PICKLIST_CONTEXT_CHOICE = 10;
    private static final int MODEL_DIALOG_CONTEXT_CHOICE = 11;
    private static final int MODEL_MSG_READOUT_ACTIVE_CHOICE = 12;
    private static final int MODEL_SDS_HELP_CORRECTION_CHOICE = 13;
    private static final int MODEL_ASIA_SEARCH_AREA_CHOICE = 14;
    private static final int MODEL_SDS_STORE_NBEST_RESULT_CHOICE = 15;
    private static final int MODEL_REMOTE_HMI_ONLINE_PROMPT_AVAILABLE_CHOICE = 16;
    private static final int MODEL_VDE_ONESHOT_ACTIVE_CHOICE = 17;
    private static final int MODEL_NAVI_TRUFFLES_CONTEXT = 18;
    private static final int MODEL_NAVI_FAVORITES_PICKLIST = 19;
    private static final int MODEL_LAST_DESTINATION_PICKLIST = 20;
    private static final int MODEL_COMMAND_DISPLAY_SOURCE = 21;
    private static final int MODEL_LAST_DESTINATION_NAVIGATE_HOME = 22;
    private static final int MODEL_VOICE_BARGE_IN_PROMPT_SELECT = 23;
    private static final int MODEL_PTT_IN_HELP_TOPIC = 24;
    private static final int MODEL_SDS_RECOGNIZER_CHOICE = 25;
    private static final int MODEL_SDS_COMMAND_SCREEN_CHOICE = 26;
    private static final int MODEL_SDS_PROGRESS_ICON_VISIBLE_CHOICE = 27;
    private static final int MODEL_SDS_INTERSECTION_SET_CHOICE = 28;
    private static final int MODEL_SDS_PROMPT_TYPE_UNCHANGING_CHOICE = 29;
    private static final int MODEL_SDS_ONLINE_POI_SYNC_NEEDED_CHOICE = 30;
    private static final int MODEL_SDS_AUDI_CONNECT_SCREEN_SYNC_CHOICE = 31;
    private static final int[][] modelTranslationTable = new int[][]{{0, 275}, {1, 3854}, {2, 3855}, {3, 3905}, {4, 3912}, {5, 3942}, {6, 3943}, {7, 3954}, {8, 3956}, {9, 3970}, {10, 4008}, {11, 4090}, {12, 276}, {13, 4164}, {14, 4337}, {15, 4305}, {16, SDSManagerBaseActivator.getMapping().getModelID(25)}, {17, 4397}, {18, 4409}, {19, 4459}, {20, 4460}, {21, 4482}, {22, 4534}, {23, SDSManagerBaseActivator.getMapping().getModelID(29)}, {24, 4644}, {25, 324}, {26, 3981}, {27, 4007}, {28, SDSManagerBaseActivator.getMapping().getModelID(31)}, {29, SDSManagerBaseActivator.getMapping().getModelID(32)}, {30, SDSManagerBaseActivator.getMapping().getModelID(33)}, {31, SDSManagerBaseActivator.getMapping().getModelID(34)}};

    public SystemSetModelCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.model = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.value = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
        this.hmi = hMIService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] called; model=%2, value=%3", (Object)this.getName(), (long)this.model, (long)this.value);
        int n = SDSUtils.translate(this.model, modelTranslationTable);
        if (n == Integer.MIN_VALUE) {
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
}

