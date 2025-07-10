package software.amazon.app.platform.template.navigation

import software.amazon.app.platform.presenter.BaseModel
import software.amazon.app.platform.presenter.molecule.MoleculePresenter

interface NavigationHeaderPresenter : MoleculePresenter<Unit, NavigationHeaderPresenter.Model> {
    data class Model(
        val temp: Boolean,
    ) : BaseModel
}
