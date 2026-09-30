/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OIDDatabase {
    private static OIDDatabase instance = new OIDDatabase();
    private Set oids = new HashSet();
    private Set algorithms = new HashSet();

    private OIDDatabase() {
        DBEntry dBEntry = new DBEntry("1.2.840.113549.1.1.2");
        DBEntry dBEntry2 = new DBEntry("MD2withRSA");
        this.wireTogether(dBEntry, dBEntry2);
        dBEntry = new DBEntry("1.2.840.113549.1.1.4");
        dBEntry2 = new DBEntry("MD5withRSA");
        this.wireTogether(dBEntry, dBEntry2);
        dBEntry = new DBEntry("1.2.840.113549.1.1.5");
        dBEntry2 = new DBEntry("SHA1withRSA");
        this.wireTogether(dBEntry, dBEntry2);
        dBEntry = new DBEntry("1.2.840.10040.4.3");
        dBEntry2 = new DBEntry("SHA1withDSA");
        this.wireTogether(dBEntry, dBEntry2);
        dBEntry = new DBEntry("1.3.14.3.2.26");
        dBEntry2 = new DBEntry("SHA");
        DBEntry dBEntry3 = new DBEntry("SHA-1");
        this.wireTogether(dBEntry, dBEntry2);
        this.wireTogether(dBEntry, dBEntry3);
        dBEntry = new DBEntry("1.2.840.113549.2.5");
        dBEntry2 = new DBEntry("MD5");
        this.wireTogether(dBEntry, dBEntry2);
        dBEntry = new DBEntry("1.2.840.113549.1.1.1");
        dBEntry2 = new DBEntry("RSA");
        this.wireTogether(dBEntry, dBEntry2);
        dBEntry = new DBEntry("1.2.840.10040.4.1");
        DBEntry dBEntry4 = new DBEntry("1.3.14.3.2.12");
        dBEntry2 = new DBEntry("DSA");
        this.wireTogether(dBEntry, dBEntry2);
        this.wireTogether(dBEntry4, dBEntry2);
        dBEntry = new DBEntry("1.2.840.10046.2.1");
        dBEntry2 = new DBEntry("DiffieHellman");
        this.wireTogether(dBEntry, dBEntry2);
    }

    private void wireTogether(DBEntry dBEntry, DBEntry dBEntry2) {
        this.oids.add(dBEntry);
        this.algorithms.add(dBEntry2);
        dBEntry.addEquivalent(dBEntry2);
        dBEntry2.addEquivalent(dBEntry);
    }

    public static OIDDatabase getInstance() {
        return instance;
    }

    public String getFirstAlgorithmForOID(String string) {
        String string2 = null;
        Iterator iterator = this.getAllAlgorithmsForOID(string).iterator();
        if (iterator.hasNext()) {
            string2 = (String)iterator.next();
        }
        return string2;
    }

    public Set getAllAlgorithmsForOID(String string) {
        Set set = null;
        Iterator iterator = this.oids.iterator();
        set = this.getAllEquivalents(string, iterator);
        if (set == null) {
            throw new IllegalArgumentException("Unknown OID : " + string);
        }
        return set;
    }

    public String getFirstOIDForAlgorithm(String string) {
        String string2 = null;
        Iterator iterator = this.getAllOIDsForAlgorithm(string).iterator();
        if (iterator.hasNext()) {
            string2 = (String)iterator.next();
        }
        return string2;
    }

    public Set getAllOIDsForAlgorithm(String string) {
        Set set = null;
        Iterator iterator = this.algorithms.iterator();
        set = this.getAllEquivalents(string, iterator);
        if (set == null) {
            throw new IllegalArgumentException("Unsupported algorithm : " + string);
        }
        return set;
    }

    private Set getAllEquivalents(String string, Iterator iterator) {
        HashSet hashSet = null;
        while (iterator.hasNext()) {
            DBEntry dBEntry = (DBEntry)iterator.next();
            if (!dBEntry.getValue().equals(string)) continue;
            Set set = dBEntry.getAllEquivalents();
            hashSet = new HashSet();
            Iterator iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                DBEntry dBEntry2 = (DBEntry)iterator2.next();
                hashSet.add(dBEntry2.getValue());
            }
        }
        return hashSet;
    }

    static class DBEntry {
        private List equivalents = new LinkedList();
        private String value;

        DBEntry(String string) {
            this.value = string;
        }

        void addEquivalent(DBEntry dBEntry) {
            this.equivalents.add(dBEntry);
        }

        String getValue() {
            return this.value;
        }

        Set getAllEquivalents() {
            return new HashSet(this.equivalents);
        }
    }
}

