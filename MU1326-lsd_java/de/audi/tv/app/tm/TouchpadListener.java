/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultVirtualButtonListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.tm.ITouchFlickGestureRecognitionListener;
import de.audi.tv.app.tm.ITouchpadHandler;
import de.audi.tv.app.tm.TouchFlickGestureRecognition;
import de.audi.tv.app.tm.TouchpadListener$1;
import de.audi.tv.app.tm.TouchpadListener$2;

public class TouchpadListener
extends DefaultVirtualButtonListener
implements ITouchFlickGestureRecognitionListener {
    private ITouchpadHandler defaultTPHandler = new TouchpadListener$1(this);
    private short pressedKeypanelID = (short)-1;
    private final TVEnv env;
    private final DSIHandler dsi;
    private final TouchFlickGestureRecognition flickRecognizer;
    public final ITVEventListener eventListener = new TouchpadListener$2(this);
    private ITouchpadHandler tpHandler = this.defaultTPHandler;

    public TouchpadListener(TVEnv tVEnv, DSIHandler dSIHandler) {
        this.env = tVEnv;
        this.dsi = dSIHandler;
        this.flickRecognizer = new TouchFlickGestureRecognition(this);
        tVEnv.getVirtualButtonModelModel(-1431558400).setVirtualButtonListener(this);
    }

    public void registerTouchpadHandler(ITouchpadHandler iTouchpadHandler) {
        this.tpHandler = iTouchpadHandler == null ? this.defaultTPHandler : iTouchpadHandler;
    }

    @Override
    public void stickIdle(int n, int n2) {
        if (this.pressedKeypanelID == -1) {
            this.env.lcHMI.log(-2137614336, "[TouchpadListener.stickIdle] IGNORED (already idle)");
            return;
        }
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.stickIdle]");
        this.releasePanelKey(this.pressedKeypanelID, n2);
    }

    @Override
    public void stickW(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.stickW]");
        this.pressPanelKey(this.tpHandler.jsWest(), n2);
    }

    @Override
    public void stickE(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.stickE]");
        this.pressPanelKey(this.tpHandler.jsEast(), n2);
    }

    @Override
    public void stickN(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.stickN]");
        this.pressPanelKey(this.tpHandler.jsNorth(), n2);
    }

    @Override
    public void stickS(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.stickS]");
        this.pressPanelKey(this.tpHandler.jsSouth(), n2);
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.touchScreenPressed]");
        this.flickRecognizer.startMove();
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.touchScreenReleased]");
        this.flickRecognizer.stopMove();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.keyPressed]");
        this.pressPanelKey(this.tpHandler.keyPressed(), n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.keyReleased]");
        this.releasePanelKey(this.tpHandler.keyReleased(), n3);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.increment]");
        short s = this.tpHandler.increment();
        if (s != -1) {
            this.dsi.setTMTVKeyPanel(s, (short)1);
            this.dsi.setTMTVKeyPanel(s, (short)0);
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.decrement]");
        short s = this.tpHandler.decrement();
        if (s != -1) {
            this.dsi.setTMTVKeyPanel(s, (short)1);
            this.dsi.setTMTVKeyPanel(s, (short)0);
        }
    }

    private void pressPanelKey(short s, int n) {
        if (s != -1) {
            if (s == -2) {
                this.env.getVirtualButtonModelModel(-1431558400).fireEvent(n);
            } else if (this.pressedKeypanelID == -1) {
                this.pressedKeypanelID = s;
                this.dsi.setTMTVKeyPanel(s, (short)1);
            } else {
                this.env.lcHMI.log(-1601830656, "[TouchpadListener.pressPanelKey] unexpected button press: 0x%1, I wasn't idle", (long)s);
            }
        }
    }

    private void releasePanelKey(short s, int n) {
        if (s != -1) {
            if (s == -2) {
                this.env.getVirtualButtonModelModel(-1431558400).fireEvent(n);
            } else if (this.pressedKeypanelID == -1) {
                this.env.lcHMI.log(-1601830656, "[TouchpadListener.releasePanelKey] unable to release key 0x%1 because it was not pressed!", (long)s);
            } else if (this.pressedKeypanelID == s) {
                this.pressedKeypanelID = (short)-1;
                this.dsi.setTMTVKeyPanel(s, (short)0);
            } else {
                this.env.lcHMI.log(-1601830656, "[TouchpadListener.releasePanelKey] unexpected button release: 0x%1, should have been: 0x%2", (long)s, (long)this.pressedKeypanelID);
            }
        }
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.touchScreenMoved] startX = %1 startY = %2", (long)n2, (long)n3);
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.touchScreenMoved] currentX = %1 currentY = %2", (long)n4, (long)n5);
        this.flickRecognizer.move(n2, n3, n4, n5);
    }

    @Override
    public void flickUp() {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.flickUp]");
        this.pressPanelKey(this.tpHandler.jsSouth(), 0);
        this.releasePanelKey(this.tpHandler.jsSouth(), 0);
    }

    @Override
    public void flickDown() {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.flickDown]");
        this.pressPanelKey(this.tpHandler.jsNorth(), 0);
        this.releasePanelKey(this.tpHandler.jsNorth(), 0);
    }

    @Override
    public void flickLeft() {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.flickLeft]");
        this.pressPanelKey(this.tpHandler.jsEast(), 0);
        this.releasePanelKey(this.tpHandler.jsEast(), 0);
    }

    @Override
    public void flickRight() {
        this.env.lcHMI.log(-2137614336, "[TouchpadListener.flickRight]");
        this.pressPanelKey(this.tpHandler.jsWest(), 0);
        this.releasePanelKey(this.tpHandler.jsWest(), 0);
    }

    @Override
    public void tap() {
        this.pressPanelKey(this.tpHandler.touchScreenPressed(), 0);
        this.releasePanelKey(this.tpHandler.touchScreenReleased(), 0);
    }

    static /* synthetic */ short access$000(TouchpadListener touchpadListener) {
        return touchpadListener.pressedKeypanelID;
    }

    static /* synthetic */ void access$100(TouchpadListener touchpadListener, short s, int n) {
        touchpadListener.releasePanelKey(s, n);
    }
}

