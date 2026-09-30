/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelDialNumberSessionHandler;
import de.audi.app.phone.core.interapp.TelServiceListenerWrapper;
import de.audi.app.phone.core.interapp.TelServiceSDSListenerWrapper;
import de.audi.app.phone.core.sim.ITelLockStateHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.ITelServiceSDSListener;
import de.audi.atip.phone.TelServiceCallStackEntry;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.Calendar;
import java.util.Hashtable;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractPhoneServiceImpl
extends AbstractPhoneComponent
implements ITelServiceSDS,
ServiceTrackerCustomizer {
    private volatile PhoneServiceProvider sdsPhoneService;
    private volatile PhoneServiceProvider phoneService;
    protected volatile IGlobalTelephoneStateStruct globalState;
    private volatile PhoneServiceTracker lockStateHandlerServiceTracker;
    private volatile ITelLockStateHandler lockStateHandlerService;
    private final TelDialNumberSessionHandler dialNumberSessionHandler;
    static /* synthetic */ Class class$de$audi$app$phone$core$sim$ITelLockStateHandler;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceSDS;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;

    public AbstractPhoneServiceImpl(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.dialNumberSessionHandler = new TelDialNumberSessionHandler(iTelApplication);
        this.addSubPhoneComponent(this.dialNumberSessionHandler);
    }

    public void init() {
        super.init();
        this.getApplication().addDiagnosisComponent(new PhoneServiceDiag());
        this.registerPhoneService();
        this.registerPhoneServiceSDS();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.lockStateHandlerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$app$phone$core$sim$ITelLockStateHandler == null ? (class$de$audi$app$phone$core$sim$ITelLockStateHandler = AbstractPhoneServiceImpl.class$("de.audi.app.phone.core.sim.ITelLockStateHandler")) : class$de$audi$app$phone$core$sim$ITelLockStateHandler).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.lockStateHandlerServiceTracker.openTracker();
    }

    public void deinit() {
        super.deinit();
        if (this.sdsPhoneService != null) {
            this.sdsPhoneService.stopService();
        }
        if (this.phoneService != null) {
            this.phoneService.stopService();
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        if (this.lockStateHandlerServiceTracker != null) {
            this.lockStateHandlerServiceTracker.closeTracker();
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof ITelLockStateHandler) {
            this.lockStateHandlerService = (ITelLockStateHandler)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITelLockStateHandler) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.lockStateHandlerService = null;
        }
    }

    private void registerPhoneServiceSDS() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.sdsPhoneService = new PhoneServiceProvider((class$de$audi$atip$phone$ITelServiceSDS == null ? (class$de$audi$atip$phone$ITelServiceSDS = AbstractPhoneServiceImpl.class$("de.audi.atip.phone.ITelServiceSDS")) : class$de$audi$atip$phone$ITelServiceSDS).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.sdsPhoneService.startService();
    }

    private void registerPhoneService() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.phoneService = new PhoneServiceProvider((class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = AbstractPhoneServiceImpl.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.phoneService.startService();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.globalState = iGlobalTelephoneStateStruct;
    }

    public void dialNumber(final String string, final ITelServiceListener iTelServiceListener, final boolean bl) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("AbstractPhoneServiceImpl#dialNumber"){

            public void run() {
                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumber] number=%1, jumpToPhone=%2", (Object)string, (Object)String.valueOf(bl));
                AbstractPhoneServiceImpl.this.getApplication().getTelephoneDSIAccess().dialNumber(string, 0, true, new TelDefaultDSIResponseListener(){

                    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                        ITelDSIResponseListener iTelDSIResponseListener;
                        ITelDSIResponseListener iTelDSIResponseListener2 = iTelDSIResponseListener = iTelServiceListener != null ? new TelServiceListenerWrapper(iTelServiceListener) : AbstractPhoneServiceImpl.this.getApplication().getDefaultListener();
                        if (iTelDSIResponseListener != null) {
                            iTelDSIResponseListener.responseDialNumber(n, n2, suppServiceResponseStruct, n3);
                        }
                        if (n == 0) {
                            if (bl) {
                                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl.dialNumber] RESULT_OK - switching to phone!");
                                AbstractPhoneServiceImpl.this.triggerJumpToPhone();
                            } else {
                                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumber] RESULT_OK - jumpToPhone false.");
                            }
                        } else {
                            AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumber] result=%1", (long)n);
                        }
                    }
                });
            }
        });
    }

    public void dialNumberFromADBEntry(final String string, final String string2, final short s, final short s2, final long l, final ResourceLocator resourceLocator, final int n, final int n2, final ITelServiceListener iTelServiceListener, final boolean bl) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("AbstractPhoneServiceImpl#dialNumberFromADBEntry"){

            public void run() {
                if (AbstractPhoneServiceImpl.this.log.isDebug()) {
                    Buffer buffer = new Buffer();
                    buffer.append("name=");
                    buffer.append(string);
                    buffer.append(", ");
                    buffer.append("number=");
                    buffer.append(string2);
                    buffer.append(", ");
                    buffer.append("phoneType=");
                    buffer.append(s);
                    buffer.append(", ");
                    buffer.append("entryType=");
                    buffer.append(s2);
                    buffer.append(", ");
                    buffer.append("entryID=");
                    buffer.append(l);
                    buffer.append(", ");
                    buffer.append("pictureLocator=");
                    buffer.append(resourceLocator);
                    buffer.append(", ");
                    buffer.append("phoneNumberIndex=");
                    buffer.append(n);
                    buffer.append(", ");
                    buffer.append("phoneDataCount=");
                    buffer.append(n2);
                    buffer.append("jumpToPhone=");
                    buffer.append(bl);
                    AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumberFromADBEntry] %1", (Object)buffer);
                }
                AbstractPhoneServiceImpl.this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(string2, l, string, s, s2, resourceLocator, n, n2, 0, true, new TelDefaultDSIResponseListener(){

                    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                        ITelDSIResponseListener iTelDSIResponseListener;
                        ITelDSIResponseListener iTelDSIResponseListener2 = iTelDSIResponseListener = iTelServiceListener != null ? new TelServiceListenerWrapper(iTelServiceListener) : AbstractPhoneServiceImpl.this.getApplication().getDefaultListener();
                        if (iTelDSIResponseListener != null) {
                            iTelDSIResponseListener.responseDialNumber(n, n2, suppServiceResponseStruct, n3);
                        }
                        if (n == 0) {
                            if (bl) {
                                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl.dialNumberFromADBEntry] RESULT_OK - switching to phone!");
                                AbstractPhoneServiceImpl.this.triggerJumpToPhone();
                            } else {
                                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumberFromADBEntry] RESULT_OK - jumpToPhone false.");
                            }
                        } else {
                            AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumberFromADBEntry] result=%1", (long)n);
                        }
                    }
                });
            }
        });
    }

    private void triggerJumpToPhone() {
        PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
    }

    public void dialNumber(final ITelCallSession iTelCallSession, final boolean bl) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("AbstractPhoneServiceImpl#dialNumber call session"){

            public void run() {
                if (iTelCallSession != null) {
                    String string = iTelCallSession.getTelephoneNumber();
                    int n = iTelCallSession.getCallType();
                    AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#dialNumber] number=%1, type=%2", (Object)string, (long)n);
                    if (n == 0) {
                        AbstractPhoneServiceImpl.this.dialNumberSessionHandler.addSession(iTelCallSession);
                        AbstractPhoneServiceImpl.this.dialNumber(string, null, bl);
                    } else if (n == 1 || n == 196608 || n == 131072 || n == 65536) {
                        AbstractPhoneServiceImpl.this.dialNumberSessionHandler.addSession(iTelCallSession);
                        AbstractPhoneServiceImpl.this.getApplication().getTelephoneDSIAccess().dialOperator(string, n, 0);
                    } else {
                        AbstractPhoneServiceImpl.this.log.log(100000, "[AbstractPhoneServiceImpl#dialNumber] callType=%1 --> NOP!", (long)n);
                    }
                } else {
                    AbstractPhoneServiceImpl.this.log.log(100000, "[AbstractPhoneServiceImpl#dialNumber] callSession is null --> NOP!");
                }
            }
        });
    }

    public boolean checkForSuppService(String string) {
        boolean bl = string != null && ('*' == string.charAt(0) || '#' == string.charAt(0));
        this.log.log(1000000, "[AbstractPhoneServiceImpl#checkForSuppService] number=%1, suppService=%2", (Object)string, (Object)String.valueOf(bl));
        return bl;
    }

    public String getPINSpellerContent() {
        String string = this.getSpellerModel(300594).getText();
        this.log.log(1000000, "[AbstractPhoneServiceImpl#getPINSpellerContent] pinText=%1", (Object)string);
        return string;
    }

    public void setPINSpeller(final String string) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("AbstractPhoneServiceImpl#setPINSpeller"){

            public void run() {
                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#setPINSpeller] setting pin speller text to %1", (Object)string);
                ITelLockStateHandler iTelLockStateHandler = AbstractPhoneServiceImpl.this.lockStateHandlerService;
                if (iTelLockStateHandler != null) {
                    iTelLockStateHandler.setPINSpeller(string);
                } else {
                    AbstractPhoneServiceImpl.this.log.log(100000, "[AbstractPhoneServiceImpl#setPINSpeller] lock handler is null --> NOP!");
                }
            }
        });
    }

    public String getMailboxSpellerContent() {
        String string = this.getSpellerModel(301156).getText();
        this.log.log(1000000, "[AbstractPhoneServiceImpl#getMailboxSpellerContent] mailboxSpellerText=%1", (Object)string);
        return string;
    }

    public void setMailboxSpeller(final String string) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("AbstractPhoneServiceImpl#setMailboxSpeller"){

            public void run() {
                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#setMailboxSpeller] setting mailbox speller text to %1", (Object)string);
                AbstractPhoneServiceImpl.this.getSpellerModel(301156).setText(string);
                if (string != null && string.length() > 0) {
                    AbstractPhoneServiceImpl.this.getButtonModel(300418).setStatus(1);
                } else {
                    AbstractPhoneServiceImpl.this.getButtonModel(300418).setStatus(0);
                }
            }
        });
    }

    public void setMailboxNumber(String string, ITelServiceSDSListener iTelServiceSDSListener) {
        this.log.log(1000000, "[AbstractPhoneServiceImpl#setMailboxNumber] setting mailbox number to %1", (Object)string);
        this.getApplication().getTelephoneDSIAccess().requestSetMailboxNumber(string, 0, true, iTelServiceSDSListener != null ? new TelServiceSDSListenerWrapper(iTelServiceSDSListener) : this.getApplication().getDefaultListener());
    }

    public void unlockSIMWithPIN(final String string, final ITelServiceSDSListener iTelServiceSDSListener) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("AbstractPhoneServiceImpl#unlockSIMWithPIN"){

            public void run() {
                AbstractPhoneServiceImpl.this.log.log(1000000, "[AbstractPhoneServiceImpl#unlockSIMWithPIN] pinCode=%1", (Object)string);
                ITelLockStateHandler iTelLockStateHandler = AbstractPhoneServiceImpl.this.lockStateHandlerService;
                if (iTelLockStateHandler != null) {
                    iTelLockStateHandler.unlockSIMwithPIN(string, 0, iTelServiceSDSListener != null ? new TelServiceSDSListenerWrapper(iTelServiceSDSListener) : AbstractPhoneServiceImpl.this.getApplication().getDefaultListener());
                } else {
                    AbstractPhoneServiceImpl.this.log.log(100000, "[AbstractPhoneServiceImpl#unlockSIMWithPIN] lock handler is null --> NOP!");
                }
            }
        });
    }

    public String getMailboxNumber() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.globalState;
        if (iGlobalTelephoneStateStruct != null) {
            String string = iGlobalTelephoneStateStruct.getMailboxNumber();
            this.log.log(1000000, "[AbstractPhoneServiceImpl#getMailboxNumber] mailboxNumber=%1", (Object)string);
            return string;
        }
        return null;
    }

    public TelServiceCallStackEntry getLastDialedNumber() {
        CallStackEntry callStackEntry;
        TelServiceCallStackEntry telServiceCallStackEntry = null;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.globalState;
        if (iGlobalTelephoneStateStruct != null && (callStackEntry = iGlobalTelephoneStateStruct.getLastDialedNumber()) != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(callStackEntry.getClYear(), callStackEntry.getClMonth() - 1, callStackEntry.getClDay(), callStackEntry.getClHour(), callStackEntry.getClMinute(), callStackEntry.getClSecond());
            telServiceCallStackEntry = new TelServiceCallStackEntry(callStackEntry.getClEntryID(), callStackEntry.getClName(), callStackEntry.getClNumber(), callStackEntry.getAdbEntryID(), (short)callStackEntry.getAdbNumberType(), 0, callStackEntry.getAdbPictureID(), callStackEntry.getAdbPhoneDataIndex(), callStackEntry.getAdbPhoneDataCount(), calendar.getTime());
        }
        this.log.log(1000000, "[AbstractPhoneServiceImpl#getLastDialedNumber] lastDialedNumber=%1", telServiceCallStackEntry);
        return telServiceCallStackEntry;
    }

    protected BaseListModelApp getSDSPickListModel() {
        return this.getBaseListModel(3938);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class PhoneServiceDiag
    implements IPhoneDiagComponent {
        private ITelCallControl sessionControl;

        private PhoneServiceDiag() {
        }

        public void cmdPhoneServiceDialNumberSession(final String string, final int n, boolean bl) {
            AbstractPhoneServiceImpl.this.dialNumber(new ITelCallSession(){

                public void updateCallInformation(ITelCallInformation iTelCallInformation, int n2) {
                    AbstractPhoneServiceImpl.this.log.log(10000000, "[AbstractPhoneServiceImpl.PhoneServiceDiag.cmdPhoneServiceDialNumberSession(...).new ITelCallSession() {...}#updateCallInformation] callInformation=%1", (Object)iTelCallInformation);
                }

                public void onClose() {
                    AbstractPhoneServiceImpl.this.log.log(10000000, "[AbstractPhoneServiceImpl.PhoneServiceDiag.cmdPhoneServiceDialNumberSession(...).new ITelCallSession() {...}#onClose]");
                }

                public void onActive(ITelCallControl iTelCallControl) {
                    AbstractPhoneServiceImpl.this.log.log(10000000, "[AbstractPhoneServiceImpl.PhoneServiceDiag.cmdPhoneServiceDialNumberSession(...).new ITelCallSession() {...}#onActive] callControl=%1", (Object)iTelCallControl);
                    PhoneServiceDiag.this.sessionControl = iTelCallControl;
                }

                public String getTelephoneNumber() {
                    return string;
                }

                public int getCallType() {
                    return n;
                }
            }, bl);
        }

        public void cmdPhoneServiceHangupSession() {
            ITelCallControl iTelCallControl = this.sessionControl;
            if (iTelCallControl != null) {
                iTelCallControl.hangupCall();
            }
        }
    }
}

