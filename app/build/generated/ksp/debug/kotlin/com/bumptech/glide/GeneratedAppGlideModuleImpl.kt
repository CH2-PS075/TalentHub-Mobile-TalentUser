package com.bumptech.glide

import android.content.Context
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule
import com.ch2ps075.talenthub.helper.AppGlideModule
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit

internal class GeneratedAppGlideModuleImpl(
  @Suppress("UNUSED_PARAMETER")
  context: Context,
) : GeneratedAppGlideModule() {
  private val appGlideModule: AppGlideModule
  init {
    appGlideModule = AppGlideModule()
  }

  public override fun registerComponents(
    context: Context,
    glide: Glide,
    registry: Registry,
  ): Unit {
    OkHttpLibraryGlideModule().registerComponents(context, glide, registry)
    appGlideModule.registerComponents(context, glide, registry)
  }

  public override fun applyOptions(context: Context, builder: GlideBuilder): Unit {
    appGlideModule.applyOptions(context, builder)
  }

  public override fun isManifestParsingEnabled(): Boolean = false
}
