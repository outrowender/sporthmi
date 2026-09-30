/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ve;

public class VEConstants {

    public static class Views {
        public static final int TYPE_VIDEO = 1000000;
        public static final int TYPE_EDITOR = 1000100;
        public static final int TYPE_LIST_EDITOR = 1000110;
    }

    public static class Action {
        public static final int ACTION_VOICE_DATA_AVAILABLE = 1000001;
        public static final int ACTION_VOICE_RECOGNITION_RUNNING = 1000002;
        public static final int ACTION_VIEW_EDITOR_TEXT_SELECTED = 1000009;
        public static final int ACTION_CREATE_AND_START_INTERPRETER = 1004001;
        public static final int ACTION_MEDIA_COMBI_STATION_SELECTED = 1006001;
        public static final int ACTION_JOKER_KEY = 1007001;
    }

    public static class States {
        public static final int STATE_MEDIA_APP_UPDATE = 1004001;
        public static final int STATE_CREATE_AND_START_INTERPRETER_RESPONSE = 1004002;
        public static final int STATE_MEDIA_OPENMEDIA = 1005000;
        public static final int STATE_MEDIA_COMBI_UPDATE = 1006000;
        public static final int STATE_ONLINE_SDS_RECOGNITION_FINISHED = 1007000;
        public static final int STATE_TRIGGER_FOCUS = 1008000;
    }

    public static class Properties {
        public static final String PROPERTY_ONLINE_SPEECH_TYPE = "onlineSpeechType";
        public static final String PROPERTY_VIEW_EDITOR_CONTENT = "viewEditorContent";
        public static final String PROPERTY_VIDEO_LOADING_PROGESS = "loadingProgress";
    }
}

