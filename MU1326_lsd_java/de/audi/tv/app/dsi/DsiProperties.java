/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class DsiProperties {
    public final DSICallListener dsiDownListener = new DsiDownListener();
    public final DefaultTVListener dsiUpListener = new DsiUpListener();
    private final Properties myProperties;

    public DsiProperties(TVEnv tVEnv) {
        this.myProperties = tVEnv.properties.dsiProperties;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final ReadOnlyProperty<ServiceInfo> selectService;
        public final ReadOnlyProperty<ServiceInfo> selectedService;
        public final ReadOnlyProperty<ProgramInfo> selectedProgram;
        public final ReadOnlyProperty<Integer> selectedProgramCasStatus;
        public final ReadOnlyProperty<ServiceInfo> selectAndSelectedService;

        public Properties(PropertyFactory propertyFactory) {
            this.selectService = propertyFactory.createProperty("DsiProperties.selectService");
            this.selectedService = propertyFactory.createProperty("DsiProperties.selectedService");
            this.selectedProgram = propertyFactory.createProperty("DsiProperties.selectedProgram");
            this.selectedProgramCasStatus = propertyFactory.createProperty("DsiProperties.selectedProgramCasStatus", new Integer(0));
            this.selectAndSelectedService = propertyFactory.createProperty("DsiProperties.selectAndselectedService");
            this.selectService.subscribe(this.writeableSelectAndSelectedService());
            this.selectedService.subscribe(this.writeableSelectAndSelectedService());
        }

        private Property<ServiceInfo> writeableSelectService() {
            return (Property)this.selectService;
        }

        private Property<ServiceInfo> writeableSelectedService() {
            return (Property)this.selectedService;
        }

        private Property<ProgramInfo> writeableSelectedProgram() {
            return (Property)this.selectedProgram;
        }

        private Property<ServiceInfo> writeableSelectAndSelectedService() {
            return (Property)this.selectAndSelectedService;
        }

        private Property<Integer> writeableSelectedProgramCasStatus() {
            return (Property)this.selectedProgramCasStatus;
        }
    }

    public class DsiUpListener
    extends DefaultTVListener {
        public void updateSelectedService(ProgramInfo programInfo) {
            DsiProperties.this.myProperties.writeableSelectedService().accept(programInfo.serviceInfo);
            DsiProperties.this.myProperties.writeableSelectedProgram().accept(programInfo);
            DsiProperties.this.myProperties.writeableSelectedProgramCasStatus().accept(new Integer(programInfo.casStatus));
        }
    }

    public class DsiDownListener
    extends DSICallListener {
        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            DsiProperties.this.myProperties.writeableSelectService().accept(serviceInfo);
        }
    }
}

