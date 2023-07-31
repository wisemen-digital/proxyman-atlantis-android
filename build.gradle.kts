// Top-level build file where you can add configuration options common to all sub-projects/modules.
val okhttpVersion by extra("4.11.0")
val gsonVersion by extra("2.10.1")

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}