/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.irc.InfotainmentRecorder;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.osgi.framework.BundleContext;

public class DiagnosisComponent
extends AbstractRemoteHMIComponent {
    private static final String PREFIX_SCREEN = "rs:";
    private static final String PREFIX_CONTEXT = "r:";
    public static final int UPDATE_CONTEXT = 0;
    public static final int UPDATE_VIEW = 1;
    public static final int UPDATE_ONLINE_MEDIA_APPS = 2;
    public static final int UPDATE_CONNECTED_DEVICES = 3;
    public static final int UPDATE_ACTIVE_CONNECTED_DEVICE = 4;
    public static final int UPDATE_LAST_MOBILE_APP_LIST_STATUS = 5;
    public static final int UPDATE_RECEIVED_SUBSCRIBE_MESSAGE_COUNT = 6;
    public static final int UPDATE_PARSED_MOBILE_APPS = 7;
    public static final int UPDATE_LAST_BACKEND_ACCESS_STATUS = 8;
    public static final int UPDATE_CGW_SERVICES = 9;
    public static final int UPDATE_CGW_LICENCES_0 = 10;
    public static final int UPDATE_CGW_LICENCES_1 = 11;
    public static final int UPDATE_CGW_LICENCES_2 = 12;
    public static final int UPDATE_CGW_USERS = 13;
    private List plugins = new ArrayList(2);

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.plugins.add(new TestSupportPlugin());
        this.plugins.add(new InfotainmentRecorderPlugin());
    }

    public void update(Object object, int n) {
        for (int i2 = 0; i2 < this.plugins.size(); ++i2) {
            ((AbstractDiagnosisPlugin)this.plugins.get(i2)).update(object, n);
        }
    }

    private Buffer createBuffer(List list, Buffer buffer, int n) {
        int n2;
        int n3 = n2 = list == null ? 0 : list.size();
        if (n2 > 0) {
            int n4 = n2;
            for (int i2 = 0; i2 < n4; ++i2) {
                if (i2 > 0) {
                    buffer.append(", ");
                }
                if (n == 2) {
                    OnlineApplicationOtherContext onlineApplicationOtherContext = (OnlineApplicationOtherContext)list.get(i2);
                    buffer.append(onlineApplicationOtherContext == null ? "NULL" : onlineApplicationOtherContext.getAppName());
                    continue;
                }
                if (n != 3) continue;
                buffer.append((String)list.get(i2));
            }
        } else {
            buffer.append("0");
        }
        return buffer;
    }

    private class TestSupportPlugin
    extends AbstractDiagnosisPlugin
    implements ITestSupportHandlerNotification {
        private ITestSupportHandler testSupportHandler;
        private boolean visible;
        private String contextName;
        private String viewId;
        private ArrayList onlineMediaApps;
        private String[] connectedDevices;
        private String activeConnectedDevice;
        private String lastMobileAppListDownloadStatus;
        private String receivedSubscribeMessagesCount;
        private String parsedMobileApps;
        private String lastBackendAccessStatus;
        private String cgwServices;
        private String cgwLicences0;
        private String cgwLicences1;
        private String cgwLicences2;
        private String cgwUsers;

        public TestSupportPlugin() {
            this.onlineMediaApps = new ArrayList();
            this.connectedDevices = new String[0];
            BundleContext bundleContext = DiagnosisComponent.this.remoteHmiService.getFrameworkAccess().getBundleCxt();
            this.testSupportHandler = new TestSupportHandler("RemoteHMI - View Options", true, false, this, bundleContext, DiagnosisComponent.this.logChannel);
            this.testSupportHandler.init();
        }

        public void debugDataVisible(boolean bl) {
            this.visible = bl;
            if (this.testSupportHandler == null) {
                return;
            }
            this.updateData();
        }

        private void updateData() {
            if (!this.visible || this.testSupportHandler == null) {
                return;
            }
            Buffer buffer = new Buffer("Context: ");
            buffer.append(this.contextName);
            Buffer buffer2 = new Buffer("View: ");
            buffer2.append(this.viewId);
            Buffer buffer3 = new Buffer("Last sent OM Apps: ");
            DiagnosisComponent.this.createBuffer(this.onlineMediaApps, buffer3, 2);
            List list = Arrays.asList(this.connectedDevices);
            Buffer buffer4 = new Buffer("Connected Devices: ");
            DiagnosisComponent.this.createBuffer(list, buffer4, 3);
            Buffer buffer5 = new Buffer("Active Device: ");
            buffer5.append(this.activeConnectedDevice);
            Buffer buffer6 = new Buffer("Download status (mobile): ");
            buffer6.append(this.lastMobileAppListDownloadStatus);
            Buffer buffer7 = new Buffer("Subscribe Messages: ");
            buffer7.append(this.receivedSubscribeMessagesCount);
            Buffer buffer8 = new Buffer("Parsed Mobile Applist: ");
            buffer8.append(this.parsedMobileApps);
            Buffer buffer9 = new Buffer("Last Backend Access Status: ");
            buffer9.append(this.lastBackendAccessStatus);
            Buffer buffer10 = new Buffer("CGW Services: ");
            buffer10.append(this.cgwServices);
            Buffer buffer11 = new Buffer("CGW  License0: ");
            buffer11.append(this.cgwLicences0);
            Buffer buffer12 = new Buffer("CGW  License1: ");
            buffer12.append(this.cgwLicences1);
            Buffer buffer13 = new Buffer("CGW  License2: ");
            buffer13.append(this.cgwLicences2);
            Buffer buffer14 = new Buffer("CGW  Users: ");
            buffer14.append(this.cgwUsers);
            this.testSupportHandler.updateData(new String[]{buffer.toString(), buffer2.toString(), buffer3.toString(), buffer4.toString(), buffer5.toString(), buffer6.toString(), buffer7.toString(), buffer8.toString(), buffer9.toString(), buffer10.toString(), buffer11.toString(), buffer12.toString(), buffer13.toString(), buffer14.toString()});
        }

        public void update(Object object, int n) {
            switch (n) {
                case 0: {
                    this.contextName = (String)object;
                    break;
                }
                case 1: {
                    this.viewId = (String)object;
                    break;
                }
                case 2: {
                    this.onlineMediaApps = (ArrayList)object;
                    break;
                }
                case 3: {
                    this.connectedDevices = (String[])object;
                    break;
                }
                case 4: {
                    this.activeConnectedDevice = (String)object;
                    break;
                }
                case 5: {
                    this.lastMobileAppListDownloadStatus = (String)object;
                    break;
                }
                case 6: {
                    this.receivedSubscribeMessagesCount = (String)object;
                    break;
                }
                case 7: {
                    this.parsedMobileApps = (String)object;
                    break;
                }
                case 8: {
                    this.lastBackendAccessStatus = (String)object;
                    break;
                }
                case 9: {
                    this.cgwServices = (String)object;
                    break;
                }
                case 10: {
                    this.cgwLicences0 = (String)object;
                    break;
                }
                case 11: {
                    this.cgwLicences1 = (String)object;
                    break;
                }
                case 12: {
                    this.cgwLicences2 = (String)object;
                    break;
                }
                case 13: {
                    this.cgwUsers = (String)object;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("TestSupportPlugin#update: update mode not defined: ").append(n).toString());
                }
            }
            this.updateData();
        }

        public void commandEntrySelected(int n) {
        }

        public TestSupportDataReceiverEntry[] getCommandEntries() {
            return new TestSupportDataReceiverEntry[0];
        }
    }

    private abstract class AbstractDiagnosisPlugin {
        private AbstractDiagnosisPlugin() {
        }

        public abstract void update(Object var1, int var2);
    }

    private class InfotainmentRecorderPlugin
    extends AbstractDiagnosisPlugin {
        private InfotainmentRecorderPlugin() {
        }

        public void update(Object object, int n) {
            String string;
            switch (n) {
                case 0: {
                    Buffer buffer = new Buffer();
                    buffer.append(DiagnosisComponent.PREFIX_CONTEXT);
                    buffer.append((String)object);
                    string = buffer.toString();
                    break;
                }
                case 1: {
                    Buffer buffer = new Buffer();
                    buffer.append(DiagnosisComponent.PREFIX_SCREEN);
                    buffer.append((String)object);
                    string = buffer.toString();
                    break;
                }
                case 2: {
                    Buffer buffer = new Buffer("Last sent OM Apps: ");
                    DiagnosisComponent.this.createBuffer((List)object, buffer, 2);
                    string = buffer.toString();
                    break;
                }
                case 3: {
                    List list = Arrays.asList((String[])object);
                    Buffer buffer = new Buffer("Connected Devices: ");
                    DiagnosisComponent.this.createBuffer(list, buffer, 3);
                    string = buffer.toString();
                    break;
                }
                case 4: {
                    string = (String)object;
                    break;
                }
                case 5: {
                    string = (String)object;
                    break;
                }
                case 6: {
                    string = (String)object;
                    break;
                }
                case 7: {
                    string = (String)object;
                    break;
                }
                case 8: {
                    string = (String)object;
                    break;
                }
                case 9: {
                    string = (String)object;
                    break;
                }
                case 10: {
                    string = (String)object;
                    break;
                }
                case 11: {
                    string = (String)object;
                    break;
                }
                case 12: {
                    string = (String)object;
                    break;
                }
                case 13: {
                    string = (String)object;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("TestSupportPlugin#update: update mode not defined: ").append(n).toString());
                }
            }
            this.logToIRC(string);
        }

        private void logToIRC(String string) {
            InfotainmentRecorder infotainmentRecorder = DiagnosisComponent.this.remoteHmiService.getFrameworkAccess().getInfotainmentrecorder();
            if (infotainmentRecorder == null) {
                DiagnosisComponent.this.logChannel.log(100000, "InfotainmentRecorderComponent#logToIRC: infotainment recorder not available");
                return;
            }
            if (string == null) {
                return;
            }
            if (string.length() > 30) {
                string = string.substring(0, 30);
            }
            infotainmentRecorder.logRemoteHMI(string);
        }
    }
}

