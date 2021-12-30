package com.rehabilitation.demo.controllers;

import com.rehabilitation.demo.models.Comments;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.payload.AddPostRequest;
import com.rehabilitation.demo.payload.CommentPostRequest;
import com.rehabilitation.demo.services.MessagesService;
import com.rehabilitation.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class MessagesController {

    private final UserService userService;
    private final MessagesService messagesService;

    @GetMapping("/users/comments/{id}")
    public List<CommentPostRequest> getCommentsByCommentsAbout(@PathVariable("id") long id) {
        UserData userdata = userService.getSingleUser(id);
        return messagesService.getCommentsAboutByAssigned(userdata);
    }

    @PostMapping("/profile/add/post")
    public boolean addPhone(@RequestBody AddPostRequest addPostRequest)
    {
        UserData assigned = userService.getSingleUser(addPostRequest.getAssignedId());
        UserData author = userService.getSingleUser(addPostRequest.getAuthorId());
        Comments comment = new Comments(addPostRequest.getComment(), addPostRequest.getCommentDate(), addPostRequest.getRate(),
                assigned, author);
        messagesService.addPost(comment);
        return true;
    }
}
