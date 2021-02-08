//
//  FeedCell.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import UIKit

@IBDesignable
class FeedCell: UITableViewCell {
    
    //MARK: - Properties
    
    @IBOutlet weak var authorLabel: UILabel!
    @IBOutlet weak var createdAtLabel: UILabel!
    @IBOutlet weak var thumbnailImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var commentsLabel: UILabel!
    @IBOutlet weak var scoreLabel: UILabel!
    
    //MARK: - Public Methods
    
    func setup(hotNewsViewModel: HotNewsViewModel) {
        authorLabel.text = hotNewsViewModel.author
        createdAtLabel.text = hotNewsViewModel.createdAt
        thumbnailImageView.image = hotNewsViewModel.image
        titleLabel.text = hotNewsViewModel.title
        commentsLabel.text = hotNewsViewModel.comments
        scoreLabel.text = hotNewsViewModel.score
    }
    
    func setup(viewModel: TypeProtocol) {
        guard let hotNewsViewModel = viewModel as? HotNewsViewModel else { return }
        authorLabel.text = hotNewsViewModel.author
        createdAtLabel.text = hotNewsViewModel.createdAt
        thumbnailImageView.image = hotNewsViewModel.image
        titleLabel.text = hotNewsViewModel.title
        commentsLabel.text = hotNewsViewModel.comments
        scoreLabel.text = hotNewsViewModel.score
    }
}
