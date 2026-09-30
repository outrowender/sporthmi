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

    public void setUnconvertedCharacters(String var1, IConversionMatrixPreparationFinishedListener var2);

    public void setSelected(String var1, int var2);

    public String getUnconvertedCharacters();

    public void registerConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler var1);

    public void unRegisterConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler var1);

    public void setUpdateHandler(IConversionMatrixModelUpdateHandler var1);

    public void setConversionDataFetcher(IConversionDataFetcher var1);

    public void handleMatrixKeyEvent(KeyEvent var1);

    public List getConversionData();

    public void removeConversionFetcher(IConversionDataFetcher var1);

    public void setIsActivated(boolean var1);

    public boolean isActivated();
}

