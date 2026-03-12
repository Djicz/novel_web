package com.example.demo.controller;
import com.example.demo.entity.Story;
import com.example.demo.service.ChapterService;
import com.example.demo.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;
    private final ChapterService chapterService;
    @GetMapping("/stories")
    public String listStories(Model model, @PageableDefault(size = 12) Pageable pageable) {
        Page<Story> stories = storyService.getStories(null, pageable);
        model.addAttribute("stories", stories.getContent());
        model.addAttribute("page", stories);
        return "story/list";
    }
    @GetMapping("/story/{slug}")
    public String viewStory(@PathVariable String slug, Model model) {
        Story story = storyService.getStoryBySlug(slug);
        model.addAttribute("story", story);
        model.addAttribute("chapters", chapterService.getChaptersByStoryId(story.getId()));
        return "story/detail";
    }
}
