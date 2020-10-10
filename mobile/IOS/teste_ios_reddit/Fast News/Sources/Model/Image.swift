//
//  Image.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation

struct Image: Codable {
    var source: Source?
    
    private enum CodingKeys: String, CodingKey {
        case source
    }
}
