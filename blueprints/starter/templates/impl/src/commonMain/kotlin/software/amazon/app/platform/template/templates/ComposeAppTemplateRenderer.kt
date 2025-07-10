package software.amazon.app.platform.template.templates

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import me.tatarka.inject.annotations.Inject
import software.amazon.app.platform.inject.ContributesRenderer
import software.amazon.app.platform.renderer.ComposeRenderer
import software.amazon.app.platform.renderer.RendererFactory
import software.amazon.app.platform.renderer.getComposeRenderer
import software.amazon.app.platform.template.templates.animation.LocalAnimatedVisibilityScope
import software.amazon.app.platform.template.templates.animation.LocalSharedTransitionScope

/**
 * A Compose renderer implementation for templates used in the sample application.
 *
 * [rendererFactory] is used to get the [software.amazon.app.platform.renderer.Renderer] for the [software.amazon.app.platform.presenter.BaseModel] wrapped in the template.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Inject
@ContributesRenderer
class ComposeAppTemplateRenderer(private val rendererFactory: RendererFactory) :
    ComposeRenderer<AppTemplate>() {
    @Composable
    override fun Compose(model: AppTemplate) {
        Box(Modifier.Companion.windowInsetsPadding(WindowInsets.Companion.safeDrawing)) {
            // Wrap all the UI in a SharedTransitionLayout and AnimatedContent to support
            // shared element transitions across template updates. The scopes are exposed through
            // composition locals as suggested here:
            // https://developer.android.com/develop/ui/compose/animation/shared-elements#understand-scopes
            SharedTransitionLayout {
                CompositionLocalProvider(LocalSharedTransitionScope provides this) {
                    AnimatedContent(
                        targetState = model,
                        label = "Top level AnimatedContent",
                        contentKey = { template ->
                            // Use the key from AnimationContentKey as indicator when content has changed
                            // that needs to be animated. If this key is doesn't change (the default behavior),
                            // then no animation occurs.
                            template.contentKey
                        },
                    ) { template ->
                        CompositionLocalProvider(LocalAnimatedVisibilityScope provides this) {
                            when (template) {
                                is AppTemplate.FullScreenTemplate -> FullScreen(template)
                                is AppTemplate.HeaderDetailTemplate -> HeaderDetail(template)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun FullScreen(template: AppTemplate.FullScreenTemplate) {
        val renderer = rendererFactory.getComposeRenderer(template.model)
        renderer.renderCompose(template.model)
    }

    @Composable
    private fun HeaderDetail(template: AppTemplate.HeaderDetailTemplate) {
        println("HeaderDetail")
        Column {
            Row(Modifier.Companion.weight(1f)) {
                rendererFactory.getComposeRenderer(template.header).renderCompose(template.header)
            }
            Row(Modifier.Companion.weight(5f)) {
                rendererFactory.getComposeRenderer(template.detail).renderCompose(template.detail)
            }
        }
    }
}