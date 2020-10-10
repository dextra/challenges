//
//  Preview.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation

struct Preview: Codable {
    var images: [Image]?
    
    private enum CodingKeys: String, CodingKey {
        case images
    }
}
