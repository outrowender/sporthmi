/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

import de.audi.atip.hmi.combi.AbstractCombiElement;
import de.audi.atip.hmi.combi.CombiCursorBarElement;
import de.audi.atip.hmi.combi.CombiIntegerElement;
import de.audi.atip.hmi.combi.CombiRGIElement;
import de.audi.atip.hmi.combi.CombiTextElement;
import de.audi.atip.hmi.combi.ddp2.CombiCompassElement;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiElementBankDDP2 {
    private static CombiElementBankDDP2 instance;
    private static volatile int numListElements;
    public static final int NUM_LIST_ELEMENTS_MAX = 12;
    private static final int NUM_LIST_FRAMES = 19;
    private static final int WINDOW_CACHING_NUM_WINDOWS = 3;
    private static volatile boolean windowCachingEnabled;
    private static volatile int windowCachingNumEntriesMenu;
    private static volatile int windowCachingNumEntriesSubmenu;
    private static volatile int windowCachingNumEntriesPopup;
    private CombiTextElement flagMedia;
    private CombiTextElement flagPhone;
    private CombiTextElement flagNavi;
    private CombiRGIElement rgiElement;
    private CombiIntegerElement distanceBar;
    private CombiIntegerElement distanceBarOffroad;
    private CombiTextElement navDistToManeuver;
    private CombiTextElement navDistToDestination;
    private CombiTextElement navBordComputer;
    private CombiRGIElement exitView;
    private CombiCompassElement compass;
    private CombiRGIElement laneGuidance;
    private CombiRGIElement trafficSign;
    private CombiTextElement trafficSignText;
    private CombiTextElement trafficSignRestriction;
    private CombiCursorBarElement[] cursorBarElements;
    private CombiIntegerElement[] listOffsets;
    private CombiTextElement[] listHeaders;
    private CombiTextElement[][] listElements;
    private int[] menuStarts;

    private CombiElementBankDDP2() {
        this.initialize();
    }

    private void initialize() {
        this.flagMedia = new CombiTextElement();
        this.flagPhone = new CombiTextElement();
        this.flagNavi = new CombiTextElement();
        this.rgiElement = new CombiRGIElement();
        this.distanceBar = new CombiIntegerElement();
        this.distanceBarOffroad = new CombiIntegerElement();
        this.navDistToManeuver = new CombiTextElement();
        this.navDistToDestination = new CombiTextElement();
        this.navBordComputer = new CombiTextElement();
        this.exitView = new CombiRGIElement();
        this.compass = new CombiCompassElement();
        this.laneGuidance = new CombiRGIElement();
        this.trafficSign = new CombiRGIElement();
        this.trafficSignText = new CombiTextElement();
        this.trafficSignRestriction = new CombiTextElement();
        if (this.listOffsets == null) {
            this.listOffsets = new CombiIntegerElement[19];
        }
        if (this.listHeaders == null) {
            this.listHeaders = new CombiTextElement[19];
        }
        if (this.cursorBarElements == null) {
            this.cursorBarElements = new CombiCursorBarElement[19];
        }
        if (this.listElements == null) {
            this.listElements = new CombiTextElement[12][19];
        }
        for (int i2 = 0; i2 < 19; ++i2) {
            this.listOffsets[i2] = new CombiIntegerElement();
            this.listHeaders[i2] = new CombiTextElement();
            this.cursorBarElements[i2] = new CombiCursorBarElement();
            for (int i3 = 0; i3 < 12; ++i3) {
                this.listElements[i3][i2] = new CombiTextElement();
            }
        }
        this.menuStarts = new int[19];
    }

    public void reInitAllElements() {
        this.initialize();
    }

    public static synchronized CombiElementBankDDP2 getInstance() {
        if (instance == null) {
            instance = new CombiElementBankDDP2();
        }
        return instance;
    }

    public int size() {
        return 31;
    }

    public AbstractCombiElement getCombiElementAt(int n, int n2) {
        switch (n) {
            case 0: {
                return this.flagMedia;
            }
            case 1: {
                return this.flagPhone;
            }
            case 2: {
                return this.flagNavi;
            }
            case 3: {
                return this.navDistToManeuver;
            }
            case 4: {
                return this.navDistToDestination;
            }
            case 5: {
                return this.navBordComputer;
            }
            case 19: {
                return this.rgiElement;
            }
            case 20: {
                return this.distanceBar;
            }
            case 21: {
                return this.cursorBarElements[n2];
            }
            case 22: {
                return this.exitView;
            }
            case 23: {
                return this.compass;
            }
            case 24: {
                return this.distanceBarOffroad;
            }
            case 25: {
                return this.laneGuidance;
            }
            case 26: {
                return this.trafficSign;
            }
            case 27: {
                return this.trafficSignText;
            }
            case 28: {
                return this.trafficSignRestriction;
            }
            case 29: {
                return this.listOffsets[n2];
            }
        }
        return this.getTextElementAt(n, n2);
    }

    public CombiTextElement getFlag(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 15: {
                return this.flagMedia;
            }
            case 4: 
            case 5: 
            case 6: {
                return this.flagPhone;
            }
            case 0: 
            case 1: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return this.flagNavi;
            }
        }
        return this.flagMedia;
    }

    public CombiTextElement getTextElementAt(int n, int n2) {
        return this.getTextElementAt(n, n2, windowCachingEnabled);
    }

    public CombiTextElement getTextElementAt(int n, int n2, boolean bl) {
        if (bl && this.isListFrame(n2) && n >= 7 && n <= 18) {
            n = this.getListElementIDForPosition(n, n2);
        }
        switch (n) {
            case 3: {
                return this.navDistToManeuver;
            }
            case 4: {
                return this.navDistToDestination;
            }
            case 0: {
                return this.flagMedia;
            }
            case 1: {
                return this.flagPhone;
            }
            case 2: {
                return this.flagNavi;
            }
            case 5: {
                return this.navBordComputer;
            }
            case 27: {
                return this.trafficSignText;
            }
            case 28: {
                return this.trafficSignRestriction;
            }
            case 6: {
                return this.listHeaders[n2];
            }
            case 7: {
                return this.listElements[0][n2];
            }
            case 8: {
                return this.listElements[1][n2];
            }
            case 9: {
                return this.listElements[2][n2];
            }
            case 10: {
                return this.listElements[3][n2];
            }
            case 11: {
                return this.listElements[4][n2];
            }
            case 12: {
                return this.listElements[5][n2];
            }
            case 13: {
                return this.listElements[6][n2];
            }
            case 14: {
                return this.listElements[7][n2];
            }
            case 15: {
                return this.listElements[8][n2];
            }
            case 16: {
                return this.listElements[9][n2];
            }
            case 17: {
                return this.listElements[10][n2];
            }
            case 18: {
                return this.listElements[11][n2];
            }
        }
        System.err.println("CombiElementBank.getTextElementAt - Invalid logical ID: " + n);
        return null;
    }

    private boolean isListFrame(int n) {
        return n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 0 || n == 1;
    }

    private int getListElementIDForPosition(int n, int n2) {
        int n3 = n;
        n3 -= 7;
        n3 = (this.menuStarts[n2] % numListElements + n3) % numListElements;
        return n3 += 7;
    }

    public CombiCompassElement getCompassElement() {
        return this.compass;
    }

    public CombiRGIElement getRGIElement() {
        return this.rgiElement;
    }

    public CombiIntegerElement getIntegerElementAt(int n, int n2) {
        switch (n) {
            case 20: {
                return this.distanceBar;
            }
            case 24: {
                return this.distanceBarOffroad;
            }
            case 29: {
                return this.listOffsets[n2];
            }
        }
        System.err.println("CombiElementBank.getIntegerElementAt - Invalid logical ID: " + n);
        return null;
    }

    public CombiCursorBarElement getCursorBarElement(int n) {
        return this.cursorBarElements[n];
    }

    public void resetCombiElements(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 15: 
            case 16: 
            case 17: {
                this.resetListFrame(n);
                break;
            }
            case 9: {
                this.flagMedia.reset();
                this.flagNavi.reset();
                this.flagPhone.reset();
                break;
            }
            case 10: {
                this.rgiElement.reset();
                this.distanceBar.reset();
                this.navDistToManeuver.reset();
                this.navDistToDestination.reset();
                this.navBordComputer.reset();
                break;
            }
            case 11: {
                this.exitView.reset();
                this.rgiElement.reset();
                this.distanceBar.reset();
                this.navDistToManeuver.reset();
                this.navDistToDestination.reset();
                this.navBordComputer.reset();
                break;
            }
            case 12: {
                this.compass.reset();
                this.distanceBar.reset();
                this.distanceBarOffroad.reset();
                this.navDistToManeuver.reset();
                this.navDistToDestination.reset();
                this.navBordComputer.reset();
                break;
            }
            case 13: {
                this.laneGuidance.reset();
                break;
            }
            case 14: {
                this.trafficSign.reset();
                this.trafficSignText.reset();
                this.trafficSignRestriction.reset();
                break;
            }
        }
    }

    private void resetListFrame(int n) {
        this.cursorBarElements[n].reset();
        this.listOffsets[n].reset();
        this.listHeaders[n].reset();
        for (int i2 = 0; i2 < 12; ++i2) {
            this.listElements[i2][n].reset();
        }
    }

    public void invalidateListFrame(int n) {
        this.cursorBarElements[n].dirty = false;
        this.listOffsets[n].dirty = false;
        this.listHeaders[n].setText(null);
        this.listHeaders[n].dirty = false;
        for (int i2 = 0; i2 < 12; ++i2) {
            this.listElements[i2][n].setText(null);
            this.listElements[i2][n].dirty = false;
        }
    }

    private boolean isListFrameDirty(int n) {
        boolean bl = false;
        bl |= this.cursorBarElements[n].dirty;
        bl |= this.listOffsets[n].dirty;
        bl |= this.listHeaders[n].dirty;
        for (int i2 = 0; i2 < 12; ++i2) {
            bl |= this.listElements[i2][n].dirty;
        }
        return bl;
    }

    private void logListFrame(LogChannel logChannel, int n, int n2) {
        logChannel.log(n2, "CombiElementBankDDP2#logListFrame log dirty elements for frame: %1", (long)n);
        if (this.listOffsets[n].dirty) {
            logChannel.log(n2, "CombiElementBankDDP2#logListFrame listOffsets %1", (Object)this.listOffsets[n]);
        }
        if (this.listHeaders[n].dirty) {
            logChannel.log(n2, "CombiElementBankDDP2#logListFrame listHeader (subtitle) %1", (Object)this.listHeaders[n]);
        }
        for (int i2 = 0; i2 < numListElements; ++i2) {
            if (!this.listElements[i2][n].dirty) continue;
            logChannel.log(n2, "CombiElementBankDDP2#logListFrame listElements%1 %2", (Object)String.valueOf(i2 + 1), (Object)this.listElements[i2][n]);
        }
        if (this.cursorBarElements[n].dirty) {
            logChannel.log(n2, "CombiElementBankDDP2#logListFrame cursorBarElement: %1", (Object)this.cursorBarElements[n]);
        }
    }

    public void invalidateAllCombiElements() {
        this.flagMedia.dirty = false;
        this.flagPhone.dirty = false;
        this.flagNavi.dirty = false;
        this.rgiElement.dirty = false;
        this.distanceBar.dirty = false;
        this.distanceBarOffroad.dirty = false;
        this.navDistToManeuver.dirty = false;
        this.navDistToDestination.dirty = false;
        this.navBordComputer.dirty = false;
        this.exitView.dirty = false;
        this.compass.dirty = false;
        this.laneGuidance.dirty = false;
        this.trafficSign.dirty = false;
        this.trafficSignText.dirty = false;
        this.trafficSignRestriction.dirty = false;
        for (int i2 = 0; i2 < 19; ++i2) {
            this.invalidateListFrame(i2);
        }
    }

    public boolean containsDirtyCombiElements() {
        boolean bl = false;
        bl |= this.flagMedia.dirty;
        bl |= this.flagPhone.dirty;
        bl |= this.flagNavi.dirty;
        bl |= this.rgiElement.dirty;
        bl |= this.distanceBar.dirty;
        bl |= this.distanceBarOffroad.dirty;
        bl |= this.navDistToManeuver.dirty;
        bl |= this.navDistToDestination.dirty;
        bl |= this.navBordComputer.dirty;
        bl |= this.exitView.dirty;
        bl |= this.compass.dirty;
        bl |= this.laneGuidance.dirty;
        bl |= this.trafficSign.dirty;
        bl |= this.trafficSignText.dirty;
        bl |= this.trafficSignRestriction.dirty;
        for (int i2 = 0; i2 < 19; ++i2) {
            bl |= this.isListFrameDirty(i2);
        }
        return bl;
    }

    public void logDirtyElements(LogChannel logChannel, int n) {
        logChannel.log(n, "CombiElementBankDDP2#logDirtyElements starting");
        if (this.rgiElement.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements rgiElement: %1", (Object)this.rgiElement);
        }
        if (this.navDistToManeuver.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements navDistToManeuver: %1", (Object)this.navDistToManeuver);
        }
        if (this.navDistToDestination.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements navDistToDestination: %1", (Object)this.navDistToDestination);
        }
        if (this.distanceBar.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements distanceBar: %1", (Object)this.distanceBar);
        }
        if (this.flagMedia.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements flagMedia: %1", (Object)this.flagMedia);
        }
        if (this.flagPhone.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements flagPhone: %1", (Object)this.flagPhone);
        }
        if (this.flagNavi.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements flagNavi: %1", (Object)this.flagNavi);
        }
        if (this.distanceBarOffroad.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements distanceBarOffroad: %1", (Object)this.distanceBarOffroad);
        }
        if (this.navBordComputer.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements navBordComputer: %1", (Object)this.navBordComputer);
        }
        if (this.exitView.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements exitView: %1", (Object)this.exitView);
        }
        if (this.compass.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements compass: %1", (Object)this.compass);
        }
        if (this.laneGuidance.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements laneGuidance: %1", (Object)this.laneGuidance);
        }
        if (this.trafficSign.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements trafficSign: %1", (Object)this.trafficSign);
        }
        if (this.trafficSignText.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements trafficSignText: %1", (Object)this.trafficSignText);
        }
        if (this.trafficSignRestriction.dirty) {
            logChannel.log(n, "CombiElementBankDDP2#logDirtyElements trafficSignRestriction: %1", (Object)this.trafficSignRestriction);
        }
        for (int i2 = 0; i2 <= 7; ++i2) {
            if (!this.isListFrameDirty(i2)) continue;
            this.logListFrame(logChannel, i2, n);
        }
    }

    public String toString() {
        return this.dumpContent();
    }

    private String dumpContent() {
        Buffer buffer = new Buffer(500);
        buffer.append("STATUS:").append("\n");
        buffer.append("status media: ").append(this.flagMedia.text).append("\t dirty: ").append(this.flagMedia.dirty).append("\n");
        buffer.append("status phone: ").append(this.flagPhone.text).append("\t dirty: ").append(this.flagPhone.dirty).append("\n");
        buffer.append("status navi: ").append(this.flagNavi.text).append("\t dirty: ").append(this.flagNavi.dirty).append("\n");
        buffer.append("\n");
        buffer.append("NAVI:").append("\n");
        buffer.append("compass: ").append(this.compass.toString()).append("\t dirty: ").append(this.compass.dirty).append("\n");
        buffer.append("rgiElement: ").append(this.rgiElement.rgiStream).append("\t dirty: ").append(this.rgiElement.dirty).append("\n");
        buffer.append("navBordComputerRoll: ").append(this.navBordComputer.text).append("\t dirty: ").append(this.navBordComputer.dirty).append("\n");
        buffer.append("navDistToManeuver: ").append(this.navDistToManeuver.text).append("\t dirty: ").append(this.navDistToManeuver.dirty).append("\n");
        buffer.append("navDistToDestination: ").append(this.navDistToDestination.text).append("\t dirty: ").append(this.navDistToDestination.dirty).append("\n");
        buffer.append("navDistanceBar: ").append(this.distanceBar.value).append("\t dirty: ").append(this.distanceBar.dirty).append("\n");
        buffer.append("navDistanceBarOffroad: ").append(this.distanceBarOffroad.value).append("\t dirty: ").append(this.distanceBarOffroad.dirty).append("\n");
        buffer.append("navTimeToArrival: see status navi");
        buffer.append("\n\n");
        buffer.append("MEDIA - ").append(this.dumpListContent(2));
        buffer.append("MEDIA_CONTEXT - ").append(this.dumpListContent(3));
        buffer.append("PHONE - ").append(this.dumpListContent(4));
        buffer.append("PHONE_CONTEXT - ").append(this.dumpListContent(5));
        buffer.append("PHONE_POPUP - ").append(this.dumpListContent(6));
        buffer.append("NAVIGATION_CONTEXT - ").append(this.dumpListContent(1));
        return buffer.toString();
    }

    public String dumpListContent(int n) {
        Buffer buffer = new Buffer(500);
        buffer.append("LIST: ").append("\n");
        buffer.append("cursorBarElement: ").append(this.cursorBarElements[n].toString()).append("\t dirty: ").append(this.cursorBarElements[n].dirty).append("\n");
        buffer.append("listHeader: ").append(this.listHeaders[n].text).append("\t dirty: ").append(this.listHeaders[n].dirty).append("\n");
        for (int i2 = 0; i2 < 12; ++i2) {
            buffer.append("listElement").append(i2).append(": ");
            buffer.append(this.listElements[i2][n].text).append("\t dirty: ").append(this.listElements[i2][n].dirty).append("\n");
        }
        buffer.append("\n");
        return buffer.toString();
    }

    public int getMenuStart(int n) {
        return this.menuStarts[n];
    }

    public void setMenuStart(int n, int n2) {
        this.menuStarts[n2] = n;
    }

    public static void setWindowCachingParameters(boolean bl, int n, int n2, int n3) {
        windowCachingEnabled = bl;
        windowCachingNumEntriesMenu = n <= 0 ? 4 : n;
        windowCachingNumEntriesSubmenu = n2 <= 0 ? 4 : n2;
        windowCachingNumEntriesPopup = n3 <= 0 ? 4 : n3;
        numListElements = windowCachingEnabled ? windowCachingNumEntriesMenu * 3 : windowCachingNumEntriesMenu;
    }

    public static boolean isWindowCachingEnabled() {
        return windowCachingEnabled;
    }

    public static int getWindowCachingNumListElements() {
        return numListElements;
    }

    public static int getWindowCachingNumEntriesMenu() {
        return windowCachingNumEntriesMenu;
    }

    public static int getWindowCachingNumEntriesSubmenu() {
        return windowCachingNumEntriesSubmenu;
    }

    public static int getWindowCachingNumEntriesPopup() {
        return windowCachingNumEntriesPopup;
    }

    static {
        numListElements = 12;
        windowCachingEnabled = true;
        windowCachingNumEntriesMenu = 4;
        windowCachingNumEntriesSubmenu = 4;
        windowCachingNumEntriesPopup = 4;
    }
}

