package software.amazon.app.platform.template.navigation

import androidx.compose.runtime.Composable
import me.tatarka.inject.annotations.Inject
import software.amazon.app.platform.template.navigation.NavigationDetailPresenter.Model
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
@ContributesBinding(AppScope::class)
class NavigationDetailPresenterImpl : NavigationDetailPresenter {
    @Composable
    override fun present(input: Unit): Model {
        return Model(true)
    }
}
