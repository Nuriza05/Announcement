package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.FeedbackRequest;
import peaksoft.dto.response.FeedbackResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.repositoy.FeedbackRepo;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@Service
@Transactional
public interface FeedbackService  {
  SimpleResponse save (FeedbackRequest feedbackRequest);
  List<FeedbackResponse> getAll();
  FeedbackResponse getById(Long feedbackId);

  SimpleResponse deleteById(Long feedbackId);
  SimpleResponse assign(Long feedId, Long annId);
}
