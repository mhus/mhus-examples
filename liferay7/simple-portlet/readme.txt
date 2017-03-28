
Access Liferay7 OSGi console:

telnet localhost 11311

If you need to use mhu-lib ...
Copy needed libraries into the Liferay7 deploy directory (should be available after build of mhu-lib, mhu-ports):

# External libs
cp ~/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.5/jackson-core-asl-1.9.5.jar deploy/
cp ~/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.5/jackson-mapper-asl-1.9.5.jar deploy/

# Ported libs
cp ~/.m2/repository/de/mhus/ports/mhus-cglib/1.3.1-SNAPSHOT/mhus-cglib-1.3.1-SNAPSHOT.jar deploy/

# mhu-lib
cp ~/.m2/repository/de/mhus/lib/mhu-lib-annotations/3.3.1-SNAPSHOT/mhu-lib-annotations-3.3.1-SNAPSHOT.jar deploy/
cp ~/.m2/repository/de/mhus/lib/mhu-lib-core/3.3.1-SNAPSHOT/mhu-lib-core-3.3.1-SNAPSHOT.jar  deploy/
cp ~/.m2/repository/de/mhus/lib/mhu-lib-persistence/3.3.1-SNAPSHOT/mhu-lib-persistence-3.3.1-SNAPSHOT.jar deploy/
cp ~/.m2/repository/de/mhus/lib/mhu-lib-j2ee/3.3.1-SNAPSHOT/mhu-lib-j2ee-3.3.1-SNAPSHOT.jar  deploy/
cp ~/.m2/repository/de/mhus/lib/mhu-lib-liferay/3.3.1-SNAPSHOT/mhu-lib-liferay-3.3.1-SNAPSHOT.jar  deploy/

