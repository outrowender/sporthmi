/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.context;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.audio.AudioEnv;
import java.util.Arrays;

public class AudioDrawerContextImpl
implements AudioDrawerContext {
    private final AudioEnv env;
    private final ListModelApp listModel;
    private final int ROW_1;

    public AudioDrawerContextImpl(AudioEnv audioEnv) {
        this.ROW_1 = 0;
        this.env = audioEnv;
        this.listModel = audioEnv.getListModel(538);
        this.listModel.setMaxRows(1);
        this.listModel.setMaxColumns(23);
        Object[] objectArray = new ListCell[23];
        Arrays.fill(objectArray, LIST_CELL_INACTIVE);
        this.listModel.addRow((ListCell[])objectArray);
    }

    public void setContext(AudioDrawerContext.Source source, AudioDrawerContext.SourceAudioState sourceAudioState) {
        if (source == null || sourceAudioState == null) {
            this.env.lcMain.log(10000, "[AudioDrawerContextImpl.setContext] Illegal args! source:%1 state:%2", (Object)source, (Object)sourceAudioState);
            return;
        }
        this.env.lcMain.log(10000000, "[AudioDrawerContextImpl.setContext] %1 -> %2", (Object)source, (Object)sourceAudioState);
        this.updateListModel(source.getColumn(), sourceAudioState.getCell());
    }

    private void updateListModel(int n, IntegerListCell integerListCell) {
        if (n < 0 || n >= 23) {
            this.env.lcMain.log(10000, "[AudioDrawerContextImpl.updateListModel] Illegal args! column:%1 ", (long)n);
            return;
        }
        if (this.listModel.getCell(0, n) != integerListCell) {
            this.listModel.setCell(0, n, integerListCell);
        }
    }
}

