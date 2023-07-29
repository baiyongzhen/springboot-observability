import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
	//`kotlin-dsl` // a Kotlin or Java plugin is required, so that 'implementation' is available
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	//implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//implementation("io.opentelemetry:opentelemetry-api:1.27.0")
	implementation("io.opentelemetry:opentelemetry-api:1.24.0")
	implementation("io.micrometer:micrometer-registry-prometheus:1.10.5")
	implementation("org.apache.httpcomponents:httpcore:4.4.16")
	implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")
	implementation("org.apache.httpcomponents.client5:httpclient5-fluent:5.2.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
