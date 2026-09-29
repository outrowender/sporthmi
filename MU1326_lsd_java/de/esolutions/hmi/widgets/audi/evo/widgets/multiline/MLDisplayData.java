/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.GhostCursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.IMLDimensions;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MultilineString$ArrList;

public class MLDisplayData {
    public static final int DEFAULT_MAX_PROCESSED_CHARS;
    public static final int STATE_PART_INVALID;
    public static final int STATE_FULLY_INVALID;
    public static final int STATE_FINISH;
    public static final int STATE_NEXT;
    public static final int STATE_POP_NEW_LINE;
    public static final int STATE_POP_SOFTBREAK;
    public static final int STATE_POP_HARDBREAK;
    public static final int NO_STATE;
    public DoubleCursor cursor = null;
    public IMLDimensions dims = null;
    public int maxLineWidth = 0;
    public int currentFlowState = 1;
    public short[] word = null;
    public int wordWidth = 0;
    public short lowBound = (short)-1;
    public int currentLineIdx = 0;
    public short lineStartIdx = 0;
    public int lineWidth = 0;
    public int cursorPosition = 0;
    public int processedChars = 0;
    public int maxProcessedChars = 100;
    public MultilineString$ArrList charMetaData = null;
    public MultilineString$ArrList sCharLines = null;
    public GhostCursor ghostCursor = null;
    public boolean needsRendering = true;
    public boolean linesNeedRepos = false;

    public void initInput(DoubleCursor doubleCursor, IMLDimensions iMLDimensions, int n) {
        this.cursor = doubleCursor;
        doubleCursor.setCursorPos(0);
        this.dims = iMLDimensions;
        this.maxLineWidth = iMLDimensions.getLineWidth();
        this.maxProcessedChars = n;
    }

    public void initStateDependentVars() {
        this.word = null;
        this.wordWidth = -1;
        this.lowBound = (short)-1;
        this.currentLineIdx = 0;
        this.lineStartIdx = 0;
        this.lineWidth = 0;
        this.cursorPosition = 0;
        this.processedChars = 0;
        this.setNeedsRendering(true);
        this.setLinesNeedRepos(false);
    }

    public void initOutput() {
        this.charMetaData = new MultilineString$ArrList(this.cursor != null && this.cursor.getCharArray() != null ? this.cursor.getCharArray().length : 100);
        this.sCharLines = new MultilineString$ArrList();
        this.ghostCursor = new GhostCursor(this.cursor, this);
    }

    public void setNeedsRendering(boolean bl) {
        this.needsRendering = bl;
    }

    public void setLinesNeedRepos(boolean bl) {
        this.linesNeedRepos = bl;
    }
}

