package peaksoft.api;

import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.FeedbackRequest;
import peaksoft.dto.response.FeedbackResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.FeedbackService;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackApi {
    private final FeedbackService feedbackService;

    public FeedbackApi(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    @GetMapping
     public List<FeedbackResponse> getAll(){
        return feedbackService.getAll();
    }
    @PostMapping
    public SimpleResponse save(@RequestBody FeedbackRequest feedbackRequest) {
        return feedbackService.save(feedbackRequest);
    }

    @GetMapping("{feedbackId}")
    public FeedbackResponse getById(@PathVariable Long feedbackId){
        return feedbackService.getById(feedbackId);

    }
    @DeleteMapping("{feedbackId}")
    public SimpleResponse deleteById(@PathVariable Long feedbackId){
        return feedbackService.deleteById(feedbackId);
    }


    @PostMapping ("/{feedId}/{annId}")
    public SimpleResponse assign(@PathVariable Long feedId, @PathVariable Long annId){
         return feedbackService.assign(feedId,annId);
    }


}
