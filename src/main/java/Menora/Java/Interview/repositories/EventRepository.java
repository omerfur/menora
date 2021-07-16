package Menora.Java.Interview.repositories;

import Menora.Java.Interview.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public interface EventRepository extends JpaRepository <Event,String> {
    public Optional<ArrayList<Event>> findByInsuredId(BigDecimal insuredId);

}
