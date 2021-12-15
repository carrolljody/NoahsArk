package Model.FAQ;

import java.io.Serializable;
import java.util.ArrayList;

public class FAQTopic implements Serializable
{
   private String title;
   private String description;
   private ArrayList<Question> questions;
   private static final long serialVersionUID = 40L;
   
   /**
    * Zero-argument constructor. 'timeSpent' field is set to zero, 'status' is set to 'Waiting', a new ArrayList of
    * TeamMember objects and a new ArrayList of Requirement subclass objects is created for the project.
    *
    * @param title
    *         Needs to consist of a combination of no more than 24 letters and/or numbers
    * @param projectId
    *         Needs to be unique ID consisting of a combination of no less than 2 letters and/or numbers
    * @param customerId
    *         Needs to consist of a combination of no more than 24 letters and/or numbers
    * @param deadline
    *         The day needs to be greater than zero and does not exceeds the referenced month's number of days, the
    *         month needs to be greater than zero and less than 12 and the year needs to be greater than zero and
    *         lesser than the current year.
    * @param comment
    *         Needs to consist of less than 250 letters
    * @throws IllegalArgumentException
    *         If the given title consists of a combination of more than 24 characters or contains other characters
    *         than letters and/or numbers
    *         If the given project ID consists of a combination of less than 2 or more than 7 characters or contains
    *         other characters than letters and/or numbers
    *         If the given customer ID consists of a combination of more than 7 characters or contains other
    *         characters than letters and/or numbers
    *         If MyDate object's day field isn't greater than zero or exceeds the referenced month's number of days
    *         If MyDate object's month field isn't greater than zero or exceeds 12
    *         If MyDate object's year field isn't greater than zero or is lesser than the current year
    *         If the comment consist of more than 249 characters or contains other than letters and/or numbers
    */
   public FAQTopic(String title,String description)
   {
      this.title=title;
      this.description=description;
      this.questions=new ArrayList<>();
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public int getNumberOfQuestions()
   {
      return questions.size();
   }

   public Question getQuestionByIndex(int index)
   {
      return questions.get(index);
   }

}
