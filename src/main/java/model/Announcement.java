package model;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import static model.Message.FORMATTER;

public class Announcement implements Comparable<Announcement>
    //id, subject, author, body and timestamp.
{
    @EqualsAndHashCode.Include
    private int announcementID;
    private final String subject;
    private final String author;
    private final String body;
    private LocalDateTime timestamp;

    public Announcement(String subject, String author, String body){
        this.subject = subject;
        this.author = author;
        this.body = body;
    }
    public Date getTimestampAsDate(){
        return Date.from(timestamp.atZone(ZoneId.systemDefault()).toInstant());
    }

    // Method to access timestamp information for internationalization usage

    @Override
    public String toString(){
        return "Announcement{" + "announcementID=" + announcementID + ", subject=" + subject + ", author=" + author + ", subject=" + subject + ", body=" + body + ", timestamp=" + timestamp.format(FORMATTER) + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Announcement that)) return false;
        return announcementID == that.announcementID && Objects.equals(subject, that.subject) && Objects.equals(author, that.author) && Objects.equals(body, that.body) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(announcementID, subject, author, body, timestamp);
    }

    @Override
    public int compareTo(Announcement o) {
        return 0;
    }


}
