/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.IStatistics;
import de.esolutions.hmi.widgets.audi.base.AbstractImageLoader;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EALStatistics
implements IStatistics {
    private static final String TEXT_NO_OF_LRU_DYNAMIC_IMAGES = "No of lru dynamic images";
    private static final String TEXT_NO_OF_LRU_GUIDE_IMAGES = "No of lru guide images";
    private static final String TEXT_FONT_MEMORY_USAGE = "Font memory usage";
    private static final String TEXT_LRU_CACHES = "LRU Caches";
    private static final String TEXT_STATISTIC_MEMORY_USAGE = "Memory Usage";
    private static final boolean COMBI_AVAILABLE = Boolean.getBoolean("showCombi");
    private static final boolean SHOW_MEMORY_USAGE_DETAILS = Boolean.getBoolean("showMemUsageDetail");
    private static final int BORDER_X = 320;
    private static final int BORDER_TOP = 100;
    private static final int FONT_SIZE = 11;
    private IWrappedFont font;
    private final EALManager ealManager;
    private final HMITerminalImpl terminal;
    private boolean initialized;
    private Slot[] slots;
    private List slotList;
    private int displayWidth;
    private int displayHeight;
    private int gridSizeX;
    private int gridSizeY;
    private int rowHeight;
    private int offsetX;
    private int offsetY;
    private int[] slotWidths;
    private int[] slotHeights;
    private int rows;

    public EALStatistics(EALManager eALManager, HMITerminalImpl hMITerminalImpl) {
        this.ealManager = eALManager;
        this.terminal = hMITerminalImpl;
    }

    public void showStatistics(int n, String[] stringArray, boolean bl) {
        if (!this.initialized) {
            this.initialize();
        }
        if (stringArray == null) {
            this.removeSlot(n);
            return;
        }
        Slot slot = this.getSlot(n);
        slot.setInfo(stringArray);
        this.relayoutSlots();
    }

    private void removeSlot(int n) {
        Slot slot = this.slots[n];
        if (slot == null) {
            return;
        }
        slot.remove();
        this.slots[n] = null;
        this.slotList.remove(slot);
        this.relayoutSlots();
    }

    private void relayoutSlots() {
        int n = this.slotList.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Slot slot = (Slot)this.slotList.get(i2);
            this.calculateSlots(i2);
            int n2 = this.getSlotPositionX(i2);
            int n3 = this.getSlotPositionY(i2);
            slot.setPosition(n2, n3);
        }
    }

    private Slot getSlot(int n) {
        Slot slot;
        Slot slot2 = this.slots[n];
        if (slot2 != null) {
            return slot2;
        }
        this.slots[n] = slot = this.createSlot(n);
        this.slotList.add(slot);
        this.relayoutSlots();
        return slot;
    }

    private Slot createSlot(int n) {
        return new Slot();
    }

    private int getSlotPositionY(int n) {
        if (this.rows > 0 && n >= this.rows) {
            return this.slotHeights[n] * 10 + this.offsetY;
        }
        return this.offsetY;
    }

    private int getSlotPositionX(int n) {
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            n3 = n >= 1 ? (n2 += this.slotWidths[i2]) * 7 : 0;
            if (this.slotWidths.length - 1 < i2 || (n2 + this.slotWidths[i2 + 1]) * 7 > this.displayWidth) {
                n3 = 0;
                this.rows = n;
                continue;
            }
            this.rows = 0;
        }
        return n3 + this.offsetX;
    }

    private void calculateSlots(int n) {
        Slot slot;
        int n2 = 0;
        int n3 = 0;
        if (this.slotList.size() > 0 && (slot = (Slot)this.slotList.get(n)).textNodes != null) {
            Iterator iterator = slot.textNodes.iterator();
            while (iterator.hasNext()) {
                IWrappedNode3DText iWrappedNode3DText = (IWrappedNode3DText)iterator.next();
                ++n3;
                int n4 = iWrappedNode3DText.getText().length();
                if (n2 >= n4) continue;
                n2 = n4;
            }
        }
        this.slotWidths[n] = n2;
        this.slotHeights[n] = n3;
    }

    private void initialize() {
        this.slots = new Slot[23];
        this.slotList = new ArrayList(23);
        this.gridSizeY = this.gridSizeX = (int)Math.ceil(Math.sqrt(23.0));
        this.font = this.getStatisticFont();
        this.rowHeight = 13;
        this.displayWidth = this.terminal.getLayout().getDistance(1);
        this.displayHeight = this.terminal.getLayout().getDistance(2);
        if (this.displayWidth == 1440) {
            this.displayWidth -= 640;
            this.displayHeight -= 100;
            this.offsetX = 320;
            this.offsetY = 100;
        }
        this.initialized = true;
        this.slotWidths = new int[23];
        this.slotHeights = new int[23];
    }

    private IWrappedFont getStatisticFont() {
        return (IWrappedFont)this.terminal.getFontLoader().getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 11);
    }

    public void showStatistics(int n, boolean bl) {
        String[] stringArray;
        switch (n) {
            case 0: {
                stringArray = this.getInfoMemoryUsage();
                break;
            }
            case 1: {
                stringArray = this.getInfoEventQueue();
                break;
            }
            case 3: {
                stringArray = this.getScreenInfo();
                break;
            }
            case 7: {
                stringArray = this.getDrawTime();
                break;
            }
            default: {
                stringArray = new String[]{new StringBuffer().append("No statistics for type: ").append(n).toString()};
            }
        }
        this.showStatistics(n, stringArray, bl);
    }

    private String[] getInfoMemoryUsage() {
        String[] stringArray = SHOW_MEMORY_USAGE_DETAILS ? new String[]{TEXT_STATISTIC_MEMORY_USAGE, this.ealManager.getRAMStatus(), this.ealManager.getVRAMStatus(), TEXT_NO_OF_LRU_GUIDE_IMAGES, String.valueOf(((AbstractImageLoader)this.terminal.getImageLoader()).getNoOfCachedGUIDEImages()), TEXT_NO_OF_LRU_DYNAMIC_IMAGES, String.valueOf(((AbstractImageLoader)this.terminal.getImageLoader()).getNoOfCachedDynamicImages()), TEXT_LRU_CACHES, new StringBuffer().append(((AbstractImageLoader)this.terminal.getImageLoader()).getStorageSize() / 1024L).append(" kbyte").toString(), TEXT_FONT_MEMORY_USAGE, new StringBuffer().append(this.terminal.getFontSizeCount() * this.terminal.getGlyphCachePageSize()[0] * this.terminal.getGlyphCachePageSize()[1] / 1024).append(" kbyte").toString()} : new String[]{TEXT_STATISTIC_MEMORY_USAGE, this.ealManager.getRAMStatus(), this.ealManager.getVRAMStatus()};
        return stringArray;
    }

    private String[] getInfoEventQueue() {
        return AbstractWidget.framework.getHMIService().getEventDispatcherAdmin().getStatisticData();
    }

    private String[] getScreenInfo() {
        String[] stringArray = new String[4];
        int n = -1;
        String string = "";
        int n2 = -1;
        boolean bl = false;
        try {
            n = this.terminal.getRootWindow().getCurrentScreen().getID();
            string = this.terminal.getScreenName(n);
            bl = this.ealManager.getKzbLoadingError();
        }
        catch (Exception exception) {
            AbstractWidget.logChannel.log(10000, "Statistics#getScreenInfo cannot determine screen id because there's no terminal, root window or current screen");
        }
        stringArray[0] = new StringBuffer().append("ScreenID: ").append(n).toString();
        stringArray[1] = new StringBuffer().append("ScreenName: ").append(string).toString();
        stringArray[2] = new StringBuffer().append("kzb loading error: ").append(bl).toString();
        if (COMBI_AVAILABLE) {
            try {
                HMITerminal hMITerminal = AbstractWidget.framework.getHMITerminalRegistry().getTerminal(1);
                if (hMITerminal != null) {
                    n2 = ((HMITerminalImpl)hMITerminal).getRootWindow().getCurrentScreen().getID();
                }
            }
            catch (Exception exception) {
                AbstractWidget.logChannel.log(10000, "Statistics#getScreenInfo cannot determine screen id for CLUSTER, because there's no terminal, root window or current screen");
            }
            stringArray[3] = new StringBuffer().append("CombiScreenID: ").append(n2).toString();
        } else {
            stringArray[3] = "";
        }
        return stringArray;
    }

    private String[] getDrawTime() {
        return this.ealManager.getDrawTimes();
    }

    public void destroyStatisticElements() {
        if (this.slots != null) {
            for (int i2 = 0; i2 < this.slots.length; ++i2) {
                Slot slot = this.slots[i2];
                if (slot == null) continue;
                slot.remove();
            }
            this.slotList.clear();
        }
        this.slots = null;
    }

    private class Slot {
        private final IWrappedNode3D node;
        private List textNodes;

        public Slot() {
            float f2 = EALStatistics.this.displayWidth / EALStatistics.this.gridSizeX;
            float f3 = EALStatistics.this.displayHeight / EALStatistics.this.gridSizeY;
            this.node = EALStatistics.this.ealManager.createNode3D(EALStatistics.this.ealManager.getStatisticsNode(), "statistics", f2, f3);
        }

        public void setInfo(String[] stringArray) {
            IWrappedNode3DText iWrappedNode3DText;
            int n;
            if (this.textNodes == null) {
                this.textNodes = new ArrayList(stringArray.length);
            }
            while (this.textNodes.size() < stringArray.length) {
                IWrappedNode3DText iWrappedNode3DText2 = EALStatistics.this.ealManager.createText3D(this.node, "statisticstext", " ", EALStatistics.this.font);
                long l = EALManager.createColorCode(-65536);
                iWrappedNode3DText2.getInterfaceText().setColor(l);
                int n2 = this.textNodes.size();
                iWrappedNode3DText2.setPosition(5.0f, n2 * (EALStatistics.this.rowHeight + 2) + EALStatistics.this.rowHeight, 0.0f);
                this.textNodes.add(iWrappedNode3DText2);
            }
            for (n = 0; n < stringArray.length; ++n) {
                iWrappedNode3DText = (IWrappedNode3DText)this.textNodes.get(n);
                iWrappedNode3DText.setText(stringArray[n], EALStatistics.this.font);
                iWrappedNode3DText.setVisible(true);
            }
            for (n = stringArray.length; n < this.textNodes.size(); ++n) {
                iWrappedNode3DText = (IWrappedNode3DText)this.textNodes.get(n);
                iWrappedNode3DText.setVisible(false);
            }
        }

        public void remove() {
            for (int i2 = 0; i2 < this.textNodes.size(); ++i2) {
                IWrappedNode3DText iWrappedNode3DText = (IWrappedNode3DText)this.textNodes.get(i2);
                EALStatistics.this.ealManager.destroy(iWrappedNode3DText);
            }
            EALStatistics.this.ealManager.destroy(this.node);
        }

        public void setPosition(int n, int n2) {
            this.node.setPosition(n, n2, 0.0f);
        }
    }
}

