/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BrowserListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DynamicListModelListener;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.SlidingListModelListener;
import de.audi.atip.hmi.model.SpellerListenerAsia;
import de.audi.atip.hmi.model.TextEditorListener;
import de.audi.atip.hmi.model.TextEditorListenerDD;
import de.audi.atip.hmi.model.TooltipListener;
import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;

public class FallbackListener
implements SpellerListenerAsia,
RangeListener,
SlidingListModelListener,
DynamicListModelListener,
BrowserListener,
ListListener,
MatchSpellerListener,
MatchspellerListenerAsia,
MetricsListener,
TooltipListener,
ChoiceListener,
VirtualButtonListener,
TextEditorListener,
TextEditorListenerDD {
    TextEditorModelDDApp m_tem;

    public FallbackListener() {
        this.m_tem = null;
    }

    public FallbackListener(TextEditorModelDDApp textEditorModelDDApp) {
        this.m_tem = textEditorModelDDApp;
    }

    @Override
    public void tooltipDataRequested(int n, int n2, int n3, boolean bl, int n4) {
    }

    @Override
    public void tooltipDataRequested(int n, int n2, ListRow listRow, boolean bl, int n3) {
    }

    @Override
    public void tooltipHidden(int n, int n2, int n3) {
    }

    @Override
    public void tooltipVisible(int n, int n2, int n3) {
    }

    @Override
    public void metricsUpdated(int n, int n2) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    @Override
    public void moveE(int n, int n2, int n3) {
    }

    @Override
    public void moveMiddle(int n, int n2) {
    }

    @Override
    public void moveN(int n, int n2, int n3) {
    }

    @Override
    public void moveNE(int n, int n2, int n3) {
    }

    @Override
    public void moveNW(int n, int n2, int n3) {
    }

    @Override
    public void moveS(int n, int n2, int n3) {
    }

    @Override
    public void moveSE(int n, int n2, int n3) {
    }

    @Override
    public void moveSW(int n, int n2, int n3) {
    }

    @Override
    public void moveW(int n, int n2, int n3) {
    }

    @Override
    public void requestRowsAfter(int n, ListRow listRow, int n2, int n3) {
    }

    @Override
    public void requestRowsBefore(int n, ListRow listRow, int n2, int n3) {
    }

    @Override
    public void itemReleased(int n, ListRow listRow, int n2) {
    }

    @Override
    public void runningOutOfData(int n, ListRow listRow, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, ListRow listRow, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, ListRow listRow, int n2) {
    }

    @Override
    public void rebuildListFromEnd(int n, int n2) {
    }

    @Override
    public void rebuildListFromStart(int n, int n2) {
    }

    @Override
    public void scrollingActive(int n, boolean bl, int n2) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
    }

    @Override
    public void increment(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, String string2, int n2) {
    }

    @Override
    public void textChanged(int n, String string, String string2, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
    }

    @Override
    public void stickE(int n, int n2) {
    }

    @Override
    public void stickIdle(int n, int n2) {
    }

    @Override
    public void stickN(int n, int n2) {
    }

    @Override
    public void stickNE(int n, int n2) {
    }

    @Override
    public void stickNW(int n, int n2) {
    }

    @Override
    public void stickS(int n, int n2) {
    }

    @Override
    public void stickSE(int n, int n2) {
    }

    @Override
    public void stickSW(int n, int n2) {
    }

    @Override
    public void stickW(int n, int n2) {
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void touchPadReleased(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPressed(int n, int n2, int n3) {
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
    }

    @Override
    public void touchScreenRotate(int n, short s, int n2) {
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
    }

    @Override
    public void inputModeTPChanged(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3) {
    }

    @Override
    public void openAlternativesList(int n, int n2, int n3) {
    }

    @Override
    public void alternativeSelected(int n, int n2, int n3, int n4) {
    }

    @Override
    public void textChanged(int n, int n2, int n3, int n4) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void textChanged(int n, int n2, int n3) {
    }

    @Override
    public boolean alternativeSelected(boolean bl, int n, int n2, int n3) {
        if (this.m_tem != null) {
            this.m_tem.getSyncedModel().selectAlternative(n2);
        }
        return true;
    }

    @Override
    public void maxTextLengthChanged(int n) {
    }

    @Override
    public void strokesChanged(int n, int n2, String string, char c2) {
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
    }
}

