package Mediator;

import Model.FAQ.FAQ;
import Model.Forum.Forum;
import Model.Home.ArticleList;
import Model.Profile;
import Model.SearchItems.Facility;
import Model.SearchItems.Service;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.GeneralListener;
import utility.observer.listener.RemoteListener;
import utility.observer.subject.LocalSubject;
import utility.observer.subject.PropertyChangeHandler;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * A Client class that calls methods on the remote server via stub.
 *
 * @author Group 1
 * @version 1.0 - 18.05.21
 */

public class Client implements RemoteListener<String, String>, LocalSubject<String, String>
{
   private RemoteModel server;
   private PropertyChangeHandler<String, String> property;
   
   /**
    * Zero-argument constructor initializing the RemoteModel instance variable to the remote server stub
    * downloaded from the registry.
    */
   
   public Client()
   {
      try
      {
         server = (RemoteModel) Naming.lookup("rmi://localhost:1099/Ark");
         UnicastRemoteObject.exportObject(this, 0);
         server.addListener(this);
         property = new PropertyChangeHandler<>(this, true);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   /**
    * Passing login credentials to the server for verification.
    * Catches RemoteExceptions and prints the stack trace.
    *
    * @param username String of the username
    * @param password String of the password
    */
   
   public void login(String username, String password)
   {
      try
      {
        server.login(username, password);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
      }
   }
   
   /**
    * Passing credentials to the server for verification to create a new User object.
    * Catches RemoteExceptions and prints the stack trace.
    *
    * @param username String of the username
    * @param password String of the password
    */
   
   public void addUser(String username, String password)
   {
      try
      {
         server.addUser(username, password);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
      }
   }

   public void subscribe(String thread, String username) {
      try {
         server.subscribe(thread, username);
      }
      catch(RemoteException e) {
         e.printStackTrace();
      }
   }
   
   public boolean isSubscribed(String thread, String username) {
      try {
         return server.isSubscribed(thread, username);
      }
      catch(RemoteException e) {
         e.printStackTrace();
         return false;
      }
   }

   public void unsubscribe(String thread, String username) {
      try {
         server.unsubscribe(thread, username);
      }
      catch(RemoteException e) {
         e.printStackTrace();
      }
   }

   public void updateProfile(Profile profile) throws IllegalStateException
   {
      try
      {
         server.updateProfile(profile);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         throw new IllegalStateException(r.getMessage());
      }
   }
   
   public Profile profileInfo(String username)
   {
      try
      {
         return server.profileInfo(username);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         return null;
      }
   }
   
   /**
    * Adding comment to the specified topic on the Server side
    * @param topicTitle String of the topic to which comment should be appended
    * @param message String of the comment
    * @param username String of the username that is adding the comment
    */
   public void addCommentOnTopic(String topicTitle, String message, String username)
   {
      try {
         server.addCommentOnTopic(topicTitle, message, username);
      }
      catch (RemoteException e) {
         e.printStackTrace();
      }
   }

   /**
    * Fetches the Forum object from the Server
    * @return Forum which contains all the topics and comments
    */
   public Forum getForum()
   {
      try {
         return server.getForum();
      }
      catch (RemoteException e) {
         e.printStackTrace();
         return null;
      }
   }

   /**
    * Fetches the FAQ object from the Server
    * @return FAQ which contains all topics, questions and answers
    */
   public FAQ getFaqs()
   {
      try {
         return server.getFaqs();
      }
      catch (RemoteException e) {
         e.printStackTrace();
         return null;
      }
   }

   /**
    * Fetches the ArticleList object from the Server
    * @return ArticleList which contains all the Articles
    */
   public ArticleList getArticles()
   {
      try {
         return server.getArticles();
      }
      catch (RemoteException e) {
         e.printStackTrace();
         return null;
      }
   }

   /**
    * Fetches all the Services from the Server
    * @return ArrayList of Services that contains all the Services within the system
    */
   public ArrayList<Service> services() {
      try {
         return server.getServices();
      }
      catch (RemoteException e)
      {
         e.printStackTrace();
         return null;
      }
   }
   
   public ArrayList<Facility> facilities()
   {
      try
      {
         return server.getFacilities();
      }
      catch (RemoteException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   /**
    * Loads all the comments from the Server for the specified topic
    * @param forumTopic String of the topic title
    * @return ArrayList of Strings that contains all the comments for the specified topic
    */
   public ArrayList<String> getComments(String forumTopic)
   {
      try {
         return server.getComments(forumTopic);
      }
      catch (RemoteException e) {
         e.printStackTrace();
         return null;
      }
   }

   /**
    * Loads all the Services that match the search criteria
    * @param searchInfo String of criteria by which the ArrayList of Services will be populated
    * @return ArrayList of Services that match the criteria
    */
   public ArrayList<Service> getServices(String searchInfo) {
      try {
         return server.getServicesByInfo(searchInfo);
      }
      catch (RemoteException e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public ArrayList<Facility> getFacilities(String info)
   {
      try
      {
         return server.getFacilitiesByInfo(info);
      }
      catch (RemoteException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   public ArrayList<String> userSearch(String search)
   {
      try
      {
         return server.userSearch(search);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         return null;
      }
   }
   
   public void addFriend(String username, String friend)
   {
      try
      {
         server.addFriend(username, friend);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
      }
   }
   
   public void unfriend(String username, String friend)
   {
      try
      {
         server.unfriend(username, friend);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
      }
   }
   
   public ArrayList<String> getFriendsList(String username)
   {
      try
      {
         return server.getFriendsList(username);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         return null;
      }
   }
   
   public boolean isFriend(String username, String friend)
   {
      try
      {
         return server.isFriend(username, friend);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         throw new IllegalStateException("Could not retrieve data from the database");
      }
   }
   
   public boolean isProfessional(String username)
   {
      try
      {
         return server.isProfessional(username);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         throw new IllegalStateException("Could not retrieve data from the database");
      }
   }
   
   public void professionalApplication(String username)
   {
      try
      {
         server.professionalApplication(username);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
      }
   }

   public void addReport(String username, String report)
   {
      try
      {
         server.addReport(username, report);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
      }
   }

   public ArrayList<String> getReportList(String username)
   {
      try
      {
         return server.getReportList(username);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         return null;
      }
   }

   public boolean againReported(String username, String report)
   {
      try
      {
         return server.againReported(username, report);
      }
      catch (RemoteException r)
      {
         r.printStackTrace();
         throw new IllegalStateException("Could not retrieve data from the database");
      }
   }

   @Override public boolean addListener(GeneralListener<String, String> listener, String... propertyNames)
   {
      return property.addListener(listener, propertyNames);
   }

   @Override public boolean removeListener(GeneralListener<String, String> listener, String... propertyNames)
   {
      return property.removeListener(listener, propertyNames);
   }

   @Override public void propertyChange(ObserverEvent<String, String> event)
   {
      if(event.getPropertyName().equals("NewComment")) {
         property.firePropertyChange(event.getPropertyName(), event.getValue1(), event.getValue2());
      }
      else
         property.firePropertyChange(event.getPropertyName(), event.getValue1(), event.getValue2());
   }

}
