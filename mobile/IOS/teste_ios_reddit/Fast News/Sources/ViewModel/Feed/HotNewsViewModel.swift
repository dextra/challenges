//
//  HotNewsViewModel.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import Foundation
import UIKit

struct HotNewsViewModel {
    
    //MARK: - Properties
    
    var id: String
    var author: String
    var createdAt: String
    var title: String
    var comments: String
    var score: String
    var url: String
    var image: UIImage
    
    init(hotNews: HotNews) {
        id = hotNews.id ?? ""
        author = hotNews.authorFullname ?? ""
        createdAt = hotNews.created?.createdAt ?? ""
        title = hotNews.title ?? ""
        comments = hotNews.numComments?.toString ?? ""
        score = hotNews.score?.toString ?? ""
        url = hotNews.url ?? ""
        image = UIImage()
        
        // preview url
        let previewUrl = hotNews.preview?.images?.first?.source?.url?.htmlDecoded ?? ""
        guard let url = URL(string: previewUrl) else { return }
        guard let data = try? Data(contentsOf: url) else { return }
        image = UIImage(data: data) ?? UIImage()
    }
}

extension HotNewsViewModel: TypeProtocol {
    var type: Type { return .hotNews }
}
