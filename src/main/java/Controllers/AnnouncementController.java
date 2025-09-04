package Controllers;

import model.User;
import persistence.AnnouncementDaoImpl;

import java.util.List;

public class AnnouncementController {
}


package wanna_shop.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class OrderController {
    @GetMapping("/userAnnouncements")
    public String getUserOrders(Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            String message = "Please log in and try again.";
            model.addAttribute("message", message);
            return "index";
        }

        AnnouncementDao AnnouncementDao = new AnnouncementDaoImpl("database.properties");
        List<Announcement> Announcements = AnnouncementDao.getAllAnnouncementsForUser(currentUser.getUsername());

        model.addAttribute("announcements", announcements);
        return "announcements";
    }

    @GetMapping("/getAllAnnouncements")
    public String getAnnouncementSubject(int announcementID, Title title, HttpSession session){
        if(AnnouncementID <= 0){
            String error = "Illegal announcement id supplied.";
            model.addAttribute("errMsg", error);
            return "error";
        }

        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            String message = "Please log in and try again.";
            model.addAttribute("message", message);
            return "index";
        }

        AnnouncementDao AnnouncementDao = new AnnouncementDaoImpl("database.properties");
        List<Announcement> announcements = AnnouncementDaoDao.getAnnouncement(announcementID);

        if(!currentUser.isAdmin()){
            AnnouncementDao announcementDao = new AnnouncementDaoImpl("database.properties");
            Announcement announcement = AnnouncementDao.AddAnnouncementById(announcementID);
            if(!order.getUsername().equalsIgnoreCase(currentUser.getUsername())){
                String message = "Must be an admin to add announcement.";
                model.addAttribute("message", message);
                return "error";
            }
        }

        model.addAttribute("Announcements", announcements);
        return "viewAnnouncement";
    }
}
