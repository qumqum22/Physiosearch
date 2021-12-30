package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Comments;
import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.payload.CommentPostRequest;
import com.rehabilitation.demo.repository.CommentsRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MessagesService {

    private final UserDataRepository userDataRepository;
    private final CommentsRepository commentsRepository;

    public void addPost(Comments comment) {
        commentsRepository.save(comment);
    }

    public List<CommentPostRequest> getCommentsAboutByAssigned(UserData userdata) {
        List<CommentPostRequest> resultList = new ArrayList<>(Collections.emptyList());
        List<Comments> commentContent = commentsRepository.findAllByAssigned(userdata);
        for (Comments comment : commentContent) {
            UserData userData = userDataRepository.findUserDataById(comment.getAuthor().getId());
            resultList.add(new CommentPostRequest(
                    comment.getId(),
                    comment.getComment(),
                    comment.getCommentDate(),
                    comment.getRate(),
                    userData.getId(),
                    userData.getName(),
                    userData.getSurname(),
                    userData.getProfileImage()
            ));
        }
        return resultList;
    }
}
