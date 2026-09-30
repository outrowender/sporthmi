/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultVirtualButtonListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.tm.ITouchFlickGestureRecognitionListener;
import de.audi.tv.app.tm.ITouchpadHandler;
import de.audi.tv.app.tm.TouchFlickGestureRecognition;

public class TouchpadListener
extends DefaultVirtualButtonListener
implements ITouchFlickGestureRecognitionListener {
    private ITouchpadHandler defaultTPHandler = new ITouchpadHandler(){

        public short touchScreenReleased() {
            return -1;
        }

        public short touchScreenPressed() {
            return -1;
        }

        public short keyReleased() {
            return -1;
        }

        public short keyPressed() {
            return -1;
        }

        public short jsWest() {
            return -1;
        }

        public short jsSouth() {
            return -1;
        }

        public short jsNorth() {
            return -1;
        }

        public short jsEast() {
            return -1;
        }

        public short increment() {
            return -1;
        }

        public short decrement() {
            return -1;
        }
    };
    private short pressedKeypanelID = (short)-1;
    private final TVEnv env;
    private final DSIHandler dsi;
    private final TouchFlickGestureRecognition flickRecognizer;
    public final ITVEventListener eventListener = new TVEventDefaultListener(){

        public void onTerminalModeInputModeChange(int n) {
            if (n == 0) {
                TouchpadListener.this.releasePanelKey(TouchpadListener.this.pressedKeypanelID, 0);
            }
        }
    };
    private ITouchpadHandler tpHandler = this.defaultTPHandler;

    public TouchpadListener(TVEnv tVEnv, DSIHandler dSIHandler) {
        this.env = tVEnv;
        this.dsi = dSIHandler;
        this.flickRecognizer = new TouchFlickGestureRecognition(this);
        tVEnv.getVirtualButtonModelModel(2600106).setVirtualButtonListener(this);
    }

    public void registerTouchpadHandler(ITouchpadHandler iTouchpadHandler) {
        this.tpHandler = iTouchpadHandler == null ? this.defaultTPHandler : iTouchpadHandler;
    }

    public void stickIdle(int n, int n2) {
        if (this.pressedKeypanelID == -1) {
            this.env.lcHMI.log(10000000, "[TouchpadListener.stickIdle] IGNORED (already idle)");
            return;
        }
        this.env.lcHMI.log(10000000, "[TouchpadListener.stickIdle]");
        this.releasePanelKey(this.pressedKeypanelID, n2);
    }

    public void stickW(int n, int n2) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.stickW]");
        this.pressPanelKey(this.tpHandler.jsWest(), n2);
    }

    public void stickE(int n, int n2) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.stickE]");
        this.pressPanelKey(this.tpHandler.jsEast(), n2);
    }

    public void stickN(int n, int n2) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.stickN]");
        this.pressPanelKey(this.tpHandler.jsNorth(), n2);
    }

    public void stickS(int n, int n2) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.stickS]");
        this.pressPanelKey(this.tpHandler.jsSouth(), n2);
    }

    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.touchScreenPressed]");
        this.flickRecognizer.startMove();
    }

    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.touchScreenReleased]");
        this.flickRecognizer.stopMove();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.keyPressed]");
        this.pressPanelKey(this.tpHandler.keyPressed(), n3);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.keyReleased]");
        this.releasePanelKey(this.tpHandler.keyReleased(), n3);
    }

    public void increment(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.increment]");
        short s = this.tpHandler.increment();
        if (s != -1) {
            this.dsi.setTMTVKeyPanel(s, (short)1);
            this.dsi.setTMTVKeyPanel(s, (short)0);
        }
    }

    public void decrement(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.decrement]");
        short s = this.tpHandler.decrement();
        if (s != -1) {
            this.dsi.setTMTVKeyPanel(s, (short)1);
            this.dsi.setTMTVKeyPanel(s, (short)0);
        }
    }

    private void pressPanelKey(short s, int n) {
        if (s != -1) {
            if (s == -2) {
                this.env.getVirtualButtonModelModel(2600106).fireEvent(n);
            } else if (this.pressedKeypanelID == -1) {
                this.pressedKeypanelID = s;
                this.dsi.setTMTVKeyPanel(s, (short)1);
            } else {
                this.env.lcHMI.log(100000, "[TouchpadListener.pressPanelKey] unexpected button press: 0x%1, I wasn't idle", (long)s);
            }
        }
    }

    private void releasePanelKey(short s, int n) {
        if (s != -1) {
            if (s == -2) {
                this.env.getVirtualButtonModelModel(2600106).fireEvent(n);
            } else if (this.pressedKeypanelID == -1) {
                this.env.lcHMI.log(100000, "[TouchpadListener.releasePanelKey] unable to release key 0x%1 because it was not pressed!", (long)s);
            } else if (this.pressedKeypanelID == s) {
                this.pressedKeypanelID = (short)-1;
                this.dsi.setTMTVKeyPanel(s, (short)0);
            } else {
                this.env.lcHMI.log(100000, "[TouchpadListener.releasePanelKey] unexpected button release: 0x%1, should have been: 0x%2", (long)s, (long)this.pressedKeypanelID);
            }
        }
    }

    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        this.env.lcHMI.log(10000000, "[TouchpadListener.touchScreenMoved] startX = %1 startY = %2", (long)n2, (long)n3);
        this.env.lcHMI.log(10000000, "[TouchpadListener.touchScreenMoved] currentX = %1 currentY = %2", (long)n4, (long)n5);
        this.flickRecognizer.move(n2, n3, n4, n5);
    }

    public void flickUp() {
        this.env.lcHMI.log(10000000, "[TouchpadListener.flickUp]");
        this.pressPanelKey(this.tpHandler.jsSouth(), 0);
        this.releasePanelKey(this.tpHandler.jsSouth(), 0);
    }

    public void flickDown() {
        this.env.lcHMI.log(10000000, "[TouchpadListener.flickDown]");
        this.pressPanelKey(this.tpHandler.jsNorth(), 0);
        this.releasePanelKey(this.tpHandler.jsNorth(), 0);
    }

    public void flickLeft() {
        this.env.lcHMI.log(10000000, "[TouchpadListener.flickLeft]");
        this.pressPanelKey(this.tpHandler.jsEast(), 0);
        this.releasePanelKey(this.tpHandler.jsEast(), 0);
    }

    public void flickRight() {
        this.env.lcHMI.log(10000000, "[TouchpadListener.flickRight]");
        this.pressPanelKey(this.tpHandler.jsWest(), 0);
        this.releasePanelKey(this.tpHandler.jsWest(), 0);
    }

    public void tap() {
        this.pressPanelKey(this.tpHandler.touchScreenPressed(), 0);
        this.releasePanelKey(this.tpHandler.touchScreenReleased(), 0);
    }
}

