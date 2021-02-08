//
//  CommentCell.swift
//  Fast News
//
//  Copyright © 2019 Lucas Moreton. All rights reserved.
//

import UIKit

class CommentCell: UITableViewCell {
    
    //MARK: - Properties
    
    @IBOutlet weak var authorLabel: UILabel!
    @IBOutlet weak var createdAtLabel: UILabel!
    @IBOutlet weak var commentLabel: UILabel!
    @IBOutlet weak var upsLabel: UILabel!
    @IBOutlet weak var downsLabel: UILabel!
    
    //MARK: - Public Methods
    
    func setup(commentViewModel: CommentViewModel) {
        authorLabel.text = commentViewModel.author
        createdAtLabel.text = commentViewModel.createdAt
        commentLabel.text = commentViewModel.body
        upsLabel.text = commentViewModel.ups
        downsLabel.text = commentViewModel.downs
    }
    
    func setup(viewModel: TypeProtocol) {
        guard let commentViewModel = viewModel as? CommentViewModel else { return }
        authorLabel.text = commentViewModel.author
        createdAtLabel.text = commentViewModel.createdAt
        commentLabel.text = commentViewModel.body
        upsLabel.text = commentViewModel.ups
        downsLabel.text = commentViewModel.downs
    }
}
