/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.osgi;

import de.audi.app.sdsmanager.dictation.osgi.DsiDescriptor;
import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public interface IServiceRegistry {
    public ServiceRegistration registerService(String var1, Object var2, Dictionary var3);

    public ServiceRegistration registerService(String[] var1, Object var2, Dictionary var3);

    public void addTracker(ServiceTracker var1);

    public void startDsiService(DsiDescriptor var1);
}

