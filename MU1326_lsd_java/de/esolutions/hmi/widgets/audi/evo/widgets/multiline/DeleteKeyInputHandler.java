/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ITimer;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.TimerHandler;

public class DeleteKeyInputHandler {
    public static final int TIMER_IDX_DELAY_1 = 0;
    public static final int TIMER_IDX_DELAY_2 = 1;
    public static final int TIMER_IDX_REPAINT = 2;
    public static final int REPAINT_DELAY = 60;
    public static final int FIRST_DELAY = 800;
    public static final int SECOND_DELAY = 250;
    public static final int DELAY_CHANGE_PERCENT = 95;
    public static final int FINAL_DELAY = 60;
    public static final int WORD_DELAY_CONSTANT = 160;
    public static final int WORD_DELAY_PERCENT = 200;
    protected DoubleCursor m_cursor;
    protected boolean isFirstDelay = true;
    protected int m_currentDelay;
    protected int m_repeatDelay;
    protected boolean m_timersRunning = false;
    protected TimerHandler m_timerHandler = null;
    protected int[] m_timerDelays = new int[]{800, 250, 60};
    protected boolean[] m_timerResets = new boolean[]{false, false, false};
    protected ITimer[] timerOps = new ITimer[]{new ITimer(){

        public void onTimeout(int n) {
            if (DeleteKeyInputHandler.this.m_cursor.getCursorMode() == 1) {
                if (DeleteKeyInputHandler.this.repeatedDelete()) {
                    DeleteKeyInputHandler.this.m_timerHandler.enqueueTimer(1);
                }
            } else if (DeleteKeyInputHandler.this.repeatedDeleteWord()) {
                DeleteKeyInputHandler.this.m_timerHandler.enqueueTimer(1);
            }
        }

        public void onEnqueue(int n) {
        }

        public void onCancel(int n) {
        }
    }, new ITimer(){

        public void onTimeout(int n) {
            if (DeleteKeyInputHandler.this.m_cursor.getCursorMode() == 1) {
                if (DeleteKeyInputHandler.this.repeatedDelete()) {
                    DeleteKeyInputHandler.this.m_timerHandler.enqueueTimer(1);
                    DeleteKeyInputHandler.this.m_timerHandler.enqueueTimer(2);
                }
            } else if (DeleteKeyInputHandler.this.repeatedDeleteWord()) {
                DeleteKeyInputHandler.this.m_timerHandler.enqueueTimer(1);
            }
        }

        public void onEnqueue(int n) {
        }

        public void onCancel(int n) {
            DeleteKeyInputHandler.this.m_timerDelays[1] = 250;
        }
    }, new ITimer(){

        public void onTimeout(int n) {
            DeleteKeyInputHandler.this.m_ctrl.repaintWidgetOnHMIThread();
        }

        public void onEnqueue(int n) {
        }

        public void onCancel(int n) {
        }
    }};
    protected MultilineTextFieldController m_ctrl;

    public DeleteKeyInputHandler(DoubleCursor doubleCursor, EventDispatcher eventDispatcher, MultilineTextFieldController multilineTextFieldController) {
        this.m_cursor = doubleCursor;
        this.m_timerHandler = TimerHandler.newInstance(eventDispatcher, this.m_timerDelays, this.m_timerResets, this.timerOps);
        this.m_ctrl = multilineTextFieldController;
    }

