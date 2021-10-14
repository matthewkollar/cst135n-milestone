package milestone.cst135n;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	private String name;

	private Scanner sc = new Scanner(System.in);
	private List<BaseContact> contacts = new ArrayList<>();

	// Constructor
	AddressBook(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// Overload Constructor
	AddressBook() {

	}

	public void open() {
		System.out.println("SYSTEM MESSAGE: The address book is now open!");

		PersonContact p1 = new PersonContact(null, "p1", "Jimmy Dean", "623-756-2323", "Phoenix, AZ", "12/23/1990",
				"Loves sandwiches");
		contacts.add(p1);
		PersonContact p2 = new PersonContact(null, "p2", "Matt Damon", "949-686-2323", "Beverly Hills, CA",
				"10/08/1970", "Hollywood Actor");
		contacts.add(p2);
		PersonContact p3 = new PersonContact(null, "p3", "Abbie Stentson", "787-124-7896", "Rolling Hills, MI",
				"04/01/1988", "Great artist");
		contacts.add(p3);
		BusinessContact b1 = new BusinessContact(null, "b1", "BestBuy", "480-878-1800", "Mesa, AZ", "0900 - 2100",
				"https://www.bestbuy.com");
		contacts.add(b1);
		BusinessContact b2 = new BusinessContact(null, "b2", "Target", "602-784-2454", "Gilbert, AZ", "1000 - 2200",
				"https://www.target.com");
		contacts.add(b2);
		BusinessContact b3 = new BusinessContact(null, "b3", "Living Spaces", "623-989-7841", "Anthem, AZ",
				"0800 - 2130", "https://www.livingspaces.com");
		contacts.add(b3);

		mainMenu();
	}

	private void mainMenu() {

		int option = 0;
		do {
			System.out.println("====================");
			System.out.println("+++ Address Book +++");
			System.out.println("====================");
			System.out.println("1. Create Person Contact");
			System.out.println("2. Create Business Contact");
			System.out.println("3. Show All Contacts");
			System.out.println("4. Show Details of One Contact");
			System.out.println("5. Update A Contact");
			System.out.println("6. Delete A Contact");
			System.out.println("7. Search for a Contact by Name");
			System.out.println("8. Sort All Contacts by Name");
			System.out.println("9. Exit");
			System.out.println("====================");
			System.out.print("Please select an option: ");

			option = sc.nextInt(); // Return
			sc.nextLine(); // Consume the return
			switch (option) {

			case 1:
				addPersonContact();
				break;
			case 2:
				addBusinessContact();
				break;
			case 3:
				viewAll();
				break;
			case 4:
				showDetails();
				break;
			case 5:
				updateContact();
				break;
			case 6:
				deleteContact();
				break;
			case 7:
				searchContact();
				break;
			case 8:
				sortContactName();
				break;
			case 9:
				System.out.println("*** This selection exits the address book! ***");
				break;
			default:

			}
		} while (option != 9);
	}

	private void addPersonContact() {
		System.out.println("*** This selection adds a person contact! ***");
		System.out.println("Person contact added!");
		System.out.println("=================");
		System.out.println("What's the contact's ID?");
		String id = sc.nextLine();
		System.out.println("What do you want to name this contact?");
		String name = sc.nextLine();
		System.out.println("What's the contact's phone number?");
		String number = sc.nextLine();
		System.out.println("What's the contact's location?");
		String location = sc.nextLine();
		System.out.println("What's the contact's DOB?");
		String birthDay = sc.nextLine();
		System.out.println("Description of contact: ");
		String description = sc.nextLine();

		contacts.add(new PersonContact(null, id, name, number, location, birthDay, description));

	}

	private void addBusinessContact() {
		System.out.println("*** This selection adds a business contact! ***");
		System.out.println("Business contact added!");
		System.out.println("=================");
		System.out.println("What's the contact's ID?");
		String id = sc.nextLine();
		System.out.println("What do you want to name this contact?");
		String name = sc.nextLine();
		System.out.println("What's the contact's phone number?");
		String number = sc.nextLine();
		System.out.println("What's the contact's location?");
		String location = sc.nextLine();
		System.out.println("What's the contact's business hours?");
		String businessHours = sc.nextLine();
		System.out.println("What's the contact's URL? ");
		String webURL = sc.nextLine();

		contacts.add(new BusinessContact(null, id, name, number, location, businessHours, webURL));
	}

	private void viewAll() {
		System.out.println("*** This selection views all options! ***");
		System.out.println("Viewing all options!");
		System.out.println("=================");
		int counter = 0;
		for (BaseContact contactItem : contacts) {
			System.out.print(counter++ + ". ");
			System.out.println(contactItem);
		}

	}

	private void deleteContact() {
		System.out.println("Deleting item!");
		System.out.println("=================");
		viewAll();
		System.out.println("=================");
		System.out.println("Which item do you want to delete?");
		int item = sc.nextInt();
		sc.nextLine();
		contacts.remove(item);
	}

	private void showDetails() {
		System.out.println("Which contact do you want to see by itself?");
		sc.nextLine();
		int counter = 0; // FIX THIS
		
		
	}

	private void updateContact() {
		System.out.println("*** This selection updates the contact! ***");
		System.out.println("============================");
		viewAll();
		System.out.println("============================");
		System.out.println("Which item do you want to update?");
		int item = sc.nextInt();
		sc.nextLine();
		if (contacts.get(item) instanceof PersonContact) {
			System.out.println("Editing Person Contact");
			editPersonContact(item);
		} else if (contacts.get(item) instanceof BusinessContact) {
			System.out.println("Editing Business Contact");
			editBusinessContact(item);
		} else {
			System.out.println("Don't know what you mean");
		}
	}

	private void editPersonContact(int item) {
		System.out.println("What do you want to change the ID to? ");
		String id = sc.nextLine();
		contacts.get(item).setContactID(id);
		System.out.println("What do you want to change the name to? ");
		String name = sc.nextLine();
		contacts.get(item).setName(name);
		System.out.println("What do you want to change the phone to? ");
		String phone = sc.nextLine();
		contacts.get(item).setPhone(phone);
		System.out.println("What do you want to change the location to? ");
		String location = sc.nextLine();
		contacts.get(item).setLocation(location);
		System.out.println("What do you want to change the D.O.B to? ");
		String dob = sc.nextLine();
		((PersonContact) contacts.get(item)).setBirthDate(dob);
		System.out.println("What do you want to change the Description to? ");
		String description = sc.nextLine();
		((PersonContact) contacts.get(item)).setDescription(description);

	}

	private void editBusinessContact(int item) {
		System.out.println(" What do you want to change the ID to? ");
		String id = sc.nextLine();
		contacts.get(item).setContactID(id);
		System.out.println(" What do you want to change the name to? ");
		String name = sc.nextLine();
		contacts.get(item).setName(name);
		System.out.println(" What do you want to change the phone to? ");
		String phone = sc.nextLine();
		contacts.get(item).setPhone(phone);
		System.out.println(" What do you want to change the location to? ");
		String location = sc.nextLine();
		contacts.get(item).setLocation(location);
		System.out.println(" What do you want to change the Hours to? ");
		String hours = sc.nextLine();
		((BusinessContact) contacts.get(item)).setBusinessHours(hours);
		System.out.println(" What do you want to change the URL to? ");
		String url = sc.nextLine();
		((BusinessContact) contacts.get(item)).setWebsiteURL(url);

	}

	private void searchContact() {
		System.out.println("Searching for a contact...");
		System.out.println("============================");
		System.out.println("What do you want to search for?");
		String name = sc.nextLine();

		for (int x = 0; x < contacts.size(); x++) {
			if (contacts.get(x).getName().toLowerCase().contains(name.toLowerCase())) {
				System.out.println(x + ". " + contacts.get(x));
			}
		}
	}

	private void sortContactName() {
		System.out.println("Sort by name...");
		System.out.println("============================");
		contacts.sort(new ComparatorName());
	}

}
