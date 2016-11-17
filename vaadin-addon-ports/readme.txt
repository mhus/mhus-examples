
In Karaf:

# Install dependencies

feature:repo-add activemq 5.12.1
feature:repo-add cxf 3.1.5
feature:repo-add mvn:de.mhus.osgi/mhu-karaf-feature/1.3.1-SNAPSHOT/xml/features

feature:install mhu-osgi-full

install -s mvn:de.mhus.ports/vaadin-viritin/1.3.1-SNAPSHOT
install -s mvn:de.mhus.ports/vaadin-easyuploads/1.3.1-SNAPSHOT
install -s mvn:de.mhus.ports/vaadin-aceeditor/1.3.1-SNAPSHOT
install -s mvn:de.mhus.ports/vaadin-borderlayout/1.3.1-SNAPSHOT
install -s mvn:de.mhus.ports/vaadin-jfreechart/1.3.1-SNAPSHOT
install -s mvn:de.mhus.ports/vaadin-portallayout/1.3.1-SNAPSHOT
install -s mvn:de.mhus.ports/vaadin-sliderpanel/1.3.1-SNAPSHOT

install -s 

# Install example

bundle:install -s mvn:de.mhus.examples/vaadin-addon-ports/1.0.0-SNAPSHOT

bundle:persistentwatch add vaadin-addon-ports

In Browser:

http://localhost:8181/vaadinaddons