plugins {
 id("chessgame.java")
}

description = "[CHESS][JAVA] Core module"

dependencies {
 testImplementation("junit:junit:4.13.1")
 testImplementation("junit-addons:junit-addons:1.4")
}

tasks.test {
 useJUnit()
}