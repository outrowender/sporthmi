/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.sdars;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.sdars.DSISDARSTunerReply;
import de.esolutions.fw.comm.dsi.sdars.impl.DSISDARSTunerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class DSISDARSTunerDispatcher
extends AbstractDispatcher
implements DSISDARSTunerReply {
    private DSISDARSTunerReplyService service = new DSISDARSTunerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTunerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISDARSTunerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$sdars$DSISDARSTunerListener == null ? (class$org$dsi$ifc$sdars$DSISDARSTunerListener = DSISDARSTunerDispatcher.class$("org.dsi.ifc.sdars.DSISDARSTunerListener")) : class$org$dsi$ifc$sdars$DSISDARSTunerListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateElectronicSerialCode(String string, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(2, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateElectronicSerialCode(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateElectronicSerialCode(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(6, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateServiceStatus3(serviceStatus3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateServiceStatus3(serviceStatus3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSignalQuality(SignalQuality signalQuality, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(7, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateSignalQuality(signalQuality, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateSignalQuality(signalQuality, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSelectedStation(StationInfo stationInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(8, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateSelectedStation(stationInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateSelectedStation(stationInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStationList(StationInfo[] stationInfoArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(9, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateStationList(stationInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateStationList(stationInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(10, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateCategoryList(categoryInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateCategoryList(categoryInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationRadioText(RadioText radioText) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationRadioText(radioText);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationRadioText2(RadioText[] radioTextArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationRadioText2(radioTextArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStaticTaggingInfo(String string, String string2, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(13, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateStaticTaggingInfo(string, string2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateStaticTaggingInfo(string, string2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDetectedDevice(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(12, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void selectStationStatus(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.selectStationStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseTime(DateTime dateTime) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.responseTime(dateTime);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.responseEPG24Hour(ePGShortInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseEPGDescription(EPGDescription ePGDescription) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.responseEPGDescription(ePGDescription);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAvailability(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(26, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(27, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateStationDescription(stationDescriptionArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateStationDescription(stationDescriptionArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(28, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateSubscriptionStatus(subscriptionStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateSubscriptionStatus(subscriptionStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationEPGChannelList(ePGShortInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationChannelArt(ImageInformation[] imageInformationArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationChannelArt(imageInformationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationBackgroundArt(ImageInformation[] imageInformationArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationBackgroundArt(imageInformationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationAlbumArt(ImageInformation[] imageInformationArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationAlbumArt(imageInformationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationGenreArt(ImageInformation[] imageInformationArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationGenreArt(imageInformationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void informationStudioArt(ImageInformation[] imageInformationArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.informationStudioArt(imageInformationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateProfileState(int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    this.confirmNotificationListener(30, dSISDARSTunerListener);
                    dSISDARSTunerListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)iterator.next();
                    dSISDARSTunerListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileChanged(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileCopied(int n, int n2, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileReset(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileResetAll(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.profileResetAll(n);
                    continue;
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
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    dSISDARSTunerListener.asyncException(n, string, n2);
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
                    DSISDARSTunerListener dSISDARSTunerListener = (DSISDARSTunerListener)objectArray[i2];
                    Method method = dSISDARSTunerListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISDARSTunerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISDARSTunerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISDARSTunerListener, new Object[]{string, string2});
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

