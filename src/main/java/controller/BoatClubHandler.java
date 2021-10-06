package controller;

import java.util.Scanner;
import model.Action;
import model.BoatAction;
import model.Member;
import model.MemberAction;
import model.MemberRegistry;
import model.PersistentData;
import view.BoatView;
import view.MemberView;

/**
 * Responsible for main operations in the boat club application.
 */
public class BoatClubHandler {
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private MemberView memberUi = new MemberView(scan);
  private MemberRegistry registry = new MemberRegistry();
  private MemberHandler memberHandler = new MemberHandler(memberUi, registry);
  private BoatView boatUi = new BoatView(scan);
  private BoatHandler boatHandler = new BoatHandler(boatUi);
  private PersistentData persistentData = new PersistentData(registry);

  public BoatClubHandler() {
  }

  public void start() {
    persistentData.load();
    showMainMenu();
  }

  private void showMainMenu() {
    Action action = boatUi.promptForMainAction();
    showSubMenu(action);
  }

  private void showSubMenu(Action action) {
    switch (action) {
      case MEMBERS:
        MemberAction memberAction = boatUi.promptForMemberAction();
        handleMemberActions(memberAction);
        break;
      case BOATS:
        BoatAction boatAction = boatUi.promptForBoatAction();
        handleBoatAction(boatAction);
        break;
      case EXIT:
        scan.close();
        System.out.println("Goodbye!");
        break;
      default:
        break;
    }
  }

  private void handleBoatAction(BoatAction action) {
    switch (action) {
      case ADD:
        handleAddBoat();
        showSubMenu(Action.BOATS);
        break;
      case EDIT:
        handleEditBoat();
        showSubMenu(Action.BOATS);
        break;
      case DELETE:
        handleDeleteBoat();
        showSubMenu(Action.BOATS);
        break;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }

  private void handleAddBoat() {
    boatUi.printRegisterBoatHeader();
    Member member = memberHandler.askForValidMember();
    boatHandler.addNewBoat(member);
  }

  private void handleEditBoat() {
    boatUi.printEditBoatHeader();
    Member member = memberHandler.askForValidMember();
    boatHandler.editBoat(member);
  }

  private void handleDeleteBoat() {
    boatUi.printDeleteBoatHeader();
    Member member = memberHandler.askForValidMember();
    boatHandler.deleteBoat(member);
  }

  private void handleMemberActions(MemberAction action) {
    switch (action) {
      case ADD:
        handleAddMember();
        showSubMenu(Action.MEMBERS);
        break;
      case EDIT:
        handleEditMember();
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWALL:
        handleViewAllMembers();
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWONE:
        handleViewMember();
        showSubMenu(Action.MEMBERS);
        break;
      case DELETE:
        handleDeleteMember();
        showSubMenu(Action.MEMBERS);
        break;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }

  private void handleAddMember() {
    memberHandler.registerMember();
  }
  
  private void handleEditMember() {
    memberHandler.editMember();
  }

  private void handleViewMember() {
    memberHandler.viewMember();
  }
  
  private void handleViewAllMembers() {
    memberHandler.viewAllMembers();
  }

  private void handleDeleteMember() {
    memberHandler.deleteMember();
  }
}
