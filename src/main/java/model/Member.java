package model;

import java.util.ArrayList;

/** 
 * A class representing a member.
 */
public class Member {
  private String name;
  private String socialSecurityNumber;
  private Id id;
  private ArrayList<Boat> boats; 

  public Member() {
    super();
  }

  /**
   * A member object.

   * @param name The name of the member.
   * @param socialSecurityNumber The social security number of the member.
   * @param id The ID of the member.
   */
  public Member(String name, String socialSecurityNumber, Id id) {
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
    this.id = id;
    this.boats = new ArrayList<>();
  }

  /**
   * Gets a member's name.

   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Sets a member's name.

   * @param value The member's new name.
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets a member's social security number.

   * @return String
   */
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  /**
   * Sets a member's social security number.

   * @param value The new social security number.
   */
  public void setSocialSecurityNumber(String value) {
    this.socialSecurityNumber = value;
  }

  /**
   * Gets a member's ID.

   * @return String
   */
  public String getId() {
    return id.getId();
  }

  /**
   * Returns an Iterable of all boats registered to a member.

   * @return Iterable of boat objects.
   */
  public Iterable<Boat> getBoats() {
    return this.boats;
  }

  public int getNumberOfBoats() {
    return this.boats.size();
  }

  public void addBoat(Boat boat) {
    this.boats.add(boat);
  }

  public void deleteBoat(Boat boat) {
    this.boats.remove(boat);
  }
}
