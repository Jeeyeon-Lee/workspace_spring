package snippet;

public class Snippet {
	public static void main(String[] args) {
		plugins {
			id 'java'
			id 'war'
			id 'org.springframework.boot' version '3.1.6'
			id 'io.spring.dependency-management' version '1.1.4'
		}
		
		group = 'com.example'
		version = '0.0.1-SNAPSHOT'
		
		java {
			sourceCompatibility = '17'
		}
		
		configurations {
			compileOnly {
				extendsFrom annotationProcessor
			}
		}
		
		repositories {
			mavenCentral()
		}
		
		dependencies {
			implementation 'org.springframework.boot:spring-boot-starter-web'
			compileOnly 'org.projectlombok:lombok'
			developmentOnly 'org.springframework.boot:spring-boot-devtools'
			annotationProcessor 'org.projectlombok:lombok'
			implementation "org.apache.tomcat.embed:tomcat-embed-jasper"
			implementation 'org.mybatis:mybatis:3.5.14'
			runtimeOnly 'com.oracle.database.jdbc:ojdbc8'
			implementation 'com.oracle:orai18n:11.2.0.3'
			providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
			testImplementation 'org.springframework.boot:spring-boot-starter-test'
		}
		
		tasks.named('bootBuildImage') {
			builder = 'paketobuildpacks/builder-jammy-base:latest'
		}
		
		tasks.named('test') {
			useJUnitPlatform()
		}
		
	}
}

