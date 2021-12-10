package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Clinic;
import com.rehabilitation.demo.models.Comments;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.repository.CommentsRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import com.rehabilitation.demo.repository.MessagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagesService {

    private final UserDataRepository userDataRepository;
    private final MessagesRepository chatMessagesRepository;
    private final CommentsRepository commentsRepository;

    public List<Comments> getCommentsAboutByUserdata(UserData userdata) {
        return userDataRepository.findAllByCommentsAbout(userdata);
    }


//    public List<UserData> getUsersByClinic(Clinic clinic) {
//        return userDataRepository.findAllByClinics(clinic);}
}
