/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class RemoteHMIView {
    public static final int INPUTTYPE_NUMERIC = 0;
    public static final int INPUTTYPE_ALPHANUMERIC = 1;
    public static final int INPUTTYPE_PASSWORD = 3;
    private String id;
    private int type;
    private int version;
    private HMIProperties parameters;
    private boolean containsGridList;

    public RemoteHMIView() {
        this(0, "", 0, false);
    }

    public RemoteHMIView(int n, String string, int n2) {
        this(n, string, n2, new HMIProperties(), false);
    }

    public RemoteHMIView(int n, String string, int n2, boolean bl) {
        this(n, string, n2, new HMIProperties(), bl);
    }

    public RemoteHMIView(RemoteHMIView remoteHMIView) {
        this(remoteHMIView.type, remoteHMIView.id, remoteHMIView.version, new HMIProperties(remoteHMIView.parameters), remoteHMIView.containsGridList);
    }

    private RemoteHMIView(int n, String string, int n2, HMIProperties hMIProperties, boolean bl) {
        this.type = n;
        this.id = string;
        this.version = n2;
        this.parameters = hMIProperties;
        this.containsGridList = bl;
    }

    public void setViewID(String string) {
        this.id = string;
    }

    public String getViewID() {
        return this.id;
    }

    public void setViewType(int n) {
        this.type = n;
    }

    public int getViewType() {
        return this.type;
    }

    public void setVersion(int n) {
        this.version = n;
    }

    public int getVersion() {
        return this.version;
    }

    public HMIProperties getProperties() {
        return this.parameters;
    }

    public void setProperties(HMIProperties hMIProperties) {
        this.parameters = hMIProperties;
    }

    public boolean containsGridList() {
        return this.containsGridList;
    }

    public void setContainsGridList(boolean bl) {
        this.containsGridList = bl;
    }

    public synchronized String toString() {
        String string = this.getViewID();
        if (string == null) {
            string = "NULL";
        }
        String string2 = Integer.toString(this.getViewType());
        String string3 = Integer.toString(this.getVersion());
        String string4 = this.getScreenType();
        Buffer buffer = new Buffer("[ ID = ".length() + string.length() + ", Type = ".length() + string2.length() + ", Version = ".length() + string3.length() + string4.length() + string4.length() + " ] ".length());
        buffer.append("[ ID = ").append(string);
        buffer.append(", Type = ").append(string2);
        buffer.append(", Version = ").append(string3);
        buffer.append(", Screen = ").append(string4);
        buffer.append(" ] ");
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearParameters() {
        RemoteHMIView remoteHMIView = this;
        synchronized (remoteHMIView) {
            this.getProperties().clear();
        }
    }

    public boolean setGridListSender(String string) {
        HMIProperties hMIProperties = this.getProperties();
        if (hMIProperties == null) {
            return false;
        }
        return hMIProperties.setGridListSender(string);
    }

    public String getScreenType() {
        HMIProperties hMIProperties = this.getProperties();
        if (hMIProperties == null) {
            return "";
        }
        return hMIProperties.getString("screenType");
    }

    public boolean isOptionsScreen() {
        return this.getScreenType().equals("options");
    }

    public boolean isUpdateOf(RemoteHMIView remoteHMIView) {
        return remoteHMIView != null && this.getViewType() == remoteHMIView.getViewType() && this.getVersion() == remoteHMIView.getVersion() && Util.equals(this.getViewID(), remoteHMIView.getViewID()) && this.isOptionsScreen() == remoteHMIView.isOptionsScreen();
    }
}

