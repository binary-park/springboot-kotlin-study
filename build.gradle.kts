import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.spring") version "1.3.50"
}

group = "io.github.wyparks2"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Kotlin 클래스 및 데이터 클래스의 직렬화/비 직렬화에 대한 지원을 추가합니다 (단일 생성자 클래스는 자동으로 사용할 수 있고 보조 생성자 또는 정적 팩토리가 있는 클래스도 지원)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // Kotlin 리플렉션 라이브러리 (Spring Framework 5에서 필수)
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // Kotlin 표준 라이브러리의 Java 8 변형
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
