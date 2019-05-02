package com.company.enroller.persistence;

import com.company.enroller.model.Meeting;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("meetingService")
public class MeetingService {

    DatabaseConnector connector;

    public MeetingService() {
        connector = DatabaseConnector.getInstance();
    }
    
    public Collection<Meeting> getAll() {
        Criteria cr = connector.getSession().createCriteria(Meeting.class);
        return cr.list();
    }


}
