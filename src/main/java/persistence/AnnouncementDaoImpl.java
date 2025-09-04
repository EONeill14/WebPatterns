package persistence;

import model.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl extends MySQLDao implements AnnouncementDao
{
    public AnnouncementDaoImpl(String propertiesFile) {
        super(propertiesFile);
    }

    @Override
    public Announcement getAnnouncementById(int AnnouncementID) {
        return null;
    }

    @Override
    public int addAnnouncementEntry(String subject, String author, String body) {
        return 0;


    }

    @Override
    public ArrayList<Announcement> getAllAnnouncements() {
        return null;
    }
    public static void main(String[] args) {
        Announcement announcementDao = new AnnouncementDaoImpl("database.properties");
        List<Announcement> getAllAnnouncements = AnnouncementDao.getAllAnnouncements();
        System.out.println("All current announcements: ");
        for(Announcement a: getAllAnnouncements){
            System.out.println(a);
        }

        String user = "user1";
        List<Announcmenet> userAnnouncement = AnnouncementDao.getAnnouncementByID(user);
        if(!Announcement.isEmpty()) {
            System.out.println("All announcmenets for " + user + ":");
            for (Announcement a: userAnnouncement) {
                System.out.println(o);
            }
        }else{
            System.out.println("No Announcements found for " + user + ".");
        }
    }
}
