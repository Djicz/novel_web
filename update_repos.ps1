 = 'ChapterRepository.java', 'CommentRepository.java', 'RatingRepository.java', 'ReadingProgressRepository.java', 'BookshelfRepository.java'
foreach ( in ) {
     = "src/main/java/com/example/demo/repository/"
     = Get-Content  -Raw
    if ( -notmatch 'void deleteByStoryId') {
         = .TrimEnd("}", "", "
") + "

    void deleteByStoryId(Long storyId);
}
"
        Set-Content -Path  -Value 
        Write-Host "Updated "
    }
}
