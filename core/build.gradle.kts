plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    if(Targeting.JVM) jvm {
        library()
        withJava()
    }

    if(Targeting.JS) js(IR) {
        library()
    }

    if(Targeting.WASM) wasm {
        library()
    }

    val nativeTargets = nativeTargets(false)

    sourceSets {
        val commonMain by getting

        val nonJvmMain by creating {
            dependsOn(commonMain)
        }

        if(Targeting.JS) {
            val jsMain by getting {
                dependsOn(nonJvmMain)
            }
        }

        if(Targeting.WASM) {
            val wasmMain by getting {
                dependsOn(nonJvmMain)
            }
        }

        if(Targeting.NATIVE) {
            (nativeTargets).forEach {
                val main by it.compilations.getting {}
                main.defaultSourceSet {
                    dependsOn(nonJvmMain)
                }
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.root.get(),
    description = "A collections of interoperable functions to easy interoperabiliy with java"
)