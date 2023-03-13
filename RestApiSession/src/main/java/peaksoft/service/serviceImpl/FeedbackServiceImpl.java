package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dto.converting.EntityConvertingToFeedback;
import peaksoft.dto.request.FeedbackRequest;
import peaksoft.dto.response.FeedbackResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.model.Announcement;
import peaksoft.model.Feedback;
import peaksoft.repositoy.AnnouncementRepo;
import peaksoft.repositoy.FeedbackRepo;
import peaksoft.service.FeedbackService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @created : Lenovo Nuriza
 **/
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    private final EntityConvertingToFeedback converting;
    private final FeedbackRepo feedbackRepo;
    private final AnnouncementRepo announcementRepo;

    @Autowired
    public FeedbackServiceImpl(EntityConvertingToFeedback converting, FeedbackRepo feedbackRepo, AnnouncementRepo announcementRepo) {
        this.converting = converting;
        this.feedbackRepo = feedbackRepo;
        this.announcementRepo = announcementRepo;
    }

    @Override
    public SimpleResponse save(FeedbackRequest feedbackRequest) {
        Feedback feedback = converting.convert(feedbackRequest);
        feedbackRepo.save(feedback);
        return new SimpleResponse("SAVE", String.format("Feedback with name: " + feedbackRequest.description() + " is saved!"));
    }

    @Override
    public List<FeedbackResponse> getAll() {
        return feedbackRepo.getAll();
    }

    @Override
    public FeedbackResponse getById(Long feedbackId) {
        return feedbackRepo.getFById(feedbackId).orElseThrow(() -> new NoSuchElementException("Feedback with id: " + feedbackId + " is not exist!"));
    }

    @Override
    public SimpleResponse deleteById(Long feedbackId) {
        boolean exist = feedbackRepo.existsById(feedbackId);
        if (!exist) {
            throw new NoSuchElementException("Feedback with id: " + feedbackId + " is not exist!");
        } else {
            feedbackRepo.deleteById(feedbackId);
        }
        return new SimpleResponse("DELETE", "Feedback with id: " + feedbackId + " is deleted!");
    }

    @Override
    public SimpleResponse assign(Long feedId, Long annId) {
        Announcement ann = announcementRepo.findById(annId).orElseThrow(() -> new NoSuchElementException("Announcement with id: " + annId + " is not exist!"));
        Feedback feedback = feedbackRepo.findById(feedId).orElseThrow(() -> new NoSuchElementException("Feedback with id: " + feedId + " is not exist!"));
        feedback.setAnnouncement(ann);
        return new SimpleResponse("Assign","Announcement is assigned to Feedback!");
    }


}
