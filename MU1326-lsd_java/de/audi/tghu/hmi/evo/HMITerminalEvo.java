/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.IVisualFeedback;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.audi.tghu.hmi.evo.ILockingManager;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.IWidgetRegistry;
import de.audi.tghu.hmi.evo.PreloadManager;

public interface HMITerminalEvo
extends HMITerminal {
    public static final int SKIN_STANDARD;
    public static final int SKIN_SPORT;

    default public IKanziResourceLoader getKanziResourceLoader() {
    }

    default public IDrawerFocusManagerEvo getDrawerFocusManager() {
    }

    default public IDrawerConditionEngine getDrawerConditionEngine() {
    }

    default public IPresetInputHandler getPresetPopupHandler() {
    }

    default public IVisualFeedback getVisualFeedback() {
    }

    default public void setSkin(int n) {
    }

    default public int getSkin() {
    }

    default public void initializeViewSize(int n) {
    }

    default public void initializeDrawerViewSize() {
    }

    default public IWidgetRegistry getWidgetRegistryIf() {
    }

    default public PreloadManager getPreloadManager() {
    }

    default public ILockingManager getLockingManager() {
    }
}

