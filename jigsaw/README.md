# Java 9 / Jigsaw + Gradle

```
export JAVA_HOME=/opt/java/jdk-9
export PATH=$JAVA_HOME/bin:$PATH
```

## Assemble and run

```
./gradlew clean assemble

./gradlew clean :by.jprof.impl.app:run

```

## jdeps introspections

```
jdeps by.jprof.api/build/libs/by.jprof.api.jar

by.jprof.api
 [file:///home/madhead/Projects/playgrounds/jigsaw/by.jprof.api/build/libs/by.jprof.api.jar]
   requires mandated java.base (@9)
by.jprof.api -> java.base
   by.jprof.api
```
```
jdeps --module-path by.jprof.api/build/libs/by.jprof.api.jar:by.jprof.impl.en/build/libs/by.jprof.impl.en.jar:by.jprof.impl.be/build/libs/by.jprof.impl.be.jar by.jprof.impl.app/build/libs/by.jprof.impl.app.jar

by.jprof.impl.app
 [file:///home/madhead/Projects/meetup_16/jigsaw/by.jprof.impl.app/build/libs/by.jprof.impl.app.jar]
   requires by.jprof.api
   requires by.jprof.impl.be
   requires by.jprof.impl.en
   requires mandated java.base (@9)
by.jprof.impl.app -> by.jprof.api
by.jprof.impl.app -> java.base
   by.jprof.impl.app                                  -> by.jprof.api                                       by.jprof.api
   by.jprof.impl.app                                  -> java.io                                            java.base
   by.jprof.impl.app                                  -> java.lang                                          java.base
   by.jprof.impl.app                                  -> java.util                                          java.base
```

## jlink

```
jlink --module-path ${JAVA_HOME}/jmods:by.jprof.api/build/libs/by.jprof.api.jar:by.jprof.impl.en/build/libs/by.jprof.impl.en.jar:by.jprof.impl.be/build/libs/by.jprof.impl.be.jar:by.jprof.impl.app/build/libs/by.jprof.impl.app.jar --add-modules by.jprof.impl.app --output build --launcher app=by.jprof.impl.app/by.jprof.impl.app.Main

build/bin/app
Hello, world!
Вітаем, world!
```

There is a Gradle task for jlink package:

```
./gradlew dist

build/bin/app
Hello, world!
Вітаем, world!
```
