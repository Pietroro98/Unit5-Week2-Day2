package RomanoPietro.unit5week2day2.services;


import RomanoPietro.unit5week2day2.exceptions.NotFoundException;
import RomanoPietro.unit5week2day2.payloads.NewBlogPostPayLoad;
import RomanoPietro.unit5week2day2.entites.blogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    private List<blogPost> blogPostList = new ArrayList<>();

    public List<blogPost> findAll(){
        return this.blogPostList;
    }

    public blogPost findById (int blogId ) {
        blogPost found = null;
        for (blogPost blogPost : this.blogPostList){
            if(blogPost.getId() == blogId) found =  blogPost;
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public blogPost saveBlogPost(NewBlogPostPayLoad body) {
        Random rndm = new Random();
        blogPost newBlogPost = new blogPost(body.getCategory(),body.getTitle(),body.getContent(),body.getReadingTime());
        newBlogPost.setId(rndm.nextInt(1, 1000));
        newBlogPost.setCover("https://picsum.photos/200/300");
        this.blogPostList.add(newBlogPost);
        return newBlogPost;
    }

    public blogPost findBolgPostByIdAndUpdate(int blogId, NewBlogPostPayLoad body){
        blogPost foundBlogPost = null;
        for (blogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogId){
                foundBlogPost = blogPost;
                foundBlogPost.setCategory(body.getCategory());
                foundBlogPost.setTitle(body.getTitle());
                foundBlogPost.setContent(body.getContent());
                foundBlogPost.setReadingTime(body.getReadingTime());
                return foundBlogPost;
            }
        }
        if (foundBlogPost == null) throw new NotFoundException(blogId);
        return foundBlogPost;
    }

    public void findByIdAndDelete(int blogId) {
        blogPost foundBlogPost = null;
        for (blogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogId){
                foundBlogPost = blogPost;

            }
            if (foundBlogPost == null) throw new NotFoundException(blogId);
            this.blogPostList.remove(foundBlogPost);
        }

    }
}
