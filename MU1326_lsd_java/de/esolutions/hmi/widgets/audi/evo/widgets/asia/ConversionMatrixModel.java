/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherWordPrediction;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModelUpdateHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixPreparationFinishedListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConversionMatrixModel
implements IConversionMatrixModel,
IConversionDataFetcherListener,
IPartialPopupListener {
    private static final int[] PARTIAL_POPUP_IDS_TO_LISTEN_FOR = new int[]{119};
    private List registeredSelectionHandlers = new ArrayList(1);
    private IConversionMatrixModelUpdateHandler updateHandler;
    private String currentUnconvertedCharacters;
    public IConversionDataFetcher conversionFetcher;
    private List conversionlist = Collections.EMPTY_LIST;
    private final LogChannel logChannel = IWidgetLogChannel.tpLogChannelInternal;
    private boolean isActive = false;
    private IConversionMatrixPreparationFinishedListener finishedListener;

    public void registerConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
        boolean bl = false;
        if (!this.registeredSelectionHandlers.isEmpty()) {
            int n = this.registeredSelectionHandlers.size();
            for (int i2 = 0; i2 < n; ++i2) {
                if (iConversionCandidateSelectionHandler != this.registeredSelectionHandlers.get(i2)) continue;
                bl = true;
                break;
            }
        }
        if (!bl) {
            this.registeredSelectionHandlers.add(iConversionCandidateSelectionHandler);
        }
    }

    public void unRegisterConversionCandidateSelectionHandler(IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler) {
        if (!this.registeredSelectionHandlers.isEmpty()) {
            int n = this.registeredSelectionHandlers.size();
            for (int i2 = 0; i2 < n; ++i2) {
                if (iConversionCandidateSelectionHandler != this.registeredSelectionHandlers.get(i2)) continue;
                this.registeredSelectionHandlers.remove(i2);
                break;
            }
        }
    }

    public void setUnconvertedCharacters(String string, IConversionMatrixPreparationFinishedListener iConversionMatrixPreparationFinishedListener) {
        this.finishedListener = iConversionMatrixPreparationFinishedListener;
        String string2 = this.currentUnconvertedCharacters;
        this.currentUnconvertedCharacters = string;
        if (this.conversionFetcher != null && (!StringUtilities.isNullOrEmpty(string) || this.conversionFetcher instanceof ConversionDataFetcherWordPrediction)) {
            char c2 = TouchControllerListenerFactory.calculateLastInputChar(string2, string);
            this.conversionFetcher.requestConversions(string, c2, 0, Integer.MAX_VALUE, false);
        }
    }

    public void setSelected(String string, int n) {
        if (this.updateHandler != null) {
            this.updateHandler.candidateSelected(string);
        }
        if (!this.registeredSelectionHandlers.isEmpty()) {
            Iterator iterator = this.registeredSelectionHandlers.iterator();
            while (iterator.hasNext()) {
                IConversionCandidateSelectionHandler iConversionCandidateSelectionHandler = (IConversionCandidateSelectionHandler)iterator.next();
                iConversionCandidateSelectionHandler.acceptConversionCandidateSelection(string, n);
            }
        }
    }

    public String getUnconvertedCharacters() {
        return this.currentUnconvertedCharacters;
    }

    public void setUpdateHandler(IConversionMatrixModelUpdateHandler iConversionMatrixModelUpdateHandler) {
        this.updateHandler = iConversionMatrixModelUpdateHandler;
    }

    public void handleMatrixKeyEvent(KeyEvent keyEvent) {
        if (null != this.registeredSelectionHandlers && !this.registeredSelectionHandlers.isEmpty()) {
            for (int i2 = 0; i2 < this.registeredSelectionHandlers.size(); ++i2) {
                ((IConversionCandidateSelectionHandler)this.registeredSelectionHandlers.get(i2)).acceptKeyEventInConversionMatrix(keyEvent);
            }
        }
    }

    public void setConversionDataFetcher(IConversionDataFetcher iConversionDataFetcher) {
        if (iConversionDataFetcher != null) {
            iConversionDataFetcher.registerConversionFetcherListener(this);
            this.conversionFetcher = iConversionDataFetcher;
        }
    }

    public void onConversionAvailableChange(String string, List list) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(10000000, "ConversionMatrixModel#onConversionAvailableChange rawInput = %1 UnconvertedCharacters = %2 conversion = %3", (Object)string, (Object)this.getUnconvertedCharacters(), (Object)list);
        }
        this.conversionlist = list;
        if (this.updateHandler != null && list != null) {
            this.updateHandler.sourceDataChanged(list);
        }
        if (null != this.finishedListener) {
            if (null != list && !list.isEmpty()) {
                this.finishedListener.matrixPreparationFinished();
            } else {
                this.finishedListener.keepCloseMatrix();
            }
            this.finishedListener = null;
        }
    }

    public void removeConversionMatrixPreparationFinishedListener() {
        this.finishedListener = null;
    }

    public void onNextValidCharactersChange(String string, String string2, String string3) {
    }

    public List getConversionData() {
        return Collections.unmodifiableList(this.conversionlist);
    }

    public void removeConversionFetcher(IConversionDataFetcher iConversionDataFetcher) {
        if (iConversionDataFetcher != null) {
            iConversionDataFetcher.unregisterConversionFetcherListener(this);
        }
        this.conversionFetcher = null;
    }

    public void partialPopupVisible(int n, int n2) {
        if (this.updateHandler != null) {
            this.updateHandler.onPopupVisibilityChange(true);
        }
    }

    public void partialPopupHidden(int n, int n2) {
        if (this.updateHandler != null) {
            this.updateHandler.onPopupVisibilityChange(false);
        }
    }

    public int[] getPPIDsForCallbacks() {
        return PARTIAL_POPUP_IDS_TO_LISTEN_FOR;
    }

    public void partialPopupRemoved(int n, int n2) {
    }

    public void setIsActivated(boolean bl) {
        this.isActive = bl;
    }

    public boolean isActivated() {
        return this.isActive;
    }

    public void unRegisterAllConversionCandidateSelectionHandler() {
        if (!this.registeredSelectionHandlers.isEmpty()) {
            this.registeredSelectionHandlers.clear();
        }
    }

    public void updateUnconvertedChars(String string) {
        this.currentUnconvertedCharacters = string;
    }

    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

