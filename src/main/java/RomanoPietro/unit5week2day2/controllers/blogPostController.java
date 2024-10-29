package RomanoPietro.unit5week2day2.controllers;
//***********************USERS CRUD*************************

/*
 1. GET http://localhost:3003/blogPost
 2. GET http://localhost:3003/blogPost/:{blogId}
 3. POST http://localhost:3003/blogPost (+ payLoad)
 4. PUT http://localhost:3003/blogPost/:{blogId} (+ payLoad)
 5. DELETE http://localhost:3003/blogPost/:{blogId}
 */

//**********************************************************

import RomanoPietro.unit5week2day2.payloads.NewBlogPostPayLoad;
import RomanoPietro.unit5week2day2.entites.blogPost;
import RomanoPietro.unit5week2day2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPost")
public class blogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // 1. GET http://localhost:3003/blogPost
    @GetMapping
    public List<blogPost> getBlogPost() {
        return blogPostService.findAll();
    }

    // 2. GET http://localhost:3003/blogPost:{blogId}
    @GetMapping("/{blogId}")
    public blogPost findBolgPostById(@PathVariable int blogId) {
        return this.blogPostService.findById(blogId);
    }

    //3. POST http://localhost:3003/blogPost (+ payLoad)
    @PostMapping
    public blogPost createBlogPost(@RequestBody NewBlogPostPayLoad body) {
        return this.blogPostService.saveBlogPost(body);
    }

    // 4. PUT http://localhost:3003/blogPost/:{blogId} (+ payLoad)
    @PutMapping("/{blogId}")
    public blogPost findBolgPostByIdAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPostPayLoad body){
        return this.blogPostService.findBolgPostByIdAndUpdate(blogId, body);
    }

    //5. DELETE http://localhost:3003/blogPost/:{blogId}
    @DeleteMapping("/{blogId}")
    public void findBolgPostByIdAndDelete(@PathVariable int blogId) {
        this.blogPostService.findByIdAndDelete(blogId);
    }
}