    public void delete(boolean bl) {
        if (bl) {
            if (!this.m_timersRunning) {
                this.m_timersRunning = true;
                this.m_repeatDelay = 250;
                if (this.m_cursor.getCursorMode() == 1) {
                    if (this.firstDelete()) {
                        this.m_timerDelays[1] = 250;
                        this.m_timerHandler.enqueueTimer(0);
                    }
                } else if (this.firstDeleteWord()) {
                    this.m_timerDelays[1] = 250;
                    this.m_timerHandler.enqueueTimer(0);
                }
            }
        } else if (this.m_timersRunning) {
            this.m_timersRunning = false;
            this.m_timerHandler.cancelTimer(0);
            this.m_timerHandler.cancelTimer(1);
            this.m_timerDelays[1] = 250;
            this.m_timerHandler.enqueueTimer(2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean firstDelete() {
        boolean bl = false;
        try {
            if (this.m_cursor.mtxAquireLock()) {
                boolean bl2 = bl = this.m_cursor.currentCharIdx() != -1;
                if (bl) {
                    this.m_cursor.removeChar();
                    bl = this.m_cursor.currentCharIdx() != -1;
                    this.m_ctrl.repaintWidgetOnHMIThread();
                }
            } else {
                IWidgetLogChannel.tpLogChannelKeypanel.log(10000000, "DeleteKeyInputHandler#firstDelete(): lock could not acquire");
            }
        }
        finally {
            this.m_cursor.mtxReleaseLock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean firstDeleteWord() {
        boolean bl = false;
        try {
            if (this.m_cursor.mtxAquireLock()) {
                int[] nArray = this.m_cursor.currentWordIdx();
                if (nArray[0] != -1) {
                    boolean bl2 = MLUtils.getCharType(this.m_cursor.getCharArray()[nArray[0]]) != 1;
                    int[] nArray2 = this.m_cursor.removeWord();
                    if (nArray2[0] != -1 && bl2 && MLUtils.getCharType(this.m_cursor.getCharArray()[nArray2[0]]) == 0) {
                        this.m_cursor.remove(nArray2[0], nArray2[1], nArray2[0]);
                        nArray2 = this.m_cursor.currentWordIdx();
                    }
                    bl = nArray2[0] != -1;
                }
            } else {
                IWidgetLogChannel.tpLogChannelKeypanel.log(10000000, "DeleteKeyInputHandler#firstDeleteWord(): lock could not acquire");
            }
        }
        finally {
            this.m_cursor.mtxReleaseLock();
        }
        this.m_ctrl.repaintWidgetOnHMIThread();
        return bl;
    }

    private boolean repeatedDeleteWord() {
        boolean bl = this.firstDeleteWord();
        this.m_currentDelay = this.m_repeatDelay;
        this.m_repeatDelay = this.m_repeatDelay * 95 / 100;
        if (this.m_repeatDelay < 60) {
            this.m_repeatDelay = 60;
        }
        this.m_timerDelays[1] = this.m_currentDelay;
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean repeatedDelete() {
        boolean bl = false;
        try {
            if (this.m_cursor.mtxAquireLock()) {
                int n = this.m_cursor.currentCharIdx();
                boolean bl2 = bl = n != -1;
                if (bl) {
                    char c2 = this.m_cursor.getCharArray()[n];
                    this.m_cursor.removeChar();
                    int n2 = this.m_cursor.currentCharIdx();
                    boolean bl3 = bl = n2 != -1;
                    if (bl) {
                        char c3 = this.m_cursor.getCharArray()[n2];
                        boolean bl4 = this.isEndOfWord(c2, c3);
                        this.m_currentDelay = this.m_repeatDelay;
                        if (bl4) {
                            this.m_currentDelay = this.m_currentDelay * 200 / 100 + 160;
                        }
                        this.m_repeatDelay = this.m_repeatDelay * 95 / 100;
                        if (this.m_repeatDelay < 60) {
                            this.m_repeatDelay = 60;
                        }
                        this.m_timerDelays[1] = this.m_currentDelay;
                    }
                }
            } else {
                IWidgetLogChannel.tpLogChannelKeypanel.log(10000000, "DeleteKeyInputHandler#repeatedDelete(): lock could not acquire");
            }
        }
        finally {
            this.m_cursor.mtxReleaseLock();
        }
        return bl;
    }

    private boolean isEndOfWord(char c2, char c3) {
        return this.isWhitespace(c2) && !this.isWhitespace(c3) || this.isInterpunctation(c3) && !this.isWhitespace(c2) && !this.isInterpunctation(c2);
    }

    private boolean isWhitespace(char c2) {
        return MLUtils.getCharType(c2) == 0;
    }

    private boolean isInterpunctation(char c2) {
        return MLUtils.getCharType(c2) == 1;
    }
}

