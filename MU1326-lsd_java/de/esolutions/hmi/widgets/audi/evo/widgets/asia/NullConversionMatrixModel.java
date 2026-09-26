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
    @Override
    public void setUnconvertedCharacters(String string, IConversionMatrixPreparationFinishedListener iConversionMatrixPreparationFinishedListener) {
    }

    @Override
    public void setSelected(String string, int n) {
    }

    @Override
    public String getUnconvertedCharacters() {
        return "";
    }

    @Override
    public void registerConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
    }

    @Override
    public void unRegisterConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
    }

    @Override
    public void setUpdateHandler(IConversionMatrixModelUpdateHandler iConversionMatrixModelUpdateHandler) {
    }

    @Override
    public void setConversionDataFetcher(IConversionDataFetcher iConversionDataFetcher) {
    }

    @Override
    public void handleMatrixKeyEvent(KeyEvent keyEvent) {
    }

    @Override
    public List getConversionData() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void removeConversionFetcher(IConversionDataFetcher iConversionDataFetcher) {
    }

    @Override
    public void setIsActivated(boolean bl) {
    }

    @Override
    public boolean isActivated() {
        return false;
    }
}

