import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

project.base.archivesName.set("people")

plugins {
    id("org.springframework.boot") version "2.7.14"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.0" apply false
    id("com.diffplug.spotless") version "6.25.0" apply false
}

allprojects {
    group = "com.stringconcat"

    repositories {
        mavenCentral()
        jcenter()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
            allWarningsAsErrors = true
        }
    }
}

subprojects {
    apply(plugin = "com.diffplug.spotless")

    configure<SpotlessExtension> {
        kotlin {
            ktfmt().kotlinlangStyle().configure {
                it.setMaxWidth(100)
                it.setBlockIndent(4)
            }
            endWithNewline()
            toggleOffOn()
        }
        kotlinGradle {
            target("*.gradle.kts")
            ktfmt().kotlinlangStyle()
            endWithNewline()
        }
    }
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    // spring modules
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.14")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:2.7.14")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation(project(":presentation"))
    implementation(project(":persistence"))
    implementation(project(":useCasePeople"))
    implementation(project(":businessPeople"))
    implementation(project(":quoteGarden"))
    implementation(project(":avatarsDicebear"))

    // dev tools
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.7.14")

    // persistance
    implementation("org.postgresql:postgresql:42.3.4")
    implementation("org.liquibase:liquibase-core:4.9.1")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}

tasks.test { useJUnitPlatform() }
