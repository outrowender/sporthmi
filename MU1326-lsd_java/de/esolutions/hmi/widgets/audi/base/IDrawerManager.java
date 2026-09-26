/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.view.IDrawerController;
import de.esolutions.hmi.widgets.audi.base.IContentChangeListener;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface IDrawerManager
extends IContentChangeListener {
    default public void activateSelectionDrawer(long l) {
    }

    default public void activateOptionDrawer(long l, long[] lArray) {
    }

    default public void activateEntertainmentDrawer() {
    }

    default public AbstractWidgetController getNewEntertainmentContent(int n) {
    }

    default public void activateEntertainmentDrawerContent(AbstractWidgetController abstractWidgetController) {
    }

    default public void startTrackingServices() {
    }

    default public int getBlackListedConnection() {
    }

    default public void notifyADCListeners(int n, int n2) {
    }

    default public void entertainmentDrawerClosed() {
    }

    default public void entertainmentDrawerOpened() {
    }

    default public IDrawerController getOptionDrawer(long l) {
    }

    default public void languageChanged() {
    }

    default public void clear() {
    }
}

