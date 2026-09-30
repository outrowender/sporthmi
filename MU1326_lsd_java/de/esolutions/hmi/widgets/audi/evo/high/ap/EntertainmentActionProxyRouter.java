/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.ap;

import de.audi.atip.statemachine.ap.EntertainmentActionProxy;

public class EntertainmentActionProxyRouter
implements EntertainmentActionProxy {
    public static final int VALUE_NOTHING = -1;
    protected static EntertainmentActionProxy m_handler = null;
    protected static EntertainmentActionProxyRouter thisIsJimmy = null;
    protected int blackListedConnection = -1;

    public static synchronized EntertainmentActionProxyRouter getInstance() {
        if (thisIsJimmy == null) {
            thisIsJimmy = new EntertainmentActionProxyRouter();
        }
        return thisIsJimmy;
    }

    public int getBlackListedConnection() {
        return this.blackListedConnection;
    }

    public void registerHandler(EntertainmentActionProxy entertainmentActionProxy) {
        m_handler = entertainmentActionProxy;
    }

    public void clearHandler() {
        m_handler = null;
    }

    public void entertainmentBlacklist(int n, int n2) {
        this.blackListedConnection = n2;
        if (m_handler != null) {
            m_handler.entertainmentBlacklist(n, n2);
        }
    }

    public void entertainmentSetVisible(int n, boolean bl) {
        if (m_handler != null) {
            m_handler.entertainmentSetVisible(n, bl);
        }
    }
}

