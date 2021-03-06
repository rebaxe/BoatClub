package controller.menus;

import controller.BoatHandler;
import java.util.Scanner;
import model.Member;
import model.MemberRegistry;
import view.BoatView;
import view.actions.Action;
import view.actions.BoatAction;
import view.actions.MemberAction;

/**
 * Responsible for handling user actions for an authenticated user.
 */
public class AuthenticatedMenu extends Menu {
  private BoatView boatUi = new BoatView(scan);
  private BoatHandler boatHandler = new BoatHandler(boatUi);

  public AuthenticatedMenu(MemberRegistry registry, Scanner scan) {
    super(registry, scan);
  }

  public void showMainMenu() {
    Action action = menuUi.promptForMainAction();
    showSubMenu(action);
  }

  private void showSubMenu(Action action) {
    switch (action) {
      case MEMBERS:
        MemberAction memberAction = menuUi.promptForMemberAction();
        handleMemberActions(memberAction);
        break;
      case BOATS:
        BoatAction boatAction = menuUi.promptForBoatAction();
        handleBoatAction(boatAction);
        break;
      case EXIT:
        exit();
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
      case SEARCH:
        handleSearch();
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

  private void handleDeleteMember() {
    memberHandler.deleteMember();
  }
}
