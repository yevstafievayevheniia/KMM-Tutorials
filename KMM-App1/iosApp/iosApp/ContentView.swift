import SwiftUI
import Shared

struct ContentView: View {

    @ObservedObject var viewModel: ViewModel

    var body: some View {
        List(viewModel.users, id: \.self) { user in
            if let name = user.name {
                VStack {
                    Spacer()
                    HStack {
                        AsyncImage(url: URL(string: (user.picture?.thumbnail)!))
                            .frame(width: 50, height: 50)
                            .clipShape(RoundedRectangle(cornerSize: CGSize(width: 10, height: 10)))
                        VStack(alignment: .leading) {
                            Text("\(name.first ?? "First Name") \(name.last ?? "Last Name")")
                            Text(user.phone ?? "Phone")
                        }
                    }
                    Spacer()
                }
            }
        }
        .onAppear {
            self.viewModel.observeDataFlow()
        }
    }
}

extension ContentView {
    @MainActor
    class ViewModel: ObservableObject {

        var homeRepository: HomeRepository = HomeRepository.init()
        @Published var users: [RandomUser] = []

        func observeDataFlow() {
            Task {
                for await user in homeRepository.getUsers() {
                    self.users.append(contentsOf: user)
                }
            }
        }
    }

}
