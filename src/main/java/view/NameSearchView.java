package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Member;

public class NameSearchView {
  private Scanner scan;

  public NameSearchView(Scanner s) {
    scan = s;
  }

  /**
   * Prompts for a search string.

   * @return The input string.
   */
  public String promptForSearchParameter() {
    System.out.println("\n***************");
    System.out.println("SEARCH MEMBER");
    System.out.println("***************");
    System.out.print("Search: ");
    String userInput = getString();
    return userInput;
  }

  private String getString() {
    String str = scan.nextLine();
    return str;
  }

  /**
   * Prints name and id of members in the console.

   * @param member The member to view.
   */
  public void printSearchResult(ArrayList<Member> members) {
    System.out.println("\n***************");
    System.out.println("SEARCH RESULT");
    System.out.println("***************");
    if (members.size() == 0) {
      System.out.println("\nNo members found");
    } else {
      for (Member m : members) {
        System.out.println("\nName: " + m.getName());
        System.out.println("Member ID: " + m.getId());
      }
    }
  }

}
