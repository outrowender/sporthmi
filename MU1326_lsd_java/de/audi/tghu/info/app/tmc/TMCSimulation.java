/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.audi.tghu.info.app.tmc.TMCSimulation$AddTmcMessageTask;
import de.audi.tghu.info.app.tmc.TMCSimulation$UpdateTimerTask;
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
    private static final int TIMER_VALUE;
    private static final int TIMER_VALUE_ADDING_MSG;
    private static int INITIAL_NUMBER_OF_MSGS;
    private int indexOfNextTmcMsg = 3;
    private static final String[] DIRECTION;
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
        this.logCh.log(-2137614336, "[TMCSimulation#TMCSimulation] Finished. ");
        Timer timer = new Timer();
    }

    private boolean isReceivingTmcMessagesOneByOneActivated() {
        if (System.getProperty("TmcOneByOne") != null) {
            this.logCh.log(-2137614336, "[TMCSimulation#isReceivingTmcMessagesOneByOneActivated] True. ");
            return true;
        }
        this.logCh.log(-2137614336, "[TMCSimulation#isReceivingTmcMessagesOneByOneActivated] False. ");
        return false;
    }

    private void init() {
        int n;
        this.logCh.log(-2137614336, "[TMCSimulation#init] Adding TMC folder node, index: 0");
        this.indexOfNextTmcMsg = 0;
        for (n = 0; n < 4; ++n) {
            this.logCh.log(-2137614336, "[TMCSimulation#init] Adding TMC child message to folder, index: %1 ", (long)this.indexOfNextTmcMsg);
            this.addTmcMessage(this.indexOfNextTmcMsg++, 0L);
        }
        INITIAL_NUMBER_OF_MSGS = this.isReceivingTmcMessagesOneByOneActivated() ? 3 : DIRECTION.length - this.indexOfNextTmcMsg;
        this.logCh.log(-2137614336, "[TMCSimulation#init] Initial number of TMC messages: %1 ", (long)INITIAL_NUMBER_OF_MSGS);
        for (n = 0; n < INITIAL_NUMBER_OF_MSGS; ++n) {
            this.logCh.log(-2137614336, "[TMCSimulation#init] Adding TMC message, index: %1 ", (long)this.indexOfNextTmcMsg);
            this.addTmcMessage(this.indexOfNextTmcMsg++, -1L);
        }
        if (this.isReceivingTmcMessagesOneByOneActivated()) {
            this.logCh.log(-2137614336, "[TMCSimulation#init] Starting Timer for adding TMC messages, timer value: %1 ", (long)0);
            Timer timer = new Timer();
            timer.schedule((TimerTask)new TMCSimulation$AddTmcMessageTask(this), 0, (long)0);
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
            n2 = 1571214599;
            n3 = 1723546403;
            bl4 = true;
        } else {
            n2 = -1244193016;
            n3 = 602975266;
            bl4 = false;
        }
        TmcListElement tmcListElement = null;
        tmcListElement = TMCHelper.isHURegionNAR() ? TMCHelper.createTmcListElement(0L, new TmcMessage(n, 0L, "W\u00fcrzburg", "Frankfurt", "Helmstadt", "wertheim/lengfurt", new String[]{"Stau", "4 km Stau", "stehender Verkehr"}, new int[]{1, 2, 3}, 0, 0, 0, bl2, bl3, n2, n3, 0, (long)(n + 1) * 0, n + 1, 1L, 1L, 1L, true, true, "Default-Provider", System.currentTimeMillis(), "A3", bl3, true, "A3", false, l2, 1L, "", 69, "de", "", new int[0], "", 0L, new TmcPhoneme("\"?a: \"draI?", "\"vYrts|bUrk?", "\"fraNk|fUrt?", "\"hElm|Stat?", "", ""), 0, 0L, 0L, l2, bl4, 1, 0, l2, string, n3, string), 2, "", false, n + 1, l, 0, n + 2) : TMCHelper.createTmcListElement(0L, new TmcMessage(n, 0L, "W\u00fcrzburg", "Frankfurt", "Helmstadt", "wertheim/lengfurt", new String[]{"Stau", "4 km Stau", "stehender Verkehr"}, new int[]{1, 2, 3}, 0, 0, 0, bl2, bl3, n2, n3, 0, (long)(n + 1) * 0, n + 1, 1L, 1L, 1L, true, true, "Default-Provider", System.currentTimeMillis(), "A3", bl3, true, "A3", false, l2, 1L, "", 69, "", "", new int[0], "", 0L, new TmcPhoneme("\"?a: \"draI?", "\"vYrts|bUrk?", "\"fraNk|fUrt?", "\"hElm|Stat?", "", ""), 0, 0L, 0L, l2, bl4, 1, 0, l2, string, n3, string), 2, "", false, n + 1, l, 0, n + 2);
        if (l == 0L) {
            this.CHILD_NODES.add(tmcListElement);
        } else {
            this.SHORT_MSGS.add(tmcListElement);
        }
    }

    @Override
    public void requestTmcWindow(int n, int n2, int n3, int[] nArray, int n4) {
        this.logCh.log(-2137614336, "[TMCSimulation#requestTmcWindow] called, window ID: %1", (long)n);
        Timer timer = new Timer();
        timer.schedule((TimerTask)new TMCSimulation$UpdateTimerTask(this, n2, n3, nArray, n4), 0);
    }

    private synchronized int fillCurrentWindow(long l, int n, long l2, int n2, boolean bl, int n3) {
        long l3;
        this.logCh.log(-2137614336, "[TMCSimulation#fillCurrentWindow] called. ");
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
        this.logCh.log(-2137614336, "[TMCSimulation#fillCurrentWindow] start: %1, end: %2 ", this.startMsgIndexOfCurrentWindow, l4);
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
        this.logCh.log(-2137614336, "[TMCSimulation#fillCurrentWindow] Size of new current window: %1, result: %2 ", (long)this.currentWindow.size(), (long)n4);
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
            this.logCh.log(-2137614336, "[TMCSimulation#searchForMessageIndex] Searching for requested message ID '%1'. ", (long)nArray[i2]);
            if (bl && i2 == 0) {
                this.logCh.log(-2137614336, "[TMCSimulation#searchForMessageIndex] Ignoring focused message for removing, message ID '%1'. ", (long)nArray[0]);
                continue;
            }
            for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                TmcListElement tmcListElement = (TmcListElement)arrayList.get(i3);
                if (tmcListElement.getUID() != (long)nArray[i2]) continue;
                this.logCh.log(-2137614336, "[TMCSimulation#searchForMessageIndex] Message ID '%1' available, index: %2. ", (long)nArray[i2], (long)i3);
                return i3;
            }
        }
        return -1;
    }

    synchronized void removeMsg(int n) {
        this.logCh.log(-2137614336, "[TMCSimulation#removeMsg] Remove message #%1 ", (long)n);
        this.SHORT_MSGS.remove(n - (int)this.startMsgIndexOfCurrentWindow);
        this.logCh.log(-2137614336, "[TMCSimulation#removeMsg] Object #%1 from current window list removed. ", (long)n - this.startMsgIndexOfCurrentWindow);
        this.tmcListener.windowChange(this.wndId);
    }

    synchronized void removeMsg(int n, int n2) {
        this.logCh.log(-2137614336, "[TMCSimulation#removeMsg] Remove messages from '%1' till '%2' ", (long)n, (long)n2);
        for (int i2 = 0; i2 <= n2 - n; ++i2) {
            this.SHORT_MSGS.remove(n - (int)this.startMsgIndexOfCurrentWindow);
            this.logCh.log(-2137614336, "[TMCSimulation#removeMsg] Object #%1 from current window list removed. ", (long)(n + i2) - this.startMsgIndexOfCurrentWindow);
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

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(short[] sArray, DSIListener dSIListener) {
    }

    public void clearNotification(short s, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    public String getName() {
        return "TMC-Simulation";
    }

    @Override
    public void setMessageFilter(int n, int n2) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
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

    @Override
    public void getMessageIdsForListElement(long l) {
    }

    @Override
    public void getBoundingRectangleForTrafficMessages(long[] lArray) {
    }

    @Override
    public void enableAreaWarnings(boolean bl) {
    }

    @Override
    public void enableTrafficFlowStatistics(boolean bl) {
    }

    static /* synthetic */ LogChannel access$000(TMCSimulation tMCSimulation) {
        return tMCSimulation.logCh;
    }

    static /* synthetic */ int access$100(TMCSimulation tMCSimulation, long l, int n, long l2, int n2, boolean bl, int n3) {
        return tMCSimulation.fillCurrentWindow(l, n, l2, n2, bl, n3);
    }

    static /* synthetic */ ArrayList access$200(TMCSimulation tMCSimulation) {
        return tMCSimulation.currentWindow;
    }

    static /* synthetic */ IFrameworkAccess access$300(TMCSimulation tMCSimulation) {
        return tMCSimulation.framework;
    }

    static /* synthetic */ ArrayList access$400(TMCSimulation tMCSimulation) {
        return tMCSimulation.SHORT_MSGS;
    }

    static /* synthetic */ ArrayList access$500(TMCSimulation tMCSimulation) {
        return tMCSimulation.CHILD_NODES;
    }

    static /* synthetic */ int access$600(TMCSimulation tMCSimulation) {
        return tMCSimulation.wndId;
    }

    static /* synthetic */ DSITmcListener access$700(TMCSimulation tMCSimulation) {
        return tMCSimulation.tmcListener;
    }

    static /* synthetic */ int access$800(TMCSimulation tMCSimulation) {
        return tMCSimulation.indexOfNextTmcMsg;
    }

    static /* synthetic */ String[] access$900() {
        return DIRECTION;
    }

    static /* synthetic */ int access$808(TMCSimulation tMCSimulation) {
        return tMCSimulation.indexOfNextTmcMsg++;
    }

    static {
        INITIAL_NUMBER_OF_MSGS = 3;
        DIRECTION = new String[]{"Ebermannstadt", "W\u00fcrzburg", "Pegnitz", "Aachen", "Hamburg", "Kaiserslautern", "Erlangen", "Buttenheim", "Dortmund", "Frankfurt", "Essen", "Mainz", "Stuttgart", "D\u00fcsseldorf", "Bremen", "Duisburg", "Leipzig", "N\u00fcrnberg", "Dresden", "Bochum", "Wuppertal", "Bielefeld", "Mannheim", "N\u00fcrnberg", "Bonn", "Gelsenkirchen", "Karlsruhe", "Wiesbaden", "M\u00fcnster", "M\u00f6nchengladbach", "Bamberg", "Augsburg", "Halle", "Braunschweig", "Aachen", "Krefeld", "Kiel", "Magdeburg", "Oberhausen", "L\u00fcbeck", "Freiburg", "Zwickau", "W\u00fcrzburg", "Wuppertal", "Wolfsburg", "Witten", "Wilhelmshaven", "Wiesbaden", "Ulm", "Trier", "Stuttgart", "Solingen", "Siegen", "Schwerin", "Salzgitter", "Saarbr\u00fccken", "Rostock", "Reutlingen", "Remscheid", "Regensburg", "Recklinghausen", "Potsdam", "Plauen", "Pforzheim", "Paderborn", "Osnabr\u00fcck", "Oldenburg", "Offenbach", "M\u00fclheim an der Ruhr", "L\u00fcbeck", "Leverkusen", "Koblenz", "Ingolstadt", "Jena", "Hildesheim", "Hamm"};
    }
}

