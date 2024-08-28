plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.14")


    // tools
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0")

    // view
    implementation( "org.jetbrains.kotlinx:kotlinx-html-jvm:0.10.1")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.14") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test:3.3.0.RELEASE")
}