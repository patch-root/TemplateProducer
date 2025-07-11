import TemplateApp
import SwiftUI

class AppDelegate: NSObject, UIApplicationDelegate, PublicRootScopeProvider {

    private let templateApplication: Application = Application()

    var rootScope: PublicScope {
        get {
            templateApplication.rootScope
        }
    }

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {
        templateApplication.create(appComponent: IosAppComponentKt.createIosAppComponent(application: application, rootScopeProvider: templateApplication))
        return true
    }
}

@main
struct iOSApp: App {

    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate

    var body: some Scene {
        WindowGroup {
            ComposeContentView(rootScopeProvider: appDelegate)
        }
    }
}
