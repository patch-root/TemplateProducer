package software.amazon.app.platform.template.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.tatarka.inject.annotations.Inject
import software.amazon.app.platform.template.navigation.NavigationDetailPresenter.Model
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
@ContributesBinding(AppScope::class)
class NavigationDetailPresenterImpl(
    private val exampleRepository: ExampleRepository,
) : NavigationDetailPresenter {
    @Composable
    override fun present(input: Unit): Model {
        val exampleValue by exampleRepository.exampleStateFlow.collectAsState()
        var exampleCount by remember { mutableStateOf(0) }

        LaunchedEffect(exampleValue) {
            exampleCount++
        }

        return Model(
            exampleValue = exampleValue,
            exampleCount = exampleCount,
        )
    }
}
