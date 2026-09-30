/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.agent.directory.IServiceDirectory;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class VolatileServiceDirectory
implements IServiceDirectory {
    protected List serviceList = new ArrayList();

    private ServiceLocator find(ServiceInstanceID serviceInstanceID) {
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            ServiceLocator serviceLocator = (ServiceLocator)listIterator.next();
            if (!serviceLocator.getServiceInstanceID().equals(serviceInstanceID)) continue;
            return serviceLocator;
        }
        return null;
    }

    public synchronized DirectoryEntry[] locateService(ServiceInstanceID serviceInstanceID) {
        ServiceLocator serviceLocator = this.find(serviceInstanceID);
        if (serviceLocator == null) {
            CommAgentTracing.DIRECTORY.log((short)1, "locateService: %1 not found ", serviceInstanceID);
            return null;
        }
        DirectoryEntry[] directoryEntryArray = serviceLocator.getEntryList();
        CommAgentTracing.DIRECTORY.log((short)1, "locateService: service %1 found on %2", serviceInstanceID, (Object)directoryEntryArray);
        return directoryEntryArray;
    }

    public synchronized void addEmptyService(ServiceInstanceID serviceInstanceID) {
        CommAgentTracing.DIRECTORY.log((short)1, "registerService: add empty service %1 to remember look up", serviceInstanceID);
        ServiceLocator serviceLocator = this.find(serviceInstanceID);
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator(serviceInstanceID);
            this.serviceList.add(serviceLocator);
        }
    }

    public synchronized void registerService(DirectoryEntry directoryEntry) {
        DirectoryEntry directoryEntry2;
        ServiceInstanceID serviceInstanceID = directoryEntry.getServiceInstanceID();
        ServiceLocator serviceLocator = this.find(serviceInstanceID);
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator(serviceInstanceID);
            this.serviceList.add(serviceLocator);
        }
        if ((directoryEntry2 = serviceLocator.findSame(directoryEntry)) == null) {
            serviceLocator.addEntry(directoryEntry);
            CommAgentTracing.DIRECTORY.log((short)1, "registerService: %1", directoryEntry);
        }
    }

    public synchronized void unregisterService(DirectoryEntry directoryEntry) {
        ServiceInstanceID serviceInstanceID = directoryEntry.getServiceInstanceID();
        ServiceLocator serviceLocator = this.find(serviceInstanceID);
        if (serviceLocator != null) {
            serviceLocator.removeEntry(directoryEntry);
            if (serviceLocator.isEmpty()) {
                this.serviceList.remove(serviceLocator);
            }
            CommAgentTracing.DIRECTORY.log((short)1, "unregisterService: %1", directoryEntry);
        }
    }

    public synchronized DirectoryEntry[] getAllEntries() {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            objectArray = (Object[])listIterator.next();
            DirectoryEntry[] directoryEntryArray = objectArray.getEntryList();
            if (directoryEntryArray == null) continue;
            for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                arrayList.add(directoryEntryArray[i2]);
            }
        }
        objectArray = new DirectoryEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public synchronized DirectoryEntry[] removeAllEntriesOfPeer(short s) {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            objectArray = (Object[])listIterator.next();
            DirectoryEntry[] directoryEntryArray = objectArray.getEntryList();
            if (directoryEntryArray == null) continue;
            DirectoryEntry directoryEntry = null;
            for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                if (directoryEntryArray[i2].getAgentID() != s) continue;
                directoryEntry = directoryEntryArray[i2];
                break;
            }
            if (directoryEntry == null) continue;
            objectArray.removeEntry(directoryEntry);
            arrayList.add(directoryEntry);
            if (!objectArray.isEmpty()) continue;
            listIterator.remove();
        }
        objectArray = new DirectoryEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public synchronized ServiceInstanceID[] getAllEmptyEntries() {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            objectArray = (Object[])listIterator.next();
            if (!objectArray.isEmpty()) continue;
            arrayList.add(objectArray.getServiceInstanceID());
        }
        objectArray = new ServiceInstanceID[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public synchronized void dumpDirectory(short s) {
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            ServiceLocator serviceLocator = (ServiceLocator)listIterator.next();
            ServiceInstanceID serviceInstanceID = serviceLocator.getServiceInstanceID();
            DirectoryEntry[] directoryEntryArray = serviceLocator.getEntryList();
            if (directoryEntryArray == null) continue;
            for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                short s2 = directoryEntryArray[i2].getAgentID();
                if (s2 == 0) {
                    s2 = s;
                }
                CommAgentTracing.COMM.log((short)2, "on='%1' event='interface-status' interface='%2:%3' home='%4' ", new Short(s), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)new Short(s2));
            }
        }
    }

    public ServiceLocatorInfo[] createServiceLocatorInfos() {
        DirectoryEntry[] directoryEntryArray = this.getAllEntries();
        if (directoryEntryArray == null) {
            return null;
        }
        int n = directoryEntryArray.length;
        ServiceLocatorInfo[] serviceLocatorInfoArray = new ServiceLocatorInfo[n];
        for (int i2 = 0; i2 < n; ++i2) {
            serviceLocatorInfoArray[i2] = new ServiceLocatorInfo(i2, directoryEntryArray[i2]);
        }
        return serviceLocatorInfoArray;
    }

    protected static class ServiceLocator {
        protected List entries;
        protected ServiceInstanceID instanceID;

        public ServiceLocator(ServiceInstanceID serviceInstanceID) {
            this.instanceID = serviceInstanceID;
            this.entries = new ArrayList();
        }

        public ServiceInstanceID getServiceInstanceID() {
            return this.instanceID;
        }

        public void addEntry(DirectoryEntry directoryEntry) {
            this.entries.add(directoryEntry);
        }

        public DirectoryEntry findSame(DirectoryEntry directoryEntry) {
            ListIterator listIterator = this.entries.listIterator();
            while (listIterator.hasNext()) {
                DirectoryEntry directoryEntry2 = (DirectoryEntry)listIterator.next();
                if (!directoryEntry2.equals(directoryEntry)) continue;
                return directoryEntry2;
            }
            return null;
        }

        public void removeEntry(DirectoryEntry directoryEntry) {
            DirectoryEntry directoryEntry2 = this.findSame(directoryEntry);
            if (directoryEntry2 != null) {
                this.entries.remove(directoryEntry2);
            }
        }

        public boolean isEmpty() {
            return this.entries.isEmpty();
        }

        public DirectoryEntry[] getEntryList() {
            DirectoryEntry[] directoryEntryArray = new DirectoryEntry[this.entries.size()];
            ListIterator listIterator = this.entries.listIterator();
            int n = 0;
            while (listIterator.hasNext()) {
                DirectoryEntry directoryEntry = (DirectoryEntry)listIterator.next();
                directoryEntryArray[n++] = directoryEntry;
            }
            return directoryEntryArray;
        }
    }
}

