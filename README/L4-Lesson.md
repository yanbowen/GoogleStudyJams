#IDEA的笔记L3  
---

###知识总结  

###项目关联firebase后平台运行展示图：
####Firebase项目展示
![](http://i.imgur.com/25Pq6ml.png)  
####项目状态分析
![](http://i.imgur.com/7gdcRcD.png)
![](http://i.imgur.com/SQHIoh3.png)

### app下build.gradle代码  

    apply plugin: 'com.android.application'
	// ADD THIS AT THE BOTTOM
	apply plugin: 'com.google.gms.google-services'

	def gitSha = 'git rev-parse --short HEAD'.execute([], project.rootDir).text.trim()
	def gitTag = 'git describe --tags'.execute([], project.rootDir).text.trim()

	android {
    compileSdkVersion 25
    buildToolsVersion "25.0.2"
    dataBinding.enabled = true

    lintOptions {
        abortOnError false
    }

    packagingOptions {
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/NOTICE.txt'
    }
    defaultConfig {
        applicationId "cn.studyjams.s2.sj0132.bowenyan.mygirlfriend"
        minSdkVersion 14
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        // If Non-Free libraries are to be used
        buildConfigField "boolean", "NONFREE", "false"
        buildConfigField "boolean", "DROPBOX_ENABLED", "false"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
	}

	dependencies {
    compile 'com.android.support:support-v4:23.1.0'
    compile "com.android.support:appcompat-v7:23.1.0"
    compile 'com.android.support:design:23.1.0'
    compile 'com.android.support:recyclerview-v7:23.1.0'
    compile 'joda-time:joda-time:2.3'
    // Dashclock
    compile 'com.google.android.apps.dashclock:dashclock-api:2.0.0'
    // FilePicker
    compile 'com.nononsenseapps:filepicker:2.4.2'
    // OrgParser
    compile 'org.cowboyprogrammer:orgparser:1.3.0'
    // For Sync
    compile 'com.squareup.retrofit:retrofit:1.6.1'
    // Included libraries
    compile project(':external:datetimepicker')
    androidTestCompile 'com.squareup.spoon:spoon-client:1.1.1'
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    }
    androidTestCompile 'com.android.support.test.espresso:espresso-contrib:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
        exclude group: 'com.android.support', module: 'support-v4'
        exclude group: 'com.android.support', module: 'design'
        exclude group: 'com.android.support', module: 'recyclerview-v7'
    }
    compile 'com.google.firebase:firebase-core:9.6.1'
    compile 'com.google.firebase:firebase-crash:9.6.1'
	}
  
###项目下build.gradle代码  
    // Top-level build file where you can add configuration options common to all sub-projects/modules.

	buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.1'
        classpath 'com.google.gms:google-services:3.0.0'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
	}

	allprojects {
    repositories {
        jcenter()
    }
	}

	task clean(type: Delete) {
    delete rootProject.buildDir
	}
