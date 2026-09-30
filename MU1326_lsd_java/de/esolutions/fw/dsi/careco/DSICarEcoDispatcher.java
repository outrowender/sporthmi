/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.careco;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoReply;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;

public class DSICarEcoDispatcher
extends AbstractDispatcher
implements DSICarEcoReply {
    private DSICarEcoReplyService service = new DSICarEcoReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarEcoDispatcher(int n) {
        super(n, (class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = DSICarEcoDispatcher.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEViewOptions(bCmEViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEViewOptions(bCmEViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEListUpdateInfo(bCmEListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEListUpdateInfo(bCmEListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEConsumption(int n, int n2, int n3, int n4) throws MethodException {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEConsumption(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEConsumption(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmELiveTip(int n, boolean bl, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarEcoListener);
                    dSICarEcoListener.updateBCmELiveTip(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmELiveTip(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerList(bCmEListUpdateInfo, bCmEConsumerListArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void acknowledgeBcmeSetFactoryDefault(boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.acknowledgeBcmeSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopProhibitReasonListUpdateInfo(startStopListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopProhibitReasonListUpdateInfo(startStopListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseStartStopProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopProhibitList[] startStopProhibitListArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseStartStopProhibitReasonList(startStopListUpdateInfo, startStopProhibitListArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopRestartReasonListUpdateInfo(startStopListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopRestartReasonListUpdateInfo(startStopListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseStartStopRestartReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartList[] startStopRestartListArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseStartStopRestartReasonList(startStopListUpdateInfo, startStopRestartListArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopRestartProhibitReasonListUpdateInfo(startStopListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopRestartProhibitReasonListUpdateInfo(startStopListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseStartStopRestartProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartProhibitList[] startStopRestartProhibitListArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseStartStopRestartProhibitReasonList(startStopListUpdateInfo, startStopRestartProhibitListArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopState(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopProhibitReasonListTotalNumberOfElements(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopProhibitReasonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopProhibitReasonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopRestartReasonListTotalNumberOfElements(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopRestartReasonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopRestartReasonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopRestartProhibitReasonListTotalNumberOfElements(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopRestartProhibitReasonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopRestartProhibitReasonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopViewOptions(StartStopViewOptions startStopViewOptions, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopViewOptions(startStopViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopViewOptions(startStopViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStartStopCollectedReasons(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarEcoListener);
                    dSICarEcoListener.updateStartStopCollectedReasons(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateStartStopCollectedReasons(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDViewOptions(RangeDataViewOptions rangeDataViewOptions, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarEcoListener);
                    dSICarEcoListener.updateRDViewOptions(rangeDataViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDViewOptions(rangeDataViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionMotorway1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionMotorway1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionMotorway1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionMotorway2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionMotorway2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionMotorway2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionHighway1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionHighway1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionHighway1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionHighway2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionHighway2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionHighway2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionCountryRoad1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionCountryRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionCountryRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionCountryRoad2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionCountryRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionCountryRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionDistrictRoad1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionDistrictRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionDistrictRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionDistrictRoad2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionDistrictRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionDistrictRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionLocalRoad1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionLocalRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionLocalRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionLocalRoad2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionLocalRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionLocalRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionRuralRoad1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionRuralRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionRuralRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionRuralRoad2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionRuralRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionRuralRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionUnclassifiedRoad1(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionUnclassifiedRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionUnclassifiedRoad1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDConsumptionUnclassifiedRoad2(CarBCConsumption carBCConsumption, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarEcoListener);
                    dSICarEcoListener.updateRDConsumptionUnclassifiedRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDConsumptionUnclassifiedRoad2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDMaxRange1(CarBCCurrentRange carBCCurrentRange, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarEcoListener);
                    dSICarEcoListener.updateRDMaxRange1(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDMaxRange1(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDMaxRange2(CarBCCurrentRange carBCCurrentRange, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarEcoListener);
                    dSICarEcoListener.updateRDMaxRange2(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDMaxRange2(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDResidualEnergy1(RangeDataResidualEnergy rangeDataResidualEnergy, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarEcoListener);
                    dSICarEcoListener.updateRDResidualEnergy1(rangeDataResidualEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDResidualEnergy1(rangeDataResidualEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateRDResidualEnergy2(RangeDataResidualEnergy rangeDataResidualEnergy, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarEcoListener);
                    dSICarEcoListener.updateRDResidualEnergy2(rangeDataResidualEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateRDResidualEnergy2(rangeDataResidualEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void acknowledgeRDSetFactoryDefault(boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.acknowledgeRDSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEConsumerListConsumptionUpdateInfo(bCmEListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEConsumerListConsumptionUpdateInfo(bCmEListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEConsumerListRangeUpdateInfo(bCmEListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEConsumerListRangeUpdateInfo(bCmEListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEEnergyFlowComfort(BCmEEnergyFlowComfort bCmEEnergyFlowComfort, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEEnergyFlowComfort(bCmEEnergyFlowComfort, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEEnergyFlowComfort(bCmEEnergyFlowComfort, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmERangeGainTotal(BCmERangeGainTotal bCmERangeGainTotal, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarEcoListener);
                    dSICarEcoListener.updateBCmERangeGainTotal(bCmERangeGainTotal, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmERangeGainTotal(bCmERangeGainTotal, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListConsumptionRA0(bCmEListUpdateInfo, bCmEConsumerListConsumptionRA0Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListConsumptionRA1(bCmEListUpdateInfo, bCmEConsumerListConsumptionRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListConsumptionRAF(bCmEListUpdateInfo, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListRangeRA0(bCmEListUpdateInfo, bCmEConsumerListRangeRA0Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListRangeRA1(bCmEListUpdateInfo, bCmEConsumerListRangeRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListRangeRA2(bCmEListUpdateInfo, bCmEConsumerListRangeRA2Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.responseBCmEConsumerListRangeRAF(bCmEListUpdateInfo, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarEcoListener);
                    dSICarEcoListener.updateBCmECurrentRange(bCmECurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmECurrentRange(bCmECurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEConsumerListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEConsumerListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEConsumerListConsumptionTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEConsumerListConsumptionTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarEcoListener);
                    dSICarEcoListener.updateBCmEConsumerListRangeTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmEConsumerListRangeTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmECurrentRangeSOC(int n, int n2, int n3, int n4) throws MethodException {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarEcoListener);
                    dSICarEcoListener.updateBCmECurrentRangeSOC(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmECurrentRangeSOC(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateBCmECatalogueRange(int n, int n2, int n3, int n4) throws MethodException {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarEcoListener);
                    dSICarEcoListener.updateBCmECatalogueRange(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateBCmECatalogueRange(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarEcoListener);
                    dSICarEcoListener.updateEAViewOptions(eAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateEAViewOptions(eAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEASystem(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarEcoListener);
                    dSICarEcoListener.updateEASystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateEASystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEAPedalJerk(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarEcoListener);
                    dSICarEcoListener.updateEAPedalJerk(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateEAPedalJerk(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void acknowledgeEASetFactoryDefault(boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.acknowledgeEASetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEAFreeWheeling(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarEcoListener);
                    dSICarEcoListener.updateEAFreeWheeling(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateEAFreeWheeling(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEAStartStop(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarEcoListener);
                    dSICarEcoListener.updateEAStartStop(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)iterator.next();
                    dSICarEcoListener.updateEAStartStop(bl, n);
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
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    dSICarEcoListener.asyncException(n, string, n2);
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
                    DSICarEcoListener dSICarEcoListener = (DSICarEcoListener)objectArray[i2];
                    Method method = dSICarEcoListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarEcoDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarEcoDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarEcoListener, new Object[]{string, string2});
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

