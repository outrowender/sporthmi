/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.modelapi.ListRowData;

public interface DSIModelAPIListener
extends DSIListener {
    public void showScreen(int var1, boolean var2);

    public void showInfoScreen(int var1, boolean var2);

    public void showTrafficScreen(int var1, boolean var2);

    public void showPopup(int var1);

    public void removePopup();

    public void removeSinglePopup(int var1);

    public void setVisible(int var1, boolean var2);

    public void setLabel(int var1, String var2);

    public void setModelEnabled(int var1, boolean var2);

    public void setChoiceValue(int var1, int var2);

    public void setTextfield(int var1, String var2);

    public void setRangeLimits(int var1, int var2, int var3);

    public void setRangeValue(int var1, int var2);

    public void setText(int var1, String var2, String var3);

    public void setMatchSpellerData(int var1, String var2, String var3, String var4, boolean var5, int var6, boolean var7, int var8);

    public void setMatchCount(int var1, int var2);

    public void setMetricsInvalid(int var1);

    public void setMetricsValue(int var1, long var2);

    public void setListData(int var1, ListRowData[] var2);

    public void setSubListData(int var1, ListRowData[] var2, long var3);

    public void setSelected(int var1, long var2);

    public void setSlidingListData(int var1, long[] var2, ListRowData[] var3, boolean var4, boolean var5, int var6);

    public void setSlidingListDataWithInitialCursorPos(int var1, long[] var2, ListRowData[] var3, boolean var4, boolean var5, int var6, long var7);

    public void setSlidingSubListData(int var1, long[] var2, ListRowData[] var3, boolean var4, boolean var5, int var6, long var7);

    public void fillListBufferAtStart(int var1, long[] var2, ListRowData[] var3, boolean var4);

    public void fillListBufferAtEnd(int var1, long[] var2, ListRowData[] var3, boolean var4);

    public void setRGIData(int var1, short[] var2);

    public void fillSlidingListRow(int var1, ListRowData var2, long var3);

    public void setSlidingListSize(int var1, int var2);

    public void switchContext(int var1);

    public void validateCharactersResult(int var1, String var2, String var3);

    public void setModelPressed(int var1, boolean var2);

    public void showSetupScreen(int var1, boolean var2);

    public void showInfoSetupScreen(int var1, boolean var2);

    public void setFmtTime(int var1, int var2, int var3);

    public void setFmtDate(int var1, int var2, int var3, int var4);

    public void setFmtRTT(int var1, long var2);

    public void setFmtDistance(int var1, int var2);

    public void setFmtAltitude(int var1, int var2);

    public void setFmtRadioFrequency(int var1, int var2);

    public void setFmtOrientation(int var1, int var2);

    public void setFmtGeoCoordinatesLongitude(int var1, int var2, int var3, int var4);

    public void setFmtGeoCoordinatesLatitude(int var1, int var2, int var3, int var4);

    public void triggerSDComponent(int var1);

    public void setDynamicImage(int var1, ResourceLocator var2);

    public void setSDSDynamicValue(int var1, String var2);

    public void setSDSDynamicObjectID(int var1, String var2);

    public void getValidHanziCharsWindowResult(int var1, int var2, String var3, int var4);

    public void requestStateMachineControl();

    public void ddsHandled(boolean var1);
}

