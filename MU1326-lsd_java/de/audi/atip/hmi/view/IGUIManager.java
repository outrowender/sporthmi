/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.hmi.event.MergeKZBAsyncEvent;
import de.audi.atip.hmi.event.PersonalPoiDatabaseUpdateEvent;

public interface IGUIManager {
    default public void draw() {
    }

    default public void swapBuffers() {
    }

    default public void readPixels(int[] nArray) {
    }

    default public void setUnsupportedDevelopmentBuild(boolean bl) {
    }

    default public void doErrorHandling(Exception exception, int n) {
    }

    default public boolean isDrawMissing() {
    }

    default public void setDrawMissing(boolean bl) {
    }

    default public void setMMICombiContextID(int n) {
    }

    default public void dumpGlyphCache(String string) {
    }

    default public void processEvent(EALMergeEvent eALMergeEvent) {
    }

    default public void processEvent(MergeKZBAsyncEvent mergeKZBAsyncEvent) {
    }

    default public void processEvent(PersonalPoiDatabaseUpdateEvent personalPoiDatabaseUpdateEvent) {
    }

    default public String getRAMStatus() {
    }

    default public String getVRAMStatus() {
    }

    default public boolean isPartialRenderingEnabled() {
    }

    default public boolean isOffscreenPartialRenderingEnabled() {
    }

    default public void setMainAreaMaterialProperties(boolean bl, float f2, float f3) {
    }

    default public int[] getImageHeaderInformation(String string) {
    }
}

