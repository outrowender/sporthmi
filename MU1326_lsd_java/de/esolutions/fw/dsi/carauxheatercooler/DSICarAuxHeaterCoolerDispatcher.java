/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carauxheatercooler;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerReply;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener;
import org.dsi.ifc.global.CarBCTemperature;

public class DSICarAuxHeaterCoolerDispatcher
extends AbstractDispatcher
implements DSICarAuxHeaterCoolerReply {
    private DSICarAuxHeaterCoolerReplyService service = new DSICarAuxHeaterCoolerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarAuxHeaterCoolerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener = DSICarAuxHeaterCoolerDispatcher.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerViewOptions(auxHeaterCoolerViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerViewOptions(auxHeaterCoolerViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerCurrentHeaterState(auxHeaterCoolerErrorReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerCurrentHeaterState(auxHeaterCoolerErrorReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerErrorReason(auxHeaterCoolerErrorReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerErrorReason(auxHeaterCoolerErrorReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerState(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerOnOff(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerRemainingTime(short s, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerRemainingTime(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerRemainingTime(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerRunningTime(short s, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerRunningTime(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerRunningTime(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerMode(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerDefaultStartMode(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerDefaultStartMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerDefaultStartMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerEngineHeater(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerEngineHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerEngineHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerActiveTimer(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerActiveTimer(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerActiveTimer(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTimer1(auxHeaterCoolerTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTimer1(auxHeaterCoolerTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTimer2(auxHeaterCoolerTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTimer2(auxHeaterCoolerTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTimer3(auxHeaterCoolerTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTimer3(auxHeaterCoolerTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void acknowledgeAuxHeaterSetFactoryDefault(boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)objectArray[i2];
                    dSICarAuxHeaterCoolerListener.acknowledgeAuxHeaterSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerPopup(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerPopup(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerPopup(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerMode2(AuxHeaterCoolerMode auxHeaterCoolerMode, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerMode2(auxHeaterCoolerMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerMode2(auxHeaterCoolerMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerExtendedConditioning(auxHeaterCoolerExtendedConditioning, auxHeaterCoolerExtendedConditioning2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerExtendedConditioning(auxHeaterCoolerExtendedConditioning, auxHeaterCoolerExtendedConditioning2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerWindowHeating(boolean bl, boolean bl2, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerWindowHeating(bl, bl2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerWindowHeating(bl, bl2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerUnlockClimating(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerUnlockClimating(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerUnlockClimating(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerTargetTemperature(CarBCTemperature carBCTemperature, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTargetTemperature(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerTargetTemperature(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAuxHeaterCoolerAirQuality(boolean bl, boolean bl2, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarAuxHeaterCoolerListener);
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerAirQuality(bl, bl2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)iterator.next();
                    dSICarAuxHeaterCoolerListener.updateAuxHeaterCoolerAirQuality(bl, bl2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void asyncException(int n, String string, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)objectArray[i2];
                    dSICarAuxHeaterCoolerListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void yyIndication(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAuxHeaterCoolerListener dSICarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)objectArray[i2];
                    Method method = dSICarAuxHeaterCoolerListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarAuxHeaterCoolerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarAuxHeaterCoolerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarAuxHeaterCoolerListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

