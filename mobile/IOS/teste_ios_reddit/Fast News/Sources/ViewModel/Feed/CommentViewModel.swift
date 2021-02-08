//
//  CommentViewModel.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation

struct CommentViewModel {
    
    //MARK: - Properties
    
    var author: String
    var createdAt: String
    var body: String
    var ups: String
    var downs: String
    
    init(comment: Comment) {
        author = comment.authorFullname ?? ""
        createdAt = comment.created?.createdAt ?? ""
        body = comment.body ?? ""
        ups = comment.ups?.toString ?? ""
        downs = comment.downs?.toString ?? ""
    }
}

extension CommentViewModel: TypeProtocol {
    var type: Type { return .comment }
}
