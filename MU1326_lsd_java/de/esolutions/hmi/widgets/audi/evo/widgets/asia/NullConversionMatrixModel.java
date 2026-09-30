/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModelUpdateHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixPreparationFinishedListener;
import java.util.Collections;
import java.util.List;

public class NullConversionMatrixModel
implements IConversionMatrixModel {
    public void setUnconvertedCharacters(String string, IConversionMatrixPreparationFinishedListener iConversionMatrixPreparationFinishedListener) {
    }

    public void setSelected(String string, int n) {
    }

    public String getUnconvertedCharacters() {
        return "";
    }

    public void registerConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
    }

    public void unRegisterConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
    }

    public void setUpdateHandler(IConversionMatrixModelUpdateHandler iConversionMatrixModelUpdateHandler) {
    }

    public void setConversionDataFetcher(IConversionDataFetcher iConversionDataFetcher) {
    }

    public void handleMatrixKeyEvent(KeyEvent keyEvent) {
    }

    public List getConversionData() {
        return Collections.EMPTY_LIST;
    }

    public void removeConversionFetcher(IConversionDataFetcher iConversionDataFetcher) {
    }

    public void setIsActivated(boolean bl) {
    }

    public boolean isActivated() {
        return false;
    }
}

