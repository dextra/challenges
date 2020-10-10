//
//  CellTypeProtocol.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation

enum Type {
    case hotNews, comment
}

protocol TypeProtocol {
    var type: Type { get }
}
