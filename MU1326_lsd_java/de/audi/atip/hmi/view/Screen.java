/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.AsyncBitmapEvent;
import de.audi.atip.hmi.event.GestureEventListener;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.ProximityEventListener;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.TouchPadEventListener;
import de.audi.atip.hmi.event.UnitChangedEvent;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IScreenData;

public interface Screen
extends KeyListener,
TouchPadEventListener,
GestureEventListener,
ProximityEventListener {
    public static final int EVENTPROCESSING_DEFAULT = 0;
    public static final int EVENTPROCESSING_HIDDEN = 1;

    public HMIView[] getViews();

    public void setViews(int[] var1, HMIView[][] var2);

    public void setReplacementWidgets(int[] var1, HMIView[][] var2);

    public int[] getConditionIDs();

    public int[] getReplacementIDs();

    public HMIView[][] getReplacementWidgets();

    public int getPriority();

    public void disconnecting();

    public void connected(IScreenData var1);

    public void updateContexts(long[] var1);

    public void updatedColorScheme(int var1);

    public int getID();

    public void processModelUpdateEvent(ModelUpdateEvent var1);

    public void processSDSEvent(SDSEvent var1);

    public void setTerminal(HMITerminal var1);

    public void setState(int[] var1);

    public HMITerminal getTerminal();

    public int getTerminalID();

    public void setLocked(boolean var1);

    public AbstractScreenFactory getScreenFactory();

    public void paint();

    public int getEventProcessing();

    public int getCacheBehaviour();

    public int getEventID(int var1);

    public void setModelIDs(int[] var1);

    public void setEventIDs(int[] var1);

    public boolean hasErrorOccured();

    public int getScreenType();

    public void setScreenType(int var1);

    public int[] getViewIDs();

    public void showPartialPopups(int[] var1);

    public void hidePartialPopups(int[] var1);

    public void hideNotScreenChangeSurvivingPopups();

    public void unitsChanged(UnitChangedEvent var1);

    public void bitmapLoaded(AsyncBitmapEvent var1);

    public boolean isPartialPopupBlocked(IPartialPopupController var1);

    public boolean areAllPartialPopupsAllowed();

    public boolean isConnected();

    public int[] getCurrentColorPalette();
}

