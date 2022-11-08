package com.bloomtechlabs.coderheroesbea.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Messages {
    private int messages_id;
    private Date sent_at;
    private String title;
    private boolean read;
    private String message;
    private Profiles profile;
    private Conversations conversation;

    /**
     * Constructor.
     * Default constructor is required to have Hibernate initialize the entity.
     */
    public Messages() {

    }

    /**
     * Constructor with messages_id
     * @param messages_id - primary key, auto-increments, generated by database
     */
    public Messages(int messages_id) {
        this.messages_id = messages_id;
    }

    /**
     * Constructor with all fields.
     * @param messages_id - primary key (auto-increments, generated by database)
     * @param sent_at - timestamp (auto-generated)
     * @param title - string (not nullable)
     * @param read - boolean (default - false)
     * @param message - string (not nullable)
     * @param profile - foreign key (table 'profiles')
     * @param conversation - foreign key (table 'conversations')
     */
    public Messages(int messages_id, Date sent_at, String title, boolean read, String message, Profiles profile,
                    Conversations conversation) {
        this.messages_id = messages_id;
        this.sent_at = sent_at;
        this.title = title;
        this.read = read;
        this.message = message;
        this.profile = profile;
        this.conversation = conversation;
    }
    @Id
    @Column(name = "messages_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMessages_id() {
        return messages_id;
    }

    public void setMessages_id(int messages_id) {
        this.messages_id = messages_id;
    }

    @Column(name = "sent_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    public Date getSent_at() {
        return sent_at;
    }

    public void setSent_at(Date sent_at) {
        this.sent_at = sent_at;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "read", columnDefinition = "boolean default false")
    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Column(name = "message", columnDefinition = "text", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name ="sent_by_profile_id", referencedColumnName = "profile_id", nullable = false)
    public Profiles getProfile() {
        return profile;
    }

    public void setProfile(Profiles profile) {
        this.profile = profile;
    }
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name ="conversation_id", referencedColumnName = "conversation_id", nullable = false)
    public Conversations getConversation() {
        return conversation;
    }

    public void setConversation(Conversations conversation) {
        this.conversation = conversation;
    }
}
