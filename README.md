# amoviles-diplomado-2018-2
Curso de Aplicaciones Android con Java - Diplomado 2018 II - Academia Móviles 

## Lesson 1 - Saturday, 9th June, 2018

- Lesson

- Samples

- Homework

- Resources

## Lesson

1. ¿Qué es android? (versiones, historia)

2. Entorno de desarrollo Android (Android Studio)

3. Estructura de un proyecto Android (Android Studio)

4. Componentes de una aplicación Android (Android Studio)

5. Simuladores de android

6. Conociendo Gradle

7. Uso de mockups

8. Desarrollando mi primera aplicación Android

9. Explicación de Métodos, Objetos y Clases

10. Características del diseño en Android


### Android

Android architecture https://developer.android.com/guide/platform/?hl=es-419

<img src="https://developer.android.com/guide/platform/images/android-stack_2x.png?hl=es-419" height="520"/>

Android versions 

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/android-versions.jpg" height="240"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/android-versions.png" height="480"/>

![versions](https://chart.googleapis.com/chart?chs=500x250&cht=p&chco=c4df9b%2C6fad0c&chf=bg%2Cs%2C00000000&chd=t%3A0.3%2C0.4%2C4.3%2C10.3%2C22.4%2C25.6%2C31.1%2C5.7&chl=Gingerbread%7CIce%20Cream%20Sandwich%7CJelly%20Bean%7CKitKat%7CLollipop%7CMarshmallow%7CNougat%7COreo)

Tamaños

<img src="https://chart.googleapis.com/chart?chs=400x250&cht=p&chco=c4df9b%2C6fad0c&chf=bg%2Cs%2C00000000&chd=t%3A2.9%2C5.5%2C91.1%2C0.5&chl=Xlarge%7CLarge%7CNormal%7CSmall" height="240"/>

<img src="https://github.com/emedinaa/amoviles-android-basic-intermediate/blob/Lesson1/images/android-screens.png" height="240"/>

Android dashboard [https://developer.android.com/about/dashboards/](https://developer.android.com/about/dashboards/)

### 2/3. Android Studio

<img src="https://developer.android.com/studio/images/studio-homepage-hero_2x.jpg" height="360"/>

Android Studio [https://developer.android.com/studio/](https://developer.android.com/studio/?hl=es-419)

### 4. App Components

App Components

(en) https://developer.android.com/guide/components/fundamentals

(es) https://developer.android.com/guide/components/fundamentals?hl=es-419

- Activities

- Services

- Broadcast receivers

- Content providers


### 5. Android Emulator

<img src="https://www.genymotion.com/wp-content/uploads/2016/02/features-genymotion-imac.jpg" height="360"/>

Genymotion [https://www.genymotion.com/desktop/](https://www.genymotion.com/desktop/)

### 6. Gradle

Android Plugin for Gradle Release Notes  [https://developer.android.com/studio/releases/gradle-plugin](https://developer.android.com/studio/releases/gradle-plugin)

![gradle](https://www.safaribooksonline.com/library/view/gradle-recipes-for/9781491947272/assets/rega_0108.png)

Building Android Apps [https://guides.gradle.org/building-android-apps/](https://guides.gradle.org/building-android-apps/)

Gradle Tasks

```
./gradlew tasks
```

```
MacBook-Pro-de-Eduardo:JavaForAndroid emedinaa$ ./gradlew tasks
Starting a Gradle Daemon, 1 incompatible and 1 stopped Daemons could not be reused, use --status for details

> Task :tasks

------------------------------------------------------------
All tasks runnable from root project
------------------------------------------------------------

Android tasks
-------------
androidDependencies - Displays the Android dependencies of the project.
signingReport - Displays the signing info for each variant.
sourceSets - Prints out all the source sets defined in this project.

Build tasks
-----------
assemble - Assembles all variants of all applications and secondary packages.
assembleAndroidTest - Assembles all the Test applications.
assembleDebug - Assembles all Debug builds.
assembleRelease - Assembles all Release builds.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
clean - Deletes the build directory.
cleanBuildCache - Deletes the build cache directory.
compileDebugAndroidTestSources
compileDebugSources
compileDebugUnitTestSources
compileReleaseSources
compileReleaseUnitTestSources
mockableAndroidJar - Creates a version of android.jar that's suitable for unit tests.

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'JavaForAndroid'.
components - Displays the components produced by root project 'JavaForAndroid'. [incubating]
dependencies - Displays all dependencies declared in root project 'JavaForAndroid'.
dependencyInsight - Displays the insight into a specific dependency in root project 'JavaForAndroid'.
dependentComponents - Displays the dependent components of components in root project 'JavaForAndroid'. [incubating]
help - Displays a help message.
model - Displays the configuration model of root project 'JavaForAndroid'. [incubating]
projects - Displays the sub-projects of root project 'JavaForAndroid'.
properties - Displays the properties of root project 'JavaForAndroid'.
tasks - Displays the tasks runnable from root project 'JavaForAndroid' (some of the displayed tasks may belong to subprojects).

Install tasks
-------------
installDebug - Installs the Debug build.
installDebugAndroidTest - Installs the android (on device) tests for the Debug build.
uninstallAll - Uninstall all applications.
uninstallDebug - Uninstalls the Debug build.
uninstallDebugAndroidTest - Uninstalls the android (on device) tests for the Debug build.
uninstallRelease - Uninstalls the Release build.

Verification tasks
------------------
check - Runs all checks.
connectedAndroidTest - Installs and runs instrumentation tests for all flavors on connected devices.
connectedCheck - Runs all device checks on currently connected devices.
connectedDebugAndroidTest - Installs and runs the tests for debug on connected devices.
deviceAndroidTest - Installs and runs instrumentation tests using all Device Providers.
deviceCheck - Runs all device checks using Device Providers and Test Servers.
lint - Runs lint on all variants.
lintDebug - Runs lint on the Debug build.
lintRelease - Runs lint on the Release build.
lintVitalRelease - Runs lint on just the fatal issues in the release build.
test - Run unit tests for all variants.
testDebugUnitTest - Run unit tests for the debug build.
testReleaseUnitTest - Run unit tests for the release build.

To see all tasks and more detail, run gradlew tasks --all

To see more detail about a task, run gradlew help --task <task>
```

### 7. Crea tu primera aplicación

Build your first App [https://developer.android.com/training/basics/firstapp/](https://developer.android.com/training/basics/firstapp/)

<img src="https://developer.android.com/training/basics/firstapp/images/studio-welcome_2x.png" height="240"/>

<img src="https://developer.android.com/training/basics/firstapp/images/studio-editor_2x.png" height="240"/>

<img src="https://developer.android.com/training/basics/firstapp/images/run-avd_2x.png" height="240"/>

<img src="https://developer.android.com/training/basics/firstapp/images/screenshot-activity2.png" height="240"/>

### 8. Java for Android Developers


## Homework

  ### Gradle
  
  Buscar una librería compatible con Android y agregar la dependencia a un proyecto . Ejemplo , picasso o retrofit.
  
  Escoger un task del plugin de Gradle y ejecutarla desde terminal o desde Android Studio
  
  ### Android Studio
  
  Crear un proyecto en Android Studio , luego realizar los cambios acorde al template entregado en clase (gradle).
  
## Resources

### Git/Github

- Github https://guides.github.com/activities/hello-world/

- Resources to learn Git https://try.github.io/

### Java

- Online Java IDE https://www.compilejava.net/

- Oracle , Learning the Java Language https://docs.oracle.com/javase/tutorial/java/index.html

- Java Programming Fundamentals https://www.udemy.com/java-programming-fundamentals/

- Java Fundamentals Language https://www.pluralsight.com/courses/java-fundamentals-language

- Java Programming Basics https://www.udacity.com/course/java-programming-basics--ud282

- Java Fundamentals for Android Development https://www.edx.org/es/course/java-fundamentals-android-development-galileox-caad001x-2

- The Java tutorials https://docs.oracle.com/javase/tutorial/java/index.html

- Java Programming https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28

- Google Java Style Guide https://google.github.io/styleguide/javaguide.html

### Android 

- Android Developers - Desarrollo https://developer.android.com/develop/index.html

- Entorno de desarrollo https://developer.android.com/studio/index.html?hl=es-419

- Ejemplos de Android  https://developer.android.com/samples/

- Primer proyecto Android https://developer.android.com/training/basics/firstapp/creating-project.html?hl=es-419

- Codelab - primera android app con Java https://codelabs.developers.google.com/codelabs/build-your-first-android-app/index.html?index=..%2F..%2Findex

- Codelab - primera android app con Kotlin https://codelabs.developers.google.com/codelabs/build-your-first-android-app-kotlin/index.html?index=..%2F..%2Findex

- Android Tool Time https://www.youtube.com/watch?v=0n9sBgds-Hs&list=PLWz5rJ2EKKc_w6fodMGrA1_tsI3pqPbqa

- Canal oficial en Youtube para Android Developers https://www.youtube.com/user/androiddevelopers

### Books

- Books Android Developers http://fragmentedpodcast.com/tag/books/

### Others

- Intellij IDEA https://www.jetbrains.com/idea/

- Android Studio https://developer.android.com/studio/index.html?hl=es-419

- Sublime text https://www.sublimetext.com/



