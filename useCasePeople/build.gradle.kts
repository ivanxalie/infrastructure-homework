plugins {
    kotlin("jvm")
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation(project(":businessPeople"))

    implementation("javax.inject:javax.inject:1")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}