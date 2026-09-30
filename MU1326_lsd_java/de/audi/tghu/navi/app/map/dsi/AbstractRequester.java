/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.dsi.AbstractResponser;
import de.audi.tghu.navi.app.map.handler.DSIStateChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractRequester
implements DSIBase {
    private int iInstanceID = -1;
    protected AbstractResponser responser = null;
    private LogChannel logChannel = null;
    private AbstractMap naviMap = null;
    private boolean bReady = false;
    private boolean bOperable = false;
    private Set dsiStateChangeListeners = new HashSet();
    private final String CLASSNAME;

    public AbstractRequester(int n, LogChannel logChannel, String string) {
        this.iInstanceID = n;
        this.logChannel = logChannel;
        this.CLASSNAME = string;
    }

    protected void cleanup() {
        if (this.dsiStateChangeListeners != null) {
            this.dsiStateChangeListeners.clear();
        }
        this.cleanupResponserAttributeNotifications();
    }

    protected void cleanupResponserAttributeNotifications() {
        if (this.responser != null) {
            if (this.getDSIBase() != null) {
                this.getDSIBase().clearNotification(this.responser);
            }
            this.responser.cleanup();
        }
    }

    protected void setResponser(AbstractResponser abstractResponser) {
        this.responser = abstractResponser;
    }

    protected LogChannel getLogger() {
        return this.logChannel;
    }

    protected void bind(DSIBase dSIBase) {
        boolean bl;
        boolean bl2 = bl = dSIBase != null;
        if (bl && !this.isReady()) {
            this.getResponser().resetMemberVariables();
            this.resetMemberVariables();
        }
        this.setReady(bl);
        if (this.getMap() != null) {
            this.getMap().initDSI();
        } else {
            this.getLogger().log(100000, "AbstractRequester#bind() - It (id = %1) is not bound to a map.", (long)this.getID());
        }
    }

    public void bind(AbstractMap abstractMap) {
        this.naviMap = abstractMap;
        this.responser.bind(abstractMap);
    }

    public AbstractMap getMap() {
        return this.naviMap;
    }

    protected IContext getActiveContext() {
        return this.getMap().getActiveContext();
    }

    public boolean isReady() {
        return this.bReady;
    }

    protected void setReady(boolean bl) {
        this.bReady = bl;
    }

    public int getID() {
        return this.iInstanceID;
    }

    protected AbstractResponser getResponser() {
        return this.responser;
    }

    public void setOperable(boolean bl) {
        if (this.bOperable != bl) {
            this.bOperable = bl;
            Iterator iterator = this.dsiStateChangeListeners.iterator();
            while (iterator.hasNext()) {
                ((DSIStateChangeListener)iterator.next()).onOperabilityChanged(this);
            }
        }
    }

    public boolean isOperable() {
        return this.bReady && this.bOperable;
    }

    public void addDSIStateChangeListener(DSIStateChangeListener dSIStateChangeListener) {
        this.dsiStateChangeListeners.add(dSIStateChangeListener);
    }

    public abstract void resetMemberVariables();

    protected abstract DSIBase getDSIBase();

    public final void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            this.getLogger().log(100000000, "AbstractRequester[%1]#setNotification() - length: %2", (Object)this.CLASSNAME, nArray == null ? 0L : (long)nArray.length);
            DSIBase dSIBase = this.getDSIBase();
            if (dSIBase != null) {
                dSIBase.setNotification(nArray, dSIListener);
            } else {
                this.getLogger().log(100000, "AbstractRequester[%1]#setNotification() - DSI not set!", (Object)this.CLASSNAME);
            }
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "AbstractRequester[%1]#setNotification(): ERROR=%2", (Object)this.CLASSNAME, (Throwable)exception);
        }
    }

    public final void setNotification(int n, DSIListener dSIListener) {
        try {
            this.getLogger().log(100000000, "AbstractRequester[%1]#setNotification(%2)", (Object)this.CLASSNAME, (long)n);
            DSIBase dSIBase = this.getDSIBase();
            if (dSIBase != null) {
                dSIBase.setNotification(n, dSIListener);
            } else {
                this.getLogger().log(100000, "AbstractRequester[%1]#setNotification() - DSI not set!", (Object)this.CLASSNAME);
            }
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "AbstractRequester[%1]#setNotification(): ERROR=%2", (Object)this.CLASSNAME, (Throwable)exception);
        }
    }

    public final void setNotification(DSIListener dSIListener) {
        try {
            this.getLogger().log(100000000, "AbstractRequester[%1]#setNotification()", (Object)this.CLASSNAME);
            DSIBase dSIBase = this.getDSIBase();
            if (dSIBase != null) {
                dSIBase.setNotification(dSIListener);
            } else {
                this.getLogger().log(100000, "AbstractRequester[%1]#setNotification() - DSI not set!", (Object)this.CLASSNAME);
            }
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "AbstractRequester[%1]#setNotification(): ERROR=%2", (Object)this.CLASSNAME, (Throwable)exception);
        }
    }

    public final void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            this.getLogger().log(100000000, "AbstractRequester[%1]#clearNotification() - length: %2", (Object)this.CLASSNAME, nArray == null ? 0L : (long)nArray.length);
            DSIBase dSIBase = this.getDSIBase();
            if (dSIBase != null) {
                dSIBase.clearNotification(nArray, dSIListener);
            } else {
                this.getLogger().log(100000, "AbstractRequester[%1]#clearNotification() - DSI not set!", (Object)this.CLASSNAME);
            }
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "AbstractRequester[%1]#clearNotification(): ERROR=%2", (Object)this.CLASSNAME, (Throwable)exception);
        }
    }

    public final void clearNotification(int n, DSIListener dSIListener) {
        try {
            this.getLogger().log(100000000, "AbstractRequester[%1]#clearNotification(%2)", (Object)this.CLASSNAME, (long)n);
            DSIBase dSIBase = this.getDSIBase();
            if (dSIBase != null) {
                dSIBase.clearNotification(n, dSIListener);
            } else {
                this.getLogger().log(100000, "AbstractRequester[%1]#clearNotification() - DSI not set!", (Object)this.CLASSNAME);
            }
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "AbstractRequester[%1]#clearNotification(): ERROR=%2", (Object)this.CLASSNAME, (Throwable)exception);
        }
    }

    public void clearNotification(DSIListener dSIListener) {
        try {
            this.getLogger().log(100000000, "AbstractRequester[%1]#clearNotification(%2)", (Object)this.CLASSNAME, (Object)dSIListener);
            DSIBase dSIBase = this.getDSIBase();
            if (dSIBase != null) {
                dSIBase.clearNotification(dSIListener);
            } else {
                this.getLogger().log(100000, "AbstractRequester[%1]#clearNotification() - DSI not set!", (Object)this.CLASSNAME);
            }
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "AbstractRequester[%1]#clearNotification(): ERROR=%2", (Object)this.CLASSNAME, (Throwable)exception);
        }
    }
}

