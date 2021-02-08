//
//  Source.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation

struct Source: Codable {
    var url: String?
    
    private enum CodingKeys: String, CodingKey {
        case url
    }
}
