/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureViewerC {
    public void initializeViewer(int var1, int var2) throws MethodException;

    public void deinitializeViewer() throws MethodException;

    public void setSelectionMode(int var1) throws MethodException;

    public void startRendering() throws MethodException;

    public void stopRendering() throws MethodException;

    public void setScrollMode(int var1) throws MethodException;

    public void scrollTicks(long var1) throws MethodException;

    public void moveFocus(long var1, int var3) throws MethodException;

    public void getPictureInfo(long var1) throws MethodException;

    public void changeFolder(long var1) throws MethodException;

    public void togglePictureSelection(long var1) throws MethodException;

    public void toggleAllPicturesSelection() throws MethodException;

    public void clearAllPicturesSelection() throws MethodException;

    public void triggerAnimation(int var1, long var2) throws MethodException;

    public void setFilterSetId(int var1) throws MethodException;

    public void moveFocusByResourceLocator(ResourceLocator var1, int var2) throws MethodException;

    public void setSortingDirection(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

