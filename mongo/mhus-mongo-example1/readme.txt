

# Start Docker

docker run --name mongo-db -d mongo:4.2.0

docker run -it --name mongo-ex \
 -h mongo \
 --link mongo-db:mongoserver \
 -v ~/.m2:/home/user/.m2 \
 mhus/apache-karaf:4.2.6_01


feature:repo-add cxf 3.3.1
feature:repo-add activemq 5.15.8
feature:install deployer/4.2.6 aries-blueprint/4.2.6 cxf-core/3.3.1 openjpa3/3.0.0

toolsversion=1.6.3-SNAPSHOT

feature:repo-add mvn:de.mhus.osgi/mhu-karaf-feature/${toolsversion}/xml/features
feature:install mhu-osgi-base

# deps
install -s mvn:org.mongodb/mongo-java-driver/3.10.1
install -s wrap:mvn:com.thoughtworks.proxytoys/proxytoys/1.0

install -s mvn:de.mhus.lib/mongo-morphia/1.6.2-SNAPSHOT
install -s mvn:de.mhus.lib/mongo-xdb/1.6.2-SNAPSHOT

install -s mvn:de.mhus.lib/mongo-karaf-api/1.6.2-SNAPSHOT
install -s mvn:de.mhus.lib/mongo-karaf-impl/1.6.2-SNAPSHOT

install -s mvn:de.mhus.example.mongo/mhus-mongo-example1/1.0.0-SNAPSHOT
