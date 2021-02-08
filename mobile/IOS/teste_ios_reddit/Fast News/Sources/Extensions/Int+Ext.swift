//
//  Int+Ext.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation

extension Int {
    
    //MARK: - Date Formatter
    
    var createdAt: String {
        
        let date = Date(timeIntervalSince1970: TimeInterval(self))
        
        return date.elapsedInterval
    }
    
    var toString: String {
        return "\(self)"
    }
}
