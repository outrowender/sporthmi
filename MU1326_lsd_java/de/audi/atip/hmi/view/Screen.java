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
    public static final int EVENTPROCESSING_DEFAULT;
    public static final int EVENTPROCESSING_HIDDEN;

    default public HMIView[] getViews() {
    }

    default public void setViews(int[] nArray, HMIView[][] hMIViewArray) {
    }

    default public void setReplacementWidgets(int[] nArray, HMIView[][] hMIViewArray) {
    }

    default public int[] getConditionIDs() {
    }

    default public int[] getReplacementIDs() {
    }

    default public HMIView[][] getReplacementWidgets() {
    }

    default public int getPriority() {
    }

    default public void disconnecting() {
    }

    default public void connected(IScreenData iScreenData) {
    }

    default public void updateContexts(long[] lArray) {
    }

    default public void updatedColorScheme(int n) {
    }

    default public int getID() {
    }

    default public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    default public void processSDSEvent(SDSEvent sDSEvent) {
    }

    default public void setTerminal(HMITerminal hMITerminal) {
    }

    default public void setState(int[] nArray) {
    }

    default public HMITerminal getTerminal() {
    }

    default public int getTerminalID() {
    }

    default public void setLocked(boolean bl) {
    }

    default public AbstractScreenFactory getScreenFactory() {
    }

    default public void paint() {
    }

    default public int getEventProcessing() {
    }

    default public int getCacheBehaviour() {
    }

    default public int getEventID(int n) {
    }

    default public void setModelIDs(int[] nArray) {
    }

    default public void setEventIDs(int[] nArray) {
    }

    default public boolean hasErrorOccured() {
    }

    default public int getScreenType() {
    }

    default public void setScreenType(int n) {
    }

    default public int[] getViewIDs() {
    }

    default public void showPartialPopups(int[] nArray) {
    }

    default public void hidePartialPopups(int[] nArray) {
    }

    default public void hideNotScreenChangeSurvivingPopups() {
    }

    default public void unitsChanged(UnitChangedEvent unitChangedEvent) {
    }

    default public void bitmapLoaded(AsyncBitmapEvent asyncBitmapEvent) {
    }

    default public boolean isPartialPopupBlocked(IPartialPopupController iPartialPopupController) {
    }

    default public boolean areAllPartialPopupsAllowed() {
    }

    default public boolean isConnected() {
    }

    default public int[] getCurrentColorPalette() {
    }
}

