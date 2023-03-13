package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.FeedbackResponse;
import peaksoft.model.Feedback;

import java.util.List;
import java.util.Optional;

/**
 * @created : Lenovo Nuriza
 **/
public interface
FeedbackRepo extends JpaRepository<Feedback,Long> {
    @Query("select new peaksoft.dto.response.FeedbackResponse(f.images,f.rating,f.description,f.createdAt,f.owner) from Feedback f")
    List<FeedbackResponse> getAll();
    @Query("select new peaksoft.dto.response.FeedbackResponse(f.images,f.rating,f.description,f.createdAt,f.owner) from Feedback f where f.id=?1")
    Optional<FeedbackResponse> getFById(Long feedbackId);
}
