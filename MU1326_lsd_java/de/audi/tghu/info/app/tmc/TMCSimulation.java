/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.TMCHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TmcPhoneme;

public final class TMCSimulation
implements DSITmc {
    private static final int TIMER_VALUE = 10;
    private static final int TIMER_VALUE_ADDING_MSG = 3000;
    private static int INITIAL_NUMBER_OF_MSGS = 3;
    private int indexOfNextTmcMsg = 3;
    private static final String[] DIRECTION = new String[]{"Ebermannstadt", "W\u00fcrzburg", "Pegnitz", "Aachen", "Hamburg", "Kaiserslautern", "Erlangen", "Buttenheim", "Dortmund", "Frankfurt", "Essen", "Mainz", "Stuttgart", "D\u00fcsseldorf", "Bremen", "Duisburg", "Leipzig", "N\u00fcrnberg", "Dresden", "Bochum", "Wuppertal", "Bielefeld", "Mannheim", "N\u00fcrnberg", "Bonn", "Gelsenkirchen", "Karlsruhe", "Wiesbaden", "M\u00fcnster", "M\u00f6nchengladbach", "Bamberg", "Augsburg", "Halle", "Braunschweig", "Aachen", "Krefeld", "Kiel", "Magdeburg", "Oberhausen", "L\u00fcbeck", "Freiburg", "Zwickau", "W\u00fcrzburg", "Wuppertal", "Wolfsburg", "Witten", "Wilhelmshaven", "Wiesbaden", "Ulm", "Trier", "Stuttgart", "Solingen", "Siegen", "Schwerin", "Salzgitter", "Saarbr\u00fccken", "Rostock", "Reutlingen", "Remscheid", "Regensburg", "Recklinghausen", "Potsdam", "Plauen", "Pforzheim", "Paderborn", "Osnabr\u00fcck", "Oldenburg", "Offenbach", "M\u00fclheim an der Ruhr", "L\u00fcbeck", "Leverkusen", "Koblenz", "Ingolstadt", "Jena", "Hildesheim", "Hamm"};
    private final ArrayList SHORT_MSGS = new ArrayList();
    private final int NUMBER_OF_CHILD_NODES;
    private final ArrayList CHILD_NODES = new ArrayList(4);
    private final TmcListElement PARENT_NODE = TMCHelper.createTmcListElement(0L, null, 1, "A1", true, 0L, -1L, 4, 1);
    private DSITmcListener tmcListener;
    private ArrayList currentWindow;
    private long startMsgIndexOfCurrentWindow = -1L;
    private LogChannel logCh;
    private int wndId;
    private IFrameworkAccess framework;

    public TMCSimulation(IFrameworkAccess iFrameworkAccess, DSITmcListener dSITmcListener, int n) {
        this.NUMBER_OF_CHILD_NODES = 4;
        this.logCh = iFrameworkAccess.getLogChannel(new StringBuffer().append("App.Info.Sim").append(n).toString());
        this.framework = iFrameworkAccess;
        this.init();
        this.wndId = n;
        this.tmcListener = dSITmcListener;
        this.currentWindow = new ArrayList(20);
        int n2 = this.SHORT_MSGS.size() + this.CHILD_NODES.size();
        int n3 = this.SHORT_MSGS.size() + 1;
        this.tmcListener.updateEventsTotal(n, n2, n3, 1);
        this.logCh.log(10000000, "[TMCSimulation#TMCSimulation] Finished. ");
        Timer timer = new Timer();
    }

    private boolean isReceivingTmcMessagesOneByOneActivated() {
        if (System.getProperty("TmcOneByOne") != null) {
            this.logCh.log(10000000, "[TMCSimulation#isReceivingTmcMessagesOneByOneActivated] True. ");
            return true;
        }
        this.logCh.log(10000000, "[TMCSimulation#isReceivingTmcMessagesOneByOneActivated] False. ");
        return false;
    }

    private void init() {
        int n;
        this.logCh.log(10000000, "[TMCSimulation#init] Adding TMC folder node, index: 0");
        this.indexOfNextTmcMsg = 0;
        for (n = 0; n < 4; ++n) {
            this.logCh.log(10000000, "[TMCSimulation#init] Adding TMC child message to folder, index: %1 ", (long)this.indexOfNextTmcMsg);
            this.addTmcMessage(this.indexOfNextTmcMsg++, 0L);
        }
        INITIAL_NUMBER_OF_MSGS = this.isReceivingTmcMessagesOneByOneActivated() ? 3 : DIRECTION.length - this.indexOfNextTmcMsg;
        this.logCh.log(10000000, "[TMCSimulation#init] Initial number of TMC messages: %1 ", (long)INITIAL_NUMBER_OF_MSGS);
        for (n = 0; n < INITIAL_NUMBER_OF_MSGS; ++n) {
            this.logCh.log(10000000, "[TMCSimulation#init] Adding TMC message, index: %1 ", (long)this.indexOfNextTmcMsg);
            this.addTmcMessage(this.indexOfNextTmcMsg++, -1L);
        }
        if (this.isReceivingTmcMessagesOneByOneActivated()) {
            this.logCh.log(10000000, "[TMCSimulation#init] Starting Timer for adding TMC messages, timer value: %1 ", 3000L);
            Timer timer = new Timer();
            timer.schedule((TimerTask)new AddTmcMessageTask(), 3000L, 3000L);
        }
    }

    synchronized void addTmcMessage(int n, long l) {
        boolean bl = true;
        boolean bl2 = false;
        String string = null;
        boolean bl3 = false;
        long l2 = Long.MIN_VALUE;
        int n2 = 0;
        int n3 = 0;
        boolean bl4 = false;
        if (n > DIRECTION.length / 10) {
            bl = false;
        }
        if (n > DIRECTION.length / 10) {
            l2 = 0L;
        }
        if (n % 2 == 0) {
            bl2 = true;
            bl3 = true;
            string = "Erlangen";
        } else {
            bl3 = false;
            bl2 = false;
            string = "Bamberg";
        }
        if (n % 4 == 0) {
            n2 = 131442269;
            n3 = 591117158;
            bl4 = true;
        } else {
            n2 = 136304565;
            n3 = 581759011;
            bl4 = false;
        }
        TmcListElement tmcListElement = null;
        tmcListElement = TMCHelper.isHURegionNAR() ? TMCHelper.createTmcListElement(0L, new TmcMessage(n, 0L, "W\u00fcrzburg", "Frankfurt", "Helmstadt", "wertheim/lengfurt", new String[]{"Stau", "4 km Stau", "stehender Verkehr"}, new int[]{1, 2, 3}, 0, 60L, 6000000L, bl2, bl3, n2, n3, 4000000L, (long)(n + 1) * 5000L, n + 1, 1L, 1L, 1L, true, true, "Default-Provider", System.currentTimeMillis(), "A3", bl3, true, "A3", false, l2, 1L, "", 69, "de", "", new int[0], "", 0L, new TmcPhoneme("\"?a: \"draI?", "\"vYrts|bUrk?", "\"fraNk|fUrt?", "\"hElm|Stat?", "", ""), 0, 0L, 0L, l2, bl4, 1, 0, l2, string, n3, string), 2, "", false, n + 1, l, 0, n + 2) : TMCHelper.createTmcListElement(0L, new TmcMessage(n, 0L, "W\u00fcrzburg", "Frankfurt", "Helmstadt", "wertheim/lengfurt", new String[]{"Stau", "4 km Stau", "stehender Verkehr"}, new int[]{1, 2, 3}, 0, 60L, 6000000L, bl2, bl3, n2, n3, 4000000L, (long)(n + 1) * 5000L, n + 1, 1L, 1L, 1L, true, true, "Default-Provider", System.currentTimeMillis(), "A3", bl3, true, "A3", false, l2, 1L, "", 69, "", "", new int[0], "", 0L, new TmcPhoneme("\"?a: \"draI?", "\"vYrts|bUrk?", "\"fraNk|fUrt?", "\"hElm|Stat?", "", ""), 0, 0L, 0L, l2, bl4, 1, 0, l2, string, n3, string), 2, "", false, n + 1, l, 0, n + 2);
        if (l == 0L) {
            this.CHILD_NODES.add(tmcListElement);
        } else {
            this.SHORT_MSGS.add(tmcListElement);
        }
    }

    public void requestTmcWindow(int n, int n2, int n3, int[] nArray, int n4) {
        this.logCh.log(10000000, "[TMCSimulation#requestTmcWindow] called, window ID: %1", (long)n);
        Timer timer = new Timer();
        timer.schedule((TimerTask)new UpdateTimerTask(n2, n3, nArray, n4), 10L);
    }

    private synchronized int fillCurrentWindow(long l, int n, long l2, int n2, boolean bl, int n3) {
        long l3;
        this.logCh.log(10000000, "[TMCSimulation#fillCurrentWindow] called. ");
        this.currentWindow.clear();
        int n4 = -1;
        ArrayList arrayList = this.getShortMessages(n2 == 0);
        this.adjustListElementPositionValues(arrayList);
        if (bl) {
            arrayList.remove(n3);
        }
        this.startMsgIndexOfCurrentWindow = (l3 = l2 - (long)n) < 0L ? 0L : (l3 >= (long)arrayList.size() ? l2 : l3);
        long l4 = this.startMsgIndexOfCurrentWindow + (long)((int)l);
        if (l4 > (long)arrayList.size()) {
            l4 = arrayList.size();
        }
        this.logCh.log(10000000, "[TMCSimulation#fillCurrentWindow] start: %1, end: %2 ", this.startMsgIndexOfCurrentWindow, l4);
        int n5 = (int)this.startMsgIndexOfCurrentWindow;
        while ((long)n5 < l4) {
            TmcListElement tmcListElement = (TmcListElement)arrayList.get(n5);
            if (tmcListElement.getMessage() != null) {
                tmcListElement.getMessage().timeStamp = System.currentTimeMillis();
            }
            this.currentWindow.add(tmcListElement);
            if ((long)n5 == l2) {
                n4 = (int)tmcListElement.getUID();
            }
            ++n5;
        }
        if (n4 == -1 && this.currentWindow.size() > 0) {
            n4 = (int)((TmcListElement)this.currentWindow.get(0)).getUID();
        }
        this.logCh.log(10000000, "[TMCSimulation#fillCurrentWindow] Size of new current window: %1, result: %2 ", (long)this.currentWindow.size(), (long)n4);
        return n4;
    }

    private void adjustListElementPositionValues(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator iterator = arrayList.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            ((TmcListElement)iterator.next()).positionInCompleteList = n++;
        }
    }

    private synchronized int searchForMessageIndex(int[] nArray, int n, boolean bl) {
        ArrayList arrayList = this.getShortMessages(n == 0);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.logCh.log(10000000, "[TMCSimulation#searchForMessageIndex] Searching for requested message ID '%1'. ", (long)nArray[i2]);
            if (bl && i2 == 0) {
                this.logCh.log(10000000, "[TMCSimulation#searchForMessageIndex] Ignoring focused message for removing, message ID '%1'. ", (long)nArray[0]);
                continue;
            }
            for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                TmcListElement tmcListElement = (TmcListElement)arrayList.get(i3);
                if (tmcListElement.getUID() != (long)nArray[i2]) continue;
                this.logCh.log(10000000, "[TMCSimulation#searchForMessageIndex] Message ID '%1' available, index: %2. ", (long)nArray[i2], (long)i3);
                return i3;
            }
        }
        return -1;
    }

    synchronized void removeMsg(int n) {
        this.logCh.log(10000000, "[TMCSimulation#removeMsg] Remove message #%1 ", (long)n);
        this.SHORT_MSGS.remove(n - (int)this.startMsgIndexOfCurrentWindow);
        this.logCh.log(10000000, "[TMCSimulation#removeMsg] Object #%1 from current window list removed. ", (long)n - this.startMsgIndexOfCurrentWindow);
        this.tmcListener.windowChange(this.wndId);
    }

    synchronized void removeMsg(int n, int n2) {
        this.logCh.log(10000000, "[TMCSimulation#removeMsg] Remove messages from '%1' till '%2' ", (long)n, (long)n2);
        for (int i2 = 0; i2 <= n2 - n; ++i2) {
            this.SHORT_MSGS.remove(n - (int)this.startMsgIndexOfCurrentWindow);
            this.logCh.log(10000000, "[TMCSimulation#removeMsg] Object #%1 from current window list removed. ", (long)(n + i2) - this.startMsgIndexOfCurrentWindow);
        }
        this.tmcListener.windowChange(this.wndId);
    }

    public String getServiceAdapterVersion() {
        return null;
    }

    public void setNotification(short[] sArray, DSIListener dSIListener) {
    }

    public void setNotification(short s, DSIListener dSIListener) {
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(short[] sArray, DSIListener dSIListener) {
    }

    public void clearNotification(short s, DSIListener dSIListener) {
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public String getName() {
        return "TMC-Simulation";
    }

    public void setMessageFilter(int n, int n2) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    private ArrayList getShortMessages(boolean bl) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.PARENT_NODE);
        if (bl) {
            arrayList.addAll(this.CHILD_NODES);
        }
        arrayList.addAll(this.SHORT_MSGS);
        return arrayList;
    }

    public void getMessageIdsForListElement(long l) {
    }

    public void getBoundingRectangleForTrafficMessages(long[] lArray) {
    }

    public void enableAreaWarnings(boolean bl) {
    }

    public void enableTrafficFlowStatistics(boolean bl) {
    }

    class UpdateTimerTask
    extends TimerTask {
        private long windowSize;
        private int offset;
        private int[] msgIds;
        private int openedListAnchorId;

        public UpdateTimerTask(long l, int n, int[] nArray, int n2) {
            this.windowSize = l;
            this.offset = n;
            this.msgIds = nArray;
            this.openedListAnchorId = n2;
        }

        public synchronized void run() {
            int n;
            int n2;
            int n3 = -1;
            if (this.msgIds == null || this.msgIds.length == 0 || this.msgIds.length == 1 && this.msgIds[0] == -1) {
                TMCSimulation.this.logCh.log(10000000, "[TMCSimulation#setWindow] Initial window requested. ");
                n3 = TMCSimulation.this.fillCurrentWindow(this.windowSize, 0, 0L, this.openedListAnchorId, false, 0);
            } else {
                boolean bl = false;
            }
            TmcListElement[] tmcListElementArray = (TmcListElement[])TMCSimulation.this.currentWindow.toArray(new TmcListElement[TMCSimulation.this.currentWindow.size()]);
            if (TMCSimulation.this.framework.isEvoHigh() || TMCSimulation.this.framework.isPorscheHigh() || TMCSimulation.this.framework.isBentley() || TMCSimulation.this.framework.isPGen2()) {
                n2 = TMCSimulation.this.SHORT_MSGS.size() + TMCSimulation.this.CHILD_NODES.size();
                n = TMCSimulation.this.SHORT_MSGS.size() + 1 + (this.openedListAnchorId == 0 ? TMCSimulation.this.CHILD_NODES.size() : 0);
            } else {
                n2 = TMCSimulation.this.SHORT_MSGS.size();
                n = TMCSimulation.this.SHORT_MSGS.size();
            }
            TMCSimulation.this.logCh.log(10000000, "Updating window... ");
            switch (TMCSimulation.this.wndId) {
                case 0: 
                case 1: 
                case 2: {
                    TMCSimulation.this.tmcListener.updateEventsTotal(TMCSimulation.this.wndId, n2, n, 1);
                    TMCSimulation.this.tmcListener.tmcWindowResult(TMCSimulation.this.wndId, n3, tmcListElementArray);
                    break;
                }
            }
        }
    }

    class AddTmcMessageTask
    extends TimerTask {
        public void run() {
            if (TMCSimulation.this.indexOfNextTmcMsg >= DIRECTION.length) {
                TMCSimulation.this.logCh.log(10000000, "[TMCSimulation#AddTmcMessageTask] Do nothing, no more messages available. ");
            } else {
                TMCSimulation.this.logCh.log(10000000, "[TMCSimulation#AddTmcMessageTask] Add next message. ");
                TMCSimulation.this.addTmcMessage(TMCSimulation.this.indexOfNextTmcMsg, -1L);
                TMCSimulation.this.indexOfNextTmcMsg++;
                TMCSimulation.this.tmcListener.windowChange(TMCSimulation.this.wndId);
            }
        }
    }
}

