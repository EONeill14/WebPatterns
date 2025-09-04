package persistence;

import model.Announcement;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementDaoImplTest AnnouncementDao{
    @BeforeEach
    void setUp() {
        // This is where you would connect to your TEST database
        // and potentially clear tables to ensure a clean state for each test.
        this.AnnouncementDao = new AnnouncementDao();
    }
// @Test
//    void findUserByUsernamePassword_WhenUserExists() {
//        try {
//            // ASSUMPTION: A user with username 'testuser' and password 'password123'
//            // exists in your TEST database.
//            User user = userDao.findUserByUsernamePassword("testuser", "password123");
//
//            // Assert that a user was found
//            assertNotNull(user, "User should not be null if credentials are correct.");
//
//            // Assert that the correct user was returned
//            assertEquals("testuser", user.getUsername(), "Username should match the one we searched for.");
//
//        } catch (DaoException e) {
//            // If an exception is thrown, the test fails.
//            fail("DaoException was thrown: " + e.getMessage());
//        }
//    }
    @org.junit.jupiter.api.Test
    void getAnnouncementById() {
Announcement announcement = AnnouncementDao.getAnnouncementByID(1);
    }

    @org.junit.jupiter.api.Test
    void addAnnouncementEntry() {
    }

    @org.junit.jupiter.api.Test
    public void getAllAnnouncements() {
    }
    try {
        Announcement announcement = AnnouncementDao.getAnnouncementById("nonexistentID", "wrongpass");

        // Assert that no user was found
        assertNull(user, "User should be null for incorrect credentials.");

    } catch (DaoException e) {
        fail("DaoException was thrown: " + e.getMessage());
    }
}