package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> findAllWhiskyByYear(int year);
    List<Whisky> findAllWhiskyByRegion(String region);
    List<Whisky> findAllWhiskyByDistilleryAndAge(Distillery distillery, int age);

}
