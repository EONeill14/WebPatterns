package persistence;

import model.Announcement;
import model.BlogEntry;

import java.util.ArrayList;
//id, subject, author, body and timestamp.

public interface AnnouncementDao {
    //id, subject, author, body and timestamp.

        public int addAnnouncement(String subject, String author, String body);

        public ArrayList<Announcement> getAllAnnouncements();


        public Announcement getAnnouncementByID(int id);

    }
