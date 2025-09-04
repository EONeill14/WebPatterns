package persistence;

import model.Announcement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl extends MySQLDao implements AnnouncementDao
{
    @Override
    public List<Announcement> getAllAnnouncements() {
        List<Announcement> announcements = new ArrayList<>();
        Connection conn = super.getConnection();
        String sql = "SELECT * from announcements";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Announcement annoncement = mapRow(rs);
                    announcements.add(announcement);
                }
            }
        }catch(SQLException e){
            log.error("SQLException occurred when retrieving all products from database", e);
        }
        return announcements;
    }

    public AnnouncementDaoImpl(String propertiesFile) {
        super(propertiesFile);
    }
    @Override
    public Announcement getAnnouncementByID(String productCode) {
        if(productCode == null){
            throw new IllegalArgumentException("Announcement code cannot be null");
        }

        Announcement announcement = null;
        Connection conn = super.getConnection();
        String sql = "SELECT * from announcements WHERE announcementID = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, productCode);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    announcement = mapRow(rs);
                }
            }
        }catch(SQLException e){
            log.error("SQLException occurred when retrieving product matching productCode: " + productCode, e);
        }
        return announcement;
    }
    //id, subject, author, body and timestamp.

    private Announcement mapRow(ResultSet rs) throws SQLException {
        Announcment announcement =
                Announcement.builder()
                        .announcementID(rs.getString("announcementID"))
                        .author(rs.getString("author"))
                        .subject(rs.getString("subject"))
                        .body(rs.getString("body"))
                        .timestamp(rs.getString(timestamp))

                        .build();
        return announcement;
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
catch(
    SQLException e){
    log.error("An error occurred when logging in user with username: " + username, e);
}

    @Override
    public int addAnnouncement(String subject, String author, String body) {
        return 0;
    }

    @Override
    public Announcement getAnnouncementByID(int id) {
        return null;
    }

    public SQLException getE() {
        return e;
    }

    public void setE(SQLException e) {
        this.e = e;
    }

    @Override
    public String getPropertiesFile() {
        return super.getPropertiesFile();
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
                System.out.println(a);
            }
        }else{
            System.out.println("No Announcements found for " + user + ".");
        }

    }
}
