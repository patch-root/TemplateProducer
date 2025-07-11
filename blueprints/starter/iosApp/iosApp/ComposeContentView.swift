import UIKit
import SwiftUI
import TemplateApp

struct ComposeView: UIViewControllerRepresentable {
    private var rootScopeProvider: PublicRootScopeProvider

    init(rootScopeProvider: PublicRootScopeProvider) {
        self.rootScopeProvider = rootScopeProvider
    }

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.mainViewController(rootScopeProvider: rootScopeProvider)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ComposeContentView: View {
    var rootScopeProvider: PublicRootScopeProvider

    init(rootScopeProvider: PublicRootScopeProvider) {
        self.rootScopeProvider = rootScopeProvider
    }

    var body: some View {
        ComposeView(rootScopeProvider: rootScopeProvider).ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
