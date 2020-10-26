plugins {
 `java-library`
 `maven-publish`
}

repositories {
 mavenLocal()
 maven {
  url = uri("https://repo.maven.apache.org/maven2/")
 }
}

group = "br.opensource.game.chessgame"
version = "1.0.0.RELEASE"

java {
 sourceCompatibility = JavaVersion.VERSION_15
 withSourcesJar()
 withJavadocJar()
}

publishing {
 publications.create<MavenPublication>("maven") {
  from(components["java"])
 }
}

tasks.withType<JavaCompile>() {
 options.encoding = "UTF-8"
}
