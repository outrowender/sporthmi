/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.update;

import de.audi.atip.hmi.model.update.ModelUpdateData;

public class ModelTrigger
extends ModelUpdateData {
    public static final ModelTrigger JOIN_CURSOR = new ModelTrigger("TRIGGER_JOIN_CURSOR");
    public static final ModelTrigger JOIN_CURSOR_NO_SCROLLING = new ModelTrigger("TRIGGER_JOIN_CURSOR_NO_SCROLLING");
    public static final ModelTrigger OPEN_FOLDER = new ModelTrigger("TRIGGER_OPEN_FOLDER");
    public static final ModelTrigger CLOSE_FOLDER = new ModelTrigger("TRIGGER_CLOSE_FOLDER");
    public static final ModelTrigger CLOSE_SELECTION_DRAWER = new ModelTrigger("TRIGGER_CLOSE_SELECTION_DRAWER");
    public static final ModelTrigger ACTIVATE_MOVE_MODE = new ModelTrigger("ACTIVATE_MOVE_MODE");
    public static final ModelTrigger DEACTIVATE_MOVE_MODE = new ModelTrigger("DEACTIVATE_MOVE_MODE");
    public static final ModelTrigger RESET_CURSOR_POS = new ModelTrigger("RESET_CURSOR_POS");
    public static final ModelTrigger ACTIVATE_NOW_PLAYING = new ModelTrigger("ACTIVATE_NOW_PLAYING");
    public static final ModelTrigger TOGGLE_NOW_PLAYING = new ModelTrigger("TOGGLE_NOW_PLAYING");
    public static final ModelTrigger START_DRAG_OK = new ModelTrigger("START_DRAG_OK");
    public static final ModelTrigger START_DRAG_NOT_OK = new ModelTrigger("START_DRAG_NOT_OK");
    public static final ModelTrigger DROP_SUCCESSFUL = new ModelTrigger("DROP_SUCCESSFUL");
    public static final ModelTrigger DROP_FAILED = new ModelTrigger("DROP_FAILED");
    public static final ModelTrigger COVER_SYNC_COMPLETE = new ModelTrigger("COVER_SYNC_COMPLETE");

    private ModelTrigger(String string) {
        super(19);
        this.put(ModelUpdateData.Key.TRIGGER, string);
    }

    public String toString() {
        return this.get(ModelUpdateData.Key.TRIGGER).toString();
    }
}

