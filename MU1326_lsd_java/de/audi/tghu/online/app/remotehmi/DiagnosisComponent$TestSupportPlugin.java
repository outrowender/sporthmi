/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$AbstractDiagnosisPlugin;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.osgi.framework.BundleContext;

class DiagnosisComponent$TestSupportPlugin
extends DiagnosisComponent$AbstractDiagnosisPlugin
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
    private final /* synthetic */ DiagnosisComponent this$0;

    public DiagnosisComponent$TestSupportPlugin(DiagnosisComponent diagnosisComponent) {
        this.this$0 = diagnosisComponent;
        super(diagnosisComponent, null);
        this.onlineMediaApps = new ArrayList();
        this.connectedDevices = new String[0];
        BundleContext bundleContext = diagnosisComponent.remoteHmiService.getFrameworkAccess().getBundleCxt();
        this.testSupportHandler = new TestSupportHandler("RemoteHMI - View Options", true, false, this, bundleContext, diagnosisComponent.logChannel);
        this.testSupportHandler.init();
    }

    @Override
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
        DiagnosisComponent.access$100(this.this$0, this.onlineMediaApps, buffer3, 2);
        List list = Arrays.asList(this.connectedDevices);
        Buffer buffer4 = new Buffer("Connected Devices: ");
        DiagnosisComponent.access$100(this.this$0, list, buffer4, 3);
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

    @Override
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

    @Override
    public void commandEntrySelected(int n) {
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }
}

