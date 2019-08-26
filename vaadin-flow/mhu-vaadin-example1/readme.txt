
feature:install http-whiteboard

# deps
install -s mvn:com.vaadin.external/gentyref/1.2.0.vaadin1
install -s mvn:com.vaadin.external.gwt/gwt-elemental/2.8.2.vaadin2
# spifly
install -s mvn:org.apache.aries.spifly/org.apache.aries.spifly.dynamic.bundle/1.2.1
install -s mvn:org.ow2.asm/asm/6.2.1
install -s mvn:org.ow2.asm/asm-tree/6.2.1
install -s mvn:org.ow2.asm/asm-commons/6.2.1
#install -s mvn:org.apache.aries.spifly/spifly/1.2.1
#deps
install -s mvn:com.helger/ph-commons/9.3.4
install -s mvn:com.helger/ph-css/6.2.0
install -s mvn:net.bytebuddy/byte-buddy/1.9.15
#install -s mvn:commons-io/commons-io/1.4
install -s mvn:commons-io/commons-io/2.5
install -s mvn:org.jsoup/jsoup/1.11.3
install -s mvn:commons-fileupload/commons-fileupload/1.4
# flow
install -s mvn:com.vaadin/flow-server/2.0.5
install -s mvn:com.vaadin/flow-osgi/2.0.5
install -s mvn:com.vaadin/flow-client/2.0.5
install -s mvn:com.vaadin/flow-data/2.0.5
install -s mvn:com.vaadin/flow-push/2.0.5
install -s mvn:com.vaadin/flow-html-components/2.0.5
# theme
install -s mvn:com.vaadin/vaadin-lumo-theme/2.0.5
# components
install -s mvn:com.vaadin/vaadin-button-flow/2.0.1
install -s mvn:com.vaadin/vaadin-notification-flow/2.0.0
install -s mvn:com.vaadin/vaadin-ordered-layout-flow/2.0.0

# app
install -s mvn:de.mhus.example.vaadin/mhu-vaadin-example1/1.0.0-SNAPSHOT

start-level mhu-vaadin-example1 81

docker run -it --name vaadin-flow \
 -h flow \
 -p 8181:8181 \
 -v ~/.m2:/home/user/.m2 \
 mhus/apache-karaf:4.2.6_01

http://localhost:8181/gui/


