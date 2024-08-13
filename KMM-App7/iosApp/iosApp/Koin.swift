//
//  Koin.swift
//  iosApp
//
//  Created by Yevstafieva Yevheniia on 12.08.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import ComposeApp

private var _koin: Koin_coreKoin?
var koin: Koin_coreKoin {
    return _koin!
}

func startKoin() {
    let koinApplication = DependencyInjectionKt.doInitKoinIOS()
    _koin = koinApplication.koin
}
