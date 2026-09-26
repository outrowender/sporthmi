/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$AbstractDiagnosisPlugin;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$InfotainmentRecorderPlugin;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent$TestSupportPlugin;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisComponent
extends AbstractRemoteHMIComponent {
    private static final String PREFIX_SCREEN;
    private static final String PREFIX_CONTEXT;
    public static final int UPDATE_CONTEXT;
    public static final int UPDATE_VIEW;
    public static final int UPDATE_ONLINE_MEDIA_APPS;
    public static final int UPDATE_CONNECTED_DEVICES;
    public static final int UPDATE_ACTIVE_CONNECTED_DEVICE;
    public static final int UPDATE_LAST_MOBILE_APP_LIST_STATUS;
    public static final int UPDATE_RECEIVED_SUBSCRIBE_MESSAGE_COUNT;
    public static final int UPDATE_PARSED_MOBILE_APPS;
    public static final int UPDATE_LAST_BACKEND_ACCESS_STATUS;
    public static final int UPDATE_CGW_SERVICES;
    public static final int UPDATE_CGW_LICENCES_0;
    public static final int UPDATE_CGW_LICENCES_1;
    public static final int UPDATE_CGW_LICENCES_2;
    public static final int UPDATE_CGW_USERS;
    private List plugins = new ArrayList(2);

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.plugins.add(new DiagnosisComponent$TestSupportPlugin(this));
        this.plugins.add(new DiagnosisComponent$InfotainmentRecorderPlugin(this, null));
    }

    public void update(Object object, int n) {
        for (int i2 = 0; i2 < this.plugins.size(); ++i2) {
            ((DiagnosisComponent$AbstractDiagnosisPlugin)this.plugins.get(i2)).update(object, n);
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

    static /* synthetic */ Buffer access$100(DiagnosisComponent diagnosisComponent, List list, Buffer buffer, int n) {
        return diagnosisComponent.createBuffer(list, buffer, n);
    }
}

