package Menora.Java.Interview.threads;

import Menora.Java.Interview.models.RootObject;

import Menora.Java.Interview.services.EventsService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ReadXmlFile implements Runnable {

    private final static String XML_FILE_NAME = "Request.xml";
    private String xmlPath;
    private EventsService eventsService;
    private static Logger LOG = LoggerFactory.getLogger(ReadXmlFile.class);


    public ReadXmlFile(String xmlPath, EventsService eventsService)
    {
        this.xmlPath=xmlPath;
        this.eventsService = eventsService;
    }

    @Override
    public void run() {

        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        try {
            RootObject rootObject = xmlMapper.readValue(Files.readAllBytes(Paths.get(xmlPath+XML_FILE_NAME)),RootObject.class);
            rootObject.getEvents().forEach(eventsService::saveEvent);
        } catch (IOException e) {
            LOG.error("Faild during saving XML",e);
        }
    }
}
