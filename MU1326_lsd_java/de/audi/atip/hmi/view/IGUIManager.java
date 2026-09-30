/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.hmi.event.MergeKZBAsyncEvent;
import de.audi.atip.hmi.event.PersonalPoiDatabaseUpdateEvent;

public interface IGUIManager {
    public void draw();

    public void swapBuffers();

    public void readPixels(int[] var1);

    public void setUnsupportedDevelopmentBuild(boolean var1);

    public void doErrorHandling(Exception var1, int var2);

    public boolean isDrawMissing();

    public void setDrawMissing(boolean var1);

    public void setMMICombiContextID(int var1);

    public void dumpGlyphCache(String var1);

    public void processEvent(EALMergeEvent var1);

    public void processEvent(MergeKZBAsyncEvent var1);

    public void processEvent(PersonalPoiDatabaseUpdateEvent var1);

    public String getRAMStatus();

    public String getVRAMStatus();

    public boolean isPartialRenderingEnabled();

    public boolean isOffscreenPartialRenderingEnabled();

    public void setMainAreaMaterialProperties(boolean var1, float var2, float var3);

    public int[] getImageHeaderInformation(String var1);
}

