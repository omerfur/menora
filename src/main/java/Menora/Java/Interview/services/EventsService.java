package Menora.Java.Interview.services;

import Menora.Java.Interview.models.Event;
import Menora.Java.Interview.models.Product;
import Menora.Java.Interview.repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class EventsService {

    @Autowired
    private EventRepository eventRepository;

    private static Logger LOG = LoggerFactory.getLogger(EventsService.class);

    public ArrayList<Product> getProductByInsurredId(BigDecimal insuredId) throws Exception
    {
        try
        {
            ArrayList<Product>products = new ArrayList<>();
            eventRepository.findByInsuredId(insuredId).ifPresent(e->e.forEach(ev->products.addAll(ev.getProducts())));
            return products;
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
            throw e;
        }
    }

    public void saveEvent(Event event)
    {
        try
        {
            eventRepository.save(event);
        }
        catch (Exception e)
        {
            LOG.error(event.getId(),e);
        }
    }
}
