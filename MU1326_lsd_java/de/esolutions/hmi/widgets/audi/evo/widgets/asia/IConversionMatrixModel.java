/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModelUpdateHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixPreparationFinishedListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.NullConversionMatrixModel;
import java.util.List;

public interface IConversionMatrixModel {
    public static final IConversionMatrixModel NULL = new NullConversionMatrixModel();

    default public void setUnconvertedCharacters(String string, IConversionMatrixPreparationFinishedListener iConversionMatrixPreparationFinishedListener) {
    }

    default public void setSelected(String string, int n) {
    }

    default public String getUnconvertedCharacters() {
    }

    default public void registerConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
    }

    default public void unRegisterConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
    }

    default public void setUpdateHandler(IConversionMatrixModelUpdateHandler iConversionMatrixModelUpdateHandler) {
    }

    default public void setConversionDataFetcher(IConversionDataFetcher iConversionDataFetcher) {
    }

    default public void handleMatrixKeyEvent(KeyEvent keyEvent) {
    }

    default public List getConversionData() {
    }

    default public void removeConversionFetcher(IConversionDataFetcher iConversionDataFetcher) {
    }

    default public void setIsActivated(boolean bl) {
    }

    default public boolean isActivated() {
    }
}

