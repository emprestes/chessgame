plugins {
 id("chessgame.java")
}

description = "[CHESS][JAVA] Core module"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("junit-addons:junit-addons:1.4")
}

tasks.test {
    useJUnitPlatform {
        includeEngines.add("junit-jupiter")
        includeEngines.add("junit-vintage")
    }
}
