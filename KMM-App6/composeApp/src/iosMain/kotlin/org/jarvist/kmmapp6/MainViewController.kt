package org.jarvist.kmmapp6

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.component.setupDefaultComponents
import com.seiko.imageloader.intercept.bitmapMemoryCacheConfig
import com.seiko.imageloader.intercept.imageMemoryCacheConfig
import com.seiko.imageloader.intercept.painterMemoryCacheConfig
import okio.Path.Companion.toPath
import org.jarvist.kmmapp6.root.RootComponent
import org.jarvist.kmmapp6.root.RootContent
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

fun MainViewController(rootComponent: RootComponent) = ComposeUIViewController {
    CompositionLocalProvider(
        LocalImageLoader provides remember { generateImageLoader() },
    ) {
        RootContent(rootComponent)
    }
}

class LifecycleCallbacksImpl: Lifecycle.Callbacks {
    override fun onCreate() {
        super.onCreate()
        println("Compose onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Compose onDestroy")
    }

    override fun onPause() {
        super.onPause()
        println("Compose onPause")
    }

    override fun onResume() {
        super.onResume()
        println("Compose onResume")
    }

    override fun onStart() {
        super.onStart()
        println("Compose onStart")
    }

    override fun onStop() {
        super.onStop()
        println("Compose onStop")
    }
}

fun generateImageLoader(): ImageLoader {
    return ImageLoader {
        components {
            setupDefaultComponents()
        }
        interceptor {
            // cache 32MB bitmap
            bitmapMemoryCacheConfig {
                maxSize(32 * 1024 * 1024) // 32MB
            }
            // cache 50 image
            imageMemoryCacheConfig {
                maxSize(50)
            }
            // cache 50 painter
            painterMemoryCacheConfig {
                maxSize(50)
            }
            diskCacheConfig {
                directory(getCacheDir().toPath().resolve("image_cache"))
                maxSizeBytes(512L * 1024 * 1024) // 512MB
            }
        }
    }
}

private fun getCacheDir(): String {
    return NSSearchPathForDirectoriesInDomains(
        NSCachesDirectory,
        NSUserDomainMask,
        true,
    ).first() as String
}